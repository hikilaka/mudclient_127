package jagex.client;

public final class Scene {
	public static final int[] sin2048_tbl = new int[2048];
	public static final int[] sin512_tbl = new int[512];

	private static final int use_gourad_shading = 12345678;
	
	int ramp_cnt;
	int[] grad_base;
	int[][] grad_ramps;
	int[] field_585;
	public int last_poly_cnt;
	public int clip_near;
	public int clip_far_3d;
	public int clip_far_2d;
	public int fog_falloff;
	public int fog_distance;
	public boolean wide_band;
	private boolean picking_active;
	private int click_x;
	private int click_y;
	private int picked_cnt;
	private int max_picked;
	private Model[] picked_models;
	private int[] picked_faces;
	private int width;
	private int clip_x;
	private int clip_y;
	private int base_x;
	private int base_y;
	private int view_dist;
	private int magnitude;
	private int cam_x;
	private int cam_y;
	private int cam_z;
	private int cam_yaw;
	private int cam_pitch;
	private int cam_roll;
	public int model_cnt;
	public int model_cap;
	public Model[] models;
	private int[] model_state;
	private int poly_cnt;
	private Polygon[] polys;
	private int sprite_cnt;
	private int[] sprite_id;
	private int[] sprite_x;
	private int[] sprite_y;
	private int[] sprite_z;
	private int[] sprite_w;
	private int[] sprite_h;
	private int[] sprite_trans_x;
	public Model view;
	int texture_cnt;
	byte[][] texture_raster;
	int[][] texture_palette;
	int[] texture_dim;
	long[] texture_id;
	int[][] texture_pixels;
	boolean[] texture_trans_back;
	private static long next_id;
	int[][] pool64;
	int[][] pool256;
	private static byte[] field_647;
	Surface surface;
	public int[] raster;
	Scanline[] scanlines;
	int min_y;
	int max_y;
	int[] plane_x;
	int[] plane_y;
	int[] vert_shade;
	int[] vert_x;
	int[] vert_y;
	int[] vert_z;
	boolean reduce_lag;
	static int frustum_max_x;
	static int frustum_min_x;
	static int frustum_max_y;
	static int frustum_min_y;
	static int frustum_far_z;
	static int frustum_near_z;
	int new_start;
	int new_end;

	public Scene(Surface s, int model_capacity, int poly_capacity, int sprite_capacity) {
		ramp_cnt = 50;
		grad_base = new int[ramp_cnt];
		grad_ramps = new int[ramp_cnt][256];
		clip_near = 5;
		clip_far_3d = 1000;
		clip_far_2d = 1000;
		fog_falloff = 20;
		fog_distance = 10;
		wide_band = false;
		picking_active = false;
		max_picked = 100;
		picked_models = new Model[max_picked];
		picked_faces = new int[max_picked];
		width = 512;
		clip_x = 256;
		clip_y = 192;
		base_x = 256;
		base_y = 256;
		view_dist = 8;
		this.magnitude = 4;
		plane_x = new int[40];
		plane_y = new int[40];
		vert_shade = new int[40];
		vert_x = new int[40];
		vert_y = new int[40];
		vert_z = new int[40];
		reduce_lag = false;
		surface = s;
		clip_x = s.width / 2;
		clip_y = s.height / 2;
		raster = s.pixels;
		model_cnt = 0;
		model_cap = model_capacity;
		models = new Model[model_cap];
		model_state = new int[model_cap];
		poly_cnt = 0;
		polys = new Polygon[poly_capacity];

		for (int i = 0; i < poly_capacity; ++i) {
			polys[i] = new Polygon();
		}

		sprite_cnt = 0;
		view = new Model(sprite_capacity * 2, sprite_capacity);
		sprite_id = new int[sprite_capacity];
		sprite_w = new int[sprite_capacity];
		sprite_h = new int[sprite_capacity];
		sprite_x = new int[sprite_capacity];
		sprite_y = new int[sprite_capacity];
		sprite_z = new int[sprite_capacity];
		sprite_trans_x = new int[sprite_capacity];

		if (field_647 == null) {
			field_647 = new byte[17691];
		}

		cam_x = 0;
		cam_y = 0;
		cam_z = 0;
		cam_yaw = 0;
		cam_pitch = 0;
		cam_roll = 0;

		for (int i = 0; i < 256; ++i) {
			sin512_tbl[i] = (int) (Math.sin((double) i * 0.02454369D) * 32768.0D);
			sin512_tbl[i + 256] = (int) (Math.cos((double) i * 0.02454369D) * 32768.0D);
		}

		for (int i = 0; i < 1024; ++i) {
			sin2048_tbl[i] = (int) (Math.sin((double) i * 0.00613592315D) * 32768.0D);
			sin2048_tbl[i + 1024] = (int) (Math.cos((double) i * 0.00613592315D) * 32768.0D);
		}

	}

	public void add(Model model) {
		if (model_cnt < model_cap) {
			model_state[model_cnt] = 0;
			models[model_cnt++] = model;
		}
	}

	public void remove(Model model) {
		for (int i = 0; i < model_cnt; ++i) {
			if (models[i] == model) {
				model_cnt -= 1;

				for (int j = i; j < model_cnt; ++j) {
					models[j] = models[j + 1];
					model_state[j] = model_state[j + 1];
				}
			}
		}
	}

	public void dispose() {
		clear();

		for (int i = 0; i < model_cnt; ++i) {
			models[i] = null;
		}

		model_cnt = 0;
	}

	public void clear() {
		sprite_cnt = 0;
		view.clear();
	}

	public void reduce(int amount) {
		sprite_cnt -= amount;
		view.reduce(amount, amount * 2);

		if (sprite_cnt < 0) {
			sprite_cnt = 0;
		}
	}

	public int sprite_add(int id, int x, int y, int z, int w, int h, int pick) {
		sprite_id[sprite_cnt] = id;
		sprite_x[sprite_cnt] = x;
		sprite_y[sprite_cnt] = y;
		sprite_z[sprite_cnt] = z;
		sprite_w[sprite_cnt] = w;
		sprite_h[sprite_cnt] = h;
		sprite_trans_x[sprite_cnt] = 0;

		int bottom = view.vert_add(x, y, z);
		int top = view.vert_add(x, y - h, z);
		int[] verts = new int[] { bottom, top };

		view.face_add(2, verts, 0, 0);
		view.face_pick_tag[sprite_cnt] = pick;
		view.is_local_player[sprite_cnt++] = 0;

		return sprite_cnt - 1;
	}

	public void set_local_player(int id) {
		view.is_local_player[id] = 1;
	}

	public void set_trans_x(int id, int value) {
		sprite_trans_x[id] = value;
	}

	public void consume_click(int x, int y) {
		click_x = x - base_x;
		click_y = y;
		picked_cnt = 0;
		picking_active = true;
	}

	public int picked_cnt() {
		return picked_cnt;
	}

	public int[] picked_faces() {
		return picked_faces;
	}

	public Model[] picked_models() {
		return picked_models;
	}

	public void set_bounds(int bx, int by, int cx, int cy, int w, int dist) {
		clip_x = cx;
		clip_y = cy;
		base_x = bx;
		base_y = by;
		width = w;
		view_dist = dist;
		scanlines = new Scanline[cy + by];

		for (int i = 0; i < cy + by; ++i) {
			scanlines[i] = new Scanline();
		}
	}

	private void qsort(Polygon[] entites, int lo, int hi) {
		if (lo < hi) {
			int prev = lo - 1;
			int next = hi + 1;
			int pivot = (lo + hi) / 2;

			Polygon mid = entites[pivot];
			entites[pivot] = entites[lo];
			entites[lo] = mid;
			int depth = mid.depth;

			while (prev < next) {
				do {
					--next;
				} while (entites[next].depth < depth);

				do {
					++prev;
				} while (entites[prev].depth > depth);

				if (prev < next) {
					Polygon entity = entites[prev];
					entites[prev] = entites[next];
					entites[next] = entity;
				}
			}

			qsort(entites, lo, next);
			qsort(entites, next + 1, hi);
		}

	}

	public void intersect_sort(int step, Polygon[] frags, int cnt) {
		for (int i = 0; i <= cnt; ++i) {
			frags[i].handled = false;
			frags[i].key = i;
			frags[i].successor = -1;
		}

		int i = 0;

		while (true) {
			while (frags[i].handled) {
				++i;
			}

			if (i == cnt) {
				return;
			}

			Polygon frag = frags[i];
			frag.handled = true;

			int start = i;
			int end = i + step;

			if (end >= cnt) {
				end = cnt - 1;
			}

			for (int j = end; j >= start + 1; --j) {
				Polygon other = frags[j];
				
				if (frag.min_plane_x < other.max_plane_x && other.min_plane_x < frag.max_plane_x
						&& frag.min_plane_y < other.max_plane_y && other.min_plane_y < frag.max_plane_y
						&& frag.key != other.successor && !separate(frag, other) && heuristic(other, frag)) {

					order(frags, start, j);

					if (frags[j] != other) {
						++j;
					}

					start = new_start;
					other.successor = frag.key;
				}
			}
		}
	}

	public boolean order(Polygon[] polys, int start, int end) {
		while (true) {
			Polygon poly_a = polys[start];
			
			for (int i = start + 1; i <= end; ++i) {
				Polygon poly_b = polys[i];
				
				if (!separate(poly_b, poly_a)) {
					break;
				}

				polys[start] = poly_b;
				polys[i] = poly_a;
				start = i;
				
				if (i == end) {
					new_start = i;
					new_end = i - 1;
					return true;
				}
			}

			Polygon poly_c = polys[end];

			for (int i = end - 1; i >= start; --i) {
				Polygon poly_d = polys[i];
				
				if (!separate(poly_c, poly_d)) {
					break;
				}

				polys[end] = poly_d;
				polys[i] = poly_c;
				end = i;
				
				if (start == i) {
					new_start = i + 1;
					new_end = i;
					return true;
				}
			}

			if (start + 1 >= end) {
				new_start = start;
				new_end = end;
				return false;
			}

			if (!order(polys, start + 1, end)) {
				new_start = start;
				return false;
			}

			end = new_end;
		}
	}

	public void set_frustum(int dx, int dy, int dz) {
		int yaw = -cam_yaw + 1024 & 1023;
		int pitch = -cam_pitch + 1024 & 1023;
		int roll = -cam_roll + 1024 & 1023;
	
		if (roll != 0) {
			int sin = sin2048_tbl[roll];
			int cos = sin2048_tbl[roll + 1024];
			int i = dy * sin + dx * cos >> 15;
			dy = dy * cos - dx * sin >> 15;
			dx = i;
		}

		if (yaw != 0) {
			int sin = sin2048_tbl[yaw];
			int cos = sin2048_tbl[yaw + 1024];
			int i = dy * cos - dz * sin >> 15;
			dz = dy * sin + dz * cos >> 15;
			dy = i;
		}

		if (pitch != 0) {
			int sin = sin2048_tbl[pitch];
			int cos = sin2048_tbl[pitch + 1024];
			int i = dz * sin + dx * cos >> 15;
			dz = dz * cos - dx * sin >> 15;
			dx = i;
		}

		if (dx < frustum_max_x) {
			frustum_max_x = dx;
		}

		if (dx > frustum_min_x) {
			frustum_min_x = dx;
		}

		if (dy < frustum_max_y) {
			frustum_max_y = dy;
		}

		if (dy > frustum_min_y) {
			frustum_min_y = dy;
		}

		if (dz < frustum_far_z) {
			frustum_far_z = dz;
		}

		if (dz > frustum_near_z) {
			frustum_near_z = dz;
		}
	}

