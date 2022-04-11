package Exercises;

/**
 * Put the elements on the stack S in ascending order using one additional stack
 * and some additional non-array variables
 *
 * AhmedHadaka;
 */
public class OrderTheStack {

    static int size = 3;

    public static void main(String[] args) {

//        Stack<Integer> inputStack = new Stack <>();
//        Stack <Integer> auxStack = new Stack <>();
        StackX inputStack = new StackX(size);
        StackX auxStack = new StackX(size);

        inputStack.push(2);
        inputStack.push(1);
        inputStack.push(3);

//        inputStack.display();
        doOrder(inputStack, auxStack);
        inputStack.display();

    }

    public static void doOrder(StackX inputStack, StackX auxStack) {
        int temp;
        while (!inputStack.isEmpty()) {
            temp = inputStack.pop();
            while (!auxStack.isEmpty() && auxStack.peek() > temp) {
                inputStack.push(auxStack.pop());
            }
            auxStack.push(temp);

        }
        while (!auxStack.isEmpty()) {
            inputStack.push(auxStack.pop());
        }
    }

}
