package jagex.client;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;

import jagex.DataUtil;

public final class Model {
	private static final int use_gourad_shading = 12345678;
	private static final int[] sin256_tbl = new int[512];
	private static final int[] sin1024_tbl = new int[2048];
	private static final byte[] enc_tbl = new byte[64];
	private static final int[] dec_tbl = new int[256];

	static {
		for (int i = 0; i < 256; ++i) {
			sin256_tbl[i] = (int) (Math.sin((double) i * 0.02454369D) * 32768.0D);
			sin256_tbl[i + 256] = (int) (Math.cos((double) i * 0.02454369D) * 32768.0D);
		}

		for (int i = 0; i < 1024; ++i) {
			sin1024_tbl[i] = (int) (Math.sin((double) i * 0.00613592315D) * 32768.0D);
			sin1024_tbl[i + 1024] = (int) (Math.cos((double) i * 0.00613592315D) * 32768.0D);
		}

		for (int i = 0; i < 10; ++i) {
			enc_tbl[i] = (byte) (48 + i);
		}

		for (int i = 0; i < 26; ++i) {
			enc_tbl[i + 10] = (byte) (65 + i);
		}

		for (int i = 0; i < 26; ++i) {
			enc_tbl[i + 36] = (byte) (97 + i);
		}

		enc_tbl[62] = -93;
		enc_tbl[63] = 36;

		for (int i = 0; i < 10; i++) {
			dec_tbl[48 + i] = i;
		}

		for (int i = 0; i < 26; ++i) {
			dec_tbl[65 + i] = i + 10;
		}

		for (int i = 0; i < 26; ++i) {
			dec_tbl[97 + i] = i + 36;
		}

		dec_tbl[163] = 62;
		dec_tbl[36] = 63;
	}

	public int vert_cnt;
	public int[] project_vert_x;
	public int[] project_vert_y;
	public int[] project_vert_z;
	public int[] project_plane_x;
	public int[] project_plane_y;
	public int[] vert_shade;
	public byte[] vert_ambient;
	public int face_cnt;
	public int[] face_vert_cnt;
	public int[][] face_verts;
	public int[] texture_front;
	public int[] texture_back;
	public int[] norm_mag;
	public int[] norm_scale;
	public int[] light_type;
	public int[] face_norm_x;
	public int[] face_norm_y;
	public int[] face_norm_z;
	public int field_278;
	public int depth;
	public int trans_state;
	public boolean visible;
	public int min_x;
	public int max_x;
	public int min_y;
	public int max_y;
	public int min_z;
	public int max_z;
	public boolean field_288;
	public boolean trans_texture;
	public boolean trans;
	public int field_291;
	public int[] face_pick_tag;
	public byte[] is_local_player;
	private boolean autocommit;
	public boolean no_bounds;
	public boolean no_shading;
	public boolean unpickable;
	public boolean unrendered;
	public int max_vert_cnt;
	public int[] vert_x;
	public int[] vert_y;
	public int[] vert_z;
	public int[] trans_vert_x;
	public int[] trans_vert_y;
	public int[] trans_vert_z;
	private int max_face_cnt;
	private int[][] field_313;
	private int[] face_min_x;
	private int[] face_max_x;
	private int[] face_min_y;
	private int[] face_max_y;
	private int[] face_min_z;
	private int[] face_max_z;
	private int base_x;
	private int base_y;
	private int base_z;
	private int yaw;
	private int pitch;
	private int roll;
	private int scale_x;
	private int scale_y;
	private int scale_z;
	private int shear_xy;
	private int shear_zy;
	private int shear_xz;
	private int shear_yz;
	private int shear_zx;
	private int shear_yx;
	private int trans_type;
	private int max_dim;
	private int light_x;
	private int light_y;
	private int light_z;
	private int light_mag;
	protected int light_falloff;
	protected int light_ambient;
	private int buf_ptr;

	public Model(int vert_cnt, int face_cnt) {
		trans_state = 1;
		visible = true;
		field_288 = true;
		trans_texture = false;
		trans = false;
		field_291 = -1;
		autocommit = false;
		no_bounds = false;
		no_shading = false;
		unpickable = false;
		unrendered = false;
		max_dim = 12345678;
		light_x = 180;
		light_y = 155;
		light_z = 95;
		light_mag = 256;
		light_falloff = 512;
		light_ambient = 32;
		allocate(vert_cnt, face_cnt);
		field_313 = new int[face_cnt][1];

		for (int i = 0; i < face_cnt; i++) {
			field_313[i][0] = i;
		}
	}

	public Model(int vert_cnt, int face_cnt, boolean autocommit, boolean no_bounds, boolean no_shading, boolean unpickable, boolean unrendered) {
		trans_state = 1;
		visible = true;
		field_288 = true;
		trans_texture = false;
		trans = false;
		field_291 = -1;
		max_dim = 12345678;
		light_x = 180;
		light_y = 155;
		light_z = 95;
		light_mag = 256;
		light_falloff = 512;
		light_ambient = 32;
		this.autocommit = autocommit;
		this.no_bounds = no_bounds;
		this.no_shading = no_shading;
		this.unpickable = unpickable;
		this.unrendered = unrendered;
		allocate(vert_cnt, face_cnt);
	}
	
