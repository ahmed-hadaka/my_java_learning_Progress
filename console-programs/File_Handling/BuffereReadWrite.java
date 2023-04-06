package filesAndstreams;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

public class BuffereReadWrite {

	public static void main(String[] args) {
		try {
			// ----- buffer Reader -------
			BufferedReader br = new BufferedReader(new FileReader("Dir1//file1.txt"));
			String line;
			while ((line = br.readLine()) != null) {
				System.out.println(line);
			}
			br.close();
			// ----- buffer Writer ------
			BufferedWriter bw = new BufferedWriter(new FileWriter("Dir1//file2.txt"));
			bw.write("start writing");
			bw.newLine();
			int n = 5;
			while (--n > 0) {
				bw.write(String.valueOf(n));
				bw.newLine();
			}
			bw.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
