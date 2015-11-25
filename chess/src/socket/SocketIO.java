package socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketIO {
	
	private Socket socket;
	private BufferedReader in;
	private PrintWriter out;
	public SocketConfig socketConfig;

	public void config()
	{
		socket = socketConfig.config();
	}
	
	public void send(String data) {
		try {
			out = new PrintWriter(socket.getOutputStream());
			out.println(data);
	        out.flush();
		} catch (IOException e) {
			e.printStackTrace();
		} 
	}

	public String receive() {
		
		String message = null;
		
		try {
			in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			message = in.readLine();
			System.out.println(message);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return message;
		
	}
	
}
