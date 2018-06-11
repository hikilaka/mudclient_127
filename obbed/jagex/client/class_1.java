package jagex.client;

import jagex.class_0;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.ColorModel;
import java.awt.image.DirectColorModel;
import java.awt.image.ImageConsumer;
import java.awt.image.ImageObserver;
import java.awt.image.ImageProducer;
import java.util.Hashtable;

// $FF: renamed from: jagex.client.j
public class class_1 implements ImageProducer, ImageObserver {
   // $FF: renamed from: pi int
   public static final int field_9 = 0;
   // $FF: renamed from: qi int
   public int field_10;
   // $FF: renamed from: ri int
   public int field_11;
   // $FF: renamed from: si int
   public int field_12;
   // $FF: renamed from: ti int
   public int field_13;
   // $FF: renamed from: ui int
   public int field_14;
   // $FF: renamed from: vi java.awt.image.ColorModel
   ColorModel field_15;
   // $FF: renamed from: wi int[]
   public int[] field_16;
   // $FF: renamed from: xi java.awt.image.ImageConsumer
   ImageConsumer field_17;
   // $FF: renamed from: yi java.awt.Component
   private Component field_18;
   // $FF: renamed from: zi java.awt.Image
   public Image field_19;
   // $FF: renamed from: aj int[][]
   public int[][] field_20;
   // $FF: renamed from: bj byte[][]
   public byte[][] field_21;
   // $FF: renamed from: cj int[][]
   public int[][] field_22;
   // $FF: renamed from: dj int[]
   public int[] field_23;
   // $FF: renamed from: ej int[]
   public int[] field_24;
   // $FF: renamed from: fj int[]
   public int[] field_25;
   // $FF: renamed from: gj int[]
   public int[] field_26;
   // $FF: renamed from: hj int[]
   public int[] field_27;
   // $FF: renamed from: ij int[]
   public int[] field_28;
   // $FF: renamed from: jj boolean[]
   public boolean[] field_29;
   // $FF: renamed from: kj int
   private int field_30;
   // $FF: renamed from: lj int
   private int field_31;
   // $FF: renamed from: mj int
   private int field_32;
   // $FF: renamed from: nj int
   private int field_33;
   // $FF: renamed from: oj boolean
   public boolean field_34 = false;
   // $FF: renamed from: pj byte[][]
   static byte[][] field_35 = new byte[50][];
   // $FF: renamed from: qj int[]
   static int[] field_36;
   // $FF: renamed from: rj int
   static int field_37;
   // $FF: renamed from: sj boolean
   public boolean field_38 = false;
   // $FF: renamed from: tj int[]
   int[] field_39;
   // $FF: renamed from: uj int[]
   int[] field_40;
   // $FF: renamed from: vj int[]
   int[] field_41;
   // $FF: renamed from: wj int[]
   int[] field_42;
   // $FF: renamed from: xj int[]
   int[] field_43;
   // $FF: renamed from: yj int[]
   int[] field_44;
   // $FF: renamed from: zj int[]
   int[] field_45;
   // $FF: renamed from: ak int
   public static final int field_46 = 0;
   // $FF: renamed from: bk int
   public static final int field_47 = 16777215;
   // $FF: renamed from: ck int
   public static final int field_48 = 16711680;
   // $FF: renamed from: dk int
   public static final int field_49 = 12582912;
   // $FF: renamed from: ek int
   public static final int field_50 = 65280;
   // $FF: renamed from: fk int
   public static final int field_51 = 255;
   // $FF: renamed from: gk int
   public static final int field_52 = 16776960;
   // $FF: renamed from: hk int
   public static final int field_53 = 65535;
   // $FF: renamed from: ik int
   public static final int field_54 = 16711935;
   // $FF: renamed from: jk int
   public static final int field_55 = 12632256;
   // $FF: renamed from: kk int
   public static final int field_56 = 8421504;
   // $FF: renamed from: lk int
   public static final int field_57 = 4210752;
   // $FF: renamed from: mk int
   public static final int field_58 = 16744448;
   // $FF: renamed from: nk int
   public static final int field_59 = 0;
   // $FF: renamed from: ok int
   public static final int field_60 = 1;
   // $FF: renamed from: pk int
   public static final int field_61 = 3;
   // $FF: renamed from: qk int
   public static final int field_62 = 4;
   // $FF: renamed from: rk int
   public static final int field_63 = 5;
   // $FF: renamed from: sk int
   public static final int field_64 = 7;

   public class_1(int var1, int var2, int var3, Component var4) {
      super();
      this.field_18 = var4;
      this.field_31 = var2;
      this.field_33 = var1;
      this.field_13 = this.field_10 = var1;
      this.field_14 = this.field_11 = var2;
      this.field_12 = var1 * var2;
      this.field_16 = new int[var1 * var2];
      this.field_20 = new int[var3][];
      this.field_29 = new boolean[var3];
      this.field_21 = new byte[var3][];
      this.field_22 = new int[var3][];
      this.field_23 = new int[var3];
      this.field_24 = new int[var3];
      this.field_27 = new int[var3];
      this.field_28 = new int[var3];
      this.field_25 = new int[var3];
      this.field_26 = new int[var3];
      if (var1 > 1 && var2 > 1 && var4 != null) {
         this.field_15 = new DirectColorModel(32, 16711680, 65280, 255);
         int var5 = this.field_10 * this.field_11;

         for(int var6 = 0; var6 < var5; ++var6) {
            this.field_16[var6] = 0;
         }

         this.field_19 = var4.createImage(this);
         this.method_28();
         var4.prepareImage(this.field_19, var4);
         this.method_28();
         var4.prepareImage(this.field_19, var4);
         this.method_28();
         var4.prepareImage(this.field_19, var4);
      }

   }

   // $FF: renamed from: jh (int, int) void
   public synchronized void method_27(int var1, int var2) {
      if (this.field_10 > this.field_13) {
         this.field_10 = this.field_13;
      }

      if (this.field_11 > this.field_14) {
         this.field_11 = this.field_14;
      }

      this.field_10 = var1;
      this.field_11 = var2;
      this.field_12 = var1 * var2;
   }

   public synchronized void addConsumer(ImageConsumer var1) {
      this.field_17 = var1;
      var1.setDimensions(this.field_10, this.field_11);
      var1.setProperties((Hashtable)null);
      var1.setColorModel(this.field_15);
      var1.setHints(14);
   }

   public synchronized boolean isConsumer(ImageConsumer var1) {
      return this.field_17 == var1;
   }

   public synchronized void removeConsumer(ImageConsumer var1) {
      if (this.field_17 == var1) {
         this.field_17 = null;
      }

   }

   public void startProduction(ImageConsumer var1) {
      this.addConsumer(var1);
   }

   public void requestTopDownLeftRightResend(ImageConsumer var1) {
      System.out.println("TDLR");
   }

   // $FF: renamed from: ah () void
   public synchronized void method_28() {
      if (this.field_17 != null) {
         this.field_17.setPixels(0, 0, this.field_10, this.field_11, this.field_15, this.field_16, 0, this.field_10);
         this.field_17.imageComplete(2);
      }
   }

   // $FF: renamed from: zg (int, int, int, int) void
   public void method_29(int var1, int var2, int var3, int var4) {
      if (var1 < 0) {
         var1 = 0;
      }

      if (var2 < 0) {
         var2 = 0;
      }

      if (var3 > this.field_10) {
         var3 = this.field_10;
      }

      if (var4 > this.field_11) {
         var4 = this.field_11;
      }

      this.field_32 = var1;
      this.field_30 = var2;
      this.field_33 = var3;
      this.field_31 = var4;
   }

   // $FF: renamed from: lf () void
   public void method_30() {
      this.field_32 = 0;
      this.field_30 = 0;
      this.field_33 = this.field_10;
      this.field_31 = this.field_11;
   }

   // $FF: renamed from: ag (java.awt.Graphics, int, int) void
   public void method_31(Graphics var1, int var2, int var3) {
      this.method_28();
      var1.drawImage(this.field_19, var2, var3, this);
   }

   // $FF: renamed from: xf () void
   public void method_32() {
      int var1 = this.field_10 * this.field_11;
      int var2;
      if (!this.field_34) {
         for(var2 = 0; var2 < var1; ++var2) {
            this.field_16[var2] = 0;
         }

      } else {
         var2 = 0;

         for(int var3 = -this.field_11; var3 < 0; var3 += 2) {
            for(int var4 = -this.field_10; var4 < 0; ++var4) {
               this.field_16[var2++] = 0;
            }

            var2 += this.field_10;
         }

      }
   }

   // $FF: renamed from: kh (int, int, int, int, int) void
   public void method_33(int var1, int var2, int var3, int var4, int var5) {
      int var6 = 256 - var5;
      int var7 = (var4 >> 16 & 255) * var5;
      int var8 = (var4 >> 8 & 255) * var5;
      int var9 = (var4 & 255) * var5;
      int var13 = var2 - var3;
      if (var13 < 0) {
         var13 = 0;
      }

      int var14 = var2 + var3;
      if (var14 >= this.field_11) {
         var14 = this.field_11 - 1;
      }

      byte var15 = 1;
      if (this.field_34) {
         var15 = 2;
         if ((var13 & 1) != 0) {
            ++var13;
         }
      }

      for(int var16 = var13; var16 <= var14; var16 += var15) {
         int var17 = var16 - var2;
         int var18 = (int)Math.sqrt((double)(var3 * var3 - var17 * var17));
         int var19 = var1 - var18;
         if (var19 < 0) {
            var19 = 0;
         }

         int var20 = var1 + var18;
         if (var20 >= this.field_10) {
            var20 = this.field_10 - 1;
         }

         int var21 = var19 + var16 * this.field_10;

         for(int var22 = var19; var22 <= var20; ++var22) {
            int var10 = (this.field_16[var21] >> 16 & 255) * var6;
            int var11 = (this.field_16[var21] >> 8 & 255) * var6;
            int var12 = (this.field_16[var21] & 255) * var6;
            int var23 = (var7 + var10 >> 8 << 16) + (var8 + var11 >> 8 << 8) + (var9 + var12 >> 8);
            this.field_16[var21++] = var23;
         }
      }

   }

