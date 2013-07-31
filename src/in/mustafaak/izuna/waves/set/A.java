package in.mustafaak.izuna.waves.set;


import java.util.ArrayList;
import java.util.List;

import in.mustafaak.izuna.meta.WaveEnemy;
import in.mustafaak.izuna.meta.WaveInfo;
import in.mustafaak.izuna.meta.WavePath;
import in.mustafaak.izuna.waves.RowColEnter;
import in.mustafaak.izuna.actions.*;

public class A {
	public static WaveInfo w1(){
		WaveInfo w = new RowColEnter(RowColEnter.FROM_UP, 100, 200, 1, 4, 150, 0, "a1", 2000);
		Action.wiggle(w, 100, 0, 2000);
		return w;
	}

	
	public static WaveInfo w2(){
		WaveInfo w = new RowColEnter(RowColEnter.FROM_LEFT, 100, 50, 1, 4, 150, 0, "a1", 2000);
		Action.wiggle(w, 150, 0, 2000);
		return w;
	}
	
	public static WaveInfo w3(){
		WaveInfo w = new RowColEnter(RowColEnter.FROM_RIGHT, 100, 50, 1, 4, 150, 0, "a1", 2000);
		Action.wiggle(w, 150, 0, 2000);
		return w;
	}
	
	public static WaveInfo w4(){
		WaveInfo w = new RowColEnter(RowColEnter.FROM_UP, 100, 50, 2, 4, 150, 150, "a1", 2000);
		Action.wiggle(w, 0, 150, 2000);
		return w;
	}
	
	public static WaveInfo w5(){
		WaveInfo w1 = new WaveInfo();
		w1.setEnemies(new ArrayList<WaveEnemy>());
		
		Action s1 = new Start(-200, -200);
		Action m1 = new Move(250,600,2000);
		Action p1 = new Move(0,-300, 1000);
		w1.putEnemy("a1", s1,m1,p1);
		
		
		Action s2 = new Start(920, -200);
		Action m2 = new Move(-350,600,2000);
		Action p2 = new Move(0,-300, 1000);
		w1.putEnemy("a1", s2,m2,p2);
				
		WaveInfo w2 = new RowColEnter(RowColEnter.FROM_UP, 175, 100, 1, 3, 135, 0, "a1", 3000);

		Action.wiggle(w2, 0, 100, 2000);
		Action.wiggle(w1, 0, -50, 2000);
		
		return WaveInfo.combine(w1,w2);
	}
	
	public static WaveInfo w6(){
		
	}
}
