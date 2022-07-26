import java.util.regex.Pattern;

public class MetaCharExample {
    public static void main(String[] args) {
        System.out.println("metacharacter d .... (one digit)");
        System.out.println(Pattern.matches("\\d", "abc")); // false
        System.out.println(Pattern.matches("\\d", "1")); // true
        System.out.println(Pattern.matches("\\d", "12")); // false
        System.out.println(Pattern.matches("\\d", "12cb")); // false

        System.out.println("metacharacter D ....( one non-digit )");
        System.out.println(Pattern.matches("\\D", "x")); // true
        System.out.println(Pattern.matches("\\D", "1")); // false
        System.out.println(Pattern.matches("\\D", "sdf")); // false
        System.out.println(Pattern.matches("\\D", "sf12")); // false
        System.out.println("metacharacter D with * ....((0 or more)non-digit )");
        System.out.println(Pattern.matches("\\D*", "x")); // true
        System.out.println(Pattern.matches("\\D*", "sdf")); // true
        System.out.println(Pattern.matches("\\D*", "sf12")); // false


    }
}
