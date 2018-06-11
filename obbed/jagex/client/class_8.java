package jagex.client;

import jagex.class_0;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;

// $FF: renamed from: jagex.client.q
public class class_8 {
   // $FF: renamed from: it int
   public int field_259;
   // $FF: renamed from: jt int[]
   public int[] field_260;
   // $FF: renamed from: kt int[]
   public int[] field_261;
   // $FF: renamed from: lt int[]
   public int[] field_262;
   // $FF: renamed from: mt int[]
   public int[] field_263;
   // $FF: renamed from: nt int[]
   public int[] field_264;
   // $FF: renamed from: ot int[]
   public int[] field_265;
   // $FF: renamed from: pt byte[]
   public byte[] field_266;
   // $FF: renamed from: qt int
   public int field_267;
   // $FF: renamed from: rt int[]
   public int[] field_268;
   // $FF: renamed from: st int[][]
   public int[][] field_269;
   // $FF: renamed from: tt int[]
   public int[] field_270;
   // $FF: renamed from: ut int[]
   public int[] field_271;
   // $FF: renamed from: vt int[]
   public int[] field_272;
   // $FF: renamed from: wt int[]
   public int[] field_273;
   // $FF: renamed from: xt int[]
   public int[] field_274;
   // $FF: renamed from: yt int[]
   public int[] field_275;
   // $FF: renamed from: zt int[]
   public int[] field_276;
   // $FF: renamed from: au int[]
   public int[] field_277;
   // $FF: renamed from: bu int
   public int field_278;
   // $FF: renamed from: cu int
   public int field_279;
   // $FF: renamed from: du int
   public int field_280;
   // $FF: renamed from: eu boolean
   public boolean field_281;
   // $FF: renamed from: fu int
   public int field_282;
   // $FF: renamed from: gu int
   public int field_283;
   // $FF: renamed from: hu int
   public int field_284;
   // $FF: renamed from: iu int
   public int field_285;
   // $FF: renamed from: ju int
   public int field_286;
   // $FF: renamed from: ku int
   public int field_287;
   // $FF: renamed from: lu boolean
   public boolean field_288;
   // $FF: renamed from: mu boolean
   public boolean field_289;
   // $FF: renamed from: nu boolean
   public boolean field_290;
   // $FF: renamed from: ou int
   public int field_291;
   // $FF: renamed from: pu int[]
   public int[] field_292;
   // $FF: renamed from: qu byte[]
   public byte[] field_293;
   // $FF: renamed from: ru boolean
   private boolean field_294;
   // $FF: renamed from: su boolean
   public boolean field_295;
   // $FF: renamed from: tu boolean
   public boolean field_296;
   // $FF: renamed from: uu boolean
   public boolean field_297;
   // $FF: renamed from: vu boolean
   public boolean field_298;
   // $FF: renamed from: wu int[]
   private static int[] field_299 = new int[512];
   // $FF: renamed from: xu int[]
   private static int[] field_300 = new int[2048];
   // $FF: renamed from: yu byte[]
   private static byte[] field_301 = new byte[64];
   // $FF: renamed from: zu int[]
   private static int[] field_302 = new int[256];
   // $FF: renamed from: av int
   private int field_303;
   // $FF: renamed from: bv int
   private int field_304;
   // $FF: renamed from: cv int
   public int field_305;
   // $FF: renamed from: dv int[]
   public int[] field_306;
   // $FF: renamed from: ev int[]
   public int[] field_307;
   // $FF: renamed from: fv int[]
   public int[] field_308;
   // $FF: renamed from: gv int[]
   public int[] field_309;
   // $FF: renamed from: hv int[]
   public int[] field_310;
   // $FF: renamed from: iv int[]
   public int[] field_311;
   // $FF: renamed from: jv int
   private int field_312;
   // $FF: renamed from: kv int[][]
   private int[][] field_313;
   // $FF: renamed from: lv int[]
   private int[] field_314;
   // $FF: renamed from: mv int[]
   private int[] field_315;
   // $FF: renamed from: nv int[]
   private int[] field_316;
   // $FF: renamed from: ov int[]
   private int[] field_317;
   // $FF: renamed from: pv int[]
   private int[] field_318;
   // $FF: renamed from: qv int[]
   private int[] field_319;
   // $FF: renamed from: rv int
   private int field_320;
   // $FF: renamed from: sv int
   private int field_321;
   // $FF: renamed from: tv int
   private int field_322;
   // $FF: renamed from: uv int
   private int field_323;
   // $FF: renamed from: vv int
   private int field_324;
   // $FF: renamed from: wv int
   private int field_325;
   // $FF: renamed from: xv int
   private int field_326;
   // $FF: renamed from: yv int
   private int field_327;
   // $FF: renamed from: zv int
   private int field_328;
   // $FF: renamed from: aw int
   private int field_329;
   // $FF: renamed from: bw int
   private int field_330;
   // $FF: renamed from: cw int
   private int field_331;
   // $FF: renamed from: dw int
   private int field_332;
   // $FF: renamed from: ew int
   private int field_333;
   // $FF: renamed from: fw int
   private int field_334;
   // $FF: renamed from: gw int
   private int field_335;
   // $FF: renamed from: hw int
   private int field_336;
   // $FF: renamed from: iw int
   private int field_337;
   // $FF: renamed from: jw int
   private int field_338;
   // $FF: renamed from: kw int
   private int field_339;
   // $FF: renamed from: lw int
   private int field_340;
   // $FF: renamed from: mw int
   protected int field_341;
   // $FF: renamed from: nw int
   protected int field_342;
   // $FF: renamed from: ow byte[]
   private byte[] field_343;
   // $FF: renamed from: pw int
   private int field_344;
   // $FF: renamed from: qw int
   private int field_345;

