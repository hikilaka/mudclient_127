package jagex.client;

import java.awt.Event;
import java.awt.Frame;
import java.awt.Graphics;

@SuppressWarnings("serial")
public final class Window extends Frame {
	private int field_104;
	private int y_offset = 28;
	private Game game;

	public Window(Game game, int width, int height, String title, boolean resizable, boolean use_offset) {
		this.game = game;

		if (use_offset) {
			y_offset = 48;
		} else {
			y_offset = 28;
		}

		setTitle(title);
		setResizable(resizable);
		setVisible(true);
		toFront();
		resize(width, height);
	}

	@Override
	public Graphics getGraphics() {
		Graphics gfx = super.getGraphics();

		if (field_104 == 0) {
			gfx.translate(0, 24);
		} else {
			gfx.translate(-5, 0);
		}

		return gfx;
	}

	@SuppressWarnings("deprecation")
	@Override
	public void resize(int width, int height) {
		super.resize(width, height + y_offset);
	}

	@SuppressWarnings("deprecation")
	@Override
	public boolean handleEvent(Event event) {
		if (event.id == 401) {
			game.keyDown(event, event.key);
		} else if (event.id == 402) {
			game.keyUp(event, event.key);
		} else if (event.id == 501) {
			game.mouseDown(event, event.x, event.y - 24);
		} else if (event.id == 506) {
			game.mouseDrag(event, event.x, event.y - 24);
		} else if (event.id == 502) {
			game.mouseUp(event, event.x, event.y - 24);
		} else if (event.id == 503) {
			game.mouseMove(event, event.x, event.y - 24);
		} else if (event.id == 201) {
			game.destroy();
		} else if (event.id == 1001) {
			game.action(event, event.target);
		} else if (event.id == 403) {
			game.keyDown(event, event.key);
		} else if (event.id == 404) {
			game.keyUp(event, event.key);
		}

		return true;
	}

	@Override
	public final void paint(Graphics gfx) {
		game.paint(gfx);
	}
}
