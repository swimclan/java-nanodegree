public class BinarySearchExample {
    public static int findTarget(int[] arr, int target) {
        int startIndex = 0;
        int endIndex = arr.length - 1;
        int prevMidIndex = 0;

        while(true) {
            int midIndex = (int) Math.round((endIndex - startIndex) / 2) + startIndex;
            if (midIndex == prevMidIndex) {
                return -1;
            }
            prevMidIndex = midIndex;
            if (arr[startIndex] == target) {
                return startIndex;
            } else if (arr[endIndex] == target) {
                return endIndex;
            }
            else if (arr[midIndex] == target) {
                return midIndex;
            } else if (target > arr[midIndex]) {
                startIndex = midIndex;
            } else if (target < arr[midIndex]) {
                endIndex = midIndex;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {2, 4, 5, 7, 8, 9, 12, 15, 19, 24, 29};
        System.out.println(findTarget(arr, 5));
    }
}
