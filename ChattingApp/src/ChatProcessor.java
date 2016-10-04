import java.net.Socket;

public class ChatProcessor extends Thread {
	
	Socket socket;
	
	public ChatProcessor(Socket socket) {
		this.socket = socket;
	}
	
	@Override
	public void run() {
		
		Thread sender = new ChatSender(socket);
		Thread reciever = new ChatReciever(socket);
		
		sender.start();
		reciever.start();
		
	}
	
	
}
