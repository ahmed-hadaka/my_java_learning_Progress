package Exercises.PalindromeTest;

/**
 * Write a program that determines whether an input string is a palindrome; that
 * is, whether it can be read the same way forward and backward, At each point,
 * you can read only one character of the input string, Consider using multiple
 * stacks
 *
 * @AhmedHadaka
 */
public class PalindromeTesterApp {

    public static void main(String[] args) {
        String word = "kayak";
        PalindromeTester tester = new PalindromeTester();

        System.out.println(tester.testPalindrome(word));
    }
}
