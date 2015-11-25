package socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {

	public static void main(String[] args) {
		Socket socket;
		BufferedReader in;
		
		try {
			socket = new Socket(InetAddress.getLocalHost(), 5000);
			System.out.println("Connection requested.");
			in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			String message = in.readLine();
			System.out.println(message);
			socket.close();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