   // $FF: renamed from: ch (int, int, int, int, int, int) void
   public void method_34(int var1, int var2, int var3, int var4, int var5, int var6) {
      if (var1 < this.field_32) {
         var3 -= this.field_32 - var1;
         var1 = this.field_32;
      }

      if (var2 < this.field_30) {
         var4 -= this.field_30 - var2;
         var2 = this.field_30;
      }

      if (var1 + var3 > this.field_33) {
         var3 = this.field_33 - var1;
      }

      if (var2 + var4 > this.field_31) {
         var4 = this.field_31 - var2;
      }

      int var7 = 256 - var6;
      int var8 = (var5 >> 16 & 255) * var6;
      int var9 = (var5 >> 8 & 255) * var6;
      int var10 = (var5 & 255) * var6;
      int var14 = this.field_10 - var3;
      byte var15 = 1;
      if (this.field_34) {
         var15 = 2;
         var14 += this.field_10;
         if ((var2 & 1) != 0) {
            ++var2;
            --var4;
         }
      }

      int var16 = var1 + var2 * this.field_10;

      for(int var17 = 0; var17 < var4; var17 += var15) {
         for(int var18 = -var3; var18 < 0; ++var18) {
            int var11 = (this.field_16[var16] >> 16 & 255) * var7;
            int var12 = (this.field_16[var16] >> 8 & 255) * var7;
            int var13 = (this.field_16[var16] & 255) * var7;
            int var19 = (var8 + var11 >> 8 << 16) + (var9 + var12 >> 8 << 8) + (var10 + var13 >> 8);
            this.field_16[var16++] = var19;
         }

         var16 += var14;
      }

   }

   // $FF: renamed from: fh (int, int, int, int, int, int) void
   public void method_35(int var1, int var2, int var3, int var4, int var5, int var6) {
      if (var1 < this.field_32) {
         var3 -= this.field_32 - var1;
         var1 = this.field_32;
      }

      if (var1 + var3 > this.field_33) {
         var3 = this.field_33 - var1;
      }

      int var7 = var6 >> 16 & 255;
      int var8 = var6 >> 8 & 255;
      int var9 = var6 & 255;
      int var10 = var5 >> 16 & 255;
      int var11 = var5 >> 8 & 255;
      int var12 = var5 & 255;
      int var13 = this.field_10 - var3;
      byte var14 = 1;
      if (this.field_34) {
         var14 = 2;
         var13 += this.field_10;
         if ((var2 & 1) != 0) {
            ++var2;
            --var4;
         }
      }

      int var15 = var1 + var2 * this.field_10;

      for(int var16 = 0; var16 < var4; var16 += var14) {
         if (var16 + var2 >= this.field_30 && var16 + var2 < this.field_31) {
            int var17 = ((var7 * var16 + var10 * (var4 - var16)) / var4 << 16) + ((var8 * var16 + var11 * (var4 - var16)) / var4 << 8) + (var9 * var16 + var12 * (var4 - var16)) / var4;

            for(int var18 = -var3; var18 < 0; ++var18) {
               this.field_16[var15++] = var17;
            }

            var15 += var13;
         } else {
            var15 += this.field_10;
         }
      }

   }

   // $FF: renamed from: ng (int, int, int, int, int) void
   public void method_36(int var1, int var2, int var3, int var4, int var5) {
      if (var1 < this.field_32) {
         var3 -= this.field_32 - var1;
         var1 = this.field_32;
      }

      if (var2 < this.field_30) {
         var4 -= this.field_30 - var2;
         var2 = this.field_30;
      }

      if (var1 + var3 > this.field_33) {
         var3 = this.field_33 - var1;
      }

      if (var2 + var4 > this.field_31) {
         var4 = this.field_31 - var2;
      }

      int var6 = this.field_10 - var3;
      byte var7 = 1;
      if (this.field_34) {
         var7 = 2;
         var6 += this.field_10;
         if ((var2 & 1) != 0) {
            ++var2;
            --var4;
         }
      }

      int var8 = var1 + var2 * this.field_10;

      for(int var9 = -var4; var9 < 0; var9 += var7) {
         for(int var10 = -var3; var10 < 0; ++var10) {
            this.field_16[var8++] = var5;
         }

         var8 += var6;
      }

   }

   // $FF: renamed from: yf (int, int, int, int, int) void
   public void method_37(int var1, int var2, int var3, int var4, int var5) {
      this.method_38(var1, var2, var3, var5);
      this.method_38(var1, var2 + var4 - 1, var3, var5);
      this.method_39(var1, var2, var4, var5);
      this.method_39(var1 + var3 - 1, var2, var4, var5);
   }

   // $FF: renamed from: og (int, int, int, int) void
   public void method_38(int var1, int var2, int var3, int var4) {
      if (var2 >= this.field_30 && var2 < this.field_31) {
         if (var1 < this.field_32) {
            var3 -= this.field_32 - var1;
            var1 = this.field_32;
         }

         if (var1 + var3 > this.field_33) {
            var3 = this.field_33 - var1;
         }

         int var5 = var1 + var2 * this.field_10;

         for(int var6 = 0; var6 < var3; ++var6) {
            this.field_16[var5 + var6] = var4;
         }

      }
   }

   // $FF: renamed from: hh (int, int, int, int) void
   public void method_39(int var1, int var2, int var3, int var4) {
      if (var1 >= this.field_32 && var1 < this.field_33) {
         if (var2 < this.field_30) {
            var3 -= this.field_30 - var2;
            var2 = this.field_30;
         }

         if (var2 + var3 > this.field_33) {
            var3 = this.field_31 - var2;
         }

         int var5 = var1 + var2 * this.field_10;

         for(int var6 = 0; var6 < var3; ++var6) {
            this.field_16[var5 + var6 * this.field_10] = var4;
         }

      }
   }

   // $FF: renamed from: ug (int, int, int) void
   public void method_40(int var1, int var2, int var3) {
      if (var1 >= this.field_32 && var2 >= this.field_30 && var1 < this.field_33 && var2 < this.field_31) {
         this.field_16[var1 + var2 * this.field_10] = var3;
      }
   }

   // $FF: renamed from: fg () void
   public void method_41() {
      int var3 = this.field_10 * this.field_11;

      for(int var2 = 0; var2 < var3; ++var2) {
         int var1 = this.field_16[var2] & 16777215;
         this.field_16[var2] = (var1 >>> 1 & 8355711) + (var1 >>> 2 & 4144959) + (var1 >>> 3 & 2039583) + (var1 >>> 4 & 986895);
      }

   }

   // $FF: renamed from: lg (int, int, int, int, int, int) void
   public void method_42(int var1, int var2, int var3, int var4, int var5, int var6) {
      for(int var7 = var3; var7 < var3 + var5; ++var7) {
         for(int var8 = var4; var8 < var4 + var6; ++var8) {
            int var9 = 0;
            int var10 = 0;
            int var11 = 0;
            int var12 = 0;

            for(int var13 = var7 - var1; var13 <= var7 + var1; ++var13) {
               if (var13 >= 0 && var13 < this.field_10) {
                  for(int var14 = var8 - var2; var14 <= var8 + var2; ++var14) {
                     if (var14 >= 0 && var14 < this.field_11) {
                        int var15 = this.field_16[var13 + this.field_10 * var14];
                        var9 += var15 >> 16 & 255;
                        var10 += var15 >> 8 & 255;
                        var11 += var15 & 255;
                        ++var12;
                     }
                  }
               }
            }

            this.field_16[var7 + this.field_10 * var8] = (var9 / var12 << 16) + (var10 / var12 << 8) + var11 / var12;
         }
      }

   }

   // $FF: renamed from: mg (int, int, int) int
   public static int method_43(int var0, int var1, int var2) {
      return (var0 << 16) + (var1 << 8) + var2;
   }

   // $FF: renamed from: sg () void
   public void method_44() {
      for(int var1 = 0; var1 < this.field_20.length; ++var1) {
         this.field_20[var1] = null;
         this.field_23[var1] = 0;
         this.field_24[var1] = 0;
         this.field_21[var1] = null;
         this.field_22[var1] = null;
      }

   }

   // $FF: renamed from: nf (int, byte[], byte[], int) void
   public void method_45(int var1, byte[] var2, byte[] var3, int var4) {
      int var5 = class_0.method_5(var2, 0);
      int var6 = class_0.method_5(var3, var5);
      var5 += 2;
      int var7 = class_0.method_5(var3, var5);
      var5 += 2;
      int var8 = var3[var5++] & 255;
      int[] var9 = new int[var8];
      var9[0] = 16711935;

      for(int var10 = 0; var10 < var8 - 1; ++var10) {
         var9[var10 + 1] = ((var3[var5] & 255) << 16) + ((var3[var5 + 1] & 255) << 8) + (var3[var5 + 2] & 255);
         var5 += 3;
      }

      int var11 = 2;

      for(int var12 = var1; var12 < var1 + var4; ++var12) {
         this.field_25[var12] = var3[var5++] & 255;
         this.field_26[var12] = var3[var5++] & 255;
         this.field_23[var12] = class_0.method_5(var3, var5);
         var5 += 2;
         this.field_24[var12] = class_0.method_5(var3, var5);
         var5 += 2;
         int var13 = var3[var5++] & 255;
         int var14 = this.field_23[var12] * this.field_24[var12];
         this.field_21[var12] = new byte[var14];
         this.field_22[var12] = var9;
         this.field_27[var12] = var6;
         this.field_28[var12] = var7;
         this.field_20[var12] = null;
         this.field_29[var12] = false;
         if (this.field_25[var12] != 0 || this.field_26[var12] != 0) {
            this.field_29[var12] = true;
         }

         int var15;
         if (var13 == 0) {
            for(var15 = 0; var15 < var14; ++var15) {
               this.field_21[var12][var15] = var2[var11++];
               if (this.field_21[var12][var15] == 0) {
                  this.field_29[var12] = true;
               }
            }
         } else if (var13 == 1) {
            for(var15 = 0; var15 < this.field_23[var12]; ++var15) {
               for(int var16 = 0; var16 < this.field_24[var12]; ++var16) {
                  this.field_21[var12][var15 + var16 * this.field_23[var12]] = var2[var11++];
                  if (this.field_21[var12][var15 + var16 * this.field_23[var12]] == 0) {
                     this.field_29[var12] = true;
                  }
               }
            }
         }
      }

   }

