package RecursiveApplications;

public class printBits {
    public static void main(String[] args) {
        printBits(214);
    }

    public static void printBits(int n) {
        if (n <= 0) return;
        printBits(n / 2);
        System.out.print(n % 2);
    }
}
