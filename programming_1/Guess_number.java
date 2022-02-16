
/*******************************************************************************
# Guess_number.

# Ahmed Hadaka .

# This is a program on a Guess number challeng.
*******************************************************************************/

import java.util.Scanner;
public class Guess_number {
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        int random_number , Guess_number;
        random_number =(int)(Math.random()*100);
        System.out.println("Guess number between 0 - 100");
        Guess_number=sc.nextInt();
        while(Guess_number!=random_number){
            if (Guess_number < 0 || Guess_number>100)
            System.out.println("it's out of play");
            else if (Guess_number<random_number)
            System.out.println("it's too small ");
            else if(Guess_number>random_number)
            System.out.println("it's too large");
            Guess_number=sc.nextInt();
        }
        System.out.println("congratolation , U win");
        System.out.println(Guess_number);


        }
}
