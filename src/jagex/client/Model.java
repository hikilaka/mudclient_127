package jagex.client;

import jagex.DataUtil;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;

// $FF: renamed from: jagex.client.q
public class Model {
   // $FF: renamed from: it int
   public int vert_cnt;
   // $FF: renamed from: jt int[]
   public int[] project_vert_x;
   // $FF: renamed from: kt int[]
   public int[] project_vert_y;
   // $FF: renamed from: lt int[]
   public int[] project_vert_z;
   // $FF: renamed from: mt int[]
   public int[] project_plane_x;
   // $FF: renamed from: nt int[]
   public int[] project_plane_y;
   // $FF: renamed from: ot int[]
   public int[] vert_shade;
   // $FF: renamed from: pt byte[]
   public byte[] vert_ambient;
   // $FF: renamed from: qt int
   public int face_cnt;
   // $FF: renamed from: rt int[]
   public int[] face_vert_cnt;
   // $FF: renamed from: st int[][]
   public int[][] face_verts;
   // $FF: renamed from: tt int[]
   public int[] texture_front;
   // $FF: renamed from: ut int[]
   public int[] texture_back;
   // $FF: renamed from: vt int[]
   public int[] norm_mag;
   // $FF: renamed from: wt int[]
   public int[] norm_scale;
   // $FF: renamed from: xt int[]
   public int[] light_type;
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
   public int trans_state;
   // $FF: renamed from: eu boolean
   public boolean visible;
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
   public boolean trans;
   // $FF: renamed from: ou int
   public int field_291;
   // $FF: renamed from: pu int[]
   public int[] face_pick_tag;
   // $FF: renamed from: qu byte[]
   public byte[] is_local_player;
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
   public int[] vert_x;
   // $FF: renamed from: ev int[]
   public int[] field_307;
   // $FF: renamed from: fv int[]
   public int[] vert_z;
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
   protected int light_ambient;
   // $FF: renamed from: ow byte[]
   private byte[] field_343;
   // $FF: renamed from: pw int
   private int field_344;
   // $FF: renamed from: qw int
   private int field_345;

   public Model(int var1, int var2) {
      super();
      this.trans_state = 1;
      this.visible = true;
      this.field_288 = true;
      this.field_289 = false;
      this.trans = false;
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
      this.light_ambient = 32;
      this.method_242(var1, var2);
      this.field_313 = new int[var2][1];

      for(int var3 = 0; var3 < var2; this.field_313[var3][0] = var3++) {
         ;
      }

   }

   public Model(int var1, int var2, boolean var3, boolean var4, boolean var5, boolean var6, boolean var7) {
      super();
      this.trans_state = 1;
      this.visible = true;
      this.field_288 = true;
      this.field_289 = false;
      this.trans = false;
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
      this.light_ambient = 32;
      this.field_294 = var3;
      this.field_295 = var4;
      this.field_296 = var5;
      this.field_297 = var6;
      this.field_298 = var7;
      this.method_242(var1, var2);
   }

   private Model(int var1, int var2, boolean var3) {
      super();
      this.trans_state = 1;
      this.visible = true;
      this.field_288 = true;
      this.field_289 = false;
      this.trans = false;
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
      this.light_ambient = 32;
      this.method_242(var1, var2);
      this.field_313 = new int[var2][];
   }

