package jagex.client;

import java.io.InputStream;
//import sun.audio.AudioPlayer;

public final class AudioStream extends InputStream {
	byte[] data;
	int off;
	int len;

	public AudioStream() {
		//AudioPlayer.player.start(this);
	}

	public void stop() {
		//AudioPlayer.player.stop(this);
	}

	public void set(byte[] data, int off, int len) {
		this.data = data;
		this.off = off;
		this.len = off + len;
	}

	public int read(byte[] out, int off, int len) {
		for (int i = 0; i < len; ++i) {
			if (this.off < this.len) {
				out[off + i] = this.data[this.off++];
			} else {
				out[off + i] = -1;
			}
		}

		return len;
	}

	public int read() {
		byte[] buf = new byte[1];
		this.read(buf, 0, 1);
		return buf[0];
	}
}
