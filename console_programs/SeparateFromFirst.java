import java.util.Scanner;
public class SeparateFromFirst{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);                 //separating from the first.     
        int y = 10000;
        System.out.println("enter number from 5 digite");
        int k = sc.nextInt();
        int x = k / y;
        System.out.println(x);

        for (int i = 1; i < 10000; i = i * 10) {
            y = y / 10;
            x = k / y;
            int outPut = x % 10;

            System.out.println( outPut);
        }

        
        
       

    }
}