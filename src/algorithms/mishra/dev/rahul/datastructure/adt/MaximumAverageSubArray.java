/**
 * 
 */
package algorithms.mishra.dev.rahul.datastructure.adt;

import java.util.Scanner;

/**
 * http://www.ideserve.co.in/learn/maximum-average-subarray
 * 
 * @author Rahul Dev Mishra
 * @assignment
 * @date 13-Jun-2017 9:44:11 PM
 *
 */
public class MaximumAverageSubArray {

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
		System.out.println("Enter the length of subarray: ");
		int subArrayLength = scanner.nextInt();
		System.out.println("Maximum Average Subarray: " + findMaximumAverageSubarray(array, subArrayLength));
		System.out
				.println("Maximum Average Subarray: " + findMaximumAverageSubarraySlidingWindow(array, subArrayLength));
		scanner.close();
	}

	private static int findMaximumAverageSubarray(int[] array, int k) {
		int maxSum = Integer.MIN_VALUE;
		for (int i = 0; i < array.length; i++) {
			if (i + k <= array.length - 1) {
				int temp = k;
				int sum = 0;
				while (temp > 0) {
					sum += array[i + temp];
					temp--;
				}
				maxSum = maxSum > sum ? maxSum : sum;
			}

		}
		return maxSum;
	}

	/**
	 * For example array = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10] and k = 3. Add the first 3 elements i.e. 1, 2, and 3
	 * Next add 4 to the sum and subtract 1 from the sum, thereby maintaining the sum of k elements only.
	 * Next add 5 and remove 2 from the sum, so on and so forth.
	 * 
	 * @param array
	 * @param k
	 * @return
	 */
	private static int findMaximumAverageSubarraySlidingWindow(int[] array, int k) {
		int maxSum = 0;
		int sum = 0;
		for (int i = 0; i < array.length; i++) {
			// Find the sum of first k elements, and then start the sliding window concept
			if (i <= k - 1) {
				sum += array[i];
				maxSum = sum;
				continue;
			}
			// After k indices, add the i+k index and remove the i-k index value from sum, thereby maintaining the sum of k elements
			
			sum += array[i] - array[i - k];
			maxSum = maxSum > sum ? maxSum : sum;
		}
		return maxSum;
	}

}
