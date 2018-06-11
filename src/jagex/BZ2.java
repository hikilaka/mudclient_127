package jagex;

public class BZ2 {
	static final int field_529 = 1;
	static final int field_530 = 2;
	static final int field_531 = 10;
	static final int field_532 = 14;
	static final int field_533 = 0;
	static final int field_534 = 4;
	static final int field_535 = 4096;
	static final int field_536 = 16;
	static final int field_537 = 258;
	static final int field_538 = 23;
	static final int field_539 = 0;
	static final int field_540 = 1;
	static final int field_541 = 6;
	static final int field_542 = 50;
	static final int field_543 = 4;
	static final int field_544 = 18002;

	public static int decompress(byte[] out, int out_sz, byte[] in, int in_sz, int in_off) {
		BZ2Context ctx = new BZ2Context();
		ctx.in_buf = in;
		ctx.in_buf_pos = in_off;
		ctx.out_buf = out;
		ctx.field_226 = 0;
		ctx.in_buf_sz = in_sz;
		ctx.out_buf_sz = out_sz;
		ctx.in_buf_bit_cnt = 0;
		ctx.in_buf_bits = 0;
		ctx.field_223 = 0;
		ctx.field_224 = 0;
		ctx.field_228 = 0;
		ctx.field_229 = 0;
		ctx.field_236 = 0;
		
		do_decode(ctx);
		
		out_sz -= ctx.out_buf_sz;
		return out_sz;
	}

	private static void method_330(BZ2Context var0) {
		byte var2 = var0.field_230;
		int var3 = var0.field_231;
		int var4 = var0.field_241;
		int var5 = var0.field_239;
		int[] var6 = BZ2Context.d_buf;
		int var7 = var0.field_238;
		byte[] var8 = var0.out_buf;
		int var9 = var0.field_226;
		int var10 = var0.out_buf_sz;
		int var12 = var0.field_258 + 1;

		label67: while (true) {
			if (var3 > 0) {
				while (true) {
					if (var10 == 0) {
						break label67;
					}

					if (var3 == 1) {
						if (var10 == 0) {
							var3 = 1;
							break label67;
						}

						var8[var9] = var2;
						++var9;
						--var10;
						break;
					}

					var8[var9] = var2;
					--var3;
					++var9;
					--var10;
				}
			}

			boolean var14 = true;

			byte var1;
			while (var14) {
				var14 = false;
				if (var4 == var12) {
					var3 = 0;
					break label67;
				}

				var2 = (byte) var5;
				var7 = var6[var7];
				var1 = (byte) (var7 & 255);
				var7 >>= 8;
				++var4;
				if (var1 != var5) {
					var5 = var1;
					if (var10 == 0) {
						var3 = 1;
						break label67;
					}

					var8[var9] = var2;
					++var9;
					--var10;
					var14 = true;
				} else if (var4 == var12) {
					if (var10 == 0) {
						var3 = 1;
						break label67;
					}

					var8[var9] = var2;
					++var9;
					--var10;
					var14 = true;
				}
			}

			var3 = 2;
			var7 = var6[var7];
			var1 = (byte) (var7 & 255);
			var7 >>= 8;
			++var4;
			if (var4 != var12) {
				if (var1 != var5) {
					var5 = var1;
				} else {
					var3 = 3;
					var7 = var6[var7];
					var1 = (byte) (var7 & 255);
					var7 >>= 8;
					++var4;
					if (var4 != var12) {
						if (var1 != var5) {
							var5 = var1;
						} else {
							var7 = var6[var7];
							var1 = (byte) (var7 & 255);
							var7 >>= 8;
							++var4;
							var3 = (var1 & 255) + 4;
							var7 = var6[var7];
							var5 = (byte) (var7 & 255);
							var7 >>= 8;
							++var4;
						}
					}
				}
			}
		}

		int var13 = var0.field_228;
		var0.field_228 += var10 - var10;
		if (var0.field_228 < var13) {
			++var0.field_229;
		}

		var0.field_230 = var2;
		var0.field_231 = var3;
		var0.field_241 = var4;
		var0.field_239 = var5;
		BZ2Context.d_buf = var6;
		var0.field_238 = var7;
		var0.out_buf = var8;
		var0.field_226 = var9;
		var0.out_buf_sz = var10;
	}


