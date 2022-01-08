//mine

import java.util.InputMismatchException;
import java.util.Scanner;
public class Array_Operations1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Welcome To Array Operations Section !");
        System.out.println(
                "Enter the number of Operation you wanna implement \n 1- ( + ) \n 2- ( * ) \n 3- ( - ) \n 4- to exit");
        String operation = sc.next();
        while (operation.length() > 1 || operation.charAt(0) != '1' && operation.charAt(0) != '2'
                && operation.charAt(0) != '3' && operation.charAt(0) != '4') {
            System.err.println("Invalid choise \n Try again");
            operation = sc.next();
        }

        //first condition for add operation----------------------------------------------------------------------------------------------
        switch (Integer.parseInt(operation)) {
            case 1: {
                int numRows = takeNumOfRows();
                int numColumns = takeNumOfcolumns();

                //inputs for first array 
                int[][] A = inputsFirstArray(numRows, numColumns);

                //inputs for Second array 
                int[][] B = inputsSecondArray(numRows, numColumns);

               

                //implement addition operation
                int[][] C = new int[A.length][A[0].length];
                System.out.println(implementAddition(A, B, C));

                //print the result array
                Print_resultArray(C, A.length, A[0].length);
                break;
            }
            // Second Operation Miltiplication --------------------------------------------------------------------------------------------

            case 2: {
                // take the size 1
                int numRowsA = takeNumOfRows();
                int numColumnsA = takeNumOfcolumns();

                //inputs for first array 
                int[][] A = inputsFirstArray(numRowsA, numColumnsA);

                // // take the size 2
                int numRowsB = numColumnsA;
                int numColumnsB = takeNumOfcolumns();

                //inputs for Second array 
                int[][] B = inputsSecondArray(numRowsB, numColumnsB);

                //implement Array multiplication
                int[][] C = new int[numRowsA][numColumnsB];
                System.out.println(implementMultiplication(A, B, C));

                //print the result array 
                Print_resultArray(C, numRowsA, numColumnsB);
                break;
            }
            // Third Operation Subtracion------------------------------------------------------------------------------------------
            case 3: {

                 //take the size
                int numRows = takeNumOfRows();
                int numColumns= takeNumOfcolumns();

                //inputs for first array 
                int[][] A = inputsFirstArray(numRows, numColumns);


                //inputs for Second array 
                int[][] B = inputsSecondArray(numRows, numColumns);


                //implement Subtracion operation
                int[][] C = new int[numRows][numColumns];
                System.out.println(implementSubtracion(A, B, C));

                //print the result array
                Print_resultArray(C, numRows,numColumns);
                break;
            }
            case 4: {
                System.out.println("Thank U For Ur time :)");
                break;
            }
        }
    }

    // Functions' section  --------------------------------------------------------------------------------------

    //take number of rows
    public static int takeNumOfRows() {
        System.out.println(
                "Inter Number Of Rows For Your Arrays");
        int numRows = checkInput();
        return numRows;
    }
    
     //take number of columns
     public static int takeNumOfcolumns() {
         System.out.println(
                 " Inter Number Of Columns For Your Arrays");
         int numColumns = checkInput();
         return numColumns;
     }
    
     //inputs for first Array
     public static int[][] inputsFirstArray(int numRows, int numColumns) {
         int[][] A = new int[numRows][numColumns];
         for (int r = 0; r < A.length; r++) {
             for (int c = 0; c < A[0].length; c++) {
                 System.out.println("enter element no " + r + c + " in the first array");
                 int element = checkInput();
                 A[r][c] = element;
             }
         }
         return A;
     }
     
     //inputs for second Array
     public static int[][] inputsSecondArray(int numRows, int numColumns) {
        int[][] B =  new int[numRows][numColumns];
        for (int r = 0; r < B.length; r++) {
            for (int c = 0; c < B[0].length; c++) {
                System.out.println("enter element no " + r + c + " in the second array");
                int element = checkInput();
                B[r][c] = element;
            }
        }
        return B;
     }

    // implement Addition function
    public static int[][] implementAddition(int[][] A, int[][] B, int[][] C) {
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A[0].length; j++) {
                C[i][j] = A[i][j] + B[i][j];
            }
        }
        return C;
    }

    //implement Subtracion function
    public static int[][] implementSubtracion(int[][] A, int[][] B, int[][] C) {
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A[0].length; j++) {
                C[i][j] = A[i][j] - B[i][j];
            }
        }
        return C;
    }

    //implement Multiplication function
    public static int[][] implementMultiplication(int[][] A, int[][] B, int[][] C) {
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < B[0].length; j++) {
                // C[i][j] = 0;    it's in vian , coz whene U created a new array C and specified it's width, the compiler gave the element value by zero
                for (int k = 0; k < A[0].length; k++) {
                    C[i][j] += (A[i][k] * B[k][j]);
                }
            }
        }
        return C;
    }

    //check input
    public static int checkInput() {
        Scanner sc = new Scanner(System.in);
        int input=0;
        boolean checker;
        do {
            try {
                input = sc.nextInt();
                checker = false;
            } catch (InputMismatchException e) {
                System.out.println("invalid intry .. try agian");
                checker = true;
                sc.next();
            }
        } while (checker);
        return input;
    }

    //print the result Array's function
    public static void Print_resultArray(int[][] k, int numRows, int numColumns) {
        System.out.println(" the result Array is :- ");
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < numColumns; j++) {
                System.out.print(k[i][j] + "  ");
            }
            System.out.println();
        }

    }
}
