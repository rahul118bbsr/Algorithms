/**
 * 
 */
package algorithms.mishra.dev.rahul.datastructure.heap;

import java.util.Arrays;

/**
 * Max - Heap Implementation
 * 
 * @author Rahul Dev Mishra
 * @assignment
 * @date 06-Jun-2017 7:54:19 PM
 *
 */
public class PriorityQueueImpl {
	private int DEFAULT_CAPACITY = 5;
	int[] array = null;
	int size = 0;

	public PriorityQueueImpl() {
		ensureCapacity(DEFAULT_CAPACITY);
	}

	public PriorityQueueImpl(int capacity) {
		ensureCapacity(capacity);
	}

	private void ensureCapacity(int capacity) {
		array = array == null ? new int[capacity] : Arrays.copyOf(array, capacity);
	}

	public void addAll(int[] values) {
		Arrays.stream(values).forEach(i -> add(i));
	}

	public void add(int newValue) {
		if (size == array.length - 2) {
			ensureCapacity(array.length * 2 + 1);
		}
		array[size] = newValue;
		swimUp();
		size++;
	}

	public int peek() {
		return array[0];
	}

	public int poll() {
		int pollValue = array[0];
		array[0] = array[size - 1];
		array[size - 1] = 0;
		swimDown();
		size--;
		return pollValue;
	}

	private void swimUp() {
		int index = size;
		while (hasParent(index) && getParent(index) < array[index]) {
			int parentIndex = getParentIndex(index);
			swap(parentIndex, index);
			index = parentIndex;
		}
	}

	private void swimDown() {
		int index = 0;
		int maxValue = Math.max(array[getLeftChildIndex(index)], array[getRightChildIndex(index)]);
		while (array[index] < maxValue) {
			if (maxValue == array[getLeftChildIndex(index)]) {
				swap(index, getLeftChildIndex(index));
				index = getLeftChildIndex(index);
			} else if (maxValue == array[getRightChildIndex(index)]) {
				swap(index, getRightChildIndex(index));
				index = getRightChildIndex(index);
			}
			maxValue = Math.max(array[getLeftChildIndex(index)], array[getRightChildIndex(index)]);
		}
	}

	private void swap(int parentIndex, int newValueIndex) {
		int temp = array[parentIndex];
		array[parentIndex] = array[newValueIndex];
		array[newValueIndex] = temp;
	}

	private int getParent(int index) {
		return array[getParentIndex(index)];
	}

	private int getParentIndex(int index) {
		return (index - 1) / 2;
	}

	private boolean hasParent(int index) {
		return index != 0;
	}

	private int getLeftChildIndex(int parentIndex) {
		return (parentIndex * 2) + 1;
	}

	private int getRightChildIndex(int parentIndex) {
		return (parentIndex * 2) + 2;
	}

	@Override
	public String toString() {
		String str = "[";
		for (int i = 0; i < size; i++) {
			str = str + array[i] + ", ";
		}
		return str.substring(0, str.lastIndexOf(",")) + "]";
	}

}
