/**
 * 
 */
package algorithms.mishra.dev.rahul.hackerrank.problems.implementation;

import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/the-birthday-bar
 * 
 * @author Rahul Dev Mishra
 * @assignment
 * @date 12-Jun-2017 5:37:45 PM
 *
 */
public class BirthdayChocolate {

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
		int d = in.nextInt();
		int m = in.nextInt();
		int result = solve(n, s, d, m);
		System.out.println(result);
		in.close();
	}

	static int solve(int n, int[] s, int d, int m) {
		int noOfWays = 0;
		int count = 0;
		int sum = 0;
		for(int i = 0; i < s.length; i++) {
			if(count == m) {
				
			}
			
			sum = sum + s[i];
			count++;
		}
		return noOfWays;
	}

}
