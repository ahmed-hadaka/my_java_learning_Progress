package Exercises;

/**
 * Reverse the order of a stack Using 1 additional Stack and non-array
 * variables.
 *
 * AhmedHadaka
 */
public class ReverseThe_OrderOf_TheStack_III {

    static int size = 4;

    public static void main(String[] args) {
        StackX stack1 = new StackX(size); // target stack
        StackX stack2 = new StackX(size - 1); // helper stack

        for (int i = 1; i <= size; i++) { // fill first stack
            stack1.push(i);
        }
//        stack1.display();

        translate(stack1, stack2);
        stack1.display();
    }

    public static void translate(StackX s1, StackX s2) {
        int temp;
        int nElems = size - 1;

        for (int i = 0; i < size - 1; i++) {
            temp = s1.pop();
            for (int j = 0; j < nElems; j++) {
                s2.push(s1.pop());
            }
            s1.push(temp);
            nElems--;
            while (!s2.isEmpty()) {
                s1.push(s2.pop());
            }
        }
    }
}
