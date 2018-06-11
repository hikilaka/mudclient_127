import jagex.class_0;
import jagex.client.class_1;
import jagex.client.class_16;
import jagex.client.class_17;
import jagex.client.class_18;
import jagex.client.class_6;
import jagex.client.class_8;
import jagex.client.class_9;
import java.applet.Applet;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.io.IOException;
import java.math.BigInteger;
import java.net.InetAddress;

public class mudclient extends class_6 {
   // $FF: renamed from: qy boolean
   public boolean field_174 = false;
   // $FF: renamed from: ry java.lang.String
   public static String field_175 = "";
   // $FF: renamed from: sy java.math.BigInteger
   public BigInteger field_176 = new BigInteger("18439792161837834709");
   // $FF: renamed from: ty java.math.BigInteger
   public BigInteger field_177 = new BigInteger("192956484481579778191558061814292671521");
   // $FF: renamed from: uy int
   int field_178;
   // $FF: renamed from: vy boolean
   boolean field_179 = false;
   // $FF: renamed from: wy boolean
   boolean field_180 = false;
   // $FF: renamed from: xy boolean
   public boolean field_181 = true;
   // $FF: renamed from: yy int
   int field_182;
   // $FF: renamed from: zy int
   int field_183 = 12345678;
   // $FF: renamed from: az int
   int field_184;
   // $FF: renamed from: bz int
   int field_185 = 8000;
   // $FF: renamed from: cz int[]
   int[] field_186;
   // $FF: renamed from: dz int[]
   int[] field_187;
   // $FF: renamed from: ez int
   int field_188;
   // $FF: renamed from: fz int[]
   int[] field_189;
   // $FF: renamed from: gz int[]
   int[] field_190;
   // $FF: renamed from: hz int
   int field_191;
   // $FF: renamed from: iz int
   int field_192;
   // $FF: renamed from: jz int
   int field_193;
   // $FF: renamed from: kz int
   int field_194;
   // $FF: renamed from: lz int
   int field_195;
   // $FF: renamed from: mz java.awt.Graphics
   Graphics field_196;
   // $FF: renamed from: nz jagex.client.a
   class_17 field_197;
   // $FF: renamed from: oz h
   class_2 field_198;
   // $FF: renamed from: pz int
   int field_199;
   // $FF: renamed from: qz int
   int field_200;
   // $FF: renamed from: rz int
   int field_201;
   // $FF: renamed from: sz int
   int field_202;
   // $FF: renamed from: tz int
   int field_203;
   // $FF: renamed from: uz int
   int field_204;
   // $FF: renamed from: vz int
   int field_205;
   // $FF: renamed from: wz int
   int field_206;
   // $FF: renamed from: xz int
   int field_207;
   // $FF: renamed from: yz int
   int field_208;
   // $FF: renamed from: zz int
   int field_209;
   int aab;
   int bab;
   int cab;
   int dab;
   int eab;
   int fab;
   int gab;
   int hab;
   int iab;
   int jab;
   class_3 kab;
   int lab;
   int mab;
   int nab;
   int oab;
   int pab;
   int qab;
   int rab;
   int sab;
   int tab;
   int uab;
   int vab;
   int wab;
   int xab;
   int yab;
   int zab;
   boolean abb;
   int bbb;
   int cbb;
   int dbb;
   int ebb;
   int fbb;
   int gbb;
   int hbb;
   int ibb;
   int jbb;
   int kbb;
   int lbb;
   class_13[] mbb;
   class_13[] nbb;
   class_13[] obb;
   class_13 pbb;
   int qbb;
   int rbb;
   int sbb;
   int tbb;
   int ubb;
   int vbb;
   int wbb;
   class_13[] xbb;
   class_13[] ybb;
   class_13[] zbb;
   int[] acb;
   int bcb;
   int ccb;
   int[] dcb;
   int[] ecb;
   int[] fcb;
   int[] gcb;
   int hcb;
   int icb;
   class_8[] jcb;
   int[] kcb;
   int[] lcb;
   int[] mcb;
   int[] ncb;
   class_8[] ocb;
   boolean[] pcb;
   int qcb;
   int rcb;
   class_8[] scb;
   int[] tcb;
   int[] ucb;
   int[] vcb;
   int[] wcb;
   boolean[] xcb;
   int ycb;
   int zcb;
   int adb;
   int[] bdb;
   int[] cdb;
   int[] ddb;
   int edb;
   String fdb;
   int[] gdb;
   int[] hdb;
   int[] idb;
   int[] jdb;
   int[] kdb;
   int ldb;
   String[] mdb;
   String[] ndb;
   class_9 odb;
   int pdb;
   int qdb;
   int rdb;
   class_9 sdb;
   int tdb;
   int udb;
   long vdb;
   class_9 wdb;
   int xdb;
   int ydb;
   int zdb;
   String[] aeb;
   boolean[] beb;
   boolean[] ceb;
   boolean deb;
   boolean eeb;
   boolean feb;
   boolean geb;
   boolean heb;
   int ieb;
   int jeb;
   int keb;
   int leb;
   int meb;
   int neb;
   String[] oeb;
   String[] peb;
   int[] qeb;
   int[] reb;
   int[] seb;
   int[] teb;
   int[] ueb;
   int[] veb;
   int[] web;
   int xeb;
   int yeb;
   int zeb;
   int afb;
   class_9 bfb;
   int cfb;
   int dfb;
   int efb;
   int ffb;
   int gfb;
   int hfb;
   String[] ifb;
   int[] jfb;
   boolean kfb;
   String lfb;
   int mfb;
   int[] nfb;
   int[] ofb;
   int pfb;
   int[] qfb;
   int[] rfb;
   boolean sfb;
   boolean tfb;
   boolean ufb;
   boolean vfb;
   boolean wfb;
   boolean xfb;
   boolean yfb;
   boolean zfb;
   long agb;
   int bgb;
   int[] cgb;
   int[] dgb;
   int egb;
   int[] fgb;
   int[] ggb;
   int hgb;
   int igb;
   int jgb;
   int kgb;
   boolean lgb;
   String mgb;
   int ngb;
   int[] ogb;
   int[] pgb;
   int qgb;
   int[] rgb;
   int[] sgb;
   boolean tgb;
   boolean ugb;
   int vgb;
   int wgb;
   long xgb;
   boolean ygb;
   boolean zgb;
   int ahb;
   int[] bhb;
   int[] chb;
   int dhb;
   int[] ehb;
   int[] fhb;
   boolean ghb;
   int hhb;
   int ihb;
   int[] jhb;
   int[] khb;
   int[] lhb;
   int mhb;
   int nhb;
   boolean ohb;
   int phb;
   int[] qhb;
   int[] rhb;
   int shb;
   int[] thb;
   int[] uhb;
   int vhb;
   int whb;
   int xhb;
   int yhb;
   boolean zhb;
   int aib;
   String[] bib;
   int cib;
   int dib;
   int eib;
   String fib;
   String gib;
   boolean hib;
   boolean iib;
   int jib;
   String kib;
   int lib;
   int mib;
   int nib;
   boolean oib;
   String pib;
   int qib;
   int rib;
   int sib;
   int tib;
   boolean uib;
   int vib;
   class_9 wib;
   int xib;
   int yib;
   class_9 zib;
   int ajb;
   int bjb;
   int cjb;
   int djb;
   int ejb;
   int fjb;
   int gjb;
   int hjb;
   class_9 ijb;
   int jjb;
   int kjb;
   int ljb;
   int mjb;
   int njb;
   int ojb;
   int pjb;
   int qjb;
   String rjb;
   String sjb;
   String tjb;
   String ujb;
   class_9 vjb;
   int wjb;
   int xjb;
   int yjb;
   int zjb;
   int akb;
   int bkb;
   int ckb;
   int dkb;
   int ekb;
   int fkb;
   int gkb;
   int hkb;
   int ikb;
   int jkb;
   int kkb;
   boolean lkb;
   class_9 mkb;
   int nkb;
   int okb;
   int pkb;
   int[] qkb;
   int[] rkb;
   int[] skb;
   int[] tkb;
   int[] ukb;
   String[] vkb;
   boolean wkb;
   class_9 xkb;
   int ykb;
   int zkb;
   int alb;
   int blb;
   int clb;
   int dlb;
   int elb;
   int flb;
   int glb;
   int hlb;
   int[] ilb;
   int[] jlb;
   int klb;
   String[] llb;
   int[] mlb;
   int[] nlb;
   int[] olb;
   int[] plb;
   int qlb;
   int[] rlb;
   int[] slb;
   int[] tlb;
   int[] ulb;
   int vlb;
   int[] wlb;
   int[] xlb;
   int[] ylb;
   int zlb;
   int amb;
   int[][] bmb;
   boolean cmb;
   int dmb;
   int emb;
   int fmb;
   int gmb;
   int hmb;
   int imb;
   int jmb;
   int kmb;
   public int[] lmb;
   public int[] mmb;
   public int[] nmb;
   int[] omb;
   int[] pmb;
   int[] qmb;
   byte[] rmb;
   class_18 smb;
   int tmb;
   int[] umb;
   int[] vmb;
   int[] wmb;
   int[] xmb;
   String[] ymb;

   // $FF: renamed from: jn (java.lang.String[]) void
   public static void method_166(String[] var0) {
      mudclient var1 = new mudclient();
      var1.field_181 = false;
      field_175 = "../release/";
      var1.method_121(var1.field_202, var1.field_203 + 11, "Runescape by Andrew Gower", false);
      var1.field_138 = 10;
   }

   // $FF: renamed from: ui () void
   public void method_116() {
      if (this.field_181) {
         String var1 = this.getDocumentBase().getHost().toLowerCase();
         if (!var1.endsWith("jagex.com") && !var1.endsWith("jagex.co.uk") && !var1.endsWith("runescape.com") && !var1.endsWith("runescape.co.uk") && !var1.endsWith("runescape.net") && !var1.endsWith("runescape.org") && !var1.endsWith("penguin") && !var1.endsWith("puffin")) {
            this.field_179 = true;
            return;
         }
      }

      this.method_138(this.field_176, this.field_177);
      int var7 = 0;

      int var3;
      int var4;
      for(int var2 = 0; var2 < 99; ++var2) {
         var3 = var2 + 1;
         var4 = (int)((double)var3 + 300.0D * Math.pow(2.0D, (double)var3 / 7.0D));
         var7 += var4;
         this.gdb[var2] = var7 & 268435452;
      }

      String var8;
      try {
         var8 = this.getParameter("member");
         var4 = Integer.parseInt(var8);
         if (var4 == 1) {
            this.field_174 = true;
         }
      } catch (Exception var6) {
         ;
      }

      if (!this.field_181) {
         this.field_174 = true;
      }

      super.field_154 = 43594;
      super.field_118 = 0;
      class_6.field_152 = 1000;
      class_6.field_151 = class_10.field_393;

      try {
         var8 = this.getParameter("poff");
         var4 = Integer.parseInt(var8);
         super.field_154 += var4;
         System.out.println("Offset: " + var4);
      } catch (Exception var5) {
         ;
      }

      this.method_167();
      this.field_205 = 2000;
      this.field_206 = this.field_205 + 100;
      this.field_207 = this.field_206 + 50;
      this.field_208 = this.field_207 + 300;
      this.field_209 = 2510;
      this.aab = this.field_209 + 10;
      this.field_196 = this.getGraphics();
      this.method_126(50);
      this.field_198 = new class_2(this.field_202, this.field_203 + 12, 2700, this);
      this.field_198.field_65 = this;
      this.field_198.method_29(0, 0, this.field_202, this.field_203 + 12);
      class_9.field_386 = false;
      class_9.field_387 = this.field_206;
      this.odb = new class_9(this.field_198, 5);
      var3 = this.field_198.field_10 - 199;
      byte var9 = 36;
      this.pdb = this.odb.method_306(var3, var9 + 24, 196, 90, 1, 500, true);
      this.sdb = new class_9(this.field_198, 5);
      this.tdb = this.sdb.method_306(var3, var9 + 40, 196, 126, 1, 500, true);
      this.wdb = new class_9(this.field_198, 5);
      this.xdb = this.wdb.method_306(var3, var9 + 24, 196, 226, 1, 500, true);
      this.method_168();
      this.method_169();
      this.field_197 = new class_17(this.field_198, 15000, 15000, 1000);
      this.field_197.method_375(this.field_202 / 2, this.field_203 / 2, this.field_202 / 2, this.field_203 / 2, this.field_202, this.field_204);
      this.field_197.field_588 = 2400;
      this.field_197.field_589 = 2400;
      this.field_197.field_590 = 1;
      this.field_197.field_591 = 2300;
      this.field_197.method_403(-50, -10, -50);
      this.kab = new class_3(this.field_197, this.field_198);
      this.kab.field_70 = this.field_205;
      this.method_170();
      this.method_171();
      this.method_172();
      if (this.field_174) {
         this.method_173();
      }

      this.method_134(100, "Starting game...");
      this.method_174();
      this.method_187();
      this.method_184();
      this.method_180();
      this.method_183();
      this.method_176();
      this.method_120();
      this.method_189();
   }

   // $FF: renamed from: rn () void
   public void method_167() {
      byte[] var1 = null;

      try {
         var1 = this.method_137(field_175 + "config" + class_10.field_394 + ".jag", "Configuration", 10);
      } catch (IOException var3) {
         System.out.println("Load error:" + var3);
      }

      class_11.method_326(var1, this.field_174);
   }

   // $FF: renamed from: tn () void
   public void method_168() {
      byte[] var1 = null;

      try {
         var1 = this.method_137(field_175 + "media" + class_10.field_396 + ".jag", "2d graphics", 20);
      } catch (IOException var8) {
         System.out.println("Load error:" + var8);
      }

      byte[] var2 = class_0.method_19("index.dat", 0, var1);
      this.field_198.method_45(this.field_205, class_0.method_19("inv1.dat", 0, var1), var2, 1);
      this.field_198.method_45(this.field_205 + 1, class_0.method_19("inv2.dat", 0, var1), var2, 6);
      this.field_198.method_45(this.field_205 + 9, class_0.method_19("bubble.dat", 0, var1), var2, 1);
      this.field_198.method_45(this.field_205 + 10, class_0.method_19("runescape.dat", 0, var1), var2, 1);
      this.field_198.method_45(this.field_205 + 11, class_0.method_19("splat.dat", 0, var1), var2, 3);
      this.field_198.method_45(this.field_205 + 14, class_0.method_19("icon.dat", 0, var1), var2, 8);
      this.field_198.method_45(this.field_205 + 22, class_0.method_19("hbar.dat", 0, var1), var2, 1);
      this.field_198.method_45(this.field_205 + 23, class_0.method_19("hbar2.dat", 0, var1), var2, 1);
      this.field_198.method_45(this.field_205 + 24, class_0.method_19("compass.dat", 0, var1), var2, 1);
      this.field_198.method_45(this.field_205 + 25, class_0.method_19("buttons.dat", 0, var1), var2, 2);
      this.field_198.method_45(this.field_206, class_0.method_19("scrollbar.dat", 0, var1), var2, 2);
      this.field_198.method_45(this.field_206 + 2, class_0.method_19("corners.dat", 0, var1), var2, 4);
      this.field_198.method_45(this.field_206 + 6, class_0.method_19("arrows.dat", 0, var1), var2, 2);
      this.field_198.method_45(this.field_208, class_0.method_19("projectile.dat", 0, var1), var2, class_11.field_470);
      int var3 = class_11.field_403;

      int var5;
      for(int var4 = 1; var3 > 0; ++var4) {
         var5 = var3;
         var3 -= 30;
         if (var5 > 30) {
            var5 = 30;
         }

         this.field_198.method_45(this.field_207 + (var4 - 1) * 30, class_0.method_19("objects" + var4 + ".dat", 0, var1), var2, var5);
      }

      this.field_198.method_49(this.field_205);
      this.field_198.method_49(this.field_205 + 9);

      for(var5 = 11; var5 <= 26; ++var5) {
         this.field_198.method_49(this.field_205 + var5);
      }

      for(int var6 = 0; var6 < class_11.field_470; ++var6) {
         this.field_198.method_49(this.field_208 + var6);
      }

      for(int var7 = 0; var7 < class_11.field_403; ++var7) {
         this.field_198.method_49(this.field_207 + var7);
      }

   }

   // $FF: renamed from: vp () void
   public void method_169() {
      byte[] var1 = null;
      Object var2 = null;

      try {
         var1 = this.method_137(field_175 + "entity" + class_10.field_399 + ".jag", "people and monsters", 30);
      } catch (IOException var13) {
         System.out.println("Load error:" + var13);
      }

      byte[] var14 = class_0.method_19("index.dat", 0, var1);
      byte[] var3 = null;
      byte[] var4 = null;
      if (this.field_174) {
         try {
            var3 = this.method_137(field_175 + "entity" + class_10.field_399 + ".mem", "member graphics", 45);
         } catch (IOException var12) {
            System.out.println("Load error:" + var12);
         }

         var4 = class_0.method_19("index.dat", 0, var3);
      }

      int var6 = 0;
      this.zlb = 0;
      this.amb = this.zlb;

      label84:
      for(int var7 = 0; var7 < class_11.field_436; ++var7) {
         String var8 = class_11.field_437[var7];

         for(int var9 = 0; var9 < var7; ++var9) {
            if (class_11.field_437[var9].equalsIgnoreCase(var8)) {
               class_11.field_442[var7] = class_11.field_442[var9];
               continue label84;
            }
         }

         byte[] var10 = class_0.method_19(var8 + ".dat", 0, var1);
         byte[] var5 = var14;
         if (var10 == null && this.field_174) {
            var10 = class_0.method_19(var8 + ".dat", 0, var3);
            var5 = var4;
         }

         if (var10 != null) {
            this.field_198.method_45(this.amb, var10, var5, 15);
            var6 += 15;
            byte[] var11;
            if (class_11.field_440[var7] == 1) {
               var11 = class_0.method_19(var8 + "a.dat", 0, var1);
               var5 = var14;
               if (var11 == null && this.field_174) {
                  var11 = class_0.method_19(var8 + "a.dat", 0, var3);
                  var5 = var4;
               }

               this.field_198.method_45(this.amb + 15, var11, var5, 3);
               var6 += 3;
            }

            if (class_11.field_441[var7] == 1) {
               var11 = class_0.method_19(var8 + "f.dat", 0, var1);
               var5 = var14;
               if (var11 == null && this.field_174) {
                  var11 = class_0.method_19(var8 + "f.dat", 0, var3);
                  var5 = var4;
               }

               this.field_198.method_45(this.amb + 18, var11, var5, 9);
               var6 += 9;
            }

            if (class_11.field_439[var7] != 0) {
               for(int var15 = this.amb; var15 < this.amb + 27; ++var15) {
                  this.field_198.method_49(var15);
               }
            }
         }

         class_11.field_442[var7] = this.amb;
         this.amb += 27;
      }

      System.out.println("Loaded: " + var6 + " frames of animation");
   }

   // $FF: renamed from: zn () void
   public void method_170() {
      byte[] var1 = null;

      try {
         var1 = this.method_137(field_175 + "textures" + class_10.field_398 + ".jag", "Textures", 50);
      } catch (IOException var10) {
         System.out.println("Load error:" + var10);
      }

      byte[] var2 = class_0.method_19("index.dat", 0, var1);
      this.field_197.method_397(class_11.field_433, 7, 11);

      for(int var3 = 0; var3 < class_11.field_433; ++var3) {
         String var4 = class_11.field_434[var3];
         byte[] var5 = class_0.method_19(var4 + ".dat", 0, var1);
         this.field_198.method_45(this.field_209, var5, var2, 1);
         this.field_198.method_36(0, 0, 128, 128, 16711935);
         this.field_198.method_52(0, 0, this.field_209);
         int var6 = this.field_198.field_27[this.field_209];
         String var7 = class_11.field_435[var3];
         if (var7 != null && var7.length() > 0) {
            var5 = class_0.method_19(var7 + ".dat", 0, var1);
            this.field_198.method_45(this.field_209, var5, var2, 1);
            this.field_198.method_52(0, 0, this.field_209);
         }

         this.field_198.method_51(this.aab + var3, 0, 0, var6, var6);
         int var8 = var6 * var6;

         for(int var9 = 0; var9 < var8; ++var9) {
            if (this.field_198.field_20[this.aab + var3][var9] == 65280) {
               this.field_198.field_20[this.aab + var3][var9] = 16711935;
            }
         }

         this.field_198.method_48(this.aab + var3);
         this.field_197.method_398(var3, this.field_198.field_21[this.aab + var3], this.field_198.field_22[this.aab + var3], var6 / 64 - 1);
      }

   }

   // $FF: renamed from: po () void
   public void method_171() {
      class_11.method_321("torcha2");
      class_11.method_321("torcha3");
      class_11.method_321("torcha4");
      class_11.method_321("skulltorcha2");
      class_11.method_321("skulltorcha3");
      class_11.method_321("skulltorcha4");
      class_11.method_321("firea2");
      class_11.method_321("firea3");
      class_11.method_321("fireplacea2");
      class_11.method_321("fireplacea3");
      if (this.method_122()) {
         byte[] var5 = null;

         try {
            var5 = this.method_137("models" + class_10.field_397 + ".jag", "3d models", 60);
         } catch (IOException var4) {
            System.out.println("Load error:" + var4);
         }

         for(int var2 = 0; var2 < class_11.field_488; ++var2) {
            int var3 = class_0.method_17(class_11.field_489[var2] + ".ob3", var5);
            if (var3 != 0) {
               this.ocb[var2] = new class_8(var5, var3, true);
            } else {
               this.ocb[var2] = new class_8(1, 1);
            }

            if (class_11.field_489[var2].equals("giantcrystal")) {
               this.ocb[var2].field_290 = true;
            }
         }

      } else {
         this.method_134(70, "Loading 3d models");

         for(int var1 = 0; var1 < class_11.field_488; ++var1) {
            this.ocb[var1] = new class_8("../gamedata/models/" + class_11.field_489[var1] + ".ob2");
            if (class_11.field_489[var1].equals("giantcrystal")) {
               this.ocb[var1].field_290 = true;
            }
         }

      }
   }

   // $FF: renamed from: sn () void
   public void method_172() {
      try {
         this.kab.field_79 = this.method_137(field_175 + "maps" + class_10.field_395 + ".jag", "map", 70);
         if (this.field_174) {
            this.kab.field_81 = this.method_137(field_175 + "maps" + class_10.field_395 + ".mem", "members map", 75);
         }

         this.kab.field_78 = this.method_137(field_175 + "land" + class_10.field_395 + ".jag", "landscape", 80);
         if (this.field_174) {
            this.kab.field_80 = this.method_137(field_175 + "land" + class_10.field_395 + ".mem", "members landscape", 85);
            return;
         }
      } catch (IOException var2) {
         System.out.println("Load error:" + var2);
      }

   }

   // $FF: renamed from: qn () void
   public void method_173() {
      try {
         this.rmb = this.method_137(field_175 + "sounds" + class_10.field_400 + ".mem", "Sound effects", 90);
         this.smb = new class_18();
      } catch (Throwable var2) {
         System.out.println("Unable to init sounds:" + var2);
      }
   }

   // $FF: renamed from: mn () void
   public void method_174() {
      this.bfb = new class_9(this.field_198, 10);
      this.cfb = this.bfb.method_302(5, 269, 502, 56, 1, 20, true);
      this.dfb = this.bfb.method_303(7, 324, 498, 14, 1, 80, false, true);
      this.efb = this.bfb.method_302(5, 269, 502, 56, 1, 20, true);
      this.ffb = this.bfb.method_302(5, 269, 502, 56, 1, 20, true);
      this.bfb.method_317(this.dfb);
   }

   // $FF: renamed from: dj () void
   public void method_117() {
      if (!this.field_179) {
         if (!this.field_180) {
            try {
               ++this.field_182;
               if (this.field_201 == 0) {
                  super.field_119 = 0;
                  this.method_190();
               }

               if (this.field_201 == 1) {
                  ++super.field_119;
                  this.method_191();
               }

               super.field_142 = 0;
               super.field_144 = 0;
               ++this.field_195;
               if (this.field_195 > 500) {
                  this.field_195 = 0;
                  int var1 = (int)(Math.random() * 4.0D);
                  if ((var1 & 1) == 1) {
                     this.field_191 += this.field_192;
                  }

                  if ((var1 & 2) == 2) {
                     this.field_193 += this.field_194;
                  }
               }

               if (this.field_191 < -50) {
                  this.field_192 = 2;
               }

               if (this.field_191 > 50) {
                  this.field_192 = -2;
               }

               if (this.field_193 < -50) {
                  this.field_194 = 2;
               }

               if (this.field_193 > 50) {
                  this.field_194 = -2;
               }

               if (this.xeb > 0) {
                  --this.xeb;
               }

               if (this.yeb > 0) {
                  --this.yeb;
               }

               if (this.zeb > 0) {
                  --this.zeb;
               }

               if (this.afb > 0) {
                  --this.afb;
                  return;
               }
            } catch (OutOfMemoryError var2) {
               this.method_175();
               this.field_180 = true;
            }

         }
      }
   }

   // $FF: renamed from: jj () void
   public void method_119() {
      Graphics var1;
      if (this.field_179) {
         var1 = this.getGraphics();
         var1.setColor(Color.black);
         var1.fillRect(0, 0, 512, 356);
         var1.setFont(new Font("Helvetica", 1, 20));
         var1.setColor(Color.white);
         var1.drawString("Error - unable to load game!", 50, 50);
         var1.drawString("To play RuneScape make sure you play from", 50, 100);
         var1.drawString("http://www.runescape.com", 50, 150);
         this.method_126(1);
      } else if (this.field_180) {
         var1 = this.getGraphics();
         var1.setColor(Color.black);
         var1.fillRect(0, 0, 512, 356);
         var1.setFont(new Font("Helvetica", 1, 20));
         var1.setColor(Color.white);
         var1.drawString("Error - out of memory!", 50, 50);
         var1.drawString("Close ALL unnecessary programs", 50, 100);
         var1.drawString("and windows before loading the game", 50, 150);
         var1.drawString("RuneScape needs about 48meg of spare RAM", 50, 200);
         this.method_126(1);
      } else {
         try {
            if (this.field_201 == 0) {
               this.field_198.field_38 = false;
               this.method_188();
            }

            if (this.field_201 == 1) {
               this.field_198.field_38 = true;
               this.method_198();
               return;
            }
         } catch (OutOfMemoryError var2) {
            this.method_175();
            this.field_180 = true;
         }

      }
   }

   // $FF: renamed from: mj () void
   public void method_118() {
      this.method_141();
      this.method_175();
      if (this.smb != null) {
         this.smb.method_410();
      }

   }

   // $FF: renamed from: uo () void
   public void method_175() {
      try {
         if (this.field_198 != null) {
            this.field_198.method_44();
            this.field_198.field_16 = null;
            this.field_198 = null;
         }

         if (this.field_197 != null) {
            this.field_197.method_365();
            this.field_197 = null;
         }

         this.ocb = null;
         this.jcb = null;
         this.scb = null;
         this.mbb = null;
         this.nbb = null;
         this.xbb = null;
         this.ybb = null;
         this.pbb = null;
         if (this.kab != null) {
            this.kab.field_98 = null;
            this.kab.field_99 = null;
            this.kab.field_100 = null;
            this.kab.field_101 = null;
            this.kab = null;
         }

         System.gc();
      } catch (Exception var1) {
         ;
      }
   }

   // $FF: renamed from: ej (int) void
   public void method_129(int var1) {
      if (this.field_201 == 0) {
         if (this.vib == 0) {
            this.wib.method_282(var1);
         }

         if (this.vib == 1) {
            this.zib.method_282(var1);
         }

         if (this.vib == 2) {
            this.ijb.method_282(var1);
         }

         if (this.vib == 3) {
            this.xkb.method_282(var1);
         }
      }

      if (this.field_201 == 1) {
         if (this.cmb) {
            this.vjb.method_282(var1);
            return;
         }

         if (this.lkb) {
            if (this.pkb == -1) {
               this.mkb.method_282(var1);
            }

            return;
         }

         if (this.eib == 0 && this.dib == 0) {
            this.bfb.method_282(var1);
         }

         if (this.eib == 3 || this.eib == 4 || this.eib == 5) {
            this.eib = 0;
         }
      }

   }

   // $FF: renamed from: ij (int, int, int) void
   public void method_130(int var1, int var2, int var3) {
      this.field_189[this.field_188] = var2;
      this.field_190[this.field_188] = var3;
      this.field_188 = this.field_188 + 1 & 8191;

      for(int var4 = 10; var4 < 4000; ++var4) {
         int var5 = this.field_188 - var4 & 8191;
         if (this.field_189[var5] == var2 && this.field_190[var5] == var3) {
            boolean var6 = false;

            for(int var7 = 1; var7 < var4; ++var7) {
               int var8 = this.field_188 - var7 & 8191;
               int var9 = var5 - var7 & 8191;
               if (this.field_189[var9] != var2 || this.field_190[var9] != var3) {
                  var6 = true;
               }

               if (this.field_189[var8] != this.field_189[var9] || this.field_190[var8] != this.field_190[var9]) {
                  break;
               }

               if (var7 == var4 - 1 && var6 && this.rib == 0 && this.qib == 0) {
                  this.method_178();
                  return;
               }
            }
         }
      }

   }

   // $FF: renamed from: nn () void
   public void method_176() {
      this.field_201 = 0;
      this.vib = 0;
      this.tjb = "";
      this.ujb = "";
      this.rjb = "Please enter a username:";
      this.sjb = "*" + this.tjb + "*";
      this.jbb = 0;
      this.vbb = 0;
   }

   // $FF: renamed from: wo () void
   public void method_177() {
      super.field_148 = "";
      super.field_149 = "";
   }

   // $FF: renamed from: op () void
   public void method_178() {
      if (this.field_201 != 0) {
         if (this.rib > 450) {
            this.method_192("@cya@You can't logout during combat!", 3);
         } else if (this.rib > 0) {
            this.method_192("@cya@You can't logout for 10 seconds after combat", 3);
         } else {
            super.field_157.method_358(6);
            super.field_157.method_359();
            this.qib = 1000;
         }
      }
   }

   // $FF: renamed from: hp (java.lang.String) void
   public void method_179(String var1) {
      if (this.smb != null) {
         if (!this.geb) {
            this.smb.method_411(this.rmb, class_0.method_17(var1 + ".pcm", this.rmb), class_0.method_18(var1 + ".pcm", this.rmb));
         }
      }
   }

   // $FF: renamed from: lp () void
   public void method_180() {
      this.mkb = new class_9(this.field_198, 100);
      byte var1 = 8;
      this.nkb = this.mkb.method_298(256, var1, "@yel@Please provide 5 security questions in case you lose your password", 1, true);
      int var3 = var1 + 22;
      this.mkb.method_298(256, var3, "If you ever lose your password, you will need these to prove you own your account.", 1, true);
      var3 += 13;
      this.mkb.method_298(256, var3, "Your answers are encrypted and are ONLY used for password recovery purposes.", 1, true);
      var3 += 22;
      this.mkb.method_298(256, var3, "@ora@IMPORTANT:@whi@ To recover your password you must give the EXACT same answers you", 1, true);
      var3 += 13;
      this.mkb.method_298(256, var3, "give here. If you think you might forget an answer, or someone else could guess the", 1, true);
      var3 += 13;
      this.mkb.method_298(256, var3, "answer, then press the 'different question' button to get a better question.", 1, true);
      var3 += 35;

      for(int var2 = 0; var2 < 5; ++var2) {
         this.mkb.method_299(170, var3, 310, 30);
         this.vkb[var2] = "~:" + this.ukb[var2];
         this.qkb[var2] = this.mkb.method_298(170, var3 - 7, var2 + 1 + ": " + this.ymb[this.ukb[var2]], 1, true);
         this.rkb[var2] = this.mkb.method_304(170, var3 + 7, 310, 30, 1, 80, false, true);
         this.mkb.method_299(370, var3, 80, 30);
         this.mkb.method_298(370, var3 - 7, "Different", 1, true);
         this.mkb.method_298(370, var3 + 7, "Question", 1, true);
         this.skb[var2] = this.mkb.method_307(370, var3, 80, 30);
         this.mkb.method_299(455, var3, 80, 30);
         this.mkb.method_298(455, var3 - 7, "Enter own", 1, true);
         this.mkb.method_298(455, var3 + 7, "Question", 1, true);
         this.tkb[var2] = this.mkb.method_307(455, var3, 80, 30);
         var3 += 35;
      }

      this.mkb.method_317(this.rkb[0]);
      var3 += 10;
      this.mkb.method_299(256, var3, 250, 30);
      this.mkb.method_298(256, var3, "Click here when finished", 4, true);
      this.okb = this.mkb.method_307(256, var3, 250, 30);
   }

   // $FF: renamed from: gp () void
   public void method_181() {
      if (this.pkb != -1) {
         if (super.field_149.length() > 0) {
            this.vkb[this.pkb] = super.field_149;
            this.mkb.method_313(this.qkb[this.pkb], this.pkb + 1 + ": " + this.vkb[this.pkb]);
            this.mkb.method_313(this.rkb[this.pkb], "");
            this.pkb = -1;
         }

      } else {
         this.mkb.method_280(super.field_139, super.field_140, super.field_142, super.field_141);

         int var3;
         for(int var1 = 0; var1 < 5; ++var1) {
            if (this.mkb.method_281(this.skb[var1])) {
               boolean var2 = false;

               while(!var2) {
                  this.ukb[var1] = (this.ukb[var1] + 1) % this.ymb.length;
                  var2 = true;

                  for(var3 = 0; var3 < 5; ++var3) {
                     if (var3 != var1 && this.ukb[var3] == this.ukb[var1]) {
                        var2 = false;
                     }
                  }
               }

               this.vkb[var1] = "~:" + this.ukb[var1];
               this.mkb.method_313(this.qkb[var1], var1 + 1 + ": " + this.ymb[this.ukb[var1]]);
               this.mkb.method_313(this.rkb[var1], "");
            }
         }

         for(int var8 = 0; var8 < 5; ++var8) {
            if (this.mkb.method_281(this.tkb[var8])) {
               this.pkb = var8;
               super.field_148 = "";
               super.field_149 = "";
            }
         }

         if (this.mkb.method_281(this.okb)) {
            var3 = 0;

            while(true) {
               if (var3 >= 5) {
                  int var6;
                  for(int var9 = 0; var9 < 5; ++var9) {
                     String var5 = this.mkb.method_314(this.rkb[var9]);

                     for(var6 = 0; var6 < var9; ++var6) {
                        String var7 = this.mkb.method_314(this.rkb[var6]);
                        if (var5.equalsIgnoreCase(var7)) {
                           this.mkb.method_313(this.nkb, "@yel@Each question must have a different answer");
                           return;
                        }
                     }
                  }

                  super.field_157.method_358(208);

                  for(int var10 = 0; var10 < 5; ++var10) {
                     String var11 = this.vkb[var10];
                     if (var11 == null || var11.length() == 0) {
                        var11 = String.valueOf(var10 + 1);
                     }

                     if (var11.length() > 50) {
                        var11 = var11.substring(0, 50);
                     }

                     super.field_157.method_349(var11.length());
                     super.field_157.method_354(var11);
                     super.field_157.method_356(class_0.method_13(this.mkb.method_314(this.rkb[var10])), super.field_172, this.field_176, this.field_177);
                  }

                  super.field_157.method_359();

                  for(var6 = 0; var6 < 5; ++var6) {
                     this.ukb[var6] = var6;
                     this.vkb[var6] = "~:" + this.ukb[var6];
                     this.mkb.method_313(this.rkb[var6], "");
                     this.mkb.method_313(this.qkb[var6], var6 + 1 + ": " + this.ymb[this.ukb[var6]]);
                  }

                  this.field_198.method_32();
                  this.lkb = false;
                  break;
               }

               String var4 = this.mkb.method_314(this.rkb[var3]);
               if (var4 == null || var4.length() < 3) {
                  this.mkb.method_313(this.nkb, "@yel@Please provide a longer answer to question: " + (var3 + 1));
                  return;
               }

               ++var3;
            }
         }

      }
   }

   // $FF: renamed from: mp () void
   public void method_182() {
      this.field_198.field_34 = false;
      this.field_198.method_32();
      this.mkb.method_283();
      if (this.pkb != -1) {
         short var1 = 150;
         this.field_198.method_36(26, var1, 460, 60, 0);
         this.field_198.method_37(26, var1, 460, 60, 16777215);
         int var2 = var1 + 22;
         this.field_198.method_75("Please enter your question", 256, var2, 4, 16777215);
         var2 += 25;
         this.field_198.method_75(super.field_148 + "*", 256, var2, 4, 16777215);
      }

      this.field_198.method_52(0, this.field_203, this.field_205 + 22);
      this.field_198.method_31(this.field_196, 0, 0);
   }

   // $FF: renamed from: yn () void
   public void method_183() {
      this.xkb = new class_9(this.field_198, 100);
      byte var1 = 10;
      this.ykb = this.xkb.method_298(256, var1, "@yel@To prove this is your account please provide the answers to", 1, true);
      int var3 = var1 + 15;
      this.zkb = this.xkb.method_298(256, var3, "@yel@your security questions. You will then be able to reset your password", 1, true);
      var3 += 35;

      for(int var2 = 0; var2 < 5; ++var2) {
         this.xkb.method_299(256, var3, 410, 30);
         this.ilb[var2] = this.xkb.method_298(256, var3 - 7, var2 + 1 + ": question?", 1, true);
         this.jlb[var2] = this.xkb.method_304(256, var3 + 7, 310, 30, 1, 80, true, true);
         var3 += 35;
      }

      this.xkb.method_317(this.jlb[0]);
      this.xkb.method_299(256, var3, 410, 30);
      this.xkb.method_298(256, var3 - 7, "If you know it, enter a previous password used on this account", 1, true);
      this.alb = this.xkb.method_304(256, var3 + 7, 310, 30, 1, 80, true, true);
      var3 += 35;
      this.xkb.method_299(151, var3, 200, 30);
      this.xkb.method_298(151, var3 - 7, "Choose a NEW password", 1, true);
      this.blb = this.xkb.method_304(146, var3 + 7, 200, 30, 1, 80, true, true);
      this.xkb.method_299(361, var3, 200, 30);
      this.xkb.method_298(361, var3 - 7, "Confirm new password", 1, true);
      this.clb = this.xkb.method_304(366, var3 + 7, 200, 30, 1, 80, true, true);
      var3 += 35;
      this.xkb.method_299(201, var3, 100, 30);
      this.xkb.method_298(201, var3, "Submit", 4, true);
      this.dlb = this.xkb.method_307(201, var3, 100, 30);
      this.xkb.method_299(311, var3, 100, 30);
      this.xkb.method_298(311, var3, "Cancel", 4, true);
      this.elb = this.xkb.method_307(311, var3, 100, 30);
   }

