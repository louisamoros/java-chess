package socket;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;

public class SocketManager {
	
	private Socket socket;
	private Thread rX;
	public SocketReceiver socketReceiver;
	public SocketConfig socketConfig;
	
	public void config() {
		socket = socketConfig.config();
		socketReceiver = new SocketReceiver(this);
		rX = new Thread(socketReceiver);
		rX.start();
	}

	public void send(String data) {

		PrintWriter out;

		try {
			//System.out.println(data);
			out = new PrintWriter(socket.getOutputStream());
			//System.out.println(data);
			out.println(data);
			out.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void receive(String data)
	{
		data = socketReceiver.getData();		
	}
	
	public Socket getSocket(){
		return this.socket;
	}

}