   public class_8(int var1, int var2) {
      super();
      this.field_280 = 1;
      this.field_281 = true;
      this.field_288 = true;
      this.field_289 = false;
      this.field_290 = false;
      this.field_291 = -1;
      this.field_294 = false;
      this.field_295 = false;
      this.field_296 = false;
      this.field_297 = false;
      this.field_298 = false;
      this.field_303 = 4;
      this.field_304 = 12345678;
      this.field_336 = 12345678;
      this.field_337 = 180;
      this.field_338 = 155;
      this.field_339 = 95;
      this.field_340 = 256;
      this.field_341 = 512;
      this.field_342 = 32;
      this.method_242(var1, var2);
      this.field_313 = new int[var2][1];

      for(int var3 = 0; var3 < var2; this.field_313[var3][0] = var3++) {
         ;
      }

   }

   public class_8(int var1, int var2, boolean var3, boolean var4, boolean var5, boolean var6, boolean var7) {
      super();
      this.field_280 = 1;
      this.field_281 = true;
      this.field_288 = true;
      this.field_289 = false;
      this.field_290 = false;
      this.field_291 = -1;
      this.field_294 = false;
      this.field_295 = false;
      this.field_296 = false;
      this.field_297 = false;
      this.field_298 = false;
      this.field_303 = 4;
      this.field_304 = 12345678;
      this.field_336 = 12345678;
      this.field_337 = 180;
      this.field_338 = 155;
      this.field_339 = 95;
      this.field_340 = 256;
      this.field_341 = 512;
      this.field_342 = 32;
      this.field_294 = var3;
      this.field_295 = var4;
      this.field_296 = var5;
      this.field_297 = var6;
      this.field_298 = var7;
      this.method_242(var1, var2);
   }

   private class_8(int var1, int var2, boolean var3) {
      super();
      this.field_280 = 1;
      this.field_281 = true;
      this.field_288 = true;
      this.field_289 = false;
      this.field_290 = false;
      this.field_291 = -1;
      this.field_294 = false;
      this.field_295 = false;
      this.field_296 = false;
      this.field_297 = false;
      this.field_298 = false;
      this.field_303 = 4;
      this.field_304 = 12345678;
      this.field_336 = 12345678;
      this.field_337 = 180;
      this.field_338 = 155;
      this.field_339 = 95;
      this.field_340 = 256;
      this.field_341 = 512;
      this.field_342 = 32;
      this.method_242(var1, var2);
      this.field_313 = new int[var2][];
   }

   // $FF: renamed from: ol (int, int) void
   private void method_242(int var1, int var2) {
      this.field_306 = new int[var1];
      this.field_307 = new int[var1];
      this.field_308 = new int[var1];
      this.field_265 = new int[var1];
      this.field_266 = new byte[var1];
      this.field_268 = new int[var2];
      this.field_269 = new int[var2][];
      this.field_270 = new int[var2];
      this.field_271 = new int[var2];
      this.field_274 = new int[var2];
      this.field_273 = new int[var2];
      this.field_272 = new int[var2];
      if (!this.field_298) {
         this.field_260 = new int[var1];
         this.field_261 = new int[var1];
         this.field_262 = new int[var1];
         this.field_263 = new int[var1];
         this.field_264 = new int[var1];
      }

      if (!this.field_297) {
         this.field_293 = new byte[var2];
         this.field_292 = new int[var2];
      }

      if (this.field_294) {
         this.field_309 = this.field_306;
         this.field_310 = this.field_307;
         this.field_311 = this.field_308;
      } else {
         this.field_309 = new int[var1];
         this.field_310 = new int[var1];
         this.field_311 = new int[var1];
      }

      if (!this.field_296 || !this.field_295) {
         this.field_275 = new int[var2];
         this.field_276 = new int[var2];
         this.field_277 = new int[var2];
      }

      if (!this.field_295) {
         this.field_314 = new int[var2];
         this.field_315 = new int[var2];
         this.field_316 = new int[var2];
         this.field_317 = new int[var2];
         this.field_318 = new int[var2];
         this.field_319 = new int[var2];
      }

      this.field_267 = 0;
      this.field_259 = 0;
      this.field_305 = var1;
      this.field_312 = var2;
      this.field_320 = this.field_321 = this.field_322 = 0;
      this.field_323 = this.field_324 = this.field_325 = 0;
      this.field_326 = this.field_327 = this.field_328 = 256;
      this.field_329 = this.field_330 = this.field_331 = this.field_332 = this.field_333 = this.field_334 = 256;
      this.field_335 = 0;
   }

   // $FF: renamed from: ql () void
   public void method_243() {
      this.field_260 = new int[this.field_259];
      this.field_261 = new int[this.field_259];
      this.field_262 = new int[this.field_259];
      this.field_263 = new int[this.field_259];
      this.field_264 = new int[this.field_259];
   }

   // $FF: renamed from: yl () void
   public void method_244() {
      this.field_267 = 0;
      this.field_259 = 0;
   }

   // $FF: renamed from: jl (int, int) void
   public void method_245(int var1, int var2) {
      this.field_267 -= var1;
      if (this.field_267 < 0) {
         this.field_267 = 0;
      }

      this.field_259 -= var2;
      if (this.field_259 < 0) {
         this.field_259 = 0;
      }

   }

