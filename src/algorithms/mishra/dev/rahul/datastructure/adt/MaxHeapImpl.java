package algorithms.mishra.dev.rahul.datastructure.adt;

import java.util.Arrays;
import java.util.Objects;

/**
 * Created by aleesha on 18/07/17.
 */
public class MaxHeapImpl {
    public static void main(String[] args) {
        MaxHeap maxHeap = new MaxHeap();
        maxHeap.add(35);
        maxHeap.add(33);
        maxHeap.add(42);
        maxHeap.add(10);
        maxHeap.add(14);
        maxHeap.add(19);
        maxHeap.add(27);
        maxHeap.add(44);
        maxHeap.add(26);
        maxHeap.add(31);
        maxHeap.add(100);
        System.out.println(maxHeap);
        System.out.println(maxHeap.poll());
        System.out.println(maxHeap);
        System.out.println(maxHeap.poll());
        System.out.println(maxHeap);
        System.out.println(maxHeap.poll());
        System.out.println(maxHeap);
        System.out.println(maxHeap.poll());
        System.out.println(maxHeap);
        System.out.println(maxHeap.poll());
        System.out.println(maxHeap);
        System.out.println(maxHeap.poll());
        System.out.println(maxHeap);
        System.out.println(maxHeap.poll());
        System.out.println(maxHeap);
        System.out.println(maxHeap.poll());
        System.out.println(maxHeap);
        System.out.println(maxHeap.poll());
        System.out.println(maxHeap);
        System.out.println(maxHeap.poll());
        System.out.println(maxHeap);
        System.out.println(maxHeap.poll());
        System.out.println(maxHeap);
        System.out.println(maxHeap.poll());
        System.out.println(maxHeap);
        System.out.println(maxHeap.poll());
        System.out.println(maxHeap);
    }
}

class MaxHeap {
    private final static int DEFAULT_CAPACITY = 10;
    private Integer[] array;
    private int size;

    public MaxHeap() {
        this(DEFAULT_CAPACITY);
    }

    public MaxHeap(int capacity) {
        ensureCapacity(capacity);
    }

    private void ensureCapacity(int capacity) {
        array = Objects.isNull(array) ? new Integer[capacity] : Arrays.copyOf(array, capacity);
    }

    public void add(int value) {
        if (size == array.length - 1) {
            ensureCapacity(getLeftChildIndex(array.length));
        }
        array[size] = value;
        swimUp();
        size++;
    }

    public int poll() {
        if (size == 0) {
            throw new RuntimeException("Heap is Empty. Cannot Poll!!!");
        }

        int pollValue = array[0];
        array[0] = array[size - 1];
        array[size - 1] = null;
        size--;
        swimDown();
        return pollValue;
    }

    private void swimUp() {
        int index = size;
        while (hasParent(index) && getParent(index) < array[index]) {
            int parentIndex = (index - 1) / 2;
            swap(parentIndex, index);
            index = parentIndex;
        }
    }

    private void swimDown() {
        int index = 0;
        while ((hasLeftChild(index) && getLeftChild(index) > array[index]) || (hasRightChild(index) && getRightChild(index) > array[index])) {
            // If there is no Right child, then there MUST be a left child, else above "while" would have been true
            if (!hasRightChild(index) || getLeftChild(index) > getRightChild(index)) {
                swap(index, getLeftChildIndex(index));
                index = getLeftChildIndex(index);
            } else {
                swap(index, getRightChildIndex(index));
                index = getRightChildIndex(index);
            }
        }
    }

    public int peek() {
        return array[0];
    }

    public int getSize() {
        return size;
    }

    private void swap(int parentIndex, int index) {
        int temp = array[parentIndex];
        array[parentIndex] = array[index];
        array[index] = temp;
    }

    private boolean hasParent(int index) {
        return index != 0;
    }

    private int getParent(int index) {
        return array[(index - 1) / 2];
    }

    private boolean hasLeftChild(int index) {
        return getLeftChildIndex(index) < size;
    }

    private int getLeftChildIndex(int index) {
        return 2 * index + 1;
    }

    private int getLeftChild(int index) {
        return array[getLeftChildIndex(index)];
    }

    private boolean hasRightChild(int index) {
        return getRightChildIndex(index) < size;
    }

    private int getRightChild(int index) {
        return array[getRightChildIndex(index)];
    }

    private int getRightChildIndex(int index) {
        return 2 * index + 2;
    }

    @Override
    public String toString() {
        String string = "[";
        for (int i = 0; i < size; i++) {
            string = string + array[i] + " ";
        }
        string = string + "]";
        return string;
    }
}
