/**
 * 
 */
package algorithms.mishra.dev.rahul.datastructure.search;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author Rahul Dev Mishra
 * @assignment
 * @date 11-Jun-2017 10:13:51 AM
 *
 */
public class BinarySearch {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the number of elements: ");
		int n = scanner.nextInt();
		int[] array = new int[n];
		System.out.println("Enter the elements: ");
		for (int i = 0; i < n; i++) {
			array[i] = scanner.nextInt();
		}
		System.out.println("Enter the number to search: ");
		Arrays.sort(array);
		search(array, scanner.nextInt(), 0, array.length - 1);
		scanner.close();
	}

	private static void search(int[] array, int key, int start, int end) {
		if (array == null || array.length == 0) {
			System.out.println("Array is either null or it has no elements!!!");
			return;
		}
		int mid = start + ((end - start) / 2);

		if (mid >= start && mid <= end) {
			if (key == array[mid]) {
				System.out.println("Element found at index " + mid);
				return;
			} else if (key < array[mid]) {
				search(array, key, start, mid - 1);
			} else if (key > array[mid]) {
				search(array, key, mid + 1, end);
			}
		} else {
			System.out.println("Element was not found in the array...");
			return;
		}
	}

	public int binarySearch(int[] inputArr, int key) {
		int start = 0;
		int end = inputArr.length - 1;
		while (start <= end) {
			int mid = (start + end) / 2;
			if (key == inputArr[mid]) {
				return mid;
			}
			if (key < inputArr[mid]) {
				end = mid - 1;
			} else {
				start = mid + 1;
			}
		}
		return -1;
	}
}
