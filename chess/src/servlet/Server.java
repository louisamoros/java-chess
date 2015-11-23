package servlet;

import java.io.IOException;
import java.net.*;

public class Server {

	public static void main(String[] args) {
		ServerSocket serverSocket;
		
		try {
			serverSocket = new ServerSocket(5000);
			Thread thread = new Thread(new AcceptClient(serverSocket));
			thread.start();
			System.out.println("Server is ready.");
		} catch(IOException e){
			e.printStackTrace();
		}

	}

}
