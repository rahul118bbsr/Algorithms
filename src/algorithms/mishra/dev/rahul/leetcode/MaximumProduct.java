/**
 * 
 */
package algorithms.mishra.dev.rahul.leetcode;

import java.util.Scanner;

/**
 * https://leetcode.com/contest/leetcode-weekly-contest-38/problems/maximum-product-of-three-numbers/
 * 
 * @author Rahul Dev Mishra
 * @assignment  
 * @date 25-Jun-2017 12:14:45 PM
 *
 */
public class MaximumProduct {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the number of elements: ");
		int n = scanner.nextInt();
		int[] array = new int[n];
		System.out.println("Enter the numbers: ");
		for(int i = 0; i < n; i++) {
			array[i] = scanner.nextInt();
		}
		scanner.close();
		System.out.println("Maximum Product is: " + findMaximumProduct(array));

	}
	
	private static int findMaximumProduct(int[] array) {
		int result = 1;
		int min = Integer.MAX_VALUE;
		for(int i = 0; i < array.length; i++) {
			result *= array[i];
			min = min < array[i] ? min : array[i];
		}
		return min == 0 ? 0 : result / min;
	}

}
