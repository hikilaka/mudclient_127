import jagex.DataUtil;
public final class Config {
	public final int field_401 = 12345678;
	public static int item_cnt;
	public static int item_max_sprite;
	public static String[] item_name;
	public static String[] item_desc;
	public static String[] item_action;
	public static int[] item_sprite;
	public static int[] item_value;
	public static int[] item_stackable;
	public static int[] item_unused;
	public static int[] item_equip_mask;
	public static int[] item_tint;
	public static int[] item_tradable;
	public static int[] item_members;
	public static int npc_cnt;
	public static String[] npc_name;
	public static String[] npc_action;
	public static int[] npc_atk_lvl;
	public static int[] npc_def_lvl;
	public static int[] npc_str_lvl;
	public static int[] npc_hit_lvl;
	public static int[] npc_attackable;
	public static int[][] npc_sprites;
	public static int[] npc_col_hair;
	public static int[] npc_col_top;
	public static int[] npc_col_bottom;
	public static int[] npc_col_skin;
	public static int[] npc_width;
	public static int[] npc_height;
	public static int[] npc_speed_walk;
	public static int[] npc_speed_cmb;
	public static int[] npc_cmb_anim;
	public static int texture_cnt;
	public static String[] texture_name;
	public static String[] texture_type;
	public static int anim_cnt;
	public static String[] anim_name;
	public static int[] anim_mask;
	public static int[] anim_unknown1;
	public static int[] anim_has_a;
	public static int[] anim_has_f;
	public static int[] anim_unknown2;
	public static int obj_cnt;
	public static String[] obj_name;
	public static String[] obj_desc;
	public static String[] obj_action1;
	public static String[] obj_action2;
	public static int[] obj_model;
	public static int[] obj_width;
	public static int[] obj_height;
	public static int[] obj_type;
	public static int[] obj_elevation;
	public static int bound_cnt;
	public static String[] bound_name;
	public static String[] bound_desc;
	public static String[] bound_action1;
	public static String[] bound_action2;
	public static int[] bound_size;
	public static int[] bound_tex_front;
	public static int[] bound_tex_back;
	public static int[] bound_adjacent;
	public static int[] bound_invis;
	public static int roof_cnt;
	public static int[] roof_size;
	public static int[] roof_vert_cnt;
	public static int tile_cnt;
	public static int[] tile_decoration;
	public static int[] tile_type;
	public static int[] tile_adjacent;
	public static int proj_sprite_cnt;
	public static int spell_cnt;
	public static String[] spell_name;
	public static String[] spell_desc;
	public static int[] spell_lvl;
	public static int[] spell_runes;
	public static int[] spell_type;
	public static int[][] spell_rune_ids;
	public static int[][] spell_rune_cnts;
	public static int prayer_cnt;
	public static String[] prayer_name;
	public static String[] prayer_desc;
	public static int[] prayer_lvl;
	public static int[] prayer_drain;
	public static int word_good_cnt;
	public static String[] word_good = new String[5000];
	public static int word_bad_cnt;
	public static String[] word_bad = new String[5000];
	public static int model_count;
	public static String[] model_name = new String[200];
	static byte[] str_buf;
	static byte[] int_buf;
	static int str_ptr;
	static int int_ptr;

	public static int model_lookup(String name) {
		if (name.equalsIgnoreCase("na")) {
			return 0;
		} else {
			for (int i = 0; i < model_count; ++i) {
				if (model_name[i].equalsIgnoreCase(name)) {
					return i;
				}
			}

			model_name[model_count++] = name;
			return model_count - 1;
		}
	}

	public static int byte_get() {
		int i = int_buf[int_ptr] & 255;
		int_ptr += 1;
		return i;
	}

	public static int short_get() {
		int i = DataUtil.short_get(int_buf, int_ptr);
		int_ptr += 2;
		return i;
	}