	public Model(byte[] buf, int buf_ptr, boolean var3) {
		trans_state = 1;
		visible = true;
		field_288 = true;
		trans_texture = false;
		trans = false;
		field_291 = -1;
		autocommit = false;
		no_bounds = false;
		no_shading = false;
		unpickable = false;
		unrendered = false;
		max_dim = 12345678;
		light_x = 180;
		light_y = 155;
		light_z = 95;
		light_mag = 256;
		light_falloff = 512;
		light_ambient = 32;
		
		int vert_cnt = DataUtil.short_get(buf, buf_ptr);
		buf_ptr += 2;
		int face_cnt = DataUtil.short_get(buf, buf_ptr);
		buf_ptr += 2;
		
		allocate(vert_cnt, face_cnt);
		field_313 = new int[face_cnt][1];

		for (int i = 0; i < vert_cnt; ++i) {
			vert_x[i] = DataUtil.method_8(buf, buf_ptr);
			buf_ptr += 2;
		}

		for (int i = 0; i < vert_cnt; ++i) {
			vert_y[i] = DataUtil.method_8(buf, buf_ptr);
			buf_ptr += 2;
		}

		for (int i = 0; i < vert_cnt; ++i) {
			vert_z[i] = DataUtil.method_8(buf, buf_ptr);
			buf_ptr += 2;
		}

		this.vert_cnt = vert_cnt;

		for (int i = 0; i < face_cnt; ++i) {
			face_vert_cnt[i] = buf[buf_ptr++] & 255;
		}

		for (int i = 0; i < face_cnt; ++i) {
			texture_front[i] = DataUtil.method_8(buf, buf_ptr);
			buf_ptr += 2;

			if (texture_front[i] == 32767) {
				texture_front[i] = use_gourad_shading;
			}
		}

		for (int i = 0; i < face_cnt; ++i) {
			texture_back[i] = DataUtil.method_8(buf, buf_ptr);
			buf_ptr += 2;
	
			if (texture_back[i] == 32767) {
				texture_back[i] = use_gourad_shading;
			}
		}

		for (int i = 0; i < face_cnt; ++i) {
			int type = buf[buf_ptr++] & 255;

			if (type == 0) {
				light_type[i] = 0;
			} else {
				light_type[i] = use_gourad_shading;
			}
		}

		for (int i = 0; i < face_cnt; ++i) {
			face_verts[i] = new int[face_vert_cnt[i]];

			for (int j = 0; j < face_vert_cnt[i]; ++j) {
				if (vert_cnt < 256) {
					face_verts[i][j] = buf[buf_ptr++] & 255;
				} else {
					face_verts[i][j] = DataUtil.short_get(buf, buf_ptr);
					buf_ptr += 2;
				}
			}
		}

		this.face_cnt = face_cnt;
		trans_state = 1;
	}

	public Model(byte[] b64_buf, int buf_ptr) {
		trans_state = 1;
		visible = true;
		field_288 = true;
		trans_texture = false;
		trans = false;
		field_291 = -1;
		autocommit = false;
		no_bounds = false;
		no_shading = false;
		unpickable = false;
		unrendered = false;
		max_dim = 12345678;
		light_x = 180;
		light_y = 155;
		light_z = 95;
		light_mag = 256;
		light_falloff = 512;
		light_ambient = 32;
		this.buf_ptr = buf_ptr;
		
		base64_get(b64_buf);
		
		int vert_cnt = base64_get(b64_buf);
		int face_cnt = base64_get(b64_buf);
		
		allocate(vert_cnt, face_cnt);
		
		field_313 = new int[face_cnt][];

		for (int i = 0; i < vert_cnt; ++i) {
			int x = base64_get(b64_buf);
			int y = base64_get(b64_buf);
			int z = base64_get(b64_buf);
			vert_get(x, y, z);
		}

		for (int i = 0; i < face_cnt; ++i) {
			int _vert_cnt = base64_get(b64_buf);
			int front = base64_get(b64_buf);
			int back = base64_get(b64_buf);
			int var11 = base64_get(b64_buf);
			
			light_falloff = base64_get(b64_buf);
			light_ambient = base64_get(b64_buf);
			
			int type = base64_get(b64_buf);
			int[] _vert = new int[_vert_cnt];

			for (int j = 0; j < _vert_cnt; ++j) {
				_vert[j] = base64_get(b64_buf);
			}

			int[] var17 = new int[var11];

			for (int j = 0; j < var11; ++j) {
				var17[j] = base64_get(b64_buf);
			}

			int face = face_add(_vert_cnt, _vert, front, back);
			field_313[i] = var17;
	
			if (type == 0) {
				light_type[face] = 0;
			} else {
				light_type[face] = use_gourad_shading;
			}
		}

		trans_state = 1;
	}

