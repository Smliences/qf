package test;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Receive {
	public static void main(String[] args) throws IOException {
		ServerSocket serverSocket = new ServerSocket(6666);
		Socket accept = serverSocket.accept();
		OutputStream os = accept.getOutputStream();
		InputStream is = accept.getInputStream();
		byte[] b = new byte[1024];
		int length = -1;
		while ((length = is.read(b)) != -1) {
			os.write(b, 0, length);
		}
		is.close();
		os.close();
		serverSocket.close();
	}
}
