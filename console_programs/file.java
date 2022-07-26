
/*****************************************************************************************************
# learning files.

# Ahmed Hadaka .

# This program enable the user to defines his own array with flexibility and search in it.
******************************************************************************************************/
import java.io.*;
import java.util.Scanner;

public class file {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in); // Global Scanneer

        // creat file

        try {
            File file1 = new File("file1.txt");
            File file2 = new File("file2.txt");
            if (file1.createNewFile() && file2.createNewFile()) {

                System.out.println("file is created ! " + file1.getName());
                System.out.println("file is created ! " + file2.getName());
            } else {
                System.out.println("file is already exists !");
            }

            // write into file

            // try {
            // FileWriter myfile = new FileWriter("text.txt");
            // myfile.write("this my first time to type into into a file 2, done!");
            // myfile.close();
            // System.out.println("successfully wrote to the file");

            // } catch (Exception ex) {
            // System.out.println(ex.getMessage());
            // }

            // read from a file

            // try {
            // System.out.println("enter your file name");
            // Scanner myReader = new Scanner(new FileReader(sc.nextLine()));
            // // File myFile = new File("text.txt");
            // // Scanner myReader = new Scanner(myFile);
            // while (myReader.hasNextLine()) {
            // String data = myReader.nextLine();
            // System.out.println(data);
            // }
            // myReader.close();
            // } catch (Exception ex) {
            // System.out.println(ex.getMessage());
            // }

            // take copy from a file into another one

            FileInputStream sourceFile = new FileInputStream(file1);
            FileOutputStream targetFile = new FileOutputStream(file2);
            int byteValue;
            while ((byteValue = sourceFile.read()) != -1) {
                targetFile.write(byteValue);
            }
            sourceFile.close();
            targetFile.close();
            System.out.println("file copied success");

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }
}