	public void render() {
		reduce_lag = surface.reduce_lag;
		
		int x = clip_x * clip_far_3d >> view_dist;
		int y = clip_y * clip_far_3d >> view_dist;
	
		frustum_max_x = 0;
		frustum_min_x = 0;
		frustum_max_y = 0;
		frustum_min_y = 0;
		frustum_far_z = 0;
		frustum_near_z = 0;

		set_frustum(-x, -y, clip_far_3d);
		set_frustum(-x, y, clip_far_3d);
		set_frustum(x, -y, clip_far_3d);
		set_frustum(x, y, clip_far_3d);
		set_frustum(-clip_x, -clip_y, 0);
		set_frustum(-clip_x, clip_y, 0);
		set_frustum(clip_x, -clip_y, 0);
		set_frustum(clip_x, clip_y, 0);
		
		frustum_max_x += cam_x;
		frustum_min_x += cam_x;
		frustum_max_y += cam_y;
		frustum_min_y += cam_y;
		frustum_far_z += cam_z;
		frustum_near_z += cam_z;
		
		models[model_cnt] = view;
		view.trans_state = 2;

		for (int i = 0; i < model_cnt; ++i) {
			models[i].project(cam_x, cam_y, cam_z, cam_yaw, cam_pitch, cam_roll, view_dist, clip_near);
		}

		models[model_cnt].project(cam_x, cam_y, cam_z, cam_yaw, cam_pitch, cam_roll, view_dist, clip_near);
		
		poly_cnt = 0;
		
		for (int i = 0; i < model_cnt; ++i) {
			Model model = models[i];
			if (model.visible) {
				for (int j = 0; j < model.face_cnt; ++j) {
					int vert_cnt = model.face_vert_cnt[j];
					int[] verts = model.face_verts[j];
					boolean flag = false;

					for (int k = 0; k < vert_cnt; ++k) {
						int vert_z = model.project_vert_z[verts[k]];
						
						if (vert_z > clip_near && vert_z < clip_far_3d) {
							flag = true;
							break;
						}
					}

					if (flag) {
						int mask = 0;

						for (int k = 0; k < vert_cnt; ++k) {
							int plane_x = model.project_plane_x[verts[k]];
							
							if (plane_x > -clip_x) {
								mask |= 1;
							}

							if (plane_x < clip_x) {
								mask |= 2;
							}

							if (mask == 3) {
								break;
							}
						}

						if (mask == 3) {
							mask = 0;

							for (int k = 0; k < vert_cnt; ++k) {
								int plane_y = model.project_plane_y[verts[k]];
								if (plane_y > -clip_y) {
									mask |= 1;
								}

								if (plane_y < clip_y) {
									mask |= 2;
								}

								if (mask == 3) {
									break;
								}
							}

							if (mask == 3) {
								Polygon poly = polys[poly_cnt];
								poly.model = model;
								poly.face = j;
								
								init_poly_3d(poly_cnt);
								int text;
								if (poly.visibility < 0) {
									text = model.texture_front[j];
								} else {
									text = model.texture_back[j];
								}

								if (text != use_gourad_shading) {
									int cnt = 0;

									for (int k = 0; k < vert_cnt; ++k) {
										cnt += model.project_vert_z[verts[k]];
									}

									poly.depth = cnt / vert_cnt + model.depth;
									poly.texture = text;
									poly_cnt += 1;
								}
							}
						}
					}
				}
			}
		}

		Model v = view;
		if (v.visible) {
			for (int i = 0; i < v.face_cnt; ++i) {
				int[] verts = v.face_verts[i];
				int vert = verts[0];
				int plane_x = v.project_plane_x[vert];
				int plane_y = v.project_plane_y[vert];
				int plane_z = v.project_vert_z[vert];
				
				if (plane_z > clip_near && plane_z < clip_far_2d) {
					int w = (sprite_w[i] << view_dist) / plane_z;
					int h = (sprite_h[i] << view_dist) / plane_z;
					
					if (plane_x - w / 2 <= clip_x && plane_x + w / 2 >= -clip_x && plane_y - h <= clip_y && plane_y >= -clip_y) {
						Polygon poly = polys[poly_cnt];
						poly.model = v;
						poly.face = i;
						init_poly_2d(poly_cnt);
						poly.depth = (plane_z + v.project_vert_z[verts[1]]) / 2;
						poly_cnt += 1;
					}
				}
			}
		}

		if (poly_cnt != 0) {
			last_poly_cnt = poly_cnt;
			
			qsort(polys, 0, poly_cnt - 1);
			intersect_sort(100, polys, poly_cnt);

			for (int i = 0; i < poly_cnt; ++i) {
				Polygon poly = polys[i];
				Model model = poly.model;
				int face = poly.face;

				if (model == this.view) {
					int[] verts = model.face_verts[face];
					int vert_a = verts[0];
					int a_x = model.project_plane_x[vert_a];
					int a_y = model.project_plane_y[vert_a];
					int a_z = model.project_vert_z[vert_a];
					
					int w = (sprite_w[face] << view_dist) / a_z;
					int h = (sprite_h[face] << view_dist) / a_z;
					int dy = a_y - model.project_plane_y[verts[1]];
					int dx = (model.project_plane_x[verts[1]] - a_x) * dy / h;
					dx = model.project_plane_x[verts[1]] - a_x;
					
					int c_x = a_x - w / 2;
					int c_y = base_y + a_y - h;
					
					surface.sprite_3d_plot(c_x + base_x, c_y, w, h, sprite_id[face], dx, (256 << view_dist) / a_z);
					
					if (picking_active && picked_cnt < max_picked) {
						c_x += (sprite_trans_x[face] << view_dist) / a_z;
						
						if (click_y >= c_y && click_y <= c_y + h && click_x >= c_x && click_x <= c_x + w && !model.unpickable && model.is_local_player[face] == 0) {
							picked_models[picked_cnt] = model;
							picked_faces[picked_cnt] = face;
							picked_cnt += 1;
						}
					}
				} else {
					int cnt = 0;
					int shade = 0;
					int vert_vnt = model.face_vert_cnt[face];
					int[] verts = model.face_verts[face];
					
					if (model.light_type[face] != use_gourad_shading) {
						if (poly.visibility < 0) {
							shade = model.light_ambient - model.light_type[face];
						} else {
							shade = model.light_ambient + model.light_type[face];
						}
					}

					for (int j = 0; j < vert_vnt; ++j) {
						int vert = verts[j];
						
						vert_x[j] = model.project_vert_x[vert];
						vert_y[j] = model.project_vert_y[vert];
						vert_z[j] = model.project_vert_z[vert];
						
						if (model.light_type[face] == use_gourad_shading) {
							if (poly.visibility < 0) {
								shade = model.light_ambient - model.vert_shade[vert] + model.vert_ambient[vert];
							} else {
								shade = model.light_ambient + model.vert_shade[vert] + model.vert_ambient[vert];
							}
						}

						if (model.project_vert_z[vert] >= clip_near) {
							plane_x[cnt] = model.project_plane_x[vert];
							plane_y[cnt] = model.project_plane_y[vert];
							vert_shade[cnt] = shade;
							
							if (model.project_vert_z[vert] > fog_distance) {
								vert_shade[cnt] += (model.project_vert_z[vert] - fog_distance) / fog_falloff;
							}

							cnt += 1;
						} else {
							int text;
							if (j == 0) {
								text = verts[vert_vnt - 1];
							} else {
								text = verts[j - 1];
							}

							if (model.project_vert_z[text] >= clip_near) {
								int dz = model.project_vert_z[vert] - model.project_vert_z[text];
								int dx = model.project_vert_x[vert] - (model.project_vert_x[vert] - model.project_vert_x[text]) * (model.project_vert_z[vert] - this.clip_near) / dz;
								int dy = model.project_vert_y[vert] - (model.project_vert_y[vert] - model.project_vert_y[text]) * (model.project_vert_z[vert] - this.clip_near) / dz;
								
								plane_x[cnt] = (dx << view_dist) / clip_near;
								plane_y[cnt] = (dy << view_dist) / clip_near;
								vert_shade[cnt] = shade;
								cnt += 1;
							}

							if (j == vert_vnt - 1) {
								text = verts[0];
							} else {
								text = verts[j + 1];
							}

							if (model.project_vert_z[text] >= clip_near) {
								int dz = model.project_vert_z[vert] - model.project_vert_z[text];
								int dx = model.project_vert_x[vert] - (model.project_vert_x[vert] - model.project_vert_x[text]) * (model.project_vert_z[vert] - clip_near) / dz;
								int dy = model.project_vert_y[vert] - (model.project_vert_y[vert] - model.project_vert_y[text]) * (model.project_vert_z[vert] - clip_near) / dz;
								
								plane_x[cnt] = (dx << view_dist) / clip_near;
								plane_y[cnt] = (dy << view_dist) / clip_near;
								vert_shade[cnt] = shade;
								cnt += 1;
							}
						}
					}

					for (int j = 0; j < vert_vnt; ++j) {
						if (vert_shade[j] < 0) {
							vert_shade[j] = 0;
						} else if (vert_shade[j] > 255) {
							vert_shade[j] = 255;
						}

						if (poly.texture >= 0) {
							if (texture_dim[poly.texture] == 1) {
								vert_shade[j] <<= 9;
							} else {
								vert_shade[j] <<= 6;
							}
						}
					}

					gen_scanlines(0, 0, 0, 0, cnt, plane_x, plane_y, vert_shade, model, face);

					if (max_y > min_y) {
						rasterize(0, 0, vert_vnt, vert_x, vert_y, vert_z, poly.texture, model);
					}
				}
			}

			picking_active = false;
		}
	}

	private void gen_scanlines(int start_x, int x, int a_ptr, int start_s, int vert_cnt, int[] vert_x, int[] vert_y, int[] vert_shade, Model model, int face) {
		int var11;
		int var12;
		int var13;
		int var14;
		int var15;
		int var16;
		int var17;
		int var18;
		int var19;
		int var20;
		int var21;
		int var22;
		int var23;
		int var24;
		int var25;
		int var26;
		int var27;
		int var28;
		int var29;
		int var30;
		int var31;
		int var32;
		int var33;
		int var34;
		int var35;
		int var36;
		int var37;
		int var38;
		int var39;
		Scanline var50;
		if (vert_cnt == 3) {
			var11 = vert_y[0] + this.base_y;
			var12 = vert_y[1] + this.base_y;
			var13 = vert_y[2] + this.base_y;
			var14 = vert_x[0];
			var15 = vert_x[1];
			var16 = vert_x[2];
			var17 = vert_shade[0];
			var18 = vert_shade[1];
			var19 = vert_shade[2];
			var20 = this.base_y + this.clip_y - 1;
			var21 = 0;
			var22 = 0;
			var23 = 0;
			var24 = 0;
			var25 = 12345678;
			var26 = -12345678;
			if (var13 != var11) {
				var22 = (var16 - var14 << 8) / (var13 - var11);
				var24 = (var19 - var17 << 8) / (var13 - var11);
				if (var11 < var13) {
					var21 = var14 << 8;
					var23 = var17 << 8;
					var25 = var11;
					var26 = var13;
				} else {
					var21 = var16 << 8;
					var23 = var19 << 8;
					var25 = var13;
					var26 = var11;
				}

				if (var25 < 0) {
					var21 -= var22 * var25;
					var23 -= var24 * var25;
					var25 = 0;
				}

				if (var26 > var20) {
					var26 = var20;
				}
			}

			var27 = 0;
			var28 = 0;
			var29 = 0;
			var30 = 0;
			var31 = 12345678;
			var32 = -12345678;
			if (var12 != var11) {
				var28 = (var15 - var14 << 8) / (var12 - var11);
				var30 = (var18 - var17 << 8) / (var12 - var11);
				if (var11 < var12) {
					var27 = var14 << 8;
					var29 = var17 << 8;
					var31 = var11;
					var32 = var12;
				} else {
					var27 = var15 << 8;
					var29 = var18 << 8;
					var31 = var12;
					var32 = var11;
				}

				if (var31 < 0) {
					var27 -= var28 * var31;
					var29 -= var30 * var31;
					var31 = 0;
				}

				if (var32 > var20) {
					var32 = var20;
				}
			}

			var33 = 0;
			var34 = 0;
			var35 = 0;
			var36 = 0;
			var37 = 12345678;
			var38 = -12345678;
			if (var13 != var12) {
				var34 = (var16 - var15 << 8) / (var13 - var12);
				var36 = (var19 - var18 << 8) / (var13 - var12);
				if (var12 < var13) {
					var33 = var15 << 8;
					var35 = var18 << 8;
					var37 = var12;
					var38 = var13;
				} else {
					var33 = var16 << 8;
					var35 = var19 << 8;
					var37 = var13;
					var38 = var12;
				}

				if (var37 < 0) {
					var33 -= var34 * var37;
					var35 -= var36 * var37;
					var37 = 0;
				}

				if (var38 > var20) {
					var38 = var20;
				}
			}

			this.min_y = var25;
			if (var31 < this.min_y) {
				this.min_y = var31;
			}

			if (var37 < this.min_y) {
				this.min_y = var37;
			}

			this.max_y = var26;
			if (var32 > this.max_y) {
				this.max_y = var32;
			}

			if (var38 > this.max_y) {
				this.max_y = var38;
			}

			var39 = 0;

			for (a_ptr = this.min_y; a_ptr < this.max_y; ++a_ptr) {
				if (a_ptr >= var25 && a_ptr < var26) {
					x = var21;
					start_x = var21;
					var39 = var23;
					start_s = var23;
					var21 += var22;
					var23 += var24;
				} else {
					start_x = 655360;
					x = -655360;
				}

				if (a_ptr >= var31 && a_ptr < var32) {
					if (var27 < start_x) {
						start_x = var27;
						start_s = var29;
					}

					if (var27 > x) {
						x = var27;
						var39 = var29;
					}

					var27 += var28;
					var29 += var30;
				}

				if (a_ptr >= var37 && a_ptr < var38) {
					if (var33 < start_x) {
						start_x = var33;
						start_s = var35;
					}

					if (var33 > x) {
						x = var33;
						var39 = var35;
					}

					var33 += var34;
					var35 += var36;
				}

				Scanline var40 = this.scanlines[a_ptr];
				var40.field_672 = start_x;
				var40.field_673 = x;
				var40.field_674 = start_s;
				var40.field_675 = var39;
			}

			if (this.min_y < this.base_y - this.clip_y) {
				this.min_y = this.base_y - this.clip_y;
			}
		} else if (vert_cnt == 4) {
			var11 = vert_y[0] + this.base_y;
			var12 = vert_y[1] + this.base_y;
			var13 = vert_y[2] + this.base_y;
			var14 = vert_y[3] + this.base_y;
			var15 = vert_x[0];
			var16 = vert_x[1];
			var17 = vert_x[2];
			var18 = vert_x[3];
			var19 = vert_shade[0];
			var20 = vert_shade[1];
			var21 = vert_shade[2];
			var22 = vert_shade[3];
			var23 = this.base_y + this.clip_y - 1;
			var24 = 0;
			var25 = 0;
			var26 = 0;
			var27 = 0;
			var28 = 12345678;
			var29 = -12345678;
			if (var14 != var11) {
				var25 = (var18 - var15 << 8) / (var14 - var11);
				var27 = (var22 - var19 << 8) / (var14 - var11);
				if (var11 < var14) {
					var24 = var15 << 8;
					var26 = var19 << 8;
					var28 = var11;
					var29 = var14;
				} else {
					var24 = var18 << 8;
					var26 = var22 << 8;
					var28 = var14;
					var29 = var11;
				}

				if (var28 < 0) {
					var24 -= var25 * var28;
					var26 -= var27 * var28;
					var28 = 0;
				}

				if (var29 > var23) {
					var29 = var23;
				}
			}

			var30 = 0;
			var31 = 0;
			var32 = 0;
			var33 = 0;
			var34 = 12345678;
			var35 = -12345678;
			if (var12 != var11) {
				var31 = (var16 - var15 << 8) / (var12 - var11);
				var33 = (var20 - var19 << 8) / (var12 - var11);
				if (var11 < var12) {
					var30 = var15 << 8;
					var32 = var19 << 8;
					var34 = var11;
					var35 = var12;
				} else {
					var30 = var16 << 8;
					var32 = var20 << 8;
					var34 = var12;
					var35 = var11;
				}

				if (var34 < 0) {
					var30 -= var31 * var34;
					var32 -= var33 * var34;
					var34 = 0;
				}

				if (var35 > var23) {
					var35 = var23;
				}
			}

			var36 = 0;
			var37 = 0;
			var38 = 0;
			var39 = 0;
			int var53 = 12345678;
			int var41 = -12345678;
			if (var13 != var12) {
				var37 = (var17 - var16 << 8) / (var13 - var12);
				var39 = (var21 - var20 << 8) / (var13 - var12);
				if (var12 < var13) {
					var36 = var16 << 8;
					var38 = var20 << 8;
					var53 = var12;
					var41 = var13;
				} else {
					var36 = var17 << 8;
					var38 = var21 << 8;
					var53 = var13;
					var41 = var12;
				}

				if (var53 < 0) {
					var36 -= var37 * var53;
					var38 -= var39 * var53;
					var53 = 0;
				}

				if (var41 > var23) {
					var41 = var23;
				}
			}

			int var42 = 0;
			int var43 = 0;
			int var44 = 0;
			int var45 = 0;
			int var46 = 12345678;
			int var47 = -12345678;
			if (var14 != var13) {
				var43 = (var18 - var17 << 8) / (var14 - var13);
				var45 = (var22 - var21 << 8) / (var14 - var13);
				if (var13 < var14) {
					var42 = var17 << 8;
					var44 = var21 << 8;
					var46 = var13;
					var47 = var14;
				} else {
					var42 = var18 << 8;
					var44 = var22 << 8;
					var46 = var14;
					var47 = var13;
				}

				if (var46 < 0) {
					var42 -= var43 * var46;
					var44 -= var45 * var46;
					var46 = 0;
				}

				if (var47 > var23) {
					var47 = var23;
				}
			}

			this.min_y = var28;
			if (var34 < this.min_y) {
				this.min_y = var34;
			}

			if (var53 < this.min_y) {
				this.min_y = var53;
			}

			if (var46 < this.min_y) {
				this.min_y = var46;
			}

			this.max_y = var29;
			if (var35 > this.max_y) {
				this.max_y = var35;
			}

			if (var41 > this.max_y) {
				this.max_y = var41;
			}

			if (var47 > this.max_y) {
				this.max_y = var47;
			}

			int var48 = 0;

			for (a_ptr = this.min_y; a_ptr < this.max_y; ++a_ptr) {
				if (a_ptr >= var28 && a_ptr < var29) {
					x = var24;
					start_x = var24;
					var48 = var26;
					start_s = var26;
					var24 += var25;
					var26 += var27;
				} else {
					start_x = 655360;
					x = -655360;
				}

				if (a_ptr >= var34 && a_ptr < var35) {
					if (var30 < start_x) {
						start_x = var30;
						start_s = var32;
					}

					if (var30 > x) {
						x = var30;
						var48 = var32;
					}

					var30 += var31;
					var32 += var33;
				}

				if (a_ptr >= var53 && a_ptr < var41) {
					if (var36 < start_x) {
						start_x = var36;
						start_s = var38;
					}

					if (var36 > x) {
						x = var36;
						var48 = var38;
					}

					var36 += var37;
					var38 += var39;
				}

				if (a_ptr >= var46 && a_ptr < var47) {
					if (var42 < start_x) {
						start_x = var42;
						start_s = var44;
					}

					if (var42 > x) {
						x = var42;
						var48 = var44;
					}

					var42 += var43;
					var44 += var45;
				}

				Scanline var49 = this.scanlines[a_ptr];
				var49.field_672 = start_x;
				var49.field_673 = x;
				var49.field_674 = start_s;
				var49.field_675 = var48;
			}

			if (this.min_y < this.base_y - this.clip_y) {
				this.min_y = this.base_y - this.clip_y;
			}
		} else {
			this.max_y = this.min_y = vert_y[0] += this.base_y;

			for (a_ptr = 1; a_ptr < vert_cnt; ++a_ptr) {
				if ((var11 = vert_y[a_ptr] += this.base_y) < this.min_y) {
					this.min_y = var11;
				} else if (var11 > this.max_y) {
					this.max_y = var11;
				}
			}

			if (this.min_y < this.base_y - this.clip_y) {
				this.min_y = this.base_y - this.clip_y;
			}

			if (this.max_y >= this.base_y + this.clip_y) {
				this.max_y = this.base_y + this.clip_y - 1;
			}

			if (this.min_y >= this.max_y) {
				return;
			}

			for (a_ptr = this.min_y; a_ptr < this.max_y; ++a_ptr) {
				var50 = this.scanlines[a_ptr];
				var50.field_672 = 655360;
				var50.field_673 = -655360;
			}

			var11 = vert_cnt - 1;
			var12 = vert_y[0];
			var13 = vert_y[var11];
			Scanline var51;
			if (var12 < var13) {
				var14 = vert_x[0] << 8;
				var15 = (vert_x[var11] - vert_x[0] << 8) / (var13 - var12);
				var16 = vert_shade[0] << 8;
				var17 = (vert_shade[var11] - vert_shade[0] << 8) / (var13 - var12);
				if (var12 < 0) {
					var14 -= var15 * var12;
					var16 -= var17 * var12;
					var12 = 0;
				}

				if (var13 > this.max_y) {
					var13 = this.max_y;
				}

				for (a_ptr = var12; a_ptr <= var13; ++a_ptr) {
					var51 = this.scanlines[a_ptr];
					var51.field_672 = var51.field_673 = var14;
					var51.field_674 = var51.field_675 = var16;
					var14 += var15;
					var16 += var17;
				}
			} else if (var12 > var13) {
				var14 = vert_x[var11] << 8;
				var15 = (vert_x[0] - vert_x[var11] << 8) / (var12 - var13);
				var16 = vert_shade[var11] << 8;
				var17 = (vert_shade[0] - vert_shade[var11] << 8) / (var12 - var13);
				if (var13 < 0) {
					var14 -= var15 * var13;
					var16 -= var17 * var13;
					var13 = 0;
				}

				if (var12 > this.max_y) {
					var12 = this.max_y;
				}

				for (a_ptr = var13; a_ptr <= var12; ++a_ptr) {
					var51 = this.scanlines[a_ptr];
					var51.field_672 = var51.field_673 = var14;
					var51.field_674 = var51.field_675 = var16;
					var14 += var15;
					var16 += var17;
				}
			}

			for (a_ptr = 0; a_ptr < var11; ++a_ptr) {
				var14 = a_ptr + 1;
				var12 = vert_y[a_ptr];
				var13 = vert_y[var14];
				Scanline var52;
				if (var12 < var13) {
					var15 = vert_x[a_ptr] << 8;
					var16 = (vert_x[var14] - vert_x[a_ptr] << 8) / (var13 - var12);
					var17 = vert_shade[a_ptr] << 8;
					var18 = (vert_shade[var14] - vert_shade[a_ptr] << 8) / (var13 - var12);
					if (var12 < 0) {
						var15 -= var16 * var12;
						var17 -= var18 * var12;
						var12 = 0;
					}

					if (var13 > this.max_y) {
						var13 = this.max_y;
					}

					for (var19 = var12; var19 <= var13; ++var19) {
						var52 = this.scanlines[var19];
						if (var15 < var52.field_672) {
							var52.field_672 = var15;
							var52.field_674 = var17;
						}

						if (var15 > var52.field_673) {
							var52.field_673 = var15;
							var52.field_675 = var17;
						}

						var15 += var16;
						var17 += var18;
					}
				} else if (var12 > var13) {
					var15 = vert_x[var14] << 8;
					var16 = (vert_x[a_ptr] - vert_x[var14] << 8) / (var12 - var13);
					var17 = vert_shade[var14] << 8;
					var18 = (vert_shade[a_ptr] - vert_shade[var14] << 8) / (var12 - var13);
					if (var13 < 0) {
						var15 -= var16 * var13;
						var17 -= var18 * var13;
						var13 = 0;
					}

					if (var12 > this.max_y) {
						var12 = this.max_y;
					}

					for (var19 = var13; var19 <= var12; ++var19) {
						var52 = this.scanlines[var19];
						if (var15 < var52.field_672) {
							var52.field_672 = var15;
							var52.field_674 = var17;
						}

						if (var15 > var52.field_673) {
							var52.field_673 = var15;
							var52.field_675 = var17;
						}

						var15 += var16;
						var17 += var18;
					}
				}
			}

			if (this.min_y < this.base_y - this.clip_y) {
				this.min_y = this.base_y - this.clip_y;
			}
		}

		if (this.picking_active && this.picked_cnt < this.max_picked && this.click_y >= this.min_y
				&& this.click_y < this.max_y) {
			var50 = this.scanlines[this.click_y];
			if (this.click_x >= var50.field_672 >> 8 && this.click_x <= var50.field_673 >> 8
					&& var50.field_672 <= var50.field_673 && !model.unpickable && model.is_local_player[face] == 0) {
				this.picked_models[this.picked_cnt] = model;
				this.picked_faces[this.picked_cnt] = face;
				++this.picked_cnt;
			}
		}

	}

