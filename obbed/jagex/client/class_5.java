package jagex.client;

import jagex.class_0;
import jagex.class_14;
import java.applet.Applet;
import java.awt.Color;
import java.awt.Component;
import java.awt.Event;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.IndexColorModel;
import java.awt.image.MemoryImageSource;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;

// $FF: renamed from: jagex.client.o
public class class_5 extends Applet implements Runnable {
   // $FF: renamed from: yp int
   private int field_108 = 512;
   // $FF: renamed from: zp int
   private int field_109 = 384;
   // $FF: renamed from: aq java.lang.Thread
   private Thread field_110;
   // $FF: renamed from: bq int
   private int field_111 = 20;
   // $FF: renamed from: cq int
   private int field_112 = 1000;
   // $FF: renamed from: dq long[]
   private long[] field_113 = new long[10];
   // $FF: renamed from: eq jagex.client.l
   static class_4 field_114 = null;
   // $FF: renamed from: fq boolean
   private boolean field_115;
   // $FF: renamed from: gq int
   private int field_116;
   // $FF: renamed from: hq int
   private int field_117;
   // $FF: renamed from: iq int
   public int field_118;
   // $FF: renamed from: jq int
   public int field_119;
   // $FF: renamed from: kq int
   public int field_120 = 1;
   // $FF: renamed from: lq java.lang.String
   public String field_121;
   // $FF: renamed from: mq boolean
   private boolean field_122 = false;
   // $FF: renamed from: nq int
   private int field_123;
   // $FF: renamed from: oq java.lang.String
   private String field_124 = "Loading";
   // $FF: renamed from: pq java.awt.Font
   private Font field_125 = new Font("TimesRoman", 0, 15);
   // $FF: renamed from: qq java.awt.Font
   private Font field_126 = new Font("Helvetica", 1, 13);
   // $FF: renamed from: rq java.awt.Font
   private Font field_127 = new Font("Helvetica", 0, 12);
   // $FF: renamed from: sq java.awt.Image
   private Image field_128;
   // $FF: renamed from: tq java.awt.Graphics
   private Graphics field_129;
   // $FF: renamed from: uq boolean
   public boolean field_130 = false;
   // $FF: renamed from: vq boolean
   public boolean field_131 = false;
   // $FF: renamed from: wq boolean
   public boolean field_132 = false;
   // $FF: renamed from: xq boolean
   public boolean field_133 = false;
   // $FF: renamed from: yq boolean
   public boolean field_134 = false;
   // $FF: renamed from: zq boolean
   public boolean field_135 = false;
   // $FF: renamed from: ar boolean
   public boolean field_136 = false;
   // $FF: renamed from: br boolean
   public boolean field_137 = false;
   // $FF: renamed from: cr int
   public int field_138 = 1;
   // $FF: renamed from: dr int
   public int field_139;
   // $FF: renamed from: er int
   public int field_140;
   // $FF: renamed from: fr int
   public int field_141;
   // $FF: renamed from: gr int
   public int field_142;
   // $FF: renamed from: hr int
   public int field_143;
   // $FF: renamed from: ir int
   public int field_144;
   // $FF: renamed from: jr boolean
   public boolean field_145 = false;
   // $FF: renamed from: kr java.lang.String
   public String field_146 = "";
   // $FF: renamed from: lr java.lang.String
   public String field_147 = "";
   // $FF: renamed from: mr java.lang.String
   public String field_148 = "";
   // $FF: renamed from: nr java.lang.String
   public String field_149 = "";

   // $FF: renamed from: ui () void
   public void method_116() {
   }

   // $FF: renamed from: dj () void
   public synchronized void method_117() {
   }

   // $FF: renamed from: mj () void
   public void method_118() {
   }

   // $FF: renamed from: jj () void
   public synchronized void method_119() {
   }

   // $FF: renamed from: xi () void
   public void method_120() {
   }

   // $FF: renamed from: lj (int, int, java.lang.String, boolean) void
   public final void method_121(int var1, int var2, String var3, boolean var4) {
      this.field_115 = false;
      System.out.println("Started application");
      this.field_108 = var1;
      this.field_109 = var2;
      field_114 = new class_4(this, var1, var2, var3, var4, false);
      this.field_120 = 1;
      this.field_110 = new Thread(this);
      this.field_110.start();
      this.field_110.setPriority(1);
   }

