import java.util.Scanner;
public class quadratic_eq {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter your variables a , b ,c  by this order");
        double v1 = sc.nextDouble();
        double v2 = sc.nextDouble();
        double v3 = sc.nextDouble();

        //check v1

       boolean CHECK_v1= check_v1(v1);
       if (CHECK_v1) 
           System.out.println("unvalid equation , (a) can't be zero");
       else {
           double Calc_squ = calc_squ(v1, v2, v3);
           System.out.println(Calc_squ);

           //check squ
           boolean Check_squ = check_squ(Calc_squ);
           if (Check_squ)
               System.out.println("this equation doesn't hava a real roots");
           else {
               print_root(v2, v1, Calc_squ);
           }

       }

    }


    public static boolean check_v1(double v1) {   //function check v1
        if (v1 == 0)
            return true;
        else
            return false;
    }

    public static double calc_squ(double v1, double v2, double v3) {        //function calculating the squre root
        double d = (v2 * v2) - (4 * v1 * v3);
        double squ_d = Math.sqrt(d);
        return squ_d;
    }
     

    public static boolean check_squ(double squ) {           //function check the squre root
        if (squ < 0)
            return true;
        else 
            return false;
     }

     public static void print_root(double v2,double v1,double  squ) {           //function print the root of equation directly
        double root1 = (-v2 - squ) / (2 * v1);
        double root2 = (-v2 + squ) / (2 * v1);
        System.out.println("root 1 is : " + root1);
        System.out.println("root 2 is : " + root2);
    }







   
}
