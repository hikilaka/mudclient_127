package jagex.client;

// $FF: renamed from: jagex.client.p
public class class_9 {
   // $FF: renamed from: or jagex.client.j
   protected class_1 field_346;
   // $FF: renamed from: pr int
   int field_347;
   // $FF: renamed from: qr int
   int field_348;
   // $FF: renamed from: rr boolean[]
   public boolean[] field_349;
   // $FF: renamed from: sr boolean[]
   public boolean[] field_350;
   // $FF: renamed from: tr boolean[]
   public boolean[] field_351;
   // $FF: renamed from: ur boolean[]
   public boolean[] field_352;
   // $FF: renamed from: vr int[]
   public int[] field_353;
   // $FF: renamed from: wr int[]
   public int[] field_354;
   // $FF: renamed from: xr int[]
   public int[] field_355;
   // $FF: renamed from: yr int[]
   public int[] field_356;
   // $FF: renamed from: zr boolean[]
   boolean[] field_357;
   // $FF: renamed from: as int[]
   int[] field_358;
   // $FF: renamed from: bs int[]
   int[] field_359;
   // $FF: renamed from: cs int[]
   int[] field_360;
   // $FF: renamed from: ds int[]
   int[] field_361;
   // $FF: renamed from: es int[]
   int[] field_362;
   // $FF: renamed from: fs int[]
   int[] field_363;
   // $FF: renamed from: gs int[]
   int[] field_364;
   // $FF: renamed from: hs java.lang.String[]
   String[] field_365;
   // $FF: renamed from: is java.lang.String[][]
   String[][] field_366;
   // $FF: renamed from: js int
   int field_367;
   // $FF: renamed from: ks int
   int field_368;
   // $FF: renamed from: ls int
   int field_369;
   // $FF: renamed from: ms int
   int field_370;
   // $FF: renamed from: ns int
   int field_371 = -1;
   // $FF: renamed from: os int
   int field_372;
   // $FF: renamed from: ps int
   int field_373;
   // $FF: renamed from: qs int
   int field_374;
   // $FF: renamed from: rs int
   int field_375;
   // $FF: renamed from: ss int
   int field_376;
   // $FF: renamed from: ts int
   int field_377;
   // $FF: renamed from: us int
   int field_378;
   // $FF: renamed from: vs int
   int field_379;
   // $FF: renamed from: ws int
   int field_380;
   // $FF: renamed from: xs int
   int field_381;
   // $FF: renamed from: ys int
   int field_382;
   // $FF: renamed from: zs int
   int field_383;
   // $FF: renamed from: at int
   int field_384;
   // $FF: renamed from: bt boolean
   public boolean field_385 = true;
   // $FF: renamed from: ct boolean
   public static boolean field_386 = true;
   // $FF: renamed from: dt int
   public static int field_387;
   // $FF: renamed from: et int
   public static int field_388 = 114;
   // $FF: renamed from: ft int
   public static int field_389 = 114;
   // $FF: renamed from: gt int
   public static int field_390 = 176;
   // $FF: renamed from: ht int
   public static int field_391;

   public class_9(class_1 var1, int var2) {
      super();
      this.field_346 = var1;
      this.field_348 = var2;
      this.field_349 = new boolean[var2];
      this.field_350 = new boolean[var2];
      this.field_351 = new boolean[var2];
      this.field_352 = new boolean[var2];
      this.field_357 = new boolean[var2];
      this.field_353 = new int[var2];
      this.field_354 = new int[var2];
      this.field_355 = new int[var2];
      this.field_356 = new int[var2];
      this.field_358 = new int[var2];
      this.field_359 = new int[var2];
      this.field_360 = new int[var2];
      this.field_361 = new int[var2];
      this.field_362 = new int[var2];
      this.field_363 = new int[var2];
      this.field_364 = new int[var2];
      this.field_365 = new String[var2];
      this.field_366 = new String[var2][];
      this.field_373 = this.method_278(114, 114, 176);
      this.field_374 = this.method_278(14, 14, 62);
      this.field_375 = this.method_278(200, 208, 232);
      this.field_376 = this.method_278(96, 129, 184);
      this.field_377 = this.method_278(53, 95, 115);
      this.field_378 = this.method_278(117, 142, 171);
      this.field_379 = this.method_278(98, 122, 158);
      this.field_380 = this.method_278(86, 100, 136);
      this.field_381 = this.method_278(135, 146, 179);
      this.field_382 = this.method_278(97, 112, 151);
      this.field_383 = this.method_278(88, 102, 136);
      this.field_384 = this.method_278(84, 93, 120);
   }

