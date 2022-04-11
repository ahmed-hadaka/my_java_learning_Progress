package RecursiveApplications;

public class threeN_Series {
    public static void main(String[] args) {
        threeN_Series(22);
    }
    public static int threeN_Series(int n) {  // 3
        if (n == 1)
            return 1;
        if (n % 2 == 0)
            return 1 + threeN_Series(n / 2);

        return 1 + threeN_Series(3 * n + 1);
    }
}

