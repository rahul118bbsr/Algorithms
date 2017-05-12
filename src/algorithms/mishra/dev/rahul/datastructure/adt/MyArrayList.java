/**
 * 
 */
package algorithms.mishra.dev.rahul.datastructure.adt;

/**
 * @author Rahul Dev Mishra
 * @assignment  
 * @date 10-Apr-2017 8:39:07 PM
 *
 */
public class MyArrayList {
	private final static int DEFAULT_CAPACITY = 2;
	private int[] myArr;
	private int arrSize;
	
	public MyArrayList() {
		ensureCapacity(DEFAULT_CAPACITY);
	}
	
	public MyArrayList(int capacity) {
		ensureCapacity(capacity);
	}
	
	private void ensureCapacity(int capacity) {
		int[] tempArr = myArr;
		myArr = new int[capacity];
		for(int i = 0; i < getSize(); i++) {
			myArr[i] = tempArr[i];
		}
	}
	
	public int getSize() {
		return arrSize;
	}
	
	public void add(int newElement) {
		add(getSize(), newElement);
	}
	
	public void add(int index, int newElement) {
		if(index < 0 || index > getSize()) {
			throw new IndexOutOfBoundsException("The index " + index + " is out of range.");
		}
		
		if(myArr.length >= getSize() - 2) {
			ensureCapacity(myArr.length * 2);
		}
		
		int[] tempArr = myArr;
		for(int i = getSize(); i >= index; i--) {
			myArr[i + 1] = tempArr[i];
		}
		
		myArr[index] = newElement;
		++arrSize;
	}
	
	public void set(int index, int newElement) {
		if(index < 0 || index >= getSize()) {
			throw new IndexOutOfBoundsException("The index " + index + " is out of range.");
		}
		
		myArr[index] = newElement;
	}
	
	public void remove(int index) {
		if(index < 0 || index >= getSize()) {
			throw new IndexOutOfBoundsException("The index " + index + " is out of range.");
		}
		
		int[] tempArr = myArr;
		for(int i = ++index; i < getSize(); i++) {
			myArr[i - 1] = tempArr[i];
		}
//		myArr[i] = null;
		--arrSize;
	}
	
	@Override
	public String toString() {
		String str = "[";
		for(int i = 0; i < getSize(); i++) {
			str = str + myArr[i] + ", ";
		}
		str = str.substring(0, str.lastIndexOf(","));
		str = str + "]";
		return str;
	}
	
}