	// jagex.client.q) void
	private void rasterize(int var1, int var2, int var3, int[] var4, int[] var5, int[] var6, int var7, Model var8) {
		int var9;
		int var10;
		int var11;
		int var12;
		int var13;
		int var14;
		int var15;
		int var16;
		int var17;
		int var18;
		if (var7 >= 0) {
			if (var7 >= this.texture_cnt) {
				var7 = 0;
			}

			this.texture_prepare(var7);
			var9 = var4[0];
			var10 = var5[0];
			var11 = var6[0];
			var12 = var9 - var4[1];
			var13 = var10 - var5[1];
			var14 = var11 - var6[1];
			--var3;
			var15 = var4[var3] - var9;
			var16 = var5[var3] - var10;
			var17 = var6[var3] - var11;
			int var19;
			int var20;
			int var21;
			int var22;
			int var23;
			int var24;
			int var25;
			int var26;
			int var27;
			int var28;
			int var29;
			int var30;
			int var31;
			int var32;
			byte var33;
			Scanline var34;
			int var35;
			int var36;
			int var37;
			int var38;
			if (this.texture_dim[var7] == 1) {
				var18 = var15 * var10 - var16 * var9 << 12;
				var19 = var16 * var11 - var17 * var10 << 5 - this.view_dist + 7 + 4;
				var20 = var17 * var9 - var15 * var11 << 5 - this.view_dist + 7;
				var21 = var12 * var10 - var13 * var9 << 12;
				var22 = var13 * var11 - var14 * var10 << 5 - this.view_dist + 7 + 4;
				var23 = var14 * var9 - var12 * var11 << 5 - this.view_dist + 7;
				var24 = var13 * var15 - var12 * var16 << 5;
				var25 = var14 * var16 - var13 * var17 << 5 - this.view_dist + 4;
				var26 = var12 * var17 - var14 * var15 >> this.view_dist - 5;
				var27 = var19 >> 4;
				var28 = var22 >> 4;
				var29 = var25 >> 4;
				var30 = this.min_y - this.base_y;
				var31 = this.width;
				var32 = this.base_x + this.min_y * var31;
				var33 = 1;
				var18 += var20 * var30;
				var21 += var23 * var30;
				var24 += var26 * var30;
				if (this.reduce_lag) {
					if ((this.min_y & 1) == 1) {
						++this.min_y;
						var18 += var20;
						var21 += var23;
						var24 += var26;
						var32 += var31;
					}

					var20 <<= 1;
					var23 <<= 1;
					var26 <<= 1;
					var31 <<= 1;
					var33 = 2;
				}

				if (var8.trans_texture) {
					for (var1 = this.min_y; var1 < this.max_y; var1 += var33) {
						var34 = this.scanlines[var1];
						var2 = var34.field_672 >> 8;
						var35 = var34.field_673 >> 8;
						var36 = var35 - var2;
						if (var36 <= 0) {
							var18 += var20;
							var21 += var23;
							var24 += var26;
							var32 += var31;
						} else {
							var37 = var34.field_674;
							var38 = (var34.field_675 - var37) / var36;
							if (var2 < -this.clip_x) {
								var37 += (-this.clip_x - var2) * var38;
								var2 = -this.clip_x;
								var36 = var35 - var2;
							}

							if (var35 > this.clip_x) {
								var35 = this.clip_x;
								var36 = var35 - var2;
							}

							method_384(this.raster, this.texture_pixels[var7], 0, 0, var18 + var27 * var2,
									var21 + var28 * var2, var24 + var29 * var2, var19, var22, var25, var36,
									var32 + var2, var37, var38 << 2);
							var18 += var20;
							var21 += var23;
							var24 += var26;
							var32 += var31;
						}
					}

				} else if (!this.texture_trans_back[var7]) {
					for (var1 = this.min_y; var1 < this.max_y; var1 += var33) {
						var34 = this.scanlines[var1];
						var2 = var34.field_672 >> 8;
						var35 = var34.field_673 >> 8;
						var36 = var35 - var2;
						if (var36 <= 0) {
							var18 += var20;
							var21 += var23;
							var24 += var26;
							var32 += var31;
						} else {
							var37 = var34.field_674;
							var38 = (var34.field_675 - var37) / var36;
							if (var2 < -this.clip_x) {
								var37 += (-this.clip_x - var2) * var38;
								var2 = -this.clip_x;
								var36 = var35 - var2;
							}

							if (var35 > this.clip_x) {
								var35 = this.clip_x;
								var36 = var35 - var2;
							}

							method_383(this.raster, this.texture_pixels[var7], 0, 0, var18 + var27 * var2,
									var21 + var28 * var2, var24 + var29 * var2, var19, var22, var25, var36,
									var32 + var2, var37, var38 << 2);
							var18 += var20;
							var21 += var23;
							var24 += var26;
							var32 += var31;
						}
					}

				} else {
					for (var1 = this.min_y; var1 < this.max_y; var1 += var33) {
						var34 = this.scanlines[var1];
						var2 = var34.field_672 >> 8;
						var35 = var34.field_673 >> 8;
						var36 = var35 - var2;
						if (var36 <= 0) {
							var18 += var20;
							var21 += var23;
							var24 += var26;
							var32 += var31;
						} else {
							var37 = var34.field_674;
							var38 = (var34.field_675 - var37) / var36;
							if (var2 < -this.clip_x) {
								var37 += (-this.clip_x - var2) * var38;
								var2 = -this.clip_x;
								var36 = var35 - var2;
							}

							if (var35 > this.clip_x) {
								var35 = this.clip_x;
								var36 = var35 - var2;
							}

							method_385(this.raster, 0, 0, 0, this.texture_pixels[var7], var18 + var27 * var2,
									var21 + var28 * var2, var24 + var29 * var2, var19, var22, var25, var36,
									var32 + var2, var37, var38);
							var18 += var20;
							var21 += var23;
							var24 += var26;
							var32 += var31;
						}
					}

				}
			} else {
				var18 = var15 * var10 - var16 * var9 << 11;
				var19 = var16 * var11 - var17 * var10 << 5 - this.view_dist + 6 + 4;
				var20 = var17 * var9 - var15 * var11 << 5 - this.view_dist + 6;
				var21 = var12 * var10 - var13 * var9 << 11;
				var22 = var13 * var11 - var14 * var10 << 5 - this.view_dist + 6 + 4;
				var23 = var14 * var9 - var12 * var11 << 5 - this.view_dist + 6;
				var24 = var13 * var15 - var12 * var16 << 5;
				var25 = var14 * var16 - var13 * var17 << 5 - this.view_dist + 4;
				var26 = var12 * var17 - var14 * var15 >> this.view_dist - 5;
				var27 = var19 >> 4;
				var28 = var22 >> 4;
				var29 = var25 >> 4;
				var30 = this.min_y - this.base_y;
				var31 = this.width;
				var32 = this.base_x + this.min_y * var31;
				var33 = 1;
				var18 += var20 * var30;
				var21 += var23 * var30;
				var24 += var26 * var30;
				if (this.reduce_lag) {
					if ((this.min_y & 1) == 1) {
						++this.min_y;
						var18 += var20;
						var21 += var23;
						var24 += var26;
						var32 += var31;
					}

					var20 <<= 1;
					var23 <<= 1;
					var26 <<= 1;
					var31 <<= 1;
					var33 = 2;
				}

				if (var8.trans_texture) {
					for (var1 = this.min_y; var1 < this.max_y; var1 += var33) {
						var34 = this.scanlines[var1];
						var2 = var34.field_672 >> 8;
						var35 = var34.field_673 >> 8;
						var36 = var35 - var2;
						if (var36 <= 0) {
							var18 += var20;
							var21 += var23;
							var24 += var26;
							var32 += var31;
						} else {
							var37 = var34.field_674;
							var38 = (var34.field_675 - var37) / var36;
							if (var2 < -this.clip_x) {
								var37 += (-this.clip_x - var2) * var38;
								var2 = -this.clip_x;
								var36 = var35 - var2;
							}

							if (var35 > this.clip_x) {
								var35 = this.clip_x;
								var36 = var35 - var2;
							}

							method_387(this.raster, this.texture_pixels[var7], 0, 0, var18 + var27 * var2,
									var21 + var28 * var2, var24 + var29 * var2, var19, var22, var25, var36,
									var32 + var2, var37, var38);
							var18 += var20;
							var21 += var23;
							var24 += var26;
							var32 += var31;
						}
					}

				} else if (!this.texture_trans_back[var7]) {
					for (var1 = this.min_y; var1 < this.max_y; var1 += var33) {
						var34 = this.scanlines[var1];
						var2 = var34.field_672 >> 8;
						var35 = var34.field_673 >> 8;
						var36 = var35 - var2;
						if (var36 <= 0) {
							var18 += var20;
							var21 += var23;
							var24 += var26;
							var32 += var31;
						} else {
							var37 = var34.field_674;
							var38 = (var34.field_675 - var37) / var36;
							if (var2 < -this.clip_x) {
								var37 += (-this.clip_x - var2) * var38;
								var2 = -this.clip_x;
								var36 = var35 - var2;
							}

							if (var35 > this.clip_x) {
								var35 = this.clip_x;
								var36 = var35 - var2;
							}

							method_386(this.raster, this.texture_pixels[var7], 0, 0, var18 + var27 * var2,
									var21 + var28 * var2, var24 + var29 * var2, var19, var22, var25, var36,
									var32 + var2, var37, var38);
							var18 += var20;
							var21 += var23;
							var24 += var26;
							var32 += var31;
						}
					}

				} else {
					for (var1 = this.min_y; var1 < this.max_y; var1 += var33) {
						var34 = this.scanlines[var1];
						var2 = var34.field_672 >> 8;
						var35 = var34.field_673 >> 8;
						var36 = var35 - var2;
						if (var36 <= 0) {
							var18 += var20;
							var21 += var23;
							var24 += var26;
							var32 += var31;
						} else {
							var37 = var34.field_674;
							var38 = (var34.field_675 - var37) / var36;
							if (var2 < -this.clip_x) {
								var37 += (-this.clip_x - var2) * var38;
								var2 = -this.clip_x;
								var36 = var35 - var2;
							}

							if (var35 > this.clip_x) {
								var35 = this.clip_x;
								var36 = var35 - var2;
							}

							method_388(this.raster, 0, 0, 0, this.texture_pixels[var7], var18 + var27 * var2,
									var21 + var28 * var2, var24 + var29 * var2, var19, var22, var25, var36,
									var32 + var2, var37, var38);
							var18 += var20;
							var21 += var23;
							var24 += var26;
							var32 += var31;
						}
					}

				}
			}
		} else {
			for (var9 = 0; var9 < this.ramp_cnt; ++var9) {
				if (this.grad_base[var9] == var7) {
					this.field_585 = this.grad_ramps[var9];
					break;
				}

				if (var9 == this.ramp_cnt - 1) {
					var10 = (int) (Math.random() * (double) this.ramp_cnt);
					this.grad_base[var10] = var7;
					var7 = -1 - var7;
					var11 = (var7 >> 10 & 31) * 8;
					var12 = (var7 >> 5 & 31) * 8;
					var13 = (var7 & 31) * 8;

					for (var14 = 0; var14 < 256; ++var14) {
						var15 = var14 * var14;
						var16 = var11 * var15 / 65536;
						var17 = var12 * var15 / 65536;
						var18 = var13 * var15 / 65536;
						this.grad_ramps[var10][255 - var14] = (var16 << 16) + (var17 << 8) + var18;
					}

					this.field_585 = this.grad_ramps[var10];
				}
			}

			var10 = this.width;
			var11 = this.base_x + this.min_y * var10;
			byte var39 = 1;
			if (this.reduce_lag) {
				if ((this.min_y & 1) == 1) {
					++this.min_y;
					var11 += var10;
				}

				var10 <<= 1;
				var39 = 2;
			}

			Scanline var40;
			if (var8.trans) {
				for (var1 = this.min_y; var1 < this.max_y; var1 += var39) {
					var40 = this.scanlines[var1];
					var2 = var40.field_672 >> 8;
					var14 = var40.field_673 >> 8;
					var15 = var14 - var2;
					if (var15 <= 0) {
						var11 += var10;
					} else {
						var16 = var40.field_674;
						var17 = (var40.field_675 - var16) / var15;
						if (var2 < -this.clip_x) {
							var16 += (-this.clip_x - var2) * var17;
							var2 = -this.clip_x;
							var15 = var14 - var2;
						}

						if (var14 > this.clip_x) {
							var14 = this.clip_x;
							var15 = var14 - var2;
						}

						method_390(this.raster, -var15, var11 + var2, 0, this.field_585, var16, var17);
						var11 += var10;
					}
				}

			} else if (this.wide_band) {
				for (var1 = this.min_y; var1 < this.max_y; var1 += var39) {
					var40 = this.scanlines[var1];
					var2 = var40.field_672 >> 8;
					var14 = var40.field_673 >> 8;
					var15 = var14 - var2;
					if (var15 <= 0) {
						var11 += var10;
					} else {
						var16 = var40.field_674;
						var17 = (var40.field_675 - var16) / var15;
						if (var2 < -this.clip_x) {
							var16 += (-this.clip_x - var2) * var17;
							var2 = -this.clip_x;
							var15 = var14 - var2;
						}

						if (var14 > this.clip_x) {
							var14 = this.clip_x;
							var15 = var14 - var2;
						}

						method_389(this.raster, -var15, var11 + var2, 0, this.field_585, var16, var17);
						var11 += var10;
					}
				}

			} else {
				for (var1 = this.min_y; var1 < this.max_y; var1 += var39) {
					var40 = this.scanlines[var1];
					var2 = var40.field_672 >> 8;
					var14 = var40.field_673 >> 8;
					var15 = var14 - var2;
					if (var15 <= 0) {
						var11 += var10;
					} else {
						var16 = var40.field_674;
						var17 = (var40.field_675 - var16) / var15;
						if (var2 < -this.clip_x) {
							var16 += (-this.clip_x - var2) * var17;
							var2 = -this.clip_x;
							var15 = var14 - var2;
						}

						if (var14 > this.clip_x) {
							var14 = this.clip_x;
							var15 = var14 - var2;
						}

						grad1_scanline(this.raster, -var15, var11 + var2, 0, this.field_585, var16, var17);
						var11 += var10;
					}
				}

			}
		}
	}

