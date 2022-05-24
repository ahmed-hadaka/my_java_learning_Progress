import java.util.List;

public class ArrayList {

    public static void main(String[] args) {
        java.util.ArrayList<Integer> numbers = new java.util.ArrayList<Integer>();

        // Adding
        numbers.add(10);
        numbers.add(100);
        numbers.add(40);

        // Retrieving
        System.out.println(numbers.get(0));

        System.out.println("nIteration #1: ");
        // Indexed for loop iteration
        for (int i = 0; i < numbers.size(); i++) {
            System.out.println(numbers.get(i));
        }

        // efficient for each loop iteration
        for (Integer number : numbers) {
            System.out.println(number);
        }

        // Removing items (careful!)
        numbers.remove(numbers.size() - 1);

        // This is VERY slow
        numbers.remove(0);

        System.out.println("nIteration #2: ");
        for (Integer value : numbers) {
            System.out.println(value);
        }

        // List interface ...
        List<String> values = new java.util.ArrayList<String>();
    }
}