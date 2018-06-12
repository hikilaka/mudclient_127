import jagex.DataUtil;
import jagex.client.Surface;
import jagex.client.Scene;
import jagex.client.Model;
import java.io.IOException;

public class Terrain {
	boolean field_66 = false;
	boolean require_clean = true;
	Surface surface;
	Scene scene;
	int sprite_offset = 750;
	final int field_71 = 12345678;
	final int field_72 = 128;
	int[] color_table = new int[256];
	int field_74;
	int[] field_75;
	int[] field_76;
	int[] field_77;
	byte[] land_archive;
	byte[] map_archive;
	byte[] mem_land_archive;
	byte[] mem_map_archive;
	byte[][] tile_height = new byte[4][2304];
	byte[][] tile_color = new byte[4][2304];
	byte[][] tile_horiz_wall = new byte[4][2304];
	byte[][] tile_vert_wall = new byte[4][2304];
	byte[][] tile_roof = new byte[4][2304];
	byte[][] tile_overlay = new byte[4][2304];
	byte[][] tile_obj_rot = new byte[4][2304];
	int[][] tile_diag_wall = new int[4][2304];
	int region_width = 96;
	int region_height = 96;
	int[] field_92;
	int[] field_93;
	int[][] dijk_prev;
	int[][] collision_flags;
	int[][] field_96;
	boolean field_97;
	Model[] ground;
	Model[][] walls;
	Model[][] rooves;
	Model mesh;

	public Terrain(Scene scene, Surface surface) {
		this.scene = scene;
		this.surface = surface;

		this.field_92 = new int[this.region_width * this.region_height * 2];
		this.field_93 = new int[this.region_width * this.region_height * 2];
		this.dijk_prev = new int[this.region_width][this.region_height];
		this.collision_flags = new int[this.region_width][this.region_height];
		this.field_96 = new int[this.region_width][this.region_height];
		this.field_97 = false;

		ground = new Model[64];
		walls = new Model[4][64];
		rooves = new Model[4][64];

		for (int i = 0; i < 64; ++i) {
			color_table[i] = Scene.rgb(255 - i * 4, 255 - (int) ((double) i * 1.75D), 255 - i * 4);
		}

		for (int i = 0; i < 64; ++i) {
			color_table[i + 64] = Scene.rgb(i * 3, 144, 0);
		}

		for (int i = 0; i < 64; ++i) {
			color_table[i + 128] = Scene.rgb(192 - (int) ((double) i * 1.5D), 144 - (int) ((double) i * 1.5D), 0);
		}

		for (int i = 0; i < 64; ++i) {
			color_table[i + 192] = Scene.rgb(96 - (int) ((double) i * 1.5D), 48 + (int) ((double) i * 1.5D), 0);
		}
	}

	public int create_path(int start_x, int start_y, int end_x2, int end_y2, int end_x1, int end_y1, int[] path_x, int[] path_y, boolean flag) {
		for (int x = 0; x < region_width; ++x) {
			for (int y = 0; y < region_height; ++y) {
				dijk_prev[x][y] = 0;
			}
		}

		int write_ptr = 0;
		int read_ptr = 0;
		int cur_x = start_x;
		int cur_y = start_y;
		
		dijk_prev[start_x][start_y] = 99;
		
		path_x[write_ptr] = start_x;
		path_y[write_ptr++] = start_y;
		int path_size = path_x.length;
		boolean found = false;

		while (read_ptr != write_ptr) {
			cur_x = path_x[read_ptr];
			cur_y = path_y[read_ptr];
			read_ptr = (read_ptr + 1) % path_size;
			if (cur_x >= end_x2 && cur_x <= end_x1 && cur_y >= end_y2 && cur_y <= end_y1) {
				found = true;
				break;
			}

			if (flag) {
				if (cur_x > 0 && cur_x - 1 >= end_x2 && cur_x - 1 <= end_x1 && cur_y >= end_y2 && cur_y <= end_y1
						&& (collision_flags[cur_x - 1][cur_y] & 8) == 0) {
					found = true;
					break;
				}

				if (cur_x < region_width - 1 && cur_x + 1 >= end_x2 && cur_x + 1 <= end_x1 && cur_y >= end_y2
						&& cur_y <= end_y1 && (collision_flags[cur_x + 1][cur_y] & 2) == 0) {
					found = true;
					break;
				}

				if (cur_y > 0 && cur_x >= end_x2 && cur_x <= end_x1 && cur_y - 1 >= end_y2 && cur_y - 1 <= end_y1
						&& (collision_flags[cur_x][cur_y - 1] & 4) == 0) {
					found = true;
					break;
				}

				if (cur_y < region_height - 1 && cur_x >= end_x2 && cur_x <= end_x1 && cur_y + 1 >= end_y2
						&& cur_y + 1 <= end_y1 && (collision_flags[cur_x][cur_y + 1] & 1) == 0) {
					found = true;
					break;
				}
			}

			if (cur_x > 0 && dijk_prev[cur_x - 1][cur_y] == 0 && (collision_flags[cur_x - 1][cur_y] & 120) == 0) {
				path_x[write_ptr] = cur_x - 1;
				path_y[write_ptr] = cur_y;
				write_ptr = (write_ptr + 1) % path_size;
				dijk_prev[cur_x - 1][cur_y] = 2;
			}

			if (cur_x < region_width - 1 && dijk_prev[cur_x + 1][cur_y] == 0
					&& (collision_flags[cur_x + 1][cur_y] & 114) == 0) {
				path_x[write_ptr] = cur_x + 1;
				path_y[write_ptr] = cur_y;
				write_ptr = (write_ptr + 1) % path_size;
				dijk_prev[cur_x + 1][cur_y] = 8;
			}

			if (cur_y > 0 && dijk_prev[cur_x][cur_y - 1] == 0 && (collision_flags[cur_x][cur_y - 1] & 116) == 0) {
				path_x[write_ptr] = cur_x;
				path_y[write_ptr] = cur_y - 1;
				write_ptr = (write_ptr + 1) % path_size;
				dijk_prev[cur_x][cur_y - 1] = 1;
			}

			if (cur_y < region_height - 1 && dijk_prev[cur_x][cur_y + 1] == 0
					&& (collision_flags[cur_x][cur_y + 1] & 113) == 0) {
				path_x[write_ptr] = cur_x;
				path_y[write_ptr] = cur_y + 1;
				write_ptr = (write_ptr + 1) % path_size;
				dijk_prev[cur_x][cur_y + 1] = 4;
			}

			if (cur_x > 0 && cur_y > 0 && (collision_flags[cur_x][cur_y - 1] & 116) == 0
					&& (collision_flags[cur_x - 1][cur_y] & 120) == 0 && (collision_flags[cur_x - 1][cur_y - 1] & 124) == 0
					&& dijk_prev[cur_x - 1][cur_y - 1] == 0) {
				path_x[write_ptr] = cur_x - 1;
				path_y[write_ptr] = cur_y - 1;
				write_ptr = (write_ptr + 1) % path_size;
				dijk_prev[cur_x - 1][cur_y - 1] = 3;
			}

			if (cur_x < region_width - 1 && cur_y > 0 && (collision_flags[cur_x][cur_y - 1] & 116) == 0
					&& (collision_flags[cur_x + 1][cur_y] & 114) == 0 && (collision_flags[cur_x + 1][cur_y - 1] & 118) == 0
					&& dijk_prev[cur_x + 1][cur_y - 1] == 0) {
				path_x[write_ptr] = cur_x + 1;
				path_y[write_ptr] = cur_y - 1;
				write_ptr = (write_ptr + 1) % path_size;
				dijk_prev[cur_x + 1][cur_y - 1] = 9;
			}

			if (cur_x > 0 && cur_y < region_height - 1 && (collision_flags[cur_x][cur_y + 1] & 113) == 0
					&& (collision_flags[cur_x - 1][cur_y] & 120) == 0 && (collision_flags[cur_x - 1][cur_y + 1] & 121) == 0
					&& dijk_prev[cur_x - 1][cur_y + 1] == 0) {
				path_x[write_ptr] = cur_x - 1;
				path_y[write_ptr] = cur_y + 1;
				write_ptr = (write_ptr + 1) % path_size;
				dijk_prev[cur_x - 1][cur_y + 1] = 6;
			}

			if (cur_x < region_width - 1 && cur_y < region_height - 1 && (collision_flags[cur_x][cur_y + 1] & 113) == 0
					&& (collision_flags[cur_x + 1][cur_y] & 114) == 0 && (collision_flags[cur_x + 1][cur_y + 1] & 115) == 0
					&& dijk_prev[cur_x + 1][cur_y + 1] == 0) {
				path_x[write_ptr] = cur_x + 1;
				path_y[write_ptr] = cur_y + 1;
				write_ptr = (write_ptr + 1) % path_size;
				dijk_prev[cur_x + 1][cur_y + 1] = 12;
			}
		}

		if (!found) {
			return -1;
		} else {
			byte var20 = 0;
			path_x[var20] = cur_x;
			read_ptr = var20 + 1;
			path_y[var20] = cur_y;

			int var18;
			for (int var17 = var18 = this.dijk_prev[cur_x][cur_y]; cur_x != start_x
					|| cur_y != start_y; var17 = this.dijk_prev[cur_x][cur_y]) {
				if (var17 != var18) {
					var18 = var17;
					path_x[read_ptr] = cur_x;
					path_y[read_ptr++] = cur_y;
				}

				if ((var17 & 2) != 0) {
					++cur_x;
				} else if ((var17 & 8) != 0) {
					--cur_x;
				}

				if ((var17 & 1) != 0) {
					++cur_y;
				} else if ((var17 & 4) != 0) {
					--cur_y;
				}
			}

			return read_ptr;
		}
	}

