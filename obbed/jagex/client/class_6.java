package jagex.client;

import jagex.class_0;
import java.applet.Applet;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.io.IOException;
import java.math.BigInteger;

// $FF: renamed from: jagex.client.g
public class class_6 extends class_5 {
   // $FF: renamed from: tf java.lang.String[]
   public static String[] field_150 = new String[50];
   // $FF: renamed from: uf int
   public static int field_151 = 1;
   // $FF: renamed from: vf int
   public static int field_152;
   // $FF: renamed from: wf java.lang.String
   public String field_153 = "127.0.0.1";
   // $FF: renamed from: xf int
   public int field_154 = 43594;
   // $FF: renamed from: yf java.lang.String
   String field_155 = "";
   // $FF: renamed from: zf java.lang.String
   String field_156 = "";
   // $FF: renamed from: ag jagex.client.b
   public class_16 field_157;
   // $FF: renamed from: bg byte[]
   byte[] field_158 = new byte[5000];
   // $FF: renamed from: cg int
   int field_159;
   // $FF: renamed from: dg long
   long field_160;
   // $FF: renamed from: eg int
   public int field_161;
   // $FF: renamed from: fg long[]
   public long[] field_162 = new long[100];
   // $FF: renamed from: gg int[]
   public int[] field_163 = new int[100];
   // $FF: renamed from: hg int
   public int field_164;
   // $FF: renamed from: ig long[]
   public long[] field_165 = new long[50];
   // $FF: renamed from: jg int
   public int field_166;
   // $FF: renamed from: kg int
   public int field_167;
   // $FF: renamed from: lg int
   public int field_168;
   // $FF: renamed from: mg int
   public int field_169;
   // $FF: renamed from: ng java.math.BigInteger
   public BigInteger field_170;
   // $FF: renamed from: og java.math.BigInteger
   public BigInteger field_171;
   // $FF: renamed from: pg int
   public int field_172;
   // $FF: renamed from: qg int
   public int field_173;

   // $FF: renamed from: ve (java.math.BigInteger, java.math.BigInteger) void
   public void method_138(BigInteger var1, BigInteger var2) {
      this.field_170 = var1;
      this.field_171 = var2;
   }

   // $FF: renamed from: gf () int
   public int method_139() {
      try {
         String var1 = this.getParameter("ranseed");
         String var2 = var1.substring(0, 10);
         int var3 = Integer.parseInt(var2);
         if (var3 == 987654321) {
            byte[] var4 = new byte[4];
            class_0.method_1("uid.dat", var4, 4);
            var3 = class_0.method_6(var4, 0);
         }

         return var3;
      } catch (Exception var5) {
         return 0;
      }
   }

