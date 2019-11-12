import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringBuilderExample {

    public static String vowelOnly(String input) {
        StringBuilder sb = new StringBuilder(input);
        Pattern vowelPattern = Pattern.compile("[AaEeIiOoUu]");

        StringBuilder sbOut = new StringBuilder();

        for (int i = 0; i < sb.length(); i++) {
            Character testChar = sb.charAt(i);
            Matcher vowelMatcher = vowelPattern.matcher(testChar.toString());
            if (vowelMatcher.matches()) {
                sbOut.append(testChar);
            }
        }
        return sbOut.toString();
    }

    public static void main(String[] args) {
        System.out.println(vowelOnly("Issue"));
    }
}
