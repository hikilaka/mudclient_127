package jagex.client;

import java.awt.Component;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.ColorModel;
import java.awt.image.DirectColorModel;
import java.awt.image.ImageConsumer;
import java.awt.image.ImageObserver;
import java.awt.image.ImageProducer;

import jagex.DataUtil;

public class Surface implements ImageProducer, ImageObserver {
	/* color constants */
	public static final int BLACK		= 0x000000;
	public static final int WHITE		= 0xFFFFFF;
	public static final int RED			= 0xFF0000;
	public static final int DARK_RED 	= 0xBB0000;
	public static final int GREEN 		= 0x00FF00;
	public static final int BLUE 		= 0x0000FF;
	public static final int YELLOW 		= 0xFFFF00;
	public static final int CYAN 		= 0x00FFFF;
	public static final int MAGENTA 	= 0xFF00FF;
	public static final int LIGHT_GRAY 	= 0xC0C0C0;
	public static final int GRAY 		= 0x808080;
	public static final int DARK_GRAY 	= 0x404040;
	public static final int ORANGE 		= 0xFF7700;

	/* font constants */
	public static final int FONT_REG 		= 0;
	public static final int FONT_BOLD 		= 1;
	public static final int FONT_M_BOLD 	= 3;
	public static final int FONT_L_BOLD 	= 4;
	public static final int FONT_XL_BOLD 	= 5;
	public static final int FONT_XXL_BOLD 	= 7;
	
	private static final byte[][] fonts = new byte[50][];
	private static final int[] glyph_idx = new int[256];
	private static int font_cnt;
	
	static {
		String avail_chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!\"\u00a3$%^&*()-_=+[{]};:'@#~,<.>/?\\| ";

		for (int i = 0; i < 256; ++i) {
			int character = avail_chars.indexOf(i);
			
			if (character == -1) {
				character = 74;
			}

			glyph_idx[i] = character * 9;
		}
	}
	
	public static int rgb(int r, int g, int b) {
		return (r << 16) + (g << 8) + b;
	}
	
	public int width;
	public int height;
	public int area;
	public int max_width;
	public int max_height;

	ColorModel model;
	public int[] pixels;
	ImageConsumer consumer;
	public Image image;
	
	public int[][] sprite_pixels;
	public byte[][] sprite_raster;
	public int[][] sprite_palette;
	public int[] sprite_width;
	public int[] sprite_height;
	public int[] sprite_trans_x;
	public int[] sprite_trans_y;
	public int[] sprite_mask_w;
	public int[] sprite_mask_h;
	public boolean[] sprite_trans;

	private int origin_y;
	private int top_y;
	private int origin_x;
	private int top_x;

	public boolean reduce_lag = false;
	public boolean logged_in = false;

	int[] sin256_tbl;
	int[] sprite_start_x;
	int[] sprite_end_x;
	int[] sprite_start_u;
	int[] sprite_end_u;
	int[] sprite_start_v;
	int[] sprite_end_v;

	public Surface(int w, int h, int sprite_cnt, Component component) {
		super();
		this.top_y = h;
		this.top_x = w;
		this.max_width = width = w;
		this.max_height = height = h;
		this.area = w * h;
		pixels = new int[w * h];
		sprite_pixels = new int[sprite_cnt][];
		sprite_trans = new boolean[sprite_cnt];
		sprite_raster = new byte[sprite_cnt][];
		sprite_palette = new int[sprite_cnt][];
		sprite_width = new int[sprite_cnt];
		sprite_height = new int[sprite_cnt];
		sprite_mask_w = new int[sprite_cnt];
		sprite_mask_h = new int[sprite_cnt];
		sprite_trans_x = new int[sprite_cnt];
		sprite_trans_y = new int[sprite_cnt];
		
		if (w > 1 && h > 1 && component != null) {
			model = new DirectColorModel(32, Surface.RED, Surface.GREEN, Surface.BLUE);
			
			int sz = width * height;

			for (int i = 0; i < sz; ++i) {
				pixels[i] = Surface.BLACK;
			}

			image = component.createImage(this);
			flush();
			component.prepareImage(image, component);
			flush();
			component.prepareImage(image, component);
			flush();
			component.prepareImage(image, component);
		}

	}


	public synchronized void init(int w, int h) {
		if (width > max_width) {
			width = max_width;
		}

		if (height > max_height) {
			height = max_height;
		}

		width = w;
		height = h;
		area = w * h;
	}

	@Override
	public synchronized void addConsumer(ImageConsumer img_consumer) {
		consumer = img_consumer;
		img_consumer.setDimensions(width, height);
		img_consumer.setProperties(null);
		img_consumer.setColorModel(model);
		img_consumer.setHints(14);
	}

	@Override
	public synchronized boolean isConsumer(ImageConsumer img_consumer) {
		return consumer == img_consumer;
	}

	@Override
	public synchronized void removeConsumer(ImageConsumer img_consumer) {
		if (consumer == img_consumer) {
			consumer = null;
		}

	}

	@Override
	public void startProduction(ImageConsumer img_consumer) {
		addConsumer(img_consumer);
	}

	@Override
	public void requestTopDownLeftRightResend(ImageConsumer img_consumer) {
		System.out.println("TDLR");
	}
	
	@Override
	public boolean imageUpdate(Image img, int intoflags, int x, int y, int w, int h) {
		return true;
	}


	public synchronized void flush() {
		if (consumer != null) {
			consumer.setPixels(0, 0, width, height, model, pixels, 0, width);
			consumer.imageComplete(ImageConsumer.TOPDOWNLEFTRIGHT);
		}
	}


	public void set_rect(int ox, int oy, int dx, int ty) {
		if (ox < 0) {
			ox = 0;
		}

		if (oy < 0) {
			oy = 0;
		}

		if (dx > width) {
			dx = width;
		}

		if (ty > height) {
			ty = height;
		}

		origin_x = ox;
		origin_y = oy;
		top_x = dx;
		top_y = ty;
	}

	public void reset() {
		origin_x = 0;
		origin_y = 0;
		top_x = width;
		top_y = height;
	}

	public void copy(Graphics graphics, int x, int y) {
		flush();
		graphics.drawImage(image, x, y, this);
	}


	public void clear() {
		int area = width * height;
		int ptr;
		if (!reduce_lag) {
			for (ptr = 0; ptr < area; ++ptr) {
				pixels[ptr] = 0;
			}
		} else {
			ptr = 0;

			for (int y = -height; y < 0; y += 2) {
				for (int x = -width; x < 0; ++x) {
					pixels[ptr++] = 0;
				}

				ptr += width;
			}
		}
	}

	public void circle_fill(int x, int y, int rad, int color, int opacity) {
		int a = 256 - opacity;
		int r = (color >> 16 & 255) * opacity;
		int g = (color >> 8 & 255) * opacity;
		int b = (color & 255) * opacity;
		int start_y = y - rad;
		
		if (start_y < 0) {
			start_y = 0;
		}

		int end_y = y + rad;
		
		if (end_y >= height) {
			end_y = height - 1;
		}

		byte step = 1;
		
		if (reduce_lag) {
			step = 2;
			if ((start_y & 1) != 0) {
				++start_y;
			}
		}

		for (int dy = start_y; dy <= end_y; dy += step) {
			int dy2 = dy - y;
			int len = (int) Math.sqrt((double) (rad * rad - dy2 * dy2));
			int start_x = x - len;
			if (start_x < 0) {
				start_x = 0;
			}

			int end_x = x + len;
			if (end_x >= width) {
				end_x = width - 1;
			}

			int ptr = start_x + dy * width;

			for (int i = start_x; i <= end_x; ++i) {
				int dr = (pixels[ptr] >> 16 & 255) * a;
				int dg = (pixels[ptr] >> 8 & 255) * a;
				int db = (pixels[ptr] & 255) * a;
				int pixel = (r + dr >> 8 << 16) + (g + dg >> 8 << 8) + (b + db >> 8);
				pixels[ptr++] = pixel;
			}
		}
	}

	public void rect_fill(int x, int y, int w, int h, int color, int opacity) {
		if (x < origin_x) {
			w -= origin_x - x;
			x = origin_x;
		}

		if (y < origin_y) {
			h -= origin_y - y;
			y = origin_y;
		}

		if (x + w > top_x) {
			w = top_x - x;
		}

		if (y + h > top_y) {
			h = top_y - y;
		}

		int a = 256 - opacity;
		int r = (color >> 16 & 255) * opacity;
		int g = (color >> 8 & 255) * opacity;
		int b = (color & 255) * opacity;
		int ptr_step = width - w;
		byte step = 1;
		
		if (reduce_lag) {
			step = 2;
			ptr_step += width;
			if ((y & 1) != 0) {
				++y;
				--h;
			}
		}

		int ptr = x + y * width;

		for (int dy = 0; dy < h; dy += step) {
			for (int dx = -w; dx < 0; ++dx) {
				int dr = (pixels[ptr] >> 16 & 255) * a;
				int dg = (pixels[ptr] >> 8 & 255) * a;
				int db = (pixels[ptr] & 255) * a;
				int pixel = (r + dr >> 8 << 16) + (g + dg >> 8 << 8) + (b + db >> 8);
				pixels[ptr++] = pixel;
			}

			ptr += ptr_step;
		}
	}

