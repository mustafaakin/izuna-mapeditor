package in.mustafaak.izuna.actions;

import in.mustafaak.izuna.meta.WaveEnemy;
import in.mustafaak.izuna.meta.WaveInfo;
import in.mustafaak.izuna.meta.WavePath;
import in.mustafaak.izuna.waves.*;
import in.mustafaak.izuna.waves.set.A;

import java.io.BufferedOutputStream;
import java.io.BufferedWriter;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.ArrayList;

import org.simpleframework.xml.core.Persister;

public class ActionTest {
	public static void main(String[] args) {
		WaveInfo waveInfo = new WaveInfo();

		/*
		RowColEnter rce1 = new RowColEnter(RowColEnter.FROM_LEFT, 100, 150, 3, 1, 100, 100, "a1", 1000);
		RowColEnter rce2 = new RowColEnter(RowColEnter.FROM_UP, 150, 100, 1, 3, 150, 100, "c1", 1000);
		RowColEnter rce3 = new RowColEnter(RowColEnter.FROM_RIGHT,500, 150, 3, 1, 100, 100, "a3", 1000);
		
		CircularInvade ci1 = new CircularInvade(4, -200, -200, 400, 400, 200, "b1", 3000) ;
*/
//		Invade i1 = new Invade(4, 800,-200, -250, 550, 150, 300, 200, 100, "a1", 2000);
		
		
		streamWave(A.w());

	}

	public static void streamWave(WaveInfo waveInfo) {
		try {
			Socket socket = new Socket();
			socket.connect(new InetSocketAddress("192.168.1.104", 5000), 50000);
			Persister serializer = new Persister();
			OutputStream os = socket.getOutputStream();
			BufferedOutputStream bos = new BufferedOutputStream(os);

			serializer.write(waveInfo, bos);
			serializer.write(waveInfo, System.out);
			os.flush();
			socket.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


}
