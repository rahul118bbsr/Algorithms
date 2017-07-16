/**
 * 
 */
package algorithms.mishra.dev.rahul.geeksforgeeks.dynamicprogramming;

import java.util.Arrays;

/**
 * http://www.geeksforgeeks.org/largest-sum-contiguous-subarray/
 * http://www.programcreek.com/2013/02/leetcode-maximum-subarray-java/
 * 
 * @author Rahul Dev Mishra
 * @assignment  
 * @date 10-Jul-2017 2:49:10 PM
 *
 */
public class LargestSubarraySumProblem {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] arr = {-2, -3, 4, -1, -2, 1, 5, -3};
		findLargestSubarraySum(arr);
		findLargestSubarraySum_2(arr);
	}

	private static void findLargestSubarraySum(int[] arr) {
		int[] result = Arrays.copyOf(arr, arr.length);
		int maxSumSoFar = result[0]; 
		
		for(int i = 1; i < arr.length; i++) {
			result[i] = Math.max(result[i - 1] + result[i], arr[i]);
			maxSumSoFar = Math.max(result[i], maxSumSoFar);
		}
		System.out.println("Maximum Sum: " + maxSumSoFar);
	}
	
	// Space complexity is O(1)
	private static void findLargestSubarraySum_2(int[] arr) {
		int newSum = arr[0];
		int maxSumSoFar = newSum; 
		
		for(int i = 1; i < arr.length; i++) {
			newSum = Math.max(newSum + arr[i], arr[i]);
			maxSumSoFar = Math.max(newSum, maxSumSoFar);
		}
		System.out.println("Maximum Sum: " + maxSumSoFar);
	}

}