	public Model(String file) {
		trans_state = 1;
		visible = true;
		field_288 = true;
		trans_texture = false;
		trans = false;
		field_291 = -1;
		autocommit = false;
		no_bounds = false;
		no_shading = false;
		unpickable = false;
		unrendered = false;
		max_dim = 12345678;
		light_x = 180;
		light_y = 155;
		light_z = 95;
		light_mag = 256;
		light_falloff = 512;
		light_ambient = 32;

		byte[] buf;
		try {
			InputStream in = DataUtil.open_stream(file);
			DataInputStream stream = new DataInputStream(in);
			buf = new byte[3];
			buf_ptr = 0;
			int read = 0;

			while (true) {
				if (read >= 3) {
					int size = base64_get(buf);
					buf = new byte[size];
					buf_ptr = 0;
					read = 0;
					
					while (read < size) {
						read += stream.read(buf,  read, size - read);
					}

					stream.close();
					break;
				}

				read += stream.read(buf, read, 3 - read);
			}
		} catch (IOException error) {
			vert_cnt = 0;
			face_cnt = 0;
			return;
		}

		int vert_cnt = base64_get(buf);
		int face_cnt = base64_get(buf);

		allocate(vert_cnt, face_cnt);
		field_313 = new int[face_cnt][];

		for (int i = 0; i < vert_cnt; ++i) {
			int x = base64_get(buf);
			int y = base64_get(buf);
			int z = base64_get(buf);
			vert_get(x, y, z);
		}

		for (int i = 0; i < face_cnt; ++i) {
			int _vert_cnt = base64_get(buf);
			int front = base64_get(buf);
			int back = base64_get(buf);
			int var13 = base64_get(buf);
			light_falloff = base64_get(buf);
			light_ambient = base64_get(buf);
			int type = base64_get(buf);
			int[] _verts = new int[_vert_cnt];

			for (int j = 0; j < _vert_cnt; ++j) {
				_verts[j] = base64_get(buf);
			}

			int[] var19 = new int[var13];

			for (int j = 0; j < var13; ++j) {
				var19[j] = base64_get(buf);
			}

			int face = face_add(_vert_cnt, _verts, front, back);
			field_313[i] = var19;

			if (type == 0) {
				light_type[face] = 0;
			} else {
				light_type[face] = use_gourad_shading;
			}
		}

		trans_state = 1;
	}

	public Model(Model[] parts, int size, boolean autocommit, boolean no_bounds, boolean no_shading, boolean unpickable) {
		trans_state = 1;
		visible = true;
		field_288 = true;
		trans_texture = false;
		trans = false;
		field_291 = -1;
		unrendered = false;
		max_dim = 12345678;
		light_x = 180;
		light_y = 155;
		light_z = 95;
		light_mag = 256;
		light_falloff = 512;
		light_ambient = 32;
		this.autocommit = autocommit;
		this.no_bounds = no_bounds;
		this.no_shading = no_shading;
		this.unpickable = unpickable;
		join(parts, size, false);
	}

	public Model(Model[] parts, int size) {
		trans_state = 1;
		visible = true;
		field_288 = true;
		trans_texture = false;
		trans = false;
		field_291 = -1;
		autocommit = false;
		no_bounds = false;
		no_shading = false;
		unpickable = false;
		unrendered = false;
		max_dim = 12345678;
		light_x = 180;
		light_y = 155;
		light_z = 95;
		light_mag = 256;
		light_falloff = 512;
		light_ambient = 32;
		join(parts, size, true);
	}

	private void allocate(int vert_cnt, int face_cnt) {
		vert_x = new int[vert_cnt];
		vert_y = new int[vert_cnt];
		vert_z = new int[vert_cnt];
		vert_shade = new int[vert_cnt];
		vert_ambient = new byte[vert_cnt];
		face_vert_cnt = new int[face_cnt];
		face_verts = new int[face_cnt][];
		texture_front = new int[face_cnt];
		texture_back = new int[face_cnt];
		light_type = new int[face_cnt];
		norm_scale = new int[face_cnt];
		norm_mag = new int[face_cnt];
		
		if (!unrendered) {
			project_vert_x = new int[vert_cnt];
			project_vert_y = new int[vert_cnt];
			project_vert_z = new int[vert_cnt];
			project_plane_x = new int[vert_cnt];
			project_plane_y = new int[vert_cnt];
		}

		if (!unpickable) {
			is_local_player = new byte[face_cnt];
			face_pick_tag = new int[face_cnt];
		}

		if (autocommit) {
			trans_vert_x = vert_x;
			trans_vert_y = vert_y;
			trans_vert_z = vert_z;
		} else {
			trans_vert_x = new int[vert_cnt];
			trans_vert_y = new int[vert_cnt];
			trans_vert_z = new int[vert_cnt];
		}

		if (!no_shading || !no_bounds) {
			face_norm_x = new int[face_cnt];
			face_norm_y = new int[face_cnt];
			face_norm_z = new int[face_cnt];
		}

		if (!no_bounds) {
			face_min_x = new int[face_cnt];
			face_max_x = new int[face_cnt];
			face_min_y = new int[face_cnt];
			face_max_y = new int[face_cnt];
			face_min_z = new int[face_cnt];
			face_max_z = new int[face_cnt];
		}

		face_cnt = 0;
		vert_cnt = 0;
		max_vert_cnt = vert_cnt;
		max_face_cnt = face_cnt;
		base_x = base_y = base_z = 0;
		yaw = pitch = roll = 0;
		scale_x = scale_y = scale_z = 256;
		shear_xy = shear_zy = shear_xz = shear_yz = shear_zx = shear_yx = 256;
		trans_type = 0;
	}