   // $FF: renamed from: ff (java.lang.String, java.lang.String, boolean) void
   public void method_140(String var1, String var2, boolean var3) {
      if (this.field_173 > 0) {
         this.method_157(field_150[6], field_150[7]);

         try {
            Thread.sleep(2000L);
         } catch (Exception var7) {
            ;
         }

         this.method_157(field_150[8], field_150[9]);
      } else {
         try {
            this.field_155 = var1;
            var1 = class_0.method_11(var1, 20);
            this.field_156 = var2;
            var2 = class_0.method_11(var2, 20);
            if (var1.trim().length() == 0) {
               this.method_157(field_150[0], field_150[1]);
            } else {
               if (var3) {
                  this.method_143(field_150[2], field_150[3]);
               } else {
                  this.method_157(field_150[6], field_150[7]);
               }

               if (this.method_122()) {
                  this.field_157 = new class_16(this.field_153, this, this.field_154);
               } else {
                  this.field_157 = new class_16(this.field_153, (Applet)null, this.field_154);
               }

               this.field_157.field_566 = field_152;
               int var4 = this.field_157.method_346();
               this.field_172 = var4;
               System.out.println("Session id: " + var4);
               if (var3) {
                  this.field_157.method_358(19);
               } else {
                  this.field_157.method_358(0);
               }

               this.field_157.method_350(field_151);
               this.field_157.method_353(class_0.method_14(var1));
               this.field_157.method_357(var2, var4, this.field_170, this.field_171);
               this.field_157.method_352(this.method_139());
               this.field_157.method_360();
               this.field_157.method_339();
               int var5 = this.field_157.method_339();
               System.out.println("Login response: " + var5);
               if (var5 == 0) {
                  this.field_159 = 0;
                  this.method_159();
               } else if (var5 == 1) {
                  this.field_159 = 0;
                  this.method_158();
               } else if (var3) {
                  var1 = "";
                  var2 = "";
                  this.method_160();
               } else if (var5 == 3) {
                  this.method_157(field_150[10], field_150[11]);
               } else if (var5 == 4) {
                  this.method_157(field_150[4], field_150[5]);
               } else if (var5 == 5) {
                  this.method_157(field_150[16], field_150[17]);
               } else if (var5 == 6) {
                  this.method_157(field_150[18], field_150[19]);
               } else if (var5 == 7) {
                  this.method_157(field_150[20], field_150[21]);
               } else if (var5 == 11) {
                  this.method_157(field_150[22], field_150[23]);
               } else if (var5 == 12) {
                  this.method_157(field_150[24], field_150[25]);
               } else if (var5 == 13) {
                  this.method_157(field_150[14], field_150[15]);
               } else if (var5 == 14) {
                  this.method_157(field_150[8], field_150[9]);
                  this.field_173 = 1500;
               } else if (var5 == 15) {
                  this.method_157(field_150[26], field_150[27]);
               } else if (var5 == 16) {
                  this.method_157(field_150[28], field_150[29]);
               } else {
                  this.method_157(field_150[12], field_150[13]);
               }
            }
         } catch (Exception var8) {
            System.out.println(String.valueOf(var8));
            if (this.field_159 > 0) {
               try {
                  Thread.sleep(5000L);
               } catch (Exception var6) {
                  ;
               }

               --this.field_159;
               this.method_140(this.field_155, this.field_156, var3);
            }

            if (var3) {
               this.field_155 = "";
               this.field_156 = "";
               this.method_160();
            } else {
               this.method_157(field_150[12], field_150[13]);
            }

         }
      }
   }

   // $FF: renamed from: oe () void
   public void method_141() {
      if (this.field_157 != null) {
         try {
            this.field_157.method_358(1);
            this.field_157.method_360();
         } catch (IOException var1) {
            ;
         }
      }

      this.field_155 = "";
      this.field_156 = "";
      this.method_160();
   }

   // $FF: renamed from: ef () void
   public void method_142() {
      System.out.println("Lost connection");
      this.field_159 = 10;
      this.method_140(this.field_155, this.field_156, true);
   }

   // $FF: renamed from: he (java.lang.String, java.lang.String) void
   public void method_143(String var1, String var2) {
      Graphics var3 = this.getGraphics();
      Font var4 = new Font("Helvetica", 1, 15);
      int var5 = this.method_123();
      int var6 = this.method_124();
      var3.setColor(Color.black);
      var3.fillRect(var5 / 2 - 140, var6 / 2 - 25, 280, 50);
      var3.setColor(Color.white);
      var3.drawRect(var5 / 2 - 140, var6 / 2 - 25, 280, 50);
      this.method_135(var3, var1, var4, var5 / 2, var6 / 2 - 10);
      this.method_135(var3, var2, var4, var5 / 2, var6 / 2 + 10);
   }

