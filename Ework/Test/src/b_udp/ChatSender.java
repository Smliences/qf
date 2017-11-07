package b_udp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class ChatSender extends Thread {
	@Override
	public void run() {
		
		try {
			DatagramSocket socket = new DatagramSocket();
			
			//public class InputStreamReader extends Reader 
			//System.in是键盘，这里是用一个输入字节流做成一个输入字符流
			BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
			
			String line = null;
			DatagramPacket packet = null;
			
			//10.8.159.255 255是一个默认的广播IP地址，如果是发往255IP地址的数据，所有的在同一个网段的
			//PC都可以收到
			while ((line = read.readLine()) != null) {
				packet = new DatagramPacket(line.getBytes(), 
						line.getBytes().length,
						InetAddress.getByName("10.8.159.255"),
						9000);
				socket.send(packet);
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
