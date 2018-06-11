package jagex;

// $FF: renamed from: jagex.r
public class class_14 {
   // $FF: renamed from: rw int
   static final int field_529 = 1;
   // $FF: renamed from: sw int
   static final int field_530 = 2;
   // $FF: renamed from: tw int
   static final int field_531 = 10;
   // $FF: renamed from: uw int
   static final int field_532 = 14;
   // $FF: renamed from: vw int
   static final int field_533 = 0;
   // $FF: renamed from: ww int
   static final int field_534 = 4;
   // $FF: renamed from: xw int
   static final int field_535 = 4096;
   // $FF: renamed from: yw int
   static final int field_536 = 16;
   // $FF: renamed from: zw int
   static final int field_537 = 258;
   // $FF: renamed from: ax int
   static final int field_538 = 23;
   // $FF: renamed from: bx int
   static final int field_539 = 0;
   // $FF: renamed from: cx int
   static final int field_540 = 1;
   // $FF: renamed from: dx int
   static final int field_541 = 6;
   // $FF: renamed from: ex int
   static final int field_542 = 50;
   // $FF: renamed from: fx int
   static final int field_543 = 4;
   // $FF: renamed from: gx int
   static final int field_544 = 18002;

   // $FF: renamed from: wm (byte[], int, byte[], int, int) int
   public static int method_329(byte[] var0, int var1, byte[] var2, int var3, int var4) {
      class_7 var5 = new class_7();
      var5.field_220 = var2;
      var5.field_221 = var4;
      var5.field_225 = var0;
      var5.field_226 = 0;
      var5.field_222 = var3;
      var5.field_227 = var1;
      var5.field_234 = 0;
      var5.field_233 = 0;
      var5.field_223 = 0;
      var5.field_224 = 0;
      var5.field_228 = 0;
      var5.field_229 = 0;
      var5.field_236 = 0;
      method_331(var5);
      var1 -= var5.field_227;
      return var1;
   }

