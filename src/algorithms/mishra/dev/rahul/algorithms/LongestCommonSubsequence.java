/**
 * 
 */
package algorithms.mishra.dev.rahul.algorithms;

import java.util.Scanner;

/**
 * @author Rahul Dev Mishra
 * @assignment
 * @date 06-Jul-2017 7:52:14 PM
 *
 */
public class LongestCommonSubsequence {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the String 1: ");
		String string1 = scanner.nextLine();
		System.out.println("Enter the String 2: ");
		String string2 = scanner.nextLine();
		System.out.println("The Longest Common Subsequence between string1 [" + string1 + "] and string2 [" + string2
				+ "] is [" + new LongestCommonSubsequence().new LCS().findLCS(string1, string2) + "]");
		scanner.close();
	}

	class LCS {
		public String findLCS(String string1, String string2) {
			int length1 = string1.length();
			int length2 = string2.length();
			int[][] array = new int[length2 + 1][length1 + 1];
			for (int i = 1; i <= length2; i++) {
				for (int j = 1; j <= length1; j++) {
					array[i][j] = string1.charAt(j - 1) == string2.charAt(i - 1) ? array[i - 1][j - 1] + 1
							: Math.max(array[i - 1][j], array[i][j - 1]);
				}
			}
			return find(string1, string2, array);
		}

		private String find(String string1, String string2, int[][] array) {
			StringBuilder lcs = new StringBuilder();
			int i = string2.length();
			for (int j = string1.length(); j > 0;) {
				int value = array[i][j];
				if (value == array[i][j - 1]) {
					j = j - 1;
				} else if (value == array[i - 1][j]) {
					i = i - 1;
				} else if (value == array[i - 1][j - 1] + 1) {
					lcs.append(string1.charAt(j - 1));
					i = i - 1;
					j = j - 1;
				}
			}
			return lcs.reverse().toString();
		}
	}

}
