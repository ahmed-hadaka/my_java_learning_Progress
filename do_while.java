import java.util.Scanner;
public class do_while {
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        float num1,num2 ,square;
        int option;
        do{
            System.out.println("select Ur choice from the menue\n1- for adding two numbers\n2- for subtract two numbers\n3- for square number\n4- for find the root for number\n5- for exit\n");
            option =sc.nextInt();
            switch(option){
                case 1:
                System.out.println("enter two numbers");
                num1 =sc.nextFloat();
                num2 =sc.nextFloat();
                System.out.printf("the sum is%f", num1+num2);
                break;
                case 2:
                System.out.println("enter two numbers");
                num1 =sc.nextFloat();
                num2 =sc.nextFloat();
                System.out.printf("the result is%f", num1-num2);
                break;

                case 3:
                System.out.println("enter number");
                num1 =sc.nextFloat();
                System.out.printf("the square is%f",num1*num1);
                break;

                case 4:
                System.out.println("enter numbers");
                num1 =sc.nextFloat();
               square=(float)Math.sqrt(num1);
                System.out.printf("the root is%f", square);
                break;

                case 5:
                System.out.println("goodbye");
                break;

            }
            }
            while(option!=5);
    }
    
}
