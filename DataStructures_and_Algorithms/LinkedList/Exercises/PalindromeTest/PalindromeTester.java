package Exercises.PalindromeTest;

/**
 *
 * @AhmedHadaka
 */
public class PalindromeTester {

    private LinkStack stack1;
    private LinkStack stack2;
    private LinkStack stack3;

    public PalindromeTester() {
        stack1 = new LinkStack();
        stack2 = new LinkStack();
        stack3 = new LinkStack();
    }

    public void makeACopy(String word) {
        char[] arr = word.toCharArray();
        
        for (char item : arr) {  // fill first and second stack
            stack1.push(item);
            stack2.push(item);
        }
        while (!stack2.isEmpty()) {  // make a reversed copy into stack3
            stack3.push(stack2.pop());
        }

    }

    public boolean testPalindrome(String word) {
        int half = stack1.getLength() / 2;
        makeACopy(word);
        while (stack1.pop() == stack3.pop()) {
            if (stack1.getLength() == half) {
                return true;
            }
        }
        return false;
    }

}