   // $FF: renamed from: bh (byte[], int, int, boolean, int, int, boolean) void
   public void method_46(byte[] var1, int var2, int var3, boolean var4, int var5, int var6, boolean var7) {
      int var8 = (var1[13 + var2] & 255) * 256 + (var1[12 + var2] & 255);
      int var9 = (var1[15 + var2] & 255) * 256 + (var1[14 + var2] & 255);
      int var10 = -1;
      int[] var11 = new int[256];

      for(int var12 = 0; var12 < 256; ++var12) {
         var11[var12] = -16777216 + ((var1[var2 + 20 + var12 * 3] & 255) << 16) + ((var1[var2 + 19 + var12 * 3] & 255) << 8) + (var1[var2 + 18 + var12 * 3] & 255);
         if (var11[var12] == -65281) {
            var10 = var12;
         }
      }

      if (var10 == -1) {
         var4 = false;
      }

      if (var7 && var4) {
         var11[var10] = var11[0];
      }

      int var13 = var8 / var5;
      int var14 = var9 / var6;
      int[] var15 = new int[var13 * var14];

      for(int var16 = 0; var16 < var6; ++var16) {
         for(int var17 = 0; var17 < var5; ++var17) {
            int var18 = 0;

            for(int var19 = var14 * var16; var19 < var14 * (var16 + 1); ++var19) {
               for(int var20 = var13 * var17; var20 < var13 * (var17 + 1); ++var20) {
                  if (var7) {
                     var15[var18++] = var1[var2 + 786 + var20 + (var9 - var19 - 1) * var8] & 255;
                  } else {
                     var15[var18++] = var11[var1[var2 + 786 + var20 + (var9 - var19 - 1) * var8] & 255];
                  }
               }
            }

            if (var7) {
               this.method_47(var15, var13, var14, var3++, var4, var11, var10);
            } else {
               this.method_47(var15, var13, var14, var3++, var4, (int[])null, -65281);
            }
         }
      }

   }

   // $FF: renamed from: rf (int[], int, int, int, boolean, int[], int) void
   private void method_47(int[] var1, int var2, int var3, int var4, boolean var5, int[] var6, int var7) {
      int var8 = 0;
      int var9 = 0;
      int var10 = var2;
      int var11 = var3;
      int var12;
      int var13;
      int var14;
      int var15;
      if (var5) {
         label145:
         for(var12 = 0; var12 < var3; ++var12) {
            for(var13 = 0; var13 < var2; ++var13) {
               var14 = var1[var13 + var12 * var2];
               if (var14 != var7) {
                  var9 = var12;
                  break label145;
               }
            }
         }

         label131:
         for(var13 = 0; var13 < var2; ++var13) {
            for(var14 = 0; var14 < var3; ++var14) {
               var15 = var1[var13 + var14 * var2];
               if (var15 != var7) {
                  var8 = var13;
                  break label131;
               }
            }
         }

         int var16;
         label117:
         for(var14 = var3 - 1; var14 >= 0; --var14) {
            for(var15 = 0; var15 < var2; ++var15) {
               var16 = var1[var15 + var14 * var2];
               if (var16 != var7) {
                  var11 = var14 + 1;
                  break label117;
               }
            }
         }

         label104:
         for(var15 = var2 - 1; var15 >= 0; --var15) {
            for(var16 = 0; var16 < var3; ++var16) {
               int var17 = var1[var15 + var16 * var2];
               if (var17 != var7) {
                  var10 = var15 + 1;
                  break label104;
               }
            }
         }
      }

      this.field_23[var4] = var10 - var8;
      this.field_24[var4] = var11 - var9;
      this.field_29[var4] = var5;
      this.field_25[var4] = var8;
      this.field_26[var4] = var9;
      this.field_27[var4] = var2;
      this.field_28[var4] = var3;
      if (var6 == null) {
         this.field_20[var4] = new int[(var10 - var8) * (var11 - var9)];
         var12 = 0;

         for(var13 = var9; var13 < var11; ++var13) {
            for(var14 = var8; var14 < var10; ++var14) {
               var15 = var1[var14 + var13 * var2];
               if (var5) {
                  if (var15 == var7) {
                     var15 = 0;
                  }

                  if (var15 == -16777216) {
                     var15 = -16711423;
                  }
               }

               this.field_20[var4][var12++] = var15 & 16777215;
            }
         }

      } else {
         this.field_21[var4] = new byte[(var10 - var8) * (var11 - var9)];
         this.field_22[var4] = var6;
         var12 = 0;

         for(var13 = var9; var13 < var11; ++var13) {
            for(var14 = var8; var14 < var10; ++var14) {
               var15 = var1[var14 + var13 * var2];
               if (var5) {
                  if (var15 == var7) {
                     var15 = 0;
                  } else if (var15 == 0) {
                     var15 = var7;
                  }
               }

               this.field_21[var4][var12++] = (byte)var15;
            }
         }

      }
   }

   // $FF: renamed from: tg (int) void
   public void method_48(int var1) {
      int var2 = this.field_23[var1] * this.field_24[var1];
      int[] var3 = this.field_20[var1];
      int[] var4 = new int['\u8000'];

      for(int var5 = 0; var5 < var2; ++var5) {
         int var6 = var3[var5];
         ++var4[((var6 & 16252928) >> 9) + ((var6 & '\uf800') >> 6) + ((var6 & 248) >> 3)];
      }

      int[] var24 = new int[256];
      var24[0] = 16711935;
      int[] var7 = new int[256];

      int var10;
      int var11;
      for(int var8 = 0; var8 < 32768; ++var8) {
         int var9 = var4[var8];
         if (var9 > var7[255]) {
            for(var10 = 1; var10 < 256; ++var10) {
               if (var9 > var7[var10]) {
                  for(var11 = 255; var11 > var10; --var11) {
                     var24[var11] = var24[var11 - 1];
                     var7[var11] = var7[var11 - 1];
                  }

                  var24[var10] = ((var8 & 31744) << 9) + ((var8 & 992) << 6) + ((var8 & 31) << 3) + 263172;
                  var7[var10] = var9;
                  break;
               }
            }
         }

         var4[var8] = -1;
      }

      byte[] var25 = new byte[var2];

      for(var10 = 0; var10 < var2; ++var10) {
         var11 = var3[var10];
         int var12 = ((var11 & 16252928) >> 9) + ((var11 & '\uf800') >> 6) + ((var11 & 248) >> 3);
         int var13 = var4[var12];
         if (var13 == -1) {
            int var14 = 999999999;
            int var15 = var11 >> 16 & 255;
            int var16 = var11 >> 8 & 255;
            int var17 = var11 & 255;

            for(int var18 = 0; var18 < 256; ++var18) {
               int var19 = var24[var18];
               int var20 = var19 >> 16 & 255;
               int var21 = var19 >> 8 & 255;
               int var22 = var19 & 255;
               int var23 = (var15 - var20) * (var15 - var20) + (var16 - var21) * (var16 - var21) + (var17 - var22) * (var17 - var22);
               if (var23 < var14) {
                  var14 = var23;
                  var13 = var18;
               }
            }

            var4[var12] = var13;
         }

         var25[var10] = (byte)var13;
      }

      this.field_21[var1] = var25;
      this.field_22[var1] = var24;
      this.field_20[var1] = null;
   }

   // $FF: renamed from: qf (int) void
   public void method_49(int var1) {
      if (this.field_21[var1] != null) {
         int var2 = this.field_23[var1] * this.field_24[var1];
         byte[] var3 = this.field_21[var1];
         int[] var4 = this.field_22[var1];
         int[] var5 = new int[var2];

         for(int var6 = 0; var6 < var2; ++var6) {
            int var7 = var4[var3[var6] & 255];
            if (var7 == 0) {
               var7 = 1;
            } else if (var7 == 16711935) {
               var7 = 0;
            }

            var5[var6] = var7;
         }

         this.field_20[var1] = var5;
         this.field_21[var1] = null;
         this.field_22[var1] = null;
      }
   }

   // $FF: renamed from: gg (int, int, int, int, int) void
   public void method_50(int var1, int var2, int var3, int var4, int var5) {
      this.field_23[var1] = var4;
      this.field_24[var1] = var5;
      this.field_29[var1] = false;
      this.field_25[var1] = 0;
      this.field_26[var1] = 0;
      this.field_27[var1] = var4;
      this.field_28[var1] = var5;
      int var6 = var4 * var5;
      int var7 = 0;
      this.field_20[var1] = new int[var6];

      for(int var8 = var2; var8 < var2 + var4; ++var8) {
         for(int var9 = var3; var9 < var3 + var5; ++var9) {
            this.field_20[var1][var7++] = this.field_16[var8 + var9 * this.field_10];
         }
      }

   }

   // $FF: renamed from: jg (int, int, int, int, int) void
   public void method_51(int var1, int var2, int var3, int var4, int var5) {
      this.field_23[var1] = var4;
      this.field_24[var1] = var5;
      this.field_29[var1] = false;
      this.field_25[var1] = 0;
      this.field_26[var1] = 0;
      this.field_27[var1] = var4;
      this.field_28[var1] = var5;
      int var6 = var4 * var5;
      int var7 = 0;
      this.field_20[var1] = new int[var6];

      for(int var8 = var3; var8 < var3 + var5; ++var8) {
         for(int var9 = var2; var9 < var2 + var4; ++var9) {
            this.field_20[var1][var7++] = this.field_16[var9 + var8 * this.field_10];
         }
      }

   }

