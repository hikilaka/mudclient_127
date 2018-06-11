package jagex;

import java.io.IOException;
import java.math.BigInteger;

// $FF: renamed from: jagex.n
public class class_15 {
   // $FF: renamed from: xo int[]
   public static int[] field_545 = new int[256];
   // $FF: renamed from: yo int[]
   public static int[] field_546 = new int[256];
   // $FF: renamed from: zo int
   protected int field_547 = 5000;
   // $FF: renamed from: ap boolean
   protected boolean field_548 = false;
   // $FF: renamed from: bp java.lang.String
   protected String field_549 = "";
   // $FF: renamed from: cp int
   protected int field_550;
   // $FF: renamed from: dp int
   final int field_551 = 61;
   // $FF: renamed from: ep int
   final int field_552 = 59;
   // $FF: renamed from: fp int
   final int field_553 = 42;
   // $FF: renamed from: gp int
   final int field_554 = 43;
   // $FF: renamed from: hp int
   final int field_555 = 44;
   // $FF: renamed from: ip int
   final int field_556 = 45;
   // $FF: renamed from: jp int
   final int field_557 = 46;
   // $FF: renamed from: kp int
   final int field_558 = 47;
   // $FF: renamed from: lp int
   final int field_559 = 92;
   // $FF: renamed from: mp int
   final int field_560 = 32;
   // $FF: renamed from: np int
   final int field_561 = 124;
   // $FF: renamed from: op int
   final int field_562 = 34;
   // $FF: renamed from: pp char[]
   static char[] field_563 = new char[256];
   // $FF: renamed from: qp int
   private int field_564;
   // $FF: renamed from: rp int
   public int field_565;
   // $FF: renamed from: sp int
   public int field_566;
   // $FF: renamed from: tp int
   private int field_567;
   // $FF: renamed from: up int
   private int field_568 = 3;
   // $FF: renamed from: vp int
   private int field_569 = 8;
   // $FF: renamed from: wp byte[]
   private byte[] field_570;
   // $FF: renamed from: xp int[]
   private static int[] field_571;

   // $FF: renamed from: mi () void
   public void method_338() {
   }

   // $FF: renamed from: qi () int
   public int method_339() throws IOException {
      return 0;
   }

   // $FF: renamed from: hi () int
   public int method_340() throws IOException {
      return 0;
   }

   // $FF: renamed from: bi (int, int, byte[]) void
   public void method_341(int var1, int var2, byte[] var3) throws IOException {
   }

   // $FF: renamed from: ki (byte[], int, int) void
   public void method_342(byte[] var1, int var2, int var3) throws IOException {
   }

   // $FF: renamed from: wh (byte[], int, int) int
   public int method_343(byte[] var1, int var2, int var3) throws IOException {
      return 0;
   }

   // $FF: renamed from: vh () int
   public int method_344() throws IOException {
      return this.method_339();
   }

   // $FF: renamed from: uh () int
   public int method_345() throws IOException {
      int var1 = this.method_344();
      int var2 = this.method_344();
      return var1 * 256 + var2;
   }

   // $FF: renamed from: ri () int
   public int method_346() throws IOException {
      int var1 = this.method_345();
      int var2 = this.method_345();
      return var1 * 65536 + var2;
   }

   // $FF: renamed from: xh (int, byte[]) void
   public void method_347(int var1, byte[] var2) throws IOException {
      this.method_341(var1, 0, var2);
   }

   // $FF: renamed from: li (byte[]) int
   public int method_348(byte[] var1) {
      try {
         ++this.field_565;
         if (this.field_566 > 0 && this.field_565 > this.field_566) {
            this.field_548 = true;
            this.field_549 = "time-out";
            this.field_566 += this.field_566;
            return 0;
         }

         if (this.field_564 == 0 && this.method_340() >= 2) {
            this.field_564 = this.method_339();
            if (this.field_564 >= 160) {
               this.field_564 = (this.field_564 - 160) * 256 + this.method_339();
            }
         }

         if (this.field_564 > 0 && this.method_340() >= this.field_564) {
            if (this.field_564 >= 160) {
               this.method_347(this.field_564, var1);
            } else {
               var1[this.field_564 - 1] = (byte)this.method_339();
               if (this.field_564 > 1) {
                  this.method_347(this.field_564 - 1, var1);
               }
            }

            int var2 = this.field_564;
            this.field_564 = 0;
            this.field_565 = 0;
            return var2;
         }
      } catch (IOException var3) {
         this.field_548 = true;
         this.field_549 = var3.getMessage();
      }

      return 0;
   }

   // $FF: renamed from: fi (int) void
   public void method_349(int var1) {
      this.field_570[this.field_568++] = (byte)var1;
   }

   // $FF: renamed from: ei (int) void
   public void method_350(int var1) {
      this.field_570[this.field_568++] = (byte)(var1 >> 8);
      this.field_570[this.field_568++] = (byte)var1;
   }

   // $FF: renamed from: ci (int, int) void
   public void method_351(int var1, int var2) {
      this.field_570[this.field_567 + var2] = (byte)(var1 >> 8);
      this.field_570[this.field_567 + var2 + 1] = (byte)var1;
   }

   // $FF: renamed from: di (int) void
   public void method_352(int var1) {
      this.field_570[this.field_568++] = (byte)(var1 >> 24);
      this.field_570[this.field_568++] = (byte)(var1 >> 16);
      this.field_570[this.field_568++] = (byte)(var1 >> 8);
      this.field_570[this.field_568++] = (byte)var1;
   }

   // $FF: renamed from: th (long) void
   public void method_353(long var1) {
      this.method_352((int)(var1 >> 32));
      this.method_352((int)(var1 & -1L));
   }

