package socketprogramming.code;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class Server {

	List<PrintWriter> clientWritersList = new ArrayList<>();

	public static void main(String[] args) {
		new Server().go(5000);
	}

	public void go(int portNum) {
		try {
			ServerSocket serverSocket = new ServerSocket(portNum);
			OutputStreamWriter outputStreamWriter = null;
			System.out.println("server started!");
			while (true) {
				Socket clientSocket = serverSocket.accept();
				System.out.println(
						"server accept a connection request from: " + clientSocket.getInetAddress().toString());
				outputStreamWriter = new OutputStreamWriter(clientSocket.getOutputStream());
				PrintWriter clientPrintWriter = new PrintWriter(outputStreamWriter);
				clientWritersList.add(clientPrintWriter);

				Thread clientThread = new Thread(new ClientHandler(clientSocket));
				clientThread.start();
			}

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public class ClientHandler implements Runnable {
		Socket clientSocket = null;
		InputStreamReader inputStreamReader = null;
		BufferedReader bufferedReader = null;
		PrintWriter printWriter = null;
		String message = null;

		public ClientHandler(Socket clientSocket) {
			this.clientSocket = clientSocket;
		}

		@Override
		public void run() {
			proccess();
		}

		private void proccess() {
			try {
				inputStreamReader = new InputStreamReader(clientSocket.getInputStream());
				bufferedReader = new BufferedReader(inputStreamReader);
				do {
					message = bufferedReader.readLine();
					System.out.println("server read: " + message);
					writeToAllClients(message);
				} while (!message.equals("end"));

			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		private void writeToAllClients(String meString) {
			for (PrintWriter printWriter : clientWritersList) {
				printWriter.println(meString);
				printWriter.flush();// mandatory
			}
		}

	}
}
