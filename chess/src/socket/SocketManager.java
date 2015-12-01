package socket;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Observer;

public class SocketManager {

	private Socket socket;
	private Thread rX;
	private SocketReceiver socketReceiver;
	private SocketConfig socketConfig;

	public SocketManager(boolean isServer) {
		if (isServer) {
			// instanciate socketio / server config
			socketConfig = new ServerSocketConfig();
		} else {
			// instanciate socketio / client config
			socketConfig = new ClientSocketConfig();
		}
	}
	
	public void config() {
		socket = socketConfig.config();
		socketReceiver = new SocketReceiver(this);
		rX = new Thread(socketReceiver);
		rX.start();
	}

	public void send(Object data) {

		// PrintWriter out;
		ObjectOutputStream outputStream;

		try {
			outputStream = new ObjectOutputStream(socket.getOutputStream());
			outputStream.writeObject(data);

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void setObserver(Observer o) {
		socketReceiver.addObserver(o);
	}

	public void receive(Object data) {
		data = socketReceiver.getData();
	}

	public Socket getSocket() {
		return this.socket;
	}

}
