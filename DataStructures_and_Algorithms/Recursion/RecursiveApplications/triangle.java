package RecursiveApplications;

public class triangle {
    public static void main(String[] args) {
        triangle(6);
    }

    public static void triangle(int n) {  // 2
        if (n == 0) return;
        for (int i = 0; i < n; i++) {
            System.out.print('*');
        }
        System.out.println(" ");

        triangle(n - 1);
    }
}
