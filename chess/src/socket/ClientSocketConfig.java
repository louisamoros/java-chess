package socket;

import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;

public class ClientSocketConfig implements SocketConfig{

	@Override
	public Socket config() {
		
		Socket socket = null;
		
		try {
			socket = new Socket("localhost", 5000);
			System.out.println("Connection requested.");
			return socket;
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return socket;
	}

}
