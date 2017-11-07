package b_udp;

public class ChatMain {
	public static void main(String[] args) {
		
		ChatSender sender = new ChatSender();
		sender.start();
		
		
		Thread thread = new Thread(new ChatReceive());
		thread.start();
	}
}