	public void project_prepare() {
		project_vert_x = new int[vert_cnt];
		project_vert_y = new int[vert_cnt];
		project_vert_z = new int[vert_cnt];
		project_plane_x = new int[vert_cnt];
		project_plane_y = new int[vert_cnt];
	}

	public void clear() {
		face_cnt = 0;
		vert_cnt = 0;
	}

	public void reduce(int faces, int verts) {
		face_cnt -= faces;
		
		if (face_cnt < 0) {
			face_cnt = 0;
		}

		vert_cnt -= verts;
		
		if (vert_cnt < 0) {
			vert_cnt = 0;
		}
	}

	public void join(Model[] parts, int size, boolean flag) {
		int face_cnt = 0;
		int vert_cnt = 0;

		for (int var6 = 0; var6 < size; ++var6) {
			face_cnt += parts[var6].face_cnt;
			vert_cnt += parts[var6].vert_cnt;
		}

		allocate(vert_cnt, face_cnt);

		if (flag) {
			field_313 = new int[face_cnt][];
		}

		for (int i = 0; i < size; ++i) {
			Model part = parts[i];
			part.commit();
	
			light_ambient = part.light_ambient;
			light_falloff = part.light_falloff;
			light_x = part.light_x;
			light_y = part.light_y;
			light_z = part.light_z;
			light_mag = part.light_mag;

			for (int j = 0; j < part.face_cnt; ++j) {
				int[] joined_verts = new int[part.face_vert_cnt[j]];
				int[] part_verts = part.face_verts[j];

				for (int k = 0; k < part.face_vert_cnt[j]; ++k) {
					joined_verts[k] = vert_get(part.vert_x[part_verts[k]], part.vert_y[part_verts[k]], part.vert_z[part_verts[k]]);
				}

				int face = face_add(part.face_vert_cnt[j], joined_verts, part.texture_front[j], part.texture_back[j]);

				light_type[face] = part.light_type[j];
				norm_scale[face] = part.norm_scale[j];
				norm_mag[face] = part.norm_mag[j];

				if (flag) {
					if (size > 1) {
						field_313[face] = new int[part.field_313[j].length + 1];
						field_313[face][0] = i;

						for (int k = 0; k < part.field_313[j].length; ++k) {
							field_313[face][k + 1] = part.field_313[j][k];
						}
					} else {
						field_313[face] = new int[part.field_313[j].length];

						for (int k = 0; k < part.field_313[j].length; ++k) {
							field_313[face][k] = part.field_313[j][k];
						}
					}
				}
			}
		}

		trans_state = 1;
	}

	public int vert_get(int x, int y, int z) {
		for (int i = 0; i < vert_cnt; ++i) {
			if (vert_x[i] == x && vert_y[i] == y && vert_z[i] == z) {
				return i;
			}
		}

		if (vert_cnt >= max_vert_cnt) {
			return -1;
		} else {
			vert_x[vert_cnt] = x;
			vert_y[vert_cnt] = y;
			vert_z[vert_cnt] = z;
			return vert_cnt++;
		}
	}

	public int vert_add(int x, int y, int z) {
		if (vert_cnt >= max_vert_cnt) {
			return -1;
		} else {
			vert_x[vert_cnt] = x;
			vert_y[vert_cnt] = y;
			vert_z[vert_cnt] = z;
			return vert_cnt++;
		}
	}

	public int face_add(int vert_cnt, int[] verts, int front, int back) {
		if (face_cnt >= max_face_cnt) {
			return -1;
		} else {
			face_vert_cnt[face_cnt] = vert_cnt;
			face_verts[face_cnt] = verts;
			texture_front[face_cnt] = front;
			texture_back[face_cnt] = back;
			trans_state = 1;
			return face_cnt++;
		}
	}

