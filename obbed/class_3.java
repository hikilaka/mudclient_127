import jagex.class_0;
import jagex.client.class_1;
import jagex.client.class_17;
import jagex.client.class_8;
import java.io.IOException;

// $FF: renamed from: d
public class class_3 {
   // $FF: renamed from: ce boolean
   boolean field_66 = false;
   // $FF: renamed from: de boolean
   boolean field_67 = true;
   // $FF: renamed from: ee jagex.client.j
   class_1 field_68;
   // $FF: renamed from: fe jagex.client.a
   class_17 field_69;
   // $FF: renamed from: ge int
   int field_70 = 750;
   // $FF: renamed from: he int
   final int field_71 = 12345678;
   // $FF: renamed from: ie int
   final int field_72 = 128;
   // $FF: renamed from: je int[]
   int[] field_73 = new int[256];
   // $FF: renamed from: ke int
   int field_74;
   // $FF: renamed from: le int[]
   int[] field_75;
   // $FF: renamed from: me int[]
   int[] field_76;
   // $FF: renamed from: ne int[]
   int[] field_77;
   // $FF: renamed from: oe byte[]
   byte[] field_78;
   // $FF: renamed from: pe byte[]
   byte[] field_79;
   // $FF: renamed from: qe byte[]
   byte[] field_80;
   // $FF: renamed from: re byte[]
   byte[] field_81;
   // $FF: renamed from: se byte[][]
   byte[][] field_82 = new byte[4][2304];
   // $FF: renamed from: te byte[][]
   byte[][] field_83 = new byte[4][2304];
   // $FF: renamed from: ue byte[][]
   byte[][] field_84 = new byte[4][2304];
   // $FF: renamed from: ve byte[][]
   byte[][] field_85 = new byte[4][2304];
   // $FF: renamed from: we byte[][]
   byte[][] field_86 = new byte[4][2304];
   // $FF: renamed from: xe byte[][]
   byte[][] field_87 = new byte[4][2304];
   // $FF: renamed from: ye byte[][]
   byte[][] field_88 = new byte[4][2304];
   // $FF: renamed from: ze int[][]
   int[][] field_89 = new int[4][2304];
   // $FF: renamed from: af int
   int field_90 = 96;
   // $FF: renamed from: bf int
   int field_91 = 96;
   // $FF: renamed from: cf int[]
   int[] field_92;
   // $FF: renamed from: df int[]
   int[] field_93;
   // $FF: renamed from: ef int[][]
   int[][] field_94;
   // $FF: renamed from: ff int[][]
   int[][] field_95;
   // $FF: renamed from: gf int[][]
   int[][] field_96;
   // $FF: renamed from: hf boolean
   boolean field_97;
   // $FF: renamed from: if jagex.client.q[]
   class_8[] field_98;
   // $FF: renamed from: jf jagex.client.q[][]
   class_8[][] field_99;
   // $FF: renamed from: kf jagex.client.q[][]
   class_8[][] field_100;
   // $FF: renamed from: lf jagex.client.q
   class_8 field_101;

   public class_3(class_17 var1, class_1 var2) {
      super();
      this.field_92 = new int[this.field_90 * this.field_91 * 2];
      this.field_93 = new int[this.field_90 * this.field_91 * 2];
      this.field_94 = new int[this.field_90][this.field_91];
      this.field_95 = new int[this.field_90][this.field_91];
      this.field_96 = new int[this.field_90][this.field_91];
      this.field_97 = false;
      this.field_98 = new class_8[64];
      this.field_99 = new class_8[4][64];
      this.field_100 = new class_8[4][64];
      this.field_69 = var1;
      this.field_68 = var2;

      for(int var3 = 0; var3 < 64; ++var3) {
         this.field_73[var3] = class_17.method_405(255 - var3 * 4, 255 - (int)((double)var3 * 1.75D), 255 - var3 * 4);
      }

      for(int var4 = 0; var4 < 64; ++var4) {
         this.field_73[var4 + 64] = class_17.method_405(var4 * 3, 144, 0);
      }

      for(int var5 = 0; var5 < 64; ++var5) {
         this.field_73[var5 + 128] = class_17.method_405(192 - (int)((double)var5 * 1.5D), 144 - (int)((double)var5 * 1.5D), 0);
      }

      for(int var6 = 0; var6 < 64; ++var6) {
         this.field_73[var6 + 192] = class_17.method_405(96 - (int)((double)var6 * 1.5D), 48 + (int)((double)var6 * 1.5D), 0);
      }

   }

