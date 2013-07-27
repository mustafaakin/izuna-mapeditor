package in.mustafaak.izuna;

import in.mustafaak.izuna.meta.WaveEnemy;
import in.mustafaak.izuna.meta.WaveInfo;
import in.mustafaak.izuna.meta.WavePath;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

import org.simpleframework.xml.core.Persister;


public class Shell {
	public static void p(String str) {
		System.out.print(str);
	}
	
	public static void pl(String str) {
		System.out.println(str);
	}

	public static int i(String str) {
		// scanner behaves strange when next() and nextInt() as I remember form
		// CS-101
		return Integer.parseInt(str);
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		WaveInfo waveInfo = new WaveInfo();

		pl("This app generates a wave, not whole level.");
		ArrayList<WaveEnemy> enemies = new ArrayList<WaveEnemy>();		
		while (true) {
			WaveEnemy enemy = new WaveEnemy();
			pl("");
			p("Enemy: (a-c)(1-4)/x: ");
			String ship = scan.next();
			if (ship.equals("x")) {
				break;
			}

			enemy.setKey(ship);

			ArrayList<WavePath> paths = new ArrayList<WavePath>();
			while (true) {
				WavePath path = new WavePath();
				p("Path: q/l/x: ");
				String pathType = scan.next();
				if (pathType.equals("x")) {
					break;
				}

				p("Start X: ");
				path.setStartX(i(scan.next()));
				p("Start Y: ");
				path.setStartY(i(scan.next()));

				p("End X: ");
				path.setEndX(i(scan.next()));
				p("End Y: ");
				path.setEndY(i(scan.next()));

				if (pathType.equals("q")) {
					p("Mid X: ");
					path.setMidX(i(scan.next()));
					p("Mid Y: ");
					path.setMidY(i(scan.next()));
				}

				p("Loop? y/n" );
				if (scan.next().equals("y")) {
					if (pathType.equals("q")) {
						path.setType("loop quadratic");
					} else {
						path.setType("loop linear");
					}
				} else {
					if (pathType.equals("q")) {
						path.setType("quadratic");
					} else {
						path.setType("linear");
					}
				}

				p("Duration: ");
				int duration = i(scan.next());

				path.setDuration(duration);
				paths.add(path);
			}

			enemy.setPaths(paths);
			enemies.add(enemy);
		}
		waveInfo.setEnemies(enemies);
		
		Persister serializer = new Persister();
	    File result = new File("wave_" + System.currentTimeMillis() + ".xml");
	    try {
			serializer.write(waveInfo, result);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
