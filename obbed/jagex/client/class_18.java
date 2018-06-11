package jagex.client;

import java.io.InputStream;
import sun.audio.AudioPlayer;

// $FF: renamed from: jagex.client.e
public class class_18 extends InputStream {
   // $FF: renamed from: mf byte[]
   byte[] field_669;
   // $FF: renamed from: nf int
   int field_670;
   // $FF: renamed from: of int
   int field_671;

   public class_18() {
      super();
      AudioPlayer.player.start(this);
   }

   // $FF: renamed from: fe () void
   public void method_410() {
      AudioPlayer.player.stop(this);
   }

   // $FF: renamed from: ee (byte[], int, int) void
   public void method_411(byte[] var1, int var2, int var3) {
      this.field_669 = var1;
      this.field_670 = var2;
      this.field_671 = var2 + var3;
   }

   public int read(byte[] var1, int var2, int var3) {
      for(int var4 = 0; var4 < var3; ++var4) {
         if (this.field_670 < this.field_671) {
            var1[var2 + var4] = this.field_669[this.field_670++];
         } else {
            var1[var2 + var4] = -1;
         }
      }

      return var3;
   }

   public int read() {
      byte[] var1 = new byte[1];
      this.read(var1, 0, 1);
      return var1[0];
   }
}
