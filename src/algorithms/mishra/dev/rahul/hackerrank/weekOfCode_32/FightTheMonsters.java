/**
 * 
 */
package algorithms.mishra.dev.rahul.hackerrank.weekOfCode_32;

import java.util.Scanner;

/**
 * https://www.hackerrank.com/contests/w32/challenges/fight-the-monsters
 * 
 * @author Rahul Dev Mishra
 * @assignment
 * @date 16-May-2017 11:11:16 AM
 *
 */
public class FightTheMonsters {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int hit = in.nextInt();
		int t = in.nextInt();
		int[] h = new int[n];
		for (int h_i = 0; h_i < n; h_i++) {
			h[h_i] = in.nextInt();
		}

		quickSort(h, 0, h.length - 1);
		int result = getMaxMonsters(n, hit, t, h);
		System.out.println(result);
	}

	static int getMaxMonsters(int n, int hit, int t, int[] h) {
		// Complete this function
		int monstersKilled = 0;
		for (int healthUnit : h) {
			t = t - (healthUnit / hit);
			t = (healthUnit % hit) == 0 ? t : t - 1;
			if(t >= 0) {
				++monstersKilled;
			} else {
				return monstersKilled;
			}
		}
		return monstersKilled;
	}

	private static void quickSort(int[] array, int lowerIndex, int higherIndex) {

		int i = lowerIndex;
		int j = higherIndex;
		// calculate pivot number, I am taking pivot as middle index number
		int pivot = array[lowerIndex + (higherIndex - lowerIndex) / 2];
		// Divide into two arrays
		while (i <= j) {
			/**
			 * In each iteration, we will identify a number from left side which
			 * is greater then the pivot value, and also we will identify a
			 * number from right side which is less then the pivot value. Once
			 * the search is done, then we exchange both numbers.
			 */
			while (array[i] < pivot) {
				i++;
			}
			while (array[j] > pivot) {
				j--;
			}
			if (i <= j) {
				exchangeNumbers(array, i, j);
				// move index to next position on both sides
				i++;
				j--;
			}
		}
		// call quickSort() method recursively
		if (lowerIndex < j)
			quickSort(array, lowerIndex, j);
		if (i < higherIndex)
			quickSort(array, i, higherIndex);
	}

	private static void exchangeNumbers(int[] array, int i, int j) {
		int temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}
}