   // $FF: renamed from: gd (int, int, int, int, int, int, int[], int[], boolean) int
   public int method_82(int var1, int var2, int var3, int var4, int var5, int var6, int[] var7, int[] var8, boolean var9) {
      int var11;
      for(int var10 = 0; var10 < this.field_90; ++var10) {
         for(var11 = 0; var11 < this.field_91; ++var11) {
            this.field_94[var10][var11] = 0;
         }
      }

      byte var19 = 0;
      int var12 = 0;
      int var13 = var1;
      int var14 = var2;
      this.field_94[var1][var2] = 99;
      var7[var19] = var1;
      var11 = var19 + 1;
      var8[var19] = var2;
      int var15 = var7.length;
      boolean var16 = false;

      while(var12 != var11) {
         var13 = var7[var12];
         var14 = var8[var12];
         var12 = (var12 + 1) % var15;
         if (var13 >= var3 && var13 <= var5 && var14 >= var4 && var14 <= var6) {
            var16 = true;
            break;
         }

         if (var9) {
            if (var13 > 0 && var13 - 1 >= var3 && var13 - 1 <= var5 && var14 >= var4 && var14 <= var6 && (this.field_95[var13 - 1][var14] & 8) == 0) {
               var16 = true;
               break;
            }

            if (var13 < this.field_90 - 1 && var13 + 1 >= var3 && var13 + 1 <= var5 && var14 >= var4 && var14 <= var6 && (this.field_95[var13 + 1][var14] & 2) == 0) {
               var16 = true;
               break;
            }

            if (var14 > 0 && var13 >= var3 && var13 <= var5 && var14 - 1 >= var4 && var14 - 1 <= var6 && (this.field_95[var13][var14 - 1] & 4) == 0) {
               var16 = true;
               break;
            }

            if (var14 < this.field_91 - 1 && var13 >= var3 && var13 <= var5 && var14 + 1 >= var4 && var14 + 1 <= var6 && (this.field_95[var13][var14 + 1] & 1) == 0) {
               var16 = true;
               break;
            }
         }

         if (var13 > 0 && this.field_94[var13 - 1][var14] == 0 && (this.field_95[var13 - 1][var14] & 120) == 0) {
            var7[var11] = var13 - 1;
            var8[var11] = var14;
            var11 = (var11 + 1) % var15;
            this.field_94[var13 - 1][var14] = 2;
         }

         if (var13 < this.field_90 - 1 && this.field_94[var13 + 1][var14] == 0 && (this.field_95[var13 + 1][var14] & 114) == 0) {
            var7[var11] = var13 + 1;
            var8[var11] = var14;
            var11 = (var11 + 1) % var15;
            this.field_94[var13 + 1][var14] = 8;
         }

         if (var14 > 0 && this.field_94[var13][var14 - 1] == 0 && (this.field_95[var13][var14 - 1] & 116) == 0) {
            var7[var11] = var13;
            var8[var11] = var14 - 1;
            var11 = (var11 + 1) % var15;
            this.field_94[var13][var14 - 1] = 1;
         }

         if (var14 < this.field_91 - 1 && this.field_94[var13][var14 + 1] == 0 && (this.field_95[var13][var14 + 1] & 113) == 0) {
            var7[var11] = var13;
            var8[var11] = var14 + 1;
            var11 = (var11 + 1) % var15;
            this.field_94[var13][var14 + 1] = 4;
         }

         if (var13 > 0 && var14 > 0 && (this.field_95[var13][var14 - 1] & 116) == 0 && (this.field_95[var13 - 1][var14] & 120) == 0 && (this.field_95[var13 - 1][var14 - 1] & 124) == 0 && this.field_94[var13 - 1][var14 - 1] == 0) {
            var7[var11] = var13 - 1;
            var8[var11] = var14 - 1;
            var11 = (var11 + 1) % var15;
            this.field_94[var13 - 1][var14 - 1] = 3;
         }

         if (var13 < this.field_90 - 1 && var14 > 0 && (this.field_95[var13][var14 - 1] & 116) == 0 && (this.field_95[var13 + 1][var14] & 114) == 0 && (this.field_95[var13 + 1][var14 - 1] & 118) == 0 && this.field_94[var13 + 1][var14 - 1] == 0) {
            var7[var11] = var13 + 1;
            var8[var11] = var14 - 1;
            var11 = (var11 + 1) % var15;
            this.field_94[var13 + 1][var14 - 1] = 9;
         }

         if (var13 > 0 && var14 < this.field_91 - 1 && (this.field_95[var13][var14 + 1] & 113) == 0 && (this.field_95[var13 - 1][var14] & 120) == 0 && (this.field_95[var13 - 1][var14 + 1] & 121) == 0 && this.field_94[var13 - 1][var14 + 1] == 0) {
            var7[var11] = var13 - 1;
            var8[var11] = var14 + 1;
            var11 = (var11 + 1) % var15;
            this.field_94[var13 - 1][var14 + 1] = 6;
         }

         if (var13 < this.field_90 - 1 && var14 < this.field_91 - 1 && (this.field_95[var13][var14 + 1] & 113) == 0 && (this.field_95[var13 + 1][var14] & 114) == 0 && (this.field_95[var13 + 1][var14 + 1] & 115) == 0 && this.field_94[var13 + 1][var14 + 1] == 0) {
            var7[var11] = var13 + 1;
            var8[var11] = var14 + 1;
            var11 = (var11 + 1) % var15;
            this.field_94[var13 + 1][var14 + 1] = 12;
         }
      }

      if (!var16) {
         return -1;
      } else {
         byte var20 = 0;
         var7[var20] = var13;
         var12 = var20 + 1;
         var8[var20] = var14;

         int var18;
         for(int var17 = var18 = this.field_94[var13][var14]; var13 != var1 || var14 != var2; var17 = this.field_94[var13][var14]) {
            if (var17 != var18) {
               var18 = var17;
               var7[var12] = var13;
               var8[var12++] = var14;
            }

            if ((var17 & 2) != 0) {
               ++var13;
            } else if ((var17 & 8) != 0) {
               --var13;
            }

            if ((var17 & 1) != 0) {
               ++var14;
            } else if ((var17 & 4) != 0) {
               --var14;
            }
         }

         return var12;
      }
   }

   // $FF: renamed from: jd (int, int, int) void
   public void method_83(int var1, int var2, int var3) {
      this.field_95[var1][var2] |= var3;
   }

   // $FF: renamed from: md (int, int, int) void
   public void method_84(int var1, int var2, int var3) {
      this.field_95[var1][var2] &= '\uffff' - var3;
   }

   // $FF: renamed from: wc (int, int, int, int) void
   public void method_85(int var1, int var2, int var3, int var4) {
      if (var1 >= 0 && var2 >= 0 && var1 < this.field_90 - 1 && var2 < this.field_91 - 1) {
         if (class_11.field_461[var4] == 1) {
            if (var3 == 0) {
               this.field_95[var1][var2] |= 1;
               if (var2 > 0) {
                  this.method_83(var1, var2 - 1, 4);
               }
            } else if (var3 == 1) {
               this.field_95[var1][var2] |= 2;
               if (var1 > 0) {
                  this.method_83(var1 - 1, var2, 8);
               }
            } else if (var3 == 2) {
               this.field_95[var1][var2] |= 16;
            } else if (var3 == 3) {
               this.field_95[var1][var2] |= 32;
            }

            this.method_89(var1, var2, 1, 1);
         }

      }
   }

   // $FF: renamed from: ce (int, int, int, int) void
   public void method_86(int var1, int var2, int var3, int var4) {
      if (var1 >= 0 && var2 >= 0 && var1 < this.field_90 - 1 && var2 < this.field_91 - 1) {
         if (class_11.field_461[var4] == 1) {
            if (var3 == 0) {
               this.field_95[var1][var2] &= 65534;
               if (var2 > 0) {
                  this.method_84(var1, var2 - 1, 4);
               }
            } else if (var3 == 1) {
               this.field_95[var1][var2] &= 65533;
               if (var1 > 0) {
                  this.method_84(var1 - 1, var2, 8);
               }
            } else if (var3 == 2) {
               this.field_95[var1][var2] &= 65519;
            } else if (var3 == 3) {
               this.field_95[var1][var2] &= 65503;
            }

            this.method_89(var1, var2, 1, 1);
         }

      }
   }

   // $FF: renamed from: bd (int, int, int) void
   public void method_87(int var1, int var2, int var3) {
      if (var1 >= 0 && var2 >= 0 && var1 < this.field_90 - 1 && var2 < this.field_91 - 1) {
         if (class_11.field_451[var3] == 1 || class_11.field_451[var3] == 2) {
            int var4 = this.method_102(var1, var2);
            int var5;
            int var6;
            if (var4 != 0 && var4 != 4) {
               var6 = class_11.field_449[var3];
               var5 = class_11.field_450[var3];
            } else {
               var5 = class_11.field_449[var3];
               var6 = class_11.field_450[var3];
            }

            for(int var7 = var1; var7 < var1 + var5; ++var7) {
               for(int var8 = var2; var8 < var2 + var6; ++var8) {
                  if (class_11.field_451[var3] == 1) {
                     this.field_95[var7][var8] |= 64;
                  } else if (var4 == 0) {
                     this.field_95[var7][var8] |= 2;
                     if (var7 > 0) {
                        this.method_83(var7 - 1, var8, 8);
                     }
                  } else if (var4 == 2) {
                     this.field_95[var7][var8] |= 4;
                     if (var8 < this.field_91 - 1) {
                        this.method_83(var7, var8 + 1, 1);
                     }
                  } else if (var4 == 4) {
                     this.field_95[var7][var8] |= 8;
                     if (var7 < this.field_90 - 1) {
                        this.method_83(var7 + 1, var8, 2);
                     }
                  } else if (var4 == 6) {
                     this.field_95[var7][var8] |= 1;
                     if (var8 > 0) {
                        this.method_83(var7, var8 - 1, 4);
                     }
                  }
               }
            }

            this.method_89(var1, var2, var5, var6);
         }

      }
   }

