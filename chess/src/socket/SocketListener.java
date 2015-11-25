package socket;

import java.net.Socket;

public class SocketListener implements Runnable{
	
	private Socket socket;
	
	public SocketListener(Socket socket) {
		this.socket = socket;
	}

	@Override
	public void run() {
		
	}

}
