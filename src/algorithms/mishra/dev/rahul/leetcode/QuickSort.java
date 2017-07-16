package algorithms.mishra.dev.rahul.leetcode;

/**
 * Created by aleesha on 13/07/17.
 */
public class QuickSort {
    public static void main(String[] args) {
        int[] inputArr = {45, 23, 11, 89, 77, 98, 4};
        new QuickSort().sort(inputArr, 0, inputArr.length - 1);
        for (int i : inputArr) {
            System.out.print(i);
            System.out.print(" ");
        }
    }

    public void sort(int[] array, int low, int high) {
        int pivot = array[low + (high - low) / 2];
        int i = low, j = high;
        while(i <= j) {
            while(array[i] < pivot) {
                i++;
            }
            while(array[j] > pivot) {
                j--;
            }
            if(i <= j) {
                swap(array, i, j);
                i++;
                j--;
            }
        }
        if(low < j) {
            sort(array, low, j);
        }
        if(i < high) {
            sort(array, i, high);
        }
    }

    private void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
