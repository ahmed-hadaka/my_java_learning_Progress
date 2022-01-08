
/*******************************************************************************
# Project_Progrm.

# Ahmed Hadaka .

# This is my project in my first term of studying Software Engineering in my college.
# It's consist of three parts [Calculator - Array Operations - Quadratic Equation]
*******************************************************************************/ 


import java.util.Scanner;
import java.util.InputMismatchException;

public class Project_Program {

    static int width, highst, widtha, widthb;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Welcome To Our program !");
        System.out.println(
                "Enter You Section Do U Want .. \n 1- Calculator Section \n 2- Array Operations Section \n 3- Quadratic Equation Section \n 4- to exit");
        String Chioce = sc.next();

        while (Chioce.length() > 1 || Chioce.charAt(0) != '1' && Chioce.charAt(0) != '2'
                && Chioce.charAt(0) != '3' && Chioce.charAt(0) != '4') {
            System.out.println("Invalid choise ... Try again");
            Chioce = sc.next();
        }

        switch (Chioce.charAt(0)) {
            case '1': {
                //----
                System.out.println("Welcome To Calculator's Section");
                System.out.println(
                        "Enter Number Of Operation Do You Want \n 1- ( + ).\n 2- ( - ).\n 3- ( * ).\n 4- ( / ).\n 5- To Exit");
                String Chioce2 = sc.next();

                while (Chioce2.length() > 1
                        || Chioce2.charAt(0) != '1' && Chioce2.charAt(0) != '2' && Chioce2.charAt(0) != '3'
                                && Chioce2.charAt(0) != '4' && Chioce2.charAt(0) != '5') {
                    System.out.println("Invalid choise ... Try again");
                    Chioce = sc.next();
                }

                switch (Integer.parseInt(Chioce2)) {
                    case 1: {

                        System.out.println(getAddition(getFirstInputs(), getSecondInputs()));
                        break;
                    }
                    case 2: {

                        System.out.println(getSubtraction(getFirstInputs(), getSecondInputs()));
                        break;
                    }
                    case 3: {

                        System.out.println(getMultiplication(getFirstInputs(), getSecondInputs()));
                        break;
                    }
                    case 4: {
                        double firstNumber = getFirstInputs();
                        double secondNumber = getSecondInputs();
                        if (secondNumber == 0) {
                            System.out.println("Can't devide by zero");
                        } else
                            System.out.println(getDivision(firstNumber, secondNumber));
                        break;
                    }
                }
                System.out.println("\n THANK YOU FOR YOUR TIME :) COME AGIAN");
                break;
            }

            case '2': {

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
                        int numColumns = takeNumOfcolumns();

                        //inputs for first array 
                        int[][] A = inputsFirstArray(numRows, numColumns);

                        //inputs for Second array 
                        int[][] B = inputsSecondArray(numRows, numColumns);

                        //implement Subtracion operation
                        int[][] C = new int[numRows][numColumns];
                        System.out.println(implementSubtracion(A, B, C));

                        //print the result array
                        Print_resultArray(C, numRows, numColumns);
                        break;
                    }
                    case 4: {
                        System.out.println("Thank U For Ur time :)");
                        break;
                    }
                }

                break;
            }
            case '3': {

                System.out.println("Welcom To Quadratic Equation's section");

                System.out.println("enter your variables a , b ,c  by this order");
                double v1 = checkInput2();
                double v2 = checkInput2();
                double v3 = checkInput2();

                //check v1 is't = 0
                boolean CHECK_v1 = check_v1(v1);
                if (CHECK_v1)
                    System.out.println("unvalid equation , (a) can't be zero");
                else {
                    double calcNumberUnderSqr = calc_numOfSqu(v1, v2, v3);

                    //check Number under Squre root  is't < 0
                    boolean Check_squ = check_numOfSqu(calcNumberUnderSqr);
                    if (Check_squ)
                        System.out.println(
                                "this equation doesn't hava a real roots , these values evaluate to a negative number under the squre root");
                    else {
                        double Sqr = Math.sqrt(calcNumberUnderSqr);
                        print_root(v2, v1, Sqr);
                    }
                }

            }  
    }
 }

    // Calculation functions' section----------------------------------------------------------------------------------------------------

    //get first input
    public static double getFirstInputs() {
        System.out.println("Enter Your First Number");
        double num1 = checkInput1();
        return num1;
    }

    //get second input
    public static double getSecondInputs() {
        System.out.println("Enter Your Second Number");
        double num2 = checkInput1();
        return num2;
    }

    //get addition 
    public static double getAddition(double num1, double num2) {
        double sum = num1 + num2;
        return sum;
    }

    //get Subtraction 
    public static double getSubtraction(double num1, double num2) {
        double sub = num1 - num2;
        return sub;
    }

    //get Multiplication 
    public static double getMultiplication(double num1, double num2) {
        double mult = num1 * num2;
        return mult;
    }

    //get division 
    public static double getDivision(double num1, double num2) {
        double div = num1 / num2;
        return div;
    }

      //check input
      public static double checkInput1() {
        Scanner sc = new Scanner(System.in);
        double input=0;
        boolean checker;
        do {
            try {
                input = sc.nextDouble();
                checker = false;
            } catch (InputMismatchException e) {
                System.out.println("invalid intry .. try agian");
                checker = true;
                sc.next();
            }
        } while (checker);
        return input;
    }

    // Array functions section ------------------------------------------------------------------------------------------------------------------*/ 

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
        int[][] B = new int[numRows][numColumns];
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
        int input = 0;
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
    // Quadratic Equation functions' section-------------------------------------------------------------------------------------

    public static boolean check_v1(double v1) {   //function check v1
        if (v1 == 0)
            return true;
        else
            return false;
    }

    public static double calc_numOfSqu(double v1, double v2, double v3) { //function calculating result number under the squre root
        double d = (v2 * v2) - (4 * v1 * v3);
        return d;
    }
    
    public static boolean check_numOfSqu(double calc_numOfSqu) {            //function check the result number under the squre root
        if (calc_numOfSqu < 0)
            return true;
        else 
            return false;
     }

     public static void print_root(double v2, double v1, double sqr) { //function print the root of equation directly
         double root1 = (-v2 - sqr) / (2 * v1);
         double root2 = (-v2 + sqr) / (2 * v1);
         System.out.println("root 1 is : " + root1);
         System.out.println("root 2 is : " + root2);
     }
    
      //check input
    public static double checkInput2() {
        Scanner sc = new Scanner(System.in);
        double input=0;
        boolean checker;
        do {
            try {
                input = sc.nextDouble();
                checker = false;
            } catch (InputMismatchException e) {
                System.out.println("invalid intry .. try agian");
                checker = true;
                sc.next();
            }
        } while (checker);
        return input;
    }

}
