/**
 * 
 */
package algorithms.mishra.dev.rahul.datastructure.stacks;

import java.util.Arrays;

/**
 * @author Rahul Dev Mishra
 * @assignment  
 * @date 07-Jun-2017 8:48:02 AM
 *
 */
public class Stack {
	private static int DEFAULT_CAPACITY = 10;
	Integer[] array = null;
	int size  = 0;
	
	public Stack() {
		ensureCapacity(DEFAULT_CAPACITY);
	}
	
	public Stack(int capacity) {
		ensureCapacity(capacity);
	}

	private void ensureCapacity(int capacity) {
		array = array == null ? new Integer[capacity] : Arrays.copyOf(array, capacity);
	}
	
	public void push(int newValue) {
		if(size == array.length - 2) {
			ensureCapacity(array.length * 2 + 1);
		}
		
		array[size] = newValue;
		size++;
	}
	
	public int pop() {
		int popValue = array[size - 1]; 
		array[size-- - 1] = null;
		return popValue;
	}
	
	@Override
	public String toString() {
		String str = "[";
		for(int i = size - 1; i >= 0; i--) {
			str = str + array[i] + ", ";
		}
		return str.substring(0, str.lastIndexOf(",")) + "]";
	}

}