   // $FF: renamed from: zh (java.lang.String) void
   public void method_354(String var1) {
      var1.getBytes(0, var1.length(), this.field_570, this.field_568);
      this.field_568 += var1.length();
   }

   // $FF: renamed from: ji (byte[], int, int) void
   public void method_355(byte[] var1, int var2, int var3) {
      for(int var4 = 0; var4 < var3; ++var4) {
         this.field_570[this.field_568++] = var1[var2 + var4];
      }

   }

   // $FF: renamed from: oi (long, int, java.math.BigInteger, java.math.BigInteger) void
   public void method_356(long var1, int var3, BigInteger var4, BigInteger var5) {
      byte[] var6 = new byte[15];
      var6[0] = (byte)((int)(1.0D + Math.random() * 127.0D));
      var6[1] = (byte)((int)(Math.random() * 256.0D));
      var6[2] = (byte)((int)(Math.random() * 256.0D));
      class_0.method_2(var6, 3, var3);
      class_0.method_3(var6, 7, var1);
      BigInteger var7 = new BigInteger(1, var6);
      BigInteger var8 = var7.modPow(var4, var5);
      byte[] var9 = var8.toByteArray();
      this.field_570[this.field_568++] = (byte)var9.length;

      for(int var10 = 0; var10 < var9.length; ++var10) {
         this.field_570[this.field_568++] = var9[var10];
      }

   }

   // $FF: renamed from: yh (java.lang.String, int, java.math.BigInteger, java.math.BigInteger) void
   public void method_357(String var1, int var2, BigInteger var3, BigInteger var4) {
      byte[] var5 = var1.getBytes();
      int var6 = var5.length;
      byte[] var7 = new byte[15];

      for(int var8 = 0; var8 < var6; var8 += 7) {
         var7[0] = (byte)((int)(1.0D + Math.random() * 127.0D));
         var7[1] = (byte)((int)(Math.random() * 256.0D));
         var7[2] = (byte)((int)(Math.random() * 256.0D));
         var7[3] = (byte)((int)(Math.random() * 256.0D));
         class_0.method_2(var7, 4, var2);

         for(int var9 = 0; var9 < 7; ++var9) {
            if (var8 + var9 < var6) {
               var7[8 + var9] = var5[var8 + var9];
            } else {
               var7[8 + var9] = 32;
            }
         }

         BigInteger var10 = new BigInteger(1, var7);
         BigInteger var11 = var10.modPow(var3, var4);
         byte[] var12 = var11.toByteArray();
         this.field_570[this.field_568++] = (byte)var12.length;

         for(int var13 = 0; var13 < var12.length; ++var13) {
            this.field_570[this.field_568++] = var12[var13];
         }
      }

   }

   // $FF: renamed from: ii (int) void
   public void method_358(int var1) {
      if (this.field_567 > this.field_547 * 4 / 5) {
         try {
            this.method_361(0);
         } catch (IOException var3) {
            this.field_548 = true;
            this.field_549 = var3.getMessage();
         }
      }

      if (this.field_570 == null) {
         this.field_570 = new byte[this.field_547];
      }

      this.field_570[this.field_567 + 2] = (byte)var1;
      this.field_570[this.field_567 + 3] = 0;
      this.field_568 = this.field_567 + 3;
      this.field_569 = 8;
   }

   // $FF: renamed from: pi () void
   public void method_359() {
      if (this.field_569 != 8) {
         ++this.field_568;
      }

      int var1 = this.field_568 - this.field_567 - 2;
      if (var1 >= 160) {
         this.field_570[this.field_567] = (byte)(160 + var1 / 256);
         this.field_570[this.field_567 + 1] = (byte)(var1 & 255);
      } else {
         this.field_570[this.field_567] = (byte)var1;
         --this.field_568;
         this.field_570[this.field_567 + 1] = this.field_570[this.field_568];
      }

      if (this.field_547 <= 10000) {
         int var2 = this.field_570[this.field_567 + 2] & 255;
         ++field_545[var2];
         field_546[var2] += this.field_568 - this.field_567;
      }

      this.field_567 = this.field_568;
   }

   // $FF: renamed from: ni () void
   public void method_360() throws IOException {
      this.method_359();
      this.method_361(0);
   }

   // $FF: renamed from: gi (int) void
   public void method_361(int var1) throws IOException {
      if (this.field_548) {
         this.field_567 = 0;
         this.field_568 = 3;
         this.field_548 = false;
         throw new IOException(this.field_549);
      } else {
         ++this.field_550;
         if (this.field_550 >= var1) {
            if (this.field_567 > 0) {
               this.field_550 = 0;
               this.method_342(this.field_570, 0, this.field_567);
            }

            this.field_567 = 0;
            this.field_568 = 3;
         }
      }
   }

   // $FF: renamed from: ai () boolean
   public boolean method_362() {
      return this.field_567 > 0;
   }

   public class_15() {
      super();
   }

   static {
      for(int var0 = 0; var0 < 256; ++var0) {
         field_563[var0] = (char)var0;
      }

      field_563[61] = '=';
      field_563[59] = ';';
      field_563[42] = '*';
      field_563[43] = '+';
      field_563[44] = ',';
      field_563[45] = '-';
      field_563[46] = '.';
      field_563[47] = '/';
      field_563[92] = '\\';
      field_563[124] = '|';
      field_563[33] = '!';
      field_563[34] = '"';
      field_571 = new int[]{0, 1, 3, 7, 15, 31, 63, 127, 255, 511, 1023, 2047, 4095, 8191, 16383, 32767, 65535, 131071, 262143, 524287, 1048575, 2097151, 4194303, 8388607, 16777215, 33554431, 67108863, 134217727, 268435455, 536870911, 1073741823, Integer.MAX_VALUE, -1};
   }
}
