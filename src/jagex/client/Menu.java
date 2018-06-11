package jagex.client;
public final class Menu {
	public static final int r_mod = 114;
	public static final int g_mod = 114;
	public static final int b_mod = 176;

	public static boolean field_386 = true;
	public static int sprite_off;
	public static int field_391;
	
	private static final int element_type_label = 0;
	private static final int element_type_label_centered = 1;
	private static final int element_type_rect = 2;
	private static final int element_type_hline = 3;
	private static final int element_type_static_list = 4;
	private static final int element_type_input= 5;
	private static final int element_type_input_centered = 6;
	private static final int element_type_hlist = 7;
	private static final int element_type_vlist = 8;
	private static final int element_type_option = 9;
	private static final int element_type_button = 10;
	private static final int element_type_container = 11;
	private static final int element_type_sprite = 12;
	private static final int element_type_checkbox = 14;

	public static int mod_rgb(int r, int g, int b) {
		return Surface.rgb(r_mod * r / 114, g_mod * g / 114, b_mod * b / 176);
	}

	protected Surface surface;
	private int elem_cnt;
	private int elem_focus = -1;
	private boolean[] elem_enabled;
	private boolean[] field_350;
	private boolean[] elem_text_shadowed;
	private boolean[] elem_hit;
	public int[] field_353;
	public int[] elem_entry_cnt;
	private int[] elem_toggle;
	private int[] elem_hover;
	private boolean[] elem_is_background;
	private int[] elem_x;
	private int[] elem_y;
	private int[] elem_type;
	private int[] elem_w;
	private int[] elem_h;
	private int[] elem_input_cap;
	private int[] elem_font;
	private String[] elem_text;
	private String[][] elem_entry;
	private int mouse_x;
	private int mouse_y;
	private int click_state;
	private int mouse_state;
	private int mouse_state_held;
	
	private int scroll_col_top;
	private int scroll_col_bottom;

	private int scroll_handle_left;
	private int scroll_handle_mid;
	private int scroll_handle_right;
	
	private int container_color_a;
	private int container_color_b;
	private int container_color_c;
	
	private int elem_color_b;
	private int elem_color_c;
	private int elem_color_d;
	private int elem_color_a;
	
	public boolean highlight_selected_opt = true;

	public Menu(Surface surface, int max_elements) {
		this.surface = surface;
		elem_cnt = 0;
		elem_enabled = new boolean[max_elements];
		field_350 = new boolean[max_elements];
		elem_text_shadowed = new boolean[max_elements];
		elem_hit = new boolean[max_elements];
		elem_is_background = new boolean[max_elements];
		field_353 = new int[max_elements];
		elem_entry_cnt = new int[max_elements];
		elem_toggle = new int[max_elements];
		elem_hover = new int[max_elements];
		elem_x = new int[max_elements];
		elem_y = new int[max_elements];
		elem_type = new int[max_elements];
		elem_w = new int[max_elements];
		elem_h = new int[max_elements];
		elem_input_cap = new int[max_elements];
		elem_font = new int[max_elements];
		elem_text = new String[max_elements];
		elem_entry = new String[max_elements][];
		
		scroll_col_top = mod_rgb(114, 114, 176);
		scroll_col_bottom = mod_rgb(14, 14, 62);
		scroll_handle_left = mod_rgb(200, 208, 232);
		scroll_handle_mid = mod_rgb(96, 129, 184);
		scroll_handle_right = mod_rgb(53, 95, 115);
		container_color_a = mod_rgb(117, 142, 171);
		container_color_b = mod_rgb(98, 122, 158);
		container_color_c = mod_rgb(86, 100, 136);
		elem_color_b = mod_rgb(135, 146, 179);
		elem_color_c = mod_rgb(97, 112, 151);
		elem_color_d = mod_rgb(88, 102, 136);
		elem_color_a = mod_rgb(84, 93, 120);
	}

	public void reset_click_state() {
		click_state = 0;
	}

