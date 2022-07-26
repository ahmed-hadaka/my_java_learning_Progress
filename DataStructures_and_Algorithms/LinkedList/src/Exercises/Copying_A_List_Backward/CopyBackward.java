package Exercises.Copying_A_List_Backward;

/**
 *
 * @AhmedHadaka
 */
public class CopyBackward {

    LinkStack stack = new LinkStack();

    public void reverseCopy(DoubleLinkedList list) {
        while (!list.isEmpty()) {
            stack.push(list.deleteFirst());
        }
        while (!stack.isEmpty()) {
            list.insertFirst(stack.pop().getIData());
        }
    }
}
