/**
 * 
 */
package algorithms.mishra.dev.rahul.datastructure.stacks;

import java.util.Scanner;
import java.util.Stack;

/**
 * @author Rahul Dev Mishra
 * @assignment
 * @date 13-May-2017 9:50:38 PM
 *
 */
public class MaximumElement {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int noOfOps = Integer.valueOf(scanner.nextLine());
		Stack<Integer> stack = new Stack<>();
		Stack<Integer> maxStack = new Stack<>();

		while (noOfOps > 0) {
			--noOfOps;
			String operation = scanner.nextLine();
			String[] opsArr = operation.split(" ");

			switch (opsArr[0]) {
			case "1":
				int i = Integer.valueOf(opsArr[1]);
				stack.push(i);

				if (maxStack.isEmpty() || maxStack.peek() <= i) {
					maxStack.push(i);
				}
				break;

			case "2":
				int poppedElement = stack.pop();
				if (!maxStack.isEmpty() && maxStack.peek() == poppedElement) {
					maxStack.pop();
				}
				break;

			case "3":
				if (!maxStack.isEmpty()) {
					System.out.println(maxStack.peek());
				}
				break;

			default:
				break;
			}
		}
		scanner.close();
	}

}
