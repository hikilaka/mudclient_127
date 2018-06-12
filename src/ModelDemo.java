

import java.awt.Graphics;
import java.io.IOException;

import jagex.DataUtil;
import jagex.client.Game;
import jagex.client.Model;
import jagex.client.Scene;
import jagex.client.Surface;

@SuppressWarnings("serial")
public final class ModelDemo extends Game {

	public static void main(String[] args) {
		ModelDemo demo = new ModelDemo("Model demo", 600, 500);
		demo.show();
	}
	
	private final String title;

	private final int width, height;
			
	private final Surface screen;
	
	private final Scene scene;

	private Graphics gfx;
	
	int ticks;
	int last_x, last_y = -25;
		
	int cam_x = 0, cam_y = 0, cam_z = 0;
	int cam_yaw = 0, cam_pitch = 0, cam_dist = 150;
	
	private final Model[] models = new Model[200];
	private Model cur_model;
	private int current_model = 0;
	
	private int texture_buffer_off = 2510;
	private int texture_sprite_off = 2520;
	
	private ModelDemo(String title, int width, int height) {
		this.title = title;
		this.width = width;
		this.height = height;
		screen = new Surface(width, height + 12, 2700, this);
		screen.set_rect(0, 0, width, height + 12);
		scene = new Scene(screen, 15000, 15000, 1000);
	}
	
	@Override
	public void show() {
		start(width, height, title, false);
	}

	@Override
	public void load_game() {
		gfx = getGraphics();
		
		unpack_config();
		unpack_textures();
		unpack_models();
		
		scene.set_light(56, 32, -10, -10, -10);
        scene.set_bounds(width / 2, height / 2, width / 2, height / 2, width, 9);
		scene.set_camera(cam_x, cam_y, cam_z, cam_yaw, cam_pitch, 0, cam_dist);
		scene.clip_far_3d = 2400;
		scene.clip_far_2d = 2400;
		scene.fog_falloff = 1;
		scene.fog_distance = 2300;
		set_rate(60);
	}

	@Override
	public void update() {
		switch (pressed_key) {
		case 32: // space
			int yaw = 0;
			int pitch = 0;
			if (mouse_x != last_x) {
				pitch = mouse_x - last_x;
				last_x = mouse_x;
			}
			if (mouse_y != last_y) {
				yaw = mouse_y - last_y;
				last_y = mouse_y;
			}
			yaw %= 256;
			pitch %= 256;
			for (int i = 0; i < models.length; i++) {
				if (models[i] == null) continue;
				models[i].rotate(yaw, -pitch, 0);
			}
			break;
		case 99: // c
			scene.set_camera(cam_x, cam_y, cam_z, cam_yaw, -cam_pitch, 0, --cam_dist);
			break;
		case 100: // d
			scene.set_camera(cam_x, cam_y, cam_z, cam_yaw, -cam_pitch, 0, ++cam_dist);
			break;
		case 1004: // up
			scene.set_camera(cam_x, cam_y, ++cam_z, cam_yaw, -cam_pitch, 0, cam_dist);
			break;
		case 1005: // down
			scene.set_camera(cam_x, cam_y, --cam_z, cam_yaw, -cam_pitch, 0, cam_dist);
			break;
		case 1006: // left
			scene.set_camera(--cam_x, cam_y, cam_z, cam_yaw, -cam_pitch, 0, cam_dist);
			break;
		case 1007: // right
			scene.set_camera(++cam_x, cam_y, cam_z, cam_yaw, -cam_pitch, 0, cam_dist);
			break;
		}
		
		if (pressed_key != 32 && mouse_state != 0) { // space
			if (mouse_x != last_x) {
				cam_pitch += (mouse_x - last_x) / 3;
				last_x = mouse_x;
			}
			if (mouse_y != last_y) {
				cam_yaw += mouse_y - last_y;
				last_y = mouse_y;
			}
			//cam_yaw %= 0xFF;
			//cam_pitch %= 0xFF;
			scene.set_camera(cam_x, cam_y, cam_z, cam_yaw, -cam_pitch, 0, cam_dist);
		}
	}

	@Override
	public void render() {
		screen.rect_fill(0, 0, width, height, Surface.DARK_GRAY);
		scene.render();
		
		draw_sys_info();
		screen.center_text_draw(Config.obj_name[current_model], width / 2, 20, Surface.FONT_BOLD, Surface.ORANGE);
		screen.center_text_draw(Config.obj_desc[current_model], width / 2, 35, Surface.FONT_BOLD, Surface.ORANGE);
		
		screen.copy(gfx, 0, 0);
		screen.clear();
	}
	
