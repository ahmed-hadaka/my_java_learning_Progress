import java.util.Scanner;
import java.util.ArrayList;

public class BearStore {
    ArrayList<Bear> bears = new ArrayList<Bear>();

    public void addStdBears(int num) {
        for (int i = 0; i < num; i++) {
            bears.add(new Bear("Acme", "brown teddy"));
        }
    }

    public void addUserSpecifiedBears(int num) {
        for (int i = 0; i < num; i++) {
            bears.add(getUserSpecifiedBear());
        }
    }

    public Bear getUserSpecifiedBear() {
        Scanner SC = new Scanner(System.in);
        System.out.println("enter bear's maker:");
        String maker = SC.next();
        System.out.println("enter bear's type:");
        String type = SC.next();

        return new Bear(maker, type);
    }

    public void displayInventory() {
        for (Bear bear : bears) {
            bear.display();
        }
    }
}