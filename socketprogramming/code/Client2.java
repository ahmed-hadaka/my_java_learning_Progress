package socketprogramming.code;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client2 {

	Scanner scanner = new Scanner(System.in);
	String message = null;
	Socket socket = null;
	PrintWriter printWriter = null;
	InputStreamReader inputStreamReader = null;
	BufferedReader bufferedReader = null;

	public static void main(String[] args) {
		Client2 client2 = new Client2();
		client2.setup("127.0.0.1", 5000);
		Thread thread = new Thread(client2.new ReadRunnable());
		thread.start();
		client2.write();
	}

	private void setup(String ipHost, int port) {
		try {

			socket = new Socket(ipHost, port);
			printWriter = new PrintWriter(socket.getOutputStream());
			inputStreamReader = new InputStreamReader(socket.getInputStream());
			bufferedReader = new BufferedReader(inputStreamReader);

		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("client2 started!");

	}

	private void write() {
		do {
			message = scanner.nextLine();
			printWriter.println(message);
			printWriter.flush();
		} while (!message.equals("end"));
	}

	public class ReadRunnable implements Runnable {
		String message = "";

		@Override
		public void run() {
			try {
				do {
					message = bufferedReader.readLine();
					System.out.println("input: " + message);
				} while (!message.equals("end"));

			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}

}
