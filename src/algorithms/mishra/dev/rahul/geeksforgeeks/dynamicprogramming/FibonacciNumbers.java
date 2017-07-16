/**
 * 
 */
package algorithms.mishra.dev.rahul.geeksforgeeks.dynamicprogramming;

import java.util.Arrays;
import java.util.Scanner;

/**
 * http://www.geeksforgeeks.org/program-for-nth-fibonacci-number/
 * 
 * @author Rahul Dev Mishra
 * @assignment  
 * @date 10-Jul-2017 2:31:47 PM
 *
 */
public class FibonacciNumbers {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the number of terms: ");
		findFibonacciNumbers(scanner.nextInt());
		scanner.close();
	}

	private static void findFibonacciNumbers(int numOfTerms) {
		int[] result = new int[numOfTerms];
		result[0] = 0;
		result[1] = 1;
		fibonacciNumbersUtil(numOfTerms, result);
		Arrays.stream(result).forEach(num -> System.out.print(num + " "));
	}

	private static void fibonacciNumbersUtil(int numOfTerms, int[] result) {
		for(int i = 2; i < numOfTerms; i++) {
			result[i] = result[i - 1] + result[i - 2];
		}
	}
}