	// int, int, int, int) void
	private static void method_383(int[] var0, int[] var1, int var2, int var3, int var4, int var5, int var6, int var7,
			int var8, int var9, int var10, int var11, int var12, int var13) {
		if (var10 > 0) {
			int var14 = 0;
			int var15 = 0;
			int var18 = 0;
			if (var6 != 0) {
				var2 = var4 / var6 << 7;
				var3 = var5 / var6 << 7;
			}

			if (var2 < 0) {
				var2 = 0;
			} else if (var2 > 16256) {
				var2 = 16256;
			}

			var4 += var7;
			var5 += var8;
			var6 += var9;
			if (var6 != 0) {
				var14 = var4 / var6 << 7;
				var15 = var5 / var6 << 7;
			}

			if (var14 < 0) {
				var14 = 0;
			} else if (var14 > 16256) {
				var14 = 16256;
			}

			int var16 = var14 - var2 >> 4;
			int var17 = var15 - var3 >> 4;

			for (int var19 = var10 >> 4; var19 > 0; --var19) {
				var2 += var12 & 6291456;
				var18 = var12 >> 23;
				var12 += var13;
				var0[var11++] = var1[(var3 & 16256) + (var2 >> 7)] >>> var18;
				var2 += var16;
				var3 += var17;
				var0[var11++] = var1[(var3 & 16256) + (var2 >> 7)] >>> var18;
				var2 += var16;
				var3 += var17;
				var0[var11++] = var1[(var3 & 16256) + (var2 >> 7)] >>> var18;
				var2 += var16;
				var3 += var17;
				var0[var11++] = var1[(var3 & 16256) + (var2 >> 7)] >>> var18;
				var2 += var16;
				var3 += var17;
				var2 = (var2 & 16383) + (var12 & 6291456);
				var18 = var12 >> 23;
				var12 += var13;
				var0[var11++] = var1[(var3 & 16256) + (var2 >> 7)] >>> var18;
				var2 += var16;
				var3 += var17;
				var0[var11++] = var1[(var3 & 16256) + (var2 >> 7)] >>> var18;
				var2 += var16;
				var3 += var17;
				var0[var11++] = var1[(var3 & 16256) + (var2 >> 7)] >>> var18;
				var2 += var16;
				var3 += var17;
				var0[var11++] = var1[(var3 & 16256) + (var2 >> 7)] >>> var18;
				var2 += var16;
				var3 += var17;
				var2 = (var2 & 16383) + (var12 & 6291456);
				var18 = var12 >> 23;
				var12 += var13;
				var0[var11++] = var1[(var3 & 16256) + (var2 >> 7)] >>> var18;
				var2 += var16;
				var3 += var17;
				var0[var11++] = var1[(var3 & 16256) + (var2 >> 7)] >>> var18;
				var2 += var16;
				var3 += var17;
				var0[var11++] = var1[(var3 & 16256) + (var2 >> 7)] >>> var18;
				var2 += var16;
				var3 += var17;
				var0[var11++] = var1[(var3 & 16256) + (var2 >> 7)] >>> var18;
				var2 += var16;
				var3 += var17;
				var2 = (var2 & 16383) + (var12 & 6291456);
				var18 = var12 >> 23;
				var12 += var13;
				var0[var11++] = var1[(var3 & 16256) + (var2 >> 7)] >>> var18;
				var2 += var16;
				var3 += var17;
				var0[var11++] = var1[(var3 & 16256) + (var2 >> 7)] >>> var18;
				var2 += var16;
				var3 += var17;
				var0[var11++] = var1[(var3 & 16256) + (var2 >> 7)] >>> var18;
				var2 += var16;
				var3 += var17;
				var0[var11++] = var1[(var3 & 16256) + (var2 >> 7)] >>> var18;
				var2 = var14;
				var3 = var15;
				var4 += var7;
				var5 += var8;
				var6 += var9;
				if (var6 != 0) {
					var14 = var4 / var6 << 7;
					var15 = var5 / var6 << 7;
				}

				if (var14 < 0) {
					var14 = 0;
				} else if (var14 > 16256) {
					var14 = 16256;
				}

				var16 = var14 - var2 >> 4;
				var17 = var15 - var3 >> 4;
			}

			for (int var20 = 0; var20 < (var10 & 15); ++var20) {
				if ((var20 & 3) == 0) {
					var2 = (var2 & 16383) + (var12 & 6291456);
					var18 = var12 >> 23;
					var12 += var13;
				}

				var0[var11++] = var1[(var3 & 16256) + (var2 >> 7)] >>> var18;
				var2 += var16;
				var3 += var17;
			}

		}
	}

	// int, int, int, int) void
	private static void method_384(int[] var0, int[] var1, int var2, int var3, int var4, int var5, int var6, int var7,
			int var8, int var9, int var10, int var11, int var12, int var13) {
		if (var10 > 0) {
			int var14 = 0;
			int var15 = 0;
			int var18 = 0;
			if (var6 != 0) {
				var2 = var4 / var6 << 7;
				var3 = var5 / var6 << 7;
			}

			if (var2 < 0) {
				var2 = 0;
			} else if (var2 > 16256) {
				var2 = 16256;
			}

			var4 += var7;
			var5 += var8;
			var6 += var9;
			if (var6 != 0) {
				var14 = var4 / var6 << 7;
				var15 = var5 / var6 << 7;
			}

			if (var14 < 0) {
				var14 = 0;
			} else if (var14 > 16256) {
				var14 = 16256;
			}

			int var16 = var14 - var2 >> 4;
			int var17 = var15 - var3 >> 4;

			for (int var19 = var10 >> 4; var19 > 0; --var19) {
				var2 += var12 & 6291456;
				var18 = var12 >> 23;
				var12 += var13;
				var0[var11++] = (var1[(var3 & 16256) + (var2 >> 7)] >>> var18) + (var0[var11] >> 1 & 8355711);
				var2 += var16;
				var3 += var17;
				var0[var11++] = (var1[(var3 & 16256) + (var2 >> 7)] >>> var18) + (var0[var11] >> 1 & 8355711);
				var2 += var16;
				var3 += var17;
				var0[var11++] = (var1[(var3 & 16256) + (var2 >> 7)] >>> var18) + (var0[var11] >> 1 & 8355711);
				var2 += var16;
				var3 += var17;
				var0[var11++] = (var1[(var3 & 16256) + (var2 >> 7)] >>> var18) + (var0[var11] >> 1 & 8355711);
				var2 += var16;
				var3 += var17;
				var2 = (var2 & 16383) + (var12 & 6291456);
				var18 = var12 >> 23;
				var12 += var13;
				var0[var11++] = (var1[(var3 & 16256) + (var2 >> 7)] >>> var18) + (var0[var11] >> 1 & 8355711);
				var2 += var16;
				var3 += var17;
				var0[var11++] = (var1[(var3 & 16256) + (var2 >> 7)] >>> var18) + (var0[var11] >> 1 & 8355711);
				var2 += var16;
				var3 += var17;
				var0[var11++] = (var1[(var3 & 16256) + (var2 >> 7)] >>> var18) + (var0[var11] >> 1 & 8355711);
				var2 += var16;
				var3 += var17;
				var0[var11++] = (var1[(var3 & 16256) + (var2 >> 7)] >>> var18) + (var0[var11] >> 1 & 8355711);
				var2 += var16;
				var3 += var17;
				var2 = (var2 & 16383) + (var12 & 6291456);
				var18 = var12 >> 23;
				var12 += var13;
				var0[var11++] = (var1[(var3 & 16256) + (var2 >> 7)] >>> var18) + (var0[var11] >> 1 & 8355711);
				var2 += var16;
				var3 += var17;
				var0[var11++] = (var1[(var3 & 16256) + (var2 >> 7)] >>> var18) + (var0[var11] >> 1 & 8355711);
				var2 += var16;
				var3 += var17;
				var0[var11++] = (var1[(var3 & 16256) + (var2 >> 7)] >>> var18) + (var0[var11] >> 1 & 8355711);
				var2 += var16;
				var3 += var17;
				var0[var11++] = (var1[(var3 & 16256) + (var2 >> 7)] >>> var18) + (var0[var11] >> 1 & 8355711);
				var2 += var16;
				var3 += var17;
				var2 = (var2 & 16383) + (var12 & 6291456);
				var18 = var12 >> 23;
				var12 += var13;
				var0[var11++] = (var1[(var3 & 16256) + (var2 >> 7)] >>> var18) + (var0[var11] >> 1 & 8355711);
				var2 += var16;
				var3 += var17;
				var0[var11++] = (var1[(var3 & 16256) + (var2 >> 7)] >>> var18) + (var0[var11] >> 1 & 8355711);
				var2 += var16;
				var3 += var17;
				var0[var11++] = (var1[(var3 & 16256) + (var2 >> 7)] >>> var18) + (var0[var11] >> 1 & 8355711);
				var2 += var16;
				var3 += var17;
				var0[var11++] = (var1[(var3 & 16256) + (var2 >> 7)] >>> var18) + (var0[var11] >> 1 & 8355711);
				var2 = var14;
				var3 = var15;
				var4 += var7;
				var5 += var8;
				var6 += var9;
				if (var6 != 0) {
					var14 = var4 / var6 << 7;
					var15 = var5 / var6 << 7;
				}

				if (var14 < 0) {
					var14 = 0;
				} else if (var14 > 16256) {
					var14 = 16256;
				}

				var16 = var14 - var2 >> 4;
				var17 = var15 - var3 >> 4;
			}

			for (int var20 = 0; var20 < (var10 & 15); ++var20) {
				if ((var20 & 3) == 0) {
					var2 = (var2 & 16383) + (var12 & 6291456);
					var18 = var12 >> 23;
					var12 += var13;
				}

				var0[var11++] = (var1[(var3 & 16256) + (var2 >> 7)] >>> var18) + (var0[var11] >> 1 & 8355711);
				var2 += var16;
				var3 += var17;
			}

		}
	}

