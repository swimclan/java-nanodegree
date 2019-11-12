public class ReverseExercise {

    public static String reverseString(String s) {
        StringBuilder sb = new StringBuilder(s);

        StringBuilder reversSb = sb.reverse();

        return reversSb.toString();

    }

    public static void main(String[] args) {
        System.out.println(reverseString("Hello, World!"));
    }
}
