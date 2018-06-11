import jagex.client.Surface;
import java.awt.Component;

public class Screen extends Surface {
	public mudclient client;

	public Screen(int w, int h, int sprite_cnt, Component component) {
		super(w, h, sprite_cnt, component);
	}

	@Override 
	public void sprite_3d_plot(int x, int y, int w, int h, int entity_id, int trans_x, int trans_y) {
		if (entity_id >= 50000) {
			client.plot_bubble(x, y, w, h, entity_id - 50000, trans_x, trans_y);
		} else if (entity_id >= 40000) {
			client.plot_item(x, y, w, h, entity_id - 40000, trans_x, trans_y);
		} else if (entity_id >= 20000) {
			client.plot_npc(x, y, w, h, entity_id - 20000, trans_x, trans_y);
		} else if (entity_id >= 5000) {
			client.plot_player(x, y, w, h, entity_id - 5000, trans_x, trans_y);
		} else {
			resize_sprite_plot(x, y, w, h, entity_id);
		}
	}
}
