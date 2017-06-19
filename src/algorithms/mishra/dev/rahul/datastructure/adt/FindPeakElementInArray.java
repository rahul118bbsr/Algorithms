/**
 * 
 */
package algorithms.mishra.dev.rahul.datastructure.adt;

import java.util.Scanner;

/**
 * http://www.ideserve.co.in/learn/find-a-peak-element-in-an-array Given an array of size n, find a peak element in the array. 
 * Peak element is the element which is greater than or equal to its neighbors. 
 * For example - In Array {1,4,3,6,7,5}, 4 and 7 are peak elements. We need to return any one
 * peak element.
 * 
 * @author Rahul Dev Mishra
 * @assignment
 * @date 03-Jun-2017 10:29:46 AM
 *
 */
public class FindPeakElementInArray {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the number of elements: ");
		int[] array = new int[scanner.nextInt()];
		System.out.println("Enter the array elements: ");
		for (int i = 0; i < array.length; i++) {
			array[i] = scanner.nextInt();
		}
		scanner.close();
		findPeakElement(array);
	}

	private static void findPeakElement(int[] array) {
		System.out.println("Peak Elements: ");
		int i = 1;
		while (i < array.length && i + 1 < array.length) {
			if (array[i] > array[i - 1] && array[i] > array[i + 1]) {
				System.out.println(array[i]);
				i = i + 1;
			} else {
				i++;
			}
		}
	}
}
