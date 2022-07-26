import java.util.Scanner;
public class switch_case2 {
    public static void main(String[] args) {
        char ch;
        Scanner input=new Scanner(System.in);
        System.out.println("enter character to test");
        ch=input.next().charAt(0);
        switch(ch){
            case'a':
            case'e':
            case'i':
            case'o':
            case'u':System.out.println("vowel character");
            break;
            default:
            System.out.println("not vowel characte");

        }


    }
    
}
