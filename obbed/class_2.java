import jagex.client.class_1;
import java.awt.Component;

// $FF: renamed from: h
public class class_2 extends class_1 {
   // $FF: renamed from: rg mudclient
   public mudclient field_65;

   public class_2(int var1, int var2, int var3, Component var4) {
      super(var1, var2, var3, var4);
      boolean var5 = false;
      if (var5) {
         new class_1(var1, var2, var3, var4);
      }

   }

   // $FF: renamed from: jf (int, int, int, int, int, int, int) void
   public void method_67(int var1, int var2, int var3, int var4, int var5, int var6, int var7) {
      if (var5 >= 50000) {
         this.field_65.method_200(var1, var2, var3, var4, var5 - '\uc350', var6, var7);
      } else if (var5 >= 40000) {
         this.field_65.method_201(var1, var2, var3, var4, var5 - '\u9c40', var6, var7);
      } else if (var5 >= 20000) {
         this.field_65.method_202(var1, var2, var3, var4, var5 - 20000, var6, var7);
      } else if (var5 >= 5000) {
         this.field_65.method_203(var1, var2, var3, var4, var5 - 5000, var6, var7);
      } else {
         super.method_53(var1, var2, var3, var4, var5);
      }
   }
}
