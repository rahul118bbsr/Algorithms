/**
 * 
 */
package algorithms.mishra.dev.rahul.datastructure.adt;

import java.util.Scanner;

/**
 * http://www.ideserve.co.in/learn/find-pivot-in-a-sorted-rotated-array
 * 
 * @author Rahul Dev Mishra
 * @assignment  
 * @date 13-Jun-2017 4:09:04 PM
 *
 */
public class FindPivotElementInSortedArray {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the number of elements: ");
		int n = scanner.nextInt();
		System.out.println("Enter the elements in a sorted manner: ");
		int[] array = new int[n];
		for(int i = 0; i < n; i++) {
			array[i] = scanner.nextInt();
		}
		scanner.close();
		System.out.println("Pivot Element: " + findPivotElement(array));
		System.out.println("Pivot Element: " + findPivotBinarySearch(array));
	}

	/*
	 * My Implementation
	 */
	private static Integer findPivotElement(int[] array) {
		int start = 0;
		int end = array.length - 1;
		if(array.length == 1 || array[0] < array[array.length - 1]) {
			return array[0];
		}
		
		while(start <= end) {
			int pivot = (start + end) / 2;
			if(array[pivot] > array[pivot + 1]) {
				return array[pivot + 1];
			}
			
			if(array[start] > array[pivot]) {
				end = pivot - 1;
			} else if(array[start] < array[pivot]) {
				start = pivot + 1;
			}
		}
		return null;
	}
	
	 // O(log n) solution - Binary Search
    public static int findPivotBinarySearch(int[] array) {
 
        if (array == null || array.length == 0) {
            return -1;
        }
 
        // Case when array is not rotated. Then first index is the pivot
        if (array.length == 1 || array[0] < array[array.length - 1]) {
            return 0;
        }
 
        int start = 0, end = array.length - 1;
 
        while (start <= end) {
 
            int mid = (start + end) / 2;
            // check if mid+1 is pivot
            if (mid < array.length-1 && array[mid] > array[mid+1]) {
                return (mid + 1);
            } else if (array[start] <= array[mid]) {
                // If array[start] <= array[mid],
                // it means from start to mid, all elements are in sorted order,
                // so pivot will be in second half
                start = mid + 1;
            } else {
                // else pivot lies in first half, so we find the pivot in first half
                end = mid - 1;
            }
        }
 
        return 0;
    }
}
