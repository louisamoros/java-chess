package socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
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
			out = new PrintWriter(socket.getOutputStream());
			out.println(data);
			out.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public String waitForData()
	{
		BufferedReader in = null;
		String data = null;
		
		while(true)
		{
			try {
				in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			} catch (IOException e) {
				e.printStackTrace();
			}
			if(in != null)
			{
				try {
					data = in.readLine();
				} catch (IOException e) {
					e.printStackTrace();
				}
				
				return data;
			}
		}
	}
	
	public Socket getSocket(){
		return this.socket;
	}

}
