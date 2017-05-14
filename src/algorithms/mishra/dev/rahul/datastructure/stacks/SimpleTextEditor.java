package algorithms.mishra.dev.rahul.datastructure.stacks;

import java.util.Scanner;
import java.util.Stack;

public class SimpleTextEditor {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int noOfOps = Integer.valueOf(scanner.nextLine());
		Stack<String> history = new Stack<>();
		String text = "";

		while (noOfOps > 0) {
			String operation = scanner.nextLine();
			String[] opsArr = operation.split(" ");
			switch (opsArr[0]) {
			// Append
			case "1":
				history.push(text);
				text = text + opsArr[1];
				break;

			// Delete the last k characters
			case "2":
				history.push(text);
				int k = Integer.valueOf(opsArr[1]);
				text = text.substring(0, text.length() - k);
				break;

			// Print the kth character
			case "3":
				int i = Integer.valueOf(opsArr[1]);
				System.out.println(text.charAt(i - 1));
				break;

			// Undo
			case "4":
				text = history.pop();
				break;

			default:
				System.out.println("Invalid Operator: " + opsArr[0]);
				break;
			}
			--noOfOps;
		}
		scanner.close();
	}
}
