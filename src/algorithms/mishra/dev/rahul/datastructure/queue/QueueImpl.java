/**
 * 
 */
package algorithms.mishra.dev.rahul.datastructure.queue;

import java.util.Arrays;

/**
 * @author Rahul Dev Mishra
 * @assignment  
 * @date 07-Jun-2017 10:49:32 AM
 *
 */
public class QueueImpl {
	private final int DEFAULT_CAPACITY = 2;
	private Integer[] array;
	private int size;
	private int head;
	
	public QueueImpl() {
		ensureCapacity(DEFAULT_CAPACITY);
	}
	
	public QueueImpl(int capacity) {
		ensureCapacity(capacity);
	}

	private void ensureCapacity(int capacity) {
		array = array == null ? new Integer[capacity] : Arrays.copyOf(array, capacity);
	}
	
	public void add(int newValue) {
		if(size == array.length - 2) {
			ensureCapacity(array.length * 2 + 1);
		}
		
		array[size++] = newValue;
	}
	
	public int peek() {
		return array[head];
	}
	
	public int poll() {
		if(size == 0) {
			throw new RuntimeException("Queue size is Zero");
		}
		int pollValue = array[head];
		array[head++] = null;
		size--;
		return pollValue;
	}
	
	@Override
	public String toString() {
		String str = "[";
		for(int i = head; i < head + size; i++) {
			str = str + array[i] + ", ";
		}
		return size == 0 ? "[ ]": str.substring(0, str.lastIndexOf(",")) + "]";
	}

}