	public void grad_rect_fill(int x, int y, int w, int h, int col_a, int col_b) {
		if (x < origin_x) {
			w -= origin_x - x;
			x = origin_x;
		}

		if (x + w > top_x) {
			w = top_x - x;
		}

		int b_r = col_b >> 16 & 255;
		int b_g = col_b >> 8 & 255;
		int b_b = col_b & 255;
		
		int a_r = col_a >> 16 & 255;
		int a_g = col_a >> 8 & 255;
		int a_b = col_a & 255;
		
		int ptr_step = width - w;
		byte step = 1;

		if (reduce_lag) {
			step = 2;
			ptr_step += width;
			if ((y & 1) != 0) {
				++y;
				--h;
			}
		}

		int ptr = x + y * this.width;

		for (int dy = 0; dy < h; dy += step) {
			if (dy + y >= origin_y && dy + y < top_y) {
				int pixel = ((b_r * dy + a_r * (h - dy)) / h << 16)
						  + ((b_g * dy + a_g * (h - dy)) / h << 8)
						   + (b_b * dy + a_b * (h - dy)) / h;

				for (int dx = -w; dx < 0; ++dx) {
					pixels[ptr++] = pixel;
				}

				ptr += ptr_step;
			} else {
				ptr += width;
			}
		}
	}

	public void rect_fill(int x, int y, int w, int h, int color) {
		if (x < origin_x) {
			w -= origin_x - x;
			x = origin_x;
		}

		if (y < origin_y) {
			h -= origin_y - y;
			y = origin_y;
		}

		if (x + w > top_x) {
			w = top_x - x;
		}

		if (y + h > top_y) {
			h = top_y - y;
		}

		int ptr_step = width - w;
		byte step = 1;
		
		if (this.reduce_lag) {
			step = 2;
			ptr_step += width;
			
			if ((y & 1) != 0) {
				++y;
				--h;
			}
		}

		int ptr = x + y * width;

		for (int dy = -h; dy < 0; dy += step) {
			for (int dx = -w; dx < 0; ++dx) {
				pixels[ptr++] = color;
			}

			ptr += ptr_step;
		}
	}

	public void rect_draw(int x, int y, int w, int h, int color) {
		line_horiz(x, y, w, color);
		line_horiz(x, y + h - 1, w, color);
		line_vert(x, y, h, color);
		line_vert(x + w - 1, y, h, color);
	}

	public void line_horiz(int x, int y, int w, int color) {
		if (y >= origin_y && y < top_y) {
			if (x < origin_x) {
				w -= origin_x - x;
				x = origin_x;
			}

			if (x + w > top_x) {
				w = top_x - x;
			}

			int ptr = x + y * width;

			for (int i = 0; i < w; ++i) {
				pixels[ptr + i] = color;
			}
		}
	}

	public void line_vert(int x, int y, int h, int color) {
		if (x >= origin_x && x < top_x) {
			if (y < origin_y) {
				h -= origin_y - y;
				y = origin_y;
			}

			if (y + h > top_x) {
				h = top_y - y;
			}

			int ptr = x + y * width;

			for (int i = 0; i < h; ++i) {
				pixels[ptr + i * width] = color;
			}

		}
	}

	public void plot(int x, int y, int color) {
		if (x >= origin_x && y >= origin_y && x < top_x && y < top_y) {
			pixels[x + y * width] = color;
		}
	}

	public void darken() {
		int area = width * height;

		for (int i = 0; i < area; ++i) {
			int col = pixels[i] & 16777215;
			pixels[i] = ((col >>> 1 & 0x7F7F7F) + (col >>> 2 & 0x3F3F3F)
					   + (col >>> 3 & 0x1F1F1F) + (col >>> 4 & 0xF0F0F));
		}
	}

	public void blur(int x, int y, int start_x, int start_y, int w, int h) {
		for (int dx = start_x; dx < start_x + w; ++dx) {
			for (int dy = start_y; dy < start_y + h; ++dy) {
				int sum_r = 0;
				int sum_g = 0;
				int sum_b = 0;
				int samples = 0;

				for (int _x = dx - x; _x <= dx + x; ++_x) {
					if (_x >= 0 && _x < width) {
						for (int _y = dy - y; _y <= dy + y; ++_y) {
							if (_y >= 0 && _y < height) {
								int pixel = pixels[_x + width * _y];
								sum_r += pixel >> 16 & 255;
								sum_g += pixel >> 8 & 255;
								sum_b += pixel & 255;
								++samples;
							}
						}
					}
				}

				pixels[dx + width * dy] = (sum_r / samples << 16) + (sum_g / samples << 8) + sum_b / samples;
			}
		}
	}

	public void sprites_release() {
		for (int i = 0; i < sprite_pixels.length; ++i) {
			sprite_pixels[i] = null;
			sprite_width[i] = 0;
			sprite_height[i] = 0;
			sprite_raster[i] = null;
			sprite_palette[i] = null;
		}
	}

	public void sprite_define(int off, byte[] data_buf, byte[] idx_buf, int cnt) {
		int idx_ptr = DataUtil.short_get(data_buf, 0);
		
		int mask_w = DataUtil.short_get(idx_buf, idx_ptr);
		idx_ptr += 2;
		int mask_h = DataUtil.short_get(idx_buf, idx_ptr);
		idx_ptr += 2;
		
		int size = idx_buf[idx_ptr++] & 255;

		int[] palette = new int[size];
		palette[0] = Surface.MAGENTA;

		for (int i = 0; i < size - 1; ++i) {
			palette[i + 1] = ((idx_buf[idx_ptr] & 255) << 16) + ((idx_buf[idx_ptr + 1] & 255) << 8) + (idx_buf[idx_ptr + 2] & 255);
			idx_ptr += 3;
		}

		int data_ptr = 2;

		for (int i = off; i < off + cnt; ++i) {
			sprite_trans_x[i] = idx_buf[idx_ptr++] & 255;
			sprite_trans_y[i] = idx_buf[idx_ptr++] & 255;
			
			sprite_width[i] = DataUtil.short_get(idx_buf, idx_ptr);
			idx_ptr += 2;
			sprite_height[i] = DataUtil.short_get(idx_buf, idx_ptr);
			idx_ptr += 2;
			
			int idx_mode = idx_buf[idx_ptr++] & 255;
			int raster_len = sprite_width[i] * sprite_height[i];
			
			sprite_raster[i] = new byte[raster_len];
			sprite_palette[i] = palette;
			sprite_mask_w[i] = mask_w;
			sprite_mask_h[i] = mask_h;
			sprite_pixels[i] = null;
			sprite_trans[i] = false;
			
			if (sprite_trans_x[i] != 0 || sprite_trans_y[i] != 0) {
				sprite_trans[i] = true;
			}

			if (idx_mode == 0) {
				for (int j = 0; j < raster_len; ++j) {
					sprite_raster[i][j] = data_buf[data_ptr++];

					if (sprite_raster[i][j] == 0) {
						sprite_trans[i] = true;
					}
				}
			} else if (idx_mode == 1) {
				for (int x = 0; x < sprite_width[i]; ++x) {
					for (int y = 0; y < sprite_height[i]; ++y) {
						sprite_raster[i][x + y * sprite_width[i]] = data_buf[data_ptr++];
						
						if (sprite_raster[i][x + y * sprite_width[i]] == 0) {
							sprite_trans[i] = true;
						}
					}
				}
			}
		}
	}


	public void sprite_define(byte[] data, int data_off, int id, boolean trans, int sprite_horiz_cnt, int sprite_vert_cnt, boolean indexed) {
		int w = (data[13 + data_off] & 255) * 256 + (data[12 + data_off] & 255);
		int h = (data[15 + data_off] & 255) * 256 + (data[14 + data_off] & 255);
		int trans_ptr = -1;
		int[] palette = new int[256];

		for (int i = 0; i < 256; ++i) {
			palette[i] = -16777216 + ((data[data_off + 20 + i * 3] & 255) << 16) + ((data[data_off + 19 + i * 3] & 255) << 8) + (data[data_off + 18 + i * 3] & 255);
			if (palette[i] == -65281) {
				trans_ptr = i;
			}
		}

		if (trans_ptr == -1) {
			trans = false;
		}

		if (indexed && trans) {
			palette[trans_ptr] = palette[0];
		}

		int _w = w / sprite_horiz_cnt;
		int _h = h / sprite_vert_cnt;
		int[] raster = new int[_w * _h];

		for (int dy = 0; dy < sprite_vert_cnt; ++dy) {
			for (int dx = 0; dx < sprite_horiz_cnt; ++dx) {
				int ptr = 0;

				for (int y = _h * dy; y < _h * (dy + 1); ++y) {
					for (int x = _w * dx; x < _w * (dx + 1); ++x) {
						if (indexed) {
							raster[ptr++] = data[data_off + 786 + x + (h - y - 1) * w] & 255;
						} else {
							raster[ptr++] = palette[data[data_off + 786 + x + (h - y - 1) * w] & 255];
						}
					}
				}

				if (indexed) {
					sprite_define(raster, _w, _h, id++, trans, palette, trans_ptr);
				} else {
					sprite_define(raster, _w, _h, id++, trans, null, -65281);
				}
			}
		}

	}

