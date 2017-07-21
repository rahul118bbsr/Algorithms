/**
 * 
 */
package algorithms.mishra.dev.rahul.algorithms;

import java.util.Scanner;

/**
 * @author Rahul Dev Mishra
 * @assignment
 * @date 19-Jun-2017 2:25:58 PM
 *
 */
public class KMP {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the Text string: ");
		String text = scanner.nextLine();
		System.out.println("Enter the Pattern string: ");
		String pattern = scanner.nextLine();
		scanner.close();
		System.out.println("The pattern [" + pattern + "] is found in the text [" + text + "] at index: "
				+ new KMP().search(text, pattern));
	}

	private int search(String text, String pattern) {
		int[] table = buildFailureFunctionTable(pattern);
		int i = 0, j = 0;
		while (i < text.length() && j < pattern.length()) {
			if (text.charAt(i) == pattern.charAt(j)) {
				i++;
				j++;
			} else {
				if (j != 0) {
					j = table[j - 1];
				} else {
					i++;
				}
			}
		}
		return j == pattern.length() ? i - j : -1;
	}

	private int[] buildFailureFunctionTable(String pattern) {
		int[] table = new int[pattern.length()];
		char[] patternArray = pattern.toCharArray();
		int i = 0;
		table[0] = 0;
		for (int j = 1; j < pattern.length();) {
			if (patternArray[i] == patternArray[j]) {
				table[j] = i + 1;
				i++;
				j++;
			} else {
				if (i > 0) {
					i = table[--i];
				} else {
					j++;
				}
			}
		}

		return table;
	}
}
