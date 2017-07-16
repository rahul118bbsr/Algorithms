/**
 * 
 */
package algorithms.mishra.dev.rahul.algorithms.dynamicprogramming;

import java.util.List;
import java.util.Scanner;

/**
 * https://www.youtube.com/watch?v=s6FhG--P7z0
 * 
 * @author Rahul Dev Mishra
 * @assignment
 * @date 07-Jul-2017 12:55:51 PM
 *
 */
public class SubsetSumProblem {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the number of elements: ");
		int[] array = new int[scanner.nextInt()];
		System.out.println("Enter the elements: ");
		for (int i = 0; i < array.length; i++) {
			array[i] = scanner.nextInt();
		}
		System.out.println("Enter the sum: ");
		System.out.println(findSubset(array, scanner.nextInt()));
		scanner.close();
	}

	private static List<Integer> findSubset(int[] inputArray, int sum) {
		boolean[][] resultArray = new boolean[inputArray.length][sum + 1];
		for (int i = 0; i < resultArray.length; i++) {
			resultArray[i][0] = true;
		}

		for (int i = 0; i < resultArray.length; i++) {
			for (int j = 1; j < resultArray[0].length; j++) {
				if (inputArray[i] > j) {
					resultArray[i][j] = false;
				} else {
					resultArray[i][j] = resultArray[i - 1][j] ? true : resultArray[i - 1][j - inputArray[i]];
				}
			}
		}
		return backTrackAndFindSubset(resultArray, inputArray);
	}

	private static List<Integer> backTrackAndFindSubset(boolean[][] resultArray, int[] inputArray) {
		// TODO Auto-generated method stub
		return null;
	}

}