   // $FF: renamed from: ol (int, int) void
   private void method_242(int var1, int var2) {
      this.vert_x = new int[var1];
      this.field_307 = new int[var1];
      this.vert_z = new int[var1];
      this.vert_shade = new int[var1];
      this.vert_ambient = new byte[var1];
      this.face_vert_cnt = new int[var2];
      this.face_verts = new int[var2][];
      this.texture_front = new int[var2];
      this.texture_back = new int[var2];
      this.light_type = new int[var2];
      this.norm_scale = new int[var2];
      this.norm_mag = new int[var2];
      if (!this.field_298) {
         this.project_vert_x = new int[var1];
         this.project_vert_y = new int[var1];
         this.project_vert_z = new int[var1];
         this.project_plane_x = new int[var1];
         this.project_plane_y = new int[var1];
      }

      if (!this.field_297) {
         this.is_local_player = new byte[var2];
         this.face_pick_tag = new int[var2];
      }

      if (this.field_294) {
         this.field_309 = this.vert_x;
         this.field_310 = this.field_307;
         this.field_311 = this.vert_z;
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

      this.face_cnt = 0;
      this.vert_cnt = 0;
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
      this.project_vert_x = new int[this.vert_cnt];
      this.project_vert_y = new int[this.vert_cnt];
      this.project_vert_z = new int[this.vert_cnt];
      this.project_plane_x = new int[this.vert_cnt];
      this.project_plane_y = new int[this.vert_cnt];
   }

   // $FF: renamed from: yl () void
   public void clear() {
      this.face_cnt = 0;
      this.vert_cnt = 0;
   }

   // $FF: renamed from: jl (int, int) void
   public void reduce(int var1, int var2) {
      this.face_cnt -= var1;
      if (this.face_cnt < 0) {
         this.face_cnt = 0;
      }

      this.vert_cnt -= var2;
      if (this.vert_cnt < 0) {
         this.vert_cnt = 0;
      }

   }

   public Model(byte[] var1, int var2, boolean var3) {
      super();
      this.trans_state = 1;
      this.visible = true;
      this.field_288 = true;
      this.field_289 = false;
      this.trans = false;
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
      this.light_ambient = 32;
      int var4 = DataUtil.short_get(var1, var2);
      var2 += 2;
      int var5 = DataUtil.short_get(var1, var2);
      var2 += 2;
      this.method_242(var4, var5);
      this.field_313 = new int[var5][1];

      for(int var6 = 0; var6 < var4; ++var6) {
         this.vert_x[var6] = DataUtil.method_8(var1, var2);
         var2 += 2;
      }

      for(int var7 = 0; var7 < var4; ++var7) {
         this.field_307[var7] = DataUtil.method_8(var1, var2);
         var2 += 2;
      }

      for(int var8 = 0; var8 < var4; ++var8) {
         this.vert_z[var8] = DataUtil.method_8(var1, var2);
         var2 += 2;
      }

      this.vert_cnt = var4;

      for(int var9 = 0; var9 < var5; ++var9) {
         this.face_vert_cnt[var9] = var1[var2++] & 255;
      }

      for(int var10 = 0; var10 < var5; ++var10) {
         this.texture_front[var10] = DataUtil.method_8(var1, var2);
         var2 += 2;
         if (this.texture_front[var10] == 32767) {
            this.texture_front[var10] = this.field_304;
         }
      }

      for(int var11 = 0; var11 < var5; ++var11) {
         this.texture_back[var11] = DataUtil.method_8(var1, var2);
         var2 += 2;
         if (this.texture_back[var11] == 32767) {
            this.texture_back[var11] = this.field_304;
         }
      }

      int var13;
      for(int var12 = 0; var12 < var5; ++var12) {
         var13 = var1[var2++] & 255;
         if (var13 == 0) {
            this.light_type[var12] = 0;
         } else {
            this.light_type[var12] = this.field_304;
         }
      }

      for(var13 = 0; var13 < var5; ++var13) {
         this.face_verts[var13] = new int[this.face_vert_cnt[var13]];

         for(int var14 = 0; var14 < this.face_vert_cnt[var13]; ++var14) {
            if (var4 < 256) {
               this.face_verts[var13][var14] = var1[var2++] & 255;
            } else {
               this.face_verts[var13][var14] = DataUtil.short_get(var1, var2);
               var2 += 2;
            }
         }
      }

      this.face_cnt = var5;
      this.trans_state = 1;
   }

   public Model(byte[] var1, int var2) {
      super();
      this.trans_state = 1;
      this.visible = true;
      this.field_288 = true;
      this.field_289 = false;
      this.trans = false;
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
      this.light_ambient = 32;
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
         this.get_vert(var5, var6, var7);
      }

      for(int var14 = 0; var14 < var4; ++var14) {
         int var8 = this.method_277(this.field_343);
         int var9 = this.method_277(this.field_343);
         int var10 = this.method_277(this.field_343);
         int var11 = this.method_277(this.field_343);
         this.field_341 = this.method_277(this.field_343);
         this.light_ambient = this.method_277(this.field_343);
         int var20 = this.method_277(this.field_343);
         int[] var15 = new int[var8];

         for(int var16 = 0; var16 < var8; ++var16) {
            var15[var16] = this.method_277(this.field_343);
         }

         int[] var17 = new int[var11];

         for(int var18 = 0; var18 < var11; ++var18) {
            var17[var18] = this.method_277(this.field_343);
         }

         int var19 = this.face_add(var8, var15, var9, var10);
         this.field_313[var14] = var17;
         if (var20 == 0) {
            this.light_type[var19] = 0;
         } else {
            this.light_type[var19] = this.field_304;
         }
      }

      this.trans_state = 1;
   }

