package jagex.client;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Component;
import java.awt.Event;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.IndexColorModel;
import java.awt.image.MemoryImageSource;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;

import jagex.BZ2;
import jagex.DataUtil;

@SuppressWarnings("serial")
public abstract class Game extends Applet implements Runnable {
	private int width = 512;
	private int height = 384;
	private Thread tick_thread;
	private int period = 20;
	private int max_updates = 1000;
	private long[] ticks = new long[10];
	static Window window = null;
	private boolean is_applet;
	private int kill_state;
	private int lag_accum;
	protected int fps = 0;
	public int mouse_y_offset;
	public int idle_counter;
	public int loading_stage = 1;
	public String additional_text;
	private boolean on_jagex = false;
	private int bar_perc;
	private String bar_text = "Loading";
	private Font times_roman = new Font("TimesRoman", Font.PLAIN, 15);
	private Font helvetica_bold = new Font("Helvetica", Font.BOLD, 13);
	private Font helvetica = new Font("Helvetica", Font.PLAIN, 12);
	private Image jag_logo;
	private Graphics graphics;
	public boolean field_130 = false;
	public boolean field_131 = false;
	public boolean field_132 = false;
	public boolean field_133 = false;
	public boolean field_134 = false;
	public boolean field_135 = false;
	public boolean field_136 = false;
	public boolean field_137 = false;
	public int min_delta = 1;
	public int mouse_x;
	public int mouse_y;
	public int mouse_state;
	public int click_state;
	public int pressed_key;
	public int typed_key;
	public boolean reduce_lag = false;
	public String line_a_buf = "";
	public String line_a = "";
	public String line_b_buf = "";
	public String line_b = "";

	public abstract void load_game();

	public abstract void cleanup();

	public abstract void update();

	public abstract void render();

	public abstract void preload_render();

	public abstract void on_key(int code);

	public abstract void on_click(int state, int x, int y);

	public final void start(int width, int height, String title, boolean resizable) {
		System.out.println("Started application");

		this.width = width;
		this.height = height;

		window = new Window(this, width, height, title, resizable, false);
		is_applet = false;
		loading_stage = 1;
		tick_thread = new Thread(this);
		tick_thread.start();
		tick_thread.setPriority(1);
	}

	public final boolean is_applet() {
		return is_applet;
	}

	@Override
	public final Graphics getGraphics() {
		return window == null ? super.getGraphics() : window.getGraphics();
	}

	public final int width() {
		return width;
	}

	public final int height() {
		return height;
	}

	@Override
	public final Image createImage(int width, int height) {
		if (window == null) {
			return super.createImage(width, height);
		}

		return window.createImage(width, height);
	}

	public Frame window() {
		return window;
	}

	public final void set_rate(int rate) {
		period = (1000 / rate);
	}

	public final void set_max_updates(int updates) {
		max_updates = updates;
	}

	public final void reset_ticks() {
		for (int i = 0; i < 10; ++i) {
			ticks[i] = 0L;
		}
	}

	@Override
	public synchronized boolean keyDown(Event event, int code) {
		on_key(code);
		pressed_key = code;
		typed_key = code;
		idle_counter = 0;

		if (code == 1006) {
			System.out.println("1006");
			this.field_132 = true;
		}

		if (code == 1007) {
			System.out.println("1007");
			this.field_133 = true;
		}

		if (code == 1004) {
			System.out.println("1004");
			this.field_134 = true;
		}

		if (code == 1005) {
			System.out.println("1005");
			this.field_135 = true;
		}

		if ((char) code == ' ') {
			this.field_136 = true;
		}

		if ((char) code == 'n' || (char) code == 'm') {
			this.field_137 = true;
		}

		if ((char) code == 'N' || (char) code == 'M') {
			this.field_137 = true;
		}

		if ((char) code == '{') {
			this.field_130 = true;
		}

		if ((char) code == '}') {
			this.field_131 = true;
		}

		// F1
		if ((char) code == 1008) {
			reduce_lag = !reduce_lag;
		}

		if ((code >= 97 && code <= 122 || code >= 65 && code <= 90 || code >= 48 && code <= 57 || code == 32)
				&& line_a_buf.length() < 20) {
			line_a_buf = line_a_buf + (char) code;
		}

		if (code >= 32 && code <= 122 && this.line_b_buf.length() < 80) {
			line_b_buf = line_b_buf + (char) code;
		}

		if (code == 8 && line_a_buf.length() > 0) {
			line_a_buf = line_a_buf.substring(0, line_a_buf.length() - 1);
		}

		if (code == 8 && line_b_buf.length() > 0) {
			line_b_buf = line_b_buf.substring(0, line_b_buf.length() - 1);
		}

		if (code == 10 || code == 13) {
			line_a = line_a_buf;
			line_b = line_b_buf;
		}

		return true;
	}

