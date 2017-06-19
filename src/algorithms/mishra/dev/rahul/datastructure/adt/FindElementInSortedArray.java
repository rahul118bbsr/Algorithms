/**
 * 
 */
package algorithms.mishra.dev.rahul.datastructure.adt;

import java.util.Scanner;

/**
 * http://www.ideserve.co.in/learn/find-an-element-in-a-sorted-rotated-array
 * Given a sorted integer array which is rotated any number of times and an
 * integer num, find the index of num in the array. If not found, return -1.
 * 
 * @author Rahul Dev Mishra
 * @assignment
 * @date 13-Jun-2017 5:03:38 PM
 *
 */
public class FindElementInSortedArray {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the number of elements: ");
		int n = scanner.nextInt();
		System.out.println("Enter the elements in a sorted manner: ");
		int[] array = new int[n];
		for (int i = 0; i < n; i++) {
			array[i] = scanner.nextInt();
		}
		System.out.println("Enter the element to find: ");
		int key = scanner.nextInt();
		scanner.close();
		System.out.println("Found the elemnt " + key + " at index: " + findElementUsingBinarySearch(array, key));
	}
	
	// Find an element in a sorted rotated array without finding pivot
	public static int findElementUsingBinarySearch(int[] array, int num) {
		if (array == null || array.length == 0) {
			return -1;
		}
		int start = 0;
		int end = array.length - 1;
		while (start <= end) {
			int mid = (start + end) / 2;
			if (num == array[mid]) {
				return mid;
			}
			if (array[start] <= array[mid]) { // array[start...mid] is sorted
				if (array[start] <= num && num <= array[mid]) { // num lies between array[start...mid]
					end = mid - 1;
				} else {
					start = mid + 1;
				}
			} else { // array[mid...end] is sorted
				if (array[mid] <= num && num <= array[end]) { // num lies between array[mid...end]
					start = mid + 1;
				} else {
					end = mid - 1;
				}
			}
		}
		return -1;
	}
}
