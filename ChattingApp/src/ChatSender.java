import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class ChatSender extends Thread {

	Socket socket;
	
	public ChatSender(Socket socket) {
		this.socket = socket;
	}
	
	@Override
	public void run() {
		
		System.out.println("***** Sender started. *****");
		System.out.println("***** Sender waiting for sending message. *****");

		try {
			
			// WRITING ON SERVER
			PrintWriter pr = new PrintWriter(socket.getOutputStream(), true);
			String message = "";
			
			
			try (Scanner in = new Scanner(System.in)) {
				while (true) {
					
//					Scanner in = new Scanner(System.in);
					
					message = in.nextLine();
					
					if (message.length() != 0) {
						System.out.println("Sent: " + message);
						pr.println(message);
					}
					
					
				}
			}
			
//			pr.print("<html> <head/> <body> <h1> Hello world </h1> </body> </html>");
			
			
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
}
