import java.util.Scanner;
import java.util.InputMismatchException;
public class largest_prime_number{
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int largest = 1;
        System.out.println("Enter your numbers ( negative number to quit )");
        int num = inputsCheker();
        if (num >= 0) {
            while (num >= 0) {
                if (isPrimeNumber(num)) {
                    if (num > largest) {
                        largest = num;
                    }
                }
                num = inputsCheker();
            }
            if (largest == 1) {
                System.out.println("No prime numbers were entered");
            } else
                System.out.println("The largest prime number = " + largest);
        } else
            System.out.println("Thank you for your time");
    }

    
    public static boolean isPrimeNumber(int num) {
        boolean isPrime = true;
        for (int i = 2; i < num; i++) {
            if (num % 2 == 0) {
                isPrime = false;
                break;
            }
            isPrime = true;
        }
        return isPrime;
    }


   public static int inputsCheker() 
      {
          Scanner sc = new Scanner(System.in);
          int i=0,cheker=0;
          do {
            try{
                  i= sc.nextInt();
                  cheker =0;
                  }
                  catch(InputMismatchException e)
                {
                       System.err.println("Invalid entry \n Try again");
                       sc.next();
                       cheker =1;
                }
        }
          while(cheker ==1);
          return i;
      }
      
    }