	// int, int, int, int, int) void
	private static void method_385(int[] var0, int var1, int var2, int var3, int[] var4, int var5, int var6, int var7,
			int var8, int var9, int var10, int var11, int var12, int var13, int var14) {
		if (var11 > 0) {
			int var15 = 0;
			int var16 = 0;
			var14 <<= 2;
			if (var7 != 0) {
				var15 = var5 / var7 << 7;
				var16 = var6 / var7 << 7;
			}

			if (var15 < 0) {
				var15 = 0;
			} else if (var15 > 16256) {
				var15 = 16256;
			}

			for (int var19 = var11; var19 > 0; var19 -= 16) {
				var5 += var8;
				var6 += var9;
				var7 += var10;
				var2 = var15;
				var3 = var16;
				if (var7 != 0) {
					var15 = var5 / var7 << 7;
					var16 = var6 / var7 << 7;
				}

				if (var15 < 0) {
					var15 = 0;
				} else if (var15 > 16256) {
					var15 = 16256;
				}

				int var17 = var15 - var2 >> 4;
				int var18 = var16 - var3 >> 4;
				int var20 = var13 >> 23;
				var2 += var13 & 6291456;
				var13 += var14;
				if (var19 < 16) {
					for (int var21 = 0; var21 < var19; ++var21) {
						if ((var1 = var4[(var3 & 16256) + (var2 >> 7)] >>> var20) != 0) {
							var0[var12] = var1;
						}

						++var12;
						var2 += var17;
						var3 += var18;
						if ((var21 & 3) == 3) {
							var2 = (var2 & 16383) + (var13 & 6291456);
							var20 = var13 >> 23;
							var13 += var14;
						}
					}
				} else {
					if ((var1 = var4[(var3 & 16256) + (var2 >> 7)] >>> var20) != 0) {
						var0[var12] = var1;
					}

					++var12;
					var2 += var17;
					var3 += var18;
					if ((var1 = var4[(var3 & 16256) + (var2 >> 7)] >>> var20) != 0) {
						var0[var12] = var1;
					}

					++var12;
					var2 += var17;
					var3 += var18;
					if ((var1 = var4[(var3 & 16256) + (var2 >> 7)] >>> var20) != 0) {
						var0[var12] = var1;
					}

					++var12;
					var2 += var17;
					var3 += var18;
					if ((var1 = var4[(var3 & 16256) + (var2 >> 7)] >>> var20) != 0) {
						var0[var12] = var1;
					}

					++var12;
					var2 += var17;
					var3 += var18;
					var2 = (var2 & 16383) + (var13 & 6291456);
					var20 = var13 >> 23;
					var13 += var14;
					if ((var1 = var4[(var3 & 16256) + (var2 >> 7)] >>> var20) != 0) {
						var0[var12] = var1;
					}

					++var12;
					var2 += var17;
					var3 += var18;
					if ((var1 = var4[(var3 & 16256) + (var2 >> 7)] >>> var20) != 0) {
						var0[var12] = var1;
					}

					++var12;
					var2 += var17;
					var3 += var18;
					if ((var1 = var4[(var3 & 16256) + (var2 >> 7)] >>> var20) != 0) {
						var0[var12] = var1;
					}

					++var12;
					var2 += var17;
					var3 += var18;
					if ((var1 = var4[(var3 & 16256) + (var2 >> 7)] >>> var20) != 0) {
						var0[var12] = var1;
					}

					++var12;
					var2 += var17;
					var3 += var18;
					var2 = (var2 & 16383) + (var13 & 6291456);
					var20 = var13 >> 23;
					var13 += var14;
					if ((var1 = var4[(var3 & 16256) + (var2 >> 7)] >>> var20) != 0) {
						var0[var12] = var1;
					}

					++var12;
					var2 += var17;
					var3 += var18;
					if ((var1 = var4[(var3 & 16256) + (var2 >> 7)] >>> var20) != 0) {
						var0[var12] = var1;
					}

					++var12;
					var2 += var17;
					var3 += var18;
					if ((var1 = var4[(var3 & 16256) + (var2 >> 7)] >>> var20) != 0) {
						var0[var12] = var1;
					}

					++var12;
					var2 += var17;
					var3 += var18;
					if ((var1 = var4[(var3 & 16256) + (var2 >> 7)] >>> var20) != 0) {
						var0[var12] = var1;
					}

					++var12;
					var2 += var17;
					var3 += var18;
					var2 = (var2 & 16383) + (var13 & 6291456);
					var20 = var13 >> 23;
					var13 += var14;
					if ((var1 = var4[(var3 & 16256) + (var2 >> 7)] >>> var20) != 0) {
						var0[var12] = var1;
					}

					++var12;
					var2 += var17;
					var3 += var18;
					if ((var1 = var4[(var3 & 16256) + (var2 >> 7)] >>> var20) != 0) {
						var0[var12] = var1;
					}

					++var12;
					var2 += var17;
					var3 += var18;
					if ((var1 = var4[(var3 & 16256) + (var2 >> 7)] >>> var20) != 0) {
						var0[var12] = var1;
					}

					++var12;
					var2 += var17;
					var3 += var18;
					if ((var1 = var4[(var3 & 16256) + (var2 >> 7)] >>> var20) != 0) {
						var0[var12] = var1;
					}

					++var12;
				}
			}

		}
	}

	// int, int, int, int) void
	private static void method_386(int[] var0, int[] var1, int var2, int var3, int var4, int var5, int var6, int var7,
			int var8, int var9, int var10, int var11, int var12, int var13) {
		if (var10 > 0) {
			int var14 = 0;
			int var15 = 0;
			var13 <<= 2;
			if (var6 != 0) {
				var14 = var4 / var6 << 6;
				var15 = var5 / var6 << 6;
			}

			if (var14 < 0) {
				var14 = 0;
			} else if (var14 > 4032) {
				var14 = 4032;
			}

			for (int var18 = var10; var18 > 0; var18 -= 16) {
				var4 += var7;
				var5 += var8;
				var6 += var9;
				var2 = var14;
				var3 = var15;
				if (var6 != 0) {
					var14 = var4 / var6 << 6;
					var15 = var5 / var6 << 6;
				}

				if (var14 < 0) {
					var14 = 0;
				} else if (var14 > 4032) {
					var14 = 4032;
				}

				int var16 = var14 - var2 >> 4;
				int var17 = var15 - var3 >> 4;
				int var19 = var12 >> 20;
				var2 += var12 & 786432;
				var12 += var13;
				if (var18 < 16) {
					for (int var20 = 0; var20 < var18; ++var20) {
						var0[var11++] = var1[(var3 & 4032) + (var2 >> 6)] >>> var19;
						var2 += var16;
						var3 += var17;
						if ((var20 & 3) == 3) {
							var2 = (var2 & 4095) + (var12 & 786432);
							var19 = var12 >> 20;
							var12 += var13;
						}
					}
				} else {
					var0[var11++] = var1[(var3 & 4032) + (var2 >> 6)] >>> var19;
					var2 += var16;
					var3 += var17;
					var0[var11++] = var1[(var3 & 4032) + (var2 >> 6)] >>> var19;
					var2 += var16;
					var3 += var17;
					var0[var11++] = var1[(var3 & 4032) + (var2 >> 6)] >>> var19;
					var2 += var16;
					var3 += var17;
					var0[var11++] = var1[(var3 & 4032) + (var2 >> 6)] >>> var19;
					var2 += var16;
					var3 += var17;
					var2 = (var2 & 4095) + (var12 & 786432);
					var19 = var12 >> 20;
					var12 += var13;
					var0[var11++] = var1[(var3 & 4032) + (var2 >> 6)] >>> var19;
					var2 += var16;
					var3 += var17;
					var0[var11++] = var1[(var3 & 4032) + (var2 >> 6)] >>> var19;
					var2 += var16;
					var3 += var17;
					var0[var11++] = var1[(var3 & 4032) + (var2 >> 6)] >>> var19;
					var2 += var16;
					var3 += var17;
					var0[var11++] = var1[(var3 & 4032) + (var2 >> 6)] >>> var19;
					var2 += var16;
					var3 += var17;
					var2 = (var2 & 4095) + (var12 & 786432);
					var19 = var12 >> 20;
					var12 += var13;
					var0[var11++] = var1[(var3 & 4032) + (var2 >> 6)] >>> var19;
					var2 += var16;
					var3 += var17;
					var0[var11++] = var1[(var3 & 4032) + (var2 >> 6)] >>> var19;
					var2 += var16;
					var3 += var17;
					var0[var11++] = var1[(var3 & 4032) + (var2 >> 6)] >>> var19;
					var2 += var16;
					var3 += var17;
					var0[var11++] = var1[(var3 & 4032) + (var2 >> 6)] >>> var19;
					var2 += var16;
					var3 += var17;
					var2 = (var2 & 4095) + (var12 & 786432);
					var19 = var12 >> 20;
					var12 += var13;
					var0[var11++] = var1[(var3 & 4032) + (var2 >> 6)] >>> var19;
					var2 += var16;
					var3 += var17;
					var0[var11++] = var1[(var3 & 4032) + (var2 >> 6)] >>> var19;
					var2 += var16;
					var3 += var17;
					var0[var11++] = var1[(var3 & 4032) + (var2 >> 6)] >>> var19;
					var2 += var16;
					var3 += var17;
					var0[var11++] = var1[(var3 & 4032) + (var2 >> 6)] >>> var19;
				}
			}

		}
	}

	// int, int, int, int) void
	private static void method_387(int[] var0, int[] var1, int var2, int var3, int var4, int var5, int var6, int var7,
			int var8, int var9, int var10, int var11, int var12, int var13) {
		if (var10 > 0) {
			int var14 = 0;
			int var15 = 0;
			var13 <<= 2;
			if (var6 != 0) {
				var14 = var4 / var6 << 6;
				var15 = var5 / var6 << 6;
			}

			if (var14 < 0) {
				var14 = 0;
			} else if (var14 > 4032) {
				var14 = 4032;
			}

			for (int var18 = var10; var18 > 0; var18 -= 16) {
				var4 += var7;
				var5 += var8;
				var6 += var9;
				var2 = var14;
				var3 = var15;
				if (var6 != 0) {
					var14 = var4 / var6 << 6;
					var15 = var5 / var6 << 6;
				}

				if (var14 < 0) {
					var14 = 0;
				} else if (var14 > 4032) {
					var14 = 4032;
				}

				int var16 = var14 - var2 >> 4;
				int var17 = var15 - var3 >> 4;
				int var19 = var12 >> 20;
				var2 += var12 & 786432;
				var12 += var13;
				if (var18 < 16) {
					for (int var20 = 0; var20 < var18; ++var20) {
						var0[var11++] = (var1[(var3 & 4032) + (var2 >> 6)] >>> var19) + (var0[var11] >> 1 & 8355711);
						var2 += var16;
						var3 += var17;
						if ((var20 & 3) == 3) {
							var2 = (var2 & 4095) + (var12 & 786432);
							var19 = var12 >> 20;
							var12 += var13;
						}
					}
				} else {
					var0[var11++] = (var1[(var3 & 4032) + (var2 >> 6)] >>> var19) + (var0[var11] >> 1 & 8355711);
					var2 += var16;
					var3 += var17;
					var0[var11++] = (var1[(var3 & 4032) + (var2 >> 6)] >>> var19) + (var0[var11] >> 1 & 8355711);
					var2 += var16;
					var3 += var17;
					var0[var11++] = (var1[(var3 & 4032) + (var2 >> 6)] >>> var19) + (var0[var11] >> 1 & 8355711);
					var2 += var16;
					var3 += var17;
					var0[var11++] = (var1[(var3 & 4032) + (var2 >> 6)] >>> var19) + (var0[var11] >> 1 & 8355711);
					var2 += var16;
					var3 += var17;
					var2 = (var2 & 4095) + (var12 & 786432);
					var19 = var12 >> 20;
					var12 += var13;
					var0[var11++] = (var1[(var3 & 4032) + (var2 >> 6)] >>> var19) + (var0[var11] >> 1 & 8355711);
					var2 += var16;
					var3 += var17;
					var0[var11++] = (var1[(var3 & 4032) + (var2 >> 6)] >>> var19) + (var0[var11] >> 1 & 8355711);
					var2 += var16;
					var3 += var17;
					var0[var11++] = (var1[(var3 & 4032) + (var2 >> 6)] >>> var19) + (var0[var11] >> 1 & 8355711);
					var2 += var16;
					var3 += var17;
					var0[var11++] = (var1[(var3 & 4032) + (var2 >> 6)] >>> var19) + (var0[var11] >> 1 & 8355711);
					var2 += var16;
					var3 += var17;
					var2 = (var2 & 4095) + (var12 & 786432);
					var19 = var12 >> 20;
					var12 += var13;
					var0[var11++] = (var1[(var3 & 4032) + (var2 >> 6)] >>> var19) + (var0[var11] >> 1 & 8355711);
					var2 += var16;
					var3 += var17;
					var0[var11++] = (var1[(var3 & 4032) + (var2 >> 6)] >>> var19) + (var0[var11] >> 1 & 8355711);
					var2 += var16;
					var3 += var17;
					var0[var11++] = (var1[(var3 & 4032) + (var2 >> 6)] >>> var19) + (var0[var11] >> 1 & 8355711);
					var2 += var16;
					var3 += var17;
					var0[var11++] = (var1[(var3 & 4032) + (var2 >> 6)] >>> var19) + (var0[var11] >> 1 & 8355711);
					var2 += var16;
					var3 += var17;
					var2 = (var2 & 4095) + (var12 & 786432);
					var19 = var12 >> 20;
					var12 += var13;
					var0[var11++] = (var1[(var3 & 4032) + (var2 >> 6)] >>> var19) + (var0[var11] >> 1 & 8355711);
					var2 += var16;
					var3 += var17;
					var0[var11++] = (var1[(var3 & 4032) + (var2 >> 6)] >>> var19) + (var0[var11] >> 1 & 8355711);
					var2 += var16;
					var3 += var17;
					var0[var11++] = (var1[(var3 & 4032) + (var2 >> 6)] >>> var19) + (var0[var11] >> 1 & 8355711);
					var2 += var16;
					var3 += var17;
					var0[var11++] = (var1[(var3 & 4032) + (var2 >> 6)] >>> var19) + (var0[var11] >> 1 & 8355711);
				}
			}

		}
	}

	// int, int, int, int, int) void
	private static void method_388(int[] var0, int var1, int var2, int var3, int[] var4, int var5, int var6, int var7,
			int var8, int var9, int var10, int var11, int var12, int var13, int var14) {
		if (var11 > 0) {
			int var15 = 0;
			int var16 = 0;
			var14 <<= 2;
			if (var7 != 0) {
				var15 = var5 / var7 << 6;
				var16 = var6 / var7 << 6;
			}

			if (var15 < 0) {
				var15 = 0;
			} else if (var15 > 4032) {
				var15 = 4032;
			}

			for (int var19 = var11; var19 > 0; var19 -= 16) {
				var5 += var8;
				var6 += var9;
				var7 += var10;
				var2 = var15;
				var3 = var16;
				if (var7 != 0) {
					var15 = var5 / var7 << 6;
					var16 = var6 / var7 << 6;
				}

				if (var15 < 0) {
					var15 = 0;
				} else if (var15 > 4032) {
					var15 = 4032;
				}

				int var17 = var15 - var2 >> 4;
				int var18 = var16 - var3 >> 4;
				int var20 = var13 >> 20;
				var2 += var13 & 786432;
				var13 += var14;
				if (var19 < 16) {
					for (int var21 = 0; var21 < var19; ++var21) {
						if ((var1 = var4[(var3 & 4032) + (var2 >> 6)] >>> var20) != 0) {
							var0[var12] = var1;
						}

						++var12;
						var2 += var17;
						var3 += var18;
						if ((var21 & 3) == 3) {
							var2 = (var2 & 4095) + (var13 & 786432);
							var20 = var13 >> 20;
							var13 += var14;
						}
					}
				} else {
					if ((var1 = var4[(var3 & 4032) + (var2 >> 6)] >>> var20) != 0) {
						var0[var12] = var1;
					}

					++var12;
					var2 += var17;
					var3 += var18;
					if ((var1 = var4[(var3 & 4032) + (var2 >> 6)] >>> var20) != 0) {
						var0[var12] = var1;
					}

					++var12;
					var2 += var17;
					var3 += var18;
					if ((var1 = var4[(var3 & 4032) + (var2 >> 6)] >>> var20) != 0) {
						var0[var12] = var1;
					}

					++var12;
					var2 += var17;
					var3 += var18;
					if ((var1 = var4[(var3 & 4032) + (var2 >> 6)] >>> var20) != 0) {
						var0[var12] = var1;
					}

					++var12;
					var2 += var17;
					var3 += var18;
					var2 = (var2 & 4095) + (var13 & 786432);
					var20 = var13 >> 20;
					var13 += var14;
					if ((var1 = var4[(var3 & 4032) + (var2 >> 6)] >>> var20) != 0) {
						var0[var12] = var1;
					}

					++var12;
					var2 += var17;
					var3 += var18;
					if ((var1 = var4[(var3 & 4032) + (var2 >> 6)] >>> var20) != 0) {
						var0[var12] = var1;
					}

					++var12;
					var2 += var17;
					var3 += var18;
					if ((var1 = var4[(var3 & 4032) + (var2 >> 6)] >>> var20) != 0) {
						var0[var12] = var1;
					}

					++var12;
					var2 += var17;
					var3 += var18;
					if ((var1 = var4[(var3 & 4032) + (var2 >> 6)] >>> var20) != 0) {
						var0[var12] = var1;
					}

					++var12;
					var2 += var17;
					var3 += var18;
					var2 = (var2 & 4095) + (var13 & 786432);
					var20 = var13 >> 20;
					var13 += var14;
					if ((var1 = var4[(var3 & 4032) + (var2 >> 6)] >>> var20) != 0) {
						var0[var12] = var1;
					}

					++var12;
					var2 += var17;
					var3 += var18;
					if ((var1 = var4[(var3 & 4032) + (var2 >> 6)] >>> var20) != 0) {
						var0[var12] = var1;
					}

					++var12;
					var2 += var17;
					var3 += var18;
					if ((var1 = var4[(var3 & 4032) + (var2 >> 6)] >>> var20) != 0) {
						var0[var12] = var1;
					}

					++var12;
					var2 += var17;
					var3 += var18;
					if ((var1 = var4[(var3 & 4032) + (var2 >> 6)] >>> var20) != 0) {
						var0[var12] = var1;
					}

					++var12;
					var2 += var17;
					var3 += var18;
					var2 = (var2 & 4095) + (var13 & 786432);
					var20 = var13 >> 20;
					var13 += var14;
					if ((var1 = var4[(var3 & 4032) + (var2 >> 6)] >>> var20) != 0) {
						var0[var12] = var1;
					}

					++var12;
					var2 += var17;
					var3 += var18;
					if ((var1 = var4[(var3 & 4032) + (var2 >> 6)] >>> var20) != 0) {
						var0[var12] = var1;
					}

					++var12;
					var2 += var17;
					var3 += var18;
					if ((var1 = var4[(var3 & 4032) + (var2 >> 6)] >>> var20) != 0) {
						var0[var12] = var1;
					}

					++var12;
					var2 += var17;
					var3 += var18;
					if ((var1 = var4[(var3 & 4032) + (var2 >> 6)] >>> var20) != 0) {
						var0[var12] = var1;
					}

					++var12;
				}
			}

		}
	}