	private void sprite_define(int[] raster, int w, int h, int id, boolean trans, int[] palette, int trans_mask) {
		int start_x = 0;
		int start_y = 0;
		int end_x = w;
		int end_y = h;
		int ptr;
		int y;
		int x;
		int pixel;
		if (trans) {
			label145: for (ptr = 0; ptr < h; ++ptr) {
				for (y = 0; y < w; ++y) {
					x = raster[y + ptr * w];
					if (x != trans_mask) {
						start_y = ptr;
						break label145;
					}
				}
			}

			label131: for (y = 0; y < w; ++y) {
				for (x = 0; x < h; ++x) {
					pixel = raster[y + x * w];
					if (pixel != trans_mask) {
						start_x = y;
						break label131;
					}
				}
			}

			int var16;
			label117: for (x = h - 1; x >= 0; --x) {
				for (pixel = 0; pixel < w; ++pixel) {
					var16 = raster[pixel + x * w];
					if (var16 != trans_mask) {
						end_y = x + 1;
						break label117;
					}
				}
			}

			label104: for (pixel = w - 1; pixel >= 0; --pixel) {
				for (var16 = 0; var16 < h; ++var16) {
					int var17 = raster[pixel + var16 * w];
					if (var17 != trans_mask) {
						end_x = pixel + 1;
						break label104;
					}
				}
			}
		}

		sprite_width[id] = end_x - start_x;
		sprite_height[id] = end_y - start_y;
		sprite_trans[id] = trans;
		sprite_trans_x[id] = start_x;
		sprite_trans_y[id] = start_y;
		sprite_mask_w[id] = w;
		sprite_mask_h[id] = h;
		
		if (palette == null) {
			sprite_pixels[id] = new int[(end_x - start_x) * (end_y - start_y)];
			ptr = 0;

			for (y = start_y; y < end_y; ++y) {
				for (x = start_x; x < end_x; ++x) {
					pixel = raster[x + y * w];
					if (trans) {
						if (pixel == trans_mask) {
							pixel = Surface.BLACK;
						}

						if (pixel == -16777216) {
							pixel = -16711423;
						}
					}

					sprite_pixels[id][ptr++] = pixel & 16777215;
				}
			}

		} else {
			sprite_raster[id] = new byte[(end_x - start_x) * (end_y - start_y)];
			sprite_palette[id] = palette;
			ptr = 0;

			for (y = start_y; y < end_y; ++y) {
				for (x = start_x; x < end_x; ++x) {
					pixel = raster[x + y * w];
					
					if (trans) {
						if (pixel == trans_mask) {
							pixel = Surface.BLACK;
						} else if (pixel == Surface.BLACK) {
							pixel = trans_mask;
						}
					}

					sprite_raster[id][ptr++] = (byte) pixel;
				}
			}
		}
	}

	public void sprite_posterize(int id) {
		int length = sprite_width[id] * sprite_height[id];
		int[] pixels = this.sprite_pixels[id];
		int[] rgb332_idx = new int[0x8000];

		for (int ptr = 0; ptr < length; ++ptr) {
			int l = pixels[ptr];
			rgb332_idx[(((l & 0xF80000) >> 9) + ((l & 0xF800) >> 6) + ((l & 0xF8) >> 3))] += 1;
		}

		int[] palette = new int[256];
		palette[0] = Surface.MAGENTA;
		int[] freq = new int[256];

		for (int col = 0; col < 0x8000; ++col) {
			int use = rgb332_idx[col];
			if (use > freq[255]) {
				for (int i = 1; i < 256; ++i) {
					if (use > freq[i]) {
						for (int j = 255; j > i; --j) {
							palette[j] = palette[j - 1];
							freq[j] = freq[j - 1];
						}

						palette[i] = ((col & 31744) << 9) + ((col & 992) << 6) + ((col & 31) << 3) + 263172;
						freq[i] = use;
						break;
					}
				}
			}

			rgb332_idx[col] = -1;
		}

		byte[] raster = new byte[length];

		for (int i = 0; i < length; ++i) {
			int pix = pixels[i];
			int pix332 = ((pix & 0xF80000) >> 9) + ((pix & 0xF800) >> 6) + ((pix & 0xF8) >> 3);
			int new_pix = rgb332_idx[pix332];
			if (new_pix == -1) {
				int min_dist = 999999999;
				int r = pix >> 16 & 255;
				int g = pix >> 8 & 255;
				int b = pix & 255;

				for (int var18 = 0; var18 < 256; ++var18) {
					int var19 = palette[var18];
					int _r = var19 >> 16 & 255;
					int _g = var19 >> 8 & 255;
					int _b = var19 & 255;
					int dist = (r - _r) * (r - _r) + (g - _g) * (g - _g) + (b - _b) * (b - _b);
					if (dist < min_dist) {
						min_dist = dist;
						new_pix = var18;
					}
				}

				rgb332_idx[pix332] = new_pix;
			}

			raster[i] = (byte) new_pix;
		}

		sprite_raster[id] = raster;
		sprite_palette[id] = palette;
		sprite_pixels[id] = null;
	}

	public void sprite_resolve(int id) {
		if (sprite_raster[id] != null) {
			int length = sprite_width[id] * sprite_height[id];
			byte[] raster = sprite_raster[id];
			int[] palette = sprite_palette[id];
			int[] pixels = new int[length];

			for (int i = 0; i < length; ++i) {
				int pixel = palette[raster[i] & 255];

				if (pixel == Surface.BLACK) {
					pixel = 1;
				} else if (pixel == Surface.MAGENTA) {
					pixel = Surface.BLACK;
				}

				pixels[i] = pixel;
			}

			sprite_pixels[id] = pixels;
			sprite_raster[id] = null;
			sprite_palette[id] = null;
		}
	}

	public void col_sprite_define(int id, int x_off, int y_off, int w, int h) {
		sprite_width[id] = w;
		sprite_height[id] = h;
		sprite_trans[id] = false;
		sprite_trans_x[id] = 0;
		sprite_trans_y[id] = 0;
		sprite_mask_w[id] = w;
		sprite_mask_h[id] = h;
		
		int length = w * h;
		int ptr = 0;
		
		sprite_pixels[id] = new int[length];

		for (int x = x_off; x < x_off + w; ++x) {
			for (int y = y_off; y < y_off + h; ++y) {
				sprite_pixels[id][ptr++] = pixels[x + y * width];
			}
		}
	}

	public void row_sprite_define(int id, int x_off, int y_off, int w, int h) {
		sprite_width[id] = w;
		sprite_height[id] = h;
		sprite_trans[id] = false;
		sprite_trans_x[id] = 0;
		sprite_trans_y[id] = 0;
		sprite_mask_w[id] = w;
		sprite_mask_h[id] = h;
		
		int length = w * h;
		int ptr = 0;
		
		sprite_pixels[id] = new int[length];

		for (int y = y_off; y < y_off + h; ++y) {
			for (int x = x_off; x < x_off + w; ++x) {
				sprite_pixels[id][ptr++] = pixels[x + y * width];
			}
		}
	}

	public void sprite_plot(int x, int y, int id) {
		if (sprite_trans[id]) {
			x += sprite_trans_x[id];
			y += sprite_trans_y[id];
		}

		int ptr = x + y * width;
		int sprite_ptr = 0;
		int h = sprite_height[id];
		int w = sprite_width[id];
		int ptr_step = width - w;
		int sprite_ptr_step = 0;

		if (y < this.origin_y) {
			int dy = origin_y - y;
			h -= dy;
			y = origin_y;
			sprite_ptr += dy * w;
			ptr += dy * width;
		}

		if (y + h >= top_y) {
			h -= y + h - top_y + 1;
		}

		if (x < origin_x) {
			int dx = origin_x - x;
			w -= dx;
			x = origin_x;
			sprite_ptr += dx;
			ptr += dx;
			sprite_ptr_step += dx;
			ptr_step += dx;
		}

		if (x + w >= top_x) {
			int dx = x + w - top_x + 1;
			w -= dx;
			sprite_ptr_step += dx;
			ptr_step += dx;
		}

		if (w > 0 && h > 0) {
			byte step = 1;
			
			if (reduce_lag) {
				step = 2;
				ptr_step += width;
				sprite_ptr_step += sprite_width[id];
				
				if ((y & 1) != 0) {
					ptr += width;
					--h;
				}
			}

			if (sprite_pixels[id] == null) {
				plot(pixels, sprite_raster[id], sprite_palette[id], sprite_ptr, ptr, w, h, ptr_step, sprite_ptr_step, step);
			} else {
				plot(pixels, sprite_pixels[id], 0, sprite_ptr, ptr, w, h, ptr_step, sprite_ptr_step, step);
			}
		}
	}


