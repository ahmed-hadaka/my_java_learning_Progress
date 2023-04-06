import java.util.Scanner;
public class selecteNegativePositiveZero {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter five numbers");
        double num1=sc.nextDouble();
        double num2=sc.nextDouble();
        double num3=sc.nextDouble();
        double num4=sc.nextDouble();
        double num5 = sc.nextDouble();
        double numNegative=0.0;
        double numPositive=0.0;
        double numZero=0.0;
        double[] store ={num1,num2,num3,num4,num5};
        for (int count = 0; count < 5; count++) {
            if (store[count] < 0) {
                numNegative++;
            } else if (store[count] > 0) {
                numPositive++;
            } else {
                numZero++;
            }
        }
    System.out.println("number of positeve inputs is :" + (int)numPositive +"\n" + "number of negative inputs is :"
   + (int)numNegative  +"\n"+ "number of zero inputs is :"+(int)numZero);
        }
    }