	public static int int_get() {
		int i = DataUtil.int_get(int_buf, int_ptr);
		int_ptr += 4;

		if (i > 99999999) {
			i = 99999999 - i;
		}

		return i;
	}

	public static String str_get() {
		String s = "";
		
		while (str_buf[str_ptr] != 0) {
			s += (char) str_buf[str_ptr];
			str_ptr += 1;
		}

		str_ptr += 1;
		return s;
	}

	public static void decode(byte[] archive, boolean is_members) {
		str_buf = DataUtil.entry_extract("string.dat", 0, archive);
		str_ptr = 0;

		int_buf = DataUtil.entry_extract("integer.dat", 0, archive);
		int_ptr = 0;
	
		item_cnt = short_get();
		item_name = new String[item_cnt];
		item_desc = new String[item_cnt];
		item_action = new String[item_cnt];
		item_sprite = new int[item_cnt];
		item_value = new int[item_cnt];
		item_stackable = new int[item_cnt];
		item_unused = new int[item_cnt];
		item_equip_mask = new int[item_cnt];
		item_tint = new int[item_cnt];
		item_tradable = new int[item_cnt];
		item_members = new int[item_cnt];

		for (int i = 0; i < item_cnt; ++i) {
			item_name[i] = str_get();
		}

		for (int i = 0; i < item_cnt; ++i) {
			item_desc[i] = str_get();
		}

		for (int i = 0; i < item_cnt; ++i) {
			item_action[i] = str_get();
		}

		for (int i = 0; i < item_cnt; ++i) {
			item_sprite[i] = short_get();
	
			if (item_sprite[i] + 1 > item_max_sprite) {
				item_max_sprite = item_sprite[i] + 1;
			}
		}

		for (int i = 0; i < item_cnt; ++i) {
			item_value[i] = int_get();
		}

		for (int i = 0; i < item_cnt; ++i) {
			item_stackable[i] = byte_get();
		}

		for (int i = 0; i < item_cnt; ++i) {
			item_unused[i] = byte_get();
		}

		for (int i = 0; i < item_cnt; ++i) {
			item_equip_mask[i] = short_get();
		}

		for (int i = 0; i < item_cnt; ++i) {
			item_tint[i] = int_get();
		}

		for (int i = 0; i < item_cnt; ++i) {
			item_tradable[i] = byte_get();
		}

		for (int i = 0; i < item_cnt; ++i) {
			item_members[i] = byte_get();
		}

		for (int i = 0; i < item_cnt; ++i) {
			if (!is_members && item_members[i] == 1) {
				item_name[i] = "Members object";
				item_desc[i] = "You need to be a member to use this object";
				item_value[i] = 0;
				item_action[i] = "";
				item_unused[0] = 0;
				item_equip_mask[i] = 0;
				item_tradable[i] = 1;
			}
		}

		npc_cnt = short_get();
		npc_name = new String[npc_cnt];
		npc_action = new String[npc_cnt];
		npc_atk_lvl = new int[npc_cnt];
		npc_def_lvl = new int[npc_cnt];
		npc_str_lvl = new int[npc_cnt];
		npc_hit_lvl = new int[npc_cnt];
		npc_attackable = new int[npc_cnt];
		npc_sprites = new int[npc_cnt][12];
		npc_col_hair = new int[npc_cnt];
		npc_col_top = new int[npc_cnt];
		npc_col_bottom = new int[npc_cnt];
		npc_col_skin = new int[npc_cnt];
		npc_width = new int[npc_cnt];
		npc_height = new int[npc_cnt];
		npc_speed_walk = new int[npc_cnt];
		npc_speed_cmb = new int[npc_cnt];
		npc_cmb_anim = new int[npc_cnt];

		for (int i = 0; i < npc_cnt; ++i) {
			npc_name[i] = str_get();
		}

		for (int i = 0; i < npc_cnt; ++i) {
			npc_action[i] = str_get();
		}

		for (int i = 0; i < npc_cnt; ++i) {
			npc_atk_lvl[i] = byte_get();
		}

		for (int i = 0; i < npc_cnt; ++i) {
			npc_def_lvl[i] = byte_get();
		}

		for (int i = 0; i < npc_cnt; ++i) {
			npc_str_lvl[i] = byte_get();
		}

		for (int i = 0; i < npc_cnt; ++i) {
			npc_hit_lvl[i] = byte_get();
		}

		for (int i = 0; i < npc_cnt; ++i) {
			npc_attackable[i] = byte_get();
		}

		for (int i = 0; i < npc_cnt; ++i) {
			for (int j = 0; j < 12; ++j) {
				npc_sprites[i][j] = byte_get();

				if (npc_sprites[i][j] == 255) {
					npc_sprites[i][j] = -1;
				}
			}
		}

		for (int i = 0; i < npc_cnt; ++i) {
			npc_col_hair[i] = int_get();
		}

		for (int i = 0; i < npc_cnt; ++i) {
			npc_col_top[i] = int_get();
		}

		for (int i = 0; i < npc_cnt; ++i) {
			npc_col_bottom[i] = int_get();
		}

		for (int i = 0; i < npc_cnt; ++i) {
			npc_col_skin[i] = int_get();
		}

		for (int i = 0; i < npc_cnt; ++i) {
			npc_width[i] = short_get();
		}

		for (int i = 0; i < npc_cnt; ++i) {
			npc_height[i] = short_get();
		}

		for (int i = 0; i < npc_cnt; ++i) {
			npc_speed_walk[i] = byte_get();
		}

		for (int i = 0; i < npc_cnt; ++i) {
			npc_speed_cmb[i] = byte_get();
		}

		for (int i = 0; i < npc_cnt; ++i) {
			npc_cmb_anim[i] = byte_get();
		}

		texture_cnt = short_get();
		texture_name = new String[texture_cnt];
		texture_type = new String[texture_cnt];

		for (int i = 0; i < texture_cnt; ++i) {
			texture_name[i] = str_get();
		}

		for (int i = 0; i < texture_cnt; ++i) {
			texture_type[i] = str_get();
		}

		anim_cnt = short_get();
		anim_name = new String[anim_cnt];
		anim_mask = new int[anim_cnt];
		anim_unknown1 = new int[anim_cnt];
		anim_has_a = new int[anim_cnt];
		anim_has_f = new int[anim_cnt];
		anim_unknown2 = new int[anim_cnt];

		for (int var33 = 0; var33 < anim_cnt; ++var33) {
			anim_name[var33] = str_get();
		}

		for (int var34 = 0; var34 < anim_cnt; ++var34) {
			anim_mask[var34] = int_get();
		}

		for (int var35 = 0; var35 < anim_cnt; ++var35) {
			anim_unknown1[var35] = byte_get();
		}

		for (int var36 = 0; var36 < anim_cnt; ++var36) {
			anim_has_a[var36] = byte_get();
		}

		for (int var37 = 0; var37 < anim_cnt; ++var37) {
			anim_has_f[var37] = byte_get();
		}

		for (int var38 = 0; var38 < anim_cnt; ++var38) {
			anim_unknown2[var38] = byte_get();
		}

		obj_cnt = short_get();
		obj_name = new String[obj_cnt];
		obj_desc = new String[obj_cnt];
		obj_action1 = new String[obj_cnt];
		obj_action2 = new String[obj_cnt];
		obj_model = new int[obj_cnt];
		obj_width = new int[obj_cnt];
		obj_height = new int[obj_cnt];
		obj_type = new int[obj_cnt];
		obj_elevation = new int[obj_cnt];

		for (int i = 0; i < obj_cnt; ++i) {
			obj_name[i] = str_get();
		}

		for (int i = 0; i < obj_cnt; ++i) {
			obj_desc[i] = str_get();
		}

		for (int i = 0; i < obj_cnt; ++i) {
			obj_action1[i] = str_get();
		}

		for (int i = 0; i < obj_cnt; ++i) {
			obj_action2[i] = str_get();
		}

		for (int i = 0; i < obj_cnt; ++i) {
			obj_model[i] = model_lookup(str_get());
		}

		for (int i = 0; i < obj_cnt; ++i) {
			obj_width[i] = byte_get();
		}

		for (int i = 0; i < obj_cnt; ++i) {
			obj_height[i] = byte_get();
		}

		for (int i = 0; i < obj_cnt; ++i) {
			obj_type[i] = byte_get();
		}

		for (int i = 0; i < obj_cnt; ++i) {
			obj_elevation[i] = byte_get();
		}

		bound_cnt = short_get();
		bound_name = new String[bound_cnt];
		bound_desc = new String[bound_cnt];
		bound_action1 = new String[bound_cnt];
		bound_action2 = new String[bound_cnt];
		bound_size = new int[bound_cnt];
		bound_tex_front = new int[bound_cnt];
		bound_tex_back = new int[bound_cnt];
		bound_adjacent = new int[bound_cnt];
		bound_invis = new int[bound_cnt];

		for (int i = 0; i < bound_cnt; ++i) {
			bound_name[i] = str_get();
		}

		for (int i = 0; i < bound_cnt; ++i) {
			bound_desc[i] = str_get();
		}

		for (int i = 0; i < bound_cnt; ++i) {
			bound_action1[i] = str_get();
		}

		for (int i = 0; i < bound_cnt; ++i) {
			bound_action2[i] = str_get();
		}

		for (int i = 0; i < bound_cnt; ++i) {
			bound_size[i] = short_get();
		}

		for (int i = 0; i < bound_cnt; ++i) {
			bound_tex_front[i] = int_get();
		}

		for (int i = 0; i < bound_cnt; ++i) {
			bound_tex_back[i] = int_get();
		}

		for (int i = 0; i < bound_cnt; ++i) {
			bound_adjacent[i] = byte_get();
		}

		for (int i = 0; i < bound_cnt; ++i) {
			bound_invis[i] = byte_get();
		}

		roof_cnt = short_get();
		roof_size = new int[roof_cnt];
		roof_vert_cnt = new int[roof_cnt];

		for (int i = 0; i < roof_cnt; ++i) {
			roof_size[i] = byte_get();
		}

		for (int i = 0; i < roof_cnt; ++i) {
			roof_vert_cnt[i] = byte_get();
		}

		tile_cnt = short_get();
		tile_decoration = new int[tile_cnt];
		tile_type = new int[tile_cnt];
		tile_adjacent = new int[tile_cnt];

		for (int i = 0; i < tile_cnt; ++i) {
			tile_decoration[i] = int_get();
		}

		for (int i = 0; i < tile_cnt; ++i) {
			tile_type[i] = byte_get();
		}

		for (int i = 0; i < tile_cnt; ++i) {
			tile_adjacent[i] = byte_get();
		}

		proj_sprite_cnt = short_get();
		
		spell_cnt = short_get();
		spell_name = new String[spell_cnt];
		spell_desc = new String[spell_cnt];
		spell_lvl = new int[spell_cnt];
		spell_runes = new int[spell_cnt];
		spell_type = new int[spell_cnt];
		spell_rune_ids = new int[spell_cnt][];
		spell_rune_cnts = new int[spell_cnt][];

		for (int i = 0; i < spell_cnt; ++i) {
			spell_name[i] = str_get();
		}

		for (int i = 0; i < spell_cnt; ++i) {
			spell_desc[i] = str_get();
		}

		for (int i = 0; i < spell_cnt; ++i) {
			spell_lvl[i] = byte_get();
		}

		for (int i = 0; i < spell_cnt; ++i) {
			spell_runes[i] = byte_get();
		}

		for (int i = 0; i < spell_cnt; ++i) {
			spell_type[i] = byte_get();
		}

		for (int i = 0; i < spell_cnt; ++i) {
			int size = byte_get();
			spell_rune_ids[i] = new int[size];

			for (int j = 0; j < size; ++j) {
				spell_rune_ids[i][j] = short_get();
			}
		}

		for (int i = 0; i < spell_cnt; ++i) {
			int size = byte_get();
			spell_rune_cnts[i] = new int[size];

			for (int j = 0; j < size; ++j) {
				spell_rune_cnts[i][j] = byte_get();
			}
		}

		prayer_cnt = short_get();
		prayer_name = new String[prayer_cnt];
		prayer_desc = new String[prayer_cnt];
		prayer_lvl = new int[prayer_cnt];
		prayer_drain = new int[prayer_cnt];

		for (int i = 0; i < prayer_cnt; ++i) {
			prayer_name[i] = str_get();
		}

		for (int i = 0; i < prayer_cnt; ++i) {
			prayer_desc[i] = str_get();
		}

		for (int i = 0; i < prayer_cnt; ++i) {
			prayer_lvl[i] = byte_get();
		}

		for (int i = 0; i < prayer_cnt; ++i) {
			prayer_drain[i] = byte_get();
		}

		byte[] words = DataUtil.entry_extract("words.txt", 0, archive);
		read_words(words, 0);
		
		byte[] badwords = DataUtil.entry_extract("badwords.txt", 0, archive);
		read_badwords(badwords, 0);
		
		str_buf = null;
		int_buf = null;
	}