	public void resize_sprite_plot(int var1, int var2, int var3, int var4, int var5) {
		try {
			int var6 = this.sprite_width[var5];
			int var7 = this.sprite_height[var5];
			int var8 = 0;
			int var9 = 0;
			int var10 = (var6 << 16) / var3;
			int var11 = (var7 << 16) / var4;
			int var12;
			int var13;
			if (this.sprite_trans[var5]) {
				var12 = this.sprite_mask_w[var5];
				var13 = this.sprite_mask_h[var5];
				var10 = (var12 << 16) / var3;
				var11 = (var13 << 16) / var4;
				var1 += (this.sprite_trans_x[var5] * var3 + var12 - 1) / var12;
				var2 += (this.sprite_trans_y[var5] * var4 + var13 - 1) / var13;
				if (this.sprite_trans_x[var5] * var3 % var12 != 0) {
					var8 = (var12 - this.sprite_trans_x[var5] * var3 % var12 << 16) / var3;
				}

				if (this.sprite_trans_y[var5] * var4 % var13 != 0) {
					var9 = (var13 - this.sprite_trans_y[var5] * var4 % var13 << 16) / var4;
				}

				var3 = var3 * (this.sprite_width[var5] - (var8 >> 16)) / var12;
				var4 = var4 * (this.sprite_height[var5] - (var9 >> 16)) / var13;
			}

			var12 = var1 + var2 * this.width;
			var13 = this.width - var3;
			int var14;
			if (var2 < this.origin_y) {
				var14 = this.origin_y - var2;
				var4 -= var14;
				var2 = 0;
				var12 += var14 * this.width;
				var9 += var11 * var14;
			}

			if (var2 + var4 >= this.top_y) {
				var4 -= var2 + var4 - this.top_y + 1;
			}

			if (var1 < this.origin_x) {
				var14 = this.origin_x - var1;
				var3 -= var14;
				var1 = 0;
				var12 += var14;
				var8 += var10 * var14;
				var13 += var14;
			}

			if (var1 + var3 >= this.top_x) {
				var14 = var1 + var3 - this.top_x + 1;
				var3 -= var14;
				var13 += var14;
			}

			byte var16 = 1;
			if (this.reduce_lag) {
				var16 = 2;
				var13 += this.width;
				var11 += var11;
				if ((var2 & 1) != 0) {
					var12 += this.width;
					--var4;
				}
			}

			this.method_59(this.pixels, this.sprite_pixels[var5], 0, var8, var9, var12, var13, var3, var4, var10, var11,
					var6, var16);
		} catch (Exception var15) {
			System.out.println("error in sprite clipping routine");
		}
	}


	public void trans_sprite_plot(int var1, int var2, int id, int var4) {
		if (this.sprite_trans[id]) {
			var1 += this.sprite_trans_x[id];
			var2 += this.sprite_trans_y[id];
		}

		int var5 = var1 + var2 * this.width;
		int var6 = 0;
		int var7 = this.sprite_height[id];
		int var8 = this.sprite_width[id];
		int var9 = this.width - var8;
		int var10 = 0;
		int var11;
		if (var2 < this.origin_y) {
			var11 = this.origin_y - var2;
			var7 -= var11;
			var2 = this.origin_y;
			var6 += var11 * var8;
			var5 += var11 * this.width;
		}

		if (var2 + var7 >= this.top_y) {
			var7 -= var2 + var7 - this.top_y + 1;
		}

		if (var1 < this.origin_x) {
			var11 = this.origin_x - var1;
			var8 -= var11;
			var1 = this.origin_x;
			var6 += var11;
			var5 += var11;
			var10 += var11;
			var9 += var11;
		}

		if (var1 + var8 >= this.top_x) {
			var11 = var1 + var8 - this.top_x + 1;
			var8 -= var11;
			var10 += var11;
			var9 += var11;
		}

		if (var8 > 0 && var7 > 0) {
			byte var12 = 1;
			if (this.reduce_lag) {
				var12 = 2;
				var9 += this.width;
				var10 += this.sprite_width[id];
				if ((var2 & 1) != 0) {
					var5 += this.width;
					--var7;
				}
			}

			if (this.sprite_pixels[id] == null) {
				this.method_61(this.pixels, this.sprite_raster[id], this.sprite_palette[id], var6, var5, var8, var7, var9,
						var10, var12, var4);
			} else {
				this.method_60(this.pixels, this.sprite_pixels[id], 0, var6, var5, var8, var7, var9, var10, var12, var4);
			}
		}
	}


	public void method_55(int var1, int var2, int var3, int var4, int var5, int var6) {
		try {
			int var7 = this.sprite_width[var5];
			int var8 = this.sprite_height[var5];
			int var9 = 0;
			int var10 = 0;
			int var11 = (var7 << 16) / var3;
			int var12 = (var8 << 16) / var4;
			int var13;
			int var14;
			if (this.sprite_trans[var5]) {
				var13 = this.sprite_mask_w[var5];
				var14 = this.sprite_mask_h[var5];
				var11 = (var13 << 16) / var3;
				var12 = (var14 << 16) / var4;
				var1 += (this.sprite_trans_x[var5] * var3 + var13 - 1) / var13;
				var2 += (this.sprite_trans_y[var5] * var4 + var14 - 1) / var14;
				if (this.sprite_trans_x[var5] * var3 % var13 != 0) {
					var9 = (var13 - this.sprite_trans_x[var5] * var3 % var13 << 16) / var3;
				}

				if (this.sprite_trans_y[var5] * var4 % var14 != 0) {
					var10 = (var14 - this.sprite_trans_y[var5] * var4 % var14 << 16) / var4;
				}

				var3 = var3 * (this.sprite_width[var5] - (var9 >> 16)) / var13;
				var4 = var4 * (this.sprite_height[var5] - (var10 >> 16)) / var14;
			}

			var13 = var1 + var2 * this.width;
			var14 = this.width - var3;
			int var15;
			if (var2 < this.origin_y) {
				var15 = this.origin_y - var2;
				var4 -= var15;
				var2 = 0;
				var13 += var15 * this.width;
				var10 += var12 * var15;
			}

			if (var2 + var4 >= this.top_y) {
				var4 -= var2 + var4 - this.top_y + 1;
			}

			if (var1 < this.origin_x) {
				var15 = this.origin_x - var1;
				var3 -= var15;
				var1 = 0;
				var13 += var15;
				var9 += var11 * var15;
				var14 += var15;
			}

			if (var1 + var3 >= this.top_x) {
				var15 = var1 + var3 - this.top_x + 1;
				var3 -= var15;
				var14 += var15;
			}

			byte var17 = 1;
			if (this.reduce_lag) {
				var17 = 2;
				var14 += this.width;
				var12 += var12;
				if ((var2 & 1) != 0) {
					var13 += this.width;
					--var4;
				}
			}

			this.method_62(this.pixels, this.sprite_pixels[var5], 0, var9, var10, var13, var14, var3, var4, var11, var12,
					var7, var17, var6);
		} catch (Exception var16) {
			System.out.println("error in sprite clipping routine");
		}
	}


	public void method_56(int var1, int var2, int var3, int var4, int var5, int var6) {
		try {
			int var7 = this.sprite_width[var5];
			int var8 = this.sprite_height[var5];
			int var9 = 0;
			int var10 = 0;
			int var11 = (var7 << 16) / var3;
			int var12 = (var8 << 16) / var4;
			int var13;
			int var14;
			if (this.sprite_trans[var5]) {
				var13 = this.sprite_mask_w[var5];
				var14 = this.sprite_mask_h[var5];
				var11 = (var13 << 16) / var3;
				var12 = (var14 << 16) / var4;
				var1 += (this.sprite_trans_x[var5] * var3 + var13 - 1) / var13;
				var2 += (this.sprite_trans_y[var5] * var4 + var14 - 1) / var14;
				if (this.sprite_trans_x[var5] * var3 % var13 != 0) {
					var9 = (var13 - this.sprite_trans_x[var5] * var3 % var13 << 16) / var3;
				}

				if (this.sprite_trans_y[var5] * var4 % var14 != 0) {
					var10 = (var14 - this.sprite_trans_y[var5] * var4 % var14 << 16) / var4;
				}

				var3 = var3 * (this.sprite_width[var5] - (var9 >> 16)) / var13;
				var4 = var4 * (this.sprite_height[var5] - (var10 >> 16)) / var14;
			}

			var13 = var1 + var2 * this.width;
			var14 = this.width - var3;
			int var15;
			if (var2 < this.origin_y) {
				var15 = this.origin_y - var2;
				var4 -= var15;
				var2 = 0;
				var13 += var15 * this.width;
				var10 += var12 * var15;
			}

			if (var2 + var4 >= this.top_y) {
				var4 -= var2 + var4 - this.top_y + 1;
			}

			if (var1 < this.origin_x) {
				var15 = this.origin_x - var1;
				var3 -= var15;
				var1 = 0;
				var13 += var15;
				var9 += var11 * var15;
				var14 += var15;
			}

			if (var1 + var3 >= this.top_x) {
				var15 = var1 + var3 - this.top_x + 1;
				var3 -= var15;
				var14 += var15;
			}

			byte var17 = 1;
			if (this.reduce_lag) {
				var17 = 2;
				var14 += this.width;
				var12 += var12;
				if ((var2 & 1) != 0) {
					var13 += this.width;
					--var4;
				}
			}

			this.resize_tint_plot(this.pixels, this.sprite_pixels[var5], 0, var9, var10, var13, var14, var3, var4, var11, var12,
					var7, var17, var6);
		} catch (Exception var16) {
			System.out.println("error in sprite clipping routine");
		}
	}


