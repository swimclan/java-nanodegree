import java.util.HashMap;

public class TwoSums {
    public static boolean twoSum(int[] nums, int target) {
        HashMap<Integer, Boolean> checkMap = new HashMap<>();
        for (int num : nums) {
            if (checkMap.containsKey(num)) {
                return true;
            }
            int k = target - num;
            checkMap.put(k, true);
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = {1, 3, 4, 5};
        System.out.print(twoSum(nums, 2));
    }
}