   public class_8(byte[] var1, int var2, boolean var3) {
      super();
      this.field_280 = 1;
      this.field_281 = true;
      this.field_288 = true;
      this.field_289 = false;
      this.field_290 = false;
      this.field_291 = -1;
      this.field_294 = false;
      this.field_295 = false;
      this.field_296 = false;
      this.field_297 = false;
      this.field_298 = false;
      this.field_303 = 4;
      this.field_304 = 12345678;
      this.field_336 = 12345678;
      this.field_337 = 180;
      this.field_338 = 155;
      this.field_339 = 95;
      this.field_340 = 256;
      this.field_341 = 512;
      this.field_342 = 32;
      int var4 = class_0.method_5(var1, var2);
      var2 += 2;
      int var5 = class_0.method_5(var1, var2);
      var2 += 2;
      this.method_242(var4, var5);
      this.field_313 = new int[var5][1];

      for(int var6 = 0; var6 < var4; ++var6) {
         this.field_306[var6] = class_0.method_8(var1, var2);
         var2 += 2;
      }

      for(int var7 = 0; var7 < var4; ++var7) {
         this.field_307[var7] = class_0.method_8(var1, var2);
         var2 += 2;
      }

      for(int var8 = 0; var8 < var4; ++var8) {
         this.field_308[var8] = class_0.method_8(var1, var2);
         var2 += 2;
      }

      this.field_259 = var4;

      for(int var9 = 0; var9 < var5; ++var9) {
         this.field_268[var9] = var1[var2++] & 255;
      }

      for(int var10 = 0; var10 < var5; ++var10) {
         this.field_270[var10] = class_0.method_8(var1, var2);
         var2 += 2;
         if (this.field_270[var10] == 32767) {
            this.field_270[var10] = this.field_304;
         }
      }

      for(int var11 = 0; var11 < var5; ++var11) {
         this.field_271[var11] = class_0.method_8(var1, var2);
         var2 += 2;
         if (this.field_271[var11] == 32767) {
            this.field_271[var11] = this.field_304;
         }
      }

      int var13;
      for(int var12 = 0; var12 < var5; ++var12) {
         var13 = var1[var2++] & 255;
         if (var13 == 0) {
            this.field_274[var12] = 0;
         } else {
            this.field_274[var12] = this.field_304;
         }
      }

      for(var13 = 0; var13 < var5; ++var13) {
         this.field_269[var13] = new int[this.field_268[var13]];

         for(int var14 = 0; var14 < this.field_268[var13]; ++var14) {
            if (var4 < 256) {
               this.field_269[var13][var14] = var1[var2++] & 255;
            } else {
               this.field_269[var13][var14] = class_0.method_5(var1, var2);
               var2 += 2;
            }
         }
      }

      this.field_267 = var5;
      this.field_280 = 1;
   }

   public class_8(byte[] var1, int var2) {
      super();
      this.field_280 = 1;
      this.field_281 = true;
      this.field_288 = true;
      this.field_289 = false;
      this.field_290 = false;
      this.field_291 = -1;
      this.field_294 = false;
      this.field_295 = false;
      this.field_296 = false;
      this.field_297 = false;
      this.field_298 = false;
      this.field_303 = 4;
      this.field_304 = 12345678;
      this.field_336 = 12345678;
      this.field_337 = 180;
      this.field_338 = 155;
      this.field_339 = 95;
      this.field_340 = 256;
      this.field_341 = 512;
      this.field_342 = 32;
      this.field_343 = var1;
      this.field_344 = var2;
      this.field_345 = 0;
      this.method_277(this.field_343);
      int var3 = this.method_277(this.field_343);
      int var4 = this.method_277(this.field_343);
      boolean var12 = false;
      this.method_242(var3, var4);
      this.field_313 = new int[var4][];

      for(int var13 = 0; var13 < var3; ++var13) {
         int var5 = this.method_277(this.field_343);
         int var6 = this.method_277(this.field_343);
         int var7 = this.method_277(this.field_343);
         this.method_247(var5, var6, var7);
      }

      for(int var14 = 0; var14 < var4; ++var14) {
         int var8 = this.method_277(this.field_343);
         int var9 = this.method_277(this.field_343);
         int var10 = this.method_277(this.field_343);
         int var11 = this.method_277(this.field_343);
         this.field_341 = this.method_277(this.field_343);
         this.field_342 = this.method_277(this.field_343);
         int var20 = this.method_277(this.field_343);
         int[] var15 = new int[var8];

         for(int var16 = 0; var16 < var8; ++var16) {
            var15[var16] = this.method_277(this.field_343);
         }

         int[] var17 = new int[var11];

         for(int var18 = 0; var18 < var11; ++var18) {
            var17[var18] = this.method_277(this.field_343);
         }

         int var19 = this.method_249(var8, var15, var9, var10);
         this.field_313[var14] = var17;
         if (var20 == 0) {
            this.field_274[var19] = 0;
         } else {
            this.field_274[var19] = this.field_304;
         }
      }

      this.field_280 = 1;
   }

   public class_8(String var1) {
      super();
      this.field_280 = 1;
      this.field_281 = true;
      this.field_288 = true;
      this.field_289 = false;
      this.field_290 = false;
      this.field_291 = -1;
      this.field_294 = false;
      this.field_295 = false;
      this.field_296 = false;
      this.field_297 = false;
      this.field_298 = false;
      this.field_303 = 4;
      this.field_304 = 12345678;
      this.field_336 = 12345678;
      this.field_337 = 180;
      this.field_338 = 155;
      this.field_339 = 95;
      this.field_340 = 256;
      this.field_341 = 512;
      this.field_342 = 32;
      boolean var2 = false;
      boolean var3 = false;
      Object var4 = null;

      byte[] var25;
      try {
         InputStream var5 = class_0.method_0(var1);
         DataInputStream var6 = new DataInputStream(var5);
         var25 = new byte[3];
         this.field_344 = 0;
         this.field_345 = 0;
         int var23 = 0;

         while(true) {
            if (var23 >= 3) {
               int var24 = this.method_277(var25);
               var25 = new byte[var24];
               this.field_344 = 0;
               this.field_345 = 0;

               for(var23 = 0; var23 < var24; var23 += var6.read(var25, var23, var24 - var23)) {
                  ;
               }

               var6.close();
               break;
            }

            var23 += var6.read(var25, var23, 3 - var23);
         }
      } catch (IOException var22) {
         this.field_259 = 0;
         this.field_267 = 0;
         return;
      }

      int var26 = this.method_277(var25);
      int var27 = this.method_277(var25);
      boolean var14 = false;
      this.method_242(var26, var27);
      this.field_313 = new int[var27][];

      for(int var15 = 0; var15 < var26; ++var15) {
         int var7 = this.method_277(var25);
         int var8 = this.method_277(var25);
         int var9 = this.method_277(var25);
         this.method_247(var7, var8, var9);
      }

      for(int var16 = 0; var16 < var27; ++var16) {
         int var10 = this.method_277(var25);
         int var11 = this.method_277(var25);
         int var12 = this.method_277(var25);
         int var13 = this.method_277(var25);
         this.field_341 = this.method_277(var25);
         this.field_342 = this.method_277(var25);
         int var28 = this.method_277(var25);
         int[] var17 = new int[var10];

         for(int var18 = 0; var18 < var10; ++var18) {
            var17[var18] = this.method_277(var25);
         }

         int[] var19 = new int[var13];

         for(int var20 = 0; var20 < var13; ++var20) {
            var19[var20] = this.method_277(var25);
         }

         int var21 = this.method_249(var10, var17, var11, var12);
         this.field_313[var16] = var19;
         if (var28 == 0) {
            this.field_274[var21] = 0;
         } else {
            this.field_274[var21] = this.field_304;
         }
      }

      this.field_280 = 1;
   }