	private static void method_389(int[] var0, int var1, int var2, int var3, int[] var4, int var5, int var6) {
		if (var1 < 0) {
			var6 <<= 1;
			var3 = var4[var5 >> 8 & 255];
			var5 += var6;
			int var7 = var1 / 8;

			for (int var8 = var7; var8 < 0; ++var8) {
				var0[var2++] = var3;
				var0[var2++] = var3;
				var3 = var4[var5 >> 8 & 255];
				var5 += var6;
				var0[var2++] = var3;
				var0[var2++] = var3;
				var3 = var4[var5 >> 8 & 255];
				var5 += var6;
				var0[var2++] = var3;
				var0[var2++] = var3;
				var3 = var4[var5 >> 8 & 255];
				var5 += var6;
				var0[var2++] = var3;
				var0[var2++] = var3;
				var3 = var4[var5 >> 8 & 255];
				var5 += var6;
			}

			var7 = -(var1 % 8);

			for (int var9 = 0; var9 < var7; ++var9) {
				var0[var2++] = var3;
				if ((var9 & 1) == 1) {
					var3 = var4[var5 >> 8 & 255];
					var5 += var6;
				}
			}

		}
	}

	private static void method_390(int[] var0, int var1, int var2, int var3, int[] var4, int var5, int var6) {
		if (var1 < 0) {
			var6 <<= 2;
			var3 = var4[var5 >> 8 & 255];
			var5 += var6;
			int var7 = var1 / 16;

			for (int var8 = var7; var8 < 0; ++var8) {
				var0[var2++] = var3 + (var0[var2] >> 1 & 8355711);
				var0[var2++] = var3 + (var0[var2] >> 1 & 8355711);
				var0[var2++] = var3 + (var0[var2] >> 1 & 8355711);
				var0[var2++] = var3 + (var0[var2] >> 1 & 8355711);
				var3 = var4[var5 >> 8 & 255];
				var5 += var6;
				var0[var2++] = var3 + (var0[var2] >> 1 & 8355711);
				var0[var2++] = var3 + (var0[var2] >> 1 & 8355711);
				var0[var2++] = var3 + (var0[var2] >> 1 & 8355711);
				var0[var2++] = var3 + (var0[var2] >> 1 & 8355711);
				var3 = var4[var5 >> 8 & 255];
				var5 += var6;
				var0[var2++] = var3 + (var0[var2] >> 1 & 8355711);
				var0[var2++] = var3 + (var0[var2] >> 1 & 8355711);
				var0[var2++] = var3 + (var0[var2] >> 1 & 8355711);
				var0[var2++] = var3 + (var0[var2] >> 1 & 8355711);
				var3 = var4[var5 >> 8 & 255];
				var5 += var6;
				var0[var2++] = var3 + (var0[var2] >> 1 & 8355711);
				var0[var2++] = var3 + (var0[var2] >> 1 & 8355711);
				var0[var2++] = var3 + (var0[var2] >> 1 & 8355711);
				var0[var2++] = var3 + (var0[var2] >> 1 & 8355711);
				var3 = var4[var5 >> 8 & 255];
				var5 += var6;
			}

			var7 = -(var1 % 16);

			for (int var9 = 0; var9 < var7; ++var9) {
				var0[var2++] = var3 + (var0[var2] >> 1 & 8355711);
				if ((var9 & 3) == 3) {
					var3 = var4[var5 >> 8 & 255];
					var5 += var6;
					var5 += var6;
				}
			}

		}
	}

	private static void grad1_scanline(int[] out, int i, int out_ptr, int col, int[] ramp, int r, int r_step) {
		if (i < 0) {
			r_step <<= 2;
			col = ramp[r >> 8 & 255];
			r += r_step;
			int off = i / 16;

			for (int j = off; j < 0; ++j) {
				out[out_ptr++] = col;
				out[out_ptr++] = col;
				out[out_ptr++] = col;
				out[out_ptr++] = col;
				col = ramp[r >> 8 & 255];
				r += r_step;
				out[out_ptr++] = col;
				out[out_ptr++] = col;
				out[out_ptr++] = col;
				out[out_ptr++] = col;
				col = ramp[r >> 8 & 255];
				r += r_step;
				out[out_ptr++] = col;
				out[out_ptr++] = col;
				out[out_ptr++] = col;
				out[out_ptr++] = col;
				col = ramp[r >> 8 & 255];
				r += r_step;
				out[out_ptr++] = col;
				out[out_ptr++] = col;
				out[out_ptr++] = col;
				out[out_ptr++] = col;
				col = ramp[r >> 8 & 255];
				r += r_step;
			}

			off = -(i % 16);

			for (int j = 0; j < off; ++j) {
				out[out_ptr++] = col;
				
				if ((j & 3) == 3) {
					col = ramp[r >> 8 & 255];
					r += r_step;
				}
			}
		}
	}

	public void set_camera(int target_x, int target_y, int target_z, int yaw, int pitch, int roll, int dist) {
		yaw &= 1023;
		pitch &= 1023;
		roll &= 1023;
		
		cam_yaw = 1024 - yaw & 1023;
		cam_pitch = 1024 - pitch & 1023;
		cam_roll = 1024 - roll & 1023;
		
		int dx = 0;
		int dy = 0;
		int dz = dist;

		if (yaw != 0) {
			int sin = sin2048_tbl[yaw];
			int cos = sin2048_tbl[yaw + 1024];
			int d = dy * cos - dist * sin >> 15;
			dz = dy * sin + dist * cos >> 15;
			dy = d;
		}

		if (pitch != 0) {
			int sin = sin2048_tbl[pitch];
			int cos = sin2048_tbl[pitch + 1024];
			int d = dz * sin + dx * cos >> 15;
			dz = dz * cos - dx * sin >> 15;
			dx = d;
		}

		if (roll != 0) {
			int sin = sin2048_tbl[roll];
			int cos = sin2048_tbl[roll + 1024];
			int d = dy * sin + dx * cos >> 15;
			dy = dy * cos - dx * sin >> 15;
			dx = d;
		}

		cam_x = target_x - dx;
		cam_y = target_y - dy;
		cam_z = target_z - dz;
	}

	private void init_poly_3d(int id) {
		Polygon poly = polys[id];
		Model model = poly.model;
		
		int face = poly.face;
		int[] verts = model.face_verts[face];
		int vert_cnt = model.face_vert_cnt[face];
		int scale = model.norm_scale[face];
		
		int a_x = model.project_vert_x[verts[0]];
		int a_y = model.project_vert_y[verts[0]];
		int a_z = model.project_vert_z[verts[0]];
		
		int b_x = model.project_vert_x[verts[1]] - a_x;
		int b_y = model.project_vert_y[verts[1]] - a_y;
		int b_z = model.project_vert_z[verts[1]] - a_z;
		
		int c_x = model.project_vert_x[verts[2]] - a_x;
		int c_y = model.project_vert_y[verts[2]] - a_y;
		int c_z = model.project_vert_z[verts[2]] - a_z;

		int norm_x = b_y * c_z - c_y * b_z;
		int norm_y = b_z * c_x - c_z * b_x;
		int norm_z = b_x * c_y - c_x * b_y;

		if (scale == -1) {
			for (scale = 0; norm_x > 25000 || norm_y > 25000 || norm_z > 25000 || norm_x < -25000 || norm_y < -25000 || norm_z < -25000; norm_z >>= 1) {
				scale += 1;
				norm_x >>= 1;
				norm_y >>= 1;
			}

			model.norm_scale[face] = scale;
			model.norm_mag[face] = (int) ((double) magnitude * Math.sqrt((double) (norm_x * norm_x + norm_y * norm_y + norm_z * norm_z)));
		} else {
			norm_x >>= scale;
			norm_y >>= scale;
			norm_z >>= scale;
		}

		poly.visibility = a_x * norm_x + a_y * norm_y + a_z * norm_z;
		poly.norm_x = norm_x;
		poly.norm_y = norm_y;
		poly.norm_z = norm_z;
		
		int min_z = model.project_vert_z[verts[0]];
		int max_z = min_z;
		
		int min_x = model.project_plane_x[verts[0]];
		int max_x = min_x;
		
		int min_y = model.project_plane_y[verts[0]];
		int max_y = min_y;

		for (int i = 1; i < vert_cnt; ++i) {
			int j = model.project_vert_z[verts[i]];
			if (j > max_z) {
				max_z = j;
			} else if (j < min_z) {
				min_z = j;
			}

			j = model.project_plane_x[verts[i]];
			if (j > max_x) {
				max_x = j;
			} else if (j < min_x) {
				min_x = j;
			}

			j = model.project_plane_y[verts[i]];
			if (j > max_y) {
				max_y = j;
			} else if (j < min_y) {
				min_y = j;
			}
		}

		poly.min_z = min_z;
		poly.max_z = max_z;
		poly.min_plane_x = min_x;
		poly.max_plane_x = max_x;
		poly.min_plane_y = min_y;
		poly.max_plane_y = max_y;
	}

	private void init_poly_2d(int id) {
		Polygon poly = polys[id];
		Model model = poly.model;
		
		int face = poly.face;
		int[] verts = model.face_verts[face];
		
		byte norm_x = 0;
		byte norm_y = 0;
		byte norm_z = 1;
		
		int a_x = model.project_vert_x[verts[0]];
		int a_y = model.project_vert_y[verts[0]];
		int a_z = model.project_vert_z[verts[0]];
		
		model.norm_mag[face] = 1;
		model.norm_scale[face] = 0;
		
		poly.visibility = a_x * norm_x + a_y * norm_y + a_z * norm_z;
		poly.norm_x = norm_x;
		poly.norm_y = norm_y;
		poly.norm_z = norm_z;
		
		int min_z = model.project_vert_z[verts[0]];
		int max_z = min_z;
		
		int min_x = model.project_plane_x[verts[0]];
		int max_x = min_x;
		
		if (model.project_plane_x[verts[1]] < min_x) {
			min_x = model.project_plane_x[verts[1]];
		} else {
			max_x = model.project_plane_x[verts[1]];
		}

		int min_y = model.project_plane_y[verts[1]];
		int max_y = model.project_plane_y[verts[0]];
		int j = model.project_vert_z[verts[1]];
		
		if (j > min_z) {
			max_z = j;
		} else if (j < min_z) {
			min_z = j;
		}

		j = model.project_plane_x[verts[1]];
		if (j > max_x) {
			max_x = j;
		} else if (j < min_x) {
			min_x = j;
		}

		j = model.project_plane_y[verts[1]];
		if (j > max_y) {
			max_y = j;
		} else if (j < min_y) {
			min_y = j;
		}

		poly.min_z = min_z;
		poly.max_z = max_z;
		poly.min_plane_x = min_x - 20;
		poly.max_plane_x = max_x + 20;
		poly.min_plane_y = min_y;
		poly.max_plane_y = max_y;
	}

	private boolean separate(Polygon poly_a, Polygon poly_b) {
		if (poly_a.min_plane_x >= poly_b.max_plane_x) {
			return true;
		} else if (poly_b.min_plane_x >= poly_a.max_plane_x) {
			return true;
		} else if (poly_a.min_plane_y >= poly_b.max_plane_y) {
			return true;
		} else if (poly_b.min_plane_y >= poly_a.max_plane_y) {
			return true;
		} else if (poly_a.min_z >= poly_b.max_z) {
			return true;
		} else if (poly_b.min_z > poly_a.max_z) {
			return false;
		} else {
			Model var3 = poly_a.model;
			Model var4 = poly_b.model;
			int var5 = poly_a.face;
			int var6 = poly_b.face;
			int[] var7 = var3.face_verts[var5];
			int[] var8 = var4.face_verts[var6];
			int var9 = var3.face_vert_cnt[var5];
			int var10 = var4.face_vert_cnt[var6];
			int var14 = var4.project_vert_x[var8[0]];
			int var15 = var4.project_vert_y[var8[0]];
			int var16 = var4.project_vert_z[var8[0]];
			int var17 = poly_b.norm_x;
			int var18 = poly_b.norm_y;
			int var19 = poly_b.norm_z;
			int var20 = var4.norm_mag[var6];
			int var21 = poly_b.visibility;
			boolean var13 = false;

			int var11;
			int var12;
			for (int var22 = 0; var22 < var9; ++var22) {
				var11 = var7[var22];
				var12 = (var14 - var3.project_vert_x[var11]) * var17 + (var15 - var3.project_vert_y[var11]) * var18
						+ (var16 - var3.project_vert_z[var11]) * var19;
				if (var12 < -var20 && var21 < 0 || var12 > var20 && var21 > 0) {
					var13 = true;
					break;
				}
			}

			if (!var13) {
				return true;
			} else {
				var14 = var3.project_vert_x[var7[0]];
				var15 = var3.project_vert_y[var7[0]];
				var16 = var3.project_vert_z[var7[0]];
				var17 = poly_a.norm_x;
				var18 = poly_a.norm_y;
				var19 = poly_a.norm_z;
				var20 = var3.norm_mag[var5];
				var21 = poly_a.visibility;
				var13 = false;

				for (int var23 = 0; var23 < var10; ++var23) {
					var11 = var8[var23];
					var12 = (var14 - var4.project_vert_x[var11]) * var17 + (var15 - var4.project_vert_y[var11]) * var18
							+ (var16 - var4.project_vert_z[var11]) * var19;
					if (var12 < -var20 && var21 > 0 || var12 > var20 && var21 < 0) {
						var13 = true;
						break;
					}
				}

				if (!var13) {
					return true;
				} else {
					int[] var24;
					int[] var25;
					int var28;
					int var29;
					if (var9 == 2) {
						var24 = new int[4];
						var25 = new int[4];
						var28 = var7[0];
						var11 = var7[1];
						var24[0] = var3.project_plane_x[var28] - 20;
						var24[1] = var3.project_plane_x[var11] - 20;
						var24[2] = var3.project_plane_x[var11] + 20;
						var24[3] = var3.project_plane_x[var28] + 20;
						var25[0] = var25[3] = var3.project_plane_y[var28];
						var25[1] = var25[2] = var3.project_plane_y[var11];
					} else {
						var24 = new int[var9];
						var25 = new int[var9];

						for (var28 = 0; var28 < var9; ++var28) {
							var29 = var7[var28];
							var24[var28] = var3.project_plane_x[var29];
							var25[var28] = var3.project_plane_y[var29];
						}
					}

					int[] var26;
					int[] var27;
					if (var10 == 2) {
						var26 = new int[4];
						var27 = new int[4];
						var28 = var8[0];
						var11 = var8[1];
						var26[0] = var4.project_plane_x[var28] - 20;
						var26[1] = var4.project_plane_x[var11] - 20;
						var26[2] = var4.project_plane_x[var11] + 20;
						var26[3] = var4.project_plane_x[var28] + 20;
						var27[0] = var27[3] = var4.project_plane_y[var28];
						var27[1] = var27[2] = var4.project_plane_y[var11];
					} else {
						var26 = new int[var10];
						var27 = new int[var10];

						for (var28 = 0; var28 < var10; ++var28) {
							var29 = var8[var28];
							var26[var28] = var4.project_plane_x[var29];
							var27[var28] = var4.project_plane_y[var29];
						}
					}

					return !this.intersect(var24, var25, var26, var27);
				}
			}
		}
	}

