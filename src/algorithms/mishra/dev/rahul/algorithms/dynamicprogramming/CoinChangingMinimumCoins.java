/**
 * 
 */
package algorithms.mishra.dev.rahul.algorithms.dynamicprogramming;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * https://www.youtube.com/watch?annotation_id=annotation_2195265949&feature=iv&src_vid=Y0ZqKpToTic&v=NJuKJ8sasGk
 * 
 * @author Rahul Dev Mishra
 * @assignment
 * @date 07-Jul-2017 9:16:50 AM
 *
 */
public class CoinChangingMinimumCoins {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the number of coins: ");
		int[] coinsArray = new int[scanner.nextInt()];
		System.out.println("Enter the coin denominations: ");
		for (int i = 0; i < coinsArray.length; i++) {
			coinsArray[i] = scanner.nextInt();
		}
		System.out.println("Enter the total value: ");
		System.out.println(findMinimumCoins(coinsArray, scanner.nextInt()));
		scanner.close();
	}

	private static List<Integer> findMinimumCoins(int[] coinsArray, int total) {
		int[] minCoinArray = new int[total + 1];
		int[] result = new int[total + 1];
		minCoinArray[0] = 0;
		for (int i = 1; i < minCoinArray.length; i++) {
			minCoinArray[i] = Integer.MAX_VALUE - 1;
		}

		for (int i = 0; i < result.length; i++) {
			result[i] = -1;
		}

		for (int i = 0; i < coinsArray.length; i++) {
			for (int j = 1; j < minCoinArray.length; j++) {
				if (j >= coinsArray[i]) {
					if (minCoinArray[j - coinsArray[i]] + 1 < minCoinArray[j]) {
						minCoinArray[j] = minCoinArray[j - coinsArray[i]] + 1;
						result[j] = i;
					}
				}
			}
		}
		return backTrackAndFindCoins(coinsArray, result, total);
	}

	private static List<Integer> backTrackAndFindCoins(int[] coinsArray, int[] result, int total) {
		List<Integer> list = new ArrayList<>();
		list.add(coinsArray[result[result.length - 1]]);
		total = total - coinsArray[result[result.length - 1]];
		while (total != 0) {
			list.add(coinsArray[result[total]]);
			total = total - coinsArray[result[total]];
		}
		return list;
	}

}
