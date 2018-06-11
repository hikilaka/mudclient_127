import java.applet.Applet;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.math.BigInteger;
import java.net.InetAddress;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.imageio.ImageIO;

import jagex.DataUtil;
import jagex.client.AudioStream;
import jagex.client.Menu;
import jagex.client.Model;
import jagex.client.MultiplayerGame;
import jagex.client.Scene;
import jagex.client.Surface;
import jagex.client.Connection;

public class mudclient extends MultiplayerGame {
	public boolean is_members = false;

	public static String cache_dir = "";

	public BigInteger rsa_exponent = new BigInteger("18439792161837834709");

	public BigInteger rsa_modulus = new BigInteger("192956484481579778191558061814292671521");

	int field_178;

	boolean field_179 = false;

	boolean field_180 = false;

	public boolean normal_user = true;

	int ticks;

	int field_183 = 12345678;

	int field_184;

	int field_185 = 8000;

	int[] field_186;

	int[] field_187;

	int field_188;

	int[] field_189;

	int[] field_190;

	int field_191;

	int field_192;

	int field_193;

	int field_194;

	int field_195;

	Graphics graphics;

	Scene scene;

	Screen screen;

	int field_199;

	int field_200;

	int field_201;

	int wnd_width;

	int wnd_height;

	int view_distance;

	int ui_sprite_off;

	int menu_sprite_off;

	int item_sprite_off;

	int proj_sprite_off;

	int texture_buffer_off;
	int texture_sprite_off;
	int bab;
	int cab;
	int dab;
	int eab;
	int fab;
	int gab;
	int hab;
	int iab;
	int jab;
	Terrain terrian;
	int lab;
	int mab;
	int nab;
	int oab;
	int pab;
	int qab;
	int rab;
	int sab;
	int tab;
	int uab;
	int vab;
	int wab;
	int xab;
	int yab;
	int zab;
	boolean abb;
	int bbb;
	int cbb;
	int dbb;
	int ebb;
	int fbb;
	int gbb;
	int hbb;
	int ibb;
	int jbb;
	int kbb;
	int lbb;
	Mob[] mbb;
	Mob[] nbb;
	Mob[] obb;
	Mob pbb;
	int qbb;
	int rbb;
	int sbb;
	int tbb;
	int ubb;
	int vbb;
	int wbb;
	Mob[] xbb;
	Mob[] ybb;
	Mob[] zbb;
	int[] acb;
	int bcb;
	int ccb;
	int[] dcb;
	int[] ecb;
	int[] fcb;
	int[] gcb;
	int hcb;
	int icb;
	Model[] jcb;
	int[] kcb;
	int[] lcb;
	int[] mcb;
	int[] ncb;
	Model[] models;
	boolean[] pcb;
	int qcb;
	int rcb;
	Model[] scb;
	int[] tcb;
	int[] ucb;
	int[] vcb;
	int[] wcb;
	boolean[] xcb;
	int ycb;
	int zcb;
	int adb;
	int[] bdb;
	int[] cdb;
	int[] ddb;
	int edb;
	String fdb;
	int[] exp_steps;
	int[] hdb;
	int[] idb;
	int[] jdb;
	int[] kdb;
	int ldb;
	String[] mdb;
	String[] ndb;
	Menu odb;
	int pdb;
	int qdb;
	int rdb;
	Menu sdb;
	int tdb;
	int udb;
	long vdb;
	Menu wdb;
	int xdb;
	int ydb;
	int zdb;
	String[] aeb;
	boolean[] beb;
	boolean[] ceb;
	boolean deb;
	boolean eeb;
	boolean feb;
	boolean geb;
	boolean heb;
	int ieb;
	int jeb;
	int keb;
	int leb;
	int meb;
	int neb;
	String[] oeb;
	String[] peb;
	int[] qeb;
	int[] reb;
	int[] seb;
	int[] teb;
	int[] ueb;
	int[] veb;
	int[] web;
	int xeb;
	int yeb;
	int zeb;
	int afb;
	Menu bfb;
	int cfb;
	int dfb;
	int efb;
	int ffb;
	int gfb;
	int hfb;
	String[] ifb;
	int[] jfb;
	boolean kfb;
	String lfb;
	int mfb;
	int[] nfb;
	int[] ofb;
	int pfb;
	int[] qfb;
	int[] rfb;
	boolean sfb;
	boolean tfb;
	boolean ufb;
	boolean vfb;
	boolean wfb;
	boolean xfb;
	boolean yfb;
	boolean zfb;
	long agb;
	int bgb;
	int[] cgb;
	int[] dgb;
	int egb;
	int[] fgb;
	int[] ggb;
	int hgb;
	int igb;
	int jgb;
	int kgb;
	boolean lgb;
	String mgb;
	int ngb;
	int[] ogb;
	int[] pgb;
	int qgb;
	int[] rgb;
	int[] sgb;
	boolean tgb;
	boolean ugb;
	int vgb;
	int wgb;
	long xgb;
	boolean ygb;
	boolean zgb;
	int ahb;
	int[] bhb;
	int[] chb;
	int dhb;
	int[] ehb;
	int[] fhb;
	boolean ghb;
	int hhb;
	int ihb;
	int[] jhb;
	int[] khb;
	int[] lhb;
	int mhb;
	int nhb;
	boolean ohb;
	int phb;
	int[] qhb;
	int[] rhb;
	int shb;
	int[] thb;
	int[] uhb;
	int vhb;
	int whb;
	int xhb;
	int yhb;
	boolean zhb;
	int aib;
	String[] bib;
	int cib;
	int dib;
	int eib;
	String fib;
	String gib;
	boolean logged_in;
	boolean iib;
	int jib;
	String kib;
	int lib;
	int mib;
	int nib;
	boolean oib;
	String pib;
	int logout_timeout;
	int rib;
	int sib;
	int tib;
	boolean uib;
	int ui_state;
	Menu welcome_ui;
	int xib;
	int yib;
	Menu register_ui;
	int register_status_field_id;
	int bjb;
	int cjb;
	int djb;
	int ejb;
	int fjb;
	int gjb;
	int hjb;
	Menu login_ui;
	int login_status_field_id;
	int kjb;
	int ljb;
	int mjb;
	int njb;
	int ojb;
	int pjb;
	int qjb;
	String rjb;
	String sjb;
	String tjb;
	String ujb;
	Menu vjb;
	int wjb;
	int xjb;
	int yjb;
	int zjb;
	int akb;
	int bkb;
	int ckb;
	int dkb;
	int ekb;
	int fkb;
	int gkb;
	int hkb;
	int ikb;
	int jkb;
	int kkb;
	boolean lkb;
	Menu mkb;
	int nkb;
	int okb;
	int pkb;
	int[] qkb;
	int[] rkb;
	int[] skb;
	int[] tkb;
	int[] ukb;
	String[] vkb;
	boolean wkb;
	Menu recovery_ui;
	int ykb;
	int zkb;
	int alb;
	int blb;
	int clb;
	int dlb;
	int elb;
	int flb;
	int glb;
	int hlb;
	int[] ilb;
	int[] jlb;
	int klb;
	String[] llb;
	int[] mlb;
	int[] nlb;
	int[] olb;
	int[] plb;
	int qlb;
	int[] rlb;
	int[] slb;
	int[] tlb;
	int[] ulb;
	int vlb;
	int[] wlb;
	int[] xlb;
	int[] ylb;
	int zlb;
	int amb;
	int[][] bmb;
	boolean cmb;
	int dmb;
	int emb;
	int fmb;
	int gmb;
	int hmb;
	int imb;
	int jmb;
	int kmb;
	public int[] lmb;
	public int[] mmb;
	public int[] nmb;
	int[] omb;
	int[] pmb;
	int[] qmb;
	byte[] sound_archive;
	AudioStream audio_stream;
	int tmb;
	int[] umb;
	int[] vmb;
	int[] wmb;
	int[] xmb;
	String[] ymb;

	public static void main(String[] var0) {
		cache_dir = "release/";
		
		mudclient client = new mudclient();
		client.normal_user = false;
		client.start(client.wnd_width, client.wnd_height + 11, "Runescape by Andrew Gower", false);
		client.min_delta = 10;
	}

	@Override
	public void load_game() {
		set_rsa_key(rsa_exponent, rsa_modulus);
		int accum = 0;

		int next;
		int var4;

		for (int i = 0; i < 99; ++i) {
			next = i + 1;
			var4 = (int) ((double) next + 300.0D * Math.pow(2.0D, (double) next / 7.0D));
			accum += var4;
			exp_steps[i] = (accum & 0xFFFFFFC);
		}

		String var8;
		try {
			var8 = this.getParameter("member");
			var4 = Integer.parseInt(var8);
			if (var4 == 1) {
				this.is_members = true;
			}
		} catch (Exception var6) {
			;
		}

		if (!this.normal_user) {
			this.is_members = true;
		}

		super.server_port = 43594;
		super.mouse_y_offset = 0;
		MultiplayerGame.time_out = 1000;
		MultiplayerGame.version = Version.game;

		try {
			var8 = this.getParameter("poff");
			int port_offset = Integer.parseInt(var8);
			super.server_port += port_offset;
			System.out.println("Offset: " + port_offset);
		} catch (Exception var5) {
			;
		}

		unpack_config();
		ui_sprite_off = 2000;
		menu_sprite_off = ui_sprite_off + 100;
		item_sprite_off = menu_sprite_off + 50;
		proj_sprite_off = item_sprite_off + 300;
		texture_buffer_off = 2510;
		texture_sprite_off = texture_buffer_off + 10;
		graphics = getGraphics();
		set_rate(50);
		screen = new Screen(wnd_width, wnd_height + 12, 2700, this);
		screen.client = this;
		screen.set_rect(0, 0, wnd_width, wnd_height + 12);
		
		Menu.field_386 = false;
		Menu.sprite_off = menu_sprite_off;
		odb = new Menu(screen, 5);
		next = screen.width - 199;
		byte var9 = 36;
		pdb = odb.option_create(next, var9 + 24, 196, 90, 1, 500, true);
		sdb = new Menu(screen, 5);
		tdb = sdb.option_create(next, var9 + 40, 196, 126, 1, 500, true);
		wdb = new Menu(screen, 5);
		xdb = wdb.option_create(next, var9 + 24, 196, 226, 1, 500, true);
		unpack_media();
		unpack_entities();
		scene = new Scene(screen, 15000, 15000, 1000);
		scene.set_bounds(wnd_width / 2, wnd_height / 2, wnd_width / 2, wnd_height / 2, wnd_width, view_distance);
		scene.clip_far_3d = 2400;
		scene.clip_far_2d = 2400;
		scene.fog_falloff = 1;
		scene.fog_distance = 2300;
		scene.set_light(-50, -10, -50);
		terrian = new Terrain(scene, screen);
		terrian.sprite_offset = ui_sprite_off;
		
		unpack_textures();
		unpack_models();
		unpack_terrain();
		
		if (is_members) {
			unpack_sounds();
		}

		set_resource_loading_bar(100, "Starting game...");
		this.method_174();
		this.prepare_ui();
		this.method_184();
		this.method_180();
		this.method_183();
		this.method_176();
		preload_render();
		this.method_189();
	}
	
	@Override
	public void preload_render() {
		
	}

	public void unpack_config() {
		try {
			byte[] archive = load_file(cache_dir + "config" + Version.config + ".jag", "Configuration", 10);
			Config.decode(archive, is_members);
		} catch (IOException error) {
			System.out.println("Load error:" + error);
		}
	}

	public void unpack_media() {
		byte[] archive = null;

		try {
			archive = load_file(cache_dir + "media" + Version.media + ".jag", "2d graphics", 20);
		} catch (IOException var8) {
			System.out.println("Load error:" + var8);
		}

		byte[] index = DataUtil.entry_extract("index.dat", 0, archive);

		screen.sprite_define(ui_sprite_off, DataUtil.entry_extract("inv1.dat", 0, archive), index, 1);
		screen.sprite_define(ui_sprite_off + 1, DataUtil.entry_extract("inv2.dat", 0, archive), index, 6);
		screen.sprite_define(ui_sprite_off + 9, DataUtil.entry_extract("bubble.dat", 0, archive), index, 1);
		screen.sprite_define(ui_sprite_off + 10, DataUtil.entry_extract("runescape.dat", 0, archive), index, 1);
		screen.sprite_define(ui_sprite_off + 11, DataUtil.entry_extract("splat.dat", 0, archive), index, 3);
		screen.sprite_define(ui_sprite_off + 14, DataUtil.entry_extract("icon.dat", 0, archive), index, 8);
		screen.sprite_define(ui_sprite_off + 22, DataUtil.entry_extract("hbar.dat", 0, archive), index, 1);
		screen.sprite_define(ui_sprite_off + 23, DataUtil.entry_extract("hbar2.dat", 0, archive), index, 1);
		screen.sprite_define(ui_sprite_off + 24, DataUtil.entry_extract("compass.dat", 0, archive), index, 1);
		screen.sprite_define(ui_sprite_off + 25, DataUtil.entry_extract("buttons.dat", 0, archive), index, 2);
		screen.sprite_define(menu_sprite_off, DataUtil.entry_extract("scrollbar.dat", 0, archive), index, 2);
		screen.sprite_define(menu_sprite_off + 2, DataUtil.entry_extract("corners.dat", 0, archive), index, 4);
		screen.sprite_define(menu_sprite_off + 6, DataUtil.entry_extract("arrows.dat", 0, archive), index, 2);
		screen.sprite_define(proj_sprite_off, DataUtil.entry_extract("projectile.dat", 0, archive), index, Config.proj_sprite_cnt);
		
		int item_sprite_cnt = Config.item_max_sprite;
		int cnt;
		
		for (int i = 1; item_sprite_cnt > 0; ++i) {
			cnt = item_sprite_cnt;
			item_sprite_cnt -= 30;
			if (cnt > 30) {
				cnt = 30;
			}

			screen.sprite_define(item_sprite_off + (i - 1) * 30, DataUtil.entry_extract("objects" + i + ".dat", 0, archive), index, cnt);
		}

		screen.sprite_resolve(ui_sprite_off);
		screen.sprite_resolve(ui_sprite_off + 9);

		for (int k = 11; k <= 26; k++) {
			screen.sprite_resolve(ui_sprite_off + k);
		}

		for (int k = 0; k < Config.proj_sprite_cnt; k++) {
			screen.sprite_resolve(proj_sprite_off + k);
		}

		for (int k = 0; k < Config.item_max_sprite; k++) {
			screen.sprite_resolve(item_sprite_off + k);
		}
	}

	public void unpack_entities() {
		byte[] var1 = null;

		try {
			var1 = this.load_file(cache_dir + "entity" + Version.entity + ".jag", "people and monsters", 30);
		} catch (IOException var13) {
			System.out.println("Load error:" + var13);
		}

		byte[] var14 = DataUtil.entry_extract("index.dat", 0, var1);
		byte[] var3 = null;
		byte[] var4 = null;
		if (this.is_members) {
			try {
				var3 = this.load_file(cache_dir + "entity" + Version.entity + ".mem", "member graphics", 45);
			} catch (IOException var12) {
				System.out.println("Load error:" + var12);
			}

			var4 = DataUtil.entry_extract("index.dat", 0, var3);
		}

		int var6 = 0;
		this.zlb = 0;
		this.amb = this.zlb;

		label84: for (int i = 0; i < Config.anim_cnt; ++i) {
			String var8 = Config.anim_name[i];

			for (int var9 = 0; var9 < i; ++var9) {
				if (Config.anim_name[var9].equalsIgnoreCase(var8)) {
					Config.anim_unknown2[i] = Config.anim_unknown2[var9];
					continue label84;
				}
			}

			byte[] var10 = DataUtil.entry_extract(var8 + ".dat", 0, var1);
			byte[] var5 = var14;
			if (var10 == null && this.is_members) {
				var10 = DataUtil.entry_extract(var8 + ".dat", 0, var3);
				var5 = var4;
			}

			if (var10 != null) {
				this.screen.sprite_define(this.amb, var10, var5, 15);
				var6 += 15;
				byte[] var11;
				if (Config.anim_has_a[i] == 1) {
					var11 = DataUtil.entry_extract(var8 + "a.dat", 0, var1);
					var5 = var14;
					if (var11 == null && this.is_members) {
						var11 = DataUtil.entry_extract(var8 + "a.dat", 0, var3);
						var5 = var4;
					}

					this.screen.sprite_define(this.amb + 15, var11, var5, 3);
					var6 += 3;
				}

				if (Config.anim_has_f[i] == 1) {
					var11 = DataUtil.entry_extract(var8 + "f.dat", 0, var1);
					var5 = var14;
					if (var11 == null && this.is_members) {
						var11 = DataUtil.entry_extract(var8 + "f.dat", 0, var3);
						var5 = var4;
					}

					this.screen.sprite_define(this.amb + 18, var11, var5, 9);
					var6 += 9;
				}

				if (Config.anim_unknown1[i] != 0) {
					for (int var15 = this.amb; var15 < this.amb + 27; ++var15) {
						this.screen.sprite_resolve(var15);
					}
				}
			}

			Config.anim_unknown2[i] = this.amb;
			this.amb += 27;
		}

		System.out.println("Loaded: " + var6 + " frames of animation");
	}