   // $FF: renamed from: yk (int, int, int) int
   public int method_278(int var1, int var2, int var3) {
      return class_1.method_43(field_388 * var1 / 114, field_389 * var2 / 114, field_390 * var3 / 176);
   }

   // $FF: renamed from: gk () void
   public void method_279() {
      this.field_369 = 0;
   }

   // $FF: renamed from: dk (int, int, int, int) void
   public void method_280(int var1, int var2, int var3, int var4) {
      this.field_367 = var1;
      this.field_368 = var2;
      this.field_370 = var4;
      if (var3 != 0) {
         this.field_369 = var3;
      }

      int var5;
      if (var3 == 1) {
         for(var5 = 0; var5 < this.field_347; ++var5) {
            if (this.field_349[var5] && this.field_360[var5] == 10 && this.field_367 >= this.field_358[var5] && this.field_368 >= this.field_359[var5] && this.field_367 <= this.field_358[var5] + this.field_361[var5] && this.field_368 <= this.field_359[var5] + this.field_362[var5]) {
               this.field_352[var5] = true;
            }

            if (this.field_349[var5] && this.field_360[var5] == 14 && this.field_367 >= this.field_358[var5] && this.field_368 >= this.field_359[var5] && this.field_367 <= this.field_358[var5] + this.field_361[var5] && this.field_368 <= this.field_359[var5] + this.field_362[var5]) {
               this.field_355[var5] = 1 - this.field_355[var5];
            }
         }
      }

      if (var4 == 1) {
         ++this.field_372;
      } else {
         this.field_372 = 0;
      }

      if (var3 == 1 || this.field_372 > 20) {
         for(var5 = 0; var5 < this.field_347; ++var5) {
            if (this.field_349[var5] && this.field_360[var5] == 15 && this.field_367 >= this.field_358[var5] && this.field_368 >= this.field_359[var5] && this.field_367 <= this.field_358[var5] + this.field_361[var5] && this.field_368 <= this.field_359[var5] + this.field_362[var5]) {
               this.field_352[var5] = true;
            }
         }

         this.field_372 -= 5;
      }

   }

   // $FF: renamed from: fk (int) boolean
   public boolean method_281(int var1) {
      if (this.field_349[var1] && this.field_352[var1]) {
         this.field_352[var1] = false;
         return true;
      } else {
         return false;
      }
   }

   // $FF: renamed from: wj (int) void
   public void method_282(int var1) {
      if (var1 != 0) {
         if (this.field_371 != -1 && this.field_365[this.field_371] != null && this.field_349[this.field_371]) {
            int var2 = this.field_365[this.field_371].length();
            if (var1 == 8 && var2 > 0) {
               this.field_365[this.field_371] = this.field_365[this.field_371].substring(0, var2 - 1);
            }

            if ((var1 == 10 || var1 == 13) && var2 > 0) {
               this.field_352[this.field_371] = true;
            }

            String var3 = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!\"\u00a3$%^&*()-_=+[{]};:'@#~,<.>/?\\| ";
            if (var2 < this.field_363[this.field_371]) {
               for(int var4 = 0; var4 < var3.length(); ++var4) {
                  if (var1 == var3.charAt(var4)) {
                     StringBuffer var10000 = new StringBuffer;
                     String[] var5 = this.field_365;
                     int var6 = this.field_371;
                     var10000.<init>(String.valueOf(this.field_365[this.field_371]));
                     var5[var6] = var10000.append((char)var1).toString();
                  }
               }
            }

            if (var1 == 9) {
               while(true) {
                  this.field_371 = (this.field_371 + 1) % this.field_347;
                  if (this.field_360[this.field_371] == 5) {
                     break;
                  }

                  if (this.field_360[this.field_371] == 6) {
                     return;
                  }
               }
            }
         }

      }
   }