	public Model[] split(int bound_a, int bound_b, int row, int cnt, int max_verts, boolean unpickable) {
		commit();

		int[] vert_cnt = new int[cnt];
		int[] verts = new int[cnt];

		for (int i = 0; i < cnt; ++i) {
			vert_cnt[i] = 0;
			verts[i] = 0;
		}

		for (int i = 0; i < face_cnt; ++i) {
			int sum_x = 0;
			int sum_z = 0;
			int _vert_cnt = face_vert_cnt[i];
			int[] _verts = face_verts[i];

			for (int j = 0; j < _vert_cnt; ++j) {
				sum_x += vert_x[_verts[j]];
				sum_z += vert_z[_verts[j]];
			}

			int idx = sum_x / (_vert_cnt * bound_a) + sum_z / (_vert_cnt * bound_b) * row;
			vert_cnt[idx] += _vert_cnt;
			verts[idx] += 1;
		}

		Model[] parts = new Model[cnt];

		for (int i = 0; i < cnt; ++i) {
			if (vert_cnt[i] > max_verts) {
				vert_cnt[i] = max_verts;
			}

			parts[i] = new Model(vert_cnt[i], verts[i], true, true, true, unpickable, true);
			parts[i].light_falloff = light_falloff;
			parts[i].light_ambient = light_ambient;
		}

		for (int i = 0; i < face_cnt; ++i) {
			int sum_x = 0;
			int sum_z = 0;
			int _vert_cnt = face_vert_cnt[i];
			int[] _verts = face_verts[i];

			for (int j = 0; j < _vert_cnt; ++j) {
				sum_x += vert_x[_verts[j]];
				sum_z += vert_z[_verts[j]];
			}

			int idx = sum_x / (_vert_cnt * bound_a) + sum_z / (_vert_cnt * bound_b) * row;
			copy_face(parts[idx], _verts, _vert_cnt, i);
		}

		for (int i = 0; i < cnt; ++i) {
			parts[i].project_prepare();
		}

		return parts;
	}

	public void copy_face(Model other, int[] verts, int vert_cnt, int face) {
		int[] dverts = new int[vert_cnt];

		for (int i = 0; i < vert_cnt; ++i) {
			int dvert = dverts[i] = other.vert_get(vert_x[verts[i]], vert_y[verts[i]], vert_z[verts[i]]);
			other.vert_shade[dvert] = vert_shade[verts[i]];
			other.vert_ambient[dvert] = vert_ambient[verts[i]];
		}

		int dface = other.face_add(vert_cnt, dverts, texture_front[face], texture_back[face]);
	
		if (!other.unpickable && !unpickable) {
			other.face_pick_tag[dface] = face_pick_tag[face];
		}

		other.light_type[dface] = light_type[face];
		other.norm_scale[dface] = norm_scale[face];
		other.norm_mag[dface] = norm_mag[face];
	}

	public void set_light(boolean gourad, int ambient, int falloff, int light_x, int light_y, int light_z) {
		light_ambient = 256 - ambient * 4;
		light_falloff = (64 - falloff) * 16 + 128;
		
		if (!no_shading) {
			for (int i = 0; i < face_cnt; ++i) {
				if (gourad) {
					light_type[i] = use_gourad_shading;
				} else {
					light_type[i] = 0;
				}
			}

			this.light_x = light_x;
			this.light_y = light_y;
			this.light_z = light_z;
			light_mag = (int) Math.sqrt((double) (light_x * light_x + light_y * light_y + light_z * light_z));
			calc_shading();
		}
	}

	public void set_light(int ambient, int falloff, int light_x, int light_y, int light_z) {
		light_ambient = 256 - ambient * 4;
		light_falloff = (64 - falloff) * 16 + 128;
	
		if (!no_shading) {
			this.light_x = light_x;
			this.light_y = light_y;
			this.light_z = light_z;
			light_mag = (int) Math.sqrt((double) (light_x * light_x + light_y * light_y + light_z * light_z));
			calc_shading();
		}
	}

	public void set_light(int light_x, int light_y, int light_z) {
		if (!no_shading) {
			this.light_x = light_x;
			this.light_y = light_y;
			this.light_z = light_z;
			light_mag = (int) Math.sqrt((double) (light_x * light_x + light_y * light_y + light_z * light_z));
			calc_shading();
		}
	}

	public void set_vert_ambient(int vert, int value) {
		vert_ambient[vert] = (byte) value;
	}

	public void rotate(int yaw, int pitch, int roll) {
		this.yaw = this.yaw + yaw & 255;
		this.pitch = this.pitch + pitch & 255;
		this.roll = this.roll + roll & 255;
		
		determine_trans();
		trans_state = 1;
	}

	public void orient(int yaw, int pitch, int roll) {
		this.yaw = yaw & 255;
		this.pitch = pitch & 255;
		this.roll = roll & 255;
		
		determine_trans();
		trans_state = 1;
	}

	public void translate(int x, int y, int z) {
		base_x += x;
		base_y += y;
		base_z += z;
		determine_trans();
		trans_state = 1;
	}

	public void position(int x, int y, int z) {
		base_x = x;
		base_y = y;
		base_z = z;
		determine_trans();
		trans_state = 1;
	}

	public int base_x() {
		return base_x;
	}