   // $FF: renamed from: mf (int, int, int) void
   public void method_52(int var1, int var2, int var3) {
      if (this.field_29[var3]) {
         var1 += this.field_25[var3];
         var2 += this.field_26[var3];
      }

      int var4 = var1 + var2 * this.field_10;
      int var5 = 0;
      int var6 = this.field_24[var3];
      int var7 = this.field_23[var3];
      int var8 = this.field_10 - var7;
      int var9 = 0;
      int var10;
      if (var2 < this.field_30) {
         var10 = this.field_30 - var2;
         var6 -= var10;
         var2 = this.field_30;
         var5 += var10 * var7;
         var4 += var10 * this.field_10;
      }

      if (var2 + var6 >= this.field_31) {
         var6 -= var2 + var6 - this.field_31 + 1;
      }

      if (var1 < this.field_32) {
         var10 = this.field_32 - var1;
         var7 -= var10;
         var1 = this.field_32;
         var5 += var10;
         var4 += var10;
         var9 += var10;
         var8 += var10;
      }

      if (var1 + var7 >= this.field_33) {
         var10 = var1 + var7 - this.field_33 + 1;
         var7 -= var10;
         var9 += var10;
         var8 += var10;
      }

      if (var7 > 0 && var6 > 0) {
         byte var11 = 1;
         if (this.field_34) {
            var11 = 2;
            var8 += this.field_10;
            var9 += this.field_23[var3];
            if ((var2 & 1) != 0) {
               var4 += this.field_10;
               --var6;
            }
         }

         if (this.field_20[var3] == null) {
            this.method_58(this.field_16, this.field_21[var3], this.field_22[var3], var5, var4, var7, var6, var8, var9, var11);
         } else {
            this.method_57(this.field_16, this.field_20[var3], 0, var5, var4, var7, var6, var8, var9, var11);
         }
      }
   }

   // $FF: renamed from: qg (int, int, int, int, int) void
   public void method_53(int var1, int var2, int var3, int var4, int var5) {
      try {
         int var6 = this.field_23[var5];
         int var7 = this.field_24[var5];
         int var8 = 0;
         int var9 = 0;
         int var10 = (var6 << 16) / var3;
         int var11 = (var7 << 16) / var4;
         int var12;
         int var13;
         if (this.field_29[var5]) {
            var12 = this.field_27[var5];
            var13 = this.field_28[var5];
            var10 = (var12 << 16) / var3;
            var11 = (var13 << 16) / var4;
            var1 += (this.field_25[var5] * var3 + var12 - 1) / var12;
            var2 += (this.field_26[var5] * var4 + var13 - 1) / var13;
            if (this.field_25[var5] * var3 % var12 != 0) {
               var8 = (var12 - this.field_25[var5] * var3 % var12 << 16) / var3;
            }

            if (this.field_26[var5] * var4 % var13 != 0) {
               var9 = (var13 - this.field_26[var5] * var4 % var13 << 16) / var4;
            }

            var3 = var3 * (this.field_23[var5] - (var8 >> 16)) / var12;
            var4 = var4 * (this.field_24[var5] - (var9 >> 16)) / var13;
         }

         var12 = var1 + var2 * this.field_10;
         var13 = this.field_10 - var3;
         int var14;
         if (var2 < this.field_30) {
            var14 = this.field_30 - var2;
            var4 -= var14;
            var2 = 0;
            var12 += var14 * this.field_10;
            var9 += var11 * var14;
         }

         if (var2 + var4 >= this.field_31) {
            var4 -= var2 + var4 - this.field_31 + 1;
         }

         if (var1 < this.field_32) {
            var14 = this.field_32 - var1;
            var3 -= var14;
            var1 = 0;
            var12 += var14;
            var8 += var10 * var14;
            var13 += var14;
         }

         if (var1 + var3 >= this.field_33) {
            var14 = var1 + var3 - this.field_33 + 1;
            var3 -= var14;
            var13 += var14;
         }

         byte var16 = 1;
         if (this.field_34) {
            var16 = 2;
            var13 += this.field_10;
            var11 += var11;
            if ((var2 & 1) != 0) {
               var12 += this.field_10;
               --var4;
            }
         }

         this.method_59(this.field_16, this.field_20[var5], 0, var8, var9, var12, var13, var3, var4, var10, var11, var6, var16);
      } catch (Exception var15) {
         System.out.println("error in sprite clipping routine");
      }
   }

   // $FF: renamed from: dg (int, int, int, int) void
   public void method_54(int var1, int var2, int var3, int var4) {
      if (this.field_29[var3]) {
         var1 += this.field_25[var3];
         var2 += this.field_26[var3];
      }

      int var5 = var1 + var2 * this.field_10;
      int var6 = 0;
      int var7 = this.field_24[var3];
      int var8 = this.field_23[var3];
      int var9 = this.field_10 - var8;
      int var10 = 0;
      int var11;
      if (var2 < this.field_30) {
         var11 = this.field_30 - var2;
         var7 -= var11;
         var2 = this.field_30;
         var6 += var11 * var8;
         var5 += var11 * this.field_10;
      }

      if (var2 + var7 >= this.field_31) {
         var7 -= var2 + var7 - this.field_31 + 1;
      }

      if (var1 < this.field_32) {
         var11 = this.field_32 - var1;
         var8 -= var11;
         var1 = this.field_32;
         var6 += var11;
         var5 += var11;
         var10 += var11;
         var9 += var11;
      }

      if (var1 + var8 >= this.field_33) {
         var11 = var1 + var8 - this.field_33 + 1;
         var8 -= var11;
         var10 += var11;
         var9 += var11;
      }

      if (var8 > 0 && var7 > 0) {
         byte var12 = 1;
         if (this.field_34) {
            var12 = 2;
            var9 += this.field_10;
            var10 += this.field_23[var3];
            if ((var2 & 1) != 0) {
               var5 += this.field_10;
               --var7;
            }
         }

         if (this.field_20[var3] == null) {
            this.method_61(this.field_16, this.field_21[var3], this.field_22[var3], var6, var5, var8, var7, var9, var10, var12, var4);
         } else {
            this.method_60(this.field_16, this.field_20[var3], 0, var6, var5, var8, var7, var9, var10, var12, var4);
         }
      }
   }

   // $FF: renamed from: wf (int, int, int, int, int, int) void
   public void method_55(int var1, int var2, int var3, int var4, int var5, int var6) {
      try {
         int var7 = this.field_23[var5];
         int var8 = this.field_24[var5];
         int var9 = 0;
         int var10 = 0;
         int var11 = (var7 << 16) / var3;
         int var12 = (var8 << 16) / var4;
         int var13;
         int var14;
         if (this.field_29[var5]) {
            var13 = this.field_27[var5];
            var14 = this.field_28[var5];
            var11 = (var13 << 16) / var3;
            var12 = (var14 << 16) / var4;
            var1 += (this.field_25[var5] * var3 + var13 - 1) / var13;
            var2 += (this.field_26[var5] * var4 + var14 - 1) / var14;
            if (this.field_25[var5] * var3 % var13 != 0) {
               var9 = (var13 - this.field_25[var5] * var3 % var13 << 16) / var3;
            }

            if (this.field_26[var5] * var4 % var14 != 0) {
               var10 = (var14 - this.field_26[var5] * var4 % var14 << 16) / var4;
            }

            var3 = var3 * (this.field_23[var5] - (var9 >> 16)) / var13;
            var4 = var4 * (this.field_24[var5] - (var10 >> 16)) / var14;
         }

         var13 = var1 + var2 * this.field_10;
         var14 = this.field_10 - var3;
         int var15;
         if (var2 < this.field_30) {
            var15 = this.field_30 - var2;
            var4 -= var15;
            var2 = 0;
            var13 += var15 * this.field_10;
            var10 += var12 * var15;
         }

         if (var2 + var4 >= this.field_31) {
            var4 -= var2 + var4 - this.field_31 + 1;
         }

         if (var1 < this.field_32) {
            var15 = this.field_32 - var1;
            var3 -= var15;
            var1 = 0;
            var13 += var15;
            var9 += var11 * var15;
            var14 += var15;
         }

         if (var1 + var3 >= this.field_33) {
            var15 = var1 + var3 - this.field_33 + 1;
            var3 -= var15;
            var14 += var15;
         }

         byte var17 = 1;
         if (this.field_34) {
            var17 = 2;
            var14 += this.field_10;
            var12 += var12;
            if ((var2 & 1) != 0) {
               var13 += this.field_10;
               --var4;
            }
         }

         this.method_62(this.field_16, this.field_20[var5], 0, var9, var10, var13, var14, var3, var4, var11, var12, var7, var17, var6);
      } catch (Exception var16) {
         System.out.println("error in sprite clipping routine");
      }
   }

   // $FF: renamed from: eh (int, int, int, int, int, int) void
   public void method_56(int var1, int var2, int var3, int var4, int var5, int var6) {
      try {
         int var7 = this.field_23[var5];
         int var8 = this.field_24[var5];
         int var9 = 0;
         int var10 = 0;
         int var11 = (var7 << 16) / var3;
         int var12 = (var8 << 16) / var4;
         int var13;
         int var14;
         if (this.field_29[var5]) {
            var13 = this.field_27[var5];
            var14 = this.field_28[var5];
            var11 = (var13 << 16) / var3;
            var12 = (var14 << 16) / var4;
            var1 += (this.field_25[var5] * var3 + var13 - 1) / var13;
            var2 += (this.field_26[var5] * var4 + var14 - 1) / var14;
            if (this.field_25[var5] * var3 % var13 != 0) {
               var9 = (var13 - this.field_25[var5] * var3 % var13 << 16) / var3;
            }

            if (this.field_26[var5] * var4 % var14 != 0) {
               var10 = (var14 - this.field_26[var5] * var4 % var14 << 16) / var4;
            }

            var3 = var3 * (this.field_23[var5] - (var9 >> 16)) / var13;
            var4 = var4 * (this.field_24[var5] - (var10 >> 16)) / var14;
         }

         var13 = var1 + var2 * this.field_10;
         var14 = this.field_10 - var3;
         int var15;
         if (var2 < this.field_30) {
            var15 = this.field_30 - var2;
            var4 -= var15;
            var2 = 0;
            var13 += var15 * this.field_10;
            var10 += var12 * var15;
         }

         if (var2 + var4 >= this.field_31) {
            var4 -= var2 + var4 - this.field_31 + 1;
         }

         if (var1 < this.field_32) {
            var15 = this.field_32 - var1;
            var3 -= var15;
            var1 = 0;
            var13 += var15;
            var9 += var11 * var15;
            var14 += var15;
         }

         if (var1 + var3 >= this.field_33) {
            var15 = var1 + var3 - this.field_33 + 1;
            var3 -= var15;
            var14 += var15;
         }

         byte var17 = 1;
         if (this.field_34) {
            var17 = 2;
            var14 += this.field_10;
            var12 += var12;
            if ((var2 & 1) != 0) {
               var13 += this.field_10;
               --var4;
            }
         }

         this.method_63(this.field_16, this.field_20[var5], 0, var9, var10, var13, var14, var3, var4, var11, var12, var7, var17, var6);
      } catch (Exception var16) {
         System.out.println("error in sprite clipping routine");
      }
   }