   // $FF: renamed from: vi () boolean
   public final boolean method_122() {
      return this.field_115;
   }

   public final Graphics getGraphics() {
      return field_114 == null ? super.getGraphics() : field_114.getGraphics();
   }

   // $FF: renamed from: ti () int
   public final int method_123() {
      return this.field_108;
   }

   // $FF: renamed from: aj () int
   public final int method_124() {
      return this.field_109;
   }

   public final Image createImage(int var1, int var2) {
      return field_114 == null ? super.createImage(var1, var2) : field_114.createImage(var1, var2);
   }

   // $FF: renamed from: yi () java.awt.Frame
   public Frame method_125() {
      return field_114;
   }

   // $FF: renamed from: fj (int) void
   public final void method_126(int var1) {
      this.field_111 = 1000 / var1;
   }

   // $FF: renamed from: kj (int) void
   public final void method_127(int var1) {
      this.field_112 = var1;
   }

   // $FF: renamed from: nj () void
   public final void method_128() {
      for(int var1 = 0; var1 < 10; ++var1) {
         this.field_113[var1] = 0L;
      }

   }

   public synchronized boolean keyDown(Event var1, int var2) {
      this.method_129(var2);
      this.field_143 = var2;
      this.field_144 = var2;
      this.field_119 = 0;
      if (var2 == 1006) {
         this.field_132 = true;
      }

      if (var2 == 1007) {
         this.field_133 = true;
      }

      if (var2 == 1004) {
         this.field_134 = true;
      }

      if (var2 == 1005) {
         this.field_135 = true;
      }

      if ((char)var2 == ' ') {
         this.field_136 = true;
      }

      if ((char)var2 == 'n' || (char)var2 == 'm') {
         this.field_137 = true;
      }

      if ((char)var2 == 'N' || (char)var2 == 'M') {
         this.field_137 = true;
      }

      if ((char)var2 == '{') {
         this.field_130 = true;
      }

      if ((char)var2 == '}') {
         this.field_131 = true;
      }

      if ((char)var2 == 1008) {
         this.field_145 = !this.field_145;
      }

      if ((var2 >= 97 && var2 <= 122 || var2 >= 65 && var2 <= 90 || var2 >= 48 && var2 <= 57 || var2 == 32) && this.field_146.length() < 20) {
         this.field_146 = this.field_146 + (char)var2;
      }

      if (var2 >= 32 && var2 <= 122 && this.field_148.length() < 80) {
         this.field_148 = this.field_148 + (char)var2;
      }

      if (var2 == 8 && this.field_146.length() > 0) {
         this.field_146 = this.field_146.substring(0, this.field_146.length() - 1);
      }

      if (var2 == 8 && this.field_148.length() > 0) {
         this.field_148 = this.field_148.substring(0, this.field_148.length() - 1);
      }

      if (var2 == 10 || var2 == 13) {
         this.field_147 = this.field_146;
         this.field_149 = this.field_148;
      }

      return true;
   }

   // $FF: renamed from: ej (int) void
   public void method_129(int var1) {
   }

   public synchronized boolean keyUp(Event var1, int var2) {
      this.field_143 = 0;
      if (var2 == 1006) {
         this.field_132 = false;
      }

      if (var2 == 1007) {
         this.field_133 = false;
      }

      if (var2 == 1004) {
         this.field_134 = false;
      }

      if (var2 == 1005) {
         this.field_135 = false;
      }

      if ((char)var2 == ' ') {
         this.field_136 = false;
      }

      if ((char)var2 == 'n' || (char)var2 == 'm') {
         this.field_137 = false;
      }

      if ((char)var2 == 'N' || (char)var2 == 'M') {
         this.field_137 = false;
      }

      if ((char)var2 == '{') {
         this.field_130 = false;
      }

      if ((char)var2 == '}') {
         this.field_131 = false;
      }

      return true;
   }

