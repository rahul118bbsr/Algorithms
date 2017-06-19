/**
 * 
 */
package algorithms.mishra.dev.rahul.hackerrank.problems.string;

import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/reduced-string
 * 
 * @author Rahul Dev Mishra
 * @assignment
 * @date 14-Jun-2017 9:58:25 PM
 *
 */
public class SuperReeducedString {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the string: ");
		System.out.println(findSuperReducedString(scanner.nextLine()));
		scanner.close();
	}

	private static String findSuperReducedString(String string) {
		String result = "";
		if (string == null || "".equals(string)) {
			return result;
		}

		char prev = string.charAt(0);
		int count = 1;
		for (int i = 1; i < string.length(); i++) {
			if(prev == string.charAt(i)) {
				count++;
			} else {
				if(count >= 2) {
					
				}
			}
		}
		return result;
	}

}
