import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class Demo3 {

}

class Sender extends Thread {
	@Override
	public void run() {
		try {
			DatagramSocket socket = new DatagramSocket();
			String str = "nihao";
			DatagramPacket p = new DatagramPacket(str.getBytes(),str.getBytes().length, InetAddress.getLocalHost(),9090);
			socket.send(p);
			socket.close();
		} catch (SocketException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

class Receive implements Runnable {

	@Override
	public void run() {
		try {
			DatagramSocket socket = new DatagramSocket(9090);
			byte[] buf = new byte[1024];
			DatagramPacket p = new DatagramPacket(buf, buf.length);
		} catch (SocketException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}