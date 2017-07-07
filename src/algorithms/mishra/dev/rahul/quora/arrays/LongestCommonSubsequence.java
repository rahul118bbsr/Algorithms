/**
 * 
 */
package algorithms.mishra.dev.rahul.quora.arrays;

import java.util.Scanner;

/**
 * @author Rahul Dev Mishra
 * @assignment
 * @date 26-Jun-2017 12:30:21 PM
 *
 */
public class LongestCommonSubsequence {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter String 1: ");
		String string1 = scanner.nextLine();
		System.out.println("Enter String 2: ");
		String string2 = scanner.nextLine();
		System.out.println("Lowest Common Subsequence in String 1: [" + string1 + "] and String 2: [" + string2
				+ "] is [" + findLongestCommonSubsequence(string1, string2) + "]");
		scanner.close();
	}

	/**
	 * If a character is matched between String 1 (at index i) and String 2 (at index j), then backtrack and find the maximum length of LCS at index i-1 and j-1 and 1 
	 * to it since we have found a new match. Else find the max value between i-1 & j and i & j-1.
	 * 
	 * @param string1
	 * @param string2
	 * @return
	 */
	private static String findLongestCommonSubsequence(String string1, String string2) {
		int[][] array = new int[string2.length() + 1][string1.length() + 1];
		for (int i = 1; i < string2.length() + 1; i++) {
			for (int j = 1; j < string1.length() + 1; j++) {
				array[i][j] = string2.charAt(i - 1) == string1.charAt(j - 1) ? array[i - 1][j - 1] + 1
						: Math.max(array[i][j - 1], array[i - 1][j]);
			}
		}
		return backTrackAndFindLongestCommonSubsequence(string1, string2, array);
	}

	private static String backTrackAndFindLongestCommonSubsequence(String string1, String string2, int[][] array) {
		StringBuilder lcs = new StringBuilder();
		int i = string2.length();
		for (int j = string1.length(); j > 0;) {
			int value = array[i][j];
			if (value == array[i][j - 1]) {
				j = j - 1;
			} else if (value == array[i - 1][j]) {
				i = i - 1;
			} else if (value == array[i - 1][j - 1] + 1) {
				lcs = lcs.append(string2.charAt(i - 1));
				i = i - 1;
				j = j - 1;
			}
		}
		return lcs.reverse().toString();
	}
}
