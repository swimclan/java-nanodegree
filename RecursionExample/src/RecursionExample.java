public class RecursionExample {
    public static void printPermutn(int[] arr, int index) {
        if (index == arr.length - 1) {
            System.out.println(arr[index]);
        } else {
            printPermutn();
        }
    }
}
