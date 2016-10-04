import java.io.IOException;
import java.net.Socket;

public class MyClient {

	public static void main(String[] args) throws IOException {
				
		Socket socket = new Socket("localhost", 80);
		
		Thread aClient = new ChatProcessor(socket);
		aClient.start();
		
	}
	
}
