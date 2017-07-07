/**
 * 
 */
package algorithms.mishra.dev.rahul.hackerrank.problems.warmup;

import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/mini-max-sum
 * 
 * Given five positive integers, find the minimum and maximum values that can be calculated by summing exactly four of the five integers. 
 * Then print the respective minimum and maximum values as a single line of two space-separated long integers.
 * 
 * @author Rahul Dev Mishra
 * @assignment  
 * @date 11-Jun-2017 12:30:35 PM
 *
 */
public class MinMaxSum {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the number of elements: ");
		int n = scanner.nextInt();
		System.out.println("Enter the elements: ");
		int[] array = new int[n];
		for(int i = 0; i < n; i++) {
			array[i] = scanner.nextInt();
		}
		scanner.close();
		printMinMaxSum(array);
	}

	private static void printMinMaxSum(int[] array) {
		long sum = 0;
		long min = Long.MAX_VALUE;
		long max = Long.MIN_VALUE;
		for(int i = 0; i < array.length; i++) {
			sum += array[i];
			min = min <= array[i] ? min : array[i];
			max = max >= array[i] ? max : array[i];
		}
		
		System.out.println("Max Sum: " + (sum - min));
		System.out.println("Min Sum: " + (sum - max));
	}
}