   // $FF: renamed from: ck () void
   public void method_283() {
      for(int var1 = 0; var1 < this.field_347; ++var1) {
         if (this.field_349[var1]) {
            if (this.field_360[var1] == 0) {
               this.method_285(var1, this.field_358[var1], this.field_359[var1], this.field_365[var1], this.field_364[var1]);
            } else if (this.field_360[var1] == 1) {
               this.method_285(var1, this.field_358[var1] - this.field_346.method_81(this.field_365[var1], this.field_364[var1]) / 2, this.field_359[var1], this.field_365[var1], this.field_364[var1]);
            } else if (this.field_360[var1] == 2) {
               this.method_288(this.field_358[var1], this.field_359[var1], this.field_361[var1], this.field_362[var1]);
            } else if (this.field_360[var1] == 3) {
               this.method_291(this.field_358[var1], this.field_359[var1], this.field_361[var1]);
            } else if (this.field_360[var1] == 4) {
               this.method_292(var1, this.field_358[var1], this.field_359[var1], this.field_361[var1], this.field_362[var1], this.field_364[var1], this.field_366[var1], this.field_354[var1], this.field_353[var1]);
            } else if (this.field_360[var1] != 5 && this.field_360[var1] != 6) {
               if (this.field_360[var1] == 7) {
                  this.method_294(var1, this.field_358[var1], this.field_359[var1], this.field_364[var1], this.field_366[var1]);
               } else if (this.field_360[var1] == 8) {
                  this.method_295(var1, this.field_358[var1], this.field_359[var1], this.field_364[var1], this.field_366[var1]);
               } else if (this.field_360[var1] == 9) {
                  this.method_296(var1, this.field_358[var1], this.field_359[var1], this.field_361[var1], this.field_362[var1], this.field_364[var1], this.field_366[var1], this.field_354[var1], this.field_353[var1]);
               } else if (this.field_360[var1] == 11) {
                  this.method_289(this.field_358[var1], this.field_359[var1], this.field_361[var1], this.field_362[var1]);
               } else if (this.field_360[var1] == 12) {
                  this.method_290(this.field_358[var1], this.field_359[var1], this.field_364[var1]);
               } else if (this.field_360[var1] == 14) {
                  this.method_284(var1, this.field_358[var1], this.field_359[var1], this.field_361[var1], this.field_362[var1]);
               }
            } else {
               this.method_287(var1, this.field_358[var1], this.field_359[var1], this.field_361[var1], this.field_362[var1], this.field_365[var1], this.field_364[var1]);
            }
         }
      }

      this.field_369 = 0;
   }

   // $FF: renamed from: sj (int, int, int, int, int) void
   protected void method_284(int var1, int var2, int var3, int var4, int var5) {
      this.field_346.method_36(var2, var3, var4, var5, 16777215);
      this.field_346.method_38(var2, var3, var4, this.field_381);
      this.field_346.method_39(var2, var3, var5, this.field_381);
      this.field_346.method_38(var2, var3 + var5 - 1, var4, this.field_384);
      this.field_346.method_39(var2 + var4 - 1, var3, var5, this.field_384);
      if (this.field_355[var1] == 1) {
         for(int var6 = 0; var6 < var5; ++var6) {
            this.field_346.method_38(var2 + var6, var3 + var6, 1, 0);
            this.field_346.method_38(var2 + var4 - 1 - var6, var3 + var6, 1, 0);
         }
      }

   }

   // $FF: renamed from: ek (int, int, int, java.lang.String, int) void
   protected void method_285(int var1, int var2, int var3, String var4, int var5) {
      int var6 = var3 + this.field_346.method_80(var5) / 3;
      this.method_286(var1, var2, var6, var4, var5);
   }

   // $FF: renamed from: tk (int, int, int, java.lang.String, int) void
   protected void method_286(int var1, int var2, int var3, String var4, int var5) {
      int var6;
      if (this.field_357[var1]) {
         var6 = 16777215;
      } else {
         var6 = 0;
      }

      this.field_346.method_77(var4, var2, var3, var5, var6);
   }

   // $FF: renamed from: uk (int, int, int, int, int, java.lang.String, int) void
   protected void method_287(int var1, int var2, int var3, int var4, int var5, String var6, int var7) {
      int var8;
      if (this.field_351[var1]) {
         var8 = var6.length();
         var6 = "";

         for(int var9 = 0; var9 < var8; ++var9) {
            var6 = var6 + "X";
         }
      }

      if (this.field_360[var1] == 5) {
         if (this.field_369 == 1 && this.field_367 >= var2 && this.field_368 >= var3 - var5 / 2 && this.field_367 <= var2 + var4 && this.field_368 <= var3 + var5 / 2) {
            this.field_371 = var1;
         }
      } else if (this.field_360[var1] == 6) {
         if (this.field_369 == 1 && this.field_367 >= var2 - var4 / 2 && this.field_368 >= var3 - var5 / 2 && this.field_367 <= var2 + var4 / 2 && this.field_368 <= var3 + var5 / 2) {
            this.field_371 = var1;
         }

         var2 -= this.field_346.method_81(var6, var7) / 2;
      }

      if (this.field_371 == var1) {
         var6 = var6 + "*";
      }

      var8 = var3 + this.field_346.method_80(var7) / 3;
      this.method_286(var1, var2, var8, var6, var7);
   }