   // $FF: renamed from: ig (int[], int[], int, int, int, int, int, int, int, int) void
   private void method_57(int[] var1, int[] var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10) {
      int var11 = -(var6 >> 2);
      var6 = -(var6 & 3);

      for(int var12 = -var7; var12 < 0; var12 += var10) {
         for(int var13 = var11; var13 < 0; ++var13) {
            var3 = var2[var4++];
            if (var3 != 0) {
               var1[var5++] = var3;
            } else {
               ++var5;
            }

            var3 = var2[var4++];
            if (var3 != 0) {
               var1[var5++] = var3;
            } else {
               ++var5;
            }

            var3 = var2[var4++];
            if (var3 != 0) {
               var1[var5++] = var3;
            } else {
               ++var5;
            }

            var3 = var2[var4++];
            if (var3 != 0) {
               var1[var5++] = var3;
            } else {
               ++var5;
            }
         }

         for(int var14 = var6; var14 < 0; ++var14) {
            var3 = var2[var4++];
            if (var3 != 0) {
               var1[var5++] = var3;
            } else {
               ++var5;
            }
         }

         var5 += var8;
         var4 += var9;
      }

   }

   // $FF: renamed from: vf (int[], byte[], int[], int, int, int, int, int, int, int) void
   private void method_58(int[] var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10) {
      int var11 = -(var6 >> 2);
      var6 = -(var6 & 3);

      for(int var12 = -var7; var12 < 0; var12 += var10) {
         for(int var13 = var11; var13 < 0; ++var13) {
            byte var14 = var2[var4++];
            if (var14 != 0) {
               var1[var5++] = var3[var14 & 255];
            } else {
               ++var5;
            }

            var14 = var2[var4++];
            if (var14 != 0) {
               var1[var5++] = var3[var14 & 255];
            } else {
               ++var5;
            }

            var14 = var2[var4++];
            if (var14 != 0) {
               var1[var5++] = var3[var14 & 255];
            } else {
               ++var5;
            }

            var14 = var2[var4++];
            if (var14 != 0) {
               var1[var5++] = var3[var14 & 255];
            } else {
               ++var5;
            }
         }

         for(int var16 = var6; var16 < 0; ++var16) {
            byte var15 = var2[var4++];
            if (var15 != 0) {
               var1[var5++] = var3[var15 & 255];
            } else {
               ++var5;
            }
         }

         var5 += var8;
         var4 += var9;
      }

   }

   // $FF: renamed from: zf (int[], int[], int, int, int, int, int, int, int, int, int, int, int) void
   private void method_59(int[] var1, int[] var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, int var11, int var12, int var13) {
      try {
         int var14 = var4;

         for(int var15 = -var9; var15 < 0; var15 += var13) {
            int var16 = (var5 >> 16) * var12;

            for(int var17 = -var8; var17 < 0; ++var17) {
               var3 = var2[(var4 >> 16) + var16];
               if (var3 != 0) {
                  var1[var6++] = var3;
               } else {
                  ++var6;
               }

               var4 += var10;
            }

            var5 += var11;
            var4 = var14;
            var6 += var7;
         }

      } catch (Exception var18) {
         System.out.println("error in plot_scale");
      }
   }

   // $FF: renamed from: pf (int[], int[], int, int, int, int, int, int, int, int, int) void
   private void method_60(int[] var1, int[] var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, int var11) {
      int var12 = 256 - var11;

      for(int var13 = -var7; var13 < 0; var13 += var10) {
         for(int var14 = -var6; var14 < 0; ++var14) {
            var3 = var2[var4++];
            if (var3 != 0) {
               int var15 = var1[var5];
               var1[var5++] = ((var3 & 16711935) * var11 + (var15 & 16711935) * var12 & -16711936) + ((var3 & '\uff00') * var11 + (var15 & '\uff00') * var12 & 16711680) >> 8;
            } else {
               ++var5;
            }
         }

         var5 += var8;
         var4 += var9;
      }

   }

   // $FF: renamed from: rg (int[], byte[], int[], int, int, int, int, int, int, int, int) void
   private void method_61(int[] var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, int var11) {
      int var12 = 256 - var11;

      for(int var13 = -var7; var13 < 0; var13 += var10) {
         for(int var14 = -var6; var14 < 0; ++var14) {
            byte var15 = var2[var4++];
            if (var15 != 0) {
               int var17 = var3[var15 & 255];
               int var16 = var1[var5];
               var1[var5++] = ((var17 & 16711935) * var11 + (var16 & 16711935) * var12 & -16711936) + ((var17 & '\uff00') * var11 + (var16 & '\uff00') * var12 & 16711680) >> 8;
            } else {
               ++var5;
            }
         }

         var5 += var8;
         var4 += var9;
      }

   }

   // $FF: renamed from: tf (int[], int[], int, int, int, int, int, int, int, int, int, int, int, int) void
   private void method_62(int[] var1, int[] var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, int var11, int var12, int var13, int var14) {
      int var15 = 256 - var14;

      try {
         int var16 = var4;

         for(int var17 = -var9; var17 < 0; var17 += var13) {
            int var18 = (var5 >> 16) * var12;

            for(int var19 = -var8; var19 < 0; ++var19) {
               var3 = var2[(var4 >> 16) + var18];
               if (var3 != 0) {
                  int var20 = var1[var6];
                  var1[var6++] = ((var3 & 16711935) * var14 + (var20 & 16711935) * var15 & -16711936) + ((var3 & '\uff00') * var14 + (var20 & '\uff00') * var15 & 16711680) >> 8;
               } else {
                  ++var6;
               }

               var4 += var10;
            }

            var5 += var11;
            var4 = var16;
            var6 += var7;
         }

      } catch (Exception var21) {
         System.out.println("error in tran_scale");
      }
   }

   // $FF: renamed from: uf (int[], int[], int, int, int, int, int, int, int, int, int, int, int, int) void
   private void method_63(int[] var1, int[] var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, int var11, int var12, int var13, int var14) {
      int var15 = var14 >> 16 & 255;
      int var16 = var14 >> 8 & 255;
      int var17 = var14 & 255;

      try {
         int var18 = var4;

         for(int var19 = -var9; var19 < 0; var19 += var13) {
            int var20 = (var5 >> 16) * var12;

            for(int var21 = -var8; var21 < 0; ++var21) {
               var3 = var2[(var4 >> 16) + var20];
               if (var3 != 0) {
                  int var22 = var3 >> 16 & 255;
                  int var23 = var3 >> 8 & 255;
                  int var24 = var3 & 255;
                  if (var22 == var23 && var23 == var24) {
                     var1[var6++] = (var22 * var15 >> 8 << 16) + (var23 * var16 >> 8 << 8) + (var24 * var17 >> 8);
                  } else {
                     var1[var6++] = var3;
                  }
               } else {
                  ++var6;
               }

               var4 += var10;
            }

            var5 += var11;
            var4 = var18;
            var6 += var7;
         }

      } catch (Exception var25) {
         System.out.println("error in plot_scale");
      }
   }

