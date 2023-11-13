package socketprogramming;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class ServerSide {
	Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		ServerSide clientSide = new ServerSide();
		clientSide.go(5000);
	}

	private void go(int portNumber) {
		ServerSocket serverSocket = null;
		Socket communicationSocket = null;
		InputStreamReader inputStreamReader = null;
		BufferedReader bufferedReader = null;
		String recievedData = "";
		try {
			serverSocket = new ServerSocket(portNumber);
			System.out.println("server starts!");
			communicationSocket = serverSocket.accept();
			System.out.println("server accepts a connection from " + communicationSocket.getLocalAddress());
			do {
				inputStreamReader = new InputStreamReader(communicationSocket.getInputStream());
				bufferedReader = new BufferedReader(inputStreamReader);
				recievedData = bufferedReader.readLine();
				System.out.println("the message is: " + recievedData);
			} while (!recievedData.equals("end"));

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