	public void set(int x, int y, int value) {
		collision_flags[x][y] |= value;
	}

	public void unset(int x, int y, int flag) {
		collision_flags[x][y] &= 65535 - flag;
	}

	public void wall_plot(int x, int y, int type, int id) {
		if (x >= 0 && y >= 0 && x < region_width - 1 && y < region_height - 1) {
			if (Config.bound_adjacent[id] == 1) {
				if (type == 0) {
					collision_flags[x][y] |= 1;
					
					if (y > 0) {
						set(x, y - 1, 4);
					}
				} else if (type == 1) {
					collision_flags[x][y] |= 2;
					
					if (x > 0) {
						set(x - 1, y, 8);
					}
				} else if (type == 2) {
					collision_flags[x][y] |= 16;
				} else if (type == 3) {
					collision_flags[x][y] |= 32;
				}
				method_89(x, y, 1, 1);
			}
		}
	}

	public void wall_remove(int x, int y, int type, int id) {
		if (x >= 0 && y >= 0 && x < region_width - 1 && y < region_height - 1) {
			if (Config.bound_adjacent[id] == 1) {
				if (type == 0) {
					collision_flags[x][y] &= 65534;
					
					if (y > 0) {
						unset(x, y - 1, 4);
					}
				} else if (type == 1) {
					collision_flags[x][y] &= 65533;
					
					if (x > 0) {
						unset(x - 1, y, 8);
					}
				} else if (type == 2) {
					collision_flags[x][y] &= 65519;
				} else if (type == 3) {
					collision_flags[x][y] &= 65503;
				}

				method_89(x, y, 1, 1);
			}
		}
	}

	public void obj_plot(int x, int y, int id) {
		if (x >= 0 && y >= 0 && x < region_width - 1 && y < region_height - 1) {
			if (Config.obj_type[id] == 1 || Config.obj_type[id] == 2) {
				int var4 = method_102(x, y);
				int var5;
				int var6;
				if (var4 != 0 && var4 != 4) {
					var6 = Config.obj_width[id];
					var5 = Config.obj_height[id];
				} else {
					var5 = Config.obj_width[id];
					var6 = Config.obj_height[id];
				}

				for (int var7 = x; var7 < x + var5; ++var7) {
					for (int var8 = y; var8 < y + var6; ++var8) {
						if (Config.obj_type[id] == 1) {
							this.collision_flags[var7][var8] |= 64;
						} else if (var4 == 0) {
							this.collision_flags[var7][var8] |= 2;
							if (var7 > 0) {
								this.set(var7 - 1, var8, 8);
							}
						} else if (var4 == 2) {
							this.collision_flags[var7][var8] |= 4;
							if (var8 < this.region_height - 1) {
								this.set(var7, var8 + 1, 1);
							}
						} else if (var4 == 4) {
							this.collision_flags[var7][var8] |= 8;
							if (var7 < this.region_width - 1) {
								this.set(var7 + 1, var8, 2);
							}
						} else if (var4 == 6) {
							this.collision_flags[var7][var8] |= 1;
							if (var8 > 0) {
								this.set(var7, var8 - 1, 4);
							}
						}
					}
				}

				this.method_89(x, y, var5, var6);
			}

		}
	}

	public void obj_remove(int x, int y, int id) {
		if (x >= 0 && y >= 0 && x < this.region_width - 1 && y < this.region_height - 1) {
			if (Config.obj_type[id] == 1 || Config.obj_type[id] == 2) {
				int var4 = this.method_102(x, y);
				int var5;
				int var6;
				if (var4 != 0 && var4 != 4) {
					var6 = Config.obj_width[id];
					var5 = Config.obj_height[id];
				} else {
					var5 = Config.obj_width[id];
					var6 = Config.obj_height[id];
				}

				for (int var7 = x; var7 < x + var5; ++var7) {
					for (int var8 = y; var8 < y + var6; ++var8) {
						if (Config.obj_type[id] == 1) {
							this.collision_flags[var7][var8] &= 65471;
						} else if (var4 == 0) {
							this.collision_flags[var7][var8] &= 65533;
							if (var7 > 0) {
								this.unset(var7 - 1, var8, 8);
							}
						} else if (var4 == 2) {
							this.collision_flags[var7][var8] &= 65531;
							if (var8 < this.region_height - 1) {
								this.unset(var7, var8 + 1, 1);
							}
						} else if (var4 == 4) {
							this.collision_flags[var7][var8] &= 65527;
							if (var7 < this.region_width - 1) {
								this.unset(var7 + 1, var8, 2);
							}
						} else if (var4 == 6) {
							this.collision_flags[var7][var8] &= 65534;
							if (var8 > 0) {
								this.unset(var7, var8 - 1, 4);
							}
						}
					}
				}

				this.method_89(x, y, var5, var6);
			}

		}
	}

	public void method_89(int var1, int var2, int var3, int var4) {
		if (var1 >= 1 && var2 >= 1 && var1 + var3 < this.region_width && var2 + var4 < this.region_height) {
			for (int var5 = var1; var5 <= var1 + var3; ++var5) {
				for (int var6 = var2; var6 <= var2 + var4; ++var6) {
					if ((this.collision_flags(var5, var6) & 99) == 0 && (this.collision_flags(var5 - 1, var6) & 89) == 0
							&& (this.collision_flags(var5, var6 - 1) & 86) == 0
							&& (this.collision_flags(var5 - 1, var6 - 1) & 108) == 0) {
						this.method_90(var5, var6, 0);
					} else {
						this.method_90(var5, var6, 35);
					}
				}
			}

		}
	}

	public void method_90(int var1, int var2, int var3) {
		int var4 = var1 / 12;
		int var5 = var2 / 12;
		int var6 = (var1 - 1) / 12;
		int var7 = (var2 - 1) / 12;
		this.method_91(var4, var5, var1, var2, var3);
		if (var4 != var6) {
			this.method_91(var6, var5, var1, var2, var3);
		}

		if (var5 != var7) {
			this.method_91(var4, var7, var1, var2, var3);
		}

		if (var4 != var6 && var5 != var7) {
			this.method_91(var6, var7, var1, var2, var3);
		}

	}

	public void method_91(int var1, int var2, int var3, int var4, int var5) {
		Model tile = this.ground[var1 + var2 * 8];

		for (int i = 0; i < tile.vert_cnt; ++i) {
			if (tile.vert_x[i] == var3 * 128 && tile.vert_z[i] == var4 * 128) {
				tile.set_vert_ambient(i, var5);
				return;
			}
		}
	}

	public int collision_flags(int x, int y) {
		if ((x < 0) || (y < 0) || (x >= region_width) || (y >= region_height)) {
			return 0;
		}
		return this.collision_flags[x][y];
	}

