import java.util.regex.Pattern;

public class Quantifiers {
    public static void main(String[] args) {
        System.out.println("? quantifiers .... ( 0 or 1 )");
        System.out.println(Pattern.matches("[xyz]?", "x")); // true
        System.out.println(Pattern.matches("[xyz]?", "zzz")); // false
        System.out.println(Pattern.matches("[xyz]?", "xyyz")); // false
        System.out.println(Pattern.matches("[xyz]?", "xmy")); // false
        System.out.println(Pattern.matches("[xyz]?", "xyz")); // false
        System.out.println("+ quantifiers ....( 1 or more )");
        System.out.println(Pattern.matches("[xyz]+", "x")); // true
        System.out.println(Pattern.matches("[xyz]+", "xxyy")); // true
        System.out.println(Pattern.matches("[xyz]+", "xxx")); // true
        System.out.println(Pattern.matches("[xyz]+", "xmty")); // false tm not from the range xyz
        System.out.println("* quantifiers ....( 0 or more )");
        System.out.println(Pattern.matches("[xyz]*", "xxyyzzz")); // true


    }
}
