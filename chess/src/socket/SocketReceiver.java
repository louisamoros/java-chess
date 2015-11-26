package socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.net.Socket;
import java.util.Observable;

public class SocketReceiver extends Observable implements Runnable {

	private SocketManager socketManager;
	private Object data = null;

	public SocketReceiver(SocketManager socketIO) {
		this.socketManager = socketIO;
	}

	@Override
	public void run() {
		
		Socket socket = socketManager.getSocket();
		//BufferedReader in = null;
		ObjectInputStream inStream = null;
		
		while(true)
		{
			try {
				//in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
				//data = in.readLine();
				inStream = new ObjectInputStream(socket.getInputStream());
				data = inStream.readObject();
			} catch (IOException e) {
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
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
	
	public Object getData(){
		return this.data;
	}
}
