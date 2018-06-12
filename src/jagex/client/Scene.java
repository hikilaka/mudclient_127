package jagex.client;

public final class Scene {
	public static final int[] sin2048_tbl = new int[2048];
	public static final int[] sin512_tbl = new int[512];

	private static final int use_gourad_shading = 12345678;

	int ramp_cnt;
	int[] grad_base;
	int[][] grad_ramps;
	int[] ramp;
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

					if (plane_x - w / 2 <= clip_x && plane_x + w / 2 >= -clip_x && plane_y - h <= clip_y
							&& plane_y >= -clip_y) {
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

						if (click_y >= c_y && click_y <= c_y + h && click_x >= c_x && click_x <= c_x + w
								&& !model.unpickable && model.is_local_player[face] == 0) {
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
								int dx = model.project_vert_x[vert]
										- (model.project_vert_x[vert] - model.project_vert_x[text])
												* (model.project_vert_z[vert] - this.clip_near) / dz;
								int dy = model.project_vert_y[vert]
										- (model.project_vert_y[vert] - model.project_vert_y[text])
												* (model.project_vert_z[vert] - this.clip_near) / dz;

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
								int dx = model.project_vert_x[vert]
										- (model.project_vert_x[vert] - model.project_vert_x[text])
												* (model.project_vert_z[vert] - clip_near) / dz;
								int dy = model.project_vert_y[vert]
										- (model.project_vert_y[vert] - model.project_vert_y[text])
												* (model.project_vert_z[vert] - clip_near) / dz;

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

	private void gen_scanlines(int start_x, int x, int a_ptr, int start_s, int vert_cnt, int[] vert_x, int[] vert_y,
			int[] vert_shade, Model model, int face) {
		if (vert_cnt == 3) {
			int a_y = vert_y[0] + base_y;
			int b_y = vert_y[1] + base_y;
			int c_y = vert_y[2] + base_y;
			int a_x = vert_x[0];
			int b_x = vert_x[1];
			int c_x = vert_x[2];
			int a_s = vert_shade[0];
			int b_s = vert_shade[1];
			int c_s = vert_shade[2];
			int max_y = base_y + clip_y - 1;
			int ac_start_x = 0;
			int ac_dx = 0;
			int ac_start_s = 0;
			int ac_ds = 0;
			int ac_start_y = 12345678;
			int ac_end_y = -12345678;
			if (c_y != a_y) {
				ac_dx = (c_x - a_x << 8) / (c_y - a_y);
				ac_ds = (c_s - a_s << 8) / (c_y - a_y);
				if (a_y < c_y) {
					ac_start_x = a_x << 8;
					ac_start_s = a_s << 8;
					ac_start_y = a_y;
					ac_end_y = c_y;
				} else {
					ac_start_x = c_x << 8;
					ac_start_s = c_s << 8;
					ac_start_y = c_y;
					ac_end_y = a_y;
				}

				if (ac_start_y < 0) {
					ac_start_x -= ac_dx * ac_start_y;
					ac_start_s -= ac_ds * ac_start_y;
					ac_start_y = 0;
				}

				if (ac_end_y > max_y) {
					ac_end_y = max_y;
				}
			}

			int ab_start_x = 0;
			int ab_dx = 0;
			int ab_start_s = 0;
			int ab_ds = 0;
			int ab_start_y = 12345678;
			int ab_end_y = -12345678;
			if (b_y != a_y) {
				ab_dx = (b_x - a_x << 8) / (b_y - a_y);
				ab_ds = (b_s - a_s << 8) / (b_y - a_y);
				if (a_y < b_y) {
					ab_start_x = a_x << 8;
					ab_start_s = a_s << 8;
					ab_start_y = a_y;
					ab_end_y = b_y;
				} else {
					ab_start_x = b_x << 8;
					ab_start_s = b_s << 8;
					ab_start_y = b_y;
					ab_end_y = a_y;
				}

				if (ab_start_y < 0) {
					ab_start_x -= ab_dx * ab_start_y;
					ab_start_s -= ab_ds * ab_start_y;
					ab_start_y = 0;
				}

				if (ab_end_y > max_y) {
					ab_end_y = max_y;
				}
			}

			int bc_start_x = 0;
			int bc_dx = 0;
			int bc_start_s = 0;
			int bc_ds = 0;
			int bc_start_y = 12345678;
			int bc_end_y = -12345678;
			if (c_y != b_y) {
				bc_dx = (c_x - b_x << 8) / (c_y - b_y);
				bc_ds = (c_s - b_s << 8) / (c_y - b_y);
				if (b_y < c_y) {
					bc_start_x = b_x << 8;
					bc_start_s = b_s << 8;
					bc_start_y = b_y;
					bc_end_y = c_y;
				} else {
					bc_start_x = c_x << 8;
					bc_start_s = c_s << 8;
					bc_start_y = c_y;
					bc_end_y = b_y;
				}

				if (bc_start_y < 0) {
					bc_start_x -= bc_dx * bc_start_y;
					bc_start_s -= bc_ds * bc_start_y;
					bc_start_y = 0;
				}

				if (bc_end_y > max_y) {
					bc_end_y = max_y;
				}
			}

			min_y = ac_start_y;
			if (ab_start_y < min_y) {
				min_y = ab_start_y;
			}

			if (bc_start_y < min_y) {
				min_y = bc_start_y;
			}

			this.max_y = ac_end_y;
			if (ab_end_y > this.max_y) {
				this.max_y = ab_end_y;
			}

			if (bc_end_y > this.max_y) {
				this.max_y = bc_end_y;
			}

			int s = 0;

			for (a_ptr = min_y; a_ptr < max_y; ++a_ptr) {
				if (a_ptr >= ac_start_y && a_ptr < ac_end_y) {
					x = ac_start_x;
					start_x = ac_start_x;
					s = ac_start_s;
					start_s = ac_start_s;
					ac_start_x += ac_dx;
					ac_start_s += ac_ds;
				} else {
					start_x = 655360;
					x = -655360;
				}

				if (a_ptr >= ab_start_y && a_ptr < ab_end_y) {
					if (ab_start_x < start_x) {
						start_x = ab_start_x;
						start_s = ab_start_s;
					}

					if (ab_start_x > x) {
						x = ab_start_x;
						s = ab_start_s;
					}

					ab_start_x += ab_dx;
					ab_start_s += ab_ds;
				}

				if (a_ptr >= bc_start_y && a_ptr < bc_end_y) {
					if (bc_start_x < start_x) {
						start_x = bc_start_x;
						start_s = bc_start_s;
					}

					if (bc_start_x > x) {
						x = bc_start_x;
						s = bc_start_s;
					}

					bc_start_x += bc_dx;
					bc_start_s += bc_ds;
				}

				Scanline line = scanlines[a_ptr];
				line.start_x = start_x;
				line.end_x = x;
				line.start_s = start_s;
				line.end_s = s;
			}

			if (min_y < base_y - clip_y) {
				min_y = base_y - clip_y;
			}
		} else if (vert_cnt == 4) {
			int a_y = vert_y[0] + base_y;
			int b_y = vert_y[1] + base_y;
			int c_y = vert_y[2] + base_y;
			int d_y = vert_y[3] + base_y;
			int a_x = vert_x[0];
			int b_x = vert_x[1];
			int c_x = vert_x[2];
			int d_x = vert_x[3];
			int a_s = vert_shade[0];
			int b_s = vert_shade[1];
			int c_s = vert_shade[2];
			int d_s = vert_shade[3];
			int max_y = base_y + clip_y - 1;
			int ad_start_x = 0;
			int ad_dx = 0;
			int ad_start_s = 0;
			int ad_ds = 0;
			int ad_start_y = 12345678;
			int ad_end_y = -12345678;
			if (d_y != a_y) {
				ad_dx = (d_x - a_x << 8) / (d_y - a_y);
				ad_ds = (d_s - a_s << 8) / (d_y - a_y);
				if (a_y < d_y) {
					ad_start_x = a_x << 8;
					ad_start_s = a_s << 8;
					ad_start_y = a_y;
					ad_end_y = d_y;
				} else {
					ad_start_x = d_x << 8;
					ad_start_s = d_s << 8;
					ad_start_y = d_y;
					ad_end_y = a_y;
				}

				if (ad_start_y < 0) {
					ad_start_x -= ad_dx * ad_start_y;
					ad_start_s -= ad_ds * ad_start_y;
					ad_start_y = 0;
				}

				if (ad_end_y > max_y) {
					ad_end_y = max_y;
				}
			}

			int ab_start_x = 0;
			int ab_dx = 0;
			int ab_start_s = 0;
			int ab_ds = 0;
			int ab_start_y = 12345678;
			int ab_end_y = -12345678;
			if (b_y != a_y) {
				ab_dx = (b_x - a_x << 8) / (b_y - a_y);
				ab_ds = (b_s - a_s << 8) / (b_y - a_y);
				if (a_y < b_y) {
					ab_start_x = a_x << 8;
					ab_start_s = a_s << 8;
					ab_start_y = a_y;
					ab_end_y = b_y;
				} else {
					ab_start_x = b_x << 8;
					ab_start_s = b_s << 8;
					ab_start_y = b_y;
					ab_end_y = a_y;
				}

				if (ab_start_y < 0) {
					ab_start_x -= ab_dx * ab_start_y;
					ab_start_s -= ab_ds * ab_start_y;
					ab_start_y = 0;
				}

				if (ab_end_y > max_y) {
					ab_end_y = max_y;
				}
			}

			int bc_start_x = 0;
			int bc_dx = 0;
			int bc_start_s = 0;
			int bc_ds = 0;
			int bc_start_y = 12345678;
			int bc_end_y = -12345678;
			if (c_y != b_y) {
				bc_dx = (c_x - b_x << 8) / (c_y - b_y);
				bc_ds = (c_s - b_s << 8) / (c_y - b_y);
				if (b_y < c_y) {
					bc_start_x = b_x << 8;
					bc_start_s = b_s << 8;
					bc_start_y = b_y;
					bc_end_y = c_y;
				} else {
					bc_start_x = c_x << 8;
					bc_start_s = c_s << 8;
					bc_start_y = c_y;
					bc_end_y = b_y;
				}

				if (bc_start_y < 0) {
					bc_start_x -= bc_dx * bc_start_y;
					bc_start_s -= bc_ds * bc_start_y;
					bc_start_y = 0;
				}

				if (bc_end_y > max_y) {
					bc_end_y = max_y;
				}
			}

			int cd_start_x = 0;
			int cd_dx = 0;
			int cd_start_s = 0;
			int cd_ds = 0;
			int cd_start_y = 12345678;
			int cd_end_y = -12345678;
			if (d_y != c_y) {
				cd_dx = (d_x - c_x << 8) / (d_y - c_y);
				cd_ds = (d_s - c_s << 8) / (d_y - c_y);
				if (c_y < d_y) {
					cd_start_x = c_x << 8;
					cd_start_s = c_s << 8;
					cd_start_y = c_y;
					cd_end_y = d_y;
				} else {
					cd_start_x = d_x << 8;
					cd_start_s = d_s << 8;
					cd_start_y = d_y;
					cd_end_y = c_y;
				}

				if (cd_start_y < 0) {
					cd_start_x -= cd_dx * cd_start_y;
					cd_start_s -= cd_ds * cd_start_y;
					cd_start_y = 0;
				}

				if (cd_end_y > max_y) {
					cd_end_y = max_y;
				}
			}

			min_y = ad_start_y;
			if (ab_start_y < min_y) {
				min_y = ab_start_y;
			}

			if (bc_start_y < min_y) {
				min_y = bc_start_y;
			}

			if (cd_start_y < min_y) {
				min_y = cd_start_y;
			}

			this.max_y = ad_end_y;
			if (ab_end_y > this.max_y) {
				this.max_y = ab_end_y;
			}

			if (bc_end_y > this.max_y) {
				this.max_y = bc_end_y;
			}

			if (cd_end_y > this.max_y) {
				this.max_y = cd_end_y;
			}

			int var48 = 0;

			for (a_ptr = this.min_y; a_ptr < this.max_y; ++a_ptr) {
				if (a_ptr >= ad_start_y && a_ptr < ad_end_y) {
					x = ad_start_x;
					start_x = ad_start_x;
					var48 = ad_start_s;
					start_s = ad_start_s;
					ad_start_x += ad_dx;
					ad_start_s += ad_ds;
				} else {
					start_x = 655360;
					x = -655360;
				}

				if (a_ptr >= ab_start_y && a_ptr < ab_end_y) {
					if (ab_start_x < start_x) {
						start_x = ab_start_x;
						start_s = ab_start_s;
					}

					if (ab_start_x > x) {
						x = ab_start_x;
						var48 = ab_start_s;
					}

					ab_start_x += ab_dx;
					ab_start_s += ab_ds;
				}

				if (a_ptr >= bc_start_y && a_ptr < bc_end_y) {
					if (bc_start_x < start_x) {
						start_x = bc_start_x;
						start_s = bc_start_s;
					}

					if (bc_start_x > x) {
						x = bc_start_x;
						var48 = bc_start_s;
					}

					bc_start_x += bc_dx;
					bc_start_s += bc_ds;
				}

				if (a_ptr >= cd_start_y && a_ptr < cd_end_y) {
					if (cd_start_x < start_x) {
						start_x = cd_start_x;
						start_s = cd_start_s;
					}

					if (cd_start_x > x) {
						x = cd_start_x;
						var48 = cd_start_s;
					}

					cd_start_x += cd_dx;
					cd_start_s += cd_ds;
				}

				Scanline var49 = this.scanlines[a_ptr];
				var49.start_x = start_x;
				var49.end_x = x;
				var49.start_s = start_s;
				var49.end_s = var48;
			}

			if (this.min_y < this.base_y - this.clip_y) {
				this.min_y = this.base_y - this.clip_y;
			}
		} else {
			this.max_y = this.min_y = vert_y[0] += this.base_y;

			for (a_ptr = 1; a_ptr < vert_cnt; ++a_ptr) {
				int v_y = vert_y[a_ptr];
				if ((v_y += this.base_y) < this.min_y) {
					this.min_y = v_y;
				} else if (v_y > this.max_y) {
					this.max_y = v_y;
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
				Scanline line = scanlines[a_ptr];
				line.start_x = 655360;
				line.end_x = -655360;
			}

			int last = vert_cnt - 1;
			int u_y = vert_y[0];
			int v_y = vert_y[last];

			if (u_y < v_y) {
				int uv_start_x = vert_x[0] << 8;
				int uv_dx = (vert_x[last] - vert_x[0] << 8) / (v_y - u_y);
				int uv_start_s = vert_shade[0] << 8;
				int uv_ds = (vert_shade[last] - vert_shade[0] << 8) / (v_y - u_y);
				if (u_y < 0) {
					uv_start_x -= uv_dx * u_y;
					uv_start_s -= uv_ds * u_y;
					u_y = 0;
				}

				if (v_y > this.max_y) {
					v_y = this.max_y;
				}

				for (a_ptr = u_y; a_ptr <= v_y; ++a_ptr) {
					Scanline line = scanlines[a_ptr];
					line.start_x = line.end_x = uv_start_x;
					line.start_s = line.end_s = uv_start_s;
					uv_start_x += uv_dx;
					uv_start_s += uv_ds;
				}
			} else if (u_y > v_y) {
				int uv_start_x = vert_x[last] << 8;
				int uv_dx = (vert_x[0] - vert_x[last] << 8) / (u_y - v_y);
				int uv_start_s = vert_shade[last] << 8;
				int uv_ds = (vert_shade[0] - vert_shade[last] << 8) / (u_y - v_y);
				if (v_y < 0) {
					uv_start_x -= uv_dx * v_y;
					uv_start_s -= uv_ds * v_y;
					v_y = 0;
				}

				if (u_y > this.max_y) {
					u_y = this.max_y;
				}

				for (a_ptr = v_y; a_ptr <= u_y; ++a_ptr) {
					Scanline line = scanlines[a_ptr];
					line.start_x = line.end_x = uv_start_x;
					line.start_s = line.end_s = uv_start_s;
					uv_start_x += uv_dx;
					uv_start_s += uv_ds;
				}
			}

			for (a_ptr = 0; a_ptr < last; ++a_ptr) {
				int var14 = a_ptr + 1;
				u_y = vert_y[a_ptr];
				v_y = vert_y[var14];
				if (u_y < v_y) {
					int uv_start_x = vert_x[a_ptr] << 8;
					int uv_dx = (vert_x[var14] - vert_x[a_ptr] << 8) / (v_y - u_y);
					int uv_start_s = vert_shade[a_ptr] << 8;
					int uv_ds = (vert_shade[var14] - vert_shade[a_ptr] << 8) / (v_y - u_y);
					if (u_y < 0) {
						uv_start_x -= uv_dx * u_y;
						uv_start_s -= uv_ds * u_y;
						u_y = 0;
					}

					if (v_y > this.max_y) {
						v_y = this.max_y;
					}

					for (int i = u_y; i <= v_y; ++i) {
						Scanline line = scanlines[i];
						if (uv_start_x < line.start_x) {
							line.start_x = uv_start_x;
							line.start_s = uv_start_s;
						}

						if (uv_start_x > line.end_x) {
							line.end_x = uv_start_x;
							line.end_s = uv_start_s;
						}

						uv_start_x += uv_dx;
						uv_start_s += uv_ds;
					}
				} else if (u_y > v_y) {
					int uv_start_x = vert_x[var14] << 8;
					int uv_dx = (vert_x[a_ptr] - vert_x[var14] << 8) / (u_y - v_y);
					int uv_start_s = vert_shade[var14] << 8;
					int uv_ds = (vert_shade[a_ptr] - vert_shade[var14] << 8) / (u_y - v_y);
					if (v_y < 0) {
						uv_start_x -= uv_dx * v_y;
						uv_start_s -= uv_ds * v_y;
						v_y = 0;
					}

					if (u_y > this.max_y) {
						u_y = this.max_y;
					}

					for (int i = v_y; i <= u_y; ++i) {
						Scanline line = scanlines[i];
						if (uv_start_x < line.start_x) {
							line.start_x = uv_start_x;
							line.start_s = uv_start_s;
						}

						if (uv_start_x > line.end_x) {
							line.end_x = uv_start_x;
							line.end_s = uv_start_s;
						}

						uv_start_x += uv_dx;
						uv_start_s += uv_ds;
					}
				}
			}

			if (this.min_y < this.base_y - this.clip_y) {
				this.min_y = this.base_y - this.clip_y;
			}
		}

		if (picking_active && picked_cnt < max_picked && click_y >= min_y && click_y < max_y) {
			Scanline line = scanlines[click_y];
			
			if (click_x >= line.start_x >> 8 && click_x <= line.end_x >> 8 && line.start_x <= line.end_x && !model.unpickable && model.is_local_player[face] == 0) {
				picked_models[picked_cnt] = model;
				picked_faces[picked_cnt] = face;
				picked_cnt += 1;
			}
		}

	}

	private void rasterize(int i, int start_x, int vert_vnt, int[] vert_x, int[] vert_y, int[] vert_z, int texture, Model model) {
		if (texture >= 0) {
			if (texture >= texture_cnt) {
				texture = 0;
			}

			texture_prepare(texture);

			int a_x = vert_x[0];
			int a_y = vert_y[0];
			int a_z = vert_z[0];
			int b_x = a_x - vert_x[1];
			int b_y = a_y - vert_y[1];
			int b_z = a_z - vert_z[1];
			vert_vnt -= 1;
			int c_x = vert_x[vert_vnt] - a_x;
			int c_y = vert_y[vert_vnt] - a_y;
			int c_z = vert_z[vert_vnt] - a_z;
			
			if (texture_dim[texture] == 1) {
				int a = c_x * a_y - c_y * a_x << 12;
				int h_a = c_y * a_z - c_z * a_y << 5 - view_dist + 7 + 4;
				int v_a = c_z * a_x - c_x * a_z << 5 - view_dist + 7;
				int b = b_x * a_y - b_y * a_x << 12;
				int h_b = b_y * a_z - b_z * a_y << 5 - view_dist + 7 + 4;
				int v_b = b_z * a_x - b_x * a_z << 5 - view_dist + 7;
				int c = b_y * c_x - b_x * c_y << 5;
				int h_c = b_z * c_y - b_y * c_z << 5 - view_dist + 4;
				int v_c = b_x * c_z - b_z * c_x >> view_dist - 5;
				int _h_a = h_a >> 4;
				int _h_b = h_b >> 4;
				int _h_c = h_c >> 4;
				int off_y = min_y - base_y;
				int w = width;
				int out_ptr = base_x + min_y * w;
				int step = 1;
				a += v_a * off_y;
				b += v_b * off_y;
				c += v_c * off_y;
				
				if (reduce_lag) {
					if ((min_y & 1) == 1) {
						min_y += 1;
						a += v_a;
						b += v_b;
						c += v_c;
						out_ptr += w;
					}

					v_a <<= 1;
					v_b <<= 1;
					v_c <<= 1;
					w <<= 1;
					step = 2;
				}

				if (model.trans_texture) {
					for (i = min_y; i < max_y; i += step) {
						Scanline s = scanlines[i];
						start_x = s.start_x >> 8;
						int end_x = s.end_x >> 8;
						int dx = end_x - start_x;
						if (dx <= 0) {
							a += v_a;
							b += v_b;
							c += v_c;
							out_ptr += w;
						} else {
							int start_s = s.start_s;
							int ds = (s.end_s - start_s) / dx;
							if (start_x < -clip_x) {
								start_s += (-clip_x - start_x) * ds;
								start_x = -clip_x;
								dx = end_x - start_x;
							}

							if (end_x > clip_x) {
								end_x = clip_x;
								dx = end_x - start_x;
							}

							trans_tex1_scanline(raster, texture_pixels[texture], 0, 0,
									a + _h_a * start_x, b + _h_b * start_x, c + _h_c * start_x, h_a,
									h_b, h_c, dx, out_ptr + start_x, start_s, ds << 2);
							a += v_a;
							b += v_b;
							c += v_c;
							out_ptr += w;
						}
					}

				} else if (!texture_trans_back[texture]) {
					for (i = min_y; i < max_y; i += step) {
						Scanline s = scanlines[i];
						start_x = s.start_x >> 8;
						int end_x = s.end_x >> 8;
						int dx = end_x - start_x;
						if (dx <= 0) {
							a += v_a;
							b += v_b;
							c += v_c;
							out_ptr += w;
						} else {
							int start_s = s.start_s;
							int ds = (s.end_s - start_s) / dx;
							if (start_x < -clip_x) {
								start_s += (-clip_x - start_x) * ds;
								start_x = -clip_x;
								dx = end_x - start_x;
							}

							if (end_x > clip_x) {
								end_x = clip_x;
								dx = end_x - start_x;
							}

							tex1_scanline(raster, texture_pixels[texture], 0, 0, a + _h_a * start_x,
									b + _h_b * start_x, c + _h_c * start_x, h_a, h_b, h_c, dx,
									out_ptr + start_x, start_s, ds << 2);
							a += v_a;
							b += v_b;
							c += v_c;
							out_ptr += w;
						}
					}

				} else {
					for (i = min_y; i < max_y; i += step) {
						Scanline s = scanlines[i];
						start_x = s.start_x >> 8;
						int end_x = s.end_x >> 8;
						int dx = end_x - start_x;
						if (dx <= 0) {
							a += v_a;
							b += v_b;
							c += v_c;
							out_ptr += w;
						} else {
							int start_s = s.start_s;
							int end_s = (s.end_s - start_s) / dx;
							if (start_x < -clip_x) {
								start_s += (-clip_x - start_x) * end_s;
								start_x = -clip_x;
								dx = end_x - start_x;
							}

							if (end_x > clip_x) {
								end_x = clip_x;
								dx = end_x - start_x;
							}

							trans_back_tex1_scanline(raster, 0, 0, 0, texture_pixels[texture],
									a + _h_a * start_x, b + _h_b * start_x, c + _h_c * start_x, h_a,
									h_b, h_c, dx, out_ptr + start_x, start_s, end_s);
							a += v_a;
							b += v_b;
							c += v_c;
							out_ptr += w;
						}
					}

				}
			} else {
				int o_a = c_x * a_y - c_y * a_x << 11;
				int h_a = c_y * a_z - c_z * a_y << 5 - view_dist + 6 + 4;
				int v_a = c_z * a_x - c_x * a_z << 5 - view_dist + 6;
				int o_b = b_x * a_y - b_y * a_x << 11;
				int h_b = b_y * a_z - b_z * a_y << 5 - view_dist + 6 + 4;
				int v_b = b_z * a_x - b_x * a_z << 5 - view_dist + 6;
				int o_c = b_y * c_x - b_x * c_y << 5;
				int h_c = b_z * c_y - b_y * c_z << 5 - view_dist + 4;
				int v_c = b_x * c_z - b_z * c_x >> view_dist - 5;
				int _h_a = h_a >> 4;
				int _h_b = h_b >> 4;
				int _h_c = h_c >> 4;
				int off_y = min_y - base_y;
				int w = width;
				int out_ptr = base_x + min_y * w;
				int step = 1;
				o_a += v_a * off_y;
				o_b += v_b * off_y;
				o_c += v_c * off_y;
				if (reduce_lag) {
					if ((min_y & 1) == 1) {
						min_y += 1;
						o_a += v_a;
						o_b += v_b;
						o_c += v_c;
						out_ptr += w;
					}

					v_a <<= 1;
					v_b <<= 1;
					v_c <<= 1;
					w <<= 1;
					step = 2;
				}

				if (model.trans_texture) {
					for (i = min_y; i < max_y; i += step) {
						Scanline s = scanlines[i];
						start_x = s.start_x >> 8;
						int end_x = s.end_x >> 8;
						int dx = end_x - start_x;
						if (dx <= 0) {
							o_a += v_a;
							o_b += v_b;
							o_c += v_c;
							out_ptr += w;
						} else {
							int start_s = s.start_s;
							int ds = (s.end_s - start_s) / dx;
							if (start_x < -clip_x) {
								start_s += (-clip_x - start_x) * ds;
								start_x = -clip_x;
								dx = end_x - start_x;
							}

							if (end_x > clip_x) {
								end_x = clip_x;
								dx = end_x - start_x;
							}

							trans_tex0_scanline(raster, texture_pixels[texture], 0, 0,
									o_a + _h_a * start_x, o_b + _h_b * start_x, o_c + _h_c * start_x, h_a,
									h_b, h_c, dx, out_ptr + start_x, start_s, ds);
							o_a += v_a;
							o_b += v_b;
							o_c += v_c;
							out_ptr += w;
						}
					}

				} else if (!texture_trans_back[texture]) {
					for (i = min_y; i < max_y; i += step) {
						Scanline s = scanlines[i];
						start_x = s.start_x >> 8;
						int end_x = s.end_x >> 8;
						int dx = end_x - start_x;
						if (dx <= 0) {
							o_a += v_a;
							o_b += v_b;
							o_c += v_c;
							out_ptr += w;
						} else {
							int start_s = s.start_s;
							int ds = (s.end_s - start_s) / dx;
							if (start_x < -clip_x) {
								start_s += (-clip_x - start_x) * ds;
								start_x = -clip_x;
								dx = end_x - start_x;
							}

							if (end_x > clip_x) {
								end_x = clip_x;
								dx = end_x - start_x;
							}

							tex0_scanline(raster, texture_pixels[texture], 0, 0, o_a + _h_a * start_x,
									o_b + _h_b * start_x, o_c + _h_c * start_x, h_a, h_b, h_c, dx,
									out_ptr + start_x, start_s, ds);
							o_a += v_a;
							o_b += v_b;
							o_c += v_c;
							out_ptr += w;
						}
					}

				} else {
					for (i = min_y; i < max_y; i += step) {
						Scanline s = scanlines[i];
						start_x = s.start_x >> 8;
						int end_x = s.end_x >> 8;
						int dx = end_x - start_x;
						if (dx <= 0) {
							o_a += v_a;
							o_b += v_b;
							o_c += v_c;
							out_ptr += w;
						} else {
							int start_s = s.start_s;
							int ds = (s.end_s - start_s) / dx;
							if (start_x < -clip_x) {
								start_s += (-clip_x - start_x) * ds;
								start_x = -clip_x;
								dx = end_x - start_x;
							}

							if (end_x > clip_x) {
								end_x = clip_x;
								dx = end_x - start_x;
							}

							trans_back_tex0_scanline(raster, 0, 0, 0, texture_pixels[texture],
									o_a + _h_a * start_x, o_b + _h_b * start_x, o_c + _h_c * start_x, h_a,
									h_b, h_c, dx, out_ptr + start_x, start_s, ds);
							o_a += v_a;
							o_b += v_b;
							o_c += v_c;
							out_ptr += w;
						}
					}

				}
			}
		} else {
			for (int j = 0; j < ramp_cnt; ++j) {
				if (grad_base[j] == texture) {
					ramp = grad_ramps[j];
					break;
				}

				if (j == ramp_cnt - 1) {
					int ptr = (int) (Math.random() * (double) ramp_cnt);
					grad_base[ptr] = texture;
					texture = -1 - texture;
					int r = (texture >> 10 & 31) * 8;
					int g = (texture >> 5 & 31) * 8;
					int b = (texture & 31) * 8;

					for (int s = 0; s < 256; ++s) {
						int k = s * s;
						int dr = r * k / 65536;
						int dg = g * k / 65536;
						int db = b * k / 65536;
						grad_ramps[ptr][255 - s] = (dr << 16) + (dg << 8) + db;
					}

					ramp = grad_ramps[ptr];
				}
			}

			int w = width;
			int out_ptr = base_x + min_y * w;
			byte step = 1;
			
			if (reduce_lag) {
				if ((min_y & 1) == 1) {
					min_y += 1;
					out_ptr += w;
				}

				w <<= 1;
				step = 2;
			}

			if (model.trans) {
				for (i = min_y; i < max_y; i += step) {
					Scanline s = scanlines[i];
					start_x = s.start_x >> 8;
					int end_x = s.end_x >> 8;
					int dx = end_x - start_x;
	
					if (dx <= 0) {
						out_ptr += w;
					} else {
						int start_s = s.start_s;
						int ds = (s.end_s - start_s) / dx;
						if (start_x < -clip_x) {
							start_s += (-clip_x - start_x) * ds;
							start_x = -clip_x;
							dx = end_x - start_x;
						}

						if (end_x > clip_x) {
							end_x = clip_x;
							dx = end_x - start_x;
						}

						trans_grad1_scanline(raster, -dx, out_ptr + start_x, 0, ramp, start_s, ds);
						out_ptr += w;
					}
				}
			} else if (wide_band) {
				for (i = min_y; i < max_y; i += step) {
					Scanline s = scanlines[i];
					start_x = s.start_x >> 8;
					int end_x = s.end_x >> 8;
					int dx = end_x - start_x;
					if (dx <= 0) {
						out_ptr += w;
					} else {
						int start_s = s.start_s;
						int ds = (s.end_s - start_s) / dx;
						if (start_x < -clip_x) {
							start_s += (-clip_x - start_x) * ds;
							start_x = -clip_x;
							dx = end_x - start_x;
						}

						if (end_x > clip_x) {
							end_x = clip_x;
							dx = end_x - start_x;
						}

						grad0_scanline(raster, -dx, out_ptr + start_x, 0, ramp, start_s, ds);
						out_ptr += w;
					}
				}
			} else {
				for (i = min_y; i < max_y; i += step) {
					Scanline s = scanlines[i];
					start_x = s.start_x >> 8;
					int end_x = s.end_x >> 8;
					int dx = end_x - start_x;
					if (dx <= 0) {
						out_ptr += w;
					} else {
						int start_s = s.start_s;
						int ds = (s.end_s - start_s) / dx;
						if (start_x < -clip_x) {
							start_s += (-clip_x - start_x) * ds;
							start_x = -clip_x;
							dx = end_x - start_x;
						}

						if (end_x > clip_x) {
							end_x = clip_x;
							dx = end_x - start_x;
						}

						grad1_scanline(raster, -dx, out_ptr + start_x, 0, ramp, start_s, ds);
						out_ptr += w;
					}
				}
			}
		}
	}

	private static void tex1_scanline(int[] out, int[] in, int u, int v, int a, int b, int c, int da, int db, int dc,
			int len, int ptr, int s, int s_step) {
		if (len <= 0) {
			return;
		}
		int end_u = 0;
		int end_v = 0;
		int shadow_pow = 0;
		if (c != 0) {
			u = a / c << 7;
			v = b / c << 7;
		}

		if (u < 0) {
			u = 0;
		} else if (u > 16256) {
			u = 16256;
		}

		a += da;
		b += db;
		c += dc;
		if (c != 0) {
			end_u = a / c << 7;
			end_v = b / c << 7;
		}

		if (end_u < 0) {
			end_u = 0;
		} else if (end_u > 16256) {
			end_u = 16256;
		}

		int du = end_u - u >> 4;
		int dv = end_v - v >> 4;

		for (int var19 = len >> 4; var19 > 0; --var19) {
			u += s & 6291456;
			shadow_pow = s >> 23;
			s += s_step;
			out[ptr++] = in[(v & 16256) + (u >> 7)] >>> shadow_pow;
			u += du;
			v += dv;
			out[ptr++] = in[(v & 16256) + (u >> 7)] >>> shadow_pow;
			u += du;
			v += dv;
			out[ptr++] = in[(v & 16256) + (u >> 7)] >>> shadow_pow;
			u += du;
			v += dv;
			out[ptr++] = in[(v & 16256) + (u >> 7)] >>> shadow_pow;
			u += du;
			v += dv;
			u = (u & 16383) + (s & 6291456);
			shadow_pow = s >> 23;
			s += s_step;
			out[ptr++] = in[(v & 16256) + (u >> 7)] >>> shadow_pow;
			u += du;
			v += dv;
			out[ptr++] = in[(v & 16256) + (u >> 7)] >>> shadow_pow;
			u += du;
			v += dv;
			out[ptr++] = in[(v & 16256) + (u >> 7)] >>> shadow_pow;
			u += du;
			v += dv;
			out[ptr++] = in[(v & 16256) + (u >> 7)] >>> shadow_pow;
			u += du;
			v += dv;
			u = (u & 16383) + (s & 6291456);
			shadow_pow = s >> 23;
			s += s_step;
			out[ptr++] = in[(v & 16256) + (u >> 7)] >>> shadow_pow;
			u += du;
			v += dv;
			out[ptr++] = in[(v & 16256) + (u >> 7)] >>> shadow_pow;
			u += du;
			v += dv;
			out[ptr++] = in[(v & 16256) + (u >> 7)] >>> shadow_pow;
			u += du;
			v += dv;
			out[ptr++] = in[(v & 16256) + (u >> 7)] >>> shadow_pow;
			u += du;
			v += dv;
			u = (u & 16383) + (s & 6291456);
			shadow_pow = s >> 23;
			s += s_step;
			out[ptr++] = in[(v & 16256) + (u >> 7)] >>> shadow_pow;
			u += du;
			v += dv;
			out[ptr++] = in[(v & 16256) + (u >> 7)] >>> shadow_pow;
			u += du;
			v += dv;
			out[ptr++] = in[(v & 16256) + (u >> 7)] >>> shadow_pow;
			u += du;
			v += dv;
			out[ptr++] = in[(v & 16256) + (u >> 7)] >>> shadow_pow;
			u = end_u;
			v = end_v;
			a += da;
			b += db;
			c += dc;
			if (c != 0) {
				end_u = a / c << 7;
				end_v = b / c << 7;
			}

			if (end_u < 0) {
				end_u = 0;
			} else if (end_u > 16256) {
				end_u = 16256;
			}

			du = end_u - u >> 4;
			dv = end_v - v >> 4;
		}

		for (int var20 = 0; var20 < (len & 15); ++var20) {
			if ((var20 & 3) == 0) {
				u = (u & 16383) + (s & 6291456);
				shadow_pow = s >> 23;
				s += s_step;
			}

			out[ptr++] = in[(v & 16256) + (u >> 7)] >>> shadow_pow;
			u += du;
			v += dv;
		}
	}

	private static void trans_tex1_scanline(int[] out, int[] in, int u, int v, int a, int b, int c, int da, int db,
			int dc, int len, int ptr, int s, int s_step) {
		if (len <= 0) {
			return;
		}
		int end_u = 0;
		int end_v = 0;
		int shadow_pow = 0;
		if (c != 0) {
			u = a / c << 7;
			v = b / c << 7;
		}

		if (u < 0) {
			u = 0;
		} else if (u > 16256) {
			u = 16256;
		}

		a += da;
		b += db;
		c += dc;
		if (c != 0) {
			end_u = a / c << 7;
			end_v = b / c << 7;
		}

		if (end_u < 0) {
			end_u = 0;
		} else if (end_u > 16256) {
			end_u = 16256;
		}

		int du = end_u - u >> 4;
		int dv = end_v - v >> 4;

		for (int i = len >> 4; i > 0; --i) {
			u += s & 6291456;
			shadow_pow = s >> 23;
			s += s_step;
			out[ptr++] = (in[(v & 16256) + (u >> 7)] >>> shadow_pow) + (out[ptr] >> 1 & 8355711);
			u += du;
			v += dv;
			out[ptr++] = (in[(v & 16256) + (u >> 7)] >>> shadow_pow) + (out[ptr] >> 1 & 8355711);
			u += du;
			v += dv;
			out[ptr++] = (in[(v & 16256) + (u >> 7)] >>> shadow_pow) + (out[ptr] >> 1 & 8355711);
			u += du;
			v += dv;
			out[ptr++] = (in[(v & 16256) + (u >> 7)] >>> shadow_pow) + (out[ptr] >> 1 & 8355711);
			u += du;
			v += dv;
			u = (u & 16383) + (s & 6291456);
			shadow_pow = s >> 23;
			s += s_step;
			out[ptr++] = (in[(v & 16256) + (u >> 7)] >>> shadow_pow) + (out[ptr] >> 1 & 8355711);
			u += du;
			v += dv;
			out[ptr++] = (in[(v & 16256) + (u >> 7)] >>> shadow_pow) + (out[ptr] >> 1 & 8355711);
			u += du;
			v += dv;
			out[ptr++] = (in[(v & 16256) + (u >> 7)] >>> shadow_pow) + (out[ptr] >> 1 & 8355711);
			u += du;
			v += dv;
			out[ptr++] = (in[(v & 16256) + (u >> 7)] >>> shadow_pow) + (out[ptr] >> 1 & 8355711);
			u += du;
			v += dv;
			u = (u & 16383) + (s & 6291456);
			shadow_pow = s >> 23;
			s += s_step;
			out[ptr++] = (in[(v & 16256) + (u >> 7)] >>> shadow_pow) + (out[ptr] >> 1 & 8355711);
			u += du;
			v += dv;
			out[ptr++] = (in[(v & 16256) + (u >> 7)] >>> shadow_pow) + (out[ptr] >> 1 & 8355711);
			u += du;
			v += dv;
			out[ptr++] = (in[(v & 16256) + (u >> 7)] >>> shadow_pow) + (out[ptr] >> 1 & 8355711);
			u += du;
			v += dv;
			out[ptr++] = (in[(v & 16256) + (u >> 7)] >>> shadow_pow) + (out[ptr] >> 1 & 8355711);
			u += du;
			v += dv;
			u = (u & 16383) + (s & 6291456);
			shadow_pow = s >> 23;
			s += s_step;
			out[ptr++] = (in[(v & 16256) + (u >> 7)] >>> shadow_pow) + (out[ptr] >> 1 & 8355711);
			u += du;
			v += dv;
			out[ptr++] = (in[(v & 16256) + (u >> 7)] >>> shadow_pow) + (out[ptr] >> 1 & 8355711);
			u += du;
			v += dv;
			out[ptr++] = (in[(v & 16256) + (u >> 7)] >>> shadow_pow) + (out[ptr] >> 1 & 8355711);
			u += du;
			v += dv;
			out[ptr++] = (in[(v & 16256) + (u >> 7)] >>> shadow_pow) + (out[ptr] >> 1 & 8355711);
			u = end_u;
			v = end_v;
			a += da;
			b += db;
			c += dc;
			if (c != 0) {
				end_u = a / c << 7;
				end_v = b / c << 7;
			}

			if (end_u < 0) {
				end_u = 0;
			} else if (end_u > 16256) {
				end_u = 16256;
			}

			du = end_u - u >> 4;
			dv = end_v - v >> 4;
		}

		for (int var20 = 0; var20 < (len & 15); ++var20) {
			if ((var20 & 3) == 0) {
				u = (u & 16383) + (s & 6291456);
				shadow_pow = s >> 23;
				s += s_step;
			}

			out[ptr++] = (in[(v & 16256) + (u >> 7)] >>> shadow_pow) + (out[ptr] >> 1 & 8355711);
			u += du;
			v += dv;
		}
	}

	private static void trans_back_tex1_scanline(int[] out, int tex, int u, int v, int[] in, int a, int b, int c,
			int da, int db, int dc, int len, int ptr, int s, int s_step) {
		if (len <= 0) {
			return;
		}
		int end_u = 0;
		int end_v = 0;
		s_step <<= 2;
		if (c != 0) {
			end_u = a / c << 7;
			end_v = b / c << 7;
		}

		if (end_u < 0) {
			end_u = 0;
		} else if (end_u > 16256) {
			end_u = 16256;
		}

		for (int var19 = len; var19 > 0; var19 -= 16) {
			a += da;
			b += db;
			c += dc;
			u = end_u;
			v = end_v;
			if (c != 0) {
				end_u = a / c << 7;
				end_v = b / c << 7;
			}

			if (end_u < 0) {
				end_u = 0;
			} else if (end_u > 16256) {
				end_u = 16256;
			}

			int du = end_u - u >> 4;
			int dv = end_v - v >> 4;
			int shadow_pow = s >> 23;
			u += s & 6291456;
			s += s_step;
			if (var19 < 16) {
				for (int var21 = 0; var21 < var19; ++var21) {
					if ((tex = in[(v & 16256) + (u >> 7)] >>> shadow_pow) != 0) {
						out[ptr] = tex;
					}

					++ptr;
					u += du;
					v += dv;
					if ((var21 & 3) == 3) {
						u = (u & 16383) + (s & 6291456);
						shadow_pow = s >> 23;
						s += s_step;
					}
				}
			} else {
				if ((tex = in[(v & 16256) + (u >> 7)] >>> shadow_pow) != 0) {
					out[ptr] = tex;
				}

				++ptr;
				u += du;
				v += dv;
				if ((tex = in[(v & 16256) + (u >> 7)] >>> shadow_pow) != 0) {
					out[ptr] = tex;
				}

				++ptr;
				u += du;
				v += dv;
				if ((tex = in[(v & 16256) + (u >> 7)] >>> shadow_pow) != 0) {
					out[ptr] = tex;
				}

				++ptr;
				u += du;
				v += dv;
				if ((tex = in[(v & 16256) + (u >> 7)] >>> shadow_pow) != 0) {
					out[ptr] = tex;
				}

				++ptr;
				u += du;
				v += dv;
				u = (u & 16383) + (s & 6291456);
				shadow_pow = s >> 23;
				s += s_step;
				if ((tex = in[(v & 16256) + (u >> 7)] >>> shadow_pow) != 0) {
					out[ptr] = tex;
				}

				++ptr;
				u += du;
				v += dv;
				if ((tex = in[(v & 16256) + (u >> 7)] >>> shadow_pow) != 0) {
					out[ptr] = tex;
				}

				++ptr;
				u += du;
				v += dv;
				if ((tex = in[(v & 16256) + (u >> 7)] >>> shadow_pow) != 0) {
					out[ptr] = tex;
				}

				++ptr;
				u += du;
				v += dv;
				if ((tex = in[(v & 16256) + (u >> 7)] >>> shadow_pow) != 0) {
					out[ptr] = tex;
				}

				++ptr;
				u += du;
				v += dv;
				u = (u & 16383) + (s & 6291456);
				shadow_pow = s >> 23;
				s += s_step;
				if ((tex = in[(v & 16256) + (u >> 7)] >>> shadow_pow) != 0) {
					out[ptr] = tex;
				}

				++ptr;
				u += du;
				v += dv;
				if ((tex = in[(v & 16256) + (u >> 7)] >>> shadow_pow) != 0) {
					out[ptr] = tex;
				}

				++ptr;
				u += du;
				v += dv;
				if ((tex = in[(v & 16256) + (u >> 7)] >>> shadow_pow) != 0) {
					out[ptr] = tex;
				}

				++ptr;
				u += du;
				v += dv;
				if ((tex = in[(v & 16256) + (u >> 7)] >>> shadow_pow) != 0) {
					out[ptr] = tex;
				}

				++ptr;
				u += du;
				v += dv;
				u = (u & 16383) + (s & 6291456);
				shadow_pow = s >> 23;
				s += s_step;
				if ((tex = in[(v & 16256) + (u >> 7)] >>> shadow_pow) != 0) {
					out[ptr] = tex;
				}

				++ptr;
				u += du;
				v += dv;
				if ((tex = in[(v & 16256) + (u >> 7)] >>> shadow_pow) != 0) {
					out[ptr] = tex;
				}

				++ptr;
				u += du;
				v += dv;
				if ((tex = in[(v & 16256) + (u >> 7)] >>> shadow_pow) != 0) {
					out[ptr] = tex;
				}

				++ptr;
				u += du;
				v += dv;
				if ((tex = in[(v & 16256) + (u >> 7)] >>> shadow_pow) != 0) {
					out[ptr] = tex;
				}

				++ptr;
			}
		}
	}

	private static void tex0_scanline(int[] out, int[] in, int u, int v, int a, int b, int c, int da, int db, int dc,
			int len, int ptr, int s, int s_step) {
		if (len <= 0) {
			return;
		}
		int end_u = 0;
		int end_v = 0;
		s_step <<= 2;

		if (c != 0) {
			end_u = a / c << 6;
			end_v = b / c << 6;
		}

		if (end_u < 0) {
			end_u = 0;
		} else if (end_u > 4032) {
			end_u = 4032;
		}

		for (int j = len; j > 0; j -= 16) {
			a += da;
			b += db;
			c += dc;
			u = end_u;
			v = end_v;
			if (c != 0) {
				end_u = a / c << 6;
				end_v = b / c << 6;
			}

			if (end_u < 0) {
				end_u = 0;
			} else if (end_u > 4032) {
				end_u = 4032;
			}

			int du = end_u - u >> 4;
			int dv = end_v - v >> 4;
			int shadow_pow = s >> 20;
			u += s & 786432;
			s += s_step;

			if (j < 16) {
				for (int var20 = 0; var20 < j; ++var20) {
					out[ptr++] = in[(v & 4032) + (u >> 6)] >>> shadow_pow;
					u += du;
					v += dv;
					if ((var20 & 3) == 3) {
						u = (u & 4095) + (s & 786432);
						shadow_pow = s >> 20;
						s += s_step;
					}
				}
			} else {
				out[ptr++] = in[(v & 4032) + (u >> 6)] >>> shadow_pow;
				u += du;
				v += dv;
				out[ptr++] = in[(v & 4032) + (u >> 6)] >>> shadow_pow;
				u += du;
				v += dv;
				out[ptr++] = in[(v & 4032) + (u >> 6)] >>> shadow_pow;
				u += du;
				v += dv;
				out[ptr++] = in[(v & 4032) + (u >> 6)] >>> shadow_pow;
				u += du;
				v += dv;
				u = (u & 4095) + (s & 786432);
				shadow_pow = s >> 20;
				s += s_step;
				out[ptr++] = in[(v & 4032) + (u >> 6)] >>> shadow_pow;
				u += du;
				v += dv;
				out[ptr++] = in[(v & 4032) + (u >> 6)] >>> shadow_pow;
				u += du;
				v += dv;
				out[ptr++] = in[(v & 4032) + (u >> 6)] >>> shadow_pow;
				u += du;
				v += dv;
				out[ptr++] = in[(v & 4032) + (u >> 6)] >>> shadow_pow;
				u += du;
				v += dv;
				u = (u & 4095) + (s & 786432);
				shadow_pow = s >> 20;
				s += s_step;
				out[ptr++] = in[(v & 4032) + (u >> 6)] >>> shadow_pow;
				u += du;
				v += dv;
				out[ptr++] = in[(v & 4032) + (u >> 6)] >>> shadow_pow;
				u += du;
				v += dv;
				out[ptr++] = in[(v & 4032) + (u >> 6)] >>> shadow_pow;
				u += du;
				v += dv;
				out[ptr++] = in[(v & 4032) + (u >> 6)] >>> shadow_pow;
				u += du;
				v += dv;
				u = (u & 4095) + (s & 786432);
				shadow_pow = s >> 20;
				s += s_step;
				out[ptr++] = in[(v & 4032) + (u >> 6)] >>> shadow_pow;
				u += du;
				v += dv;
				out[ptr++] = in[(v & 4032) + (u >> 6)] >>> shadow_pow;
				u += du;
				v += dv;
				out[ptr++] = in[(v & 4032) + (u >> 6)] >>> shadow_pow;
				u += du;
				v += dv;
				out[ptr++] = in[(v & 4032) + (u >> 6)] >>> shadow_pow;
			}
		}
	}

	private static void trans_tex0_scanline(int[] out, int[] in, int u, int v, int a, int b, int c, int da, int db,
			int dc, int len, int ptr, int s, int s_step) {
		if (len <= 0) {
			return;
		}
		int end_u = 0;
		int end_v = 0;
		s_step <<= 2;

		if (c != 0) {
			end_u = a / c << 6;
			end_v = b / c << 6;
		}

		if (end_u < 0) {
			end_u = 0;
		} else if (end_u > 4032) {
			end_u = 4032;
		}

		for (int j = len; j > 0; j -= 16) {
			a += da;
			b += db;
			c += dc;
			u = end_u;
			v = end_v;
			if (c != 0) {
				end_u = a / c << 6;
				end_v = b / c << 6;
			}

			if (end_u < 0) {
				end_u = 0;
			} else if (end_u > 4032) {
				end_u = 4032;
			}

			int du = end_u - u >> 4;
			int dv = end_v - v >> 4;
			int shadow_pow = s >> 20;
			u += s & 786432;
			s += s_step;
			if (j < 16) {
				for (int var20 = 0; var20 < j; ++var20) {
					out[ptr++] = (in[(v & 4032) + (u >> 6)] >>> shadow_pow) + (out[ptr] >> 1 & 8355711);
					u += du;
					v += dv;
					if ((var20 & 3) == 3) {
						u = (u & 4095) + (s & 786432);
						shadow_pow = s >> 20;
						s += s_step;
					}
				}
			} else {
				out[ptr++] = (in[(v & 4032) + (u >> 6)] >>> shadow_pow) + (out[ptr] >> 1 & 8355711);
				u += du;
				v += dv;
				out[ptr++] = (in[(v & 4032) + (u >> 6)] >>> shadow_pow) + (out[ptr] >> 1 & 8355711);
				u += du;
				v += dv;
				out[ptr++] = (in[(v & 4032) + (u >> 6)] >>> shadow_pow) + (out[ptr] >> 1 & 8355711);
				u += du;
				v += dv;
				out[ptr++] = (in[(v & 4032) + (u >> 6)] >>> shadow_pow) + (out[ptr] >> 1 & 8355711);
				u += du;
				v += dv;
				u = (u & 4095) + (s & 786432);
				shadow_pow = s >> 20;
				s += s_step;
				out[ptr++] = (in[(v & 4032) + (u >> 6)] >>> shadow_pow) + (out[ptr] >> 1 & 8355711);
				u += du;
				v += dv;
				out[ptr++] = (in[(v & 4032) + (u >> 6)] >>> shadow_pow) + (out[ptr] >> 1 & 8355711);
				u += du;
				v += dv;
				out[ptr++] = (in[(v & 4032) + (u >> 6)] >>> shadow_pow) + (out[ptr] >> 1 & 8355711);
				u += du;
				v += dv;
				out[ptr++] = (in[(v & 4032) + (u >> 6)] >>> shadow_pow) + (out[ptr] >> 1 & 8355711);
				u += du;
				v += dv;
				u = (u & 4095) + (s & 786432);
				shadow_pow = s >> 20;
				s += s_step;
				out[ptr++] = (in[(v & 4032) + (u >> 6)] >>> shadow_pow) + (out[ptr] >> 1 & 8355711);
				u += du;
				v += dv;
				out[ptr++] = (in[(v & 4032) + (u >> 6)] >>> shadow_pow) + (out[ptr] >> 1 & 8355711);
				u += du;
				v += dv;
				out[ptr++] = (in[(v & 4032) + (u >> 6)] >>> shadow_pow) + (out[ptr] >> 1 & 8355711);
				u += du;
				v += dv;
				out[ptr++] = (in[(v & 4032) + (u >> 6)] >>> shadow_pow) + (out[ptr] >> 1 & 8355711);
				u += du;
				v += dv;
				u = (u & 4095) + (s & 786432);
				shadow_pow = s >> 20;
				s += s_step;
				out[ptr++] = (in[(v & 4032) + (u >> 6)] >>> shadow_pow) + (out[ptr] >> 1 & 8355711);
				u += du;
				v += dv;
				out[ptr++] = (in[(v & 4032) + (u >> 6)] >>> shadow_pow) + (out[ptr] >> 1 & 8355711);
				u += du;
				v += dv;
				out[ptr++] = (in[(v & 4032) + (u >> 6)] >>> shadow_pow) + (out[ptr] >> 1 & 8355711);
				u += du;
				v += dv;
				out[ptr++] = (in[(v & 4032) + (u >> 6)] >>> shadow_pow) + (out[ptr] >> 1 & 8355711);
			}
		}
	}

	private static void trans_back_tex0_scanline(int[] out, int u, int i, int v, int[] in, int a, int b, int c, int da,
			int db, int dc, int len, int ptr, int s, int s_step) {
		if (len <= 0) {
			return;
		}

		int end_u = 0;
		int end_v = 0;
		s_step <<= 2;

		if (c != 0) {
			end_u = a / c << 6;
			end_v = b / c << 6;
		}

		if (end_u < 0) {
			end_u = 0;
		} else if (end_u > 4032) {
			end_u = 4032;
		}

		for (int j = len; j > 0; j -= 16) {
			a += da;
			b += db;
			c += dc;
			i = end_u;
			v = end_v;
			if (c != 0) {
				end_u = a / c << 6;
				end_v = b / c << 6;
			}

			if (end_u < 0) {
				end_u = 0;
			} else if (end_u > 4032) {
				end_u = 4032;
			}

			int du = end_u - i >> 4;
			int dv = end_v - v >> 4;
			int shade_pow = s >> 20;
			i += s & 786432;
			s += s_step;
			if (j < 16) {
				for (int var21 = 0; var21 < j; ++var21) {
					if ((u = in[(v & 4032) + (i >> 6)] >>> shade_pow) != 0) {
						out[ptr] = u;
					}

					++ptr;
					i += du;
					v += dv;
					if ((var21 & 3) == 3) {
						i = (i & 4095) + (s & 786432);
						shade_pow = s >> 20;
						s += s_step;
					}
				}
			} else {
				if ((u = in[(v & 4032) + (i >> 6)] >>> shade_pow) != 0) {
					out[ptr] = u;
				}

				++ptr;
				i += du;
				v += dv;
				if ((u = in[(v & 4032) + (i >> 6)] >>> shade_pow) != 0) {
					out[ptr] = u;
				}

				++ptr;
				i += du;
				v += dv;
				if ((u = in[(v & 4032) + (i >> 6)] >>> shade_pow) != 0) {
					out[ptr] = u;
				}

				++ptr;
				i += du;
				v += dv;
				if ((u = in[(v & 4032) + (i >> 6)] >>> shade_pow) != 0) {
					out[ptr] = u;
				}

				++ptr;
				i += du;
				v += dv;
				i = (i & 4095) + (s & 786432);
				shade_pow = s >> 20;
				s += s_step;
				if ((u = in[(v & 4032) + (i >> 6)] >>> shade_pow) != 0) {
					out[ptr] = u;
				}

				++ptr;
				i += du;
				v += dv;
				if ((u = in[(v & 4032) + (i >> 6)] >>> shade_pow) != 0) {
					out[ptr] = u;
				}

				++ptr;
				i += du;
				v += dv;
				if ((u = in[(v & 4032) + (i >> 6)] >>> shade_pow) != 0) {
					out[ptr] = u;
				}

				++ptr;
				i += du;
				v += dv;
				if ((u = in[(v & 4032) + (i >> 6)] >>> shade_pow) != 0) {
					out[ptr] = u;
				}

				++ptr;
				i += du;
				v += dv;
				i = (i & 4095) + (s & 786432);
				shade_pow = s >> 20;
				s += s_step;
				if ((u = in[(v & 4032) + (i >> 6)] >>> shade_pow) != 0) {
					out[ptr] = u;
				}

				++ptr;
				i += du;
				v += dv;
				if ((u = in[(v & 4032) + (i >> 6)] >>> shade_pow) != 0) {
					out[ptr] = u;
				}

				++ptr;
				i += du;
				v += dv;
				if ((u = in[(v & 4032) + (i >> 6)] >>> shade_pow) != 0) {
					out[ptr] = u;
				}

				++ptr;
				i += du;
				v += dv;
				if ((u = in[(v & 4032) + (i >> 6)] >>> shade_pow) != 0) {
					out[ptr] = u;
				}

				++ptr;
				i += du;
				v += dv;
				i = (i & 4095) + (s & 786432);
				shade_pow = s >> 20;
				s += s_step;
				if ((u = in[(v & 4032) + (i >> 6)] >>> shade_pow) != 0) {
					out[ptr] = u;
				}

				++ptr;
				i += du;
				v += dv;
				if ((u = in[(v & 4032) + (i >> 6)] >>> shade_pow) != 0) {
					out[ptr] = u;
				}

				++ptr;
				i += du;
				v += dv;
				if ((u = in[(v & 4032) + (i >> 6)] >>> shade_pow) != 0) {
					out[ptr] = u;
				}

				++ptr;
				i += du;
				v += dv;
				if ((u = in[(v & 4032) + (i >> 6)] >>> shade_pow) != 0) {
					out[ptr] = u;
				}

				++ptr;
			}
		}
	}

	private static void grad0_scanline(int[] out, int len, int ptr, int col, int[] ramp, int r, int r_step) {
		if (len < 0) {
			r_step <<= 1;
			col = ramp[r >> 8 & 255];
			r += r_step;
			int init = len / 8;

			for (int i = init; i < 0; ++i) {
				out[ptr++] = col;
				out[ptr++] = col;
				col = ramp[r >> 8 & 255];
				r += r_step;
				out[ptr++] = col;
				out[ptr++] = col;
				col = ramp[r >> 8 & 255];
				r += r_step;
				out[ptr++] = col;
				out[ptr++] = col;
				col = ramp[r >> 8 & 255];
				r += r_step;
				out[ptr++] = col;
				out[ptr++] = col;
				col = ramp[r >> 8 & 255];
				r += r_step;
			}

			init = -(len % 8);

			for (int i = 0; i < init; ++i) {
				out[ptr++] = col;
				if ((i & 1) == 1) {
					col = ramp[r >> 8 & 255];
					r += r_step;
				}
			}

		}
	}

	private static void trans_grad1_scanline(int[] out, int len, int ptr, int col, int[] ramp, int r, int r_step) {
		if (len < 0) {
			r_step <<= 2;
			col = ramp[r >> 8 & 255];
			r += r_step;
			int init = len / 16;

			for (int i = init; i < 0; ++i) {
				out[ptr++] = col + (out[ptr] >> 1 & 8355711);
				out[ptr++] = col + (out[ptr] >> 1 & 8355711);
				out[ptr++] = col + (out[ptr] >> 1 & 8355711);
				out[ptr++] = col + (out[ptr] >> 1 & 8355711);
				col = ramp[r >> 8 & 255];
				r += r_step;
				out[ptr++] = col + (out[ptr] >> 1 & 8355711);
				out[ptr++] = col + (out[ptr] >> 1 & 8355711);
				out[ptr++] = col + (out[ptr] >> 1 & 8355711);
				out[ptr++] = col + (out[ptr] >> 1 & 8355711);
				col = ramp[r >> 8 & 255];
				r += r_step;
				out[ptr++] = col + (out[ptr] >> 1 & 8355711);
				out[ptr++] = col + (out[ptr] >> 1 & 8355711);
				out[ptr++] = col + (out[ptr] >> 1 & 8355711);
				out[ptr++] = col + (out[ptr] >> 1 & 8355711);
				col = ramp[r >> 8 & 255];
				r += r_step;
				out[ptr++] = col + (out[ptr] >> 1 & 8355711);
				out[ptr++] = col + (out[ptr] >> 1 & 8355711);
				out[ptr++] = col + (out[ptr] >> 1 & 8355711);
				out[ptr++] = col + (out[ptr] >> 1 & 8355711);
				col = ramp[r >> 8 & 255];
				r += r_step;
			}

			init = -(len % 16);

			for (int i = 0; i < init; ++i) {
				out[ptr++] = col + (out[ptr] >> 1 & 8355711);
				if ((i & 3) == 3) {
					col = ramp[r >> 8 & 255];
					r += r_step;
					r += r_step;
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
			for (scale = 0; norm_x > 25000 || norm_y > 25000 || norm_z > 25000 || norm_x < -25000 || norm_y < -25000
					|| norm_z < -25000; norm_z >>= 1) {
				scale += 1;
				norm_x >>= 1;
				norm_y >>= 1;
			}

			model.norm_scale[face] = scale;
			model.norm_mag[face] = (int) ((double) magnitude
					* Math.sqrt((double) (norm_x * norm_x + norm_y * norm_y + norm_z * norm_z)));
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
			raster[ptr + i] = pix - (pix >>> 3) & 0xF8F8FF;
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

				raster[off + i] = pix - (pix >>> 3) & 0xF8F8FF;
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

				var11 = this.method_406(a_x[(min_y_idx_a + 1) % cnt_a], a_y[(min_y_idx_a + 1) % cnt_a],
						a_x[min_y_idx_a], a_y[min_y_idx_a], b_y[min_y_idx_b]);
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
				var13 = this.method_406(b_x[(min_y_idx_b + 1) % cnt_b], b_y[(min_y_idx_b + 1) % cnt_b],
						b_x[min_y_idx_b], b_y[min_y_idx_b], a_y[min_y_idx_a]);
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
							var13 = this.method_406(b_x[(min_y_idx_b + 1) % cnt_b], b_y[(min_y_idx_b + 1) % cnt_b],
									b_x[min_y_idx_b], b_y[min_y_idx_b], a_y[min_y_idx_a]);
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
							var11 = this.method_406(a_x[(min_y_idx_a + 1) % cnt_a], a_y[(min_y_idx_a + 1) % cnt_a],
									a_x[min_y_idx_a], a_y[min_y_idx_a], b_y[var10]);
							var12 = this.method_406(a_x[(var8 - 1 + cnt_a) % cnt_a], a_y[(var8 - 1 + cnt_a) % cnt_a],
									a_x[var8], a_y[var8], b_y[var10]);
							var13 = this.method_406(b_x[(min_y_idx_b + 1) % cnt_b], b_y[(min_y_idx_b + 1) % cnt_b],
									b_x[min_y_idx_b], b_y[min_y_idx_b], b_y[var10]);
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
						var11 = this.method_406(a_x[(min_y_idx_a + 1) % cnt_a], a_y[(min_y_idx_a + 1) % cnt_a],
								a_x[min_y_idx_a], a_y[min_y_idx_a], b_y[min_y_idx_b]);
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
						var11 = this.method_406(a_x[(min_y_idx_a + 1) % cnt_a], a_y[(min_y_idx_a + 1) % cnt_a],
								a_x[min_y_idx_a], a_y[min_y_idx_a], b_y[var10]);
						var12 = this.method_406(a_x[(var8 - 1 + cnt_a) % cnt_a], a_y[(var8 - 1 + cnt_a) % cnt_a],
								a_x[var8], a_y[var8], b_y[var10]);
						var13 = this.method_406(b_x[(min_y_idx_b + 1) % cnt_b], b_y[(min_y_idx_b + 1) % cnt_b],
								b_x[min_y_idx_b], b_y[min_y_idx_b], b_y[var10]);
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
						var11 = this.method_406(a_x[(min_y_idx_a + 1) % cnt_a], a_y[(min_y_idx_a + 1) % cnt_a],
								a_x[min_y_idx_a], a_y[min_y_idx_a], a_y[var8]);
						var12 = a_x[var8];
						var13 = this.method_406(b_x[(min_y_idx_b + 1) % cnt_b], b_y[(min_y_idx_b + 1) % cnt_b],
								b_x[min_y_idx_b], b_y[min_y_idx_b], a_y[var8]);
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
						var11 = this.method_406(a_x[(min_y_idx_a + 1) % cnt_a], a_y[(min_y_idx_a + 1) % cnt_a],
								a_x[min_y_idx_a], a_y[min_y_idx_a], b_y[var10]);
						var12 = this.method_406(a_x[(var8 - 1 + cnt_a) % cnt_a], a_y[(var8 - 1 + cnt_a) % cnt_a],
								a_x[var8], a_y[var8], b_y[var10]);
						var13 = this.method_406(b_x[(min_y_idx_b + 1) % cnt_b], b_y[(min_y_idx_b + 1) % cnt_b],
								b_x[min_y_idx_b], b_y[min_y_idx_b], b_y[var10]);
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
					var11 = this.method_406(a_x[(min_y_idx_a + 1) % cnt_a], a_y[(min_y_idx_a + 1) % cnt_a],
							a_x[min_y_idx_a], a_y[min_y_idx_a], b_y[min_y_idx_b]);
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
					var11 = this.method_406(a_x[(min_y_idx_a + 1) % cnt_a], a_y[(min_y_idx_a + 1) % cnt_a],
							a_x[min_y_idx_a], a_y[min_y_idx_a], b_y[var10]);
					var12 = this.method_406(a_x[(var8 - 1 + cnt_a) % cnt_a], a_y[(var8 - 1 + cnt_a) % cnt_a], a_x[var8],
							a_y[var8], b_y[var10]);
					var13 = this.method_406(b_x[(min_y_idx_b + 1) % cnt_b], b_y[(min_y_idx_b + 1) % cnt_b],
							b_x[min_y_idx_b], b_y[min_y_idx_b], b_y[var10]);
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
						var13 = this.method_406(b_x[(min_y_idx_b + 1) % cnt_b], b_y[(min_y_idx_b + 1) % cnt_b],
								b_x[min_y_idx_b], b_y[min_y_idx_b], a_y[min_y_idx_a]);
						var14 = this.method_406(b_x[(var10 - 1 + cnt_b) % cnt_b], b_y[(var10 - 1 + cnt_b) % cnt_b],
								b_x[var10], b_y[var10], a_y[min_y_idx_a]);
						if (this.method_408(var13, var14, var11, !var16)) {
							return true;
						}

						return false;
					}

					var11 = this.method_406(a_x[(min_y_idx_a + 1) % cnt_a], a_y[(min_y_idx_a + 1) % cnt_a],
							a_x[min_y_idx_a], a_y[min_y_idx_a], b_y[var10]);
					var12 = this.method_406(a_x[(var8 - 1 + cnt_a) % cnt_a], a_y[(var8 - 1 + cnt_a) % cnt_a], a_x[var8],
							a_y[var8], b_y[var10]);
					var13 = this.method_406(b_x[(min_y_idx_b + 1) % cnt_b], b_y[(min_y_idx_b + 1) % cnt_b],
							b_x[min_y_idx_b], b_y[min_y_idx_b], b_y[var10]);
					var14 = b_x[var10];
					if (this.method_407(var11, var12, var13, var14, var16)) {
						return true;
					}

					var10 = (var10 + 1) % cnt_b;
					if (min_y_idx_b == var10) {
						state = 0;
					}
				} else if (b_y[min_y_idx_b] < b_y[var10]) {
					var11 = this.method_406(a_x[(min_y_idx_a + 1) % cnt_a], a_y[(min_y_idx_a + 1) % cnt_a],
							a_x[min_y_idx_a], a_y[min_y_idx_a], b_y[min_y_idx_b]);
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
					var11 = this.method_406(a_x[(min_y_idx_a + 1) % cnt_a], a_y[(min_y_idx_a + 1) % cnt_a],
							a_x[min_y_idx_a], a_y[min_y_idx_a], b_y[var10]);
					var12 = this.method_406(a_x[(var8 - 1 + cnt_a) % cnt_a], a_y[(var8 - 1 + cnt_a) % cnt_a], a_x[var8],
							a_y[var8], b_y[var10]);
					var13 = this.method_406(b_x[(min_y_idx_b + 1) % cnt_b], b_y[(min_y_idx_b + 1) % cnt_b],
							b_x[min_y_idx_b], b_y[min_y_idx_b], b_y[var10]);
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
						var11 = this.method_406(a_x[(min_y_idx_a + 1) % cnt_a], a_y[(min_y_idx_a + 1) % cnt_a],
								a_x[min_y_idx_a], a_y[min_y_idx_a], b_y[min_y_idx_b]);
						var12 = this.method_406(a_x[(var8 - 1 + cnt_a) % cnt_a], a_y[(var8 - 1 + cnt_a) % cnt_a],
								a_x[var8], a_y[var8], b_y[min_y_idx_b]);
						var13 = b_x[min_y_idx_b];
						if (this.method_408(var11, var12, var13, var16)) {
							return true;
						}

						return false;
					}

					var11 = this.method_406(a_x[(min_y_idx_a + 1) % cnt_a], a_y[(min_y_idx_a + 1) % cnt_a],
							a_x[min_y_idx_a], a_y[min_y_idx_a], a_y[var8]);
					var12 = a_x[var8];
					var13 = this.method_406(b_x[(min_y_idx_b + 1) % cnt_b], b_y[(min_y_idx_b + 1) % cnt_b],
							b_x[min_y_idx_b], b_y[min_y_idx_b], a_y[var8]);
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
					var13 = this.method_406(b_x[(min_y_idx_b + 1) % cnt_b], b_y[(min_y_idx_b + 1) % cnt_b],
							b_x[min_y_idx_b], b_y[min_y_idx_b], a_y[min_y_idx_a]);
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
					var11 = this.method_406(a_x[(min_y_idx_a + 1) % cnt_a], a_y[(min_y_idx_a + 1) % cnt_a],
							a_x[min_y_idx_a], a_y[min_y_idx_a], a_y[var8]);
					var12 = a_x[var8];
					var13 = this.method_406(b_x[(min_y_idx_b + 1) % cnt_b], b_y[(min_y_idx_b + 1) % cnt_b],
							b_x[min_y_idx_b], b_y[min_y_idx_b], a_y[var8]);
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
				var13 = this.method_406(b_x[(min_y_idx_b + 1) % cnt_b], b_y[(min_y_idx_b + 1) % cnt_b],
						b_x[min_y_idx_b], b_y[min_y_idx_b], a_y[min_y_idx_a]);
				var14 = this.method_406(b_x[(var10 - 1 + cnt_b) % cnt_b], b_y[(var10 - 1 + cnt_b) % cnt_b], b_x[var10],
						b_y[var10], a_y[min_y_idx_a]);
				if (this.method_408(var13, var14, var11, !var16)) {
					return true;
				} else {
					return false;
				}
			} else {
				var11 = this.method_406(a_x[(min_y_idx_a + 1) % cnt_a], a_y[(min_y_idx_a + 1) % cnt_a],
						a_x[min_y_idx_a], a_y[min_y_idx_a], b_y[min_y_idx_b]);
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
