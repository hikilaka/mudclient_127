package jagex;

import java.io.DataInputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

// $FF: renamed from: jagex.c
public class class_0 {
   // $FF: renamed from: td java.net.URL
   public static URL field_0 = null;
   // $FF: renamed from: ud int[]
   private static int[] field_1 = new int[]{0, 1, 3, 7, 15, 31, 63, 127, 255, 511, 1023, 2047, 4095, 8191, 16383, 32767, 65535, 131071, 262143, 524287, 1048575, 2097151, 4194303, 8388607, 16777215, 33554431, 67108863, 134217727, 268435455, 536870911, 1073741823, Integer.MAX_VALUE, -1};
   // $FF: renamed from: vd int
   public static int field_2 = 1;
   // $FF: renamed from: wd java.lang.String[]
   public static String[] field_3 = new String[]{"bum"};
   // $FF: renamed from: xd int
   public static int field_4 = 1;
   // $FF: renamed from: yd java.lang.String[]
   public static String[] field_5 = new String[]{"hello"};
   // $FF: renamed from: zd byte[]
   public static byte[] field_6 = new byte[200];
   // $FF: renamed from: ae char[]
   static char[] field_7 = new char[1000];
   // $FF: renamed from: be char[]
   private static char[] field_8 = new char[]{'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', ' ', '!', '?', '.', ',', ':', ';', '(', ')', '-', '&', '*', '\\', '\''};

   // $FF: renamed from: zb (java.lang.String) java.io.InputStream
   public static InputStream method_0(String var0) throws IOException {
      Object var1;
      if (field_0 == null) {
         var1 = new FileInputStream(var0);
      } else {
         URL var2 = new URL(field_0, var0);
         var1 = var2.openStream();
      }

      return (InputStream)var1;
   }

   // $FF: renamed from: nc (java.lang.String, byte[], int) void
   public static void method_1(String var0, byte[] var1, int var2) throws IOException {
      InputStream var3 = method_0(var0);
      DataInputStream var4 = new DataInputStream(var3);

      try {
         var4.readFully(var1, 0, var2);
      } catch (EOFException var5) {
         ;
      }

      var4.close();
   }

   // $FF: renamed from: uc (byte[], int, int) void
   public static void method_2(byte[] var0, int var1, int var2) {
      var0[var1] = (byte)(var2 >> 24);
      var0[var1 + 1] = (byte)(var2 >> 16);
      var0[var1 + 2] = (byte)(var2 >> 8);
      var0[var1 + 3] = (byte)var2;
   }

   // $FF: renamed from: kc (byte[], int, long) void
   public static void method_3(byte[] var0, int var1, long var2) {
      var0[var1] = (byte)((int)(var2 >> 56));
      var0[var1 + 1] = (byte)((int)(var2 >> 48));
      var0[var1 + 2] = (byte)((int)(var2 >> 40));
      var0[var1 + 3] = (byte)((int)(var2 >> 32));
      var0[var1 + 4] = (byte)((int)(var2 >> 24));
      var0[var1 + 5] = (byte)((int)(var2 >> 16));
      var0[var1 + 6] = (byte)((int)(var2 >> 8));
      var0[var1 + 7] = (byte)((int)var2);
   }

   // $FF: renamed from: fc (byte) int
   public static int method_4(byte var0) {
      return var0 & 255;
   }

   // $FF: renamed from: ic (byte[], int) int
   public static int method_5(byte[] var0, int var1) {
      return ((var0[var1] & 255) << 8) + (var0[var1 + 1] & 255);
   }

   // $FF: renamed from: gc (byte[], int) int
   public static int method_6(byte[] var0, int var1) {
      return ((var0[var1] & 255) << 24) + ((var0[var1 + 1] & 255) << 16) + ((var0[var1 + 2] & 255) << 8) + (var0[var1 + 3] & 255);
   }

   // $FF: renamed from: bc (byte[], int) long
   public static long method_7(byte[] var0, int var1) {
      return (((long)method_6(var0, var1) & 4294967295L) << 32) + ((long)method_6(var0, var1 + 4) & 4294967295L);
   }

