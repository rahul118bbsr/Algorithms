/**
 * 
 */
package algorithms.mishra.dev.rahul.datastructure.search;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author Rahul Dev Mishra
 * @assignment
 * @date 11-Jun-2017 8:18:18 PM
 *
 */
public class QuickSort {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the num of elements: ");
		int n = scanner.nextInt();
		System.out.println("Enter the elements: ");
		int[] array = new int[n];
		for (int i = 0; i < n; i++) {
			array[i] = scanner.nextInt();
		}
		scanner.close();
		System.out.print("Before Sorting: ");
		Arrays.stream(array).forEach(i -> System.out.print(i + ", "));
		sort(array, 0, array.length - 1);
		System.out.println("");
		System.out.print("After Sorting: ");
		Arrays.stream(array).forEach(i -> System.out.print(i + ", "));
	}

	private static void sort(int[] array, int low, int high) {
		if (array == null || array.length == 0) {
			System.out.println("Array is either null or doesn't have any elements in it to sort!!!");
			return;
		}

		if (low > high) {
			return;
		}

		int i = low;
		int j = high;
		int pivot = array[low + (high - low) / 2];
		while (i <= j) {
			while (array[i] < pivot) {
				i++;
			}

			while (array[j] > pivot) {
				j--;
			}

			if (i <= j) {
				int temp = array[j];
				array[i] = array[j];
				array[j] = temp;
				i++;
				j--;
			}
		}
		
		if(i < high) {
			sort(array, i, high);
		}
		
		if(j > low) {
			sort(array, low, j);
		}
	}
}