   public synchronized boolean mouseMove(Event var1, int var2, int var3) {
      this.field_139 = var2;
      this.field_140 = var3 + this.field_118;
      this.field_141 = 0;
      this.field_119 = 0;
      return true;
   }

   public synchronized boolean mouseUp(Event var1, int var2, int var3) {
      this.field_139 = var2;
      this.field_140 = var3 + this.field_118;
      this.field_141 = 0;
      return true;
   }

   public synchronized boolean mouseDown(Event var1, int var2, int var3) {
      this.field_139 = var2;
      this.field_140 = var3 + this.field_118;
      if (var1.metaDown()) {
         this.field_141 = 2;
      } else {
         this.field_141 = 1;
      }

      this.field_142 = this.field_141;
      this.field_119 = 0;
      this.method_130(this.field_141, var2, var3);
      return true;
   }

   // $FF: renamed from: ij (int, int, int) void
   public void method_130(int var1, int var2, int var3) {
   }

   public synchronized boolean mouseDrag(Event var1, int var2, int var3) {
      this.field_139 = var2;
      this.field_140 = var3 + this.field_118;
      if (var1.metaDown()) {
         this.field_141 = 2;
      } else {
         this.field_141 = 1;
      }

      return true;
   }

   public final void init() {
      this.field_115 = true;
      System.out.println("Started applet");
      this.field_108 = this.size().width;
      this.field_109 = this.size().height;
      this.field_120 = 1;
      class_0.field_0 = this.getCodeBase();
      this.field_110 = new Thread(this);
      this.field_110.start();
   }

   public final void start() {
      if (this.field_116 >= 0) {
         this.field_116 = 0;
      }

   }

   public final void stop() {
      if (this.field_116 >= 0) {
         this.field_116 = 4000 / this.field_111;
      }

   }

   public final void destroy() {
      this.field_116 = -1;

      try {
         Thread.sleep(5000L);
      } catch (Exception var1) {
         ;
      }

      if (this.field_116 == -1) {
         System.out.println("5 seconds expired, forcing kill");
         this.method_131();
         if (this.field_110 != null) {
            this.field_110.stop();
            this.field_110 = null;
         }
      }

   }

   // $FF: renamed from: cj () void
   public final void method_131() {
      this.field_116 = -2;
      System.out.println("Closing program");
      this.method_118();

      try {
         Thread.sleep(1000L);
      } catch (Exception var1) {
         ;
      }

      if (field_114 != null) {
         field_114.dispose();
      }

      if (!this.field_115) {
         System.exit(0);
      }

   }

   public final void run() {
      if (this.field_120 == 1) {
         this.field_120 = 2;
         this.field_129 = this.getGraphics();
         this.method_132();
         this.method_133(0, "Loading...");
         this.method_116();
         this.field_120 = 0;
      }

      int var3 = 0;
      int var4 = 256;
      int var5 = 1;
      int var6 = 0;

      for(int var7 = 0; var7 < 10; ++var7) {
         this.field_113[var7] = System.currentTimeMillis();
      }

      long var1 = System.currentTimeMillis();

      while(this.field_116 >= 0) {
         if (this.field_116 > 0) {
            --this.field_116;
            if (this.field_116 == 0) {
               this.method_131();
               this.field_110 = null;
               return;
            }
         }

         int var8 = var4;
         int var9 = var5;
         var4 = 300;
         var5 = 1;
         var1 = System.currentTimeMillis();
         if (this.field_113[var3] == 0L) {
            var4 = var8;
            var5 = var9;
         } else if (var1 > this.field_113[var3]) {
            var4 = (int)((long)(2560 * this.field_111) / (var1 - this.field_113[var3]));
         }

         if (var4 < 25) {
            var4 = 25;
         }

         if (var4 > 256) {
            var4 = 256;
            var5 = (int)((long)this.field_111 - (var1 - this.field_113[var3]) / 10L);
            if (var5 < this.field_138) {
               var5 = this.field_138;
            }
         }

         try {
            Thread.sleep((long)var5);
         } catch (InterruptedException var11) {
            ;
         }

         this.field_113[var3] = var1;
         var3 = (var3 + 1) % 10;
         int var10;
         if (var5 > 1) {
            for(var10 = 0; var10 < 10; ++var10) {
               if (this.field_113[var10] != 0L) {
                  this.field_113[var10] += (long)var5;
               }
            }
         }

         var10 = 0;

         while(var6 < 256) {
            this.method_117();
            var6 += var4;
            ++var10;
            if (var10 > this.field_112) {
               var6 = 0;
               this.field_117 += 6;
               if (this.field_117 > 25) {
                  this.field_117 = 0;
                  this.field_145 = true;
               }
               break;
            }
         }

         --this.field_117;
         var6 &= 255;
         this.method_119();
      }

      if (this.field_116 == -1) {
         this.method_131();
      }

      this.field_110 = null;
   }