   public Model(String var1) {
      super();
      this.trans_state = 1;
      this.visible = true;
      this.field_288 = true;
      this.field_289 = false;
      this.trans = false;
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
      this.light_ambient = 32;
      boolean var2 = false;
      boolean var3 = false;
      Object var4 = null;

      byte[] var25;
      try {
         InputStream var5 = DataUtil.open_stream(var1);
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
         this.vert_cnt = 0;
         this.face_cnt = 0;
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
         this.get_vert(var7, var8, var9);
      }

      for(int var16 = 0; var16 < var27; ++var16) {
         int var10 = this.method_277(var25);
         int var11 = this.method_277(var25);
         int var12 = this.method_277(var25);
         int var13 = this.method_277(var25);
         this.field_341 = this.method_277(var25);
         this.light_ambient = this.method_277(var25);
         int var28 = this.method_277(var25);
         int[] var17 = new int[var10];

         for(int var18 = 0; var18 < var10; ++var18) {
            var17[var18] = this.method_277(var25);
         }

         int[] var19 = new int[var13];

         for(int var20 = 0; var20 < var13; ++var20) {
            var19[var20] = this.method_277(var25);
         }

         int var21 = this.face_add(var10, var17, var11, var12);
         this.field_313[var16] = var19;
         if (var28 == 0) {
            this.light_type[var21] = 0;
         } else {
            this.light_type[var21] = this.field_304;
         }
      }

      this.trans_state = 1;
   }

   public Model(Model[] var1, int var2, boolean var3, boolean var4, boolean var5, boolean var6) {
      super();
      this.trans_state = 1;
      this.visible = true;
      this.field_288 = true;
      this.field_289 = false;
      this.trans = false;
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
      this.light_ambient = 32;
      this.field_294 = var3;
      this.field_295 = var4;
      this.field_296 = var5;
      this.field_297 = var6;
      this.method_246(var1, var2, false);
   }

   public Model(Model[] var1, int var2) {
      super();
      this.trans_state = 1;
      this.visible = true;
      this.field_288 = true;
      this.field_289 = false;
      this.trans = false;
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
      this.light_ambient = 32;
      this.method_246(var1, var2, true);
   }