   // $FF: renamed from: bg (int, int, int, int, int) void
   public void method_64(int var1, int var2, int var3, int var4, int var5) {
      int var6 = this.field_10;
      int var7 = this.field_11;
      int var8;
      if (this.field_39 == null) {
         this.field_39 = new int[512];

         for(var8 = 0; var8 < 256; ++var8) {
            this.field_39[var8] = (int)(Math.sin((double)var8 * 0.02454369D) * 32768.0D);
            this.field_39[var8 + 256] = (int)(Math.cos((double)var8 * 0.02454369D) * 32768.0D);
         }
      }

      var8 = -this.field_27[var3] / 2;
      int var9 = -this.field_28[var3] / 2;
      if (this.field_29[var3]) {
         var8 += this.field_25[var3];
         var9 += this.field_26[var3];
      }

      int var10 = var8 + this.field_23[var3];
      int var11 = var9 + this.field_24[var3];
      var4 &= 255;
      int var16 = this.field_39[var4] * var5;
      int var17 = this.field_39[var4 + 256] * var5;
      int var18 = var1 + (var9 * var16 + var8 * var17 >> 22);
      int var19 = var2 + (var9 * var17 - var8 * var16 >> 22);
      int var20 = var1 + (var9 * var16 + var10 * var17 >> 22);
      int var21 = var2 + (var9 * var17 - var10 * var16 >> 22);
      int var22 = var1 + (var11 * var16 + var10 * var17 >> 22);
      int var23 = var2 + (var11 * var17 - var10 * var16 >> 22);
      int var24 = var1 + (var11 * var16 + var8 * var17 >> 22);
      int var25 = var2 + (var11 * var17 - var8 * var16 >> 22);
      int var26 = var19;
      int var27 = var19;
      if (var21 < var19) {
         var26 = var21;
      } else if (var21 > var19) {
         var27 = var21;
      }

      if (var23 < var26) {
         var26 = var23;
      } else if (var23 > var27) {
         var27 = var23;
      }

      if (var25 < var26) {
         var26 = var25;
      } else if (var25 > var27) {
         var27 = var25;
      }

      if (var26 < this.field_30) {
         var26 = this.field_30;
      }

      if (var27 > this.field_31) {
         var27 = this.field_31;
      }

      if (this.field_40 == null || this.field_40.length != var7 + 1) {
         this.field_40 = new int[var7 + 1];
         this.field_41 = new int[var7 + 1];
         this.field_42 = new int[var7 + 1];
         this.field_43 = new int[var7 + 1];
         this.field_44 = new int[var7 + 1];
         this.field_45 = new int[var7 + 1];
      }

      for(int var28 = var26; var28 <= var27; ++var28) {
         this.field_40[var28] = 99999999;
         this.field_41[var28] = -99999999;
      }

      int var32 = 0;
      int var34 = 0;
      int var36 = 0;
      int var37 = this.field_23[var3];
      int var38 = this.field_24[var3];
      byte var52 = 0;
      byte var53 = 0;
      int var12 = var37 - 1;
      byte var13 = 0;
      var10 = var37 - 1;
      var11 = var38 - 1;
      byte var14 = 0;
      int var15 = var38 - 1;
      if (var25 != var19) {
         var32 = (var24 - var18 << 8) / (var25 - var19);
         var36 = (var15 - var53 << 8) / (var25 - var19);
      }

      int var29;
      int var30;
      int var31;
      int var35;
      if (var19 > var25) {
         var31 = var24 << 8;
         var35 = var15 << 8;
         var29 = var25;
         var30 = var19;
      } else {
         var31 = var18 << 8;
         var35 = var53 << 8;
         var29 = var19;
         var30 = var25;
      }

      if (var29 < 0) {
         var31 -= var32 * var29;
         var35 -= var36 * var29;
         var29 = 0;
      }

      if (var30 > var7 - 1) {
         var30 = var7 - 1;
      }

      for(int var39 = var29; var39 <= var30; ++var39) {
         this.field_40[var39] = this.field_41[var39] = var31;
         var31 += var32;
         this.field_42[var39] = this.field_43[var39] = 0;
         this.field_44[var39] = this.field_45[var39] = var35;
         var35 += var36;
      }

      if (var21 != var19) {
         var32 = (var20 - var18 << 8) / (var21 - var19);
         var34 = (var12 - var52 << 8) / (var21 - var19);
      }

      int var33;
      if (var19 > var21) {
         var31 = var20 << 8;
         var33 = var12 << 8;
         var29 = var21;
         var30 = var19;
      } else {
         var31 = var18 << 8;
         var33 = var52 << 8;
         var29 = var19;
         var30 = var21;
      }

      if (var29 < 0) {
         var31 -= var32 * var29;
         var33 -= var34 * var29;
         var29 = 0;
      }

      if (var30 > var7 - 1) {
         var30 = var7 - 1;
      }

      for(int var40 = var29; var40 <= var30; ++var40) {
         if (var31 < this.field_40[var40]) {
            this.field_40[var40] = var31;
            this.field_42[var40] = var33;
            this.field_44[var40] = 0;
         }

         if (var31 > this.field_41[var40]) {
            this.field_41[var40] = var31;
            this.field_43[var40] = var33;
            this.field_45[var40] = 0;
         }

         var31 += var32;
         var33 += var34;
      }

      if (var23 != var21) {
         var32 = (var22 - var20 << 8) / (var23 - var21);
         var36 = (var11 - var13 << 8) / (var23 - var21);
      }

      if (var21 > var23) {
         var31 = var22 << 8;
         var33 = var10 << 8;
         var35 = var11 << 8;
         var29 = var23;
         var30 = var21;
      } else {
         var31 = var20 << 8;
         var33 = var12 << 8;
         var35 = var13 << 8;
         var29 = var21;
         var30 = var23;
      }

      if (var29 < 0) {
         var31 -= var32 * var29;
         var35 -= var36 * var29;
         var29 = 0;
      }

      if (var30 > var7 - 1) {
         var30 = var7 - 1;
      }

      for(int var41 = var29; var41 <= var30; ++var41) {
         if (var31 < this.field_40[var41]) {
            this.field_40[var41] = var31;
            this.field_42[var41] = var33;
            this.field_44[var41] = var35;
         }

         if (var31 > this.field_41[var41]) {
            this.field_41[var41] = var31;
            this.field_43[var41] = var33;
            this.field_45[var41] = var35;
         }

         var31 += var32;
         var35 += var36;
      }

      if (var25 != var23) {
         var32 = (var24 - var22 << 8) / (var25 - var23);
         var34 = (var14 - var10 << 8) / (var25 - var23);
      }

      if (var23 > var25) {
         var31 = var24 << 8;
         var33 = var14 << 8;
         var35 = var15 << 8;
         var29 = var25;
         var30 = var23;
      } else {
         var31 = var22 << 8;
         var33 = var10 << 8;
         var35 = var11 << 8;
         var29 = var23;
         var30 = var25;
      }

      if (var29 < 0) {
         var31 -= var32 * var29;
         var33 -= var34 * var29;
         var29 = 0;
      }

      if (var30 > var7 - 1) {
         var30 = var7 - 1;
      }

      for(int var42 = var29; var42 <= var30; ++var42) {
         if (var31 < this.field_40[var42]) {
            this.field_40[var42] = var31;
            this.field_42[var42] = var33;
            this.field_44[var42] = var35;
         }

         if (var31 > this.field_41[var42]) {
            this.field_41[var42] = var31;
            this.field_43[var42] = var33;
            this.field_45[var42] = var35;
         }

         var31 += var32;
         var33 += var34;
      }

      int var43 = var26 * var6;
      int[] var44 = this.field_20[var3];

      for(int var45 = var26; var45 < var27; ++var45) {
         int var46 = this.field_40[var45] >> 8;
         int var47 = this.field_41[var45] >> 8;
         if (var47 - var46 <= 0) {
            var43 += var6;
         } else {
            int var48 = this.field_42[var45] << 9;
            int var49 = ((this.field_43[var45] << 9) - var48) / (var47 - var46);
            int var50 = this.field_44[var45] << 9;
            int var51 = ((this.field_45[var45] << 9) - var50) / (var47 - var46);
            if (var46 < this.field_32) {
               var48 += (this.field_32 - var46) * var49;
               var50 += (this.field_32 - var46) * var51;
               var46 = this.field_32;
            }

            if (var47 > this.field_33) {
               var47 = this.field_33;
            }

            if (!this.field_34 || (var45 & 1) == 0) {
               if (!this.field_29[var3]) {
                  this.method_65(this.field_16, var44, 0, var43 + var46, var48, var50, var49, var51, var46 - var47, var37);
               } else {
                  this.method_66(this.field_16, var44, 0, var43 + var46, var48, var50, var49, var51, var46 - var47, var37);
               }
            }

            var43 += var6;
         }
      }

   }

   // $FF: renamed from: eg (int[], int[], int, int, int, int, int, int, int, int) void
   private void method_65(int[] var1, int[] var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10) {
      for(var3 = var9; var3 < 0; ++var3) {
         this.field_16[var4++] = var2[(var5 >> 17) + (var6 >> 17) * var10];
         var5 += var7;
         var6 += var8;
      }

   }

   // $FF: renamed from: yg (int[], int[], int, int, int, int, int, int, int, int) void
   private void method_66(int[] var1, int[] var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10) {
      for(int var11 = var9; var11 < 0; ++var11) {
         var3 = var2[(var5 >> 17) + (var6 >> 17) * var10];
         if (var3 != 0) {
            this.field_16[var4++] = var3;
         } else {
            ++var4;
         }

         var5 += var7;
         var6 += var8;
      }

   }

   // $FF: renamed from: jf (int, int, int, int, int, int, int) void
   public void method_67(int var1, int var2, int var3, int var4, int var5, int var6, int var7) {
      this.method_53(var1, var2, var3, var4, var5);
   }