	// void
	private void plot(int[] var1, int[] var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9,
			int var10) {
		int var11 = -(var6 >> 2);
		var6 = -(var6 & 3);

		for (int var12 = -var7; var12 < 0; var12 += var10) {
			for (int var13 = var11; var13 < 0; ++var13) {
				var3 = var2[var4++];
				if (var3 != 0) {
					var1[var5++] = var3;
				} else {
					++var5;
				}

				var3 = var2[var4++];
				if (var3 != 0) {
					var1[var5++] = var3;
				} else {
					++var5;
				}

				var3 = var2[var4++];
				if (var3 != 0) {
					var1[var5++] = var3;
				} else {
					++var5;
				}

				var3 = var2[var4++];
				if (var3 != 0) {
					var1[var5++] = var3;
				} else {
					++var5;
				}
			}

			for (int var14 = var6; var14 < 0; ++var14) {
				var3 = var2[var4++];
				if (var3 != 0) {
					var1[var5++] = var3;
				} else {
					++var5;
				}
			}

			var5 += var8;
			var4 += var9;
		}

	}


	// int) void
	private void plot(int[] var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8,
			int var9, int var10) {
		int var11 = -(var6 >> 2);
		var6 = -(var6 & 3);

		for (int var12 = -var7; var12 < 0; var12 += var10) {
			for (int var13 = var11; var13 < 0; ++var13) {
				byte var14 = var2[var4++];
				if (var14 != 0) {
					var1[var5++] = var3[var14 & 255];
				} else {
					++var5;
				}

				var14 = var2[var4++];
				if (var14 != 0) {
					var1[var5++] = var3[var14 & 255];
				} else {
					++var5;
				}

				var14 = var2[var4++];
				if (var14 != 0) {
					var1[var5++] = var3[var14 & 255];
				} else {
					++var5;
				}

				var14 = var2[var4++];
				if (var14 != 0) {
					var1[var5++] = var3[var14 & 255];
				} else {
					++var5;
				}
			}

			for (int var16 = var6; var16 < 0; ++var16) {
				byte var15 = var2[var4++];
				if (var15 != 0) {
					var1[var5++] = var3[var15 & 255];
				} else {
					++var5;
				}
			}

			var5 += var8;
			var4 += var9;
		}

	}


	// int, int, int) void
	private void method_59(int[] var1, int[] var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9,
			int var10, int var11, int var12, int var13) {
		try {
			int var14 = var4;

			for (int var15 = -var9; var15 < 0; var15 += var13) {
				int var16 = (var5 >> 16) * var12;

				for (int var17 = -var8; var17 < 0; ++var17) {
					var3 = var2[(var4 >> 16) + var16];
					if (var3 != 0) {
						var1[var6++] = var3;
					} else {
						++var6;
					}

					var4 += var10;
				}

				var5 += var11;
				var4 = var14;
				var6 += var7;
			}

		} catch (Exception var18) {
			System.out.println("error in plot_scale");
		}
	}


	// int) void
	private void method_60(int[] var1, int[] var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9,
			int var10, int var11) {
		int var12 = 256 - var11;

		for (int var13 = -var7; var13 < 0; var13 += var10) {
			for (int var14 = -var6; var14 < 0; ++var14) {
				var3 = var2[var4++];
				if (var3 != 0) {
					int var15 = var1[var5];
					var1[var5++] = ((var3 & 16711935) * var11 + (var15 & 16711935) * var12 & -16711936)
							+ ((var3 & '\uff00') * var11 + (var15 & '\uff00') * var12 & 16711680) >> 8;
				} else {
					++var5;
				}
			}

			var5 += var8;
			var4 += var9;
		}

	}


	// int, int) void
	private void method_61(int[] var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8,
			int var9, int var10, int var11) {
		int var12 = 256 - var11;

		for (int var13 = -var7; var13 < 0; var13 += var10) {
			for (int var14 = -var6; var14 < 0; ++var14) {
				byte var15 = var2[var4++];
				if (var15 != 0) {
					int var17 = var3[var15 & 255];
					int var16 = var1[var5];
					var1[var5++] = ((var17 & 16711935) * var11 + (var16 & 16711935) * var12 & -16711936)
							+ ((var17 & '\uff00') * var11 + (var16 & '\uff00') * var12 & 16711680) >> 8;
				} else {
					++var5;
				}
			}

			var5 += var8;
			var4 += var9;
		}

	}


	// int, int, int, int) void
	private void method_62(int[] var1, int[] var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9,
			int var10, int var11, int var12, int var13, int var14) {
		int var15 = 256 - var14;

		try {
			int var16 = var4;

			for (int var17 = -var9; var17 < 0; var17 += var13) {
				int var18 = (var5 >> 16) * var12;

				for (int var19 = -var8; var19 < 0; ++var19) {
					var3 = var2[(var4 >> 16) + var18];
					if (var3 != 0) {
						int var20 = var1[var6];
						var1[var6++] = ((var3 & 16711935) * var14 + (var20 & 16711935) * var15 & -16711936)
								+ ((var3 & '\uff00') * var14 + (var20 & '\uff00') * var15 & 16711680) >> 8;
					} else {
						++var6;
					}

					var4 += var10;
				}

				var5 += var11;
				var4 = var16;
				var6 += var7;
			}

		} catch (Exception var21) {
			System.out.println("error in tran_scale");
		}
	}

	private void resize_tint_plot(int[] var1, int[] var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9,
			int var10, int var11, int var12, int var13, int var14) {
		int var15 = var14 >> 16 & 255;
		int var16 = var14 >> 8 & 255;
		int var17 = var14 & 255;

		try {
			int var18 = var4;

			for (int var19 = -var9; var19 < 0; var19 += var13) {
				int var20 = (var5 >> 16) * var12;

				for (int var21 = -var8; var21 < 0; ++var21) {
					var3 = var2[(var4 >> 16) + var20];
					if (var3 != 0) {
						int var22 = var3 >> 16 & 255;
						int var23 = var3 >> 8 & 255;
						int var24 = var3 & 255;
						if (var22 == var23 && var23 == var24) {
							var1[var6++] = (var22 * var15 >> 8 << 16) + (var23 * var16 >> 8 << 8)
									+ (var24 * var17 >> 8);
						} else {
							var1[var6++] = var3;
						}
					} else {
						++var6;
					}

					var4 += var10;
				}

				var5 += var11;
				var4 = var18;
				var6 += var7;
			}
		} catch (Exception error) {
			System.out.println("error in plot_scale");
		}
	}