   // $FF: renamed from: ul (jagex.client.q[], int, boolean) void
   public void method_246(Model[] var1, int var2, boolean var3) {
      int var4 = 0;
      int var5 = 0;

      for(int var6 = 0; var6 < var2; ++var6) {
         var4 += var1[var6].face_cnt;
         var5 += var1[var6].vert_cnt;
      }

      this.method_242(var5, var4);
      if (var3) {
         this.field_313 = new int[var4][];
      }

      for(int var7 = 0; var7 < var2; ++var7) {
         Model var8 = var1[var7];
         var8.method_273();
         this.light_ambient = var8.light_ambient;
         this.field_341 = var8.field_341;
         this.field_337 = var8.field_337;
         this.field_338 = var8.field_338;
         this.field_339 = var8.field_339;
         this.field_340 = var8.field_340;

         for(int var9 = 0; var9 < var8.face_cnt; ++var9) {
            int[] var10 = new int[var8.face_vert_cnt[var9]];
            int[] var11 = var8.face_verts[var9];

            for(int var12 = 0; var12 < var8.face_vert_cnt[var9]; ++var12) {
               var10[var12] = this.get_vert(var8.vert_x[var11[var12]], var8.field_307[var11[var12]], var8.vert_z[var11[var12]]);
            }

            int var13 = this.face_add(var8.face_vert_cnt[var9], var10, var8.texture_front[var9], var8.texture_back[var9]);
            this.light_type[var13] = var8.light_type[var9];
            this.norm_scale[var13] = var8.norm_scale[var9];
            this.norm_mag[var13] = var8.norm_mag[var9];
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

      this.trans_state = 1;
   }

   public Model(int var1, int[] var2, int[] var3, int[] var4, int var5, int var6) {
      this(var1, 1);
      this.vert_cnt = var1;

      for(int var7 = 0; var7 < var1; ++var7) {
         this.vert_x[var7] = var2[var7];
         this.field_307[var7] = var3[var7];
         this.vert_z[var7] = var4[var7];
      }

      this.face_cnt = 1;
      this.face_vert_cnt[0] = var1;
      int[] var8 = new int[var1];

      for(int var9 = 0; var9 < var1; var8[var9] = var9++) {
         ;
      }

      this.face_verts[0] = var8;
      this.texture_front[0] = var5;
      this.texture_back[0] = var6;
      this.trans_state = 1;
   }

   // $FF: renamed from: xl (int, int, int) int
   public int get_vert(int var1, int var2, int var3) {
      for(int var4 = 0; var4 < this.vert_cnt; ++var4) {
         if (this.vert_x[var4] == var1 && this.field_307[var4] == var2 && this.vert_z[var4] == var3) {
            return var4;
         }
      }

      if (this.vert_cnt >= this.field_305) {
         return -1;
      } else {
         this.vert_x[this.vert_cnt] = var1;
         this.field_307[this.vert_cnt] = var2;
         this.vert_z[this.vert_cnt] = var3;
         return this.vert_cnt++;
      }
   }

   // $FF: renamed from: tl (int, int, int) int
   public int vert_add(int var1, int var2, int var3) {
      if (this.vert_cnt >= this.field_305) {
         return -1;
      } else {
         this.vert_x[this.vert_cnt] = var1;
         this.field_307[this.vert_cnt] = var2;
         this.vert_z[this.vert_cnt] = var3;
         return this.vert_cnt++;
      }
   }

   // $FF: renamed from: zl (int, int[], int, int) int
   public int face_add(int var1, int[] var2, int var3, int var4) {
      if (this.face_cnt >= this.field_312) {
         return -1;
      } else {
         this.face_vert_cnt[this.face_cnt] = var1;
         this.face_verts[this.face_cnt] = var2;
         this.texture_front[this.face_cnt] = var3;
         this.texture_back[this.face_cnt] = var4;
         this.trans_state = 1;
         return this.face_cnt++;
      }
   }

   // $FF: renamed from: fm (int, int, int, int, int, int, int, boolean) jagex.client.q[]
   public Model[] split(int var1, int var2, int var3, int var4, int var5, int var6, int var7, boolean var8) {
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
      for(int var12 = 0; var12 < this.face_cnt; ++var12) {
         int var13 = 0;
         var14 = 0;
         var15 = this.face_vert_cnt[var12];
         int[] var16 = this.face_verts[var12];

         for(var17 = 0; var17 < var15; ++var17) {
            var13 += this.vert_x[var16[var17]];
            var14 += this.vert_z[var16[var17]];
         }

         var18 = var13 / (var15 * var3) + var14 / (var15 * var4) * var5;
         var9[var18] += var15;
         ++var10[var18];
      }

      Model[] var22 = new Model[var6];

      for(var14 = 0; var14 < var6; ++var14) {
         if (var9[var14] > var7) {
            var9[var14] = var7;
         }

         var22[var14] = new Model(var9[var14], var10[var14], true, true, true, var8, true);
         var22[var14].field_341 = this.field_341;
         var22[var14].light_ambient = this.light_ambient;
      }

      int var23;
      for(var15 = 0; var15 < this.face_cnt; ++var15) {
         var23 = 0;
         var17 = 0;
         var18 = this.face_vert_cnt[var15];
         int[] var19 = this.face_verts[var15];

         for(int var20 = 0; var20 < var18; ++var20) {
            var23 += this.vert_x[var19[var20]];
            var17 += this.vert_z[var19[var20]];
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
   public void method_251(Model var1, int[] var2, int var3, int var4) {
      int[] var5 = new int[var3];

      int var7;
      for(int var6 = 0; var6 < var3; ++var6) {
         var7 = var5[var6] = var1.get_vert(this.vert_x[var2[var6]], this.field_307[var2[var6]], this.vert_z[var2[var6]]);
         var1.vert_shade[var7] = this.vert_shade[var2[var6]];
         var1.vert_ambient[var7] = this.vert_ambient[var2[var6]];
      }

      var7 = var1.face_add(var3, var5, this.texture_front[var4], this.texture_back[var4]);
      if (!var1.field_297 && !this.field_297) {
         var1.face_pick_tag[var7] = this.face_pick_tag[var4];
      }

      var1.light_type[var7] = this.light_type[var4];
      var1.norm_scale[var7] = this.norm_scale[var4];
      var1.norm_mag[var7] = this.norm_mag[var4];
   }

   // $FF: renamed from: gm (boolean, int, int, int, int, int) void
   public void set_light(boolean var1, int var2, int var3, int var4, int var5, int var6) {
      this.light_ambient = 256 - var2 * 4;
      this.field_341 = (64 - var3) * 16 + 128;
      if (!this.field_296) {
         for(int var7 = 0; var7 < this.face_cnt; ++var7) {
            if (var1) {
               this.light_type[var7] = this.field_304;
            } else {
               this.light_type[var7] = 0;
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
      this.light_ambient = 256 - var1 * 4;
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
   public void set_light(int var1, int var2, int var3) {
      if (!this.field_296) {
         this.field_337 = var1;
         this.field_338 = var2;
         this.field_339 = var3;
         this.field_340 = (int)Math.sqrt((double)(var1 * var1 + var2 * var2 + var3 * var3));
         this.method_269();
      }
   }

   // $FF: renamed from: om (int, int) void
   public void set_vert_ambient(int var1, int var2) {
      this.vert_ambient[var1] = (byte)var2;
   }

   // $FF: renamed from: jm (int, int, int) void
   public void method_256(int var1, int var2, int var3) {
      this.field_323 = this.field_323 + var1 & 255;
      this.field_324 = this.field_324 + var2 & 255;
      this.field_325 = this.field_325 + var3 & 255;
      this.method_263();
      this.trans_state = 1;
   }

   // $FF: renamed from: ml (int, int, int) void
   public void method_257(int var1, int var2, int var3) {
      this.field_323 = var1 & 255;
      this.field_324 = var2 & 255;
      this.field_325 = var3 & 255;
      this.method_263();
      this.trans_state = 1;
   }

   // $FF: renamed from: wl (int, int, int) void
   public void method_258(int var1, int var2, int var3) {
      this.field_320 += var1;
      this.field_321 += var2;
      this.field_322 += var3;
      this.method_263();
      this.trans_state = 1;
   }

   // $FF: renamed from: hl (int, int, int) void
   public void method_259(int var1, int var2, int var3) {
      this.field_320 = var1;
      this.field_321 = var2;
      this.field_322 = var3;
      this.method_263();
      this.trans_state = 1;
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
      this.trans_state = 1;
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
      this.trans_state = 1;
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
      for(int var4 = 0; var4 < this.vert_cnt; ++var4) {
         this.field_309[var4] += var1;
         this.field_310[var4] += var2;
         this.field_311[var4] += var3;
      }

   }

   // $FF: renamed from: gl (int, int, int) void
   private void method_265(int var1, int var2, int var3) {
      for(int var7 = 0; var7 < this.vert_cnt; ++var7) {
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
      for(int var7 = 0; var7 < this.vert_cnt; ++var7) {
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
      for(int var4 = 0; var4 < this.vert_cnt; ++var4) {
         this.field_309[var4] = this.field_309[var4] * var1 >> 8;
         this.field_310[var4] = this.field_310[var4] * var2 >> 8;
         this.field_311[var4] = this.field_311[var4] * var3 >> 8;
      }

   }

   // $FF: renamed from: il () void
   private void method_268() {
      this.field_282 = this.field_284 = this.field_286 = 999999;
      this.field_336 = this.field_283 = this.field_285 = this.field_287 = -999999;

      for(int var2 = 0; var2 < this.face_cnt; ++var2) {
         int[] var1 = this.face_verts[var2];
         int var4 = var1[0];
         int var5 = this.face_vert_cnt[var2];
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

         for(int var2 = 0; var2 < this.face_cnt; ++var2) {
            if (this.light_type[var2] != this.field_304) {
               this.light_type[var2] = (this.field_275[var2] * this.field_337 + this.field_276[var2] * this.field_338 + this.field_277[var2] * this.field_339) / var1;
            }
         }

         int[] var3 = new int[this.vert_cnt];
         int[] var4 = new int[this.vert_cnt];
         int[] var5 = new int[this.vert_cnt];
         int[] var6 = new int[this.vert_cnt];

         for(int var7 = 0; var7 < this.vert_cnt; ++var7) {
            var3[var7] = 0;
            var4[var7] = 0;
            var5[var7] = 0;
            var6[var7] = 0;
         }

         int var9;
         for(int var8 = 0; var8 < this.face_cnt; ++var8) {
            if (this.light_type[var8] == this.field_304) {
               for(var9 = 0; var9 < this.face_vert_cnt[var8]; ++var9) {
                  int var10 = this.face_verts[var8][var9];
                  var3[var10] += this.field_275[var8];
                  var4[var10] += this.field_276[var8];
                  var5[var10] += this.field_277[var8];
                  ++var6[var10];
               }
            }
         }

         for(var9 = 0; var9 < this.vert_cnt; ++var9) {
            if (var6[var9] > 0) {
               this.vert_shade[var9] = (var3[var9] * this.field_337 + var4[var9] * this.field_338 + var5[var9] * this.field_339) / (var1 * var6[var9]);
            }
         }

      }
   }

   // $FF: renamed from: am () void
   public void method_270() {
      if (!this.field_296 || !this.field_295) {
         for(int var1 = 0; var1 < this.face_cnt; ++var1) {
            int[] var2 = this.face_verts[var1];
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
            this.norm_scale[var1] = -1;
         }

         this.method_269();
      }
   }

   // $FF: renamed from: em () void
   public void method_271() {
      int var1;
      if (this.trans_state == 2) {
         this.trans_state = 0;

         for(var1 = 0; var1 < this.vert_cnt; ++var1) {
            this.field_309[var1] = this.vert_x[var1];
            this.field_310[var1] = this.field_307[var1];
            this.field_311[var1] = this.vert_z[var1];
         }

         this.field_282 = this.field_284 = this.field_286 = -9999999;
         this.field_336 = this.field_283 = this.field_285 = this.field_287 = 9999999;
      } else {
         if (this.trans_state == 1) {
            this.trans_state = 0;

            for(var1 = 0; var1 < this.vert_cnt; ++var1) {
               this.field_309[var1] = this.vert_x[var1];
               this.field_310[var1] = this.field_307[var1];
               this.field_311[var1] = this.vert_z[var1];
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
   public void project(int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8) {
      this.method_271();
      if (this.field_286 <= Scene.frustum_near_z && this.field_287 >= Scene.frustum_far_z && this.field_282 <= Scene.frustum_min_x && this.field_283 >= Scene.frustum_max_x && this.field_284 <= Scene.frustum_min_y && this.field_285 >= Scene.frustum_max_y) {
         this.visible = true;
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

         for(int var16 = 0; var16 < this.vert_cnt; ++var16) {
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
               this.project_plane_x[var16] = (var17 << var7) / var19;
            } else {
               this.project_plane_x[var16] = var17 << var7;
            }

            if (var19 >= var8) {
               this.project_plane_y[var16] = (var18 << var7) / var19;
            } else {
               this.project_plane_y[var16] = var18 << var7;
            }

            this.project_vert_x[var16] = var17;
            this.project_vert_y[var16] = var18;
            this.project_vert_z[var16] = var19;
         }

      } else {
         this.visible = false;
      }
   }

   // $FF: renamed from: fl () void
   public void method_273() {
      this.method_271();

      for(int var1 = 0; var1 < this.vert_cnt; ++var1) {
         this.vert_x[var1] = this.field_309[var1];
         this.field_307[var1] = this.field_310[var1];
         this.vert_z[var1] = this.field_311[var1];
      }

      this.field_320 = this.field_321 = this.field_322 = 0;
      this.field_323 = this.field_324 = this.field_325 = 0;
      this.field_326 = this.field_327 = this.field_328 = 256;
      this.field_329 = this.field_330 = this.field_331 = this.field_332 = this.field_333 = this.field_334 = 256;
      this.field_335 = 0;
   }

   // $FF: renamed from: sl () jagex.client.q
   public Model method_274() {
      Model[] var1 = new Model[]{this};
      Model var2 = new Model(var1, 1);
      var2.field_279 = this.field_279;
      var2.trans = this.trans;
      return var2;
   }

   // $FF: renamed from: rl (boolean, boolean, boolean, boolean) jagex.client.q
   public Model method_275(boolean var1, boolean var2, boolean var3, boolean var4) {
      Model[] var5 = new Model[]{this};
      Model var6 = new Model(var5, 1, var1, var2, var3, var4);
      var6.field_279 = this.field_279;
      return var6;
   }

   // $FF: renamed from: cm (jagex.client.q) void
   public void method_276(Model var1) {
      this.field_323 = var1.field_323;
      this.field_324 = var1.field_324;
      this.field_325 = var1.field_325;
      this.field_320 = var1.field_320;
      this.field_321 = var1.field_321;
      this.field_322 = var1.field_322;
      this.method_263();
      this.trans_state = 1;
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
