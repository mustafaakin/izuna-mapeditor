package in.mustafaak.izuna.actions;

import in.mustafaak.izuna.meta.WavePath;

import java.util.ArrayList;

public class Invade extends Action {
	public Invade(int index, int delay, int x, int y, int spacing, int xmax, int ymax, int r, int duration) {
		Action a0 = new Delay(delay * index);
		Action a1 = new Move(x, y, duration);
		Action a2;
		if (x < 0) { // meaning coming from right
			a2 = new Circle(r, 2, 2, true, duration);
		} else {
			a2 = new Circle(r, 1, 2, false, duration);
		}
		Action a3 = new Move(-xmax + spacing * index, -ymax, duration);
		addAction(a0, a1, a2, a3);
	}

	@Override
	public ArrayList<WavePath> getPath(WavePath prev) {
		return null;
	}

}
