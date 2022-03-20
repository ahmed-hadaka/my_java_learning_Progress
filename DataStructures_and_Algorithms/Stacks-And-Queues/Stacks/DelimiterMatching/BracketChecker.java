package Stacks.DelimiterMatching;

public class BracketChecker {

    private String input;

    public BracketChecker(String input) {
        this.input = input;
    }

    public void checkStr() {
        Stack1 stk = new Stack1(input.length());
        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);

            switch (ch) {
                case '{', '[', '(' ->
                    stk.push(ch);

                case '}', ']', ')' -> {
                    if (!stk.isEmpty()) {
                        char chr = stk.pop();
                        if (ch == '}' && chr != '{'
                                || ch == ']' && chr != '['
                                || ch == ')' && chr != '(') {
                            System.out.println("Error: " + ch + "at " + i);
                        }
                    }
                }
            }
        }
        if (!stk.isEmpty()) {
            System.out.println(stk.pop() + " missing left delimiter! ");
        }
    }
}
