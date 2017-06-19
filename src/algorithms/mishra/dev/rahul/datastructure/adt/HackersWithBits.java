/**
 * 
 */
package algorithms.mishra.dev.rahul.datastructure.adt;

import java.util.Scanner;

/**
 * @author Rahul Dev Mishra
 * @assignment
 * @date 17-Jun-2017 2:15:00 PM
 *
 */
public class HackersWithBits {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int[] array = new int[n + 1];
		array[0] = -1;
		for (int i = 1; i < array.length; i++) {
			array[i] = scanner.nextInt();
		}
		scanner.close();
		System.out.println(solve(array));
	}

	private static int solve(int[] array) {
		int index = 0;
		int maxLength = Integer.MIN_VALUE;
		int count = 0;
		int lastZeroIndex = 0;
		for (int i = 1; i < array.length; i++) {
			if (array[i] == 1) {
				count++;
			} else {
				if(maxLength < count) {
					maxLength = count;
					index = i;
				} else {
					lastZeroIndex = i;
				}
				count = 0;
			}
		}
		index = maxLength > count ? index : lastZeroIndex;
		return index;
	}
}