	public void consume(int mouse_x, int mouse_y, int click_state, int mouse_state) {
		this.mouse_x = mouse_x;
		this.mouse_y = mouse_y;
		this.mouse_state = mouse_state;

		if (click_state != 0) {
			this.click_state = click_state;
		}

		if (click_state == 1) {
			for (int i = 0; i < elem_cnt; ++i) {
				if (elem_enabled[i] && elem_type[i] == element_type_button && mouse_x >= elem_x[i]
						&& mouse_y >= elem_y[i]
						&& mouse_x <= elem_x[i] + elem_w[i]
						&& mouse_y <= elem_y[i] + elem_h[i]) {
					elem_hit[i] = true;
				}

				if (elem_enabled[i] && elem_type[i] == element_type_checkbox && mouse_x >= elem_x[i]
						&& mouse_y >= elem_y[i]
						&& mouse_x <= elem_x[i] + elem_w[i]
						&& mouse_y <= elem_y[i] + elem_h[i]) {
					elem_toggle[i] = 1 - elem_toggle[i];
				}
			}
		}

		if (mouse_state == 1) {
			mouse_state_held += 1;
		} else {
			mouse_state_held = 0;
		}

		if (click_state == 1 || mouse_state_held > 20) {
			for (int i = 0; i < elem_cnt; ++i) {
				// no such element type == 15
				if (elem_enabled[i] && elem_type[i] == 15 && mouse_x >= elem_x[i]
						&& mouse_y >= elem_y[i]
						&& mouse_x <= elem_x[i] + elem_w[i]
						&& mouse_y <= elem_y[i] + elem_h[i]) {
					elem_hit[i] = true;
				}
			}

			mouse_state_held -= 5;
		}

	}

	public boolean selected(int id) {
		if (elem_enabled[id] && elem_hit[id]) {
			elem_hit[id] = false;
			return true;
		} else {
			return false;
		}
	}

	public void on_key(int key) {
		if (key != 0) {
			if (elem_focus != -1 && elem_text[elem_focus] != null && elem_enabled[elem_focus]) {
				int text_len = elem_text[elem_focus].length();
				
				if (key == 8 && text_len > 0) {
					elem_text[elem_focus] = elem_text[elem_focus].substring(0, text_len - 1);
				}

				if ((key == 10 || key == 13) && text_len > 0) {
					elem_hit[elem_focus] = true;
				}

				String valid_input = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!\"\u00a3$%^&*()-_=+[{]};:'@#~,<.>/?\\| ";
	
				if (text_len < elem_input_cap[elem_focus]) {
					for (int i = 0; i < valid_input.length(); ++i) {
						if (key == valid_input.charAt(i)) {
							elem_text[elem_focus] += (char) key;
						}
					}
				}

				// tab to next element
				if (key == 9) {
					while (true) {
						elem_focus = (elem_focus + 1) % elem_cnt;
	
						if (elem_type[elem_focus] == element_type_input) {
							break;
						}

						if (elem_type[elem_focus] == element_type_input_centered) {
							return;
						}
					}
				}
			}
		}
	}

	public void display() {
		for (int i = 0; i < elem_cnt; ++i) {
			if (!elem_enabled[i]) {
				continue;
			}
			
			switch (elem_type[i]) {
			case element_type_label:
				draw_text_elem(i, elem_x[i], elem_y[i], elem_text[i], elem_font[i]);
				break;
			case element_type_label_centered:
				draw_text_elem(i, elem_x[i] - surface.text_width(elem_text[i], elem_font[i]) / 2, elem_y[i], elem_text[i], elem_font[i]);
				break;
			case element_type_rect:
				draw_box_elem(elem_x[i], elem_y[i], elem_w[i], elem_h[i]);
				break;
			case element_type_hline:
				draw_hline_elem(elem_x[i], elem_y[i], elem_w[i]);
				break;
			case element_type_static_list:
				draw_s_list_elem(i, elem_x[i], elem_y[i], elem_w[i], elem_h[i], elem_font[i], elem_entry[i], elem_entry_cnt[i], field_353[i]);
				break;
			case element_type_input:
			case element_type_input_centered:
				draw_input_elem(i, elem_x[i], elem_y[i], elem_w[i], elem_h[i], elem_text[i], elem_font[i]);
				break;
			case element_type_hlist:
				draw_hlist_elem(i, elem_x[i], elem_y[i], elem_font[i], elem_entry[i]);
				break;
			case element_type_vlist:
				draw_vlist_elem(i, elem_x[i], elem_y[i], elem_font[i], elem_entry[i]);
				break;
			case element_type_option:
				draw_option_elem(i, elem_x[i], elem_y[i], elem_w[i], elem_h[i], elem_font[i], elem_entry[i], elem_entry_cnt[i], field_353[i]);
				break;
			case element_type_container:
				draw_container_elem(elem_x[i], elem_y[i], elem_w[i], elem_h[i]);
				break;
			case element_type_sprite:
				// apparently sprite elements use the font column for
				// storing the sprite id
				draw_sprite_elem(elem_x[i], elem_y[i], elem_font[i]);
				break;
			case element_type_checkbox:
				draw_checkbox_elem(i, elem_x[i], elem_y[i], elem_w[i], elem_h[i]);
				break;
			}
		}

		click_state = 0;
	}

