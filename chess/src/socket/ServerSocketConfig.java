package socket;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerSocketConfig implements SocketConfig{

	@Override
	public Socket config() {
		
		try {
			ServerSocket serverSocket = new ServerSocket(5000);
			System.out.println("Server is ready.");
			Socket socket = serverSocket.accept();
			return socket;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	

}
