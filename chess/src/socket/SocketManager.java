package socket;

import java.io.IOException;
import java.io.ObjectOutputStream;
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

	public void send(Object data) {

		//PrintWriter out;
		ObjectOutputStream outputStream;

		try {
			/*out = new PrintWriter(socket.getOutputStream());
			out.println(data);
			out.flush();*/
			outputStream = new ObjectOutputStream(socket.getOutputStream());
			outputStream.writeObject(data);		
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void receive(Object data)
	{
		data = socketReceiver.getData();		
	}
	
	public Socket getSocket(){
		return this.socket;
	}

}
