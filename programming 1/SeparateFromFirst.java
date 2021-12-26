import java.util.Scanner;
public class SeparateFromFirst{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);    //separating from the first.  
        System.out.println("enter your number");
        int k = sc.nextInt();
        int x = k / 10000;
        System.out.print(x+"  ");
        for (int i = 1000; i >= 1; i /= 10) {
            x = k / i;
            int outPut = x% 10;
            System.out.print( outPut+"  ");
        }
    }
}