   public class_8(class_8[] var1, int var2, boolean var3, boolean var4, boolean var5, boolean var6) {
      super();
      this.field_280 = 1;
      this.field_281 = true;
      this.field_288 = true;
      this.field_289 = false;
      this.field_290 = false;
      this.field_291 = -1;
      this.field_294 = false;
      this.field_295 = false;
      this.field_296 = false;
      this.field_297 = false;
      this.field_298 = false;
      this.field_303 = 4;
      this.field_304 = 12345678;
      this.field_336 = 12345678;
      this.field_337 = 180;
      this.field_338 = 155;
      this.field_339 = 95;
      this.field_340 = 256;
      this.field_341 = 512;
      this.field_342 = 32;
      this.field_294 = var3;
      this.field_295 = var4;
      this.field_296 = var5;
      this.field_297 = var6;
      this.method_246(var1, var2, false);
   }

   public class_8(class_8[] var1, int var2) {
      super();
      this.field_280 = 1;
      this.field_281 = true;
      this.field_288 = true;
      this.field_289 = false;
      this.field_290 = false;
      this.field_291 = -1;
      this.field_294 = false;
      this.field_295 = false;
      this.field_296 = false;
      this.field_297 = false;
      this.field_298 = false;
      this.field_303 = 4;
      this.field_304 = 12345678;
      this.field_336 = 12345678;
      this.field_337 = 180;
      this.field_338 = 155;
      this.field_339 = 95;
      this.field_340 = 256;
      this.field_341 = 512;
      this.field_342 = 32;
      this.method_246(var1, var2, true);
   }

   // $FF: renamed from: ul (jagex.client.q[], int, boolean) void
   public void method_246(class_8[] var1, int var2, boolean var3) {
      int var4 = 0;
      int var5 = 0;

      for(int var6 = 0; var6 < var2; ++var6) {
         var4 += var1[var6].field_267;
         var5 += var1[var6].field_259;
      }

      this.method_242(var5, var4);
      if (var3) {
         this.field_313 = new int[var4][];
      }

      for(int var7 = 0; var7 < var2; ++var7) {
         class_8 var8 = var1[var7];
         var8.method_273();
         this.field_342 = var8.field_342;
         this.field_341 = var8.field_341;
         this.field_337 = var8.field_337;
         this.field_338 = var8.field_338;
         this.field_339 = var8.field_339;
         this.field_340 = var8.field_340;

         for(int var9 = 0; var9 < var8.field_267; ++var9) {
            int[] var10 = new int[var8.field_268[var9]];
            int[] var11 = var8.field_269[var9];

            for(int var12 = 0; var12 < var8.field_268[var9]; ++var12) {
               var10[var12] = this.method_247(var8.field_306[var11[var12]], var8.field_307[var11[var12]], var8.field_308[var11[var12]]);
            }

            int var13 = this.method_249(var8.field_268[var9], var10, var8.field_270[var9], var8.field_271[var9]);
            this.field_274[var13] = var8.field_274[var9];
            this.field_273[var13] = var8.field_273[var9];
            this.field_272[var13] = var8.field_272[var9];
            if (var3) {
               int var14;
               if (var2 > 1) {
                  this.field_313[var13] = new int[var8.field_313[var9].length + 1];
                  this.field_313[var13][0] = var7;

                  for(var14 = 0; var14 < var8.field_313[var9].length; ++var14) {
                     this.field_313[var13][var14 + 1] = var8.field_313[var9][var14];
                  }
               } else {
                  this.field_313[var13] = new int[var8.field_313[var9].length];

                  for(var14 = 0; var14 < var8.field_313[var9].length; ++var14) {
                     this.field_313[var13][var14] = var8.field_313[var9][var14];
                  }
               }
            }
         }
      }

      this.field_280 = 1;
   }

   public class_8(int var1, int[] var2, int[] var3, int[] var4, int var5, int var6) {
      this(var1, 1);
      this.field_259 = var1;

      for(int var7 = 0; var7 < var1; ++var7) {
         this.field_306[var7] = var2[var7];
         this.field_307[var7] = var3[var7];
         this.field_308[var7] = var4[var7];
      }

      this.field_267 = 1;
      this.field_268[0] = var1;
      int[] var8 = new int[var1];

      for(int var9 = 0; var9 < var1; var8[var9] = var9++) {
         ;
      }

      this.field_269[0] = var8;
      this.field_270[0] = var5;
      this.field_271[0] = var6;
      this.field_280 = 1;
   }

   // $FF: renamed from: xl (int, int, int) int
   public int method_247(int var1, int var2, int var3) {
      for(int var4 = 0; var4 < this.field_259; ++var4) {
         if (this.field_306[var4] == var1 && this.field_307[var4] == var2 && this.field_308[var4] == var3) {
            return var4;
         }
      }

      if (this.field_259 >= this.field_305) {
         return -1;
      } else {
         this.field_306[this.field_259] = var1;
         this.field_307[this.field_259] = var2;
         this.field_308[this.field_259] = var3;
         return this.field_259++;
      }
   }

