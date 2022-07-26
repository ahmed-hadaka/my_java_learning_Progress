import java.io.FileWriter;

public class Write_File {
	public static void main(String[] args) {
		try {
			FileWriter myFile = new FileWriter("File_No_1");
			myFile.write("Hello! this my first inputs into this file, Is it appears now!\n");
			myFile.write("Hello 2! this my first inputs into this file, Is it appears now!");
			myFile.close();
			System.out.println("Successfully wrote to the file.");
		} catch (Exception e) {
			System.out.println("An error occurred");
			e.printStackTrace();
		}

	}
}