	public void unpack_textures() {
		byte[] archive = null;

		try {
			archive = load_file(cache_dir + "textures" + Version.textures + ".jag", "Textures", 50);
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

	public void unpack_models() {
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
				models_archive = load_file(cache_dir + "models" + Version.models + ".jag", "3d models", 60);
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


	public void unpack_terrain() {
		try {
			terrian.map_archive = load_file(cache_dir + "maps" + Version.field_395 + ".jag", "map", 70);
			
			if (is_members) {
				terrian.mem_map_archive = load_file(cache_dir + "maps" + Version.field_395 + ".mem", "members map", 75);
			}

			terrian.land_archive = this.load_file(cache_dir + "land" + Version.field_395 + ".jag", "landscape", 80);

			if (is_members) {
				terrian.mem_land_archive = this.load_file(cache_dir + "land" + Version.field_395 + ".mem", "members landscape", 85);
			}
		} catch (IOException error) {
			System.out.println("Load error:" + error);
		}
	}


	public void unpack_sounds() {
		try {
			sound_archive = load_file(cache_dir + "sounds" + Version.field_400 + ".mem", "Sound effects", 90);
			audio_stream = new AudioStream();
		} catch (Throwable var2) {
			System.out.println("Unable to init sounds:" + var2);
		}
	}


	public void method_174() {
		this.bfb = new Menu(this.screen, 10);
		this.cfb = this.bfb.static_list_create(5, 269, 502, 56, 1, 20, true);
		this.dfb = this.bfb.input_create(7, 324, 498, 14, 1, 80, false, true);
		this.efb = this.bfb.static_list_create(5, 269, 502, 56, 1, 20, true);
		this.ffb = this.bfb.static_list_create(5, 269, 502, 56, 1, 20, true);
		this.bfb.set_focus(this.dfb);
	}


	@Override
	public synchronized void update() {
		if (!this.field_179) {
			if (!this.field_180) {
				try {
					++this.ticks;
					if (this.field_201 == 0) {
						super.idle_counter = 0;
						this.method_190();
					}

					if (this.field_201 == 1) {
						++super.idle_counter;
						this.method_191();
					}

					super.click_state = 0;
					super.typed_key = 0;
					++this.field_195;
					if (this.field_195 > 500) {
						this.field_195 = 0;
						int var1 = (int) (Math.random() * 4.0D);
						if ((var1 & 1) == 1) {
							this.field_191 += this.field_192;
						}

						if ((var1 & 2) == 2) {
							this.field_193 += this.field_194;
						}
					}

					if (this.field_191 < -50) {
						this.field_192 = 2;
					}

					if (this.field_191 > 50) {
						this.field_192 = -2;
					}

					if (this.field_193 < -50) {
						this.field_194 = 2;
					}

					if (this.field_193 > 50) {
						this.field_194 = -2;
					}

					if (this.xeb > 0) {
						--this.xeb;
					}

					if (this.yeb > 0) {
						--this.yeb;
					}

					if (this.zeb > 0) {
						--this.zeb;
					}

					if (this.afb > 0) {
						--this.afb;
						return;
					}
				} catch (OutOfMemoryError var2) {
					this.method_175();
					this.field_180 = true;
				}

			}
		}
	}

	@Override
	public synchronized void render() {
		Graphics var1;
		if (this.field_179) {
			var1 = this.getGraphics();
			var1.setColor(Color.black);
			var1.fillRect(0, 0, 512, 356);
			var1.setFont(new Font("Helvetica", 1, 20));
			var1.setColor(Color.white);
			var1.drawString("Error - unable to load game!", 50, 50);
			var1.drawString("To play RuneScape make sure you play from", 50, 100);
			var1.drawString("http://www.runescape.com", 50, 150);
			this.set_rate(1);
		} else if (this.field_180) {
			var1 = this.getGraphics();
			var1.setColor(Color.black);
			var1.fillRect(0, 0, 512, 356);
			var1.setFont(new Font("Helvetica", 1, 20));
			var1.setColor(Color.white);
			var1.drawString("Error - out of memory!", 50, 50);
			var1.drawString("Close ALL unnecessary programs", 50, 100);
			var1.drawString("and windows before loading the game", 50, 150);
			var1.drawString("RuneScape needs about 48meg of spare RAM", 50, 200);
			this.set_rate(1);
		} else {
			try {
				if (this.field_201 == 0) {
					this.screen.logged_in = false;
					this.pregame_display();
				}

				if (this.field_201 == 1) {
					this.screen.logged_in = true;
					this.method_198();
					return;
				}
			} catch (OutOfMemoryError var2) {
				this.method_175();
				this.field_180 = true;
			}

		}
	}

	@Override
	public void cleanup() {
		this.conn_close();
		this.method_175();
		if (this.audio_stream != null) {
			this.audio_stream.stop();
		}

	}

	public void method_175() {
		try {
			if (this.screen != null) {
				this.screen.sprites_release();
				this.screen.pixels = null;
				this.screen = null;
			}

			if (this.scene != null) {
				this.scene.dispose();
				this.scene = null;
			}

			this.models = null;
			this.jcb = null;
			this.scb = null;
			this.mbb = null;
			this.nbb = null;
			this.xbb = null;
			this.ybb = null;
			this.pbb = null;
			if (this.terrian != null) {
				this.terrian.ground = null;
				this.terrian.walls = null;
				this.terrian.rooves = null;
				this.terrian.mesh = null;
				this.terrian = null;
			}

			System.gc();
		} catch (Exception var1) {
			;
		}
	}


	@Override
	public void on_key(int var1) {
		if (this.field_201 == 0) {
			if (this.ui_state == 0) {
				this.welcome_ui.on_key(var1);
			}

			if (this.ui_state == 1) {
				this.register_ui.on_key(var1);
			}

			if (this.ui_state == 2) {
				this.login_ui.on_key(var1);
			}

			if (this.ui_state == 3) {
				this.recovery_ui.on_key(var1);
			}
		}

		if (this.field_201 == 1) {
			if (this.cmb) {
				this.vjb.on_key(var1);
				return;
			}

			if (this.lkb) {
				if (this.pkb == -1) {
					this.mkb.on_key(var1);
				}

				return;
			}

			if (this.eib == 0 && this.dib == 0) {
				this.bfb.on_key(var1);
			}

			if (this.eib == 3 || this.eib == 4 || this.eib == 5) {
				this.eib = 0;
			}
		}

	}


	@Override
	public void on_click(int var1, int var2, int var3) {
		this.field_189[this.field_188] = var2;
		this.field_190[this.field_188] = var3;
		this.field_188 = this.field_188 + 1 & 8191;

		for (int var4 = 10; var4 < 4000; ++var4) {
			int var5 = this.field_188 - var4 & 8191;
			if (this.field_189[var5] == var2 && this.field_190[var5] == var3) {
				boolean var6 = false;

				for (int var7 = 1; var7 < var4; ++var7) {
					int var8 = this.field_188 - var7 & 8191;
					int var9 = var5 - var7 & 8191;
					if (this.field_189[var9] != var2 || this.field_190[var9] != var3) {
						var6 = true;
					}

					if (this.field_189[var8] != this.field_189[var9] || this.field_190[var8] != this.field_190[var9]) {
						break;
					}

					if (var7 == var4 - 1 && var6 && this.rib == 0 && this.logout_timeout == 0) {
						this.method_178();
						return;
					}
				}
			}
		}

	}


	public void method_176() {
		this.field_201 = 0;
		this.ui_state = 0;
		this.tjb = "";
		this.ujb = "";
		this.rjb = "Please enter a username:";
		this.sjb = "*" + this.tjb + "*";
		this.jbb = 0;
		this.vbb = 0;
	}


	public void method_177() {
		super.line_b_buf = "";
		super.line_b = "";
	}


	public void method_178() {
		if (this.field_201 != 0) {
			if (this.rib > 450) {
				this.show_message("@cya@You can't logout during combat!", 3);
			} else if (this.rib > 0) {
				this.show_message("@cya@You can't logout for 10 seconds after combat", 3);
			} else {
				conn.enter(6);
				conn.exit();
				this.logout_timeout = 1000;
			}
		}
	}


	public void method_179(String var1) {
		if (this.audio_stream != null) {
			if (!this.geb) {
				this.audio_stream.set(this.sound_archive, DataUtil.entry_offset(var1 + ".pcm", this.sound_archive),
						DataUtil.method_18(var1 + ".pcm", this.sound_archive));
			}
		}
	}


	public void method_180() {
		this.mkb = new Menu(this.screen, 100);
		byte var1 = 8;
		this.nkb = this.mkb.center_label_create(256, var1,
				"@yel@Please provide 5 security questions in case you lose your password", 1, true);
		int var3 = var1 + 22;
		this.mkb.center_label_create(256, var3,
				"If you ever lose your password, you will need these to prove you own your account.", 1, true);
		var3 += 13;
		this.mkb.center_label_create(256, var3, "Your answers are encrypted and are ONLY used for password recovery purposes.",
				1, true);
		var3 += 22;
		this.mkb.center_label_create(256, var3,
				"@ora@IMPORTANT:@whi@ To recover your password you must give the EXACT same answers you", 1, true);
		var3 += 13;
		this.mkb.center_label_create(256, var3,
				"give here. If you think you might forget an answer, or someone else could guess the", 1, true);
		var3 += 13;
		this.mkb.center_label_create(256, var3, "answer, then press the 'different question' button to get a better question.",
				1, true);
		var3 += 35;

		for (int var2 = 0; var2 < 5; ++var2) {
			this.mkb.rect_create(170, var3, 310, 30);
			this.vkb[var2] = "~:" + this.ukb[var2];
			this.qkb[var2] = this.mkb.center_label_create(170, var3 - 7, var2 + 1 + ": " + this.ymb[this.ukb[var2]], 1, true);
			this.rkb[var2] = this.mkb.center_input_create(170, var3 + 7, 310, 30, 1, 80, false, true);
			this.mkb.rect_create(370, var3, 80, 30);
			this.mkb.center_label_create(370, var3 - 7, "Different", 1, true);
			this.mkb.center_label_create(370, var3 + 7, "Question", 1, true);
			this.skb[var2] = this.mkb.button_create(370, var3, 80, 30);
			this.mkb.rect_create(455, var3, 80, 30);
			this.mkb.center_label_create(455, var3 - 7, "Enter own", 1, true);
			this.mkb.center_label_create(455, var3 + 7, "Question", 1, true);
			this.tkb[var2] = this.mkb.button_create(455, var3, 80, 30);
			var3 += 35;
		}

		this.mkb.set_focus(this.rkb[0]);
		var3 += 10;
		this.mkb.rect_create(256, var3, 250, 30);
		this.mkb.center_label_create(256, var3, "Click here when finished", 4, true);
		this.okb = this.mkb.button_create(256, var3, 250, 30);
	}


	public void method_181() {
		if (this.pkb != -1) {
			if (super.line_b.length() > 0) {
				this.vkb[this.pkb] = super.line_b;
				this.mkb.set_text(this.qkb[this.pkb], this.pkb + 1 + ": " + this.vkb[this.pkb]);
				this.mkb.set_text(this.rkb[this.pkb], "");
				this.pkb = -1;
			}

		} else {
			this.mkb.consume(mouse_x, mouse_y, click_state, mouse_state);

			int var3;
			for (int var1 = 0; var1 < 5; ++var1) {
				if (this.mkb.selected(this.skb[var1])) {
					boolean var2 = false;

					while (!var2) {
						this.ukb[var1] = (this.ukb[var1] + 1) % this.ymb.length;
						var2 = true;

						for (var3 = 0; var3 < 5; ++var3) {
							if (var3 != var1 && this.ukb[var3] == this.ukb[var1]) {
								var2 = false;
							}
						}
					}

					this.vkb[var1] = "~:" + this.ukb[var1];
					this.mkb.set_text(this.qkb[var1], var1 + 1 + ": " + this.ymb[this.ukb[var1]]);
					this.mkb.set_text(this.rkb[var1], "");
				}
			}

			for (int var8 = 0; var8 < 5; ++var8) {
				if (this.mkb.selected(this.tkb[var8])) {
					this.pkb = var8;
					super.line_b_buf = "";
					super.line_b = "";
				}
			}

			if (this.mkb.selected(this.okb)) {
				var3 = 0;

				while (true) {
					if (var3 >= 5) {
						int var6;
						for (int var9 = 0; var9 < 5; ++var9) {
							String var5 = this.mkb.get_text(this.rkb[var9]);

							for (var6 = 0; var6 < var9; ++var6) {
								String var7 = this.mkb.get_text(this.rkb[var6]);
								if (var5.equalsIgnoreCase(var7)) {
									this.mkb.set_text(this.nkb, "@yel@Each question must have a different answer");
									return;
								}
							}
						}

						conn.enter(208);

						for (int var10 = 0; var10 < 5; ++var10) {
							String var11 = this.vkb[var10];
							if (var11 == null || var11.length() == 0) {
								var11 = String.valueOf(var10 + 1);
							}

							if (var11.length() > 50) {
								var11 = var11.substring(0, 50);
							}

							conn.byte_put(var11.length());
							conn.str_put(var11);
							conn.enc_cred_put(DataUtil.method_13(this.mkb.get_text(this.rkb[var10])),
									super.sess_id, this.rsa_exponent, this.rsa_modulus);
						}

						conn.exit();

						for (var6 = 0; var6 < 5; ++var6) {
							this.ukb[var6] = var6;
							this.vkb[var6] = "~:" + this.ukb[var6];
							this.mkb.set_text(this.rkb[var6], "");
							this.mkb.set_text(this.qkb[var6], var6 + 1 + ": " + this.ymb[this.ukb[var6]]);
						}

						this.screen.clear();
						this.lkb = false;
						break;
					}

					String var4 = this.mkb.get_text(this.rkb[var3]);
					if (var4 == null || var4.length() < 3) {
						this.mkb.set_text(this.nkb, "@yel@Please provide a longer answer to question: " + (var3 + 1));
						return;
					}

					++var3;
				}
			}

		}
	}


	public void method_182() {
		this.screen.reduce_lag = false;
		this.screen.clear();
		this.mkb.display();
		if (this.pkb != -1) {
			short var1 = 150;
			this.screen.rect_fill(26, var1, 460, 60, 0);
			this.screen.rect_draw(26, var1, 460, 60, 16777215);
			int var2 = var1 + 22;
			this.screen.center_text_draw("Please enter your question", 256, var2, 4, 16777215);
			var2 += 25;
			this.screen.center_text_draw(super.line_b_buf + "*", 256, var2, 4, 16777215);
		}

		this.screen.sprite_plot(0, this.wnd_height, this.ui_sprite_off + 22);
		this.screen.copy(this.graphics, 0, 0);
	}


	public void method_183() {
		this.recovery_ui = new Menu(this.screen, 100);
		byte var1 = 10;
		this.ykb = this.recovery_ui.center_label_create(256, var1, "@yel@To prove this is your account please provide the answers to", 1,
				true);
		int var3 = var1 + 15;
		this.zkb = this.recovery_ui.center_label_create(256, var3,
				"@yel@your security questions. You will then be able to reset your password", 1, true);
		var3 += 35;

		for (int var2 = 0; var2 < 5; ++var2) {
			this.recovery_ui.rect_create(256, var3, 410, 30);
			this.ilb[var2] = this.recovery_ui.center_label_create(256, var3 - 7, var2 + 1 + ": question?", 1, true);
			this.jlb[var2] = this.recovery_ui.center_input_create(256, var3 + 7, 310, 30, 1, 80, true, true);
			var3 += 35;
		}

		this.recovery_ui.set_focus(this.jlb[0]);
		this.recovery_ui.rect_create(256, var3, 410, 30);
		this.recovery_ui.center_label_create(256, var3 - 7, "If you know it, enter a previous password used on this account", 1, true);
		this.alb = this.recovery_ui.center_input_create(256, var3 + 7, 310, 30, 1, 80, true, true);
		var3 += 35;
		this.recovery_ui.rect_create(151, var3, 200, 30);
		this.recovery_ui.center_label_create(151, var3 - 7, "Choose a NEW password", 1, true);
		this.blb = this.recovery_ui.center_input_create(146, var3 + 7, 200, 30, 1, 80, true, true);
		this.recovery_ui.rect_create(361, var3, 200, 30);
		this.recovery_ui.center_label_create(361, var3 - 7, "Confirm new password", 1, true);
		this.clb = this.recovery_ui.center_input_create(366, var3 + 7, 200, 30, 1, 80, true, true);
		var3 += 35;
		this.recovery_ui.rect_create(201, var3, 100, 30);
		this.recovery_ui.center_label_create(201, var3, "Submit", 4, true);
		this.dlb = this.recovery_ui.button_create(201, var3, 100, 30);
		this.recovery_ui.rect_create(311, var3, 100, 30);
		this.recovery_ui.center_label_create(311, var3, "Cancel", 4, true);
		this.elb = this.recovery_ui.button_create(311, var3, 100, 30);
	}


	public void method_184() {
		this.vjb = new Menu(this.screen, 100);
		this.vjb.center_label_create(256, 10, "Design Your Character", 4, true);
		short var1 = 140;
		byte var2 = 34;
		this.vjb.rect_create(var1, var2, 200, 25);
		this.vjb.center_label_create(var1, var2, "Appearance", 4, false);
		int var5 = var2 + 15;
		this.vjb.center_label_create(var1 - 55, var5 + 110, "Front", 3, true);
		this.vjb.center_label_create(var1, var5 + 110, "Side", 3, true);
		this.vjb.center_label_create(var1 + 55, var5 + 110, "Back", 3, true);
		byte var3 = 54;
		var5 += 145;
		this.vjb.container_create(var1 - var3, var5, 53, 41);
		this.vjb.center_label_create(var1 - var3, var5 - 8, "Head", 1, true);
		this.vjb.center_label_create(var1 - var3, var5 + 8, "Type", 1, true);
		this.vjb.sprite_create(var1 - var3 - 40, var5, Menu.sprite_off + 7);
		this.wjb = this.vjb.button_create(var1 - var3 - 40, var5, 20, 20);
		this.vjb.sprite_create(var1 - var3 + 40, var5, Menu.sprite_off + 6);
		this.xjb = this.vjb.button_create(var1 - var3 + 40, var5, 20, 20);
		this.vjb.container_create(var1 + var3, var5, 53, 41);
		this.vjb.center_label_create(var1 + var3, var5 - 8, "Hair", 1, true);
		this.vjb.center_label_create(var1 + var3, var5 + 8, "Color", 1, true);
		this.vjb.sprite_create(var1 + var3 - 40, var5, Menu.sprite_off + 7);
		this.yjb = this.vjb.button_create(var1 + var3 - 40, var5, 20, 20);
		this.vjb.sprite_create(var1 + var3 + 40, var5, Menu.sprite_off + 6);
		this.zjb = this.vjb.button_create(var1 + var3 + 40, var5, 20, 20);
		var5 += 50;
		this.vjb.container_create(var1 - var3, var5, 53, 41);
		this.vjb.center_label_create(var1 - var3, var5, "Gender", 1, true);
		this.vjb.sprite_create(var1 - var3 - 40, var5, Menu.sprite_off + 7);
		this.akb = this.vjb.button_create(var1 - var3 - 40, var5, 20, 20);
		this.vjb.sprite_create(var1 - var3 + 40, var5, Menu.sprite_off + 6);
		this.bkb = this.vjb.button_create(var1 - var3 + 40, var5, 20, 20);
		this.vjb.container_create(var1 + var3, var5, 53, 41);
		this.vjb.center_label_create(var1 + var3, var5 - 8, "Top", 1, true);
		this.vjb.center_label_create(var1 + var3, var5 + 8, "Color", 1, true);
		this.vjb.sprite_create(var1 + var3 - 40, var5, Menu.sprite_off + 7);
		this.ckb = this.vjb.button_create(var1 + var3 - 40, var5, 20, 20);
		this.vjb.sprite_create(var1 + var3 + 40, var5, Menu.sprite_off + 6);
		this.dkb = this.vjb.button_create(var1 + var3 + 40, var5, 20, 20);
		var5 += 50;
		this.vjb.container_create(var1 - var3, var5, 53, 41);
		this.vjb.center_label_create(var1 - var3, var5 - 8, "Skin", 1, true);
		this.vjb.center_label_create(var1 - var3, var5 + 8, "Color", 1, true);
		this.vjb.sprite_create(var1 - var3 - 40, var5, Menu.sprite_off + 7);
		this.ekb = this.vjb.button_create(var1 - var3 - 40, var5, 20, 20);
		this.vjb.sprite_create(var1 - var3 + 40, var5, Menu.sprite_off + 6);
		this.fkb = this.vjb.button_create(var1 - var3 + 40, var5, 20, 20);
		this.vjb.container_create(var1 + var3, var5, 53, 41);
		this.vjb.center_label_create(var1 + var3, var5 - 8, "Bottom", 1, true);
		this.vjb.center_label_create(var1 + var3, var5 + 8, "Color", 1, true);
		this.vjb.sprite_create(var1 + var3 - 40, var5, Menu.sprite_off + 7);
		this.gkb = this.vjb.button_create(var1 + var3 - 40, var5, 20, 20);
		this.vjb.sprite_create(var1 + var3 + 40, var5, Menu.sprite_off + 6);
		this.hkb = this.vjb.button_create(var1 + var3 + 40, var5, 20, 20);
		var1 = 372;
		var2 = 35;
		this.vjb.rect_create(var1, var2, 200, 25);
		this.vjb.center_label_create(var1, var2, "Character Type", 4, false);
		var5 = var2 + 22;
		this.vjb.center_label_create(var1, var5, "Each character type has different starting", 0, true);
		var5 += 13;
		this.vjb.center_label_create(var1, var5, "bonuses. But the choice you make here", 0, true);
		var5 += 13;
		this.vjb.center_label_create(var1, var5, "isn't permanent, and will change depending", 0, true);
		var5 += 13;
		this.vjb.center_label_create(var1, var5, "on how you play the game.", 0, true);
		var5 += 73;
		this.vjb.container_create(var1, var5, 215, 125);
		String[] var4 = new String[] { "Adventurer", "Warrior", "Wizard", "Ranger", "Miner" };
		this.jkb = this.vjb.list_create(var1, var5 + 2, var4, 3, true);
		var5 += 82;
		this.vjb.rect_create(var1, var5, 200, 30);
		this.vjb.center_label_create(var1, var5, "Start Game", 4, false);
		this.ikb = this.vjb.button_create(var1, var5, 200, 30);
	}


	public void method_185() {
		this.screen.reduce_lag = false;
		this.screen.clear();
		this.vjb.display();
		short var1 = 140;
		byte var2 = 50;
		this.screen.method_56(var1 - 32 - 55, var2, 64, 102, Config.anim_unknown2[this.fmb], this.lmb[this.imb]);
		this.screen.resize_trans_sprite_plot(var1 - 32 - 55, var2, 64, 102, Config.anim_unknown2[this.emb], this.lmb[this.hmb],
				this.nmb[this.jmb], 0, false);
		this.screen.resize_trans_sprite_plot(var1 - 32 - 55, var2, 64, 102, Config.anim_unknown2[this.dmb], this.mmb[this.gmb],
				this.nmb[this.jmb], 0, false);
		this.screen.method_56(var1 - 32, var2, 64, 102, Config.anim_unknown2[this.fmb] + 6, this.lmb[this.imb]);
		this.screen.resize_trans_sprite_plot(var1 - 32, var2, 64, 102, Config.anim_unknown2[this.emb] + 6, this.lmb[this.hmb],
				this.nmb[this.jmb], 0, false);
		this.screen.resize_trans_sprite_plot(var1 - 32, var2, 64, 102, Config.anim_unknown2[this.dmb] + 6, this.mmb[this.gmb],
				this.nmb[this.jmb], 0, false);
		this.screen.method_56(var1 - 32 + 55, var2, 64, 102, Config.anim_unknown2[this.fmb] + 12, this.lmb[this.imb]);
		this.screen.resize_trans_sprite_plot(var1 - 32 + 55, var2, 64, 102, Config.anim_unknown2[this.emb] + 12, this.lmb[this.hmb],
				this.nmb[this.jmb], 0, false);
		this.screen.resize_trans_sprite_plot(var1 - 32 + 55, var2, 64, 102, Config.anim_unknown2[this.dmb] + 12, this.mmb[this.gmb],
				this.nmb[this.jmb], 0, false);
		this.screen.sprite_plot(0, this.wnd_height, this.ui_sprite_off + 22);
		this.screen.copy(this.graphics, 0, 0);
	}


	public void method_186() {
		this.vjb.consume(super.mouse_x, super.mouse_y, super.click_state, super.mouse_state);
		if (this.vjb.selected(this.wjb)) {
			do {
				do {
					this.dmb = (this.dmb - 1 + Config.anim_cnt) % Config.anim_cnt;
				} while ((Config.anim_unknown1[this.dmb] & 3) != 1);
			} while ((Config.anim_unknown1[this.dmb] & 4 * this.kmb) == 0);
		}

		if (this.vjb.selected(this.xjb)) {
			do {
				do {
					this.dmb = (this.dmb + 1) % Config.anim_cnt;
				} while ((Config.anim_unknown1[this.dmb] & 3) != 1);
			} while ((Config.anim_unknown1[this.dmb] & 4 * this.kmb) == 0);
		}

		if (this.vjb.selected(this.yjb)) {
			this.gmb = (this.gmb - 1 + this.mmb.length) % this.mmb.length;
		}

		if (this.vjb.selected(this.zjb)) {
			this.gmb = (this.gmb + 1) % this.mmb.length;
		}

		if (this.vjb.selected(this.akb) || this.vjb.selected(this.bkb)) {
			for (this.kmb = 3 - this.kmb; (Config.anim_unknown1[this.dmb] & 3) != 1
					|| (Config.anim_unknown1[this.dmb] & 4 * this.kmb) == 0; this.dmb = (this.dmb + 1)
							% Config.anim_cnt) {
				;
			}

			while ((Config.anim_unknown1[this.emb] & 3) != 2 || (Config.anim_unknown1[this.emb] & 4 * this.kmb) == 0) {
				this.emb = (this.emb + 1) % Config.anim_cnt;
			}
		}

		if (this.vjb.selected(this.ckb)) {
			this.hmb = (this.hmb - 1 + this.lmb.length) % this.lmb.length;
		}

		if (this.vjb.selected(this.dkb)) {
			this.hmb = (this.hmb + 1) % this.lmb.length;
		}

		if (this.vjb.selected(this.ekb)) {
			this.jmb = (this.jmb - 1 + this.nmb.length) % this.nmb.length;
		}

		if (this.vjb.selected(this.fkb)) {
			this.jmb = (this.jmb + 1) % this.nmb.length;
		}

		if (this.vjb.selected(this.gkb)) {
			this.imb = (this.imb - 1 + this.lmb.length) % this.lmb.length;
		}

		if (this.vjb.selected(this.hkb)) {
			this.imb = (this.imb + 1) % this.lmb.length;
		}

		if (this.vjb.selected(this.ikb)) {
			conn.enter(236);
			conn.byte_put(this.kmb);
			conn.byte_put(this.dmb);
			conn.byte_put(this.emb);
			conn.byte_put(this.fmb);
			conn.byte_put(this.gmb);
			conn.byte_put(this.hmb);
			conn.byte_put(this.imb);
			conn.byte_put(this.jmb);
			conn.byte_put(this.vjb.is_toggled(this.jkb));
			conn.exit();
			this.screen.clear();
			this.cmb = false;
		}

	}


	public void prepare_ui() {
		this.welcome_ui = new Menu(this.screen, 50);
		byte var1 = 40;
		if (!this.is_members) {
			this.welcome_ui.center_label_create(256, 200 + var1, "Click on an option", 5, true);
			this.welcome_ui.rect_create(156, 240 + var1, 120, 35);
			this.welcome_ui.rect_create(356, 240 + var1, 120, 35);
			this.welcome_ui.center_label_create(156, 240 + var1, "New User", 5, false);
			this.welcome_ui.center_label_create(356, 240 + var1, "Existing User", 5, false);
			this.xib = this.welcome_ui.button_create(156, 240 + var1, 120, 35);
			this.yib = this.welcome_ui.button_create(356, 240 + var1, 120, 35);
		} else {
			this.welcome_ui.center_label_create(256, 200 + var1, "Welcome to RuneScape", 4, true);
			this.welcome_ui.center_label_create(256, 215 + var1, "You need a members account to use this server", 4, true);
			this.welcome_ui.rect_create(256, 250 + var1, 200, 35);
			this.welcome_ui.center_label_create(256, 250 + var1, "Click here to login", 5, false);
			this.yib = this.welcome_ui.button_create(256, 250 + var1, 200, 35);
		}

		this.register_ui = new Menu(this.screen, 50);
		var1 = 70;
		this.register_status_field_id = this.register_ui.center_label_create(256, var1 + 8, "To create an account please enter all the requested details", 4,
				true);
		int var2 = var1 + 25;
		this.register_ui.rect_create(256, var2 + 17, 250, 34);
		this.register_ui.center_label_create(256, var2 + 8, "Choose a Username", 4, false);
		this.ejb = this.register_ui.center_input_create(256, var2 + 25, 200, 40, 4, 12, false, false);
		this.register_ui.set_focus(this.ejb);
		var2 += 40;
		this.register_ui.rect_create(141, var2 + 17, 220, 34);
		this.register_ui.center_label_create(141, var2 + 8, "Choose a Password", 4, false);
		this.fjb = this.register_ui.center_input_create(141, var2 + 25, 220, 40, 4, 20, true, false);
		this.register_ui.rect_create(371, var2 + 17, 220, 34);
		this.register_ui.center_label_create(371, var2 + 8, "Confirm Password", 4, false);
		this.gjb = this.register_ui.center_input_create(371, var2 + 25, 220, 40, 4, 20, true, false);
		var2 += 40;
		var2 += 20;
		this.hjb = this.register_ui.checkbox_create(60, var2, 14);
		this.register_ui.label_create(75, var2, "I have read and agree to the terms+conditions listed at:", 4, true);
		var2 += 15;
		this.register_ui.center_label_create(256, var2, "http://www.runescape.com/runeterms.html", 4, true);
		var2 += 20;
		this.register_ui.rect_create(156, var2 + 17, 150, 34);
		this.register_ui.center_label_create(156, var2 + 17, "Submit", 5, false);
		this.djb = this.register_ui.button_create(156, var2 + 17, 150, 34);
		this.register_ui.rect_create(356, var2 + 17, 150, 34);
		this.register_ui.center_label_create(356, var2 + 17, "Cancel", 5, false);
		this.cjb = this.register_ui.button_create(356, var2 + 17, 150, 34);
		this.login_ui = new Menu(this.screen, 50);
		short var3 = 230;
		this.login_status_field_id = this.login_ui.center_label_create(256, var3 - 10, "Please enter your username and password", 4, true);
		var2 = var3 + 28;
		this.login_ui.rect_create(140, var2, 200, 40);
		this.login_ui.center_label_create(140, var2 - 10, "Username:", 4, false);
		this.kjb = this.login_ui.center_input_create(140, var2 + 10, 200, 40, 4, 12, false, false);
		var2 += 47;
		this.login_ui.rect_create(190, var2, 200, 40);
		this.login_ui.center_label_create(190, var2 - 10, "Password:", 4, false);
		this.ljb = this.login_ui.center_input_create(190, var2 + 10, 200, 40, 4, 20, true, false);
		var2 -= 55;
		this.login_ui.rect_create(410, var2, 120, 25);
		this.login_ui.center_label_create(410, var2, "Ok", 4, false);
		this.mjb = this.login_ui.button_create(410, var2, 120, 25);
		var2 += 30;
		this.login_ui.rect_create(410, var2, 120, 25);
		this.login_ui.center_label_create(410, var2, "Cancel", 4, false);
		this.njb = this.login_ui.button_create(410, var2, 120, 25);
		var2 += 30;
		this.login_ui.rect_create(410, var2, 160, 25);
		this.login_ui.center_label_create(410, var2, "I've lost my password", 4, false);
		this.ojb = this.login_ui.button_create(410, var2, 160, 25);
		this.login_ui.set_focus(this.kjb);
	}


	public void pregame_display() {
		logged_in = false;
		screen.reduce_lag = false;
		screen.clear();

		if (ui_state == 0 || ui_state == 2) {
			int tick_cnt = ticks * 2 % 3072;

			if (tick_cnt < 1024) {
				screen.sprite_plot(0, 10, 2500);
				
				if (tick_cnt > 768) {
					screen.trans_sprite_plot(0, 10, 2501, tick_cnt - 768);
				}
			} else if (tick_cnt < 2048) {
				screen.sprite_plot(0, 10, 2501);
				
				if (tick_cnt > 1792) {
					screen.trans_sprite_plot(0, 10, ui_sprite_off + 10, tick_cnt - 1792);
				}
			} else {
				screen.sprite_plot(0, 10, ui_sprite_off + 10);
				
				if (tick_cnt > 2816) {
					screen.trans_sprite_plot(0, 10, 2500, tick_cnt - 2816);
				}
			}
		}

		if (ui_state == 0) {
			welcome_ui.display();
		}

		if (ui_state == 1) {
			register_ui.display();
		}

		if (ui_state == 2) {
			login_ui.display();
		}

		if (ui_state == 3) {
			recovery_ui.display();
		}

		screen.sprite_plot(0, wnd_height, ui_sprite_off + 22);
		screen.copy(graphics, 0, 0);
	}


	public void method_189() {
		byte var1 = 0;
		byte var2 = 50;
		byte var3 = 50;
		this.terrian.load(var2 * 48 + 23, var3 * 48 + 23, var1);
		this.terrian.method_113(this.models);
		short var4 = 9728;
		short var5 = 6400;
		short var6 = 1100;
		short var7 = 888;
		this.scene.clip_far_3d = 4100;
		this.scene.clip_far_2d = 4100;
		this.scene.fog_falloff = 1;
		this.scene.fog_distance = 4000;
		this.scene.set_camera(var4, -this.terrian.calc_z(var4, var5), var5, 912, var7, 0, var6 * 2);
		this.scene.render();
		this.screen.darken();
		this.screen.darken();
		this.screen.rect_fill(0, 0, 512, 6, 0);

		for (int var8 = 6; var8 >= 1; --var8) {
			this.screen.blur(0, var8, 0, var8, 512, 8);
		}

		this.screen.rect_fill(0, 194, 512, 20, 0);

		for (int var9 = 6; var9 >= 1; --var9) {
			this.screen.blur(0, var9, 0, 194 - var9, 512, 8);
		}

		this.screen.sprite_plot(15, 15, this.ui_sprite_off + 10);
		this.screen.row_sprite_define(2500, 0, 0, 512, 200);
		this.screen.sprite_posterize(2500);
		var4 = 9216;
		var5 = 9216;
		var6 = 1100;
		var7 = 888;
		this.scene.clip_far_3d = 4100;
		this.scene.clip_far_2d = 4100;
		this.scene.fog_falloff = 1;
		this.scene.fog_distance = 4000;
		this.scene.set_camera(var4, -this.terrian.calc_z(var4, var5), var5, 912, var7, 0, var6 * 2);
		this.scene.render();
		this.screen.darken();
		this.screen.darken();
		this.screen.rect_fill(0, 0, 512, 6, 0);

		for (int var10 = 6; var10 >= 1; --var10) {
			this.screen.blur(0, var10, 0, var10, 512, 8);
		}

		this.screen.rect_fill(0, 194, 512, 20, 0);

		for (int var11 = 6; var11 >= 1; --var11) {
			this.screen.blur(0, var11, 0, 194 - var11, 512, 8);
		}

		this.screen.sprite_plot(15, 15, this.ui_sprite_off + 10);
		this.screen.row_sprite_define(2501, 0, 0, 512, 200);
		this.screen.sprite_posterize(2501);

		for (int var12 = 0; var12 < 64; ++var12) {
			this.scene.remove(this.terrian.rooves[0][var12]);
			this.scene.remove(this.terrian.walls[1][var12]);
			this.scene.remove(this.terrian.rooves[1][var12]);
			this.scene.remove(this.terrian.walls[2][var12]);
			this.scene.remove(this.terrian.rooves[2][var12]);
		}

		var4 = 11136;
		var5 = 10368;
		var6 = 500;
		var7 = 376;
		this.scene.clip_far_3d = 4100;
		this.scene.clip_far_2d = 4100;
		this.scene.fog_falloff = 1;
		this.scene.fog_distance = 4000;
		this.scene.set_camera(var4, -this.terrian.calc_z(var4, var5), var5, 912, var7, 0, var6 * 2);
		this.scene.render();
		this.screen.darken();
		this.screen.darken();
		this.screen.rect_fill(0, 0, 512, 6, 0);

		for (int var13 = 6; var13 >= 1; --var13) {
			this.screen.blur(0, var13, 0, var13, 512, 8);
		}

		this.screen.rect_fill(0, 194, 512, 20, 0);

		for (int var14 = 6; var14 >= 1; --var14) {
			this.screen.blur(0, var14, 0, 194, 512, 8);
		}

		this.screen.sprite_plot(15, 15, this.ui_sprite_off + 10);
		this.screen.row_sprite_define(this.ui_sprite_off + 10, 0, 0, 512, 200);
		this.screen.sprite_posterize(this.ui_sprite_off + 10);
	}


	public void method_190() {
		if (super.login_delay > 0) {
			--super.login_delay;
		}

		if (this.ui_state == 0) {
			this.welcome_ui.consume(super.mouse_x, super.mouse_y, super.click_state, super.mouse_state);
			if (this.welcome_ui.selected(this.xib)) {
				this.ui_state = 1;
				this.register_ui.set_text(this.ejb, "");
				this.register_ui.set_text(this.fjb, "");
				this.register_ui.set_text(this.gjb, "");
				this.register_ui.set_focus(this.ejb);
				this.register_ui.set_toggle(this.hjb, 0);
				this.register_ui.set_text(this.register_status_field_id, "To create an account please enter all the requested details");
			}

			if (this.welcome_ui.selected(this.yib)) {
				this.ui_state = 2;
				this.login_ui.set_text(this.login_status_field_id, "Please enter your username and password");
				this.login_ui.set_text(this.kjb, "");
				this.login_ui.set_text(this.ljb, "");
				this.login_ui.set_focus(this.kjb);
				return;
			}
		} else {
			String var1;
			String var2;
			if (this.ui_state == 1) {
				this.register_ui.consume(super.mouse_x, super.mouse_y, super.click_state, super.mouse_state);
				if (this.register_ui.selected(this.ejb)) {
					this.register_ui.set_focus(this.fjb);
				}

				if (this.register_ui.selected(this.fjb)) {
					this.register_ui.set_focus(this.gjb);
				}

				if (this.register_ui.selected(this.gjb)) {
					this.register_ui.set_focus(this.ejb);
				}

				if (this.register_ui.selected(this.cjb)) {
					this.ui_state = 0;
				}

				if (this.register_ui.selected(this.djb)) {
					if (this.register_ui.get_text(this.ejb) != null && this.register_ui.get_text(this.ejb).length() != 0
							&& this.register_ui.get_text(this.fjb) != null && this.register_ui.get_text(this.fjb).length() != 0) {
						if (!this.register_ui.get_text(this.fjb).equalsIgnoreCase(this.register_ui.get_text(this.gjb))) {
							this.register_ui.set_text(this.register_status_field_id,
									"@yel@The two passwords entered are not the same as each other!");
							return;
						}

						if (this.register_ui.get_text(this.fjb).length() < 5) {
							this.register_ui.set_text(this.register_status_field_id, "@yel@Your password must be at least 5 letters long");
							return;
						}

						if (this.register_ui.is_toggled(this.hjb) == 0) {
							this.register_ui.set_text(this.register_status_field_id, "@yel@You must agree to the terms+conditions to continue");
							return;
						}

						this.register_ui.set_text(this.register_status_field_id, "Please wait... Creating new account");
						this.pregame_display();
						this.reset_ticks();
						var1 = this.register_ui.get_text(this.ejb);
						var2 = this.register_ui.get_text(this.fjb);
						this.register(var1, var2);
						return;
					}

					this.register_ui.set_text(this.register_status_field_id, "@yel@Please fill in ALL requested information to continue!");
					return;
				}
			} else {
				int var3;
				String var5;
				int var6;
				if (this.ui_state == 2) {
					this.login_ui.consume(super.mouse_x, super.mouse_y, super.click_state, super.mouse_state);
					if (this.login_ui.selected(this.njb)) {
						this.ui_state = 0;
					}

					if (this.login_ui.selected(this.kjb)) {
						this.login_ui.set_focus(this.ljb);
					}

					if (this.login_ui.selected(this.ljb) || this.login_ui.selected(this.mjb)) {
						this.tjb = this.login_ui.get_text(this.kjb);
						this.ujb = this.login_ui.get_text(this.ljb);
						this.login(this.tjb, this.ujb, false);
					}

					if (this.login_ui.selected(this.ojb)) {
						this.tjb = this.login_ui.get_text(this.kjb);
						this.tjb = DataUtil.filter_str(this.tjb, 20);
						if (this.tjb.trim().length() == 0) {
							this.status_text("You must enter your username to recover your password", "");
							return;
						}

						this.status_text(MultiplayerGame.response_status_text[6], MultiplayerGame.response_status_text[7]);

						try {
							if (is_applet()) {
								conn = new Connection(host, this, server_port);
							} else {
								conn = new Connection(host, (Applet) null, server_port);
							}

							conn.time_out = MultiplayerGame.time_out;
							conn.read_int();
							conn.enter(4);
							conn.long_put(DataUtil.encode_name(this.tjb));
							conn.send();
							conn.read_short();
							int var11 = conn.read();
							System.out.println("Getpq response: " + var11);
							if (var11 == 0) {
								this.status_text("Sorry, the recovery questions for this user have not been set", "");
								return;
							}

							for (int var12 = 0; var12 < 5; ++var12) {
								var3 = conn.read();
								byte[] var4 = new byte[5000];
								conn.read(var3, var4);
								var5 = new String(var4, 0, var3);
								if (var5.startsWith("~:")) {
									var5 = var5.substring(2);
									var6 = 0;

									try {
										var6 = Integer.parseInt(var5);
									} catch (Exception var8) {
										;
									}

									var5 = this.ymb[var6];
								}

								this.recovery_ui.set_text(this.ilb[var12], var5);
							}

							if (this.wkb) {
								this.status_text("Sorry, you have already attempted 1 recovery, try again later", "");
								return;
							}

							this.ui_state = 3;
							this.recovery_ui.set_text(this.ykb,
									"@yel@To prove this is your account please provide the answers to");
							this.recovery_ui.set_text(this.zkb,
									"@yel@your security questions. You will then be able to reset your password");

							for (var3 = 0; var3 < 5; ++var3) {
								this.recovery_ui.set_text(this.jlb[var3], "");
							}

							this.recovery_ui.set_text(this.alb, "");
							this.recovery_ui.set_text(this.blb, "");
							this.recovery_ui.set_text(this.clb, "");
							return;
						} catch (Exception var9) {
							this.status_text(MultiplayerGame.response_status_text[12], MultiplayerGame.response_status_text[13]);
							return;
						}
					}
				} else if (this.ui_state == 3) {
					this.recovery_ui.consume(super.mouse_x, super.mouse_y, super.click_state, super.mouse_state);
					if (this.recovery_ui.selected(this.dlb)) {
						var1 = this.recovery_ui.get_text(this.blb);
						var2 = this.recovery_ui.get_text(this.clb);
						if (!var1.equalsIgnoreCase(var2)) {
							this.status_text("@yel@The two new passwords entered are not the same as each other!", "");
							return;
						}

						if (var1.length() < 5) {
							this.status_text("@yel@Your new password must be at least 5 letters long", "");
							return;
						}

						this.status_text(MultiplayerGame.response_status_text[6], MultiplayerGame.response_status_text[7]);

						try {
							if (this.is_applet()) {
								super.conn = new Connection(super.host, this, super.server_port);
							} else {
								super.conn = new Connection(super.host, (Applet) null, super.server_port);
							}

							conn.time_out = MultiplayerGame.time_out;
							var3 = conn.read_int();
							String var13 = DataUtil.filter_str(this.recovery_ui.get_text(this.alb), 20);
							var5 = DataUtil.filter_str(this.recovery_ui.get_text(this.blb), 20);
							conn.enter(8);
							conn.long_put(DataUtil.encode_name(this.tjb));
							conn.int_put(this.seed());
							conn.enc_cred_put(var13 + var5, var3, this.rsa_exponent, this.rsa_modulus);

							for (var6 = 0; var6 < 5; ++var6) {
								conn.enc_cred_put(DataUtil.method_13(this.recovery_ui.get_text(this.jlb[var6])), var3,
										this.rsa_exponent, this.rsa_modulus);
							}

							conn.send();
							conn.read();
							int var7 = conn.read();
							System.out.println("Recover response: " + var7);
							if (var7 == 0) {
								this.ui_state = 2;
								this.status_text("Sorry, recovery failed. You may try again in 1 hour", "");
								this.wkb = true;
								return;
							}

							if (var7 == 1) {
								this.ui_state = 2;
								this.status_text("Your pass has been reset. You may now use the new pass to login", "");
								return;
							}

							this.ui_state = 2;
							this.status_text("Recovery failed! Attempts exceeded?", "");
							return;
						} catch (Exception var10) {
							this.status_text(MultiplayerGame.response_status_text[12], MultiplayerGame.response_status_text[13]);
						}
					}

					if (this.recovery_ui.selected(this.elb)) {
						this.ui_state = 0;
					}
				}
			}
		}

	}

	@Override
	public void status_text(String first, String second) {
		if (ui_state == 1) {
			register_ui.set_text(register_status_field_id, first + " " + second);
		}

		if (ui_state == 2) {
			login_ui.set_text(login_status_field_id, first + " " + second);
		}

		if (ui_state == 3) {
			recovery_ui.set_text(ykb, first);
			recovery_ui.set_text(zkb, second);
		}

		this.sjb = second;
		this.pregame_display();
		this.reset_ticks();
	}

	@Override
	public void logout_disabled() {
		logout_timeout = 0;
		show_message("@cya@Sorry, you can't logout at the moment", 3);
	}

	@Override
	public void conn_dropped() {
		if (logout_timeout != 0) {
			reset_login_state();
		} else {
			super.conn_dropped();
		}
	}

	@Override
	public void reset_login_state() {
		ui_state = 0;
		field_201 = 0;
		logout_timeout = 0;
	}

	@Override
	public void reset_game_state() {
		this.cib = 0;
		this.logout_timeout = 0;
		this.ui_state = 0;
		this.field_201 = 1;
		this.method_177();
		this.screen.clear();
		this.screen.copy(this.graphics, 0, 0);

		for (int var1 = 0; var1 < this.icb; ++var1) {
			this.scene.remove(this.jcb[var1]);
			this.terrian.obj_remove(this.kcb[var1], this.lcb[var1], this.mcb[var1]);
		}

		for (int var2 = 0; var2 < this.rcb; ++var2) {
			this.scene.remove(this.scb[var2]);
			this.terrian.wall_remove(this.tcb[var2], this.ucb[var2], this.vcb[var2], this.wcb[var2]);
		}

		this.icb = 0;
		this.rcb = 0;
		this.ccb = 0;
		this.jbb = 0;

		for (int var3 = 0; var3 < this.hbb; ++var3) {
			this.mbb[var3] = null;
		}

		for (int var4 = 0; var4 < this.ibb; ++var4) {
			this.nbb[var4] = null;
		}

		this.vbb = 0;

		for (int var5 = 0; var5 < this.tbb; ++var5) {
			this.xbb[var5] = null;
		}

		for (int var6 = 0; var6 < this.ubb; ++var6) {
			this.ybb[var6] = null;
		}

		for (int var7 = 0; var7 < 50; ++var7) {
			this.ceb[var7] = false;
		}

		this.field_184 = 0;
		super.click_state = 0;
		super.mouse_state = 0;
		this.ghb = false;
		this.ohb = false;
	}

	// TODO: rename this, it's incorrect
	@Override
	public void reset_register_state() {
		String var1 = this.register_ui.get_text(this.ejb);
		String var2 = this.register_ui.get_text(this.fjb);
		this.ui_state = 2;
		this.login_ui.set_text(this.login_status_field_id, "Please enter your username and password");
		this.login_ui.set_text(this.kjb, var1);
		this.login_ui.set_text(this.ljb, var2);
		this.pregame_display();
		this.reset_ticks();
		this.login(var1, var2, false);
	}


	public void method_191() {
		conn_check();

		if (this.logout_timeout > 0) {
			--this.logout_timeout;
		}

		if (super.idle_counter > 4500 && this.rib == 0 && this.logout_timeout == 0) {
			super.idle_counter -= 500;
			this.method_178();
		} else {
			if (this.pbb.field_502 == 8 || this.pbb.field_502 == 9) {
				this.rib = 500;
			}

			if (this.rib > 0) {
				--this.rib;
			}

			if (this.cmb) {
				this.method_186();
			} else if (this.lkb) {
				this.method_181();
			} else {
				int var3;
				int var5;
				int var6;
				int var7;
				for (int var1 = 0; var1 < this.jbb; ++var1) {
					Mob var2 = this.nbb[var1];
					var3 = (var2.field_505 + 1) % 10;
					if (var2.field_504 != var3) {
						byte var4 = -1;
						var5 = var2.field_504;
						if (var5 < var3) {
							var6 = var3 - var5;
						} else {
							var6 = 10 + var3 - var5;
						}

						var7 = 4;
						if (var6 > 2) {
							var7 = (var6 - 1) * 4;
						}

						if (var2.waypoint_hist_x[var5] - var2.cur_x <= this.field_200 * 3
								&& var2.waypoint_hist_y[var5] - var2.cur_y <= this.field_200 * 3
								&& var2.waypoint_hist_x[var5] - var2.cur_x >= -this.field_200 * 3
								&& var2.waypoint_hist_y[var5] - var2.cur_y >= -this.field_200 * 3 && var6 <= 8) {
							if (var2.cur_x < var2.waypoint_hist_x[var5]) {
								var2.cur_x += var7;
								++var2.field_501;
								var4 = 2;
							} else if (var2.cur_x > var2.waypoint_hist_x[var5]) {
								var2.cur_x -= var7;
								++var2.field_501;
								var4 = 6;
							}

							if (var2.cur_x - var2.waypoint_hist_x[var5] < var7
									&& var2.cur_x - var2.waypoint_hist_x[var5] > -var7) {
								var2.cur_x = var2.waypoint_hist_x[var5];
							}

							if (var2.cur_y < var2.waypoint_hist_y[var5]) {
								var2.cur_y += var7;
								++var2.field_501;
								if (var4 == -1) {
									var4 = 4;
								} else if (var4 == 2) {
									var4 = 3;
								} else {
									var4 = 5;
								}
							} else if (var2.cur_y > var2.waypoint_hist_y[var5]) {
								var2.cur_y -= var7;
								++var2.field_501;
								if (var4 == -1) {
									var4 = 0;
								} else if (var4 == 2) {
									var4 = 1;
								} else {
									var4 = 7;
								}
							}

							if (var2.cur_y - var2.waypoint_hist_y[var5] < var7
									&& var2.cur_y - var2.waypoint_hist_y[var5] > -var7) {
								var2.cur_y = var2.waypoint_hist_y[var5];
							}
						} else {
							var2.cur_x = var2.waypoint_hist_x[var5];
							var2.cur_y = var2.waypoint_hist_y[var5];
						}

						if (var4 != -1) {
							var2.field_502 = var4;
						}

						if (var2.cur_x == var2.waypoint_hist_x[var5] && var2.cur_y == var2.waypoint_hist_y[var5]) {
							var2.field_504 = (var5 + 1) % 10;
						}
					} else {
						var2.field_502 = var2.field_503;
					}

					if (var2.field_510 > 0) {
						--var2.field_510;
					}

					if (var2.field_512 > 0) {
						--var2.field_512;
					}

					if (var2.field_516 > 0) {
						--var2.field_516;
					}

					if (this.sib > 0) {
						--this.sib;
						if (this.sib == 0) {
							this.show_message("You have been granted another life. Be more careful this time!", 3);
						}

						if (this.sib == 0) {
							this.show_message("You retain your skills. Your objects land where you died", 3);
						}
					}
				}

				int var13;
				for (int var9 = 0; var9 < this.vbb; ++var9) {
					Mob var10 = this.ybb[var9];
					var13 = (var10.field_505 + 1) % 10;
					if (var10.field_504 != var13) {
						byte var11 = -1;
						var6 = var10.field_504;
						if (var6 < var13) {
							var7 = var13 - var6;
						} else {
							var7 = 10 + var13 - var6;
						}

						int var8 = 4;
						if (var7 > 2) {
							var8 = (var7 - 1) * 4;
						}

						if (var10.waypoint_hist_x[var6] - var10.cur_x <= this.field_200 * 3
								&& var10.waypoint_hist_y[var6] - var10.cur_y <= this.field_200 * 3
								&& var10.waypoint_hist_x[var6] - var10.cur_x >= -this.field_200 * 3
								&& var10.waypoint_hist_y[var6] - var10.cur_y >= -this.field_200 * 3 && var7 <= 8) {
							if (var10.cur_x < var10.waypoint_hist_x[var6]) {
								var10.cur_x += var8;
								++var10.field_501;
								var11 = 2;
							} else if (var10.cur_x > var10.waypoint_hist_x[var6]) {
								var10.cur_x -= var8;
								++var10.field_501;
								var11 = 6;
							}

							if (var10.cur_x - var10.waypoint_hist_x[var6] < var8
									&& var10.cur_x - var10.waypoint_hist_x[var6] > -var8) {
								var10.cur_x = var10.waypoint_hist_x[var6];
							}

							if (var10.cur_y < var10.waypoint_hist_y[var6]) {
								var10.cur_y += var8;
								++var10.field_501;
								if (var11 == -1) {
									var11 = 4;
								} else if (var11 == 2) {
									var11 = 3;
								} else {
									var11 = 5;
								}
							} else if (var10.cur_y > var10.waypoint_hist_y[var6]) {
								var10.cur_y -= var8;
								++var10.field_501;
								if (var11 == -1) {
									var11 = 0;
								} else if (var11 == 2) {
									var11 = 1;
								} else {
									var11 = 7;
								}
							}

							if (var10.cur_y - var10.waypoint_hist_y[var6] < var8
									&& var10.cur_y - var10.waypoint_hist_y[var6] > -var8) {
								var10.cur_y = var10.waypoint_hist_y[var6];
							}
						} else {
							var10.cur_x = var10.waypoint_hist_x[var6];
							var10.cur_y = var10.waypoint_hist_y[var6];
						}

						if (var11 != -1) {
							var10.field_502 = var11;
						}

						if (var10.cur_x == var10.waypoint_hist_x[var6] && var10.cur_y == var10.waypoint_hist_y[var6]) {
							var10.field_504 = (var6 + 1) % 10;
						}
					} else {
						var10.field_502 = var10.field_503;
						if (var10.field_500 == 43) {
							++var10.field_501;
						}
					}

					if (var10.field_510 > 0) {
						--var10.field_510;
					}

					if (var10.field_512 > 0) {
						--var10.field_512;
					}

					if (var10.field_516 > 0) {
						--var10.field_516;
					}
				}

				for (var3 = 0; var3 < this.jbb; ++var3) {
					Mob var14 = this.nbb[var3];
					if (var14.field_525 > 0) {
						--var14.field_525;
					}
				}

				if (this.deb) {
					if (this.bbb - this.pbb.cur_x < -500 || this.bbb - this.pbb.cur_x > 500
							|| this.cbb - this.pbb.cur_y < -500 || this.cbb - this.pbb.cur_y > 500) {
						this.bbb = this.pbb.cur_x;
						this.cbb = this.pbb.cur_y;
					}
				} else {
					if (this.bbb - this.pbb.cur_x < -500 || this.bbb - this.pbb.cur_x > 500
							|| this.cbb - this.pbb.cur_y < -500 || this.cbb - this.pbb.cur_y > 500) {
						this.bbb = this.pbb.cur_x;
						this.cbb = this.pbb.cur_y;
					}

					if (this.bbb != this.pbb.cur_x) {
						this.bbb += (this.pbb.cur_x - this.bbb) / (16 + (this.zab - 500) / 15);
					}

					if (this.cbb != this.pbb.cur_y) {
						this.cbb += (this.pbb.cur_y - this.cbb) / (16 + (this.zab - 500) / 15);
					}

					if (this.eeb) {
						var13 = this.dbb * 32;
						var5 = var13 - this.fbb;
						byte var12 = 1;
						if (var5 != 0) {
							++this.ebb;
							if (var5 > 128) {
								var12 = -1;
								var5 = 256 - var5;
							} else if (var5 > 0) {
								var12 = 1;
							} else if (var5 < -128) {
								var12 = 1;
								var5 += 256;
							} else if (var5 < 0) {
								var12 = -1;
								var5 = -var5;
							}

							this.fbb += (this.ebb * var5 + 255) / 256 * var12;
							this.fbb &= 255;
						} else {
							this.ebb = 0;
						}
					}
				}

				if (super.mouse_y > this.wnd_height - 4) {
					if (super.mouse_x > 15 && super.mouse_x < 96 && super.click_state == 1) {
						this.gfb = 0;
					}

					if (super.mouse_x > 110 && super.mouse_x < 194 && super.click_state == 1) {
						this.gfb = 1;
						this.bfb.field_353[this.cfb] = 999999;
					}

					if (super.mouse_x > 215 && super.mouse_x < 295 && super.click_state == 1) {
						this.gfb = 2;
						this.bfb.field_353[this.efb] = 999999;
					}

					if (super.mouse_x > 315 && super.mouse_x < 395 && super.click_state == 1) {
						this.gfb = 3;
						this.bfb.field_353[this.ffb] = 999999;
					}

					super.click_state = 0;
					super.mouse_state = 0;
				}

				this.bfb.consume(super.mouse_x, super.mouse_y, super.click_state, super.mouse_state);
				if (this.gfb > 0 && super.mouse_x >= 494 && super.mouse_y >= this.wnd_height - 66) {
					super.click_state = 0;
				}

				if (this.bfb.selected(this.dfb)) {
					String var15 = this.bfb.get_text(this.dfb);
					this.bfb.set_text(this.dfb, "");
					if (var15.startsWith("::")) {
						if (var15.equalsIgnoreCase("::lostcon") && !this.normal_user) {
							conn.close();
						} else if (var15.equalsIgnoreCase("::closecon") && !this.normal_user) {
							this.conn_close();
						} else {
							this.send_command(var15.substring(2));
						}
					} else {
						var5 = DataUtil.method_21(var15);
						this.send_message(DataUtil.field_6, var5);
						var15 = DataUtil.decode_censor(DataUtil.field_6, 0, var5, true);
						this.pbb.field_510 = 150;
						this.pbb.field_509 = var15;
						this.show_message(this.pbb.name + ": " + var15, 2);
					}
				}

				if (this.gfb == 0) {
					for (var13 = 0; var13 < this.hfb; ++var13) {
						if (this.jfb[var13] > 0) {
							--this.jfb[var13];
						}
					}
				}

				if (this.sib != 0) {
					super.click_state = 0;
				}

				if (!this.lgb && !this.kfb) {
					this.vgb = 0;
					this.wgb = 0;
				} else {
					if (super.mouse_state != 0) {
						++this.vgb;
					} else {
						this.vgb = 0;
					}

					if (this.vgb > 300) {
						this.wgb += 50;
					} else if (this.vgb > 150) {
						this.wgb += 5;
					} else if (this.vgb > 50) {
						++this.wgb;
					} else if (this.vgb > 20 && (this.vgb & 5) == 0) {
						++this.wgb;
					}
				}

				if (super.click_state == 1) {
					this.field_184 = 1;
				} else if (super.click_state == 2) {
					this.field_184 = 2;
				}

				this.scene.consume_click(super.mouse_x, super.mouse_y);
				super.click_state = 0;
				if (this.eeb) {
					if (this.ebb == 0 || this.deb) {
						if (super.field_132) {
							this.dbb = this.dbb + 1 & 7;
							super.field_132 = false;
							if (!this.abb) {
								if ((this.dbb & 1) == 0) {
									this.dbb = this.dbb + 1 & 7;
								}

								for (var13 = 0; var13 < 8 && !this.method_196(this.dbb); ++var13) {
									this.dbb = this.dbb + 1 & 7;
								}
							}
						}

						if (super.field_133) {
							this.dbb = this.dbb + 7 & 7;
							super.field_133 = false;
							if (!this.abb) {
								if ((this.dbb & 1) == 0) {
									this.dbb = this.dbb + 7 & 7;
								}

								for (var13 = 0; var13 < 8 && !this.method_196(this.dbb); ++var13) {
									this.dbb = this.dbb + 7 & 7;
								}
							}
						}
					}
				} else if (super.field_132) {
					this.fbb = this.fbb + 2 & 255;
				} else if (super.field_133) {
					this.fbb = this.fbb - 2 & 255;
				}

				if (this.abb && this.zab > 550) {
					this.zab -= 4;
				} else if (!this.abb && this.zab < 750) {
					this.zab += 4;
				}

				if (this.hab > 0) {
					--this.hab;
				} else if (this.hab < 0) {
					++this.hab;
				}

				this.scene.method_401(17);
				++this.cab;
				if (this.cab > 5) {
					this.cab = 0;
					this.dab = this.dab + 1 & 3;
					this.eab = (this.eab + 1) % 3;
				}

				for (var13 = 0; var13 < this.icb; ++var13) {
					var5 = this.kcb[var13];
					var6 = this.lcb[var13];
					if (var5 >= 0 && var6 >= 0 && var5 < 96 && var6 < 96 && this.mcb[var13] == 74) {
						this.jcb[var13].method_256(1, 0, 0);
					}
				}

				for (var5 = 0; var5 < this.tmb; ++var5) {
					++this.wmb[var5];
					if (this.wmb[var5] > 50) {
						--this.tmb;

						for (var6 = var5; var6 < this.tmb; ++var6) {
							this.umb[var6] = this.umb[var6 + 1];
							this.vmb[var6] = this.vmb[var6 + 1];
							this.wmb[var6] = this.wmb[var6 + 1];
							this.xmb[var6] = this.xmb[var6 + 1];
						}
					}
				}

			}
		}
	}


	public void show_message(String var1, int var2) {
		int var3;
		if (var2 == 2 || var2 == 4 || var2 == 6) {
			while (true) {
				if (var1.length() <= 5 || var1.charAt(0) != '@' || var1.charAt(4) != '@') {
					var3 = var1.indexOf(":");
					if (var3 != -1) {
						String var4 = var1.substring(0, var3);
						long var5 = DataUtil.encode_name(var4);

						for (int var7 = 0; var7 < super.ignore_cnt; ++var7) {
							if (super.ignore_hash[var7] == var5) {
								return;
							}
						}
					}
					break;
				}

				var1 = var1.substring(5);
			}
		}

		if (var2 == 2) {
			var1 = "@yel@" + var1;
		}

		if (var2 == 3 || var2 == 4) {
			var1 = "@whi@" + var1;
		}

		if (var2 == 6) {
			var1 = "@cya@" + var1;
		}

		if (this.gfb != 0) {
			if (var2 == 4 || var2 == 3) {
				this.xeb = 200;
			}

			if (var2 == 2 && this.gfb != 1) {
				this.yeb = 200;
			}

			if (var2 == 5 && this.gfb != 2) {
				this.zeb = 200;
			}

			if (var2 == 6 && this.gfb != 3) {
				this.afb = 200;
			}

			if (var2 == 3 && this.gfb != 0) {
				this.gfb = 0;
			}

			if (var2 == 6 && this.gfb != 3 && this.gfb != 0) {
				this.gfb = 0;
			}
		}

		for (var3 = this.hfb - 1; var3 > 0; --var3) {
			this.ifb[var3] = this.ifb[var3 - 1];
			this.jfb[var3] = this.jfb[var3 - 1];
		}

		this.ifb[0] = var1;
		this.jfb[0] = 300;
		if (var2 == 2) {
			if (this.bfb.field_353[this.cfb] == this.bfb.elem_entry_cnt[this.cfb] - 4) {
				this.bfb.entry_add(this.cfb, var1, true);
			} else {
				this.bfb.entry_add(this.cfb, var1, false);
			}
		}

		if (var2 == 5) {
			if (this.bfb.field_353[this.efb] == this.bfb.elem_entry_cnt[this.efb] - 4) {
				this.bfb.entry_add(this.efb, var1, true);
			} else {
				this.bfb.entry_add(this.efb, var1, false);
			}
		}

		if (var2 == 6) {
			if (this.bfb.field_353[this.ffb] == this.bfb.elem_entry_cnt[this.ffb] - 4) {
				this.bfb.entry_add(this.ffb, var1, true);
				return;
			}

			this.bfb.entry_add(this.ffb, var1, false);
		}

	}

	@Override
	public void push_message(String message) {
		if (message.startsWith("@bor@")) {
			show_message(message, 4);
		} else if (message.startsWith("@que@")) {
			show_message("@whi@" + message, 5);
		} else if (message.startsWith("@pri@")) {
			show_message(message, 6);
		} else {
			show_message(message, 3);
		}
	}

	public Mob method_193(int var1, int var2, int var3, int var4) {
		if (this.mbb[var1] == null) {
			this.mbb[var1] = new Mob();
			this.mbb[var1].index = var1;
			this.mbb[var1].field_497 = 0;
		}

		Mob var5 = this.mbb[var1];
		boolean var6 = false;

		for (int var7 = 0; var7 < this.kbb; ++var7) {
			if (this.obb[var7].index == var1) {
				var6 = true;
				break;
			}
		}

		if (var6) {
			var5.field_503 = var4;
			int var8 = var5.field_505;
			if (var2 != var5.waypoint_hist_x[var8] || var3 != var5.waypoint_hist_y[var8]) {
				var5.field_505 = var8 = (var8 + 1) % 10;
				var5.waypoint_hist_x[var8] = var2;
				var5.waypoint_hist_y[var8] = var3;
			}
		} else {
			var5.index = var1;
			var5.field_504 = 0;
			var5.field_505 = 0;
			var5.waypoint_hist_x[0] = var5.cur_x = var2;
			var5.waypoint_hist_y[0] = var5.cur_y = var3;
			var5.field_503 = var5.field_502 = var4;
			var5.field_501 = 0;
		}

		this.nbb[this.jbb++] = var5;
		return var5;
	}


	public Mob method_194(int var1, int var2, int var3, int var4, int var5) {
		if (this.xbb[var1] == null) {
			this.xbb[var1] = new Mob();
			this.xbb[var1].index = var1;
		}

		Mob var6 = this.xbb[var1];
		boolean var7 = false;

		for (int var8 = 0; var8 < this.wbb; ++var8) {
			if (this.zbb[var8].index == var1) {
				var7 = true;
				break;
			}
		}

		if (var7) {
			var6.field_500 = var5;
			var6.field_503 = var4;
			int var9 = var6.field_505;
			if (var2 != var6.waypoint_hist_x[var9] || var3 != var6.waypoint_hist_y[var9]) {
				var6.field_505 = var9 = (var9 + 1) % 10;
				var6.waypoint_hist_x[var9] = var2;
				var6.waypoint_hist_y[var9] = var3;
			}
		} else {
			var6.index = var1;
			var6.field_504 = 0;
			var6.field_505 = 0;
			var6.waypoint_hist_x[0] = var6.cur_x = var2;
			var6.waypoint_hist_y[0] = var6.cur_y = var3;
			var6.field_500 = var5;
			var6.field_503 = var6.field_502 = var4;
			var6.field_501 = 0;
		}

		this.ybb[this.vbb++] = var6;
		return var6;
	}

	@Override
	public void handle_frame(int id, int len, byte[] buf) {
		int var6;
		try {
			int var8;
			int var9;
			int var10;
			int var12;
			int var13;
			int var14;
			int var15;
			int var20;
			int var21;
			int var27;
			boolean var35;
			byte var39;
			if (id == 255) {
				this.kbb = this.jbb;

				for (var20 = 0; var20 < this.kbb; ++var20) {
					this.obb[var20] = this.nbb[var20];
				}

				var39 = 8;
				this.qbb = DataUtil.method_10(buf, var39, 10);
				var21 = var39 + 10;
				this.rbb = DataUtil.method_10(buf, var21, 12);
				var21 += 12;
				var6 = DataUtil.method_10(buf, var21, 4);
				var21 += 4;
				boolean var28 = this.method_214(this.qbb, this.rbb);
				this.qbb -= this.pab;
				this.rbb -= this.qab;
				var8 = this.qbb * this.field_200 + 64;
				var9 = this.rbb * this.field_200 + 64;
				if (var28) {
					this.pbb.field_505 = 0;
					this.pbb.field_504 = 0;
					this.pbb.cur_x = this.pbb.waypoint_hist_x[0] = var8;
					this.pbb.cur_y = this.pbb.waypoint_hist_y[0] = var9;
				}

				this.jbb = 0;
				this.pbb = this.method_193(this.sbb, var8, var9, var6);
				var10 = DataUtil.method_10(buf, var21, 8);
				var21 += 8;
				var27 = 0;

				while (true) {
					int var36;
					if (var27 >= var10) {
						var12 = 0;

						while (var21 + 24 < len * 8) {
							var13 = DataUtil.method_10(buf, var21, 11);
							var21 += 11;
							var14 = DataUtil.method_10(buf, var21, 5);
							var21 += 5;
							if (var14 > 15) {
								var14 -= 32;
							}

							var15 = DataUtil.method_10(buf, var21, 5);
							var21 += 5;
							if (var15 > 15) {
								var15 -= 32;
							}

							var6 = DataUtil.method_10(buf, var21, 4);
							var21 += 4;
							var36 = DataUtil.method_10(buf, var21, 1);
							++var21;
							var8 = (this.qbb + var14) * this.field_200 + 64;
							var9 = (this.rbb + var15) * this.field_200 + 64;
							this.method_193(var13, var8, var9, var6);
							if (var36 == 0) {
								this.acb[var12++] = var13;
							}
						}

						if (var12 > 0) {
							conn.enter(254);
							conn.short_put(var12);

							for (var13 = 0; var13 < var12; ++var13) {
								Mob var40 = this.mbb[this.acb[var13]];
								conn.short_put(var40.index);
								conn.short_put(var40.field_497);
							}

							conn.exit();
							var35 = false;
							return;
						}
						break;
					}

					label1093: {
						Mob var38 = this.obb[var27 + 1];
						var13 = DataUtil.method_10(buf, var21, 1);
						++var21;
						if (var13 != 0) {
							var14 = DataUtil.method_10(buf, var21, 1);
							++var21;
							if (var14 == 0) {
								var15 = DataUtil.method_10(buf, var21, 3);
								var21 += 3;
								var36 = var38.field_505;
								int var17 = var38.waypoint_hist_x[var36];
								int var18 = var38.waypoint_hist_y[var36];
								if (var15 == 2 || var15 == 1 || var15 == 3) {
									var17 += this.field_200;
								}

								if (var15 == 6 || var15 == 5 || var15 == 7) {
									var17 -= this.field_200;
								}

								if (var15 == 4 || var15 == 3 || var15 == 5) {
									var18 += this.field_200;
								}

								if (var15 == 0 || var15 == 1 || var15 == 7) {
									var18 -= this.field_200;
								}

								var38.field_503 = var15;
								var38.field_505 = var36 = (var36 + 1) % 10;
								var38.waypoint_hist_x[var36] = var17;
								var38.waypoint_hist_y[var36] = var18;
							} else {
								var15 = DataUtil.method_10(buf, var21, 4);
								if ((var15 & 12) == 12) {
									var21 += 2;
									break label1093;
								}

								var38.field_503 = DataUtil.method_10(buf, var21, 4);
								var21 += 4;
							}
						}

						this.nbb[this.jbb++] = var38;
					}

					++var27;
				}
			} else {
				int var7;
				if (id == 254) {
					var20 = 1;

					while (true) {
						while (var20 < len) {
							if (DataUtil.unsign(buf[var20]) == 255) {
								var21 = 0;
								var6 = this.qbb + buf[var20 + 1] >> 3;
								var7 = this.rbb + buf[var20 + 2] >> 3;
								var20 += 3;

								for (var8 = 0; var8 < this.ccb; ++var8) {
									var9 = (this.dcb[var8] >> 3) - var6;
									var10 = (this.ecb[var8] >> 3) - var7;
									if (var9 != 0 || var10 != 0) {
										if (var8 != var21) {
											this.dcb[var21] = this.dcb[var8];
											this.ecb[var21] = this.ecb[var8];
											this.fcb[var21] = this.fcb[var8];
											this.gcb[var21] = this.gcb[var8];
										}

										++var21;
									}
								}

								this.ccb = var21;
							} else {
								var21 = DataUtil.short_get(buf, var20);
								var20 += 2;
								var6 = this.qbb + buf[var20++];
								var7 = this.rbb + buf[var20++];
								if ((var21 & '\u8000') == 0) {
									this.dcb[this.ccb] = var6;
									this.ecb[this.ccb] = var7;
									this.fcb[this.ccb] = var21;
									this.gcb[this.ccb] = 0;

									for (var8 = 0; var8 < this.icb; ++var8) {
										if (this.kcb[var8] == var6 && this.lcb[var8] == var7) {
											this.gcb[this.ccb] = Config.obj_elevation[this.mcb[var8]];
											break;
										}
									}

									++this.ccb;
								} else {
									var21 &= 32767;
									var8 = 0;

									for (var9 = 0; var9 < this.ccb; ++var9) {
										if (this.dcb[var9] == var6 && this.ecb[var9] == var7
												&& this.fcb[var9] == var21) {
											var21 = -123;
										} else {
											if (var9 != var8) {
												this.dcb[var8] = this.dcb[var9];
												this.ecb[var8] = this.ecb[var9];
												this.fcb[var8] = this.fcb[var9];
												this.gcb[var8] = this.gcb[var9];
											}

											++var8;
										}
									}

									this.ccb = var8;
								}
							}
						}

						return;
					}
				}

				if (id == 253) {
					var20 = 1;

					while (true) {
						while (var20 < len) {
							if (DataUtil.unsign(buf[var20]) == 255) {
								var21 = 0;
								var6 = this.qbb + buf[var20 + 1] >> 3;
								var7 = this.rbb + buf[var20 + 2] >> 3;
								var20 += 3;

								for (var8 = 0; var8 < this.icb; ++var8) {
									var9 = (this.kcb[var8] >> 3) - var6;
									var10 = (this.lcb[var8] >> 3) - var7;
									if (var9 == 0 && var10 == 0) {
										this.scene.remove(this.jcb[var8]);
										this.terrian.obj_remove(this.kcb[var8], this.lcb[var8], this.mcb[var8]);
									} else {
										if (var8 != var21) {
											this.jcb[var21] = this.jcb[var8];
											this.jcb[var21].field_291 = var21;
											this.kcb[var21] = this.kcb[var8];
											this.lcb[var21] = this.lcb[var8];
											this.mcb[var21] = this.mcb[var8];
											this.ncb[var21] = this.ncb[var8];
										}

										++var21;
									}
								}

								this.icb = var21;
							} else {
								var21 = DataUtil.short_get(buf, var20);
								var20 += 2;
								var6 = this.qbb + buf[var20++];
								var7 = this.rbb + buf[var20++];
								var8 = 0;

								for (var9 = 0; var9 < this.icb; ++var9) {
									if (this.kcb[var9] == var6 && this.lcb[var9] == var7) {
										this.scene.remove(this.jcb[var9]);
										this.terrian.obj_remove(this.kcb[var9], this.lcb[var9], this.mcb[var9]);
									} else {
										if (var9 != var8) {
											this.jcb[var8] = this.jcb[var9];
											this.jcb[var8].field_291 = var8;
											this.kcb[var8] = this.kcb[var9];
											this.lcb[var8] = this.lcb[var9];
											this.mcb[var8] = this.mcb[var9];
											this.ncb[var8] = this.ncb[var9];
										}

										++var8;
									}
								}

								this.icb = var8;
								if (var21 != 60000) {
									var10 = this.terrian.method_102(var6, var7);
									if (var10 != 0 && var10 != 4) {
										var12 = Config.obj_width[var21];
										var27 = Config.obj_height[var21];
									} else {
										var27 = Config.obj_width[var21];
										var12 = Config.obj_height[var21];
									}

									var13 = (var6 + var6 + var27) * this.field_200 / 2;
									var14 = (var7 + var7 + var12) * this.field_200 / 2;
									var15 = Config.obj_model[var21];
									Model var16 = this.models[var15].method_274();
									this.scene.add(var16);
									var16.field_291 = this.icb;
									var16.method_256(0, var10 * 32, 0);
									var16.method_258(var13, -this.terrian.calc_z(var13, var14), var14);
									var16.set_light(true, 48, 48, -50, -10, -50);
									this.terrian.obj_plot(var6, var7, var21);
									if (var21 == 74) {
										var16.method_258(0, -480, 0);
									}

									this.kcb[this.icb] = var6;
									this.lcb[this.icb] = var7;
									this.mcb[this.icb] = var21;
									this.ncb[this.icb] = var10;
									this.jcb[this.icb++] = var16;
								}
							}
						}

						return;
					}
				}

				byte var4;
				if (id == 252) {
					var4 = 1;
					var20 = var4 + 1;
					this.adb = buf[var4] & 255;

					for (var21 = 0; var21 < this.adb; ++var21) {
						var6 = DataUtil.short_get(buf, var20);
						var20 += 2;
						this.bdb[var21] = var6 & 32767;
						this.ddb[var21] = var6 / '\u8000';
						if (Config.item_stackable[var6 & 32767] == 0) {
							this.cdb[var21] = DataUtil.method_9(buf, var20);
							if (this.cdb[var21] >= 128) {
								var20 += 4;
							} else {
								++var20;
							}
						} else {
							this.cdb[var21] = 1;
						}
					}

					return;
				}

				Mob var24;
				if (id == 250) {
					var20 = DataUtil.short_get(buf, 1);
					var21 = 3;

					for (var6 = 0; var6 < var20; ++var6) {
						var7 = DataUtil.short_get(buf, var21);
						var21 += 2;
						var24 = this.mbb[var7];
						byte var29 = buf[var21];
						++var21;
						if (var29 == 0) {
							var10 = DataUtil.short_get(buf, var21);
							var21 += 2;
							if (var24 != null) {
								var24.field_512 = 150;
								var24.field_511 = var10;
							}
						} else {
							byte var34;
							String var37;
							if (var29 == 1) {
								var34 = buf[var21];
								++var21;
								if (var24 != null) {
									var37 = DataUtil.decode_censor(buf, var21, var34, true);
									var35 = false;

									for (var13 = 0; var13 < super.ignore_cnt; ++var13) {
										if (super.ignore_hash[var13] == var24.hash) {
											var35 = true;
										}
									}

									if (!var35) {
										var24.field_510 = 150;
										var24.field_509 = var37;
										this.show_message(var24.name + ": " + var24.field_509, 2);
									}
								}

								var21 += var34;
							} else if (var29 == 2) {
								var10 = DataUtil.unsign(buf[var21]);
								++var21;
								var27 = DataUtil.unsign(buf[var21]);
								++var21;
								var12 = DataUtil.unsign(buf[var21]);
								++var21;
								if (var24 != null) {
									var24.field_513 = var10;
									var24.field_514 = var27;
									var24.field_515 = var12;
									var24.field_516 = 200;
									if (var24 == this.pbb) {
										this.hdb[3] = var27;
										this.idb[3] = var12;
										this.iib = false;
										this.oib = false;
									}
								}
							} else if (var29 == 3) {
								var10 = DataUtil.short_get(buf, var21);
								var21 += 2;
								var27 = DataUtil.short_get(buf, var21);
								var21 += 2;
								if (var24 != null) {
									var24.field_522 = var10;
									var24.field_524 = var27;
									var24.field_523 = -1;
									var24.field_525 = this.bab;
								}
							} else if (var29 == 4) {
								var10 = DataUtil.short_get(buf, var21);
								var21 += 2;
								var27 = DataUtil.short_get(buf, var21);
								var21 += 2;
								if (var24 != null) {
									var24.field_522 = var10;
									var24.field_523 = var27;
									var24.field_524 = -1;
									var24.field_525 = this.bab;
								}
							} else if (var29 != 5) {
								if (var29 == 6) {
									var34 = buf[var21];
									++var21;
									if (var24 != null) {
										var37 = DataUtil.decode_censor(buf, var21, var34, false);
										var24.field_510 = 150;
										var24.field_509 = var37;
										if (var24 == this.pbb) {
											this.show_message(var24.name + ": " + var24.field_509, 5);
										}
									}

									var21 += var34;
								}
							} else if (var24 == null) {
								var21 += 14;
								var10 = DataUtil.unsign(buf[var21]);
								var21 += var10 + 1;
							} else {
								var24.field_497 = DataUtil.short_get(buf, var21);
								var21 += 2;
								var24.hash = DataUtil.long_get(buf, var21);
								var21 += 8;
								var24.name = DataUtil.decode_name(var24.hash);
								var10 = DataUtil.unsign(buf[var21]);
								++var21;

								for (var27 = 0; var27 < var10; ++var27) {
									var24.sprites[var27] = DataUtil.unsign(buf[var21]);
									++var21;
								}

								for (var12 = var10; var12 < 12; ++var12) {
									var24.sprites[var12] = 0;
								}

								var24.field_518 = buf[var21++] & 255;
								var24.field_519 = buf[var21++] & 255;
								var24.field_520 = buf[var21++] & 255;
								var24.field_521 = buf[var21++] & 255;
								var24.field_517 = buf[var21++] & 255;
								var24.field_528 = buf[var21++] & 255;
							}
						}
					}

					return;
				}

				if (id == 249) {
					var20 = 1;

					while (true) {
						while (var20 < len) {
							if (DataUtil.unsign(buf[var20]) == 255) {
								var21 = 0;
								var6 = this.qbb + buf[var20 + 1] >> 3;
								var7 = this.rbb + buf[var20 + 2] >> 3;
								var20 += 3;

								for (var8 = 0; var8 < this.rcb; ++var8) {
									var9 = (this.tcb[var8] >> 3) - var6;
									var10 = (this.ucb[var8] >> 3) - var7;
									if (var9 == 0 && var10 == 0) {
										this.scene.remove(this.scb[var8]);
										this.terrian.wall_remove(this.tcb[var8], this.ucb[var8], this.vcb[var8],
												this.wcb[var8]);
									} else {
										if (var8 != var21) {
											this.scb[var21] = this.scb[var8];
											this.scb[var21].field_291 = var21 + 10000;
											this.tcb[var21] = this.tcb[var8];
											this.ucb[var21] = this.ucb[var8];
											this.vcb[var21] = this.vcb[var8];
											this.wcb[var21] = this.wcb[var8];
										}

										++var21;
									}
								}

								this.rcb = var21;
							} else {
								var21 = DataUtil.short_get(buf, var20);
								var20 += 2;
								var6 = this.qbb + buf[var20++];
								var7 = this.rbb + buf[var20++];
								byte var26 = buf[var20++];
								var9 = 0;

								for (var10 = 0; var10 < this.rcb; ++var10) {
									if (this.tcb[var10] == var6 && this.ucb[var10] == var7
											&& this.vcb[var10] == var26) {
										this.scene.remove(this.scb[var10]);
										this.terrian.wall_remove(this.tcb[var10], this.ucb[var10], this.vcb[var10],
												this.wcb[var10]);
									} else {
										if (var10 != var9) {
											this.scb[var9] = this.scb[var10];
											this.scb[var9].field_291 = var9 + 10000;
											this.tcb[var9] = this.tcb[var10];
											this.ucb[var9] = this.ucb[var10];
											this.vcb[var9] = this.vcb[var10];
											this.wcb[var9] = this.wcb[var10];
										}

										++var9;
									}
								}

								this.rcb = var9;
								if (var21 != 65535) {
									this.terrian.wall_plot(var6, var7, var26, var21);
									Model var33 = this.method_215(var6, var7, var26, var21, this.rcb);
									this.scb[this.rcb] = var33;
									this.tcb[this.rcb] = var6;
									this.ucb[this.rcb] = var7;
									this.wcb[this.rcb] = var21;
									this.vcb[this.rcb++] = var26;
								}
							}
						}

						return;
					}
				}

				if (id == 248) {
					this.wbb = this.vbb;
					this.vbb = 0;

					for (var20 = 0; var20 < this.wbb; ++var20) {
						this.zbb[var20] = this.ybb[var20];
					}

					var39 = 8;
					var6 = DataUtil.method_10(buf, var39, 8);
					var21 = var39 + 8;

					for (var7 = 0; var7 < var6; ++var7) {
						var24 = this.zbb[var7];
						var9 = DataUtil.method_10(buf, var21, 1);
						++var21;
						if (var9 != 0) {
							var10 = DataUtil.method_10(buf, var21, 1);
							++var21;
							if (var10 == 0) {
								var27 = DataUtil.method_10(buf, var21, 3);
								var21 += 3;
								var12 = var24.field_505;
								var13 = var24.waypoint_hist_x[var12];
								var14 = var24.waypoint_hist_y[var12];
								if (var27 == 2 || var27 == 1 || var27 == 3) {
									var13 += this.field_200;
								}

								if (var27 == 6 || var27 == 5 || var27 == 7) {
									var13 -= this.field_200;
								}

								if (var27 == 4 || var27 == 3 || var27 == 5) {
									var14 += this.field_200;
								}

								if (var27 == 0 || var27 == 1 || var27 == 7) {
									var14 -= this.field_200;
								}

								var24.field_503 = var27;
								var24.field_505 = var12 = (var12 + 1) % 10;
								var24.waypoint_hist_x[var12] = var13;
								var24.waypoint_hist_y[var12] = var14;
							} else {
								var27 = DataUtil.method_10(buf, var21, 4);
								if ((var27 & 12) == 12) {
									var21 += 2;
									continue;
								}

								var24.field_503 = DataUtil.method_10(buf, var21, 4);
								var21 += 4;
							}
						}

						this.ybb[this.vbb++] = var24;
					}

					for (; var21 + 31 < len * 8; this.method_194(var8, var12, var13, var27, var14)) {
						var8 = DataUtil.method_10(buf, var21, 11);
						var21 += 11;
						var9 = DataUtil.method_10(buf, var21, 5);
						var21 += 5;
						if (var9 > 15) {
							var9 -= 32;
						}

						var10 = DataUtil.method_10(buf, var21, 5);
						var21 += 5;
						if (var10 > 15) {
							var10 -= 32;
						}

						var27 = DataUtil.method_10(buf, var21, 4);
						var21 += 4;
						var12 = (this.qbb + var9) * this.field_200 + 64;
						var13 = (this.rbb + var10) * this.field_200 + 64;
						var14 = DataUtil.method_10(buf, var21, 9);
						var21 += 9;
						if (var14 >= Config.npc_cnt) {
							var14 = 24;
						}
					}

					return;
				}

				if (id == 247) {
					var20 = DataUtil.short_get(buf, 1);
					var21 = 3;

					for (var6 = 0; var6 < var20; ++var6) {
						var7 = DataUtil.short_get(buf, var21);
						var21 += 2;
						var24 = this.xbb[var7];
						var9 = DataUtil.unsign(buf[var21]);
						++var21;
						if (var9 == 1) {
							var10 = DataUtil.short_get(buf, var21);
							var21 += 2;
							byte var32 = buf[var21];
							++var21;
							if (var24 != null) {
								String var31 = DataUtil.decode_censor(buf, var21, var32, false);
								var24.field_510 = 150;
								var24.field_509 = var31;
								if (var10 == this.pbb.index) {
									this.show_message(
											"@yel@" + Config.npc_name[var24.field_500] + ": " + var24.field_509, 5);
								}
							}

							var21 += var32;
						} else if (var9 == 2) {
							var10 = DataUtil.unsign(buf[var21]);
							++var21;
							var27 = DataUtil.unsign(buf[var21]);
							++var21;
							var12 = DataUtil.unsign(buf[var21]);
							++var21;
							if (var24 != null) {
								var24.field_513 = var10;
								var24.field_514 = var27;
								var24.field_515 = var12;
								var24.field_516 = 200;
							}
						}
					}

					return;
				}

				if (id == 246) {
					this.zhb = true;
					var20 = DataUtil.unsign(buf[1]);
					this.aib = var20;
					var21 = 2;

					for (var6 = 0; var6 < var20; ++var6) {
						var7 = DataUtil.unsign(buf[var21]);
						++var21;
						this.bib[var6] = new String(buf, var21, var7);
						var21 += var7;
					}

					return;
				}

				if (id == 245) {
					this.zhb = false;
					return;
				}

				if (id == 244) {
					this.uib = true;
					this.sbb = DataUtil.short_get(buf, 1);
					this.lab = DataUtil.short_get(buf, 3);
					this.mab = DataUtil.short_get(buf, 5);
					this.rab = DataUtil.short_get(buf, 7);
					this.nab = DataUtil.short_get(buf, 9);
					this.mab -= this.rab * this.nab;
					return;
				}

				if (id == 243) {
					var20 = 1;

					for (var21 = 0; var21 < 16; ++var21) {
						this.hdb[var21] = DataUtil.unsign(buf[var20++]);
					}

					for (var6 = 0; var6 < 16; ++var6) {
						this.idb[var6] = DataUtil.unsign(buf[var20++]);
					}

					for (var7 = 0; var7 < 16; ++var7) {
						this.jdb[var7] = DataUtil.int_get(buf, var20);
						var20 += 4;
					}

					this.ldb = DataUtil.unsign(buf[var20++]);
					return;
				}

				if (id == 242) {
					for (var20 = 0; var20 < 5; ++var20) {
						this.kdb[var20] = DataUtil.unsign(buf[1 + var20]);
					}

					return;
				}

				if (id == 241) {
					this.sib = 250;
					return;
				}

				if (id == 240) {
					var20 = (len - 1) / 4;

					for (var21 = 0; var21 < var20; ++var21) {
						var6 = this.qbb + DataUtil.method_8(buf, 1 + var21 * 4) >> 3;
						var7 = this.rbb + DataUtil.method_8(buf, 3 + var21 * 4) >> 3;
						var8 = 0;

						for (var9 = 0; var9 < this.ccb; ++var9) {
							var10 = (this.dcb[var9] >> 3) - var6;
							var27 = (this.ecb[var9] >> 3) - var7;
							if (var10 != 0 || var27 != 0) {
								if (var9 != var8) {
									this.dcb[var8] = this.dcb[var9];
									this.ecb[var8] = this.ecb[var9];
									this.fcb[var8] = this.fcb[var9];
									this.gcb[var8] = this.gcb[var9];
								}

								++var8;
							}
						}

						this.ccb = var8;
						var8 = 0;

						for (var10 = 0; var10 < this.icb; ++var10) {
							var27 = (this.kcb[var10] >> 3) - var6;
							var12 = (this.lcb[var10] >> 3) - var7;
							if (var27 == 0 && var12 == 0) {
								this.scene.remove(this.jcb[var10]);
								this.terrian.obj_remove(this.kcb[var10], this.lcb[var10], this.mcb[var10]);
							} else {
								if (var10 != var8) {
									this.jcb[var8] = this.jcb[var10];
									this.jcb[var8].field_291 = var8;
									this.kcb[var8] = this.kcb[var10];
									this.lcb[var8] = this.lcb[var10];
									this.mcb[var8] = this.mcb[var10];
									this.ncb[var8] = this.ncb[var10];
								}

								++var8;
							}
						}

						this.icb = var8;
						var8 = 0;

						for (var27 = 0; var27 < this.rcb; ++var27) {
							var12 = (this.tcb[var27] >> 3) - var6;
							var13 = (this.ucb[var27] >> 3) - var7;
							if (var12 == 0 && var13 == 0) {
								this.scene.remove(this.scb[var27]);
								this.terrian.wall_remove(this.tcb[var27], this.ucb[var27], this.vcb[var27], this.wcb[var27]);
							} else {
								if (var27 != var8) {
									this.scb[var8] = this.scb[var27];
									this.scb[var8].field_291 = var8 + 10000;
									this.tcb[var8] = this.tcb[var27];
									this.ucb[var8] = this.ucb[var27];
									this.vcb[var8] = this.vcb[var27];
									this.wcb[var8] = this.wcb[var27];
								}

								++var8;
							}
						}

						this.rcb = var8;
					}

					return;
				}

				if (id == 239) {
					this.cmb = true;
					return;
				}

				if (id == 238) {
					var20 = DataUtil.short_get(buf, 1);
					if (this.mbb[var20] != null) {
						this.mgb = this.mbb[var20].name;
					}

					this.lgb = true;
					this.tgb = false;
					this.ugb = false;
					this.ngb = 0;
					this.qgb = 0;
					return;
				}

				if (id == 237) {
					this.lgb = false;
					this.ygb = false;
					return;
				}

				if (id == 236) {
					this.qgb = buf[1] & 255;
					var20 = 2;

					for (var21 = 0; var21 < this.qgb; ++var21) {
						this.rgb[var21] = DataUtil.short_get(buf, var20);
						var20 += 2;
						this.sgb[var21] = DataUtil.int_get(buf, var20);
						var20 += 4;
					}

					this.tgb = false;
					this.ugb = false;
					return;
				}

				byte var30;
				if (id == 235) {
					var30 = buf[1];
					if (var30 == 1) {
						this.tgb = true;
						return;
					}

					this.tgb = false;
					return;
				}

				if (id != 234) {
					if (id == 233) {
						this.ghb = false;
						return;
					}

					if (id == 229) {
						var30 = buf[1];
						if (var30 == 1) {
							this.ugb = true;
							return;
						}

						this.ugb = false;
						return;
					}

					if (id == 228) {
						this.eeb = DataUtil.unsign(buf[1]) == 1;
						this.feb = DataUtil.unsign(buf[2]) == 1;
						this.geb = DataUtil.unsign(buf[3]) == 1;
						return;
					}

					if (id == 227) {
						for (var20 = 0; var20 < len - 1; ++var20) {
							boolean var25 = buf[var20 + 1] == 1;
							if (!this.ceb[var20] && var25) {
								this.method_179("prayeron");
							}

							if (this.ceb[var20] && !var25) {
								this.method_179("prayeroff");
							}

							this.ceb[var20] = var25;
						}

						return;
					}

					if (id == 226) {
						for (var20 = 0; var20 < this.zdb; ++var20) {
							this.beb[var20] = buf[var20 + 1] == 1;
						}

						return;
					}

					if (id == 224) {
						this.lkb = true;

						for (var20 = 0; var20 < 5; ++var20) {
							this.ukb[var20] = var20;
							this.vkb[var20] = "~:" + this.ukb[var20];
							this.mkb.set_text(this.rkb[var20], "");
							this.mkb.set_text(this.qkb[var20], var20 + 1 + ": " + this.ymb[this.ukb[var20]]);
						}

						return;
					}

					if (id == 222) {
						this.ohb = true;
						var4 = 1;
						var20 = var4 + 1;
						this.phb = buf[var4] & 255;
						this.xhb = buf[var20++] & 255;

						for (var21 = 0; var21 < this.phb; ++var21) {
							this.qhb[var21] = DataUtil.short_get(buf, var20);
							var20 += 2;
							this.rhb[var21] = DataUtil.method_9(buf, var20);
							if (this.rhb[var21] >= 128) {
								var20 += 4;
							} else {
								++var20;
							}
						}

						this.method_195();
						return;
					}

					if (id == 221) {
						this.ohb = false;
						return;
					}

					if (id == 220) {
						var20 = buf[1] & 255;
						this.jdb[var20] = DataUtil.int_get(buf, 2);
						return;
					}

					if (id == 219) {
						var20 = DataUtil.short_get(buf, 1);
						if (this.mbb[var20] != null) {
							this.lfb = this.mbb[var20].name;
						}

						this.kfb = true;
						this.mfb = 0;
						this.pfb = 0;
						this.sfb = false;
						this.tfb = false;
						this.ufb = false;
						this.vfb = false;
						this.wfb = false;
						this.xfb = false;
						return;
					}

					if (id == 218) {
						this.kfb = false;
						this.yfb = false;
						return;
					}

					if (id == 217) {
						this.ygb = true;
						this.zgb = false;
						this.lgb = false;
						var4 = 1;
						this.xgb = DataUtil.long_get(buf, var4);
						var20 = var4 + 8;
						this.dhb = buf[var20++] & 255;

						for (var21 = 0; var21 < this.dhb; ++var21) {
							this.ehb[var21] = DataUtil.short_get(buf, var20);
							var20 += 2;
							this.fhb[var21] = DataUtil.int_get(buf, var20);
							var20 += 4;
						}

						this.ahb = buf[var20++] & 255;

						for (var6 = 0; var6 < this.ahb; ++var6) {
							this.bhb[var6] = DataUtil.short_get(buf, var20);
							var20 += 2;
							this.chb[var6] = DataUtil.int_get(buf, var20);
							var20 += 4;
						}

						return;
					}

					if (id == 216) {
						this.pfb = buf[1] & 255;
						var20 = 2;

						for (var21 = 0; var21 < this.pfb; ++var21) {
							this.qfb[var21] = DataUtil.short_get(buf, var20);
							var20 += 2;
							this.rfb[var21] = DataUtil.int_get(buf, var20);
							var20 += 4;
						}

						this.sfb = false;
						this.tfb = false;
						return;
					}

					if (id == 215) {
						if (buf[1] == 1) {
							this.ufb = true;
						} else {
							this.ufb = false;
						}

						if (buf[2] == 1) {
							this.vfb = true;
						} else {
							this.vfb = false;
						}

						if (buf[3] == 1) {
							this.wfb = true;
						} else {
							this.wfb = false;
						}

						if (buf[4] == 1) {
							this.xfb = true;
						} else {
							this.xfb = false;
						}

						this.sfb = false;
						this.tfb = false;
						return;
					}

					if (id == 214) {
						var4 = 1;
						var20 = var4 + 1;
						var21 = buf[var4] & 255;
						var6 = DataUtil.short_get(buf, var20);
						var20 += 2;
						var7 = DataUtil.method_9(buf, var20);
						if (var7 >= 128) {
							var20 += 4;
						} else {
							++var20;
						}

						if (var7 == 0) {
							--this.phb;

							for (var8 = var21; var8 < this.phb; ++var8) {
								this.qhb[var8] = this.qhb[var8 + 1];
								this.rhb[var8] = this.rhb[var8 + 1];
							}
						} else {
							this.qhb[var21] = var6;
							this.rhb[var21] = var7;
							if (var21 >= this.phb) {
								this.phb = var21 + 1;
							}
						}

						this.method_195();
						return;
					}

					if (id == 213) {
						var4 = 1;
						var21 = 1;
						var20 = var4 + 1;
						var6 = buf[var4] & 255;
						var7 = DataUtil.short_get(buf, var20);
						var20 += 2;
						if (Config.item_stackable[var7 & 32767] == 0) {
							var21 = DataUtil.method_9(buf, var20);
							if (var21 >= 128) {
								var20 += 4;
							} else {
								++var20;
							}
						}

						this.bdb[var6] = var7 & 32767;
						this.ddb[var6] = var7 / '\u8000';
						this.cdb[var6] = var21;
						if (var6 >= this.adb) {
							this.adb = var6 + 1;
							return;
						}
					} else {
						if (id == 212) {
							var20 = buf[1] & 255;
							--this.adb;

							for (var21 = var20; var21 < this.adb; ++var21) {
								this.bdb[var21] = this.bdb[var21 + 1];
								this.cdb[var21] = this.cdb[var21 + 1];
								this.ddb[var21] = this.ddb[var21 + 1];
							}

							return;
						}

						if (id == 211) {
							var4 = 1;
							var20 = var4 + 1;
							var21 = buf[var4] & 255;
							this.hdb[var21] = DataUtil.unsign(buf[var20++]);
							this.idb[var21] = DataUtil.unsign(buf[var20++]);
							this.jdb[var21] = DataUtil.int_get(buf, var20);
							var20 += 4;
							return;
						}

						if (id == 210) {
							var30 = buf[1];
							if (var30 == 1) {
								this.sfb = true;
								return;
							}

							this.sfb = false;
							return;
						}

						if (id == 209) {
							var30 = buf[1];
							if (var30 == 1) {
								this.tfb = true;
								return;
							}

							this.tfb = false;
							return;
						}

						if (id == 208) {
							this.yfb = true;
							this.zfb = false;
							this.kfb = false;
							var4 = 1;
							this.agb = DataUtil.long_get(buf, var4);
							var20 = var4 + 8;
							this.egb = buf[var20++] & 255;

							for (var21 = 0; var21 < this.egb; ++var21) {
								this.fgb[var21] = DataUtil.short_get(buf, var20);
								var20 += 2;
								this.ggb[var21] = DataUtil.int_get(buf, var20);
								var20 += 4;
							}

							this.bgb = buf[var20++] & 255;

							for (var6 = 0; var6 < this.bgb; ++var6) {
								this.cgb[var6] = DataUtil.short_get(buf, var20);
								var20 += 2;
								this.dgb[var6] = DataUtil.int_get(buf, var20);
								var20 += 4;
							}

							this.hgb = buf[var20++] & 255;
							this.igb = buf[var20++] & 255;
							this.jgb = buf[var20++] & 255;
							this.kgb = buf[var20++] & 255;
							return;
						}

						if (id == 207) {
							String var23 = new String(buf, 1, len - 1);
							this.method_179(var23);
							return;
						}

						if (id == 206) {
							if (this.tmb < 50) {
								var20 = buf[1] & 255;
								var21 = buf[2] + this.qbb;
								var6 = buf[3] + this.rbb;
								this.xmb[this.tmb] = var20;
								this.wmb[this.tmb] = 0;
								this.umb[this.tmb] = var21;
								this.vmb[this.tmb] = var6;
								++this.tmb;
								return;
							}
						} else if (id == 205) {
							if (!this.logged_in) {
								this.lib = DataUtil.int_get(buf, 1);
								this.mib = DataUtil.int_get(buf, 5);
								this.jib = DataUtil.int_get(buf, 9);
								this.nib = (int) (Math.random() * 6.0D);
								this.iib = true;
								this.logged_in = true;
								this.kib = null;
								return;
							}
						} else {
							if (id != 204) {
								return;
							}

							this.pib = new String(buf, 1, len - 1);
							this.oib = true;
						}
					}
				} else {
					this.ghb = true;
					var4 = 1;
					var20 = var4 + 1;
					var21 = buf[var4] & 255;
					byte var22 = buf[var20++];
					this.hhb = buf[var20++] & 255;
					this.ihb = buf[var20++] & 255;

					for (var7 = 0; var7 < 40; ++var7) {
						this.jhb[var7] = -1;
					}

					for (var8 = 0; var8 < var21; ++var8) {
						this.jhb[var8] = DataUtil.short_get(buf, var20);
						var20 += 2;
						this.khb[var8] = DataUtil.short_get(buf, var20);
						var20 += 2;
						this.lhb[var8] = buf[var20++];
					}

					if (var22 == 1) {
						var9 = 39;

						for (var10 = 0; var10 < this.adb && var9 >= var21; ++var10) {
							boolean var11 = false;

							for (var12 = 0; var12 < 40; ++var12) {
								if (this.jhb[var12] == this.bdb[var10]) {
									var11 = true;
									break;
								}
							}

							if (this.bdb[var10] == 10) {
								var11 = true;
							}

							if (!var11) {
								this.jhb[var9] = this.bdb[var10] & 32767;
								this.khb[var9] = 0;
								this.lhb[var9] = 0;
								--var9;
							}
						}
					}

					if (this.mhb >= 0 && this.mhb < 40 && this.jhb[this.mhb] != this.nhb) {
						this.mhb = -1;
						this.nhb = -2;
						return;
					}
				}
			}

			return;
		} catch (RuntimeException var19) {
			if (this.field_178 < 3) {
				conn.enter(17);
				conn.str_put(var19.toString());
				conn.exit();
				conn.enter(17);
				conn.str_put("p-type:" + id + " p-size:" + len);
				conn.exit();
				conn.enter(17);
				conn.str_put("rx:" + this.qbb + " ry:" + this.rbb + " num3l:" + this.icb);
				conn.exit();
				String var5 = "";

				for (var6 = 0; var6 < 80 && var6 < len; ++var6) {
					var5 = var5 + buf[var6] + " ";
				}

				conn.enter(17);
				conn.str_put(var5);
				conn.exit();
				++this.field_178;
			}
		}

	}


	public void method_195() {
		this.shb = this.phb;

		for (int var1 = 0; var1 < this.phb; ++var1) {
			this.thb[var1] = this.qhb[var1];
			this.uhb[var1] = this.rhb[var1];
		}

		for (int var2 = 0; var2 < this.adb && this.shb < this.xhb; ++var2) {
			int var3 = this.bdb[var2];
			boolean var4 = false;

			for (int var5 = 0; var5 < this.shb; ++var5) {
				if (this.thb[var5] == var3) {
					var4 = true;
					break;
				}
			}

			if (!var4) {
				this.thb[this.shb] = var3;
				this.uhb[this.shb] = 0;
				++this.shb;
			}
		}

	}


	public boolean method_196(int var1) {
		int var2 = this.pbb.cur_x / 128;
		int var3 = this.pbb.cur_y / 128;

		for (int var4 = 2; var4 >= 1; --var4) {
			if (var1 == 1 && ((this.terrian.collision_flags[var2][var3 - var4] & 128) == 128
					|| (this.terrian.collision_flags[var2 - var4][var3] & 128) == 128
					|| (this.terrian.collision_flags[var2 - var4][var3 - var4] & 128) == 128)) {
				return false;
			}

			if (var1 == 3 && ((this.terrian.collision_flags[var2][var3 + var4] & 128) == 128
					|| (this.terrian.collision_flags[var2 - var4][var3] & 128) == 128
					|| (this.terrian.collision_flags[var2 - var4][var3 + var4] & 128) == 128)) {
				return false;
			}

			if (var1 == 5 && ((this.terrian.collision_flags[var2][var3 + var4] & 128) == 128
					|| (this.terrian.collision_flags[var2 + var4][var3] & 128) == 128
					|| (this.terrian.collision_flags[var2 + var4][var3 + var4] & 128) == 128)) {
				return false;
			}

			if (var1 == 7 && ((this.terrian.collision_flags[var2][var3 - var4] & 128) == 128
					|| (this.terrian.collision_flags[var2 + var4][var3] & 128) == 128
					|| (this.terrian.collision_flags[var2 + var4][var3 - var4] & 128) == 128)) {
				return false;
			}

			if (var1 == 0 && (this.terrian.collision_flags[var2][var3 - var4] & 128) == 128) {
				return false;
			}

			if (var1 == 2 && (this.terrian.collision_flags[var2 - var4][var3] & 128) == 128) {
				return false;
			}

			if (var1 == 4 && (this.terrian.collision_flags[var2][var3 + var4] & 128) == 128) {
				return false;
			}

			if (var1 == 6 && (this.terrian.collision_flags[var2 + var4][var3] & 128) == 128) {
				return false;
			}
		}

		return true;
	}


	public void method_197() {
		if ((this.dbb & 1) != 1 || !this.method_196(this.dbb)) {
			if ((this.dbb & 1) == 0 && this.method_196(this.dbb)) {
				if (this.method_196(this.dbb + 1 & 7)) {
					this.dbb = this.dbb + 1 & 7;
				} else {
					if (this.method_196(this.dbb + 7 & 7)) {
						this.dbb = this.dbb + 7 & 7;
					}

				}
			} else {
				int[] var1 = new int[] { 1, -1, 2, -2, 3, -3, 4 };

				for (int var2 = 0; var2 < 7; ++var2) {
					if (this.method_196(this.dbb + var1[var2] + 8 & 7)) {
						this.dbb = this.dbb + var1[var2] + 8 & 7;
						break;
					}
				}

				if ((this.dbb & 1) == 0 && this.method_196(this.dbb)) {
					if (this.method_196(this.dbb + 1 & 7)) {
						this.dbb = this.dbb + 1 & 7;
					} else {
						if (this.method_196(this.dbb + 7 & 7)) {
							this.dbb = this.dbb + 7 & 7;
						}

					}
				}
			}
		}
	}


	public void method_198() {
		if (this.sib != 0) {
			this.screen.darken();
			this.screen.center_text_draw("Oh dear! You are dead...", this.wnd_width / 2, this.wnd_height / 2, 7, 16711680);
			this.method_199();
			this.screen.copy(this.graphics, 0, 0);
		} else if (this.cmb) {
			this.method_185();
		} else if (this.lkb) {
			this.method_182();
		} else if (this.terrian.field_97) {
			for (int var1 = 0; var1 < 64; ++var1) {
				this.scene.remove(this.terrian.rooves[this.oab][var1]);
				if (this.oab == 0) {
					this.scene.remove(this.terrian.walls[1][var1]);
					this.scene.remove(this.terrian.rooves[1][var1]);
					this.scene.remove(this.terrian.walls[2][var1]);
					this.scene.remove(this.terrian.rooves[2][var1]);
				}

				this.abb = true;
				if (this.oab == 0
						&& (this.terrian.collision_flags[this.pbb.cur_x / 128][this.pbb.cur_y / 128] & 128) == 0) {
					this.scene.add(this.terrian.rooves[this.oab][var1]);
					if (this.oab == 0) {
						this.scene.add(this.terrian.walls[1][var1]);
						this.scene.add(this.terrian.rooves[1][var1]);
						this.scene.add(this.terrian.walls[2][var1]);
						this.scene.add(this.terrian.rooves[2][var1]);
					}

					this.abb = false;
				}
			}

			int var2;
			int var3;
			int var4;
			int var5;
			int var6;
			byte var7;
			String var8;
			int var9;
			Model var10;
			if (this.dab != this.fab) {
				this.fab = this.dab;

				for (var2 = 0; var2 < this.icb; ++var2) {
					if (this.mcb[var2] == 51) {
						var3 = this.kcb[var2];
						var4 = this.lcb[var2];
						var5 = var3 - this.pbb.cur_x / 128;
						var6 = var4 - this.pbb.cur_y / 128;
						var7 = 7;
						if (var3 >= 0 && var4 >= 0 && var3 < 96 && var4 < 96 && var5 > -var7 && var5 < var7
								&& var6 > -var7 && var6 < var7) {
							this.scene.remove(this.jcb[var2]);
							var8 = "torcha" + (this.dab + 1);
							var9 = Config.model_lookup(var8);
							var10 = this.models[var9].method_274();
							this.scene.add(var10);
							var10.set_light(true, 48, 48, -50, -10, -50);
							var10.method_276(this.jcb[var2]);
							var10.field_291 = var2;
							this.jcb[var2] = var10;
						}
					}

					if (this.mcb[var2] == 143) {
						var3 = this.kcb[var2];
						var4 = this.lcb[var2];
						var5 = var3 - this.pbb.cur_x / 128;
						var6 = var4 - this.pbb.cur_y / 128;
						var7 = 7;
						if (var3 >= 0 && var4 >= 0 && var3 < 96 && var4 < 96 && var5 > -var7 && var5 < var7
								&& var6 > -var7 && var6 < var7) {
							this.scene.remove(this.jcb[var2]);
							var8 = "skulltorcha" + (this.dab + 1);
							var9 = Config.model_lookup(var8);
							var10 = this.models[var9].method_274();
							this.scene.add(var10);
							var10.set_light(true, 48, 48, -50, -10, -50);
							var10.method_276(this.jcb[var2]);
							var10.field_291 = var2;
							this.jcb[var2] = var10;
						}
					}
				}
			}

			if (this.eab != this.gab) {
				this.gab = this.eab;

				for (var2 = 0; var2 < this.icb; ++var2) {
					if (this.mcb[var2] == 97) {
						var3 = this.kcb[var2];
						var4 = this.lcb[var2];
						var5 = var3 - this.pbb.cur_x / 128;
						var6 = var4 - this.pbb.cur_y / 128;
						var7 = 9;
						if (var3 >= 0 && var4 >= 0 && var3 < 96 && var4 < 96 && var5 > -var7 && var5 < var7
								&& var6 > -var7 && var6 < var7) {
							this.scene.remove(this.jcb[var2]);
							var8 = "firea" + (this.eab + 1);
							var9 = Config.model_lookup(var8);
							var10 = this.models[var9].method_274();
							this.scene.add(var10);
							var10.set_light(true, 48, 48, -50, -10, -50);
							var10.method_276(this.jcb[var2]);
							var10.field_291 = var2;
							this.jcb[var2] = var10;
						}
					}

					if (this.mcb[var2] == 274) {
						var3 = this.kcb[var2];
						var4 = this.lcb[var2];
						var5 = var3 - this.pbb.cur_x / 128;
						var6 = var4 - this.pbb.cur_y / 128;
						var7 = 9;
						if (var3 >= 0 && var4 >= 0 && var3 < 96 && var4 < 96 && var5 > -var7 && var5 < var7
								&& var6 > -var7 && var6 < var7) {
							this.scene.remove(this.jcb[var2]);
							var8 = "fireplacea" + (this.eab + 1);
							var9 = Config.model_lookup(var8);
							var10 = this.models[var9].method_274();
							this.scene.add(var10);
							var10.set_light(true, 48, 48, -50, -10, -50);
							var10.method_276(this.jcb[var2]);
							var10.field_291 = var2;
							this.jcb[var2] = var10;
						}
					}
				}
			}

			this.scene.reduce(this.lbb);
			this.lbb = 0;

			int var18;
			for (var2 = 0; var2 < this.jbb; ++var2) {
				Mob var15 = this.nbb[var2];
				if (var15.field_520 != 255) {
					var4 = var15.cur_x;
					var5 = var15.cur_y;
					var6 = -this.terrian.calc_z(var4, var5);
					var18 = this.scene.sprite_add(5000 + var2, var4, var6, var5, 145, 220, var2 + 10000);
					++this.lbb;
					if (var15 == this.pbb) {
						this.scene.set_local_player(var18);
					}

					if (var15.field_502 == 8) {
						this.scene.set_trans_x(var18, -30);
					}

					if (var15.field_502 == 9) {
						this.scene.set_trans_x(var18, 30);
					}
				}
			}

			Mob var17;
			int var19;
			for (var3 = 0; var3 < this.jbb; ++var3) {
				Mob var16 = this.nbb[var3];
				if (var16.field_525 > 0) {
					var17 = null;
					if (var16.field_524 != -1) {
						var17 = this.xbb[var16.field_524];
					} else if (var16.field_523 != -1) {
						var17 = this.mbb[var16.field_523];
					}

					if (var17 != null) {
						var6 = var16.cur_x;
						var18 = var16.cur_y;
						var19 = -this.terrian.calc_z(var6, var18) - 110;
						var9 = var17.cur_x;
						int var20 = var17.cur_y;
						int var11 = -this.terrian.calc_z(var9, var20) - Config.npc_height[var17.field_500] / 2;
						int var12 = (var6 * var16.field_525 + var9 * (this.bab - var16.field_525)) / this.bab;
						int var13 = (var19 * var16.field_525 + var11 * (this.bab - var16.field_525)) / this.bab;
						int var14 = (var18 * var16.field_525 + var20 * (this.bab - var16.field_525)) / this.bab;
						this.scene.sprite_add(this.proj_sprite_off + var16.field_522, var12, var13, var14, 32, 32, 0);
						++this.lbb;
					}
				}
			}

			for (var4 = 0; var4 < this.vbb; ++var4) {
				var17 = this.ybb[var4];
				var6 = var17.cur_x;
				var18 = var17.cur_y;
				var19 = -this.terrian.calc_z(var6, var18);
				var9 = this.scene.sprite_add(20000 + var4, var6, var19, var18, Config.npc_width[var17.field_500],
						Config.npc_height[var17.field_500], var4 + 30000);
				++this.lbb;
				if (var17.field_502 == 8) {
					this.scene.set_trans_x(var9, -30);
				}

				if (var17.field_502 == 9) {
					this.scene.set_trans_x(var9, 30);
				}
			}

			for (var5 = 0; var5 < this.ccb; ++var5) {
				var6 = this.dcb[var5] * this.field_200 + 64;
				var18 = this.ecb[var5] * this.field_200 + 64;
				this.scene.sprite_add('\u9c40' + this.fcb[var5], var6,
						-this.terrian.calc_z(var6, var18) - this.gcb[var5], var18, 96, 64, var5 + 20000);
				++this.lbb;
			}

			for (var6 = 0; var6 < this.tmb; ++var6) {
				var18 = this.umb[var6] * this.field_200 + 64;
				var19 = this.vmb[var6] * this.field_200 + 64;
				var9 = this.xmb[var6];
				if (var9 == 0) {
					this.scene.sprite_add('\uc350' + var6, var18, -this.terrian.calc_z(var18, var19), var19, 128,
							256, var6 + '\uc350');
					++this.lbb;
				}

				if (var9 == 1) {
					this.scene.sprite_add('\uc350' + var6, var18, -this.terrian.calc_z(var18, var19), var19, 128, 64,
							var6 + '\uc350');
					++this.lbb;
				}
			}

			this.screen.reduce_lag = false;
			this.screen.clear();
			this.screen.reduce_lag = super.reduce_lag;
			if (this.oab == 3) {
				var18 = 40 + (int) (Math.random() * 3.0D);
				var19 = 40 + (int) (Math.random() * 7.0D);
				this.scene.set_light(var18, var19, -50, -10, -50);
			}

			this.qlb = 0;
			this.klb = 0;
			this.vlb = 0;
			if (this.deb) {
				if (this.eeb && !this.abb) {
					var18 = this.dbb;
					this.method_197();
					if (this.dbb != var18) {
						this.bbb = this.pbb.cur_x;
						this.cbb = this.pbb.cur_y;
					}
				}

				this.scene.clip_far_3d = 3000;
				this.scene.clip_far_2d = 3000;
				this.scene.fog_falloff = 1;
				this.scene.fog_distance = 2800;
				this.fbb = this.dbb * 32;
				var18 = this.bbb + this.field_191;
				var19 = this.cbb + this.field_193;
				this.scene.set_camera(var18, -this.terrian.calc_z(var18, var19), var19, 912, this.fbb * 4, 0, 2000);
			} else {
				if (this.eeb && !this.abb) {
					this.method_197();
				}

				if (!super.reduce_lag) {
					this.scene.clip_far_3d = 2400;
					this.scene.clip_far_2d = 2400;
					this.scene.fog_falloff = 1;
					this.scene.fog_distance = 2300;
				} else {
					this.scene.clip_far_3d = 2200;
					this.scene.clip_far_2d = 2200;
					this.scene.fog_falloff = 1;
					this.scene.fog_distance = 2100;
				}

				var18 = this.bbb + this.field_191;
				var19 = this.cbb + this.field_193;
				this.scene.set_camera(var18, -this.terrian.calc_z(var18, var19), var19, 912, this.fbb * 4, 0,
						this.zab * 2);
			}

			this.scene.render();
			this.method_204();
			if (this.hab > 0) {
				this.screen.sprite_plot(this.iab - 8, this.jab - 8, this.ui_sprite_off + 14 + (24 - this.hab) / 6);
			}

			if (this.hab < 0) {
				this.screen.sprite_plot(this.iab - 8, this.jab - 8, this.ui_sprite_off + 18 + (24 + this.hab) / 6);
			}

			if (!this.uib) {
				var18 = 2203 - (this.rbb + this.mab + this.qab);
				if (this.qbb + this.lab + this.pab >= 2640) {
					var18 = -50;
				}

				if (var18 > 0) {
					var19 = 1 + var18 / 6;
					this.screen.sprite_plot(453, this.wnd_height - 56, this.ui_sprite_off + 13);
					this.screen.center_text_draw("Wilderness", 465, this.wnd_height - 20, 1, 16776960);
					this.screen.center_text_draw("Level: " + var19, 465, this.wnd_height - 7, 1, 16776960);
					if (this.tib == 0) {
						this.tib = 2;
					}
				}

				if (this.tib == 0 && var18 > -10 && var18 <= 0) {
					this.tib = 1;
				}
			}

			if (this.gfb == 0) {
				for (var18 = 0; var18 < this.hfb; ++var18) {
					if (this.jfb[var18] > 0) {
						var8 = this.ifb[var18];
						this.screen.text_draw(var8, 7, this.wnd_height - 18 - var18 * 12, 1, 16776960);
					}
				}
			}

			this.bfb.disable(this.cfb);
			this.bfb.disable(this.efb);
			this.bfb.disable(this.ffb);
			if (this.gfb == 1) {
				this.bfb.enable(this.cfb);
			} else if (this.gfb == 2) {
				this.bfb.enable(this.efb);
			} else if (this.gfb == 3) {
				this.bfb.enable(this.ffb);
			}

			Menu.field_391 = 2;
			this.bfb.display();
			Menu.field_391 = 0;
			screen.trans_sprite_plot(screen.width - 3 - 197, 3, ui_sprite_off, 128);
			this.method_216();
			this.screen.logged_in = false;
			this.method_199();
			this.screen.copy(this.graphics, 0, 0);
		}
	}


	public void method_199() {
		this.screen.sprite_plot(0, this.wnd_height - 4, this.ui_sprite_off + 23);
		int var1 = Surface.rgb(200, 200, 255);
		if (this.gfb == 0) {
			var1 = Surface.rgb(255, 200, 50);
		}

		if (this.xeb % 30 > 15) {
			var1 = Surface.rgb(255, 50, 50);
		}

		this.screen.center_text_draw("All messages", 54, this.wnd_height + 6, 0, var1);
		var1 = Surface.rgb(200, 200, 255);
		if (this.gfb == 1) {
			var1 = Surface.rgb(255, 200, 50);
		}

		if (this.yeb % 30 > 15) {
			var1 = Surface.rgb(255, 50, 50);
		}

		this.screen.center_text_draw("Chat history", 155, this.wnd_height + 6, 0, var1);
		var1 = Surface.rgb(200, 200, 255);
		if (this.gfb == 2) {
			var1 = Surface.rgb(255, 200, 50);
		}

		if (this.zeb % 30 > 15) {
			var1 = Surface.rgb(255, 50, 50);
		}

		this.screen.center_text_draw("Quest history", 255, this.wnd_height + 6, 0, var1);
		var1 = Surface.rgb(200, 200, 255);
		if (this.gfb == 3) {
			var1 = Surface.rgb(255, 200, 50);
		}

		if (this.afb % 30 > 15) {
			var1 = Surface.rgb(255, 50, 50);
		}

		this.screen.center_text_draw("Private history", 355, this.wnd_height + 6, 0, var1);
	}


	public void plot_bubble(int var1, int var2, int var3, int var4, int var5, int var6, int var7) {
		int var8 = this.xmb[var5];
		int var9 = this.wmb[var5];
		int var10;
		if (var8 == 0) {
			var10 = 255 + var9 * 5 * 256;
			this.screen.circle_fill(var1 + var3 / 2, var2 + var4 / 2, 20 + var9 * 2, var10, 255 - var9 * 5);
		}

		if (var8 == 1) {
			var10 = 16711680 + var9 * 5 * 256;
			this.screen.circle_fill(var1 + var3 / 2, var2 + var4 / 2, 10 + var9, var10, 255 - var9 * 5);
		}

	}

	public void plot_item(int var1, int var2, int var3, int var4, int var5, int var6, int var7) {
		int var8 = Config.item_sprite[var5] + this.item_sprite_off;
		int var9 = Config.item_tint[var5];
		this.screen.resize_trans_sprite_plot(var1, var2, var3, var4, var8, var9, 0, 0, false);
	}

	public void plot_npc(int var1, int var2, int var3, int var4, int var5, int var6, int var7) {
		Mob var8 = this.ybb[var5];
		int var9 = var8.field_502 + (this.fbb + 16) / 32 & 7;
		boolean var10 = false;
		int var11 = var9;
		if (var9 == 5) {
			var11 = 3;
			var10 = true;
		} else if (var9 == 6) {
			var11 = 2;
			var10 = true;
		} else if (var9 == 7) {
			var11 = 1;
			var10 = true;
		}

		int var12 = var11 * 3 + this.omb[var8.field_501 / Config.npc_speed_walk[var8.field_500] % 4];
		if (var8.field_502 == 8) {
			var11 = 5;
			var9 = 2;
			var10 = false;
			var1 -= Config.npc_cmb_anim[var8.field_500] * var7 / 100;
			var12 = var11 * 3 + this.pmb[this.ticks / (Config.npc_speed_cmb[var8.field_500] - 1) % 8];
		} else if (var8.field_502 == 9) {
			var11 = 5;
			var9 = 2;
			var10 = true;
			var1 += Config.npc_cmb_anim[var8.field_500] * var7 / 100;
			var12 = var11 * 3 + this.qmb[this.ticks / Config.npc_speed_cmb[var8.field_500] % 8];
		}

		int var14;
		int var15;
		for (int var13 = 0; var13 < 12; ++var13) {
			var14 = this.bmb[var9][var13];
			var15 = Config.npc_sprites[var8.field_500][var14];
			if (var15 >= 0) {
				byte var16 = 0;
				byte var17 = 0;
				int var18 = var12;
				if (var10 && var11 >= 1 && var11 <= 3 && Config.anim_has_f[var15] == 1) {
					var18 = var12 + 15;
				}

				if (var11 != 5 || Config.anim_has_a[var15] == 1) {
					int var19 = var18 + Config.anim_unknown2[var15];
					int var23 = var16 * var3 / this.screen.sprite_mask_w[var19];
					int var24 = var17 * var4 / this.screen.sprite_mask_h[var19];
					int var20 = var3 * this.screen.sprite_mask_w[var19]
							/ this.screen.sprite_mask_w[Config.anim_unknown2[var15]];
					var23 -= (var20 - var3) / 2;
					int var21 = Config.anim_mask[var15];
					int var22 = 0;
					if (var21 == 1) {
						var21 = Config.npc_col_hair[var8.field_500];
						var22 = Config.npc_col_skin[var8.field_500];
					} else if (var21 == 2) {
						var21 = Config.npc_col_top[var8.field_500];
						var22 = Config.npc_col_skin[var8.field_500];
					} else if (var21 == 3) {
						var21 = Config.npc_col_bottom[var8.field_500];
						var22 = Config.npc_col_skin[var8.field_500];
					}

					this.screen.resize_trans_sprite_plot(var1 + var23, var2 + var24, var20, var4, var19, var21, var22, var6, var10);
				}
			}
		}

		if (var8.field_510 > 0) {
			this.olb[this.klb] = this.screen.text_width(var8.field_509, 1) / 2;
			if (this.olb[this.klb] > 150) {
				this.olb[this.klb] = 150;
			}

			this.plb[this.klb] = this.screen.text_width(var8.field_509, 1) / 300 * this.screen.text_height(1);
			this.mlb[this.klb] = var1 + var3 / 2;
			this.nlb[this.klb] = var2;
			this.llb[this.klb++] = var8.field_509;
		}

		if (var8.field_502 == 8 || var8.field_502 == 9 || var8.field_516 != 0) {
			if (var8.field_516 > 0) {
				var14 = var1;
				if (var8.field_502 == 8) {
					var14 = var1 - 20 * var7 / 100;
				} else if (var8.field_502 == 9) {
					var14 = var1 + 20 * var7 / 100;
				}

				var15 = var8.field_514 * 30 / var8.field_515;
				this.wlb[this.vlb] = var14 + var3 / 2;
				this.xlb[this.vlb] = var2;
				this.ylb[this.vlb++] = var15;
			}

			if (var8.field_516 > 150) {
				var14 = var1;
				if (var8.field_502 == 8) {
					var14 = var1 - 10 * var7 / 100;
				} else if (var8.field_502 == 9) {
					var14 = var1 + 10 * var7 / 100;
				}

				this.screen.sprite_plot(var14 + var3 / 2 - 12, var2 + var4 / 2 - 12, this.ui_sprite_off + 12);
				this.screen.center_text_draw(String.valueOf(var8.field_513), var14 + var3 / 2 - 1, var2 + var4 / 2 + 5, 3,
						16777215);
			}
		}

	}


	public void plot_player(int var1, int var2, int var3, int var4, int var5, int var6, int var7) {
		Mob var8 = this.nbb[var5];
		if (var8.field_520 != 255) {
			int var9 = var8.field_502 + (this.fbb + 16) / 32 & 7;
			boolean var10 = false;
			int var11 = var9;
			if (var9 == 5) {
				var11 = 3;
				var10 = true;
			} else if (var9 == 6) {
				var11 = 2;
				var10 = true;
			} else if (var9 == 7) {
				var11 = 1;
				var10 = true;
			}

			int var12 = var11 * 3 + this.omb[var8.field_501 / 6 % 4];
			if (var8.field_502 == 8) {
				var11 = 5;
				var9 = 2;
				var10 = false;
				var1 -= 5 * var7 / 100;
				var12 = var11 * 3 + this.pmb[this.ticks / 5 % 8];
			} else if (var8.field_502 == 9) {
				var11 = 5;
				var9 = 2;
				var10 = true;
				var1 += 5 * var7 / 100;
				var12 = var11 * 3 + this.qmb[this.ticks / 6 % 8];
			}

			int var14;
			int var15;
			int var23;
			for (int var13 = 0; var13 < 12; ++var13) {
				var14 = this.bmb[var9][var13];
				var15 = var8.sprites[var14] - 1;
				if (var15 >= 0) {
					byte var16 = 0;
					byte var17 = 0;
					int var18 = var12;
					if (var10 && var11 >= 1 && var11 <= 3) {
						if (Config.anim_has_f[var15] == 1) {
							var18 = var12 + 15;
						} else if (var14 == 4 && var11 == 1) {
							var16 = -22;
							var17 = -3;
							var18 = var11 * 3 + this.omb[(2 + var8.field_501 / 6) % 4];
						} else if (var14 == 4 && var11 == 2) {
							var16 = 0;
							var17 = -8;
							var18 = var11 * 3 + this.omb[(2 + var8.field_501 / 6) % 4];
						} else if (var14 == 4 && var11 == 3) {
							var16 = 26;
							var17 = -5;
							var18 = var11 * 3 + this.omb[(2 + var8.field_501 / 6) % 4];
						} else if (var14 == 3 && var11 == 1) {
							var16 = 22;
							var17 = 3;
							var18 = var11 * 3 + this.omb[(2 + var8.field_501 / 6) % 4];
						} else if (var14 == 3 && var11 == 2) {
							var16 = 0;
							var17 = 8;
							var18 = var11 * 3 + this.omb[(2 + var8.field_501 / 6) % 4];
						} else if (var14 == 3 && var11 == 3) {
							var16 = -26;
							var17 = 5;
							var18 = var11 * 3 + this.omb[(2 + var8.field_501 / 6) % 4];
						}
					}

					if (var11 != 5 || Config.anim_has_a[var15] == 1) {
						int var19 = var18 + Config.anim_unknown2[var15];
						var23 = var16 * var3 / this.screen.sprite_mask_w[var19];
						int var24 = var17 * var4 / this.screen.sprite_mask_h[var19];
						int var20 = var3 * this.screen.sprite_mask_w[var19]
								/ this.screen.sprite_mask_w[Config.anim_unknown2[var15]];
						var23 -= (var20 - var3) / 2;
						int var21 = Config.anim_mask[var15];
						int var22 = this.nmb[var8.field_521];
						if (var21 == 1) {
							var21 = this.mmb[var8.field_518];
						} else if (var21 == 2) {
							var21 = this.lmb[var8.field_519];
						} else if (var21 == 3) {
							var21 = this.lmb[var8.field_520];
						}

						this.screen.resize_trans_sprite_plot(var1 + var23, var2 + var24, var20, var4, var19, var21, var22, var6,
								var10);
					}
				}
			}

			if (var8.field_510 > 0) {
				this.olb[this.klb] = this.screen.text_width(var8.field_509, 1) / 2;
				if (this.olb[this.klb] > 150) {
					this.olb[this.klb] = 150;
				}

				this.plb[this.klb] = this.screen.text_width(var8.field_509, 1) / 300 * this.screen.text_height(1);
				this.mlb[this.klb] = var1 + var3 / 2;
				this.nlb[this.klb] = var2;
				this.llb[this.klb++] = var8.field_509;
			}

			if (var8.field_512 > 0) {
				this.rlb[this.qlb] = var1 + var3 / 2;
				this.slb[this.qlb] = var2;
				this.tlb[this.qlb] = var7;
				this.ulb[this.qlb++] = var8.field_511;
			}

			if (var8.field_502 == 8 || var8.field_502 == 9 || var8.field_516 != 0) {
				if (var8.field_516 > 0) {
					var14 = var1;
					if (var8.field_502 == 8) {
						var14 = var1 - 20 * var7 / 100;
					} else if (var8.field_502 == 9) {
						var14 = var1 + 20 * var7 / 100;
					}

					var15 = var8.field_514 * 30 / var8.field_515;
					this.wlb[this.vlb] = var14 + var3 / 2;
					this.xlb[this.vlb] = var2;
					this.ylb[this.vlb++] = var15;
				}

				if (var8.field_516 > 150) {
					var14 = var1;
					if (var8.field_502 == 8) {
						var14 = var1 - 10 * var7 / 100;
					} else if (var8.field_502 == 9) {
						var14 = var1 + 10 * var7 / 100;
					}

					this.screen.sprite_plot(var14 + var3 / 2 - 12, var2 + var4 / 2 - 12, this.ui_sprite_off + 11);
					this.screen.center_text_draw(String.valueOf(var8.field_513), var14 + var3 / 2 - 1, var2 + var4 / 2 + 5,
							3, 16777215);
				}
			}

			if (var8.field_528 == 1 && var8.field_512 == 0) {
				var14 = var6 + var1 + var3 / 2;
				if (var8.field_502 == 8) {
					var14 -= 20 * var7 / 100;
				} else if (var8.field_502 == 9) {
					var14 += 20 * var7 / 100;
				}

				var15 = 16 * var7 / 100;
				var23 = 16 * var7 / 100;
				this.screen.resize_sprite_plot(var14 - var15 / 2, var2 - var23 / 2 - 10 * var7 / 100, var15, var23,
						this.ui_sprite_off + 13);
			}

		}
	}


	public void method_204() {
		int var2;
		int var3;
		int var4;
		int var5;
		int var6;
		int var8;
		for (int var1 = 0; var1 < this.klb; ++var1) {
			var2 = this.screen.text_height(1);
			var3 = this.mlb[var1];
			var4 = this.nlb[var1];
			var5 = this.olb[var1];
			var6 = this.plb[var1];
			boolean var7 = true;

			while (var7) {
				var7 = false;

				for (var8 = 0; var8 < var1; ++var8) {
					if (var4 + var6 > this.nlb[var8] - var2 && var4 - var2 < this.nlb[var8] + this.plb[var8]
							&& var3 - var5 < this.mlb[var8] + this.olb[var8]
							&& var3 + var5 > this.mlb[var8] - this.olb[var8] && this.nlb[var8] - var2 - var6 < var4) {
						var4 = this.nlb[var8] - var2 - var6;
						var7 = true;
					}
				}
			}

			this.nlb[var1] = var4;
			this.screen.multiline_text_draw(this.llb[var1], var3, var4, 1, 16776960, 300);
		}

		for (var2 = 0; var2 < this.qlb; ++var2) {
			var3 = this.rlb[var2];
			var4 = this.slb[var2];
			var5 = this.tlb[var2];
			var6 = this.ulb[var2];
			int var12 = 39 * var5 / 100;
			var8 = 27 * var5 / 100;
			int var9 = var4 - var8;
			this.screen.method_55(var3 - var12 / 2, var9, var12, var8, this.ui_sprite_off + 9, 85);
			int var10 = 36 * var5 / 100;
			int var11 = 24 * var5 / 100;
			this.screen.resize_trans_sprite_plot(var3 - var10 / 2, var9 + var8 / 2 - var11 / 2, var10, var11,
					Config.item_sprite[var6] + this.item_sprite_off, Config.item_tint[var6], 0, 0, false);
		}

		for (var3 = 0; var3 < this.vlb; ++var3) {
			var4 = this.wlb[var3];
			var5 = this.xlb[var3];
			var6 = this.ylb[var3];
			this.screen.rect_fill(var4 - 15, var5 - 3, var6, 5, 65280, 192);
			this.screen.rect_fill(var4 - 15 + var6, var5 - 3, 30 - var6, 5, 16711680, 192);
		}

	}


	public int method_205(int var1) {
		int var2 = 0;

		for (int var3 = 0; var3 < this.adb; ++var3) {
			if (this.bdb[var3] == var1) {
				if (Config.item_stackable[var1] == 1) {
					++var2;
				} else {
					var2 += this.cdb[var3];
				}
			}
		}

		return var2;
	}


	public boolean method_206(int var1, int var2) {
		if (var1 == 31 && (this.method_207(197) || this.method_207(615))) {
			return true;
		} else if (var1 != 32 || !this.method_207(102) && !this.method_207(616)) {
			if (var1 == 33 && (this.method_207(101) || this.method_207(617))) {
				return true;
			} else if (var1 != 34 || !this.method_207(103) && !this.method_207(618)) {
				return this.method_205(var1) >= var2;
			} else {
				return true;
			}
		} else {
			return true;
		}
	}


	public boolean method_207(int var1) {
		for (int var2 = 0; var2 < this.adb; ++var2) {
			if (this.bdb[var2] == var1 && this.ddb[var2] == 1) {
				return true;
			}
		}

		return false;
	}


	public void method_208(int var1, int var2, int var3) {
		this.screen.plot(var1, var2, var3);
		this.screen.plot(var1 - 1, var2, var3);
		this.screen.plot(var1 + 1, var2, var3);
		this.screen.plot(var1, var2 - 1, var3);
		this.screen.plot(var1, var2 + 1, var3);
	}


	public void method_209(int var1, int var2, int var3, int var4, boolean var5) {
		this.method_213(var1, var2, var3, var4, var3, var4, false, var5);
	}


	public void method_210(int var1, int var2, int var3, int var4, boolean var5) {
		if (!this.method_213(var1, var2, var3, var4, var3, var4, false, var5)) {
			this.method_213(var1, var2, var3, var4, var3, var4, true, var5);
		}
	}


	public void method_211(int var1, int var2, int var3, int var4) {
		int var5;
		int var6;
		if (var3 != 0 && var3 != 4) {
			var6 = Config.obj_width[var4];
			var5 = Config.obj_height[var4];
		} else {
			var5 = Config.obj_width[var4];
			var6 = Config.obj_height[var4];
		}

		if (Config.obj_type[var4] != 2 && Config.obj_type[var4] != 3) {
			this.method_213(this.qbb, this.rbb, var1, var2, var1 + var5 - 1, var2 + var6 - 1, true, true);
		} else {
			if (var3 == 0) {
				--var1;
				++var5;
			}

			if (var3 == 2) {
				++var6;
			}

			if (var3 == 4) {
				++var5;
			}

			if (var3 == 6) {
				--var2;
				++var6;
			}

			this.method_213(this.qbb, this.rbb, var1, var2, var1 + var5 - 1, var2 + var6 - 1, false, true);
		}
	}


	public void method_212(int var1, int var2, int var3) {
		if (var3 == 0) {
			this.method_213(this.qbb, this.rbb, var1, var2 - 1, var1, var2, false, true);
		} else if (var3 == 1) {
			this.method_213(this.qbb, this.rbb, var1 - 1, var2, var1, var2, false, true);
		} else {
			this.method_213(this.qbb, this.rbb, var1, var2, var1, var2, true, true);
		}
	}


	// boolean
	public boolean method_213(int var1, int var2, int var3, int var4, int var5, int var6, boolean var7, boolean var8) {
		int var9 = this.terrian.create_path(var1, var2, var3, var4, var5, var6, this.field_186, this.field_187, var7);
		if (var9 == -1) {
			return false;
		} else {
			--var9;
			var1 = this.field_186[var9];
			var2 = this.field_187[var9];
			--var9;
			if (var8) {
				conn.enter(215);
			} else {
				conn.enter(255);
			}

			conn.short_put(var1 + this.pab);
			conn.short_put(var2 + this.qab);

			for (int var10 = var9; var10 >= 0 && var10 > var9 - 25; --var10) {
				conn.byte_put(this.field_186[var10] - var1);
				conn.byte_put(this.field_187[var10] - var2);
			}

			conn.exit();
			this.hab = -24;
			this.iab = super.mouse_x;
			this.jab = super.mouse_y;
			return true;
		}
	}


	public boolean method_214(int var1, int var2) {
		if (this.sib != 0) {
			this.terrian.field_97 = false;
			return false;
		} else {
			this.uib = false;
			var1 += this.lab;
			var2 += this.mab;
			if (this.oab == this.rab && var1 > this.sab && var1 < this.uab && var2 > this.tab && var2 < this.vab) {
				this.terrian.field_97 = true;
				return false;
			} else {
				this.screen.center_text_draw("Loading... Please wait", 256, 192, 1, 16777215);
				this.method_199();
				this.screen.copy(this.graphics, 0, 0);
				int var3 = this.pab;
				int var4 = this.qab;
				int var5 = (var1 + 24) / 48;
				int var6 = (var2 + 24) / 48;
				this.oab = this.rab;
				this.pab = var5 * 48 - 48;
				this.qab = var6 * 48 - 48;
				this.sab = var5 * 48 - 32;
				this.tab = var6 * 48 - 32;
				this.uab = var5 * 48 + 32;
				this.vab = var6 * 48 + 32;
				this.terrian.load(var1, var2, this.oab);
				this.pab -= this.lab;
				this.qab -= this.mab;
				int var7 = this.pab - var3;
				int var8 = this.qab - var4;

				int var10;
				int var11;
				int var12;
				int var14;
				int var15;
				for (int var9 = 0; var9 < this.icb; ++var9) {
					this.kcb[var9] -= var7;
					this.lcb[var9] -= var8;
					var10 = this.kcb[var9];
					var11 = this.lcb[var9];
					var12 = this.mcb[var9];
					Model var13 = this.jcb[var9];

					try {
						var14 = this.ncb[var9];
						int var16;
						if (var14 != 0 && var14 != 4) {
							var16 = Config.obj_width[var12];
							var15 = Config.obj_height[var12];
						} else {
							var15 = Config.obj_width[var12];
							var16 = Config.obj_height[var12];
						}

						int var17 = (var10 + var10 + var15) * this.field_200 / 2;
						int var18 = (var11 + var11 + var16) * this.field_200 / 2;
						if (var10 >= 0 && var11 >= 0 && var10 < 96 && var11 < 96) {
							this.scene.add(var13);
							var13.method_259(var17, -this.terrian.calc_z(var17, var18), var18);
							this.terrian.obj_plot(var10, var11, var12);
							if (var12 == 74) {
								var13.method_258(0, -480, 0);
							}
						}
					} catch (RuntimeException var20) {
						System.out.println("Loc Error: " + var20.getMessage());
						System.out.println("i:" + var9 + " obj:" + var13);
						var20.printStackTrace();
					}
				}

				int var21;
				for (var10 = 0; var10 < this.rcb; ++var10) {
					this.tcb[var10] -= var7;
					this.ucb[var10] -= var8;
					var11 = this.tcb[var10];
					var12 = this.ucb[var10];
					var21 = this.wcb[var10];
					var14 = this.vcb[var10];

					try {
						this.terrian.wall_plot(var11, var12, var14, var21);
						Model var24 = this.method_215(var11, var12, var14, var21, var10);
						this.scb[var10] = var24;
					} catch (RuntimeException var19) {
						System.out.println("Bound Error: " + var19.getMessage());
						var19.printStackTrace();
					}
				}

				for (var11 = 0; var11 < this.ccb; ++var11) {
					this.dcb[var11] -= var7;
					this.ecb[var11] -= var8;
				}

				for (var12 = 0; var12 < this.jbb; ++var12) {
					Mob var22 = this.nbb[var12];
					var22.cur_x -= var7 * this.field_200;
					var22.cur_y -= var8 * this.field_200;

					for (var14 = 0; var14 <= var22.field_505; ++var14) {
						var22.waypoint_hist_x[var14] -= var7 * this.field_200;
						var22.waypoint_hist_y[var14] -= var8 * this.field_200;
					}
				}

				for (var21 = 0; var21 < this.vbb; ++var21) {
					Mob var23 = this.ybb[var21];
					var23.cur_x -= var7 * this.field_200;
					var23.cur_y -= var8 * this.field_200;

					for (var15 = 0; var15 <= var23.field_505; ++var15) {
						var23.waypoint_hist_x[var15] -= var7 * this.field_200;
						var23.waypoint_hist_y[var15] -= var8 * this.field_200;
					}
				}

				this.terrian.field_97 = true;
				return true;
			}
		}
	}


	public Model method_215(int var1, int var2, int var3, int var4, int var5) {
		int var6 = var1;
		int var8 = var1;
		int var9 = var2;
		int var10 = Config.bound_tex_front[var4];
		int var11 = Config.bound_tex_back[var4];
		int var12 = Config.bound_size[var4];
		Model var13 = new Model(4, 1);
		if (var3 == 0) {
			var8 = var1 + 1;
		}

		if (var3 == 1) {
			var9 = var2 + 1;
		}

		if (var3 == 2) {
			var6 = var1 + 1;
			var9 = var2 + 1;
		}

		if (var3 == 3) {
			var8 = var1 + 1;
			var9 = var2 + 1;
		}

		var6 *= this.field_200;
		int var7 = var2 * this.field_200;
		var8 *= this.field_200;
		var9 *= this.field_200;
		int var14 = var13.get_vert(var6, -this.terrian.calc_z(var6, var7), var7);
		int var15 = var13.get_vert(var6, -this.terrian.calc_z(var6, var7) - var12, var7);
		int var16 = var13.get_vert(var8, -this.terrian.calc_z(var8, var9) - var12, var9);
		int var17 = var13.get_vert(var8, -this.terrian.calc_z(var8, var9), var9);
		int[] var18 = new int[] { var14, var15, var16, var17 };
		var13.face_add(4, var18, var10, var11);
		var13.set_light(false, 60, 24, -50, -10, -50);
		if (var1 >= 0 && var2 >= 0 && var1 < 96 && var2 < 96) {
			this.scene.add(var13);
		}

		var13.field_291 = var5 + 10000;
		return var13;
	}


	public void method_216() {
		if (this.logout_timeout != 0) {
			this.method_221();
		} else if (this.iib) {
			this.method_219();
		} else if (this.oib) {
			this.method_220();
		} else if (this.tib == 1) {
			this.method_222();
		} else if (this.ohb && this.rib == 0) {
			this.method_225();
		} else if (this.ghb && this.rib == 0) {
			this.method_226();
		} else if (this.ygb) {
			this.method_227();
		} else if (this.lgb) {
			this.method_228();
		} else if (this.yfb) {
			this.method_229();
		} else if (this.kfb) {
			this.method_230();
		} else if (this.eib != 0) {
			this.method_223();
		} else if (this.dib != 0) {
			this.method_224();
		} else {
			if (this.zhb) {
				this.method_217();
			}

			if (this.pbb.field_502 == 8 || this.pbb.field_502 == 9) {
				this.method_218();
			}

			this.method_231();
			boolean var1 = !this.zhb && !this.heb;
			if (var1) {
				this.meb = 0;
			}

			if (this.ycb == 0 && var1) {
				this.method_238();
			}

			if (this.ycb == 1) {
				this.method_232(var1);
			}

			if (this.ycb == 2) {
				this.method_233(var1);
			}

			if (this.ycb == 3) {
				this.method_234(var1);
			}

			if (this.ycb == 4) {
				this.method_235(var1);
			}

			if (this.ycb == 5) {
				this.method_236(var1);
			}

			if (this.ycb == 6) {
				this.method_237(var1);
			}

			if (!this.heb && !this.zhb) {
				this.method_240();
			}

			if (this.heb && !this.zhb) {
				this.method_239();
			}
		}

		this.field_184 = 0;
	}


	public void method_217() {
		int var1;
		if (this.field_184 == 0) {
			for (var1 = 0; var1 < this.aib; ++var1) {
				int var2 = 65535;
				if (super.mouse_x < this.screen.text_width(this.bib[var1], 1) && super.mouse_y > var1 * 12
						&& super.mouse_y < 12 + var1 * 12) {
					var2 = 16711680;
				}

				this.screen.text_draw(this.bib[var1], 6, 12 + var1 * 12, 1, var2);
			}

		} else {
			for (var1 = 0; var1 < this.aib; ++var1) {
				if (super.mouse_x < this.screen.text_width(this.bib[var1], 1) && super.mouse_y > var1 * 12
						&& super.mouse_y < 12 + var1 * 12) {
					conn.enter(237);
					conn.byte_put(var1);
					conn.exit();
					break;
				}
			}

			this.field_184 = 0;
			this.zhb = false;
		}
	}


	public void method_218() {
		byte var1 = 7;
		byte var2 = 15;
		short var3 = 175;
		int var4;
		if (this.field_184 != 0) {
			for (var4 = 0; var4 < 5; ++var4) {
				if (var4 > 0 && super.mouse_x > var1 && super.mouse_x < var1 + var3
						&& super.mouse_y > var2 + var4 * 20 && super.mouse_y < var2 + var4 * 20 + 20) {
					this.cib = var4 - 1;
					this.field_184 = 0;
					conn.enter(231);
					conn.byte_put(this.cib);
					conn.exit();
					break;
				}
			}
		}

		for (var4 = 0; var4 < 5; ++var4) {
			if (var4 == this.cib + 1) {
				this.screen.rect_fill(var1, var2 + var4 * 20, var3, 20, Surface.rgb(255, 0, 0), 128);
			} else {
				this.screen.rect_fill(var1, var2 + var4 * 20, var3, 20, Surface.rgb(190, 190, 190), 128);
			}

			this.screen.line_horiz(var1, var2 + var4 * 20, var3, 0);
			this.screen.line_horiz(var1, var2 + var4 * 20 + 20, var3, 0);
		}

		this.screen.center_text_draw("Select combat style", var1 + var3 / 2, var2 + 16, 3, 16777215);
		this.screen.center_text_draw("Controlled (+1 of each)", var1 + var3 / 2, var2 + 36, 3, 0);
		this.screen.center_text_draw("Aggressive (+3 strength)", var1 + var3 / 2, var2 + 56, 3, 0);
		this.screen.center_text_draw("Accurate   (+3 attack)", var1 + var3 / 2, var2 + 76, 3, 0);
		this.screen.center_text_draw("Defensive  (+3 defense)", var1 + var3 / 2, var2 + 96, 3, 0);
	}


	public void method_219() {
		short var1 = 180;
		int var2 = 167 - var1 / 2;
		this.screen.rect_fill(56, 167 - var1 / 2, 400, var1, 0);
		this.screen.rect_draw(56, 167 - var1 / 2, 400, var1, 16777215);
		var2 += 20;
		this.screen.center_text_draw("Welcome to RuneScape " + this.tjb, 256, var2, 4, 16776960);
		var2 += 30;
		this.screen.center_text_draw(
				"You last logged in " + this.lib / 1440 + " days, " + this.lib / 60 % 24 + " hours ago", 256, var2, 1,
				16777215);
		var2 += 15;
		String var4;
		int var5;
		if (this.kib == null) {
			this.kib = DataUtil.method_12(this.jib);

			try {
				this.kib = InetAddress.getByName(this.kib).getHostName();
			} catch (Exception var6) {
				var4 = var6.getMessage();
				var5 = var4.indexOf("cannot connect to");
				if (var5 != -1) {
					this.kib = var4.substring(var5 + 18);
				}
			}
		}

		this.screen.center_text_draw("from: " + this.kib, 256, var2, 1, 16777215);
		var2 += 15;
		var2 += 15;
		int var3;
		if (this.mib != 0) {
			var3 = 1 + this.mib / 1440;
			if (var3 > 14) {
				var3 = 14;
			}

			if (var3 == 14) {
				var4 = "Earlier today";
			} else if (var3 == 13) {
				var4 = "Yesterday";
			} else {
				var4 = 14 - var3 + " days ago";
			}

			this.screen.center_text_draw(var4 + " you requested new recovery questions", 256, var2, 1, 16744448);
			var2 += 15;
			this.screen.center_text_draw("If you do not remember making this request then", 256, var2, 1, 16744448);
			var2 += 15;
			this.screen.center_text_draw("cancel it and change your password immediately!", 256, var2, 1, 16744448);
			var2 += 15;
			var2 += 15;
			var5 = 16777215;
			if (super.mouse_y > var2 - 12 && super.mouse_y <= var2 && super.mouse_x > 106
					&& super.mouse_x < 406) {
				var5 = 16711680;
			}

			this.screen.center_text_draw("No that wasn't me - Cancel the request!", 256, var2, 1, var5);
			if (var5 == 16711680 && this.field_184 == 1) {
				conn.enter(196);
				conn.exit();
				this.iib = false;
			}

			var2 += 15;
			var5 = 16777215;
			if (super.mouse_y > var2 - 12 && super.mouse_y <= var2 && super.mouse_x > 106
					&& super.mouse_x < 406) {
				var5 = 16711680;
			}

			this.screen.center_text_draw("That's ok, activate the new questions in " + var3 + " days time", 256, var2, 1,
					var5);
			if (var5 == 16711680 && this.field_184 == 1) {
				this.iib = false;
			}
		} else {
			var2 += 7;
			this.screen.center_text_draw("Security tip of the day", 256, var2, 1, 16711680);
			var2 += 15;
			if (this.nib == 0) {
				this.screen.center_text_draw("Don't tell ANYONE your password or recovery questions!", 256, var2, 1,
						16777215);
				var2 += 15;
				this.screen.center_text_draw("Not even people claiming to be Jagex staff.", 256, var2, 1, 16777215);
				var2 += 15;
			}

			if (this.nib == 1) {
				this.screen.center_text_draw("Never enter your password or recovery questions into ANY", 256, var2, 1,
						16777215);
				var2 += 15;
				this.screen.center_text_draw("website other than this one - Not even if it looks similar.", 256, var2, 1,
						16777215);
				var2 += 15;
			}

			if (this.nib == 2) {
				this.screen.center_text_draw("Don't use RuneScape cheats, helpers, or automaters.", 256, var2, 1, 16777215);
				var2 += 15;
				this.screen.center_text_draw("These programs WILL steal your password.", 256, var2, 1, 16777215);
				var2 += 15;
			}

			if (this.nib == 3) {
				this.screen.center_text_draw("Watch out for fake emails, and fake staff. Real staff", 256, var2, 1,
						16777215);
				var2 += 15;
				this.screen.center_text_draw("will NEVER ask you for your password or recovery questions!", 256, var2, 1,
						16777215);
				var2 += 15;
			}

			if (this.nib == 4) {
				this.screen.center_text_draw("Use a password your friends won't guess. Do NOT use your name!", 256, var2, 1,
						16777215);
				var2 += 15;
				this.screen.center_text_draw("Choose a unique password which you haven't used anywhere else", 256, var2, 1,
						16777215);
				var2 += 15;
			}

			if (this.nib == 5) {
				this.screen.center_text_draw("If possible only play runescape from your own computer", 256, var2, 1,
						16777215);
				var2 += 15;
				this.screen.center_text_draw("Other machines could have been tampered with to steal your pass", 256, var2,
						1, 16777215);
				var2 += 15;
			}

			var2 += 22;
			var3 = 16777215;
			if (super.mouse_y > var2 - 12 && super.mouse_y <= var2 && super.mouse_x > 106
					&& super.mouse_x < 406) {
				var3 = 16711680;
			}

			this.screen.center_text_draw("Click here to close window", 256, var2, 1, var3);
			if (this.field_184 == 1) {
				if (var3 == 16711680) {
					this.iib = false;
				}

				if ((super.mouse_x < 86 || super.mouse_x > 426)
						&& (super.mouse_y < 167 - var1 / 2 || super.mouse_y > 167 + var1 / 2)) {
					this.iib = false;
				}
			}
		}

		this.field_184 = 0;
	}


	public void method_220() {
		short var1 = 400;
		byte var2 = 100;
		this.screen.rect_fill(256 - var1 / 2, 167 - var2 / 2, var1, var2, 0);
		this.screen.rect_draw(256 - var1 / 2, 167 - var2 / 2, var1, var2, 16777215);
		this.screen.multiline_text_draw(this.pib, 256, 137, 1, 16777215, var1 - 40);
		int var3 = 157 + var2 / 2;
		int var4 = 16777215;
		if (super.mouse_y > var3 - 12 && super.mouse_y <= var3 && super.mouse_x > 106 && super.mouse_x < 406) {
			var4 = 16711680;
		}

		this.screen.center_text_draw("Click here to close window", 256, var3, 1, var4);
		if (this.field_184 == 1) {
			if (var4 == 16711680) {
				this.oib = false;
			}

			if ((super.mouse_x < 256 - var1 / 2 || super.mouse_x > 256 + var1 / 2)
					&& (super.mouse_y < 167 - var2 / 2 || super.mouse_y > 167 + var2 / 2)) {
				this.oib = false;
			}
		}

		this.field_184 = 0;
	}


	public void method_221() {
		this.screen.rect_fill(126, 137, 260, 60, 0);
		this.screen.rect_draw(126, 137, 260, 60, 16777215);
		this.screen.center_text_draw("Logging out...", 256, 173, 5, 16777215);
	}


	public void method_222() {
		byte var1 = 97;
		this.screen.rect_fill(86, 77, 340, 180, 0);
		this.screen.rect_draw(86, 77, 340, 180, 16777215);
		this.screen.center_text_draw("Warning! Proceed with caution", 256, var1, 4, 16711680);
		int var3 = var1 + 26;
		this.screen.center_text_draw("If you go much further north you will enter the", 256, var3, 1, 16777215);
		var3 += 13;
		this.screen.center_text_draw("wilderness. This a very dangerous area where", 256, var3, 1, 16777215);
		var3 += 13;
		this.screen.center_text_draw("other players can attack you!", 256, var3, 1, 16777215);
		var3 += 22;
		this.screen.center_text_draw("The further north you go the more dangerous it", 256, var3, 1, 16777215);
		var3 += 13;
		this.screen.center_text_draw("becomes, but the more treasure you will find.", 256, var3, 1, 16777215);
		var3 += 22;
		this.screen.center_text_draw("In the wilderness an indicator at the bottom-right", 256, var3, 1, 16777215);
		var3 += 13;
		this.screen.center_text_draw("of the screen will show the current level of danger", 256, var3, 1, 16777215);
		var3 += 22;
		int var2 = 16777215;
		if (super.mouse_y > var3 - 12 && super.mouse_y <= var3 && super.mouse_x > 181 && super.mouse_x < 331) {
			var2 = 16711680;
		}

		this.screen.center_text_draw("Click here to close window", 256, var3, 1, var2);
		if (this.field_184 != 0) {
			if (super.mouse_y > var3 - 12 && super.mouse_y <= var3 && super.mouse_x > 181
					&& super.mouse_x < 331) {
				this.tib = 2;
			}

			if (super.mouse_x < 86 || super.mouse_x > 426 || super.mouse_y < 77 || super.mouse_y > 257) {
				this.tib = 2;
			}

			this.field_184 = 0;
		}

	}


	public void method_223() {
		if (this.field_184 != 0) {
			this.field_184 = 0;
			if (super.mouse_x < 106 || super.mouse_y < 150 || super.mouse_x > 406 || super.mouse_y > 210) {
				this.eib = 0;
				return;
			}
		}

		short var1 = 150;
		this.screen.rect_fill(106, var1, 300, 60, 0);
		this.screen.rect_draw(106, var1, 300, 60, 16777215);
		int var4 = var1 + 22;
		String var2;
		int var3;
		if (this.eib == 6) {
			this.screen.center_text_draw("Please enter your current password", 256, var4, 4, 16777215);
			var4 += 25;
			var2 = "*";

			for (var3 = 0; var3 < super.line_a_buf.length(); ++var3) {
				var2 = "X" + var2;
			}

			this.screen.center_text_draw(var2, 256, var4, 4, 16777215);
			if (super.line_a.length() > 0) {
				this.fib = super.line_a;
				super.line_a_buf = "";
				super.line_a = "";
				this.eib = 1;
				return;
			}
		} else if (this.eib == 1) {
			this.screen.center_text_draw("Please enter your new password", 256, var4, 4, 16777215);
			var4 += 25;
			var2 = "*";

			for (var3 = 0; var3 < super.line_a_buf.length(); ++var3) {
				var2 = "X" + var2;
			}

			this.screen.center_text_draw(var2, 256, var4, 4, 16777215);
			if (super.line_a.length() > 0) {
				this.gib = super.line_a;
				super.line_a_buf = "";
				super.line_a = "";
				if (this.gib.length() >= 5) {
					this.eib = 2;
					return;
				}

				this.eib = 5;
				return;
			}
		} else if (this.eib == 2) {
			this.screen.center_text_draw("Enter password again to confirm", 256, var4, 4, 16777215);
			var4 += 25;
			var2 = "*";

			for (var3 = 0; var3 < super.line_a_buf.length(); ++var3) {
				var2 = "X" + var2;
			}

			this.screen.center_text_draw(var2, 256, var4, 4, 16777215);
			if (super.line_a.length() > 0) {
				if (super.line_a.equalsIgnoreCase(this.gib)) {
					this.eib = 4;
					this.send_cred(this.fib, this.gib);
					return;
				}

				this.eib = 3;
				return;
			}
		} else {
			if (this.eib == 3) {
				this.screen.center_text_draw("Passwords do not match!", 256, var4, 4, 16777215);
				var4 += 25;
				this.screen.center_text_draw("Press any key to close", 256, var4, 4, 16777215);
				return;
			}

			if (this.eib == 4) {
				this.screen.center_text_draw("Ok, your request has been sent", 256, var4, 4, 16777215);
				var4 += 25;
				this.screen.center_text_draw("Press any key to close", 256, var4, 4, 16777215);
				return;
			}

			if (this.eib == 5) {
				this.screen.center_text_draw("Password must be at", 256, var4, 4, 16777215);
				var4 += 25;
				this.screen.center_text_draw("least 5 letters long", 256, var4, 4, 16777215);
			}
		}

	}


	public void method_224() {
		if (this.field_184 != 0) {
			label118: {
				this.field_184 = 0;
				if (this.dib != 1 || super.mouse_x >= 106 && super.mouse_y >= 145 && super.mouse_x <= 406
						&& super.mouse_y <= 215) {
					if (this.dib == 2 && (super.mouse_x < 6 || super.mouse_y < 145 || super.mouse_x > 506
							|| super.mouse_y > 215)) {
						this.dib = 0;
						return;
					}

					if (this.dib != 3 || super.mouse_x >= 106 && super.mouse_y >= 145 && super.mouse_x <= 406
							&& super.mouse_y <= 215) {
						if (super.mouse_x > 236 && super.mouse_x < 276 && super.mouse_y > 193
								&& super.mouse_y < 213) {
							this.dib = 0;
							return;
						}
						break label118;
					}

					this.dib = 0;
					return;
				}

				this.dib = 0;
				return;
			}
		}

		int var1 = 145;
		String input;
		if (this.dib == 1) {
			this.screen.rect_fill(106, var1, 300, 70, 0);
			this.screen.rect_draw(106, var1, 300, 70, 16777215);
			var1 += 20;
			this.screen.center_text_draw("Enter name to add to friends list", 256, var1, 4, 16777215);
			var1 += 20;
			this.screen.center_text_draw(super.line_a_buf + "*", 256, var1, 4, 16777215);
	
			if (line_a.length() > 0) {
				input = line_a.trim();
				line_a_buf = "";
				line_a = "";
				dib = 0;
				
				if (input.length() > 0 && DataUtil.encode_name(input) != this.pbb.hash) {
					friend_add(input);
				}
			}
		}

		if (this.dib == 2) {
			this.screen.rect_fill(6, var1, 500, 70, 0);
			this.screen.rect_draw(6, var1, 500, 70, 16777215);
			var1 += 20;
			this.screen.center_text_draw("Enter message to send to " + DataUtil.decode_name(this.vdb), 256, var1, 4, 16777215);
			var1 += 20;
			this.screen.center_text_draw(super.line_b_buf + "*", 256, var1, 4, 16777215);
			if (super.line_b.length() > 0) {
				input = super.line_b;
				super.line_b_buf = "";
				super.line_b = "";
				this.dib = 0;
				int var3 = DataUtil.method_21(input);
				this.send_priv_message(this.vdb, DataUtil.field_6, var3);
				input = DataUtil.decode_censor(DataUtil.field_6, 0, var3, true);
				this.push_message("@pri@You tell " + DataUtil.decode_name(this.vdb) + ": " + input);
			}
		}

		if (this.dib == 3) {
			this.screen.rect_fill(106, var1, 300, 70, 0);
			this.screen.rect_draw(106, var1, 300, 70, 16777215);
			var1 += 20;
			this.screen.center_text_draw("Enter name to add to ignore list", 256, var1, 4, 16777215);
			var1 += 20;
			this.screen.center_text_draw(super.line_a_buf + "*", 256, var1, 4, 16777215);
			if (super.line_a.length() > 0) {
				input = super.line_a.trim();
				super.line_a_buf = "";
				super.line_a = "";
				this.dib = 0;
				if (input.length() > 0 && DataUtil.encode_name(input) != this.pbb.hash) {
					this.ignore_add(input);
				}
			}
		}

		int var4 = 16777215;
		if (super.mouse_x > 236 && super.mouse_x < 276 && super.mouse_y > 193 && super.mouse_y < 213) {
			var4 = 16776960;
		}

		this.screen.center_text_draw("Cancel", 256, 208, 1, var4);
	}


	public void method_225() {
		short var1 = 408;
		short var2 = 334;
		if (this.yhb == 1 && this.shb <= 48) {
			this.yhb = 0;
		}

		if (this.vhb >= this.shb || this.vhb < 0) {
			this.vhb = -1;
		}

		if (this.vhb != -1 && this.thb[this.vhb] != this.whb) {
			this.vhb = -1;
			this.whb = -2;
		}

		int var3;
		int var4;
		int var5;
		int var6;
		int var7;
		int var8;
		int var9;
		if (this.field_184 != 0) {
			this.field_184 = 0;
			var3 = super.mouse_x - (256 - var1 / 2);
			var4 = super.mouse_y - (170 - var2 / 2);
			if (var3 >= 0 && var4 >= 12 && var3 < 408 && var4 < 280) {
				var5 = this.yhb * 48;

				for (var6 = 0; var6 < 6; ++var6) {
					for (var7 = 0; var7 < 8; ++var7) {
						var8 = 7 + var7 * 49;
						var9 = 28 + var6 * 34;
						if (var3 > var8 && var3 < var8 + 49 && var4 > var9 && var4 < var9 + 34 && var5 < this.shb
								&& this.thb[var5] != -1) {
							this.whb = this.thb[var5];
							this.vhb = var5;
						}

						++var5;
					}
				}

				var3 = 256 - var1 / 2;
				var4 = 170 - var2 / 2;
				if (this.vhb < 0) {
					var7 = -1;
				} else {
					var7 = this.thb[this.vhb];
				}

				if (var7 != -1) {
					var5 = this.uhb[this.vhb];
					if (Config.item_stackable[var7] == 1 && var5 > 1) {
						var5 = 1;
					}

					if (var5 >= 1 && super.mouse_x >= var3 + 220 && super.mouse_y >= var4 + 238
							&& super.mouse_x < var3 + 250 && super.mouse_y <= var4 + 249) {
						conn.enter(206);
						conn.short_put(var7);
						conn.short_put(1);
						conn.exit();
					}

					if (var5 >= 5 && super.mouse_x >= var3 + 250 && super.mouse_y >= var4 + 238
							&& super.mouse_x < var3 + 280 && super.mouse_y <= var4 + 249) {
						conn.enter(206);
						conn.short_put(var7);
						conn.short_put(5);
						conn.exit();
					}

					if (var5 >= 25 && super.mouse_x >= var3 + 280 && super.mouse_y >= var4 + 238
							&& super.mouse_x < var3 + 305 && super.mouse_y <= var4 + 249) {
						conn.enter(206);
						conn.short_put(var7);
						conn.short_put(25);
						conn.exit();
					}

					if (var5 >= 100 && super.mouse_x >= var3 + 305 && super.mouse_y >= var4 + 238
							&& super.mouse_x < var3 + 335 && super.mouse_y <= var4 + 249) {
						conn.enter(206);
						conn.short_put(var7);
						conn.short_put(100);
						conn.exit();
					}

					if (var5 >= 500 && super.mouse_x >= var3 + 335 && super.mouse_y >= var4 + 238
							&& super.mouse_x < var3 + 368 && super.mouse_y <= var4 + 249) {
						conn.enter(206);
						conn.short_put(var7);
						conn.short_put(500);
						conn.exit();
					}

					if (var5 >= 2500 && super.mouse_x >= var3 + 370 && super.mouse_y >= var4 + 238
							&& super.mouse_x < var3 + 400 && super.mouse_y <= var4 + 249) {
						conn.enter(206);
						conn.short_put(var7);
						conn.short_put(2500);
						conn.exit();
					}

					if (this.method_205(var7) >= 1 && super.mouse_x >= var3 + 220 && super.mouse_y >= var4 + 263
							&& super.mouse_x < var3 + 250 && super.mouse_y <= var4 + 274) {
						conn.enter(205);
						conn.short_put(var7);
						conn.short_put(1);
						conn.exit();
					}

					if (this.method_205(var7) >= 5 && super.mouse_x >= var3 + 250 && super.mouse_y >= var4 + 263
							&& super.mouse_x < var3 + 280 && super.mouse_y <= var4 + 274) {
						conn.enter(205);
						conn.short_put(var7);
						conn.short_put(5);
						conn.exit();
					}

					if (this.method_205(var7) >= 25 && super.mouse_x >= var3 + 280 && super.mouse_y >= var4 + 263
							&& super.mouse_x < var3 + 305 && super.mouse_y <= var4 + 274) {
						conn.enter(205);
						conn.short_put(var7);
						conn.short_put(25);
						conn.exit();
					}

					if (this.method_205(var7) >= 100 && super.mouse_x >= var3 + 305 && super.mouse_y >= var4 + 263
							&& super.mouse_x < var3 + 335 && super.mouse_y <= var4 + 274) {
						conn.enter(205);
						conn.short_put(var7);
						conn.short_put(100);
						conn.exit();
					}

					if (this.method_205(var7) >= 500 && super.mouse_x >= var3 + 335 && super.mouse_y >= var4 + 263
							&& super.mouse_x < var3 + 368 && super.mouse_y <= var4 + 274) {
						conn.enter(205);
						conn.short_put(var7);
						conn.short_put(500);
						conn.exit();
					}

					if (this.method_205(var7) >= 2500 && super.mouse_x >= var3 + 370 && super.mouse_y >= var4 + 263
							&& super.mouse_x < var3 + 400 && super.mouse_y <= var4 + 274) {
						conn.enter(205);
						conn.short_put(var7);
						conn.short_put(2500);
						conn.exit();
					}
				}
			} else if (this.shb > 48 && var3 >= 120 && var3 <= 190 && var4 <= 12) {
				this.yhb = 0;
			} else {
				if (this.shb <= 48 || var3 < 190 || var3 > 260 || var4 > 12) {
					conn.enter(207);
					conn.exit();
					this.ohb = false;
					return;
				}

				this.yhb = 1;
			}
		}

		var3 = 256 - var1 / 2;
		var4 = 170 - var2 / 2;
		this.screen.rect_fill(var3, var4, 408, 12, 192);
		var5 = 10000536;
		this.screen.rect_fill(var3, var4 + 12, 408, 17, var5, 160);
		this.screen.rect_fill(var3, var4 + 29, 8, 204, var5, 160);
		this.screen.rect_fill(var3 + 399, var4 + 29, 9, 204, var5, 160);
		this.screen.rect_fill(var3, var4 + 233, 408, 47, var5, 160);
		this.screen.text_draw("Bank", var3 + 1, var4 + 10, 1, 16777215);
		if (this.shb > 48) {
			var6 = 16777215;
			if (this.yhb == 0) {
				var6 = 16711680;
			} else if (super.mouse_x > var3 + 120 && super.mouse_y >= var4 && super.mouse_x < var3 + 190
					&& super.mouse_y < var4 + 12) {
				var6 = 16776960;
			}

			this.screen.text_draw("<page 1>", var3 + 120, var4 + 10, 1, var6);
			var6 = 16777215;
			if (this.yhb == 1) {
				var6 = 16711680;
			} else if (super.mouse_x > var3 + 190 && super.mouse_y >= var4 && super.mouse_x < var3 + 260
					&& super.mouse_y < var4 + 12) {
				var6 = 16776960;
			}

			this.screen.text_draw("<page 2>", var3 + 200, var4 + 10, 1, var6);
		}

		var6 = 16777215;
		if (super.mouse_x > var3 + 320 && super.mouse_y >= var4 && super.mouse_x < var3 + 408
				&& super.mouse_y < var4 + 12) {
			var6 = 16711680;
		}

		this.screen.precede_text_draw("Close window", var3 + 406, var4 + 10, 1, var6);
		this.screen.text_draw("Number in bank in green", var3 + 7, var4 + 24, 1, 65280);
		this.screen.text_draw("Number held in blue", var3 + 289, var4 + 24, 1, 65535);
		var7 = 13684944;
		var8 = this.yhb * 48;

		int var10;
		for (var9 = 0; var9 < 6; ++var9) {
			for (var10 = 0; var10 < 8; ++var10) {
				int var11 = var3 + 7 + var10 * 49;
				int var12 = var4 + 28 + var9 * 34;
				if (this.vhb == var8) {
					this.screen.rect_fill(var11, var12, 49, 34, 16711680, 160);
				} else {
					this.screen.rect_fill(var11, var12, 49, 34, var7, 160);
				}

				this.screen.rect_draw(var11, var12, 50, 35, 0);
				if (var8 < this.shb && this.thb[var8] != -1) {
					this.screen.resize_trans_sprite_plot(var11, var12, 48, 32, this.item_sprite_off + Config.item_sprite[this.thb[var8]],
							Config.item_tint[this.thb[var8]], 0, 0, false);
					this.screen.text_draw(String.valueOf(this.uhb[var8]), var11 + 1, var12 + 10, 1, 65280);
					this.screen.precede_text_draw(String.valueOf(this.method_205(this.thb[var8])), var11 + 47, var12 + 29, 1,
							65535);
				}

				++var8;
			}
		}

		this.screen.line_horiz(var3 + 5, var4 + 256, 398, 0);
		if (this.vhb == -1) {
			this.screen.center_text_draw("Select an object to withdraw or deposit", var3 + 204, var4 + 248, 3, 16776960);
		} else {
			if (this.vhb < 0) {
				var10 = -1;
			} else {
				var10 = this.thb[this.vhb];
			}

			if (var10 != -1) {
				var8 = this.uhb[this.vhb];
				if (Config.item_stackable[var10] == 1 && var8 > 1) {
					var8 = 1;
				}

				if (var8 > 0) {
					this.screen.text_draw("Withdraw " + Config.item_name[var10], var3 + 2, var4 + 248, 1,
							16777215);
					var6 = 16777215;
					if (super.mouse_x >= var3 + 220 && super.mouse_y >= var4 + 238 && super.mouse_x < var3 + 250
							&& super.mouse_y <= var4 + 249) {
						var6 = 16711680;
					}

					this.screen.text_draw("One", var3 + 222, var4 + 248, 1, var6);
					if (var8 >= 5) {
						var6 = 16777215;
						if (super.mouse_x >= var3 + 250 && super.mouse_y >= var4 + 238
								&& super.mouse_x < var3 + 280 && super.mouse_y <= var4 + 249) {
							var6 = 16711680;
						}

						this.screen.text_draw("Five", var3 + 252, var4 + 248, 1, var6);
					}

					if (var8 >= 25) {
						var6 = 16777215;
						if (super.mouse_x >= var3 + 280 && super.mouse_y >= var4 + 238
								&& super.mouse_x < var3 + 305 && super.mouse_y <= var4 + 249) {
							var6 = 16711680;
						}

						this.screen.text_draw("25", var3 + 282, var4 + 248, 1, var6);
					}

					if (var8 >= 100) {
						var6 = 16777215;
						if (super.mouse_x >= var3 + 305 && super.mouse_y >= var4 + 238
								&& super.mouse_x < var3 + 335 && super.mouse_y <= var4 + 249) {
							var6 = 16711680;
						}

						this.screen.text_draw("100", var3 + 307, var4 + 248, 1, var6);
					}

					if (var8 >= 500) {
						var6 = 16777215;
						if (super.mouse_x >= var3 + 335 && super.mouse_y >= var4 + 238
								&& super.mouse_x < var3 + 368 && super.mouse_y <= var4 + 249) {
							var6 = 16711680;
						}

						this.screen.text_draw("500", var3 + 337, var4 + 248, 1, var6);
					}

					if (var8 >= 2500) {
						var6 = 16777215;
						if (super.mouse_x >= var3 + 370 && super.mouse_y >= var4 + 238
								&& super.mouse_x < var3 + 400 && super.mouse_y <= var4 + 249) {
							var6 = 16711680;
						}

						this.screen.text_draw("2500", var3 + 370, var4 + 248, 1, var6);
					}
				}

				if (this.method_205(var10) > 0) {
					this.screen.text_draw("Deposit " + Config.item_name[var10], var3 + 2, var4 + 273, 1, 16777215);
					var6 = 16777215;
					if (super.mouse_x >= var3 + 220 && super.mouse_y >= var4 + 263 && super.mouse_x < var3 + 250
							&& super.mouse_y <= var4 + 274) {
						var6 = 16711680;
					}

					this.screen.text_draw("One", var3 + 222, var4 + 273, 1, var6);
					if (this.method_205(var10) >= 5) {
						var6 = 16777215;
						if (super.mouse_x >= var3 + 250 && super.mouse_y >= var4 + 263
								&& super.mouse_x < var3 + 280 && super.mouse_y <= var4 + 274) {
							var6 = 16711680;
						}

						this.screen.text_draw("Five", var3 + 252, var4 + 273, 1, var6);
					}

					if (this.method_205(var10) >= 25) {
						var6 = 16777215;
						if (super.mouse_x >= var3 + 280 && super.mouse_y >= var4 + 263
								&& super.mouse_x < var3 + 305 && super.mouse_y <= var4 + 274) {
							var6 = 16711680;
						}

						this.screen.text_draw("25", var3 + 282, var4 + 273, 1, var6);
					}

					if (this.method_205(var10) >= 100) {
						var6 = 16777215;
						if (super.mouse_x >= var3 + 305 && super.mouse_y >= var4 + 263
								&& super.mouse_x < var3 + 335 && super.mouse_y <= var4 + 274) {
							var6 = 16711680;
						}

						this.screen.text_draw("100", var3 + 307, var4 + 273, 1, var6);
					}

					if (this.method_205(var10) >= 500) {
						var6 = 16777215;
						if (super.mouse_x >= var3 + 335 && super.mouse_y >= var4 + 263
								&& super.mouse_x < var3 + 368 && super.mouse_y <= var4 + 274) {
							var6 = 16711680;
						}

						this.screen.text_draw("500", var3 + 337, var4 + 273, 1, var6);
					}

					if (this.method_205(var10) >= 2500) {
						var6 = 16777215;
						if (super.mouse_x >= var3 + 370 && super.mouse_y >= var4 + 263
								&& super.mouse_x < var3 + 400 && super.mouse_y <= var4 + 274) {
							var6 = 16711680;
						}

						this.screen.text_draw("2500", var3 + 370, var4 + 273, 1, var6);
					}
				}
			}

		}
	}


	public void method_226() {
		int var3;
		int var4;
		int var5;
		int var6;
		int var7;
		if (this.field_184 != 0) {
			this.field_184 = 0;
			int var1 = super.mouse_x - 52;
			int var2 = super.mouse_y - 44;
			if (var1 < 0 || var2 < 12 || var1 >= 408 || var2 >= 246) {
				conn.enter(218);
				conn.exit();
				this.ghb = false;
				return;
			}

			var3 = 0;

			for (var4 = 0; var4 < 5; ++var4) {
				for (var5 = 0; var5 < 8; ++var5) {
					var6 = 7 + var5 * 49;
					var7 = 28 + var4 * 34;
					if (var1 > var6 && var1 < var6 + 49 && var2 > var7 && var2 < var7 + 34 && this.jhb[var3] != -1) {
						this.mhb = var3;
						this.nhb = this.jhb[var3];
					}

					++var3;
				}
			}

			if (this.mhb >= 0) {
				var5 = this.jhb[this.mhb];
				if (var5 != -1) {
					if (this.khb[this.mhb] > 0 && var1 > 298 && var2 >= 204 && var1 < 408 && var2 <= 215) {
						var6 = this.ihb + this.lhb[this.mhb];
						if (var6 < 10) {
							var6 = 10;
						}

						var7 = var6 * Config.item_value[var5] / 100;
						conn.enter(217);
						conn.short_put(this.jhb[this.mhb]);
						conn.int_put(var7);
						conn.exit();
					}

					if (this.method_205(var5) > 0 && var1 > 2 && var2 >= 229 && var1 < 112 && var2 <= 240) {
						var6 = this.hhb + this.lhb[this.mhb];
						if (var6 < 10) {
							var6 = 10;
						}

						var7 = var6 * Config.item_value[var5] / 100;
						conn.enter(216);
						conn.short_put(this.jhb[this.mhb]);
						conn.int_put(var7);
						conn.exit();
					}
				}
			}
		}

		byte var11 = 52;
		byte var12 = 44;
		this.screen.rect_fill(var11, var12, 408, 12, 192);
		var3 = 10000536;
		this.screen.rect_fill(var11, var12 + 12, 408, 17, var3, 160);
		this.screen.rect_fill(var11, var12 + 29, 8, 170, var3, 160);
		this.screen.rect_fill(var11 + 399, var12 + 29, 9, 170, var3, 160);
		this.screen.rect_fill(var11, var12 + 199, 408, 47, var3, 160);
		this.screen.text_draw("Buying and selling items", var11 + 1, var12 + 10, 1, 16777215);
		var4 = 16777215;
		if (super.mouse_x > var11 + 320 && super.mouse_y >= var12 && super.mouse_x < var11 + 408
				&& super.mouse_y < var12 + 12) {
			var4 = 16711680;
		}

		this.screen.precede_text_draw("Close window", var11 + 406, var12 + 10, 1, var4);
		this.screen.text_draw("Shops stock in green", var11 + 2, var12 + 24, 1, 65280);
		this.screen.text_draw("Number you own in blue", var11 + 135, var12 + 24, 1, 65535);
		this.screen.text_draw("Your money: " + this.method_205(10) + "gp", var11 + 280, var12 + 24, 1, 16776960);
		var5 = 13684944;
		var6 = 0;

		int var8;
		int var9;
		int var10;
		for (var7 = 0; var7 < 5; ++var7) {
			for (var8 = 0; var8 < 8; ++var8) {
				var9 = var11 + 7 + var8 * 49;
				var10 = var12 + 28 + var7 * 34;
				if (this.mhb == var6) {
					this.screen.rect_fill(var9, var10, 49, 34, 16711680, 160);
				} else {
					this.screen.rect_fill(var9, var10, 49, 34, var5, 160);
				}

				this.screen.rect_draw(var9, var10, 50, 35, 0);
				if (this.jhb[var6] != -1) {
					this.screen.resize_trans_sprite_plot(var9, var10, 48, 32, this.item_sprite_off + Config.item_sprite[this.jhb[var6]],
							Config.item_tint[this.jhb[var6]], 0, 0, false);
					this.screen.text_draw(String.valueOf(this.khb[var6]), var9 + 1, var10 + 10, 1, 65280);
					this.screen.precede_text_draw(String.valueOf(this.method_205(this.jhb[var6])), var9 + 47, var10 + 10, 1,
							65535);
				}

				++var6;
			}
		}

		this.screen.line_horiz(var11 + 5, var12 + 222, 398, 0);
		if (this.mhb == -1) {
			this.screen.center_text_draw("Select an object to buy or sell", var11 + 204, var12 + 214, 3, 16776960);
		} else {
			var8 = this.jhb[this.mhb];
			if (var8 != -1) {
				if (this.khb[this.mhb] > 0) {
					var9 = this.ihb + this.lhb[this.mhb];
					if (var9 < 10) {
						var9 = 10;
					}

					var10 = var9 * Config.item_value[var8] / 100;
					this.screen.text_draw("Buy a new " + Config.item_name[var8] + " for " + var10 + "gp",
							var11 + 2, var12 + 214, 1, 16776960);
					var4 = 16777215;
					if (super.mouse_x > var11 + 298 && super.mouse_y >= var12 + 204 && super.mouse_x < var11 + 408
							&& super.mouse_y <= var12 + 215) {
						var4 = 16711680;
					}

					this.screen.precede_text_draw("Click here to buy", var11 + 405, var12 + 214, 3, var4);
				} else {
					this.screen.center_text_draw("This item is not currently available to buy", var11 + 204, var12 + 214, 3,
							16776960);
				}

				if (this.method_205(var8) > 0) {
					var9 = this.hhb + this.lhb[this.mhb];
					if (var9 < 10) {
						var9 = 10;
					}

					var10 = var9 * Config.item_value[var8] / 100;
					this.screen.precede_text_draw("Sell your " + Config.item_name[var8] + " for " + var10 + "gp",
							var11 + 405, var12 + 239, 1, 16776960);
					var4 = 16777215;
					if (super.mouse_x > var11 + 2 && super.mouse_y >= var12 + 229 && super.mouse_x < var11 + 112
							&& super.mouse_y <= var12 + 240) {
						var4 = 16711680;
					}

					this.screen.text_draw("Click here to sell", var11 + 2, var12 + 239, 3, var4);
					return;
				}

				this.screen.center_text_draw("You do not have any of this item to sell", var11 + 204, var12 + 239, 3,
						16776960);
			}

		}
	}


	public void method_227() {
		byte var1 = 22;
		byte var2 = 36;
		this.screen.rect_fill(var1, var2, 468, 16, 192);
		int var3 = 10000536;
		this.screen.rect_fill(var1, var2 + 16, 468, 246, var3, 160);
		this.screen.center_text_draw("Please confirm your trade with @yel@" + DataUtil.decode_name(this.xgb), var1 + 234,
				var2 + 12, 1, 16777215);
		this.screen.center_text_draw("You are about to give:", var1 + 117, var2 + 30, 1, 16776960);

		for (int var4 = 0; var4 < this.ngb; ++var4) {
			String var5 = Config.item_name[this.ogb[var4]];
			if (Config.item_stackable[this.ogb[var4]] == 0) {
				var5 = var5 + " (" + this.pgb[var4] + ")";
			}

			this.screen.center_text_draw(var5, var1 + 117, var2 + 42 + var4 * 12, 1, 16777215);
		}

		if (this.ngb == 0) {
			this.screen.center_text_draw("Nothing!", var1 + 117, var2 + 42, 1, 16777215);
		}

		this.screen.center_text_draw("In return you will receive:", var1 + 351, var2 + 30, 1, 16776960);

		for (int var7 = 0; var7 < this.qgb; ++var7) {
			String var6 = Config.item_name[this.rgb[var7]];
			if (Config.item_stackable[this.rgb[var7]] == 0) {
				var6 = var6 + " (" + this.sgb[var7] + ")";
			}

			this.screen.center_text_draw(var6, var1 + 351, var2 + 42 + var7 * 12, 1, 16777215);
		}

		if (this.qgb == 0) {
			this.screen.center_text_draw("Nothing!", var1 + 351, var2 + 42, 1, 16777215);
		}

		this.screen.center_text_draw("Are you sure you want to do this?", var1 + 234, var2 + 200, 4, 65535);
		this.screen.center_text_draw("There is NO WAY to reverse a trade if you change your mind.", var1 + 234, var2 + 215,
				1, 16777215);
		this.screen.center_text_draw("Remember that not all players are trustworthy", var1 + 234, var2 + 230, 1, 16777215);
		if (!this.zgb) {
			this.screen.sprite_plot(var1 + 118 - 35, var2 + 238, this.ui_sprite_off + 25);
			this.screen.sprite_plot(var1 + 352 - 35, var2 + 238, this.ui_sprite_off + 26);
		} else {
			this.screen.center_text_draw("Waiting for other player...", var1 + 234, var2 + 250, 1, 16776960);
		}

		if (this.field_184 == 1) {
			if (super.mouse_x < var1 || super.mouse_y < var2 || super.mouse_x > var1 + 468
					|| super.mouse_y > var2 + 262) {
				this.ygb = false;
				conn.enter(233);
				conn.exit();
			}

			if (super.mouse_x >= var1 + 118 - 35 && super.mouse_x <= var1 + 118 + 70
					&& super.mouse_y >= var2 + 238 && super.mouse_y <= var2 + 238 + 21) {
				this.zgb = true;
				conn.enter(202);
				conn.exit();
			}

			if (super.mouse_x >= var1 + 352 - 35 && super.mouse_x <= var1 + 353 + 70
					&& super.mouse_y >= var2 + 238 && super.mouse_y <= var2 + 238 + 21) {
				this.ygb = false;
				conn.enter(233);
				conn.exit();
			}

			this.field_184 = 0;
		}

	}


	public void method_228() {
		if (this.field_184 != 0 && this.wgb == 0) {
			this.wgb = 1;
		}

		int var3;
		int var5;
		int var6;
		int var7;
		int var8;
		int var16;
		if (this.wgb > 0) {
			int var1 = super.mouse_x - 22;
			int var2 = super.mouse_y - 36;
			if (var1 >= 0 && var2 >= 0 && var1 < 468 && var2 < 262) {
				if (var1 > 216 && var2 > 30 && var1 < 462 && var2 < 235) {
					var3 = (var1 - 217) / 49 + (var2 - 31) / 34 * 5;
					if (var3 >= 0 && var3 < this.adb) {
						boolean var4 = false;
						var5 = 0;
						var6 = this.bdb[var3];

						for (var7 = 0; var7 < this.ngb; ++var7) {
							if (this.ogb[var7] == var6) {
								if (Config.item_stackable[var6] == 0) {
									for (var8 = 0; var8 < this.wgb; ++var8) {
										if (this.pgb[var7] < this.cdb[var3]) {
											++this.pgb[var7];
										}

										var4 = true;
									}
								} else {
									++var5;
								}
							}
						}

						if (this.method_205(var6) <= var5) {
							var4 = true;
						}

						if (Config.item_tradable[var6] == 1) {
							this.show_message("This object cannot be traded with other players", 3);
							var4 = true;
						}

						if (!var4 && this.ngb < 12) {
							this.ogb[this.ngb] = var6;
							this.pgb[this.ngb] = 1;
							++this.ngb;
							var4 = true;
						}

						if (var4) {
							conn.enter(234);
							conn.byte_put(this.ngb);

							for (var8 = 0; var8 < this.ngb; ++var8) {
								conn.short_put(this.ogb[var8]);
								conn.int_put(this.pgb[var8]);
							}

							conn.exit();
							this.tgb = false;
							this.ugb = false;
						}
					}
				}

				if (var1 > 8 && var2 > 30 && var1 < 205 && var2 < 133) {
					var3 = (var1 - 9) / 49 + (var2 - 31) / 34 * 4;
					if (var3 >= 0 && var3 < this.ngb) {
						var16 = this.ogb[var3];

						for (var5 = 0; var5 < this.wgb; ++var5) {
							if (Config.item_stackable[var16] != 0 || this.pgb[var3] <= 1) {
								--this.ngb;
								this.vgb = 0;

								for (var6 = var3; var6 < this.ngb; ++var6) {
									this.ogb[var6] = this.ogb[var6 + 1];
									this.pgb[var6] = this.pgb[var6 + 1];
								}
								break;
							}

							--this.pgb[var3];
						}

						conn.enter(234);
						conn.byte_put(this.ngb);

						for (var6 = 0; var6 < this.ngb; ++var6) {
							conn.short_put(this.ogb[var6]);
							conn.int_put(this.pgb[var6]);
						}

						conn.exit();
						this.tgb = false;
						this.ugb = false;
					}
				}

				if (var1 >= 217 && var2 >= 238 && var1 <= 286 && var2 <= 259) {
					this.ugb = true;
					conn.enter(232);
					conn.exit();
				}

				if (var1 >= 394 && var2 >= 238 && var1 < 463 && var2 < 259) {
					this.lgb = false;
					conn.enter(233);
					conn.exit();
				}
			} else if (this.field_184 != 0) {
				this.lgb = false;
				conn.enter(233);
				conn.exit();
			}

			this.field_184 = 0;
			this.wgb = 0;
		}

		if (this.lgb) {
			byte var14 = 22;
			byte var15 = 36;
			this.screen.rect_fill(var14, var15, 468, 12, 192);
			var3 = 10000536;
			this.screen.rect_fill(var14, var15 + 12, 468, 18, var3, 160);
			this.screen.rect_fill(var14, var15 + 30, 8, 248, var3, 160);
			this.screen.rect_fill(var14 + 205, var15 + 30, 11, 248, var3, 160);
			this.screen.rect_fill(var14 + 462, var15 + 30, 6, 248, var3, 160);
			this.screen.rect_fill(var14 + 8, var15 + 133, 197, 22, var3, 160);
			this.screen.rect_fill(var14 + 8, var15 + 258, 197, 20, var3, 160);
			this.screen.rect_fill(var14 + 216, var15 + 235, 246, 43, var3, 160);
			var16 = 13684944;
			this.screen.rect_fill(var14 + 8, var15 + 30, 197, 103, var16, 160);
			this.screen.rect_fill(var14 + 8, var15 + 155, 197, 103, var16, 160);
			this.screen.rect_fill(var14 + 216, var15 + 30, 246, 205, var16, 160);

			for (var5 = 0; var5 < 4; ++var5) {
				this.screen.line_horiz(var14 + 8, var15 + 30 + var5 * 34, 197, 0);
			}

			for (var6 = 0; var6 < 4; ++var6) {
				this.screen.line_horiz(var14 + 8, var15 + 155 + var6 * 34, 197, 0);
			}

			for (var7 = 0; var7 < 7; ++var7) {
				this.screen.line_horiz(var14 + 216, var15 + 30 + var7 * 34, 246, 0);
			}

			for (var8 = 0; var8 < 6; ++var8) {
				if (var8 < 5) {
					this.screen.line_vert(var14 + 8 + var8 * 49, var15 + 30, 103, 0);
				}

				if (var8 < 5) {
					this.screen.line_vert(var14 + 8 + var8 * 49, var15 + 155, 103, 0);
				}

				this.screen.line_vert(var14 + 216 + var8 * 49, var15 + 30, 205, 0);
			}

			this.screen.text_draw("Trading with: " + this.mgb, var14 + 1, var15 + 10, 1, 16777215);
			this.screen.text_draw("Your Offer", var14 + 9, var15 + 27, 4, 16777215);
			this.screen.text_draw("Opponent's Offer", var14 + 9, var15 + 152, 4, 16777215);
			this.screen.text_draw("Your Inventory", var14 + 216, var15 + 27, 4, 16777215);
			if (!this.ugb) {
				this.screen.sprite_plot(var14 + 217, var15 + 238, this.ui_sprite_off + 25);
			}

			this.screen.sprite_plot(var14 + 394, var15 + 238, this.ui_sprite_off + 26);
			if (this.tgb) {
				this.screen.center_text_draw("Other player", var14 + 341, var15 + 246, 1, 16777215);
				this.screen.center_text_draw("has accepted", var14 + 341, var15 + 256, 1, 16777215);
			}

			if (this.ugb) {
				this.screen.center_text_draw("Waiting for", var14 + 217 + 35, var15 + 246, 1, 16777215);
				this.screen.center_text_draw("other player", var14 + 217 + 35, var15 + 256, 1, 16777215);
			}

			int var10;
			int var11;
			for (int var9 = 0; var9 < this.adb; ++var9) {
				var10 = 217 + var14 + var9 % 5 * 49;
				var11 = 31 + var15 + var9 / 5 * 34;
				this.screen.resize_trans_sprite_plot(var10, var11, 48, 32, this.item_sprite_off + Config.item_sprite[this.bdb[var9]],
						Config.item_tint[this.bdb[var9]], 0, 0, false);
				if (Config.item_stackable[this.bdb[var9]] == 0) {
					this.screen.text_draw(String.valueOf(this.cdb[var9]), var10 + 1, var11 + 10, 1, 16776960);
				}
			}

			int var12;
			for (var10 = 0; var10 < this.ngb; ++var10) {
				var11 = 9 + var14 + var10 % 4 * 49;
				var12 = 31 + var15 + var10 / 4 * 34;
				this.screen.resize_trans_sprite_plot(var11, var12, 48, 32, this.item_sprite_off + Config.item_sprite[this.ogb[var10]],
						Config.item_tint[this.ogb[var10]], 0, 0, false);
				if (Config.item_stackable[this.ogb[var10]] == 0) {
					this.screen.text_draw(String.valueOf(this.pgb[var10]), var11 + 1, var12 + 10, 1, 16776960);
				}

				if (super.mouse_x > var11 && super.mouse_x < var11 + 48 && super.mouse_y > var12
						&& super.mouse_y < var12 + 32) {
					this.screen.text_draw(
							Config.item_name[this.ogb[var10]] + ": @whi@" + Config.item_desc[this.ogb[var10]],
							var14 + 8, var15 + 273, 1, 16776960);
				}
			}

			for (var11 = 0; var11 < this.qgb; ++var11) {
				var12 = 9 + var14 + var11 % 4 * 49;
				int var13 = 156 + var15 + var11 / 4 * 34;
				this.screen.resize_trans_sprite_plot(var12, var13, 48, 32, this.item_sprite_off + Config.item_sprite[this.rgb[var11]],
						Config.item_tint[this.rgb[var11]], 0, 0, false);
				if (Config.item_stackable[this.rgb[var11]] == 0) {
					this.screen.text_draw(String.valueOf(this.sgb[var11]), var12 + 1, var13 + 10, 1, 16776960);
				}

				if (super.mouse_x > var12 && super.mouse_x < var12 + 48 && super.mouse_y > var13
						&& super.mouse_y < var13 + 32) {
					this.screen.text_draw(
							Config.item_name[this.rgb[var11]] + ": @whi@" + Config.item_desc[this.rgb[var11]],
							var14 + 8, var15 + 273, 1, 16776960);
				}
			}

		}
	}


	public void method_229() {
		byte var1 = 22;
		byte var2 = 36;
		this.screen.rect_fill(var1, var2, 468, 16, 192);
		int var3 = 10000536;
		this.screen.rect_fill(var1, var2 + 16, 468, 246, var3, 160);
		this.screen.center_text_draw("Please confirm your duel with @yel@" + DataUtil.decode_name(this.agb), var1 + 234,
				var2 + 12, 1, 16777215);
		this.screen.center_text_draw("Your stake:", var1 + 117, var2 + 30, 1, 16776960);

		for (int var4 = 0; var4 < this.mfb; ++var4) {
			String var5 = Config.item_name[this.nfb[var4]];
			if (Config.item_stackable[this.nfb[var4]] == 0) {
				var5 = var5 + " (" + this.ofb[var4] + ")";
			}

			this.screen.center_text_draw(var5, var1 + 117, var2 + 42 + var4 * 12, 1, 16777215);
		}

		if (this.mfb == 0) {
			this.screen.center_text_draw("Nothing!", var1 + 117, var2 + 42, 1, 16777215);
		}

		this.screen.center_text_draw("Your opponent's stake:", var1 + 351, var2 + 30, 1, 16776960);

		for (int var7 = 0; var7 < this.pfb; ++var7) {
			String var6 = Config.item_name[this.qfb[var7]];
			if (Config.item_stackable[this.qfb[var7]] == 0) {
				var6 = var6 + " (" + this.rfb[var7] + ")";
			}

			this.screen.center_text_draw(var6, var1 + 351, var2 + 42 + var7 * 12, 1, 16777215);
		}

		if (this.pfb == 0) {
			this.screen.center_text_draw("Nothing!", var1 + 351, var2 + 42, 1, 16777215);
		}

		if (this.hgb == 0) {
			this.screen.center_text_draw("You can retreat from this duel", var1 + 234, var2 + 180, 1, 65280);
		} else {
			this.screen.center_text_draw("No retreat is possible!", var1 + 234, var2 + 180, 1, 16711680);
		}

		if (this.igb == 0) {
			this.screen.center_text_draw("Magic may be used", var1 + 234, var2 + 192, 1, 65280);
		} else {
			this.screen.center_text_draw("Magic cannot be used", var1 + 234, var2 + 192, 1, 16711680);
		}

		if (this.jgb == 0) {
			this.screen.center_text_draw("Prayer may be used", var1 + 234, var2 + 204, 1, 65280);
		} else {
			this.screen.center_text_draw("Prayer cannot be used", var1 + 234, var2 + 204, 1, 16711680);
		}

		if (this.kgb == 0) {
			this.screen.center_text_draw("Weapons may be used", var1 + 234, var2 + 216, 1, 65280);
		} else {
			this.screen.center_text_draw("Weapons cannot be used", var1 + 234, var2 + 216, 1, 16711680);
		}

		this.screen.center_text_draw("If you are sure click 'Accept' to begin the duel", var1 + 234, var2 + 230, 1,
				16777215);
		if (!this.zfb) {
			this.screen.sprite_plot(var1 + 118 - 35, var2 + 238, this.ui_sprite_off + 25);
			this.screen.sprite_plot(var1 + 352 - 35, var2 + 238, this.ui_sprite_off + 26);
		} else {
			this.screen.center_text_draw("Waiting for other player...", var1 + 234, var2 + 250, 1, 16776960);
		}

		if (this.field_184 == 1) {
			if (super.mouse_x < var1 || super.mouse_y < var2 || super.mouse_x > var1 + 468
					|| super.mouse_y > var2 + 262) {
				this.yfb = false;
				conn.enter(233);
				conn.exit();
			}

			if (super.mouse_x >= var1 + 118 - 35 && super.mouse_x <= var1 + 118 + 70
					&& super.mouse_y >= var2 + 238 && super.mouse_y <= var2 + 238 + 21) {
				this.zfb = true;
				conn.enter(198);
				conn.exit();
			}

			if (super.mouse_x >= var1 + 352 - 35 && super.mouse_x <= var1 + 353 + 70
					&& super.mouse_y >= var2 + 238 && super.mouse_y <= var2 + 238 + 21) {
				this.yfb = false;
				conn.enter(203);
				conn.exit();
			}

			this.field_184 = 0;
		}

	}


	public void method_230() {
		if (this.field_184 != 0 && this.wgb == 0) {
			this.wgb = 1;
		}

		int var3;
		int var5;
		int var6;
		int var7;
		int var8;
		int var17;
		if (this.wgb > 0) {
			int var1 = super.mouse_x - 22;
			int var2 = super.mouse_y - 36;
			if (var1 >= 0 && var2 >= 0 && var1 < 468 && var2 < 262) {
				if (var1 > 216 && var2 > 30 && var1 < 462 && var2 < 235) {
					var3 = (var1 - 217) / 49 + (var2 - 31) / 34 * 5;
					if (var3 >= 0 && var3 < this.adb) {
						boolean var4 = false;
						var5 = 0;
						var6 = this.bdb[var3];

						for (var7 = 0; var7 < this.mfb; ++var7) {
							if (this.nfb[var7] == var6) {
								if (Config.item_stackable[var6] == 0) {
									for (var8 = 0; var8 < this.wgb; ++var8) {
										if (this.ofb[var7] < this.cdb[var3]) {
											++this.ofb[var7];
										}

										var4 = true;
									}
								} else {
									++var5;
								}
							}
						}

						if (this.method_205(var6) <= var5) {
							var4 = true;
						}

						if (Config.item_tradable[var6] == 1) {
							this.show_message("This object cannot be added to a duel offer", 3);
							var4 = true;
						}

						if (!var4 && this.mfb < 8) {
							this.nfb[this.mfb] = var6;
							this.ofb[this.mfb] = 1;
							++this.mfb;
							var4 = true;
						}

						if (var4) {
							conn.enter(201);
							conn.byte_put(this.mfb);

							for (var8 = 0; var8 < this.mfb; ++var8) {
								conn.short_put(this.nfb[var8]);
								conn.int_put(this.ofb[var8]);
							}

							conn.exit();
							this.sfb = false;
							this.tfb = false;
						}
					}
				}

				if (var1 > 8 && var2 > 30 && var1 < 205 && var2 < 129) {
					var3 = (var1 - 9) / 49 + (var2 - 31) / 34 * 4;
					if (var3 >= 0 && var3 < this.mfb) {
						var17 = this.nfb[var3];

						for (var5 = 0; var5 < this.wgb; ++var5) {
							if (Config.item_stackable[var17] != 0 || this.ofb[var3] <= 1) {
								--this.mfb;
								this.vgb = 0;

								for (var6 = var3; var6 < this.mfb; ++var6) {
									this.nfb[var6] = this.nfb[var6 + 1];
									this.ofb[var6] = this.ofb[var6 + 1];
								}
								break;
							}

							--this.ofb[var3];
						}

						conn.enter(201);
						conn.byte_put(this.mfb);

						for (var6 = 0; var6 < this.mfb; ++var6) {
							conn.short_put(this.nfb[var6]);
							conn.int_put(this.ofb[var6]);
						}

						conn.exit();
						this.sfb = false;
						this.tfb = false;
					}
				}

				boolean var16 = false;
				if (var1 >= 93 && var2 >= 221 && var1 <= 104 && var2 <= 232) {
					this.ufb = !this.ufb;
					var16 = true;
				}

				if (var1 >= 93 && var2 >= 240 && var1 <= 104 && var2 <= 251) {
					this.vfb = !this.vfb;
					var16 = true;
				}

				if (var1 >= 191 && var2 >= 221 && var1 <= 202 && var2 <= 232) {
					this.wfb = !this.wfb;
					var16 = true;
				}

				if (var1 >= 191 && var2 >= 240 && var1 <= 202 && var2 <= 251) {
					this.xfb = !this.xfb;
					var16 = true;
				}

				if (var16) {
					conn.enter(200);
					conn.byte_put(this.ufb ? 1 : 0);
					conn.byte_put(this.vfb ? 1 : 0);
					conn.byte_put(this.wfb ? 1 : 0);
					conn.byte_put(this.xfb ? 1 : 0);
					conn.exit();
					this.sfb = false;
					this.tfb = false;
				}

				if (var1 >= 217 && var2 >= 238 && var1 <= 286 && var2 <= 259) {
					this.tfb = true;
					conn.enter(199);
					conn.exit();
				}

				if (var1 >= 394 && var2 >= 238 && var1 < 463 && var2 < 259) {
					this.kfb = false;
					conn.enter(203);
					conn.exit();
				}
			} else if (this.field_184 != 0) {
				this.kfb = false;
				conn.enter(203);
				conn.exit();
			}

			this.field_184 = 0;
			this.wgb = 0;
		}

		if (this.kfb) {
			byte var14 = 22;
			byte var15 = 36;
			this.screen.rect_fill(var14, var15, 468, 12, 13175581);
			var3 = 10000536;
			this.screen.rect_fill(var14, var15 + 12, 468, 18, var3, 160);
			this.screen.rect_fill(var14, var15 + 30, 8, 248, var3, 160);
			this.screen.rect_fill(var14 + 205, var15 + 30, 11, 248, var3, 160);
			this.screen.rect_fill(var14 + 462, var15 + 30, 6, 248, var3, 160);
			this.screen.rect_fill(var14 + 8, var15 + 99, 197, 24, var3, 160);
			this.screen.rect_fill(var14 + 8, var15 + 192, 197, 23, var3, 160);
			this.screen.rect_fill(var14 + 8, var15 + 258, 197, 20, var3, 160);
			this.screen.rect_fill(var14 + 216, var15 + 235, 246, 43, var3, 160);
			var17 = 13684944;
			this.screen.rect_fill(var14 + 8, var15 + 30, 197, 69, var17, 160);
			this.screen.rect_fill(var14 + 8, var15 + 123, 197, 69, var17, 160);
			this.screen.rect_fill(var14 + 8, var15 + 215, 197, 43, var17, 160);
			this.screen.rect_fill(var14 + 216, var15 + 30, 246, 205, var17, 160);

			for (var5 = 0; var5 < 3; ++var5) {
				this.screen.line_horiz(var14 + 8, var15 + 30 + var5 * 34, 197, 0);
			}

			for (var6 = 0; var6 < 3; ++var6) {
				this.screen.line_horiz(var14 + 8, var15 + 123 + var6 * 34, 197, 0);
			}

			for (var7 = 0; var7 < 7; ++var7) {
				this.screen.line_horiz(var14 + 216, var15 + 30 + var7 * 34, 246, 0);
			}

			for (var8 = 0; var8 < 6; ++var8) {
				if (var8 < 5) {
					this.screen.line_vert(var14 + 8 + var8 * 49, var15 + 30, 69, 0);
				}

				if (var8 < 5) {
					this.screen.line_vert(var14 + 8 + var8 * 49, var15 + 123, 69, 0);
				}

				this.screen.line_vert(var14 + 216 + var8 * 49, var15 + 30, 205, 0);
			}

			this.screen.line_horiz(var14 + 8, var15 + 215, 197, 0);
			this.screen.line_horiz(var14 + 8, var15 + 257, 197, 0);
			this.screen.line_vert(var14 + 8, var15 + 215, 43, 0);
			this.screen.line_vert(var14 + 204, var15 + 215, 43, 0);
			this.screen.text_draw("Preparing to duel with: " + this.lfb, var14 + 1, var15 + 10, 1, 16777215);
			this.screen.text_draw("Your Stake", var14 + 9, var15 + 27, 4, 16777215);
			this.screen.text_draw("Opponent's Stake", var14 + 9, var15 + 120, 4, 16777215);
			this.screen.text_draw("Duel Options", var14 + 9, var15 + 212, 4, 16777215);
			this.screen.text_draw("Your Inventory", var14 + 216, var15 + 27, 4, 16777215);
			this.screen.text_draw("No retreating", var14 + 8 + 1, var15 + 215 + 16, 3, 16776960);
			this.screen.text_draw("No magic", var14 + 8 + 1, var15 + 215 + 35, 3, 16776960);
			this.screen.text_draw("No prayer", var14 + 8 + 102, var15 + 215 + 16, 3, 16776960);
			this.screen.text_draw("No weapons", var14 + 8 + 102, var15 + 215 + 35, 3, 16776960);
			this.screen.rect_draw(var14 + 93, var15 + 215 + 6, 11, 11, 16776960);
			if (this.ufb) {
				this.screen.rect_fill(var14 + 95, var15 + 215 + 8, 7, 7, 16776960);
			}

			this.screen.rect_draw(var14 + 93, var15 + 215 + 25, 11, 11, 16776960);
			if (this.vfb) {
				this.screen.rect_fill(var14 + 95, var15 + 215 + 27, 7, 7, 16776960);
			}

			this.screen.rect_draw(var14 + 191, var15 + 215 + 6, 11, 11, 16776960);
			if (this.wfb) {
				this.screen.rect_fill(var14 + 193, var15 + 215 + 8, 7, 7, 16776960);
			}

			this.screen.rect_draw(var14 + 191, var15 + 215 + 25, 11, 11, 16776960);
			if (this.xfb) {
				this.screen.rect_fill(var14 + 193, var15 + 215 + 27, 7, 7, 16776960);
			}

			if (!this.tfb) {
				this.screen.sprite_plot(var14 + 217, var15 + 238, this.ui_sprite_off + 25);
			}

			this.screen.sprite_plot(var14 + 394, var15 + 238, this.ui_sprite_off + 26);
			if (this.sfb) {
				this.screen.center_text_draw("Other player", var14 + 341, var15 + 246, 1, 16777215);
				this.screen.center_text_draw("has accepted", var14 + 341, var15 + 256, 1, 16777215);
			}

			if (this.tfb) {
				this.screen.center_text_draw("Waiting for", var14 + 217 + 35, var15 + 246, 1, 16777215);
				this.screen.center_text_draw("other player", var14 + 217 + 35, var15 + 256, 1, 16777215);
			}

			int var10;
			int var11;
			for (int var9 = 0; var9 < this.adb; ++var9) {
				var10 = 217 + var14 + var9 % 5 * 49;
				var11 = 31 + var15 + var9 / 5 * 34;
				this.screen.resize_trans_sprite_plot(var10, var11, 48, 32, this.item_sprite_off + Config.item_sprite[this.bdb[var9]],
						Config.item_tint[this.bdb[var9]], 0, 0, false);
				if (Config.item_stackable[this.bdb[var9]] == 0) {
					this.screen.text_draw(String.valueOf(this.cdb[var9]), var10 + 1, var11 + 10, 1, 16776960);
				}
			}

			int var12;
			for (var10 = 0; var10 < this.mfb; ++var10) {
				var11 = 9 + var14 + var10 % 4 * 49;
				var12 = 31 + var15 + var10 / 4 * 34;
				this.screen.resize_trans_sprite_plot(var11, var12, 48, 32, this.item_sprite_off + Config.item_sprite[this.nfb[var10]],
						Config.item_tint[this.nfb[var10]], 0, 0, false);
				if (Config.item_stackable[this.nfb[var10]] == 0) {
					this.screen.text_draw(String.valueOf(this.ofb[var10]), var11 + 1, var12 + 10, 1, 16776960);
				}

				if (super.mouse_x > var11 && super.mouse_x < var11 + 48 && super.mouse_y > var12
						&& super.mouse_y < var12 + 32) {
					this.screen.text_draw(
							Config.item_name[this.nfb[var10]] + ": @whi@" + Config.item_desc[this.nfb[var10]],
							var14 + 8, var15 + 273, 1, 16776960);
				}
			}

			for (var11 = 0; var11 < this.pfb; ++var11) {
				var12 = 9 + var14 + var11 % 4 * 49;
				int var13 = 124 + var15 + var11 / 4 * 34;
				this.screen.resize_trans_sprite_plot(var12, var13, 48, 32, this.item_sprite_off + Config.item_sprite[this.qfb[var11]],
						Config.item_tint[this.qfb[var11]], 0, 0, false);
				if (Config.item_stackable[this.qfb[var11]] == 0) {
					this.screen.text_draw(String.valueOf(this.rfb[var11]), var12 + 1, var13 + 10, 1, 16776960);
				}

				if (super.mouse_x > var12 && super.mouse_x < var12 + 48 && super.mouse_y > var13
						&& super.mouse_y < var13 + 32) {
					this.screen.text_draw(
							Config.item_name[this.qfb[var11]] + ": @whi@" + Config.item_desc[this.qfb[var11]],
							var14 + 8, var15 + 273, 1, 16776960);
				}
			}

		}
	}


	public void method_231() {
		if (this.ycb == 0 && super.mouse_x >= this.screen.width - 35 && super.mouse_y >= 3
				&& super.mouse_x < this.screen.width - 3 && super.mouse_y < 35) {
			this.ycb = 1;
		}

		if (this.ycb == 0 && super.mouse_x >= this.screen.width - 35 - 33 && super.mouse_y >= 3
				&& super.mouse_x < this.screen.width - 3 - 33 && super.mouse_y < 35) {
			this.ycb = 2;
		}

		if (this.ycb == 0 && super.mouse_x >= this.screen.width - 35 - 66 && super.mouse_y >= 3
				&& super.mouse_x < this.screen.width - 3 - 66 && super.mouse_y < 35) {
			this.ycb = 3;
		}

		if (this.ycb == 0 && super.mouse_x >= this.screen.width - 35 - 99 && super.mouse_y >= 3
				&& super.mouse_x < this.screen.width - 3 - 99 && super.mouse_y < 35) {
			this.ycb = 4;
		}

		if (this.ycb == 0 && super.mouse_x >= this.screen.width - 35 - 132 && super.mouse_y >= 3
				&& super.mouse_x < this.screen.width - 3 - 132 && super.mouse_y < 35) {
			this.ycb = 5;
		}

		if (this.ycb == 0 && super.mouse_x >= this.screen.width - 35 - 165 && super.mouse_y >= 3
				&& super.mouse_x < this.screen.width - 3 - 165 && super.mouse_y < 35) {
			this.ycb = 6;
		}

		if (this.ycb != 0 && super.mouse_x >= this.screen.width - 35 && super.mouse_y >= 3
				&& super.mouse_x < this.screen.width - 3 && super.mouse_y < 26) {
			this.ycb = 1;
		}

		if (this.ycb != 0 && super.mouse_x >= this.screen.width - 35 - 33 && super.mouse_y >= 3
				&& super.mouse_x < this.screen.width - 3 - 33 && super.mouse_y < 26) {
			this.ycb = 2;
		}

		if (this.ycb != 0 && super.mouse_x >= this.screen.width - 35 - 66 && super.mouse_y >= 3
				&& super.mouse_x < this.screen.width - 3 - 66 && super.mouse_y < 26) {
			this.ycb = 3;
		}

		if (this.ycb != 0 && super.mouse_x >= this.screen.width - 35 - 99 && super.mouse_y >= 3
				&& super.mouse_x < this.screen.width - 3 - 99 && super.mouse_y < 26) {
			this.ycb = 4;
		}

		if (this.ycb != 0 && super.mouse_x >= this.screen.width - 35 - 132 && super.mouse_y >= 3
				&& super.mouse_x < this.screen.width - 3 - 132 && super.mouse_y < 26) {
			this.ycb = 5;
		}

		if (this.ycb != 0 && super.mouse_x >= this.screen.width - 35 - 165 && super.mouse_y >= 3
				&& super.mouse_x < this.screen.width - 3 - 165 && super.mouse_y < 26) {
			this.ycb = 6;
		}

		if (this.ycb == 1
				&& (super.mouse_x < this.screen.width - 248 || super.mouse_y > 36 + this.zcb / 5 * 34)) {
			this.ycb = 0;
		}

		if (this.ycb == 3 && (super.mouse_x < this.screen.width - 199 || super.mouse_y > 294)) {
			this.ycb = 0;
		}

		if ((this.ycb == 2 || this.ycb == 4 || this.ycb == 5)
				&& (super.mouse_x < this.screen.width - 199 || super.mouse_y > 240)) {
			this.ycb = 0;
		}

		if (this.ycb == 6 && (super.mouse_x < this.screen.width - 199 || super.mouse_y > 311)) {
			this.ycb = 0;
		}

	}


	public void method_232(boolean var1) {
		int var2 = this.screen.width - 248;
		this.screen.sprite_plot(var2, 3, this.ui_sprite_off + 1);

		int var4;
		int var5;
		for (int var3 = 0; var3 < this.zcb; ++var3) {
			var4 = var2 + var3 % 5 * 49;
			var5 = 36 + var3 / 5 * 34;
			if (var3 < this.adb && this.ddb[var3] == 1) {
				this.screen.rect_fill(var4, var5, 49, 34, 16711680, 128);
			} else {
				this.screen.rect_fill(var4, var5, 49, 34, Surface.rgb(181, 181, 181), 128);
			}

			if (var3 < this.adb) {
				this.screen.resize_trans_sprite_plot(var4, var5, 48, 32, this.item_sprite_off + Config.item_sprite[this.bdb[var3]],
						Config.item_tint[this.bdb[var3]], 0, 0, false);
				if (Config.item_stackable[this.bdb[var3]] == 0) {
					this.screen.text_draw(String.valueOf(this.cdb[var3]), var4 + 1, var5 + 10, 1, 16776960);
				}
			}
		}

		for (var4 = 1; var4 <= 4; ++var4) {
			this.screen.line_vert(var2 + var4 * 49, 36, this.zcb / 5 * 34, 0);
		}

		for (var5 = 1; var5 <= this.zcb / 5 - 1; ++var5) {
			this.screen.line_horiz(var2, 36 + var5 * 34, 245, 0);
		}

		if (var1) {
			var2 = super.mouse_x - (this.screen.width - 248);
			int var6 = super.mouse_y - 36;
			if (var2 >= 0 && var6 >= 0 && var2 < 248 && var6 < this.zcb / 5 * 34) {
				int var7 = var2 / 49 + var6 / 34 * 5;
				if (var7 < this.adb) {
					int var8 = this.bdb[var7];
					if (this.rdb >= 0) {
						if (Config.spell_type[this.rdb] == 3) {
							this.peb[this.meb] = "Cast " + Config.spell_name[this.rdb] + " on";
							this.oeb[this.meb] = "@lre@" + Config.item_name[var8];
							this.qeb[this.meb] = 600;
							this.teb[this.meb] = var7;
							this.ueb[this.meb] = this.rdb;
							++this.meb;
							return;
						}
					} else {
						if (this.edb >= 0) {
							this.peb[this.meb] = "Use " + this.fdb + " with";
							this.oeb[this.meb] = "@lre@" + Config.item_name[var8];
							this.qeb[this.meb] = 610;
							this.teb[this.meb] = var7;
							this.ueb[this.meb] = this.edb;
							++this.meb;
							return;
						}

						if (this.ddb[var7] == 1) {
							this.peb[this.meb] = "Remove";
							this.oeb[this.meb] = "@lre@" + Config.item_name[var8];
							this.qeb[this.meb] = 620;
							this.teb[this.meb] = var7;
							++this.meb;
						} else if (Config.item_equip_mask[var8] != 0) {
							if ((Config.item_equip_mask[var8] & 24) != 0) {
								this.peb[this.meb] = "Wield";
							} else {
								this.peb[this.meb] = "Wear";
							}

							this.oeb[this.meb] = "@lre@" + Config.item_name[var8];
							this.qeb[this.meb] = 630;
							this.teb[this.meb] = var7;
							++this.meb;
						}

						if (!Config.item_action[var8].equals("")) {
							this.peb[this.meb] = Config.item_action[var8];
							this.oeb[this.meb] = "@lre@" + Config.item_name[var8];
							this.qeb[this.meb] = 640;
							this.teb[this.meb] = var7;
							++this.meb;
						}

						this.peb[this.meb] = "Use";
						this.oeb[this.meb] = "@lre@" + Config.item_name[var8];
						this.qeb[this.meb] = 650;
						this.teb[this.meb] = var7;
						++this.meb;
						this.peb[this.meb] = "Drop";
						this.oeb[this.meb] = "@lre@" + Config.item_name[var8];
						this.qeb[this.meb] = 660;
						this.teb[this.meb] = var7;
						++this.meb;
						this.peb[this.meb] = "Examine";
						this.oeb[this.meb] = "@lre@" + Config.item_name[var8];
						this.qeb[this.meb] = 3600;
						this.teb[this.meb] = var8;
						++this.meb;
					}
				}
			}

		}
	}


	public void method_233(boolean var1) {
		int var2 = this.screen.width - 199;
		short var3 = 156;
		short var4 = 152;
		this.screen.sprite_plot(var2 - 49, 3, this.ui_sprite_off + 2);
		var2 += 40;
		this.screen.rect_fill(var2, 36, var3, var4, 0);
		this.screen.set_rect(var2, 36, var2 + var3, 36 + var4);
		short var5 = 192;
		int var6 = (this.pbb.cur_x - 6040) * 3 * var5 / 2048;
		int var7 = (this.pbb.cur_y - 6040) * 3 * var5 / 2048;
		int var8 = Scene.sin2048_tbl[1024 - this.fbb * 4 & 1023];
		int var9 = Scene.sin2048_tbl[(1024 - this.fbb * 4 & 1023) + 1024];
		int var10 = var7 * var8 + var6 * var9 >> 18;
		var7 = var7 * var9 - var6 * var8 >> 18;
		this.screen.rotate_sprite_plot(var2 + var3 / 2 - var10, 36 + var4 / 2 + var7, this.ui_sprite_off - 1, this.fbb + 64 & 255,
				var5);

		for (int var11 = 0; var11 < this.icb; ++var11) {
			var6 = (this.kcb[var11] * this.field_200 + 64 - this.pbb.cur_x) * 3 * var5 / 2048;
			var7 = (this.lcb[var11] * this.field_200 + 64 - this.pbb.cur_y) * 3 * var5 / 2048;
			var10 = var7 * var8 + var6 * var9 >> 18;
			var7 = var7 * var9 - var6 * var8 >> 18;
			this.method_208(var2 + var3 / 2 + var10, 36 + var4 / 2 - var7, 65535);
		}

		for (int var12 = 0; var12 < this.ccb; ++var12) {
			var6 = (this.dcb[var12] * this.field_200 + 64 - this.pbb.cur_x) * 3 * var5 / 2048;
			var7 = (this.ecb[var12] * this.field_200 + 64 - this.pbb.cur_y) * 3 * var5 / 2048;
			var10 = var7 * var8 + var6 * var9 >> 18;
			var7 = var7 * var9 - var6 * var8 >> 18;
			this.method_208(var2 + var3 / 2 + var10, 36 + var4 / 2 - var7, 16711680);
		}

		for (int var13 = 0; var13 < this.vbb; ++var13) {
			Mob var14 = this.ybb[var13];
			var6 = (var14.cur_x - this.pbb.cur_x) * 3 * var5 / 2048;
			var7 = (var14.cur_y - this.pbb.cur_y) * 3 * var5 / 2048;
			var10 = var7 * var8 + var6 * var9 >> 18;
			var7 = var7 * var9 - var6 * var8 >> 18;
			this.method_208(var2 + var3 / 2 + var10, 36 + var4 / 2 - var7, 16776960);
		}

		for (int var18 = 0; var18 < this.jbb; ++var18) {
			Mob var15 = this.nbb[var18];
			var6 = (var15.cur_x - this.pbb.cur_x) * 3 * var5 / 2048;
			var7 = (var15.cur_y - this.pbb.cur_y) * 3 * var5 / 2048;
			var10 = var7 * var8 + var6 * var9 >> 18;
			var7 = var7 * var9 - var6 * var8 >> 18;
			int var16 = 16777215;

			for (int var17 = 0; var17 < super.friend_cnt; ++var17) {
				if (var15.hash == super.friend_hash[var17] && super.friend_world[var17] == 10) {
					var16 = 65280;
					break;
				}
			}

			this.method_208(var2 + var3 / 2 + var10, 36 + var4 / 2 - var7, var16);
		}

		this.screen.circle_fill(var2 + var3 / 2, 36 + var4 / 2, 2, 16777215, 255);
		this.screen.rotate_sprite_plot(var2 + 19, 55, this.ui_sprite_off + 24, this.fbb + 128 & 255, 128);
		this.screen.set_rect(0, 0, this.wnd_width, this.wnd_height + 12);
		if (var1) {
			var2 = super.mouse_x - (this.screen.width - 199);
			int var19 = super.mouse_y - 36;
			if (var2 >= 40 && var19 >= 0 && var2 < 196 && var19 < 152) {
				var3 = 156;
				var4 = 152;
				var5 = 192;
				var2 = this.screen.width - 199;
				var2 += 40;
				var6 = (super.mouse_x - (var2 + var3 / 2)) * 16384 / (3 * var5);
				var7 = (super.mouse_y - (36 + var4 / 2)) * 16384 / (3 * var5);
				var8 = Scene.sin2048_tbl[1024 - this.fbb * 4 & 1023];
				var9 = Scene.sin2048_tbl[(1024 - this.fbb * 4 & 1023) + 1024];
				var10 = var7 * var8 + var6 * var9 >> 15;
				var7 = var7 * var9 - var6 * var8 >> 15;
				var6 = var10 + this.pbb.cur_x;
				var7 = this.pbb.cur_y - var7;
				if (this.field_184 == 1) {
					this.method_209(this.qbb, this.rbb, var6 / 128, var7 / 128, false);
				}

				this.field_184 = 0;
			}

		}
	}


	public void method_234(boolean var1) {
		int var2 = this.screen.width - 199;
		byte var3 = 36;
		this.screen.sprite_plot(var2 - 49, 3, this.ui_sprite_off + 3);
		short var4 = 196;
		short var5 = 250;
		int var7;
		int var6 = var7 = Surface.rgb(160, 160, 160);
		if (this.ydb == 0) {
			var6 = Surface.rgb(220, 220, 220);
		} else {
			var7 = Surface.rgb(220, 220, 220);
		}

		this.screen.rect_fill(var2, var3, var4 / 2, 24, var6, 128);
		this.screen.rect_fill(var2 + var4 / 2, var3, var4 / 2, 24, var7, 128);
		this.screen.rect_fill(var2, var3 + 24, var4, var5 - 24, Surface.rgb(220, 220, 220), 128);
		this.screen.line_horiz(var2, var3 + 24, var4, 0);
		this.screen.line_vert(var2 + var4 / 2, var3, 24, 0);
		this.screen.center_text_draw("Stats", var2 + var4 / 4, var3 + 16, 4, 0);
		this.screen.center_text_draw("Quests", var2 + var4 / 4 + var4 / 2, var3 + 16, 4, 0);
		int var15;
		if (this.ydb == 0) {
			byte var8 = 72;
			int var9 = -1;
			this.screen.text_draw("Skills", var2 + 5, var8, 3, 16776960);
			var15 = var8 + 13;

			int var11;
			for (int var10 = 0; var10 < 8; ++var10) {
				var11 = 16777215;
				if (super.mouse_x > var2 + 3 && super.mouse_y >= var15 - 11 && super.mouse_y < var15 + 2
						&& super.mouse_x < var2 + 90) {
					var11 = 16711680;
					var9 = var10;
				}

				this.screen.text_draw(this.mdb[var10] + ":@yel@" + this.hdb[var10] + "/" + this.idb[var10], var2 + 5,
						var15, 1, var11);
				var11 = 16777215;
				if (super.mouse_x >= var2 + 90 && super.mouse_y >= var15 - 13 - 11
						&& super.mouse_y < var15 - 13 + 2 && super.mouse_x < var2 + 196) {
					var11 = 16711680;
					var9 = var10 + 8;
				}

				this.screen.text_draw(
						this.mdb[var10 + 8] + ":@yel@" + this.hdb[var10 + 8] + "/" + this.idb[var10 + 8],
						var2 + var4 / 2 - 8, var15 - 13, 1, var11);
				var15 += 13;
			}

			this.screen.text_draw("Quest Points:@yel@" + this.ldb, var2 + var4 / 2 - 8, var15 - 13, 1, 16777215);
			var15 += 8;
			this.screen.text_draw("Equipment Status", var2 + 5, var15, 3, 16776960);
			var15 += 12;

			for (var11 = 0; var11 < 3; ++var11) {
				this.screen.text_draw(this.ndb[var11] + ":@yel@" + this.kdb[var11], var2 + 5, var15, 1, 16777215);
				if (var11 < 2) {
					this.screen.text_draw(this.ndb[var11 + 3] + ":@yel@" + this.kdb[var11 + 3], var2 + var4 / 2 + 25,
							var15, 1, 16777215);
				}

				var15 += 13;
			}

			var15 += 6;
			this.screen.line_horiz(var2, var15 - 15, var4, 0);
			int var12;
			int var13;
			if (var9 != -1) {
				this.screen.text_draw(this.mdb[var9] + " skill", var2 + 5, var15, 1, 16776960);
				var15 += 12;
				var12 = this.exp_steps[0];

				for (var13 = 0; var13 < 98; ++var13) {
					if (this.jdb[var9] >= this.exp_steps[var13]) {
						var12 = this.exp_steps[var13 + 1];
					}
				}

				this.screen.text_draw("Total xp: " + this.jdb[var9] / 4, var2 + 5, var15, 1, 16777215);
				var15 += 12;
				this.screen.text_draw("Next level at: " + var12 / 4, var2 + 5, var15, 1, 16777215);
			} else {
				this.screen.text_draw("Overall levels", var2 + 5, var15, 1, 16776960);
				var15 += 12;
				var12 = 0;

				for (var13 = 0; var13 < 16; ++var13) {
					var12 += this.idb[var13];
				}

				this.screen.text_draw("Skill total: " + var12, var2 + 5, var15, 1, 16777215);
				var15 += 12;
				this.screen.text_draw("Combat level: " + this.pbb.field_517, var2 + 5, var15, 1, 16777215);
				var15 += 12;
			}
		}

		if (this.ydb == 1) {
			this.wdb.clear_entry(this.xdb);
			this.wdb.entry_set(this.xdb, 0, "@whi@Quest-list (green=completed)");

			for (var15 = 0; var15 < this.zdb; ++var15) {
				this.wdb.entry_set(this.xdb, var15 + 1, (this.beb[var15] ? "@gre@" : "@red@") + this.aeb[var15]);
			}

			this.wdb.display();
		}

		if (var1) {
			var2 = super.mouse_x - (this.screen.width - 199);
			int var14 = super.mouse_y - 36;
			if (var2 >= 0 && var14 >= 0 && var2 < var4 && var14 < var5) {
				if (this.ydb == 1) {
					this.wdb.consume(var2 + (this.screen.width - 199), var14 + 36, super.click_state,
							super.mouse_state);
				}

				if (var14 <= 24 && this.field_184 == 1) {
					if (var2 < 98) {
						this.ydb = 0;
						return;
					}

					if (var2 > 98) {
						this.ydb = 1;
					}
				}
			}

		}
	}


	public void method_235(boolean var1) {
		int var2 = this.screen.width - 199;
		byte var3 = 36;
		this.screen.sprite_plot(var2 - 49, 3, this.ui_sprite_off + 4);
		short var4 = 196;
		short var5 = 182;
		int var7;
		int var6 = var7 = Surface.rgb(160, 160, 160);
		if (this.qdb == 0) {
			var6 = Surface.rgb(220, 220, 220);
		} else {
			var7 = Surface.rgb(220, 220, 220);
		}

		this.screen.rect_fill(var2, var3, var4 / 2, 24, var6, 128);
		this.screen.rect_fill(var2 + var4 / 2, var3, var4 / 2, 24, var7, 128);
		this.screen.rect_fill(var2, var3 + 24, var4, 90, Surface.rgb(220, 220, 220), 128);
		this.screen.rect_fill(var2, var3 + 24 + 90, var4, var5 - 90 - 24, Surface.rgb(160, 160, 160), 128);
		this.screen.line_horiz(var2, var3 + 24, var4, 0);
		this.screen.line_vert(var2 + var4 / 2, var3, 24, 0);
		this.screen.line_horiz(var2, var3 + 113, var4, 0);
		this.screen.center_text_draw("Magic", var2 + var4 / 4, var3 + 16, 4, 0);
		this.screen.center_text_draw("Prayers", var2 + var4 / 4 + var4 / 2, var3 + 16, 4, 0);
		int index;
		int var9;
		String var10;
		int var11;
		int var17;
		if (this.qdb == 0) {
			this.odb.clear_entry(this.pdb);
			index = 0;

			int var12;
			for (var9 = 0; var9 < Config.spell_cnt; ++var9) {
				var10 = "@yel@";

				for (var11 = 0; var11 < Config.spell_runes[var9]; ++var11) {
					var12 = Config.spell_rune_ids[var9][var11];
					if (!this.method_206(var12, Config.spell_rune_cnts[var9][var11])) {
						var10 = "@whi@";
						break;
					}
				}

				var12 = this.hdb[6];
				if (Config.spell_lvl[var9] > var12) {
					var10 = "@bla@";
				}

				this.odb.entry_set(this.pdb, index++,
						var10 + "Level " + Config.spell_lvl[var9] + ": " + Config.spell_name[var9]);
			}

			this.odb.display();
			var17 = this.odb.is_hover(this.pdb);
			if (var17 != -1) {
				this.screen.text_draw("Level " + Config.spell_lvl[var17] + ": " + Config.spell_name[var17],
						var2 + 2, var3 + 124, 1, 16776960);
				this.screen.text_draw(Config.spell_desc[var17], var2 + 2, var3 + 136, 0, 16777215);

				for (var11 = 0; var11 < Config.spell_runes[var17]; ++var11) {
					var12 = Config.spell_rune_ids[var17][var11];
					this.screen.sprite_plot(var2 + 2 + var11 * 44, var3 + 150,
							this.item_sprite_off + Config.item_sprite[var12]);
					int var13 = this.method_205(var12);
					int var14 = Config.spell_rune_cnts[var17][var11];
					String var15 = "@red@";
					if (this.method_206(var12, var14)) {
						var15 = "@gre@";
					}

					this.screen.text_draw(var15 + var13 + "/" + var14, var2 + 2 + var11 * 44, var3 + 150, 1,
							16777215);
				}
			} else {
				this.screen.text_draw("Point at a spell for a description", var2 + 2, var3 + 124, 1, 0);
			}
		}

		if (this.qdb == 1) {
			this.odb.clear_entry(this.pdb);
			index = 0;

			for (var9 = 0; var9 < Config.prayer_cnt; ++var9) {
				var10 = "@whi@";
				if (Config.prayer_lvl[var9] > this.idb[5]) {
					var10 = "@bla@";
				}

				if (this.ceb[var9]) {
					var10 = "@gre@";
				}

				this.odb.entry_set(this.pdb, index++,
						var10 + "Level " + Config.prayer_lvl[var9] + ": " + Config.prayer_name[var9]);
			}

			this.odb.display();
			var17 = this.odb.is_hover(this.pdb);
			if (var17 != -1) {
				this.screen.center_text_draw("Level " + Config.prayer_lvl[var17] + ": " + Config.prayer_name[var17],
						var2 + var4 / 2, var3 + 130, 1, 16776960);
				this.screen.center_text_draw(Config.prayer_desc[var17], var2 + var4 / 2, var3 + 145, 0, 16777215);
				this.screen.center_text_draw("Drain rate: " + Config.prayer_drain[var17], var2 + var4 / 2, var3 + 160, 1, 0);
			} else {
				this.screen.text_draw("Point at a prayer for a description", var2 + 2, var3 + 124, 1, 0);
			}
		}

		if (var1) {
			var2 = super.mouse_x - (this.screen.width - 199);
			int var16 = super.mouse_y - 36;
			if (var2 >= 0 && var16 >= 0 && var2 < 196 && var16 < 182) {
				this.odb.consume(var2 + (this.screen.width - 199), var16 + 36, super.click_state,
						super.mouse_state);
				if (var16 <= 24 && this.field_184 == 1) {
					if (var2 < 98 && this.qdb == 1) {
						this.qdb = 0;
						this.odb.reset_list(this.pdb);
					} else if (var2 > 98 && this.qdb == 0) {
						this.qdb = 1;
						this.odb.reset_list(this.pdb);
					}
				}

				if (this.field_184 == 1 && this.qdb == 0) {
					index = this.odb.is_hover(this.pdb);
					if (index != -1) {
						var9 = this.hdb[6];
						if (Config.spell_lvl[index] > var9) {
							this.show_message("Your magic ability is not high enough for this spell", 3);
						} else {
							for (var17 = 0; var17 < Config.spell_runes[index]; ++var17) {
								var11 = Config.spell_rune_ids[index][var17];
								if (!this.method_206(var11, Config.spell_rune_cnts[index][var17])) {
									this.show_message("You don't have all the reagents you need for this spell", 3);
									var17 = -1;
									break;
								}
							}

							if (var17 == Config.spell_runes[index]) {
								this.rdb = index;
								this.edb = -1;
							}
						}
					}
				}

				if (this.field_184 == 1 && this.qdb == 1) {
					index = this.odb.is_hover(this.pdb);
					if (index != -1) {
						var9 = this.idb[5];
						if (Config.prayer_lvl[index] > var9) {
							this.show_message("Your prayer ability is not high enough for this prayer", 3);
						} else if (this.hdb[5] == 0) {
							this.show_message("You have run out of prayer points. Return to a church to recharge", 3);
						} else if (this.ceb[index]) {
							conn.enter(211);
							conn.byte_put(index);
							conn.exit();
							this.ceb[index] = false;
							this.method_179("prayeroff");
						} else {
							conn.enter(212);
							conn.byte_put(index);
							conn.exit();
							this.ceb[index] = true;
							this.method_179("prayeron");
						}
					}
				}

				this.field_184 = 0;
			}

		}
	}


	public void method_236(boolean var1) {
		int var2 = this.screen.width - 199;
		byte var3 = 36;
		this.screen.sprite_plot(var2 - 49, 3, this.ui_sprite_off + 5);
		short var4 = 196;
		short var5 = 182;
		int var7;
		int var6 = var7 = Surface.rgb(160, 160, 160);
		if (this.udb == 0) {
			var6 = Surface.rgb(220, 220, 220);
		} else {
			var7 = Surface.rgb(220, 220, 220);
		}

		this.screen.rect_fill(var2, var3, var4 / 2, 24, var6, 128);
		this.screen.rect_fill(var2 + var4 / 2, var3, var4 / 2, 24, var7, 128);
		this.screen.rect_fill(var2, var3 + 24, var4, var5 - 24, Surface.rgb(220, 220, 220), 128);
		this.screen.line_horiz(var2, var3 + 24, var4, 0);
		this.screen.line_vert(var2 + var4 / 2, var3, 24, 0);
		this.screen.line_horiz(var2, var3 + var5 - 16, var4, 0);
		this.screen.center_text_draw("Friends", var2 + var4 / 4, var3 + 16, 4, 0);
		this.screen.center_text_draw("Ignore", var2 + var4 / 4 + var4 / 2, var3 + 16, 4, 0);
		this.sdb.clear_entry(this.tdb);
		int var8;
		if (this.udb == 0) {
			for (var8 = 0; var8 < super.friend_cnt; ++var8) {
				String var9;
				if (super.friend_world[var8] == 10) {
					var9 = "@gre@";
				} else if (super.friend_world[var8] > 0) {
					var9 = "@yel@";
				} else {
					var9 = "@red@";
				}

				this.sdb.entry_set(this.tdb, var8,
						var9 + DataUtil.decode_name(super.friend_hash[var8]) + "~439~@whi@Remove         WWWWWWWWWW");
			}
		}

		if (this.udb == 1) {
			for (var8 = 0; var8 < super.ignore_cnt; ++var8) {
				this.sdb.entry_set(this.tdb, var8,
						"@yel@" + DataUtil.decode_name(super.ignore_hash[var8]) + "~439~@whi@Remove         WWWWWWWWWW");
			}
		}

		this.sdb.display();
		int var11;
		if (this.udb == 0) {
			var8 = this.sdb.is_hover(this.tdb);
			if (var8 >= 0 && super.mouse_x < 489) {
				if (super.mouse_x > 429) {
					this.screen.center_text_draw("Click to remove " + DataUtil.decode_name(super.friend_hash[var8]),
							var2 + var4 / 2, var3 + 35, 1, 16777215);
				} else if (super.friend_world[var8] == 10) {
					this.screen.center_text_draw("Click to message " + DataUtil.decode_name(super.friend_hash[var8]),
							var2 + var4 / 2, var3 + 35, 1, 16777215);
				} else if (super.friend_world[var8] > 0) {
					this.screen.center_text_draw(
							DataUtil.decode_name(super.friend_hash[var8]) + " is on world " + super.friend_world[var8],
							var2 + var4 / 2, var3 + 35, 1, 16777215);
				} else {
					this.screen.center_text_draw(DataUtil.decode_name(super.friend_hash[var8]) + " is offline", var2 + var4 / 2,
							var3 + 35, 1, 16777215);
				}
			} else {
				this.screen.center_text_draw("Click a name to send a message", var2 + var4 / 2, var3 + 35, 1, 16777215);
			}

			if (super.mouse_x > var2 && super.mouse_x < var2 + var4 && super.mouse_y > var3 + var5 - 16
					&& super.mouse_y < var3 + var5) {
				var11 = 16776960;
			} else {
				var11 = 16777215;
			}

			this.screen.center_text_draw("Click here to add a friend", var2 + var4 / 2, var3 + var5 - 3, 1, var11);
		}

		if (this.udb == 1) {
			var8 = this.sdb.is_hover(this.tdb);
			if (var8 >= 0 && super.mouse_x < 489 && super.mouse_x > 429) {
				if (super.mouse_x > 429) {
					this.screen.center_text_draw("Click to remove " + DataUtil.decode_name(super.ignore_hash[var8]),
							var2 + var4 / 2, var3 + 35, 1, 16777215);
				}
			} else {
				this.screen.center_text_draw("Blocking messages from:", var2 + var4 / 2, var3 + 35, 1, 16777215);
			}

			if (super.mouse_x > var2 && super.mouse_x < var2 + var4 && super.mouse_y > var3 + var5 - 16
					&& super.mouse_y < var3 + var5) {
				var11 = 16776960;
			} else {
				var11 = 16777215;
			}

			this.screen.center_text_draw("Click here to add a name", var2 + var4 / 2, var3 + var5 - 3, 1, var11);
		}

		if (var1) {
			var2 = super.mouse_x - (this.screen.width - 199);
			int var10 = super.mouse_y - 36;
			if (var2 >= 0 && var10 >= 0 && var2 < 196 && var10 < 182) {
				this.sdb.consume(var2 + (this.screen.width - 199), var10 + 36, super.click_state,
						super.mouse_state);
				if (var10 <= 24 && this.field_184 == 1) {
					if (var2 < 98 && this.udb == 1) {
						this.udb = 0;
						this.sdb.reset_list(this.tdb);
					} else if (var2 > 98 && this.udb == 0) {
						this.udb = 1;
						this.sdb.reset_list(this.tdb);
					}
				}

				if (this.field_184 == 1 && this.udb == 0) {
					var8 = this.sdb.is_hover(this.tdb);
					if (var8 >= 0 && super.mouse_x < 489) {
						if (super.mouse_x > 429) {
							this.friend_remove(super.friend_hash[var8]);
						} else if (super.friend_world[var8] != 0) {
							this.dib = 2;
							this.vdb = super.friend_hash[var8];
							super.line_b_buf = "";
							super.line_b = "";
						}
					}
				}

				if (this.field_184 == 1 && this.udb == 1) {
					var8 = this.sdb.is_hover(this.tdb);
					if (var8 >= 0 && super.mouse_x < 489 && super.mouse_x > 429) {
						this.ignore_remove(super.ignore_hash[var8]);
					}
				}

				if (var10 > 166 && this.field_184 == 1 && this.udb == 0) {
					this.dib = 1;
					super.line_a_buf = "";
					super.line_a = "";
				}

				if (var10 > 166 && this.field_184 == 1 && this.udb == 1) {
					this.dib = 3;
					super.line_a_buf = "";
					super.line_a = "";
				}

				this.field_184 = 0;
			}

		}
	}


	public void method_237(boolean var1) {
		int var2 = this.screen.width - 199;
		byte var3 = 36;
		this.screen.sprite_plot(var2 - 49, 3, this.ui_sprite_off + 6);
		short var4 = 196;
		this.screen.rect_fill(var2, 36, var4, 65, Surface.rgb(181, 181, 181), 160);
		this.screen.rect_fill(var2, 101, var4, 65, Surface.rgb(201, 201, 201), 160);
		this.screen.rect_fill(var2, 166, var4, 95, Surface.rgb(181, 181, 181), 160);
		this.screen.rect_fill(var2, 261, var4, 40, Surface.rgb(201, 201, 201), 160);
		int var5 = var2 + 3;
		int var6 = var3 + 15;
		this.screen.text_draw("Game options - click to toggle", var5, var6, 1, 0);
		var6 += 15;
		if (this.eeb) {
			this.screen.text_draw("Camera angle mode - @gre@Auto", var5, var6, 1, 16777215);
		} else {
			this.screen.text_draw("Camera angle mode - @red@Manual", var5, var6, 1, 16777215);
		}

		var6 += 15;
		if (this.feb) {
			this.screen.text_draw("Mouse buttons - @red@One", var5, var6, 1, 16777215);
		} else {
			this.screen.text_draw("Mouse buttons - @gre@Two", var5, var6, 1, 16777215);
		}

		var6 += 15;
		if (this.is_members) {
			if (this.geb) {
				this.screen.text_draw("Sound effects - @red@off", var5, var6, 1, 16777215);
			} else {
				this.screen.text_draw("Sound effects - @gre@on", var5, var6, 1, 16777215);
			}
		}

		var6 += 15;
		var6 += 5;
		this.screen.text_draw("Security settings", var5, var6, 1, 0);
		var6 += 15;
		int var7 = 16777215;
		if (super.mouse_x > var5 && super.mouse_x < var5 + var4 && super.mouse_y > var6 - 12
				&& super.mouse_y < var6 + 4) {
			var7 = 16776960;
		}

		this.screen.text_draw("Change password", var5, var6, 1, var7);
		var6 += 15;
		var7 = 16777215;
		if (super.mouse_x > var5 && super.mouse_x < var5 + var4 && super.mouse_y > var6 - 12
				&& super.mouse_y < var6 + 4) {
			var7 = 16776960;
		}

		this.screen.text_draw("Change recovery questions", var5, var6, 1, var7);
		var6 += 15;
		var6 += 15;
		var6 += 5;
		this.screen.text_draw("Privacy settings. Will be applied to", var2 + 3, var6, 1, 0);
		var6 += 15;
		this.screen.text_draw("all people not on your friends list", var2 + 3, var6, 1, 0);
		var6 += 15;
		if (super.block_public == 0) {
			this.screen.text_draw("Block chat messages: @red@<off>", var2 + 3, var6, 1, 16777215);
		} else {
			this.screen.text_draw("Block chat messages: @gre@<on>", var2 + 3, var6, 1, 16777215);
		}

		var6 += 15;
		if (super.block_private == 0) {
			this.screen.text_draw("Block private messages: @red@<off>", var2 + 3, var6, 1, 16777215);
		} else {
			this.screen.text_draw("Block private messages: @gre@<on>", var2 + 3, var6, 1, 16777215);
		}

		var6 += 15;
		if (super.block_trades == 0) {
			this.screen.text_draw("Block trade requests: @red@<off>", var2 + 3, var6, 1, 16777215);
		} else {
			this.screen.text_draw("Block trade requests: @gre@<on>", var2 + 3, var6, 1, 16777215);
		}

		var6 += 15;
		if (this.is_members) {
			if (super.block_duels == 0) {
				this.screen.text_draw("Block duel requests: @red@<off>", var2 + 3, var6, 1, 16777215);
			} else {
				this.screen.text_draw("Block duel requests: @gre@<on>", var2 + 3, var6, 1, 16777215);
			}
		}

		var6 += 15;
		var6 += 5;
		this.screen.text_draw("Always logout when you finish", var5, var6, 1, 0);
		var6 += 15;
		var7 = 16777215;
		if (super.mouse_x > var5 && super.mouse_x < var5 + var4 && super.mouse_y > var6 - 12
				&& super.mouse_y < var6 + 4) {
			var7 = 16776960;
		}

		this.screen.text_draw("Click here to logout", var2 + 3, var6, 1, var7);
		if (var1) {
			var2 = super.mouse_x - (this.screen.width - 199);
			int var11 = super.mouse_y - 36;
			if (var2 >= 0 && var11 >= 0 && var2 < 196 && var11 < 265) {
				int var8 = this.screen.width - 199;
				byte var9 = 36;
				var4 = 196;
				var5 = var8 + 3;
				var6 = var9 + 30;
				if (super.mouse_x > var5 && super.mouse_x < var5 + var4 && super.mouse_y > var6 - 12
						&& super.mouse_y < var6 + 4 && this.field_184 == 1) {
					this.eeb = !this.eeb;
					conn.enter(213);
					conn.byte_put(0);
					conn.byte_put(this.eeb ? 1 : 0);
					conn.exit();
				}

				var6 += 15;
				if (super.mouse_x > var5 && super.mouse_x < var5 + var4 && super.mouse_y > var6 - 12
						&& super.mouse_y < var6 + 4 && this.field_184 == 1) {
					this.feb = !this.feb;
					conn.enter(213);
					conn.byte_put(2);
					conn.byte_put(this.feb ? 1 : 0);
					conn.exit();
				}

				var6 += 15;
				if (this.is_members && super.mouse_x > var5 && super.mouse_x < var5 + var4
						&& super.mouse_y > var6 - 12 && super.mouse_y < var6 + 4 && this.field_184 == 1) {
					this.geb = !this.geb;
					conn.enter(213);
					conn.byte_put(3);
					conn.byte_put(this.geb ? 1 : 0);
					conn.exit();
				}

				var6 += 15;
				var6 += 20;
				if (super.mouse_x > var5 && super.mouse_x < var5 + var4 && super.mouse_y > var6 - 12
						&& super.mouse_y < var6 + 4 && this.field_184 == 1) {
					this.eib = 6;
					super.line_a_buf = "";
					super.line_a = "";
				}

				var6 += 15;
				if (super.mouse_x > var5 && super.mouse_x < var5 + var4 && super.mouse_y > var6 - 12
						&& super.mouse_y < var6 + 4 && this.field_184 == 1) {
					conn.enter(197);
					conn.exit();
				}

				var6 += 15;
				var6 += 15;
				boolean var10 = false;
				var6 += 35;
				if (super.mouse_x > var5 && super.mouse_x < var5 + var4 && super.mouse_y > var6 - 12
						&& super.mouse_y < var6 + 4 && this.field_184 == 1) {
					super.block_public = 1 - super.block_public;
					var10 = true;
				}

				var6 += 15;
				if (super.mouse_x > var5 && super.mouse_x < var5 + var4 && super.mouse_y > var6 - 12
						&& super.mouse_y < var6 + 4 && this.field_184 == 1) {
					super.block_private = 1 - super.block_private;
					var10 = true;
				}

				var6 += 15;
				if (super.mouse_x > var5 && super.mouse_x < var5 + var4 && super.mouse_y > var6 - 12
						&& super.mouse_y < var6 + 4 && this.field_184 == 1) {
					super.block_trades = 1 - super.block_trades;
					var10 = true;
				}

				var6 += 15;
				if (this.is_members && super.mouse_x > var5 && super.mouse_x < var5 + var4
						&& super.mouse_y > var6 - 12 && super.mouse_y < var6 + 4 && this.field_184 == 1) {
					super.block_duels = 1 - super.block_duels;
					var10 = true;
				}

				var6 += 15;
				if (var10) {
					this.send_settings(super.block_public, super.block_private, super.block_trades, super.block_duels);
				}

				var6 += 20;
				if (super.mouse_x > var5 && super.mouse_x < var5 + var4 && super.mouse_y > var6 - 12
						&& super.mouse_y < var6 + 4 && this.field_184 == 1) {
					this.method_178();
				}

				this.field_184 = 0;
			}

		}
	}


	public void method_238() {
		int var1 = -1;

		for (int var2 = 0; var2 < this.icb; ++var2) {
			this.pcb[var2] = false;
		}

		for (int var3 = 0; var3 < this.rcb; ++var3) {
			this.xcb[var3] = false;
		}

		int var4 = this.scene.picked_cnt();
		Model[] var5 = this.scene.picked_models();
		int[] var6 = this.scene.picked_faces();

		for (int var7 = 0; var7 < var4 && this.meb <= 200; ++var7) {
			int var8 = var6[var7];
			Model var9 = var5[var7];
			if (var9.face_pick_tag[var8] <= 65535 || var9.face_pick_tag[var8] >= 200000 && var9.face_pick_tag[var8] <= 300000) {
				int var10;
				int var11;
				if (var9 == this.scene.view) {
					var10 = var9.face_pick_tag[var8] % 10000;
					var11 = var9.face_pick_tag[var8] / 10000;
					String var12;
					int var13;
					if (var11 == 1) {
						var12 = "";
						var13 = 0;
						if (this.pbb.field_517 > 0 && this.nbb[var10].field_517 > 0) {
							var13 = this.pbb.field_517 - this.nbb[var10].field_517;
						}

						if (var13 < 0) {
							var12 = "@or1@";
						}

						if (var13 < -3) {
							var12 = "@or2@";
						}

						if (var13 < -6) {
							var12 = "@or3@";
						}

						if (var13 < -9) {
							var12 = "@red@";
						}

						if (var13 > 0) {
							var12 = "@gr1@";
						}

						if (var13 > 3) {
							var12 = "@gr2@";
						}

						if (var13 > 6) {
							var12 = "@gr3@";
						}

						if (var13 > 9) {
							var12 = "@gre@";
						}

						var12 = " " + var12 + "(level-" + this.nbb[var10].field_517 + ")";
						if (this.rdb >= 0) {
							if (Config.spell_type[this.rdb] == 1
									|| Config.spell_type[this.rdb] == 2 && this.rbb < 2203) {
								this.peb[this.meb] = "Cast " + Config.spell_name[this.rdb] + " on";
								this.oeb[this.meb] = "@whi@" + this.nbb[var10].name;
								this.qeb[this.meb] = 800;
								this.reb[this.meb] = this.nbb[var10].cur_x;
								this.seb[this.meb] = this.nbb[var10].cur_y;
								this.teb[this.meb] = this.nbb[var10].index;
								this.ueb[this.meb] = this.rdb;
								++this.meb;
							}
						} else if (this.edb >= 0) {
							this.peb[this.meb] = "Use " + this.fdb + " with";
							this.oeb[this.meb] = "@whi@" + this.nbb[var10].name;
							this.qeb[this.meb] = 810;
							this.reb[this.meb] = this.nbb[var10].cur_x;
							this.seb[this.meb] = this.nbb[var10].cur_y;
							this.teb[this.meb] = this.nbb[var10].index;
							this.ueb[this.meb] = this.edb;
							++this.meb;
						} else {
							if (this.rbb + this.mab + this.qab < 2203
									&& (this.nbb[var10].cur_y - 64) / this.field_200 + this.mab + this.qab < 2203) {
								this.peb[this.meb] = "Attack";
								this.oeb[this.meb] = "@whi@" + this.nbb[var10].name + var12;
								if (var13 >= 0 && var13 < 5) {
									this.qeb[this.meb] = 805;
								} else {
									this.qeb[this.meb] = 2805;
								}

								this.reb[this.meb] = this.nbb[var10].cur_x;
								this.seb[this.meb] = this.nbb[var10].cur_y;
								this.teb[this.meb] = this.nbb[var10].index;
								++this.meb;
							} else if (this.is_members) {
								this.peb[this.meb] = "Duel with";
								this.oeb[this.meb] = "@whi@" + this.nbb[var10].name + var12;
								this.reb[this.meb] = this.nbb[var10].cur_x;
								this.seb[this.meb] = this.nbb[var10].cur_y;
								this.qeb[this.meb] = 2806;
								this.teb[this.meb] = this.nbb[var10].index;
								++this.meb;
							}

							this.peb[this.meb] = "Trade with";
							this.oeb[this.meb] = "@whi@" + this.nbb[var10].name;
							this.qeb[this.meb] = 2810;
							this.teb[this.meb] = this.nbb[var10].index;
							++this.meb;
							this.peb[this.meb] = "Follow";
							this.oeb[this.meb] = "@whi@" + this.nbb[var10].name;
							this.qeb[this.meb] = 2820;
							this.teb[this.meb] = this.nbb[var10].index;
							++this.meb;
						}
					} else if (var11 == 2) {
						if (this.rdb >= 0) {
							if (Config.spell_type[this.rdb] == 3) {
								this.peb[this.meb] = "Cast " + Config.spell_name[this.rdb] + " on";
								this.oeb[this.meb] = "@lre@" + Config.item_name[this.fcb[var10]];
								this.qeb[this.meb] = 200;
								this.reb[this.meb] = this.dcb[var10];
								this.seb[this.meb] = this.ecb[var10];
								this.teb[this.meb] = this.fcb[var10];
								this.ueb[this.meb] = this.rdb;
								++this.meb;
							}
						} else if (this.edb >= 0) {
							this.peb[this.meb] = "Use " + this.fdb + " with";
							this.oeb[this.meb] = "@lre@" + Config.item_name[this.fcb[var10]];
							this.qeb[this.meb] = 210;
							this.reb[this.meb] = this.dcb[var10];
							this.seb[this.meb] = this.ecb[var10];
							this.teb[this.meb] = this.fcb[var10];
							this.ueb[this.meb] = this.edb;
							++this.meb;
						} else {
							this.peb[this.meb] = "Take";
							this.oeb[this.meb] = "@lre@" + Config.item_name[this.fcb[var10]];
							this.qeb[this.meb] = 220;
							this.reb[this.meb] = this.dcb[var10];
							this.seb[this.meb] = this.ecb[var10];
							this.teb[this.meb] = this.fcb[var10];
							++this.meb;
							this.peb[this.meb] = "Examine";
							this.oeb[this.meb] = "@lre@" + Config.item_name[this.fcb[var10]];
							this.qeb[this.meb] = 3200;
							this.teb[this.meb] = this.fcb[var10];
							++this.meb;
						}
					} else if (var11 == 3) {
						var12 = "";
						var13 = -1;
						int var14 = this.ybb[var10].field_500;
						if (Config.npc_attackable[var14] > 0) {
							int var15 = (Config.npc_atk_lvl[var14] + Config.npc_hit_lvl[var14]
									+ Config.npc_def_lvl[var14] + Config.npc_str_lvl[var14]) / 4;
							int var16 = (this.idb[0] + this.idb[1] + this.idb[2] + this.idb[3] + 27) / 4;
							var13 = var16 - var15;
							var12 = "@yel@";
							if (var13 < 0) {
								var12 = "@or1@";
							}

							if (var13 < -3) {
								var12 = "@or2@";
							}

							if (var13 < -6) {
								var12 = "@or3@";
							}

							if (var13 < -9) {
								var12 = "@red@";
							}

							if (var13 > 0) {
								var12 = "@gr1@";
							}

							if (var13 > 3) {
								var12 = "@gr2@";
							}

							if (var13 > 6) {
								var12 = "@gr3@";
							}

							if (var13 > 9) {
								var12 = "@gre@";
							}

							var12 = " " + var12 + "(level-" + var15 + ")";
						}

						if (this.rdb >= 0) {
							if (Config.spell_type[this.rdb] == 2) {
								this.peb[this.meb] = "Cast " + Config.spell_name[this.rdb] + " on";
								this.oeb[this.meb] = "@yel@" + Config.npc_name[this.ybb[var10].field_500];
								this.qeb[this.meb] = 700;
								this.reb[this.meb] = this.ybb[var10].cur_x;
								this.seb[this.meb] = this.ybb[var10].cur_y;
								this.teb[this.meb] = this.ybb[var10].index;
								this.ueb[this.meb] = this.rdb;
								++this.meb;
							}
						} else if (this.edb >= 0) {
							this.peb[this.meb] = "Use " + this.fdb + " with";
							this.oeb[this.meb] = "@yel@" + Config.npc_name[this.ybb[var10].field_500];
							this.qeb[this.meb] = 710;
							this.reb[this.meb] = this.ybb[var10].cur_x;
							this.seb[this.meb] = this.ybb[var10].cur_y;
							this.teb[this.meb] = this.ybb[var10].index;
							this.ueb[this.meb] = this.edb;
							++this.meb;
						} else {
							if (Config.npc_attackable[var14] > 0) {
								this.peb[this.meb] = "Attack";
								this.oeb[this.meb] = "@yel@" + Config.npc_name[this.ybb[var10].field_500] + var12;
								if (var13 >= 0) {
									this.qeb[this.meb] = 715;
								} else {
									this.qeb[this.meb] = 2715;
								}

								this.reb[this.meb] = this.ybb[var10].cur_x;
								this.seb[this.meb] = this.ybb[var10].cur_y;
								this.teb[this.meb] = this.ybb[var10].index;
								++this.meb;
							}

							this.peb[this.meb] = "Talk-to";
							this.oeb[this.meb] = "@yel@" + Config.npc_name[this.ybb[var10].field_500];
							this.qeb[this.meb] = 720;
							this.reb[this.meb] = this.ybb[var10].cur_x;
							this.seb[this.meb] = this.ybb[var10].cur_y;
							this.teb[this.meb] = this.ybb[var10].index;
							++this.meb;
							this.peb[this.meb] = "Examine";
							this.oeb[this.meb] = "@yel@" + Config.npc_name[this.ybb[var10].field_500];
							this.qeb[this.meb] = 3700;
							this.teb[this.meb] = this.ybb[var10].field_500;
							++this.meb;
						}
					}
				} else if (var9 != null && var9.field_291 >= 10000) {
					var10 = var9.field_291 - 10000;
					var11 = this.wcb[var10];
					if (!this.xcb[var10]) {
						if (this.rdb >= 0) {
							if (Config.spell_type[this.rdb] == 4) {
								this.peb[this.meb] = "Cast " + Config.spell_name[this.rdb] + " on";
								this.oeb[this.meb] = "@cya@" + Config.bound_name[var11];
								this.qeb[this.meb] = 300;
								this.reb[this.meb] = this.tcb[var10];
								this.seb[this.meb] = this.ucb[var10];
								this.teb[this.meb] = this.vcb[var10];
								this.ueb[this.meb] = this.rdb;
								++this.meb;
							}
						} else if (this.edb >= 0) {
							this.peb[this.meb] = "Use " + this.fdb + " with";
							this.oeb[this.meb] = "@cya@" + Config.bound_name[var11];
							this.qeb[this.meb] = 310;
							this.reb[this.meb] = this.tcb[var10];
							this.seb[this.meb] = this.ucb[var10];
							this.teb[this.meb] = this.vcb[var10];
							this.ueb[this.meb] = this.edb;
							++this.meb;
						} else {
							if (!Config.bound_action1[var11].equalsIgnoreCase("WalkTo")) {
								this.peb[this.meb] = Config.bound_action1[var11];
								this.oeb[this.meb] = "@cya@" + Config.bound_name[var11];
								this.qeb[this.meb] = 320;
								this.reb[this.meb] = this.tcb[var10];
								this.seb[this.meb] = this.ucb[var10];
								this.teb[this.meb] = this.vcb[var10];
								++this.meb;
							}

							if (!Config.bound_action2[var11].equalsIgnoreCase("Examine")) {
								this.peb[this.meb] = Config.bound_action2[var11];
								this.oeb[this.meb] = "@cya@" + Config.bound_name[var11];
								this.qeb[this.meb] = 2300;
								this.reb[this.meb] = this.tcb[var10];
								this.seb[this.meb] = this.ucb[var10];
								this.teb[this.meb] = this.vcb[var10];
								++this.meb;
							}

							this.peb[this.meb] = "Examine";
							this.oeb[this.meb] = "@cya@" + Config.bound_name[var11];
							this.qeb[this.meb] = 3300;
							this.teb[this.meb] = var11;
							++this.meb;
						}

						this.xcb[var10] = true;
					}
				} else if (var9 != null && var9.field_291 >= 0) {
					var10 = var9.field_291;
					var11 = this.mcb[var10];
					if (!this.pcb[var10]) {
						if (this.rdb >= 0) {
							if (Config.spell_type[this.rdb] == 5) {
								this.peb[this.meb] = "Cast " + Config.spell_name[this.rdb] + " on";
								this.oeb[this.meb] = "@cya@" + Config.obj_name[var11];
								this.qeb[this.meb] = 400;
								this.reb[this.meb] = this.kcb[var10];
								this.seb[this.meb] = this.lcb[var10];
								this.teb[this.meb] = this.ncb[var10];
								this.ueb[this.meb] = this.mcb[var10];
								this.veb[this.meb] = this.rdb;
								++this.meb;
							}
						} else if (this.edb >= 0) {
							this.peb[this.meb] = "Use " + this.fdb + " with";
							this.oeb[this.meb] = "@cya@" + Config.obj_name[var11];
							this.qeb[this.meb] = 410;
							this.reb[this.meb] = this.kcb[var10];
							this.seb[this.meb] = this.lcb[var10];
							this.teb[this.meb] = this.ncb[var10];
							this.ueb[this.meb] = this.mcb[var10];
							this.veb[this.meb] = this.edb;
							++this.meb;
						} else {
							if (!Config.obj_action1[var11].equalsIgnoreCase("WalkTo")) {
								this.peb[this.meb] = Config.obj_action1[var11];
								this.oeb[this.meb] = "@cya@" + Config.obj_name[var11];
								this.qeb[this.meb] = 420;
								this.reb[this.meb] = this.kcb[var10];
								this.seb[this.meb] = this.lcb[var10];
								this.teb[this.meb] = this.ncb[var10];
								this.ueb[this.meb] = this.mcb[var10];
								++this.meb;
							}

							if (!Config.obj_action2[var11].equalsIgnoreCase("Examine")) {
								this.peb[this.meb] = Config.obj_action2[var11];
								this.oeb[this.meb] = "@cya@" + Config.obj_name[var11];
								this.qeb[this.meb] = 2400;
								this.reb[this.meb] = this.kcb[var10];
								this.seb[this.meb] = this.lcb[var10];
								this.teb[this.meb] = this.ncb[var10];
								this.ueb[this.meb] = this.mcb[var10];
								++this.meb;
							}

							this.peb[this.meb] = "Examine";
							this.oeb[this.meb] = "@cya@" + Config.obj_name[var11];
							this.qeb[this.meb] = 3400;
							this.teb[this.meb] = var11;
							++this.meb;
						}

						this.pcb[var10] = true;
					}
				} else {
					if (var8 >= 0) {
						var8 = var9.face_pick_tag[var8] - 200000;
					}

					if (var8 >= 0) {
						var1 = var8;
					}
				}
			}
		}

		if (this.rdb >= 0 && Config.spell_type[this.rdb] <= 1) {
			this.peb[this.meb] = "Cast " + Config.spell_name[this.rdb] + " on self";
			this.oeb[this.meb] = "";
			this.qeb[this.meb] = 1000;
			this.teb[this.meb] = this.rdb;
			++this.meb;
		}

		if (var1 != -1) {
			if (this.rdb >= 0) {
				if (Config.spell_type[this.rdb] == 6) {
					this.peb[this.meb] = "Cast " + Config.spell_name[this.rdb] + " on ground";
					this.oeb[this.meb] = "";
					this.qeb[this.meb] = 900;
					this.reb[this.meb] = this.terrian.field_92[var1];
					this.seb[this.meb] = this.terrian.field_93[var1];
					this.teb[this.meb] = this.rdb;
					++this.meb;
					return;
				}
			} else if (this.edb < 0) {
				this.peb[this.meb] = "Walk here";
				this.oeb[this.meb] = "";
				this.qeb[this.meb] = 920;
				this.reb[this.meb] = this.terrian.field_92[var1];
				this.seb[this.meb] = this.terrian.field_93[var1];
				++this.meb;
			}
		}

	}


	public void method_239() {
		int var1;
		int var2;
		int var3;
		if (this.field_184 == 0) {
			if (super.mouse_x >= this.ieb - 10 && super.mouse_y >= this.jeb - 10
					&& super.mouse_x <= this.ieb + this.keb + 10 && super.mouse_y <= this.jeb + this.leb + 10) {
				this.screen.rect_fill(this.ieb, this.jeb, this.keb, this.leb, 13684944, 160);
				this.screen.text_draw("Choose option", this.ieb + 2, this.jeb + 12, 1, 65535);

				for (var1 = 0; var1 < this.meb; ++var1) {
					var2 = this.ieb + 2;
					var3 = this.jeb + 27 + var1 * 15;
					int var4 = 16777215;
					if (super.mouse_x > var2 - 2 && super.mouse_y > var3 - 12 && super.mouse_y < var3 + 4
							&& super.mouse_x < var2 - 3 + this.keb) {
						var4 = 16776960;
					}

					this.screen.text_draw(this.peb[this.web[var1]] + " " + this.oeb[this.web[var1]], var2, var3, 1,
							var4);
				}

			} else {
				this.heb = false;
			}
		} else {
			for (var1 = 0; var1 < this.meb; ++var1) {
				var2 = this.ieb + 2;
				var3 = this.jeb + 27 + var1 * 15;
				if (super.mouse_x > var2 - 2 && super.mouse_y > var3 - 12 && super.mouse_y < var3 + 4
						&& super.mouse_x < var2 - 3 + this.keb) {
					this.method_241(this.web[var1]);
					break;
				}
			}

			this.field_184 = 0;
			this.heb = false;
		}
	}


	public void method_240() {
		if (this.rdb >= 0 || this.edb >= 0) {
			this.peb[this.meb] = "Cancel";
			this.oeb[this.meb] = "";
			this.qeb[this.meb] = 4000;
			++this.meb;
		}

		for (int var1 = 0; var1 < this.meb; this.web[var1] = var1++) {
			;
		}

		boolean var2 = false;

		int var3;
		int var4;
		while (!var2) {
			var2 = true;

			for (var3 = 0; var3 < this.meb - 1; ++var3) {
				var4 = this.web[var3];
				int var5 = this.web[var3 + 1];
				if (this.qeb[var4] > this.qeb[var5]) {
					this.web[var3] = var5;
					this.web[var3 + 1] = var4;
					var2 = false;
				}
			}
		}

		if (this.meb > 20) {
			this.meb = 20;
		}

		if (this.meb > 0) {
			var3 = -1;

			for (var4 = 0; var4 < this.meb; ++var4) {
				if (this.oeb[this.web[var4]] != null && this.oeb[this.web[var4]].length() > 0) {
					var3 = var4;
					break;
				}
			}

			String var8 = null;
			if ((this.edb >= 0 || this.rdb >= 0) && this.meb == 1) {
				var8 = "Choose a target";
			} else if ((this.edb >= 0 || this.rdb >= 0) && this.meb > 1) {
				var8 = "@whi@" + this.peb[this.web[0]] + " " + this.oeb[this.web[0]];
			} else if (var3 != -1) {
				var8 = this.oeb[this.web[var3]] + ": @whi@" + this.peb[this.web[0]];
			}

			if (this.meb == 2 && var8 != null) {
				var8 = var8 + "@whi@ / 1 more option";
			}

			if (this.meb > 2 && var8 != null) {
				var8 = var8 + "@whi@ / " + (this.meb - 1) + " more options";
			}

			if (var8 != null) {
				this.screen.text_draw(var8, 6, 14, 1, 16776960);
			}

			if (!this.feb && this.field_184 == 1 || this.feb && this.field_184 == 1 && this.meb == 1) {
				this.method_241(this.web[0]);
				this.field_184 = 0;
				return;
			}

			if (!this.feb && this.field_184 == 2 || this.feb && this.field_184 == 1) {
				this.leb = (this.meb + 1) * 15;
				this.keb = this.screen.text_width("Choose option", 1) + 5;

				for (int var6 = 0; var6 < this.meb; ++var6) {
					int var7 = this.screen.text_width(this.peb[var6] + " " + this.oeb[var6], 1) + 5;
					if (var7 > this.keb) {
						this.keb = var7;
					}
				}

				this.ieb = super.mouse_x - this.keb / 2;
				this.jeb = super.mouse_y - 7;
				this.heb = true;
				if (this.ieb < 0) {
					this.ieb = 0;
				}

				if (this.jeb < 0) {
					this.jeb = 0;
				}

				if (this.ieb + this.keb > 510) {
					this.ieb = 510 - this.keb;
				}

				if (this.jeb + this.leb > 315) {
					this.jeb = 315 - this.leb;
				}

				this.field_184 = 0;
			}
		}

	}


	public void method_241(int var1) {
		int var2 = this.reb[var1];
		int var3 = this.seb[var1];
		int var4 = this.teb[var1];
		int var5 = this.ueb[var1];
		int var6 = this.veb[var1];
		int var7 = this.qeb[var1];
		if (var7 == 200) {
			this.method_210(this.qbb, this.rbb, var2, var3, true);
			conn.enter(224);
			conn.short_put(var2 + this.pab);
			conn.short_put(var3 + this.qab);
			conn.short_put(var4);
			conn.short_put(var5);
			conn.exit();
			this.rdb = -1;
		}

		if (var7 == 210) {
			this.method_210(this.qbb, this.rbb, var2, var3, true);
			conn.enter(250);
			conn.short_put(var2 + this.pab);
			conn.short_put(var3 + this.qab);
			conn.short_put(var4);
			conn.short_put(var5);
			conn.exit();
			this.edb = -1;
		}

		if (var7 == 220) {
			this.method_210(this.qbb, this.rbb, var2, var3, true);
			conn.enter(252);
			conn.short_put(var2 + this.pab);
			conn.short_put(var3 + this.qab);
			conn.short_put(var4);
			conn.exit();
		}

		if (var7 == 3200) {
			this.show_message(Config.item_desc[var4], 3);
		}

		if (var7 == 300) {
			this.method_212(var2, var3, var4);
			conn.enter(223);
			conn.short_put(var2 + this.pab);
			conn.short_put(var3 + this.qab);
			conn.byte_put(var4);
			conn.short_put(var5);
			conn.exit();
			this.rdb = -1;
		}

		if (var7 == 310) {
			this.method_212(var2, var3, var4);
			conn.enter(239);
			conn.short_put(var2 + this.pab);
			conn.short_put(var3 + this.qab);
			conn.byte_put(var4);
			conn.short_put(var5);
			conn.exit();
			this.edb = -1;
		}

		if (var7 == 320) {
			this.method_212(var2, var3, var4);
			conn.enter(238);
			conn.short_put(var2 + this.pab);
			conn.short_put(var3 + this.qab);
			conn.byte_put(var4);
			conn.exit();
		}

		if (var7 == 2300) {
			this.method_212(var2, var3, var4);
			conn.enter(229);
			conn.short_put(var2 + this.pab);
			conn.short_put(var3 + this.qab);
			conn.byte_put(var4);
			conn.exit();
		}

		if (var7 == 3300) {
			this.show_message(Config.bound_desc[var4], 3);
		}

		if (var7 == 400) {
			this.method_211(var2, var3, var4, var5);
			conn.enter(222);
			conn.short_put(var2 + this.pab);
			conn.short_put(var3 + this.qab);
			conn.short_put(var6);
			conn.exit();
			this.rdb = -1;
		}

		if (var7 == 410) {
			this.method_211(var2, var3, var4, var5);
			conn.enter(241);
			conn.short_put(var2 + this.pab);
			conn.short_put(var3 + this.qab);
			conn.short_put(var6);
			conn.exit();
			this.edb = -1;
		}

		if (var7 == 420) {
			this.method_211(var2, var3, var4, var5);
			conn.enter(242);
			conn.short_put(var2 + this.pab);
			conn.short_put(var3 + this.qab);
			conn.exit();
		}

		if (var7 == 2400) {
			this.method_211(var2, var3, var4, var5);
			conn.enter(230);
			conn.short_put(var2 + this.pab);
			conn.short_put(var3 + this.qab);
			conn.exit();
		}

		if (var7 == 3400) {
			this.show_message(Config.obj_desc[var4], 3);
		}

		if (var7 == 600) {
			conn.enter(220);
			conn.short_put(var4);
			conn.short_put(var5);
			conn.exit();
			this.rdb = -1;
		}

		if (var7 == 610) {
			conn.enter(240);
			conn.short_put(var4);
			conn.short_put(var5);
			conn.exit();
			this.edb = -1;
		}

		if (var7 == 620) {
			conn.enter(248);
			conn.short_put(var4);
			conn.exit();
		}

		if (var7 == 630) {
			conn.enter(249);
			conn.short_put(var4);
			conn.exit();
		}

		if (var7 == 640) {
			conn.enter(246);
			conn.short_put(var4);
			conn.exit();
		}

		if (var7 == 650) {
			this.edb = var4;
			this.ycb = 0;
			this.fdb = Config.item_name[this.bdb[this.edb]];
		}

		if (var7 == 660) {
			conn.enter(251);
			conn.short_put(var4);
			conn.exit();
			this.edb = -1;
			this.ycb = 0;
			this.show_message("Dropping " + Config.item_name[this.bdb[var4]], 4);
		}

		if (var7 == 3600) {
			this.show_message(Config.item_desc[var4], 3);
		}

		int var8;
		int var9;
		if (var7 == 700) {
			var8 = (var2 - 64) / this.field_200;
			var9 = (var3 - 64) / this.field_200;
			this.method_209(this.qbb, this.rbb, var8, var9, true);
			conn.enter(225);
			conn.short_put(var4);
			conn.short_put(var5);
			conn.exit();
			this.rdb = -1;
		}

		if (var7 == 710) {
			var8 = (var2 - 64) / this.field_200;
			var9 = (var3 - 64) / this.field_200;
			this.method_209(this.qbb, this.rbb, var8, var9, true);
			conn.enter(243);
			conn.short_put(var4);
			conn.short_put(var5);
			conn.exit();
			this.edb = -1;
		}

		if (var7 == 720) {
			var8 = (var2 - 64) / this.field_200;
			var9 = (var3 - 64) / this.field_200;
			this.method_209(this.qbb, this.rbb, var8, var9, true);
			conn.enter(245);
			conn.short_put(var4);
			conn.exit();
		}

		if (var7 == 715 || var7 == 2715) {
			var8 = (var2 - 64) / this.field_200;
			var9 = (var3 - 64) / this.field_200;
			this.method_209(this.qbb, this.rbb, var8, var9, true);
			conn.enter(244);
			conn.short_put(var4);
			conn.exit();
		}

		if (var7 == 3700) {
			this.show_message(Config.npc_action[var4], 3);
		}

		if (var7 == 800) {
			var8 = (var2 - 64) / this.field_200;
			var9 = (var3 - 64) / this.field_200;
			this.method_209(this.qbb, this.rbb, var8, var9, true);
			conn.enter(226);
			conn.short_put(var4);
			conn.short_put(var5);
			conn.exit();
			this.rdb = -1;
		}

		if (var7 == 810) {
			var8 = (var2 - 64) / this.field_200;
			var9 = (var3 - 64) / this.field_200;
			this.method_209(this.qbb, this.rbb, var8, var9, true);
			conn.enter(219);
			conn.short_put(var4);
			conn.short_put(var5);
			conn.exit();
			this.edb = -1;
		}

		if (var7 == 805 || var7 == 2805) {
			var8 = (var2 - 64) / this.field_200;
			var9 = (var3 - 64) / this.field_200;
			this.method_209(this.qbb, this.rbb, var8, var9, true);
			conn.enter(228);
			conn.short_put(var4);
			conn.exit();
		}

		if (var7 == 2806) {
			conn.enter(204);
			conn.short_put(var4);
			conn.exit();
		}

		if (var7 == 2810) {
			conn.enter(235);
			conn.short_put(var4);
			conn.exit();
		}

		if (var7 == 2820) {
			conn.enter(214);
			conn.short_put(var4);
			conn.exit();
		}

		if (var7 == 900) {
			this.method_209(this.qbb, this.rbb, var2, var3, true);
			conn.enter(221);
			conn.short_put(var2 + this.pab);
			conn.short_put(var3 + this.qab);
			conn.short_put(var4);
			conn.exit();
			this.rdb = -1;
		}

		if (var7 == 920) {
			this.method_209(this.qbb, this.rbb, var2, var3, false);
			if (this.hab == -24) {
				this.hab = 24;
			}
		}

		if (var7 == 1000) {
			conn.enter(227);
			conn.short_put(var4);
			conn.exit();
			this.rdb = -1;
		}

		if (var7 == 4000) {
			this.edb = -1;
			this.rdb = -1;
		}

	}

	public mudclient() {
		super();
		this.field_186 = new int[this.field_185];
		this.field_187 = new int[this.field_185];
		this.field_189 = new int[8192];
		this.field_190 = new int[8192];
		this.field_192 = 2;
		this.field_194 = 2;
		this.field_200 = 128;
		this.wnd_width = 512;
		this.wnd_height = 334;
		this.view_distance = 9;
		this.bab = 40;
		this.fab = -1;
		this.gab = -1;
		this.oab = -1;
		this.rab = -1;
		this.zab = 550;
		this.abb = false;
		this.dbb = 1;
		this.fbb = 128;
		this.hbb = 4000;
		this.ibb = 500;
		this.mbb = new Mob[this.hbb];
		this.nbb = new Mob[this.ibb];
		this.obb = new Mob[this.ibb];
		this.pbb = new Mob();
		this.sbb = -1;
		this.tbb = 1500;
		this.ubb = 500;
		this.xbb = new Mob[this.tbb];
		this.ybb = new Mob[this.ubb];
		this.zbb = new Mob[this.ubb];
		this.acb = new int[500];
		this.bcb = 500;
		this.dcb = new int[this.bcb];
		this.ecb = new int[this.bcb];
		this.fcb = new int[this.bcb];
		this.gcb = new int[this.bcb];
		this.hcb = 1500;
		this.jcb = new Model[this.hcb];
		this.kcb = new int[this.hcb];
		this.lcb = new int[this.hcb];
		this.mcb = new int[this.hcb];
		this.ncb = new int[this.hcb];
		this.models = new Model[200];
		this.pcb = new boolean[this.hcb];
		this.qcb = 500;
		this.scb = new Model[this.qcb];
		this.tcb = new int[this.qcb];
		this.ucb = new int[this.qcb];
		this.vcb = new int[this.qcb];
		this.wcb = new int[this.qcb];
		this.xcb = new boolean[this.qcb];
		this.zcb = 30;
		this.bdb = new int[35];
		this.cdb = new int[35];
		this.ddb = new int[35];
		this.edb = -1;
		this.fdb = "";
		this.exp_steps = new int[99];
		this.hdb = new int[16];
		this.idb = new int[16];
		this.jdb = new int[16];
		this.kdb = new int[5];
		this.mdb = new String[] { "Attack", "Defense", "Strength", "Hits", "Ranged", "Prayer", "Magic", "Cooking",
				"Woodcutting", "Fletching", "Fishing", "Firemaking", "Crafting", "Smithing", "Mining", "Herblaw" };
		this.ndb = new String[] { "Armour", "WeaponAim", "WeaponPower", "Magic", "Prayer" };
		this.rdb = -1;
		this.zdb = 22;
		this.aeb = new String[] { "Black knight's fortress", "Cook's assistant", "Demon slayer", "Doric's quest",
				"The restless ghost", "Goblin diplomacy", "Ernest the chicken", "Imp catcher", "Pirate's treasure",
				"Prince Ali rescue", "Romeo & Juliet", "Sheep shearer", "Shield of Arrav", "The knight's sword",
				"Vampire slayer", "Witch's potion", "Dragon slayer", "Witch's house (members)", "Lost city (members)",
				"Hero's quest (members)", "Druidic ritual (members)", "Merlin's crystal (members)" };
		this.beb = new boolean[this.zdb];
		this.ceb = new boolean[50];
		this.deb = false;
		this.eeb = true;
		this.feb = false;
		this.geb = false;
		this.heb = false;
		this.neb = 250;
		this.oeb = new String[this.neb];
		this.peb = new String[this.neb];
		this.qeb = new int[this.neb];
		this.reb = new int[this.neb];
		this.seb = new int[this.neb];
		this.teb = new int[this.neb];
		this.ueb = new int[this.neb];
		this.veb = new int[this.neb];
		this.web = new int[this.neb];
		this.hfb = 5;
		this.ifb = new String[this.hfb];
		this.jfb = new int[this.hfb];
		this.kfb = false;
		this.lfb = "";
		this.nfb = new int[8];
		this.ofb = new int[8];
		this.qfb = new int[8];
		this.rfb = new int[8];
		this.sfb = false;
		this.tfb = false;
		this.ufb = false;
		this.vfb = false;
		this.wfb = false;
		this.xfb = false;
		this.yfb = false;
		this.zfb = false;
		this.cgb = new int[8];
		this.dgb = new int[8];
		this.fgb = new int[8];
		this.ggb = new int[8];
		this.lgb = false;
		this.mgb = "";
		this.ogb = new int[14];
		this.pgb = new int[14];
		this.rgb = new int[14];
		this.sgb = new int[14];
		this.tgb = false;
		this.ugb = false;
		this.ygb = false;
		this.zgb = false;
		this.bhb = new int[14];
		this.chb = new int[14];
		this.ehb = new int[14];
		this.fhb = new int[14];
		this.ghb = false;
		this.jhb = new int[256];
		this.khb = new int[256];
		this.lhb = new int[256];
		this.mhb = -1;
		this.nhb = -2;
		this.ohb = false;
		this.qhb = new int[256];
		this.rhb = new int[256];
		this.thb = new int[256];
		this.uhb = new int[256];
		this.vhb = -1;
		this.whb = -2;
		this.xhb = 48;
		this.zhb = false;
		this.bib = new String[5];
		this.fib = "";
		this.gib = "";
		this.logged_in = false;
		this.iib = false;
		this.oib = false;
		this.pib = "";
		this.uib = false;
		this.rjb = "";
		this.sjb = "";
		this.tjb = "";
		this.ujb = "";
		this.lkb = false;
		this.pkb = -1;
		this.qkb = new int[5];
		this.rkb = new int[5];
		this.skb = new int[5];
		this.tkb = new int[5];
		this.ukb = new int[] { 0, 1, 2, 3, 4 };
		this.vkb = new String[5];
		this.wkb = false;
		this.ilb = new int[5];
		this.jlb = new int[5];
		this.llb = new String[50];
		this.mlb = new int[50];
		this.nlb = new int[50];
		this.olb = new int[50];
		this.plb = new int[50];
		this.rlb = new int[50];
		this.slb = new int[50];
		this.tlb = new int[50];
		this.ulb = new int[50];
		this.wlb = new int[50];
		this.xlb = new int[50];
		this.ylb = new int[50];
		this.bmb = new int[][] { { 11, 2, 9, 7, 1, 6, 10, 0, 5, 8, 3, 4 }, { 11, 2, 9, 7, 1, 6, 10, 0, 5, 8, 3, 4 },
				{ 11, 3, 2, 9, 7, 1, 6, 10, 0, 5, 8, 4 }, { 3, 4, 2, 9, 7, 1, 6, 10, 8, 11, 0, 5 },
				{ 3, 4, 2, 9, 7, 1, 6, 10, 8, 11, 0, 5 }, { 4, 3, 2, 9, 7, 1, 6, 10, 8, 11, 0, 5 },
				{ 11, 4, 2, 9, 7, 1, 6, 10, 0, 5, 8, 3 }, { 11, 2, 9, 7, 1, 6, 10, 0, 5, 8, 4, 3 } };
		this.cmb = false;
		this.emb = 1;
		this.fmb = 2;
		this.gmb = 2;
		this.hmb = 8;
		this.imb = 14;
		this.kmb = 1;
		this.lmb = new int[] { 16711680, 16744448, 16769024, 10543104, 57344, 32768, 41088, 45311, 33023, 12528,
				14680288, 3158064, 6307840, 8409088, 16777215 };
		this.mmb = new int[] { 16760880, 16752704, 8409136, 6307872, 3158064, 16736288, 16728064, 16777215, 65280,
				65535 };
		this.nmb = new int[] { 15523536, 13415270, 11766848, 10056486, 9461792 };
		this.omb = new int[] { 0, 1, 2, 1 };
		this.pmb = new int[] { 0, 1, 2, 1, 0, 0, 0, 0 };
		this.qmb = new int[] { 0, 0, 0, 0, 0, 1, 2, 1 };
		this.umb = new int[50];
		this.vmb = new int[50];
		this.wmb = new int[50];
		this.xmb = new int[50];
		this.ymb = new String[] { "Where were you born?", "What was your first teacher's name?",
				"What is your father's middle name?", "Who was your first best friend?",
				"What is your favourite vacation spot?", "What is your mother's middle name?",
				"What was your first pet's name?", "What was the name of your first school?",
				"What is your mother's maiden name?", "Who was your first boyfriend/girlfriend?",
				"What was the first computer game you purchased?", "Who is your favourite actor/actress?",
				"Who is your favourite author?", "Who is your favourite musician?",
				"Who is your favourite cartoon character?", "What is your favourite book?",
				"What is your favourite food?", "What is your favourite movie?" };
	}
}
