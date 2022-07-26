package RecursiveApplications;

public class Tower {
    public static void main(String[] args) {
        doTower(3, 'A', 'B', 'C');
    }

    public static void doTower(int n, char from, char inter, char to) {  // 1
        if (n == 1) {
            System.out.println("form " + from + "to " + to);
        } else {
            doTower(n - 1, from, to, inter);
            System.out.println("form " + from + "to " + to);
            doTower(n - 1, inter, from, to);
        }
    }
}