   // $FF: renamed from: yc (int, int, int) void
   public void method_88(int var1, int var2, int var3) {
      if (var1 >= 0 && var2 >= 0 && var1 < this.field_90 - 1 && var2 < this.field_91 - 1) {
         if (class_11.field_451[var3] == 1 || class_11.field_451[var3] == 2) {
            int var4 = this.method_102(var1, var2);
            int var5;
            int var6;
            if (var4 != 0 && var4 != 4) {
               var6 = class_11.field_449[var3];
               var5 = class_11.field_450[var3];
            } else {
               var5 = class_11.field_449[var3];
               var6 = class_11.field_450[var3];
            }

            for(int var7 = var1; var7 < var1 + var5; ++var7) {
               for(int var8 = var2; var8 < var2 + var6; ++var8) {
                  if (class_11.field_451[var3] == 1) {
                     this.field_95[var7][var8] &= 65471;
                  } else if (var4 == 0) {
                     this.field_95[var7][var8] &= 65533;
                     if (var7 > 0) {
                        this.method_84(var7 - 1, var8, 8);
                     }
                  } else if (var4 == 2) {
                     this.field_95[var7][var8] &= 65531;
                     if (var8 < this.field_91 - 1) {
                        this.method_84(var7, var8 + 1, 1);
                     }
                  } else if (var4 == 4) {
                     this.field_95[var7][var8] &= 65527;
                     if (var7 < this.field_90 - 1) {
                        this.method_84(var7 + 1, var8, 2);
                     }
                  } else if (var4 == 6) {
                     this.field_95[var7][var8] &= 65534;
                     if (var8 > 0) {
                        this.method_84(var7, var8 - 1, 4);
                     }
                  }
               }
            }

            this.method_89(var1, var2, var5, var6);
         }

      }
   }

   // $FF: renamed from: cd (int, int, int, int) void
   public void method_89(int var1, int var2, int var3, int var4) {
      if (var1 >= 1 && var2 >= 1 && var1 + var3 < this.field_90 && var2 + var4 < this.field_91) {
         for(int var5 = var1; var5 <= var1 + var3; ++var5) {
            for(int var6 = var2; var6 <= var2 + var4; ++var6) {
               if ((this.method_92(var5, var6) & 99) == 0 && (this.method_92(var5 - 1, var6) & 89) == 0 && (this.method_92(var5, var6 - 1) & 86) == 0 && (this.method_92(var5 - 1, var6 - 1) & 108) == 0) {
                  this.method_90(var5, var6, 0);
               } else {
                  this.method_90(var5, var6, 35);
               }
            }
         }

      }
   }

   // $FF: renamed from: be (int, int, int) void
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

   // $FF: renamed from: fd (int, int, int, int, int) void
   public void method_91(int var1, int var2, int var3, int var4, int var5) {
      class_8 var6 = this.field_98[var1 + var2 * 8];

      for(int var7 = 0; var7 < var6.field_259; ++var7) {
         if (var6.field_306[var7] == var3 * 128 && var6.field_308[var7] == var4 * 128) {
            var6.method_255(var7, var5);
            return;
         }
      }

   }

   // $FF: renamed from: td (int, int) int
   public int method_92(int var1, int var2) {
      return var1 >= 0 && var2 >= 0 && var1 < this.field_90 && var2 < this.field_91 ? this.field_95[var1][var2] : 0;
   }

   // $FF: renamed from: nd (int, int) int
   public int method_93(int var1, int var2) {
      int var3 = var1 >> 7;
      int var4 = var2 >> 7;
      int var5 = var1 & 127;
      int var6 = var2 & 127;
      if (var3 >= 0 && var4 >= 0 && var3 < this.field_90 - 1 && var4 < this.field_91 - 1) {
         int var7;
         int var8;
         int var9;
         if (var5 <= 128 - var6) {
            var7 = this.method_94(var3, var4);
            var8 = this.method_94(var3 + 1, var4) - var7;
            var9 = this.method_94(var3, var4 + 1) - var7;
         } else {
            var7 = this.method_94(var3 + 1, var4 + 1);
            var8 = this.method_94(var3, var4 + 1) - var7;
            var9 = this.method_94(var3 + 1, var4) - var7;
            var5 = 128 - var5;
            var6 = 128 - var6;
         }

         int var10 = var7 + var8 * var5 / 128 + var9 * var6 / 128;
         return var10;
      } else {
         return 0;
      }
   }

