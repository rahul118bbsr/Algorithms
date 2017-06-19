/**
 * 
 */
package algorithms.mishra.dev.rahul.hackerrank.problems.implementation;

import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/apple-and-orange
 * 
 * @author Rahul Dev Mishra
 * @assignment
 * @date 12-Jun-2017 12:29:01 AM
 *
 */
public class AppleAndOrange {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int s = in.nextInt();
		int t = in.nextInt();
		int a = in.nextInt();
		int b = in.nextInt();
		int m = in.nextInt();
		int n = in.nextInt();
		int[] apple = new int[m];
		for (int apple_i = 0; apple_i < m; apple_i++) {
			apple[apple_i] = in.nextInt();
		}
		int[] orange = new int[n];
		for (int orange_i = 0; orange_i < n; orange_i++) {
			orange[orange_i] = in.nextInt();
		}
		in.close();
		count(s, t, a, b, apple, orange);
	}
	
	private static void count(int s, int t, int a, int b, int[] apple, int[] orange) {
		int appleCount = 0;
		int orangeCount = 0;
		
		for(int i : apple) {
			appleCount = (a + i) >= s && (a + i) <= t? appleCount + 1 : appleCount;
		}
		
		for(int i : orange) {
			orangeCount = (b + i) >= s && (b + i) <= t ? orangeCount + 1 : orangeCount;
		}
		
		System.out.println(appleCount);
		System.out.println(orangeCount);
	}
	
//	print(sum([1 for x in apple if (x + a) >= s and (x + a) <= t]))
//	print(sum([1 for x in orange if (x + b) >= s and (x + b) <= t]))

}
