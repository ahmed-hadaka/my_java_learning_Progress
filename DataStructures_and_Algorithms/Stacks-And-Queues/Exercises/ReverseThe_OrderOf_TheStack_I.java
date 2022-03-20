package Exercises;

/**
 * Reverse the order of a stack Using 2 additional stacks.
 *
 * AhmedHadaka;
 */
public class ReverseThe_OrderOf_TheStack_I {

    static int size = 3;

    public static void main(String[] args) {
        StackX stack1 = new StackX(size);
        StackX stack2 = new StackX(size);
        StackX stack3 = new StackX(size);

        for (int i = size; i > 0; i--) { // fill first stack
            stack1.push(i);
        }
//        stack1.display();

        translate(stack1, stack2);
        translate(stack2, stack3);
        translate(stack3, stack1);
        stack1.display();

    }

    public static void translate(StackX s1, StackX s2) {
        while (!s1.isEmpty()) {
            s2.push(s1.pop());
        }
    }
}