	protected void draw_checkbox_elem(int id, int x, int y, int w, int h) {
		surface.rect_fill(x, y, w, h, Surface.WHITE);
		surface.line_horiz(x, y, w, elem_color_b);
		surface.line_vert(x, y, h, elem_color_b);
		surface.line_horiz(x, y + h - 1, w, elem_color_a);
		surface.line_vert(x + w - 1, y, h, elem_color_a);
		
		if (elem_toggle[id] == 1) {
			for (int i = 0; i < h; ++i) {
				surface.line_horiz(x + i, y + i, 1, 0);
				surface.line_horiz(x + w - 1 - i, y + i, 1, 0);
			}
		}
	}

	protected void draw_text_elem(int id, int x, int y, String text, int font) {
		int offset = y + this.surface.text_height(font) / 3;
		text_draw(id, x, offset, text, font);
	}

	protected void text_draw(int id, int x, int y, String text, int font) {
		int color;

		if (elem_is_background[id]) {
			color = Surface.WHITE;
		} else {
			color = Surface.BLACK;
		}

		surface.text_draw(text, x, y, font, color);
	}

	protected void draw_input_elem(int id, int x, int y, int w, int h, String text, int font) {
		if (elem_text_shadowed[id]) {
			int len = text.length();
			text = "";

			for (int i = 0; i < len; ++i) {
				text = text + "X";
			}
		}

		if (elem_type[id] == element_type_input) {
			if (click_state == 1 && mouse_x >= x && mouse_y >= y - h / 2 && mouse_x <= x + w && mouse_y <= y + h / 2) {
				elem_focus = id;
			}
		} else if (elem_type[id] == element_type_input_centered) {
			if (click_state == 1 && mouse_x >= x - w / 2 && mouse_y >= y - h / 2 && mouse_x <= x + w / 2 && mouse_y <= y + h / 2) {
				elem_focus = id;
			}

			x -= surface.text_width(text, font) / 2;
		}

		if (elem_focus == id) {
			text = text + "*";
		}

		int offset = y + surface.text_height(font) / 3;
		text_draw(id, x, offset, text, font);
	}

	public void draw_box_elem(int x, int y, int w, int h) {
		surface.set_rect(x, y, x + w, y + h);
		surface.grad_rect_fill(x, y, w, h, elem_color_a, elem_color_b);
		
		// apparently draws an arrow?
		if (field_386) {
			for (int dx = x - (y & 63); dx < x + w; dx += 128) {
				for (int dy = y - (y & 31); dy < y + h; dy += 128) {
					surface.trans_sprite_plot(dx, dy, sprite_off + 6, 128);
				}
			}
		}

		surface.line_horiz(x, y, w, elem_color_b);
		surface.line_horiz(x + 1, y + 1, w - 2, elem_color_b);
		surface.line_horiz(x + 2, y + 2, w - 4, elem_color_c);
		surface.line_vert(x, y, h, elem_color_b);
		surface.line_vert(x + 1, y + 1, h - 2, elem_color_b);
		surface.line_vert(x + 2, y + 2, h - 4, elem_color_c);
		surface.line_horiz(x, y + h - 1, w, elem_color_a);
		surface.line_horiz(x + 1, y + h - 2, w - 2, elem_color_a);
		surface.line_horiz(x + 2, y + h - 3, w - 4, elem_color_d);
		surface.line_vert(x + w - 1, y, h, elem_color_a);
		surface.line_vert(x + w - 2, y + 1, h - 2, elem_color_a);
		surface.line_vert(x + w - 3, y + 2, h - 4, elem_color_d);
		surface.reset();
	}