	public void rotate_sprite_plot(int x, int y, int off, int angle, int scale) {
		int w = width;
		int h = height;

		if (sin256_tbl == null) {
			sin256_tbl = new int[512];

			for (int i = 0; i < 256; ++i) {
				sin256_tbl[i] = (int) (Math.sin((double) i * 0.02454369D) * 32768.0D);
				sin256_tbl[i + 256] = (int) (Math.cos((double) i * 0.02454369D) * 32768.0D);
			}
		}

		int bl_x = -sprite_mask_w[off] / 2;
		int bl_y = -sprite_mask_h[off] / 2;
		
		if (sprite_trans[off]) {
			bl_x += sprite_trans_x[off];
			bl_y += sprite_trans_y[off];
		}

		int tr_x = bl_x + sprite_width[off];
		int tr_y = bl_y + sprite_height[off];
		
		angle &= 255;
		
		int sin = sin256_tbl[angle] * scale;
		int cos = sin256_tbl[angle + 256] * scale;
		int bl_u = x + (bl_y * sin + bl_x * cos >> 22);
		int bl_v = y + (bl_y * cos - bl_x * sin >> 22);
		int tr_u = x + (bl_y * sin + tr_x * cos >> 22);
		int tr_v = y + (bl_y * cos - tr_x * sin >> 22);
		int br_u = x + (tr_y * sin + tr_x * cos >> 22);
		int br_v = y + (tr_y * cos - tr_x * sin >> 22);
		int tl_u = x + (tr_y * sin + bl_x * cos >> 22);
		int tl_v = y + (tr_y * cos - bl_x * sin >> 22);
		int min_v = bl_v;
		int max_v = bl_v;
		
		if (tr_v < bl_v) {
			min_v = tr_v;
		} else if (tr_v > bl_v) {
			max_v = tr_v;
		}

		if (br_v < min_v) {
			min_v = br_v;
		} else if (br_v > max_v) {
			max_v = br_v;
		}

		if (tl_v < min_v) {
			min_v = tl_v;
		} else if (tl_v > max_v) {
			max_v = tl_v;
		}

		if (min_v < origin_y) {
			min_v = origin_y;
		}

		if (max_v > top_y) {
			max_v = top_y;
		}

		if (sprite_start_x == null || sprite_start_x.length != h + 1) {
			sprite_start_x = new int[h + 1];
			sprite_end_x = new int[h + 1];
			sprite_start_u = new int[h + 1];
			sprite_end_u = new int[h + 1];
			sprite_start_v = new int[h + 1];
			sprite_end_v = new int[h + 1];
		}

		for (int var28 = min_v; var28 <= max_v; ++var28) {
			sprite_start_x[var28] = 99999999;
			sprite_end_x[var28] = -99999999;
		}

		int _dx = 0;
		int _du = 0;
		int _dv = 0;
		int sprite_w = sprite_width[off];
		int sprite_h = sprite_height[off];
		byte var52 = 0;
		byte var53 = 0;
		int var12 = sprite_w - 1;
		byte var13 = 0;
		tr_x = sprite_w - 1;
		tr_y = sprite_h - 1;
		byte var14 = 0;
		int tl_y = sprite_h - 1;
		
		if (tl_v != bl_v) {
			_dx = (tl_u - bl_u << 8) / (tl_v - bl_v);
			_dv = (tl_y - var53 << 8) / (tl_v - bl_v);
		}

		int start_v;
		int end_v;
		int _x;
		int _v;
		
		if (bl_v > tl_v) {
			_x = tl_u << 8;
			_v = tl_y << 8;
			start_v = tl_v;
			end_v = bl_v;
		} else {
			_x = bl_u << 8;
			_v = var53 << 8;
			start_v = bl_v;
			end_v = tl_v;
		}

		if (start_v < 0) {
			_x -= _dx * start_v;
			_v -= _dv * start_v;
			start_v = 0;
		}

		if (end_v > h - 1) {
			end_v = h - 1;
		}

		for (int i = start_v; i <= end_v; ++i) {
			sprite_start_x[i] = sprite_end_x[i] = _x;
			_x += _dx;
			sprite_start_u[i] = sprite_end_u[i] = 0;
			sprite_start_v[i] = sprite_end_v[i] = _v;
			_v += _dv;
		}

		if (tr_v != bl_v) {
			_dx = (tr_u - bl_u << 8) / (tr_v - bl_v);
			_du = (var12 - var52 << 8) / (tr_v - bl_v);
		}

		int _u;
		if (bl_v > tr_v) {
			_x = tr_u << 8;
			_u = var12 << 8;
			start_v = tr_v;
			end_v = bl_v;
		} else {
			_x = bl_u << 8;
			_u = var52 << 8;
			start_v = bl_v;
			end_v = tr_v;
		}

		if (start_v < 0) {
			_x -= _dx * start_v;
			_u -= _du * start_v;
			start_v = 0;
		}

		if (end_v > h - 1) {
			end_v = h - 1;
		}

		for (int i = start_v; i <= end_v; ++i) {
			if (_x < sprite_start_x[i]) {
				sprite_start_x[i] = _x;
				sprite_start_u[i] = _u;
				sprite_start_v[i] = 0;
			}

			if (_x > sprite_end_x[i]) {
				sprite_end_x[i] = _x;
				sprite_end_u[i] = _u;
				sprite_end_v[i] = 0;
			}

			_x += _dx;
			_u += _du;
		}

		if (br_v != tr_v) {
			_dx = (br_u - tr_u << 8) / (br_v - tr_v);
			_dv = (tr_y - var13 << 8) / (br_v - tr_v);
		}

		if (tr_v > br_v) {
			_x = br_u << 8;
			_u = tr_x << 8;
			_v = tr_y << 8;
			start_v = br_v;
			end_v = tr_v;
		} else {
			_x = tr_u << 8;
			_u = var12 << 8;
			_v = var13 << 8;
			start_v = tr_v;
			end_v = br_v;
		}

		if (start_v < 0) {
			_x -= _dx * start_v;
			_v -= _dv * start_v;
			start_v = 0;
		}

		if (end_v > h - 1) {
			end_v = h - 1;
		}

		for (int i = start_v; i <= end_v; ++i) {
			if (_x < sprite_start_x[i]) {
				sprite_start_x[i] = _x;
				sprite_start_u[i] = _u;
				sprite_start_v[i] = _v;
			}

			if (_x > sprite_end_x[i]) {
				sprite_end_x[i] = _x;
				sprite_end_u[i] = _u;
				sprite_end_v[i] = _v;
			}

			_x += _dx;
			_v += _dv;
		}

		if (tl_v != br_v) {
			_dx = (tl_u - br_u << 8) / (tl_v - br_v);
			_du = (var14 - tr_x << 8) / (tl_v - br_v);
		}

		if (br_v > tl_v) {
			_x = tl_u << 8;
			_u = var14 << 8;
			_v = tl_y << 8;
			start_v = tl_v;
			end_v = br_v;
		} else {
			_x = br_u << 8;
			_u = tr_x << 8;
			_v = tr_y << 8;
			start_v = br_v;
			end_v = tl_v;
		}

		if (start_v < 0) {
			_x -= _dx * start_v;
			_u -= _du * start_v;
			start_v = 0;
		}

		if (end_v > h - 1) {
			end_v = h - 1;
		}

		for (int i = start_v; i <= end_v; ++i) {
			if (_x < sprite_start_x[i]) {
				sprite_start_x[i] = _x;
				sprite_start_u[i] = _u;
				sprite_start_v[i] = _v;
			}

			if (_x > sprite_end_x[i]) {
				sprite_end_x[i] = _x;
				sprite_end_u[i] = _u;
				sprite_end_v[i] = _v;
			}

			_x += _dx;
			_u += _du;
		}

		int ptr = min_v * w;
		int[] sprite_pix = this.sprite_pixels[off];

		for (int i = min_v; i < max_v; ++i) {
			int off_x = sprite_start_x[i] >> 8;
			int end_x = sprite_end_x[i] >> 8;
			if (end_x - off_x <= 0) {
				ptr += w;
			} else {
				int u = sprite_start_u[i] << 9;
				int du = ((sprite_end_u[i] << 9) - u) / (end_x - off_x);
				int v = sprite_start_v[i] << 9;
				int dv = ((sprite_end_v[i] << 9) - v) / (end_x - off_x);
				if (off_x < origin_x) {
					u += (origin_x - off_x) * du;
					v += (origin_x - off_x) * dv;
					off_x = origin_x;
				}

				if (end_x > top_x) {
					end_x = top_x;
				}

				if (!reduce_lag || (i & 1) == 0) {
					if (!sprite_trans[off]) {
						trans_row_plot(pixels, sprite_pix, 0, ptr + off_x, u, v, du, dv, off_x - end_x, sprite_w);
					} else {
						trans_row_index_plot(pixels, sprite_pix, 0, ptr + off_x, u, v, du, dv, off_x - end_x, sprite_w);
					}
				}

				ptr += w;
			}
		}
	}

	private void trans_row_plot(int[] out, int[] in, int i, int out_ptr, int u, int v, int du, int dv, int len, int in_w) {
		for (i = len; i < 0; ++i) {
			pixels[out_ptr++] = in[(u >> 17) + (v >> 17) * in_w];
			u += du;
			v += dv;
		}
	}

	private void trans_row_index_plot(int[] out, int[] palette, int i, int out_ptr, int u, int v, int du, int dv, int len, int in_w) {
		for (int j = len; j < 0; ++j) {
			i = palette[(u >> 17) + (v >> 17) * in_w];
			if (i != 0) {
				pixels[out_ptr++] = i;
			} else {
				++out_ptr;
			}

			u += du;
			v += dv;
		}
	}

	public void sprite_3d_plot(int var1, int var2, int var3, int var4, int var5, int var6, int var7) {
		resize_sprite_plot(var1, var2, var3, var4, var5);
	}

