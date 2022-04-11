package RecursiveApplications;
/*
* this program calc the power of any integer num, with
* time complexity O(logN ) instead O(n)
* @ author Ahmed_Hadaka
* */
import java.util.Scanner;

public class Raising_A_Number_To_A_Power {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter your base:");
        int x = sc.nextInt();
        System.out.println("Enter your power:");
        int y = sc.nextInt();

        if (y < 0) {
            System.out.print("the result is : ");
            System.out.format("%.4f" , (1 / doPower(x, Math.abs(y))));
        }
        else {
            System.out.println("the result is : " + doPower(x, y));
        }
    }

    public static double doPower(int x, int y) {
        if (y == 0)
            return 1;
        if (y == 1)
            return x;
        if (y % 2 == 0)
            return doPower(x * x, y / 2);
        return x * doPower(x * x, y / 2);
    }


}
