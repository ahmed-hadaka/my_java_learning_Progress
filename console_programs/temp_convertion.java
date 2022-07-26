import java.util.Scanner;
public class temp_convertion {
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        int input;
        Double temp1,temp2,convert1,convert2;
        System.out.println("Welcom to my programe :)\n press 1 to convert from Fahrenheit to Coelcius\n press 2 to convert from Coelcius to Fahrenheit");
        input=sc.nextInt();
        if(input==1){
            System.out.println("enter the temperature by Fahrenheit");
            temp1=sc.nextDouble();
            convert1= (temp1-32)*(0.5555555556);
            System.out.println("it's equal to :"+(convert1)+" C\n");
            System.out.println(" END! thank U for Ur time");
        }
        else if(input==2){
                System.out.println("enter the temperature by Coelcius");
                temp2=sc.nextDouble();
                convert2= (temp2*(9/5))+32;
                System.out.println("it's equal to :"+(convert2)+" F\n");
                System.out.println(" END! thank U for Ur time");

        }
        else
        System.out.println(" Oops! unvalid choice");



    }
}