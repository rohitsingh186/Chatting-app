import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class MyServer {

	public static void main(String[] args) throws IOException {
		
		int port = 80;
		
		try (ServerSocket service = new ServerSocket(port)) {
			
			System.out.println("***** Server Started. waiting for connection. *****");
			
			while (true) {
				
				Socket socket = service.accept();
				
				Thread aClient = new ChatProcessor(socket);
				aClient.start();
				
			}
			
		}
		
	}
	
}
