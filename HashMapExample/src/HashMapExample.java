import java.util.TreeMap;


public class HashMapExample {
    public static void printWordFrequency(String[] words) {
        TreeMap<String, Integer> wordMap = new TreeMap<>();
        for (String word : words) {
            if (!wordMap.containsKey(word)) {
                wordMap.put(word, 1);
            } else {
                int currentCount = wordMap.get(word);
                wordMap.replace(word, currentCount + 1);
            }
        }

        wordMap.forEach((word, count) -> {
            System.out.print(word + "|" + count.toString() + ", ");
        });
    }

    public static void main(String[] args) {
        String[] words = {"abc", "bcd", "cde", "abc"};
        printWordFrequency(words);
    }
}