	private boolean heuristic(Polygon var1, Polygon var2) {
		Model var3 = var1.model;
		Model var4 = var2.model;
		int var5 = var1.face;
		int var6 = var2.face;
		int[] var7 = var3.face_verts[var5];
		int[] var8 = var4.face_verts[var6];
		int var9 = var3.face_vert_cnt[var5];
		int var10 = var4.face_vert_cnt[var6];
		int var14 = var4.project_vert_x[var8[0]];
		int var15 = var4.project_vert_y[var8[0]];
		int var16 = var4.project_vert_z[var8[0]];
		int var17 = var2.norm_x;
		int var18 = var2.norm_y;
		int var19 = var2.norm_z;
		int var20 = var4.norm_mag[var6];
		int var21 = var2.visibility;
		boolean intersect = false;

		int var11;
		int var12;
		for (int var22 = 0; var22 < var9; ++var22) {
			var11 = var7[var22];
			var12 = (var14 - var3.project_vert_x[var11]) * var17 + (var15 - var3.project_vert_y[var11]) * var18
					+ (var16 - var3.project_vert_z[var11]) * var19;
			if (var12 < -var20 && var21 < 0 || var12 > var20 && var21 > 0) {
				intersect = true;
				break;
			}
		}

		if (!intersect) {
			return true;
		} else {
			var14 = var3.project_vert_x[var7[0]];
			var15 = var3.project_vert_y[var7[0]];
			var16 = var3.project_vert_z[var7[0]];
			var17 = var1.norm_x;
			var18 = var1.norm_y;
			var19 = var1.norm_z;
			var20 = var3.norm_mag[var5];
			var21 = var1.visibility;
			intersect = false;

			for (int var23 = 0; var23 < var10; ++var23) {
				var11 = var8[var23];
				var12 = (var14 - var4.project_vert_x[var11]) * var17 + (var15 - var4.project_vert_y[var11]) * var18
						+ (var16 - var4.project_vert_z[var11]) * var19;
				if (var12 < -var20 && var21 > 0 || var12 > var20 && var21 < 0) {
					intersect = true;
					break;
				}
			}

			return !intersect;
		}
	}

	public void texture_allocate(int texture_sz, int pool64_sz, int pool256_sz) {
		texture_cnt = texture_sz;
		texture_raster = new byte[texture_sz][];
		texture_palette = new int[texture_sz][];
		texture_dim = new int[texture_sz];
		texture_id = new long[texture_sz];
		texture_trans_back = new boolean[texture_sz];
		texture_pixels = new int[texture_sz][];
		
		pool64 = new int[pool64_sz][];
		pool256 = new int[pool256_sz][];
		next_id = 0L;
	}

	public void texture_define(int id, byte[] raster, int[] palette, int dim) {
		texture_raster[id] = raster;
		texture_palette[id] = palette;
		texture_dim[id] = dim;
		texture_id[id] = 0L;
		texture_trans_back[id] = false;
		texture_pixels[id] = null;
		
		texture_prepare(id);
	}

	public void texture_prepare(int id) {
		if (id < 0) {
			return;
		}
		
		texture_id[id] = (long) (next_id++);
		
		if (texture_pixels[id] != null) {
			return;
		}
		

		
		if (texture_dim[id] == 0) {
			for (int i = 0; i < pool64.length; ++i) {
				if (pool64[i] == null) {
					pool64[i] = new int[16384];
					texture_pixels[id] = pool64[i];
					texture_resolve(id);
					return;
				}
			}

			long t_id = 1L << 30;
			int duplicate_id = 0;

			for (int i = 0; i < texture_cnt; ++i) {
				if (i != id && texture_dim[i] == 0 && texture_pixels[i] != null && texture_id[i] < t_id) {
					t_id = texture_id[i];
					duplicate_id = i;
				}
			}

			texture_pixels[id] = texture_pixels[duplicate_id];
			texture_pixels[duplicate_id] = null;
			texture_resolve(id);
		} else {
			for (int i = 0; i < pool256.length; ++i) {
				if (pool256[i] == null) {
					pool256[i] = new int[65536];
					texture_pixels[id] = pool256[i];
					texture_resolve(id);
					return;
				}
			}

			long t_id = 1L << 30;
			int duplicate_id = 0;

			for (int i = 0; i < texture_cnt; ++i) {
				if (i != id && texture_dim[i] == 1 && texture_pixels[i] != null && texture_id[i] < t_id) {
					t_id = texture_id[i];
					duplicate_id = i;
				}
			}

			texture_pixels[id] = texture_pixels[duplicate_id];
			texture_pixels[duplicate_id] = null;
			texture_resolve(id);
		}
	}

	private void texture_resolve(int id) {
		short len;
		if (texture_dim[id] == 0) {
			len = 64;
		} else {
			len = 128;
		}

		int[] raster = texture_pixels[id];
		int ptr = 0;

		for (int y = 0; y < len; ++y) {
			for (int x = 0; x < len; ++x) {
				int pix = texture_palette[id][texture_raster[id][x + y * len] & 255];
				pix &= 0xF8F8FF;
				
				if (pix == 0) {
					pix = 1;
				} else if (pix == 0xF800FF) {
					pix = 0;
					texture_trans_back[id] = true;
				}

				raster[ptr++] = pix;
			}
		}

		for (int i = 0; i < ptr; ++i) {
			int pix = raster[i];
			raster[ptr + i]     = pix - (pix >>> 3) & 0xF8F8FF;
			raster[ptr * 2 + i] = pix - (pix >>> 2) & 0xF8F8FF;
			raster[ptr * 3 + i] = pix - (pix >>> 2) - (pix >>> 3) & 0xF8F8FF;
		}

	}

	public void method_401(int id) {
		if (texture_pixels[id] != null) {
			int[] raster = texture_pixels[id];

			for (int i = 0; i < 64; ++i) {
				int ptr = i + 4032;
				int pix = raster[ptr];

				for (int j = 0; j < 63; ++j) {
					raster[ptr] = raster[ptr - 64];
					ptr -= 64;
				}

				texture_pixels[id][ptr] = pix;
			}

			short off = 4096;

			for (int i = 0; i < off; ++i) {
				int pix = raster[i];

				raster[off + i]     = pix - (pix >>> 3) & 0xF8F8FF;
				raster[off * 2 + i] = pix - (pix >>> 2) & 0xF8F8FF;
				raster[off * 3 + i] = pix - (pix >>> 2) - (pix >>> 3) & 0xF8F8FF;
			}
		}
	}

	public int texture_map_color(int id) {
		if (id == use_gourad_shading) {
			return 0;
		}

		texture_prepare(id);
		
		if (id >= 0) {
			return texture_pixels[id][0];
		} else if (id < 0) {
			id = -(id + 1);
			int r = id >> 10 & 31;
			int g = id >> 5 & 31;
			int b = id & 31;
			return (r << 19) + (g << 11) + (b << 3);
		}
		
		return 0;
	}

	public void set_light(int x, int y, int z) {
		if (x == 0 && y == 0 && z == 0) {
			x = 32;
		}

		for (int i = 0; i < model_cnt; ++i) {
			models[i].set_light(x, y, z);
		}
	}

	public void set_light(int ambient, int falloff, int x, int y, int z) {
		if (x == 0 && y == 0 && z == 0) {
			x = 32;
		}

		for (int var6 = 0; var6 < this.model_cnt; ++var6) {
			this.models[var6].set_light(ambient, falloff, x, y, z);
		}
	}

	public static int rgb(int r, int g, int b) {
		return -1 - r / 8 * 1024 - g / 8 * 32 - b / 8;
	}

	public int method_406(int var1, int var2, int var3, int var4, int var5) {
		return var4 == var2 ? var1 : var1 + (var3 - var1) * (var5 - var2) / (var4 - var2);
	}

	public boolean method_407(int var1, int var2, int var3, int var4, boolean var5) {
		if ((!var5 || var1 > var3) && var1 >= var3) {
			if (var1 < var4) {
				return true;
			} else if (var2 < var3) {
				return true;
			} else {
				return var2 < var4 ? true : var5;
			}
		} else if (var1 > var4) {
			return true;
		} else if (var2 > var3) {
			return true;
		} else if (var2 > var4) {
			return true;
		} else {
			return !var5;
		}
	}

	public boolean method_408(int var1, int var2, int var3, boolean var4) {
		if ((!var4 || var1 > var3) && var1 >= var3) {
			return var2 < var3 ? true : var4;
		} else if (var2 > var3) {
			return true;
		} else {
			return !var4;
		}
	}

