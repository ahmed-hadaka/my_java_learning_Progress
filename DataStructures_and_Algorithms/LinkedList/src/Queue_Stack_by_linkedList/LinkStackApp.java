package Queue_Stack_by_linkedList;

/**
 *
 * @AhmedHadaka
 */
public class LinkStackApp {

    public static void main(String[] args) {
        LinkStack stack = new LinkStack();

        stack.push(20); 
        stack.push(40);
        System.out.println(stack.toString()); 
        stack.push(60); 
        stack.push(80);
        System.out.println(stack.toString()); 
        stack.pop(); 
        stack.pop();
        System.out.println(stack.toString());
    }
}
