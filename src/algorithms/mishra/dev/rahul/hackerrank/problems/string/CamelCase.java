/**
 * 
 */
package algorithms.mishra.dev.rahul.hackerrank.problems.string;

import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * https://www.hackerrank.com/challenges/camelcase
 * 
 * @author Rahul Dev Mishra
 * @assignment  
 * @date 15-Jun-2017 8:03:56 AM
 *
 */
public class CamelCase {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter a word: ");
		System.out.println(findNumberOfWords(scanner.nextLine()));
		scanner.close();
	}

	private static int findNumberOfWords(String string) {
		if("".equals(string)) {
			return 0;
		}
		
		AtomicInteger count = new AtomicInteger(1);
		string.chars()
		.mapToObj(i -> (char)i)
		.forEach(i -> {
			if(Character.isUpperCase(i)) {
				count.incrementAndGet();
			}
		});
		return count.get();
	}

}