   // $FF: renamed from: ik (int, int, int, int) void
   public void method_288(int var1, int var2, int var3, int var4) {
      this.field_346.method_29(var1, var2, var1 + var3, var2 + var4);
      this.field_346.method_35(var1, var2, var3, var4, this.field_384, this.field_381);
      if (field_386) {
         for(int var5 = var1 - (var2 & 63); var5 < var1 + var3; var5 += 128) {
            for(int var6 = var2 - (var2 & 31); var6 < var2 + var4; var6 += 128) {
               this.field_346.method_54(var5, var6, 6 + field_387, 128);
            }
         }
      }

      this.field_346.method_38(var1, var2, var3, this.field_381);
      this.field_346.method_38(var1 + 1, var2 + 1, var3 - 2, this.field_381);
      this.field_346.method_38(var1 + 2, var2 + 2, var3 - 4, this.field_382);
      this.field_346.method_39(var1, var2, var4, this.field_381);
      this.field_346.method_39(var1 + 1, var2 + 1, var4 - 2, this.field_381);
      this.field_346.method_39(var1 + 2, var2 + 2, var4 - 4, this.field_382);
      this.field_346.method_38(var1, var2 + var4 - 1, var3, this.field_384);
      this.field_346.method_38(var1 + 1, var2 + var4 - 2, var3 - 2, this.field_384);
      this.field_346.method_38(var1 + 2, var2 + var4 - 3, var3 - 4, this.field_383);
      this.field_346.method_39(var1 + var3 - 1, var2, var4, this.field_384);
      this.field_346.method_39(var1 + var3 - 2, var2 + 1, var4 - 2, this.field_384);
      this.field_346.method_39(var1 + var3 - 3, var2 + 2, var4 - 4, this.field_383);
      this.field_346.method_30();
   }

   // $FF: renamed from: bk (int, int, int, int) void
   public void method_289(int var1, int var2, int var3, int var4) {
      this.field_346.method_36(var1, var2, var3, var4, 0);
      this.field_346.method_37(var1, var2, var3, var4, this.field_378);
      this.field_346.method_37(var1 + 1, var2 + 1, var3 - 2, var4 - 2, this.field_379);
      this.field_346.method_37(var1 + 2, var2 + 2, var3 - 4, var4 - 4, this.field_380);
      this.field_346.method_52(var1, var2, 2 + field_387);
      this.field_346.method_52(var1 + var3 - 7, var2, 3 + field_387);
      this.field_346.method_52(var1, var2 + var4 - 7, 4 + field_387);
      this.field_346.method_52(var1 + var3 - 7, var2 + var4 - 7, 5 + field_387);
   }

   // $FF: renamed from: al (int, int, int) void
   protected void method_290(int var1, int var2, int var3) {
      this.field_346.method_52(var1, var2, var3);
   }

   // $FF: renamed from: vj (int, int, int) void
   protected void method_291(int var1, int var2, int var3) {
      this.field_346.method_38(var1, var2, var3, 0);
   }

   // $FF: renamed from: hk (int, int, int, int, int, int, java.lang.String[], int, int) void
   protected void method_292(int var1, int var2, int var3, int var4, int var5, int var6, String[] var7, int var8, int var9) {
      int var10 = var5 / this.field_346.method_80(var6);
      if (var9 > var8 - var10) {
         var9 = var8 - var10;
      }

      if (var9 < 0) {
         var9 = 0;
      }

      this.field_353[var1] = var9;
      int var11;
      int var12;
      int var13;
      if (var10 < var8) {
         var11 = var2 + var4 - 12;
         var12 = (var5 - 27) * var10 / var8;
         if (var12 < 6) {
            var12 = 6;
         }

         var13 = (var5 - 27 - var12) * var9 / (var8 - var10);
         if (this.field_370 == 1 && this.field_367 >= var11 && this.field_367 <= var11 + 12) {
            if (this.field_368 > var3 && this.field_368 < var3 + 12 && var9 > 0) {
               --var9;
            }

            if (this.field_368 > var3 + var5 - 12 && this.field_368 < var3 + var5 && var9 < var8 - var10) {
               ++var9;
            }

            this.field_353[var1] = var9;
         }

         if (this.field_370 == 1 && (this.field_367 >= var11 && this.field_367 <= var11 + 12 || this.field_367 >= var11 - 12 && this.field_367 <= var11 + 24 && this.field_350[var1])) {
            if (this.field_368 > var3 + 12 && this.field_368 < var3 + var5 - 12) {
               this.field_350[var1] = true;
               int var14 = this.field_368 - var3 - 12 - var12 / 2;
               var9 = var14 * var8 / (var5 - 24);
               if (var9 > var8 - var10) {
                  var9 = var8 - var10;
               }

               if (var9 < 0) {
                  var9 = 0;
               }

               this.field_353[var1] = var9;
            }
         } else {
            this.field_350[var1] = false;
         }

         var13 = (var5 - 27 - var12) * var9 / (var8 - var10);
         this.method_293(var2, var3, var4, var5, var13, var12);
      }

      var11 = var5 - var10 * this.field_346.method_80(var6);
      var12 = var3 + this.field_346.method_80(var6) * 5 / 6 + var11 / 2;

      for(var13 = var9; var13 < var8; ++var13) {
         this.method_286(var1, var2 + 2, var12, var7[var13], var6);
         var12 += this.field_346.method_80(var6) - field_391;
         if (var12 >= var3 + var5) {
            return;
         }
      }

   }

