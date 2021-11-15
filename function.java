import java.util.Scanner;
public class function{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        char input_character;
        int input_length;
        System.out.println("enter Ur char");
        input_character=sc.next().charAt(0);
        System.out.println("enter Ur length");
        input_length=sc.nextInt();
        drawline(input_character,input_length);
        System.out.println("welcom to java");
        drawline(input_character,input_length);
    }

    public static void drawline(char a,int length){
        for(int i=1;i<=length;i++)
    {
System.out.print(a);
    }
    System.out.println(a);
    }

}
