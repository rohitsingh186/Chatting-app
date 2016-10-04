import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;

public class ChatReciever extends Thread {
	
	Socket socket;
	
	public ChatReciever(Socket socket) {
		this.socket = socket;
	}
	
	@Override
	public void run() {
		
		try {
			
			System.out.println("***** Reciever started. *****");
			System.out.println("***** Reciever waiting for recieving message. *****");
			
			
			// READING FROM SERVER
			InputStreamReader isr = new InputStreamReader(socket.getInputStream());
			BufferedReader bReader = new BufferedReader(isr);
			
			String s;
			
			while(true) {
				s = bReader.readLine();
				
				/*if (s.length() == 0) {
					break;
				}*/
				
				if (s.length() != 0) {
					System.out.println("Recieved: " + s);
				}
				
			}
				
			
			/*bReader.close();
			isr.close();*/
			
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
}
