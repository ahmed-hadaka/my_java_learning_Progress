
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
        int x = 0, flag = 0;
        char answer;
        System.out.println("enter ur numbers to sum , once U finished or wan't leave...press 0 ");
        num = sc.nextFloat();
        if (num != 0) {
            for (x = 1; num != 0; x++) {
                sum += num;
                num = sc.nextFloat();
            }
            System.out.println("the sum is : " + sum);
            flag = 1;
        }
        System.out.println("thanks for Ur time");
        if (flag == 1) {
            System.out.println("do U want the avarege :  y/ n ?");
            answer = sc.next().charAt(0);

            switch (answer)
             {
            case 'y':
            case 'Y':
                avg = sum / x;
                System.out.println("the avarege is" + avg);
                break;

            case 'n':
            case 'N':
                System.out.println("thanks for Ur time");
                break;
            default:

                while (answer != 'y' && answer != 'Y' && answer != 'n' && answer != 'N') {
                    System.out.println("unvaliad choice");
                    answer = sc.next().charAt(0);
                }  
       
            if (answer == 'y' || answer == 'Y' || answer == 'n' || answer == 'N') {
                    
                switch (answer) {
                    case 'y':
                    case 'Y':
                        avg = sum / x;
                        System.out.println("the avarege is" + avg);
                break;
                    case 'n':
                    case 'N':
                        System.out.println("thanks for Ur time");

                break;
                    default:
                        System.out.println("");

                }
            }
    

                

            }

        }
   }
}



