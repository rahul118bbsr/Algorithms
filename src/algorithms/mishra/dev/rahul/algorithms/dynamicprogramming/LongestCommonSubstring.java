/**
 * 
 */
package algorithms.mishra.dev.rahul.algorithms.dynamicprogramming;

import java.util.Scanner;

/**
 * https://www.youtube.com/watch?v=BysNXJHzCEs&index=16&list=PLrmLmBdmIlpsHaNTPP_jHHDx_os9ItYXr
 * Non-DP solution
 * 
 * 
 * @author Rahul Dev Mishra
 * @assignment
 * @date 07-Jul-2017 3:21:17 PM
 *
 */
public class LongestCommonSubstring {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter String 1: ");
		String string1 = scanner.nextLine();
		System.out.println("Enter String 2: ");
		String string2 = scanner.nextLine();
		scanner.close();
		System.out.println("Longest common substring between string 1 [" + string1 + "] and string 2 [" + string2
				+ "] is [" + lcs(string1, string2) + "]");
	}

	public static String lcs(String str1, String str2) {
		int l1 = str1.length();
		int l2 = str2.length();
		int[][] arr = new int[l1 + 1][l2 + 1];
		int len = 0, pos = -1;
		for (int x = 1; x < l1 + 1; x++) {
			for (int y = 1; y < l2 + 1; y++) {
				if (str1.charAt(x - 1) == str2.charAt(y - 1)) {
					arr[x][y] = arr[x - 1][y - 1] + 1;
					if (arr[x][y] > len) {
						len = arr[x][y];
						pos = x;
					}
				} else {
					arr[x][y] = 0;
				}
			}
		}
		return str1.substring(pos - len, pos);
	}
}