	public void resize_trans_sprite_plot(int x, int y, int w, int h, int id, int gray_tint, int pink_tint, int ptr,
			boolean var9) {
		try {
			if (gray_tint == 0) {
				gray_tint = Surface.WHITE;
			}

			if (pink_tint == 0) {
				pink_tint = Surface.WHITE;
			}

			int dw = sprite_width[id];
			int dh = sprite_height[id];
			int new_w = 0;
			int new_h = 0;
			int out_ptr = ptr << 16;
			int ratio_w = (dw << 16) / w;
			int ratio_h = (dh << 16) / h;
			int var17 = -(ptr << 16) / h;
			int mask_w;
			int mask_h;
			
			if (sprite_trans[id]) {
				mask_w = sprite_mask_w[id];
				mask_h = sprite_mask_h[id];
				ratio_w = (mask_w << 16) / w;
				ratio_h = (mask_h << 16) / h;
				
				int trans_x = sprite_trans_x[id];
				int trans_y = sprite_trans_y[id];
				
				if (var9) {
					trans_x = mask_w - sprite_width[id] - trans_x;
				}

				x += (trans_x * w + mask_w - 1) / mask_w;
				
				int dy = (trans_y * h + mask_h - 1) / mask_h;
				
				y += dy;
				out_ptr += dy * var17;
				
				if (trans_x * w % mask_w != 0) {
					new_w = (mask_w - trans_x * w % mask_w << 16) / w;
				}

				if (trans_y * h % mask_h != 0) {
					new_h = (mask_h - trans_y * h % mask_h << 16) / h;
				}

				w = ((sprite_width[id] << 16) - new_w + ratio_w - 1) / ratio_w;
				h = ((sprite_height[id] << 16) - new_h + ratio_h - 1) / ratio_h;
			}

			mask_w = y * width;
			out_ptr += x << 16;
			
			if (y < origin_y) {
				mask_h = origin_y - y;
				h -= mask_h;
				y = origin_y;
				mask_w += mask_h * width;
				new_h += ratio_h * mask_h;
				out_ptr += var17 * mask_h;
			}

			if (y + h >= top_y) {
				h -= y + h - top_y + 1;
			}

			mask_h = mask_w / width & 1;
			
			if (!reduce_lag) {
				mask_h = 2;
			}

			if (pink_tint == Surface.WHITE) {
				if (sprite_pixels[id] != null) {
					if (!var9) {
						resize_trans_sprite_plot(pixels, sprite_pixels[id], 0, new_w, new_h, mask_w, w, h, ratio_w, ratio_h, dw, gray_tint, out_ptr, var17, mask_h);
					} else {
						resize_trans_sprite_plot(pixels, sprite_pixels[id], 0, (sprite_width[id] << 16) - new_w - 1, new_h, mask_w, w, h, -ratio_w, ratio_h, dw, gray_tint, out_ptr, var17, mask_h);
					}
				} else if (!var9) {
					resize_trans_sprite_plot(pixels, sprite_raster[id], sprite_palette[id], 0, new_w, new_h, mask_w, w, h, ratio_w, ratio_h, dw, gray_tint, out_ptr, var17, mask_h);
				} else {
					resize_trans_sprite_plot(pixels, sprite_raster[id], sprite_palette[id], 0, (sprite_width[id] << 16) - new_w - 1, new_h, mask_w, w, h, -ratio_w, ratio_h, dw, gray_tint, out_ptr, var17, mask_h);
				}
			} else if (sprite_pixels[id] != null) {
				if (!var9) {
					resize_trans_sprite_plot(pixels, sprite_pixels[id], 0, new_w, new_h, mask_w, w, h, ratio_w, ratio_h, dw, gray_tint, pink_tint, out_ptr, var17, mask_h);
				} else {
					resize_trans_sprite_plot(pixels, sprite_pixels[id], 0, (sprite_width[id] << 16) - new_w - 1, new_h, mask_w, w, h, -ratio_w, ratio_h, dw, gray_tint, pink_tint, out_ptr, var17, mask_h);
				}
			} else if (!var9) {
				resize_trans_sprite_plot(pixels, sprite_raster[id], sprite_palette[id], 0, new_w, new_h, mask_w, w, h, ratio_w, ratio_h, dw, gray_tint, pink_tint, out_ptr, var17, mask_h);
			} else {
				resize_trans_sprite_plot(pixels, sprite_raster[id], sprite_palette[id], 0, (sprite_width[id] << 16) - new_w - 1, new_h, mask_w, w, h, -ratio_w, ratio_h, dw, gray_tint, pink_tint, out_ptr, var17, mask_h);
			}
		} catch (Exception error) {
			System.out.println("error in sprite clipping routine");
		}
	}

	private void resize_trans_sprite_plot(int[] var1, int[] var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9,
			int var10, int var11, int var12, int var13, int var14, int var15) {
		int var19 = var12 >> 16 & 255;
		int var20 = var12 >> 8 & 255;
		int var21 = var12 & 255;

		try {
			int var22 = var4;

			for (int var23 = -var8; var23 < 0; ++var23) {
				int var24 = (var5 >> 16) * var11;
				int var25 = var13 >> 16;
				int var26 = var7;
				int var27;
				if (var25 < this.origin_x) {
					var27 = this.origin_x - var25;
					var26 = var7 - var27;
					var25 = this.origin_x;
					var4 += var9 * var27;
				}

				if (var25 + var26 >= this.top_x) {
					var27 = var25 + var26 - this.top_x;
					var26 -= var27;
				}

				var15 = 1 - var15;
				if (var15 != 0) {
					for (var27 = var25; var27 < var25 + var26; ++var27) {
						var3 = var2[(var4 >> 16) + var24];
						if (var3 != 0) {
							int var16 = var3 >> 16 & 255;
							int var17 = var3 >> 8 & 255;
							int var18 = var3 & 255;
							if (var16 == var17 && var17 == var18) {
								var1[var27 + var6] = (var16 * var19 >> 8 << 16) + (var17 * var20 >> 8 << 8)
										+ (var18 * var21 >> 8);
							} else {
								var1[var27 + var6] = var3;
							}
						}

						var4 += var9;
					}
				}

				var5 += var10;
				var4 = var22;
				var6 += this.width;
				var13 += var14;
			}

		} catch (Exception var28) {
			System.out.println("error in transparent sprite plot routine");
		}
	}

	private void resize_trans_sprite_plot(int[] out, int[] in, int var3, int out_ptr, int var5, int var6, int var7, int var8, int out_step,
			int var10, int var11, int col_a, int col_b, int var14, int var15, int var16) {
		int a_r = col_a >> 16 & 255;
		int a_g = col_a >> 8 & 255;
		int a_b = col_a & 255;

		int b_r = col_b >> 16 & 255;
		int b_g = col_b >> 8 & 255;
		int b_b = col_b & 255;

		try {
			int var26 = out_ptr;

			for (int var27 = -var8; var27 < 0; ++var27) {
				int var28 = (var5 >> 16) * var11;
				int var29 = var14 >> 16;
				int var30 = var7;
				int var31;
				if (var29 < origin_x) {
					var31 = origin_x - var29;
					var30 = var7 - var31;
					var29 = origin_x;
					out_ptr += out_step * var31;
				}

				if (var29 + var30 >= top_x) {
					var31 = var29 + var30 - top_x;
					var30 -= var31;
				}

				var16 = 1 - var16;
				if (var16 != 0) {
					for (var31 = var29; var31 < var29 + var30; ++var31) {
						var3 = in[(out_ptr >> 16) + var28];
						if (var3 != 0) {
							int var17 = var3 >> 16 & 255;
							int var18 = var3 >> 8 & 255;
							int var19 = var3 & 255;
							if (var17 == var18 && var18 == var19) {
								out[var31 + var6] = (var17 * a_r >> 8 << 16) + (var18 * a_g >> 8 << 8)
										+ (var19 * a_b >> 8);
							} else if (var17 == 255 && var18 == var19) {
								out[var31 + var6] = (var17 * b_r >> 8 << 16) + (var18 * b_g >> 8 << 8)
										+ (var19 * b_b >> 8);
							} else {
								out[var31 + var6] = var3;
							}
						}

						out_ptr += out_step;
					}
				}

				var5 += var10;
				out_ptr = var26;
				var6 += width;
				var14 += var15;
			}
		} catch (Exception var32) {
			System.out.println("error in transparent sprite plot routine");
		}
	}

	private void resize_trans_sprite_plot(int[] var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8,
			int var9, int var10, int var11, int var12, int var13, int var14, int var15, int var16) {
		int var20 = var13 >> 16 & 255;
		int var21 = var13 >> 8 & 255;
		int var22 = var13 & 255;

		try {
			int var23 = var5;

			for (int var24 = -var9; var24 < 0; ++var24) {
				int var25 = (var6 >> 16) * var12;
				int var26 = var14 >> 16;
				int var27 = var8;
				int var28;
				if (var26 < this.origin_x) {
					var28 = this.origin_x - var26;
					var27 = var8 - var28;
					var26 = this.origin_x;
					var5 += var10 * var28;
				}

				if (var26 + var27 >= this.top_x) {
					var28 = var26 + var27 - this.top_x;
					var27 -= var28;
				}

				var16 = 1 - var16;
				if (var16 != 0) {
					for (var28 = var26; var28 < var26 + var27; ++var28) {
						var4 = var2[(var5 >> 16) + var25] & 255;
						if (var4 != 0) {
							var4 = var3[var4];
							int var17 = var4 >> 16 & 255;
							int var18 = var4 >> 8 & 255;
							int var19 = var4 & 255;
							if (var17 == var18 && var18 == var19) {
								var1[var28 + var7] = (var17 * var20 >> 8 << 16) + (var18 * var21 >> 8 << 8)
										+ (var19 * var22 >> 8);
							} else {
								var1[var28 + var7] = var4;
							}
						}

						var5 += var10;
					}
				}

				var6 += var11;
				var5 = var23;
				var7 += this.width;
				var14 += var15;
			}

		} catch (Exception var29) {
			System.out.println("error in transparent sprite plot routine");
		}
	}

	private void resize_trans_sprite_plot(int[] var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8,
			int var9, int var10, int var11, int var12, int var13, int var14, int var15, int var16, int var17) {
		int var21 = var13 >> 16 & 255;
		int var22 = var13 >> 8 & 255;
		int var23 = var13 & 255;
		int var24 = var14 >> 16 & 255;
		int var25 = var14 >> 8 & 255;
		int var26 = var14 & 255;

		try {
			int var27 = var5;

			for (int var28 = -var9; var28 < 0; ++var28) {
				int var29 = (var6 >> 16) * var12;
				int var30 = var15 >> 16;
				int var31 = var8;
				int var32;
				if (var30 < this.origin_x) {
					var32 = this.origin_x - var30;
					var31 = var8 - var32;
					var30 = this.origin_x;
					var5 += var10 * var32;
				}

				if (var30 + var31 >= this.top_x) {
					var32 = var30 + var31 - this.top_x;
					var31 -= var32;
				}

				var17 = 1 - var17;
				if (var17 != 0) {
					for (var32 = var30; var32 < var30 + var31; ++var32) {
						var4 = var2[(var5 >> 16) + var29] & 255;
						if (var4 != 0) {
							var4 = var3[var4];
							int var18 = var4 >> 16 & 255;
							int var19 = var4 >> 8 & 255;
							int var20 = var4 & 255;
							if (var18 == var19 && var19 == var20) {
								var1[var32 + var7] = (var18 * var21 >> 8 << 16) + (var19 * var22 >> 8 << 8)
										+ (var20 * var23 >> 8);
							} else if (var18 == 255 && var19 == var20) {
								var1[var32 + var7] = (var18 * var24 >> 8 << 16) + (var19 * var25 >> 8 << 8)
										+ (var20 * var26 >> 8);
							} else {
								var1[var32 + var7] = var4;
							}
						}

						var5 += var10;
					}
				}

				var6 += var11;
				var5 = var27;
				var7 += this.width;
				var15 += var16;
			}

		} catch (Exception var33) {
			System.out.println("error in transparent sprite plot routine");
		}
	}

