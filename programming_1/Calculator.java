import java.util.Scanner;
import java.util.InputMismatchException;
public class Calculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Welcome To Calculator's Section");
        System.out.println(
                "Enter Number Of Operation Do You Want \n 1- ( + ).\n 2- ( - ).\n 3- ( * ).\n 4- ( / ).\n 5- To Exit");
        String Chioce = sc.next();

        while (Chioce.length() > 1 || Chioce.charAt(0) != '1' && Chioce.charAt(0) != '2' && Chioce.charAt(0) != '3'
                && Chioce.charAt(0) != '4'  && Chioce.charAt(0) != '5'  ) {
            System.out.println("Invalid choise ... Try again");
            Chioce = sc.next();
        }
        
        switch (Integer.parseInt(Chioce)) {
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
                double firstNumber=getFirstInputs();
                double secondNumber = getSecondInputs();
                if (secondNumber==0) {
                    System.out.println("Can't devide by zero");
                }else
                System.out.println(getDivision(firstNumber, secondNumber));
                break;
            }
        }
        System.out.println("\n THANK YOU FOR YOUR TIME :) COME AGIAN");
    }
    // Calculation functions' section----------------------------------------------------------------------------------------------------

    //get first input
    public static double getFirstInputs() {
        System.out.println("Enter Your First Number");
        double num1 = inputsCheker();
        return num1;
    }

    //get second input
    public static double getSecondInputs() {
        System.out.println("Enter Your Second Number");
        double num2 = inputsCheker();
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
      static double inputsCheker() 
      {
          Scanner sc = new Scanner(System.in);
          double i=0,cheker=0;
          do {
            try{
                  i= sc.nextDouble();
                  cheker =0;
                  }
                  catch(InputMismatchException e)
                {
                       System.err.println("Invalid choise \n Try again");
                       sc.next();
                       cheker =1;
                }
        }
          while(cheker ==1);
          return i;
      }
      
    }