	public synchronized boolean keyUp(Event event, int code) {
		pressed_key = 0;

		if (code == 1006) {
			this.field_132 = false;
		}

		if (code == 1007) {
			this.field_133 = false;
		}

		if (code == 1004) {
			this.field_134 = false;
		}

		if (code == 1005) {
			this.field_135 = false;
		}

		if ((char) code == ' ') {
			this.field_136 = false;
		}

		if ((char) code == 'n' || (char) code == 'm') {
			this.field_137 = false;
		}

		if ((char) code == 'N' || (char) code == 'M') {
			this.field_137 = false;
		}

		if ((char) code == '{') {
			this.field_130 = false;
		}

		if ((char) code == '}') {
			this.field_131 = false;
		}

		return true;
	}

	@Override
	public synchronized boolean mouseMove(Event event, int x, int y) {
		mouse_x = x;
		mouse_y = y + mouse_y_offset;
		mouse_state = 0;
		idle_counter = 0;
		return true;
	}

	@Override
	public synchronized boolean mouseUp(Event event, int x, int y) {
		mouse_x = x;
		mouse_y = y + mouse_y_offset;
		mouse_state = 0;
		return true;
	}

	@Override
	public synchronized boolean mouseDown(Event event, int x, int y) {
		mouse_x = x;
		mouse_y = y + mouse_y_offset;

		if (event.metaDown()) {
			mouse_state = 2;
		} else {
			mouse_state = 1;
		}

		click_state = mouse_state;
		idle_counter = 0;

		on_click(mouse_state, x, y);
		return true;
	}

	@Override
	public synchronized boolean mouseDrag(Event event, int x, int y) {
		mouse_x = x;
		mouse_y = y + mouse_y_offset;

		if (event.metaDown()) {
			mouse_state = 2;
		} else {
			mouse_state = 1;
		}

		return true;
	}

	@Override
	public final void init() {
		System.out.println("Started applet");
		is_applet = true;
		width = getSize().width;
		height = getSize().height;

		loading_stage = 1;
		DataUtil.codebase = this.getCodeBase();

		tick_thread = new Thread(this);
		tick_thread.start();
	}

	@Override
	public final void start() {
		if (kill_state >= 0) {
			kill_state = 0;
		}
	}

	@Override
	public final void stop() {
		if (kill_state >= 0) {
			kill_state = 4000 / period;
		}
	}

	@SuppressWarnings("deprecation")
	@Override
	public final void destroy() {
		kill_state = -1;

		try {
			Thread.sleep(5000L);
		} catch (Exception error) {
		}

		if (this.kill_state == -1) {
			System.out.println("5 seconds expired, forcing kill");
			close();

			if (tick_thread != null) {
				tick_thread.stop();
				tick_thread = null;
			}
		}

	}

	public final void close() {
		this.kill_state = -2;
		System.out.println("Closing program");
		cleanup();

		try {
			Thread.sleep(1000L);
		} catch (Exception error) {
		}

		if (window != null) {
			window.dispose();
		}

		if (!is_applet) {
			System.exit(0);
		}
	}

