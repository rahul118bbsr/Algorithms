/**
 * 
 */
package algorithms.mishra.dev.rahul.datastructure.adt;

/**
 * http://www.ideserve.co.in/learn/longest-increasing-subsequence-nlogn x = [0,
 * 8, 4, 12, 2, 10, 6, 14, 1, 9, 5, 13, 3, 11, 7, 15] lis = [0, 2, 6, 9, 11, 15]
 * 
 * X = {3,1,5,2,6,4,9} LIS(X) = {1,2,4,9}
 * 
 * @author Rahul Dev Mishra
 * @assignment
 * @date 13-Jun-2017 10:38:06 PM
 *
 */
public class LongestIncreasingSubsequence {

	// Driver program to test above function
	public static void main(String[] args) {
		int A[] = { 0, 8, 4, 12, 2, 10, 6, 14, 1, 9, 5, 13, 3, 11, 7, 15 };
		int n = A.length;
		System.out.println("Length of Longest Increasing Subsequence is " + LongestIncreasingSubsequenceLength(A, n));
		LIS(A);
	}

	// Java program to find length of longest increasing subsequence
	// in O(n Log n) time
	// Binary search (note boundaries in the caller)
	// A[] is ceilIndex in the caller
	static int CeilIndex(int A[], int l, int r, int key) {
		while (r - l > 1) {
			int m = l + (r - l) / 2;
			if (A[m] >= key)
				r = m;
			else
				l = m;
		}

		return r;
	}

	static int LongestIncreasingSubsequenceLength(int A[], int size) {
		// Add boundary case, when array size is one

		int[] tailTable = new int[size];
		int len; // always points empty slot

		tailTable[0] = A[0];
		len = 1;
		for (int i = 1; i < size; i++) {
			if (A[i] < tailTable[0])
				// new smallest value
				tailTable[0] = A[i];

			else if (A[i] > tailTable[len - 1])
				// A[i] wants to extend largest subsequence
				tailTable[len++] = A[i];

			else
				// A[i] wants to be current end candidate of an existing
				// subsequence. It will replace ceil value in tailTable
				tailTable[CeilIndex(tailTable, -1, len - 1, A[i])] = A[i];
		}

		return len;
	}

	public static void LIS(int X[]) {
		int parent[] = new int[X.length]; // Tracking the predecessors/parents of elements of each subsequence.
		int increasingSub[] = new int[X.length + 1]; // Tracking ends of each increasing subsequence.
		int length = 0; // Length of longest subsequence.

		for (int i = 0; i < X.length; i++) {
			// Binary search
			int low = 1;
			int high = length;
			while (low <= high) {
				int mid = (int) Math.ceil((low + high) / 2);

				if (X[increasingSub[mid]] < X[i])
					low = mid + 1;
				else
					high = mid - 1;
			}

			int pos = low;
			// update parent/previous element for LIS
			parent[i] = increasingSub[pos - 1];
			// Replace or append
			increasingSub[pos] = i;

			// Update the length of the longest subsequence.
			if (pos > length)
				length = pos;
		}

		// Generate LIS by traversing parent array
		int LIS[] = new int[length];
		int k = increasingSub[length];
		for (int j = length - 1; j >= 0; j--) {
			LIS[j] = X[k];
			k = parent[k];
		}

		for (int i = 0; i < length; i++) {
			System.out.println(LIS[i]);
		}

	}
}
