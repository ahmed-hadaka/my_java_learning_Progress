import java.io.File;

public class File_Informations {
    public static void main(String[] args) {
        File myFile = new File("C:\\Users\\mf\\Desktop\\File_No_1");
        if (myFile.exists()) {
            System.out.println("File Name: " + myFile.getName());
            System.out.println("Absolute path: " + myFile.getAbsolutePath());
            System.out.println("writeable: " + myFile.canWrite());
            System.out.println("Readabel: " + myFile.canRead());
            System.out.println("File Size In Bytes: " + myFile.length());
        } else {
            System.out.println("Sorry! the file doesn't exist");
        }
    }
}
