package in.mustafaak.izuna.actions;

import in.mustafaak.izuna.meta.WavePath;

import java.util.ArrayList;

public class CircularInvade extends Action {
	public CircularInvade(int idx, int delay, int dx, int dy, int r, int duration, int durationCircle) {
		Action a1 = new Delay(idx * delay);
		Action a2 = new Move(dx, dy, duration);
		Action a3 = new Loop();
		Action a4 = new Circle(r, 0, 4, true, durationCircle);
		addAction(a1, a2, a3, a4);
	}

	@Override
	public ArrayList<WavePath> getPath(WavePath prev) {
		// TODO Auto-generated method stub
		return null;
	}
}
