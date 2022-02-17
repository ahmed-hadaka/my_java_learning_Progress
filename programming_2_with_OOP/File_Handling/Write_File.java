import java.io.File;
import java.io.FileWriter;

public class Write_File {
    public static void main(String[] args) {
        try {
            FileWriter myFile = new FileWriter("C:\\Users\\mf\\Desktop\\File_No_1");
            myFile.write("Hello! this my first inputs into this file, Is it appears now!");
            myFile.close();
            System.out.println("Successfully wrote to the file.");
        } catch (Exception e) {
            System.out.println("An error occurred");
            e.printStackTrace();
        }

    }
}