   // $FF: renamed from: tl (int, int, int) int
   public int method_248(int var1, int var2, int var3) {
      if (this.field_259 >= this.field_305) {
         return -1;
      } else {
         this.field_306[this.field_259] = var1;
         this.field_307[this.field_259] = var2;
         this.field_308[this.field_259] = var3;
         return this.field_259++;
      }
   }

   // $FF: renamed from: zl (int, int[], int, int) int
   public int method_249(int var1, int[] var2, int var3, int var4) {
      if (this.field_267 >= this.field_312) {
         return -1;
      } else {
         this.field_268[this.field_267] = var1;
         this.field_269[this.field_267] = var2;
         this.field_270[this.field_267] = var3;
         this.field_271[this.field_267] = var4;
         this.field_280 = 1;
         return this.field_267++;
      }
   }

   // $FF: renamed from: fm (int, int, int, int, int, int, int, boolean) jagex.client.q[]
   public class_8[] method_250(int var1, int var2, int var3, int var4, int var5, int var6, int var7, boolean var8) {
      this.method_273();
      int[] var9 = new int[var6];
      int[] var10 = new int[var6];

      for(int var11 = 0; var11 < var6; ++var11) {
         var9[var11] = 0;
         var10[var11] = 0;
      }

      int var14;
      int var15;
      int var17;
      int var18;
      for(int var12 = 0; var12 < this.field_267; ++var12) {
         int var13 = 0;
         var14 = 0;
         var15 = this.field_268[var12];
         int[] var16 = this.field_269[var12];

         for(var17 = 0; var17 < var15; ++var17) {
            var13 += this.field_306[var16[var17]];
            var14 += this.field_308[var16[var17]];
         }

         var18 = var13 / (var15 * var3) + var14 / (var15 * var4) * var5;
         var9[var18] += var15;
         ++var10[var18];
      }

      class_8[] var22 = new class_8[var6];

      for(var14 = 0; var14 < var6; ++var14) {
         if (var9[var14] > var7) {
            var9[var14] = var7;
         }

         var22[var14] = new class_8(var9[var14], var10[var14], true, true, true, var8, true);
         var22[var14].field_341 = this.field_341;
         var22[var14].field_342 = this.field_342;
      }

      int var23;
      for(var15 = 0; var15 < this.field_267; ++var15) {
         var23 = 0;
         var17 = 0;
         var18 = this.field_268[var15];
         int[] var19 = this.field_269[var15];

         for(int var20 = 0; var20 < var18; ++var20) {
            var23 += this.field_306[var19[var20]];
            var17 += this.field_308[var19[var20]];
         }

         int var21 = var23 / (var18 * var3) + var17 / (var18 * var4) * var5;
         this.method_251(var22[var21], var19, var18, var15);
      }

      for(var23 = 0; var23 < var6; ++var23) {
         var22[var23].method_243();
      }

      return var22;
   }

   // $FF: renamed from: kl (jagex.client.q, int[], int, int) void
   public void method_251(class_8 var1, int[] var2, int var3, int var4) {
      int[] var5 = new int[var3];

      int var7;
      for(int var6 = 0; var6 < var3; ++var6) {
         var7 = var5[var6] = var1.method_247(this.field_306[var2[var6]], this.field_307[var2[var6]], this.field_308[var2[var6]]);
         var1.field_265[var7] = this.field_265[var2[var6]];
         var1.field_266[var7] = this.field_266[var2[var6]];
      }

      var7 = var1.method_249(var3, var5, this.field_270[var4], this.field_271[var4]);
      if (!var1.field_297 && !this.field_297) {
         var1.field_292[var7] = this.field_292[var4];
      }

      var1.field_274[var7] = this.field_274[var4];
      var1.field_273[var7] = this.field_273[var4];
      var1.field_272[var7] = this.field_272[var4];
   }

   // $FF: renamed from: gm (boolean, int, int, int, int, int) void
   public void method_252(boolean var1, int var2, int var3, int var4, int var5, int var6) {
      this.field_342 = 256 - var2 * 4;
      this.field_341 = (64 - var3) * 16 + 128;
      if (!this.field_296) {
         for(int var7 = 0; var7 < this.field_267; ++var7) {
            if (var1) {
               this.field_274[var7] = this.field_304;
            } else {
               this.field_274[var7] = 0;
            }
         }

         this.field_337 = var4;
         this.field_338 = var5;
         this.field_339 = var6;
         this.field_340 = (int)Math.sqrt((double)(var4 * var4 + var5 * var5 + var6 * var6));
         this.method_269();
      }
   }

   // $FF: renamed from: pl (int, int, int, int, int) void
   public void method_253(int var1, int var2, int var3, int var4, int var5) {
      this.field_342 = 256 - var1 * 4;
      this.field_341 = (64 - var2) * 16 + 128;
      if (!this.field_296) {
         this.field_337 = var3;
         this.field_338 = var4;
         this.field_339 = var5;
         this.field_340 = (int)Math.sqrt((double)(var3 * var3 + var4 * var4 + var5 * var5));
         this.method_269();
      }
   }

   // $FF: renamed from: nm (int, int, int) void
   public void method_254(int var1, int var2, int var3) {
      if (!this.field_296) {
         this.field_337 = var1;
         this.field_338 = var2;
         this.field_339 = var3;
         this.field_340 = (int)Math.sqrt((double)(var1 * var1 + var2 * var2 + var3 * var3));
         this.method_269();
      }
   }

   // $FF: renamed from: om (int, int) void
   public void method_255(int var1, int var2) {
      this.field_266[var1] = (byte)var2;
   }

   // $FF: renamed from: jm (int, int, int) void
   public void method_256(int var1, int var2, int var3) {
      this.field_323 = this.field_323 + var1 & 255;
      this.field_324 = this.field_324 + var2 & 255;
      this.field_325 = this.field_325 + var3 & 255;
      this.method_263();
      this.field_280 = 1;
   }

