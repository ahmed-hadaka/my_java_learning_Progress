
import java.util.Scanner;
public class first_prog {
   public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int fnum,snum,sum ;
        System.out.println("enter fnum");
        fnum=input.nextInt();
        System.out.println("entet snum");
        snum=input.nextInt();
        sum=fnum+snum;
        System.out.printf("Ur sum is :%d",sum);
        System.out.println("entet Ur salary");
        float salary=input.nextFloat();
        float salaryafter= salary - (salary * 0.10f);
        System.out.printf("Ur salary afrter deSCound is :%f",salaryafter);




        
    }
    
}

    