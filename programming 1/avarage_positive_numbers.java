
/*****************************************************************************************************
# avarage_positive_numbers.

# Ahmed Hadaka .

# This program is an application on arrays which give U the avarage of enter's positive numbers.
******************************************************************************************************/
import java.util.Scanner;
public class avarage_positive_numbers{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int count = 0, size;
        double sum = 0;
        System.out.println("enter the numbers of elements");
        size = sc.nextInt();
        double[] avarage =new double[size];
        for (int i = 0; i < size; i++) {
            System.out.println("enter the number no :"+ (i+1));
            avarage[i] = sc.nextDouble();
            if (avarage[i] > 0) {
                sum += avarage[i];
                count++;
            }
        }
            System.out.println("the avarage of positive numbers is :"+ (sum/count));
}
        
   
}