	public int calc_z(int x, int y) {
		int tile_x = x >> 7;
		int tile_y = y >> 7;
		int off_x = x & 127;
		int off_y = y & 127;
		
		if (tile_x >= 0 && tile_y >= 0 && tile_x < region_width - 1 && tile_y < region_height - 1) {
			int base;
			int diff_h_a;
			int diff_h_b;

			if (off_x <= 128 - off_y) {
				base = tile_height(tile_x, tile_y);
				diff_h_a = tile_height(tile_x + 1, tile_y) - base;
				diff_h_b = tile_height(tile_x, tile_y + 1) - base;
			} else {
				base = tile_height(tile_x + 1, tile_y + 1);
				diff_h_a = tile_height(tile_x, tile_y + 1) - base;
				diff_h_b = tile_height(tile_x + 1, tile_y) - base;
				off_x = 128 - off_x;
				off_y = 128 - off_y;
			}

			return base + diff_h_a * off_x / 128 + diff_h_b * off_y / 128;
		}

		return 0;
	}

	public int tile_height(int x, int y) {
		if (x >= 0 && x < 96 && y >= 0 && y < 96) {
			byte part = 0;

			if (x >= 48 && y < 48) {
				part = 1;
				x -= 48;
			} else if (x < 48 && y >= 48) {
				part = 2;
				y -= 48;
			} else if (x >= 48 && y >= 48) {
				part = 3;
				x -= 48;
				y -= 48;
			}

			return (tile_height[part][x * 48 + y] & 255) * 3;
		}
		
		return 0;
	}

	public int tile_color(int x, int y) {
		if (x >= 0 && x < 96 && y >= 0 && y < 96) {
			byte part = 0;
			if (x >= 48 && y < 48) {
				part = 1;
				x -= 48;
			} else if (x < 48 && y >= 48) {
				part = 2;
				y -= 48;
			} else if (x >= 48 && y >= 48) {
				part = 3;
				x -= 48;
				y -= 48;
			}

			return tile_color[part][x * 48 + y] & 255;
		}
		
		return 0;
	}

	public int method_96(int var1, int var2, int var3) {
		if (var1 >= 0 && var1 < 96 && var2 >= 0 && var2 < 96) {
			byte var4 = 0;
			if (var1 >= 48 && var2 < 48) {
				var4 = 1;
				var1 -= 48;
			} else if (var1 < 48 && var2 >= 48) {
				var4 = 2;
				var2 -= 48;
			} else if (var1 >= 48 && var2 >= 48) {
				var4 = 3;
				var1 -= 48;
				var2 -= 48;
			}

			return this.tile_overlay[var4][var1 * 48 + var2] & 255;
		} else {
			return 0;
		}
	}

	public void method_97(int var1, int var2, int var3) {
		if (var1 >= 0 && var1 < 96 && var2 >= 0 && var2 < 96) {
			byte var4 = 0;
			if (var1 >= 48 && var2 < 48) {
				var4 = 1;
				var1 -= 48;
			} else if (var1 < 48 && var2 >= 48) {
				var4 = 2;
				var2 -= 48;
			} else if (var1 >= 48 && var2 >= 48) {
				var4 = 3;
				var1 -= 48;
				var2 -= 48;
			}

			this.tile_overlay[var4][var1 * 48 + var2] = (byte) var3;
		}
	}

	public int method_98(int var1, int var2, int var3) {
		int var4 = this.method_96(var1, var2, var3);
		if (var4 == 0) {
			return -1;
		} else {
			int var5 = Config.tile_type[var4 - 1];
			return var5 == 2 ? 1 : 0;
		}
	}

	public int method_99(int var1, int var2, int var3, int var4) {
		int var5 = this.method_96(var1, var2, var3);
		return var5 == 0 ? var4 : Config.tile_decoration[var5 - 1];
	}

	public int method_100(int var1, int var2) {
		if (var1 >= 0 && var1 < 96 && var2 >= 0 && var2 < 96) {
			byte var3 = 0;
			if (var1 >= 48 && var2 < 48) {
				var3 = 1;
				var1 -= 48;
			} else if (var1 < 48 && var2 >= 48) {
				var3 = 2;
				var2 -= 48;
			} else if (var1 >= 48 && var2 >= 48) {
				var3 = 3;
				var1 -= 48;
				var2 -= 48;
			}

			return this.tile_diag_wall[var3][var1 * 48 + var2];
		} else {
			return 0;
		}
	}

	public int method_101(int var1, int var2) {
		if (var1 >= 0 && var1 < 96 && var2 >= 0 && var2 < 96) {
			byte var3 = 0;
			if (var1 >= 48 && var2 < 48) {
				var3 = 1;
				var1 -= 48;
			} else if (var1 < 48 && var2 >= 48) {
				var3 = 2;
				var2 -= 48;
			} else if (var1 >= 48 && var2 >= 48) {
				var3 = 3;
				var1 -= 48;
				var2 -= 48;
			}

			return this.tile_roof[var3][var1 * 48 + var2];
		} else {
			return 0;
		}
	}

	public int method_102(int var1, int var2) {
		if (var1 >= 0 && var1 < 96 && var2 >= 0 && var2 < 96) {
			byte var3 = 0;
			if (var1 >= 48 && var2 < 48) {
				var3 = 1;
				var1 -= 48;
			} else if (var1 < 48 && var2 >= 48) {
				var3 = 2;
				var2 -= 48;
			} else if (var1 >= 48 && var2 >= 48) {
				var3 = 3;
				var1 -= 48;
				var2 -= 48;
			}

			return this.tile_obj_rot[var3][var1 * 48 + var2];
		} else {
			return 0;
		}
	}

	public boolean method_103(int var1, int var2) {
		return this.method_101(var1, var2) > 0 || this.method_101(var1 - 1, var2) > 0
				|| this.method_101(var1 - 1, var2 - 1) > 0 || this.method_101(var1, var2 - 1) > 0;
	}

	public boolean method_104(int var1, int var2) {
		return this.method_101(var1, var2) > 0 && this.method_101(var1 - 1, var2) > 0
				&& this.method_101(var1 - 1, var2 - 1) > 0 && this.method_101(var1, var2 - 1) > 0;
	}

	public int method_105(int var1, int var2) {
		if (var1 >= 0 && var1 < 96 && var2 >= 0 && var2 < 96) {
			byte var3 = 0;
			if (var1 >= 48 && var2 < 48) {
				var3 = 1;
				var1 -= 48;
			} else if (var1 < 48 && var2 >= 48) {
				var3 = 2;
				var2 -= 48;
			} else if (var1 >= 48 && var2 >= 48) {
				var3 = 3;
				var1 -= 48;
				var2 -= 48;
			}

			return this.tile_vert_wall[var3][var1 * 48 + var2] & 255;
		} else {
			return 0;
		}
	}

	public int method_106(int var1, int var2) {
		if (var1 >= 0 && var1 < 96 && var2 >= 0 && var2 < 96) {
			byte var3 = 0;
			if (var1 >= 48 && var2 < 48) {
				var3 = 1;
				var1 -= 48;
			} else if (var1 < 48 && var2 >= 48) {
				var3 = 2;
				var2 -= 48;
			} else if (var1 >= 48 && var2 >= 48) {
				var3 = 3;
				var1 -= 48;
				var2 -= 48;
			}

			return this.tile_horiz_wall[var3][var1 * 48 + var2] & 255;
		} else {
			return 0;
		}
	}