	public void scale(int x, int y, int z) {
		scale_x = x;
		scale_y = y;
		scale_z = z;
		determine_trans();
		trans_state = 1;
	}

	public void shear(int xy, int zy, int xz, int yz, int zx, int yx) {
		shear_xy = xy;
		shear_zy = zy;
		shear_xz = xz;
		shear_yz = yz;
		shear_zx = zx;
		shear_yx = yx;
		determine_trans();
		trans_state = 1;
	}

	private void determine_trans() {
		if ((shear_xy != 256) || (shear_zy != 256)
				|| (shear_xz != 256) || (shear_yz != 256)
				|| (shear_zx != 256) || (shear_yx != 256)) {
			trans_type = 4;
			return;
		}
		if ((scale_x != 256) || (scale_y != 256) || (scale_z != 256)) {
			trans_type = 3;
			return;
		}
		if ((yaw != 0) || (pitch != 0) || (roll != 0)) {
			trans_type = 2;
			return;
		}
		if ((base_x != 0) || (base_y != 0) || (base_z != 0)) {
			trans_type = 1;
			return;
		}
		trans_type = 0;
	}

	private void translate_apply(int x, int y, int z) {
		for (int i = 0; i < vert_cnt; ++i) {
			trans_vert_x[i] += x;
			trans_vert_y[i] += y;
			trans_vert_z[i] += z;
		}
	}

	private void rotate_apply(int x, int y, int z) {
		for (int i = 0; i < vert_cnt; ++i) {
			if (z != 0) {
				int sin = sin256_tbl[z];
				int cos = sin256_tbl[z + 256];
				int vert = trans_vert_y[i] * sin + trans_vert_x[i] * cos >> 15;
				trans_vert_y[i] = trans_vert_y[i] * cos - trans_vert_x[i] * sin >> 15;
				trans_vert_x[i] = vert;
			}

			if (x != 0) {
				int sin = sin256_tbl[x];
				int cos = sin256_tbl[x + 256];
				int vert = trans_vert_y[i] * cos - trans_vert_z[i] * sin >> 15;
				trans_vert_z[i] = trans_vert_y[i] * sin + trans_vert_z[i] * cos >> 15;
				trans_vert_y[i] = vert;
			}

			if (y != 0) {
				int sin = sin256_tbl[y];
				int cos = sin256_tbl[y + 256];
				int vert = trans_vert_z[i] * sin + trans_vert_x[i] * cos >> 15;
				trans_vert_z[i] = trans_vert_z[i] * cos - trans_vert_x[i] * sin >> 15;
				trans_vert_x[i] = vert;
			}
		}
	}

	private void shear_apply(int xy, int zy, int xz, int yz, int zx, int yx) {
		for (int i = 0; i < vert_cnt; ++i) {
			if (xy != 0) {
				trans_vert_x[i] += trans_vert_y[i] * xy >> 8;
			}

			if (zy != 0) {
				trans_vert_z[i] += trans_vert_y[i] * zy >> 8;
			}

			if (xz != 0) {
				trans_vert_x[i] += trans_vert_z[i] * xz >> 8;
			}

			if (yz != 0) {
				trans_vert_y[i] += trans_vert_z[i] * yz >> 8;
			}

			if (zx != 0) {
				trans_vert_z[i] += trans_vert_x[i] * zx >> 8;
			}

			if (yx != 0) {
				trans_vert_y[i] += trans_vert_x[i] * yx >> 8;
			}
		}
	}

	private void scale_apply(int x, int y, int z) {
		for (int i = 0; i < vert_cnt; ++i) {
			trans_vert_x[i] = trans_vert_x[i] * x >> 8;
			trans_vert_y[i] = trans_vert_y[i] * y >> 8;
			trans_vert_z[i] = trans_vert_z[i] * z >> 8;
		}
	}