   // $FF: renamed from: we (java.lang.String, java.lang.String) void
   public void method_144(String var1, String var2) {
      if (this.field_173 > 0) {
         this.method_157(field_150[6], field_150[7]);

         try {
            Thread.sleep(2000L);
         } catch (Exception var5) {
            ;
         }

         this.method_157(field_150[8], field_150[9]);
      } else {
         try {
            var1 = class_0.method_11(var1, 20);
            var2 = class_0.method_11(var2, 20);
            this.method_157(field_150[6], field_150[7]);
            if (this.method_122()) {
               this.field_157 = new class_16(this.field_153, this, this.field_154);
            } else {
               this.field_157 = new class_16(this.field_153, (Applet)null, this.field_154);
            }

            int var3 = this.field_157.method_346();
            this.field_172 = var3;
            System.out.println("Session id: " + var3);
            this.field_157.method_358(2);
            this.field_157.method_350(field_151);
            this.field_157.method_353(class_0.method_14(var1));
            this.field_157.method_357(var2, var3, this.field_170, this.field_171);
            this.field_157.method_352(this.method_139());
            this.field_157.method_360();
            this.field_157.method_339();
            int var4 = this.field_157.method_339();
            this.field_157.method_338();
            System.out.println("Newplayer response: " + var4);
            if (var4 == 2) {
               this.method_162();
            } else if (var4 == 3) {
               this.method_157(field_150[14], field_150[15]);
            } else if (var4 == 4) {
               this.method_157(field_150[4], field_150[5]);
            } else if (var4 == 5) {
               this.method_157(field_150[16], field_150[17]);
            } else if (var4 == 6) {
               this.method_157(field_150[18], field_150[19]);
            } else if (var4 == 7) {
               this.method_157(field_150[20], field_150[21]);
            } else if (var4 == 11) {
               this.method_157(field_150[22], field_150[23]);
            } else if (var4 == 12) {
               this.method_157(field_150[24], field_150[25]);
            } else if (var4 == 13) {
               this.method_157(field_150[14], field_150[15]);
            } else if (var4 == 14) {
               this.method_157(field_150[8], field_150[9]);
               this.field_173 = 1500;
            } else if (var4 == 15) {
               this.method_157(field_150[26], field_150[27]);
            } else if (var4 == 16) {
               this.method_157(field_150[28], field_150[29]);
            } else {
               this.method_157(field_150[12], field_150[13]);
            }
         } catch (Exception var6) {
            System.out.println(String.valueOf(var6));
            this.method_157(field_150[12], field_150[13]);
         }
      }
   }

   // $FF: renamed from: je () void
   public void method_145() {
      long var1 = System.currentTimeMillis();
      if (this.field_157.method_362()) {
         this.field_160 = var1;
      }

      if (var1 - this.field_160 > 5000L) {
         this.field_160 = var1;
         this.field_157.method_358(5);
         this.field_157.method_359();
      }

      try {
         this.field_157.method_361(20);
      } catch (IOException var4) {
         this.method_142();
         return;
      }

      if (this.method_165()) {
         int var3 = this.field_157.method_348(this.field_158);
         if (var3 > 0) {
            this.method_146(this.field_158[0] & 255, var3);
         }

      }
   }