   // $FF: renamed from: xk (int, int, int, int, int, int) void
   protected void method_293(int var1, int var2, int var3, int var4, int var5, int var6) {
      int var7 = var1 + var3 - 12;
      this.field_346.method_37(var7, var2, 12, var4, 0);
      this.field_346.method_52(var7 + 1, var2 + 1, field_387);
      this.field_346.method_52(var7 + 1, var2 + var4 - 12, 1 + field_387);
      this.field_346.method_38(var7, var2 + 13, 12, 0);
      this.field_346.method_38(var7, var2 + var4 - 13, 12, 0);
      this.field_346.method_35(var7 + 1, var2 + 14, 11, var4 - 27, this.field_373, this.field_374);
      this.field_346.method_36(var7 + 3, var5 + var2 + 14, 7, var6, this.field_376);
      this.field_346.method_39(var7 + 2, var5 + var2 + 14, var6, this.field_375);
      this.field_346.method_39(var7 + 2 + 8, var5 + var2 + 14, var6, this.field_377);
   }

   // $FF: renamed from: sk (int, int, int, int, java.lang.String[]) void
   protected void method_294(int var1, int var2, int var3, int var4, String[] var5) {
      int var6 = 0;
      int var7 = var5.length;

      for(int var8 = 0; var8 < var7; ++var8) {
         var6 += this.field_346.method_81(var5[var8], var4);
         if (var8 < var7 - 1) {
            var6 += this.field_346.method_81("  ", var4);
         }
      }

      int var9 = var2 - var6 / 2;
      int var10 = var3 + this.field_346.method_80(var4) / 3;

      for(int var11 = 0; var11 < var7; ++var11) {
         int var12;
         if (this.field_357[var1]) {
            var12 = 16777215;
         } else {
            var12 = 0;
         }

         if (this.field_367 >= var9 && this.field_367 <= var9 + this.field_346.method_81(var5[var11], var4) && this.field_368 <= var10 && this.field_368 > var10 - this.field_346.method_80(var4)) {
            if (this.field_357[var1]) {
               var12 = 8421504;
            } else {
               var12 = 16777215;
            }

            if (this.field_369 == 1) {
               this.field_355[var1] = var11;
               this.field_352[var1] = true;
            }
         }

         if (this.field_355[var1] == var11) {
            if (this.field_357[var1]) {
               var12 = 16711680;
            } else {
               var12 = 12582912;
            }
         }

         this.field_346.method_77(var5[var11], var9, var10, var4, var12);
         var9 += this.field_346.method_81(var5[var11] + "  ", var4);
      }

   }

   // $FF: renamed from: pk (int, int, int, int, java.lang.String[]) void
   protected void method_295(int var1, int var2, int var3, int var4, String[] var5) {
      int var6 = var5.length;
      int var7 = var3 - this.field_346.method_80(var4) * (var6 - 1) / 2;

      for(int var8 = 0; var8 < var6; ++var8) {
         int var9;
         if (this.field_357[var1]) {
            var9 = 16777215;
         } else {
            var9 = 0;
         }

         int var10 = this.field_346.method_81(var5[var8], var4);
         if (this.field_367 >= var2 - var10 / 2 && this.field_367 <= var2 + var10 / 2 && this.field_368 - 2 <= var7 && this.field_368 - 2 > var7 - this.field_346.method_80(var4)) {
            if (this.field_357[var1]) {
               var9 = 8421504;
            } else {
               var9 = 16777215;
            }

            if (this.field_369 == 1) {
               this.field_355[var1] = var8;
               this.field_352[var1] = true;
            }
         }

         if (this.field_355[var1] == var8) {
            if (this.field_357[var1]) {
               var9 = 16711680;
            } else {
               var9 = 12582912;
            }
         }

         this.field_346.method_77(var5[var8], var2 - var10 / 2, var7, var4, var9);
         var7 += this.field_346.method_80(var4);
      }

   }