	public void load_region(int x, int y, int z, int region) {
		String basename = "m" + z + x / 10 + x % 10 + y / 10 + y % 10;

		try {
			int var7;
			int var8;
			int var9;
			int var10;
			int var11;
			int var12;
			int var13;
			int var14;
			int var15;
			int var16;
			byte[] file_buf;
			if (land_archive != null) {
				file_buf = DataUtil.entry_extract(basename + ".hei", 0, land_archive);
				
				if (file_buf == null && mem_land_archive != null) {
					file_buf = DataUtil.entry_extract(basename + ".hei", 0, mem_land_archive);
				}

				if (file_buf != null && file_buf.length > 0) {
					var7 = 0;
					var8 = 0;
					var9 = 0;

					while (var9 < 2304) {
						var10 = file_buf[var7++] & 255;
						if (var10 < 128) {
							tile_height[region][var9++] = (byte) var10;
							var8 = var10;
						}

						if (var10 >= 128) {
							for (var11 = 0; var11 < var10 - 128; ++var11) {
								tile_height[region][var9++] = (byte) var8;
							}
						}
					}

					var8 = 64;
					var10 = 0;

					label348: while (true) {
						if (var10 >= 48) {
							var8 = 0;
							var11 = 0;

							while (var11 < 2304) {
								var12 = file_buf[var7++] & 255;
								if (var12 < 128) {
									tile_color[region][var11++] = (byte) var12;
									var8 = var12;
								}

								if (var12 >= 128) {
									for (var13 = 0; var13 < var12 - 128; ++var13) {
										tile_color[region][var11++] = (byte) var8;
									}
								}
							}

							var8 = 35;
							var12 = 0;

							while (true) {
								if (var12 >= 48) {
									break label348;
								}

								for (var13 = 0; var13 < 48; ++var13) {
									var8 = tile_color[region][var13 * 48 + var12] + var8 & 127;
									tile_color[region][var13 * 48 + var12] = (byte) (var8 * 2);
								}

								++var12;
							}
						}

						for (var11 = 0; var11 < 48; ++var11) {
							var8 = tile_height[region][var11 * 48 + var10] + var8 & 127;
							tile_height[region][var11 * 48 + var10] = (byte) (var8 * 2);
						}

						++var10;
					}
				} else {
					for (var7 = 0; var7 < 2304; ++var7) {
						tile_height[region][var7] = 0;
						tile_color[region][var7] = 0;
					}
				}

				file_buf = DataUtil.entry_extract(basename + ".dat", 0, map_archive);

				if (file_buf == null && mem_map_archive != null) {
					file_buf = DataUtil.entry_extract(basename + ".dat", 0, mem_map_archive);
				}

				if (file_buf == null || file_buf.length == 0) {
					throw new IOException();
				} else {
					var7 = 0;
					var8 = 0;

					while (true) {
						while (var8 < 2304) {
							var9 = file_buf[var7++] & 255;
							if (var9 < 128) {
								this.tile_horiz_wall[region][var8++] = (byte) var9;
							} else {
								for (var10 = 0; var10 < var9 - 128; ++var10) {
									this.tile_horiz_wall[region][var8++] = 0;
								}
							}
						}

						var9 = 0;

						while (true) {
							while (var9 < 2304) {
								var10 = file_buf[var7++] & 255;
								if (var10 < 128) {
									this.tile_vert_wall[region][var9++] = (byte) var10;
								} else {
									for (var11 = 0; var11 < var10 - 128; ++var11) {
										this.tile_vert_wall[region][var9++] = 0;
									}
								}
							}

							var10 = 0;

							while (true) {
								while (var10 < 2304) {
									var11 = file_buf[var7++] & 255;
									if (var11 < 128) {
										this.tile_diag_wall[region][var10++] = var11;
									} else {
										for (var12 = 0; var12 < var11 - 128; ++var12) {
											this.tile_diag_wall[region][var10++] = 0;
										}
									}
								}

								var11 = 0;

								while (var11 < 2304) {
									var12 = file_buf[var7++] & 255;
									if (var12 < 128) {
										this.tile_diag_wall[region][var11++] = var12 + 12000;
									} else {
										var11 += var12 - 128;
									}
								}

								var12 = 0;

								while (true) {
									while (var12 < 2304) {
										var13 = file_buf[var7++] & 255;
										if (var13 < 128) {
											this.tile_roof[region][var12++] = (byte) var13;
										} else {
											for (var14 = 0; var14 < var13 - 128; ++var14) {
												this.tile_roof[region][var12++] = 0;
											}
										}
									}

									var13 = 0;
									var14 = 0;

									while (true) {
										while (var14 < 2304) {
											var15 = file_buf[var7++] & 255;
											if (var15 < 128) {
												this.tile_overlay[region][var14++] = (byte) var15;
												var13 = var15;
											} else {
												for (var16 = 0; var16 < var15 - 128; ++var16) {
													this.tile_overlay[region][var14++] = (byte) var13;
												}
											}
										}

										var15 = 0;

										while (true) {
											int value;
											while (var15 < 2304) {
												var16 = file_buf[var7++] & 255;
												if (var16 < 128) {
													this.tile_obj_rot[region][var15++] = (byte) var16;
												} else {
													for (value = 0; value < var16 - 128; ++value) {
														this.tile_obj_rot[region][var15++] = 0;
													}
												}
											}

											file_buf = DataUtil.entry_extract(basename + ".loc", 0, map_archive);
											
											if (file_buf != null && file_buf.length > 0) {
												var7 = 0;
												var16 = 0;

												while (var16 < 2304) {
													value = file_buf[var7++] & 255;
													if (value < 128) {
														tile_diag_wall[region][var16++] = value + 48000;
													} else {
														var16 += value - 128;
													}
												}
												return;
											}
											return;
										}
									}
								}
							}
						}
					}
				}
			} else {
				file_buf = new byte[20736];
				DataUtil.read("../gamedata/maps/" + basename + ".jm", file_buf, 20736);
				var7 = 0;
				var8 = 0;

				for (var9 = 0; var9 < 2304; ++var9) {
					var7 = var7 + file_buf[var8++] & 255;
					this.tile_height[region][var9] = (byte) var7;
				}

				var7 = 0;

				for (var10 = 0; var10 < 2304; ++var10) {
					var7 = var7 + file_buf[var8++] & 255;
					this.tile_color[region][var10] = (byte) var7;
				}

				for (var11 = 0; var11 < 2304; ++var11) {
					this.tile_horiz_wall[region][var11] = file_buf[var8++];
				}

				for (var12 = 0; var12 < 2304; ++var12) {
					this.tile_vert_wall[region][var12] = file_buf[var8++];
				}

				for (var13 = 0; var13 < 2304; ++var13) {
					this.tile_diag_wall[region][var13] = (file_buf[var8] & 255) * 256 + (file_buf[var8 + 1] & 255);
					var8 += 2;
				}

				for (var14 = 0; var14 < 2304; ++var14) {
					this.tile_roof[region][var14] = file_buf[var8++];
				}

				for (var15 = 0; var15 < 2304; ++var15) {
					this.tile_overlay[region][var15] = file_buf[var8++];
				}

				for (var16 = 0; var16 < 2304; ++var16) {
					this.tile_obj_rot[region][var16] = file_buf[var8++];
				}

			}
		} catch (IOException var18) {
			for (int var6 = 0; var6 < 2304; ++var6) {
				this.tile_height[region][var6] = 0;
				this.tile_color[region][var6] = 0;
				this.tile_horiz_wall[region][var6] = 0;
				this.tile_vert_wall[region][var6] = 0;
				this.tile_diag_wall[region][var6] = 0;
				this.tile_roof[region][var6] = 0;
				this.tile_overlay[region][var6] = 0;
				if (z == 0) {
					this.tile_overlay[region][var6] = -6;
				}

				if (z == 3) {
					this.tile_overlay[region][var6] = 8;
				}

				this.tile_obj_rot[region][var6] = 0;
			}

		}
	}

	public void dispose() {
		if (require_clean) {
			scene.dispose();
		}

		for (int i = 0; i < 64; ++i) {
			ground[i] = null;

			for (int j = 0; j < 4; ++j) {
				walls[j][i] = null;
			}

			for (int j = 0; j < 4; ++j) {
				rooves[j][i] = null;
			}
		}

		System.gc();
	}

	public void load(int x, int y, int z) {
		this.dispose();
		int var4 = (x + 24) / 48;
		int var5 = (y + 24) / 48;
		this.method_112(x, y, z, true);

		if (z == 0) {
			this.method_112(x, y, 1, false);
			this.method_112(x, y, 2, false);
			this.load_region(var4 - 1, var5 - 1, z, 0);
			this.load_region(var4, var5 - 1, z, 1);
			this.load_region(var4 - 1, var5, z, 2);
			this.load_region(var4, var5, z, 3);
			this.method_110();
		}
	}

