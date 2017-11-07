package b_udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class ChatReceive implements Runnable{

	@Override
	public void run() {
		try {
			DatagramSocket socket = new DatagramSocket(9000);
			
			byte[] buf = new byte[1024];
			DatagramPacket packet = new DatagramPacket(buf, buf.length);
			
			boolean flag = true;
			while (flag) {
				socket.receive(packet);
				
				System.out.println(packet.getAddress().getHostAddress() + ":" + 
						new String(buf, 0, packet.getLength()));
			}
			
			socket.close();
		} catch (SocketException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}
