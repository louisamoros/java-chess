package socket;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;
import java.util.Observable;

public class SocketReceiver extends Observable implements Runnable {

	private SocketManager socketManager;
	private Object data = null;

	public SocketReceiver(SocketManager socketManager) {
		this.socketManager = socketManager;
	}

	@Override
	public void run() {

		Socket socket = socketManager.getSocket();
		ObjectInputStream inStream = null;

		while (true) {
			try {
				inStream = new ObjectInputStream(socket.getInputStream());
				data = inStream.readObject();
			} catch (IOException e) {
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}

			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			if (data != null) {
				setChanged();
				notifyObservers(data);
			}
		}
	}

	public Object getData() {
		return this.data;
	}
}
