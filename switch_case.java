import java.util.Scanner;
public class switch_case {
   public static void main(String[] args) {
       char choice;
       float num1 ,num2;
       Scanner input=new Scanner(System.in);
       System.out.println("enter Ur choice");
       System.out.println("1- add two numbers");
       System.out.println("2- subtract two numbers");
       System.out.println("3- square num");
       choice =input.next().charAt(0);
       switch(choice)
      { 
         case '1':
         System.out.println("enter two numbers");
         num1=input.nextFloat();
         num2=input.nextFloat();
         System.out.println(num1+num2);
         break;

         case '2':
         System.out.println("enter two numbers");
         num1=input.nextFloat();
         num2=input.nextFloat();
         System.out.println(num1-num2);
         break;

         case '3':
         System.out.println("enter positive num");
         num1=input.nextFloat();
         if(num1>0)
         System.out.println(num1*num1);
         else 
         System.out.println("not positive num");
         break;
         default:
         System.out.println("invalid choice");

   }

    }
    
}
