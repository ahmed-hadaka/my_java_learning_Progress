package Exercises;

/**
 * Reverse the order of a stack Using 1 additional Queue.
 *
 * AhmedHadaka
 */
public class ReverseThe_OrderOf_TheStack_II {

    static int size = 3;

    public static void main(String[] args) {
        QueueX Queue = new QueueX(size);
        StackX Stack = new StackX(size);

        for (int i = size; i > 0; i--) { // fill first stack
            Stack.push(i);
        }

//        Stack.display();
        translate(Stack, Queue);

        Stack.display();

    }

    public static void translate(StackX s1, QueueX q1) {
        while (!s1.isEmpty()) {
            q1.insert(s1.pop());
        }
        while (!q1.isEmpty()) {
            s1.push((int) q1.remove());
        }

    }
}
