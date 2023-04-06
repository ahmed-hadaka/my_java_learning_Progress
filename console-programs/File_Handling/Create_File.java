import java.io.File;

public class Create_File {
    public static void main(String[] args) {
        try {
            File myFile = new File("C:\\Users\\mf\\Desktop\\File_No_1");
            if (myFile.createNewFile()) {
                System.out.println("File Created Successfully" + myFile.getName());
            } else {
                System.out.println("File is already exists.");
            }
        } catch (Exception e) {
            System.out.println("An error occurred");
        }

    }
}
