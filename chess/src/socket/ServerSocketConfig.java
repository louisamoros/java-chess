package socket;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerSocketConfig implements SocketConfig{

	@Override
	public Socket config() {
		
		Socket socket = null;
		
		try {
			ServerSocket serverSocket = new ServerSocket(1000);
			System.out.println("Server is ready.");
			socket = serverSocket.accept();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return socket;
	}
	
	

}