	public void method_110() {
		for (int var1 = 0; var1 < 96; ++var1) {
			for (int var2 = 0; var2 < 96; ++var2) {
				if (this.method_96(var1, var2, 0) == 250) {
					if (var1 == 47 && this.method_96(var1 + 1, var2, 0) != 250
							&& this.method_96(var1 + 1, var2, 0) != 2) {
						this.method_97(var1, var2, 9);
					} else if (var2 == 47 && this.method_96(var1, var2 + 1, 0) != 250
							&& this.method_96(var1, var2 + 1, 0) != 2) {
						this.method_97(var1, var2, 9);
					} else {
						this.method_97(var1, var2, 2);
					}
				}
			}
		}

	}

	public void method_111(int var1, int var2, int var3, int var4, int var5) {
		int var6 = var1 * 3;
		int var7 = var2 * 3;
		int var8 = this.scene.texture_map_color(var4);
		int var9 = this.scene.texture_map_color(var5);
		var8 = var8 >> 1 & 8355711;
		var9 = var9 >> 1 & 8355711;

		if (var3 == 0) {
			surface.line_horiz(var6, var7, 3, var8);
			surface.line_horiz(var6, var7 + 1, 2, var8);
			surface.line_horiz(var6, var7 + 2, 1, var8);
			surface.line_horiz(var6 + 2, var7 + 1, 1, var9);
			surface.line_horiz(var6 + 1, var7 + 2, 2, var9);
		} else if (var3 == 1) {
			surface.line_horiz(var6, var7, 3, var9);
			surface.line_horiz(var6 + 1, var7 + 1, 2, var9);
			surface.line_horiz(var6 + 2, var7 + 2, 1, var9);
			surface.line_horiz(var6, var7 + 1, 1, var8);
			surface.line_horiz(var6, var7 + 2, 2, var8);
		}
	}

