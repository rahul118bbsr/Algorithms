/**
 * 
 */
package algorithms.mishra.dev.rahul.quora.sort;

/**
 * @author Rahul Dev Mishra
 * @assignment
 * @date 11-Jul-2017 6:50:08 PM
 *
 */
public class MyMergeSort {
	private int[] array;
	private int[] tempArray;

	public static void main(String[] args) {
		int[] inputArr = {45, 23, 11, 89, 77, 98, 4};
		new MyMergeSort().sort(inputArr);
		for (int i : inputArr) {
			System.out.print(i);
			System.out.print(" ");
		}
	}

	public void sort(int[] inputArray) {
		array = inputArray;
		tempArray = new int[array.length];
		doMerge(0, array.length - 1);
	}

	private void doMerge(int low, int high) {
		if (low < high) {
			int middle = low + (high - low) / 2;
			doMerge(low, middle);
			doMerge(middle + 1, high);
			merge(low, middle, high);
		}
	}

	private void merge(int low, int middle, int high) {
		for (int i = low; i <= high; i++) {
			tempArray[i] = array[i];
		}

		int i = low;
		int j = middle + 1;
		int k = low;
		while (i <= middle && j <= high) {
			if (tempArray[i] <= tempArray[j]) {
				array[k] = tempArray[i];
				i++;
			} else {
				array[k] = tempArray[j];
				j++;
			}
			k++;
		}
		while (i <= middle) {
			array[k] = tempArray[i];
			i++;
			k++;
		}
	}
}
