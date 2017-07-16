/**
 * 
 */
package algorithms.mishra.dev.rahul.quora.sort;

/**
 * @author Rahul Dev Mishra
 * @assignment  
 * @date 12-Jul-2017 12:35:16 PM
 *
 */
public class MergeSort_1 {
	private int[] array;
	private int[] tempArray;
	
	public static void main(String[] args) {
		int[] inputArr = {45, 23, 11, 89, 77, 98, 4};
		new MergeSort_1().sort(inputArr);
		for (int i : inputArr) {
			System.out.print(i + " ");
		}
	}
	
	public void sort(int[] inputArr) {
		array = inputArr;
		tempArray = new int[array.length];
		doSort(0, array.length - 1);
	}
	
	private void doSort(int low, int high) {
		if(low < high) {
			int mid = low + (high - low) / 2;
			doSort(low, mid);
			doSort(mid + 1, high);
			merge(low, mid, high);
		}
	}

	private void merge(int low, int mid, int high) {
		for(int i = low; i <= high; i++) {
			tempArray[i] = array[i];
		}
		int i = low;
		int j = mid + 1;
		int k = low;
		while(i <= mid && j <= high) {
			if(tempArray[i] <= tempArray[j]) {
				array[k] = tempArray[i];
				i++;
			} else {
				array[k] = tempArray[j];
				j++;
			}
			k++;
		}
		
		while(i <= mid) {
			array[k] = tempArray[i];
			i++;
			k++;
		}
	}

}