	public void draw_container_elem(int x, int y, int w, int h) {
		surface.rect_fill(x, y, w, h, 0);
		surface.rect_draw(x, y, w, h, container_color_a);
		surface.rect_draw(x + 1, y + 1, w - 2, h - 2, container_color_b);
		surface.rect_draw(x + 2, y + 2, w - 4, h - 4, container_color_c);

		surface.sprite_plot(x, y, sprite_off + 2);
		surface.sprite_plot(x + w - 7, y, sprite_off + 3);
		surface.sprite_plot(x, y + h - 7, sprite_off + 4);
		surface.sprite_plot(x + w - 7, y + h - 7, sprite_off + 5);
	}

	protected void draw_sprite_elem(int x, int y, int id) {
		surface.sprite_plot(x, y, id);
	}

	protected void draw_hline_elem(int x, int y, int w) {
		surface.line_horiz(x, y, w, Surface.BLACK);
	}

	protected void draw_s_list_elem(int id, int x, int y, int w, int h, int font, String[] opts, int var8, int var9) {
		int text_h = h / surface.text_height(font);

		if (var9 > var8 - text_h) {
			var9 = var8 - text_h;
		}

		if (var9 < 0) {
			var9 = 0;
		}

		field_353[id] = var9;

		if (text_h < var8) {
			int dw = x + w - 12;
			int dh = (h - 27) * text_h / var8;

			if (dh < 6) {
				dh = 6;
			}

			int var13 = (h - 27 - dh) * var9 / (var8 - text_h);
			
			if (mouse_state == 1 && mouse_x >= dw && mouse_x <= dw + 12) {
				if (mouse_y > y && mouse_y < y + 12 && var9 > 0) {
					--var9;
				}

				if (mouse_y > y + h - 12 && mouse_y < y + h && var9 < var8 - text_h) {
					++var9;
				}

				field_353[id] = var9;
			}

			if (mouse_state == 1 && (mouse_x >= dw && mouse_x <= dw + 12 || mouse_x >= dw - 12 && mouse_x <= dw + 24 && field_350[id])) {
				if (mouse_y > y + 12 && mouse_y < y + h - 12) {
					field_350[id] = true;
					
					int var14 = mouse_y - y - 12 - dh / 2;
					
					var9 = var14 * var8 / (h - 24);
					
					if (var9 > var8 - text_h) {
						var9 = var8 - text_h;
					}

					if (var9 < 0) {
						var9 = 0;
					}

					field_353[id] = var9;
				}
			} else {
				field_350[id] = false;
			}

			var13 = (h - 27 - dh) * var9 / (var8 - text_h);
			draw_list_container(x, y, w, h, var13, dh);
		}

		int var11 = h - text_h * surface.text_height(font);
		int var12 = y + surface.text_height(font) * 5 / 6 + var11 / 2;

		for (int i = var9; i < var8; ++i) {
			text_draw(id, x + 2, var12, opts[i], font);
			
			var12 += surface.text_height(font) - field_391;
			
			if (var12 >= y + h) {
				return;
			}
		}
	}

	protected void draw_list_container(int x, int y, int w, int h, int corner_a, int corner_b) {
		int var7 = x + w - 12;

		surface.rect_draw(var7, y, 12, h, 0);
		surface.sprite_plot(var7 + 1, y + 1, sprite_off);
		surface.sprite_plot(var7 + 1, y + h - 12, sprite_off + 1);
		surface.line_horiz(var7, y + 13, 12, 0);
		surface.line_horiz(var7, y + h - 13, 12, 0);
		surface.grad_rect_fill(var7 + 1, y + 14, 11, h - 27, scroll_col_top, scroll_col_bottom);
		surface.rect_fill(var7 + 3, corner_a + y + 14, 7, corner_b, scroll_handle_mid);
		surface.line_vert(var7 + 2, corner_a + y + 14, corner_b, scroll_handle_left);
		surface.line_vert(var7 + 2 + 8, corner_a + y + 14, corner_b, scroll_handle_right);
	}

