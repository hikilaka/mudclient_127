package jagex.client;

import jagex.class_15;
import java.applet.Applet;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;

// $FF: renamed from: jagex.client.b
public class class_16 extends class_15 implements Runnable {
   // $FF: renamed from: kd java.io.InputStream
   private InputStream field_572;
   // $FF: renamed from: ld java.io.OutputStream
   private OutputStream field_573;
   // $FF: renamed from: md java.net.Socket
   private Socket field_574;
   // $FF: renamed from: nd boolean
   private boolean field_575 = false;
   // $FF: renamed from: od byte[]
   private byte[] field_576;
   // $FF: renamed from: pd int
   private int field_577;
   // $FF: renamed from: qd int
   private int field_578;
   // $FF: renamed from: rd java.lang.Thread
   private Thread field_579;
   // $FF: renamed from: sd boolean
   private boolean field_580 = true;

   public class_16(String var1, Applet var2, int var3) throws IOException {
      super();
      if (var2 != null) {
         this.field_574 = new Socket(InetAddress.getByName(var2.getCodeBase().getHost()), var3);
      } else {
         this.field_574 = new Socket(InetAddress.getByName(var1), var3);
      }

      this.field_574.setSoTimeout(30000);
      this.field_574.setTcpNoDelay(true);
      this.field_572 = this.field_574.getInputStream();
      this.field_573 = this.field_574.getOutputStream();
   }

   // $FF: renamed from: mi () void
   public void method_338() {
      super.method_338();
      this.field_575 = true;

      try {
         if (this.field_572 != null) {
            this.field_572.close();
         }

         if (this.field_573 != null) {
            this.field_573.close();
         }

         if (this.field_574 != null) {
            this.field_574.close();
         }
      } catch (IOException var5) {
         System.out.println("Error closing stream");
      }

      if (this.field_579 != null) {
         this.field_580 = true;
         synchronized(this){}

         try {
            this.notify();
         } catch (Throwable var4) {
            throw var4;
         }

         this.field_579 = null;
      }

      this.field_576 = null;
   }

   // $FF: renamed from: qi () int
   public int method_339() throws IOException {
      return this.field_575 ? 0 : this.field_572.read();
   }

   // $FF: renamed from: hi () int
   public int method_340() throws IOException {
      return this.field_575 ? 0 : this.field_572.available();
   }

   // $FF: renamed from: bi (int, int, byte[]) void
   public void method_341(int var1, int var2, byte[] var3) throws IOException {
      if (!this.field_575) {
         int var4 = 0;

         int var6;
         for(boolean var5 = false; var4 < var1; var4 += var6) {
            if ((var6 = this.field_572.read(var3, var4 + var2, var1 - var4)) <= 0) {
               throw new IOException("EOF");
            }
         }

      }
   }

   // $FF: renamed from: ki (byte[], int, int) void
   public void method_342(byte[] var1, int var2, int var3) throws IOException {
      if (!this.field_575) {
         if (this.field_576 == null) {
            this.field_576 = new byte[5000];
         }

         synchronized(this){}

         try {
            for(int var6 = 0; var6 < var3; ++var6) {
               this.field_576[this.field_578] = var1[var6 + var2];
               this.field_578 = (this.field_578 + 1) % 5000;
               if (this.field_578 == (this.field_577 + 4900) % 5000) {
                  throw new IOException("buffer overflow");
               }
            }

            if (this.field_579 == null) {
               this.field_580 = false;
               this.field_579 = new Thread(this);
               this.field_579.setDaemon(true);
               this.field_579.setPriority(4);
               this.field_579.start();
            }

            this.notify();
         } catch (Throwable var8) {
            throw var8;
         }
      }
   }

   public void run() {
      while(this.field_579 != null && !this.field_580) {
         synchronized(this){}

         int var1;
         int var2;
         try {
            if (this.field_578 == this.field_577) {
               try {
                  this.wait();
               } catch (InterruptedException var11) {
                  ;
               }
            }

            if (this.field_579 == null || this.field_580) {
               return;
            }

            var2 = this.field_577;
            if (this.field_578 >= this.field_577) {
               var1 = this.field_578 - this.field_577;
            } else {
               var1 = 5000 - this.field_577;
            }
         } catch (Throwable var12) {
            throw var12;
         }

         if (var1 > 0) {
            try {
               this.field_573.write(this.field_576, var2, var1);
            } catch (IOException var10) {
               super.field_548 = true;
               super.field_549 = "Twriter:" + var10;
            }

            this.field_577 = (this.field_577 + var1) % 5000;

            try {
               if (this.field_578 == this.field_577) {
                  this.field_573.flush();
               }
            } catch (IOException var9) {
               super.field_548 = true;
               super.field_549 = "Twriter:" + var9;
            }
         }
      }

   }
}
