import java.util.Scanner;
public class avgandsum{
    public static void main(String[] args) {
   
        Scanner sc =new Scanner(System.in);
double  sum=0;
float num=1;
double avg;
int x=0,flag=0;
System.out.println("enter ur numbers to sum , once U finished or wan't leave...press 0 ");
num=sc.nextFloat();
if(num!=0){
    for( x=1;num!=0;x++){
        sum+=num;           
        num=sc.nextFloat();         
    }
    System.out.println("the sum is : " +sum);
    flag=1;
}
System.out.println("thanks for Ur time");
if(flag==1){
    System.out.println("do U want the avarege :  yas/ no ?");
    String answer=sc.next();
    if(answer=="yas"){
        avg= sum/x;
        System.out.println("the avarege is" +avg);
    }
    else{
        System.out.println("thanks for Ur time");

    }

}

}
    


}
