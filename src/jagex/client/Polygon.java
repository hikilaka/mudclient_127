package jagex.client;

public final class Polygon {
   protected int min_plane_x;
   protected int min_plane_y;
   protected int max_plane_x;
   protected int max_plane_y;
   protected int min_z;
   protected int max_z;
   protected Model model;
   protected int face;
   protected int depth;
   protected int norm_x;
   protected int norm_y;
   protected int norm_z;
   protected int visibility;
   protected int texture;
   protected boolean handled = false;
   protected int key;
   protected int successor = -1;
}
