/**
 * 
 */
package algorithms.mishra.dev.rahul.hackerrank.problems.string;

import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/caesar-cipher-1
 * 
 * @author Rahul Dev Mishra
 * @assignment
 * @date 15-Jun-2017 11:03:12 AM
 *
 */
public class CaesarCipher {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter a word: ");
		String string = scanner.nextLine();
		System.out.println("Enter the key value: ");
		System.out.println(encryptSring(string, Integer.valueOf(scanner.nextLine())));
		scanner.close();
	}

	private static String encryptSring(String string, int key) {
		String result = "";
		for (char c : string.toCharArray()) {
			if ((c >= 65 && c <= 90) || (c >= 97 && c <= 122)) {
				int encryptedCharValue = c + key;
				if (encryptedCharValue > 90) {
					encryptedCharValue = encryptedCharValue % 90 - 1;
				} else if (encryptedCharValue > 122) {
					encryptedCharValue = encryptedCharValue % 122 - 1;
				}
				result = result + (char) encryptedCharValue;
			} else {
				result = result + c;
			}
		}
		return result;
	}

}