   // $FF: renamed from: ml (int, int, int) void
   public void method_257(int var1, int var2, int var3) {
      this.field_323 = var1 & 255;
      this.field_324 = var2 & 255;
      this.field_325 = var3 & 255;
      this.method_263();
      this.field_280 = 1;
   }

   // $FF: renamed from: wl (int, int, int) void
   public void method_258(int var1, int var2, int var3) {
      this.field_320 += var1;
      this.field_321 += var2;
      this.field_322 += var3;
      this.method_263();
      this.field_280 = 1;
   }

   // $FF: renamed from: hl (int, int, int) void
   public void method_259(int var1, int var2, int var3) {
      this.field_320 = var1;
      this.field_321 = var2;
      this.field_322 = var3;
      this.method_263();
      this.field_280 = 1;
   }

   // $FF: renamed from: hm () int
   public int method_260() {
      return this.field_320;
   }

   // $FF: renamed from: mm (int, int, int) void
   public void method_261(int var1, int var2, int var3) {
      this.field_326 = var1;
      this.field_327 = var2;
      this.field_328 = var3;
      this.method_263();
      this.field_280 = 1;
   }

   // $FF: renamed from: nl (int, int, int, int, int, int) void
   public void method_262(int var1, int var2, int var3, int var4, int var5, int var6) {
      this.field_329 = var1;
      this.field_330 = var2;
      this.field_331 = var3;
      this.field_332 = var4;
      this.field_333 = var5;
      this.field_334 = var6;
      this.method_263();
      this.field_280 = 1;
   }

   // $FF: renamed from: lm () void
   private void method_263() {
      if (this.field_329 == 256 && this.field_330 == 256 && this.field_331 == 256 && this.field_332 == 256 && this.field_333 == 256 && this.field_334 == 256) {
         if (this.field_326 == 256 && this.field_327 == 256 && this.field_328 == 256) {
            if (this.field_323 == 0 && this.field_324 == 0 && this.field_325 == 0) {
               if (this.field_320 == 0 && this.field_321 == 0 && this.field_322 == 0) {
                  this.field_335 = 0;
               } else {
                  this.field_335 = 1;
               }
            } else {
               this.field_335 = 2;
            }
         } else {
            this.field_335 = 3;
         }
      } else {
         this.field_335 = 4;
      }
   }

   // $FF: renamed from: im (int, int, int) void
   private void method_264(int var1, int var2, int var3) {
      for(int var4 = 0; var4 < this.field_259; ++var4) {
         this.field_309[var4] += var1;
         this.field_310[var4] += var2;
         this.field_311[var4] += var3;
      }

   }

   // $FF: renamed from: gl (int, int, int) void
   private void method_265(int var1, int var2, int var3) {
      for(int var7 = 0; var7 < this.field_259; ++var7) {
         int var4;
         int var5;
         int var6;
         if (var3 != 0) {
            var4 = field_299[var3];
            var5 = field_299[var3 + 256];
            var6 = this.field_310[var7] * var4 + this.field_309[var7] * var5 >> 15;
            this.field_310[var7] = this.field_310[var7] * var5 - this.field_309[var7] * var4 >> 15;
            this.field_309[var7] = var6;
         }

         if (var1 != 0) {
            var4 = field_299[var1];
            var5 = field_299[var1 + 256];
            var6 = this.field_310[var7] * var5 - this.field_311[var7] * var4 >> 15;
            this.field_311[var7] = this.field_310[var7] * var4 + this.field_311[var7] * var5 >> 15;
            this.field_310[var7] = var6;
         }

         if (var2 != 0) {
            var4 = field_299[var2];
            var5 = field_299[var2 + 256];
            var6 = this.field_311[var7] * var4 + this.field_309[var7] * var5 >> 15;
            this.field_311[var7] = this.field_311[var7] * var5 - this.field_309[var7] * var4 >> 15;
            this.field_309[var7] = var6;
         }
      }

   }

   // $FF: renamed from: bm (int, int, int, int, int, int) void
   private void method_266(int var1, int var2, int var3, int var4, int var5, int var6) {
      for(int var7 = 0; var7 < this.field_259; ++var7) {
         if (var1 != 0) {
            this.field_309[var7] += this.field_310[var7] * var1 >> 8;
         }

         if (var2 != 0) {
            this.field_311[var7] += this.field_310[var7] * var2 >> 8;
         }

         if (var3 != 0) {
            this.field_309[var7] += this.field_311[var7] * var3 >> 8;
         }

         if (var4 != 0) {
            this.field_310[var7] += this.field_311[var7] * var4 >> 8;
         }

         if (var5 != 0) {
            this.field_311[var7] += this.field_309[var7] * var5 >> 8;
         }

         if (var6 != 0) {
            this.field_310[var7] += this.field_309[var7] * var6 >> 8;
         }
      }

   }

   // $FF: renamed from: ll (int, int, int) void
   private void method_267(int var1, int var2, int var3) {
      for(int var4 = 0; var4 < this.field_259; ++var4) {
         this.field_309[var4] = this.field_309[var4] * var1 >> 8;
         this.field_310[var4] = this.field_310[var4] * var2 >> 8;
         this.field_311[var4] = this.field_311[var4] * var3 >> 8;
      }

   }