   public final void update(Graphics var1) {
      this.paint(var1);
   }

   public final void paint(Graphics var1) {
      if (this.field_120 == 2 && this.field_128 != null) {
         this.method_133(this.field_123, this.field_124);
      } else {
         if (this.field_120 == 0) {
            this.method_120();
         }

      }
   }

   // $FF: renamed from: zi () void
   public void method_132() {
      try {
         byte[] var1 = class_0.method_16("jagex.jag");
         byte[] var2 = class_0.method_19("logo.tga", 0, var1);
         this.field_128 = this.method_136(var2);
         class_1.method_73(class_0.method_19("h11p.jf", 0, var1));
         class_1.method_73(class_0.method_19("h12b.jf", 0, var1));
         class_1.method_73(class_0.method_19("h12p.jf", 0, var1));
         class_1.method_73(class_0.method_19("h13b.jf", 0, var1));
         class_1.method_73(class_0.method_19("h14b.jf", 0, var1));
         class_1.method_73(class_0.method_19("h16b.jf", 0, var1));
         class_1.method_73(class_0.method_19("h20b.jf", 0, var1));
         class_1.method_73(class_0.method_19("h24b.jf", 0, var1));
      } catch (IOException var3) {
         System.out.println("Error loading jagex.dat");
      }
   }

   // $FF: renamed from: hj (int, java.lang.String) void
   public void method_133(int var1, String var2) {
      int var3 = (this.field_108 - 281) / 2;
      int var4 = (this.field_109 - 148) / 2;
      this.field_129.setColor(Color.black);
      this.field_129.fillRect(0, 0, this.field_108, this.field_109);
      if (!this.field_122) {
         this.field_129.drawImage(this.field_128, var3, var4, this);
      }

      var3 += 2;
      var4 += 90;
      this.field_123 = var1;
      this.field_124 = var2;
      this.field_129.setColor(new Color(132, 132, 132));
      if (this.field_122) {
         this.field_129.setColor(new Color(220, 0, 0));
      }

      this.field_129.drawRect(var3 - 2, var4 - 2, 280, 23);
      this.field_129.fillRect(var3, var4, 277 * var1 / 100, 20);
      this.field_129.setColor(new Color(198, 198, 198));
      if (this.field_122) {
         this.field_129.setColor(new Color(255, 255, 255));
      }

      this.method_135(this.field_129, var2, this.field_125, var3 + 138, var4 + 10);
      if (!this.field_122) {
         this.method_135(this.field_129, "Created by JAGeX - visit www.jagex.com", this.field_126, var3 + 138, var4 + 30);
         this.method_135(this.field_129, "\u00a92001-2002 Andrew Gower and Jagex Ltd", this.field_126, var3 + 138, var4 + 44);
      } else {
         this.field_129.setColor(new Color(132, 132, 152));
         this.method_135(this.field_129, "\u00a92001-2002 Andrew Gower and Jagex Ltd", this.field_127, var3 + 138, this.field_109 - 20);
      }

      if (this.field_121 != null) {
         this.field_129.setColor(Color.white);
         this.method_135(this.field_129, this.field_121, this.field_126, var3 + 138, var4 - 120);
      }

   }