	public static void read_words(byte[] buf, int ptr) {
		try {
			while (true) {
				String word = "";
				
				while (buf[ptr] != 13) {
					word += (char) buf[ptr++];
				}
	
				ptr += 1;
				
				if (buf[ptr] == 10) {
					ptr += 1;
				}
	
				if (!word.equals("-EOF-") && word != null && word.length() > 0) {
					break;
				}
				word_good[word_good_cnt++] = word;
			}
		} catch (Exception error) {
			DataUtil.replacement_term_cnt = word_good_cnt;
			DataUtil.replacements = word_good;	
		}
	}

	public static void read_badwords(byte[] buf, int ptr) {
		try {
			while (true) {
				String word = "";
				
				while (buf[ptr] != 13) {
					word += (char) buf[ptr++];
				}
	
				ptr += 1;
				
				if (buf[ptr] == 10) {
					++ptr;
				}
	
				if (!word.equals("-EOF-") && word != null && word.length() > 0) {
					break;
				}
				word_bad[word_bad_cnt++] = word;
			}
		} catch (Exception error) {
			String[] vowels = new String[] { "a", "e", "i", "o", "u" };
			int cnt = word_bad_cnt;
	
			for (int i = 0; i < cnt; ++i) {
				String word = word_bad[i];
				
				if (word.length() >= 5) {
					for (int j = 1; j < word.length() - 1; ++j) {
						char ch = word.charAt(j);
						String variant;
						if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u' || ch == 'y') {
							for (int k = 0; k < 5; ++k) {
								variant = vowels[k];
								if (variant.charAt(0) != ch) {
									String var10 = word.substring(0, j) + variant + word.substring(j + 1);
									word_bad[word_bad_cnt++] = var10;
									var10 = word.substring(0, j) + variant + ch + word.substring(j + 1);
									word_bad[word_bad_cnt++] = var10;
								}
							}
	
							variant = word.substring(0, j) + word.substring(j + 1);
							word_bad[word_bad_cnt++] = variant;
						}
	
						char var13 = word.charAt(j + 1);
						variant = word.substring(0, j) + var13 + ch + word.substring(j + 2);
						word_bad[word_bad_cnt++] = variant;
					}
				}
			}
	
			DataUtil.search_term_cnt = word_bad_cnt;
			DataUtil.search_terms = word_bad;
		}
	}
}
