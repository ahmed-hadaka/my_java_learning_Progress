package filesAndstreams;

import java.io.File;
import java.io.FileWriter;

public class mkDir {
	public static void main(String[] args) {
		try {
			File dir = new File("Dir1");
			dir.mkdir();
			String path = dir.getAbsolutePath();
			FileWriter file1 = new FileWriter(path + "//file1.txt");
			FileWriter file2 = new FileWriter(path + "//file2.txt");
			FileWriter file3 = new FileWriter(path + "//file3.txt");
			file1.write("file1 here");
			file2.write("file2 here");
			file3.write("file3 here");
			String[] dirContent = dir.list();
			for (String string : dirContent) {
				System.out.println(string);
			}
			file1.close();
			file2.close();
			file3.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
