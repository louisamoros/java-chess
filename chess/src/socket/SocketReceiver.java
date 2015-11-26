package socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.Observable;

public class SocketReceiver extends Observable implements Runnable {

	private SocketManager socketManager;
	private String data = null;

	public SocketReceiver(SocketManager socketIO) {
		this.socketManager = socketIO;
	}

	@Override
	public void run() {
		
		Socket socket = socketManager.getSocket();
		BufferedReader in = null;
		
		while(true)
		{
			try {
				in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
				data = in.readLine();
			} catch (IOException e) {
				e.printStackTrace();
			}
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			if(data != null)
			{
				setChanged();
				notifyObservers(data);
			}
		}
	}
	
	public String getData(){
		return this.data;
	}
}