   // $FF: renamed from: lo () void
   public void method_184() {
      this.vjb = new class_9(this.field_198, 100);
      this.vjb.method_298(256, 10, "Design Your Character", 4, true);
      short var1 = 140;
      byte var2 = 34;
      this.vjb.method_299(var1, var2, 200, 25);
      this.vjb.method_298(var1, var2, "Appearance", 4, false);
      int var5 = var2 + 15;
      this.vjb.method_298(var1 - 55, var5 + 110, "Front", 3, true);
      this.vjb.method_298(var1, var5 + 110, "Side", 3, true);
      this.vjb.method_298(var1 + 55, var5 + 110, "Back", 3, true);
      byte var3 = 54;
      var5 += 145;
      this.vjb.method_300(var1 - var3, var5, 53, 41);
      this.vjb.method_298(var1 - var3, var5 - 8, "Head", 1, true);
      this.vjb.method_298(var1 - var3, var5 + 8, "Type", 1, true);
      this.vjb.method_301(var1 - var3 - 40, var5, class_9.field_387 + 7);
      this.wjb = this.vjb.method_307(var1 - var3 - 40, var5, 20, 20);
      this.vjb.method_301(var1 - var3 + 40, var5, class_9.field_387 + 6);
      this.xjb = this.vjb.method_307(var1 - var3 + 40, var5, 20, 20);
      this.vjb.method_300(var1 + var3, var5, 53, 41);
      this.vjb.method_298(var1 + var3, var5 - 8, "Hair", 1, true);
      this.vjb.method_298(var1 + var3, var5 + 8, "Color", 1, true);
      this.vjb.method_301(var1 + var3 - 40, var5, class_9.field_387 + 7);
      this.yjb = this.vjb.method_307(var1 + var3 - 40, var5, 20, 20);
      this.vjb.method_301(var1 + var3 + 40, var5, class_9.field_387 + 6);
      this.zjb = this.vjb.method_307(var1 + var3 + 40, var5, 20, 20);
      var5 += 50;
      this.vjb.method_300(var1 - var3, var5, 53, 41);
      this.vjb.method_298(var1 - var3, var5, "Gender", 1, true);
      this.vjb.method_301(var1 - var3 - 40, var5, class_9.field_387 + 7);
      this.akb = this.vjb.method_307(var1 - var3 - 40, var5, 20, 20);
      this.vjb.method_301(var1 - var3 + 40, var5, class_9.field_387 + 6);
      this.bkb = this.vjb.method_307(var1 - var3 + 40, var5, 20, 20);
      this.vjb.method_300(var1 + var3, var5, 53, 41);
      this.vjb.method_298(var1 + var3, var5 - 8, "Top", 1, true);
      this.vjb.method_298(var1 + var3, var5 + 8, "Color", 1, true);
      this.vjb.method_301(var1 + var3 - 40, var5, class_9.field_387 + 7);
      this.ckb = this.vjb.method_307(var1 + var3 - 40, var5, 20, 20);
      this.vjb.method_301(var1 + var3 + 40, var5, class_9.field_387 + 6);
      this.dkb = this.vjb.method_307(var1 + var3 + 40, var5, 20, 20);
      var5 += 50;
      this.vjb.method_300(var1 - var3, var5, 53, 41);
      this.vjb.method_298(var1 - var3, var5 - 8, "Skin", 1, true);
      this.vjb.method_298(var1 - var3, var5 + 8, "Color", 1, true);
      this.vjb.method_301(var1 - var3 - 40, var5, class_9.field_387 + 7);
      this.ekb = this.vjb.method_307(var1 - var3 - 40, var5, 20, 20);
      this.vjb.method_301(var1 - var3 + 40, var5, class_9.field_387 + 6);
      this.fkb = this.vjb.method_307(var1 - var3 + 40, var5, 20, 20);
      this.vjb.method_300(var1 + var3, var5, 53, 41);
      this.vjb.method_298(var1 + var3, var5 - 8, "Bottom", 1, true);
      this.vjb.method_298(var1 + var3, var5 + 8, "Color", 1, true);
      this.vjb.method_301(var1 + var3 - 40, var5, class_9.field_387 + 7);
      this.gkb = this.vjb.method_307(var1 + var3 - 40, var5, 20, 20);
      this.vjb.method_301(var1 + var3 + 40, var5, class_9.field_387 + 6);
      this.hkb = this.vjb.method_307(var1 + var3 + 40, var5, 20, 20);
      var1 = 372;
      var2 = 35;
      this.vjb.method_299(var1, var2, 200, 25);
      this.vjb.method_298(var1, var2, "Character Type", 4, false);
      var5 = var2 + 22;
      this.vjb.method_298(var1, var5, "Each character type has different starting", 0, true);
      var5 += 13;
      this.vjb.method_298(var1, var5, "bonuses. But the choice you make here", 0, true);
      var5 += 13;
      this.vjb.method_298(var1, var5, "isn't permanent, and will change depending", 0, true);
      var5 += 13;
      this.vjb.method_298(var1, var5, "on how you play the game.", 0, true);
      var5 += 73;
      this.vjb.method_300(var1, var5, 215, 125);
      String[] var4 = new String[]{"Adventurer", "Warrior", "Wizard", "Ranger", "Miner"};
      this.jkb = this.vjb.method_305(var1, var5 + 2, var4, 3, true);
      var5 += 82;
      this.vjb.method_299(var1, var5, 200, 30);
      this.vjb.method_298(var1, var5, "Start Game", 4, false);
      this.ikb = this.vjb.method_307(var1, var5, 200, 30);
   }

   // $FF: renamed from: rp () void
   public void method_185() {
      this.field_198.field_34 = false;
      this.field_198.method_32();
      this.vjb.method_283();
      short var1 = 140;
      byte var2 = 50;
      this.field_198.method_56(var1 - 32 - 55, var2, 64, 102, class_11.field_442[this.fmb], this.lmb[this.imb]);
      this.field_198.method_68(var1 - 32 - 55, var2, 64, 102, class_11.field_442[this.emb], this.lmb[this.hmb], this.nmb[this.jmb], 0, false);
      this.field_198.method_68(var1 - 32 - 55, var2, 64, 102, class_11.field_442[this.dmb], this.mmb[this.gmb], this.nmb[this.jmb], 0, false);
      this.field_198.method_56(var1 - 32, var2, 64, 102, class_11.field_442[this.fmb] + 6, this.lmb[this.imb]);
      this.field_198.method_68(var1 - 32, var2, 64, 102, class_11.field_442[this.emb] + 6, this.lmb[this.hmb], this.nmb[this.jmb], 0, false);
      this.field_198.method_68(var1 - 32, var2, 64, 102, class_11.field_442[this.dmb] + 6, this.mmb[this.gmb], this.nmb[this.jmb], 0, false);
      this.field_198.method_56(var1 - 32 + 55, var2, 64, 102, class_11.field_442[this.fmb] + 12, this.lmb[this.imb]);
      this.field_198.method_68(var1 - 32 + 55, var2, 64, 102, class_11.field_442[this.emb] + 12, this.lmb[this.hmb], this.nmb[this.jmb], 0, false);
      this.field_198.method_68(var1 - 32 + 55, var2, 64, 102, class_11.field_442[this.dmb] + 12, this.mmb[this.gmb], this.nmb[this.jmb], 0, false);
      this.field_198.method_52(0, this.field_203, this.field_205 + 22);
      this.field_198.method_31(this.field_196, 0, 0);
   }

   // $FF: renamed from: wn () void
   public void method_186() {
      this.vjb.method_280(super.field_139, super.field_140, super.field_142, super.field_141);
      if (this.vjb.method_281(this.wjb)) {
         do {
            do {
               this.dmb = (this.dmb - 1 + class_11.field_436) % class_11.field_436;
            } while((class_11.field_439[this.dmb] & 3) != 1);
         } while((class_11.field_439[this.dmb] & 4 * this.kmb) == 0);
      }

      if (this.vjb.method_281(this.xjb)) {
         do {
            do {
               this.dmb = (this.dmb + 1) % class_11.field_436;
            } while((class_11.field_439[this.dmb] & 3) != 1);
         } while((class_11.field_439[this.dmb] & 4 * this.kmb) == 0);
      }

      if (this.vjb.method_281(this.yjb)) {
         this.gmb = (this.gmb - 1 + this.mmb.length) % this.mmb.length;
      }

      if (this.vjb.method_281(this.zjb)) {
         this.gmb = (this.gmb + 1) % this.mmb.length;
      }

      if (this.vjb.method_281(this.akb) || this.vjb.method_281(this.bkb)) {
         for(this.kmb = 3 - this.kmb; (class_11.field_439[this.dmb] & 3) != 1 || (class_11.field_439[this.dmb] & 4 * this.kmb) == 0; this.dmb = (this.dmb + 1) % class_11.field_436) {
            ;
         }

         while((class_11.field_439[this.emb] & 3) != 2 || (class_11.field_439[this.emb] & 4 * this.kmb) == 0) {
            this.emb = (this.emb + 1) % class_11.field_436;
         }
      }

      if (this.vjb.method_281(this.ckb)) {
         this.hmb = (this.hmb - 1 + this.lmb.length) % this.lmb.length;
      }

      if (this.vjb.method_281(this.dkb)) {
         this.hmb = (this.hmb + 1) % this.lmb.length;
      }

      if (this.vjb.method_281(this.ekb)) {
         this.jmb = (this.jmb - 1 + this.nmb.length) % this.nmb.length;
      }

      if (this.vjb.method_281(this.fkb)) {
         this.jmb = (this.jmb + 1) % this.nmb.length;
      }

      if (this.vjb.method_281(this.gkb)) {
         this.imb = (this.imb - 1 + this.lmb.length) % this.lmb.length;
      }

      if (this.vjb.method_281(this.hkb)) {
         this.imb = (this.imb + 1) % this.lmb.length;
      }

      if (this.vjb.method_281(this.ikb)) {
         super.field_157.method_358(236);
         super.field_157.method_349(this.kmb);
         super.field_157.method_349(this.dmb);
         super.field_157.method_349(this.emb);
         super.field_157.method_349(this.fmb);
         super.field_157.method_349(this.gmb);
         super.field_157.method_349(this.hmb);
         super.field_157.method_349(this.imb);
         super.field_157.method_349(this.jmb);
         super.field_157.method_349(this.vjb.method_318(this.jkb));
         super.field_157.method_359();
         this.field_198.method_32();
         this.cmb = false;
      }

   }

   // $FF: renamed from: ko () void
   public void method_187() {
      this.wib = new class_9(this.field_198, 50);
      byte var1 = 40;
      if (!this.field_174) {
         this.wib.method_298(256, 200 + var1, "Click on an option", 5, true);
         this.wib.method_299(156, 240 + var1, 120, 35);
         this.wib.method_299(356, 240 + var1, 120, 35);
         this.wib.method_298(156, 240 + var1, "New User", 5, false);
         this.wib.method_298(356, 240 + var1, "Existing User", 5, false);
         this.xib = this.wib.method_307(156, 240 + var1, 120, 35);
         this.yib = this.wib.method_307(356, 240 + var1, 120, 35);
      } else {
         this.wib.method_298(256, 200 + var1, "Welcome to RuneScape", 4, true);
         this.wib.method_298(256, 215 + var1, "You need a member account to use this server", 4, true);
         this.wib.method_299(256, 250 + var1, 200, 35);
         this.wib.method_298(256, 250 + var1, "Click here to login", 5, false);
         this.yib = this.wib.method_307(256, 250 + var1, 200, 35);
      }

      this.zib = new class_9(this.field_198, 50);
      var1 = 70;
      this.ajb = this.zib.method_298(256, var1 + 8, "To create an account please enter all the requested details", 4, true);
      int var2 = var1 + 25;
      this.zib.method_299(256, var2 + 17, 250, 34);
      this.zib.method_298(256, var2 + 8, "Choose a Username", 4, false);
      this.ejb = this.zib.method_304(256, var2 + 25, 200, 40, 4, 12, false, false);
      this.zib.method_317(this.ejb);
      var2 += 40;
      this.zib.method_299(141, var2 + 17, 220, 34);
      this.zib.method_298(141, var2 + 8, "Choose a Password", 4, false);
      this.fjb = this.zib.method_304(141, var2 + 25, 220, 40, 4, 20, true, false);
      this.zib.method_299(371, var2 + 17, 220, 34);
      this.zib.method_298(371, var2 + 8, "Confirm Password", 4, false);
      this.gjb = this.zib.method_304(371, var2 + 25, 220, 40, 4, 20, true, false);
      var2 += 40;
      var2 += 20;
      this.hjb = this.zib.method_308(60, var2, 14);
      this.zib.method_297(75, var2, "I have read and agree to the terms+conditions listed at:", 4, true);
      var2 += 15;
      this.zib.method_298(256, var2, "http://www.runescape.com/runeterms.html", 4, true);
      var2 += 20;
      this.zib.method_299(156, var2 + 17, 150, 34);
      this.zib.method_298(156, var2 + 17, "Submit", 5, false);
      this.djb = this.zib.method_307(156, var2 + 17, 150, 34);
      this.zib.method_299(356, var2 + 17, 150, 34);
      this.zib.method_298(356, var2 + 17, "Cancel", 5, false);
      this.cjb = this.zib.method_307(356, var2 + 17, 150, 34);
      this.ijb = new class_9(this.field_198, 50);
      short var3 = 230;
      this.jjb = this.ijb.method_298(256, var3 - 10, "Please enter your username and password", 4, true);
      var2 = var3 + 28;
      this.ijb.method_299(140, var2, 200, 40);
      this.ijb.method_298(140, var2 - 10, "Username:", 4, false);
      this.kjb = this.ijb.method_304(140, var2 + 10, 200, 40, 4, 12, false, false);
      var2 += 47;
      this.ijb.method_299(190, var2, 200, 40);
      this.ijb.method_298(190, var2 - 10, "Password:", 4, false);
      this.ljb = this.ijb.method_304(190, var2 + 10, 200, 40, 4, 20, true, false);
      var2 -= 55;
      this.ijb.method_299(410, var2, 120, 25);
      this.ijb.method_298(410, var2, "Ok", 4, false);
      this.mjb = this.ijb.method_307(410, var2, 120, 25);
      var2 += 30;
      this.ijb.method_299(410, var2, 120, 25);
      this.ijb.method_298(410, var2, "Cancel", 4, false);
      this.njb = this.ijb.method_307(410, var2, 120, 25);
      var2 += 30;
      this.ijb.method_299(410, var2, 160, 25);
      this.ijb.method_298(410, var2, "I've lost my password", 4, false);
      this.ojb = this.ijb.method_307(410, var2, 160, 25);
      this.ijb.method_317(this.kjb);
   }

   // $FF: renamed from: ep () void
   public void method_188() {
      this.hib = false;
      this.field_198.field_34 = false;
      this.field_198.method_32();
      if (this.vib == 0 || this.vib == 2) {
         int var1 = this.field_182 * 2 % 3072;
         if (var1 < 1024) {
            this.field_198.method_52(0, 10, 2500);
            if (var1 > 768) {
               this.field_198.method_54(0, 10, 2501, var1 - 768);
            }
         } else if (var1 < 2048) {
            this.field_198.method_52(0, 10, 2501);
            if (var1 > 1792) {
               this.field_198.method_54(0, 10, this.field_205 + 10, var1 - 1792);
            }
         } else {
            this.field_198.method_52(0, 10, this.field_205 + 10);
            if (var1 > 2816) {
               this.field_198.method_54(0, 10, 2500, var1 - 2816);
            }
         }
      }

      if (this.vib == 0) {
         this.wib.method_283();
      }

      if (this.vib == 1) {
         this.zib.method_283();
      }

      if (this.vib == 2) {
         this.ijb.method_283();
      }

      if (this.vib == 3) {
         this.xkb.method_283();
      }

      this.field_198.method_52(0, this.field_203, this.field_205 + 22);
      this.field_198.method_31(this.field_196, 0, 0);
   }

   // $FF: renamed from: en () void
   public void method_189() {
      byte var1 = 0;
      byte var2 = 50;
      byte var3 = 50;
      this.kab.method_109(var2 * 48 + 23, var3 * 48 + 23, var1);
      this.kab.method_113(this.ocb);
      short var4 = 9728;
      short var5 = 6400;
      short var6 = 1100;
      short var7 = 888;
      this.field_197.field_588 = 4100;
      this.field_197.field_589 = 4100;
      this.field_197.field_590 = 1;
      this.field_197.field_591 = 4000;
      this.field_197.method_392(var4, -this.kab.method_93(var4, var5), var5, 912, var7, 0, var6 * 2);
      this.field_197.method_380();
      this.field_198.method_41();
      this.field_198.method_41();
      this.field_198.method_36(0, 0, 512, 6, 0);

      for(int var8 = 6; var8 >= 1; --var8) {
         this.field_198.method_42(0, var8, 0, var8, 512, 8);
      }

      this.field_198.method_36(0, 194, 512, 20, 0);

      for(int var9 = 6; var9 >= 1; --var9) {
         this.field_198.method_42(0, var9, 0, 194 - var9, 512, 8);
      }

      this.field_198.method_52(15, 15, this.field_205 + 10);
      this.field_198.method_51(2500, 0, 0, 512, 200);
      this.field_198.method_48(2500);
      var4 = 9216;
      var5 = 9216;
      var6 = 1100;
      var7 = 888;
      this.field_197.field_588 = 4100;
      this.field_197.field_589 = 4100;
      this.field_197.field_590 = 1;
      this.field_197.field_591 = 4000;
      this.field_197.method_392(var4, -this.kab.method_93(var4, var5), var5, 912, var7, 0, var6 * 2);
      this.field_197.method_380();
      this.field_198.method_41();
      this.field_198.method_41();
      this.field_198.method_36(0, 0, 512, 6, 0);

      for(int var10 = 6; var10 >= 1; --var10) {
         this.field_198.method_42(0, var10, 0, var10, 512, 8);
      }

      this.field_198.method_36(0, 194, 512, 20, 0);

      for(int var11 = 6; var11 >= 1; --var11) {
         this.field_198.method_42(0, var11, 0, 194 - var11, 512, 8);
      }

      this.field_198.method_52(15, 15, this.field_205 + 10);
      this.field_198.method_51(2501, 0, 0, 512, 200);
      this.field_198.method_48(2501);

      for(int var12 = 0; var12 < 64; ++var12) {
         this.field_197.method_364(this.kab.field_100[0][var12]);
         this.field_197.method_364(this.kab.field_99[1][var12]);
         this.field_197.method_364(this.kab.field_100[1][var12]);
         this.field_197.method_364(this.kab.field_99[2][var12]);
         this.field_197.method_364(this.kab.field_100[2][var12]);
      }

      var4 = 11136;
      var5 = 10368;
      var6 = 500;
      var7 = 376;
      this.field_197.field_588 = 4100;
      this.field_197.field_589 = 4100;
      this.field_197.field_590 = 1;
      this.field_197.field_591 = 4000;
      this.field_197.method_392(var4, -this.kab.method_93(var4, var5), var5, 912, var7, 0, var6 * 2);
      this.field_197.method_380();
      this.field_198.method_41();
      this.field_198.method_41();
      this.field_198.method_36(0, 0, 512, 6, 0);

      for(int var13 = 6; var13 >= 1; --var13) {
         this.field_198.method_42(0, var13, 0, var13, 512, 8);
      }

      this.field_198.method_36(0, 194, 512, 20, 0);

      for(int var14 = 6; var14 >= 1; --var14) {
         this.field_198.method_42(0, var14, 0, 194, 512, 8);
      }

      this.field_198.method_52(15, 15, this.field_205 + 10);
      this.field_198.method_51(this.field_205 + 10, 0, 0, 512, 200);
      this.field_198.method_48(this.field_205 + 10);
   }

   // $FF: renamed from: yo () void
   public void method_190() {
      if (super.field_173 > 0) {
         --super.field_173;
      }

      if (this.vib == 0) {
         this.wib.method_280(super.field_139, super.field_140, super.field_142, super.field_141);
         if (this.wib.method_281(this.xib)) {
            this.vib = 1;
            this.zib.method_313(this.ejb, "");
            this.zib.method_313(this.fjb, "");
            this.zib.method_313(this.gjb, "");
            this.zib.method_317(this.ejb);
            this.zib.method_320(this.hjb, 0);
            this.zib.method_313(this.ajb, "To create an account please enter all the requested details");
         }

         if (this.wib.method_281(this.yib)) {
            this.vib = 2;
            this.ijb.method_313(this.jjb, "Please enter your username and password");
            this.ijb.method_313(this.kjb, "");
            this.ijb.method_313(this.ljb, "");
            this.ijb.method_317(this.kjb);
            return;
         }
      } else {
         String var1;
         String var2;
         if (this.vib == 1) {
            this.zib.method_280(super.field_139, super.field_140, super.field_142, super.field_141);
            if (this.zib.method_281(this.ejb)) {
               this.zib.method_317(this.fjb);
            }

            if (this.zib.method_281(this.fjb)) {
               this.zib.method_317(this.gjb);
            }

            if (this.zib.method_281(this.gjb)) {
               this.zib.method_317(this.ejb);
            }

            if (this.zib.method_281(this.cjb)) {
               this.vib = 0;
            }

            if (this.zib.method_281(this.djb)) {
               if (this.zib.method_314(this.ejb) != null && this.zib.method_314(this.ejb).length() != 0 && this.zib.method_314(this.fjb) != null && this.zib.method_314(this.fjb).length() != 0) {
                  if (!this.zib.method_314(this.fjb).equalsIgnoreCase(this.zib.method_314(this.gjb))) {
                     this.zib.method_313(this.ajb, "@yel@The two passwords entered are not the same as each other!");
                     return;
                  }

                  if (this.zib.method_314(this.fjb).length() < 5) {
                     this.zib.method_313(this.ajb, "@yel@Your password must be at least 5 letters long");
                     return;
                  }

                  if (this.zib.method_318(this.hjb) == 0) {
                     this.zib.method_313(this.ajb, "@yel@You must agree to the terms+conditions to continue");
                     return;
                  }

                  this.zib.method_313(this.ajb, "Please wait... Creating new account");
                  this.method_188();
                  this.method_128();
                  var1 = this.zib.method_314(this.ejb);
                  var2 = this.zib.method_314(this.fjb);
                  this.method_144(var1, var2);
                  return;
               }

               this.zib.method_313(this.ajb, "@yel@Please fill in ALL requested information to continue!");
               return;
            }
         } else {
            int var3;
            String var5;
            int var6;
            if (this.vib == 2) {
               this.ijb.method_280(super.field_139, super.field_140, super.field_142, super.field_141);
               if (this.ijb.method_281(this.njb)) {
                  this.vib = 0;
               }

               if (this.ijb.method_281(this.kjb)) {
                  this.ijb.method_317(this.ljb);
               }

               if (this.ijb.method_281(this.ljb) || this.ijb.method_281(this.mjb)) {
                  this.tjb = this.ijb.method_314(this.kjb);
                  this.ujb = this.ijb.method_314(this.ljb);
                  this.method_140(this.tjb, this.ujb, false);
               }

               if (this.ijb.method_281(this.ojb)) {
                  this.tjb = this.ijb.method_314(this.kjb);
                  this.tjb = class_0.method_11(this.tjb, 20);
                  if (this.tjb.trim().length() == 0) {
                     this.method_157("You must enter your username to recover your password", "");
                     return;
                  }

                  this.method_157(class_6.field_150[6], class_6.field_150[7]);

                  try {
                     if (this.method_122()) {
                        super.field_157 = new class_16(super.field_153, this, super.field_154);
                     } else {
                        super.field_157 = new class_16(super.field_153, (Applet)null, super.field_154);
                     }

                     super.field_157.field_566 = class_6.field_152;
                     super.field_157.method_346();
                     super.field_157.method_358(4);
                     super.field_157.method_353(class_0.method_14(this.tjb));
                     super.field_157.method_360();
                     super.field_157.method_345();
                     int var11 = super.field_157.method_339();
                     System.out.println("Getpq response: " + var11);
                     if (var11 == 0) {
                        this.method_157("Sorry, the recovery questions for this user have not been set", "");
                        return;
                     }

                     for(int var12 = 0; var12 < 5; ++var12) {
                        var3 = super.field_157.method_339();
                        byte[] var4 = new byte[5000];
                        super.field_157.method_347(var3, var4);
                        var5 = new String(var4, 0, var3);
                        if (var5.startsWith("~:")) {
                           var5 = var5.substring(2);
                           var6 = 0;

                           try {
                              var6 = Integer.parseInt(var5);
                           } catch (Exception var8) {
                              ;
                           }

                           var5 = this.ymb[var6];
                        }

                        this.xkb.method_313(this.ilb[var12], var5);
                     }

                     if (this.wkb) {
                        this.method_157("Sorry, you have already attempted 1 recovery, try again later", "");
                        return;
                     }

                     this.vib = 3;
                     this.xkb.method_313(this.ykb, "@yel@To prove this is your account please provide the answers to");
                     this.xkb.method_313(this.zkb, "@yel@your security questions. You will then be able to reset your password");

                     for(var3 = 0; var3 < 5; ++var3) {
                        this.xkb.method_313(this.jlb[var3], "");
                     }

                     this.xkb.method_313(this.alb, "");
                     this.xkb.method_313(this.blb, "");
                     this.xkb.method_313(this.clb, "");
                     return;
                  } catch (Exception var9) {
                     this.method_157(class_6.field_150[12], class_6.field_150[13]);
                     return;
                  }
               }
            } else if (this.vib == 3) {
               this.xkb.method_280(super.field_139, super.field_140, super.field_142, super.field_141);
               if (this.xkb.method_281(this.dlb)) {
                  var1 = this.xkb.method_314(this.blb);
                  var2 = this.xkb.method_314(this.clb);
                  if (!var1.equalsIgnoreCase(var2)) {
                     this.method_157("@yel@The two new passwords entered are not the same as each other!", "");
                     return;
                  }

                  if (var1.length() < 5) {
                     this.method_157("@yel@Your new password must be at least 5 letters long", "");
                     return;
                  }

                  this.method_157(class_6.field_150[6], class_6.field_150[7]);

                  try {
                     if (this.method_122()) {
                        super.field_157 = new class_16(super.field_153, this, super.field_154);
                     } else {
                        super.field_157 = new class_16(super.field_153, (Applet)null, super.field_154);
                     }

                     super.field_157.field_566 = class_6.field_152;
                     var3 = super.field_157.method_346();
                     String var13 = class_0.method_11(this.xkb.method_314(this.alb), 20);
                     var5 = class_0.method_11(this.xkb.method_314(this.blb), 20);
                     super.field_157.method_358(8);
                     super.field_157.method_353(class_0.method_14(this.tjb));
                     super.field_157.method_352(this.method_139());
                     super.field_157.method_357(var13 + var5, var3, this.field_176, this.field_177);

                     for(var6 = 0; var6 < 5; ++var6) {
                        super.field_157.method_356(class_0.method_13(this.xkb.method_314(this.jlb[var6])), var3, this.field_176, this.field_177);
                     }

                     super.field_157.method_360();
                     super.field_157.method_339();
                     int var7 = super.field_157.method_339();
                     System.out.println("Recover response: " + var7);
                     if (var7 == 0) {
                        this.vib = 2;
                        this.method_157("Sorry, recovery failed. You may try again in 1 hour", "");
                        this.wkb = true;
                        return;
                     }

                     if (var7 == 1) {
                        this.vib = 2;
                        this.method_157("Your pass has been reset. You may now use the new pass to login", "");
                        return;
                     }

                     this.vib = 2;
                     this.method_157("Recovery failed! Attempts exceeded?", "");
                     return;
                  } catch (Exception var10) {
                     this.method_157(class_6.field_150[12], class_6.field_150[13]);
                  }
               }

               if (this.xkb.method_281(this.elb)) {
                  this.vib = 0;
               }
            }
         }
      }

   }

   // $FF: renamed from: bf (java.lang.String, java.lang.String) void
   public void method_157(String var1, String var2) {
      if (this.vib == 1) {
         this.zib.method_313(this.ajb, var1 + " " + var2);
      }

      if (this.vib == 2) {
         this.ijb.method_313(this.jjb, var1 + " " + var2);
      }

      if (this.vib == 3) {
         this.xkb.method_313(this.ykb, var1);
         this.xkb.method_313(this.zkb, var2);
      }

      this.sjb = var2;
      this.method_188();
      this.method_128();
   }

   // $FF: renamed from: ye () void
   public void method_161() {
      this.qib = 0;
      this.method_192("@cya@Sorry, you can't logout at the moment", 3);
   }

   // $FF: renamed from: ef () void
   public void method_142() {
      if (this.qib != 0) {
         this.method_160();
      } else {
         super.method_142();
      }
   }

   // $FF: renamed from: se () void
   public void method_160() {
      this.vib = 0;
      this.field_201 = 0;
      this.qib = 0;
   }

   // $FF: renamed from: ge () void
   public void method_159() {
      this.cib = 0;
      this.qib = 0;
      this.vib = 0;
      this.field_201 = 1;
      this.method_177();
      this.field_198.method_32();
      this.field_198.method_31(this.field_196, 0, 0);

      for(int var1 = 0; var1 < this.icb; ++var1) {
         this.field_197.method_364(this.jcb[var1]);
         this.kab.method_88(this.kcb[var1], this.lcb[var1], this.mcb[var1]);
      }

      for(int var2 = 0; var2 < this.rcb; ++var2) {
         this.field_197.method_364(this.scb[var2]);
         this.kab.method_86(this.tcb[var2], this.ucb[var2], this.vcb[var2], this.wcb[var2]);
      }

      this.icb = 0;
      this.rcb = 0;
      this.ccb = 0;
      this.jbb = 0;

      for(int var3 = 0; var3 < this.hbb; ++var3) {
         this.mbb[var3] = null;
      }

      for(int var4 = 0; var4 < this.ibb; ++var4) {
         this.nbb[var4] = null;
      }

      this.vbb = 0;

      for(int var5 = 0; var5 < this.tbb; ++var5) {
         this.xbb[var5] = null;
      }

      for(int var6 = 0; var6 < this.ubb; ++var6) {
         this.ybb[var6] = null;
      }

      for(int var7 = 0; var7 < 50; ++var7) {
         this.ceb[var7] = false;
      }

      this.field_184 = 0;
      super.field_142 = 0;
      super.field_141 = 0;
      this.ghb = false;
      this.ohb = false;
   }

   // $FF: renamed from: re () void
   public void method_162() {
      String var1 = this.zib.method_314(this.ejb);
      String var2 = this.zib.method_314(this.fjb);
      this.vib = 2;
      this.ijb.method_313(this.jjb, "Please enter your username and password");
      this.ijb.method_313(this.kjb, var1);
      this.ijb.method_313(this.ljb, var2);
      this.method_188();
      this.method_128();
      this.method_140(var1, var2, false);
   }

   // $FF: renamed from: mo () void
   public void method_191() {
      this.method_145();
      if (this.qib > 0) {
         --this.qib;
      }

      if (super.field_119 > 4500 && this.rib == 0 && this.qib == 0) {
         super.field_119 -= 500;
         this.method_178();
      } else {
         if (this.pbb.field_502 == 8 || this.pbb.field_502 == 9) {
            this.rib = 500;
         }

         if (this.rib > 0) {
            --this.rib;
         }

         if (this.cmb) {
            this.method_186();
         } else if (this.lkb) {
            this.method_181();
         } else {
            int var3;
            int var5;
            int var6;
            int var7;
            for(int var1 = 0; var1 < this.jbb; ++var1) {
               class_13 var2 = this.nbb[var1];
               var3 = (var2.field_505 + 1) % 10;
               if (var2.field_504 != var3) {
                  byte var4 = -1;
                  var5 = var2.field_504;
                  if (var5 < var3) {
                     var6 = var3 - var5;
                  } else {
                     var6 = 10 + var3 - var5;
                  }

                  var7 = 4;
                  if (var6 > 2) {
                     var7 = (var6 - 1) * 4;
                  }

                  if (var2.field_506[var5] - var2.field_498 <= this.field_200 * 3 && var2.field_507[var5] - var2.field_499 <= this.field_200 * 3 && var2.field_506[var5] - var2.field_498 >= -this.field_200 * 3 && var2.field_507[var5] - var2.field_499 >= -this.field_200 * 3 && var6 <= 8) {
                     if (var2.field_498 < var2.field_506[var5]) {
                        var2.field_498 += var7;
                        ++var2.field_501;
                        var4 = 2;
                     } else if (var2.field_498 > var2.field_506[var5]) {
                        var2.field_498 -= var7;
                        ++var2.field_501;
                        var4 = 6;
                     }

                     if (var2.field_498 - var2.field_506[var5] < var7 && var2.field_498 - var2.field_506[var5] > -var7) {
                        var2.field_498 = var2.field_506[var5];
                     }

                     if (var2.field_499 < var2.field_507[var5]) {
                        var2.field_499 += var7;
                        ++var2.field_501;
                        if (var4 == -1) {
                           var4 = 4;
                        } else if (var4 == 2) {
                           var4 = 3;
                        } else {
                           var4 = 5;
                        }
                     } else if (var2.field_499 > var2.field_507[var5]) {
                        var2.field_499 -= var7;
                        ++var2.field_501;
                        if (var4 == -1) {
                           var4 = 0;
                        } else if (var4 == 2) {
                           var4 = 1;
                        } else {
                           var4 = 7;
                        }
                     }

                     if (var2.field_499 - var2.field_507[var5] < var7 && var2.field_499 - var2.field_507[var5] > -var7) {
                        var2.field_499 = var2.field_507[var5];
                     }
                  } else {
                     var2.field_498 = var2.field_506[var5];
                     var2.field_499 = var2.field_507[var5];
                  }

                  if (var4 != -1) {
                     var2.field_502 = var4;
                  }

                  if (var2.field_498 == var2.field_506[var5] && var2.field_499 == var2.field_507[var5]) {
                     var2.field_504 = (var5 + 1) % 10;
                  }
               } else {
                  var2.field_502 = var2.field_503;
               }

               if (var2.field_510 > 0) {
                  --var2.field_510;
               }

               if (var2.field_512 > 0) {
                  --var2.field_512;
               }

               if (var2.field_516 > 0) {
                  --var2.field_516;
               }

               if (this.sib > 0) {
                  --this.sib;
                  if (this.sib == 0) {
                     this.method_192("You have been granted another life. Be more careful this time!", 3);
                  }

                  if (this.sib == 0) {
                     this.method_192("You retain your skills. Your objects land where you died", 3);
                  }
               }
            }

            int var13;
            for(int var9 = 0; var9 < this.vbb; ++var9) {
               class_13 var10 = this.ybb[var9];
               var13 = (var10.field_505 + 1) % 10;
               if (var10.field_504 != var13) {
                  byte var11 = -1;
                  var6 = var10.field_504;
                  if (var6 < var13) {
                     var7 = var13 - var6;
                  } else {
                     var7 = 10 + var13 - var6;
                  }

                  int var8 = 4;
                  if (var7 > 2) {
                     var8 = (var7 - 1) * 4;
                  }

                  if (var10.field_506[var6] - var10.field_498 <= this.field_200 * 3 && var10.field_507[var6] - var10.field_499 <= this.field_200 * 3 && var10.field_506[var6] - var10.field_498 >= -this.field_200 * 3 && var10.field_507[var6] - var10.field_499 >= -this.field_200 * 3 && var7 <= 8) {
                     if (var10.field_498 < var10.field_506[var6]) {
                        var10.field_498 += var8;
                        ++var10.field_501;
                        var11 = 2;
                     } else if (var10.field_498 > var10.field_506[var6]) {
                        var10.field_498 -= var8;
                        ++var10.field_501;
                        var11 = 6;
                     }

                     if (var10.field_498 - var10.field_506[var6] < var8 && var10.field_498 - var10.field_506[var6] > -var8) {
                        var10.field_498 = var10.field_506[var6];
                     }

                     if (var10.field_499 < var10.field_507[var6]) {
                        var10.field_499 += var8;
                        ++var10.field_501;
                        if (var11 == -1) {
                           var11 = 4;
                        } else if (var11 == 2) {
                           var11 = 3;
                        } else {
                           var11 = 5;
                        }
                     } else if (var10.field_499 > var10.field_507[var6]) {
                        var10.field_499 -= var8;
                        ++var10.field_501;
                        if (var11 == -1) {
                           var11 = 0;
                        } else if (var11 == 2) {
                           var11 = 1;
                        } else {
                           var11 = 7;
                        }
                     }

                     if (var10.field_499 - var10.field_507[var6] < var8 && var10.field_499 - var10.field_507[var6] > -var8) {
                        var10.field_499 = var10.field_507[var6];
                     }
                  } else {
                     var10.field_498 = var10.field_506[var6];
                     var10.field_499 = var10.field_507[var6];
                  }

                  if (var11 != -1) {
                     var10.field_502 = var11;
                  }

                  if (var10.field_498 == var10.field_506[var6] && var10.field_499 == var10.field_507[var6]) {
                     var10.field_504 = (var6 + 1) % 10;
                  }
               } else {
                  var10.field_502 = var10.field_503;
                  if (var10.field_500 == 43) {
                     ++var10.field_501;
                  }
               }

               if (var10.field_510 > 0) {
                  --var10.field_510;
               }

               if (var10.field_512 > 0) {
                  --var10.field_512;
               }

               if (var10.field_516 > 0) {
                  --var10.field_516;
               }
            }

            for(var3 = 0; var3 < this.jbb; ++var3) {
               class_13 var14 = this.nbb[var3];
               if (var14.field_525 > 0) {
                  --var14.field_525;
               }
            }

            if (this.deb) {
               if (this.bbb - this.pbb.field_498 < -500 || this.bbb - this.pbb.field_498 > 500 || this.cbb - this.pbb.field_499 < -500 || this.cbb - this.pbb.field_499 > 500) {
                  this.bbb = this.pbb.field_498;
                  this.cbb = this.pbb.field_499;
               }
            } else {
               if (this.bbb - this.pbb.field_498 < -500 || this.bbb - this.pbb.field_498 > 500 || this.cbb - this.pbb.field_499 < -500 || this.cbb - this.pbb.field_499 > 500) {
                  this.bbb = this.pbb.field_498;
                  this.cbb = this.pbb.field_499;
               }

               if (this.bbb != this.pbb.field_498) {
                  this.bbb += (this.pbb.field_498 - this.bbb) / (16 + (this.zab - 500) / 15);
               }

               if (this.cbb != this.pbb.field_499) {
                  this.cbb += (this.pbb.field_499 - this.cbb) / (16 + (this.zab - 500) / 15);
               }

               if (this.eeb) {
                  var13 = this.dbb * 32;
                  var5 = var13 - this.fbb;
                  byte var12 = 1;
                  if (var5 != 0) {
                     ++this.ebb;
                     if (var5 > 128) {
                        var12 = -1;
                        var5 = 256 - var5;
                     } else if (var5 > 0) {
                        var12 = 1;
                     } else if (var5 < -128) {
                        var12 = 1;
                        var5 += 256;
                     } else if (var5 < 0) {
                        var12 = -1;
                        var5 = -var5;
                     }

                     this.fbb += (this.ebb * var5 + 255) / 256 * var12;
                     this.fbb &= 255;
                  } else {
                     this.ebb = 0;
                  }
               }
            }

            if (super.field_140 > this.field_203 - 4) {
               if (super.field_139 > 15 && super.field_139 < 96 && super.field_142 == 1) {
                  this.gfb = 0;
               }

               if (super.field_139 > 110 && super.field_139 < 194 && super.field_142 == 1) {
                  this.gfb = 1;
                  this.bfb.field_353[this.cfb] = 999999;
               }

               if (super.field_139 > 215 && super.field_139 < 295 && super.field_142 == 1) {
                  this.gfb = 2;
                  this.bfb.field_353[this.efb] = 999999;
               }

               if (super.field_139 > 315 && super.field_139 < 395 && super.field_142 == 1) {
                  this.gfb = 3;
                  this.bfb.field_353[this.ffb] = 999999;
               }

               super.field_142 = 0;
               super.field_141 = 0;
            }

            this.bfb.method_280(super.field_139, super.field_140, super.field_142, super.field_141);
            if (this.gfb > 0 && super.field_139 >= 494 && super.field_140 >= this.field_203 - 66) {
               super.field_142 = 0;
            }

            if (this.bfb.method_281(this.dfb)) {
               String var15 = this.bfb.method_314(this.dfb);
               this.bfb.method_313(this.dfb, "");
               if (var15.startsWith("::")) {
                  if (var15.equalsIgnoreCase("::lostcon") && !this.field_181) {
                     super.field_157.method_338();
                  } else if (var15.equalsIgnoreCase("::closecon") && !this.field_181) {
                     this.method_141();
                  } else {
                     this.method_156(var15.substring(2));
                  }
               } else {
                  var5 = class_0.method_21(var15);
                  this.method_155(class_0.field_6, var5);
                  var15 = class_0.method_23(class_0.field_6, 0, var5, true);
                  this.pbb.field_510 = 150;
                  this.pbb.field_509 = var15;
                  this.method_192(this.pbb.field_495 + ": " + var15, 2);
               }
            }

            if (this.gfb == 0) {
               for(var13 = 0; var13 < this.hfb; ++var13) {
                  if (this.jfb[var13] > 0) {
                     --this.jfb[var13];
                  }
               }
            }

            if (this.sib != 0) {
               super.field_142 = 0;
            }

            if (!this.lgb && !this.kfb) {
               this.vgb = 0;
               this.wgb = 0;
            } else {
               if (super.field_141 != 0) {
                  ++this.vgb;
               } else {
                  this.vgb = 0;
               }

               if (this.vgb > 300) {
                  this.wgb += 50;
               } else if (this.vgb > 150) {
                  this.wgb += 5;
               } else if (this.vgb > 50) {
                  ++this.wgb;
               } else if (this.vgb > 20 && (this.vgb & 5) == 0) {
                  ++this.wgb;
               }
            }

            if (super.field_142 == 1) {
               this.field_184 = 1;
            } else if (super.field_142 == 2) {
               this.field_184 = 2;
            }

            this.field_197.method_371(super.field_139, super.field_140);
            super.field_142 = 0;
            if (this.eeb) {
               if (this.ebb == 0 || this.deb) {
                  if (super.field_132) {
                     this.dbb = this.dbb + 1 & 7;
                     super.field_132 = false;
                     if (!this.abb) {
                        if ((this.dbb & 1) == 0) {
                           this.dbb = this.dbb + 1 & 7;
                        }

                        for(var13 = 0; var13 < 8 && !this.method_196(this.dbb); ++var13) {
                           this.dbb = this.dbb + 1 & 7;
                        }
                     }
                  }

                  if (super.field_133) {
                     this.dbb = this.dbb + 7 & 7;
                     super.field_133 = false;
                     if (!this.abb) {
                        if ((this.dbb & 1) == 0) {
                           this.dbb = this.dbb + 7 & 7;
                        }

                        for(var13 = 0; var13 < 8 && !this.method_196(this.dbb); ++var13) {
                           this.dbb = this.dbb + 7 & 7;
                        }
                     }
                  }
               }
            } else if (super.field_132) {
               this.fbb = this.fbb + 2 & 255;
            } else if (super.field_133) {
               this.fbb = this.fbb - 2 & 255;
            }

            if (this.abb && this.zab > 550) {
               this.zab -= 4;
            } else if (!this.abb && this.zab < 750) {
               this.zab += 4;
            }

            if (this.hab > 0) {
               --this.hab;
            } else if (this.hab < 0) {
               ++this.hab;
            }

            this.field_197.method_401(17);
            ++this.cab;
            if (this.cab > 5) {
               this.cab = 0;
               this.dab = this.dab + 1 & 3;
               this.eab = (this.eab + 1) % 3;
            }

            for(var13 = 0; var13 < this.icb; ++var13) {
               var5 = this.kcb[var13];
               var6 = this.lcb[var13];
               if (var5 >= 0 && var6 >= 0 && var5 < 96 && var6 < 96 && this.mcb[var13] == 74) {
                  this.jcb[var13].method_256(1, 0, 0);
               }
            }

            for(var5 = 0; var5 < this.tmb; ++var5) {
               ++this.wmb[var5];
               if (this.wmb[var5] > 50) {
                  --this.tmb;

                  for(var6 = var5; var6 < this.tmb; ++var6) {
                     this.umb[var6] = this.umb[var6 + 1];
                     this.vmb[var6] = this.vmb[var6 + 1];
                     this.wmb[var6] = this.wmb[var6 + 1];
                     this.xmb[var6] = this.xmb[var6 + 1];
                  }
               }
            }

         }
      }
   }