	private static void do_decode(BZ2Context ctx) {
		int var23 = 0;
		int[] var24 = null;
		int[] var25 = null;
		int[] var26 = null;

		ctx.block_sz = 1;
		
		if (BZ2Context.d_buf == null) {
			BZ2Context.d_buf = new int[ctx.block_sz * 100000];
		}

		boolean var27 = true;

		while (true) {
			while (var27) {
				byte var1 = get_byte(ctx);

				if (var1 == 23) {
					return;
				}

				var1 = get_byte(ctx);
				var1 = get_byte(ctx);
				var1 = get_byte(ctx);
				var1 = get_byte(ctx);
				var1 = get_byte(ctx);
				++ctx.field_236;
				var1 = get_byte(ctx);
				var1 = get_byte(ctx);
				var1 = get_byte(ctx);
				var1 = get_byte(ctx);
				var1 = get_bit(ctx);
				if (var1 != 0) {
					ctx.field_232 = true;
				} else {
					ctx.field_232 = false;
				}

				if (ctx.field_232) {
					System.out.println("PANIC! RANDOMISED BLOCK!");
				}

				ctx.field_237 = 0;
				var1 = get_byte(ctx);
				ctx.field_237 = ctx.field_237 << 8 | var1 & 255;
				var1 = get_byte(ctx);
				ctx.field_237 = ctx.field_237 << 8 | var1 & 255;
				var1 = get_byte(ctx);
				ctx.field_237 = ctx.field_237 << 8 | var1 & 255;

				int var42;
				for (var42 = 0; var42 < 16; ++var42) {
					var1 = get_bit(ctx);
					if (var1 == 1) {
						ctx.field_247[var42] = true;
					} else {
						ctx.field_247[var42] = false;
					}
				}

				for (var42 = 0; var42 < 256; ++var42) {
					ctx.field_246[var42] = false;
				}

				int var43;
				for (var42 = 0; var42 < 16; ++var42) {
					if (ctx.field_247[var42]) {
						for (var43 = 0; var43 < 16; ++var43) {
							var1 = get_bit(ctx);
							if (var1 == 1) {
								ctx.field_246[var42 * 16 + var43] = true;
							}
						}
					}
				}

				method_336(ctx);
				int var45 = ctx.field_245 + 2;
				int var46 = get_bits(3, ctx);
				int var47 = get_bits(15, ctx);

				for (var42 = 0; var42 < var47; ++var42) {
					var43 = 0;

					while (true) {
						var1 = get_bit(ctx);
						if (var1 == 0) {
							ctx.field_252[var42] = (byte) var43;
							break;
						}

						++var43;
					}
				}

				byte[] var28 = new byte[6];

				byte var30;
				for (var30 = 0; var30 < var46; var28[var30] = var30++) {
					;
				}

				for (var42 = 0; var42 < var47; ++var42) {
					var30 = ctx.field_252[var42];

					byte var29;
					for (var29 = var28[var30]; var30 > 0; --var30) {
						var28[var30] = var28[var30 - 1];
					}

					var28[0] = var29;
					ctx.field_251[var42] = var29;
				}

				int var44;
				for (var44 = 0; var44 < var46; ++var44) {
					int var57 = get_bits(5, ctx);

					for (var42 = 0; var42 < var45; ++var42) {
						while (true) {
							var1 = get_bit(ctx);
							if (var1 == 0) {
								ctx.field_253[var44][var42] = (byte) var57;
								break;
							}

							var1 = get_bit(ctx);
							if (var1 == 0) {
								++var57;
							} else {
								--var57;
							}
						}
					}
				}

				for (var44 = 0; var44 < var46; ++var44) {
					byte var2 = 32;
					byte var3 = 0;

					for (var42 = 0; var42 < var45; ++var42) {
						if (ctx.field_253[var44][var42] > var3) {
							var3 = ctx.field_253[var44][var42];
						}

						if (ctx.field_253[var44][var42] < var2) {
							var2 = ctx.field_253[var44][var42];
						}
					}

					method_337(ctx.field_254[var44], ctx.field_255[var44], ctx.field_256[var44],
							ctx.field_253[var44], var2, var3, var45);
					ctx.field_257[var44] = var2;
				}

				int var48 = ctx.field_245 + 1;
				int var53 = 100000 * ctx.block_sz;
				int var49 = -1;
				byte var50 = 0;

				for (var42 = 0; var42 <= 255; ++var42) {
					ctx.crc32_table[var42] = 0;
				}

				int var33 = 4095;

				for (int var31 = 15; var31 >= 0; --var31) {
					for (int var32 = 15; var32 >= 0; --var32) {
						ctx.not_out_buf[var33] = (byte) (var31 * 16 + var32);
						--var33;
					}

					ctx.field_250[var31] = var33 + 1;
				}

				int var54 = 0;
				byte var61;
				if (var50 == 0) {
					++var49;
					var50 = 50;
					var61 = ctx.field_251[var49];
					var23 = ctx.field_257[var61];
					var24 = ctx.field_254[var61];
					var26 = ctx.field_256[var61];
					var25 = ctx.field_255[var61];
				}

				int sym_cnt = var50 - 1;
				int var58 = var23;

				int var59;
				byte var60;
				for (var59 = get_bits(var23, ctx); var59 > var24[var58]; var59 = var59 << 1 | var60) {
					++var58;
					var60 = get_bit(ctx);
				}

				int var52 = var26[var59 - var25[var58]];

				while (true) {
					while (var52 != var48) {
						if (var52 != 0 && var52 != 1) {
							int var40 = var52 - 1;
							int var37;
							if (var40 < 16) {
								var37 = ctx.field_250[0];

								for (var1 = ctx.not_out_buf[var37 + var40]; var40 > 3; var40 -= 4) {
									int var41 = var37 + var40;
									ctx.not_out_buf[var41] = ctx.not_out_buf[var41 - 1];
									ctx.not_out_buf[var41 - 1] = ctx.not_out_buf[var41 - 2];
									ctx.not_out_buf[var41 - 2] = ctx.not_out_buf[var41 - 3];
									ctx.not_out_buf[var41 - 3] = ctx.not_out_buf[var41 - 4];
								}

								while (var40 > 0) {
									ctx.not_out_buf[var37 + var40] = ctx.not_out_buf[var37 + var40 - 1];
									--var40;
								}

								ctx.not_out_buf[var37] = var1;
							} else {
								int var38 = var40 / 16;
								int var39 = var40 % 16;
								var37 = ctx.field_250[var38] + var39;

								for (var1 = ctx.not_out_buf[var37]; var37 > ctx.field_250[var38]; --var37) {
									ctx.not_out_buf[var37] = ctx.not_out_buf[var37 - 1];
								}

								++ctx.field_250[var38];

								while (var38 > 0) {
									--ctx.field_250[var38];
									ctx.not_out_buf[ctx.field_250[var38]] = ctx.not_out_buf[ctx.field_250[var38 - 1]
											+ 16 - 1];
									--var38;
								}

								--ctx.field_250[0];
								ctx.not_out_buf[ctx.field_250[0]] = var1;
								if (ctx.field_250[0] == 0) {
									int var36 = 4095;

									for (int var34 = 15; var34 >= 0; --var34) {
										for (int var35 = 15; var35 >= 0; --var35) {
											ctx.not_out_buf[var36] = ctx.not_out_buf[ctx.field_250[var34] + var35];
											--var36;
										}

										ctx.field_250[var34] = var36 + 1;
									}
								}
							}

							++ctx.crc32_table[ctx.field_248[var1 & 255] & 255];
							BZ2Context.d_buf[var54] = ctx.field_248[var1 & 255] & 255;
							++var54;
							if (sym_cnt == 0) {
								++var49;
								sym_cnt = 50;
								var61 = ctx.field_251[var49];
								var23 = ctx.field_257[var61];
								var24 = ctx.field_254[var61];
								var26 = ctx.field_256[var61];
								var25 = ctx.field_255[var61];
							}

							--sym_cnt;
							var58 = var23;

							for (var59 = get_bits(var23, ctx); var59 > var24[var58]; var59 = var59 << 1 | var60) {
								++var58;
								var60 = get_bit(ctx);
							}

							var52 = var26[var59 - var25[var58]];
						} else {
							int var55 = -1;
							int var56 = 1;

							do {
								if (var52 == 0) {
									var55 += var56;
								} else if (var52 == 1) {
									var55 += 2 * var56;
								}

								var56 *= 2;

								if (sym_cnt == 0) {
									++var49;
									sym_cnt = 50;
									var61 = ctx.field_251[var49];
									var23 = ctx.field_257[var61];
									var24 = ctx.field_254[var61];
									var26 = ctx.field_256[var61];
									var25 = ctx.field_255[var61];
								}

								--sym_cnt;
								var58 = var23;

								for (var59 = get_bits(var23, ctx); var59 > var24[var58]; var59 = var59 << 1
										| var60) {
									++var58;
									var60 = get_bit(ctx);
								}

								var52 = var26[var59 - var25[var58]];
							} while (var52 == 0 || var52 == 1);

							++var55;
							var1 = ctx.field_248[ctx.not_out_buf[ctx.field_250[0]] & 255];

							for (ctx.crc32_table[var1 & 255] += var55; var55 > 0; --var55) {
								BZ2Context.d_buf[var54] = var1 & 255;
								++var54;
							}
						}
					}

					ctx.field_231 = 0;
					ctx.field_230 = 0;
					ctx.field_242[0] = 0;

					for (var42 = 1; var42 <= 256; ++var42) {
						ctx.field_242[var42] = ctx.crc32_table[var42 - 1];
					}

					for (var42 = 1; var42 <= 256; ++var42) {
						ctx.field_242[var42] += ctx.field_242[var42 - 1];
					}

					for (var42 = 0; var42 < var54; ++var42) {
						var1 = (byte) (BZ2Context.d_buf[var42] & 255);
						BZ2Context.d_buf[ctx.field_242[var1 & 255]] |= var42 << 8;
						++ctx.field_242[var1 & 255];
					}

					ctx.field_238 = BZ2Context.d_buf[ctx.field_237] >> 8;
					ctx.field_241 = 0;
					ctx.field_238 = BZ2Context.d_buf[ctx.field_238];
					ctx.field_239 = (byte) (ctx.field_238 & 255);
					ctx.field_238 >>= 8;
					++ctx.field_241;
					ctx.field_258 = var54;
					method_330(ctx);
					if (ctx.field_241 == ctx.field_258 + 1 && ctx.field_231 == 0) {
						var27 = true;
						break;
					}

					var27 = false;
					break;
				}
			}

			return;
		}
	}