   // $FF: renamed from: tc (byte[], int) int
   public static int method_8(byte[] var0, int var1) {
      int var2 = method_4(var0[var1]) * 256 + method_4(var0[var1 + 1]);
      if (var2 > 32767) {
         var2 -= 65536;
      }

      return var2;
   }

   // $FF: renamed from: mc (byte[], int) int
   public static int method_9(byte[] var0, int var1) {
      return (var0[var1] & 255) < 128 ? var0[var1] : ((var0[var1] & 255) - 128 << 24) + ((var0[var1 + 1] & 255) << 16) + ((var0[var1 + 2] & 255) << 8) + (var0[var1 + 3] & 255);
   }

   // $FF: renamed from: cc (byte[], int, int) int
   public static int method_10(byte[] var0, int var1, int var2) {
      int var3 = var1 >> 3;
      int var4 = 8 - (var1 & 7);

      int var5;
      for(var5 = 0; var2 > var4; var4 = 8) {
         var5 += (var0[var3++] & field_1[var4]) << var2 - var4;
         var2 -= var4;
      }

      if (var2 == var4) {
         var5 += var0[var3] & field_1[var4];
      } else {
         var5 += var0[var3] >> var4 - var2 & field_1[var2];
      }

      return var5;
   }

   // $FF: renamed from: ac (java.lang.String, int) java.lang.String
   public static String method_11(String var0, int var1) {
      String var2 = "";

      for(int var3 = 0; var3 < var1; ++var3) {
         if (var3 >= var0.length()) {
            var2 = var2 + " ";
         } else {
            char var4 = var0.charAt(var3);
            if (var4 >= 'a' && var4 <= 'z') {
               var2 = var2 + var4;
            } else if (var4 >= 'A' && var4 <= 'Z') {
               var2 = var2 + var4;
            } else if (var4 >= '0' && var4 <= '9') {
               var2 = var2 + var4;
            } else {
               var2 = var2 + '_';
            }
         }
      }

      return var2;
   }

   // $FF: renamed from: qc (int) java.lang.String
   public static String method_12(int var0) {
      return (var0 >> 24 & 255) + "." + (var0 >> 16 & 255) + "." + (var0 >> 8 & 255) + "." + (var0 & 255);
   }

   // $FF: renamed from: rc (java.lang.String) long
   public static long method_13(String var0) {
      var0 = var0.trim();
      var0 = var0.toLowerCase();
      long var1 = 0L;
      int var3 = 0;

      for(int var4 = 0; var4 < var0.length(); ++var4) {
         char var5 = var0.charAt(var4);
         if (var5 >= 'a' && var5 <= 'z' || var5 >= '0' && var5 <= '9') {
            var1 = var1 * 47L * (var1 - (long)(var5 * 6) - (long)(var3 * 7));
            var1 += (long)(var5 - 32 + var3 * var5);
            ++var3;
         }
      }

      return var1;
   }

   // $FF: renamed from: vc (java.lang.String) long
   public static long method_14(String var0) {
      String var1 = "";

      for(int var2 = 0; var2 < var0.length(); ++var2) {
         char var3 = var0.charAt(var2);
         if (var3 >= 'a' && var3 <= 'z') {
            var1 = var1 + var3;
         } else if (var3 >= 'A' && var3 <= 'Z') {
            var1 = var1 + (char)(var3 + 97 - 65);
         } else if (var3 >= '0' && var3 <= '9') {
            var1 = var1 + var3;
         } else {
            var1 = var1 + ' ';
         }
      }

      var1 = var1.trim();
      if (var1.length() > 12) {
         var1 = var1.substring(0, 12);
      }

      long var7 = 0L;

      for(int var5 = 0; var5 < var1.length(); ++var5) {
         char var6 = var1.charAt(var5);
         var7 *= 37L;
         if (var6 >= 'a' && var6 <= 'z') {
            var7 += (long)(1 + var6 - 97);
         } else if (var6 >= '0' && var6 <= '9') {
            var7 += (long)(27 + var6 - 48);
         }
      }

      return var7;
   }

