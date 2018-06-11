package jagex.client;

import java.awt.Event;
import java.awt.Frame;
import java.awt.Graphics;

// $FF: renamed from: jagex.client.l
public class class_4 extends Frame {
   // $FF: renamed from: cl int
   int field_102;
   // $FF: renamed from: dl int
   int field_103;
   // $FF: renamed from: el int
   int field_104;
   // $FF: renamed from: fl int
   int field_105 = 28;
   // $FF: renamed from: gl jagex.client.o
   class_5 field_106;
   // $FF: renamed from: hl java.awt.Graphics
   Graphics field_107;

   public class_4(class_5 var1, int var2, int var3, String var4, boolean var5, boolean var6) {
      super();
      this.field_102 = var2;
      this.field_103 = var3;
      this.field_106 = var1;
      if (var6) {
         this.field_105 = 48;
      } else {
         this.field_105 = 28;
      }

      this.setTitle(var4);
      this.setResizable(var5);
      this.show();
      this.toFront();
      this.resize(this.field_102, this.field_103);
      this.field_107 = this.getGraphics();
   }

   public Graphics getGraphics() {
      Graphics var1 = super.getGraphics();
      if (this.field_104 == 0) {
         var1.translate(0, 24);
      } else {
         var1.translate(-5, 0);
      }

      return var1;
   }

   public void resize(int var1, int var2) {
      super.resize(var1, var2 + this.field_105);
   }

   public boolean handleEvent(Event var1) {
      if (var1.id == 401) {
         this.field_106.keyDown(var1, var1.key);
      } else if (var1.id == 402) {
         this.field_106.keyUp(var1, var1.key);
      } else if (var1.id == 501) {
         this.field_106.mouseDown(var1, var1.x, var1.y - 24);
      } else if (var1.id == 506) {
         this.field_106.mouseDrag(var1, var1.x, var1.y - 24);
      } else if (var1.id == 502) {
         this.field_106.mouseUp(var1, var1.x, var1.y - 24);
      } else if (var1.id == 503) {
         this.field_106.mouseMove(var1, var1.x, var1.y - 24);
      } else if (var1.id == 201) {
         this.field_106.destroy();
      } else if (var1.id == 1001) {
         this.field_106.action(var1, var1.target);
      } else if (var1.id == 403) {
         this.field_106.keyDown(var1, var1.key);
      } else if (var1.id == 404) {
         this.field_106.keyUp(var1, var1.key);
      }

      return true;
   }

   public final void paint(Graphics var1) {
      this.field_106.paint(var1);
   }
}
