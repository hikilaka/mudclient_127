package jagex;

import java.io.IOException;
import java.math.BigInteger;

public abstract class Buffer {
	public static int[] frames_created = new int[256];
	public static int[] frames_cum_size = new int[256];
	private static char[] char_set = new char[256];
	
	private static final int char_equals = 61;
	private static final int char_semicolon = 59;
	private static final int char_asterisk = 42;
	private static final int char_plus = 43;
	private static final int char_comma = 44;
	private static final int char_minus = 45;
	private static final int char_period = 46;
	private static final int char_fslash = 47;
	private static final int char_bslash = 92;
	private static final int char_exclaimation = 33;
	private static final int char_pipe = 124;
	private static final int char_quote = 34;

	protected final int max_frame_size = 5000;
	protected boolean error = false;
	protected String error_str = "";
	protected int flush_tick;
	private int len;
	public int idle_tick;
	public int time_out;
	private int frame_base;
	private int ptr = 3;
	private int op_size = 8;
	private byte[] buf;

	public abstract void close();

	public abstract int read() throws IOException;

	public abstract int available() throws IOException;

	public abstract void read(int var1, int var2, byte[] var3) throws IOException;

	public abstract void write(byte[] var1, int var2, int var3) throws IOException;

	public int read_byte() throws IOException {
		return read();
	}

	public int read_short() throws IOException {
		int i = read_byte();
		int j = read_byte();
		return i * 256 + j;
	}

	public int read_int() throws IOException {
		int i = read_short();
		int j = read_short();
		return i * 65536 + j;
	}

	public void read(int out, byte[] len) throws IOException {
		read(out, 0, len);
	}

	public int frame_read(byte[] out) {
		try {
			++idle_tick;
			
			if (time_out > 0 && idle_tick > time_out) {
				error = true;
				error_str = "time-out";
				time_out += time_out;
				return 0;
			}

			if (len == 0 && available() >= 2) {
				len = read();
				
				if (len >= 160) {
					len = (len - 160) * 256 + read();
				}
			}

			if (len > 0 && available() >= len) {
				if (len >= 160) {
					read(len, out);
				} else {
					out[len - 1] = (byte) read();
					if (len > 1) {
						read(len - 1, out);
					}
				}

				int len_prev = len;
				len = 0;
				idle_tick = 0;
				return len_prev;
			}
		} catch (IOException ex) {
			error = true;
			error_str = ex.getMessage();
		}
		return 0;
	}

	public void byte_put(int i) {
		buf[ptr++] = (byte) i;
	}

	public void short_put(int i) {
		buf[ptr++] = (byte) (i >> 8);
		buf[ptr++] = (byte) i;
	}

	public void size_put(int i, int off) {
		buf[frame_base + off] = (byte) (i >> 8);
		buf[frame_base + off + 1] = (byte) i;
	}

	public void int_put(int i) {
		buf[ptr++] = (byte) (i >> 24);
		buf[ptr++] = (byte) (i >> 16);
		buf[ptr++] = (byte) (i >> 8);
		buf[ptr++] = (byte) i;
	}

	public void long_put(long i) {
		int_put((int) (i >> 32));
		int_put((int) (i & -1L));
	}

	@SuppressWarnings("deprecation")
	public void str_put(String str) {
		str.getBytes(0, str.length(), this.buf, this.ptr);
		ptr += str.length();
	}

	public void bytes_put(byte[] in, int off, int len) {
		for (int i = 0; i < len; ++i) {
			buf[ptr++] = in[off + i];
		}
	}

	public void enc_cred_put(long l, int j, BigInteger exp, BigInteger mod) {
		byte[] block = new byte[15];
		block[0] = (byte) ((int) (1.0D + Math.random() * 127.0D));
		block[1] = (byte) ((int) (Math.random() * 256.0D));
		block[2] = (byte) ((int) (Math.random() * 256.0D));
		
		DataUtil.int_put(block, 3, j);
		DataUtil.long_put(block, 7, l);
		
		BigInteger _block = new BigInteger(1, block);
		BigInteger _enc = _block.modPow(exp, mod);
		byte[] enc = _enc.toByteArray();
		
		buf[ptr++] = (byte) enc.length;

		for (int i = 0; i < enc.length; ++i) {
			buf[ptr++] = enc[i];
		}
	}

	public void enc_cred_put(String str, int k, BigInteger exp, BigInteger mod) {
		byte[] data = str.getBytes();
		int len = data.length;
		byte[] block = new byte[15];

		for (int i = 0; i < len; i += 7) {
			block[0] = (byte) ((int) (1.0D + Math.random() * 127.0D));
			block[1] = (byte) ((int) (Math.random() * 256.0D));
			block[2] = (byte) ((int) (Math.random() * 256.0D));
			block[3] = (byte) ((int) (Math.random() * 256.0D));
			
			DataUtil.int_put(block, 4, k);

			for (int var9 = 0; var9 < 7; ++var9) {
				if (i + var9 < len) {
					block[8 + var9] = data[i + var9];
				} else {
					block[8 + var9] = 32;
				}
			}

			BigInteger _block = new BigInteger(1, block);
			BigInteger _enc = _block.modPow(exp, mod);
			byte[] enc = _enc.toByteArray();
			
			buf[ptr++] = (byte) enc.length;

			for (int j = 0; j < enc.length; ++j) {
				buf[ptr++] = enc[j];
			}
		}
	}

	public void enter(int op) {
		if (frame_base > max_frame_size * 4 / 5) {
			try {
				flush(0);
			} catch (IOException e) {
				error = true;
				error_str = e.getMessage();
			}
		}

		if (buf == null) {
			buf = new byte[max_frame_size];
		}

		buf[frame_base + 2] = (byte) op;
		buf[frame_base + 3] = 0;
		ptr = frame_base + 3;
		op_size = 8;
	}

	public void exit() {
		if (op_size != 8) {
			++ptr;
		}

		int i = ptr - frame_base - 2;
		
		if (i >= 160) {
			buf[frame_base] = (byte) (160 + i / 256);
			buf[frame_base + 1] = (byte) (i & 255);
		} else {
			buf[frame_base] = (byte) i;
			ptr -= 1;
			buf[frame_base + 1] = buf[ptr];
		}

		if (max_frame_size <= 10000) {
			int op = buf[frame_base + 2] & 255;
			
			frames_created[op] += 1;
			frames_cum_size[op] += ptr - frame_base;
		}

		frame_base = ptr;
	}

	public void send() throws IOException {
		exit();
		flush(0);
	}

	public void flush(int thresh) throws IOException {
		if (error) {
			frame_base = 0;
			ptr = 3;
			error = false;
			throw new IOException(error_str);
		} else {
			flush_tick += 1;
			
			if (flush_tick >= thresh) {
				if (frame_base > 0) {
					flush_tick = 0;
					write(buf, 0, frame_base);
				}

				frame_base = 0;
				ptr = 3;
			}
		}
	}

	public boolean in_frame() {
		return frame_base > 0;
	}

	static {
		for (int i = 0; i < 256; ++i) {
			char_set[i] = (char) i;
		}
		
		char_set[char_equals] = '=';
		char_set[char_semicolon] = ';';
		char_set[char_asterisk] = '*';
		char_set[char_plus] = '+';
		char_set[char_comma] = ',';
		char_set[char_minus] = '-';
		char_set[char_period] = '.';
		char_set[char_fslash] = '/';
		char_set[char_bslash] = '\\';
		char_set[char_pipe] = '|';
		char_set[char_exclaimation] = '!';
		char_set[char_quote] = '"';
	}
}