   // $FF: renamed from: zk (int, int, int, int, int, int, java.lang.String[], int, int) void
   protected void method_296(int var1, int var2, int var3, int var4, int var5, int var6, String[] var7, int var8, int var9) {
      int var10 = var5 / this.field_346.method_80(var6);
      int var11;
      int var12;
      int var13;
      int var14;
      if (var10 < var8) {
         var11 = var2 + var4 - 12;
         var12 = (var5 - 27) * var10 / var8;
         if (var12 < 6) {
            var12 = 6;
         }

         var13 = (var5 - 27 - var12) * var9 / (var8 - var10);
         if (this.field_370 == 1 && this.field_367 >= var11 && this.field_367 <= var11 + 12) {
            if (this.field_368 > var3 && this.field_368 < var3 + 12 && var9 > 0) {
               --var9;
            }

            if (this.field_368 > var3 + var5 - 12 && this.field_368 < var3 + var5 && var9 < var8 - var10) {
               ++var9;
            }

            this.field_353[var1] = var9;
         }

         if (this.field_370 != 1 || (this.field_367 < var11 || this.field_367 > var11 + 12) && (this.field_367 < var11 - 12 || this.field_367 > var11 + 24 || !this.field_350[var1])) {
            this.field_350[var1] = false;
         } else if (this.field_368 > var3 + 12 && this.field_368 < var3 + var5 - 12) {
            this.field_350[var1] = true;
            var14 = this.field_368 - var3 - 12 - var12 / 2;
            var9 = var14 * var8 / (var5 - 24);
            if (var9 < 0) {
               var9 = 0;
            }

            if (var9 > var8 - var10) {
               var9 = var8 - var10;
            }

            this.field_353[var1] = var9;
         }

         var13 = (var5 - 27 - var12) * var9 / (var8 - var10);
         this.method_293(var2, var3, var4, var5, var13, var12);
      } else {
         var9 = 0;
         this.field_353[var1] = 0;
      }

      this.field_356[var1] = -1;
      var11 = var5 - var10 * this.field_346.method_80(var6);
      var12 = var3 + this.field_346.method_80(var6) * 5 / 6 + var11 / 2;

      for(var13 = var9; var13 < var8; ++var13) {
         if (this.field_357[var1]) {
            var14 = 16777215;
         } else {
            var14 = 0;
         }

         if (this.field_367 >= var2 + 2 && this.field_367 <= var2 + 2 + this.field_346.method_81(var7[var13], var6) && this.field_368 - 2 <= var12 && this.field_368 - 2 > var12 - this.field_346.method_80(var6)) {
            if (this.field_357[var1]) {
               var14 = 8421504;
            } else {
               var14 = 16777215;
            }

            this.field_356[var1] = var13;
            if (this.field_369 == 1) {
               this.field_355[var1] = var13;
               this.field_352[var1] = true;
            }
         }

         if (this.field_355[var1] == var13 && this.field_385) {
            var14 = 16711680;
         }

         this.field_346.method_77(var7[var13], var2 + 2, var12, var6, var14);
         var12 += this.field_346.method_80(var6);
         if (var12 >= var3 + var5) {
            return;
         }
      }

   }

   // $FF: renamed from: nk (int, int, java.lang.String, int, boolean) int
   public int method_297(int var1, int var2, String var3, int var4, boolean var5) {
      this.field_360[this.field_347] = 0;
      this.field_349[this.field_347] = true;
      this.field_352[this.field_347] = false;
      this.field_364[this.field_347] = var4;
      this.field_357[this.field_347] = var5;
      this.field_358[this.field_347] = var1;
      this.field_359[this.field_347] = var2;
      this.field_365[this.field_347] = var3;
      return this.field_347++;
   }