   // $FF: renamed from: np (java.lang.String, int) void
   public void method_192(String var1, int var2) {
      int var3;
      if (var2 == 2 || var2 == 4 || var2 == 6) {
         while(true) {
            if (var1.length() <= 5 || var1.charAt(0) != '@' || var1.charAt(4) != '@') {
               var3 = var1.indexOf(":");
               if (var3 != -1) {
                  String var4 = var1.substring(0, var3);
                  long var5 = class_0.method_14(var4);

                  for(int var7 = 0; var7 < super.field_164; ++var7) {
                     if (super.field_165[var7] == var5) {
                        return;
                     }
                  }
               }
               break;
            }

            var1 = var1.substring(5);
         }
      }

      if (var2 == 2) {
         var1 = "@yel@" + var1;
      }

      if (var2 == 3 || var2 == 4) {
         var1 = "@whi@" + var1;
      }

      if (var2 == 6) {
         var1 = "@cya@" + var1;
      }

      if (this.gfb != 0) {
         if (var2 == 4 || var2 == 3) {
            this.xeb = 200;
         }

         if (var2 == 2 && this.gfb != 1) {
            this.yeb = 200;
         }

         if (var2 == 5 && this.gfb != 2) {
            this.zeb = 200;
         }

         if (var2 == 6 && this.gfb != 3) {
            this.afb = 200;
         }

         if (var2 == 3 && this.gfb != 0) {
            this.gfb = 0;
         }

         if (var2 == 6 && this.gfb != 3 && this.gfb != 0) {
            this.gfb = 0;
         }
      }

      for(var3 = this.hfb - 1; var3 > 0; --var3) {
         this.ifb[var3] = this.ifb[var3 - 1];
         this.jfb[var3] = this.jfb[var3 - 1];
      }

      this.ifb[0] = var1;
      this.jfb[0] = 300;
      if (var2 == 2) {
         if (this.bfb.field_353[this.cfb] == this.bfb.field_354[this.cfb] - 4) {
            this.bfb.method_312(this.cfb, var1, true);
         } else {
            this.bfb.method_312(this.cfb, var1, false);
         }
      }

      if (var2 == 5) {
         if (this.bfb.field_353[this.efb] == this.bfb.field_354[this.efb] - 4) {
            this.bfb.method_312(this.efb, var1, true);
         } else {
            this.bfb.method_312(this.efb, var1, false);
         }
      }

      if (var2 == 6) {
         if (this.bfb.field_353[this.ffb] == this.bfb.field_354[this.ffb] - 4) {
            this.bfb.method_312(this.ffb, var1, true);
            return;
         }

         this.bfb.method_312(this.ffb, var1, false);
      }

   }

   // $FF: renamed from: te (java.lang.String) void
   public void method_164(String var1) {
      if (var1.startsWith("@bor@")) {
         this.method_192(var1, 4);
      } else if (var1.startsWith("@que@")) {
         this.method_192("@whi@" + var1, 5);
      } else if (var1.startsWith("@pri@")) {
         this.method_192(var1, 6);
      } else {
         this.method_192(var1, 3);
      }
   }

   // $FF: renamed from: an (int, int, int, int) s
   public class_13 method_193(int var1, int var2, int var3, int var4) {
      if (this.mbb[var1] == null) {
         this.mbb[var1] = new class_13();
         this.mbb[var1].field_496 = var1;
         this.mbb[var1].field_497 = 0;
      }

      class_13 var5 = this.mbb[var1];
      boolean var6 = false;

      for(int var7 = 0; var7 < this.kbb; ++var7) {
         if (this.obb[var7].field_496 == var1) {
            var6 = true;
            break;
         }
      }

      if (var6) {
         var5.field_503 = var4;
         int var8 = var5.field_505;
         if (var2 != var5.field_506[var8] || var3 != var5.field_507[var8]) {
            var5.field_505 = var8 = (var8 + 1) % 10;
            var5.field_506[var8] = var2;
            var5.field_507[var8] = var3;
         }
      } else {
         var5.field_496 = var1;
         var5.field_504 = 0;
         var5.field_505 = 0;
         var5.field_506[0] = var5.field_498 = var2;
         var5.field_507[0] = var5.field_499 = var3;
         var5.field_503 = var5.field_502 = var4;
         var5.field_501 = 0;
      }

      this.nbb[this.jbb++] = var5;
      return var5;
   }

   // $FF: renamed from: xo (int, int, int, int, int) s
   public class_13 method_194(int var1, int var2, int var3, int var4, int var5) {
      if (this.xbb[var1] == null) {
         this.xbb[var1] = new class_13();
         this.xbb[var1].field_496 = var1;
      }

      class_13 var6 = this.xbb[var1];
      boolean var7 = false;

      for(int var8 = 0; var8 < this.wbb; ++var8) {
         if (this.zbb[var8].field_496 == var1) {
            var7 = true;
            break;
         }
      }

      if (var7) {
         var6.field_500 = var5;
         var6.field_503 = var4;
         int var9 = var6.field_505;
         if (var2 != var6.field_506[var9] || var3 != var6.field_507[var9]) {
            var6.field_505 = var9 = (var9 + 1) % 10;
            var6.field_506[var9] = var2;
            var6.field_507[var9] = var3;
         }
      } else {
         var6.field_496 = var1;
         var6.field_504 = 0;
         var6.field_505 = 0;
         var6.field_506[0] = var6.field_498 = var2;
         var6.field_507[0] = var6.field_499 = var3;
         var6.field_500 = var5;
         var6.field_503 = var6.field_502 = var4;
         var6.field_501 = 0;
      }

      this.ybb[this.vbb++] = var6;
      return var6;
   }

   // $FF: renamed from: pe (int, int, byte[]) void
   public void method_163(int var1, int var2, byte[] var3) {
      int var6;
      try {
         int var8;
         int var9;
         int var10;
         int var12;
         int var13;
         int var14;
         int var15;
         int var20;
         int var21;
         int var27;
         boolean var35;
         byte var39;
         if (var1 == 255) {
            this.kbb = this.jbb;

            for(var20 = 0; var20 < this.kbb; ++var20) {
               this.obb[var20] = this.nbb[var20];
            }

            var39 = 8;
            this.qbb = class_0.method_10(var3, var39, 10);
            var21 = var39 + 10;
            this.rbb = class_0.method_10(var3, var21, 12);
            var21 += 12;
            var6 = class_0.method_10(var3, var21, 4);
            var21 += 4;
            boolean var28 = this.method_214(this.qbb, this.rbb);
            this.qbb -= this.pab;
            this.rbb -= this.qab;
            var8 = this.qbb * this.field_200 + 64;
            var9 = this.rbb * this.field_200 + 64;
            if (var28) {
               this.pbb.field_505 = 0;
               this.pbb.field_504 = 0;
               this.pbb.field_498 = this.pbb.field_506[0] = var8;
               this.pbb.field_499 = this.pbb.field_507[0] = var9;
            }

            this.jbb = 0;
            this.pbb = this.method_193(this.sbb, var8, var9, var6);
            var10 = class_0.method_10(var3, var21, 8);
            var21 += 8;
            var27 = 0;

            while(true) {
               int var36;
               if (var27 >= var10) {
                  var12 = 0;

                  while(var21 + 24 < var2 * 8) {
                     var13 = class_0.method_10(var3, var21, 11);
                     var21 += 11;
                     var14 = class_0.method_10(var3, var21, 5);
                     var21 += 5;
                     if (var14 > 15) {
                        var14 -= 32;
                     }

                     var15 = class_0.method_10(var3, var21, 5);
                     var21 += 5;
                     if (var15 > 15) {
                        var15 -= 32;
                     }

                     var6 = class_0.method_10(var3, var21, 4);
                     var21 += 4;
                     var36 = class_0.method_10(var3, var21, 1);
                     ++var21;
                     var8 = (this.qbb + var14) * this.field_200 + 64;
                     var9 = (this.rbb + var15) * this.field_200 + 64;
                     this.method_193(var13, var8, var9, var6);
                     if (var36 == 0) {
                        this.acb[var12++] = var13;
                     }
                  }

                  if (var12 > 0) {
                     super.field_157.method_358(254);
                     super.field_157.method_350(var12);

                     for(var13 = 0; var13 < var12; ++var13) {
                        class_13 var40 = this.mbb[this.acb[var13]];
                        super.field_157.method_350(var40.field_496);
                        super.field_157.method_350(var40.field_497);
                     }

                     super.field_157.method_359();
                     var35 = false;
                     return;
                  }
                  break;
               }

               label1093: {
                  class_13 var38 = this.obb[var27 + 1];
                  var13 = class_0.method_10(var3, var21, 1);
                  ++var21;
                  if (var13 != 0) {
                     var14 = class_0.method_10(var3, var21, 1);
                     ++var21;
                     if (var14 == 0) {
                        var15 = class_0.method_10(var3, var21, 3);
                        var21 += 3;
                        var36 = var38.field_505;
                        int var17 = var38.field_506[var36];
                        int var18 = var38.field_507[var36];
                        if (var15 == 2 || var15 == 1 || var15 == 3) {
                           var17 += this.field_200;
                        }

                        if (var15 == 6 || var15 == 5 || var15 == 7) {
                           var17 -= this.field_200;
                        }

                        if (var15 == 4 || var15 == 3 || var15 == 5) {
                           var18 += this.field_200;
                        }

                        if (var15 == 0 || var15 == 1 || var15 == 7) {
                           var18 -= this.field_200;
                        }

                        var38.field_503 = var15;
                        var38.field_505 = var36 = (var36 + 1) % 10;
                        var38.field_506[var36] = var17;
                        var38.field_507[var36] = var18;
                     } else {
                        var15 = class_0.method_10(var3, var21, 4);
                        if ((var15 & 12) == 12) {
                           var21 += 2;
                           break label1093;
                        }

                        var38.field_503 = class_0.method_10(var3, var21, 4);
                        var21 += 4;
                     }
                  }

                  this.nbb[this.jbb++] = var38;
               }

               ++var27;
            }
         } else {
            int var7;
            if (var1 == 254) {
               var20 = 1;

               while(true) {
                  while(var20 < var2) {
                     if (class_0.method_4(var3[var20]) == 255) {
                        var21 = 0;
                        var6 = this.qbb + var3[var20 + 1] >> 3;
                        var7 = this.rbb + var3[var20 + 2] >> 3;
                        var20 += 3;

                        for(var8 = 0; var8 < this.ccb; ++var8) {
                           var9 = (this.dcb[var8] >> 3) - var6;
                           var10 = (this.ecb[var8] >> 3) - var7;
                           if (var9 != 0 || var10 != 0) {
                              if (var8 != var21) {
                                 this.dcb[var21] = this.dcb[var8];
                                 this.ecb[var21] = this.ecb[var8];
                                 this.fcb[var21] = this.fcb[var8];
                                 this.gcb[var21] = this.gcb[var8];
                              }

                              ++var21;
                           }
                        }

                        this.ccb = var21;
                     } else {
                        var21 = class_0.method_5(var3, var20);
                        var20 += 2;
                        var6 = this.qbb + var3[var20++];
                        var7 = this.rbb + var3[var20++];
                        if ((var21 & '\u8000') == 0) {
                           this.dcb[this.ccb] = var6;
                           this.ecb[this.ccb] = var7;
                           this.fcb[this.ccb] = var21;
                           this.gcb[this.ccb] = 0;

                           for(var8 = 0; var8 < this.icb; ++var8) {
                              if (this.kcb[var8] == var6 && this.lcb[var8] == var7) {
                                 this.gcb[this.ccb] = class_11.field_452[this.mcb[var8]];
                                 break;
                              }
                           }

                           ++this.ccb;
                        } else {
                           var21 &= 32767;
                           var8 = 0;

                           for(var9 = 0; var9 < this.ccb; ++var9) {
                              if (this.dcb[var9] == var6 && this.ecb[var9] == var7 && this.fcb[var9] == var21) {
                                 var21 = -123;
                              } else {
                                 if (var9 != var8) {
                                    this.dcb[var8] = this.dcb[var9];
                                    this.ecb[var8] = this.ecb[var9];
                                    this.fcb[var8] = this.fcb[var9];
                                    this.gcb[var8] = this.gcb[var9];
                                 }

                                 ++var8;
                              }
                           }

                           this.ccb = var8;
                        }
                     }
                  }

                  return;
               }
            }

            if (var1 == 253) {
               var20 = 1;

               while(true) {
                  while(var20 < var2) {
                     if (class_0.method_4(var3[var20]) == 255) {
                        var21 = 0;
                        var6 = this.qbb + var3[var20 + 1] >> 3;
                        var7 = this.rbb + var3[var20 + 2] >> 3;
                        var20 += 3;

                        for(var8 = 0; var8 < this.icb; ++var8) {
                           var9 = (this.kcb[var8] >> 3) - var6;
                           var10 = (this.lcb[var8] >> 3) - var7;
                           if (var9 == 0 && var10 == 0) {
                              this.field_197.method_364(this.jcb[var8]);
                              this.kab.method_88(this.kcb[var8], this.lcb[var8], this.mcb[var8]);
                           } else {
                              if (var8 != var21) {
                                 this.jcb[var21] = this.jcb[var8];
                                 this.jcb[var21].field_291 = var21;
                                 this.kcb[var21] = this.kcb[var8];
                                 this.lcb[var21] = this.lcb[var8];
                                 this.mcb[var21] = this.mcb[var8];
                                 this.ncb[var21] = this.ncb[var8];
                              }

                              ++var21;
                           }
                        }

                        this.icb = var21;
                     } else {
                        var21 = class_0.method_5(var3, var20);
                        var20 += 2;
                        var6 = this.qbb + var3[var20++];
                        var7 = this.rbb + var3[var20++];
                        var8 = 0;

                        for(var9 = 0; var9 < this.icb; ++var9) {
                           if (this.kcb[var9] == var6 && this.lcb[var9] == var7) {
                              this.field_197.method_364(this.jcb[var9]);
                              this.kab.method_88(this.kcb[var9], this.lcb[var9], this.mcb[var9]);
                           } else {
                              if (var9 != var8) {
                                 this.jcb[var8] = this.jcb[var9];
                                 this.jcb[var8].field_291 = var8;
                                 this.kcb[var8] = this.kcb[var9];
                                 this.lcb[var8] = this.lcb[var9];
                                 this.mcb[var8] = this.mcb[var9];
                                 this.ncb[var8] = this.ncb[var9];
                              }

                              ++var8;
                           }
                        }

                        this.icb = var8;
                        if (var21 != 60000) {
                           var10 = this.kab.method_102(var6, var7);
                           if (var10 != 0 && var10 != 4) {
                              var12 = class_11.field_449[var21];
                              var27 = class_11.field_450[var21];
                           } else {
                              var27 = class_11.field_449[var21];
                              var12 = class_11.field_450[var21];
                           }

                           var13 = (var6 + var6 + var27) * this.field_200 / 2;
                           var14 = (var7 + var7 + var12) * this.field_200 / 2;
                           var15 = class_11.field_448[var21];
                           class_8 var16 = this.ocb[var15].method_274();
                           this.field_197.method_363(var16);
                           var16.field_291 = this.icb;
                           var16.method_256(0, var10 * 32, 0);
                           var16.method_258(var13, -this.kab.method_93(var13, var14), var14);
                           var16.method_252(true, 48, 48, -50, -10, -50);
                           this.kab.method_87(var6, var7, var21);
                           if (var21 == 74) {
                              var16.method_258(0, -480, 0);
                           }

                           this.kcb[this.icb] = var6;
                           this.lcb[this.icb] = var7;
                           this.mcb[this.icb] = var21;
                           this.ncb[this.icb] = var10;
                           this.jcb[this.icb++] = var16;
                        }
                     }
                  }

                  return;
               }
            }

            byte var4;
            if (var1 == 252) {
               var4 = 1;
               var20 = var4 + 1;
               this.adb = var3[var4] & 255;

               for(var21 = 0; var21 < this.adb; ++var21) {
                  var6 = class_0.method_5(var3, var20);
                  var20 += 2;
                  this.bdb[var21] = var6 & 32767;
                  this.ddb[var21] = var6 / '\u8000';
                  if (class_11.field_409[var6 & 32767] == 0) {
                     this.cdb[var21] = class_0.method_9(var3, var20);
                     if (this.cdb[var21] >= 128) {
                        var20 += 4;
                     } else {
                        ++var20;
                     }
                  } else {
                     this.cdb[var21] = 1;
                  }
               }

               return;
            }

            class_13 var24;
            if (var1 == 250) {
               var20 = class_0.method_5(var3, 1);
               var21 = 3;

               for(var6 = 0; var6 < var20; ++var6) {
                  var7 = class_0.method_5(var3, var21);
                  var21 += 2;
                  var24 = this.mbb[var7];
                  byte var29 = var3[var21];
                  ++var21;
                  if (var29 == 0) {
                     var10 = class_0.method_5(var3, var21);
                     var21 += 2;
                     if (var24 != null) {
                        var24.field_512 = 150;
                        var24.field_511 = var10;
                     }
                  } else {
                     byte var34;
                     String var37;
                     if (var29 == 1) {
                        var34 = var3[var21];
                        ++var21;
                        if (var24 != null) {
                           var37 = class_0.method_23(var3, var21, var34, true);
                           var35 = false;

                           for(var13 = 0; var13 < super.field_164; ++var13) {
                              if (super.field_165[var13] == var24.field_494) {
                                 var35 = true;
                              }
                           }

                           if (!var35) {
                              var24.field_510 = 150;
                              var24.field_509 = var37;
                              this.method_192(var24.field_495 + ": " + var24.field_509, 2);
                           }
                        }

                        var21 += var34;
                     } else if (var29 == 2) {
                        var10 = class_0.method_4(var3[var21]);
                        ++var21;
                        var27 = class_0.method_4(var3[var21]);
                        ++var21;
                        var12 = class_0.method_4(var3[var21]);
                        ++var21;
                        if (var24 != null) {
                           var24.field_513 = var10;
                           var24.field_514 = var27;
                           var24.field_515 = var12;
                           var24.field_516 = 200;
                           if (var24 == this.pbb) {
                              this.hdb[3] = var27;
                              this.idb[3] = var12;
                              this.iib = false;
                              this.oib = false;
                           }
                        }
                     } else if (var29 == 3) {
                        var10 = class_0.method_5(var3, var21);
                        var21 += 2;
                        var27 = class_0.method_5(var3, var21);
                        var21 += 2;
                        if (var24 != null) {
                           var24.field_522 = var10;
                           var24.field_524 = var27;
                           var24.field_523 = -1;
                           var24.field_525 = this.bab;
                        }
                     } else if (var29 == 4) {
                        var10 = class_0.method_5(var3, var21);
                        var21 += 2;
                        var27 = class_0.method_5(var3, var21);
                        var21 += 2;
                        if (var24 != null) {
                           var24.field_522 = var10;
                           var24.field_523 = var27;
                           var24.field_524 = -1;
                           var24.field_525 = this.bab;
                        }
                     } else if (var29 != 5) {
                        if (var29 == 6) {
                           var34 = var3[var21];
                           ++var21;
                           if (var24 != null) {
                              var37 = class_0.method_23(var3, var21, var34, false);
                              var24.field_510 = 150;
                              var24.field_509 = var37;
                              if (var24 == this.pbb) {
                                 this.method_192(var24.field_495 + ": " + var24.field_509, 5);
                              }
                           }

                           var21 += var34;
                        }
                     } else if (var24 == null) {
                        var21 += 14;
                        var10 = class_0.method_4(var3[var21]);
                        var21 += var10 + 1;
                     } else {
                        var24.field_497 = class_0.method_5(var3, var21);
                        var21 += 2;
                        var24.field_494 = class_0.method_7(var3, var21);
                        var21 += 8;
                        var24.field_495 = class_0.method_15(var24.field_494);
                        var10 = class_0.method_4(var3[var21]);
                        ++var21;

                        for(var27 = 0; var27 < var10; ++var27) {
                           var24.field_508[var27] = class_0.method_4(var3[var21]);
                           ++var21;
                        }

                        for(var12 = var10; var12 < 12; ++var12) {
                           var24.field_508[var12] = 0;
                        }

                        var24.field_518 = var3[var21++] & 255;
                        var24.field_519 = var3[var21++] & 255;
                        var24.field_520 = var3[var21++] & 255;
                        var24.field_521 = var3[var21++] & 255;
                        var24.field_517 = var3[var21++] & 255;
                        var24.field_528 = var3[var21++] & 255;
                     }
                  }
               }

               return;
            }

            if (var1 == 249) {
               var20 = 1;

               while(true) {
                  while(var20 < var2) {
                     if (class_0.method_4(var3[var20]) == 255) {
                        var21 = 0;
                        var6 = this.qbb + var3[var20 + 1] >> 3;
                        var7 = this.rbb + var3[var20 + 2] >> 3;
                        var20 += 3;

                        for(var8 = 0; var8 < this.rcb; ++var8) {
                           var9 = (this.tcb[var8] >> 3) - var6;
                           var10 = (this.ucb[var8] >> 3) - var7;
                           if (var9 == 0 && var10 == 0) {
                              this.field_197.method_364(this.scb[var8]);
                              this.kab.method_86(this.tcb[var8], this.ucb[var8], this.vcb[var8], this.wcb[var8]);
                           } else {
                              if (var8 != var21) {
                                 this.scb[var21] = this.scb[var8];
                                 this.scb[var21].field_291 = var21 + 10000;
                                 this.tcb[var21] = this.tcb[var8];
                                 this.ucb[var21] = this.ucb[var8];
                                 this.vcb[var21] = this.vcb[var8];
                                 this.wcb[var21] = this.wcb[var8];
                              }

                              ++var21;
                           }
                        }

                        this.rcb = var21;
                     } else {
                        var21 = class_0.method_5(var3, var20);
                        var20 += 2;
                        var6 = this.qbb + var3[var20++];
                        var7 = this.rbb + var3[var20++];
                        byte var26 = var3[var20++];
                        var9 = 0;

                        for(var10 = 0; var10 < this.rcb; ++var10) {
                           if (this.tcb[var10] == var6 && this.ucb[var10] == var7 && this.vcb[var10] == var26) {
                              this.field_197.method_364(this.scb[var10]);
                              this.kab.method_86(this.tcb[var10], this.ucb[var10], this.vcb[var10], this.wcb[var10]);
                           } else {
                              if (var10 != var9) {
                                 this.scb[var9] = this.scb[var10];
                                 this.scb[var9].field_291 = var9 + 10000;
                                 this.tcb[var9] = this.tcb[var10];
                                 this.ucb[var9] = this.ucb[var10];
                                 this.vcb[var9] = this.vcb[var10];
                                 this.wcb[var9] = this.wcb[var10];
                              }

                              ++var9;
                           }
                        }

                        this.rcb = var9;
                        if (var21 != 65535) {
                           this.kab.method_85(var6, var7, var26, var21);
                           class_8 var33 = this.method_215(var6, var7, var26, var21, this.rcb);
                           this.scb[this.rcb] = var33;
                           this.tcb[this.rcb] = var6;
                           this.ucb[this.rcb] = var7;
                           this.wcb[this.rcb] = var21;
                           this.vcb[this.rcb++] = var26;
                        }
                     }
                  }

                  return;
               }
            }

            if (var1 == 248) {
               this.wbb = this.vbb;
               this.vbb = 0;

               for(var20 = 0; var20 < this.wbb; ++var20) {
                  this.zbb[var20] = this.ybb[var20];
               }

               var39 = 8;
               var6 = class_0.method_10(var3, var39, 8);
               var21 = var39 + 8;

               for(var7 = 0; var7 < var6; ++var7) {
                  var24 = this.zbb[var7];
                  var9 = class_0.method_10(var3, var21, 1);
                  ++var21;
                  if (var9 != 0) {
                     var10 = class_0.method_10(var3, var21, 1);
                     ++var21;
                     if (var10 == 0) {
                        var27 = class_0.method_10(var3, var21, 3);
                        var21 += 3;
                        var12 = var24.field_505;
                        var13 = var24.field_506[var12];
                        var14 = var24.field_507[var12];
                        if (var27 == 2 || var27 == 1 || var27 == 3) {
                           var13 += this.field_200;
                        }

                        if (var27 == 6 || var27 == 5 || var27 == 7) {
                           var13 -= this.field_200;
                        }

                        if (var27 == 4 || var27 == 3 || var27 == 5) {
                           var14 += this.field_200;
                        }

                        if (var27 == 0 || var27 == 1 || var27 == 7) {
                           var14 -= this.field_200;
                        }

                        var24.field_503 = var27;
                        var24.field_505 = var12 = (var12 + 1) % 10;
                        var24.field_506[var12] = var13;
                        var24.field_507[var12] = var14;
                     } else {
                        var27 = class_0.method_10(var3, var21, 4);
                        if ((var27 & 12) == 12) {
                           var21 += 2;
                           continue;
                        }

                        var24.field_503 = class_0.method_10(var3, var21, 4);
                        var21 += 4;
                     }
                  }

                  this.ybb[this.vbb++] = var24;
               }

               for(; var21 + 31 < var2 * 8; this.method_194(var8, var12, var13, var27, var14)) {
                  var8 = class_0.method_10(var3, var21, 11);
                  var21 += 11;
                  var9 = class_0.method_10(var3, var21, 5);
                  var21 += 5;
                  if (var9 > 15) {
                     var9 -= 32;
                  }

                  var10 = class_0.method_10(var3, var21, 5);
                  var21 += 5;
                  if (var10 > 15) {
                     var10 -= 32;
                  }

                  var27 = class_0.method_10(var3, var21, 4);
                  var21 += 4;
                  var12 = (this.qbb + var9) * this.field_200 + 64;
                  var13 = (this.rbb + var10) * this.field_200 + 64;
                  var14 = class_0.method_10(var3, var21, 9);
                  var21 += 9;
                  if (var14 >= class_11.field_415) {
                     var14 = 24;
                  }
               }

               return;
            }

            if (var1 == 247) {
               var20 = class_0.method_5(var3, 1);
               var21 = 3;

               for(var6 = 0; var6 < var20; ++var6) {
                  var7 = class_0.method_5(var3, var21);
                  var21 += 2;
                  var24 = this.xbb[var7];
                  var9 = class_0.method_4(var3[var21]);
                  ++var21;
                  if (var9 == 1) {
                     var10 = class_0.method_5(var3, var21);
                     var21 += 2;
                     byte var32 = var3[var21];
                     ++var21;
                     if (var24 != null) {
                        String var31 = class_0.method_23(var3, var21, var32, false);
                        var24.field_510 = 150;
                        var24.field_509 = var31;
                        if (var10 == this.pbb.field_496) {
                           this.method_192("@yel@" + class_11.field_416[var24.field_500] + ": " + var24.field_509, 5);
                        }
                     }

                     var21 += var32;
                  } else if (var9 == 2) {
                     var10 = class_0.method_4(var3[var21]);
                     ++var21;
                     var27 = class_0.method_4(var3[var21]);
                     ++var21;
                     var12 = class_0.method_4(var3[var21]);
                     ++var21;
                     if (var24 != null) {
                        var24.field_513 = var10;
                        var24.field_514 = var27;
                        var24.field_515 = var12;
                        var24.field_516 = 200;
                     }
                  }
               }

               return;
            }

            if (var1 == 246) {
               this.zhb = true;
               var20 = class_0.method_4(var3[1]);
               this.aib = var20;
               var21 = 2;

               for(var6 = 0; var6 < var20; ++var6) {
                  var7 = class_0.method_4(var3[var21]);
                  ++var21;
                  this.bib[var6] = new String(var3, var21, var7);
                  var21 += var7;
               }

               return;
            }

            if (var1 == 245) {
               this.zhb = false;
               return;
            }

            if (var1 == 244) {
               this.uib = true;
               this.sbb = class_0.method_5(var3, 1);
               this.lab = class_0.method_5(var3, 3);
               this.mab = class_0.method_5(var3, 5);
               this.rab = class_0.method_5(var3, 7);
               this.nab = class_0.method_5(var3, 9);
               this.mab -= this.rab * this.nab;
               return;
            }

            if (var1 == 243) {
               var20 = 1;

               for(var21 = 0; var21 < 16; ++var21) {
                  this.hdb[var21] = class_0.method_4(var3[var20++]);
               }

               for(var6 = 0; var6 < 16; ++var6) {
                  this.idb[var6] = class_0.method_4(var3[var20++]);
               }

               for(var7 = 0; var7 < 16; ++var7) {
                  this.jdb[var7] = class_0.method_6(var3, var20);
                  var20 += 4;
               }

               this.ldb = class_0.method_4(var3[var20++]);
               return;
            }

            if (var1 == 242) {
               for(var20 = 0; var20 < 5; ++var20) {
                  this.kdb[var20] = class_0.method_4(var3[1 + var20]);
               }

               return;
            }

            if (var1 == 241) {
               this.sib = 250;
               return;
            }

            if (var1 == 240) {
               var20 = (var2 - 1) / 4;

               for(var21 = 0; var21 < var20; ++var21) {
                  var6 = this.qbb + class_0.method_8(var3, 1 + var21 * 4) >> 3;
                  var7 = this.rbb + class_0.method_8(var3, 3 + var21 * 4) >> 3;
                  var8 = 0;

                  for(var9 = 0; var9 < this.ccb; ++var9) {
                     var10 = (this.dcb[var9] >> 3) - var6;
                     var27 = (this.ecb[var9] >> 3) - var7;
                     if (var10 != 0 || var27 != 0) {
                        if (var9 != var8) {
                           this.dcb[var8] = this.dcb[var9];
                           this.ecb[var8] = this.ecb[var9];
                           this.fcb[var8] = this.fcb[var9];
                           this.gcb[var8] = this.gcb[var9];
                        }

                        ++var8;
                     }
                  }

                  this.ccb = var8;
                  var8 = 0;

                  for(var10 = 0; var10 < this.icb; ++var10) {
                     var27 = (this.kcb[var10] >> 3) - var6;
                     var12 = (this.lcb[var10] >> 3) - var7;
                     if (var27 == 0 && var12 == 0) {
                        this.field_197.method_364(this.jcb[var10]);
                        this.kab.method_88(this.kcb[var10], this.lcb[var10], this.mcb[var10]);
                     } else {
                        if (var10 != var8) {
                           this.jcb[var8] = this.jcb[var10];
                           this.jcb[var8].field_291 = var8;
                           this.kcb[var8] = this.kcb[var10];
                           this.lcb[var8] = this.lcb[var10];
                           this.mcb[var8] = this.mcb[var10];
                           this.ncb[var8] = this.ncb[var10];
                        }

                        ++var8;
                     }
                  }

                  this.icb = var8;
                  var8 = 0;

                  for(var27 = 0; var27 < this.rcb; ++var27) {
                     var12 = (this.tcb[var27] >> 3) - var6;
                     var13 = (this.ucb[var27] >> 3) - var7;
                     if (var12 == 0 && var13 == 0) {
                        this.field_197.method_364(this.scb[var27]);
                        this.kab.method_86(this.tcb[var27], this.ucb[var27], this.vcb[var27], this.wcb[var27]);
                     } else {
                        if (var27 != var8) {
                           this.scb[var8] = this.scb[var27];
                           this.scb[var8].field_291 = var8 + 10000;
                           this.tcb[var8] = this.tcb[var27];
                           this.ucb[var8] = this.ucb[var27];
                           this.vcb[var8] = this.vcb[var27];
                           this.wcb[var8] = this.wcb[var27];
                        }

                        ++var8;
                     }
                  }

                  this.rcb = var8;
               }

               return;
            }

            if (var1 == 239) {
               this.cmb = true;
               return;
            }

            if (var1 == 238) {
               var20 = class_0.method_5(var3, 1);
               if (this.mbb[var20] != null) {
                  this.mgb = this.mbb[var20].field_495;
               }

               this.lgb = true;
               this.tgb = false;
               this.ugb = false;
               this.ngb = 0;
               this.qgb = 0;
               return;
            }

            if (var1 == 237) {
               this.lgb = false;
               this.ygb = false;
               return;
            }

            if (var1 == 236) {
               this.qgb = var3[1] & 255;
               var20 = 2;

               for(var21 = 0; var21 < this.qgb; ++var21) {
                  this.rgb[var21] = class_0.method_5(var3, var20);
                  var20 += 2;
                  this.sgb[var21] = class_0.method_6(var3, var20);
                  var20 += 4;
               }

               this.tgb = false;
               this.ugb = false;
               return;
            }

            byte var30;
            if (var1 == 235) {
               var30 = var3[1];
               if (var30 == 1) {
                  this.tgb = true;
                  return;
               }

               this.tgb = false;
               return;
            }

            if (var1 != 234) {
               if (var1 == 233) {
                  this.ghb = false;
                  return;
               }

               if (var1 == 229) {
                  var30 = var3[1];
                  if (var30 == 1) {
                     this.ugb = true;
                     return;
                  }

                  this.ugb = false;
                  return;
               }

               if (var1 == 228) {
                  this.eeb = class_0.method_4(var3[1]) == 1;
                  this.feb = class_0.method_4(var3[2]) == 1;
                  this.geb = class_0.method_4(var3[3]) == 1;
                  return;
               }

               if (var1 == 227) {
                  for(var20 = 0; var20 < var2 - 1; ++var20) {
                     boolean var25 = var3[var20 + 1] == 1;
                     if (!this.ceb[var20] && var25) {
                        this.method_179("prayeron");
                     }

                     if (this.ceb[var20] && !var25) {
                        this.method_179("prayeroff");
                     }

                     this.ceb[var20] = var25;
                  }

                  return;
               }

               if (var1 == 226) {
                  for(var20 = 0; var20 < this.zdb; ++var20) {
                     this.beb[var20] = var3[var20 + 1] == 1;
                  }

                  return;
               }

               if (var1 == 224) {
                  this.lkb = true;

                  for(var20 = 0; var20 < 5; ++var20) {
                     this.ukb[var20] = var20;
                     this.vkb[var20] = "~:" + this.ukb[var20];
                     this.mkb.method_313(this.rkb[var20], "");
                     this.mkb.method_313(this.qkb[var20], var20 + 1 + ": " + this.ymb[this.ukb[var20]]);
                  }

                  return;
               }

               if (var1 == 222) {
                  this.ohb = true;
                  var4 = 1;
                  var20 = var4 + 1;
                  this.phb = var3[var4] & 255;
                  this.xhb = var3[var20++] & 255;

                  for(var21 = 0; var21 < this.phb; ++var21) {
                     this.qhb[var21] = class_0.method_5(var3, var20);
                     var20 += 2;
                     this.rhb[var21] = class_0.method_9(var3, var20);
                     if (this.rhb[var21] >= 128) {
                        var20 += 4;
                     } else {
                        ++var20;
                     }
                  }

                  this.method_195();
                  return;
               }

               if (var1 == 221) {
                  this.ohb = false;
                  return;
               }

               if (var1 == 220) {
                  var20 = var3[1] & 255;
                  this.jdb[var20] = class_0.method_6(var3, 2);
                  return;
               }

               if (var1 == 219) {
                  var20 = class_0.method_5(var3, 1);
                  if (this.mbb[var20] != null) {
                     this.lfb = this.mbb[var20].field_495;
                  }

                  this.kfb = true;
                  this.mfb = 0;
                  this.pfb = 0;
                  this.sfb = false;
                  this.tfb = false;
                  this.ufb = false;
                  this.vfb = false;
                  this.wfb = false;
                  this.xfb = false;
                  return;
               }

               if (var1 == 218) {
                  this.kfb = false;
                  this.yfb = false;
                  return;
               }

               if (var1 == 217) {
                  this.ygb = true;
                  this.zgb = false;
                  this.lgb = false;
                  var4 = 1;
                  this.xgb = class_0.method_7(var3, var4);
                  var20 = var4 + 8;
                  this.dhb = var3[var20++] & 255;

                  for(var21 = 0; var21 < this.dhb; ++var21) {
                     this.ehb[var21] = class_0.method_5(var3, var20);
                     var20 += 2;
                     this.fhb[var21] = class_0.method_6(var3, var20);
                     var20 += 4;
                  }

                  this.ahb = var3[var20++] & 255;

                  for(var6 = 0; var6 < this.ahb; ++var6) {
                     this.bhb[var6] = class_0.method_5(var3, var20);
                     var20 += 2;
                     this.chb[var6] = class_0.method_6(var3, var20);
                     var20 += 4;
                  }

                  return;
               }

               if (var1 == 216) {
                  this.pfb = var3[1] & 255;
                  var20 = 2;

                  for(var21 = 0; var21 < this.pfb; ++var21) {
                     this.qfb[var21] = class_0.method_5(var3, var20);
                     var20 += 2;
                     this.rfb[var21] = class_0.method_6(var3, var20);
                     var20 += 4;
                  }

                  this.sfb = false;
                  this.tfb = false;
                  return;
               }

               if (var1 == 215) {
                  if (var3[1] == 1) {
                     this.ufb = true;
                  } else {
                     this.ufb = false;
                  }

                  if (var3[2] == 1) {
                     this.vfb = true;
                  } else {
                     this.vfb = false;
                  }

                  if (var3[3] == 1) {
                     this.wfb = true;
                  } else {
                     this.wfb = false;
                  }

                  if (var3[4] == 1) {
                     this.xfb = true;
                  } else {
                     this.xfb = false;
                  }

                  this.sfb = false;
                  this.tfb = false;
                  return;
               }

               if (var1 == 214) {
                  var4 = 1;
                  var20 = var4 + 1;
                  var21 = var3[var4] & 255;
                  var6 = class_0.method_5(var3, var20);
                  var20 += 2;
                  var7 = class_0.method_9(var3, var20);
                  if (var7 >= 128) {
                     var20 += 4;
                  } else {
                     ++var20;
                  }

                  if (var7 == 0) {
                     --this.phb;

                     for(var8 = var21; var8 < this.phb; ++var8) {
                        this.qhb[var8] = this.qhb[var8 + 1];
                        this.rhb[var8] = this.rhb[var8 + 1];
                     }
                  } else {
                     this.qhb[var21] = var6;
                     this.rhb[var21] = var7;
                     if (var21 >= this.phb) {
                        this.phb = var21 + 1;
                     }
                  }

                  this.method_195();
                  return;
               }

               if (var1 == 213) {
                  var4 = 1;
                  var21 = 1;
                  var20 = var4 + 1;
                  var6 = var3[var4] & 255;
                  var7 = class_0.method_5(var3, var20);
                  var20 += 2;
                  if (class_11.field_409[var7 & 32767] == 0) {
                     var21 = class_0.method_9(var3, var20);
                     if (var21 >= 128) {
                        var20 += 4;
                     } else {
                        ++var20;
                     }
                  }

                  this.bdb[var6] = var7 & 32767;
                  this.ddb[var6] = var7 / '\u8000';
                  this.cdb[var6] = var21;
                  if (var6 >= this.adb) {
                     this.adb = var6 + 1;
                     return;
                  }
               } else {
                  if (var1 == 212) {
                     var20 = var3[1] & 255;
                     --this.adb;

                     for(var21 = var20; var21 < this.adb; ++var21) {
                        this.bdb[var21] = this.bdb[var21 + 1];
                        this.cdb[var21] = this.cdb[var21 + 1];
                        this.ddb[var21] = this.ddb[var21 + 1];
                     }

                     return;
                  }

                  if (var1 == 211) {
                     var4 = 1;
                     var20 = var4 + 1;
                     var21 = var3[var4] & 255;
                     this.hdb[var21] = class_0.method_4(var3[var20++]);
                     this.idb[var21] = class_0.method_4(var3[var20++]);
                     this.jdb[var21] = class_0.method_6(var3, var20);
                     var20 += 4;
                     return;
                  }

                  if (var1 == 210) {
                     var30 = var3[1];
                     if (var30 == 1) {
                        this.sfb = true;
                        return;
                     }

                     this.sfb = false;
                     return;
                  }

                  if (var1 == 209) {
                     var30 = var3[1];
                     if (var30 == 1) {
                        this.tfb = true;
                        return;
                     }

                     this.tfb = false;
                     return;
                  }

                  if (var1 == 208) {
                     this.yfb = true;
                     this.zfb = false;
                     this.kfb = false;
                     var4 = 1;
                     this.agb = class_0.method_7(var3, var4);
                     var20 = var4 + 8;
                     this.egb = var3[var20++] & 255;

                     for(var21 = 0; var21 < this.egb; ++var21) {
                        this.fgb[var21] = class_0.method_5(var3, var20);
                        var20 += 2;
                        this.ggb[var21] = class_0.method_6(var3, var20);
                        var20 += 4;
                     }

                     this.bgb = var3[var20++] & 255;

                     for(var6 = 0; var6 < this.bgb; ++var6) {
                        this.cgb[var6] = class_0.method_5(var3, var20);
                        var20 += 2;
                        this.dgb[var6] = class_0.method_6(var3, var20);
                        var20 += 4;
                     }

                     this.hgb = var3[var20++] & 255;
                     this.igb = var3[var20++] & 255;
                     this.jgb = var3[var20++] & 255;
                     this.kgb = var3[var20++] & 255;
                     return;
                  }

                  if (var1 == 207) {
                     String var23 = new String(var3, 1, var2 - 1);
                     this.method_179(var23);
                     return;
                  }

                  if (var1 == 206) {
                     if (this.tmb < 50) {
                        var20 = var3[1] & 255;
                        var21 = var3[2] + this.qbb;
                        var6 = var3[3] + this.rbb;
                        this.xmb[this.tmb] = var20;
                        this.wmb[this.tmb] = 0;
                        this.umb[this.tmb] = var21;
                        this.vmb[this.tmb] = var6;
                        ++this.tmb;
                        return;
                     }
                  } else if (var1 == 205) {
                     if (!this.hib) {
                        this.lib = class_0.method_6(var3, 1);
                        this.mib = class_0.method_6(var3, 5);
                        this.jib = class_0.method_6(var3, 9);
                        this.nib = (int)(Math.random() * 6.0D);
                        this.iib = true;
                        this.hib = true;
                        this.kib = null;
                        return;
                     }
                  } else {
                     if (var1 != 204) {
                        return;
                     }

                     this.pib = new String(var3, 1, var2 - 1);
                     this.oib = true;
                  }
               }
            } else {
               this.ghb = true;
               var4 = 1;
               var20 = var4 + 1;
               var21 = var3[var4] & 255;
               byte var22 = var3[var20++];
               this.hhb = var3[var20++] & 255;
               this.ihb = var3[var20++] & 255;

               for(var7 = 0; var7 < 40; ++var7) {
                  this.jhb[var7] = -1;
               }

               for(var8 = 0; var8 < var21; ++var8) {
                  this.jhb[var8] = class_0.method_5(var3, var20);
                  var20 += 2;
                  this.khb[var8] = class_0.method_5(var3, var20);
                  var20 += 2;
                  this.lhb[var8] = var3[var20++];
               }

               if (var22 == 1) {
                  var9 = 39;

                  for(var10 = 0; var10 < this.adb && var9 >= var21; ++var10) {
                     boolean var11 = false;

                     for(var12 = 0; var12 < 40; ++var12) {
                        if (this.jhb[var12] == this.bdb[var10]) {
                           var11 = true;
                           break;
                        }
                     }

                     if (this.bdb[var10] == 10) {
                        var11 = true;
                     }

                     if (!var11) {
                        this.jhb[var9] = this.bdb[var10] & 32767;
                        this.khb[var9] = 0;
                        this.lhb[var9] = 0;
                        --var9;
                     }
                  }
               }

               if (this.mhb >= 0 && this.mhb < 40 && this.jhb[this.mhb] != this.nhb) {
                  this.mhb = -1;
                  this.nhb = -2;
                  return;
               }
            }
         }

         return;
      } catch (RuntimeException var19) {
         if (this.field_178 < 3) {
            super.field_157.method_358(17);
            super.field_157.method_354(var19.toString());
            super.field_157.method_359();
            super.field_157.method_358(17);
            super.field_157.method_354("p-type:" + var1 + " p-size:" + var2);
            super.field_157.method_359();
            super.field_157.method_358(17);
            super.field_157.method_354("rx:" + this.qbb + " ry:" + this.rbb + " num3l:" + this.icb);
            super.field_157.method_359();
            String var5 = "";

            for(var6 = 0; var6 < 80 && var6 < var2; ++var6) {
               var5 = var5 + var3[var6] + " ";
            }

            super.field_157.method_358(17);
            super.field_157.method_354(var5);
            super.field_157.method_359();
            ++this.field_178;
         }
      }

   }