   // $FF: renamed from: ih (int, int, int, int, int, int, int, int, boolean) void
   public void method_68(int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, boolean var9) {
      try {
         if (var6 == 0) {
            var6 = 16777215;
         }

         if (var7 == 0) {
            var7 = 16777215;
         }

         int var10 = this.field_23[var5];
         int var11 = this.field_24[var5];
         int var12 = 0;
         int var13 = 0;
         int var14 = var8 << 16;
         int var15 = (var10 << 16) / var3;
         int var16 = (var11 << 16) / var4;
         int var17 = -(var8 << 16) / var4;
         int var18;
         int var19;
         if (this.field_29[var5]) {
            var18 = this.field_27[var5];
            var19 = this.field_28[var5];
            var15 = (var18 << 16) / var3;
            var16 = (var19 << 16) / var4;
            int var20 = this.field_25[var5];
            int var21 = this.field_26[var5];
            if (var9) {
               var20 = var18 - this.field_23[var5] - var20;
            }

            var1 += (var20 * var3 + var18 - 1) / var18;
            int var22 = (var21 * var4 + var19 - 1) / var19;
            var2 += var22;
            var14 += var22 * var17;
            if (var20 * var3 % var18 != 0) {
               var12 = (var18 - var20 * var3 % var18 << 16) / var3;
            }

            if (var21 * var4 % var19 != 0) {
               var13 = (var19 - var21 * var4 % var19 << 16) / var4;
            }

            var3 = ((this.field_23[var5] << 16) - var12 + var15 - 1) / var15;
            var4 = ((this.field_24[var5] << 16) - var13 + var16 - 1) / var16;
         }

         var18 = var2 * this.field_10;
         var14 += var1 << 16;
         if (var2 < this.field_30) {
            var19 = this.field_30 - var2;
            var4 -= var19;
            var2 = this.field_30;
            var18 += var19 * this.field_10;
            var13 += var16 * var19;
            var14 += var17 * var19;
         }

         if (var2 + var4 >= this.field_31) {
            var4 -= var2 + var4 - this.field_31 + 1;
         }

         var19 = var18 / this.field_10 & 1;
         if (!this.field_34) {
            var19 = 2;
         }

         if (var7 == 16777215) {
            if (this.field_20[var5] != null) {
               if (!var9) {
                  this.method_69(this.field_16, this.field_20[var5], 0, var12, var13, var18, var3, var4, var15, var16, var10, var6, var14, var17, var19);
               } else {
                  this.method_69(this.field_16, this.field_20[var5], 0, (this.field_23[var5] << 16) - var12 - 1, var13, var18, var3, var4, -var15, var16, var10, var6, var14, var17, var19);
               }
            } else if (!var9) {
               this.method_71(this.field_16, this.field_21[var5], this.field_22[var5], 0, var12, var13, var18, var3, var4, var15, var16, var10, var6, var14, var17, var19);
            } else {
               this.method_71(this.field_16, this.field_21[var5], this.field_22[var5], 0, (this.field_23[var5] << 16) - var12 - 1, var13, var18, var3, var4, -var15, var16, var10, var6, var14, var17, var19);
            }
         } else if (this.field_20[var5] != null) {
            if (!var9) {
               this.method_70(this.field_16, this.field_20[var5], 0, var12, var13, var18, var3, var4, var15, var16, var10, var6, var7, var14, var17, var19);
            } else {
               this.method_70(this.field_16, this.field_20[var5], 0, (this.field_23[var5] << 16) - var12 - 1, var13, var18, var3, var4, -var15, var16, var10, var6, var7, var14, var17, var19);
            }
         } else if (!var9) {
            this.method_72(this.field_16, this.field_21[var5], this.field_22[var5], 0, var12, var13, var18, var3, var4, var15, var16, var10, var6, var7, var14, var17, var19);
         } else {
            this.method_72(this.field_16, this.field_21[var5], this.field_22[var5], 0, (this.field_23[var5] << 16) - var12 - 1, var13, var18, var3, var4, -var15, var16, var10, var6, var7, var14, var17, var19);
         }
      } catch (Exception var23) {
         System.out.println("error in sprite clipping routine");
      }
   }

   // $FF: renamed from: kg (int[], int[], int, int, int, int, int, int, int, int, int, int, int, int, int) void
   private void method_69(int[] var1, int[] var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, int var11, int var12, int var13, int var14, int var15) {
      int var19 = var12 >> 16 & 255;
      int var20 = var12 >> 8 & 255;
      int var21 = var12 & 255;

      try {
         int var22 = var4;

         for(int var23 = -var8; var23 < 0; ++var23) {
            int var24 = (var5 >> 16) * var11;
            int var25 = var13 >> 16;
            int var26 = var7;
            int var27;
            if (var25 < this.field_32) {
               var27 = this.field_32 - var25;
               var26 = var7 - var27;
               var25 = this.field_32;
               var4 += var9 * var27;
            }

            if (var25 + var26 >= this.field_33) {
               var27 = var25 + var26 - this.field_33;
               var26 -= var27;
            }

            var15 = 1 - var15;
            if (var15 != 0) {
               for(var27 = var25; var27 < var25 + var26; ++var27) {
                  var3 = var2[(var4 >> 16) + var24];
                  if (var3 != 0) {
                     int var16 = var3 >> 16 & 255;
                     int var17 = var3 >> 8 & 255;
                     int var18 = var3 & 255;
                     if (var16 == var17 && var17 == var18) {
                        var1[var27 + var6] = (var16 * var19 >> 8 << 16) + (var17 * var20 >> 8 << 8) + (var18 * var21 >> 8);
                     } else {
                        var1[var27 + var6] = var3;
                     }
                  }

                  var4 += var9;
               }
            }

            var5 += var10;
            var4 = var22;
            var6 += this.field_10;
            var13 += var14;
         }

      } catch (Exception var28) {
         System.out.println("error in transparent sprite plot routine");
      }
   }

   // $FF: renamed from: wg (int[], int[], int, int, int, int, int, int, int, int, int, int, int, int, int, int) void
   private void method_70(int[] var1, int[] var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, int var11, int var12, int var13, int var14, int var15, int var16) {
      int var20 = var12 >> 16 & 255;
      int var21 = var12 >> 8 & 255;
      int var22 = var12 & 255;
      int var23 = var13 >> 16 & 255;
      int var24 = var13 >> 8 & 255;
      int var25 = var13 & 255;

      try {
         int var26 = var4;

         for(int var27 = -var8; var27 < 0; ++var27) {
            int var28 = (var5 >> 16) * var11;
            int var29 = var14 >> 16;
            int var30 = var7;
            int var31;
            if (var29 < this.field_32) {
               var31 = this.field_32 - var29;
               var30 = var7 - var31;
               var29 = this.field_32;
               var4 += var9 * var31;
            }

            if (var29 + var30 >= this.field_33) {
               var31 = var29 + var30 - this.field_33;
               var30 -= var31;
            }

            var16 = 1 - var16;
            if (var16 != 0) {
               for(var31 = var29; var31 < var29 + var30; ++var31) {
                  var3 = var2[(var4 >> 16) + var28];
                  if (var3 != 0) {
                     int var17 = var3 >> 16 & 255;
                     int var18 = var3 >> 8 & 255;
                     int var19 = var3 & 255;
                     if (var17 == var18 && var18 == var19) {
                        var1[var31 + var6] = (var17 * var20 >> 8 << 16) + (var18 * var21 >> 8 << 8) + (var19 * var22 >> 8);
                     } else if (var17 == 255 && var18 == var19) {
                        var1[var31 + var6] = (var17 * var23 >> 8 << 16) + (var18 * var24 >> 8 << 8) + (var19 * var25 >> 8);
                     } else {
                        var1[var31 + var6] = var3;
                     }
                  }

                  var4 += var9;
               }
            }

            var5 += var10;
            var4 = var26;
            var6 += this.field_10;
            var14 += var15;
         }

      } catch (Exception var32) {
         System.out.println("error in transparent sprite plot routine");
      }
   }

   // $FF: renamed from: vg (int[], byte[], int[], int, int, int, int, int, int, int, int, int, int, int, int, int) void
   private void method_71(int[] var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, int var11, int var12, int var13, int var14, int var15, int var16) {
      int var20 = var13 >> 16 & 255;
      int var21 = var13 >> 8 & 255;
      int var22 = var13 & 255;

      try {
         int var23 = var5;

         for(int var24 = -var9; var24 < 0; ++var24) {
            int var25 = (var6 >> 16) * var12;
            int var26 = var14 >> 16;
            int var27 = var8;
            int var28;
            if (var26 < this.field_32) {
               var28 = this.field_32 - var26;
               var27 = var8 - var28;
               var26 = this.field_32;
               var5 += var10 * var28;
            }

            if (var26 + var27 >= this.field_33) {
               var28 = var26 + var27 - this.field_33;
               var27 -= var28;
            }

            var16 = 1 - var16;
            if (var16 != 0) {
               for(var28 = var26; var28 < var26 + var27; ++var28) {
                  var4 = var2[(var5 >> 16) + var25] & 255;
                  if (var4 != 0) {
                     var4 = var3[var4];
                     int var17 = var4 >> 16 & 255;
                     int var18 = var4 >> 8 & 255;
                     int var19 = var4 & 255;
                     if (var17 == var18 && var18 == var19) {
                        var1[var28 + var7] = (var17 * var20 >> 8 << 16) + (var18 * var21 >> 8 << 8) + (var19 * var22 >> 8);
                     } else {
                        var1[var28 + var7] = var4;
                     }
                  }

                  var5 += var10;
               }
            }

            var6 += var11;
            var5 = var23;
            var7 += this.field_10;
            var14 += var15;
         }

      } catch (Exception var29) {
         System.out.println("error in transparent sprite plot routine");
      }
   }

   // $FF: renamed from: dh (int[], byte[], int[], int, int, int, int, int, int, int, int, int, int, int, int, int, int) void
   private void method_72(int[] var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, int var11, int var12, int var13, int var14, int var15, int var16, int var17) {
      int var21 = var13 >> 16 & 255;
      int var22 = var13 >> 8 & 255;
      int var23 = var13 & 255;
      int var24 = var14 >> 16 & 255;
      int var25 = var14 >> 8 & 255;
      int var26 = var14 & 255;

      try {
         int var27 = var5;

         for(int var28 = -var9; var28 < 0; ++var28) {
            int var29 = (var6 >> 16) * var12;
            int var30 = var15 >> 16;
            int var31 = var8;
            int var32;
            if (var30 < this.field_32) {
               var32 = this.field_32 - var30;
               var31 = var8 - var32;
               var30 = this.field_32;
               var5 += var10 * var32;
            }

            if (var30 + var31 >= this.field_33) {
               var32 = var30 + var31 - this.field_33;
               var31 -= var32;
            }

            var17 = 1 - var17;
            if (var17 != 0) {
               for(var32 = var30; var32 < var30 + var31; ++var32) {
                  var4 = var2[(var5 >> 16) + var29] & 255;
                  if (var4 != 0) {
                     var4 = var3[var4];
                     int var18 = var4 >> 16 & 255;
                     int var19 = var4 >> 8 & 255;
                     int var20 = var4 & 255;
                     if (var18 == var19 && var19 == var20) {
                        var1[var32 + var7] = (var18 * var21 >> 8 << 16) + (var19 * var22 >> 8 << 8) + (var20 * var23 >> 8);
                     } else if (var18 == 255 && var19 == var20) {
                        var1[var32 + var7] = (var18 * var24 >> 8 << 16) + (var19 * var25 >> 8 << 8) + (var20 * var26 >> 8);
                     } else {
                        var1[var32 + var7] = var4;
                     }
                  }

                  var5 += var10;
               }
            }

            var6 += var11;
            var5 = var27;
            var7 += this.field_10;
            var15 += var16;
         }

      } catch (Exception var33) {
         System.out.println("error in transparent sprite plot routine");
      }
   }

