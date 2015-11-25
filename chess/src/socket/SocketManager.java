package socket;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;

public class SocketManager {
	
	private Socket socket;
	public SocketConfig socketConfig;

	public void config() {
		socket = socketConfig.config();
	}

	public void send(String data) {

		PrintWriter out;

		try {
			System.out.println(data);
			out = new PrintWriter(socket.getOutputStream());
			System.out.println(data);
			out.println(data);
			out.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public Socket getSocket(){
		return this.socket;
	}

}