   // $FF: renamed from: oo () void
   public void method_195() {
      this.shb = this.phb;

      for(int var1 = 0; var1 < this.phb; ++var1) {
         this.thb[var1] = this.qhb[var1];
         this.uhb[var1] = this.rhb[var1];
      }

      for(int var2 = 0; var2 < this.adb && this.shb < this.xhb; ++var2) {
         int var3 = this.bdb[var2];
         boolean var4 = false;

         for(int var5 = 0; var5 < this.shb; ++var5) {
            if (this.thb[var5] == var3) {
               var4 = true;
               break;
            }
         }

         if (!var4) {
            this.thb[this.shb] = var3;
            this.uhb[this.shb] = 0;
            ++this.shb;
         }
      }

   }

   // $FF: renamed from: up (int) boolean
   public boolean method_196(int var1) {
      int var2 = this.pbb.field_498 / 128;
      int var3 = this.pbb.field_499 / 128;

      for(int var4 = 2; var4 >= 1; --var4) {
         if (var1 == 1 && ((this.kab.field_95[var2][var3 - var4] & 128) == 128 || (this.kab.field_95[var2 - var4][var3] & 128) == 128 || (this.kab.field_95[var2 - var4][var3 - var4] & 128) == 128)) {
            return false;
         }

         if (var1 == 3 && ((this.kab.field_95[var2][var3 + var4] & 128) == 128 || (this.kab.field_95[var2 - var4][var3] & 128) == 128 || (this.kab.field_95[var2 - var4][var3 + var4] & 128) == 128)) {
            return false;
         }

         if (var1 == 5 && ((this.kab.field_95[var2][var3 + var4] & 128) == 128 || (this.kab.field_95[var2 + var4][var3] & 128) == 128 || (this.kab.field_95[var2 + var4][var3 + var4] & 128) == 128)) {
            return false;
         }

         if (var1 == 7 && ((this.kab.field_95[var2][var3 - var4] & 128) == 128 || (this.kab.field_95[var2 + var4][var3] & 128) == 128 || (this.kab.field_95[var2 + var4][var3 - var4] & 128) == 128)) {
            return false;
         }

         if (var1 == 0 && (this.kab.field_95[var2][var3 - var4] & 128) == 128) {
            return false;
         }

         if (var1 == 2 && (this.kab.field_95[var2 - var4][var3] & 128) == 128) {
            return false;
         }

         if (var1 == 4 && (this.kab.field_95[var2][var3 + var4] & 128) == 128) {
            return false;
         }

         if (var1 == 6 && (this.kab.field_95[var2 + var4][var3] & 128) == 128) {
            return false;
         }
      }

      return true;
   }

   // $FF: renamed from: kn () void
   public void method_197() {
      if ((this.dbb & 1) != 1 || !this.method_196(this.dbb)) {
         if ((this.dbb & 1) == 0 && this.method_196(this.dbb)) {
            if (this.method_196(this.dbb + 1 & 7)) {
               this.dbb = this.dbb + 1 & 7;
            } else {
               if (this.method_196(this.dbb + 7 & 7)) {
                  this.dbb = this.dbb + 7 & 7;
               }

            }
         } else {
            int[] var1 = new int[]{1, -1, 2, -2, 3, -3, 4};

            for(int var2 = 0; var2 < 7; ++var2) {
               if (this.method_196(this.dbb + var1[var2] + 8 & 7)) {
                  this.dbb = this.dbb + var1[var2] + 8 & 7;
                  break;
               }
            }

            if ((this.dbb & 1) == 0 && this.method_196(this.dbb)) {
               if (this.method_196(this.dbb + 1 & 7)) {
                  this.dbb = this.dbb + 1 & 7;
               } else {
                  if (this.method_196(this.dbb + 7 & 7)) {
                     this.dbb = this.dbb + 7 & 7;
                  }

               }
            }
         }
      }
   }

   // $FF: renamed from: gn () void
   public void method_198() {
      if (this.sib != 0) {
         this.field_198.method_41();
         this.field_198.method_75("Oh dear! You are dead...", this.field_202 / 2, this.field_203 / 2, 7, 16711680);
         this.method_199();
         this.field_198.method_31(this.field_196, 0, 0);
      } else if (this.cmb) {
         this.method_185();
      } else if (this.lkb) {
         this.method_182();
      } else if (this.kab.field_97) {
         for(int var1 = 0; var1 < 64; ++var1) {
            this.field_197.method_364(this.kab.field_100[this.oab][var1]);
            if (this.oab == 0) {
               this.field_197.method_364(this.kab.field_99[1][var1]);
               this.field_197.method_364(this.kab.field_100[1][var1]);
               this.field_197.method_364(this.kab.field_99[2][var1]);
               this.field_197.method_364(this.kab.field_100[2][var1]);
            }

            this.abb = true;
            if (this.oab == 0 && (this.kab.field_95[this.pbb.field_498 / 128][this.pbb.field_499 / 128] & 128) == 0) {
               this.field_197.method_363(this.kab.field_100[this.oab][var1]);
               if (this.oab == 0) {
                  this.field_197.method_363(this.kab.field_99[1][var1]);
                  this.field_197.method_363(this.kab.field_100[1][var1]);
                  this.field_197.method_363(this.kab.field_99[2][var1]);
                  this.field_197.method_363(this.kab.field_100[2][var1]);
               }

               this.abb = false;
            }
         }

         int var2;
         int var3;
         int var4;
         int var5;
         int var6;
         byte var7;
         String var8;
         int var9;
         class_8 var10;
         if (this.dab != this.fab) {
            this.fab = this.dab;

            for(var2 = 0; var2 < this.icb; ++var2) {
               if (this.mcb[var2] == 51) {
                  var3 = this.kcb[var2];
                  var4 = this.lcb[var2];
                  var5 = var3 - this.pbb.field_498 / 128;
                  var6 = var4 - this.pbb.field_499 / 128;
                  var7 = 7;
                  if (var3 >= 0 && var4 >= 0 && var3 < 96 && var4 < 96 && var5 > -var7 && var5 < var7 && var6 > -var7 && var6 < var7) {
                     this.field_197.method_364(this.jcb[var2]);
                     var8 = "torcha" + (this.dab + 1);
                     var9 = class_11.method_321(var8);
                     var10 = this.ocb[var9].method_274();
                     this.field_197.method_363(var10);
                     var10.method_252(true, 48, 48, -50, -10, -50);
                     var10.method_276(this.jcb[var2]);
                     var10.field_291 = var2;
                     this.jcb[var2] = var10;
                  }
               }

               if (this.mcb[var2] == 143) {
                  var3 = this.kcb[var2];
                  var4 = this.lcb[var2];
                  var5 = var3 - this.pbb.field_498 / 128;
                  var6 = var4 - this.pbb.field_499 / 128;
                  var7 = 7;
                  if (var3 >= 0 && var4 >= 0 && var3 < 96 && var4 < 96 && var5 > -var7 && var5 < var7 && var6 > -var7 && var6 < var7) {
                     this.field_197.method_364(this.jcb[var2]);
                     var8 = "skulltorcha" + (this.dab + 1);
                     var9 = class_11.method_321(var8);
                     var10 = this.ocb[var9].method_274();
                     this.field_197.method_363(var10);
                     var10.method_252(true, 48, 48, -50, -10, -50);
                     var10.method_276(this.jcb[var2]);
                     var10.field_291 = var2;
                     this.jcb[var2] = var10;
                  }
               }
            }
         }

         if (this.eab != this.gab) {
            this.gab = this.eab;

            for(var2 = 0; var2 < this.icb; ++var2) {
               if (this.mcb[var2] == 97) {
                  var3 = this.kcb[var2];
                  var4 = this.lcb[var2];
                  var5 = var3 - this.pbb.field_498 / 128;
                  var6 = var4 - this.pbb.field_499 / 128;
                  var7 = 9;
                  if (var3 >= 0 && var4 >= 0 && var3 < 96 && var4 < 96 && var5 > -var7 && var5 < var7 && var6 > -var7 && var6 < var7) {
                     this.field_197.method_364(this.jcb[var2]);
                     var8 = "firea" + (this.eab + 1);
                     var9 = class_11.method_321(var8);
                     var10 = this.ocb[var9].method_274();
                     this.field_197.method_363(var10);
                     var10.method_252(true, 48, 48, -50, -10, -50);
                     var10.method_276(this.jcb[var2]);
                     var10.field_291 = var2;
                     this.jcb[var2] = var10;
                  }
               }

               if (this.mcb[var2] == 274) {
                  var3 = this.kcb[var2];
                  var4 = this.lcb[var2];
                  var5 = var3 - this.pbb.field_498 / 128;
                  var6 = var4 - this.pbb.field_499 / 128;
                  var7 = 9;
                  if (var3 >= 0 && var4 >= 0 && var3 < 96 && var4 < 96 && var5 > -var7 && var5 < var7 && var6 > -var7 && var6 < var7) {
                     this.field_197.method_364(this.jcb[var2]);
                     var8 = "fireplacea" + (this.eab + 1);
                     var9 = class_11.method_321(var8);
                     var10 = this.ocb[var9].method_274();
                     this.field_197.method_363(var10);
                     var10.method_252(true, 48, 48, -50, -10, -50);
                     var10.method_276(this.jcb[var2]);
                     var10.field_291 = var2;
                     this.jcb[var2] = var10;
                  }
               }
            }
         }

         this.field_197.method_367(this.lbb);
         this.lbb = 0;

         int var18;
         for(var2 = 0; var2 < this.jbb; ++var2) {
            class_13 var15 = this.nbb[var2];
            if (var15.field_520 != 255) {
               var4 = var15.field_498;
               var5 = var15.field_499;
               var6 = -this.kab.method_93(var4, var5);
               var18 = this.field_197.method_368(5000 + var2, var4, var6, var5, 145, 220, var2 + 10000);
               ++this.lbb;
               if (var15 == this.pbb) {
                  this.field_197.method_369(var18);
               }

               if (var15.field_502 == 8) {
                  this.field_197.method_370(var18, -30);
               }

               if (var15.field_502 == 9) {
                  this.field_197.method_370(var18, 30);
               }
            }
         }

         class_13 var17;
         int var19;
         for(var3 = 0; var3 < this.jbb; ++var3) {
            class_13 var16 = this.nbb[var3];
            if (var16.field_525 > 0) {
               var17 = null;
               if (var16.field_524 != -1) {
                  var17 = this.xbb[var16.field_524];
               } else if (var16.field_523 != -1) {
                  var17 = this.mbb[var16.field_523];
               }

               if (var17 != null) {
                  var6 = var16.field_498;
                  var18 = var16.field_499;
                  var19 = -this.kab.method_93(var6, var18) - 110;
                  var9 = var17.field_498;
                  int var20 = var17.field_499;
                  int var11 = -this.kab.method_93(var9, var20) - class_11.field_429[var17.field_500] / 2;
                  int var12 = (var6 * var16.field_525 + var9 * (this.bab - var16.field_525)) / this.bab;
                  int var13 = (var19 * var16.field_525 + var11 * (this.bab - var16.field_525)) / this.bab;
                  int var14 = (var18 * var16.field_525 + var20 * (this.bab - var16.field_525)) / this.bab;
                  this.field_197.method_368(this.field_208 + var16.field_522, var12, var13, var14, 32, 32, 0);
                  ++this.lbb;
               }
            }
         }

         for(var4 = 0; var4 < this.vbb; ++var4) {
            var17 = this.ybb[var4];
            var6 = var17.field_498;
            var18 = var17.field_499;
            var19 = -this.kab.method_93(var6, var18);
            var9 = this.field_197.method_368(20000 + var4, var6, var19, var18, class_11.field_428[var17.field_500], class_11.field_429[var17.field_500], var4 + 30000);
            ++this.lbb;
            if (var17.field_502 == 8) {
               this.field_197.method_370(var9, -30);
            }

            if (var17.field_502 == 9) {
               this.field_197.method_370(var9, 30);
            }
         }

         for(var5 = 0; var5 < this.ccb; ++var5) {
            var6 = this.dcb[var5] * this.field_200 + 64;
            var18 = this.ecb[var5] * this.field_200 + 64;
            this.field_197.method_368('\u9c40' + this.fcb[var5], var6, -this.kab.method_93(var6, var18) - this.gcb[var5], var18, 96, 64, var5 + 20000);
            ++this.lbb;
         }

         for(var6 = 0; var6 < this.tmb; ++var6) {
            var18 = this.umb[var6] * this.field_200 + 64;
            var19 = this.vmb[var6] * this.field_200 + 64;
            var9 = this.xmb[var6];
            if (var9 == 0) {
               this.field_197.method_368('\uc350' + var6, var18, -this.kab.method_93(var18, var19), var19, 128, 256, var6 + '\uc350');
               ++this.lbb;
            }

            if (var9 == 1) {
               this.field_197.method_368('\uc350' + var6, var18, -this.kab.method_93(var18, var19), var19, 128, 64, var6 + '\uc350');
               ++this.lbb;
            }
         }

         this.field_198.field_34 = false;
         this.field_198.method_32();
         this.field_198.field_34 = super.field_145;
         if (this.oab == 3) {
            var18 = 40 + (int)(Math.random() * 3.0D);
            var19 = 40 + (int)(Math.random() * 7.0D);
            this.field_197.method_404(var18, var19, -50, -10, -50);
         }

         this.qlb = 0;
         this.klb = 0;
         this.vlb = 0;
         if (this.deb) {
            if (this.eeb && !this.abb) {
               var18 = this.dbb;
               this.method_197();
               if (this.dbb != var18) {
                  this.bbb = this.pbb.field_498;
                  this.cbb = this.pbb.field_499;
               }
            }

            this.field_197.field_588 = 3000;
            this.field_197.field_589 = 3000;
            this.field_197.field_590 = 1;
            this.field_197.field_591 = 2800;
            this.fbb = this.dbb * 32;
            var18 = this.bbb + this.field_191;
            var19 = this.cbb + this.field_193;
            this.field_197.method_392(var18, -this.kab.method_93(var18, var19), var19, 912, this.fbb * 4, 0, 2000);
         } else {
            if (this.eeb && !this.abb) {
               this.method_197();
            }

            if (!super.field_145) {
               this.field_197.field_588 = 2400;
               this.field_197.field_589 = 2400;
               this.field_197.field_590 = 1;
               this.field_197.field_591 = 2300;
            } else {
               this.field_197.field_588 = 2200;
               this.field_197.field_589 = 2200;
               this.field_197.field_590 = 1;
               this.field_197.field_591 = 2100;
            }

            var18 = this.bbb + this.field_191;
            var19 = this.cbb + this.field_193;
            this.field_197.method_392(var18, -this.kab.method_93(var18, var19), var19, 912, this.fbb * 4, 0, this.zab * 2);
         }

         this.field_197.method_380();
         this.method_204();
         if (this.hab > 0) {
            this.field_198.method_52(this.iab - 8, this.jab - 8, this.field_205 + 14 + (24 - this.hab) / 6);
         }

         if (this.hab < 0) {
            this.field_198.method_52(this.iab - 8, this.jab - 8, this.field_205 + 18 + (24 + this.hab) / 6);
         }

         if (!this.uib) {
            var18 = 2203 - (this.rbb + this.mab + this.qab);
            if (this.qbb + this.lab + this.pab >= 2640) {
               var18 = -50;
            }

            if (var18 > 0) {
               var19 = 1 + var18 / 6;
               this.field_198.method_52(453, this.field_203 - 56, this.field_205 + 13);
               this.field_198.method_75("Wilderness", 465, this.field_203 - 20, 1, 16776960);
               this.field_198.method_75("Level: " + var19, 465, this.field_203 - 7, 1, 16776960);
               if (this.tib == 0) {
                  this.tib = 2;
               }
            }

            if (this.tib == 0 && var18 > -10 && var18 <= 0) {
               this.tib = 1;
            }
         }

         if (this.gfb == 0) {
            for(var18 = 0; var18 < this.hfb; ++var18) {
               if (this.jfb[var18] > 0) {
                  var8 = this.ifb[var18];
                  this.field_198.method_77(var8, 7, this.field_203 - 18 - var18 * 12, 1, 16776960);
               }
            }
         }

         this.bfb.method_316(this.cfb);
         this.bfb.method_316(this.efb);
         this.bfb.method_316(this.ffb);
         if (this.gfb == 1) {
            this.bfb.method_315(this.cfb);
         } else if (this.gfb == 2) {
            this.bfb.method_315(this.efb);
         } else if (this.gfb == 3) {
            this.bfb.method_315(this.ffb);
         }

         class_9.field_391 = 2;
         this.bfb.method_283();
         class_9.field_391 = 0;
         this.field_198.method_54(this.field_198.field_10 - 3 - 197, 3, this.field_205, 128);
         this.method_216();
         this.field_198.field_38 = false;
         this.method_199();
         this.field_198.method_31(this.field_196, 0, 0);
      }
   }

   // $FF: renamed from: dn () void
   public void method_199() {
      this.field_198.method_52(0, this.field_203 - 4, this.field_205 + 23);
      int var1 = class_1.method_43(200, 200, 255);
      if (this.gfb == 0) {
         var1 = class_1.method_43(255, 200, 50);
      }

      if (this.xeb % 30 > 15) {
         var1 = class_1.method_43(255, 50, 50);
      }

      this.field_198.method_75("All messages", 54, this.field_203 + 6, 0, var1);
      var1 = class_1.method_43(200, 200, 255);
      if (this.gfb == 1) {
         var1 = class_1.method_43(255, 200, 50);
      }

      if (this.yeb % 30 > 15) {
         var1 = class_1.method_43(255, 50, 50);
      }

      this.field_198.method_75("Chat history", 155, this.field_203 + 6, 0, var1);
      var1 = class_1.method_43(200, 200, 255);
      if (this.gfb == 2) {
         var1 = class_1.method_43(255, 200, 50);
      }

      if (this.zeb % 30 > 15) {
         var1 = class_1.method_43(255, 50, 50);
      }

      this.field_198.method_75("Quest history", 255, this.field_203 + 6, 0, var1);
      var1 = class_1.method_43(200, 200, 255);
      if (this.gfb == 3) {
         var1 = class_1.method_43(255, 200, 50);
      }

      if (this.afb % 30 > 15) {
         var1 = class_1.method_43(255, 50, 50);
      }

      this.field_198.method_75("Private history", 355, this.field_203 + 6, 0, var1);
   }

   // $FF: renamed from: bp (int, int, int, int, int, int, int) void
   public void method_200(int var1, int var2, int var3, int var4, int var5, int var6, int var7) {
      int var8 = this.xmb[var5];
      int var9 = this.wmb[var5];
      int var10;
      if (var8 == 0) {
         var10 = 255 + var9 * 5 * 256;
         this.field_198.method_33(var1 + var3 / 2, var2 + var4 / 2, 20 + var9 * 2, var10, 255 - var9 * 5);
      }

      if (var8 == 1) {
         var10 = 16711680 + var9 * 5 * 256;
         this.field_198.method_33(var1 + var3 / 2, var2 + var4 / 2, 10 + var9, var10, 255 - var9 * 5);
      }

   }

   // $FF: renamed from: kp (int, int, int, int, int, int, int) void
   public void method_201(int var1, int var2, int var3, int var4, int var5, int var6, int var7) {
      int var8 = class_11.field_407[var5] + this.field_207;
      int var9 = class_11.field_412[var5];
      this.field_198.method_68(var1, var2, var3, var4, var8, var9, 0, 0, false);
   }

   // $FF: renamed from: ap (int, int, int, int, int, int, int) void
   public void method_202(int var1, int var2, int var3, int var4, int var5, int var6, int var7) {
      class_13 var8 = this.ybb[var5];
      int var9 = var8.field_502 + (this.fbb + 16) / 32 & 7;
      boolean var10 = false;
      int var11 = var9;
      if (var9 == 5) {
         var11 = 3;
         var10 = true;
      } else if (var9 == 6) {
         var11 = 2;
         var10 = true;
      } else if (var9 == 7) {
         var11 = 1;
         var10 = true;
      }

      int var12 = var11 * 3 + this.omb[var8.field_501 / class_11.field_430[var8.field_500] % 4];
      if (var8.field_502 == 8) {
         var11 = 5;
         var9 = 2;
         var10 = false;
         var1 -= class_11.field_432[var8.field_500] * var7 / 100;
         var12 = var11 * 3 + this.pmb[this.field_182 / (class_11.field_431[var8.field_500] - 1) % 8];
      } else if (var8.field_502 == 9) {
         var11 = 5;
         var9 = 2;
         var10 = true;
         var1 += class_11.field_432[var8.field_500] * var7 / 100;
         var12 = var11 * 3 + this.qmb[this.field_182 / class_11.field_431[var8.field_500] % 8];
      }

      int var14;
      int var15;
      for(int var13 = 0; var13 < 12; ++var13) {
         var14 = this.bmb[var9][var13];
         var15 = class_11.field_423[var8.field_500][var14];
         if (var15 >= 0) {
            byte var16 = 0;
            byte var17 = 0;
            int var18 = var12;
            if (var10 && var11 >= 1 && var11 <= 3 && class_11.field_441[var15] == 1) {
               var18 = var12 + 15;
            }

            if (var11 != 5 || class_11.field_440[var15] == 1) {
               int var19 = var18 + class_11.field_442[var15];
               int var23 = var16 * var3 / this.field_198.field_27[var19];
               int var24 = var17 * var4 / this.field_198.field_28[var19];
               int var20 = var3 * this.field_198.field_27[var19] / this.field_198.field_27[class_11.field_442[var15]];
               var23 -= (var20 - var3) / 2;
               int var21 = class_11.field_438[var15];
               int var22 = 0;
               if (var21 == 1) {
                  var21 = class_11.field_424[var8.field_500];
                  var22 = class_11.field_427[var8.field_500];
               } else if (var21 == 2) {
                  var21 = class_11.field_425[var8.field_500];
                  var22 = class_11.field_427[var8.field_500];
               } else if (var21 == 3) {
                  var21 = class_11.field_426[var8.field_500];
                  var22 = class_11.field_427[var8.field_500];
               }

               this.field_198.method_68(var1 + var23, var2 + var24, var20, var4, var19, var21, var22, var6, var10);
            }
         }
      }

      if (var8.field_510 > 0) {
         this.olb[this.klb] = this.field_198.method_81(var8.field_509, 1) / 2;
         if (this.olb[this.klb] > 150) {
            this.olb[this.klb] = 150;
         }

         this.plb[this.klb] = this.field_198.method_81(var8.field_509, 1) / 300 * this.field_198.method_80(1);
         this.mlb[this.klb] = var1 + var3 / 2;
         this.nlb[this.klb] = var2;
         this.llb[this.klb++] = var8.field_509;
      }

      if (var8.field_502 == 8 || var8.field_502 == 9 || var8.field_516 != 0) {
         if (var8.field_516 > 0) {
            var14 = var1;
            if (var8.field_502 == 8) {
               var14 = var1 - 20 * var7 / 100;
            } else if (var8.field_502 == 9) {
               var14 = var1 + 20 * var7 / 100;
            }

            var15 = var8.field_514 * 30 / var8.field_515;
            this.wlb[this.vlb] = var14 + var3 / 2;
            this.xlb[this.vlb] = var2;
            this.ylb[this.vlb++] = var15;
         }

         if (var8.field_516 > 150) {
            var14 = var1;
            if (var8.field_502 == 8) {
               var14 = var1 - 10 * var7 / 100;
            } else if (var8.field_502 == 9) {
               var14 = var1 + 10 * var7 / 100;
            }

            this.field_198.method_52(var14 + var3 / 2 - 12, var2 + var4 / 2 - 12, this.field_205 + 12);
            this.field_198.method_75(String.valueOf(var8.field_513), var14 + var3 / 2 - 1, var2 + var4 / 2 + 5, 3, 16777215);
         }
      }

   }

   // $FF: renamed from: co (int, int, int, int, int, int, int) void
   public void method_203(int var1, int var2, int var3, int var4, int var5, int var6, int var7) {
      class_13 var8 = this.nbb[var5];
      if (var8.field_520 != 255) {
         int var9 = var8.field_502 + (this.fbb + 16) / 32 & 7;
         boolean var10 = false;
         int var11 = var9;
         if (var9 == 5) {
            var11 = 3;
            var10 = true;
         } else if (var9 == 6) {
            var11 = 2;
            var10 = true;
         } else if (var9 == 7) {
            var11 = 1;
            var10 = true;
         }

         int var12 = var11 * 3 + this.omb[var8.field_501 / 6 % 4];
         if (var8.field_502 == 8) {
            var11 = 5;
            var9 = 2;
            var10 = false;
            var1 -= 5 * var7 / 100;
            var12 = var11 * 3 + this.pmb[this.field_182 / 5 % 8];
         } else if (var8.field_502 == 9) {
            var11 = 5;
            var9 = 2;
            var10 = true;
            var1 += 5 * var7 / 100;
            var12 = var11 * 3 + this.qmb[this.field_182 / 6 % 8];
         }

         int var14;
         int var15;
         int var23;
         for(int var13 = 0; var13 < 12; ++var13) {
            var14 = this.bmb[var9][var13];
            var15 = var8.field_508[var14] - 1;
            if (var15 >= 0) {
               byte var16 = 0;
               byte var17 = 0;
               int var18 = var12;
               if (var10 && var11 >= 1 && var11 <= 3) {
                  if (class_11.field_441[var15] == 1) {
                     var18 = var12 + 15;
                  } else if (var14 == 4 && var11 == 1) {
                     var16 = -22;
                     var17 = -3;
                     var18 = var11 * 3 + this.omb[(2 + var8.field_501 / 6) % 4];
                  } else if (var14 == 4 && var11 == 2) {
                     var16 = 0;
                     var17 = -8;
                     var18 = var11 * 3 + this.omb[(2 + var8.field_501 / 6) % 4];
                  } else if (var14 == 4 && var11 == 3) {
                     var16 = 26;
                     var17 = -5;
                     var18 = var11 * 3 + this.omb[(2 + var8.field_501 / 6) % 4];
                  } else if (var14 == 3 && var11 == 1) {
                     var16 = 22;
                     var17 = 3;
                     var18 = var11 * 3 + this.omb[(2 + var8.field_501 / 6) % 4];
                  } else if (var14 == 3 && var11 == 2) {
                     var16 = 0;
                     var17 = 8;
                     var18 = var11 * 3 + this.omb[(2 + var8.field_501 / 6) % 4];
                  } else if (var14 == 3 && var11 == 3) {
                     var16 = -26;
                     var17 = 5;
                     var18 = var11 * 3 + this.omb[(2 + var8.field_501 / 6) % 4];
                  }
               }

               if (var11 != 5 || class_11.field_440[var15] == 1) {
                  int var19 = var18 + class_11.field_442[var15];
                  var23 = var16 * var3 / this.field_198.field_27[var19];
                  int var24 = var17 * var4 / this.field_198.field_28[var19];
                  int var20 = var3 * this.field_198.field_27[var19] / this.field_198.field_27[class_11.field_442[var15]];
                  var23 -= (var20 - var3) / 2;
                  int var21 = class_11.field_438[var15];
                  int var22 = this.nmb[var8.field_521];
                  if (var21 == 1) {
                     var21 = this.mmb[var8.field_518];
                  } else if (var21 == 2) {
                     var21 = this.lmb[var8.field_519];
                  } else if (var21 == 3) {
                     var21 = this.lmb[var8.field_520];
                  }

                  this.field_198.method_68(var1 + var23, var2 + var24, var20, var4, var19, var21, var22, var6, var10);
               }
            }
         }

         if (var8.field_510 > 0) {
            this.olb[this.klb] = this.field_198.method_81(var8.field_509, 1) / 2;
            if (this.olb[this.klb] > 150) {
               this.olb[this.klb] = 150;
            }

            this.plb[this.klb] = this.field_198.method_81(var8.field_509, 1) / 300 * this.field_198.method_80(1);
            this.mlb[this.klb] = var1 + var3 / 2;
            this.nlb[this.klb] = var2;
            this.llb[this.klb++] = var8.field_509;
         }

         if (var8.field_512 > 0) {
            this.rlb[this.qlb] = var1 + var3 / 2;
            this.slb[this.qlb] = var2;
            this.tlb[this.qlb] = var7;
            this.ulb[this.qlb++] = var8.field_511;
         }

         if (var8.field_502 == 8 || var8.field_502 == 9 || var8.field_516 != 0) {
            if (var8.field_516 > 0) {
               var14 = var1;
               if (var8.field_502 == 8) {
                  var14 = var1 - 20 * var7 / 100;
               } else if (var8.field_502 == 9) {
                  var14 = var1 + 20 * var7 / 100;
               }

               var15 = var8.field_514 * 30 / var8.field_515;
               this.wlb[this.vlb] = var14 + var3 / 2;
               this.xlb[this.vlb] = var2;
               this.ylb[this.vlb++] = var15;
            }

            if (var8.field_516 > 150) {
               var14 = var1;
               if (var8.field_502 == 8) {
                  var14 = var1 - 10 * var7 / 100;
               } else if (var8.field_502 == 9) {
                  var14 = var1 + 10 * var7 / 100;
               }

               this.field_198.method_52(var14 + var3 / 2 - 12, var2 + var4 / 2 - 12, this.field_205 + 11);
               this.field_198.method_75(String.valueOf(var8.field_513), var14 + var3 / 2 - 1, var2 + var4 / 2 + 5, 3, 16777215);
            }
         }

         if (var8.field_528 == 1 && var8.field_512 == 0) {
            var14 = var6 + var1 + var3 / 2;
            if (var8.field_502 == 8) {
               var14 -= 20 * var7 / 100;
            } else if (var8.field_502 == 9) {
               var14 += 20 * var7 / 100;
            }

            var15 = 16 * var7 / 100;
            var23 = 16 * var7 / 100;
            this.field_198.method_53(var14 - var15 / 2, var2 - var23 / 2 - 10 * var7 / 100, var15, var23, this.field_205 + 13);
         }

      }
   }

