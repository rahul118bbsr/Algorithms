/**
 * 
 */
package algorithms.mishra.dev.rahul.quora.stack;

import java.util.Stack;

/**
 * Cracking the Coding Interview - Q3.2
 * 
 * @author Rahul Dev Mishra
 * @assignment
 * @date 01-Jul-2017 10:55:09 PM
 *
 */
public class StackMin {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		MyStack stack = new MyStack();
		stack.push(10);
		stack.push(12);
		System.out.println("Min Value: " + stack.min());
		stack.push(6);
		stack.push(2);
		System.out.println("Min Value: " + stack.min());
		stack.pop();
		System.out.println("Min Value: " + stack.min());
	}
}

class MyStack {
	private Stack<Integer> stack = new Stack<>();
	private Stack<Integer> minStack = new Stack<>();

	public void push(int value) {
		if (!minStack.isEmpty() && value < minStack.peek()) {
			minStack.push(value);
		} else if (minStack.isEmpty()) {
			minStack.push(value);
		}
		stack.push(value);
	}

	public int pop() {
		int popValue = stack.pop();
		if (!minStack.isEmpty() && popValue == minStack.peek()) {
			minStack.pop();
		}
		return popValue;
	}
	
	public int min() {
		return minStack.peek();
	}
}