	private void calc_bounds() {
		min_x = min_y = min_z = 999999;
		max_dim = max_x = max_y = max_z = -999999;

		for (int i = 0; i < face_cnt; ++i) {
			int[] face_v = face_verts[i];
			int vert = face_v[0];
			int face_v_cnt = face_vert_cnt[i];
			int _min_x;
			int _max_x = _min_x = trans_vert_x[vert];
			int _min_y;
			int _max_y = _min_y = trans_vert_y[vert];
			int _min_z;
			int _max_z = _min_z = trans_vert_z[vert];

			for (int j = 0; j < face_v_cnt; ++j) {
				vert = face_v[j];
				if (trans_vert_x[vert] < _min_x) {
					_min_x = trans_vert_x[vert];
				} else if (trans_vert_x[vert] > _max_x) {
					_max_x = trans_vert_x[vert];
				}

				if (trans_vert_y[vert] < _min_y) {
					_min_y = trans_vert_y[vert];
				} else if (trans_vert_y[vert] > _max_y) {
					_max_y = trans_vert_y[vert];
				}

				if (trans_vert_z[vert] < _min_z) {
					_min_z = trans_vert_z[vert];
				} else if (trans_vert_z[vert] > _max_z) {
					_max_z = trans_vert_z[vert];
				}
			}

			if (!no_bounds) {
				face_min_x[i] = _min_x;
				face_max_x[i] = _max_x;
				face_min_y[i] = _min_y;
				face_max_y[i] = _max_y;
				face_min_z[i] = _min_z;
				face_max_z[i] = _max_z;
			}

			if (_max_x - _min_x > max_dim) {
				max_dim = _max_x - _min_x;
			}

			if (_max_y - _min_y > max_dim) {
				max_dim = _max_y - _min_y;
			}

			if (_max_z - _min_z > max_dim) {
				max_dim = _max_z - _min_z;
			}

			if (_min_x < min_x) {
				min_x = _min_x;
			}

			if (_max_x > max_x) {
				max_x = _max_x;
			}

			if (_min_y < min_y) {
				min_y = _min_y;
			}

			if (_max_y > max_y) {
				max_y = _max_y;
			}

			if (_min_z < min_z) {
				min_z = _min_z;
			}

			if (_max_z > max_z) {
				max_z = _max_z;
			}
		}
	}

	public void calc_shading() {
		if (!no_shading) {
			int radiometry = light_falloff * light_mag >> 8;

			for (int i = 0; i < face_cnt; ++i) {
				if (light_type[i] != use_gourad_shading) {
					light_type[i] = (face_norm_x[i] * light_x	+ face_norm_y[i] * light_y + face_norm_z[i] * light_z) / radiometry;
				}
			}

			int[] x = new int[vert_cnt];
			int[] y = new int[vert_cnt];
			int[] z = new int[vert_cnt];
			int[] cnt = new int[vert_cnt];

			for (int i = 0; i < vert_cnt; ++i) {
				x[i] = 0;
				y[i] = 0;
				z[i] = 0;
				cnt[i] = 0;
			}

			for (int i = 0; i < face_cnt; ++i) {
				if (light_type[i] == use_gourad_shading) {
					for (int j = 0; j < face_vert_cnt[i]; ++j) {
						int vert = face_verts[i][j];
						x[vert] += face_norm_x[i];
						y[vert] += face_norm_y[i];
						z[vert] += face_norm_z[i];
						cnt[vert] += 1;
					}
				}
			}

			for (int i = 0; i < vert_cnt; ++i) {
				if (cnt[i] > 0) {
					vert_shade[i] = (x[i] * light_x + y[i] * light_y + z[i] * light_z) / (radiometry * cnt[i]);
				}
			}
		}
	}

	public void calc_norms() {
		if (no_shading && no_bounds) {
			return;
		}
		
		for (int i = 0; i < face_cnt; ++i) {
			int[] face_v = face_verts[i];
			int face_vx = trans_vert_x[face_v[0]];
			int face_vy = trans_vert_y[face_v[0]];
			int face_vz = trans_vert_z[face_v[0]];
			int d_vx = trans_vert_x[face_v[1]] - face_vx;
			int d_vy = trans_vert_y[face_v[1]] - face_vy;
			int d_vz = trans_vert_z[face_v[1]] - face_vz;
			int _d_vx = trans_vert_x[face_v[2]] - face_vx;
			int _d_vy = trans_vert_y[face_v[2]] - face_vy;
			int _d_vz = trans_vert_z[face_v[2]] - face_vz;
			int norm_x = d_vy * _d_vz - _d_vy * d_vz;
			int norm_y = d_vz * _d_vx - _d_vz * d_vx;

			int norm_z;
			for (norm_z = d_vx * _d_vy - _d_vx * d_vy; norm_x > 8192 || norm_y > 8192 || norm_z > 8192 || norm_x < -8192
					|| norm_y < -8192 || norm_z < -8192; norm_z >>= 1) {
				norm_x >>= 1;
				norm_y >>= 1;
			}

			int mag = (int) (256.0D * Math.sqrt((double) (norm_x * norm_x + norm_y * norm_y + norm_z * norm_z)));
			if (mag <= 0) {
				mag = 1;
			}

			face_norm_x[i] = norm_x * 65536 / mag;
			face_norm_y[i] = norm_y * 65536 / mag;
			face_norm_z[i] = norm_z * 65536 / mag;
			norm_scale[i] = -1;
		}

		calc_shading();
	}