	protected void draw_hlist_elem(int id, int x, int y, int font, String[] opts) {
		int w = 0;
		int opts_len = opts.length;

		for (int i = 0; i < opts_len; ++i) {
			w += surface.text_width(opts[i], font);
			
			if (i < opts_len - 1) {
				w += surface.text_width("  ", font);
			}
		}

		int cw = x - w / 2;
		int h = y + surface.text_height(font) / 3;

		for (int i = 0; i < opts_len; ++i) {
			int color;
	
			if (elem_is_background[id]) {
				color = Surface.WHITE;
			} else {
				color = Surface.BLACK;
			}

			if (mouse_x >= cw && mouse_x <= cw + surface.text_width(opts[i], font) && mouse_y <= h && mouse_y > h - surface.text_height(font)) {
				if (this.elem_is_background[id]) {
					color = Surface.GRAY;
				} else {
					color = Surface.WHITE;
				}

				if (click_state == 1) {
					elem_toggle[id] = i;
					elem_hit[id] = true;
				}
			}

			if (elem_toggle[id] == i) {
				if (elem_is_background[id]) {
					color = Surface.RED;
				} else {
					color = 0xC00000;
				}
			}

			surface.text_draw(opts[i], cw, h, font, color);
			cw += surface.text_width(opts[i] + "  ", font);
		}
	}

	protected void draw_vlist_elem(int id, int x, int y, int font, String[] opts) {
		int opts_len = opts.length;
		int h = y - surface.text_height(font) * (opts_len - 1) / 2;

		for (int i = 0; i < opts_len; ++i) {
			int color;
			
			if (elem_is_background[id]) {
				color = Surface.WHITE;
			} else {
				color = Surface.BLACK;
			}

			int w = this.surface.text_width(opts[i], font);

			if (mouse_x >= x - w / 2 && mouse_x <= x + w / 2 && mouse_y - 2 <= h && mouse_y - 2 > h - surface.text_height(font)) {
				if (elem_is_background[id]) {
					color = Surface.GRAY;
				} else {
					color = Surface.WHITE;
				}

				if (click_state == 1) {
					elem_toggle[id] = i;
					elem_hit[id] = true;
				}
			}

			if (elem_toggle[id] == i) {
				if (elem_is_background[id]) {
					color = Surface.RED;
				} else {
					color = 0xC00000;
				}
			}

			surface.text_draw(opts[i], x - w / 2, h, font, color);
			h += surface.text_height(font);
		}
	}

	protected void draw_option_elem(int id, int x, int y, int w, int h, int font, String[] opts, int opt_cnt, int opt_start) {
		int display_cnt = h / surface.text_height(font);
		
		if (display_cnt < opt_cnt) {
			int right = x + w - 12;
			int var12 = (h - 27) * display_cnt / opt_cnt;
			
			if (var12 < 6) {
				var12 = 6;
			}

			int var13 = (h - 27 - var12) * opt_start / (opt_cnt - display_cnt);
			
			if (mouse_state == 1 && mouse_x >= right && mouse_x <= right + 12) {
				if (mouse_y > y && mouse_y < y + 12 && opt_start > 0) {
					--opt_start;
				}

				if (mouse_y > y + h - 12 && mouse_y < y + h && opt_start < opt_cnt - display_cnt) {
					++opt_start;
				}

				field_353[id] = opt_start;
			}

			if (mouse_state != 1 || (mouse_x < right || mouse_x > right + 12) && (mouse_x < right - 12 || mouse_x > right + 24 || !field_350[id])) {
				field_350[id] = false;
			} else if (mouse_y > y + 12 && mouse_y < y + h - 12) {
				field_350[id] = true;

				int var14 = mouse_y - y - 12 - var12 / 2;
				
				opt_start = var14 * opt_cnt / (h - 24);
				
				if (opt_start < 0) {
					opt_start = 0;
				}

				if (opt_start > opt_cnt - display_cnt) {
					opt_start = opt_cnt - display_cnt;
				}

				field_353[id] = opt_start;
			}

			var13 = (h - 27 - var12) * opt_start / (opt_cnt - display_cnt);
			draw_list_container(x, y, w, h, var13, var12);
		} else {
			opt_start = 0;
			field_353[id] = 0;
		}

		elem_hover[id] = -1;
		
		int var11 = h - display_cnt * surface.text_height(font);
		int var12 = y + surface.text_height(font) * 5 / 6 + var11 / 2;

		for (int i = opt_start; i < opt_cnt; ++i) {
			int color;
			
			if (elem_is_background[id]) {
				color = Surface.WHITE;
			} else {
				color = Surface.BLACK;
			}

			if (mouse_x >= x + 2 && mouse_x <= x + 2 + surface.text_width(opts[i], font) && mouse_y - 2 <= var12 && mouse_y - 2 > var12 - surface.text_height(font)) {
				if (elem_is_background[id]) {
					color = Surface.GRAY;
				} else {
					color = Surface.WHITE;
				}

				elem_hover[id] = i;
				
				if (click_state == 1) {
					elem_toggle[id] = i;
					elem_hit[id] = true;
				}
			}

			if (elem_toggle[id] == i && highlight_selected_opt) {
				color = Surface.RED;
			}

			surface.text_draw(opts[i], x + 2, var12, font, color);
			
			var12 += surface.text_height(font);
			
			if (var12 >= y + h) {
				return;
			}
		}
	}