	public static int font_define(byte[] font) {
		fonts[font_cnt] = font;
		return font_cnt++;
	}

	public void precede_text_draw(String text, int x, int y, int font, int color) {
		text_draw(text, x - text_width(text, font), y, font, color);
	}

	public void center_text_draw(String text, int x, int y, int font, int color) {
		text_draw(text, x - text_width(text, font) / 2, y, font, color);
	}

	public void multiline_text_draw(String text, int x, int y, int font, int color, int line_break) {
		try {
			int cnt = 0;
			byte[] glyphs = fonts[font];
			int line_begin = 0;
			int line_end = 0;

			for (int i = 0; i < text.length(); ++i) {
				if (text.charAt(i) == '@' && i + 4 < text.length() && text.charAt(i + 4) == '@') {
					i += 4;
				} else if (text.charAt(i) == '~' && i + 4 < text.length() && text.charAt(i + 4) == '~') {
					i += 4;
				} else {
					cnt += glyphs[glyph_idx[text.charAt(i)] + 7];
				}

				if (text.charAt(i) == ' ') {
					line_end = i;
				}

				if (cnt > line_break) {
					if (line_end <= line_begin) {
						line_end = i;
					}

					center_text_draw(text.substring(line_begin, line_end), x, y, font, color);
					cnt = 0;
					line_begin = i = line_end + 1;
					y += text_height(font);
				}
			}

			if (cnt > 0) {
				center_text_draw(text.substring(line_begin), x, y, font, color);
			}
		} catch (Exception error) {
			System.out.println("centrepara: " + error);
			error.printStackTrace();
		}

	}

	public void text_draw(String text, int x, int y, int font, int color) {
		try {
			byte[] gylphs = fonts[font];

			for (int i = 0; i < text.length(); ++i) {
				if (text.charAt(i) == '@' && i + 4 < text.length() && text.charAt(i + 4) == '@') {
					if (text.substring(i + 1, i + 4).equalsIgnoreCase("red")) {
						color = Surface.RED;
					} else if (text.substring(i + 1, i + 4).equalsIgnoreCase("lre")) {
						color = 0xFF9040;
					} else if (text.substring(i + 1, i + 4).equalsIgnoreCase("yel")) {
						color = Surface.YELLOW;
					} else if (text.substring(i + 1, i + 4).equalsIgnoreCase("gre")) {
						color = Surface.GREEN;
					} else if (text.substring(i + 1, i + 4).equalsIgnoreCase("blu")) {
						color = Surface.BLUE;
					} else if (text.substring(i + 1, i + 4).equalsIgnoreCase("cya")) {
						color = Surface.CYAN;
					} else if (text.substring(i + 1, i + 4).equalsIgnoreCase("mag")) {
						color = Surface.MAGENTA;
					} else if (text.substring(i + 1, i + 4).equalsIgnoreCase("whi")) {
						color = Surface.WHITE;
					} else if (text.substring(i + 1, i + 4).equalsIgnoreCase("bla")) {
						color = Surface.BLACK;
					} else if (text.substring(i + 1, i + 4).equalsIgnoreCase("dre")) {
						color = 0xC00000;
					} else if (text.substring(i + 1, i + 4).equalsIgnoreCase("ora")) {
						color = 0xFF9040;
					} else if (text.substring(i + 1, i + 4).equalsIgnoreCase("ran")) {
						color = (int) (Math.random() * 1.6777215E7D);
					} else if (text.substring(i + 1, i + 4).equalsIgnoreCase("or1")) {
						color = 0xFFB000;
					} else if (text.substring(i + 1, i + 4).equalsIgnoreCase("or2")) {
						color = 0xFF7000;
					} else if (text.substring(i + 1, i + 4).equalsIgnoreCase("or3")) {
						color = 0xFF3000;
					} else if (text.substring(i + 1, i + 4).equalsIgnoreCase("gr1")) {
						color = 0xC0FF00;
					} else if (text.substring(i + 1, i + 4).equalsIgnoreCase("gr2")) {
						color = 0x80FF00;
					} else if (text.substring(i + 1, i + 4).equalsIgnoreCase("gr3")) {
						color = 0x40FF00;
					}

					i += 4;
				} else if (text.charAt(i) == '~' && i + 4 < text.length() && text.charAt(i + 4) == '~') {
					char c1 = text.charAt(i + 1);
					char c2 = text.charAt(i + 2);
					char c3 = text.charAt(i + 3);
					if (c1 >= '0' && c1 <= '9' && c2 >= '0' && c2 <= '9' && c3 >= '0' && c3 <= '9') {
						x = Integer.parseInt(text.substring(i + 1, i + 4));
					}

					i += 4;
				} else {
					int idx = glyph_idx[text.charAt(i)];
										
					// text shadows
					if (logged_in && color != 0) {
						char_plot(idx, x + 1, y, Surface.BLACK, gylphs);
						char_plot(idx, x, y + 1, Surface.BLACK, gylphs);
					}

					char_plot(idx, x, y, color, gylphs);
					x += gylphs[idx + 7];
				}
			}
		} catch (Exception error) {
			System.out.println("drawstring: " + error);
			error.printStackTrace();
		}
	}

	private void char_plot(int ptr, int x, int y, int color, byte[] glyph) {
		int start_x = x + glyph[ptr + 5];
		int start_y = y - glyph[ptr + 6];
		int w = glyph[ptr + 3];
		int h = glyph[ptr + 4];
		int in_ptr = glyph[ptr] * 16384 + glyph[ptr + 1] * 128 + glyph[ptr + 2];
		int out_ptr = start_x + start_y * width;
		int out_step = width - w;
		int in_step = 0;
		int i;
		if (start_y < origin_y) {
			i = origin_y - start_y;
			h -= i;
			start_y = origin_y;
			in_ptr += i * w;
			out_ptr += i * width;
		}

		if (start_y + h >= top_y) {
			h -= start_y + h - top_y + 1;
		}

		if (start_x < origin_x) {
			i = origin_x - start_x;
			w -= i;
			start_x = origin_x;
			in_ptr += i;
			out_ptr += i;
			in_step += i;
			out_step += i;
		}

		if (start_x + w >= top_x) {
			i = start_x + w - top_x + 1;
			w -= i;
			in_step += i;
			out_step += i;
		}

		if (w > 0 && h > 0) {
			char_plot(pixels, glyph, color, in_ptr, out_ptr, w, h, out_step, in_step);
		}
	}

	private void char_plot(int[] out, byte[] glyph, int color, int i_ptr, int o_ptr, int w, int h, int o_step,
			int i_step) {
		try {
			int blocks = -(w >> 2);
			w = -(w & 3);

			for (int y = -h; y < 0; ++y) {
				for (int i = blocks; i < 0; ++i) {
					if (glyph[i_ptr++] != 0) {
						out[o_ptr++] = color;
					} else {
						++o_ptr;
					}

					if (glyph[i_ptr++] != 0) {
						out[o_ptr++] = color;
					} else {
						++o_ptr;
					}

					if (glyph[i_ptr++] != 0) {
						out[o_ptr++] = color;
					} else {
						++o_ptr;
					}

					if (glyph[i_ptr++] != 0) {
						out[o_ptr++] = color;
					} else {
						++o_ptr;
					}
				}

				for (int x = w; x < 0; ++x) {
					if (glyph[i_ptr++] != 0) {
						out[o_ptr++] = color;
					} else {
						++o_ptr;
					}
				}

				o_ptr += o_step;
				i_ptr += i_step;
			}

		} catch (Exception error) {
			System.out.println("plotletter: " + error);
			error.printStackTrace();
		}
	}

	public int text_height(int font) {
		return font == 0 ? fonts[font][8] - 2 : fonts[font][8] - 1;
	}

	public int text_width(String text, int font) {
		int result = 0;
		byte[] glyphs = fonts[font];

		for (int i = 0; i < text.length(); ++i) {
			if (text.charAt(i) == '@' && i + 4 < text.length() && text.charAt(i + 4) == '@') {
				i += 4;
			} else if (text.charAt(i) == '~' && i + 4 < text.length() && text.charAt(i + 4) == '~') {
				i += 4;
			} else {
				result += glyphs[glyph_idx[text.charAt(i)] + 7];
			}
		}

		return result;
	}
}