	public void trans_apply() {
		if (trans_state == 2) {
			trans_state = 0;

			for (int i = 0; i < vert_cnt; ++i) {
				trans_vert_x[i] = vert_x[i];
				trans_vert_y[i] = vert_y[i];
				trans_vert_z[i] = vert_z[i];
			}

			min_x = min_y = min_z = -9999999;
			max_dim = max_x = max_y = max_z = 9999999;
		} else {
			if (trans_state == 1) {
				trans_state = 0;

				for (int i = 0; i < vert_cnt; ++i) {
					trans_vert_x[i] = vert_x[i];
					trans_vert_y[i] = vert_y[i];
					trans_vert_z[i] = vert_z[i];
				}

				if (trans_type >= 2) {
					rotate_apply(yaw, pitch, roll);
				}

				if (trans_type >= 3) {
					scale_apply(scale_x, scale_y, scale_z);
				}

				if (trans_type >= 4) {
					shear_apply(shear_xy, shear_zy, shear_xz, shear_yz, shear_zx,
							shear_yx);
				}

				if (trans_type >= 1) {
					translate_apply(base_x, base_y, base_z);
				}

				calc_bounds();
				calc_norms();
			}
		}
	}


	public void project(int cam_x, int cam_y, int cam_z, int cam_roll, int cam_pitch, int cam_yaw, int plane_dist, int near_dist) {
		trans_apply();
		
		if ((min_z > Scene.frustum_near_z) || (max_z < Scene.frustum_far_z)
			|| (min_x > Scene.frustum_min_x)|| (max_x < Scene.frustum_max_x)
			|| (min_y > Scene.frustum_min_y) || (max_y < Scene.frustum_max_y)) {
			visible = false;
			return;
		}

		visible = true;
		int sin_yaw = 0;
		int cos_yaw = 0;
		int sin_roll = 0;
		int cos_roll = 0;
		int sin_pitch = 0;
		int cos_pitch = 0;
		if (cam_yaw != 0) {
			sin_yaw = sin1024_tbl[cam_yaw];
			cos_yaw = sin1024_tbl[cam_yaw + 1024];
		}

		if (cam_pitch != 0) {
			sin_pitch = sin1024_tbl[cam_pitch];
			cos_pitch = sin1024_tbl[cam_pitch + 1024];
		}

		if (cam_roll != 0) {
			sin_roll = sin1024_tbl[cam_roll];
			cos_roll = sin1024_tbl[cam_roll + 1024];
		}

		for (int vert = 0; vert < vert_cnt; ++vert) {
			int x = trans_vert_x[vert] - cam_x;
			int y = trans_vert_y[vert] - cam_y;
			int z = trans_vert_z[vert] - cam_z;

			if (cam_yaw != 0) {
				int dx = y * sin_yaw + x * cos_yaw >> 15;
				y = y * cos_yaw - x * sin_yaw >> 15;
				x = dx;
			}

			if (cam_pitch != 0) {
				int dx = z * sin_pitch + x * cos_pitch >> 15;
				z = z * cos_pitch - x * sin_pitch >> 15;
				x = dx;
			}

			if (cam_roll != 0) {
				int dy = y * cos_roll - z * sin_roll >> 15;
				z = y * sin_roll + z * cos_roll >> 15;
				y = dy;
			}

			if (z >= near_dist) {
				project_plane_x[vert] = (x << plane_dist) / z;
			} else {
				project_plane_x[vert] = x << plane_dist;
			}

			if (z >= near_dist) {
				project_plane_y[vert] = (y << plane_dist) / z;
			} else {
				project_plane_y[vert] = y << plane_dist;
			}

			project_vert_x[vert] = x;
			project_vert_y[vert] = y;
			project_vert_z[vert] = z;
		}
	}

	public void commit() {
		trans_apply();

		for (int i = 0; i < vert_cnt; ++i) {
			vert_x[i] = trans_vert_x[i];
			vert_y[i] = trans_vert_y[i];
			vert_z[i] = trans_vert_z[i];
		}

		base_x = base_y = base_z = 0;
		yaw = pitch = roll = 0;
		scale_x = scale_y = scale_z = 256;
		shear_xy = shear_zy = shear_xz = shear_yz = shear_zx = shear_yx = 256;
		trans_type = 0;
	}

	public Model copy() {
		Model copy = new Model(new Model[] { this }, 1);
		copy.depth = depth;
		copy.trans = trans;
		return copy;
	}

	public Model copy(boolean autocommit, boolean no_bounds, boolean no_shading, boolean unpickable) {
		Model copy = new Model(new Model[] { this }, 1, autocommit, no_bounds, no_shading, unpickable);
		copy.depth = depth;
		return copy;
	}

	public void copy_trans(Model other) {
		yaw = other.yaw;
		pitch = other.pitch;
		roll = other.roll;
		base_x = other.base_x;
		base_y = other.base_y;
		base_z = other.base_z;
		determine_trans();
		trans_state = 1;
	}

	public int base64_get(byte[] buf) {
		while (buf[buf_ptr] == 10 || buf[buf_ptr] == 13) {
			buf_ptr += 1;
		}

		int var2 = dec_tbl[buf[this.buf_ptr++] & 255];
		int var3 = dec_tbl[buf[this.buf_ptr++] & 255];
		int var4 = dec_tbl[buf[this.buf_ptr++] & 255];
		int value = var2 * 4096 + var3 * 64 + var4 - 131072;

		if (value == 123456) {
			value = use_gourad_shading;
		}

		return value;
	}
}