   // $FF: renamed from: vo () void
   public void method_204() {
      int var2;
      int var3;
      int var4;
      int var5;
      int var6;
      int var8;
      for(int var1 = 0; var1 < this.klb; ++var1) {
         var2 = this.field_198.method_80(1);
         var3 = this.mlb[var1];
         var4 = this.nlb[var1];
         var5 = this.olb[var1];
         var6 = this.plb[var1];
         boolean var7 = true;

         while(var7) {
            var7 = false;

            for(var8 = 0; var8 < var1; ++var8) {
               if (var4 + var6 > this.nlb[var8] - var2 && var4 - var2 < this.nlb[var8] + this.plb[var8] && var3 - var5 < this.mlb[var8] + this.olb[var8] && var3 + var5 > this.mlb[var8] - this.olb[var8] && this.nlb[var8] - var2 - var6 < var4) {
                  var4 = this.nlb[var8] - var2 - var6;
                  var7 = true;
               }
            }
         }

         this.nlb[var1] = var4;
         this.field_198.method_76(this.llb[var1], var3, var4, 1, 16776960, 300);
      }

      for(var2 = 0; var2 < this.qlb; ++var2) {
         var3 = this.rlb[var2];
         var4 = this.slb[var2];
         var5 = this.tlb[var2];
         var6 = this.ulb[var2];
         int var12 = 39 * var5 / 100;
         var8 = 27 * var5 / 100;
         int var9 = var4 - var8;
         this.field_198.method_55(var3 - var12 / 2, var9, var12, var8, this.field_205 + 9, 85);
         int var10 = 36 * var5 / 100;
         int var11 = 24 * var5 / 100;
         this.field_198.method_68(var3 - var10 / 2, var9 + var8 / 2 - var11 / 2, var10, var11, class_11.field_407[var6] + this.field_207, class_11.field_412[var6], 0, 0, false);
      }

      for(var3 = 0; var3 < this.vlb; ++var3) {
         var4 = this.wlb[var3];
         var5 = this.xlb[var3];
         var6 = this.ylb[var3];
         this.field_198.method_34(var4 - 15, var5 - 3, var6, 5, 65280, 192);
         this.field_198.method_34(var4 - 15 + var6, var5 - 3, 30 - var6, 5, 16711680, 192);
      }

   }

   // $FF: renamed from: io (int) int
   public int method_205(int var1) {
      int var2 = 0;

      for(int var3 = 0; var3 < this.adb; ++var3) {
         if (this.bdb[var3] == var1) {
            if (class_11.field_409[var1] == 1) {
               ++var2;
            } else {
               var2 += this.cdb[var3];
            }
         }
      }

      return var2;
   }

   // $FF: renamed from: hn (int, int) boolean
   public boolean method_206(int var1, int var2) {
      if (var1 == 31 && (this.method_207(197) || this.method_207(615))) {
         return true;
      } else if (var1 != 32 || !this.method_207(102) && !this.method_207(616)) {
         if (var1 == 33 && (this.method_207(101) || this.method_207(617))) {
            return true;
         } else if (var1 != 34 || !this.method_207(103) && !this.method_207(618)) {
            return this.method_205(var1) >= var2;
         } else {
            return true;
         }
      } else {
         return true;
      }
   }

   // $FF: renamed from: ao (int) boolean
   public boolean method_207(int var1) {
      for(int var2 = 0; var2 < this.adb; ++var2) {
         if (this.bdb[var2] == var1 && this.ddb[var2] == 1) {
            return true;
         }
      }

      return false;
   }

   // $FF: renamed from: cn (int, int, int) void
   public void method_208(int var1, int var2, int var3) {
      this.field_198.method_40(var1, var2, var3);
      this.field_198.method_40(var1 - 1, var2, var3);
      this.field_198.method_40(var1 + 1, var2, var3);
      this.field_198.method_40(var1, var2 - 1, var3);
      this.field_198.method_40(var1, var2 + 1, var3);
   }

   // $FF: renamed from: fp (int, int, int, int, boolean) void
   public void method_209(int var1, int var2, int var3, int var4, boolean var5) {
      this.method_213(var1, var2, var3, var4, var3, var4, false, var5);
   }

   // $FF: renamed from: pn (int, int, int, int, boolean) void
   public void method_210(int var1, int var2, int var3, int var4, boolean var5) {
      if (!this.method_213(var1, var2, var3, var4, var3, var4, false, var5)) {
         this.method_213(var1, var2, var3, var4, var3, var4, true, var5);
      }
   }

   // $FF: renamed from: ip (int, int, int, int) void
   public void method_211(int var1, int var2, int var3, int var4) {
      int var5;
      int var6;
      if (var3 != 0 && var3 != 4) {
         var6 = class_11.field_449[var4];
         var5 = class_11.field_450[var4];
      } else {
         var5 = class_11.field_449[var4];
         var6 = class_11.field_450[var4];
      }

      if (class_11.field_451[var4] != 2 && class_11.field_451[var4] != 3) {
         this.method_213(this.qbb, this.rbb, var1, var2, var1 + var5 - 1, var2 + var6 - 1, true, true);
      } else {
         if (var3 == 0) {
            --var1;
            ++var5;
         }

         if (var3 == 2) {
            ++var6;
         }

         if (var3 == 4) {
            ++var5;
         }

         if (var3 == 6) {
            --var2;
            ++var6;
         }

         this.method_213(this.qbb, this.rbb, var1, var2, var1 + var5 - 1, var2 + var6 - 1, false, true);
      }
   }

   // $FF: renamed from: cp (int, int, int) void
   public void method_212(int var1, int var2, int var3) {
      if (var3 == 0) {
         this.method_213(this.qbb, this.rbb, var1, var2 - 1, var1, var2, false, true);
      } else if (var3 == 1) {
         this.method_213(this.qbb, this.rbb, var1 - 1, var2, var1, var2, false, true);
      } else {
         this.method_213(this.qbb, this.rbb, var1, var2, var1, var2, true, true);
      }
   }

   // $FF: renamed from: bo (int, int, int, int, int, int, boolean, boolean) boolean
   public boolean method_213(int var1, int var2, int var3, int var4, int var5, int var6, boolean var7, boolean var8) {
      int var9 = this.kab.method_82(var1, var2, var3, var4, var5, var6, this.field_186, this.field_187, var7);
      if (var9 == -1) {
         return false;
      } else {
         --var9;
         var1 = this.field_186[var9];
         var2 = this.field_187[var9];
         --var9;
         if (var8) {
            super.field_157.method_358(215);
         } else {
            super.field_157.method_358(255);
         }

         super.field_157.method_350(var1 + this.pab);
         super.field_157.method_350(var2 + this.qab);

         for(int var10 = var9; var10 >= 0 && var10 > var9 - 25; --var10) {
            super.field_157.method_349(this.field_186[var10] - var1);
            super.field_157.method_349(this.field_187[var10] - var2);
         }

         super.field_157.method_359();
         this.hab = -24;
         this.iab = super.field_139;
         this.jab = super.field_140;
         return true;
      }
   }

   // $FF: renamed from: un (int, int) boolean
   public boolean method_214(int var1, int var2) {
      if (this.sib != 0) {
         this.kab.field_97 = false;
         return false;
      } else {
         this.uib = false;
         var1 += this.lab;
         var2 += this.mab;
         if (this.oab == this.rab && var1 > this.sab && var1 < this.uab && var2 > this.tab && var2 < this.vab) {
            this.kab.field_97 = true;
            return false;
         } else {
            this.field_198.method_75("Loading... Please wait", 256, 192, 1, 16777215);
            this.method_199();
            this.field_198.method_31(this.field_196, 0, 0);
            int var3 = this.pab;
            int var4 = this.qab;
            int var5 = (var1 + 24) / 48;
            int var6 = (var2 + 24) / 48;
            this.oab = this.rab;
            this.pab = var5 * 48 - 48;
            this.qab = var6 * 48 - 48;
            this.sab = var5 * 48 - 32;
            this.tab = var6 * 48 - 32;
            this.uab = var5 * 48 + 32;
            this.vab = var6 * 48 + 32;
            this.kab.method_109(var1, var2, this.oab);
            this.pab -= this.lab;
            this.qab -= this.mab;
            int var7 = this.pab - var3;
            int var8 = this.qab - var4;

            int var10;
            int var11;
            int var12;
            int var14;
            int var15;
            for(int var9 = 0; var9 < this.icb; ++var9) {
               this.kcb[var9] -= var7;
               this.lcb[var9] -= var8;
               var10 = this.kcb[var9];
               var11 = this.lcb[var9];
               var12 = this.mcb[var9];
               class_8 var13 = this.jcb[var9];

               try {
                  var14 = this.ncb[var9];
                  int var16;
                  if (var14 != 0 && var14 != 4) {
                     var16 = class_11.field_449[var12];
                     var15 = class_11.field_450[var12];
                  } else {
                     var15 = class_11.field_449[var12];
                     var16 = class_11.field_450[var12];
                  }

                  int var17 = (var10 + var10 + var15) * this.field_200 / 2;
                  int var18 = (var11 + var11 + var16) * this.field_200 / 2;
                  if (var10 >= 0 && var11 >= 0 && var10 < 96 && var11 < 96) {
                     this.field_197.method_363(var13);
                     var13.method_259(var17, -this.kab.method_93(var17, var18), var18);
                     this.kab.method_87(var10, var11, var12);
                     if (var12 == 74) {
                        var13.method_258(0, -480, 0);
                     }
                  }
               } catch (RuntimeException var20) {
                  System.out.println("Loc Error: " + var20.getMessage());
                  System.out.println("i:" + var9 + " obj:" + var13);
                  var20.printStackTrace();
               }
            }

            int var21;
            for(var10 = 0; var10 < this.rcb; ++var10) {
               this.tcb[var10] -= var7;
               this.ucb[var10] -= var8;
               var11 = this.tcb[var10];
               var12 = this.ucb[var10];
               var21 = this.wcb[var10];
               var14 = this.vcb[var10];

               try {
                  this.kab.method_85(var11, var12, var14, var21);
                  class_8 var24 = this.method_215(var11, var12, var14, var21, var10);
                  this.scb[var10] = var24;
               } catch (RuntimeException var19) {
                  System.out.println("Bound Error: " + var19.getMessage());
                  var19.printStackTrace();
               }
            }

            for(var11 = 0; var11 < this.ccb; ++var11) {
               this.dcb[var11] -= var7;
               this.ecb[var11] -= var8;
            }

            for(var12 = 0; var12 < this.jbb; ++var12) {
               class_13 var22 = this.nbb[var12];
               var22.field_498 -= var7 * this.field_200;
               var22.field_499 -= var8 * this.field_200;

               for(var14 = 0; var14 <= var22.field_505; ++var14) {
                  var22.field_506[var14] -= var7 * this.field_200;
                  var22.field_507[var14] -= var8 * this.field_200;
               }
            }

            for(var21 = 0; var21 < this.vbb; ++var21) {
               class_13 var23 = this.ybb[var21];
               var23.field_498 -= var7 * this.field_200;
               var23.field_499 -= var8 * this.field_200;

               for(var15 = 0; var15 <= var23.field_505; ++var15) {
                  var23.field_506[var15] -= var7 * this.field_200;
                  var23.field_507[var15] -= var8 * this.field_200;
               }
            }

            this.kab.field_97 = true;
            return true;
         }
      }
   }

   // $FF: renamed from: ym (int, int, int, int, int) jagex.client.q
   public class_8 method_215(int var1, int var2, int var3, int var4, int var5) {
      int var6 = var1;
      int var8 = var1;
      int var9 = var2;
      int var10 = class_11.field_459[var4];
      int var11 = class_11.field_460[var4];
      int var12 = class_11.field_458[var4];
      class_8 var13 = new class_8(4, 1);
      if (var3 == 0) {
         var8 = var1 + 1;
      }

      if (var3 == 1) {
         var9 = var2 + 1;
      }

      if (var3 == 2) {
         var6 = var1 + 1;
         var9 = var2 + 1;
      }

      if (var3 == 3) {
         var8 = var1 + 1;
         var9 = var2 + 1;
      }

      var6 *= this.field_200;
      int var7 = var2 * this.field_200;
      var8 *= this.field_200;
      var9 *= this.field_200;
      int var14 = var13.method_247(var6, -this.kab.method_93(var6, var7), var7);
      int var15 = var13.method_247(var6, -this.kab.method_93(var6, var7) - var12, var7);
      int var16 = var13.method_247(var8, -this.kab.method_93(var8, var9) - var12, var9);
      int var17 = var13.method_247(var8, -this.kab.method_93(var8, var9), var9);
      int[] var18 = new int[]{var14, var15, var16, var17};
      var13.method_249(4, var18, var10, var11);
      var13.method_252(false, 60, 24, -50, -10, -50);
      if (var1 >= 0 && var2 >= 0 && var1 < 96 && var2 < 96) {
         this.field_197.method_363(var13);
      }

      var13.field_291 = var5 + 10000;
      return var13;
   }

   // $FF: renamed from: vn () void
   public void method_216() {
      if (this.qib != 0) {
         this.method_221();
      } else if (this.iib) {
         this.method_219();
      } else if (this.oib) {
         this.method_220();
      } else if (this.tib == 1) {
         this.method_222();
      } else if (this.ohb && this.rib == 0) {
         this.method_225();
      } else if (this.ghb && this.rib == 0) {
         this.method_226();
      } else if (this.ygb) {
         this.method_227();
      } else if (this.lgb) {
         this.method_228();
      } else if (this.yfb) {
         this.method_229();
      } else if (this.kfb) {
         this.method_230();
      } else if (this.eib != 0) {
         this.method_223();
      } else if (this.dib != 0) {
         this.method_224();
      } else {
         if (this.zhb) {
            this.method_217();
         }

         if (this.pbb.field_502 == 8 || this.pbb.field_502 == 9) {
            this.method_218();
         }

         this.method_231();
         boolean var1 = !this.zhb && !this.heb;
         if (var1) {
            this.meb = 0;
         }

         if (this.ycb == 0 && var1) {
            this.method_238();
         }

         if (this.ycb == 1) {
            this.method_232(var1);
         }

         if (this.ycb == 2) {
            this.method_233(var1);
         }

         if (this.ycb == 3) {
            this.method_234(var1);
         }

         if (this.ycb == 4) {
            this.method_235(var1);
         }

         if (this.ycb == 5) {
            this.method_236(var1);
         }

         if (this.ycb == 6) {
            this.method_237(var1);
         }

         if (!this.heb && !this.zhb) {
            this.method_240();
         }

         if (this.heb && !this.zhb) {
            this.method_239();
         }
      }

      this.field_184 = 0;
   }

   // $FF: renamed from: qo () void
   public void method_217() {
      int var1;
      if (this.field_184 == 0) {
         for(var1 = 0; var1 < this.aib; ++var1) {
            int var2 = 65535;
            if (super.field_139 < this.field_198.method_81(this.bib[var1], 1) && super.field_140 > var1 * 12 && super.field_140 < 12 + var1 * 12) {
               var2 = 16711680;
            }

            this.field_198.method_77(this.bib[var1], 6, 12 + var1 * 12, 1, var2);
         }

      } else {
         for(var1 = 0; var1 < this.aib; ++var1) {
            if (super.field_139 < this.field_198.method_81(this.bib[var1], 1) && super.field_140 > var1 * 12 && super.field_140 < 12 + var1 * 12) {
               super.field_157.method_358(237);
               super.field_157.method_349(var1);
               super.field_157.method_359();
               break;
            }
         }

         this.field_184 = 0;
         this.zhb = false;
      }
   }

   // $FF: renamed from: to () void
   public void method_218() {
      byte var1 = 7;
      byte var2 = 15;
      short var3 = 175;
      int var4;
      if (this.field_184 != 0) {
         for(var4 = 0; var4 < 5; ++var4) {
            if (var4 > 0 && super.field_139 > var1 && super.field_139 < var1 + var3 && super.field_140 > var2 + var4 * 20 && super.field_140 < var2 + var4 * 20 + 20) {
               this.cib = var4 - 1;
               this.field_184 = 0;
               super.field_157.method_358(231);
               super.field_157.method_349(this.cib);
               super.field_157.method_359();
               break;
            }
         }
      }

      for(var4 = 0; var4 < 5; ++var4) {
         if (var4 == this.cib + 1) {
            this.field_198.method_34(var1, var2 + var4 * 20, var3, 20, class_1.method_43(255, 0, 0), 128);
         } else {
            this.field_198.method_34(var1, var2 + var4 * 20, var3, 20, class_1.method_43(190, 190, 190), 128);
         }

         this.field_198.method_38(var1, var2 + var4 * 20, var3, 0);
         this.field_198.method_38(var1, var2 + var4 * 20 + 20, var3, 0);
      }

      this.field_198.method_75("Select combat style", var1 + var3 / 2, var2 + 16, 3, 16777215);
      this.field_198.method_75("Controlled (+1 of each)", var1 + var3 / 2, var2 + 36, 3, 0);
      this.field_198.method_75("Aggressive (+3 strength)", var1 + var3 / 2, var2 + 56, 3, 0);
      this.field_198.method_75("Accurate   (+3 attack)", var1 + var3 / 2, var2 + 76, 3, 0);
      this.field_198.method_75("Defensive  (+3 defense)", var1 + var3 / 2, var2 + 96, 3, 0);
   }

   // $FF: renamed from: sp () void
   public void method_219() {
      short var1 = 180;
      int var2 = 167 - var1 / 2;
      this.field_198.method_36(56, 167 - var1 / 2, 400, var1, 0);
      this.field_198.method_37(56, 167 - var1 / 2, 400, var1, 16777215);
      var2 += 20;
      this.field_198.method_75("Welcome to RuneScape " + this.tjb, 256, var2, 4, 16776960);
      var2 += 30;
      this.field_198.method_75("You last logged in " + this.lib / 1440 + " days, " + this.lib / 60 % 24 + " hours ago", 256, var2, 1, 16777215);
      var2 += 15;
      String var4;
      int var5;
      if (this.kib == null) {
         this.kib = class_0.method_12(this.jib);

         try {
            this.kib = InetAddress.getByName(this.kib).getHostName();
         } catch (Exception var6) {
            var4 = var6.getMessage();
            var5 = var4.indexOf("cannot connect to");
            if (var5 != -1) {
               this.kib = var4.substring(var5 + 18);
            }
         }
      }

      this.field_198.method_75("from: " + this.kib, 256, var2, 1, 16777215);
      var2 += 15;
      var2 += 15;
      int var3;
      if (this.mib != 0) {
         var3 = 1 + this.mib / 1440;
         if (var3 > 14) {
            var3 = 14;
         }

         if (var3 == 14) {
            var4 = "Earlier today";
         } else if (var3 == 13) {
            var4 = "Yesterday";
         } else {
            var4 = 14 - var3 + " days ago";
         }

         this.field_198.method_75(var4 + " you requested new recovery questions", 256, var2, 1, 16744448);
         var2 += 15;
         this.field_198.method_75("If you do not remember making this request then", 256, var2, 1, 16744448);
         var2 += 15;
         this.field_198.method_75("cancel it and change your password immediately!", 256, var2, 1, 16744448);
         var2 += 15;
         var2 += 15;
         var5 = 16777215;
         if (super.field_140 > var2 - 12 && super.field_140 <= var2 && super.field_139 > 106 && super.field_139 < 406) {
            var5 = 16711680;
         }

         this.field_198.method_75("No that wasn't me - Cancel the request!", 256, var2, 1, var5);
         if (var5 == 16711680 && this.field_184 == 1) {
            super.field_157.method_358(196);
            super.field_157.method_359();
            this.iib = false;
         }

         var2 += 15;
         var5 = 16777215;
         if (super.field_140 > var2 - 12 && super.field_140 <= var2 && super.field_139 > 106 && super.field_139 < 406) {
            var5 = 16711680;
         }

         this.field_198.method_75("That's ok, activate the new questions in " + var3 + " days time", 256, var2, 1, var5);
         if (var5 == 16711680 && this.field_184 == 1) {
            this.iib = false;
         }
      } else {
         var2 += 7;
         this.field_198.method_75("Security tip of the day", 256, var2, 1, 16711680);
         var2 += 15;
         if (this.nib == 0) {
            this.field_198.method_75("Don't tell ANYONE your password or recovery questions!", 256, var2, 1, 16777215);
            var2 += 15;
            this.field_198.method_75("Not even people claiming to be Jagex staff.", 256, var2, 1, 16777215);
            var2 += 15;
         }

         if (this.nib == 1) {
            this.field_198.method_75("Never enter your password or recovery questions into ANY", 256, var2, 1, 16777215);
            var2 += 15;
            this.field_198.method_75("website other than this one - Not even if it looks similar.", 256, var2, 1, 16777215);
            var2 += 15;
         }

         if (this.nib == 2) {
            this.field_198.method_75("Don't use RuneScape cheats, helpers, or automaters.", 256, var2, 1, 16777215);
            var2 += 15;
            this.field_198.method_75("These programs WILL steal your password.", 256, var2, 1, 16777215);
            var2 += 15;
         }

         if (this.nib == 3) {
            this.field_198.method_75("Watch out for fake emails, and fake staff. Real staff", 256, var2, 1, 16777215);
            var2 += 15;
            this.field_198.method_75("will NEVER ask you for your password or recovery questions!", 256, var2, 1, 16777215);
            var2 += 15;
         }

         if (this.nib == 4) {
            this.field_198.method_75("Use a password your friends won't guess. Do NOT use your name!", 256, var2, 1, 16777215);
            var2 += 15;
            this.field_198.method_75("Choose a unique password which you haven't used anywhere else", 256, var2, 1, 16777215);
            var2 += 15;
         }

         if (this.nib == 5) {
            this.field_198.method_75("If possible only play runescape from your own computer", 256, var2, 1, 16777215);
            var2 += 15;
            this.field_198.method_75("Other machines could have been tampered with to steal your pass", 256, var2, 1, 16777215);
            var2 += 15;
         }

         var2 += 22;
         var3 = 16777215;
         if (super.field_140 > var2 - 12 && super.field_140 <= var2 && super.field_139 > 106 && super.field_139 < 406) {
            var3 = 16711680;
         }

         this.field_198.method_75("Click here to close window", 256, var2, 1, var3);
         if (this.field_184 == 1) {
            if (var3 == 16711680) {
               this.iib = false;
            }

            if ((super.field_139 < 86 || super.field_139 > 426) && (super.field_140 < 167 - var1 / 2 || super.field_140 > 167 + var1 / 2)) {
               this.iib = false;
            }
         }
      }

      this.field_184 = 0;
   }

   // $FF: renamed from: on () void
   public void method_220() {
      short var1 = 400;
      byte var2 = 100;
      this.field_198.method_36(256 - var1 / 2, 167 - var2 / 2, var1, var2, 0);
      this.field_198.method_37(256 - var1 / 2, 167 - var2 / 2, var1, var2, 16777215);
      this.field_198.method_76(this.pib, 256, 137, 1, 16777215, var1 - 40);
      int var3 = 157 + var2 / 2;
      int var4 = 16777215;
      if (super.field_140 > var3 - 12 && super.field_140 <= var3 && super.field_139 > 106 && super.field_139 < 406) {
         var4 = 16711680;
      }

      this.field_198.method_75("Click here to close window", 256, var3, 1, var4);
      if (this.field_184 == 1) {
         if (var4 == 16711680) {
            this.oib = false;
         }

         if ((super.field_139 < 256 - var1 / 2 || super.field_139 > 256 + var1 / 2) && (super.field_140 < 167 - var2 / 2 || super.field_140 > 167 + var2 / 2)) {
            this.oib = false;
         }
      }

      this.field_184 = 0;
   }

   // $FF: renamed from: so () void
   public void method_221() {
      this.field_198.method_36(126, 137, 260, 60, 0);
      this.field_198.method_37(126, 137, 260, 60, 16777215);
      this.field_198.method_75("Logging out...", 256, 173, 5, 16777215);
   }

   // $FF: renamed from: dp () void
   public void method_222() {
      byte var1 = 97;
      this.field_198.method_36(86, 77, 340, 180, 0);
      this.field_198.method_37(86, 77, 340, 180, 16777215);
      this.field_198.method_75("Warning! Proceed with caution", 256, var1, 4, 16711680);
      int var3 = var1 + 26;
      this.field_198.method_75("If you go much further north you will enter the", 256, var3, 1, 16777215);
      var3 += 13;
      this.field_198.method_75("wilderness. This a very dangerous area where", 256, var3, 1, 16777215);
      var3 += 13;
      this.field_198.method_75("other players can attack you!", 256, var3, 1, 16777215);
      var3 += 22;
      this.field_198.method_75("The further north you go the more dangerous it", 256, var3, 1, 16777215);
      var3 += 13;
      this.field_198.method_75("becomes, but the more treasure you will find.", 256, var3, 1, 16777215);
      var3 += 22;
      this.field_198.method_75("In the wilderness an indicator at the bottom-right", 256, var3, 1, 16777215);
      var3 += 13;
      this.field_198.method_75("of the screen will show the current level of danger", 256, var3, 1, 16777215);
      var3 += 22;
      int var2 = 16777215;
      if (super.field_140 > var3 - 12 && super.field_140 <= var3 && super.field_139 > 181 && super.field_139 < 331) {
         var2 = 16711680;
      }

      this.field_198.method_75("Click here to close window", 256, var3, 1, var2);
      if (this.field_184 != 0) {
         if (super.field_140 > var3 - 12 && super.field_140 <= var3 && super.field_139 > 181 && super.field_139 < 331) {
            this.tib = 2;
         }

         if (super.field_139 < 86 || super.field_139 > 426 || super.field_140 < 77 || super.field_140 > 257) {
            this.tib = 2;
         }

         this.field_184 = 0;
      }

   }

   // $FF: renamed from: ro () void
   public void method_223() {
      if (this.field_184 != 0) {
         this.field_184 = 0;
         if (super.field_139 < 106 || super.field_140 < 150 || super.field_139 > 406 || super.field_140 > 210) {
            this.eib = 0;
            return;
         }
      }

      short var1 = 150;
      this.field_198.method_36(106, var1, 300, 60, 0);
      this.field_198.method_37(106, var1, 300, 60, 16777215);
      int var4 = var1 + 22;
      String var2;
      int var3;
      if (this.eib == 6) {
         this.field_198.method_75("Please enter your current password", 256, var4, 4, 16777215);
         var4 += 25;
         var2 = "*";

         for(var3 = 0; var3 < super.field_146.length(); ++var3) {
            var2 = "X" + var2;
         }

         this.field_198.method_75(var2, 256, var4, 4, 16777215);
         if (super.field_147.length() > 0) {
            this.fib = super.field_147;
            super.field_146 = "";
            super.field_147 = "";
            this.eib = 1;
            return;
         }
      } else if (this.eib == 1) {
         this.field_198.method_75("Please enter your new password", 256, var4, 4, 16777215);
         var4 += 25;
         var2 = "*";

         for(var3 = 0; var3 < super.field_146.length(); ++var3) {
            var2 = "X" + var2;
         }

         this.field_198.method_75(var2, 256, var4, 4, 16777215);
         if (super.field_147.length() > 0) {
            this.gib = super.field_147;
            super.field_146 = "";
            super.field_147 = "";
            if (this.gib.length() >= 5) {
               this.eib = 2;
               return;
            }

            this.eib = 5;
            return;
         }
      } else if (this.eib == 2) {
         this.field_198.method_75("Enter password again to confirm", 256, var4, 4, 16777215);
         var4 += 25;
         var2 = "*";

         for(var3 = 0; var3 < super.field_146.length(); ++var3) {
            var2 = "X" + var2;
         }

         this.field_198.method_75(var2, 256, var4, 4, 16777215);
         if (super.field_147.length() > 0) {
            if (super.field_147.equalsIgnoreCase(this.gib)) {
               this.eib = 4;
               this.method_148(this.fib, this.gib);
               return;
            }

            this.eib = 3;
            return;
         }
      } else {
         if (this.eib == 3) {
            this.field_198.method_75("Passwords do not match!", 256, var4, 4, 16777215);
            var4 += 25;
            this.field_198.method_75("Press any key to close", 256, var4, 4, 16777215);
            return;
         }

         if (this.eib == 4) {
            this.field_198.method_75("Ok, your request has been sent", 256, var4, 4, 16777215);
            var4 += 25;
            this.field_198.method_75("Press any key to close", 256, var4, 4, 16777215);
            return;
         }

         if (this.eib == 5) {
            this.field_198.method_75("Password must be at", 256, var4, 4, 16777215);
            var4 += 25;
            this.field_198.method_75("least 5 letters long", 256, var4, 4, 16777215);
         }
      }

   }

   // $FF: renamed from: ln () void
   public void method_224() {
      if (this.field_184 != 0) {
         label118: {
            this.field_184 = 0;
            if (this.dib != 1 || super.field_139 >= 106 && super.field_140 >= 145 && super.field_139 <= 406 && super.field_140 <= 215) {
               if (this.dib == 2 && (super.field_139 < 6 || super.field_140 < 145 || super.field_139 > 506 || super.field_140 > 215)) {
                  this.dib = 0;
                  return;
               }

               if (this.dib != 3 || super.field_139 >= 106 && super.field_140 >= 145 && super.field_139 <= 406 && super.field_140 <= 215) {
                  if (super.field_139 > 236 && super.field_139 < 276 && super.field_140 > 193 && super.field_140 < 213) {
                     this.dib = 0;
                     return;
                  }
                  break label118;
               }

               this.dib = 0;
               return;
            }

            this.dib = 0;
            return;
         }
      }

      int var1 = 145;
      String var2;
      if (this.dib == 1) {
         this.field_198.method_36(106, var1, 300, 70, 0);
         this.field_198.method_37(106, var1, 300, 70, 16777215);
         var1 += 20;
         this.field_198.method_75("Enter name to add to friends list", 256, var1, 4, 16777215);
         var1 += 20;
         this.field_198.method_75(super.field_146 + "*", 256, var1, 4, 16777215);
         if (super.field_147.length() > 0) {
            var2 = super.field_147.trim();
            super.field_146 = "";
            super.field_147 = "";
            this.dib = 0;
            if (var2.length() > 0 && class_0.method_14(var2) != this.pbb.field_494) {
               this.method_152(var2);
            }
         }
      }

      if (this.dib == 2) {
         this.field_198.method_36(6, var1, 500, 70, 0);
         this.field_198.method_37(6, var1, 500, 70, 16777215);
         var1 += 20;
         this.field_198.method_75("Enter message to send to " + class_0.method_15(this.vdb), 256, var1, 4, 16777215);
         var1 += 20;
         this.field_198.method_75(super.field_148 + "*", 256, var1, 4, 16777215);
         if (super.field_149.length() > 0) {
            var2 = super.field_149;
            super.field_148 = "";
            super.field_149 = "";
            this.dib = 0;
            int var3 = class_0.method_21(var2);
            this.method_154(this.vdb, class_0.field_6, var3);
            var2 = class_0.method_23(class_0.field_6, 0, var3, true);
            this.method_164("@pri@You tell " + class_0.method_15(this.vdb) + ": " + var2);
         }
      }

      if (this.dib == 3) {
         this.field_198.method_36(106, var1, 300, 70, 0);
         this.field_198.method_37(106, var1, 300, 70, 16777215);
         var1 += 20;
         this.field_198.method_75("Enter name to add to ignore list", 256, var1, 4, 16777215);
         var1 += 20;
         this.field_198.method_75(super.field_146 + "*", 256, var1, 4, 16777215);
         if (super.field_147.length() > 0) {
            var2 = super.field_147.trim();
            super.field_146 = "";
            super.field_147 = "";
            this.dib = 0;
            if (var2.length() > 0 && class_0.method_14(var2) != this.pbb.field_494) {
               this.method_150(var2);
            }
         }
      }

      int var4 = 16777215;
      if (super.field_139 > 236 && super.field_139 < 276 && super.field_140 > 193 && super.field_140 < 213) {
         var4 = 16776960;
      }

      this.field_198.method_75("Cancel", 256, 208, 1, var4);
   }

   // $FF: renamed from: eo () void
   public void method_225() {
      short var1 = 408;
      short var2 = 334;
      if (this.yhb == 1 && this.shb <= 48) {
         this.yhb = 0;
      }

      if (this.vhb >= this.shb || this.vhb < 0) {
         this.vhb = -1;
      }

      if (this.vhb != -1 && this.thb[this.vhb] != this.whb) {
         this.vhb = -1;
         this.whb = -2;
      }

      int var3;
      int var4;
      int var5;
      int var6;
      int var7;
      int var8;
      int var9;
      if (this.field_184 != 0) {
         this.field_184 = 0;
         var3 = super.field_139 - (256 - var1 / 2);
         var4 = super.field_140 - (170 - var2 / 2);
         if (var3 >= 0 && var4 >= 12 && var3 < 408 && var4 < 280) {
            var5 = this.yhb * 48;

            for(var6 = 0; var6 < 6; ++var6) {
               for(var7 = 0; var7 < 8; ++var7) {
                  var8 = 7 + var7 * 49;
                  var9 = 28 + var6 * 34;
                  if (var3 > var8 && var3 < var8 + 49 && var4 > var9 && var4 < var9 + 34 && var5 < this.shb && this.thb[var5] != -1) {
                     this.whb = this.thb[var5];
                     this.vhb = var5;
                  }

                  ++var5;
               }
            }

            var3 = 256 - var1 / 2;
            var4 = 170 - var2 / 2;
            if (this.vhb < 0) {
               var7 = -1;
            } else {
               var7 = this.thb[this.vhb];
            }

            if (var7 != -1) {
               var5 = this.uhb[this.vhb];
               if (class_11.field_409[var7] == 1 && var5 > 1) {
                  var5 = 1;
               }

               if (var5 >= 1 && super.field_139 >= var3 + 220 && super.field_140 >= var4 + 238 && super.field_139 < var3 + 250 && super.field_140 <= var4 + 249) {
                  super.field_157.method_358(206);
                  super.field_157.method_350(var7);
                  super.field_157.method_350(1);
                  super.field_157.method_359();
               }

               if (var5 >= 5 && super.field_139 >= var3 + 250 && super.field_140 >= var4 + 238 && super.field_139 < var3 + 280 && super.field_140 <= var4 + 249) {
                  super.field_157.method_358(206);
                  super.field_157.method_350(var7);
                  super.field_157.method_350(5);
                  super.field_157.method_359();
               }

               if (var5 >= 25 && super.field_139 >= var3 + 280 && super.field_140 >= var4 + 238 && super.field_139 < var3 + 305 && super.field_140 <= var4 + 249) {
                  super.field_157.method_358(206);
                  super.field_157.method_350(var7);
                  super.field_157.method_350(25);
                  super.field_157.method_359();
               }

               if (var5 >= 100 && super.field_139 >= var3 + 305 && super.field_140 >= var4 + 238 && super.field_139 < var3 + 335 && super.field_140 <= var4 + 249) {
                  super.field_157.method_358(206);
                  super.field_157.method_350(var7);
                  super.field_157.method_350(100);
                  super.field_157.method_359();
               }

               if (var5 >= 500 && super.field_139 >= var3 + 335 && super.field_140 >= var4 + 238 && super.field_139 < var3 + 368 && super.field_140 <= var4 + 249) {
                  super.field_157.method_358(206);
                  super.field_157.method_350(var7);
                  super.field_157.method_350(500);
                  super.field_157.method_359();
               }

               if (var5 >= 2500 && super.field_139 >= var3 + 370 && super.field_140 >= var4 + 238 && super.field_139 < var3 + 400 && super.field_140 <= var4 + 249) {
                  super.field_157.method_358(206);
                  super.field_157.method_350(var7);
                  super.field_157.method_350(2500);
                  super.field_157.method_359();
               }

               if (this.method_205(var7) >= 1 && super.field_139 >= var3 + 220 && super.field_140 >= var4 + 263 && super.field_139 < var3 + 250 && super.field_140 <= var4 + 274) {
                  super.field_157.method_358(205);
                  super.field_157.method_350(var7);
                  super.field_157.method_350(1);
                  super.field_157.method_359();
               }

               if (this.method_205(var7) >= 5 && super.field_139 >= var3 + 250 && super.field_140 >= var4 + 263 && super.field_139 < var3 + 280 && super.field_140 <= var4 + 274) {
                  super.field_157.method_358(205);
                  super.field_157.method_350(var7);
                  super.field_157.method_350(5);
                  super.field_157.method_359();
               }

               if (this.method_205(var7) >= 25 && super.field_139 >= var3 + 280 && super.field_140 >= var4 + 263 && super.field_139 < var3 + 305 && super.field_140 <= var4 + 274) {
                  super.field_157.method_358(205);
                  super.field_157.method_350(var7);
                  super.field_157.method_350(25);
                  super.field_157.method_359();
               }

               if (this.method_205(var7) >= 100 && super.field_139 >= var3 + 305 && super.field_140 >= var4 + 263 && super.field_139 < var3 + 335 && super.field_140 <= var4 + 274) {
                  super.field_157.method_358(205);
                  super.field_157.method_350(var7);
                  super.field_157.method_350(100);
                  super.field_157.method_359();
               }

               if (this.method_205(var7) >= 500 && super.field_139 >= var3 + 335 && super.field_140 >= var4 + 263 && super.field_139 < var3 + 368 && super.field_140 <= var4 + 274) {
                  super.field_157.method_358(205);
                  super.field_157.method_350(var7);
                  super.field_157.method_350(500);
                  super.field_157.method_359();
               }

               if (this.method_205(var7) >= 2500 && super.field_139 >= var3 + 370 && super.field_140 >= var4 + 263 && super.field_139 < var3 + 400 && super.field_140 <= var4 + 274) {
                  super.field_157.method_358(205);
                  super.field_157.method_350(var7);
                  super.field_157.method_350(2500);
                  super.field_157.method_359();
               }
            }
         } else if (this.shb > 48 && var3 >= 120 && var3 <= 190 && var4 <= 12) {
            this.yhb = 0;
         } else {
            if (this.shb <= 48 || var3 < 190 || var3 > 260 || var4 > 12) {
               super.field_157.method_358(207);
               super.field_157.method_359();
               this.ohb = false;
               return;
            }

            this.yhb = 1;
         }
      }

      var3 = 256 - var1 / 2;
      var4 = 170 - var2 / 2;
      this.field_198.method_36(var3, var4, 408, 12, 192);
      var5 = 10000536;
      this.field_198.method_34(var3, var4 + 12, 408, 17, var5, 160);
      this.field_198.method_34(var3, var4 + 29, 8, 204, var5, 160);
      this.field_198.method_34(var3 + 399, var4 + 29, 9, 204, var5, 160);
      this.field_198.method_34(var3, var4 + 233, 408, 47, var5, 160);
      this.field_198.method_77("Bank", var3 + 1, var4 + 10, 1, 16777215);
      if (this.shb > 48) {
         var6 = 16777215;
         if (this.yhb == 0) {
            var6 = 16711680;
         } else if (super.field_139 > var3 + 120 && super.field_140 >= var4 && super.field_139 < var3 + 190 && super.field_140 < var4 + 12) {
            var6 = 16776960;
         }

         this.field_198.method_77("<page 1>", var3 + 120, var4 + 10, 1, var6);
         var6 = 16777215;
         if (this.yhb == 1) {
            var6 = 16711680;
         } else if (super.field_139 > var3 + 190 && super.field_140 >= var4 && super.field_139 < var3 + 260 && super.field_140 < var4 + 12) {
            var6 = 16776960;
         }

         this.field_198.method_77("<page 2>", var3 + 200, var4 + 10, 1, var6);
      }

      var6 = 16777215;
      if (super.field_139 > var3 + 320 && super.field_140 >= var4 && super.field_139 < var3 + 408 && super.field_140 < var4 + 12) {
         var6 = 16711680;
      }

      this.field_198.method_74("Close window", var3 + 406, var4 + 10, 1, var6);
      this.field_198.method_77("Number in bank in green", var3 + 7, var4 + 24, 1, 65280);
      this.field_198.method_77("Number held in blue", var3 + 289, var4 + 24, 1, 65535);
      var7 = 13684944;
      var8 = this.yhb * 48;

      int var10;
      for(var9 = 0; var9 < 6; ++var9) {
         for(var10 = 0; var10 < 8; ++var10) {
            int var11 = var3 + 7 + var10 * 49;
            int var12 = var4 + 28 + var9 * 34;
            if (this.vhb == var8) {
               this.field_198.method_34(var11, var12, 49, 34, 16711680, 160);
            } else {
               this.field_198.method_34(var11, var12, 49, 34, var7, 160);
            }

            this.field_198.method_37(var11, var12, 50, 35, 0);
            if (var8 < this.shb && this.thb[var8] != -1) {
               this.field_198.method_68(var11, var12, 48, 32, this.field_207 + class_11.field_407[this.thb[var8]], class_11.field_412[this.thb[var8]], 0, 0, false);
               this.field_198.method_77(String.valueOf(this.uhb[var8]), var11 + 1, var12 + 10, 1, 65280);
               this.field_198.method_74(String.valueOf(this.method_205(this.thb[var8])), var11 + 47, var12 + 29, 1, 65535);
            }

            ++var8;
         }
      }

      this.field_198.method_38(var3 + 5, var4 + 256, 398, 0);
      if (this.vhb == -1) {
         this.field_198.method_75("Select an object to withdraw or deposit", var3 + 204, var4 + 248, 3, 16776960);
      } else {
         if (this.vhb < 0) {
            var10 = -1;
         } else {
            var10 = this.thb[this.vhb];
         }

         if (var10 != -1) {
            var8 = this.uhb[this.vhb];
            if (class_11.field_409[var10] == 1 && var8 > 1) {
               var8 = 1;
            }

            if (var8 > 0) {
               this.field_198.method_77("Withdraw " + class_11.field_404[var10], var3 + 2, var4 + 248, 1, 16777215);
               var6 = 16777215;
               if (super.field_139 >= var3 + 220 && super.field_140 >= var4 + 238 && super.field_139 < var3 + 250 && super.field_140 <= var4 + 249) {
                  var6 = 16711680;
               }

               this.field_198.method_77("One", var3 + 222, var4 + 248, 1, var6);
               if (var8 >= 5) {
                  var6 = 16777215;
                  if (super.field_139 >= var3 + 250 && super.field_140 >= var4 + 238 && super.field_139 < var3 + 280 && super.field_140 <= var4 + 249) {
                     var6 = 16711680;
                  }

                  this.field_198.method_77("Five", var3 + 252, var4 + 248, 1, var6);
               }

               if (var8 >= 25) {
                  var6 = 16777215;
                  if (super.field_139 >= var3 + 280 && super.field_140 >= var4 + 238 && super.field_139 < var3 + 305 && super.field_140 <= var4 + 249) {
                     var6 = 16711680;
                  }

                  this.field_198.method_77("25", var3 + 282, var4 + 248, 1, var6);
               }

               if (var8 >= 100) {
                  var6 = 16777215;
                  if (super.field_139 >= var3 + 305 && super.field_140 >= var4 + 238 && super.field_139 < var3 + 335 && super.field_140 <= var4 + 249) {
                     var6 = 16711680;
                  }

                  this.field_198.method_77("100", var3 + 307, var4 + 248, 1, var6);
               }

               if (var8 >= 500) {
                  var6 = 16777215;
                  if (super.field_139 >= var3 + 335 && super.field_140 >= var4 + 238 && super.field_139 < var3 + 368 && super.field_140 <= var4 + 249) {
                     var6 = 16711680;
                  }

                  this.field_198.method_77("500", var3 + 337, var4 + 248, 1, var6);
               }

               if (var8 >= 2500) {
                  var6 = 16777215;
                  if (super.field_139 >= var3 + 370 && super.field_140 >= var4 + 238 && super.field_139 < var3 + 400 && super.field_140 <= var4 + 249) {
                     var6 = 16711680;
                  }

                  this.field_198.method_77("2500", var3 + 370, var4 + 248, 1, var6);
               }
            }

            if (this.method_205(var10) > 0) {
               this.field_198.method_77("Deposit " + class_11.field_404[var10], var3 + 2, var4 + 273, 1, 16777215);
               var6 = 16777215;
               if (super.field_139 >= var3 + 220 && super.field_140 >= var4 + 263 && super.field_139 < var3 + 250 && super.field_140 <= var4 + 274) {
                  var6 = 16711680;
               }

               this.field_198.method_77("One", var3 + 222, var4 + 273, 1, var6);
               if (this.method_205(var10) >= 5) {
                  var6 = 16777215;
                  if (super.field_139 >= var3 + 250 && super.field_140 >= var4 + 263 && super.field_139 < var3 + 280 && super.field_140 <= var4 + 274) {
                     var6 = 16711680;
                  }

                  this.field_198.method_77("Five", var3 + 252, var4 + 273, 1, var6);
               }

               if (this.method_205(var10) >= 25) {
                  var6 = 16777215;
                  if (super.field_139 >= var3 + 280 && super.field_140 >= var4 + 263 && super.field_139 < var3 + 305 && super.field_140 <= var4 + 274) {
                     var6 = 16711680;
                  }

                  this.field_198.method_77("25", var3 + 282, var4 + 273, 1, var6);
               }

               if (this.method_205(var10) >= 100) {
                  var6 = 16777215;
                  if (super.field_139 >= var3 + 305 && super.field_140 >= var4 + 263 && super.field_139 < var3 + 335 && super.field_140 <= var4 + 274) {
                     var6 = 16711680;
                  }

                  this.field_198.method_77("100", var3 + 307, var4 + 273, 1, var6);
               }

               if (this.method_205(var10) >= 500) {
                  var6 = 16777215;
                  if (super.field_139 >= var3 + 335 && super.field_140 >= var4 + 263 && super.field_139 < var3 + 368 && super.field_140 <= var4 + 274) {
                     var6 = 16711680;
                  }

                  this.field_198.method_77("500", var3 + 337, var4 + 273, 1, var6);
               }

               if (this.method_205(var10) >= 2500) {
                  var6 = 16777215;
                  if (super.field_139 >= var3 + 370 && super.field_140 >= var4 + 263 && super.field_139 < var3 + 400 && super.field_140 <= var4 + 274) {
                     var6 = 16711680;
                  }

                  this.field_198.method_77("2500", var3 + 370, var4 + 273, 1, var6);
               }
            }
         }

      }
   }

