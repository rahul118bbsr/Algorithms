/**
 * 
 */
package algorithms.mishra.dev.rahul.quora.stack;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

/**
 * @author Rahul Dev Mishra
 * @assignment
 * @date 01-Jul-2017 7:20:25 PM
 *
 */
public class ReversePolishNotation {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String[] arr = {"2", "1", "+", "3", "*"};
		System.out.println("Result: "  + evaluate(arr));
		String[] arr1 = {"4", "13", "5", "/", "+"};
		System.out.println("Result: "  + evaluate(arr1));
	}

	private static int evaluate(String[] tokens) {
		Stack<String> stack = new Stack<>();
		Set<String> set = new HashSet<>(Arrays.asList("+", "-", "*", "/"));
		for (int i = 0; i < tokens.length; i++) {
			String value = tokens[i];
			if (set.contains(value)) {
				stack.push(operate(stack.pop(), stack.pop(), value));
			} else {
				stack.push(value);
			}
		}
		return Integer.parseInt(stack.pop());
	}

	private static String operate(String o1, String o2, String operator) {
		int op1 = Integer.parseInt(o1);
		int op2 = Integer.parseInt(o2);
		int result = 0;
		switch (operator) {
		case "+":
			result = op1 + op2;
			break;
		case "-":
			result = op1 - op2;
			break;
		case "*":
			result = op1 * op2;
			break;
		case "/":
			result = op1 / op2;
			break;
		default:
			throw new IllegalArgumentException("Invalid Operator: " + operator);
		}

		return Integer.toString(result);
	}

}