   // $FF: renamed from: il () void
   private void method_268() {
      this.field_282 = this.field_284 = this.field_286 = 999999;
      this.field_336 = this.field_283 = this.field_285 = this.field_287 = -999999;

      for(int var2 = 0; var2 < this.field_267; ++var2) {
         int[] var1 = this.field_269[var2];
         int var4 = var1[0];
         int var5 = this.field_268[var2];
         int var6;
         int var7 = var6 = this.field_309[var4];
         int var8;
         int var9 = var8 = this.field_310[var4];
         int var10;
         int var11 = var10 = this.field_311[var4];

         for(int var3 = 0; var3 < var5; ++var3) {
            var4 = var1[var3];
            if (this.field_309[var4] < var6) {
               var6 = this.field_309[var4];
            } else if (this.field_309[var4] > var7) {
               var7 = this.field_309[var4];
            }

            if (this.field_310[var4] < var8) {
               var8 = this.field_310[var4];
            } else if (this.field_310[var4] > var9) {
               var9 = this.field_310[var4];
            }

            if (this.field_311[var4] < var10) {
               var10 = this.field_311[var4];
            } else if (this.field_311[var4] > var11) {
               var11 = this.field_311[var4];
            }
         }

         if (!this.field_295) {
            this.field_314[var2] = var6;
            this.field_315[var2] = var7;
            this.field_316[var2] = var8;
            this.field_317[var2] = var9;
            this.field_318[var2] = var10;
            this.field_319[var2] = var11;
         }

         if (var7 - var6 > this.field_336) {
            this.field_336 = var7 - var6;
         }

         if (var9 - var8 > this.field_336) {
            this.field_336 = var9 - var8;
         }

         if (var11 - var10 > this.field_336) {
            this.field_336 = var11 - var10;
         }

         if (var6 < this.field_282) {
            this.field_282 = var6;
         }

         if (var7 > this.field_283) {
            this.field_283 = var7;
         }

         if (var8 < this.field_284) {
            this.field_284 = var8;
         }

         if (var9 > this.field_285) {
            this.field_285 = var9;
         }

         if (var10 < this.field_286) {
            this.field_286 = var10;
         }

         if (var11 > this.field_287) {
            this.field_287 = var11;
         }
      }

   }

   // $FF: renamed from: km () void
   public void method_269() {
      if (!this.field_296) {
         int var1 = this.field_341 * this.field_340 >> 8;

         for(int var2 = 0; var2 < this.field_267; ++var2) {
            if (this.field_274[var2] != this.field_304) {
               this.field_274[var2] = (this.field_275[var2] * this.field_337 + this.field_276[var2] * this.field_338 + this.field_277[var2] * this.field_339) / var1;
            }
         }

         int[] var3 = new int[this.field_259];
         int[] var4 = new int[this.field_259];
         int[] var5 = new int[this.field_259];
         int[] var6 = new int[this.field_259];

         for(int var7 = 0; var7 < this.field_259; ++var7) {
            var3[var7] = 0;
            var4[var7] = 0;
            var5[var7] = 0;
            var6[var7] = 0;
         }

         int var9;
         for(int var8 = 0; var8 < this.field_267; ++var8) {
            if (this.field_274[var8] == this.field_304) {
               for(var9 = 0; var9 < this.field_268[var8]; ++var9) {
                  int var10 = this.field_269[var8][var9];
                  var3[var10] += this.field_275[var8];
                  var4[var10] += this.field_276[var8];
                  var5[var10] += this.field_277[var8];
                  ++var6[var10];
               }
            }
         }

         for(var9 = 0; var9 < this.field_259; ++var9) {
            if (var6[var9] > 0) {
               this.field_265[var9] = (var3[var9] * this.field_337 + var4[var9] * this.field_338 + var5[var9] * this.field_339) / (var1 * var6[var9]);
            }
         }

      }
   }

   // $FF: renamed from: am () void
   public void method_270() {
      if (!this.field_296 || !this.field_295) {
         for(int var1 = 0; var1 < this.field_267; ++var1) {
            int[] var2 = this.field_269[var1];
            int var3 = this.field_309[var2[0]];
            int var4 = this.field_310[var2[0]];
            int var5 = this.field_311[var2[0]];
            int var6 = this.field_309[var2[1]] - var3;
            int var7 = this.field_310[var2[1]] - var4;
            int var8 = this.field_311[var2[1]] - var5;
            int var9 = this.field_309[var2[2]] - var3;
            int var10 = this.field_310[var2[2]] - var4;
            int var11 = this.field_311[var2[2]] - var5;
            int var12 = var7 * var11 - var10 * var8;
            int var13 = var8 * var9 - var11 * var6;

            int var14;
            for(var14 = var6 * var10 - var9 * var7; var12 > 8192 || var13 > 8192 || var14 > 8192 || var12 < -8192 || var13 < -8192 || var14 < -8192; var14 >>= 1) {
               var12 >>= 1;
               var13 >>= 1;
            }

            int var15 = (int)(256.0D * Math.sqrt((double)(var12 * var12 + var13 * var13 + var14 * var14)));
            if (var15 <= 0) {
               var15 = 1;
            }

            this.field_275[var1] = var12 * 65536 / var15;
            this.field_276[var1] = var13 * 65536 / var15;
            this.field_277[var1] = var14 * '\uffff' / var15;
            this.field_273[var1] = -1;
         }

         this.method_269();
      }
   }

   // $FF: renamed from: em () void
   public void method_271() {
      int var1;
      if (this.field_280 == 2) {
         this.field_280 = 0;

         for(var1 = 0; var1 < this.field_259; ++var1) {
            this.field_309[var1] = this.field_306[var1];
            this.field_310[var1] = this.field_307[var1];
            this.field_311[var1] = this.field_308[var1];
         }

         this.field_282 = this.field_284 = this.field_286 = -9999999;
         this.field_336 = this.field_283 = this.field_285 = this.field_287 = 9999999;
      } else {
         if (this.field_280 == 1) {
            this.field_280 = 0;

            for(var1 = 0; var1 < this.field_259; ++var1) {
               this.field_309[var1] = this.field_306[var1];
               this.field_310[var1] = this.field_307[var1];
               this.field_311[var1] = this.field_308[var1];
            }

            if (this.field_335 >= 2) {
               this.method_265(this.field_323, this.field_324, this.field_325);
            }

            if (this.field_335 >= 3) {
               this.method_267(this.field_326, this.field_327, this.field_328);
            }

            if (this.field_335 >= 4) {
               this.method_266(this.field_329, this.field_330, this.field_331, this.field_332, this.field_333, this.field_334);
            }

            if (this.field_335 >= 1) {
               this.method_264(this.field_320, this.field_321, this.field_322);
            }

            this.method_268();
            this.method_270();
         }

      }
   }