   // $FF: renamed from: ne (int, int) void
   public void method_146(int var1, int var2) {
      if (var1 == 8) {
         String var3 = new String(this.field_158, 1, var2 - 1);
         this.method_164(var3);
      }

      if (var1 == 9) {
         this.method_141();
      }

      if (var1 == 10) {
         this.method_161();
      } else {
         int var8;
         if (var1 == 23) {
            this.field_161 = class_0.method_4(this.field_158[1]);

            for(var8 = 0; var8 < this.field_161; ++var8) {
               this.field_162[var8] = class_0.method_7(this.field_158, 2 + var8 * 9);
               this.field_163[var8] = class_0.method_4(this.field_158[10 + var8 * 9]);
            }

            this.method_147();
         } else {
            long var9;
            if (var1 == 24) {
               var9 = class_0.method_7(this.field_158, 1);
               int var10 = this.field_158[9] & 255;

               for(int var6 = 0; var6 < this.field_161; ++var6) {
                  if (this.field_162[var6] == var9) {
                     if (this.field_163[var6] == 0 && var10 != 0) {
                        this.method_164("@pri@" + class_0.method_15(var9) + " has logged in");
                     }

                     if (this.field_163[var6] != 0 && var10 == 0) {
                        this.method_164("@pri@" + class_0.method_15(var9) + " has logged out");
                     }

                     this.field_163[var6] = var10;
                     boolean var7 = false;
                     this.method_147();
                     return;
                  }
               }

               this.field_162[this.field_161] = var9;
               this.field_163[this.field_161] = var10;
               ++this.field_161;
               this.method_164("@pri@" + class_0.method_15(var9) + " has been added to your friends list");
               this.method_147();
            } else if (var1 != 26) {
               if (var1 == 27) {
                  this.field_166 = this.field_158[1];
                  this.field_167 = this.field_158[2];
                  this.field_168 = this.field_158[3];
                  this.field_169 = this.field_158[4];
               } else if (var1 == 28) {
                  var9 = class_0.method_7(this.field_158, 1);
                  String var5 = class_0.method_23(this.field_158, 9, var2 - 9, true);
                  this.method_164("@pri@" + class_0.method_15(var9) + ": tells you " + var5);
               } else {
                  this.method_163(var1, var2, this.field_158);
               }
            } else {
               this.field_164 = class_0.method_4(this.field_158[1]);

               for(var8 = 0; var8 < this.field_164; ++var8) {
                  this.field_165[var8] = class_0.method_7(this.field_158, 2 + var8 * 8);
               }

            }
         }
      }
   }

   // $FF: renamed from: ze () void
   public void method_147() {
      boolean var1 = true;

      while(var1) {
         var1 = false;

         for(int var2 = 0; var2 < this.field_161 - 1; ++var2) {
            if (this.field_163[var2] < this.field_163[var2 + 1]) {
               int var3 = this.field_163[var2];
               this.field_163[var2] = this.field_163[var2 + 1];
               this.field_163[var2 + 1] = var3;
               long var4 = this.field_162[var2];
               this.field_162[var2] = this.field_162[var2 + 1];
               this.field_162[var2 + 1] = var4;
               var1 = true;
            }
         }
      }

   }

   // $FF: renamed from: xe (java.lang.String, java.lang.String) void
   public void method_148(String var1, String var2) {
      var1 = class_0.method_11(var1, 20);
      var2 = class_0.method_11(var2, 20);
      this.field_157.method_358(25);
      this.field_157.method_357(var1 + var2, this.field_172, this.field_170, this.field_171);
      this.field_157.method_359();
   }

   // $FF: renamed from: qe (int, int, int, int) void
   public void method_149(int var1, int var2, int var3, int var4) {
      this.field_157.method_358(31);
      this.field_157.method_349(var1);
      this.field_157.method_349(var2);
      this.field_157.method_349(var3);
      this.field_157.method_349(var4);
      this.field_157.method_359();
   }

   // $FF: renamed from: ue (java.lang.String) void
   public void method_150(String var1) {
      long var2 = class_0.method_14(var1);
      this.field_157.method_358(29);
      this.field_157.method_353(var2);
      this.field_157.method_359();

      for(int var4 = 0; var4 < this.field_164; ++var4) {
         if (this.field_165[var4] == var2) {
            return;
         }
      }

      if (this.field_164 < 50) {
         this.field_165[this.field_164++] = var2;
      }
   }

   // $FF: renamed from: hf (long) void
   public void method_151(long var1) {
      this.field_157.method_358(30);
      this.field_157.method_353(var1);
      this.field_157.method_359();

      for(int var3 = 0; var3 < this.field_164; ++var3) {
         if (this.field_165[var3] == var1) {
            --this.field_164;

            for(int var4 = var3; var4 < this.field_164; ++var4) {
               this.field_165[var4] = this.field_165[var4 + 1];
            }

            return;
         }
      }

   }

