import java.util.Scanner;

public class factorial_to_any_number {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // int i,j=1,number,check=1;
        // double factorial=1;
        // while(check!=2){
        // System.out.printf("press 1 to continue or prees 2 to exit\n");
        // check=sc.nextInt();
        // while(check!=1 && check!=2){
        // System.out.printf("unvalid choise\n");
        // check=sc.nextInt();
        // }
        // if(check==1){
        // System.out.printf("enter the number to git factorial\n");
        // number=sc.nextInt();
        // {
        // while(number<0){
        // System.out.printf("enter positive number\n");
        // number = sc.nextInt();
        // }
        // for(i=1;i<=number;i++){
        // factorial=factorial*i;
        // }
        // System.out.printf("factorial is"+factorial);
        // System.out.printf("\n");
        // factorial=1;
        // }

        // }
        // }
        int factorial = 1;
        System.out.println("enter the number to git the factorial ");
        int num = sc.nextInt();
        for (int i = 1; i <= num; i++) {
            factorial = factorial * i;
        }
        System.out.println(factorial);

    }
}
