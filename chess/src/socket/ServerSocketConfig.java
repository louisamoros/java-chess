package socket;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerSocketConfig implements SocketConfig{

	private ServerSocket serverSocket;

	@Override
	public Socket config() {
		
		Socket socket = null;
		
		try {
			serverSocket = new ServerSocket(5000);
			System.out.println("Server is ready.");
			socket = serverSocket.accept();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return socket;
	}
	
	

}