	public void method_112(int var1, int var2, int var3, boolean var4) {
		int var5 = (var1 + 24) / 48;
		int var6 = (var2 + 24) / 48;
		this.load_region(var5 - 1, var6 - 1, var3, 0);
		this.load_region(var5, var6 - 1, var3, 1);
		this.load_region(var5 - 1, var6, var3, 2);
		this.load_region(var5, var6, var3, 3);
		this.method_110();
		if (mesh == null) {
			mesh = new Model(region_width * region_height * 2 + 256, region_width * region_height * 2 + 256, true, true, false, false, true);
		}

		int var7;
		int var8;
		int var9;
		int var10;
		int var11;
		int var12;
		int var13;
		int var14;
		int var15;
		int var17;
		int var18;
		int var20;
		int var42;
		int var43;
		if (var4) {
			surface.clear();

			for (var7 = 0; var7 < 96; ++var7) {
				for (var8 = 0; var8 < 96; ++var8) {
					this.collision_flags[var7][var8] = 0;
				}
			}

			Model var40 = this.mesh;
			var40.clear();

			for (var9 = 0; var9 < 96; ++var9) {
				for (var10 = 0; var10 < 96; ++var10) {
					var11 = -this.tile_height(var9, var10);
					if (this.method_96(var9, var10, var3) > 0
							&& Config.tile_type[this.method_96(var9, var10, var3) - 1] == 4) {
						var11 = 0;
					}

					if (this.method_96(var9 - 1, var10, var3) > 0
							&& Config.tile_type[this.method_96(var9 - 1, var10, var3) - 1] == 4) {
						var11 = 0;
					}

					if (this.method_96(var9, var10 - 1, var3) > 0
							&& Config.tile_type[this.method_96(var9, var10 - 1, var3) - 1] == 4) {
						var11 = 0;
					}

					if (this.method_96(var9 - 1, var10 - 1, var3) > 0
							&& Config.tile_type[this.method_96(var9 - 1, var10 - 1, var3) - 1] == 4) {
						var11 = 0;
					}

					var12 = var40.vert_get(var9 * 128, var11, var10 * 128);
					var13 = (int) (Math.random() * 10.0D) - 5;
					var40.set_vert_ambient(var12, var13);
				}
			}

			int[] var41;
			for (var10 = 0; var10 < 95; ++var10) {
				for (var11 = 0; var11 < 95; ++var11) {
					var12 = this.tile_color(var10, var11);
					var13 = this.color_table[var12];
					var14 = var13;
					var15 = var13;
					byte var16 = 0;
					if (var3 == 1 || var3 == 2) {
						var13 = 12345678;
						var14 = 12345678;
						var15 = 12345678;
					}

					if (this.method_96(var10, var11, var3) > 0) {
						var17 = this.method_96(var10, var11, var3);
						var12 = Config.tile_type[var17 - 1];
						var18 = this.method_98(var10, var11, var3);
						var13 = var14 = Config.tile_decoration[var17 - 1];
						if (var12 == 4) {
							var13 = 1;
							var14 = 1;
							if (var17 == 12) {
								var13 = 31;
								var14 = 31;
							}
						}

						if (var12 == 5) {
							if (this.method_100(var10, var11) > 0 && this.method_100(var10, var11) < 24000) {
								if (this.method_99(var10 - 1, var11, var3, var15) != 12345678
										&& this.method_99(var10, var11 - 1, var3, var15) != 12345678) {
									var13 = this.method_99(var10 - 1, var11, var3, var15);
									var16 = 0;
								} else if (this.method_99(var10 + 1, var11, var3, var15) != 12345678
										&& this.method_99(var10, var11 + 1, var3, var15) != 12345678) {
									var14 = this.method_99(var10 + 1, var11, var3, var15);
									var16 = 0;
								} else if (this.method_99(var10 + 1, var11, var3, var15) != 12345678
										&& this.method_99(var10, var11 - 1, var3, var15) != 12345678) {
									var14 = this.method_99(var10 + 1, var11, var3, var15);
									var16 = 1;
								} else if (this.method_99(var10 - 1, var11, var3, var15) != 12345678
										&& this.method_99(var10, var11 + 1, var3, var15) != 12345678) {
									var13 = this.method_99(var10 - 1, var11, var3, var15);
									var16 = 1;
								}
							}
						} else if (var12 != 2
								|| this.method_100(var10, var11) > 0 && this.method_100(var10, var11) < 24000) {
							if (this.method_98(var10 - 1, var11, var3) != var18
									&& this.method_98(var10, var11 - 1, var3) != var18) {
								var13 = var15;
								var16 = 0;
							} else if (this.method_98(var10 + 1, var11, var3) != var18
									&& this.method_98(var10, var11 + 1, var3) != var18) {
								var14 = var15;
								var16 = 0;
							} else if (this.method_98(var10 + 1, var11, var3) != var18
									&& this.method_98(var10, var11 - 1, var3) != var18) {
								var14 = var15;
								var16 = 1;
							} else if (this.method_98(var10 - 1, var11, var3) != var18
									&& this.method_98(var10, var11 + 1, var3) != var18) {
								var13 = var15;
								var16 = 1;
							}
						}

						if (Config.tile_adjacent[var17 - 1] != 0) {
							this.collision_flags[var10][var11] |= 64;
						}

						if (Config.tile_type[var17 - 1] == 2) {
							this.collision_flags[var10][var11] |= 128;
						}
					}

					this.method_111(var10, var11, var16, var13, var14);
					var17 = this.tile_height(var10 + 1, var11 + 1) - this.tile_height(var10 + 1, var11)
							+ this.tile_height(var10, var11 + 1) - this.tile_height(var10, var11);
					if (var13 == var14 && var17 == 0) {
						if (var13 != 12345678) {
							var41 = new int[] { var11 + var10 * this.region_width + this.region_width,
									var11 + var10 * this.region_width, var11 + var10 * this.region_width + 1,
									var11 + var10 * this.region_width + this.region_width + 1 };
							var42 = var40.face_add(4, var41, 12345678, var13);
							this.field_92[var42] = var10;
							this.field_93[var42] = var11;
							var40.face_pick_tag[var42] = 200000 + var42;
						}
					} else {
						var41 = new int[3];
						int[] var19 = new int[3];
						if (var16 == 0) {
							if (var13 != 12345678) {
								var41[0] = var11 + var10 * this.region_width + this.region_width;
								var41[1] = var11 + var10 * this.region_width;
								var41[2] = var11 + var10 * this.region_width + 1;
								var20 = var40.face_add(3, var41, 12345678, var13);
								this.field_92[var20] = var10;
								this.field_93[var20] = var11;
								var40.face_pick_tag[var20] = 200000 + var20;
							}

							if (var14 != 12345678) {
								var19[0] = var11 + var10 * this.region_width + 1;
								var19[1] = var11 + var10 * this.region_width + this.region_width + 1;
								var19[2] = var11 + var10 * this.region_width + this.region_width;
								var20 = var40.face_add(3, var19, 12345678, var14);
								this.field_92[var20] = var10;
								this.field_93[var20] = var11;
								var40.face_pick_tag[var20] = 200000 + var20;
							}
						} else {
							if (var13 != 12345678) {
								var41[0] = var11 + var10 * this.region_width + 1;
								var41[1] = var11 + var10 * this.region_width + this.region_width + 1;
								var41[2] = var11 + var10 * this.region_width;
								var20 = var40.face_add(3, var41, 12345678, var13);
								this.field_92[var20] = var10;
								this.field_93[var20] = var11;
								var40.face_pick_tag[var20] = 200000 + var20;
							}

							if (var14 != 12345678) {
								var19[0] = var11 + var10 * this.region_width + this.region_width;
								var19[1] = var11 + var10 * this.region_width;
								var19[2] = var11 + var10 * this.region_width + this.region_width + 1;
								var20 = var40.face_add(3, var19, 12345678, var14);
								this.field_92[var20] = var10;
								this.field_93[var20] = var11;
								var40.face_pick_tag[var20] = 200000 + var20;
							}
						}
					}
				}
			}

			for (var11 = 1; var11 < 95; ++var11) {
				for (var12 = 1; var12 < 95; ++var12) {
					if (this.method_96(var11, var12, var3) > 0
							&& Config.tile_type[this.method_96(var11, var12, var3) - 1] == 4) {
						var13 = Config.tile_decoration[this.method_96(var11, var12, var3) - 1];
						var14 = var40.vert_get(var11 * 128, -this.tile_height(var11, var12), var12 * 128);
						var15 = var40.vert_get((var11 + 1) * 128, -this.tile_height(var11 + 1, var12), var12 * 128);
						var43 = var40.vert_get((var11 + 1) * 128, -this.tile_height(var11 + 1, var12 + 1),
								(var12 + 1) * 128);
						var17 = var40.vert_get(var11 * 128, -this.tile_height(var11, var12 + 1), (var12 + 1) * 128);
						var41 = new int[] { var14, var15, var43, var17 };
						var42 = var40.face_add(4, var41, var13, 12345678);
						this.field_92[var42] = var11;
						this.field_93[var42] = var12;
						var40.face_pick_tag[var42] = 200000 + var42;
						this.method_111(var11, var12, 0, var13, var13);
					} else if (this.method_96(var11, var12, var3) == 0
							|| Config.tile_type[this.method_96(var11, var12, var3) - 1] != 3) {
						if (this.method_96(var11, var12 + 1, var3) > 0
								&& Config.tile_type[this.method_96(var11, var12 + 1, var3) - 1] == 4) {
							var13 = Config.tile_decoration[this.method_96(var11, var12 + 1, var3) - 1];
							var14 = var40.vert_get(var11 * 128, -this.tile_height(var11, var12), var12 * 128);
							var15 = var40.vert_get((var11 + 1) * 128, -this.tile_height(var11 + 1, var12), var12 * 128);
							var43 = var40.vert_get((var11 + 1) * 128, -this.tile_height(var11 + 1, var12 + 1),
									(var12 + 1) * 128);
							var17 = var40.vert_get(var11 * 128, -this.tile_height(var11, var12 + 1), (var12 + 1) * 128);
							var41 = new int[] { var14, var15, var43, var17 };
							var42 = var40.face_add(4, var41, var13, 12345678);
							this.field_92[var42] = var11;
							this.field_93[var42] = var12;
							var40.face_pick_tag[var42] = 200000 + var42;
							this.method_111(var11, var12, 0, var13, var13);
						}

						if (this.method_96(var11, var12 - 1, var3) > 0
								&& Config.tile_type[this.method_96(var11, var12 - 1, var3) - 1] == 4) {
							var13 = Config.tile_decoration[this.method_96(var11, var12 - 1, var3) - 1];
							var14 = var40.vert_get(var11 * 128, -this.tile_height(var11, var12), var12 * 128);
							var15 = var40.vert_get((var11 + 1) * 128, -this.tile_height(var11 + 1, var12), var12 * 128);
							var43 = var40.vert_get((var11 + 1) * 128, -this.tile_height(var11 + 1, var12 + 1),
									(var12 + 1) * 128);
							var17 = var40.vert_get(var11 * 128, -this.tile_height(var11, var12 + 1), (var12 + 1) * 128);
							var41 = new int[] { var14, var15, var43, var17 };
							var42 = var40.face_add(4, var41, var13, 12345678);
							this.field_92[var42] = var11;
							this.field_93[var42] = var12;
							var40.face_pick_tag[var42] = 200000 + var42;
							this.method_111(var11, var12, 0, var13, var13);
						}

						if (this.method_96(var11 + 1, var12, var3) > 0
								&& Config.tile_type[this.method_96(var11 + 1, var12, var3) - 1] == 4) {
							var13 = Config.tile_decoration[this.method_96(var11 + 1, var12, var3) - 1];
							var14 = var40.vert_get(var11 * 128, -this.tile_height(var11, var12), var12 * 128);
							var15 = var40.vert_get((var11 + 1) * 128, -this.tile_height(var11 + 1, var12), var12 * 128);
							var43 = var40.vert_get((var11 + 1) * 128, -this.tile_height(var11 + 1, var12 + 1),
									(var12 + 1) * 128);
							var17 = var40.vert_get(var11 * 128, -this.tile_height(var11, var12 + 1), (var12 + 1) * 128);
							var41 = new int[] { var14, var15, var43, var17 };
							var42 = var40.face_add(4, var41, var13, 12345678);
							this.field_92[var42] = var11;
							this.field_93[var42] = var12;
							var40.face_pick_tag[var42] = 200000 + var42;
							this.method_111(var11, var12, 0, var13, var13);
						}

						if (this.method_96(var11 - 1, var12, var3) > 0
								&& Config.tile_type[this.method_96(var11 - 1, var12, var3) - 1] == 4) {
							var13 = Config.tile_decoration[this.method_96(var11 - 1, var12, var3) - 1];
							var14 = var40.vert_get(var11 * 128, -this.tile_height(var11, var12), var12 * 128);
							var15 = var40.vert_get((var11 + 1) * 128, -this.tile_height(var11 + 1, var12), var12 * 128);
							var43 = var40.vert_get((var11 + 1) * 128, -this.tile_height(var11 + 1, var12 + 1),
									(var12 + 1) * 128);
							var17 = var40.vert_get(var11 * 128, -this.tile_height(var11, var12 + 1), (var12 + 1) * 128);
							var41 = new int[] { var14, var15, var43, var17 };
							var42 = var40.face_add(4, var41, var13, 12345678);
							this.field_92[var42] = var11;
							this.field_93[var42] = var12;
							var40.face_pick_tag[var42] = 200000 + var42;
							this.method_111(var11, var12, 0, var13, var13);
						}
					}
				}
			}

			var40.set_light(true, 40, 48, -50, -10, -50);
			ground = mesh.split(1536, 1536, 8, 64, 233, false);

			for (var12 = 0; var12 < 64; ++var12) {
				scene.add(ground[var12]);
			}

			for (var13 = 0; var13 < 96; ++var13) {
				for (var14 = 0; var14 < 96; ++var14) {
					field_96[var13][var14] = tile_height(var13, var14);
				}
			}
		}

		mesh.clear();
		var7 = 6316128;

		for (var8 = 0; var8 < 95; ++var8) {
			for (var9 = 0; var9 < 95; ++var9) {
				var10 = this.method_105(var8, var9);
				if (var10 > 0 && (Config.bound_invis[var10 - 1] == 0 || this.field_66)) {
					this.method_114(this.mesh, var10 - 1, var8, var9, var8 + 1, var9);
					if (var4 && Config.bound_adjacent[var10 - 1] != 0) {
						this.collision_flags[var8][var9] |= 1;
						if (var9 > 0) {
							this.set(var8, var9 - 1, 4);
						}
					}

					if (var4) {
						this.surface.line_horiz(var8 * 3, var9 * 3, 3, var7);
					}
				}

				var10 = this.method_106(var8, var9);
				if (var10 > 0 && (Config.bound_invis[var10 - 1] == 0 || this.field_66)) {
					this.method_114(this.mesh, var10 - 1, var8, var9, var8, var9 + 1);
					if (var4 && Config.bound_adjacent[var10 - 1] != 0) {
						this.collision_flags[var8][var9] |= 2;
						if (var8 > 0) {
							this.set(var8 - 1, var9, 8);
						}
					}

					if (var4) {
						this.surface.line_vert(var8 * 3, var9 * 3, 3, var7);
					}
				}

				var10 = this.method_100(var8, var9);
				if (var10 > 0 && var10 < 12000 && (Config.bound_invis[var10 - 1] == 0 || this.field_66)) {
					this.method_114(this.mesh, var10 - 1, var8, var9, var8 + 1, var9 + 1);
					if (var4 && Config.bound_adjacent[var10 - 1] != 0) {
						this.collision_flags[var8][var9] |= 32;
					}

					if (var4) {
						this.surface.plot(var8 * 3, var9 * 3, var7);
						this.surface.plot(var8 * 3 + 1, var9 * 3 + 1, var7);
						this.surface.plot(var8 * 3 + 2, var9 * 3 + 2, var7);
					}
				}

				if (var10 > 12000 && var10 < 24000 && (Config.bound_invis[var10 - 12001] == 0 || this.field_66)) {
					this.method_114(this.mesh, var10 - 12001, var8 + 1, var9, var8, var9 + 1);
					if (var4 && Config.bound_adjacent[var10 - 12001] != 0) {
						this.collision_flags[var8][var9] |= 16;
					}

					if (var4) {
						this.surface.plot(var8 * 3 + 2, var9 * 3, var7);
						this.surface.plot(var8 * 3 + 1, var9 * 3 + 1, var7);
						this.surface.plot(var8 * 3, var9 * 3 + 2, var7);
					}
				}
			}
		}

		if (var4) {
			this.surface.col_sprite_define(this.sprite_offset - 1, 0, 0, 285, 285);
		}

		this.mesh.set_light(false, 60, 24, -50, -10, -50);
		this.walls[var3] = this.mesh.split(1536, 1536, 8, 64, 338, true);

		for (var9 = 0; var9 < 64; ++var9) {
			this.scene.add(this.walls[var3][var9]);
		}

		for (var10 = 0; var10 < 95; ++var10) {
			for (var11 = 0; var11 < 95; ++var11) {
				var12 = this.method_105(var10, var11);
				if (var12 > 0) {
					this.method_115(var12 - 1, var10, var11, var10 + 1, var11);
				}

				var12 = this.method_106(var10, var11);
				if (var12 > 0) {
					this.method_115(var12 - 1, var10, var11, var10, var11 + 1);
				}

				var12 = this.method_100(var10, var11);
				if (var12 > 0 && var12 < 12000) {
					this.method_115(var12 - 1, var10, var11, var10 + 1, var11 + 1);
				}

				if (var12 > 12000 && var12 < 24000) {
					this.method_115(var12 - 12001, var10 + 1, var11, var10, var11 + 1);
				}
			}
		}

		int var22;
		int var23;
		int var24;
		int var25;
		int var26;
		for (var11 = 1; var11 < 95; ++var11) {
			for (var12 = 1; var12 < 95; ++var12) {
				var13 = this.method_101(var11, var12);
				if (var13 > 0) {
					var43 = var11 + 1;
					var18 = var11 + 1;
					var42 = var12 + 1;
					int var21 = var12 + 1;
					var22 = 0;
					var23 = this.field_96[var11][var12];
					var24 = this.field_96[var43][var12];
					var25 = this.field_96[var18][var42];
					var26 = this.field_96[var11][var21];
					if (var23 > 80000) {
						var23 -= 80000;
					}

					if (var24 > 80000) {
						var24 -= 80000;
					}

					if (var25 > 80000) {
						var25 -= 80000;
					}

					if (var26 > 80000) {
						var26 -= 80000;
					}

					if (var23 > var22) {
						var22 = var23;
					}

					if (var24 > var22) {
						var22 = var24;
					}

					if (var25 > var22) {
						var22 = var25;
					}

					if (var26 > var22) {
						var22 = var26;
					}

					if (var22 >= 80000) {
						var22 -= 80000;
					}

					if (var23 < 80000) {
						this.field_96[var11][var12] = var22;
					} else {
						this.field_96[var11][var12] -= 80000;
					}

					if (var24 < 80000) {
						this.field_96[var43][var12] = var22;
					} else {
						this.field_96[var43][var12] -= 80000;
					}

					if (var25 < 80000) {
						this.field_96[var18][var42] = var22;
					} else {
						this.field_96[var18][var42] -= 80000;
					}

					if (var26 < 80000) {
						this.field_96[var11][var21] = var22;
					} else {
						this.field_96[var11][var21] -= 80000;
					}
				}
			}
		}

		this.mesh.clear();

		for (var12 = 1; var12 < 95; ++var12) {
			for (var13 = 1; var13 < 95; ++var13) {
				var14 = this.method_101(var12, var13);
				if (var14 > 0) {
					var17 = var12 + 1;
					var42 = var12 + 1;
					var20 = var13 + 1;
					var22 = var13 + 1;
					var23 = var12 * 128;
					var24 = var13 * 128;
					var25 = var23 + 128;
					var26 = var24 + 128;
					int var27 = var23;
					int var28 = var24;
					int var29 = var25;
					int var30 = var26;
					int var31 = this.field_96[var12][var13];
					int var32 = this.field_96[var17][var13];
					int var33 = this.field_96[var42][var20];
					int var34 = this.field_96[var12][var22];
					int var35 = Config.roof_size[var14 - 1];
					if (this.method_104(var12, var13) && var31 < 80000) {
						var31 += var35 + 80000;
						this.field_96[var12][var13] = var31;
					}

					if (this.method_104(var17, var13) && var32 < 80000) {
						var32 += var35 + 80000;
						this.field_96[var17][var13] = var32;
					}

					if (this.method_104(var42, var20) && var33 < 80000) {
						var33 += var35 + 80000;
						this.field_96[var42][var20] = var33;
					}

					if (this.method_104(var12, var22) && var34 < 80000) {
						var34 += var35 + 80000;
						this.field_96[var12][var22] = var34;
					}

					if (var31 >= 80000) {
						var31 -= 80000;
					}

					if (var32 >= 80000) {
						var32 -= 80000;
					}

					if (var33 >= 80000) {
						var33 -= 80000;
					}

					if (var34 >= 80000) {
						var34 -= 80000;
					}

					byte var36 = 16;
					if (!this.method_103(var12 - 1, var13)) {
						var23 -= var36;
					}

					if (!this.method_103(var12 + 1, var13)) {
						var23 += var36;
					}

					if (!this.method_103(var12, var13 - 1)) {
						var24 -= var36;
					}

					if (!this.method_103(var12, var13 + 1)) {
						var24 += var36;
					}

					if (!this.method_103(var17 - 1, var13)) {
						var25 -= var36;
					}

					if (!this.method_103(var17 + 1, var13)) {
						var25 += var36;
					}

					if (!this.method_103(var17, var13 - 1)) {
						var28 = var24 - var36;
					}

					if (!this.method_103(var17, var13 + 1)) {
						var28 += var36;
					}

					if (!this.method_103(var42 - 1, var20)) {
						var29 = var25 - var36;
					}

					if (!this.method_103(var42 + 1, var20)) {
						var29 += var36;
					}

					if (!this.method_103(var42, var20 - 1)) {
						var26 -= var36;
					}

					if (!this.method_103(var42, var20 + 1)) {
						var26 += var36;
					}

					if (!this.method_103(var12 - 1, var22)) {
						var27 = var23 - var36;
					}

					if (!this.method_103(var12 + 1, var22)) {
						var27 += var36;
					}

					if (!this.method_103(var12, var22 - 1)) {
						var30 = var26 - var36;
					}

					if (!this.method_103(var12, var22 + 1)) {
						var30 += var36;
					}

					var14 = Config.roof_vert_cnt[var14 - 1];
					var31 = -var31;
					var32 = -var32;
					var33 = -var33;
					var34 = -var34;
					int[] var44;
					if (this.method_100(var12, var13) > 12000 && this.method_100(var12, var13) < 24000
							&& this.method_101(var12 - 1, var13 - 1) == 0) {
						var44 = new int[] { this.mesh.vert_get(var29, var33, var26),
								this.mesh.vert_get(var27, var34, var30), this.mesh.vert_get(var25, var32, var28) };
						this.mesh.face_add(3, var44, var14, 12345678);
					} else if (this.method_100(var12, var13) > 12000 && this.method_100(var12, var13) < 24000
							&& this.method_101(var12 + 1, var13 + 1) == 0) {
						var44 = new int[] { this.mesh.vert_get(var23, var31, var24),
								this.mesh.vert_get(var25, var32, var28), this.mesh.vert_get(var27, var34, var30) };
						this.mesh.face_add(3, var44, var14, 12345678);
					} else if (this.method_100(var12, var13) > 0 && this.method_100(var12, var13) < 12000
							&& this.method_101(var12 + 1, var13 - 1) == 0) {
						var44 = new int[] { this.mesh.vert_get(var27, var34, var30),
								this.mesh.vert_get(var23, var31, var24), this.mesh.vert_get(var29, var33, var26) };
						this.mesh.face_add(3, var44, var14, 12345678);
					} else if (this.method_100(var12, var13) > 0 && this.method_100(var12, var13) < 12000
							&& this.method_101(var12 - 1, var13 + 1) == 0) {
						var44 = new int[] { this.mesh.vert_get(var25, var32, var28),
								this.mesh.vert_get(var29, var33, var26), this.mesh.vert_get(var23, var31, var24) };
						this.mesh.face_add(3, var44, var14, 12345678);
					} else if (var31 == var32 && var33 == var34) {
						var44 = new int[] { this.mesh.vert_get(var23, var31, var24),
								this.mesh.vert_get(var25, var32, var28), this.mesh.vert_get(var29, var33, var26),
								this.mesh.vert_get(var27, var34, var30) };
						this.mesh.face_add(4, var44, var14, 12345678);
					} else if (var31 == var34 && var32 == var33) {
						var44 = new int[] { this.mesh.vert_get(var27, var34, var30),
								this.mesh.vert_get(var23, var31, var24), this.mesh.vert_get(var25, var32, var28),
								this.mesh.vert_get(var29, var33, var26) };
						this.mesh.face_add(4, var44, var14, 12345678);
					} else {
						boolean var37 = true;
						if (this.method_101(var12 - 1, var13 - 1) > 0) {
							var37 = false;
						}

						if (this.method_101(var12 + 1, var13 + 1) > 0) {
							var37 = false;
						}

						int[] var38;
						int[] var39;
						if (!var37) {
							var38 = new int[] { this.mesh.vert_get(var25, var32, var28),
									this.mesh.vert_get(var29, var33, var26),
									this.mesh.vert_get(var23, var31, var24) };
							this.mesh.face_add(3, var38, var14, 12345678);
							var39 = new int[] { this.mesh.vert_get(var27, var34, var30),
									this.mesh.vert_get(var23, var31, var24),
									this.mesh.vert_get(var29, var33, var26) };
							this.mesh.face_add(3, var39, var14, 12345678);
						} else {
							var38 = new int[] { this.mesh.vert_get(var23, var31, var24),
									this.mesh.vert_get(var25, var32, var28),
									this.mesh.vert_get(var27, var34, var30) };
							this.mesh.face_add(3, var38, var14, 12345678);
							var39 = new int[] { this.mesh.vert_get(var29, var33, var26),
									this.mesh.vert_get(var27, var34, var30),
									this.mesh.vert_get(var25, var32, var28) };
							this.mesh.face_add(3, var39, var14, 12345678);
						}
					}
				}
			}
		}

		this.mesh.set_light(true, 50, 50, -50, -10, -50);
		this.rooves[var3] = this.mesh.split(1536, 1536, 8, 64, 169, true);

		for (var13 = 0; var13 < 64; ++var13) {
			this.scene.add(this.rooves[var3][var13]);
		}

		for (var14 = 0; var14 < 96; ++var14) {
			for (var15 = 0; var15 < 96; ++var15) {
				if (this.field_96[var14][var15] >= 80000) {
					this.field_96[var14][var15] -= 80000;
				}
			}
		}

	}

