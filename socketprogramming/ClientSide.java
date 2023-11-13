package socketprogramming;

import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class ClientSide {
	Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		ClientSide serverSide = new ClientSide();
		serverSide.go("127.0.0.1", 5000);
	}

	private void go(String ipAddress, int port) {
		Socket communicationSocket = null;
		String sentData = "";
		PrintWriter printWriter = null;

		try {
			communicationSocket = new Socket(ipAddress, port);
			System.out.println("Client sent a connection request to the server!");

			do {
				printWriter = new PrintWriter(communicationSocket.getOutputStream());
				sentData = scanner.nextLine();
				printWriter.println(sentData);
				printWriter.flush();
			} while (!sentData.equals("end"));

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