	private static byte get_byte(BZ2Context ctx) {
		return (byte) get_bits(8, ctx);
	}

	private static byte get_bit(BZ2Context ctx) {
		return (byte) get_bits(1, ctx);
	}

	private static int get_bits(int bits_wanted, BZ2Context ctx) {
		while (ctx.in_buf_bit_cnt < bits_wanted) {
			ctx.in_buf_bits = ctx.in_buf_bits << 8 | ctx.in_buf[ctx.in_buf_pos] & 255;
			ctx.in_buf_bit_cnt += 8;
			++ctx.in_buf_pos;
			--ctx.in_buf_sz;
			++ctx.field_223;
			
			if (ctx.field_223 == 0) {
				++ctx.field_224;
			}
		}

		int bits = ctx.in_buf_bits >> ctx.in_buf_bit_cnt - bits_wanted & (1 << bits_wanted) - 1;
		ctx.in_buf_bit_cnt -= bits_wanted;
		return bits;
	}

	private static void method_336(BZ2Context var0) {
		var0.field_245 = 0;

		for (int var1 = 0; var1 < 256; ++var1) {
			if (var0.field_246[var1]) {
				var0.field_248[var0.field_245] = (byte) var1;
				++var0.field_245;
			}
		}

	}

	private static void method_337(int[] var0, int[] var1, int[] var2, byte[] var3, int var4, int var5, int var6) {
		int var7 = 0;

		int var8;
		for (var8 = var4; var8 <= var5; ++var8) {
			for (int var9 = 0; var9 < var6; ++var9) {
				if (var3[var9] == var8) {
					var2[var7] = var9;
					++var7;
				}
			}
		}

		for (var8 = 0; var8 < 23; ++var8) {
			var1[var8] = 0;
		}

		for (var8 = 0; var8 < var6; ++var8) {
			++var1[var3[var8] + 1];
		}

		for (var8 = 1; var8 < 23; ++var8) {
			var1[var8] += var1[var8 - 1];
		}

		for (var8 = 0; var8 < 23; ++var8) {
			var0[var8] = 0;
		}

		int var10 = 0;

		for (var8 = var4; var8 <= var5; ++var8) {
			var10 += var1[var8 + 1] - var1[var8];
			var0[var8] = var10 - 1;
			var10 <<= 1;
		}

		for (var8 = var4 + 1; var8 <= var5; ++var8) {
			var1[var8] = (var0[var8 - 1] + 1 << 1) - var1[var8];
		}
	}
}
