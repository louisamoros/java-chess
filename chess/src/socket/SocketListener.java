package socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.Observable;

public class SocketListener extends Observable implements Runnable {

	private SocketManager socketManager;

	public SocketListener(SocketManager socketIO) {
		this.socketManager = socketIO;
	}

	@Override
	public void run() {
		
		Socket socket = socketManager.getSocket();
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
				
				notifyObservers(data);
			}
		}
	}
}