	public int label_create(int x, int y, String text, int font, boolean background) {
		elem_type[elem_cnt] = element_type_label;
		elem_enabled[elem_cnt] = true;
		elem_hit[elem_cnt] = false;
		elem_font[elem_cnt] = font;
		elem_is_background[elem_cnt] = background;
		elem_x[elem_cnt] = x;
		elem_y[elem_cnt] = y;
		elem_text[elem_cnt] = text;
		return elem_cnt++;
	}

	public int center_label_create(int x, int y, String text, int font, boolean background) {
		elem_type[elem_cnt] = element_type_label_centered;
		elem_enabled[elem_cnt] = true;
		elem_hit[elem_cnt] = false;
		elem_font[elem_cnt] = font;
		elem_is_background[elem_cnt] = background;
		elem_x[elem_cnt] = x;
		elem_y[elem_cnt] = y;
		elem_text[elem_cnt] = text;
		return elem_cnt++;
	}

	public int rect_create(int x, int y, int w, int h) {
		elem_type[elem_cnt] = element_type_rect;
		elem_enabled[elem_cnt] = true;
		elem_hit[elem_cnt] = false;
		elem_x[elem_cnt] = x - w / 2;
		elem_y[elem_cnt] = y - h / 2;
		elem_w[elem_cnt] = w;
		elem_h[elem_cnt] = h;
		return elem_cnt++;
	}

	public int container_create(int x, int y, int w, int h) {
		elem_type[elem_cnt] = element_type_container;
		elem_enabled[elem_cnt] = true;
		elem_hit[elem_cnt] = false;
		elem_x[elem_cnt] = x - w / 2;
		elem_y[elem_cnt] = y - h / 2;
		elem_w[elem_cnt] = w;
		elem_h[elem_cnt] = h;
		return elem_cnt++;
	}

	public int sprite_create(int x, int y, int id) {
		int w = surface.sprite_width[id];
		int h = surface.sprite_height[id];
		
		elem_type[elem_cnt] = element_type_container;
		elem_enabled[elem_cnt] = true;
		elem_hit[elem_cnt] = false;
		elem_x[elem_cnt] = x - w / 2;
		elem_y[elem_cnt] = y - h / 2;
		elem_w[elem_cnt] = w;
		elem_h[elem_cnt] = h;
		elem_font[elem_cnt] = id;
		return elem_cnt++;
	}

	public int static_list_create(int x, int y, int w, int h, int font, int cap, boolean background) {
		elem_type[elem_cnt] = element_type_static_list;
		elem_enabled[elem_cnt] = true;
		elem_hit[elem_cnt] = false;
		elem_x[elem_cnt] = x;
		elem_y[elem_cnt] = y;
		elem_w[elem_cnt] = w;
		elem_h[elem_cnt] = h;
		elem_is_background[elem_cnt] = background;
		elem_font[elem_cnt] = font;
		elem_input_cap[elem_cnt] = cap;
		elem_entry_cnt[elem_cnt] = 0;
		field_353[elem_cnt] = 0;
		elem_entry[elem_cnt] = new String[cap];
		return elem_cnt++;
	}

	public int input_create(int x, int y, int w, int h, int font, int cap, boolean shadowed, boolean background) {
		elem_type[elem_cnt] = element_type_input;
		elem_enabled[elem_cnt] = true;
		elem_text_shadowed[elem_cnt] = shadowed;
		elem_hit[elem_cnt] = false;
		elem_font[elem_cnt] = font;
		elem_is_background[elem_cnt] = background;
		elem_x[elem_cnt] = x;
		elem_y[elem_cnt] = y;
		elem_w[elem_cnt] = w;
		elem_h[elem_cnt] = h;
		elem_input_cap[elem_cnt] = cap;
		elem_text[elem_cnt] = "";
		return elem_cnt++;
	}