   // $FF: renamed from: do () void
   public void method_226() {
      int var3;
      int var4;
      int var5;
      int var6;
      int var7;
      if (this.field_184 != 0) {
         this.field_184 = 0;
         int var1 = super.field_139 - 52;
         int var2 = super.field_140 - 44;
         if (var1 < 0 || var2 < 12 || var1 >= 408 || var2 >= 246) {
            super.field_157.method_358(218);
            super.field_157.method_359();
            this.ghb = false;
            return;
         }

         var3 = 0;

         for(var4 = 0; var4 < 5; ++var4) {
            for(var5 = 0; var5 < 8; ++var5) {
               var6 = 7 + var5 * 49;
               var7 = 28 + var4 * 34;
               if (var1 > var6 && var1 < var6 + 49 && var2 > var7 && var2 < var7 + 34 && this.jhb[var3] != -1) {
                  this.mhb = var3;
                  this.nhb = this.jhb[var3];
               }

               ++var3;
            }
         }

         if (this.mhb >= 0) {
            var5 = this.jhb[this.mhb];
            if (var5 != -1) {
               if (this.khb[this.mhb] > 0 && var1 > 298 && var2 >= 204 && var1 < 408 && var2 <= 215) {
                  var6 = this.ihb + this.lhb[this.mhb];
                  if (var6 < 10) {
                     var6 = 10;
                  }

                  var7 = var6 * class_11.field_408[var5] / 100;
                  super.field_157.method_358(217);
                  super.field_157.method_350(this.jhb[this.mhb]);
                  super.field_157.method_352(var7);
                  super.field_157.method_359();
               }

               if (this.method_205(var5) > 0 && var1 > 2 && var2 >= 229 && var1 < 112 && var2 <= 240) {
                  var6 = this.hhb + this.lhb[this.mhb];
                  if (var6 < 10) {
                     var6 = 10;
                  }

                  var7 = var6 * class_11.field_408[var5] / 100;
                  super.field_157.method_358(216);
                  super.field_157.method_350(this.jhb[this.mhb]);
                  super.field_157.method_352(var7);
                  super.field_157.method_359();
               }
            }
         }
      }

      byte var11 = 52;
      byte var12 = 44;
      this.field_198.method_36(var11, var12, 408, 12, 192);
      var3 = 10000536;
      this.field_198.method_34(var11, var12 + 12, 408, 17, var3, 160);
      this.field_198.method_34(var11, var12 + 29, 8, 170, var3, 160);
      this.field_198.method_34(var11 + 399, var12 + 29, 9, 170, var3, 160);
      this.field_198.method_34(var11, var12 + 199, 408, 47, var3, 160);
      this.field_198.method_77("Buying and selling items", var11 + 1, var12 + 10, 1, 16777215);
      var4 = 16777215;
      if (super.field_139 > var11 + 320 && super.field_140 >= var12 && super.field_139 < var11 + 408 && super.field_140 < var12 + 12) {
         var4 = 16711680;
      }

      this.field_198.method_74("Close window", var11 + 406, var12 + 10, 1, var4);
      this.field_198.method_77("Shops stock in green", var11 + 2, var12 + 24, 1, 65280);
      this.field_198.method_77("Number you own in blue", var11 + 135, var12 + 24, 1, 65535);
      this.field_198.method_77("Your money: " + this.method_205(10) + "gp", var11 + 280, var12 + 24, 1, 16776960);
      var5 = 13684944;
      var6 = 0;

      int var8;
      int var9;
      int var10;
      for(var7 = 0; var7 < 5; ++var7) {
         for(var8 = 0; var8 < 8; ++var8) {
            var9 = var11 + 7 + var8 * 49;
            var10 = var12 + 28 + var7 * 34;
            if (this.mhb == var6) {
               this.field_198.method_34(var9, var10, 49, 34, 16711680, 160);
            } else {
               this.field_198.method_34(var9, var10, 49, 34, var5, 160);
            }

            this.field_198.method_37(var9, var10, 50, 35, 0);
            if (this.jhb[var6] != -1) {
               this.field_198.method_68(var9, var10, 48, 32, this.field_207 + class_11.field_407[this.jhb[var6]], class_11.field_412[this.jhb[var6]], 0, 0, false);
               this.field_198.method_77(String.valueOf(this.khb[var6]), var9 + 1, var10 + 10, 1, 65280);
               this.field_198.method_74(String.valueOf(this.method_205(this.jhb[var6])), var9 + 47, var10 + 10, 1, 65535);
            }

            ++var6;
         }
      }

      this.field_198.method_38(var11 + 5, var12 + 222, 398, 0);
      if (this.mhb == -1) {
         this.field_198.method_75("Select an object to buy or sell", var11 + 204, var12 + 214, 3, 16776960);
      } else {
         var8 = this.jhb[this.mhb];
         if (var8 != -1) {
            if (this.khb[this.mhb] > 0) {
               var9 = this.ihb + this.lhb[this.mhb];
               if (var9 < 10) {
                  var9 = 10;
               }

               var10 = var9 * class_11.field_408[var8] / 100;
               this.field_198.method_77("Buy a new " + class_11.field_404[var8] + " for " + var10 + "gp", var11 + 2, var12 + 214, 1, 16776960);
               var4 = 16777215;
               if (super.field_139 > var11 + 298 && super.field_140 >= var12 + 204 && super.field_139 < var11 + 408 && super.field_140 <= var12 + 215) {
                  var4 = 16711680;
               }

               this.field_198.method_74("Click here to buy", var11 + 405, var12 + 214, 3, var4);
            } else {
               this.field_198.method_75("This item is not currently available to buy", var11 + 204, var12 + 214, 3, 16776960);
            }

            if (this.method_205(var8) > 0) {
               var9 = this.hhb + this.lhb[this.mhb];
               if (var9 < 10) {
                  var9 = 10;
               }

               var10 = var9 * class_11.field_408[var8] / 100;
               this.field_198.method_74("Sell your " + class_11.field_404[var8] + " for " + var10 + "gp", var11 + 405, var12 + 239, 1, 16776960);
               var4 = 16777215;
               if (super.field_139 > var11 + 2 && super.field_140 >= var12 + 229 && super.field_139 < var11 + 112 && super.field_140 <= var12 + 240) {
                  var4 = 16711680;
               }

               this.field_198.method_77("Click here to sell", var11 + 2, var12 + 239, 3, var4);
               return;
            }

            this.field_198.method_75("You do not have any of this item to sell", var11 + 204, var12 + 239, 3, 16776960);
         }

      }
   }

   // $FF: renamed from: jo () void
   public void method_227() {
      byte var1 = 22;
      byte var2 = 36;
      this.field_198.method_36(var1, var2, 468, 16, 192);
      int var3 = 10000536;
      this.field_198.method_34(var1, var2 + 16, 468, 246, var3, 160);
      this.field_198.method_75("Please confirm your trade with @yel@" + class_0.method_15(this.xgb), var1 + 234, var2 + 12, 1, 16777215);
      this.field_198.method_75("You are about to give:", var1 + 117, var2 + 30, 1, 16776960);

      for(int var4 = 0; var4 < this.ngb; ++var4) {
         String var5 = class_11.field_404[this.ogb[var4]];
         if (class_11.field_409[this.ogb[var4]] == 0) {
            var5 = var5 + " (" + this.pgb[var4] + ")";
         }

         this.field_198.method_75(var5, var1 + 117, var2 + 42 + var4 * 12, 1, 16777215);
      }

      if (this.ngb == 0) {
         this.field_198.method_75("Nothing!", var1 + 117, var2 + 42, 1, 16777215);
      }

      this.field_198.method_75("In return you will receive:", var1 + 351, var2 + 30, 1, 16776960);

      for(int var7 = 0; var7 < this.qgb; ++var7) {
         String var6 = class_11.field_404[this.rgb[var7]];
         if (class_11.field_409[this.rgb[var7]] == 0) {
            var6 = var6 + " (" + this.sgb[var7] + ")";
         }

         this.field_198.method_75(var6, var1 + 351, var2 + 42 + var7 * 12, 1, 16777215);
      }

      if (this.qgb == 0) {
         this.field_198.method_75("Nothing!", var1 + 351, var2 + 42, 1, 16777215);
      }

      this.field_198.method_75("Are you sure you want to do this?", var1 + 234, var2 + 200, 4, 65535);
      this.field_198.method_75("There is NO WAY to reverse a trade if you change your mind.", var1 + 234, var2 + 215, 1, 16777215);
      this.field_198.method_75("Remember that not all players are trustworthy", var1 + 234, var2 + 230, 1, 16777215);
      if (!this.zgb) {
         this.field_198.method_52(var1 + 118 - 35, var2 + 238, this.field_205 + 25);
         this.field_198.method_52(var1 + 352 - 35, var2 + 238, this.field_205 + 26);
      } else {
         this.field_198.method_75("Waiting for other player...", var1 + 234, var2 + 250, 1, 16776960);
      }

      if (this.field_184 == 1) {
         if (super.field_139 < var1 || super.field_140 < var2 || super.field_139 > var1 + 468 || super.field_140 > var2 + 262) {
            this.ygb = false;
            super.field_157.method_358(233);
            super.field_157.method_359();
         }

         if (super.field_139 >= var1 + 118 - 35 && super.field_139 <= var1 + 118 + 70 && super.field_140 >= var2 + 238 && super.field_140 <= var2 + 238 + 21) {
            this.zgb = true;
            super.field_157.method_358(202);
            super.field_157.method_359();
         }

         if (super.field_139 >= var1 + 352 - 35 && super.field_139 <= var1 + 353 + 70 && super.field_140 >= var2 + 238 && super.field_140 <= var2 + 238 + 21) {
            this.ygb = false;
            super.field_157.method_358(233);
            super.field_157.method_359();
         }

         this.field_184 = 0;
      }

   }

   // $FF: renamed from: tp () void
   public void method_228() {
      if (this.field_184 != 0 && this.wgb == 0) {
         this.wgb = 1;
      }

      int var3;
      int var5;
      int var6;
      int var7;
      int var8;
      int var16;
      if (this.wgb > 0) {
         int var1 = super.field_139 - 22;
         int var2 = super.field_140 - 36;
         if (var1 >= 0 && var2 >= 0 && var1 < 468 && var2 < 262) {
            if (var1 > 216 && var2 > 30 && var1 < 462 && var2 < 235) {
               var3 = (var1 - 217) / 49 + (var2 - 31) / 34 * 5;
               if (var3 >= 0 && var3 < this.adb) {
                  boolean var4 = false;
                  var5 = 0;
                  var6 = this.bdb[var3];

                  for(var7 = 0; var7 < this.ngb; ++var7) {
                     if (this.ogb[var7] == var6) {
                        if (class_11.field_409[var6] == 0) {
                           for(var8 = 0; var8 < this.wgb; ++var8) {
                              if (this.pgb[var7] < this.cdb[var3]) {
                                 ++this.pgb[var7];
                              }

                              var4 = true;
                           }
                        } else {
                           ++var5;
                        }
                     }
                  }

                  if (this.method_205(var6) <= var5) {
                     var4 = true;
                  }

                  if (class_11.field_413[var6] == 1) {
                     this.method_192("This object cannot be traded with other players", 3);
                     var4 = true;
                  }

                  if (!var4 && this.ngb < 12) {
                     this.ogb[this.ngb] = var6;
                     this.pgb[this.ngb] = 1;
                     ++this.ngb;
                     var4 = true;
                  }

                  if (var4) {
                     super.field_157.method_358(234);
                     super.field_157.method_349(this.ngb);

                     for(var8 = 0; var8 < this.ngb; ++var8) {
                        super.field_157.method_350(this.ogb[var8]);
                        super.field_157.method_352(this.pgb[var8]);
                     }

                     super.field_157.method_359();
                     this.tgb = false;
                     this.ugb = false;
                  }
               }
            }

            if (var1 > 8 && var2 > 30 && var1 < 205 && var2 < 133) {
               var3 = (var1 - 9) / 49 + (var2 - 31) / 34 * 4;
               if (var3 >= 0 && var3 < this.ngb) {
                  var16 = this.ogb[var3];

                  for(var5 = 0; var5 < this.wgb; ++var5) {
                     if (class_11.field_409[var16] != 0 || this.pgb[var3] <= 1) {
                        --this.ngb;
                        this.vgb = 0;

                        for(var6 = var3; var6 < this.ngb; ++var6) {
                           this.ogb[var6] = this.ogb[var6 + 1];
                           this.pgb[var6] = this.pgb[var6 + 1];
                        }
                        break;
                     }

                     --this.pgb[var3];
                  }

                  super.field_157.method_358(234);
                  super.field_157.method_349(this.ngb);

                  for(var6 = 0; var6 < this.ngb; ++var6) {
                     super.field_157.method_350(this.ogb[var6]);
                     super.field_157.method_352(this.pgb[var6]);
                  }

                  super.field_157.method_359();
                  this.tgb = false;
                  this.ugb = false;
               }
            }

            if (var1 >= 217 && var2 >= 238 && var1 <= 286 && var2 <= 259) {
               this.ugb = true;
               super.field_157.method_358(232);
               super.field_157.method_359();
            }

            if (var1 >= 394 && var2 >= 238 && var1 < 463 && var2 < 259) {
               this.lgb = false;
               super.field_157.method_358(233);
               super.field_157.method_359();
            }
         } else if (this.field_184 != 0) {
            this.lgb = false;
            super.field_157.method_358(233);
            super.field_157.method_359();
         }

         this.field_184 = 0;
         this.wgb = 0;
      }

      if (this.lgb) {
         byte var14 = 22;
         byte var15 = 36;
         this.field_198.method_36(var14, var15, 468, 12, 192);
         var3 = 10000536;
         this.field_198.method_34(var14, var15 + 12, 468, 18, var3, 160);
         this.field_198.method_34(var14, var15 + 30, 8, 248, var3, 160);
         this.field_198.method_34(var14 + 205, var15 + 30, 11, 248, var3, 160);
         this.field_198.method_34(var14 + 462, var15 + 30, 6, 248, var3, 160);
         this.field_198.method_34(var14 + 8, var15 + 133, 197, 22, var3, 160);
         this.field_198.method_34(var14 + 8, var15 + 258, 197, 20, var3, 160);
         this.field_198.method_34(var14 + 216, var15 + 235, 246, 43, var3, 160);
         var16 = 13684944;
         this.field_198.method_34(var14 + 8, var15 + 30, 197, 103, var16, 160);
         this.field_198.method_34(var14 + 8, var15 + 155, 197, 103, var16, 160);
         this.field_198.method_34(var14 + 216, var15 + 30, 246, 205, var16, 160);

         for(var5 = 0; var5 < 4; ++var5) {
            this.field_198.method_38(var14 + 8, var15 + 30 + var5 * 34, 197, 0);
         }

         for(var6 = 0; var6 < 4; ++var6) {
            this.field_198.method_38(var14 + 8, var15 + 155 + var6 * 34, 197, 0);
         }

         for(var7 = 0; var7 < 7; ++var7) {
            this.field_198.method_38(var14 + 216, var15 + 30 + var7 * 34, 246, 0);
         }

         for(var8 = 0; var8 < 6; ++var8) {
            if (var8 < 5) {
               this.field_198.method_39(var14 + 8 + var8 * 49, var15 + 30, 103, 0);
            }

            if (var8 < 5) {
               this.field_198.method_39(var14 + 8 + var8 * 49, var15 + 155, 103, 0);
            }

            this.field_198.method_39(var14 + 216 + var8 * 49, var15 + 30, 205, 0);
         }

         this.field_198.method_77("Trading with: " + this.mgb, var14 + 1, var15 + 10, 1, 16777215);
         this.field_198.method_77("Your Offer", var14 + 9, var15 + 27, 4, 16777215);
         this.field_198.method_77("Opponent's Offer", var14 + 9, var15 + 152, 4, 16777215);
         this.field_198.method_77("Your Inventory", var14 + 216, var15 + 27, 4, 16777215);
         if (!this.ugb) {
            this.field_198.method_52(var14 + 217, var15 + 238, this.field_205 + 25);
         }

         this.field_198.method_52(var14 + 394, var15 + 238, this.field_205 + 26);
         if (this.tgb) {
            this.field_198.method_75("Other player", var14 + 341, var15 + 246, 1, 16777215);
            this.field_198.method_75("has accepted", var14 + 341, var15 + 256, 1, 16777215);
         }

         if (this.ugb) {
            this.field_198.method_75("Waiting for", var14 + 217 + 35, var15 + 246, 1, 16777215);
            this.field_198.method_75("other player", var14 + 217 + 35, var15 + 256, 1, 16777215);
         }

         int var10;
         int var11;
         for(int var9 = 0; var9 < this.adb; ++var9) {
            var10 = 217 + var14 + var9 % 5 * 49;
            var11 = 31 + var15 + var9 / 5 * 34;
            this.field_198.method_68(var10, var11, 48, 32, this.field_207 + class_11.field_407[this.bdb[var9]], class_11.field_412[this.bdb[var9]], 0, 0, false);
            if (class_11.field_409[this.bdb[var9]] == 0) {
               this.field_198.method_77(String.valueOf(this.cdb[var9]), var10 + 1, var11 + 10, 1, 16776960);
            }
         }

         int var12;
         for(var10 = 0; var10 < this.ngb; ++var10) {
            var11 = 9 + var14 + var10 % 4 * 49;
            var12 = 31 + var15 + var10 / 4 * 34;
            this.field_198.method_68(var11, var12, 48, 32, this.field_207 + class_11.field_407[this.ogb[var10]], class_11.field_412[this.ogb[var10]], 0, 0, false);
            if (class_11.field_409[this.ogb[var10]] == 0) {
               this.field_198.method_77(String.valueOf(this.pgb[var10]), var11 + 1, var12 + 10, 1, 16776960);
            }

            if (super.field_139 > var11 && super.field_139 < var11 + 48 && super.field_140 > var12 && super.field_140 < var12 + 32) {
               this.field_198.method_77(class_11.field_404[this.ogb[var10]] + ": @whi@" + class_11.field_405[this.ogb[var10]], var14 + 8, var15 + 273, 1, 16776960);
            }
         }

         for(var11 = 0; var11 < this.qgb; ++var11) {
            var12 = 9 + var14 + var11 % 4 * 49;
            int var13 = 156 + var15 + var11 / 4 * 34;
            this.field_198.method_68(var12, var13, 48, 32, this.field_207 + class_11.field_407[this.rgb[var11]], class_11.field_412[this.rgb[var11]], 0, 0, false);
            if (class_11.field_409[this.rgb[var11]] == 0) {
               this.field_198.method_77(String.valueOf(this.sgb[var11]), var12 + 1, var13 + 10, 1, 16776960);
            }

            if (super.field_139 > var12 && super.field_139 < var12 + 48 && super.field_140 > var13 && super.field_140 < var13 + 32) {
               this.field_198.method_77(class_11.field_404[this.rgb[var11]] + ": @whi@" + class_11.field_405[this.rgb[var11]], var14 + 8, var15 + 273, 1, 16776960);
            }
         }

      }
   }

   // $FF: renamed from: jp () void
   public void method_229() {
      byte var1 = 22;
      byte var2 = 36;
      this.field_198.method_36(var1, var2, 468, 16, 192);
      int var3 = 10000536;
      this.field_198.method_34(var1, var2 + 16, 468, 246, var3, 160);
      this.field_198.method_75("Please confirm your duel with @yel@" + class_0.method_15(this.agb), var1 + 234, var2 + 12, 1, 16777215);
      this.field_198.method_75("Your stake:", var1 + 117, var2 + 30, 1, 16776960);

      for(int var4 = 0; var4 < this.mfb; ++var4) {
         String var5 = class_11.field_404[this.nfb[var4]];
         if (class_11.field_409[this.nfb[var4]] == 0) {
            var5 = var5 + " (" + this.ofb[var4] + ")";
         }

         this.field_198.method_75(var5, var1 + 117, var2 + 42 + var4 * 12, 1, 16777215);
      }

      if (this.mfb == 0) {
         this.field_198.method_75("Nothing!", var1 + 117, var2 + 42, 1, 16777215);
      }

      this.field_198.method_75("Your opponent's stake:", var1 + 351, var2 + 30, 1, 16776960);

      for(int var7 = 0; var7 < this.pfb; ++var7) {
         String var6 = class_11.field_404[this.qfb[var7]];
         if (class_11.field_409[this.qfb[var7]] == 0) {
            var6 = var6 + " (" + this.rfb[var7] + ")";
         }

         this.field_198.method_75(var6, var1 + 351, var2 + 42 + var7 * 12, 1, 16777215);
      }

      if (this.pfb == 0) {
         this.field_198.method_75("Nothing!", var1 + 351, var2 + 42, 1, 16777215);
      }

      if (this.hgb == 0) {
         this.field_198.method_75("You can retreat from this duel", var1 + 234, var2 + 180, 1, 65280);
      } else {
         this.field_198.method_75("No retreat is possible!", var1 + 234, var2 + 180, 1, 16711680);
      }

      if (this.igb == 0) {
         this.field_198.method_75("Magic may be used", var1 + 234, var2 + 192, 1, 65280);
      } else {
         this.field_198.method_75("Magic cannot be used", var1 + 234, var2 + 192, 1, 16711680);
      }

      if (this.jgb == 0) {
         this.field_198.method_75("Prayer may be used", var1 + 234, var2 + 204, 1, 65280);
      } else {
         this.field_198.method_75("Prayer cannot be used", var1 + 234, var2 + 204, 1, 16711680);
      }

      if (this.kgb == 0) {
         this.field_198.method_75("Weapons may be used", var1 + 234, var2 + 216, 1, 65280);
      } else {
         this.field_198.method_75("Weapons cannot be used", var1 + 234, var2 + 216, 1, 16711680);
      }

      this.field_198.method_75("If you are sure click 'Accept' to begin the duel", var1 + 234, var2 + 230, 1, 16777215);
      if (!this.zfb) {
         this.field_198.method_52(var1 + 118 - 35, var2 + 238, this.field_205 + 25);
         this.field_198.method_52(var1 + 352 - 35, var2 + 238, this.field_205 + 26);
      } else {
         this.field_198.method_75("Waiting for other player...", var1 + 234, var2 + 250, 1, 16776960);
      }

      if (this.field_184 == 1) {
         if (super.field_139 < var1 || super.field_140 < var2 || super.field_139 > var1 + 468 || super.field_140 > var2 + 262) {
            this.yfb = false;
            super.field_157.method_358(233);
            super.field_157.method_359();
         }

         if (super.field_139 >= var1 + 118 - 35 && super.field_139 <= var1 + 118 + 70 && super.field_140 >= var2 + 238 && super.field_140 <= var2 + 238 + 21) {
            this.zfb = true;
            super.field_157.method_358(198);
            super.field_157.method_359();
         }

         if (super.field_139 >= var1 + 352 - 35 && super.field_139 <= var1 + 353 + 70 && super.field_140 >= var2 + 238 && super.field_140 <= var2 + 238 + 21) {
            this.yfb = false;
            super.field_157.method_358(203);
            super.field_157.method_359();
         }

         this.field_184 = 0;
      }

   }

   // $FF: renamed from: ho () void
   public void method_230() {
      if (this.field_184 != 0 && this.wgb == 0) {
         this.wgb = 1;
      }

      int var3;
      int var5;
      int var6;
      int var7;
      int var8;
      int var17;
      if (this.wgb > 0) {
         int var1 = super.field_139 - 22;
         int var2 = super.field_140 - 36;
         if (var1 >= 0 && var2 >= 0 && var1 < 468 && var2 < 262) {
            if (var1 > 216 && var2 > 30 && var1 < 462 && var2 < 235) {
               var3 = (var1 - 217) / 49 + (var2 - 31) / 34 * 5;
               if (var3 >= 0 && var3 < this.adb) {
                  boolean var4 = false;
                  var5 = 0;
                  var6 = this.bdb[var3];

                  for(var7 = 0; var7 < this.mfb; ++var7) {
                     if (this.nfb[var7] == var6) {
                        if (class_11.field_409[var6] == 0) {
                           for(var8 = 0; var8 < this.wgb; ++var8) {
                              if (this.ofb[var7] < this.cdb[var3]) {
                                 ++this.ofb[var7];
                              }

                              var4 = true;
                           }
                        } else {
                           ++var5;
                        }
                     }
                  }

                  if (this.method_205(var6) <= var5) {
                     var4 = true;
                  }

                  if (class_11.field_413[var6] == 1) {
                     this.method_192("This object cannot be added to a duel offer", 3);
                     var4 = true;
                  }

                  if (!var4 && this.mfb < 8) {
                     this.nfb[this.mfb] = var6;
                     this.ofb[this.mfb] = 1;
                     ++this.mfb;
                     var4 = true;
                  }

                  if (var4) {
                     super.field_157.method_358(201);
                     super.field_157.method_349(this.mfb);

                     for(var8 = 0; var8 < this.mfb; ++var8) {
                        super.field_157.method_350(this.nfb[var8]);
                        super.field_157.method_352(this.ofb[var8]);
                     }

                     super.field_157.method_359();
                     this.sfb = false;
                     this.tfb = false;
                  }
               }
            }

            if (var1 > 8 && var2 > 30 && var1 < 205 && var2 < 129) {
               var3 = (var1 - 9) / 49 + (var2 - 31) / 34 * 4;
               if (var3 >= 0 && var3 < this.mfb) {
                  var17 = this.nfb[var3];

                  for(var5 = 0; var5 < this.wgb; ++var5) {
                     if (class_11.field_409[var17] != 0 || this.ofb[var3] <= 1) {
                        --this.mfb;
                        this.vgb = 0;

                        for(var6 = var3; var6 < this.mfb; ++var6) {
                           this.nfb[var6] = this.nfb[var6 + 1];
                           this.ofb[var6] = this.ofb[var6 + 1];
                        }
                        break;
                     }

                     --this.ofb[var3];
                  }

                  super.field_157.method_358(201);
                  super.field_157.method_349(this.mfb);

                  for(var6 = 0; var6 < this.mfb; ++var6) {
                     super.field_157.method_350(this.nfb[var6]);
                     super.field_157.method_352(this.ofb[var6]);
                  }

                  super.field_157.method_359();
                  this.sfb = false;
                  this.tfb = false;
               }
            }

            boolean var16 = false;
            if (var1 >= 93 && var2 >= 221 && var1 <= 104 && var2 <= 232) {
               this.ufb = !this.ufb;
               var16 = true;
            }

            if (var1 >= 93 && var2 >= 240 && var1 <= 104 && var2 <= 251) {
               this.vfb = !this.vfb;
               var16 = true;
            }

            if (var1 >= 191 && var2 >= 221 && var1 <= 202 && var2 <= 232) {
               this.wfb = !this.wfb;
               var16 = true;
            }

            if (var1 >= 191 && var2 >= 240 && var1 <= 202 && var2 <= 251) {
               this.xfb = !this.xfb;
               var16 = true;
            }

            if (var16) {
               super.field_157.method_358(200);
               super.field_157.method_349(this.ufb ? 1 : 0);
               super.field_157.method_349(this.vfb ? 1 : 0);
               super.field_157.method_349(this.wfb ? 1 : 0);
               super.field_157.method_349(this.xfb ? 1 : 0);
               super.field_157.method_359();
               this.sfb = false;
               this.tfb = false;
            }

            if (var1 >= 217 && var2 >= 238 && var1 <= 286 && var2 <= 259) {
               this.tfb = true;
               super.field_157.method_358(199);
               super.field_157.method_359();
            }

            if (var1 >= 394 && var2 >= 238 && var1 < 463 && var2 < 259) {
               this.kfb = false;
               super.field_157.method_358(203);
               super.field_157.method_359();
            }
         } else if (this.field_184 != 0) {
            this.kfb = false;
            super.field_157.method_358(203);
            super.field_157.method_359();
         }

         this.field_184 = 0;
         this.wgb = 0;
      }

      if (this.kfb) {
         byte var14 = 22;
         byte var15 = 36;
         this.field_198.method_36(var14, var15, 468, 12, 13175581);
         var3 = 10000536;
         this.field_198.method_34(var14, var15 + 12, 468, 18, var3, 160);
         this.field_198.method_34(var14, var15 + 30, 8, 248, var3, 160);
         this.field_198.method_34(var14 + 205, var15 + 30, 11, 248, var3, 160);
         this.field_198.method_34(var14 + 462, var15 + 30, 6, 248, var3, 160);
         this.field_198.method_34(var14 + 8, var15 + 99, 197, 24, var3, 160);
         this.field_198.method_34(var14 + 8, var15 + 192, 197, 23, var3, 160);
         this.field_198.method_34(var14 + 8, var15 + 258, 197, 20, var3, 160);
         this.field_198.method_34(var14 + 216, var15 + 235, 246, 43, var3, 160);
         var17 = 13684944;
         this.field_198.method_34(var14 + 8, var15 + 30, 197, 69, var17, 160);
         this.field_198.method_34(var14 + 8, var15 + 123, 197, 69, var17, 160);
         this.field_198.method_34(var14 + 8, var15 + 215, 197, 43, var17, 160);
         this.field_198.method_34(var14 + 216, var15 + 30, 246, 205, var17, 160);

         for(var5 = 0; var5 < 3; ++var5) {
            this.field_198.method_38(var14 + 8, var15 + 30 + var5 * 34, 197, 0);
         }

         for(var6 = 0; var6 < 3; ++var6) {
            this.field_198.method_38(var14 + 8, var15 + 123 + var6 * 34, 197, 0);
         }

         for(var7 = 0; var7 < 7; ++var7) {
            this.field_198.method_38(var14 + 216, var15 + 30 + var7 * 34, 246, 0);
         }

         for(var8 = 0; var8 < 6; ++var8) {
            if (var8 < 5) {
               this.field_198.method_39(var14 + 8 + var8 * 49, var15 + 30, 69, 0);
            }

            if (var8 < 5) {
               this.field_198.method_39(var14 + 8 + var8 * 49, var15 + 123, 69, 0);
            }

            this.field_198.method_39(var14 + 216 + var8 * 49, var15 + 30, 205, 0);
         }

         this.field_198.method_38(var14 + 8, var15 + 215, 197, 0);
         this.field_198.method_38(var14 + 8, var15 + 257, 197, 0);
         this.field_198.method_39(var14 + 8, var15 + 215, 43, 0);
         this.field_198.method_39(var14 + 204, var15 + 215, 43, 0);
         this.field_198.method_77("Preparing to duel with: " + this.lfb, var14 + 1, var15 + 10, 1, 16777215);
         this.field_198.method_77("Your Stake", var14 + 9, var15 + 27, 4, 16777215);
         this.field_198.method_77("Opponent's Stake", var14 + 9, var15 + 120, 4, 16777215);
         this.field_198.method_77("Duel Options", var14 + 9, var15 + 212, 4, 16777215);
         this.field_198.method_77("Your Inventory", var14 + 216, var15 + 27, 4, 16777215);
         this.field_198.method_77("No retreating", var14 + 8 + 1, var15 + 215 + 16, 3, 16776960);
         this.field_198.method_77("No magic", var14 + 8 + 1, var15 + 215 + 35, 3, 16776960);
         this.field_198.method_77("No prayer", var14 + 8 + 102, var15 + 215 + 16, 3, 16776960);
         this.field_198.method_77("No weapons", var14 + 8 + 102, var15 + 215 + 35, 3, 16776960);
         this.field_198.method_37(var14 + 93, var15 + 215 + 6, 11, 11, 16776960);
         if (this.ufb) {
            this.field_198.method_36(var14 + 95, var15 + 215 + 8, 7, 7, 16776960);
         }

         this.field_198.method_37(var14 + 93, var15 + 215 + 25, 11, 11, 16776960);
         if (this.vfb) {
            this.field_198.method_36(var14 + 95, var15 + 215 + 27, 7, 7, 16776960);
         }

         this.field_198.method_37(var14 + 191, var15 + 215 + 6, 11, 11, 16776960);
         if (this.wfb) {
            this.field_198.method_36(var14 + 193, var15 + 215 + 8, 7, 7, 16776960);
         }

         this.field_198.method_37(var14 + 191, var15 + 215 + 25, 11, 11, 16776960);
         if (this.xfb) {
            this.field_198.method_36(var14 + 193, var15 + 215 + 27, 7, 7, 16776960);
         }

         if (!this.tfb) {
            this.field_198.method_52(var14 + 217, var15 + 238, this.field_205 + 25);
         }

         this.field_198.method_52(var14 + 394, var15 + 238, this.field_205 + 26);
         if (this.sfb) {
            this.field_198.method_75("Other player", var14 + 341, var15 + 246, 1, 16777215);
            this.field_198.method_75("has accepted", var14 + 341, var15 + 256, 1, 16777215);
         }

         if (this.tfb) {
            this.field_198.method_75("Waiting for", var14 + 217 + 35, var15 + 246, 1, 16777215);
            this.field_198.method_75("other player", var14 + 217 + 35, var15 + 256, 1, 16777215);
         }

         int var10;
         int var11;
         for(int var9 = 0; var9 < this.adb; ++var9) {
            var10 = 217 + var14 + var9 % 5 * 49;
            var11 = 31 + var15 + var9 / 5 * 34;
            this.field_198.method_68(var10, var11, 48, 32, this.field_207 + class_11.field_407[this.bdb[var9]], class_11.field_412[this.bdb[var9]], 0, 0, false);
            if (class_11.field_409[this.bdb[var9]] == 0) {
               this.field_198.method_77(String.valueOf(this.cdb[var9]), var10 + 1, var11 + 10, 1, 16776960);
            }
         }

         int var12;
         for(var10 = 0; var10 < this.mfb; ++var10) {
            var11 = 9 + var14 + var10 % 4 * 49;
            var12 = 31 + var15 + var10 / 4 * 34;
            this.field_198.method_68(var11, var12, 48, 32, this.field_207 + class_11.field_407[this.nfb[var10]], class_11.field_412[this.nfb[var10]], 0, 0, false);
            if (class_11.field_409[this.nfb[var10]] == 0) {
               this.field_198.method_77(String.valueOf(this.ofb[var10]), var11 + 1, var12 + 10, 1, 16776960);
            }

            if (super.field_139 > var11 && super.field_139 < var11 + 48 && super.field_140 > var12 && super.field_140 < var12 + 32) {
               this.field_198.method_77(class_11.field_404[this.nfb[var10]] + ": @whi@" + class_11.field_405[this.nfb[var10]], var14 + 8, var15 + 273, 1, 16776960);
            }
         }

         for(var11 = 0; var11 < this.pfb; ++var11) {
            var12 = 9 + var14 + var11 % 4 * 49;
            int var13 = 124 + var15 + var11 / 4 * 34;
            this.field_198.method_68(var12, var13, 48, 32, this.field_207 + class_11.field_407[this.qfb[var11]], class_11.field_412[this.qfb[var11]], 0, 0, false);
            if (class_11.field_409[this.qfb[var11]] == 0) {
               this.field_198.method_77(String.valueOf(this.rfb[var11]), var12 + 1, var13 + 10, 1, 16776960);
            }

            if (super.field_139 > var12 && super.field_139 < var12 + 48 && super.field_140 > var13 && super.field_140 < var13 + 32) {
               this.field_198.method_77(class_11.field_404[this.qfb[var11]] + ": @whi@" + class_11.field_405[this.qfb[var11]], var14 + 8, var15 + 273, 1, 16776960);
            }
         }

      }
   }