	@Override
	public final void run() {
		if (loading_stage == 1) {
			loading_stage = 2;
			graphics = getGraphics();
			load_resources();
			set_game_loading_bar(0, "Loading...");
			load_game();
			loading_stage = 0;
		}

		int ptr = 0;
		int step = 256;
		int delta = 1;
		int elapsed = 0;

		for (int i = 0; i < 10; ++i) {
			this.ticks[i] = System.currentTimeMillis();
		}

		long tick = System.currentTimeMillis();

		while (kill_state >= 0) {
			if (kill_state > 0) {
				kill_state -= 1;

				if (kill_state == 0) {
					close();
					tick_thread = null;
					return;
				}
			}

			int prev_step = step;
			int prev_delta = delta;

			step = 300;
			delta = 1;
			tick = System.currentTimeMillis();

			if (ticks[ptr] == 0L) {
				step = prev_step;
				delta = prev_delta;
			} else if (tick > ticks[ptr]) {
				step = (int) (2560 * period / (tick - ticks[ptr]));
			}

			if (step < 25) {
				step = 25;
			}

			if (step > 256) {
				step = 256;
				delta = (int) (period - (tick - ticks[ptr]) / 10L);
				if (delta < min_delta) {
					delta = min_delta;
				}
			}

			try {
				Thread.sleep((long) delta);
			} catch (InterruptedException error) {
			}

			ticks[ptr] = tick;
			ptr = (ptr + 1) % 10;

			if (delta > 1) {
				for (int i = 0; i < 10; i++) {
					if (this.ticks[i] != 0L) {
						this.ticks[i] += (long) delta;
					}
				}
			}

			int updates = 0;

			while (elapsed < 256) {
				update();
				elapsed += step;
				updates++;
				if (updates > max_updates) {
					elapsed = 0;
					lag_accum += 6;
					if (lag_accum > 25) {
						lag_accum = 0;
						reduce_lag = true;
					}
				}
			}

			lag_accum -= 1;
			elapsed &= 255;

			if (period > 0) {
				fps = (1000 * step) / (period * 256);
			}
			
			render();
		}

		if (kill_state == -1) {
			close();
		}

		tick_thread = null;
	}

	@Override
	public final void update(Graphics graphics) {
		paint(graphics);
	}

	@Override
	public final void paint(Graphics var1) {
		if (loading_stage == 2 && jag_logo != null) {
			set_game_loading_bar(bar_perc, bar_text);
		} else if (loading_stage == 0) {
			preload_render();
		}
	}

	public void load_resources() {
		try {
			byte[] archive = DataUtil.load("jagex.jag");
			byte[] logo_buf = DataUtil.entry_extract("logo.tga", 0, archive);
			
			jag_logo = decode_tga(logo_buf);

			Surface.font_define(DataUtil.entry_extract("h11p.jf", 0, archive));
			Surface.font_define(DataUtil.entry_extract("h12b.jf", 0, archive));
			Surface.font_define(DataUtil.entry_extract("h12p.jf", 0, archive));
			Surface.font_define(DataUtil.entry_extract("h13b.jf", 0, archive));
			Surface.font_define(DataUtil.entry_extract("h14b.jf", 0, archive));
			Surface.font_define(DataUtil.entry_extract("h16b.jf", 0, archive));
			Surface.font_define(DataUtil.entry_extract("h20b.jf", 0, archive));
			Surface.font_define(DataUtil.entry_extract("h24b.jf", 0, archive));
		} catch (IOException error) {
			System.out.println("Error loading jagex.dat");
		}
	}

	public void set_game_loading_bar(int perc, String text) {
		int x = (width - 281) / 2;
		int y = (height - 148) / 2;

		graphics.setColor(Color.BLACK);
		graphics.fillRect(0, 0, width, height);

		if (!on_jagex) {
			graphics.drawImage(jag_logo, x, y, this);
		}

		x += 2;
		y += 90;

		bar_perc = perc;
		bar_text = text;
		graphics.setColor(new Color(132, 132, 132));

		if (on_jagex) {
			graphics.setColor(new Color(220, 0, 0));
		}

		graphics.drawRect(x - 2, y - 2, 280, 23);
		graphics.fillRect(x, y, 277 * perc / 100, 20);
		graphics.setColor(new Color(198, 198, 198));

		if (on_jagex) {
			graphics.setColor(new Color(255, 255, 255));
		}

		text_draw(graphics, text, times_roman, x + 138, y + 10);

		if (!on_jagex) {
			text_draw(graphics, "Created by JAGeX - visit www.jagex.com", helvetica_bold, x + 138, y + 30);
			text_draw(graphics, "\u00a92001-2002 Andrew Gower and Jagex Ltd", helvetica_bold, x + 138, y + 44);
		} else {
			graphics.setColor(new Color(132, 132, 152));
			text_draw(graphics, "\u00a92001-2002 Andrew Gower and Jagex Ltd", helvetica, x + 138, height - 20);
		}

		if (additional_text != null) {
			graphics.setColor(Color.WHITE);
			text_draw(graphics, additional_text, helvetica_bold, x + 138, y - 120);
		}
	}

