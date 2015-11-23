package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class AcceptClient implements Runnable{
	
	private ServerSocket serverSocket;
	private Socket socket;
	private PrintWriter out;
	private int nbrClients;
	
	public AcceptClient(ServerSocket serverSocket) {
		this.serverSocket = serverSocket;
	}
	
	public void run() {
		try {
			while(true) {
				socket = serverSocket.accept();
				out = new PrintWriter(socket.getOutputStream());
				out.println("Client number " + nbrClients + " is connected.");
				out.flush();
				nbrClients++;
				socket.close();
			}
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
}