	public void method_113(Model[] var1) {
		for (int var2 = 0; var2 < this.region_width - 2; ++var2) {
			for (int var3 = 0; var3 < this.region_height - 2; ++var3) {
				if (this.method_100(var2, var3) > 48000 && this.method_100(var2, var3) < 60000) {
					int var4 = this.method_100(var2, var3) - '\ubb81';
					int var5 = this.method_102(var2, var3);
					int var6;
					int var7;
					if (var5 != 0 && var5 != 4) {
						var7 = Config.obj_width[var4];
						var6 = Config.obj_height[var4];
					} else {
						var6 = Config.obj_width[var4];
						var7 = Config.obj_height[var4];
					}

					this.obj_plot(var2, var3, var4);
					Model var8 = var1[Config.obj_model[var4]].copy(false, true, false, false);
					int var9 = (var2 + var2 + var6) * 128 / 2;
					int var10 = (var3 + var3 + var7) * 128 / 2;
					var8.translate(var9, -this.calc_z(var9, var10), var10);
					var8.orient(0, this.method_102(var2, var3) * 32, 0);
					this.scene.add(var8);
					var8.set_light(48, 48, -50, -10, -50);
					if (var6 > 1 || var7 > 1) {
						for (int var11 = var2; var11 < var2 + var6; ++var11) {
							for (int var12 = var3; var12 < var3 + var7; ++var12) {
								if ((var11 > var2 || var12 > var3)
										&& this.method_100(var11, var12) - '\ubb81' == var4) {
									var9 = var11;
									var10 = var12;
									byte var13 = 0;
									if (var11 >= 48 && var12 < 48) {
										var13 = 1;
										var9 = var11 - 48;
									} else if (var11 < 48 && var12 >= 48) {
										var13 = 2;
										var10 = var12 - 48;
									} else if (var11 >= 48 && var12 >= 48) {
										var13 = 3;
										var9 = var11 - 48;
										var10 = var12 - 48;
									}

									this.tile_diag_wall[var13][var9 * 48 + var10] = 0;
								}
							}
						}
					}
				}
			}
		}

	}

