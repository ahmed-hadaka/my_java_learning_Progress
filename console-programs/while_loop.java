import java.util.Scanner;
public class while_loop {
    public static void main(String[] args) {
        Scanner Sc=new Scanner(System.in);
        float sum=0 ,grade;
        int number ,count=1;
        System.out.println(" enter the number of students");
        number=Sc.nextInt();
        while(count<=number){
            System.out.println(" enter the grade for student no"+count);
            grade=Sc.nextFloat();
            sum+=grade;
            count++;
        }
        System.out.printf(" the avarege of grades is %f" , sum/number);

    }
    
}
