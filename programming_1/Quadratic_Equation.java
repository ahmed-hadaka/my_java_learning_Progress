import java.util.InputMismatchException;
import java.util.Scanner;
public class Quadratic_Equation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter your variables a , b ,c  by this order");
        double v1 = checkInput();
        double v2 =checkInput();
        double v3 = checkInput();

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
// functions' section  ----------------------------------------------------------------------------------------------------------------------
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
    public static double checkInput() {
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
