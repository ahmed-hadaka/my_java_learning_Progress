import java.util.Scanner;
public class largest_prime_number{
    public static void main(String[] args) {
   
        Scanner sc =new Scanner(System.in);
        float num,largestNumber=0;
        System.out.println("enter Ur numbers or press 0 to quite");
        num=sc.nextFloat();
        if(num!=0){
            while(num!=0){
                if(num>=largestNumber){
                    largestNumber=num;
                } 
                num=sc.nextFloat();
            }
            System.out.println("the largest number is :" +largestNumber);
            System.out.println("thank U for Ur time");
        }
        else
        System.out.println("thank U for Ur time");


    }
}