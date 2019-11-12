import java.util.Set;
import java.util.TreeMap;

public class TopKLargestExercise {

    public static Set findTopKLargest(int[] arr, int k) {
        TreeMap<Integer, Boolean> tracker = new TreeMap<>();
        for (int i : arr) {
            if (tracker.size() < k) {
                tracker.put(i, true);
            } else {
                int smallest = tracker.firstKey();
                if (i > smallest) {
                    tracker.remove(smallest);
                    tracker.put(i, true);
                }
            }
        }

        return tracker.keySet();
    }

    public static void main(String[] args) {
        int[] in = {11 ,2, 302, 201 , 87, 5};
        Set largestThree = findTopKLargest(in, 2);
        largestThree.forEach((Object num) -> {
            System.out.println((int) num);
        });
    }

}