   // $FF: renamed from: qp () void
   public void method_231() {
      if (this.ycb == 0 && super.field_139 >= this.field_198.field_10 - 35 && super.field_140 >= 3 && super.field_139 < this.field_198.field_10 - 3 && super.field_140 < 35) {
         this.ycb = 1;
      }

      if (this.ycb == 0 && super.field_139 >= this.field_198.field_10 - 35 - 33 && super.field_140 >= 3 && super.field_139 < this.field_198.field_10 - 3 - 33 && super.field_140 < 35) {
         this.ycb = 2;
      }

      if (this.ycb == 0 && super.field_139 >= this.field_198.field_10 - 35 - 66 && super.field_140 >= 3 && super.field_139 < this.field_198.field_10 - 3 - 66 && super.field_140 < 35) {
         this.ycb = 3;
      }

      if (this.ycb == 0 && super.field_139 >= this.field_198.field_10 - 35 - 99 && super.field_140 >= 3 && super.field_139 < this.field_198.field_10 - 3 - 99 && super.field_140 < 35) {
         this.ycb = 4;
      }

      if (this.ycb == 0 && super.field_139 >= this.field_198.field_10 - 35 - 132 && super.field_140 >= 3 && super.field_139 < this.field_198.field_10 - 3 - 132 && super.field_140 < 35) {
         this.ycb = 5;
      }

      if (this.ycb == 0 && super.field_139 >= this.field_198.field_10 - 35 - 165 && super.field_140 >= 3 && super.field_139 < this.field_198.field_10 - 3 - 165 && super.field_140 < 35) {
         this.ycb = 6;
      }

      if (this.ycb != 0 && super.field_139 >= this.field_198.field_10 - 35 && super.field_140 >= 3 && super.field_139 < this.field_198.field_10 - 3 && super.field_140 < 26) {
         this.ycb = 1;
      }

      if (this.ycb != 0 && super.field_139 >= this.field_198.field_10 - 35 - 33 && super.field_140 >= 3 && super.field_139 < this.field_198.field_10 - 3 - 33 && super.field_140 < 26) {
         this.ycb = 2;
      }

      if (this.ycb != 0 && super.field_139 >= this.field_198.field_10 - 35 - 66 && super.field_140 >= 3 && super.field_139 < this.field_198.field_10 - 3 - 66 && super.field_140 < 26) {
         this.ycb = 3;
      }

      if (this.ycb != 0 && super.field_139 >= this.field_198.field_10 - 35 - 99 && super.field_140 >= 3 && super.field_139 < this.field_198.field_10 - 3 - 99 && super.field_140 < 26) {
         this.ycb = 4;
      }

      if (this.ycb != 0 && super.field_139 >= this.field_198.field_10 - 35 - 132 && super.field_140 >= 3 && super.field_139 < this.field_198.field_10 - 3 - 132 && super.field_140 < 26) {
         this.ycb = 5;
      }

      if (this.ycb != 0 && super.field_139 >= this.field_198.field_10 - 35 - 165 && super.field_140 >= 3 && super.field_139 < this.field_198.field_10 - 3 - 165 && super.field_140 < 26) {
         this.ycb = 6;
      }

      if (this.ycb == 1 && (super.field_139 < this.field_198.field_10 - 248 || super.field_140 > 36 + this.zcb / 5 * 34)) {
         this.ycb = 0;
      }

      if (this.ycb == 3 && (super.field_139 < this.field_198.field_10 - 199 || super.field_140 > 294)) {
         this.ycb = 0;
      }

      if ((this.ycb == 2 || this.ycb == 4 || this.ycb == 5) && (super.field_139 < this.field_198.field_10 - 199 || super.field_140 > 240)) {
         this.ycb = 0;
      }

      if (this.ycb == 6 && (super.field_139 < this.field_198.field_10 - 199 || super.field_140 > 311)) {
         this.ycb = 0;
      }

   }

   // $FF: renamed from: go (boolean) void
   public void method_232(boolean var1) {
      int var2 = this.field_198.field_10 - 248;
      this.field_198.method_52(var2, 3, this.field_205 + 1);

      int var4;
      int var5;
      for(int var3 = 0; var3 < this.zcb; ++var3) {
         var4 = var2 + var3 % 5 * 49;
         var5 = 36 + var3 / 5 * 34;
         if (var3 < this.adb && this.ddb[var3] == 1) {
            this.field_198.method_34(var4, var5, 49, 34, 16711680, 128);
         } else {
            this.field_198.method_34(var4, var5, 49, 34, class_1.method_43(181, 181, 181), 128);
         }

         if (var3 < this.adb) {
            this.field_198.method_68(var4, var5, 48, 32, this.field_207 + class_11.field_407[this.bdb[var3]], class_11.field_412[this.bdb[var3]], 0, 0, false);
            if (class_11.field_409[this.bdb[var3]] == 0) {
               this.field_198.method_77(String.valueOf(this.cdb[var3]), var4 + 1, var5 + 10, 1, 16776960);
            }
         }
      }

      for(var4 = 1; var4 <= 4; ++var4) {
         this.field_198.method_39(var2 + var4 * 49, 36, this.zcb / 5 * 34, 0);
      }

      for(var5 = 1; var5 <= this.zcb / 5 - 1; ++var5) {
         this.field_198.method_38(var2, 36 + var5 * 34, 245, 0);
      }

      if (var1) {
         var2 = super.field_139 - (this.field_198.field_10 - 248);
         int var6 = super.field_140 - 36;
         if (var2 >= 0 && var6 >= 0 && var2 < 248 && var6 < this.zcb / 5 * 34) {
            int var7 = var2 / 49 + var6 / 34 * 5;
            if (var7 < this.adb) {
               int var8 = this.bdb[var7];
               if (this.rdb >= 0) {
                  if (class_11.field_476[this.rdb] == 3) {
                     this.peb[this.meb] = "Cast " + class_11.field_472[this.rdb] + " on";
                     this.oeb[this.meb] = "@lre@" + class_11.field_404[var8];
                     this.qeb[this.meb] = 600;
                     this.teb[this.meb] = var7;
                     this.ueb[this.meb] = this.rdb;
                     ++this.meb;
                     return;
                  }
               } else {
                  if (this.edb >= 0) {
                     this.peb[this.meb] = "Use " + this.fdb + " with";
                     this.oeb[this.meb] = "@lre@" + class_11.field_404[var8];
                     this.qeb[this.meb] = 610;
                     this.teb[this.meb] = var7;
                     this.ueb[this.meb] = this.edb;
                     ++this.meb;
                     return;
                  }

                  if (this.ddb[var7] == 1) {
                     this.peb[this.meb] = "Remove";
                     this.oeb[this.meb] = "@lre@" + class_11.field_404[var8];
                     this.qeb[this.meb] = 620;
                     this.teb[this.meb] = var7;
                     ++this.meb;
                  } else if (class_11.field_411[var8] != 0) {
                     if ((class_11.field_411[var8] & 24) != 0) {
                        this.peb[this.meb] = "Wield";
                     } else {
                        this.peb[this.meb] = "Wear";
                     }

                     this.oeb[this.meb] = "@lre@" + class_11.field_404[var8];
                     this.qeb[this.meb] = 630;
                     this.teb[this.meb] = var7;
                     ++this.meb;
                  }

                  if (!class_11.field_406[var8].equals("")) {
                     this.peb[this.meb] = class_11.field_406[var8];
                     this.oeb[this.meb] = "@lre@" + class_11.field_404[var8];
                     this.qeb[this.meb] = 640;
                     this.teb[this.meb] = var7;
                     ++this.meb;
                  }

                  this.peb[this.meb] = "Use";
                  this.oeb[this.meb] = "@lre@" + class_11.field_404[var8];
                  this.qeb[this.meb] = 650;
                  this.teb[this.meb] = var7;
                  ++this.meb;
                  this.peb[this.meb] = "Drop";
                  this.oeb[this.meb] = "@lre@" + class_11.field_404[var8];
                  this.qeb[this.meb] = 660;
                  this.teb[this.meb] = var7;
                  ++this.meb;
                  this.peb[this.meb] = "Examine";
                  this.oeb[this.meb] = "@lre@" + class_11.field_404[var8];
                  this.qeb[this.meb] = 3600;
                  this.teb[this.meb] = var8;
                  ++this.meb;
               }
            }
         }

      }
   }

   // $FF: renamed from: in (boolean) void
   public void method_233(boolean var1) {
      int var2 = this.field_198.field_10 - 199;
      short var3 = 156;
      short var4 = 152;
      this.field_198.method_52(var2 - 49, 3, this.field_205 + 2);
      var2 += 40;
      this.field_198.method_36(var2, 36, var3, var4, 0);
      this.field_198.method_29(var2, 36, var2 + var3, 36 + var4);
      short var5 = 192;
      int var6 = (this.pbb.field_498 - 6040) * 3 * var5 / 2048;
      int var7 = (this.pbb.field_499 - 6040) * 3 * var5 / 2048;
      int var8 = class_17.field_592[1024 - this.fbb * 4 & 1023];
      int var9 = class_17.field_592[(1024 - this.fbb * 4 & 1023) + 1024];
      int var10 = var7 * var8 + var6 * var9 >> 18;
      var7 = var7 * var9 - var6 * var8 >> 18;
      this.field_198.method_64(var2 + var3 / 2 - var10, 36 + var4 / 2 + var7, this.field_205 - 1, this.fbb + 64 & 255, var5);

      for(int var11 = 0; var11 < this.icb; ++var11) {
         var6 = (this.kcb[var11] * this.field_200 + 64 - this.pbb.field_498) * 3 * var5 / 2048;
         var7 = (this.lcb[var11] * this.field_200 + 64 - this.pbb.field_499) * 3 * var5 / 2048;
         var10 = var7 * var8 + var6 * var9 >> 18;
         var7 = var7 * var9 - var6 * var8 >> 18;
         this.method_208(var2 + var3 / 2 + var10, 36 + var4 / 2 - var7, 65535);
      }

      for(int var12 = 0; var12 < this.ccb; ++var12) {
         var6 = (this.dcb[var12] * this.field_200 + 64 - this.pbb.field_498) * 3 * var5 / 2048;
         var7 = (this.ecb[var12] * this.field_200 + 64 - this.pbb.field_499) * 3 * var5 / 2048;
         var10 = var7 * var8 + var6 * var9 >> 18;
         var7 = var7 * var9 - var6 * var8 >> 18;
         this.method_208(var2 + var3 / 2 + var10, 36 + var4 / 2 - var7, 16711680);
      }

      for(int var13 = 0; var13 < this.vbb; ++var13) {
         class_13 var14 = this.ybb[var13];
         var6 = (var14.field_498 - this.pbb.field_498) * 3 * var5 / 2048;
         var7 = (var14.field_499 - this.pbb.field_499) * 3 * var5 / 2048;
         var10 = var7 * var8 + var6 * var9 >> 18;
         var7 = var7 * var9 - var6 * var8 >> 18;
         this.method_208(var2 + var3 / 2 + var10, 36 + var4 / 2 - var7, 16776960);
      }

      for(int var18 = 0; var18 < this.jbb; ++var18) {
         class_13 var15 = this.nbb[var18];
         var6 = (var15.field_498 - this.pbb.field_498) * 3 * var5 / 2048;
         var7 = (var15.field_499 - this.pbb.field_499) * 3 * var5 / 2048;
         var10 = var7 * var8 + var6 * var9 >> 18;
         var7 = var7 * var9 - var6 * var8 >> 18;
         int var16 = 16777215;

         for(int var17 = 0; var17 < super.field_161; ++var17) {
            if (var15.field_494 == super.field_162[var17] && super.field_163[var17] == 10) {
               var16 = 65280;
               break;
            }
         }

         this.method_208(var2 + var3 / 2 + var10, 36 + var4 / 2 - var7, var16);
      }

      this.field_198.method_33(var2 + var3 / 2, 36 + var4 / 2, 2, 16777215, 255);
      this.field_198.method_64(var2 + 19, 55, this.field_205 + 24, this.fbb + 128 & 255, 128);
      this.field_198.method_29(0, 0, this.field_202, this.field_203 + 12);
      if (var1) {
         var2 = super.field_139 - (this.field_198.field_10 - 199);
         int var19 = super.field_140 - 36;
         if (var2 >= 40 && var19 >= 0 && var2 < 196 && var19 < 152) {
            var3 = 156;
            var4 = 152;
            var5 = 192;
            var2 = this.field_198.field_10 - 199;
            var2 += 40;
            var6 = (super.field_139 - (var2 + var3 / 2)) * 16384 / (3 * var5);
            var7 = (super.field_140 - (36 + var4 / 2)) * 16384 / (3 * var5);
            var8 = class_17.field_592[1024 - this.fbb * 4 & 1023];
            var9 = class_17.field_592[(1024 - this.fbb * 4 & 1023) + 1024];
            var10 = var7 * var8 + var6 * var9 >> 15;
            var7 = var7 * var9 - var6 * var8 >> 15;
            var6 = var10 + this.pbb.field_498;
            var7 = this.pbb.field_499 - var7;
            if (this.field_184 == 1) {
               this.method_209(this.qbb, this.rbb, var6 / 128, var7 / 128, false);
            }

            this.field_184 = 0;
         }

      }
   }

   // $FF: renamed from: bn (boolean) void
   public void method_234(boolean var1) {
      int var2 = this.field_198.field_10 - 199;
      byte var3 = 36;
      this.field_198.method_52(var2 - 49, 3, this.field_205 + 3);
      short var4 = 196;
      short var5 = 250;
      int var7;
      int var6 = var7 = class_1.method_43(160, 160, 160);
      if (this.ydb == 0) {
         var6 = class_1.method_43(220, 220, 220);
      } else {
         var7 = class_1.method_43(220, 220, 220);
      }

      this.field_198.method_34(var2, var3, var4 / 2, 24, var6, 128);
      this.field_198.method_34(var2 + var4 / 2, var3, var4 / 2, 24, var7, 128);
      this.field_198.method_34(var2, var3 + 24, var4, var5 - 24, class_1.method_43(220, 220, 220), 128);
      this.field_198.method_38(var2, var3 + 24, var4, 0);
      this.field_198.method_39(var2 + var4 / 2, var3, 24, 0);
      this.field_198.method_75("Stats", var2 + var4 / 4, var3 + 16, 4, 0);
      this.field_198.method_75("Quests", var2 + var4 / 4 + var4 / 2, var3 + 16, 4, 0);
      int var15;
      if (this.ydb == 0) {
         byte var8 = 72;
         int var9 = -1;
         this.field_198.method_77("Skills", var2 + 5, var8, 3, 16776960);
         var15 = var8 + 13;

         int var11;
         for(int var10 = 0; var10 < 8; ++var10) {
            var11 = 16777215;
            if (super.field_139 > var2 + 3 && super.field_140 >= var15 - 11 && super.field_140 < var15 + 2 && super.field_139 < var2 + 90) {
               var11 = 16711680;
               var9 = var10;
            }

            this.field_198.method_77(this.mdb[var10] + ":@yel@" + this.hdb[var10] + "/" + this.idb[var10], var2 + 5, var15, 1, var11);
            var11 = 16777215;
            if (super.field_139 >= var2 + 90 && super.field_140 >= var15 - 13 - 11 && super.field_140 < var15 - 13 + 2 && super.field_139 < var2 + 196) {
               var11 = 16711680;
               var9 = var10 + 8;
            }

            this.field_198.method_77(this.mdb[var10 + 8] + ":@yel@" + this.hdb[var10 + 8] + "/" + this.idb[var10 + 8], var2 + var4 / 2 - 8, var15 - 13, 1, var11);
            var15 += 13;
         }

         this.field_198.method_77("Quest Points:@yel@" + this.ldb, var2 + var4 / 2 - 8, var15 - 13, 1, 16777215);
         var15 += 8;
         this.field_198.method_77("Equipment Status", var2 + 5, var15, 3, 16776960);
         var15 += 12;

         for(var11 = 0; var11 < 3; ++var11) {
            this.field_198.method_77(this.ndb[var11] + ":@yel@" + this.kdb[var11], var2 + 5, var15, 1, 16777215);
            if (var11 < 2) {
               this.field_198.method_77(this.ndb[var11 + 3] + ":@yel@" + this.kdb[var11 + 3], var2 + var4 / 2 + 25, var15, 1, 16777215);
            }

            var15 += 13;
         }

         var15 += 6;
         this.field_198.method_38(var2, var15 - 15, var4, 0);
         int var12;
         int var13;
         if (var9 != -1) {
            this.field_198.method_77(this.mdb[var9] + " skill", var2 + 5, var15, 1, 16776960);
            var15 += 12;
            var12 = this.gdb[0];

            for(var13 = 0; var13 < 98; ++var13) {
               if (this.jdb[var9] >= this.gdb[var13]) {
                  var12 = this.gdb[var13 + 1];
               }
            }

            this.field_198.method_77("Total xp: " + this.jdb[var9] / 4, var2 + 5, var15, 1, 16777215);
            var15 += 12;
            this.field_198.method_77("Next level at: " + var12 / 4, var2 + 5, var15, 1, 16777215);
         } else {
            this.field_198.method_77("Overall levels", var2 + 5, var15, 1, 16776960);
            var15 += 12;
            var12 = 0;

            for(var13 = 0; var13 < 16; ++var13) {
               var12 += this.idb[var13];
            }

            this.field_198.method_77("Skill total: " + var12, var2 + 5, var15, 1, 16777215);
            var15 += 12;
            this.field_198.method_77("Combat level: " + this.pbb.field_517, var2 + 5, var15, 1, 16777215);
            var15 += 12;
         }
      }

      if (this.ydb == 1) {
         this.wdb.method_309(this.xdb);
         this.wdb.method_311(this.xdb, 0, "@whi@Quest-list (green=completed)");

         for(var15 = 0; var15 < this.zdb; ++var15) {
            this.wdb.method_311(this.xdb, var15 + 1, (this.beb[var15] ? "@gre@" : "@red@") + this.aeb[var15]);
         }

         this.wdb.method_283();
      }

      if (var1) {
         var2 = super.field_139 - (this.field_198.field_10 - 199);
         int var14 = super.field_140 - 36;
         if (var2 >= 0 && var14 >= 0 && var2 < var4 && var14 < var5) {
            if (this.ydb == 1) {
               this.wdb.method_280(var2 + (this.field_198.field_10 - 199), var14 + 36, super.field_142, super.field_141);
            }

            if (var14 <= 24 && this.field_184 == 1) {
               if (var2 < 98) {
                  this.ydb = 0;
                  return;
               }

               if (var2 > 98) {
                  this.ydb = 1;
               }
            }
         }

      }
   }

   // $FF: renamed from: xn (boolean) void
   public void method_235(boolean var1) {
      int var2 = this.field_198.field_10 - 199;
      byte var3 = 36;
      this.field_198.method_52(var2 - 49, 3, this.field_205 + 4);
      short var4 = 196;
      short var5 = 182;
      int var7;
      int var6 = var7 = class_1.method_43(160, 160, 160);
      if (this.qdb == 0) {
         var6 = class_1.method_43(220, 220, 220);
      } else {
         var7 = class_1.method_43(220, 220, 220);
      }

      this.field_198.method_34(var2, var3, var4 / 2, 24, var6, 128);
      this.field_198.method_34(var2 + var4 / 2, var3, var4 / 2, 24, var7, 128);
      this.field_198.method_34(var2, var3 + 24, var4, 90, class_1.method_43(220, 220, 220), 128);
      this.field_198.method_34(var2, var3 + 24 + 90, var4, var5 - 90 - 24, class_1.method_43(160, 160, 160), 128);
      this.field_198.method_38(var2, var3 + 24, var4, 0);
      this.field_198.method_39(var2 + var4 / 2, var3, 24, 0);
      this.field_198.method_38(var2, var3 + 113, var4, 0);
      this.field_198.method_75("Magic", var2 + var4 / 4, var3 + 16, 4, 0);
      this.field_198.method_75("Prayers", var2 + var4 / 4 + var4 / 2, var3 + 16, 4, 0);
      int var8;
      int var9;
      String var10;
      int var11;
      int var17;
      if (this.qdb == 0) {
         this.odb.method_309(this.pdb);
         var8 = 0;

         int var12;
         for(var9 = 0; var9 < class_11.field_471; ++var9) {
            var10 = "@yel@";

            for(var11 = 0; var11 < class_11.field_475[var9]; ++var11) {
               var12 = class_11.field_477[var9][var11];
               if (!this.method_206(var12, class_11.field_478[var9][var11])) {
                  var10 = "@whi@";
                  break;
               }
            }

            var12 = this.hdb[6];
            if (class_11.field_474[var9] > var12) {
               var10 = "@bla@";
            }

            this.odb.method_311(this.pdb, var8++, var10 + "Level " + class_11.field_474[var9] + ": " + class_11.field_472[var9]);
         }

         this.odb.method_283();
         var17 = this.odb.method_319(this.pdb);
         if (var17 != -1) {
            this.field_198.method_77("Level " + class_11.field_474[var17] + ": " + class_11.field_472[var17], var2 + 2, var3 + 124, 1, 16776960);
            this.field_198.method_77(class_11.field_473[var17], var2 + 2, var3 + 136, 0, 16777215);

            for(var11 = 0; var11 < class_11.field_475[var17]; ++var11) {
               var12 = class_11.field_477[var17][var11];
               this.field_198.method_52(var2 + 2 + var11 * 44, var3 + 150, this.field_207 + class_11.field_407[var12]);
               int var13 = this.method_205(var12);
               int var14 = class_11.field_478[var17][var11];
               String var15 = "@red@";
               if (this.method_206(var12, var14)) {
                  var15 = "@gre@";
               }

               this.field_198.method_77(var15 + var13 + "/" + var14, var2 + 2 + var11 * 44, var3 + 150, 1, 16777215);
            }
         } else {
            this.field_198.method_77("Point at a spell for a description", var2 + 2, var3 + 124, 1, 0);
         }
      }

      if (this.qdb == 1) {
         this.odb.method_309(this.pdb);
         var8 = 0;

         for(var9 = 0; var9 < class_11.field_479; ++var9) {
            var10 = "@whi@";
            if (class_11.field_482[var9] > this.idb[5]) {
               var10 = "@bla@";
            }

            if (this.ceb[var9]) {
               var10 = "@gre@";
            }

            this.odb.method_311(this.pdb, var8++, var10 + "Level " + class_11.field_482[var9] + ": " + class_11.field_480[var9]);
         }

         this.odb.method_283();
         var17 = this.odb.method_319(this.pdb);
         if (var17 != -1) {
            this.field_198.method_75("Level " + class_11.field_482[var17] + ": " + class_11.field_480[var17], var2 + var4 / 2, var3 + 130, 1, 16776960);
            this.field_198.method_75(class_11.field_481[var17], var2 + var4 / 2, var3 + 145, 0, 16777215);
            this.field_198.method_75("Drain rate: " + class_11.field_483[var17], var2 + var4 / 2, var3 + 160, 1, 0);
         } else {
            this.field_198.method_77("Point at a prayer for a description", var2 + 2, var3 + 124, 1, 0);
         }
      }

      if (var1) {
         var2 = super.field_139 - (this.field_198.field_10 - 199);
         int var16 = super.field_140 - 36;
         if (var2 >= 0 && var16 >= 0 && var2 < 196 && var16 < 182) {
            this.odb.method_280(var2 + (this.field_198.field_10 - 199), var16 + 36, super.field_142, super.field_141);
            if (var16 <= 24 && this.field_184 == 1) {
               if (var2 < 98 && this.qdb == 1) {
                  this.qdb = 0;
                  this.odb.method_310(this.pdb);
               } else if (var2 > 98 && this.qdb == 0) {
                  this.qdb = 1;
                  this.odb.method_310(this.pdb);
               }
            }

            if (this.field_184 == 1 && this.qdb == 0) {
               var8 = this.odb.method_319(this.pdb);
               if (var8 != -1) {
                  var9 = this.hdb[6];
                  if (class_11.field_474[var8] > var9) {
                     this.method_192("Your magic ability is not high enough for this spell", 3);
                  } else {
                     for(var17 = 0; var17 < class_11.field_475[var8]; ++var17) {
                        var11 = class_11.field_477[var8][var17];
                        if (!this.method_206(var11, class_11.field_478[var8][var17])) {
                           this.method_192("You don't have all the reagents you need for this spell", 3);
                           var17 = -1;
                           break;
                        }
                     }

                     if (var17 == class_11.field_475[var8]) {
                        this.rdb = var8;
                        this.edb = -1;
                     }
                  }
               }
            }

            if (this.field_184 == 1 && this.qdb == 1) {
               var8 = this.odb.method_319(this.pdb);
               if (var8 != -1) {
                  var9 = this.idb[5];
                  if (class_11.field_482[var8] > var9) {
                     this.method_192("Your prayer ability is not high enough for this prayer", 3);
                  } else if (this.hdb[5] == 0) {
                     this.method_192("You have run out of prayer points. Return to a church to recharge", 3);
                  } else if (this.ceb[var8]) {
                     super.field_157.method_358(211);
                     super.field_157.method_349(var8);
                     super.field_157.method_359();
                     this.ceb[var8] = false;
                     this.method_179("prayeroff");
                  } else {
                     super.field_157.method_358(212);
                     super.field_157.method_349(var8);
                     super.field_157.method_359();
                     this.ceb[var8] = true;
                     this.method_179("prayeron");
                  }
               }
            }

            this.field_184 = 0;
         }

      }
   }

   // $FF: renamed from: fn (boolean) void
   public void method_236(boolean var1) {
      int var2 = this.field_198.field_10 - 199;
      byte var3 = 36;
      this.field_198.method_52(var2 - 49, 3, this.field_205 + 5);
      short var4 = 196;
      short var5 = 182;
      int var7;
      int var6 = var7 = class_1.method_43(160, 160, 160);
      if (this.udb == 0) {
         var6 = class_1.method_43(220, 220, 220);
      } else {
         var7 = class_1.method_43(220, 220, 220);
      }

      this.field_198.method_34(var2, var3, var4 / 2, 24, var6, 128);
      this.field_198.method_34(var2 + var4 / 2, var3, var4 / 2, 24, var7, 128);
      this.field_198.method_34(var2, var3 + 24, var4, var5 - 24, class_1.method_43(220, 220, 220), 128);
      this.field_198.method_38(var2, var3 + 24, var4, 0);
      this.field_198.method_39(var2 + var4 / 2, var3, 24, 0);
      this.field_198.method_38(var2, var3 + var5 - 16, var4, 0);
      this.field_198.method_75("Friends", var2 + var4 / 4, var3 + 16, 4, 0);
      this.field_198.method_75("Ignore", var2 + var4 / 4 + var4 / 2, var3 + 16, 4, 0);
      this.sdb.method_309(this.tdb);
      int var8;
      if (this.udb == 0) {
         for(var8 = 0; var8 < super.field_161; ++var8) {
            String var9;
            if (super.field_163[var8] == 10) {
               var9 = "@gre@";
            } else if (super.field_163[var8] > 0) {
               var9 = "@yel@";
            } else {
               var9 = "@red@";
            }

            this.sdb.method_311(this.tdb, var8, var9 + class_0.method_15(super.field_162[var8]) + "~439~@whi@Remove         WWWWWWWWWW");
         }
      }

      if (this.udb == 1) {
         for(var8 = 0; var8 < super.field_164; ++var8) {
            this.sdb.method_311(this.tdb, var8, "@yel@" + class_0.method_15(super.field_165[var8]) + "~439~@whi@Remove         WWWWWWWWWW");
         }
      }

      this.sdb.method_283();
      int var11;
      if (this.udb == 0) {
         var8 = this.sdb.method_319(this.tdb);
         if (var8 >= 0 && super.field_139 < 489) {
            if (super.field_139 > 429) {
               this.field_198.method_75("Click to remove " + class_0.method_15(super.field_162[var8]), var2 + var4 / 2, var3 + 35, 1, 16777215);
            } else if (super.field_163[var8] == 10) {
               this.field_198.method_75("Click to message " + class_0.method_15(super.field_162[var8]), var2 + var4 / 2, var3 + 35, 1, 16777215);
            } else if (super.field_163[var8] > 0) {
               this.field_198.method_75(class_0.method_15(super.field_162[var8]) + " is on world " + super.field_163[var8], var2 + var4 / 2, var3 + 35, 1, 16777215);
            } else {
               this.field_198.method_75(class_0.method_15(super.field_162[var8]) + " is offline", var2 + var4 / 2, var3 + 35, 1, 16777215);
            }
         } else {
            this.field_198.method_75("Click a name to send a message", var2 + var4 / 2, var3 + 35, 1, 16777215);
         }

         if (super.field_139 > var2 && super.field_139 < var2 + var4 && super.field_140 > var3 + var5 - 16 && super.field_140 < var3 + var5) {
            var11 = 16776960;
         } else {
            var11 = 16777215;
         }

         this.field_198.method_75("Click here to add a friend", var2 + var4 / 2, var3 + var5 - 3, 1, var11);
      }

      if (this.udb == 1) {
         var8 = this.sdb.method_319(this.tdb);
         if (var8 >= 0 && super.field_139 < 489 && super.field_139 > 429) {
            if (super.field_139 > 429) {
               this.field_198.method_75("Click to remove " + class_0.method_15(super.field_165[var8]), var2 + var4 / 2, var3 + 35, 1, 16777215);
            }
         } else {
            this.field_198.method_75("Blocking messages from:", var2 + var4 / 2, var3 + 35, 1, 16777215);
         }

         if (super.field_139 > var2 && super.field_139 < var2 + var4 && super.field_140 > var3 + var5 - 16 && super.field_140 < var3 + var5) {
            var11 = 16776960;
         } else {
            var11 = 16777215;
         }

         this.field_198.method_75("Click here to add a name", var2 + var4 / 2, var3 + var5 - 3, 1, var11);
      }

      if (var1) {
         var2 = super.field_139 - (this.field_198.field_10 - 199);
         int var10 = super.field_140 - 36;
         if (var2 >= 0 && var10 >= 0 && var2 < 196 && var10 < 182) {
            this.sdb.method_280(var2 + (this.field_198.field_10 - 199), var10 + 36, super.field_142, super.field_141);
            if (var10 <= 24 && this.field_184 == 1) {
               if (var2 < 98 && this.udb == 1) {
                  this.udb = 0;
                  this.sdb.method_310(this.tdb);
               } else if (var2 > 98 && this.udb == 0) {
                  this.udb = 1;
                  this.sdb.method_310(this.tdb);
               }
            }

            if (this.field_184 == 1 && this.udb == 0) {
               var8 = this.sdb.method_319(this.tdb);
               if (var8 >= 0 && super.field_139 < 489) {
                  if (super.field_139 > 429) {
                     this.method_153(super.field_162[var8]);
                  } else if (super.field_163[var8] != 0) {
                     this.dib = 2;
                     this.vdb = super.field_162[var8];
                     super.field_148 = "";
                     super.field_149 = "";
                  }
               }
            }

            if (this.field_184 == 1 && this.udb == 1) {
               var8 = this.sdb.method_319(this.tdb);
               if (var8 >= 0 && super.field_139 < 489 && super.field_139 > 429) {
                  this.method_151(super.field_165[var8]);
               }
            }

            if (var10 > 166 && this.field_184 == 1 && this.udb == 0) {
               this.dib = 1;
               super.field_146 = "";
               super.field_147 = "";
            }

            if (var10 > 166 && this.field_184 == 1 && this.udb == 1) {
               this.dib = 3;
               super.field_146 = "";
               super.field_147 = "";
            }

            this.field_184 = 0;
         }

      }
   }

   // $FF: renamed from: no (boolean) void
   public void method_237(boolean var1) {
      int var2 = this.field_198.field_10 - 199;
      byte var3 = 36;
      this.field_198.method_52(var2 - 49, 3, this.field_205 + 6);
      short var4 = 196;
      this.field_198.method_34(var2, 36, var4, 65, class_1.method_43(181, 181, 181), 160);
      this.field_198.method_34(var2, 101, var4, 65, class_1.method_43(201, 201, 201), 160);
      this.field_198.method_34(var2, 166, var4, 95, class_1.method_43(181, 181, 181), 160);
      this.field_198.method_34(var2, 261, var4, 40, class_1.method_43(201, 201, 201), 160);
      int var5 = var2 + 3;
      int var6 = var3 + 15;
      this.field_198.method_77("Game options - click to toggle", var5, var6, 1, 0);
      var6 += 15;
      if (this.eeb) {
         this.field_198.method_77("Camera angle mode - @gre@Auto", var5, var6, 1, 16777215);
      } else {
         this.field_198.method_77("Camera angle mode - @red@Manual", var5, var6, 1, 16777215);
      }

      var6 += 15;
      if (this.feb) {
         this.field_198.method_77("Mouse buttons - @red@One", var5, var6, 1, 16777215);
      } else {
         this.field_198.method_77("Mouse buttons - @gre@Two", var5, var6, 1, 16777215);
      }

      var6 += 15;
      if (this.field_174) {
         if (this.geb) {
            this.field_198.method_77("Sound effects - @red@off", var5, var6, 1, 16777215);
         } else {
            this.field_198.method_77("Sound effects - @gre@on", var5, var6, 1, 16777215);
         }
      }

      var6 += 15;
      var6 += 5;
      this.field_198.method_77("Security settings", var5, var6, 1, 0);
      var6 += 15;
      int var7 = 16777215;
      if (super.field_139 > var5 && super.field_139 < var5 + var4 && super.field_140 > var6 - 12 && super.field_140 < var6 + 4) {
         var7 = 16776960;
      }

      this.field_198.method_77("Change password", var5, var6, 1, var7);
      var6 += 15;
      var7 = 16777215;
      if (super.field_139 > var5 && super.field_139 < var5 + var4 && super.field_140 > var6 - 12 && super.field_140 < var6 + 4) {
         var7 = 16776960;
      }

      this.field_198.method_77("Change recovery questions", var5, var6, 1, var7);
      var6 += 15;
      var6 += 15;
      var6 += 5;
      this.field_198.method_77("Privacy settings. Will be applied to", var2 + 3, var6, 1, 0);
      var6 += 15;
      this.field_198.method_77("all people not on your friends list", var2 + 3, var6, 1, 0);
      var6 += 15;
      if (super.field_166 == 0) {
         this.field_198.method_77("Block chat messages: @red@<off>", var2 + 3, var6, 1, 16777215);
      } else {
         this.field_198.method_77("Block chat messages: @gre@<on>", var2 + 3, var6, 1, 16777215);
      }

      var6 += 15;
      if (super.field_167 == 0) {
         this.field_198.method_77("Block private messages: @red@<off>", var2 + 3, var6, 1, 16777215);
      } else {
         this.field_198.method_77("Block private messages: @gre@<on>", var2 + 3, var6, 1, 16777215);
      }

      var6 += 15;
      if (super.field_168 == 0) {
         this.field_198.method_77("Block trade requests: @red@<off>", var2 + 3, var6, 1, 16777215);
      } else {
         this.field_198.method_77("Block trade requests: @gre@<on>", var2 + 3, var6, 1, 16777215);
      }

      var6 += 15;
      if (this.field_174) {
         if (super.field_169 == 0) {
            this.field_198.method_77("Block duel requests: @red@<off>", var2 + 3, var6, 1, 16777215);
         } else {
            this.field_198.method_77("Block duel requests: @gre@<on>", var2 + 3, var6, 1, 16777215);
         }
      }

      var6 += 15;
      var6 += 5;
      this.field_198.method_77("Always logout when you finish", var5, var6, 1, 0);
      var6 += 15;
      var7 = 16777215;
      if (super.field_139 > var5 && super.field_139 < var5 + var4 && super.field_140 > var6 - 12 && super.field_140 < var6 + 4) {
         var7 = 16776960;
      }

      this.field_198.method_77("Click here to logout", var2 + 3, var6, 1, var7);
      if (var1) {
         var2 = super.field_139 - (this.field_198.field_10 - 199);
         int var11 = super.field_140 - 36;
         if (var2 >= 0 && var11 >= 0 && var2 < 196 && var11 < 265) {
            int var8 = this.field_198.field_10 - 199;
            byte var9 = 36;
            var4 = 196;
            var5 = var8 + 3;
            var6 = var9 + 30;
            if (super.field_139 > var5 && super.field_139 < var5 + var4 && super.field_140 > var6 - 12 && super.field_140 < var6 + 4 && this.field_184 == 1) {
               this.eeb = !this.eeb;
               super.field_157.method_358(213);
               super.field_157.method_349(0);
               super.field_157.method_349(this.eeb ? 1 : 0);
               super.field_157.method_359();
            }

            var6 += 15;
            if (super.field_139 > var5 && super.field_139 < var5 + var4 && super.field_140 > var6 - 12 && super.field_140 < var6 + 4 && this.field_184 == 1) {
               this.feb = !this.feb;
               super.field_157.method_358(213);
               super.field_157.method_349(2);
               super.field_157.method_349(this.feb ? 1 : 0);
               super.field_157.method_359();
            }

            var6 += 15;
            if (this.field_174 && super.field_139 > var5 && super.field_139 < var5 + var4 && super.field_140 > var6 - 12 && super.field_140 < var6 + 4 && this.field_184 == 1) {
               this.geb = !this.geb;
               super.field_157.method_358(213);
               super.field_157.method_349(3);
               super.field_157.method_349(this.geb ? 1 : 0);
               super.field_157.method_359();
            }

            var6 += 15;
            var6 += 20;
            if (super.field_139 > var5 && super.field_139 < var5 + var4 && super.field_140 > var6 - 12 && super.field_140 < var6 + 4 && this.field_184 == 1) {
               this.eib = 6;
               super.field_146 = "";
               super.field_147 = "";
            }

            var6 += 15;
            if (super.field_139 > var5 && super.field_139 < var5 + var4 && super.field_140 > var6 - 12 && super.field_140 < var6 + 4 && this.field_184 == 1) {
               super.field_157.method_358(197);
               super.field_157.method_359();
            }

            var6 += 15;
            var6 += 15;
            boolean var10 = false;
            var6 += 35;
            if (super.field_139 > var5 && super.field_139 < var5 + var4 && super.field_140 > var6 - 12 && super.field_140 < var6 + 4 && this.field_184 == 1) {
               super.field_166 = 1 - super.field_166;
               var10 = true;
            }

            var6 += 15;
            if (super.field_139 > var5 && super.field_139 < var5 + var4 && super.field_140 > var6 - 12 && super.field_140 < var6 + 4 && this.field_184 == 1) {
               super.field_167 = 1 - super.field_167;
               var10 = true;
            }

            var6 += 15;
            if (super.field_139 > var5 && super.field_139 < var5 + var4 && super.field_140 > var6 - 12 && super.field_140 < var6 + 4 && this.field_184 == 1) {
               super.field_168 = 1 - super.field_168;
               var10 = true;
            }

            var6 += 15;
            if (this.field_174 && super.field_139 > var5 && super.field_139 < var5 + var4 && super.field_140 > var6 - 12 && super.field_140 < var6 + 4 && this.field_184 == 1) {
               super.field_169 = 1 - super.field_169;
               var10 = true;
            }

            var6 += 15;
            if (var10) {
               this.method_149(super.field_166, super.field_167, super.field_168, super.field_169);
            }

            var6 += 20;
            if (super.field_139 > var5 && super.field_139 < var5 + var4 && super.field_140 > var6 - 12 && super.field_140 < var6 + 4 && this.field_184 == 1) {
               this.method_178();
            }

            this.field_184 = 0;
         }

      }
   }