	public boolean intersect(int[] a_x, int[] a_y, int[] b_x, int[] b_y) {
		int cnt_a = a_x.length;
		int cnt_b = b_x.length;
		byte state = 0;
		int min_y_a;
		int max_y_a = min_y_a = a_y[0];
		int min_y_idx_a = 0;
		int min_y_b;
		int max_y_b = min_y_b = b_y[0];
		int min_y_idx_b = 0;

		for (int i = 1; i < cnt_a; ++i) {
			if (a_y[i] < min_y_a) {
				min_y_a = a_y[i];
				min_y_idx_a = i;
			} else if (a_y[i] > max_y_a) {
				max_y_a = a_y[i];
			}
		}

		for (int i = 1; i < cnt_b; ++i) {
			if (b_y[i] < min_y_b) {
				min_y_b = b_y[i];
				min_y_idx_b = i;
			} else if (b_y[i] > max_y_b) {
				max_y_b = b_y[i];
			}
		}

		if (min_y_b >= max_y_a) {
			return false;
		} else if (min_y_a >= max_y_b) {
			return false;
		} else {
			int var8;
			int var10;
			int var11;
			int var12;
			int var13;
			int var14;
			boolean var16;
			if (a_y[min_y_idx_a] < b_y[min_y_idx_b]) {
				for (var8 = min_y_idx_a; a_y[var8] < b_y[min_y_idx_b]; var8 = (var8 + 1) % cnt_a) {
					;
				}

				while (a_y[min_y_idx_a] < b_y[min_y_idx_b]) {
					min_y_idx_a = (min_y_idx_a - 1 + cnt_a) % cnt_a;
				}

				var11 = this.method_406(a_x[(min_y_idx_a + 1) % cnt_a], a_y[(min_y_idx_a + 1) % cnt_a], a_x[min_y_idx_a], a_y[min_y_idx_a],
						b_y[min_y_idx_b]);
				var12 = this.method_406(a_x[(var8 - 1 + cnt_a) % cnt_a], a_y[(var8 - 1 + cnt_a) % cnt_a], a_x[var8],
						a_y[var8], b_y[min_y_idx_b]);
				var13 = b_x[min_y_idx_b];
				var16 = var11 < var13 | var12 < var13;
				if (this.method_408(var11, var12, var13, var16)) {
					return true;
				}

				var10 = (min_y_idx_b + 1) % cnt_b;
				min_y_idx_b = (min_y_idx_b - 1 + cnt_b) % cnt_b;
				if (min_y_idx_a == var8) {
					state = 1;
				}
			} else {
				for (var10 = min_y_idx_b; b_y[var10] < a_y[min_y_idx_a]; var10 = (var10 + 1) % cnt_b) {
					;
				}

				while (b_y[min_y_idx_b] < a_y[min_y_idx_a]) {
					min_y_idx_b = (min_y_idx_b - 1 + cnt_b) % cnt_b;
				}

				var11 = a_x[min_y_idx_a];
				var13 = this.method_406(b_x[(min_y_idx_b + 1) % cnt_b], b_y[(min_y_idx_b + 1) % cnt_b], b_x[min_y_idx_b], b_y[min_y_idx_b],
						a_y[min_y_idx_a]);
				var14 = this.method_406(b_x[(var10 - 1 + cnt_b) % cnt_b], b_y[(var10 - 1 + cnt_b) % cnt_b], b_x[var10],
						b_y[var10], a_y[min_y_idx_a]);
				var16 = var11 < var13 | var11 < var14;
				if (this.method_408(var13, var14, var11, !var16)) {
					return true;
				}

				var8 = (min_y_idx_a + 1) % cnt_a;
				min_y_idx_a = (min_y_idx_a - 1 + cnt_a) % cnt_a;
				if (min_y_idx_b == var10) {
					state = 2;
				}
			}

			while (state == 0) {
				if (a_y[min_y_idx_a] < a_y[var8]) {
					if (a_y[min_y_idx_a] < b_y[min_y_idx_b]) {
						if (a_y[min_y_idx_a] < b_y[var10]) {
							var11 = a_x[min_y_idx_a];
							var12 = this.method_406(a_x[(var8 - 1 + cnt_a) % cnt_a], a_y[(var8 - 1 + cnt_a) % cnt_a],
									a_x[var8], a_y[var8], a_y[min_y_idx_a]);
							var13 = this.method_406(b_x[(min_y_idx_b + 1) % cnt_b], b_y[(min_y_idx_b + 1) % cnt_b], b_x[min_y_idx_b],
									b_y[min_y_idx_b], a_y[min_y_idx_a]);
							var14 = this.method_406(b_x[(var10 - 1 + cnt_b) % cnt_b], b_y[(var10 - 1 + cnt_b) % cnt_b],
									b_x[var10], b_y[var10], a_y[min_y_idx_a]);
							if (this.method_407(var11, var12, var13, var14, var16)) {
								return true;
							}

							min_y_idx_a = (min_y_idx_a - 1 + cnt_a) % cnt_a;
							if (min_y_idx_a == var8) {
								state = 1;
							}
						} else {
							var11 = this.method_406(a_x[(min_y_idx_a + 1) % cnt_a], a_y[(min_y_idx_a + 1) % cnt_a], a_x[min_y_idx_a],
									a_y[min_y_idx_a], b_y[var10]);
							var12 = this.method_406(a_x[(var8 - 1 + cnt_a) % cnt_a], a_y[(var8 - 1 + cnt_a) % cnt_a],
									a_x[var8], a_y[var8], b_y[var10]);
							var13 = this.method_406(b_x[(min_y_idx_b + 1) % cnt_b], b_y[(min_y_idx_b + 1) % cnt_b], b_x[min_y_idx_b],
									b_y[min_y_idx_b], b_y[var10]);
							var14 = b_x[var10];
							if (this.method_407(var11, var12, var13, var14, var16)) {
								return true;
							}

							var10 = (var10 + 1) % cnt_b;
							if (min_y_idx_b == var10) {
								state = 2;
							}
						}
					} else if (b_y[min_y_idx_b] < b_y[var10]) {
						var11 = this.method_406(a_x[(min_y_idx_a + 1) % cnt_a], a_y[(min_y_idx_a + 1) % cnt_a], a_x[min_y_idx_a],
								a_y[min_y_idx_a], b_y[min_y_idx_b]);
						var12 = this.method_406(a_x[(var8 - 1 + cnt_a) % cnt_a], a_y[(var8 - 1 + cnt_a) % cnt_a],
								a_x[var8], a_y[var8], b_y[min_y_idx_b]);
						var13 = b_x[min_y_idx_b];
						var14 = this.method_406(b_x[(var10 - 1 + cnt_b) % cnt_b], b_y[(var10 - 1 + cnt_b) % cnt_b],
								b_x[var10], b_y[var10], b_y[min_y_idx_b]);
						if (this.method_407(var11, var12, var13, var14, var16)) {
							return true;
						}

						min_y_idx_b = (min_y_idx_b - 1 + cnt_b) % cnt_b;
						if (min_y_idx_b == var10) {
							state = 2;
						}
					} else {
						var11 = this.method_406(a_x[(min_y_idx_a + 1) % cnt_a], a_y[(min_y_idx_a + 1) % cnt_a], a_x[min_y_idx_a],
								a_y[min_y_idx_a], b_y[var10]);
						var12 = this.method_406(a_x[(var8 - 1 + cnt_a) % cnt_a], a_y[(var8 - 1 + cnt_a) % cnt_a],
								a_x[var8], a_y[var8], b_y[var10]);
						var13 = this.method_406(b_x[(min_y_idx_b + 1) % cnt_b], b_y[(min_y_idx_b + 1) % cnt_b], b_x[min_y_idx_b],
								b_y[min_y_idx_b], b_y[var10]);
						var14 = b_x[var10];
						if (this.method_407(var11, var12, var13, var14, var16)) {
							return true;
						}

						var10 = (var10 + 1) % cnt_b;
						if (min_y_idx_b == var10) {
							state = 2;
						}
					}
				} else if (a_y[var8] < b_y[min_y_idx_b]) {
					if (a_y[var8] < b_y[var10]) {
						var11 = this.method_406(a_x[(min_y_idx_a + 1) % cnt_a], a_y[(min_y_idx_a + 1) % cnt_a], a_x[min_y_idx_a],
								a_y[min_y_idx_a], a_y[var8]);
						var12 = a_x[var8];
						var13 = this.method_406(b_x[(min_y_idx_b + 1) % cnt_b], b_y[(min_y_idx_b + 1) % cnt_b], b_x[min_y_idx_b],
								b_y[min_y_idx_b], a_y[var8]);
						var14 = this.method_406(b_x[(var10 - 1 + cnt_b) % cnt_b], b_y[(var10 - 1 + cnt_b) % cnt_b],
								b_x[var10], b_y[var10], a_y[var8]);
						if (this.method_407(var11, var12, var13, var14, var16)) {
							return true;
						}

						var8 = (var8 + 1) % cnt_a;
						if (min_y_idx_a == var8) {
							state = 1;
						}
					} else {
						var11 = this.method_406(a_x[(min_y_idx_a + 1) % cnt_a], a_y[(min_y_idx_a + 1) % cnt_a], a_x[min_y_idx_a],
								a_y[min_y_idx_a], b_y[var10]);
						var12 = this.method_406(a_x[(var8 - 1 + cnt_a) % cnt_a], a_y[(var8 - 1 + cnt_a) % cnt_a],
								a_x[var8], a_y[var8], b_y[var10]);
						var13 = this.method_406(b_x[(min_y_idx_b + 1) % cnt_b], b_y[(min_y_idx_b + 1) % cnt_b], b_x[min_y_idx_b],
								b_y[min_y_idx_b], b_y[var10]);
						var14 = b_x[var10];
						if (this.method_407(var11, var12, var13, var14, var16)) {
							return true;
						}

						var10 = (var10 + 1) % cnt_b;
						if (min_y_idx_b == var10) {
							state = 2;
						}
					}
				} else if (b_y[min_y_idx_b] < b_y[var10]) {
					var11 = this.method_406(a_x[(min_y_idx_a + 1) % cnt_a], a_y[(min_y_idx_a + 1) % cnt_a], a_x[min_y_idx_a], a_y[min_y_idx_a],
							b_y[min_y_idx_b]);
					var12 = this.method_406(a_x[(var8 - 1 + cnt_a) % cnt_a], a_y[(var8 - 1 + cnt_a) % cnt_a], a_x[var8],
							a_y[var8], b_y[min_y_idx_b]);
					var13 = b_x[min_y_idx_b];
					var14 = this.method_406(b_x[(var10 - 1 + cnt_b) % cnt_b], b_y[(var10 - 1 + cnt_b) % cnt_b],
							b_x[var10], b_y[var10], b_y[min_y_idx_b]);
					if (this.method_407(var11, var12, var13, var14, var16)) {
						return true;
					}

					min_y_idx_b = (min_y_idx_b - 1 + cnt_b) % cnt_b;
					if (min_y_idx_b == var10) {
						state = 2;
					}
				} else {
					var11 = this.method_406(a_x[(min_y_idx_a + 1) % cnt_a], a_y[(min_y_idx_a + 1) % cnt_a], a_x[min_y_idx_a], a_y[min_y_idx_a],
							b_y[var10]);
					var12 = this.method_406(a_x[(var8 - 1 + cnt_a) % cnt_a], a_y[(var8 - 1 + cnt_a) % cnt_a], a_x[var8],
							a_y[var8], b_y[var10]);
					var13 = this.method_406(b_x[(min_y_idx_b + 1) % cnt_b], b_y[(min_y_idx_b + 1) % cnt_b], b_x[min_y_idx_b], b_y[min_y_idx_b],
							b_y[var10]);
					var14 = b_x[var10];
					if (this.method_407(var11, var12, var13, var14, var16)) {
						return true;
					}

					var10 = (var10 + 1) % cnt_b;
					if (min_y_idx_b == var10) {
						state = 2;
					}
				}
			}

			while (state == 1) {
				if (a_y[min_y_idx_a] < b_y[min_y_idx_b]) {
					if (a_y[min_y_idx_a] < b_y[var10]) {
						var11 = a_x[min_y_idx_a];
						var13 = this.method_406(b_x[(min_y_idx_b + 1) % cnt_b], b_y[(min_y_idx_b + 1) % cnt_b], b_x[min_y_idx_b],
								b_y[min_y_idx_b], a_y[min_y_idx_a]);
						var14 = this.method_406(b_x[(var10 - 1 + cnt_b) % cnt_b], b_y[(var10 - 1 + cnt_b) % cnt_b],
								b_x[var10], b_y[var10], a_y[min_y_idx_a]);
						if (this.method_408(var13, var14, var11, !var16)) {
							return true;
						}

						return false;
					}

					var11 = this.method_406(a_x[(min_y_idx_a + 1) % cnt_a], a_y[(min_y_idx_a + 1) % cnt_a], a_x[min_y_idx_a], a_y[min_y_idx_a],
							b_y[var10]);
					var12 = this.method_406(a_x[(var8 - 1 + cnt_a) % cnt_a], a_y[(var8 - 1 + cnt_a) % cnt_a], a_x[var8],
							a_y[var8], b_y[var10]);
					var13 = this.method_406(b_x[(min_y_idx_b + 1) % cnt_b], b_y[(min_y_idx_b + 1) % cnt_b], b_x[min_y_idx_b], b_y[min_y_idx_b],
							b_y[var10]);
					var14 = b_x[var10];
					if (this.method_407(var11, var12, var13, var14, var16)) {
						return true;
					}

					var10 = (var10 + 1) % cnt_b;
					if (min_y_idx_b == var10) {
						state = 0;
					}
				} else if (b_y[min_y_idx_b] < b_y[var10]) {
					var11 = this.method_406(a_x[(min_y_idx_a + 1) % cnt_a], a_y[(min_y_idx_a + 1) % cnt_a], a_x[min_y_idx_a], a_y[min_y_idx_a],
							b_y[min_y_idx_b]);
					var12 = this.method_406(a_x[(var8 - 1 + cnt_a) % cnt_a], a_y[(var8 - 1 + cnt_a) % cnt_a], a_x[var8],
							a_y[var8], b_y[min_y_idx_b]);
					var13 = b_x[min_y_idx_b];
					var14 = this.method_406(b_x[(var10 - 1 + cnt_b) % cnt_b], b_y[(var10 - 1 + cnt_b) % cnt_b],
							b_x[var10], b_y[var10], b_y[min_y_idx_b]);
					if (this.method_407(var11, var12, var13, var14, var16)) {
						return true;
					}

					min_y_idx_b = (min_y_idx_b - 1 + cnt_b) % cnt_b;
					if (min_y_idx_b == var10) {
						state = 0;
					}
				} else {
					var11 = this.method_406(a_x[(min_y_idx_a + 1) % cnt_a], a_y[(min_y_idx_a + 1) % cnt_a], a_x[min_y_idx_a], a_y[min_y_idx_a],
							b_y[var10]);
					var12 = this.method_406(a_x[(var8 - 1 + cnt_a) % cnt_a], a_y[(var8 - 1 + cnt_a) % cnt_a], a_x[var8],
							a_y[var8], b_y[var10]);
					var13 = this.method_406(b_x[(min_y_idx_b + 1) % cnt_b], b_y[(min_y_idx_b + 1) % cnt_b], b_x[min_y_idx_b], b_y[min_y_idx_b],
							b_y[var10]);
					var14 = b_x[var10];
					if (this.method_407(var11, var12, var13, var14, var16)) {
						return true;
					}

					var10 = (var10 + 1) % cnt_b;
					if (min_y_idx_b == var10) {
						state = 0;
					}
				}
			}

			while (state == 2) {
				if (b_y[min_y_idx_b] < a_y[min_y_idx_a]) {
					if (b_y[min_y_idx_b] < a_y[var8]) {
						var11 = this.method_406(a_x[(min_y_idx_a + 1) % cnt_a], a_y[(min_y_idx_a + 1) % cnt_a], a_x[min_y_idx_a],
								a_y[min_y_idx_a], b_y[min_y_idx_b]);
						var12 = this.method_406(a_x[(var8 - 1 + cnt_a) % cnt_a], a_y[(var8 - 1 + cnt_a) % cnt_a],
								a_x[var8], a_y[var8], b_y[min_y_idx_b]);
						var13 = b_x[min_y_idx_b];
						if (this.method_408(var11, var12, var13, var16)) {
							return true;
						}

						return false;
					}

					var11 = this.method_406(a_x[(min_y_idx_a + 1) % cnt_a], a_y[(min_y_idx_a + 1) % cnt_a], a_x[min_y_idx_a], a_y[min_y_idx_a],
							a_y[var8]);
					var12 = a_x[var8];
					var13 = this.method_406(b_x[(min_y_idx_b + 1) % cnt_b], b_y[(min_y_idx_b + 1) % cnt_b], b_x[min_y_idx_b], b_y[min_y_idx_b],
							a_y[var8]);
					var14 = this.method_406(b_x[(var10 - 1 + cnt_b) % cnt_b], b_y[(var10 - 1 + cnt_b) % cnt_b],
							b_x[var10], b_y[var10], a_y[var8]);
					if (this.method_407(var11, var12, var13, var14, var16)) {
						return true;
					}

					var8 = (var8 + 1) % cnt_a;
					if (min_y_idx_a == var8) {
						state = 0;
					}
				} else if (a_y[min_y_idx_a] < a_y[var8]) {
					var11 = a_x[min_y_idx_a];
					var12 = this.method_406(a_x[(var8 - 1 + cnt_a) % cnt_a], a_y[(var8 - 1 + cnt_a) % cnt_a], a_x[var8],
							a_y[var8], a_y[min_y_idx_a]);
					var13 = this.method_406(b_x[(min_y_idx_b + 1) % cnt_b], b_y[(min_y_idx_b + 1) % cnt_b], b_x[min_y_idx_b], b_y[min_y_idx_b],
							a_y[min_y_idx_a]);
					var14 = this.method_406(b_x[(var10 - 1 + cnt_b) % cnt_b], b_y[(var10 - 1 + cnt_b) % cnt_b],
							b_x[var10], b_y[var10], a_y[min_y_idx_a]);
					if (this.method_407(var11, var12, var13, var14, var16)) {
						return true;
					}

					min_y_idx_a = (min_y_idx_a - 1 + cnt_a) % cnt_a;
					if (min_y_idx_a == var8) {
						state = 0;
					}
				} else {
					var11 = this.method_406(a_x[(min_y_idx_a + 1) % cnt_a], a_y[(min_y_idx_a + 1) % cnt_a], a_x[min_y_idx_a], a_y[min_y_idx_a],
							a_y[var8]);
					var12 = a_x[var8];
					var13 = this.method_406(b_x[(min_y_idx_b + 1) % cnt_b], b_y[(min_y_idx_b + 1) % cnt_b], b_x[min_y_idx_b], b_y[min_y_idx_b],
							a_y[var8]);
					var14 = this.method_406(b_x[(var10 - 1 + cnt_b) % cnt_b], b_y[(var10 - 1 + cnt_b) % cnt_b],
							b_x[var10], b_y[var10], a_y[var8]);
					if (this.method_407(var11, var12, var13, var14, var16)) {
						return true;
					}

					var8 = (var8 + 1) % cnt_a;
					if (min_y_idx_a == var8) {
						state = 0;
					}
				}
			}

			if (a_y[min_y_idx_a] < b_y[min_y_idx_b]) {
				var11 = a_x[min_y_idx_a];
				var13 = this.method_406(b_x[(min_y_idx_b + 1) % cnt_b], b_y[(min_y_idx_b + 1) % cnt_b], b_x[min_y_idx_b], b_y[min_y_idx_b],
						a_y[min_y_idx_a]);
				var14 = this.method_406(b_x[(var10 - 1 + cnt_b) % cnt_b], b_y[(var10 - 1 + cnt_b) % cnt_b], b_x[var10],
						b_y[var10], a_y[min_y_idx_a]);
				if (this.method_408(var13, var14, var11, !var16)) {
					return true;
				} else {
					return false;
				}
			} else {
				var11 = this.method_406(a_x[(min_y_idx_a + 1) % cnt_a], a_y[(min_y_idx_a + 1) % cnt_a], a_x[min_y_idx_a], a_y[min_y_idx_a],
						b_y[min_y_idx_b]);
				var12 = this.method_406(a_x[(var8 - 1 + cnt_a) % cnt_a], a_y[(var8 - 1 + cnt_a) % cnt_a], a_x[var8],
						a_y[var8], b_y[min_y_idx_b]);
				var13 = b_x[min_y_idx_b];
				if (this.method_408(var11, var12, var13, var16)) {
					return true;
				} else {
					return false;
				}
			}
		}
	}
}