   // $FF: renamed from: dm (int, int, int, int, int, int, int, int) void
   public void method_272(int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8) {
      this.method_271();
      if (this.field_286 <= class_17.field_666 && this.field_287 >= class_17.field_665 && this.field_282 <= class_17.field_662 && this.field_283 >= class_17.field_661 && this.field_284 <= class_17.field_664 && this.field_285 >= class_17.field_663) {
         this.field_281 = true;
         int var10 = 0;
         int var11 = 0;
         int var12 = 0;
         int var13 = 0;
         int var14 = 0;
         int var15 = 0;
         if (var6 != 0) {
            var10 = field_300[var6];
            var11 = field_300[var6 + 1024];
         }

         if (var5 != 0) {
            var14 = field_300[var5];
            var15 = field_300[var5 + 1024];
         }

         if (var4 != 0) {
            var12 = field_300[var4];
            var13 = field_300[var4 + 1024];
         }

         for(int var16 = 0; var16 < this.field_259; ++var16) {
            int var17 = this.field_309[var16] - var1;
            int var18 = this.field_310[var16] - var2;
            int var19 = this.field_311[var16] - var3;
            int var9;
            if (var6 != 0) {
               var9 = var18 * var10 + var17 * var11 >> 15;
               var18 = var18 * var11 - var17 * var10 >> 15;
               var17 = var9;
            }

            if (var5 != 0) {
               var9 = var19 * var14 + var17 * var15 >> 15;
               var19 = var19 * var15 - var17 * var14 >> 15;
               var17 = var9;
            }

            if (var4 != 0) {
               var9 = var18 * var13 - var19 * var12 >> 15;
               var19 = var18 * var12 + var19 * var13 >> 15;
               var18 = var9;
            }

            if (var19 >= var8) {
               this.field_263[var16] = (var17 << var7) / var19;
            } else {
               this.field_263[var16] = var17 << var7;
            }

            if (var19 >= var8) {
               this.field_264[var16] = (var18 << var7) / var19;
            } else {
               this.field_264[var16] = var18 << var7;
            }

            this.field_260[var16] = var17;
            this.field_261[var16] = var18;
            this.field_262[var16] = var19;
         }

      } else {
         this.field_281 = false;
      }
   }

   // $FF: renamed from: fl () void
   public void method_273() {
      this.method_271();

      for(int var1 = 0; var1 < this.field_259; ++var1) {
         this.field_306[var1] = this.field_309[var1];
         this.field_307[var1] = this.field_310[var1];
         this.field_308[var1] = this.field_311[var1];
      }

      this.field_320 = this.field_321 = this.field_322 = 0;
      this.field_323 = this.field_324 = this.field_325 = 0;
      this.field_326 = this.field_327 = this.field_328 = 256;
      this.field_329 = this.field_330 = this.field_331 = this.field_332 = this.field_333 = this.field_334 = 256;
      this.field_335 = 0;
   }

   // $FF: renamed from: sl () jagex.client.q
   public class_8 method_274() {
      class_8[] var1 = new class_8[]{this};
      class_8 var2 = new class_8(var1, 1);
      var2.field_279 = this.field_279;
      var2.field_290 = this.field_290;
      return var2;
   }

   // $FF: renamed from: rl (boolean, boolean, boolean, boolean) jagex.client.q
   public class_8 method_275(boolean var1, boolean var2, boolean var3, boolean var4) {
      class_8[] var5 = new class_8[]{this};
      class_8 var6 = new class_8(var5, 1, var1, var2, var3, var4);
      var6.field_279 = this.field_279;
      return var6;
   }

   // $FF: renamed from: cm (jagex.client.q) void
   public void method_276(class_8 var1) {
      this.field_323 = var1.field_323;
      this.field_324 = var1.field_324;
      this.field_325 = var1.field_325;
      this.field_320 = var1.field_320;
      this.field_321 = var1.field_321;
      this.field_322 = var1.field_322;
      this.method_263();
      this.field_280 = 1;
   }

   // $FF: renamed from: vl (byte[]) int
   public int method_277(byte[] var1) {
      while(var1[this.field_344] == 10 || var1[this.field_344] == 13) {
         ++this.field_344;
      }

      int var2 = field_302[var1[this.field_344++] & 255];
      int var3 = field_302[var1[this.field_344++] & 255];
      int var4 = field_302[var1[this.field_344++] & 255];
      int var5 = var2 * 4096 + var3 * 64 + var4 - 131072;
      if (var5 == 123456) {
         var5 = this.field_304;
      }

      return var5;
   }

   static {
      for(int var0 = 0; var0 < 256; ++var0) {
         field_299[var0] = (int)(Math.sin((double)var0 * 0.02454369D) * 32768.0D);
         field_299[var0 + 256] = (int)(Math.cos((double)var0 * 0.02454369D) * 32768.0D);
      }

      for(int var1 = 0; var1 < 1024; ++var1) {
         field_300[var1] = (int)(Math.sin((double)var1 * 0.00613592315D) * 32768.0D);
         field_300[var1 + 1024] = (int)(Math.cos((double)var1 * 0.00613592315D) * 32768.0D);
      }

      for(int var2 = 0; var2 < 10; ++var2) {
         field_301[var2] = (byte)(48 + var2);
      }

      for(int var3 = 0; var3 < 26; ++var3) {
         field_301[var3 + 10] = (byte)(65 + var3);
      }

      for(int var4 = 0; var4 < 26; ++var4) {
         field_301[var4 + 36] = (byte)(97 + var4);
      }

      field_301[62] = -93;
      field_301[63] = 36;

      for(int var5 = 0; var5 < 10; field_302[48 + var5] = var5++) {
         ;
      }

      for(int var6 = 0; var6 < 26; ++var6) {
         field_302[65 + var6] = var6 + 10;
      }

      for(int var7 = 0; var7 < 26; ++var7) {
         field_302[97 + var7] = var7 + 36;
      }

      field_302[163] = 62;
      field_302[36] = 63;
   }
}