	private void draw_sys_info() {
		Runtime r = Runtime.getRuntime();
		int total = (int) (r.totalMemory() / 1024L / 1024L);
		int avail = (int) ((r.totalMemory() - r.freeMemory()) / 1024L / 1024L);

		int y = 15;
		screen.text_draw("fps: " + fps, 10, y, Surface.FONT_BOLD, Surface.YELLOW);
		y += screen.text_height(Surface.FONT_BOLD);
		screen.text_draw("mem: " + avail + "mb/" + total + "mb", 10, y, Surface.FONT_BOLD, Surface.YELLOW);
	}
	
	@Override
	public void on_key(int code) {
		if (code == 113) {
			load_next_model();
		}
	}

	@Override
	public void on_click(int state, int x, int y) {
	}
	
	private void load_next_model() {
		if (cur_model != null) {
			scene.remove(cur_model);
			current_model += 1;
		}
		if (current_model >= Config.obj_cnt) {
			current_model = 0;
		}
		
		cur_model = models[Config.obj_model[current_model]];
		
		if (cur_model == null) {
			System.out.println("null model for " + current_model);
			return;
		}
		
		cur_model.scale(50, 50, 50);
		scene.add(cur_model);
		cur_model.position(0, 30, -10);
	}
	
	private void unpack_config() {
		try {
			byte[] archive = load_file("release/config" + Version.config + ".jag", "Configuration", 10);
			Config.decode(archive, true);
		} catch (IOException error) {
			System.out.println("Load error:" + error);
		}
	}
	
	private void unpack_textures() {
		byte[] archive = null;

		try {
			archive = load_file("release/textures" + Version.textures + ".jag", "Textures", 50);
		} catch (IOException error) {
			System.out.println("Load error:" + error);
		}

		byte[] idx_buf = DataUtil.entry_extract("index.dat", 0, archive);

		scene.texture_allocate(Config.texture_cnt, 7, 11);

		for (int i = 0; i < Config.texture_cnt; ++i) {
			String texture_name = Config.texture_name[i];
			byte[] data_buf = DataUtil.entry_extract(texture_name + ".dat", 0, archive);
			
			screen.sprite_define(texture_buffer_off, data_buf, idx_buf, 1);
			screen.rect_fill(0, 0, 128, 128, Surface.MAGENTA);
			screen.sprite_plot(0, 0, texture_buffer_off);
			
			int mask_w = screen.sprite_mask_w[texture_buffer_off];
			String type = Config.texture_type[i];
	
			if (type != null && type.length() > 0) {
				data_buf = DataUtil.entry_extract(type + ".dat", 0, archive);
				screen.sprite_define(texture_buffer_off, data_buf, idx_buf, 1);
				screen.sprite_plot(0, 0, texture_buffer_off);
			}

			screen.row_sprite_define(texture_sprite_off + i, 0, 0, mask_w, mask_w);

			int pixel_len = mask_w * mask_w;

			for (int j = 0; j < pixel_len; ++j) {
				if (screen.sprite_pixels[texture_sprite_off + i][j] == Surface.GREEN) {
					screen.sprite_pixels[texture_sprite_off + i][j] = Surface.MAGENTA;
				}
			}

			screen.sprite_posterize(texture_sprite_off + i);
			scene.texture_define(i, screen.sprite_raster[texture_sprite_off + i], screen.sprite_palette[texture_sprite_off + i], mask_w / 64 - 1);
		}
	}
	
	private void unpack_models() {
		Config.model_lookup("torcha2");
		Config.model_lookup("torcha3");
		Config.model_lookup("torcha4");
		Config.model_lookup("skulltorcha2");
		Config.model_lookup("skulltorcha3");
		Config.model_lookup("skulltorcha4");
		Config.model_lookup("firea2");
		Config.model_lookup("firea3");
		Config.model_lookup("fireplacea2");
		Config.model_lookup("fireplacea3");
		
		if (!is_applet()) {
			byte[] models_archive = null;

			try {
				models_archive = load_file("release/models" + Version.models + ".jag", "3d models", 60);
			} catch (IOException error) {
				System.out.println("Load error:" + error);
			}

			for (int i = 0; i < Config.model_count; ++i) {
				int offset = DataUtil.entry_offset(Config.model_name[i] + ".ob3", models_archive);

				if (offset != 0) {
					models[i] = new Model(models_archive, offset, true);
				} else {
					models[i] = new Model(1, 1);
				}

				if (Config.model_name[i].equals("giantcrystal")) {
					models[i].trans = true;
				}
			}
		} else {
			set_resource_loading_bar(70, "Loading 3d models");

			for (int i = 0; i < Config.model_count; ++i) {
				models[i] = new Model("../gamedata/models/" + Config.model_name[i] + ".ob2");

				if (Config.model_name[i].equals("giantcrystal")) {
					models[i].trans = true;
				}
			}
		}
	}

	@Override
	public void cleanup() { }
	@Override
	public void preload_render() { }
}