   // $FF: renamed from: vd (int, int) int
   public int method_94(int var1, int var2) {
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

         return (this.field_82[var3][var1 * 48 + var2] & 255) * 3;
      } else {
         return 0;
      }
   }

   // $FF: renamed from: ud (int, int) int
   public int method_95(int var1, int var2) {
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

         return this.field_83[var3][var1 * 48 + var2] & 255;
      } else {
         return 0;
      }
   }

   // $FF: renamed from: xd (int, int, int) int
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

         return this.field_87[var4][var1 * 48 + var2] & 255;
      } else {
         return 0;
      }
   }

   // $FF: renamed from: kd (int, int, int) void
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

         this.field_87[var4][var1 * 48 + var2] = (byte)var3;
      }
   }

   // $FF: renamed from: id (int, int, int) int
   public int method_98(int var1, int var2, int var3) {
      int var4 = this.method_96(var1, var2, var3);
      if (var4 == 0) {
         return -1;
      } else {
         int var5 = class_11.field_468[var4 - 1];
         return var5 == 2 ? 1 : 0;
      }
   }

   // $FF: renamed from: od (int, int, int, int) int
   public int method_99(int var1, int var2, int var3, int var4) {
      int var5 = this.method_96(var1, var2, var3);
      return var5 == 0 ? var4 : class_11.field_467[var5 - 1];
   }

   // $FF: renamed from: wd (int, int) int
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

         return this.field_89[var3][var1 * 48 + var2];
      } else {
         return 0;
      }
   }

   // $FF: renamed from: yd (int, int) int
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

         return this.field_86[var3][var1 * 48 + var2];
      } else {
         return 0;
      }
   }

   // $FF: renamed from: ld (int, int) int
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

         return this.field_88[var3][var1 * 48 + var2];
      } else {
         return 0;
      }
   }

   // $FF: renamed from: sd (int, int) boolean
   public boolean method_103(int var1, int var2) {
      return this.method_101(var1, var2) > 0 || this.method_101(var1 - 1, var2) > 0 || this.method_101(var1 - 1, var2 - 1) > 0 || this.method_101(var1, var2 - 1) > 0;
   }

   // $FF: renamed from: rd (int, int) boolean
   public boolean method_104(int var1, int var2) {
      return this.method_101(var1, var2) > 0 && this.method_101(var1 - 1, var2) > 0 && this.method_101(var1 - 1, var2 - 1) > 0 && this.method_101(var1, var2 - 1) > 0;
   }

   // $FF: renamed from: xc (int, int) int
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

         return this.field_85[var3][var1 * 48 + var2] & 255;
      } else {
         return 0;
      }
   }

   // $FF: renamed from: zd (int, int) int
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

         return this.field_84[var3][var1 * 48 + var2] & 255;
      } else {
         return 0;
      }
   }

   // $FF: renamed from: ad (int, int, int, int) void
   public void method_107(int var1, int var2, int var3, int var4) {
      String var5 = "m" + var3 + var1 / 10 + var1 % 10 + var2 / 10 + var2 % 10;

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
         byte[] var19;
         if (this.field_78 != null) {
            var19 = class_0.method_19(var5 + ".hei", 0, this.field_78);
            if (var19 == null && this.field_80 != null) {
               var19 = class_0.method_19(var5 + ".hei", 0, this.field_80);
            }

            if (var19 != null && var19.length > 0) {
               var7 = 0;
               var8 = 0;
               var9 = 0;

               while(var9 < 2304) {
                  var10 = var19[var7++] & 255;
                  if (var10 < 128) {
                     this.field_82[var4][var9++] = (byte)var10;
                     var8 = var10;
                  }

                  if (var10 >= 128) {
                     for(var11 = 0; var11 < var10 - 128; ++var11) {
                        this.field_82[var4][var9++] = (byte)var8;
                     }
                  }
               }

               var8 = 64;
               var10 = 0;

               label348:
               while(true) {
                  if (var10 >= 48) {
                     var8 = 0;
                     var11 = 0;

                     while(var11 < 2304) {
                        var12 = var19[var7++] & 255;
                        if (var12 < 128) {
                           this.field_83[var4][var11++] = (byte)var12;
                           var8 = var12;
                        }

                        if (var12 >= 128) {
                           for(var13 = 0; var13 < var12 - 128; ++var13) {
                              this.field_83[var4][var11++] = (byte)var8;
                           }
                        }
                     }

                     var8 = 35;
                     var12 = 0;

                     while(true) {
                        if (var12 >= 48) {
                           break label348;
                        }

                        for(var13 = 0; var13 < 48; ++var13) {
                           var8 = this.field_83[var4][var13 * 48 + var12] + var8 & 127;
                           this.field_83[var4][var13 * 48 + var12] = (byte)(var8 * 2);
                        }

                        ++var12;
                     }
                  }

                  for(var11 = 0; var11 < 48; ++var11) {
                     var8 = this.field_82[var4][var11 * 48 + var10] + var8 & 127;
                     this.field_82[var4][var11 * 48 + var10] = (byte)(var8 * 2);
                  }

                  ++var10;
               }
            } else {
               for(var7 = 0; var7 < 2304; ++var7) {
                  this.field_82[var4][var7] = 0;
                  this.field_83[var4][var7] = 0;
               }
            }

            var19 = class_0.method_19(var5 + ".dat", 0, this.field_79);
            if (var19 == null && this.field_81 != null) {
               var19 = class_0.method_19(var5 + ".dat", 0, this.field_81);
            }

            if (var19 == null || var19.length == 0) {
               throw new IOException();
            } else {
               var7 = 0;
               var8 = 0;

               while(true) {
                  while(var8 < 2304) {
                     var9 = var19[var7++] & 255;
                     if (var9 < 128) {
                        this.field_84[var4][var8++] = (byte)var9;
                     } else {
                        for(var10 = 0; var10 < var9 - 128; ++var10) {
                           this.field_84[var4][var8++] = 0;
                        }
                     }
                  }

                  var9 = 0;

                  while(true) {
                     while(var9 < 2304) {
                        var10 = var19[var7++] & 255;
                        if (var10 < 128) {
                           this.field_85[var4][var9++] = (byte)var10;
                        } else {
                           for(var11 = 0; var11 < var10 - 128; ++var11) {
                              this.field_85[var4][var9++] = 0;
                           }
                        }
                     }

                     var10 = 0;

                     while(true) {
                        while(var10 < 2304) {
                           var11 = var19[var7++] & 255;
                           if (var11 < 128) {
                              this.field_89[var4][var10++] = var11;
                           } else {
                              for(var12 = 0; var12 < var11 - 128; ++var12) {
                                 this.field_89[var4][var10++] = 0;
                              }
                           }
                        }

                        var11 = 0;

                        while(var11 < 2304) {
                           var12 = var19[var7++] & 255;
                           if (var12 < 128) {
                              this.field_89[var4][var11++] = var12 + 12000;
                           } else {
                              var11 += var12 - 128;
                           }
                        }

                        var12 = 0;

                        while(true) {
                           while(var12 < 2304) {
                              var13 = var19[var7++] & 255;
                              if (var13 < 128) {
                                 this.field_86[var4][var12++] = (byte)var13;
                              } else {
                                 for(var14 = 0; var14 < var13 - 128; ++var14) {
                                    this.field_86[var4][var12++] = 0;
                                 }
                              }
                           }

                           var13 = 0;
                           var14 = 0;

                           while(true) {
                              while(var14 < 2304) {
                                 var15 = var19[var7++] & 255;
                                 if (var15 < 128) {
                                    this.field_87[var4][var14++] = (byte)var15;
                                    var13 = var15;
                                 } else {
                                    for(var16 = 0; var16 < var15 - 128; ++var16) {
                                       this.field_87[var4][var14++] = (byte)var13;
                                    }
                                 }
                              }

                              var15 = 0;

                              while(true) {
                                 int var17;
                                 while(var15 < 2304) {
                                    var16 = var19[var7++] & 255;
                                    if (var16 < 128) {
                                       this.field_88[var4][var15++] = (byte)var16;
                                    } else {
                                       for(var17 = 0; var17 < var16 - 128; ++var17) {
                                          this.field_88[var4][var15++] = 0;
                                       }
                                    }
                                 }

                                 var19 = class_0.method_19(var5 + ".loc", 0, this.field_79);
                                 if (var19 != null && var19.length > 0) {
                                    var7 = 0;
                                    var16 = 0;

                                    while(var16 < 2304) {
                                       var17 = var19[var7++] & 255;
                                       if (var17 < 128) {
                                          this.field_89[var4][var16++] = var17 + '\ubb80';
                                       } else {
                                          var16 += var17 - 128;
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
            var19 = new byte[20736];
            class_0.method_1("../gamedata/maps/" + var5 + ".jm", var19, 20736);
            var7 = 0;
            var8 = 0;

            for(var9 = 0; var9 < 2304; ++var9) {
               var7 = var7 + var19[var8++] & 255;
               this.field_82[var4][var9] = (byte)var7;
            }

            var7 = 0;

            for(var10 = 0; var10 < 2304; ++var10) {
               var7 = var7 + var19[var8++] & 255;
               this.field_83[var4][var10] = (byte)var7;
            }

            for(var11 = 0; var11 < 2304; ++var11) {
               this.field_84[var4][var11] = var19[var8++];
            }

            for(var12 = 0; var12 < 2304; ++var12) {
               this.field_85[var4][var12] = var19[var8++];
            }

            for(var13 = 0; var13 < 2304; ++var13) {
               this.field_89[var4][var13] = (var19[var8] & 255) * 256 + (var19[var8 + 1] & 255);
               var8 += 2;
            }

            for(var14 = 0; var14 < 2304; ++var14) {
               this.field_86[var4][var14] = var19[var8++];
            }

            for(var15 = 0; var15 < 2304; ++var15) {
               this.field_87[var4][var15] = var19[var8++];
            }

            for(var16 = 0; var16 < 2304; ++var16) {
               this.field_88[var4][var16] = var19[var8++];
            }

         }
      } catch (IOException var18) {
         for(int var6 = 0; var6 < 2304; ++var6) {
            this.field_82[var4][var6] = 0;
            this.field_83[var4][var6] = 0;
            this.field_84[var4][var6] = 0;
            this.field_85[var4][var6] = 0;
            this.field_89[var4][var6] = 0;
            this.field_86[var4][var6] = 0;
            this.field_87[var4][var6] = 0;
            if (var3 == 0) {
               this.field_87[var4][var6] = -6;
            }

            if (var3 == 3) {
               this.field_87[var4][var6] = 8;
            }

            this.field_88[var4][var6] = 0;
         }

      }
   }

   // $FF: renamed from: ae () void
   public void method_108() {
      if (this.field_67) {
         this.field_69.method_365();
      }

      for(int var1 = 0; var1 < 64; ++var1) {
         this.field_98[var1] = null;

         for(int var2 = 0; var2 < 4; ++var2) {
            this.field_99[var2][var1] = null;
         }

         for(int var3 = 0; var3 < 4; ++var3) {
            this.field_100[var3][var1] = null;
         }
      }

      System.gc();
   }

   // $FF: renamed from: ed (int, int, int) void
   public void method_109(int var1, int var2, int var3) {
      this.method_108();
      int var4 = (var1 + 24) / 48;
      int var5 = (var2 + 24) / 48;
      this.method_112(var1, var2, var3, true);
      if (var3 == 0) {
         this.method_112(var1, var2, 1, false);
         this.method_112(var1, var2, 2, false);
         this.method_107(var4 - 1, var5 - 1, var3, 0);
         this.method_107(var4, var5 - 1, var3, 1);
         this.method_107(var4 - 1, var5, var3, 2);
         this.method_107(var4, var5, var3, 3);
         this.method_110();
      }

   }

   // $FF: renamed from: de () void
   public void method_110() {
      for(int var1 = 0; var1 < 96; ++var1) {
         for(int var2 = 0; var2 < 96; ++var2) {
            if (this.method_96(var1, var2, 0) == 250) {
               if (var1 == 47 && this.method_96(var1 + 1, var2, 0) != 250 && this.method_96(var1 + 1, var2, 0) != 2) {
                  this.method_97(var1, var2, 9);
               } else if (var2 == 47 && this.method_96(var1, var2 + 1, 0) != 250 && this.method_96(var1, var2 + 1, 0) != 2) {
                  this.method_97(var1, var2, 9);
               } else {
                  this.method_97(var1, var2, 2);
               }
            }
         }
      }

   }

   // $FF: renamed from: pd (int, int, int, int, int) void
   public void method_111(int var1, int var2, int var3, int var4, int var5) {
      int var6 = var1 * 3;
      int var7 = var2 * 3;
      int var8 = this.field_69.method_402(var4);
      int var9 = this.field_69.method_402(var5);
      var8 = var8 >> 1 & 8355711;
      var9 = var9 >> 1 & 8355711;
      if (var3 == 0) {
         this.field_68.method_38(var6, var7, 3, var8);
         this.field_68.method_38(var6, var7 + 1, 2, var8);
         this.field_68.method_38(var6, var7 + 2, 1, var8);
         this.field_68.method_38(var6 + 2, var7 + 1, 1, var9);
         this.field_68.method_38(var6 + 1, var7 + 2, 2, var9);
      } else {
         if (var3 == 1) {
            this.field_68.method_38(var6, var7, 3, var9);
            this.field_68.method_38(var6 + 1, var7 + 1, 2, var9);
            this.field_68.method_38(var6 + 2, var7 + 2, 1, var9);
            this.field_68.method_38(var6, var7 + 1, 1, var8);
            this.field_68.method_38(var6, var7 + 2, 2, var8);
         }

      }
   }

   // $FF: renamed from: hd (int, int, int, boolean) void
   public void method_112(int var1, int var2, int var3, boolean var4) {
      int var5 = (var1 + 24) / 48;
      int var6 = (var2 + 24) / 48;
      this.method_107(var5 - 1, var6 - 1, var3, 0);
      this.method_107(var5, var6 - 1, var3, 1);
      this.method_107(var5 - 1, var6, var3, 2);
      this.method_107(var5, var6, var3, 3);
      this.method_110();
      if (this.field_101 == null) {
         this.field_101 = new class_8(this.field_90 * this.field_91 * 2 + 256, this.field_90 * this.field_91 * 2 + 256, true, true, false, false, true);
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
         this.field_68.method_32();

         for(var7 = 0; var7 < 96; ++var7) {
            for(var8 = 0; var8 < 96; ++var8) {
               this.field_95[var7][var8] = 0;
            }
         }

         class_8 var40 = this.field_101;
         var40.method_244();

         for(var9 = 0; var9 < 96; ++var9) {
            for(var10 = 0; var10 < 96; ++var10) {
               var11 = -this.method_94(var9, var10);
               if (this.method_96(var9, var10, var3) > 0 && class_11.field_468[this.method_96(var9, var10, var3) - 1] == 4) {
                  var11 = 0;
               }

               if (this.method_96(var9 - 1, var10, var3) > 0 && class_11.field_468[this.method_96(var9 - 1, var10, var3) - 1] == 4) {
                  var11 = 0;
               }

               if (this.method_96(var9, var10 - 1, var3) > 0 && class_11.field_468[this.method_96(var9, var10 - 1, var3) - 1] == 4) {
                  var11 = 0;
               }

               if (this.method_96(var9 - 1, var10 - 1, var3) > 0 && class_11.field_468[this.method_96(var9 - 1, var10 - 1, var3) - 1] == 4) {
                  var11 = 0;
               }

               var12 = var40.method_247(var9 * 128, var11, var10 * 128);
               var13 = (int)(Math.random() * 10.0D) - 5;
               var40.method_255(var12, var13);
            }
         }

         int[] var41;
         for(var10 = 0; var10 < 95; ++var10) {
            for(var11 = 0; var11 < 95; ++var11) {
               var12 = this.method_95(var10, var11);
               var13 = this.field_73[var12];
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
                  var12 = class_11.field_468[var17 - 1];
                  var18 = this.method_98(var10, var11, var3);
                  var13 = var14 = class_11.field_467[var17 - 1];
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
                        if (this.method_99(var10 - 1, var11, var3, var15) != 12345678 && this.method_99(var10, var11 - 1, var3, var15) != 12345678) {
                           var13 = this.method_99(var10 - 1, var11, var3, var15);
                           var16 = 0;
                        } else if (this.method_99(var10 + 1, var11, var3, var15) != 12345678 && this.method_99(var10, var11 + 1, var3, var15) != 12345678) {
                           var14 = this.method_99(var10 + 1, var11, var3, var15);
                           var16 = 0;
                        } else if (this.method_99(var10 + 1, var11, var3, var15) != 12345678 && this.method_99(var10, var11 - 1, var3, var15) != 12345678) {
                           var14 = this.method_99(var10 + 1, var11, var3, var15);
                           var16 = 1;
                        } else if (this.method_99(var10 - 1, var11, var3, var15) != 12345678 && this.method_99(var10, var11 + 1, var3, var15) != 12345678) {
                           var13 = this.method_99(var10 - 1, var11, var3, var15);
                           var16 = 1;
                        }
                     }
                  } else if (var12 != 2 || this.method_100(var10, var11) > 0 && this.method_100(var10, var11) < 24000) {
                     if (this.method_98(var10 - 1, var11, var3) != var18 && this.method_98(var10, var11 - 1, var3) != var18) {
                        var13 = var15;
                        var16 = 0;
                     } else if (this.method_98(var10 + 1, var11, var3) != var18 && this.method_98(var10, var11 + 1, var3) != var18) {
                        var14 = var15;
                        var16 = 0;
                     } else if (this.method_98(var10 + 1, var11, var3) != var18 && this.method_98(var10, var11 - 1, var3) != var18) {
                        var14 = var15;
                        var16 = 1;
                     } else if (this.method_98(var10 - 1, var11, var3) != var18 && this.method_98(var10, var11 + 1, var3) != var18) {
                        var13 = var15;
                        var16 = 1;
                     }
                  }

                  if (class_11.field_469[var17 - 1] != 0) {
                     this.field_95[var10][var11] |= 64;
                  }

                  if (class_11.field_468[var17 - 1] == 2) {
                     this.field_95[var10][var11] |= 128;
                  }
               }

               this.method_111(var10, var11, var16, var13, var14);
               var17 = this.method_94(var10 + 1, var11 + 1) - this.method_94(var10 + 1, var11) + this.method_94(var10, var11 + 1) - this.method_94(var10, var11);
               if (var13 == var14 && var17 == 0) {
                  if (var13 != 12345678) {
                     var41 = new int[]{var11 + var10 * this.field_90 + this.field_90, var11 + var10 * this.field_90, var11 + var10 * this.field_90 + 1, var11 + var10 * this.field_90 + this.field_90 + 1};
                     var42 = var40.method_249(4, var41, 12345678, var13);
                     this.field_92[var42] = var10;
                     this.field_93[var42] = var11;
                     var40.field_292[var42] = 200000 + var42;
                  }
               } else {
                  var41 = new int[3];
                  int[] var19 = new int[3];
                  if (var16 == 0) {
                     if (var13 != 12345678) {
                        var41[0] = var11 + var10 * this.field_90 + this.field_90;
                        var41[1] = var11 + var10 * this.field_90;
                        var41[2] = var11 + var10 * this.field_90 + 1;
                        var20 = var40.method_249(3, var41, 12345678, var13);
                        this.field_92[var20] = var10;
                        this.field_93[var20] = var11;
                        var40.field_292[var20] = 200000 + var20;
                     }

                     if (var14 != 12345678) {
                        var19[0] = var11 + var10 * this.field_90 + 1;
                        var19[1] = var11 + var10 * this.field_90 + this.field_90 + 1;
                        var19[2] = var11 + var10 * this.field_90 + this.field_90;
                        var20 = var40.method_249(3, var19, 12345678, var14);
                        this.field_92[var20] = var10;
                        this.field_93[var20] = var11;
                        var40.field_292[var20] = 200000 + var20;
                     }
                  } else {
                     if (var13 != 12345678) {
                        var41[0] = var11 + var10 * this.field_90 + 1;
                        var41[1] = var11 + var10 * this.field_90 + this.field_90 + 1;
                        var41[2] = var11 + var10 * this.field_90;
                        var20 = var40.method_249(3, var41, 12345678, var13);
                        this.field_92[var20] = var10;
                        this.field_93[var20] = var11;
                        var40.field_292[var20] = 200000 + var20;
                     }

                     if (var14 != 12345678) {
                        var19[0] = var11 + var10 * this.field_90 + this.field_90;
                        var19[1] = var11 + var10 * this.field_90;
                        var19[2] = var11 + var10 * this.field_90 + this.field_90 + 1;
                        var20 = var40.method_249(3, var19, 12345678, var14);
                        this.field_92[var20] = var10;
                        this.field_93[var20] = var11;
                        var40.field_292[var20] = 200000 + var20;
                     }
                  }
               }
            }
         }

         for(var11 = 1; var11 < 95; ++var11) {
            for(var12 = 1; var12 < 95; ++var12) {
               if (this.method_96(var11, var12, var3) > 0 && class_11.field_468[this.method_96(var11, var12, var3) - 1] == 4) {
                  var13 = class_11.field_467[this.method_96(var11, var12, var3) - 1];
                  var14 = var40.method_247(var11 * 128, -this.method_94(var11, var12), var12 * 128);
                  var15 = var40.method_247((var11 + 1) * 128, -this.method_94(var11 + 1, var12), var12 * 128);
                  var43 = var40.method_247((var11 + 1) * 128, -this.method_94(var11 + 1, var12 + 1), (var12 + 1) * 128);
                  var17 = var40.method_247(var11 * 128, -this.method_94(var11, var12 + 1), (var12 + 1) * 128);
                  var41 = new int[]{var14, var15, var43, var17};
                  var42 = var40.method_249(4, var41, var13, 12345678);
                  this.field_92[var42] = var11;
                  this.field_93[var42] = var12;
                  var40.field_292[var42] = 200000 + var42;
                  this.method_111(var11, var12, 0, var13, var13);
               } else if (this.method_96(var11, var12, var3) == 0 || class_11.field_468[this.method_96(var11, var12, var3) - 1] != 3) {
                  if (this.method_96(var11, var12 + 1, var3) > 0 && class_11.field_468[this.method_96(var11, var12 + 1, var3) - 1] == 4) {
                     var13 = class_11.field_467[this.method_96(var11, var12 + 1, var3) - 1];
                     var14 = var40.method_247(var11 * 128, -this.method_94(var11, var12), var12 * 128);
                     var15 = var40.method_247((var11 + 1) * 128, -this.method_94(var11 + 1, var12), var12 * 128);
                     var43 = var40.method_247((var11 + 1) * 128, -this.method_94(var11 + 1, var12 + 1), (var12 + 1) * 128);
                     var17 = var40.method_247(var11 * 128, -this.method_94(var11, var12 + 1), (var12 + 1) * 128);
                     var41 = new int[]{var14, var15, var43, var17};
                     var42 = var40.method_249(4, var41, var13, 12345678);
                     this.field_92[var42] = var11;
                     this.field_93[var42] = var12;
                     var40.field_292[var42] = 200000 + var42;
                     this.method_111(var11, var12, 0, var13, var13);
                  }

                  if (this.method_96(var11, var12 - 1, var3) > 0 && class_11.field_468[this.method_96(var11, var12 - 1, var3) - 1] == 4) {
                     var13 = class_11.field_467[this.method_96(var11, var12 - 1, var3) - 1];
                     var14 = var40.method_247(var11 * 128, -this.method_94(var11, var12), var12 * 128);
                     var15 = var40.method_247((var11 + 1) * 128, -this.method_94(var11 + 1, var12), var12 * 128);
                     var43 = var40.method_247((var11 + 1) * 128, -this.method_94(var11 + 1, var12 + 1), (var12 + 1) * 128);
                     var17 = var40.method_247(var11 * 128, -this.method_94(var11, var12 + 1), (var12 + 1) * 128);
                     var41 = new int[]{var14, var15, var43, var17};
                     var42 = var40.method_249(4, var41, var13, 12345678);
                     this.field_92[var42] = var11;
                     this.field_93[var42] = var12;
                     var40.field_292[var42] = 200000 + var42;
                     this.method_111(var11, var12, 0, var13, var13);
                  }

                  if (this.method_96(var11 + 1, var12, var3) > 0 && class_11.field_468[this.method_96(var11 + 1, var12, var3) - 1] == 4) {
                     var13 = class_11.field_467[this.method_96(var11 + 1, var12, var3) - 1];
                     var14 = var40.method_247(var11 * 128, -this.method_94(var11, var12), var12 * 128);
                     var15 = var40.method_247((var11 + 1) * 128, -this.method_94(var11 + 1, var12), var12 * 128);
                     var43 = var40.method_247((var11 + 1) * 128, -this.method_94(var11 + 1, var12 + 1), (var12 + 1) * 128);
                     var17 = var40.method_247(var11 * 128, -this.method_94(var11, var12 + 1), (var12 + 1) * 128);
                     var41 = new int[]{var14, var15, var43, var17};
                     var42 = var40.method_249(4, var41, var13, 12345678);
                     this.field_92[var42] = var11;
                     this.field_93[var42] = var12;
                     var40.field_292[var42] = 200000 + var42;
                     this.method_111(var11, var12, 0, var13, var13);
                  }

                  if (this.method_96(var11 - 1, var12, var3) > 0 && class_11.field_468[this.method_96(var11 - 1, var12, var3) - 1] == 4) {
                     var13 = class_11.field_467[this.method_96(var11 - 1, var12, var3) - 1];
                     var14 = var40.method_247(var11 * 128, -this.method_94(var11, var12), var12 * 128);
                     var15 = var40.method_247((var11 + 1) * 128, -this.method_94(var11 + 1, var12), var12 * 128);
                     var43 = var40.method_247((var11 + 1) * 128, -this.method_94(var11 + 1, var12 + 1), (var12 + 1) * 128);
                     var17 = var40.method_247(var11 * 128, -this.method_94(var11, var12 + 1), (var12 + 1) * 128);
                     var41 = new int[]{var14, var15, var43, var17};
                     var42 = var40.method_249(4, var41, var13, 12345678);
                     this.field_92[var42] = var11;
                     this.field_93[var42] = var12;
                     var40.field_292[var42] = 200000 + var42;
                     this.method_111(var11, var12, 0, var13, var13);
                  }
               }
            }
         }

         var40.method_252(true, 40, 48, -50, -10, -50);
         this.field_98 = this.field_101.method_250(0, 0, 1536, 1536, 8, 64, 233, false);

         for(var12 = 0; var12 < 64; ++var12) {
            this.field_69.method_363(this.field_98[var12]);
         }

         for(var13 = 0; var13 < 96; ++var13) {
            for(var14 = 0; var14 < 96; ++var14) {
               this.field_96[var13][var14] = this.method_94(var13, var14);
            }
         }
      }

      this.field_101.method_244();
      var7 = 6316128;

      for(var8 = 0; var8 < 95; ++var8) {
         for(var9 = 0; var9 < 95; ++var9) {
            var10 = this.method_105(var8, var9);
            if (var10 > 0 && (class_11.field_462[var10 - 1] == 0 || this.field_66)) {
               this.method_114(this.field_101, var10 - 1, var8, var9, var8 + 1, var9);
               if (var4 && class_11.field_461[var10 - 1] != 0) {
                  this.field_95[var8][var9] |= 1;
                  if (var9 > 0) {
                     this.method_83(var8, var9 - 1, 4);
                  }
               }

               if (var4) {
                  this.field_68.method_38(var8 * 3, var9 * 3, 3, var7);
               }
            }

            var10 = this.method_106(var8, var9);
            if (var10 > 0 && (class_11.field_462[var10 - 1] == 0 || this.field_66)) {
               this.method_114(this.field_101, var10 - 1, var8, var9, var8, var9 + 1);
               if (var4 && class_11.field_461[var10 - 1] != 0) {
                  this.field_95[var8][var9] |= 2;
                  if (var8 > 0) {
                     this.method_83(var8 - 1, var9, 8);
                  }
               }

               if (var4) {
                  this.field_68.method_39(var8 * 3, var9 * 3, 3, var7);
               }
            }

            var10 = this.method_100(var8, var9);
            if (var10 > 0 && var10 < 12000 && (class_11.field_462[var10 - 1] == 0 || this.field_66)) {
               this.method_114(this.field_101, var10 - 1, var8, var9, var8 + 1, var9 + 1);
               if (var4 && class_11.field_461[var10 - 1] != 0) {
                  this.field_95[var8][var9] |= 32;
               }

               if (var4) {
                  this.field_68.method_40(var8 * 3, var9 * 3, var7);
                  this.field_68.method_40(var8 * 3 + 1, var9 * 3 + 1, var7);
                  this.field_68.method_40(var8 * 3 + 2, var9 * 3 + 2, var7);
               }
            }

            if (var10 > 12000 && var10 < 24000 && (class_11.field_462[var10 - 12001] == 0 || this.field_66)) {
               this.method_114(this.field_101, var10 - 12001, var8 + 1, var9, var8, var9 + 1);
               if (var4 && class_11.field_461[var10 - 12001] != 0) {
                  this.field_95[var8][var9] |= 16;
               }

               if (var4) {
                  this.field_68.method_40(var8 * 3 + 2, var9 * 3, var7);
                  this.field_68.method_40(var8 * 3 + 1, var9 * 3 + 1, var7);
                  this.field_68.method_40(var8 * 3, var9 * 3 + 2, var7);
               }
            }
         }
      }

      if (var4) {
         this.field_68.method_50(this.field_70 - 1, 0, 0, 285, 285);
      }

      this.field_101.method_252(false, 60, 24, -50, -10, -50);
      this.field_99[var3] = this.field_101.method_250(0, 0, 1536, 1536, 8, 64, 338, true);

      for(var9 = 0; var9 < 64; ++var9) {
         this.field_69.method_363(this.field_99[var3][var9]);
      }

      for(var10 = 0; var10 < 95; ++var10) {
         for(var11 = 0; var11 < 95; ++var11) {
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
      for(var11 = 1; var11 < 95; ++var11) {
         for(var12 = 1; var12 < 95; ++var12) {
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

      this.field_101.method_244();

      for(var12 = 1; var12 < 95; ++var12) {
         for(var13 = 1; var13 < 95; ++var13) {
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
               int var35 = class_11.field_464[var14 - 1];
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

               var14 = class_11.field_465[var14 - 1];
               var31 = -var31;
               var32 = -var32;
               var33 = -var33;
               var34 = -var34;
               int[] var44;
               if (this.method_100(var12, var13) > 12000 && this.method_100(var12, var13) < 24000 && this.method_101(var12 - 1, var13 - 1) == 0) {
                  var44 = new int[]{this.field_101.method_247(var29, var33, var26), this.field_101.method_247(var27, var34, var30), this.field_101.method_247(var25, var32, var28)};
                  this.field_101.method_249(3, var44, var14, 12345678);
               } else if (this.method_100(var12, var13) > 12000 && this.method_100(var12, var13) < 24000 && this.method_101(var12 + 1, var13 + 1) == 0) {
                  var44 = new int[]{this.field_101.method_247(var23, var31, var24), this.field_101.method_247(var25, var32, var28), this.field_101.method_247(var27, var34, var30)};
                  this.field_101.method_249(3, var44, var14, 12345678);
               } else if (this.method_100(var12, var13) > 0 && this.method_100(var12, var13) < 12000 && this.method_101(var12 + 1, var13 - 1) == 0) {
                  var44 = new int[]{this.field_101.method_247(var27, var34, var30), this.field_101.method_247(var23, var31, var24), this.field_101.method_247(var29, var33, var26)};
                  this.field_101.method_249(3, var44, var14, 12345678);
               } else if (this.method_100(var12, var13) > 0 && this.method_100(var12, var13) < 12000 && this.method_101(var12 - 1, var13 + 1) == 0) {
                  var44 = new int[]{this.field_101.method_247(var25, var32, var28), this.field_101.method_247(var29, var33, var26), this.field_101.method_247(var23, var31, var24)};
                  this.field_101.method_249(3, var44, var14, 12345678);
               } else if (var31 == var32 && var33 == var34) {
                  var44 = new int[]{this.field_101.method_247(var23, var31, var24), this.field_101.method_247(var25, var32, var28), this.field_101.method_247(var29, var33, var26), this.field_101.method_247(var27, var34, var30)};
                  this.field_101.method_249(4, var44, var14, 12345678);
               } else if (var31 == var34 && var32 == var33) {
                  var44 = new int[]{this.field_101.method_247(var27, var34, var30), this.field_101.method_247(var23, var31, var24), this.field_101.method_247(var25, var32, var28), this.field_101.method_247(var29, var33, var26)};
                  this.field_101.method_249(4, var44, var14, 12345678);
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
                     var38 = new int[]{this.field_101.method_247(var25, var32, var28), this.field_101.method_247(var29, var33, var26), this.field_101.method_247(var23, var31, var24)};
                     this.field_101.method_249(3, var38, var14, 12345678);
                     var39 = new int[]{this.field_101.method_247(var27, var34, var30), this.field_101.method_247(var23, var31, var24), this.field_101.method_247(var29, var33, var26)};
                     this.field_101.method_249(3, var39, var14, 12345678);
                  } else {
                     var38 = new int[]{this.field_101.method_247(var23, var31, var24), this.field_101.method_247(var25, var32, var28), this.field_101.method_247(var27, var34, var30)};
                     this.field_101.method_249(3, var38, var14, 12345678);
                     var39 = new int[]{this.field_101.method_247(var29, var33, var26), this.field_101.method_247(var27, var34, var30), this.field_101.method_247(var25, var32, var28)};
                     this.field_101.method_249(3, var39, var14, 12345678);
                  }
               }
            }
         }
      }

      this.field_101.method_252(true, 50, 50, -50, -10, -50);
      this.field_100[var3] = this.field_101.method_250(0, 0, 1536, 1536, 8, 64, 169, true);

      for(var13 = 0; var13 < 64; ++var13) {
         this.field_69.method_363(this.field_100[var3][var13]);
      }

      for(var14 = 0; var14 < 96; ++var14) {
         for(var15 = 0; var15 < 96; ++var15) {
            if (this.field_96[var14][var15] >= 80000) {
               this.field_96[var14][var15] -= 80000;
            }
         }
      }

   }

   // $FF: renamed from: qd (jagex.client.q[]) void
   public void method_113(class_8[] var1) {
      for(int var2 = 0; var2 < this.field_90 - 2; ++var2) {
         for(int var3 = 0; var3 < this.field_91 - 2; ++var3) {
            if (this.method_100(var2, var3) > 48000 && this.method_100(var2, var3) < 60000) {
               int var4 = this.method_100(var2, var3) - '\ubb81';
               int var5 = this.method_102(var2, var3);
               int var6;
               int var7;
               if (var5 != 0 && var5 != 4) {
                  var7 = class_11.field_449[var4];
                  var6 = class_11.field_450[var4];
               } else {
                  var6 = class_11.field_449[var4];
                  var7 = class_11.field_450[var4];
               }

               this.method_87(var2, var3, var4);
               class_8 var8 = var1[class_11.field_448[var4]].method_275(false, true, false, false);
               int var9 = (var2 + var2 + var6) * 128 / 2;
               int var10 = (var3 + var3 + var7) * 128 / 2;
               var8.method_258(var9, -this.method_93(var9, var10), var10);
               var8.method_257(0, this.method_102(var2, var3) * 32, 0);
               this.field_69.method_363(var8);
               var8.method_253(48, 48, -50, -10, -50);
               if (var6 > 1 || var7 > 1) {
                  for(int var11 = var2; var11 < var2 + var6; ++var11) {
                     for(int var12 = var3; var12 < var3 + var7; ++var12) {
                        if ((var11 > var2 || var12 > var3) && this.method_100(var11, var12) - '\ubb81' == var4) {
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

                           this.field_89[var13][var9 * 48 + var10] = 0;
                        }
                     }
                  }
               }
            }
         }
      }

   }

   // $FF: renamed from: zc (jagex.client.q, int, int, int, int, int) void
   public void method_114(class_8 var1, int var2, int var3, int var4, int var5, int var6) {
      this.method_90(var3, var4, 40);
      this.method_90(var5, var6, 40);
      int var7 = class_11.field_458[var2];
      int var8 = class_11.field_459[var2];
      int var9 = class_11.field_460[var2];
      int var10 = var3 * 128;
      int var11 = var4 * 128;
      int var12 = var5 * 128;
      int var13 = var6 * 128;
      int var14 = var1.method_247(var10, -this.field_96[var3][var4], var11);
      int var15 = var1.method_247(var10, -this.field_96[var3][var4] - var7, var11);
      int var16 = var1.method_247(var12, -this.field_96[var5][var6] - var7, var13);
      int var17 = var1.method_247(var12, -this.field_96[var5][var6], var13);
      int[] var18 = new int[]{var14, var15, var16, var17};
      int var19 = var1.method_249(4, var18, var8, var9);
      if (class_11.field_462[var2] == 5) {
         var1.field_292[var19] = 30000 + var2;
      } else {
         var1.field_292[var19] = 0;
      }
   }

   // $FF: renamed from: dd (int, int, int, int, int) void
   public void method_115(int var1, int var2, int var3, int var4, int var5) {
      int var6 = class_11.field_458[var1];
      if (this.field_96[var2][var3] < 80000) {
         this.field_96[var2][var3] += 80000 + var6;
      }

      if (this.field_96[var4][var5] < 80000) {
         this.field_96[var4][var5] += 80000 + var6;
      }

   }
}