	public int center_input_create(int x, int y, int w, int h, int font, int cap, boolean shadowed, boolean background) {
		elem_type[elem_cnt] = element_type_input_centered;
		elem_enabled[elem_cnt] = true;
		elem_text_shadowed[elem_cnt] = shadowed;
		elem_hit[elem_cnt] = false;
		elem_font[elem_cnt] = font;
		elem_is_background[elem_cnt] = background;
		elem_x[elem_cnt] = x;
		elem_y[elem_cnt] = y;
		elem_w[elem_cnt] = w;
		elem_h[elem_cnt] = h;
		elem_input_cap[elem_cnt] = cap;
		elem_text[elem_cnt] = "";
		return elem_cnt++;
	}

	public int list_create(int x, int y, String[] entries, int font, boolean background) {
		elem_type[elem_cnt] = element_type_vlist;
		elem_enabled[elem_cnt] = true;
		elem_hit[elem_cnt] = false;
		elem_font[elem_cnt] = font;
		elem_is_background[elem_cnt] = background;
		elem_x[elem_cnt] = x;
		elem_y[elem_cnt] = y;
		elem_entry[elem_cnt] = entries;
		elem_toggle[elem_cnt] = 0;
		return elem_cnt++;
	}

	public int option_create(int x, int y, int w, int h, int font, int cap, boolean background) {
		elem_type[elem_cnt] = element_type_option;
		elem_enabled[elem_cnt] = true;
		elem_hit[elem_cnt] = false;
		elem_font[elem_cnt] = font;
		elem_is_background[elem_cnt] = background;
		elem_x[elem_cnt] = x;
		elem_y[elem_cnt] = y;
		elem_w[elem_cnt] = w;
		elem_h[elem_cnt] = h;
		elem_input_cap[elem_cnt] = cap;
		elem_entry[elem_cnt] = new String[cap];
		elem_entry_cnt[elem_cnt] = 0;
		field_353[elem_cnt] = 0;
		elem_toggle[elem_cnt] = -1;
		elem_hover[elem_cnt] = -1;
		return elem_cnt++;
	}

	public int button_create(int x, int y, int w, int h) {
		elem_type[elem_cnt] = element_type_button;
		elem_enabled[elem_cnt] = true;
		elem_hit[elem_cnt] = false;
		elem_x[elem_cnt] = x - w / 2;
		elem_y[elem_cnt] = y - h / 2;
		elem_w[elem_cnt] = w;
		elem_h[elem_cnt] = h;
		return elem_cnt++;
	}

	public int checkbox_create(int x, int y, int size) {
		elem_type[elem_cnt] = element_type_checkbox;
		elem_enabled[elem_cnt] = true;
		elem_hit[elem_cnt] = false;
		elem_x[elem_cnt] = x - size / 2;
		elem_y[elem_cnt] = y - size / 2;
		elem_w[elem_cnt] = size;
		elem_h[elem_cnt] = size;
		return elem_cnt++;
	}

	public void clear_entry(int id) {
		elem_entry_cnt[id] = 0;
	}

	public void reset_list(int id) {
		field_353[id] = 0;
		elem_hover[id] = -1;
	}

	public void entry_set(int id, int pos, String entry) {
		elem_entry[id][pos] = entry;
		
		if (pos + 1 > elem_entry_cnt[id]) {
			elem_entry_cnt[id] = pos + 1;
		}
	}

	public void entry_add(int id, String entry, boolean var3) {
		int cnt = elem_entry_cnt[id]++;
		
		if (cnt >= elem_input_cap[id]) {
			cnt -= 1;
			elem_entry_cnt[id] -= 1;

			for (int i = 0; i < cnt; ++i) {
				elem_entry[id][i] = elem_entry[id][i + 1];
			}
		}

		elem_entry[id][cnt] = entry;
		
		if (var3) {
			field_353[id] = 999999;
		}
	}

	public void set_text(int id, String text) {
		elem_text[id] = text;
	}

	public String get_text(int id) {
		return elem_text[id] == null ? "null" : elem_text[id];
	}

	public void enable(int id) {
		elem_enabled[id] = true;
	}

	public void disable(int id) {
		elem_enabled[id] = false;
	}

	public void set_focus(int id) {
		elem_focus = id;
	}

	public int is_toggled(int id) {
		return elem_toggle[id];
	}

	public int is_hover(int id) {
		return elem_hover[id];
	}

	public void set_toggle(int id, int toggle) {
		elem_toggle[id] = toggle;
	}
}