	public void method_114(Model var1, int var2, int var3, int var4, int var5, int var6) {
		this.method_90(var3, var4, 40);
		this.method_90(var5, var6, 40);
		int var7 = Config.bound_size[var2];
		int var8 = Config.bound_tex_front[var2];
		int var9 = Config.bound_tex_back[var2];
		int var10 = var3 * 128;
		int var11 = var4 * 128;
		int var12 = var5 * 128;
		int var13 = var6 * 128;
		int var14 = var1.vert_get(var10, -this.field_96[var3][var4], var11);
		int var15 = var1.vert_get(var10, -this.field_96[var3][var4] - var7, var11);
		int var16 = var1.vert_get(var12, -this.field_96[var5][var6] - var7, var13);
		int var17 = var1.vert_get(var12, -this.field_96[var5][var6], var13);
		int[] var18 = new int[] { var14, var15, var16, var17 };
		int var19 = var1.face_add(4, var18, var8, var9);
		if (Config.bound_invis[var2] == 5) {
			var1.face_pick_tag[var19] = 30000 + var2;
		} else {
			var1.face_pick_tag[var19] = 0;
		}
	}

	public void method_115(int var1, int var2, int var3, int var4, int var5) {
		int var6 = Config.bound_size[var1];
		if (this.field_96[var2][var3] < 80000) {
			this.field_96[var2][var3] += 80000 + var6;
		}

		if (this.field_96[var4][var5] < 80000) {
			this.field_96[var4][var5] += 80000 + var6;
		}

	}
}