   // $FF: renamed from: pc (long) java.lang.String
   public static String method_15(long var0) {
      if (var0 < 0L) {
         return "invalid_name";
      } else {
         String var2 = "";

         while(var0 != 0L) {
            int var3 = (int)(var0 % 37L);
            var0 /= 37L;
            if (var3 == 0) {
               var2 = " " + var2;
            } else if (var3 < 27) {
               if (var0 % 37L == 0L) {
                  var2 = (char)(var3 + 65 - 1) + var2;
               } else {
                  var2 = (char)(var3 + 97 - 1) + var2;
               }
            } else {
               var2 = (char)(var3 + 48 - 27) + var2;
            }
         }

         return var2;
      }
   }

   // $FF: renamed from: sc (java.lang.String) byte[]
   public static byte[] method_16(String var0) throws IOException {
      int var1 = 0;
      int var2 = 0;
      int var3 = 0;
      byte[] var4 = null;

      while(var1 < 2) {
         try {
            if (var1 == 1) {
               var0 = var0.toUpperCase();
            }

            InputStream var5 = method_0(var0);
            DataInputStream var6 = new DataInputStream(var5);
            byte[] var7 = new byte[6];
            var6.readFully(var7, 0, 6);
            var2 = ((var7[0] & 255) << 16) + ((var7[1] & 255) << 8) + (var7[2] & 255);
            var3 = ((var7[3] & 255) << 16) + ((var7[4] & 255) << 8) + (var7[5] & 255);
            int var8 = 0;

            int var9;
            for(var4 = new byte[var3]; var8 < var3; var8 += var9) {
               var9 = var3 - var8;
               if (var9 > 1000) {
                  var9 = 1000;
               }

               var6.readFully(var4, var8, var9);
            }

            var1 = 2;
            var6.close();
         } catch (IOException var10) {
            ++var1;
         }
      }

      if (var3 != var2) {
         byte[] var11 = new byte[var2];
         class_14.method_329(var11, var2, var4, var3, 0);
         return var11;
      } else {
         return var4;
      }
   }

   // $FF: renamed from: jc (java.lang.String, byte[]) int
   public static int method_17(String var0, byte[] var1) {
      int var2 = method_5(var1, 0);
      int var3 = 0;
      var0 = var0.toUpperCase();

      for(int var4 = 0; var4 < var0.length(); ++var4) {
         var3 = var3 * 61 + var0.charAt(var4) - 32;
      }

      int var5 = 2 + var2 * 10;

      for(int var6 = 0; var6 < var2; ++var6) {
         int var7 = (var1[var6 * 10 + 2] & 255) * 16777216 + (var1[var6 * 10 + 3] & 255) * 65536 + (var1[var6 * 10 + 4] & 255) * 256 + (var1[var6 * 10 + 5] & 255);
         int var8 = (var1[var6 * 10 + 9] & 255) * 65536 + (var1[var6 * 10 + 10] & 255) * 256 + (var1[var6 * 10 + 11] & 255);
         if (var7 == var3) {
            return var5;
         }

         var5 += var8;
      }

      return 0;
   }

   // $FF: renamed from: yb (java.lang.String, byte[]) int
   public static int method_18(String var0, byte[] var1) {
      int var2 = method_5(var1, 0);
      int var3 = 0;
      var0 = var0.toUpperCase();

      for(int var4 = 0; var4 < var0.length(); ++var4) {
         var3 = var3 * 61 + var0.charAt(var4) - 32;
      }

      int var5 = 2 + var2 * 10;

      for(int var6 = 0; var6 < var2; ++var6) {
         int var7 = (var1[var6 * 10 + 2] & 255) * 16777216 + (var1[var6 * 10 + 3] & 255) * 65536 + (var1[var6 * 10 + 4] & 255) * 256 + (var1[var6 * 10 + 5] & 255);
         int var8 = (var1[var6 * 10 + 6] & 255) * 65536 + (var1[var6 * 10 + 7] & 255) * 256 + (var1[var6 * 10 + 8] & 255);
         int var9 = (var1[var6 * 10 + 9] & 255) * 65536 + (var1[var6 * 10 + 10] & 255) * 256 + (var1[var6 * 10 + 11] & 255);
         if (var7 == var3) {
            return var8;
         }

         var5 += var9;
      }

      return 0;
   }