   // $FF: renamed from: qm (jagex.i) void
   private static void method_330(class_7 var0) {
      byte var2 = var0.field_230;
      int var3 = var0.field_231;
      int var4 = var0.field_241;
      int var5 = var0.field_239;
      int[] var6 = class_7.field_244;
      int var7 = var0.field_238;
      byte[] var8 = var0.field_225;
      int var9 = var0.field_226;
      int var10 = var0.field_227;
      int var12 = var0.field_258 + 1;

      label67:
      while(true) {
         if (var3 > 0) {
            while(true) {
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
         while(var14) {
            var14 = false;
            if (var4 == var12) {
               var3 = 0;
               break label67;
            }

            var2 = (byte)var5;
            var7 = var6[var7];
            var1 = (byte)(var7 & 255);
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
         var1 = (byte)(var7 & 255);
         var7 >>= 8;
         ++var4;
         if (var4 != var12) {
            if (var1 != var5) {
               var5 = var1;
            } else {
               var3 = 3;
               var7 = var6[var7];
               var1 = (byte)(var7 & 255);
               var7 >>= 8;
               ++var4;
               if (var4 != var12) {
                  if (var1 != var5) {
                     var5 = var1;
                  } else {
                     var7 = var6[var7];
                     var1 = (byte)(var7 & 255);
                     var7 >>= 8;
                     ++var4;
                     var3 = (var1 & 255) + 4;
                     var7 = var6[var7];
                     var5 = (byte)(var7 & 255);
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
      class_7.field_244 = var6;
      var0.field_238 = var7;
      var0.field_225 = var8;
      var0.field_226 = var9;
      var0.field_227 = var10;
   }

   // $FF: renamed from: um (jagex.i) void
   private static void method_331(class_7 var0) {
      boolean var4 = false;
      boolean var5 = false;
      boolean var6 = false;
      boolean var7 = false;
      boolean var8 = false;
      boolean var9 = false;
      boolean var10 = false;
      boolean var11 = false;
      boolean var12 = false;
      boolean var13 = false;
      boolean var14 = false;
      boolean var15 = false;
      boolean var16 = false;
      boolean var17 = false;
      boolean var18 = false;
      boolean var19 = false;
      boolean var20 = false;
      boolean var21 = false;
      boolean var22 = false;
      int var23 = 0;
      int[] var24 = null;
      int[] var25 = null;
      int[] var26 = null;
      var0.field_235 = 1;
      if (class_7.field_244 == null) {
         class_7.field_244 = new int[var0.field_235 * 100000];
      }

      boolean var27 = true;

      while(true) {
         while(var27) {
            byte var1 = method_332(var0);
            if (var1 == 23) {
               return;
            }

            var1 = method_332(var0);
            var1 = method_332(var0);
            var1 = method_332(var0);
            var1 = method_332(var0);
            var1 = method_332(var0);
            ++var0.field_236;
            var1 = method_332(var0);
            var1 = method_332(var0);
            var1 = method_332(var0);
            var1 = method_332(var0);
            var1 = method_333(var0);
            if (var1 != 0) {
               var0.field_232 = true;
            } else {
               var0.field_232 = false;
            }

            if (var0.field_232) {
               System.out.println("PANIC! RANDOMISED BLOCK!");
            }

            var0.field_237 = 0;
            var1 = method_332(var0);
            var0.field_237 = var0.field_237 << 8 | var1 & 255;
            var1 = method_332(var0);
            var0.field_237 = var0.field_237 << 8 | var1 & 255;
            var1 = method_332(var0);
            var0.field_237 = var0.field_237 << 8 | var1 & 255;

            int var42;
            for(var42 = 0; var42 < 16; ++var42) {
               var1 = method_333(var0);
               if (var1 == 1) {
                  var0.field_247[var42] = true;
               } else {
                  var0.field_247[var42] = false;
               }
            }

            for(var42 = 0; var42 < 256; ++var42) {
               var0.field_246[var42] = false;
            }

            int var43;
            for(var42 = 0; var42 < 16; ++var42) {
               if (var0.field_247[var42]) {
                  for(var43 = 0; var43 < 16; ++var43) {
                     var1 = method_333(var0);
                     if (var1 == 1) {
                        var0.field_246[var42 * 16 + var43] = true;
                     }
                  }
               }
            }

            method_336(var0);
            int var45 = var0.field_245 + 2;
            int var46 = method_334(3, var0);
            int var47 = method_334(15, var0);

            for(var42 = 0; var42 < var47; ++var42) {
               var43 = 0;

               while(true) {
                  var1 = method_333(var0);
                  if (var1 == 0) {
                     var0.field_252[var42] = (byte)var43;
                     break;
                  }

                  ++var43;
               }
            }

            byte[] var28 = new byte[6];

            byte var30;
            for(var30 = 0; var30 < var46; var28[var30] = var30++) {
               ;
            }

            for(var42 = 0; var42 < var47; ++var42) {
               var30 = var0.field_252[var42];

               byte var29;
               for(var29 = var28[var30]; var30 > 0; --var30) {
                  var28[var30] = var28[var30 - 1];
               }

               var28[0] = var29;
               var0.field_251[var42] = var29;
            }

            int var44;
            for(var44 = 0; var44 < var46; ++var44) {
               int var57 = method_334(5, var0);

               for(var42 = 0; var42 < var45; ++var42) {
                  while(true) {
                     var1 = method_333(var0);
                     if (var1 == 0) {
                        var0.field_253[var44][var42] = (byte)var57;
                        break;
                     }

                     var1 = method_333(var0);
                     if (var1 == 0) {
                        ++var57;
                     } else {
                        --var57;
                     }
                  }
               }
            }

            for(var44 = 0; var44 < var46; ++var44) {
               byte var2 = 32;
               byte var3 = 0;

               for(var42 = 0; var42 < var45; ++var42) {
                  if (var0.field_253[var44][var42] > var3) {
                     var3 = var0.field_253[var44][var42];
                  }

                  if (var0.field_253[var44][var42] < var2) {
                     var2 = var0.field_253[var44][var42];
                  }
               }

               method_337(var0.field_254[var44], var0.field_255[var44], var0.field_256[var44], var0.field_253[var44], var2, var3, var45);
               var0.field_257[var44] = var2;
            }

            int var48 = var0.field_245 + 1;
            int var53 = 100000 * var0.field_235;
            int var49 = -1;
            byte var50 = 0;

            for(var42 = 0; var42 <= 255; ++var42) {
               var0.field_240[var42] = 0;
            }

            int var33 = 4095;

            for(int var31 = 15; var31 >= 0; --var31) {
               for(int var32 = 15; var32 >= 0; --var32) {
                  var0.field_249[var33] = (byte)(var31 * 16 + var32);
                  --var33;
               }

               var0.field_250[var31] = var33 + 1;
            }

            int var54 = 0;
            byte var61;
            if (var50 == 0) {
               ++var49;
               var50 = 50;
               var61 = var0.field_251[var49];
               var23 = var0.field_257[var61];
               var24 = var0.field_254[var61];
               var26 = var0.field_256[var61];
               var25 = var0.field_255[var61];
            }

            int var51 = var50 - 1;
            int var58 = var23;

            int var59;
            byte var60;
            for(var59 = method_334(var23, var0); var59 > var24[var58]; var59 = var59 << 1 | var60) {
               ++var58;
               var60 = method_333(var0);
            }

            int var52 = var26[var59 - var25[var58]];

            while(true) {
               while(var52 != var48) {
                  if (var52 != 0 && var52 != 1) {
                     int var40 = var52 - 1;
                     int var37;
                     if (var40 < 16) {
                        var37 = var0.field_250[0];

                        for(var1 = var0.field_249[var37 + var40]; var40 > 3; var40 -= 4) {
                           int var41 = var37 + var40;
                           var0.field_249[var41] = var0.field_249[var41 - 1];
                           var0.field_249[var41 - 1] = var0.field_249[var41 - 2];
                           var0.field_249[var41 - 2] = var0.field_249[var41 - 3];
                           var0.field_249[var41 - 3] = var0.field_249[var41 - 4];
                        }

                        while(var40 > 0) {
                           var0.field_249[var37 + var40] = var0.field_249[var37 + var40 - 1];
                           --var40;
                        }

                        var0.field_249[var37] = var1;
                     } else {
                        int var38 = var40 / 16;
                        int var39 = var40 % 16;
                        var37 = var0.field_250[var38] + var39;

                        for(var1 = var0.field_249[var37]; var37 > var0.field_250[var38]; --var37) {
                           var0.field_249[var37] = var0.field_249[var37 - 1];
                        }

                        ++var0.field_250[var38];

                        while(var38 > 0) {
                           --var0.field_250[var38];
                           var0.field_249[var0.field_250[var38]] = var0.field_249[var0.field_250[var38 - 1] + 16 - 1];
                           --var38;
                        }

                        --var0.field_250[0];
                        var0.field_249[var0.field_250[0]] = var1;
                        if (var0.field_250[0] == 0) {
                           int var36 = 4095;

                           for(int var34 = 15; var34 >= 0; --var34) {
                              for(int var35 = 15; var35 >= 0; --var35) {
                                 var0.field_249[var36] = var0.field_249[var0.field_250[var34] + var35];
                                 --var36;
                              }

                              var0.field_250[var34] = var36 + 1;
                           }
                        }
                     }

                     ++var0.field_240[var0.field_248[var1 & 255] & 255];
                     class_7.field_244[var54] = var0.field_248[var1 & 255] & 255;
                     ++var54;
                     if (var51 == 0) {
                        ++var49;
                        var51 = 50;
                        var61 = var0.field_251[var49];
                        var23 = var0.field_257[var61];
                        var24 = var0.field_254[var61];
                        var26 = var0.field_256[var61];
                        var25 = var0.field_255[var61];
                     }

                     --var51;
                     var58 = var23;

                     for(var59 = method_334(var23, var0); var59 > var24[var58]; var59 = var59 << 1 | var60) {
                        ++var58;
                        var60 = method_333(var0);
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
                        if (var51 == 0) {
                           ++var49;
                           var51 = 50;
                           var61 = var0.field_251[var49];
                           var23 = var0.field_257[var61];
                           var24 = var0.field_254[var61];
                           var26 = var0.field_256[var61];
                           var25 = var0.field_255[var61];
                        }

                        --var51;
                        var58 = var23;

                        for(var59 = method_334(var23, var0); var59 > var24[var58]; var59 = var59 << 1 | var60) {
                           ++var58;
                           var60 = method_333(var0);
                        }

                        var52 = var26[var59 - var25[var58]];
                     } while(var52 == 0 || var52 == 1);

                     ++var55;
                     var1 = var0.field_248[var0.field_249[var0.field_250[0]] & 255];

                     for(var0.field_240[var1 & 255] += var55; var55 > 0; --var55) {
                        class_7.field_244[var54] = var1 & 255;
                        ++var54;
                     }
                  }
               }

               var0.field_231 = 0;
               var0.field_230 = 0;
               var0.field_242[0] = 0;

               for(var42 = 1; var42 <= 256; ++var42) {
                  var0.field_242[var42] = var0.field_240[var42 - 1];
               }

               for(var42 = 1; var42 <= 256; ++var42) {
                  var0.field_242[var42] += var0.field_242[var42 - 1];
               }

               for(var42 = 0; var42 < var54; ++var42) {
                  var1 = (byte)(class_7.field_244[var42] & 255);
                  class_7.field_244[var0.field_242[var1 & 255]] |= var42 << 8;
                  ++var0.field_242[var1 & 255];
               }

               var0.field_238 = class_7.field_244[var0.field_237] >> 8;
               var0.field_241 = 0;
               var0.field_238 = class_7.field_244[var0.field_238];
               var0.field_239 = (byte)(var0.field_238 & 255);
               var0.field_238 >>= 8;
               ++var0.field_241;
               var0.field_258 = var54;
               method_330(var0);
               if (var0.field_241 == var0.field_258 + 1 && var0.field_231 == 0) {
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

   // $FF: renamed from: sm (jagex.i) byte
   private static byte method_332(class_7 var0) {
      return (byte)method_334(8, var0);
   }

   // $FF: renamed from: rm (jagex.i) byte
   private static byte method_333(class_7 var0) {
      return (byte)method_334(1, var0);
   }

   // $FF: renamed from: vm (int, jagex.i) int
   private static int method_334(int var0, class_7 var1) {
      while(var1.field_234 < var0) {
         var1.field_233 = var1.field_233 << 8 | var1.field_220[var1.field_221] & 255;
         var1.field_234 += 8;
         ++var1.field_221;
         --var1.field_222;
         ++var1.field_223;
         if (var1.field_223 == 0) {
            ++var1.field_224;
         }
      }

      int var3 = var1.field_233 >> var1.field_234 - var0 & (1 << var0) - 1;
      var1.field_234 -= var0;
      return var3;
   }

   // $FF: renamed from: pm (int, int[]) int
   private static int method_335(int var0, int[] var1) {
      int var2 = 0;
      int var3 = 256;

      do {
         int var4 = var2 + var3 >> 1;
         if (var0 >= var1[var4]) {
            var2 = var4;
         } else {
            var3 = var4;
         }
      } while(var3 - var2 != 1);

      return var2;
   }

   // $FF: renamed from: tm (jagex.i) void
   private static void method_336(class_7 var0) {
      var0.field_245 = 0;

      for(int var1 = 0; var1 < 256; ++var1) {
         if (var0.field_246[var1]) {
            var0.field_248[var0.field_245] = (byte)var1;
            ++var0.field_245;
         }
      }

   }

   // $FF: renamed from: xm (int[], int[], int[], byte[], int, int, int) void
   private static void method_337(int[] var0, int[] var1, int[] var2, byte[] var3, int var4, int var5, int var6) {
      int var7 = 0;

      int var8;
      for(var8 = var4; var8 <= var5; ++var8) {
         for(int var9 = 0; var9 < var6; ++var9) {
            if (var3[var9] == var8) {
               var2[var7] = var9;
               ++var7;
            }
         }
      }

      for(var8 = 0; var8 < 23; ++var8) {
         var1[var8] = 0;
      }

      for(var8 = 0; var8 < var6; ++var8) {
         ++var1[var3[var8] + 1];
      }

      for(var8 = 1; var8 < 23; ++var8) {
         var1[var8] += var1[var8 - 1];
      }

      for(var8 = 0; var8 < 23; ++var8) {
         var0[var8] = 0;
      }

      int var10 = 0;

      for(var8 = var4; var8 <= var5; ++var8) {
         var10 += var1[var8 + 1] - var1[var8];
         var0[var8] = var10 - 1;
         var10 <<= 1;
      }

      for(var8 = var4 + 1; var8 <= var5; ++var8) {
         var1[var8] = (var0[var8 - 1] + 1 << 1) - var1[var8];
      }

   }

   public class_14() {
      super();
   }
}