   // $FF: renamed from: kk (int, int, java.lang.String, int, boolean) int
   public int method_298(int var1, int var2, String var3, int var4, boolean var5) {
      this.field_360[this.field_347] = 1;
      this.field_349[this.field_347] = true;
      this.field_352[this.field_347] = false;
      this.field_364[this.field_347] = var4;
      this.field_357[this.field_347] = var5;
      this.field_358[this.field_347] = var1;
      this.field_359[this.field_347] = var2;
      this.field_365[this.field_347] = var3;
      return this.field_347++;
   }

   // $FF: renamed from: rj (int, int, int, int) int
   public int method_299(int var1, int var2, int var3, int var4) {
      this.field_360[this.field_347] = 2;
      this.field_349[this.field_347] = true;
      this.field_352[this.field_347] = false;
      this.field_358[this.field_347] = var1 - var3 / 2;
      this.field_359[this.field_347] = var2 - var4 / 2;
      this.field_361[this.field_347] = var3;
      this.field_362[this.field_347] = var4;
      return this.field_347++;
   }

   // $FF: renamed from: tj (int, int, int, int) int
   public int method_300(int var1, int var2, int var3, int var4) {
      this.field_360[this.field_347] = 11;
      this.field_349[this.field_347] = true;
      this.field_352[this.field_347] = false;
      this.field_358[this.field_347] = var1 - var3 / 2;
      this.field_359[this.field_347] = var2 - var4 / 2;
      this.field_361[this.field_347] = var3;
      this.field_362[this.field_347] = var4;
      return this.field_347++;
   }

   // $FF: renamed from: ak (int, int, int) int
   public int method_301(int var1, int var2, int var3) {
      int var4 = this.field_346.field_23[var3];
      int var5 = this.field_346.field_24[var3];
      this.field_360[this.field_347] = 12;
      this.field_349[this.field_347] = true;
      this.field_352[this.field_347] = false;
      this.field_358[this.field_347] = var1 - var4 / 2;
      this.field_359[this.field_347] = var2 - var5 / 2;
      this.field_361[this.field_347] = var4;
      this.field_362[this.field_347] = var5;
      this.field_364[this.field_347] = var3;
      return this.field_347++;
   }

   // $FF: renamed from: qj (int, int, int, int, int, int, boolean) int
   public int method_302(int var1, int var2, int var3, int var4, int var5, int var6, boolean var7) {
      this.field_360[this.field_347] = 4;
      this.field_349[this.field_347] = true;
      this.field_352[this.field_347] = false;
      this.field_358[this.field_347] = var1;
      this.field_359[this.field_347] = var2;
      this.field_361[this.field_347] = var3;
      this.field_362[this.field_347] = var4;
      this.field_357[this.field_347] = var7;
      this.field_364[this.field_347] = var5;
      this.field_363[this.field_347] = var6;
      this.field_354[this.field_347] = 0;
      this.field_353[this.field_347] = 0;
      this.field_366[this.field_347] = new String[var6];
      return this.field_347++;
   }

   // $FF: renamed from: wk (int, int, int, int, int, int, boolean, boolean) int
   public int method_303(int var1, int var2, int var3, int var4, int var5, int var6, boolean var7, boolean var8) {
      this.field_360[this.field_347] = 5;
      this.field_349[this.field_347] = true;
      this.field_351[this.field_347] = var7;
      this.field_352[this.field_347] = false;
      this.field_364[this.field_347] = var5;
      this.field_357[this.field_347] = var8;
      this.field_358[this.field_347] = var1;
      this.field_359[this.field_347] = var2;
      this.field_361[this.field_347] = var3;
      this.field_362[this.field_347] = var4;
      this.field_363[this.field_347] = var6;
      this.field_365[this.field_347] = "";
      return this.field_347++;
   }

   // $FF: renamed from: pj (int, int, int, int, int, int, boolean, boolean) int
   public int method_304(int var1, int var2, int var3, int var4, int var5, int var6, boolean var7, boolean var8) {
      this.field_360[this.field_347] = 6;
      this.field_349[this.field_347] = true;
      this.field_351[this.field_347] = var7;
      this.field_352[this.field_347] = false;
      this.field_364[this.field_347] = var5;
      this.field_357[this.field_347] = var8;
      this.field_358[this.field_347] = var1;
      this.field_359[this.field_347] = var2;
      this.field_361[this.field_347] = var3;
      this.field_362[this.field_347] = var4;
      this.field_363[this.field_347] = var6;
      this.field_365[this.field_347] = "";
      return this.field_347++;
   }

