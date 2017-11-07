package com.qianfeng.kaoti02;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class Server {
	public static void main(String[] args) throws UnknownHostException, IOException {
		Socket sendSocket = new Socket("10.8.159.46:9999", 6666);
		InputStream is = sendSocket.getInputStream();
		OutputStream os = sendSocket.getOutputStream();
		byte[] buf = new byte[1024];
		int length = -1;
		while ((length = is.read(buf)) != -1) {
			os.write(buf, 0, length);
		}
		os.close();
		is.close();
		sendSocket.close();
	}
}