   // $FF: renamed from: of (byte[]) int
   public static int method_73(byte[] var0) {
      field_35[field_37] = var0;
      return field_37++;
   }

   // $FF: renamed from: hg (java.lang.String, int, int, int, int) void
   public void method_74(String var1, int var2, int var3, int var4, int var5) {
      this.method_77(var1, var2 - this.method_81(var1, var4), var3, var4, var5);
   }

   // $FF: renamed from: pg (java.lang.String, int, int, int, int) void
   public void method_75(String var1, int var2, int var3, int var4, int var5) {
      this.method_77(var1, var2 - this.method_81(var1, var4) / 2, var3, var4, var5);
   }

   // $FF: renamed from: cg (java.lang.String, int, int, int, int, int) void
   public void method_76(String var1, int var2, int var3, int var4, int var5, int var6) {
      try {
         int var7 = 0;
         byte[] var8 = field_35[var4];
         int var9 = 0;
         int var10 = 0;

         for(int var11 = 0; var11 < var1.length(); ++var11) {
            if (var1.charAt(var11) == '@' && var11 + 4 < var1.length() && var1.charAt(var11 + 4) == '@') {
               var11 += 4;
            } else if (var1.charAt(var11) == '~' && var11 + 4 < var1.length() && var1.charAt(var11 + 4) == '~') {
               var11 += 4;
            } else {
               var7 += var8[field_36[var1.charAt(var11)] + 7];
            }

            if (var1.charAt(var11) == ' ') {
               var10 = var11;
            }

            if (var7 > var6) {
               if (var10 <= var9) {
                  var10 = var11;
               }

               this.method_75(var1.substring(var9, var10), var2, var3, var4, var5);
               var7 = 0;
               var9 = var11 = var10 + 1;
               var3 += this.method_80(var4);
            }
         }

         if (var7 > 0) {
            this.method_75(var1.substring(var9), var2, var3, var4, var5);
            return;
         }
      } catch (Exception var12) {
         System.out.println("centrepara: " + var12);
         var12.printStackTrace();
      }

   }

   // $FF: renamed from: xg (java.lang.String, int, int, int, int) void
   public void method_77(String var1, int var2, int var3, int var4, int var5) {
      try {
         byte[] var6 = field_35[var4];

         for(int var7 = 0; var7 < var1.length(); ++var7) {
            if (var1.charAt(var7) == '@' && var7 + 4 < var1.length() && var1.charAt(var7 + 4) == '@') {
               if (var1.substring(var7 + 1, var7 + 4).equalsIgnoreCase("red")) {
                  var5 = 16711680;
               } else if (var1.substring(var7 + 1, var7 + 4).equalsIgnoreCase("lre")) {
                  var5 = 16748608;
               } else if (var1.substring(var7 + 1, var7 + 4).equalsIgnoreCase("yel")) {
                  var5 = 16776960;
               } else if (var1.substring(var7 + 1, var7 + 4).equalsIgnoreCase("gre")) {
                  var5 = 65280;
               } else if (var1.substring(var7 + 1, var7 + 4).equalsIgnoreCase("blu")) {
                  var5 = 255;
               } else if (var1.substring(var7 + 1, var7 + 4).equalsIgnoreCase("cya")) {
                  var5 = 65535;
               } else if (var1.substring(var7 + 1, var7 + 4).equalsIgnoreCase("mag")) {
                  var5 = 16711935;
               } else if (var1.substring(var7 + 1, var7 + 4).equalsIgnoreCase("whi")) {
                  var5 = 16777215;
               } else if (var1.substring(var7 + 1, var7 + 4).equalsIgnoreCase("bla")) {
                  var5 = 0;
               } else if (var1.substring(var7 + 1, var7 + 4).equalsIgnoreCase("dre")) {
                  var5 = 12582912;
               } else if (var1.substring(var7 + 1, var7 + 4).equalsIgnoreCase("ora")) {
                  var5 = 16748608;
               } else if (var1.substring(var7 + 1, var7 + 4).equalsIgnoreCase("ran")) {
                  var5 = (int)(Math.random() * 1.6777215E7D);
               } else if (var1.substring(var7 + 1, var7 + 4).equalsIgnoreCase("or1")) {
                  var5 = 16756736;
               } else if (var1.substring(var7 + 1, var7 + 4).equalsIgnoreCase("or2")) {
                  var5 = 16740352;
               } else if (var1.substring(var7 + 1, var7 + 4).equalsIgnoreCase("or3")) {
                  var5 = 16723968;
               } else if (var1.substring(var7 + 1, var7 + 4).equalsIgnoreCase("gr1")) {
                  var5 = 12648192;
               } else if (var1.substring(var7 + 1, var7 + 4).equalsIgnoreCase("gr2")) {
                  var5 = 8453888;
               } else if (var1.substring(var7 + 1, var7 + 4).equalsIgnoreCase("gr3")) {
                  var5 = 4259584;
               }

               var7 += 4;
            } else if (var1.charAt(var7) == '~' && var7 + 4 < var1.length() && var1.charAt(var7 + 4) == '~') {
               char var12 = var1.charAt(var7 + 1);
               char var9 = var1.charAt(var7 + 2);
               char var10 = var1.charAt(var7 + 3);
               if (var12 >= '0' && var12 <= '9' && var9 >= '0' && var9 <= '9' && var10 >= '0' && var10 <= '9') {
                  var2 = Integer.parseInt(var1.substring(var7 + 1, var7 + 4));
               }

               var7 += 4;
            } else {
               int var8 = field_36[var1.charAt(var7)];
               if (this.field_38 && var5 != 0) {
                  this.method_78(var8, var2 + 1, var3, 0, var6);
               }

               if (this.field_38 && var5 != 0) {
                  this.method_78(var8, var2, var3 + 1, 0, var6);
               }

               this.method_78(var8, var2, var3, var5, var6);
               var2 += var6[var8 + 7];
            }
         }

      } catch (Exception var11) {
         System.out.println("drawstring: " + var11);
         var11.printStackTrace();
      }
   }

   // $FF: renamed from: gh (int, int, int, int, byte[]) void
   private void method_78(int var1, int var2, int var3, int var4, byte[] var5) {
      int var6 = var2 + var5[var1 + 5];
      int var7 = var3 - var5[var1 + 6];
      int var8 = var5[var1 + 3];
      int var9 = var5[var1 + 4];
      int var10 = var5[var1] * 16384 + var5[var1 + 1] * 128 + var5[var1 + 2];
      int var11 = var6 + var7 * this.field_10;
      int var12 = this.field_10 - var8;
      int var13 = 0;
      int var14;
      if (var7 < this.field_30) {
         var14 = this.field_30 - var7;
         var9 -= var14;
         var7 = this.field_30;
         var10 += var14 * var8;
         var11 += var14 * this.field_10;
      }

      if (var7 + var9 >= this.field_31) {
         var9 -= var7 + var9 - this.field_31 + 1;
      }

      if (var6 < this.field_32) {
         var14 = this.field_32 - var6;
         var8 -= var14;
         var6 = this.field_32;
         var10 += var14;
         var11 += var14;
         var13 += var14;
         var12 += var14;
      }

      if (var6 + var8 >= this.field_33) {
         var14 = var6 + var8 - this.field_33 + 1;
         var8 -= var14;
         var13 += var14;
         var12 += var14;
      }

      if (var8 > 0 && var9 > 0) {
         this.method_79(this.field_16, var5, var4, var10, var11, var8, var9, var12, var13);
      }

   }

   // $FF: renamed from: sf (int[], byte[], int, int, int, int, int, int, int) void
   private void method_79(int[] var1, byte[] var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9) {
      try {
         int var10 = -(var6 >> 2);
         var6 = -(var6 & 3);

         for(int var11 = -var7; var11 < 0; ++var11) {
            for(int var12 = var10; var12 < 0; ++var12) {
               if (var2[var4++] != 0) {
                  var1[var5++] = var3;
               } else {
                  ++var5;
               }

               if (var2[var4++] != 0) {
                  var1[var5++] = var3;
               } else {
                  ++var5;
               }

               if (var2[var4++] != 0) {
                  var1[var5++] = var3;
               } else {
                  ++var5;
               }

               if (var2[var4++] != 0) {
                  var1[var5++] = var3;
               } else {
                  ++var5;
               }
            }

            for(int var13 = var6; var13 < 0; ++var13) {
               if (var2[var4++] != 0) {
                  var1[var5++] = var3;
               } else {
                  ++var5;
               }
            }

            var5 += var8;
            var4 += var9;
         }

      } catch (Exception var14) {
         System.out.println("plotletter: " + var14);
         var14.printStackTrace();
      }
   }

   // $FF: renamed from: kf (int) int
   public int method_80(int var1) {
      return var1 == 0 ? field_35[var1][8] - 2 : field_35[var1][8] - 1;
   }

   // $FF: renamed from: if (java.lang.String, int) int
   public int method_81(String var1, int var2) {
      int var3 = 0;
      byte[] var4 = field_35[var2];

      for(int var5 = 0; var5 < var1.length(); ++var5) {
         if (var1.charAt(var5) == '@' && var5 + 4 < var1.length() && var1.charAt(var5 + 4) == '@') {
            var5 += 4;
         } else if (var1.charAt(var5) == '~' && var5 + 4 < var1.length() && var1.charAt(var5 + 4) == '~') {
            var5 += 4;
         } else {
            var3 += var4[field_36[var1.charAt(var5)] + 7];
         }
      }

      return var3;
   }

   public boolean imageUpdate(Image var1, int var2, int var3, int var4, int var5, int var6) {
      return true;
   }

   static {
      String var0 = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!\"\u00a3$%^&*()-_=+[{]};:'@#~,<.>/?\\| ";
      field_36 = new int[256];

      for(int var1 = 0; var1 < 256; ++var1) {
         int var2 = var0.indexOf(var1);
         if (var2 == -1) {
            var2 = 74;
         }

         field_36[var1] = var2 * 9;
      }

   }
}
