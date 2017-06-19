/**
 * 
 */
package algorithms.mishra.dev.rahul.hackerrank.problems.warmup;

import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/birthday-cake-candles
 * 
 * @author Rahul Dev Mishra
 * @assignment
 * @date 11-Jun-2017 10:28:34 PM
 *
 */
public class BirthdayCakeCandles {

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
		System.out.println(find(array));
	}

	private static int find(int[] array) {
		int max = array[0];
		int count = 1;
		for (int i = 1; i < array.length; i++) {
			if (array[i] == max) {
				count++;
			} else if (array[i] > max) {
				max = array[i];
				count = 1;
			}
		}
		return count;
	}

}
