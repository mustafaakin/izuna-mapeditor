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
	public static void main(String[] args){
		Action a1 = new Start(-100,-100);
		Action a2 = new Move(300,300,1000);
		Action a3 = new Loop();
		Action a4 = new Rectangle(400, 200, true, 1000);
		Action a5 = new Move(0,200, 500);
		Action a6 = new Rectangle(200, 400, false, 1000);
		
		ArrayList<WavePath> wavePath = Action.construct(null, a1,a2,a3,a4,a5,a6);
		
		WaveInfo waveInfo = new WaveInfo();
		ArrayList<WaveEnemy> waveEnemies = new ArrayList<WaveEnemy>();
		waveInfo.setEnemies(waveEnemies);
		
		WaveEnemy waveEnemy = new WaveEnemy();
		waveEnemy.setKey("a1");
		waveEnemy.setPaths(wavePath);
		waveEnemies.add(waveEnemy);
		
		streamWave(waveInfo);
		
	}
	
	
	public static void streamWave(WaveInfo waveInfo){
	    try {
	    	Socket socket = new Socket();
	    	socket.connect(new InetSocketAddress("192.168.1.102", 5000), 50000);
			Persister serializer = new Persister();
	    	OutputStream os = socket.getOutputStream();
	    	serializer.write(waveInfo, os);
	    	serializer.write(waveInfo, System.out);
	    	os.flush();
	    } catch ( Exception e){
	    	e.printStackTrace();
	    }
	}
}
