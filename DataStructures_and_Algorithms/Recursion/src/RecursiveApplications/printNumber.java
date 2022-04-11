package RecursiveApplications;

public class printNumber {
    public static void main(String[] args) {
        printNumber(214);
    }
    public static void printNumber(int n) {
        if (n <= 0) return;
        printNumber(n / 10);
        System.out.print(n % 10);
    }
}
