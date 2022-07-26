
/*******************************************************************************
# calc_avg_and_sum

# Ahmed Hadaka

# This program calculate avarage and summation for unlimited numbers
*******************************************************************************/
import java.util.Scanner;
public class calc_avg_and_sum{
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        double sum = 0;
        float num = 1;
        double avg;
        int x = 0, flag1 = 0,flag2=0;
        String answer;
        System.out.println("enter ur numbers to sum , once U finished or wan't leave...press 0 ");
        num = sc.nextFloat();
        if (num != 0) {
            for (x = 1; num != 0; x++) {
                sum += num;
                num = sc.nextFloat();
            }
            System.out.println("the sum is : " + sum);
            flag1 = 1;
        }
        System.out.println("thanks for Ur time");
        if (flag1 == 1) {
            do{
            System.out.println("do U want the avarege :  yas/ no ?");
            answer = sc.next();
            if (answer.equalsIgnoreCase("yas")) {
                avg = sum / x;
                System.out.println("the avarege is" + avg);
                System.out.println("FINISHED");
                flag2 = 0;
            }
            else if (answer.equalsIgnoreCase("no")) {
                System.out.println("thanks for Ur time");
                flag2 = 0;
            }
            else {
                flag2=1;
                System.out.println("unvaliad choice");
            } 
        } while (flag2 == 1);

        }
   }
}



