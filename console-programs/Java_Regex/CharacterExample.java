import java.util.regex.Pattern;

public class CharacterExample {
    public static void main(String[] args) {
        System.out.println(Pattern.matches("[xyz]", "wbcd")); // false (not x or y or x )
        System.out.println(Pattern.matches("[xyz]", "y")); // true y
        System.out.println(Pattern.matches("[xyz]", "xyyzz")); // false (not single character and duplicated)
    }
}
