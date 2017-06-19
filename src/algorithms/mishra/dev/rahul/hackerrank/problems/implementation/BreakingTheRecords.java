/**
 * 
 */
package algorithms.mishra.dev.rahul.hackerrank.problems.implementation;

import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/breaking-best-and-worst-records
 * 
 * @author Rahul Dev Mishra
 * @assignment
 * @date 12-Jun-2017 5:23:01 PM
 *
 */
public class BreakingTheRecords {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int[] s = new int[n];
		for (int s_i = 0; s_i < n; s_i++) {
			s[s_i] = in.nextInt();
		}
		int[] result = getRecord(s);
		String separator = "", delimiter = " ";
		for (Integer val : result) {
			System.out.print(separator + val);
			separator = delimiter;
		}
		System.out.println("");
		in.close();
	}

	private static int[] getRecord(int[] s) {
		int high = s[0];
		int highScoreCount = 0;
		int low = s[0];
		int lowScoreCount = 0;
		for (int i = 1; i < s.length; i++) {
			if (s[i] > high) {
				high = s[i];
				highScoreCount++;
			} else if (s[i] < low) {
				low = s[i];
				lowScoreCount++;
			}
		}
		return new int[] { highScoreCount, lowScoreCount };
	}

}
