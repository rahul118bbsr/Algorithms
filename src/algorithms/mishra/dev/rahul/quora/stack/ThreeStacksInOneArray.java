/**
 * 
 */
package algorithms.mishra.dev.rahul.quora.stack;

import java.util.Arrays;

/**
 * Cracking the Coding Interview Question - Q3.1
 * 
 * @author Rahul Dev Mishra
 * @assignment
 * @date 01-Jul-2017 7:48:51 PM
 *
 */
public class ThreeStacksInOneArray {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ThreeStacks stack = new ThreeStacks();
		stack.push(100, 1);
		stack.push(200, 2);
		stack.push(300, 3);
		stack.push(101, 1);
		stack.push(102, 1);
		stack.push(301, 3);
		stack.push(201, 2);

		stack.printStack(1);
		stack.printStack(2);
		stack.printStack(3);

		stack.push(103, 1);
		stack.push(202, 2);
		stack.push(203, 2);
		stack.push(302, 3);
		stack.push(303, 3);

		stack.printStack(1);
		stack.printStack(2);
		stack.printStack(3);

		System.out.println(stack.pop(1));
		System.out.println(stack.pop(1));
		System.out.println(stack.pop(1));
		System.out.println(stack.pop(1));
		// System.out.println(stack.pop(1));
		stack.push(120, 1);
		stack.printStack(1);
	}
}

/**
 * Create an array which holds three stacks. Here the implementation is based on
 * the idea that alternate indexes in the array is allocated to Stack1, Stack2
 * and Stack3
 * 
 * @author Rahul Dev Mishra
 * @assignment
 * @date 01-Jul-2017 10:11:29 PM
 *
 */
class ThreeStacks {
	private final int DEFAULT_SIZE = 3;
	private final int THRESHOLD_VALUE = 5;
	private final int NO_OF_STACKS = 3;
	private Integer[] array = null;
	private int i1 = 1;
	private int i2 = 2;
	private int i3 = 3;
	private int size = 0;

	public ThreeStacks() {
		ensureCapacity(DEFAULT_SIZE);
	}

	public ThreeStacks(int size) {
		ensureCapacity(size);
	}

	private void ensureCapacity(int capacity) {
		array = array == null ? new Integer[capacity] : Arrays.copyOf(array, capacity);
	}

	/**
	 * Push the value into the array and increment the pointer by 3 steps
	 * 
	 * @param value
	 * @param stackNo
	 */
	public void push(int value, int stackNo) {
		if (array.length - size <= THRESHOLD_VALUE) {
			ensureCapacity(2 * array.length + 1);
		}
		size++;

		switch (stackNo) {
		case 1:
			array[i1] = value;
			i1 = i1 + NO_OF_STACKS;
			break;

		case 2:
			array[i2] = value;
			i2 = i2 + NO_OF_STACKS;
			break;

		case 3:
			array[i3] = value;
			i3 = i3 + NO_OF_STACKS;
			break;

		default:
			throw new IllegalArgumentException("Invalid Stack Number: " + stackNo);
		}
	}

	/**
	 * Move the pointer back three steps (since push operation increments the
	 * pointer by 3 steps) and then pop the value. If the pointer is already at
	 * the HEAD position, then just pop back the value.
	 * 
	 * @param stackNo
	 * @return
	 */
	public int pop(int stackNo) {
		Integer popValue = 0;
		switch (stackNo) {
		case 1:
			i1 = i1 == 1 ? i1 : i1 - NO_OF_STACKS;
			popValue = array[i1];
			array[i1] = null;
			break;

		case 2:
			i2 = i2 == 2 ? i2 : i2 - NO_OF_STACKS;
			popValue = array[i2];
			array[i2] = null;
			break;

		case 3:
			i3 = i3 == 3 ? i3 : i3 - NO_OF_STACKS;
			popValue = array[i3];
			array[i3] = null;
			break;

		default:
			throw new IllegalArgumentException("Invalid Stack Number: " + stackNo);
		}
		size--;
		if (popValue == null) {
			throw new RuntimeException("Cannot Pop further elements from Stack " + stackNo);
		}
		return popValue;
	}

	public void printStack(int stackNo) {
		int ptr = 0;
		switch (stackNo) {
		case 1:
			ptr = i1;
			break;

		case 2:
			ptr = i2;
			break;

		case 3:
			ptr = i3;
			break;

		default:
			throw new IllegalArgumentException("Invalid Stack Number: " + stackNo);
		}

		System.out.print("Printing the elements of Stack " + stackNo + " - ");
		ptr = ptr - NO_OF_STACKS;
		for (; ptr > 0; ptr = ptr - NO_OF_STACKS) {
			System.out.print(array[ptr] + " ");
		}
		System.out.println();
	}

	public boolean isEmpty(int stackNo) {
		switch (stackNo) {
		case 1:
			return i1 == 1;
		case 2:
			return i2 == 2;
		case 3:
			return i3 == 3;
		default:
			throw new IllegalArgumentException("Invalid Stack Number: " + stackNo);
		}
	}
}
