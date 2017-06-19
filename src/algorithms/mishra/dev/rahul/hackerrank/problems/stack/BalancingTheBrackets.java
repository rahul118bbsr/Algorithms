/**
 * 
 */
package algorithms.mishra.dev.rahul.hackerrank.problems.stack;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Stack;

/**
 * @author Rahul Dev Mishra
 * @assignment  
 * @date 13-Jun-2017 10:17:39 AM
 *
 */
public class BalancingTheBrackets {
	private static Map<Character, Character> bracketMap = new HashMap<>();

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the sequence of brackets: ");
		String brackets = scanner.nextLine();
		scanner.close();
		initBracketMap();
		System.out.println(checkIfBracketsAreBalanced(brackets));
	}

	private static void initBracketMap() {
		bracketMap.put(')', '(');
		bracketMap.put(']', '[');
		bracketMap.put('}', '{');
	}

	private static boolean checkIfBracketsAreBalanced(String brackets) {
		Stack<Character> stack = new Stack<>();
		for(char bracket : brackets.toCharArray()) {
			if(stack.size() == 0) {
				stack.push(bracket);
				continue;
			}
			
			if(stack.peek() == bracketMap.get(bracket)) {
				stack.pop();
			} else {
				stack.push(bracket);
			}
		}
		return stack.size() == 0;
	}

}