   // $FF: renamed from: vb (java.lang.String, int, byte[]) byte[]
   public static byte[] method_19(String var0, int var1, byte[] var2) {
      return method_20(var0, var1, var2, (byte[])null);
   }

   // $FF: renamed from: ec (java.lang.String, int, byte[], byte[]) byte[]
   public static byte[] method_20(String var0, int var1, byte[] var2, byte[] var3) {
      int var4 = (var2[0] & 255) * 256 + (var2[1] & 255);
      int var5 = 0;
      var0 = var0.toUpperCase();

      for(int var6 = 0; var6 < var0.length(); ++var6) {
         var5 = var5 * 61 + var0.charAt(var6) - 32;
      }

      int var7 = 2 + var4 * 10;

      for(int var8 = 0; var8 < var4; ++var8) {
         int var9 = (var2[var8 * 10 + 2] & 255) * 16777216 + (var2[var8 * 10 + 3] & 255) * 65536 + (var2[var8 * 10 + 4] & 255) * 256 + (var2[var8 * 10 + 5] & 255);
         int var10 = (var2[var8 * 10 + 6] & 255) * 65536 + (var2[var8 * 10 + 7] & 255) * 256 + (var2[var8 * 10 + 8] & 255);
         int var11 = (var2[var8 * 10 + 9] & 255) * 65536 + (var2[var8 * 10 + 10] & 255) * 256 + (var2[var8 * 10 + 11] & 255);
         if (var9 == var5) {
            if (var3 == null) {
               var3 = new byte[var10 + var1];
            }

            if (var10 != var11) {
               class_14.method_329(var3, var10, var2, var11, var7);
            } else {
               for(int var12 = 0; var12 < var10; ++var12) {
                  var3[var12] = var2[var7 + var12];
               }
            }

            return var3;
         }

         var7 += var11;
      }

      return null;
   }

   // $FF: renamed from: hc (java.lang.String) int
   public static int method_21(String var0) {
      int var1 = 0;

      try {
         if (var0.length() > 80) {
            var0 = var0.substring(0, 80);
         }

         var0 = var0.toLowerCase() + " ";
         if (var0.startsWith("@red@")) {
            field_6[var1++] = -1;
            field_6[var1++] = 0;
            var0 = var0.substring(5);
         }

         if (var0.startsWith("@gre@")) {
            field_6[var1++] = -1;
            field_6[var1++] = 1;
            var0 = var0.substring(5);
         }

         if (var0.startsWith("@blu@")) {
            field_6[var1++] = -1;
            field_6[var1++] = 2;
            var0 = var0.substring(5);
         }

         if (var0.startsWith("@cya@")) {
            field_6[var1++] = -1;
            field_6[var1++] = 3;
            var0 = var0.substring(5);
         }

         if (var0.startsWith("@ran@")) {
            field_6[var1++] = -1;
            field_6[var1++] = 4;
            var0 = var0.substring(5);
         }

         if (var0.startsWith("@whi@")) {
            field_6[var1++] = -1;
            field_6[var1++] = 5;
            var0 = var0.substring(5);
         }

         if (var0.startsWith("@bla@")) {
            field_6[var1++] = -1;
            field_6[var1++] = 6;
            var0 = var0.substring(5);
         }

         if (var0.startsWith("@ora@")) {
            field_6[var1++] = -1;
            field_6[var1++] = 7;
            var0 = var0.substring(5);
         }

         if (var0.startsWith("@yel@")) {
            field_6[var1++] = -1;
            field_6[var1++] = 8;
            var0 = var0.substring(5);
         }

         if (var0.startsWith("@mag@")) {
            field_6[var1++] = -1;
            field_6[var1++] = 9;
            var0 = var0.substring(5);
         }

         String var2 = "";

         for(int var3 = 0; var3 < var0.length(); ++var3) {
            char var4 = var0.charAt(var3);
            if ((var4 < 'a' || var4 > 'z') && (var4 < '0' || var4 > '9') && var4 != '\'') {
               int var5 = method_22(var4);
               int var6;
               if (var2.length() > 0) {
                  for(var6 = 0; var6 < field_4; ++var6) {
                     if (var2.equals(field_5[var6])) {
                        if (var5 == 36 && var6 < 165) {
                           field_6[var1++] = (byte)(var6 + 90);
                           var5 = -1;
                        } else if (var5 == 36) {
                           field_6[var1++] = (byte)(var6 / 256 + 50);
                           field_6[var1++] = (byte)(var6 & 255);
                           var5 = -1;
                        } else {
                           field_6[var1++] = (byte)(var6 / 256 + 70);
                           field_6[var1++] = (byte)(var6 & 255);
                        }

                        var2 = "";
                        break;
                     }
                  }
               }

               for(var6 = 0; var6 < var2.length(); ++var6) {
                  field_6[var1++] = (byte)method_22(var2.charAt(var6));
               }

               var2 = "";
               if (var5 != -1 && var3 < var0.length() - 1) {
                  field_6[var1++] = (byte)var5;
               }
            } else {
               var2 = var2 + var4;
            }
         }
      } catch (Exception var7) {
         ;
      }

      return var1;
   }