   // $FF: renamed from: cf (java.lang.String) void
   public void method_152(String var1) {
      this.field_157.method_358(26);
      this.field_157.method_353(class_0.method_14(var1));
      this.field_157.method_359();
   }

   // $FF: renamed from: le (long) void
   public void method_153(long var1) {
      this.field_157.method_358(27);
      this.field_157.method_353(var1);
      this.field_157.method_359();

      label23:
      for(int var3 = 0; var3 < this.field_161; ++var3) {
         if (this.field_162[var3] == var1) {
            --this.field_161;
            int var4 = var3;

            while(true) {
               if (var4 >= this.field_161) {
                  break label23;
               }

               this.field_162[var4] = this.field_162[var4 + 1];
               this.field_163[var4] = this.field_163[var4 + 1];
               ++var4;
            }
         }
      }

      this.method_164("@pri@" + class_0.method_15(var1) + " has been removed from your friends list");
   }

   // $FF: renamed from: df (long, byte[], int) void
   public void method_154(long var1, byte[] var3, int var4) {
      this.field_157.method_358(28);
      this.field_157.method_353(var1);
      this.field_157.method_355(var3, 0, var4);
      this.field_157.method_359();
   }

   // $FF: renamed from: ke (byte[], int) void
   public void method_155(byte[] var1, int var2) {
      this.field_157.method_358(3);
      this.field_157.method_355(var1, 0, var2);
      this.field_157.method_359();
   }

   // $FF: renamed from: ie (java.lang.String) void
   public void method_156(String var1) {
      this.field_157.method_358(7);
      this.field_157.method_354(var1);
      this.field_157.method_359();
   }

   // $FF: renamed from: bf (java.lang.String, java.lang.String) void
   public void method_157(String var1, String var2) {
   }

   // $FF: renamed from: af () void
   public void method_158() {
   }

   // $FF: renamed from: ge () void
   public void method_159() {
   }

   // $FF: renamed from: se () void
   public void method_160() {
   }

   // $FF: renamed from: ye () void
   public void method_161() {
   }

   // $FF: renamed from: re () void
   public void method_162() {
   }

   // $FF: renamed from: pe (int, int, byte[]) void
   public void method_163(int var1, int var2, byte[] var3) {
   }

   // $FF: renamed from: te (java.lang.String) void
   public void method_164(String var1) {
   }

   // $FF: renamed from: me () boolean
   public boolean method_165() {
      return true;
   }

   public class_6() {
      super();
   }

   static {
      field_150[0] = "You must enter both a username";
      field_150[1] = "and a password - Please try again";
      field_150[2] = "Connection lost! Please wait...";
      field_150[3] = "Attempting to re-establish";
      field_150[4] = "That username is already in use.";
      field_150[5] = "Wait 60 seconds then retry";
      field_150[6] = "Please wait...";
      field_150[7] = "Connecting to server";
      field_150[8] = "Sorry! The server is currently full.";
      field_150[9] = "Please try again later";
      field_150[10] = "Invalid username or password.";
      field_150[11] = "Try again, or create a new account";
      field_150[12] = "Sorry! Unable to connect to server.";
      field_150[13] = "Check your internet settings";
      field_150[14] = "Username already taken.";
      field_150[15] = "Please choose another username";
      field_150[16] = "The client has been updated.";
      field_150[17] = "Please reload this page";
      field_150[18] = "You may only use 1 character at once.";
      field_150[19] = "Your ip-address is already in use";
      field_150[20] = "Login attempts exceeded!";
      field_150[21] = "Please try again in 5 minutes";
      field_150[22] = "Account has been temporarily disabled";
      field_150[23] = "for cheating or abuse";
      field_150[24] = "Account has been permanently disabled";
      field_150[25] = "for cheating or abuse";
      field_150[26] = "You need a members account";
      field_150[27] = "to login to this server";
      field_150[28] = "Please login to a members server";
      field_150[29] = "to access member-only features";
   }
}