   // $FF: renamed from: zm () void
   public void method_238() {
      int var1 = -1;

      for(int var2 = 0; var2 < this.icb; ++var2) {
         this.pcb[var2] = false;
      }

      for(int var3 = 0; var3 < this.rcb; ++var3) {
         this.xcb[var3] = false;
      }

      int var4 = this.field_197.method_372();
      class_8[] var5 = this.field_197.method_374();
      int[] var6 = this.field_197.method_373();

      for(int var7 = 0; var7 < var4 && this.meb <= 200; ++var7) {
         int var8 = var6[var7];
         class_8 var9 = var5[var7];
         if (var9.field_292[var8] <= 65535 || var9.field_292[var8] >= 200000 && var9.field_292[var8] <= 300000) {
            int var10;
            int var11;
            if (var9 == this.field_197.field_632) {
               var10 = var9.field_292[var8] % 10000;
               var11 = var9.field_292[var8] / 10000;
               String var12;
               int var13;
               if (var11 == 1) {
                  var12 = "";
                  var13 = 0;
                  if (this.pbb.field_517 > 0 && this.nbb[var10].field_517 > 0) {
                     var13 = this.pbb.field_517 - this.nbb[var10].field_517;
                  }

                  if (var13 < 0) {
                     var12 = "@or1@";
                  }

                  if (var13 < -3) {
                     var12 = "@or2@";
                  }

                  if (var13 < -6) {
                     var12 = "@or3@";
                  }

                  if (var13 < -9) {
                     var12 = "@red@";
                  }

                  if (var13 > 0) {
                     var12 = "@gr1@";
                  }

                  if (var13 > 3) {
                     var12 = "@gr2@";
                  }

                  if (var13 > 6) {
                     var12 = "@gr3@";
                  }

                  if (var13 > 9) {
                     var12 = "@gre@";
                  }

                  var12 = " " + var12 + "(level-" + this.nbb[var10].field_517 + ")";
                  if (this.rdb >= 0) {
                     if (class_11.field_476[this.rdb] == 1 || class_11.field_476[this.rdb] == 2 && this.rbb < 2203) {
                        this.peb[this.meb] = "Cast " + class_11.field_472[this.rdb] + " on";
                        this.oeb[this.meb] = "@whi@" + this.nbb[var10].field_495;
                        this.qeb[this.meb] = 800;
                        this.reb[this.meb] = this.nbb[var10].field_498;
                        this.seb[this.meb] = this.nbb[var10].field_499;
                        this.teb[this.meb] = this.nbb[var10].field_496;
                        this.ueb[this.meb] = this.rdb;
                        ++this.meb;
                     }
                  } else if (this.edb >= 0) {
                     this.peb[this.meb] = "Use " + this.fdb + " with";
                     this.oeb[this.meb] = "@whi@" + this.nbb[var10].field_495;
                     this.qeb[this.meb] = 810;
                     this.reb[this.meb] = this.nbb[var10].field_498;
                     this.seb[this.meb] = this.nbb[var10].field_499;
                     this.teb[this.meb] = this.nbb[var10].field_496;
                     this.ueb[this.meb] = this.edb;
                     ++this.meb;
                  } else {
                     if (this.rbb + this.mab + this.qab < 2203 && (this.nbb[var10].field_499 - 64) / this.field_200 + this.mab + this.qab < 2203) {
                        this.peb[this.meb] = "Attack";
                        this.oeb[this.meb] = "@whi@" + this.nbb[var10].field_495 + var12;
                        if (var13 >= 0 && var13 < 5) {
                           this.qeb[this.meb] = 805;
                        } else {
                           this.qeb[this.meb] = 2805;
                        }

                        this.reb[this.meb] = this.nbb[var10].field_498;
                        this.seb[this.meb] = this.nbb[var10].field_499;
                        this.teb[this.meb] = this.nbb[var10].field_496;
                        ++this.meb;
                     } else if (this.field_174) {
                        this.peb[this.meb] = "Duel with";
                        this.oeb[this.meb] = "@whi@" + this.nbb[var10].field_495 + var12;
                        this.reb[this.meb] = this.nbb[var10].field_498;
                        this.seb[this.meb] = this.nbb[var10].field_499;
                        this.qeb[this.meb] = 2806;
                        this.teb[this.meb] = this.nbb[var10].field_496;
                        ++this.meb;
                     }

                     this.peb[this.meb] = "Trade with";
                     this.oeb[this.meb] = "@whi@" + this.nbb[var10].field_495;
                     this.qeb[this.meb] = 2810;
                     this.teb[this.meb] = this.nbb[var10].field_496;
                     ++this.meb;
                     this.peb[this.meb] = "Follow";
                     this.oeb[this.meb] = "@whi@" + this.nbb[var10].field_495;
                     this.qeb[this.meb] = 2820;
                     this.teb[this.meb] = this.nbb[var10].field_496;
                     ++this.meb;
                  }
               } else if (var11 == 2) {
                  if (this.rdb >= 0) {
                     if (class_11.field_476[this.rdb] == 3) {
                        this.peb[this.meb] = "Cast " + class_11.field_472[this.rdb] + " on";
                        this.oeb[this.meb] = "@lre@" + class_11.field_404[this.fcb[var10]];
                        this.qeb[this.meb] = 200;
                        this.reb[this.meb] = this.dcb[var10];
                        this.seb[this.meb] = this.ecb[var10];
                        this.teb[this.meb] = this.fcb[var10];
                        this.ueb[this.meb] = this.rdb;
                        ++this.meb;
                     }
                  } else if (this.edb >= 0) {
                     this.peb[this.meb] = "Use " + this.fdb + " with";
                     this.oeb[this.meb] = "@lre@" + class_11.field_404[this.fcb[var10]];
                     this.qeb[this.meb] = 210;
                     this.reb[this.meb] = this.dcb[var10];
                     this.seb[this.meb] = this.ecb[var10];
                     this.teb[this.meb] = this.fcb[var10];
                     this.ueb[this.meb] = this.edb;
                     ++this.meb;
                  } else {
                     this.peb[this.meb] = "Take";
                     this.oeb[this.meb] = "@lre@" + class_11.field_404[this.fcb[var10]];
                     this.qeb[this.meb] = 220;
                     this.reb[this.meb] = this.dcb[var10];
                     this.seb[this.meb] = this.ecb[var10];
                     this.teb[this.meb] = this.fcb[var10];
                     ++this.meb;
                     this.peb[this.meb] = "Examine";
                     this.oeb[this.meb] = "@lre@" + class_11.field_404[this.fcb[var10]];
                     this.qeb[this.meb] = 3200;
                     this.teb[this.meb] = this.fcb[var10];
                     ++this.meb;
                  }
               } else if (var11 == 3) {
                  var12 = "";
                  var13 = -1;
                  int var14 = this.ybb[var10].field_500;
                  if (class_11.field_422[var14] > 0) {
                     int var15 = (class_11.field_418[var14] + class_11.field_421[var14] + class_11.field_419[var14] + class_11.field_420[var14]) / 4;
                     int var16 = (this.idb[0] + this.idb[1] + this.idb[2] + this.idb[3] + 27) / 4;
                     var13 = var16 - var15;
                     var12 = "@yel@";
                     if (var13 < 0) {
                        var12 = "@or1@";
                     }

                     if (var13 < -3) {
                        var12 = "@or2@";
                     }

                     if (var13 < -6) {
                        var12 = "@or3@";
                     }

                     if (var13 < -9) {
                        var12 = "@red@";
                     }

                     if (var13 > 0) {
                        var12 = "@gr1@";
                     }

                     if (var13 > 3) {
                        var12 = "@gr2@";
                     }

                     if (var13 > 6) {
                        var12 = "@gr3@";
                     }

                     if (var13 > 9) {
                        var12 = "@gre@";
                     }

                     var12 = " " + var12 + "(level-" + var15 + ")";
                  }

                  if (this.rdb >= 0) {
                     if (class_11.field_476[this.rdb] == 2) {
                        this.peb[this.meb] = "Cast " + class_11.field_472[this.rdb] + " on";
                        this.oeb[this.meb] = "@yel@" + class_11.field_416[this.ybb[var10].field_500];
                        this.qeb[this.meb] = 700;
                        this.reb[this.meb] = this.ybb[var10].field_498;
                        this.seb[this.meb] = this.ybb[var10].field_499;
                        this.teb[this.meb] = this.ybb[var10].field_496;
                        this.ueb[this.meb] = this.rdb;
                        ++this.meb;
                     }
                  } else if (this.edb >= 0) {
                     this.peb[this.meb] = "Use " + this.fdb + " with";
                     this.oeb[this.meb] = "@yel@" + class_11.field_416[this.ybb[var10].field_500];
                     this.qeb[this.meb] = 710;
                     this.reb[this.meb] = this.ybb[var10].field_498;
                     this.seb[this.meb] = this.ybb[var10].field_499;
                     this.teb[this.meb] = this.ybb[var10].field_496;
                     this.ueb[this.meb] = this.edb;
                     ++this.meb;
                  } else {
                     if (class_11.field_422[var14] > 0) {
                        this.peb[this.meb] = "Attack";
                        this.oeb[this.meb] = "@yel@" + class_11.field_416[this.ybb[var10].field_500] + var12;
                        if (var13 >= 0) {
                           this.qeb[this.meb] = 715;
                        } else {
                           this.qeb[this.meb] = 2715;
                        }

                        this.reb[this.meb] = this.ybb[var10].field_498;
                        this.seb[this.meb] = this.ybb[var10].field_499;
                        this.teb[this.meb] = this.ybb[var10].field_496;
                        ++this.meb;
                     }

                     this.peb[this.meb] = "Talk-to";
                     this.oeb[this.meb] = "@yel@" + class_11.field_416[this.ybb[var10].field_500];
                     this.qeb[this.meb] = 720;
                     this.reb[this.meb] = this.ybb[var10].field_498;
                     this.seb[this.meb] = this.ybb[var10].field_499;
                     this.teb[this.meb] = this.ybb[var10].field_496;
                     ++this.meb;
                     this.peb[this.meb] = "Examine";
                     this.oeb[this.meb] = "@yel@" + class_11.field_416[this.ybb[var10].field_500];
                     this.qeb[this.meb] = 3700;
                     this.teb[this.meb] = this.ybb[var10].field_500;
                     ++this.meb;
                  }
               }
            } else if (var9 != null && var9.field_291 >= 10000) {
               var10 = var9.field_291 - 10000;
               var11 = this.wcb[var10];
               if (!this.xcb[var10]) {
                  if (this.rdb >= 0) {
                     if (class_11.field_476[this.rdb] == 4) {
                        this.peb[this.meb] = "Cast " + class_11.field_472[this.rdb] + " on";
                        this.oeb[this.meb] = "@cya@" + class_11.field_454[var11];
                        this.qeb[this.meb] = 300;
                        this.reb[this.meb] = this.tcb[var10];
                        this.seb[this.meb] = this.ucb[var10];
                        this.teb[this.meb] = this.vcb[var10];
                        this.ueb[this.meb] = this.rdb;
                        ++this.meb;
                     }
                  } else if (this.edb >= 0) {
                     this.peb[this.meb] = "Use " + this.fdb + " with";
                     this.oeb[this.meb] = "@cya@" + class_11.field_454[var11];
                     this.qeb[this.meb] = 310;
                     this.reb[this.meb] = this.tcb[var10];
                     this.seb[this.meb] = this.ucb[var10];
                     this.teb[this.meb] = this.vcb[var10];
                     this.ueb[this.meb] = this.edb;
                     ++this.meb;
                  } else {
                     if (!class_11.field_456[var11].equalsIgnoreCase("WalkTo")) {
                        this.peb[this.meb] = class_11.field_456[var11];
                        this.oeb[this.meb] = "@cya@" + class_11.field_454[var11];
                        this.qeb[this.meb] = 320;
                        this.reb[this.meb] = this.tcb[var10];
                        this.seb[this.meb] = this.ucb[var10];
                        this.teb[this.meb] = this.vcb[var10];
                        ++this.meb;
                     }

                     if (!class_11.field_457[var11].equalsIgnoreCase("Examine")) {
                        this.peb[this.meb] = class_11.field_457[var11];
                        this.oeb[this.meb] = "@cya@" + class_11.field_454[var11];
                        this.qeb[this.meb] = 2300;
                        this.reb[this.meb] = this.tcb[var10];
                        this.seb[this.meb] = this.ucb[var10];
                        this.teb[this.meb] = this.vcb[var10];
                        ++this.meb;
                     }

                     this.peb[this.meb] = "Examine";
                     this.oeb[this.meb] = "@cya@" + class_11.field_454[var11];
                     this.qeb[this.meb] = 3300;
                     this.teb[this.meb] = var11;
                     ++this.meb;
                  }

                  this.xcb[var10] = true;
               }
            } else if (var9 != null && var9.field_291 >= 0) {
               var10 = var9.field_291;
               var11 = this.mcb[var10];
               if (!this.pcb[var10]) {
                  if (this.rdb >= 0) {
                     if (class_11.field_476[this.rdb] == 5) {
                        this.peb[this.meb] = "Cast " + class_11.field_472[this.rdb] + " on";
                        this.oeb[this.meb] = "@cya@" + class_11.field_444[var11];
                        this.qeb[this.meb] = 400;
                        this.reb[this.meb] = this.kcb[var10];
                        this.seb[this.meb] = this.lcb[var10];
                        this.teb[this.meb] = this.ncb[var10];
                        this.ueb[this.meb] = this.mcb[var10];
                        this.veb[this.meb] = this.rdb;
                        ++this.meb;
                     }
                  } else if (this.edb >= 0) {
                     this.peb[this.meb] = "Use " + this.fdb + " with";
                     this.oeb[this.meb] = "@cya@" + class_11.field_444[var11];
                     this.qeb[this.meb] = 410;
                     this.reb[this.meb] = this.kcb[var10];
                     this.seb[this.meb] = this.lcb[var10];
                     this.teb[this.meb] = this.ncb[var10];
                     this.ueb[this.meb] = this.mcb[var10];
                     this.veb[this.meb] = this.edb;
                     ++this.meb;
                  } else {
                     if (!class_11.field_446[var11].equalsIgnoreCase("WalkTo")) {
                        this.peb[this.meb] = class_11.field_446[var11];
                        this.oeb[this.meb] = "@cya@" + class_11.field_444[var11];
                        this.qeb[this.meb] = 420;
                        this.reb[this.meb] = this.kcb[var10];
                        this.seb[this.meb] = this.lcb[var10];
                        this.teb[this.meb] = this.ncb[var10];
                        this.ueb[this.meb] = this.mcb[var10];
                        ++this.meb;
                     }

                     if (!class_11.field_447[var11].equalsIgnoreCase("Examine")) {
                        this.peb[this.meb] = class_11.field_447[var11];
                        this.oeb[this.meb] = "@cya@" + class_11.field_444[var11];
                        this.qeb[this.meb] = 2400;
                        this.reb[this.meb] = this.kcb[var10];
                        this.seb[this.meb] = this.lcb[var10];
                        this.teb[this.meb] = this.ncb[var10];
                        this.ueb[this.meb] = this.mcb[var10];
                        ++this.meb;
                     }

                     this.peb[this.meb] = "Examine";
                     this.oeb[this.meb] = "@cya@" + class_11.field_444[var11];
                     this.qeb[this.meb] = 3400;
                     this.teb[this.meb] = var11;
                     ++this.meb;
                  }

                  this.pcb[var10] = true;
               }
            } else {
               if (var8 >= 0) {
                  var8 = var9.field_292[var8] - 200000;
               }

               if (var8 >= 0) {
                  var1 = var8;
               }
            }
         }
      }

      if (this.rdb >= 0 && class_11.field_476[this.rdb] <= 1) {
         this.peb[this.meb] = "Cast " + class_11.field_472[this.rdb] + " on self";
         this.oeb[this.meb] = "";
         this.qeb[this.meb] = 1000;
         this.teb[this.meb] = this.rdb;
         ++this.meb;
      }

      if (var1 != -1) {
         if (this.rdb >= 0) {
            if (class_11.field_476[this.rdb] == 6) {
               this.peb[this.meb] = "Cast " + class_11.field_472[this.rdb] + " on ground";
               this.oeb[this.meb] = "";
               this.qeb[this.meb] = 900;
               this.reb[this.meb] = this.kab.field_92[var1];
               this.seb[this.meb] = this.kab.field_93[var1];
               this.teb[this.meb] = this.rdb;
               ++this.meb;
               return;
            }
         } else if (this.edb < 0) {
            this.peb[this.meb] = "Walk here";
            this.oeb[this.meb] = "";
            this.qeb[this.meb] = 920;
            this.reb[this.meb] = this.kab.field_92[var1];
            this.seb[this.meb] = this.kab.field_93[var1];
            ++this.meb;
         }
      }

   }

   // $FF: renamed from: pp () void
   public void method_239() {
      int var1;
      int var2;
      int var3;
      if (this.field_184 == 0) {
         if (super.field_139 >= this.ieb - 10 && super.field_140 >= this.jeb - 10 && super.field_139 <= this.ieb + this.keb + 10 && super.field_140 <= this.jeb + this.leb + 10) {
            this.field_198.method_34(this.ieb, this.jeb, this.keb, this.leb, 13684944, 160);
            this.field_198.method_77("Choose option", this.ieb + 2, this.jeb + 12, 1, 65535);

            for(var1 = 0; var1 < this.meb; ++var1) {
               var2 = this.ieb + 2;
               var3 = this.jeb + 27 + var1 * 15;
               int var4 = 16777215;
               if (super.field_139 > var2 - 2 && super.field_140 > var3 - 12 && super.field_140 < var3 + 4 && super.field_139 < var2 - 3 + this.keb) {
                  var4 = 16776960;
               }

               this.field_198.method_77(this.peb[this.web[var1]] + " " + this.oeb[this.web[var1]], var2, var3, 1, var4);
            }

         } else {
            this.heb = false;
         }
      } else {
         for(var1 = 0; var1 < this.meb; ++var1) {
            var2 = this.ieb + 2;
            var3 = this.jeb + 27 + var1 * 15;
            if (super.field_139 > var2 - 2 && super.field_140 > var3 - 12 && super.field_140 < var3 + 4 && super.field_139 < var2 - 3 + this.keb) {
               this.method_241(this.web[var1]);
               break;
            }
         }

         this.field_184 = 0;
         this.heb = false;
      }
   }

   // $FF: renamed from: fo () void
   public void method_240() {
      if (this.rdb >= 0 || this.edb >= 0) {
         this.peb[this.meb] = "Cancel";
         this.oeb[this.meb] = "";
         this.qeb[this.meb] = 4000;
         ++this.meb;
      }

      for(int var1 = 0; var1 < this.meb; this.web[var1] = var1++) {
         ;
      }

      boolean var2 = false;

      int var3;
      int var4;
      while(!var2) {
         var2 = true;

         for(var3 = 0; var3 < this.meb - 1; ++var3) {
            var4 = this.web[var3];
            int var5 = this.web[var3 + 1];
            if (this.qeb[var4] > this.qeb[var5]) {
               this.web[var3] = var5;
               this.web[var3 + 1] = var4;
               var2 = false;
            }
         }
      }

      if (this.meb > 20) {
         this.meb = 20;
      }

      if (this.meb > 0) {
         var3 = -1;

         for(var4 = 0; var4 < this.meb; ++var4) {
            if (this.oeb[this.web[var4]] != null && this.oeb[this.web[var4]].length() > 0) {
               var3 = var4;
               break;
            }
         }

         String var8 = null;
         if ((this.edb >= 0 || this.rdb >= 0) && this.meb == 1) {
            var8 = "Choose a target";
         } else if ((this.edb >= 0 || this.rdb >= 0) && this.meb > 1) {
            var8 = "@whi@" + this.peb[this.web[0]] + " " + this.oeb[this.web[0]];
         } else if (var3 != -1) {
            var8 = this.oeb[this.web[var3]] + ": @whi@" + this.peb[this.web[0]];
         }

         if (this.meb == 2 && var8 != null) {
            var8 = var8 + "@whi@ / 1 more option";
         }

         if (this.meb > 2 && var8 != null) {
            var8 = var8 + "@whi@ / " + (this.meb - 1) + " more options";
         }

         if (var8 != null) {
            this.field_198.method_77(var8, 6, 14, 1, 16776960);
         }

         if (!this.feb && this.field_184 == 1 || this.feb && this.field_184 == 1 && this.meb == 1) {
            this.method_241(this.web[0]);
            this.field_184 = 0;
            return;
         }

         if (!this.feb && this.field_184 == 2 || this.feb && this.field_184 == 1) {
            this.leb = (this.meb + 1) * 15;
            this.keb = this.field_198.method_81("Choose option", 1) + 5;

            for(int var6 = 0; var6 < this.meb; ++var6) {
               int var7 = this.field_198.method_81(this.peb[var6] + " " + this.oeb[var6], 1) + 5;
               if (var7 > this.keb) {
                  this.keb = var7;
               }
            }

            this.ieb = super.field_139 - this.keb / 2;
            this.jeb = super.field_140 - 7;
            this.heb = true;
            if (this.ieb < 0) {
               this.ieb = 0;
            }

            if (this.jeb < 0) {
               this.jeb = 0;
            }

            if (this.ieb + this.keb > 510) {
               this.ieb = 510 - this.keb;
            }

            if (this.jeb + this.leb > 315) {
               this.jeb = 315 - this.leb;
            }

            this.field_184 = 0;
         }
      }

   }

   // $FF: renamed from: zo (int) void
   public void method_241(int var1) {
      int var2 = this.reb[var1];
      int var3 = this.seb[var1];
      int var4 = this.teb[var1];
      int var5 = this.ueb[var1];
      int var6 = this.veb[var1];
      int var7 = this.qeb[var1];
      if (var7 == 200) {
         this.method_210(this.qbb, this.rbb, var2, var3, true);
         super.field_157.method_358(224);
         super.field_157.method_350(var2 + this.pab);
         super.field_157.method_350(var3 + this.qab);
         super.field_157.method_350(var4);
         super.field_157.method_350(var5);
         super.field_157.method_359();
         this.rdb = -1;
      }

      if (var7 == 210) {
         this.method_210(this.qbb, this.rbb, var2, var3, true);
         super.field_157.method_358(250);
         super.field_157.method_350(var2 + this.pab);
         super.field_157.method_350(var3 + this.qab);
         super.field_157.method_350(var4);
         super.field_157.method_350(var5);
         super.field_157.method_359();
         this.edb = -1;
      }

      if (var7 == 220) {
         this.method_210(this.qbb, this.rbb, var2, var3, true);
         super.field_157.method_358(252);
         super.field_157.method_350(var2 + this.pab);
         super.field_157.method_350(var3 + this.qab);
         super.field_157.method_350(var4);
         super.field_157.method_359();
      }

      if (var7 == 3200) {
         this.method_192(class_11.field_405[var4], 3);
      }

      if (var7 == 300) {
         this.method_212(var2, var3, var4);
         super.field_157.method_358(223);
         super.field_157.method_350(var2 + this.pab);
         super.field_157.method_350(var3 + this.qab);
         super.field_157.method_349(var4);
         super.field_157.method_350(var5);
         super.field_157.method_359();
         this.rdb = -1;
      }

      if (var7 == 310) {
         this.method_212(var2, var3, var4);
         super.field_157.method_358(239);
         super.field_157.method_350(var2 + this.pab);
         super.field_157.method_350(var3 + this.qab);
         super.field_157.method_349(var4);
         super.field_157.method_350(var5);
         super.field_157.method_359();
         this.edb = -1;
      }

      if (var7 == 320) {
         this.method_212(var2, var3, var4);
         super.field_157.method_358(238);
         super.field_157.method_350(var2 + this.pab);
         super.field_157.method_350(var3 + this.qab);
         super.field_157.method_349(var4);
         super.field_157.method_359();
      }

      if (var7 == 2300) {
         this.method_212(var2, var3, var4);
         super.field_157.method_358(229);
         super.field_157.method_350(var2 + this.pab);
         super.field_157.method_350(var3 + this.qab);
         super.field_157.method_349(var4);
         super.field_157.method_359();
      }

      if (var7 == 3300) {
         this.method_192(class_11.field_455[var4], 3);
      }

      if (var7 == 400) {
         this.method_211(var2, var3, var4, var5);
         super.field_157.method_358(222);
         super.field_157.method_350(var2 + this.pab);
         super.field_157.method_350(var3 + this.qab);
         super.field_157.method_350(var6);
         super.field_157.method_359();
         this.rdb = -1;
      }

      if (var7 == 410) {
         this.method_211(var2, var3, var4, var5);
         super.field_157.method_358(241);
         super.field_157.method_350(var2 + this.pab);
         super.field_157.method_350(var3 + this.qab);
         super.field_157.method_350(var6);
         super.field_157.method_359();
         this.edb = -1;
      }

      if (var7 == 420) {
         this.method_211(var2, var3, var4, var5);
         super.field_157.method_358(242);
         super.field_157.method_350(var2 + this.pab);
         super.field_157.method_350(var3 + this.qab);
         super.field_157.method_359();
      }

      if (var7 == 2400) {
         this.method_211(var2, var3, var4, var5);
         super.field_157.method_358(230);
         super.field_157.method_350(var2 + this.pab);
         super.field_157.method_350(var3 + this.qab);
         super.field_157.method_359();
      }

      if (var7 == 3400) {
         this.method_192(class_11.field_445[var4], 3);
      }

      if (var7 == 600) {
         super.field_157.method_358(220);
         super.field_157.method_350(var4);
         super.field_157.method_350(var5);
         super.field_157.method_359();
         this.rdb = -1;
      }

      if (var7 == 610) {
         super.field_157.method_358(240);
         super.field_157.method_350(var4);
         super.field_157.method_350(var5);
         super.field_157.method_359();
         this.edb = -1;
      }

      if (var7 == 620) {
         super.field_157.method_358(248);
         super.field_157.method_350(var4);
         super.field_157.method_359();
      }

      if (var7 == 630) {
         super.field_157.method_358(249);
         super.field_157.method_350(var4);
         super.field_157.method_359();
      }

      if (var7 == 640) {
         super.field_157.method_358(246);
         super.field_157.method_350(var4);
         super.field_157.method_359();
      }

      if (var7 == 650) {
         this.edb = var4;
         this.ycb = 0;
         this.fdb = class_11.field_404[this.bdb[this.edb]];
      }

      if (var7 == 660) {
         super.field_157.method_358(251);
         super.field_157.method_350(var4);
         super.field_157.method_359();
         this.edb = -1;
         this.ycb = 0;
         this.method_192("Dropping " + class_11.field_404[this.bdb[var4]], 4);
      }

      if (var7 == 3600) {
         this.method_192(class_11.field_405[var4], 3);
      }

      int var8;
      int var9;
      if (var7 == 700) {
         var8 = (var2 - 64) / this.field_200;
         var9 = (var3 - 64) / this.field_200;
         this.method_209(this.qbb, this.rbb, var8, var9, true);
         super.field_157.method_358(225);
         super.field_157.method_350(var4);
         super.field_157.method_350(var5);
         super.field_157.method_359();
         this.rdb = -1;
      }

      if (var7 == 710) {
         var8 = (var2 - 64) / this.field_200;
         var9 = (var3 - 64) / this.field_200;
         this.method_209(this.qbb, this.rbb, var8, var9, true);
         super.field_157.method_358(243);
         super.field_157.method_350(var4);
         super.field_157.method_350(var5);
         super.field_157.method_359();
         this.edb = -1;
      }

      if (var7 == 720) {
         var8 = (var2 - 64) / this.field_200;
         var9 = (var3 - 64) / this.field_200;
         this.method_209(this.qbb, this.rbb, var8, var9, true);
         super.field_157.method_358(245);
         super.field_157.method_350(var4);
         super.field_157.method_359();
      }

      if (var7 == 715 || var7 == 2715) {
         var8 = (var2 - 64) / this.field_200;
         var9 = (var3 - 64) / this.field_200;
         this.method_209(this.qbb, this.rbb, var8, var9, true);
         super.field_157.method_358(244);
         super.field_157.method_350(var4);
         super.field_157.method_359();
      }

      if (var7 == 3700) {
         this.method_192(class_11.field_417[var4], 3);
      }

      if (var7 == 800) {
         var8 = (var2 - 64) / this.field_200;
         var9 = (var3 - 64) / this.field_200;
         this.method_209(this.qbb, this.rbb, var8, var9, true);
         super.field_157.method_358(226);
         super.field_157.method_350(var4);
         super.field_157.method_350(var5);
         super.field_157.method_359();
         this.rdb = -1;
      }

      if (var7 == 810) {
         var8 = (var2 - 64) / this.field_200;
         var9 = (var3 - 64) / this.field_200;
         this.method_209(this.qbb, this.rbb, var8, var9, true);
         super.field_157.method_358(219);
         super.field_157.method_350(var4);
         super.field_157.method_350(var5);
         super.field_157.method_359();
         this.edb = -1;
      }

      if (var7 == 805 || var7 == 2805) {
         var8 = (var2 - 64) / this.field_200;
         var9 = (var3 - 64) / this.field_200;
         this.method_209(this.qbb, this.rbb, var8, var9, true);
         super.field_157.method_358(228);
         super.field_157.method_350(var4);
         super.field_157.method_359();
      }

      if (var7 == 2806) {
         super.field_157.method_358(204);
         super.field_157.method_350(var4);
         super.field_157.method_359();
      }

      if (var7 == 2810) {
         super.field_157.method_358(235);
         super.field_157.method_350(var4);
         super.field_157.method_359();
      }

      if (var7 == 2820) {
         super.field_157.method_358(214);
         super.field_157.method_350(var4);
         super.field_157.method_359();
      }

      if (var7 == 900) {
         this.method_209(this.qbb, this.rbb, var2, var3, true);
         super.field_157.method_358(221);
         super.field_157.method_350(var2 + this.pab);
         super.field_157.method_350(var3 + this.qab);
         super.field_157.method_350(var4);
         super.field_157.method_359();
         this.rdb = -1;
      }

      if (var7 == 920) {
         this.method_209(this.qbb, this.rbb, var2, var3, false);
         if (this.hab == -24) {
            this.hab = 24;
         }
      }

      if (var7 == 1000) {
         super.field_157.method_358(227);
         super.field_157.method_350(var4);
         super.field_157.method_359();
         this.rdb = -1;
      }

      if (var7 == 4000) {
         this.edb = -1;
         this.rdb = -1;
      }

   }

   public mudclient() {
      super();
      this.field_186 = new int[this.field_185];
      this.field_187 = new int[this.field_185];
      this.field_189 = new int[8192];
      this.field_190 = new int[8192];
      this.field_192 = 2;
      this.field_194 = 2;
      this.field_200 = 128;
      this.field_202 = 512;
      this.field_203 = 334;
      this.field_204 = 9;
      this.bab = 40;
      this.fab = -1;
      this.gab = -1;
      this.oab = -1;
      this.rab = -1;
      this.zab = 550;
      this.abb = false;
      this.dbb = 1;
      this.fbb = 128;
      this.hbb = 4000;
      this.ibb = 500;
      this.mbb = new class_13[this.hbb];
      this.nbb = new class_13[this.ibb];
      this.obb = new class_13[this.ibb];
      this.pbb = new class_13();
      this.sbb = -1;
      this.tbb = 1500;
      this.ubb = 500;
      this.xbb = new class_13[this.tbb];
      this.ybb = new class_13[this.ubb];
      this.zbb = new class_13[this.ubb];
      this.acb = new int[500];
      this.bcb = 500;
      this.dcb = new int[this.bcb];
      this.ecb = new int[this.bcb];
      this.fcb = new int[this.bcb];
      this.gcb = new int[this.bcb];
      this.hcb = 1500;
      this.jcb = new class_8[this.hcb];
      this.kcb = new int[this.hcb];
      this.lcb = new int[this.hcb];
      this.mcb = new int[this.hcb];
      this.ncb = new int[this.hcb];
      this.ocb = new class_8[200];
      this.pcb = new boolean[this.hcb];
      this.qcb = 500;
      this.scb = new class_8[this.qcb];
      this.tcb = new int[this.qcb];
      this.ucb = new int[this.qcb];
      this.vcb = new int[this.qcb];
      this.wcb = new int[this.qcb];
      this.xcb = new boolean[this.qcb];
      this.zcb = 30;
      this.bdb = new int[35];
      this.cdb = new int[35];
      this.ddb = new int[35];
      this.edb = -1;
      this.fdb = "";
      this.gdb = new int[99];
      this.hdb = new int[16];
      this.idb = new int[16];
      this.jdb = new int[16];
      this.kdb = new int[5];
      this.mdb = new String[]{"Attack", "Defense", "Strength", "Hits", "Ranged", "Prayer", "Magic", "Cooking", "Woodcutting", "Fletching", "Fishing", "Firemaking", "Crafting", "Smithing", "Mining", "Herblaw"};
      this.ndb = new String[]{"Armour", "WeaponAim", "WeaponPower", "Magic", "Prayer"};
      this.rdb = -1;
      this.zdb = 22;
      this.aeb = new String[]{"Black knight's fortress", "Cook's assistant", "Demon slayer", "Doric's quest", "The restless ghost", "Goblin diplomacy", "Ernest the chicken", "Imp catcher", "Pirate's treasure", "Prince Ali rescue", "Romeo & Juliet", "Sheep shearer", "Shield of Arrav", "The knight's sword", "Vampire slayer", "Witch's potion", "Dragon slayer", "Witch's house (members)", "Lost city (members)", "Hero's quest (members)", "Druidic ritual (members)", "Merlin's crystal (members)"};
      this.beb = new boolean[this.zdb];
      this.ceb = new boolean[50];
      this.deb = false;
      this.eeb = true;
      this.feb = false;
      this.geb = false;
      this.heb = false;
      this.neb = 250;
      this.oeb = new String[this.neb];
      this.peb = new String[this.neb];
      this.qeb = new int[this.neb];
      this.reb = new int[this.neb];
      this.seb = new int[this.neb];
      this.teb = new int[this.neb];
      this.ueb = new int[this.neb];
      this.veb = new int[this.neb];
      this.web = new int[this.neb];
      this.hfb = 5;
      this.ifb = new String[this.hfb];
      this.jfb = new int[this.hfb];
      this.kfb = false;
      this.lfb = "";
      this.nfb = new int[8];
      this.ofb = new int[8];
      this.qfb = new int[8];
      this.rfb = new int[8];
      this.sfb = false;
      this.tfb = false;
      this.ufb = false;
      this.vfb = false;
      this.wfb = false;
      this.xfb = false;
      this.yfb = false;
      this.zfb = false;
      this.cgb = new int[8];
      this.dgb = new int[8];
      this.fgb = new int[8];
      this.ggb = new int[8];
      this.lgb = false;
      this.mgb = "";
      this.ogb = new int[14];
      this.pgb = new int[14];
      this.rgb = new int[14];
      this.sgb = new int[14];
      this.tgb = false;
      this.ugb = false;
      this.ygb = false;
      this.zgb = false;
      this.bhb = new int[14];
      this.chb = new int[14];
      this.ehb = new int[14];
      this.fhb = new int[14];
      this.ghb = false;
      this.jhb = new int[256];
      this.khb = new int[256];
      this.lhb = new int[256];
      this.mhb = -1;
      this.nhb = -2;
      this.ohb = false;
      this.qhb = new int[256];
      this.rhb = new int[256];
      this.thb = new int[256];
      this.uhb = new int[256];
      this.vhb = -1;
      this.whb = -2;
      this.xhb = 48;
      this.zhb = false;
      this.bib = new String[5];
      this.fib = "";
      this.gib = "";
      this.hib = false;
      this.iib = false;
      this.oib = false;
      this.pib = "";
      this.uib = false;
      this.rjb = "";
      this.sjb = "";
      this.tjb = "";
      this.ujb = "";
      this.lkb = false;
      this.pkb = -1;
      this.qkb = new int[5];
      this.rkb = new int[5];
      this.skb = new int[5];
      this.tkb = new int[5];
      this.ukb = new int[]{0, 1, 2, 3, 4};
      this.vkb = new String[5];
      this.wkb = false;
      this.ilb = new int[5];
      this.jlb = new int[5];
      this.llb = new String[50];
      this.mlb = new int[50];
      this.nlb = new int[50];
      this.olb = new int[50];
      this.plb = new int[50];
      this.rlb = new int[50];
      this.slb = new int[50];
      this.tlb = new int[50];
      this.ulb = new int[50];
      this.wlb = new int[50];
      this.xlb = new int[50];
      this.ylb = new int[50];
      this.bmb = new int[][]{{11, 2, 9, 7, 1, 6, 10, 0, 5, 8, 3, 4}, {11, 2, 9, 7, 1, 6, 10, 0, 5, 8, 3, 4}, {11, 3, 2, 9, 7, 1, 6, 10, 0, 5, 8, 4}, {3, 4, 2, 9, 7, 1, 6, 10, 8, 11, 0, 5}, {3, 4, 2, 9, 7, 1, 6, 10, 8, 11, 0, 5}, {4, 3, 2, 9, 7, 1, 6, 10, 8, 11, 0, 5}, {11, 4, 2, 9, 7, 1, 6, 10, 0, 5, 8, 3}, {11, 2, 9, 7, 1, 6, 10, 0, 5, 8, 4, 3}};
      this.cmb = false;
      this.emb = 1;
      this.fmb = 2;
      this.gmb = 2;
      this.hmb = 8;
      this.imb = 14;
      this.kmb = 1;
      this.lmb = new int[]{16711680, 16744448, 16769024, 10543104, 57344, 32768, 41088, 45311, 33023, 12528, 14680288, 3158064, 6307840, 8409088, 16777215};
      this.mmb = new int[]{16760880, 16752704, 8409136, 6307872, 3158064, 16736288, 16728064, 16777215, 65280, 65535};
      this.nmb = new int[]{15523536, 13415270, 11766848, 10056486, 9461792};
      this.omb = new int[]{0, 1, 2, 1};
      this.pmb = new int[]{0, 1, 2, 1, 0, 0, 0, 0};
      this.qmb = new int[]{0, 0, 0, 0, 0, 1, 2, 1};
      this.umb = new int[50];
      this.vmb = new int[50];
      this.wmb = new int[50];
      this.xmb = new int[50];
      this.ymb = new String[]{"Where were you born?", "What was your first teacher's name?", "What is your father's middle name?", "Who was your first best friend?", "What is your favourite vacation spot?", "What is your mother's middle name?", "What was your first pet's name?", "What was the name of your first school?", "What is your mother's maiden name?", "Who was your first boyfriend/girlfriend?", "What was the first computer game you purchased?", "Who is your favourite actor/actress?", "Who is your favourite author?", "Who is your favourite musician?", "Who is your favourite cartoon character?", "What is your favourite book?", "What is your favourite food?", "What is your favourite movie?"};
   }
}