   // $FF: renamed from: xb (char) int
   private static int method_22(char var0) {
      if (var0 >= 'a' && var0 <= 'z') {
         return var0 - 97;
      } else if (var0 >= '0' && var0 <= '9') {
         return var0 + 26 - 48;
      } else if (var0 == ' ') {
         return 36;
      } else if (var0 == '!') {
         return 37;
      } else if (var0 == '?') {
         return 38;
      } else if (var0 == '.') {
         return 39;
      } else if (var0 == ',') {
         return 40;
      } else if (var0 == ':') {
         return 41;
      } else if (var0 == ';') {
         return 42;
      } else if (var0 == '(') {
         return 43;
      } else if (var0 == ')') {
         return 44;
      } else if (var0 == '-') {
         return 45;
      } else if (var0 == '&') {
         return 46;
      } else if (var0 == '*') {
         return 47;
      } else if (var0 == '\\') {
         return 48;
      } else {
         return var0 == '\'' ? 49 : 36;
      }
   }

   // $FF: renamed from: oc (byte[], int, int, boolean) java.lang.String
   public static String method_23(byte[] var0, int var1, int var2, boolean var3) {
      try {
         String var4 = "";
         String var5 = "";

         int var7;
         for(int var6 = var1; var6 < var1 + var2; ++var6) {
            var7 = var0[var6] & 255;
            if (var7 < 50) {
               var4 = var4 + field_8[var7];
            } else if (var7 < 70) {
               ++var6;
               var4 = var4 + field_5[(var7 - 50) * 256 + (var0[var6] & 255)] + " ";
            } else if (var7 < 90) {
               ++var6;
               var4 = var4 + field_5[(var7 - 70) * 256 + (var0[var6] & 255)];
            } else if (var7 < 255) {
               var4 = var4 + field_5[var7 - 90] + " ";
            } else {
               ++var6;
               var7 = var0[var6] & 255;
               if (var7 == 0) {
                  var5 = "@red@";
               }

               if (var7 == 1) {
                  var5 = "@gre@";
               }

               if (var7 == 2) {
                  var5 = "@blu@";
               }

               if (var7 == 3) {
                  var5 = "@cya@";
               }

               if (var7 == 4) {
                  var5 = "@ran@";
               }

               if (var7 == 5) {
                  var5 = "@whi@";
               }

               if (var7 == 6) {
                  var5 = "@bla@";
               }

               if (var7 == 7) {
                  var5 = "@ora@";
               }

               if (var7 == 8) {
                  var5 = "@yel@";
               }

               if (var7 == 9) {
                  var5 = "@mag@";
               }
            }
         }

         if (var3) {
            for(var7 = 0; var7 < 2; ++var7) {
               String var8 = var4;
               var4 = method_24(var4);
               if (var4.equals(var8)) {
                  break;
               }
            }
         }

         if (var4.length() > 80) {
            var4 = var4.substring(0, 80);
         }

         var4 = var4.toLowerCase();
         String var12 = var5;
         boolean var13 = true;

         for(int var9 = 0; var9 < var4.length(); ++var9) {
            char var10 = var4.charAt(var9);
            if (var10 >= 'a' && var10 <= 'z' && var13) {
               var13 = false;
               var10 = (char)(var10 + 65 - 97);
            }

            if (var10 == '.' || var10 == '!' || var10 == '?') {
               var13 = true;
            }

            var12 = var12 + var10;
         }

         return var12;
      } catch (Exception var11) {
         return "eep!";
      }
   }

