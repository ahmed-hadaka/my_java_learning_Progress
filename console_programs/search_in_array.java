
/*****************************************************************************************************
# search_in_array.

# Ahmed Hadaka .

# This program enable the user to defines his own array with flexibility and search init.
******************************************************************************************************/
import java.util.Scanner;
public class search_in_array {
    static Scanner sc = new Scanner(System.in); //Global Scanneer
    static int columns = 0, rows = 0; //Global variables
    public static void main(String[] args) 
    {
          System.out.println("enter the numbers of rows and columns");
        rows = sc.nextInt();
        columns = sc.nextInt();
        float[][] IDS = new float[rows][columns];
        fillArray(IDS);
        displAyarray(IDS);
        System.out.println("do U want search about any item... y/n");
        char answer = sc.next().charAt(0);
        if (answer == 'y' || answer == 'Y' || answer == 'n' || answer == 'N') //check for answer with if statments
        {
            switch (answer) {
            case 'y':
            case 'Y':
                System.out.println("enter the item U want search");
                float item = sc.nextFloat();
                float result = search(IDS, item);
                if (result != -1)
                    System.out.println("Ur item already here" + item);
                else
                    System.out.println("Ur item doesn't found here");
            case 'n':
            case 'N':
                System.out.println("thank U for Ur time :)");
            }
        }
        else
        System.out.println("unvalid choice ,please try again later :)");
    }
    
    public static void fillArray(float[][] array) //fill array - function
    {
        for (int R = 0; R < rows; R++)

            for (int C = 0; C < columns; C++) {
                System.out.println("enter the number no :" + (C + 1) + "in row no :" + (R + 1));
                array[R][C] = sc.nextFloat();
            }
    }
    
    public static void displAyarray(float[][] array) //display the array - function
     {
        System.out.println("Ur array is :"); 
        for  (int R = 0; R < rows;R++) 
     
            for (int C = 0 ; C <columns ; C++)
            {
                System.out.println(array[R][C]);
            }
    }
    
    public static float search(float[][] array,float target) //search in array - function
    {
        for  (int R = 0; R < rows;R++) 
   
            for (int C = 0; C < columns; C++) 
            {
                if (array[R][C] == target) 
                {
                    return target;
                }
            }
        return -1;
    }
}