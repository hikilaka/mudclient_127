package jagex.client;

import java.applet.Applet;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;

import jagex.Buffer;

public final class Connection extends Buffer implements Runnable {
	private InputStream input;
	private OutputStream output;
	private Socket socket;
	private boolean closed = false;
	private byte[] write_buf;
	private int last_write_ptr;
	private int write_ptr;
	private Thread writer;
	private boolean writer_stop = true;

	public Connection(String host, Applet app, int port) throws IOException {
		if (app != null) {
			socket = new Socket(InetAddress.getByName(app.getCodeBase().getHost()), port);
		} else {
			socket = new Socket(InetAddress.getByName(host), port);
		}

		socket.setSoTimeout(30000);
		socket.setTcpNoDelay(true);
		input = socket.getInputStream();
		output = socket.getOutputStream();
	}

	@Override
	public void close() {
		closed = true;

		try {
			if (input != null) {
				input.close();
			}

			if (output != null) {
				output.close();
			}

			if (socket != null) {
				socket.close();
			}
		} catch (IOException error) {
			System.out.println("Error closing stream");
		}

		if (writer != null) {
			writer_stop = true;

			try {
				synchronized (this) {
					notify();
				}
			} catch (Throwable error) {
				throw error;
			}

			writer = null;
		}

		write_buf = null;
	}

	@Override
	public int read() throws IOException {
		return closed ? 0 : input.read();
	}

	@Override
	public int available() throws IOException {
		return closed ? 0 : input.available();
	}

	@Override
	public void read(int out, int off, byte[] len) throws IOException {
		if (closed) {
			return;
		}

		int read;
		for (int i = 0; i < out; i += read) {
			if ((read = input.read(len, i + off, out - i)) <= 0) {
				throw new IOException("EOF");
			}
		}
	}

	@Override
	public void write(byte[] data, int len, int off) throws IOException {
		if (!closed) {
			if (write_buf == null) {
				write_buf = new byte[5000];
			}

			synchronized (this) {
				try {
					for (int i = 0; i < off; ++i) {
						write_buf[write_ptr] = data[i + len];
						write_ptr = (write_ptr + 1) % 5000;
						
						if (write_ptr == (last_write_ptr + 4900) % 5000) {
							throw new IOException("buffer overflow");
						}
					}
	
					if (writer == null) {
						writer_stop = false;
						writer = new Thread(this);
						writer.setDaemon(true);
						writer.setPriority(Thread.NORM_PRIORITY - 1);
						writer.start();
					}
	
					notify();
				} catch (Throwable error) {
					throw error;
				}
			}
		}
	}

	@Override
	public void run() {
		while (writer != null && !writer_stop) {
			int written;
			int off;
			synchronized (this) {
				try {
					if (write_ptr == last_write_ptr) {
						try {
							wait();
						} catch (InterruptedException error) { }
					}
	
					if (writer == null || writer_stop) {
						return;
					}
	
					off = last_write_ptr;
					
					if (write_ptr >= last_write_ptr) {
						written = write_ptr - last_write_ptr;
					} else {
						written = 5000 - last_write_ptr;
					}
				} catch (Throwable error) {
					throw error;
				}
			}

			if (written > 0) {
				try {
					output.write(write_buf, off, written);
				} catch (IOException ex) {
					error = true;
					error_str = "Twriter:" + ex;
				}

				last_write_ptr = (last_write_ptr + written) % 5000;

				try {
					if (write_ptr == last_write_ptr) {
						output.flush();
					}
				} catch (IOException ex) {
					error = true;
					error_str = "Twriter:" + ex;
				}
			}
		}
	}
}