	public void set_resource_loading_bar(int perc, String text) {
		int x = (width - 281) / 2;
		int y = (height - 148) / 2;

		x += 2;
		y += 90;

		bar_perc = perc;
		bar_text = text;

		int fill_width = 277 * perc / 100;

		graphics.setColor(new Color(132, 132, 132));

		if (on_jagex) {
			graphics.setColor(new Color(220, 0, 0));
		}

		graphics.fillRect(x, y, fill_width, 20);
		graphics.setColor(Color.BLACK);
		graphics.fillRect(x + fill_width, y, 277 - fill_width, 20);
		graphics.setColor(new Color(198, 198, 198));

		if (on_jagex) {
			graphics.setColor(new Color(255, 255, 255));
		}

		text_draw(graphics, text, times_roman, x + 138, y + 10);
	}

	public void text_draw(Graphics graphics, String text, Font font, int x, int y) {
		Component obj = window == null ? this : window;
		FontMetrics metrics = obj.getFontMetrics(font);

		metrics.stringWidth(text);
		graphics.setFont(font);
		graphics.drawString(text, x - metrics.stringWidth(text) / 2, y + metrics.getHeight() / 4);
	}

	public Image decode_tga(byte[] buffer) {
		int width = buffer[13] * 256 + buffer[12];
		int height = buffer[15] * 256 + buffer[14];
		byte[] palette_r = new byte[256];
		byte[] palette_g = new byte[256];
		byte[] palette_b = new byte[256];

		for (int i = 0; i < 256; ++i) {
			palette_r[i] = buffer[20 + i * 3];
			palette_g[i] = buffer[19 + i * 3];
			palette_b[i] = buffer[18 + i * 3];
		}

		IndexColorModel model = new IndexColorModel(8, 256, palette_r, palette_g, palette_b);
		byte[] pixels = new byte[width * height];
		int ptr = 0;

		for (int y = height - 1; y >= 0; --y) {
			for (int x = 0; x < width; ++x) {
				pixels[ptr++] = buffer[786 + x + y * width];
			}
		}

		MemoryImageSource source = new MemoryImageSource(width, height, model, pixels, 0, width);
		return createImage(source);
	}

	public byte[] load_file(String file, String desc, int perc) throws IOException {
		int attempts = 0;
		int decmp_len = 0;
		int len = 0;
		byte[] buffer = null;
		
		while (attempts < 2) {
			try {
				set_resource_loading_bar(perc, "Loading " + desc + " - 0%");
				if (attempts == 1) {
					file = file.toUpperCase();
				}

				InputStream stream = DataUtil.open_stream(file);
				DataInputStream data_stream = new DataInputStream(stream);

				byte[] header = new byte[6];
				data_stream.readFully(header, 0, 6);
				decmp_len = ((header[0] & 255) << 16) + ((header[1] & 255) << 8) + (header[2] & 255);
				len = ((header[3] & 255) << 16) + ((header[4] & 255) << 8) + (header[5] & 255);

				set_resource_loading_bar(perc, "Loading " + desc + " - 5%");

				int read = 0;
				buffer = new byte[len];

				while (read < len) {
					int step = len - read;
					if (step > 1000) {
						step = 1000;
					}

					data_stream.readFully(buffer, read, step);
					read += step;

					set_resource_loading_bar(perc, "Loading " + desc + " - " + (5 + read * 95 / len) + "%");
				}

				attempts = 2;
				data_stream.close();
			} catch (IOException error) {
				++attempts;
			}
		}

		set_resource_loading_bar(perc, "Unpacking " + desc);

		if (len != decmp_len) {
			byte[] decmp_buffer = new byte[decmp_len];
			BZ2.decompress(decmp_buffer, decmp_len, buffer, len, 0);
			return decmp_buffer;
		} else {
			return buffer;
		}
	}
}
