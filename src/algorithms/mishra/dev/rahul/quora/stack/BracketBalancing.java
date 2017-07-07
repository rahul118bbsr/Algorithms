/**
 * 
 */
package algorithms.mishra.dev.rahul.quora.stack;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Stack;

/**
 * @author Rahul Dev Mishra
 * @assignment
 * @date 01-Jul-2017 6:39:21 PM
 *
 */
public class BracketBalancing {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter a string: ");
		System.out.println(checkIfBracketsAreBalanced(scanner.next()));
		scanner.close();
	}

	private static boolean checkIfBracketsAreBalanced(String brackets) {
		Map<Character, Character> map = new HashMap<>();
		map.put(')', '(');
		map.put(']', '[');
		map.put('}', '{');
		Stack<Character> stack = new Stack<>();
		stack.push(brackets.charAt(0));
		for (int i = 1; i < brackets.length(); i++) {
			char value = brackets.charAt(i);
			if (!stack.isEmpty() && map.get(value) == stack.peek()) {
				stack.pop();
			} else {
				stack.push(value);
			}
		}
		return stack.isEmpty();
	}
}
