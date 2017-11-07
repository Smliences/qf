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
			//System.in�Ǽ��̣���������һ�������ֽ�������һ�������ַ���
			BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
			
			String line = null;
			DatagramPacket packet = null;
			
			//10.8.159.255 255��һ��Ĭ�ϵĹ㲥IP��ַ������Ƿ���255IP��ַ�����ݣ����е���ͬһ�����ε�
			//PC�������յ�
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
