/**
 * 
 */
package algorithms.mishra.dev.rahul.algorithms.dynamicprogramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author Rahul Dev Mishra
 * @assignment  
 * @date 07-Jul-2017 11:27:40 PM
 *
 */
public class MaximumSumIncreasingSubsequence {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] array = {7, 6, 1, 3, 7, 4, 6};
		findMaximumIncreasingSubsequence(array);
	}

	private static void findMaximumIncreasingSubsequence(int[] inputArray) {
		int[] sumArray = Arrays.copyOf(inputArray, inputArray.length);
		int[] pointerArray = new int[inputArray.length];
		for(int i = 0; i < pointerArray.length; i++) {
			pointerArray[i] = i;
		}
		
		for(int i = 1; i < inputArray.length; i++) {
			for(int j = 0; j < i; j++) {
				if(inputArray[j] < inputArray[i]) {
					// If new sum is greater than existing value in the sum array, then update pointer array
					pointerArray[i] = sumArray[j] + inputArray[i] > sumArray[i] ? j : pointerArray[i];
					sumArray[i] = Math.max(sumArray[i], sumArray[j] + inputArray[i]);
				}
			}
		}
		findMaxSumAndElements(inputArray, sumArray, pointerArray);
	}

	private static void findMaxSumAndElements(int[] inputArray, int[] sumArray, int[] pointerArray) {
		int maxSum = sumArray[0];
		int index = 0;
		for(int i = 0; i < sumArray.length; i++) {
			index = sumArray[i] > maxSum ? i : index;
			maxSum = sumArray[i] > maxSum ? sumArray[i] : maxSum;
		}
		
		System.out.println("Maximum Sum Increasing Subsequence: " + maxSum);
		List<Integer> subsequenceList = new ArrayList<>();
		while(maxSum > 0) {
			subsequenceList.add(inputArray[index]);
			maxSum -= inputArray[index];
			index = pointerArray[index];
		}
		Collections.reverse(subsequenceList);
		System.out.println("Maximum Sum Increasing Subsequence Elements: " + subsequenceList);
	}
}
