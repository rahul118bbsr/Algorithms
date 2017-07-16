package algorithms.mishra.dev.rahul.leetcode;

/**
 * Created by aleesha on 13/07/17.
 */
public class BinarySearch {
    public static void main(String[] args) {
        int[] array = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11};
        System.out.println(search(array, 0));
        System.out.println(search(array, 11));
        System.out.println(search(array, 5));

    }

    public static int search(int[] array, int key) {
        int low = 0, high = array.length - 1;
        while(low <= high) {
            int mid = low + (high - low) / 2;
            if(array[mid] == key) {
                return mid;
            } else if(key < array[mid]) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }
}
