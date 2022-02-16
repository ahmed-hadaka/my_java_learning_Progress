
/*******************************************************************************
#  while_loop2 .

# Ahmed Hadaka .

# This is an application on  while_loop .
*******************************************************************************/

import java.util.Scanner;
public class while_loop2 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        double sum=0.0 ,number;
        System.out.println("enter Ur numbers to add or enter negative number to exit");
        number=sc.nextDouble();
        while(number>0){
            sum+=number;
            System.out.println("the sum in " + sum);
            System.out.println("enter the next number");
            number=sc.nextDouble();

        }
    }
    
}
