import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class Demo2 extends Thread{
	@Override
	public void run() {
		DatagramSocket socket = null;
			try {
				socket = new DatagramSocket();
			} catch (SocketException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
		String line = null;
		DatagramPacket packet = null;
		try {
			while ((line = read.readLine()) != null) {
				packet = new DatagramPacket(line.getBytes(), 
						line.getBytes().length,
						InetAddress.getByName("10"),
						9000
						);
				socket.send(packet);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
class ChatReceive implements Runnable {

	@Override
	public void run() {
		try {
			DatagramSocket socket = new DatagramSocket(9000);
			
			byte[] buf = new byte[1024];
			DatagramPacket packet = new DatagramPacket(buf, buf.length);
			boolean flag = true;
			while (flag) {
				socket.receive(packet);
				System.out.println(packet.getAddress().getHostAddress());
			}
		} catch (SocketException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}