   // $FF: renamed from: xj (int, int, java.lang.String[], int, boolean) int
   public int method_305(int var1, int var2, String[] var3, int var4, boolean var5) {
      this.field_360[this.field_347] = 8;
      this.field_349[this.field_347] = true;
      this.field_352[this.field_347] = false;
      this.field_364[this.field_347] = var4;
      this.field_357[this.field_347] = var5;
      this.field_358[this.field_347] = var1;
      this.field_359[this.field_347] = var2;
      this.field_366[this.field_347] = var3;
      this.field_355[this.field_347] = 0;
      return this.field_347++;
   }

   // $FF: renamed from: el (int, int, int, int, int, int, boolean) int
   public int method_306(int var1, int var2, int var3, int var4, int var5, int var6, boolean var7) {
      this.field_360[this.field_347] = 9;
      this.field_349[this.field_347] = true;
      this.field_352[this.field_347] = false;
      this.field_364[this.field_347] = var5;
      this.field_357[this.field_347] = var7;
      this.field_358[this.field_347] = var1;
      this.field_359[this.field_347] = var2;
      this.field_361[this.field_347] = var3;
      this.field_362[this.field_347] = var4;
      this.field_363[this.field_347] = var6;
      this.field_366[this.field_347] = new String[var6];
      this.field_354[this.field_347] = 0;
      this.field_353[this.field_347] = 0;
      this.field_355[this.field_347] = -1;
      this.field_356[this.field_347] = -1;
      return this.field_347++;
   }

   // $FF: renamed from: qk (int, int, int, int) int
   public int method_307(int var1, int var2, int var3, int var4) {
      this.field_360[this.field_347] = 10;
      this.field_349[this.field_347] = true;
      this.field_352[this.field_347] = false;
      this.field_358[this.field_347] = var1 - var3 / 2;
      this.field_359[this.field_347] = var2 - var4 / 2;
      this.field_361[this.field_347] = var3;
      this.field_362[this.field_347] = var4;
      return this.field_347++;
   }

   // $FF: renamed from: vk (int, int, int) int
   public int method_308(int var1, int var2, int var3) {
      this.field_360[this.field_347] = 14;
      this.field_349[this.field_347] = true;
      this.field_352[this.field_347] = false;
      this.field_358[this.field_347] = var1 - var3 / 2;
      this.field_359[this.field_347] = var2 - var3 / 2;
      this.field_361[this.field_347] = var3;
      this.field_362[this.field_347] = var3;
      return this.field_347++;
   }

   // $FF: renamed from: zj (int) void
   public void method_309(int var1) {
      this.field_354[var1] = 0;
   }

   // $FF: renamed from: ok (int) void
   public void method_310(int var1) {
      this.field_353[var1] = 0;
      this.field_356[var1] = -1;
   }

   // $FF: renamed from: dl (int, int, java.lang.String) void
   public void method_311(int var1, int var2, String var3) {
      this.field_366[var1][var2] = var3;
      if (var2 + 1 > this.field_354[var1]) {
         this.field_354[var1] = var2 + 1;
      }

   }

   // $FF: renamed from: jk (int, java.lang.String, boolean) void
   public void method_312(int var1, String var2, boolean var3) {
      int var4 = this.field_354[var1]++;
      if (var4 >= this.field_363[var1]) {
         --var4;
         --this.field_354[var1];

         for(int var5 = 0; var5 < var4; ++var5) {
            this.field_366[var1][var5] = this.field_366[var1][var5 + 1];
         }
      }

      this.field_366[var1][var4] = var2;
      if (var3) {
         this.field_353[var1] = 999999;
      }

   }

   // $FF: renamed from: uj (int, java.lang.String) void
   public void method_313(int var1, String var2) {
      this.field_365[var1] = var2;
   }

   // $FF: renamed from: cl (int) java.lang.String
   public String method_314(int var1) {
      return this.field_365[var1] == null ? "null" : this.field_365[var1];
   }

   // $FF: renamed from: yj (int) void
   public void method_315(int var1) {
      this.field_349[var1] = true;
   }

   // $FF: renamed from: rk (int) void
   public void method_316(int var1) {
      this.field_349[var1] = false;
   }

   // $FF: renamed from: mk (int) void
   public void method_317(int var1) {
      this.field_371 = var1;
   }

   // $FF: renamed from: oj (int) int
   public int method_318(int var1) {
      return this.field_355[var1];
   }

   // $FF: renamed from: bl (int) int
   public int method_319(int var1) {
      int var2 = this.field_356[var1];
      return var2;
   }

   // $FF: renamed from: lk (int, int) void
   public void method_320(int var1, int var2) {
      this.field_355[var1] = var2;
   }
}