   // $FF: renamed from: wb (java.lang.String) java.lang.String
   private static String method_24(String var0) {
      try {
         int var1 = var0.length();
         var0.toLowerCase().getChars(0, var1, field_7, 0);

         for(int var2 = 0; var2 < var1; ++var2) {
            char var3 = field_7[var2];

            for(int var4 = 0; var4 < field_2; ++var4) {
               String var5 = field_3[var4];
               char var6 = var5.charAt(0);
               if (method_25(var6, var3, 0)) {
                  int var7 = 1;
                  int var8 = var5.length();
                  char var9 = var5.charAt(1);
                  int var10 = 0;
                  if (var8 >= 6) {
                     var10 = 1;
                  }

                  for(int var11 = var2 + 1; var11 < var1; ++var11) {
                     char var12 = field_7[var11];
                     if (method_25(var9, var12, var8)) {
                        ++var7;
                        if (var7 >= var8) {
                           boolean var13 = false;

                           for(int var14 = var2; var14 <= var11; ++var14) {
                              if (var0.charAt(var14) >= 'A' && var0.charAt(var14) <= 'Z') {
                                 var13 = true;
                                 break;
                              }
                           }

                           if (!var13) {
                              break;
                           }

                           String var15 = "";

                           for(int var16 = 0; var16 < var0.length(); ++var16) {
                              char var17 = var0.charAt(var16);
                              if (var16 < var2 || var16 > var11 || var17 == ' ' || var17 >= 'a' && var17 <= 'z') {
                                 var15 = var15 + var17;
                              } else {
                                 var15 = var15 + "*";
                              }
                           }

                           var0 = var15;
                           break;
                        }

                        var6 = var9;
                        var9 = var5.charAt(var7);
                     } else if (!method_26(var6, var12, var8)) {
                        --var10;
                        if (var10 < 0) {
                           break;
                        }
                     }
                  }
               }
            }
         }

         return var0;
      } catch (Exception var18) {
         return "wibble!";
      }
   }

   // $FF: renamed from: lc (char, char, int) boolean
   private static boolean method_25(char var0, char var1, int var2) {
      if (var0 == var1) {
         return true;
      } else if (var0 != 'i' || var1 != 'y' && var1 != '1' && var1 != '!' && var1 != ':' && var1 != ';') {
         if (var0 == 's' && (var1 == '5' || var1 == 'z')) {
            return true;
         } else if (var0 == 'e' && var1 == '3') {
            return true;
         } else if (var0 == 'a' && var1 == '4') {
            return true;
         } else if (var0 != 'o' || var1 != '0' && var1 != '*') {
            if (var0 == 'u' && var1 == 'v') {
               return true;
            } else if (var0 == 'c' && (var1 == '(' || var1 == 'k')) {
               return true;
            } else if (var0 != 'k' || var1 != '(' && var1 != 'c') {
               if (var0 == 'w' && var1 == 'v') {
                  return true;
               } else {
                  return var2 >= 4 && var0 == 'i' && var1 == 'l';
               }
            } else {
               return true;
            }
         } else {
            return true;
         }
      } else {
         return true;
      }
   }

   // $FF: renamed from: dc (char, char, int) boolean
   private static boolean method_26(char var0, char var1, int var2) {
      if (var0 == var1) {
         return true;
      } else if (var1 < 'a' || var1 > 'u' && var1 != 'y') {
         return true;
      } else if (var0 == 'i' && var1 == 'y') {
         return true;
      } else if (var0 == 'c' && var1 == 'k') {
         return true;
      } else if (var0 == 'k' && var1 == 'c') {
         return true;
      } else {
         return var2 >= 5 && (var0 == 'a' || var0 == 'e' || var0 == 'i' || var0 == 'o' || var0 == 'u' || var0 == 'y') && (var1 == 'a' || var1 == 'e' || var1 == 'i' || var1 == 'o' || var1 == 'u' || var1 == 'y');
      }
   }

   public class_0() {
      super();
   }
}
