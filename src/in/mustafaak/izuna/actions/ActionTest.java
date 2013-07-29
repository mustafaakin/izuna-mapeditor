package in.mustafaak.izuna.actions;

import in.mustafaak.izuna.meta.WaveEnemy;
import in.mustafaak.izuna.meta.WaveInfo;
import in.mustafaak.izuna.meta.WavePath;

import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.ArrayList;

import org.simpleframework.xml.core.Persister;

public class ActionTest {
	public static void main(String[] args) {
		WaveInfo waveInfo = new WaveInfo();
		ArrayList<WaveEnemy> waveEnemies = new ArrayList<WaveEnemy>();

		for (int i = 0; i < 20; i++) {
			Action a1 = new Start(-100, -100);
			int delay = 100;
			int x = 400;
			int y = 400;
			int spacing = 100;
			int xmax = 500;
			int ymax = 100;
			int r = 200;
			int duration = 1000;
			//Action a3 = new Invade(i, delay, x, y, spacing, xmax, ymax, r, duration);
			int duration2 = 2000;
			Action a3 = new CircularInvade(i, delay, x,y,r, duration, duration2);
			ArrayList<WavePath> wavePath = Action.construct(null, a1, a3);

			waveInfo.setEnemies(waveEnemies);

			WaveEnemy waveEnemy = new WaveEnemy();
			waveEnemy.setKey("a1");
			waveEnemy.setPaths(wavePath);
			waveEnemies.add(waveEnemy);

		}

		streamWave(waveInfo);

	}

	public static void streamWave(WaveInfo waveInfo) {
		try {
			Socket socket = new Socket();
			socket.connect(new InetSocketAddress("192.168.1.102", 5000), 50000);
			Persister serializer = new Persister();
			OutputStream os = socket.getOutputStream();
			serializer.write(waveInfo, os);
			serializer.write(waveInfo, System.out);
			os.flush();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
