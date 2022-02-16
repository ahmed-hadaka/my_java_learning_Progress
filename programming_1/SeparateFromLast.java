import java.util.Scanner;

public class SeparateFromLast {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int y = 10;
        System.out.println("enter number from 5 digite");
        int k = sc.nextInt();
        int x = k % y;
        System.out.print(x+"  ");

        for (int i = 10; i <= 10000; i = i * 10) {
            y = y * 10;
            x = k % y;
            int outPut = x / i;

            System.out.print(outPut+"  ");
        }
    }
}
