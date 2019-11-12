import java.util.HashMap;

public class FindFirstDuplicate {
    public static int findDuplicate(String input) {
        String[] splitInput = input.split("");
        HashMap<String, Boolean> dupMap = new HashMap<>();
        for (int i = 0; i < splitInput.length; i++) {
            if (dupMap.containsKey(splitInput[i])) {
                return i;
            }
            dupMap.put(splitInput[i], true);
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.print(findDuplicate("aghdsheioth"));
    }
}