   // $FF: renamed from: si (int, java.lang.String) void
   public void method_134(int var1, String var2) {
      int var3 = (this.field_108 - 281) / 2;
      int var4 = (this.field_109 - 148) / 2;
      var3 += 2;
      var4 += 90;
      this.field_123 = var1;
      this.field_124 = var2;
      int var5 = 277 * var1 / 100;
      this.field_129.setColor(new Color(132, 132, 132));
      if (this.field_122) {
         this.field_129.setColor(new Color(220, 0, 0));
      }

      this.field_129.fillRect(var3, var4, var5, 20);
      this.field_129.setColor(Color.black);
      this.field_129.fillRect(var3 + var5, var4, 277 - var5, 20);
      this.field_129.setColor(new Color(198, 198, 198));
      if (this.field_122) {
         this.field_129.setColor(new Color(255, 255, 255));
      }

      this.method_135(this.field_129, var2, this.field_125, var3 + 138, var4 + 10);
   }

   // $FF: renamed from: bj (java.awt.Graphics, java.lang.String, java.awt.Font, int, int) void
   public void method_135(Graphics var1, String var2, Font var3, int var4, int var5) {
      Object var6;
      if (field_114 == null) {
         var6 = this;
      } else {
         var6 = field_114;
      }

      FontMetrics var7 = ((Component)var6).getFontMetrics(var3);
      var7.stringWidth(var2);
      var1.setFont(var3);
      var1.drawString(var2, var4 - var7.stringWidth(var2) / 2, var5 + var7.getHeight() / 4);
   }

   // $FF: renamed from: gj (byte[]) java.awt.Image
   public Image method_136(byte[] var1) {
      int var2 = var1[13] * 256 + var1[12];
      int var3 = var1[15] * 256 + var1[14];
      byte[] var4 = new byte[256];
      byte[] var5 = new byte[256];
      byte[] var6 = new byte[256];

      for(int var7 = 0; var7 < 256; ++var7) {
         var4[var7] = var1[20 + var7 * 3];
         var5[var7] = var1[19 + var7 * 3];
         var6[var7] = var1[18 + var7 * 3];
      }

      IndexColorModel var8 = new IndexColorModel(8, 256, var4, var5, var6);
      byte[] var9 = new byte[var2 * var3];
      int var10 = 0;

      for(int var11 = var3 - 1; var11 >= 0; --var11) {
         for(int var12 = 0; var12 < var2; ++var12) {
            var9[var10++] = var1[786 + var12 + var11 * var2];
         }
      }

      MemoryImageSource var14 = new MemoryImageSource(var2, var3, var8, var9, 0, var2);
      Image var13 = this.createImage(var14);
      return var13;
   }

   // $FF: renamed from: wi (java.lang.String, java.lang.String, int) byte[]
   public byte[] method_137(String var1, String var2, int var3) throws IOException {
      int var4 = 0;
      int var5 = 0;
      int var6 = 0;
      byte[] var7 = null;

      while(var4 < 2) {
         try {
            this.method_134(var3, "Loading " + var2 + " - 0%");
            if (var4 == 1) {
               var1 = var1.toUpperCase();
            }

            InputStream var8 = class_0.method_0(var1);
            DataInputStream var9 = new DataInputStream(var8);
            byte[] var10 = new byte[6];
            var9.readFully(var10, 0, 6);
            var5 = ((var10[0] & 255) << 16) + ((var10[1] & 255) << 8) + (var10[2] & 255);
            var6 = ((var10[3] & 255) << 16) + ((var10[4] & 255) << 8) + (var10[5] & 255);
            this.method_134(var3, "Loading " + var2 + " - 5%");
            int var11 = 0;
            var7 = new byte[var6];

            while(var11 < var6) {
               int var12 = var6 - var11;
               if (var12 > 1000) {
                  var12 = 1000;
               }

               var9.readFully(var7, var11, var12);
               var11 += var12;
               this.method_134(var3, "Loading " + var2 + " - " + (5 + var11 * 95 / var6) + "%");
            }

            var4 = 2;
            var9.close();
         } catch (IOException var13) {
            ++var4;
         }
      }

      this.method_134(var3, "Unpacking " + var2);
      if (var6 != var5) {
         byte[] var14 = new byte[var5];
         class_14.method_329(var14, var5, var7, var6, 0);
         return var14;
      } else {
         return var7;
      }
   }

   public class_5() {
      super();
   }
}
