/**
 * 
 */
package algorithms.mishra.dev.rahul.codefights;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Rahul Dev Mishra
 * @assignment
 * @date 22-Jun-2017 2:20:14 PM
 *
 */
public class FirstNonRepeatingCharacter {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(firstNotRepeatingCharacter("ngrhhqbhnsipkcoqjyviikvxbxyphsnjpdxkhtadltsuxbfbrkof"));
	}

	static char firstNotRepeatingCharacter(String s) {
		char[] a = s.toCharArray();
		int[] count = new int[128];
		for (int i = 0; i < a.length; i++) {
			count[a[i]] = count[a[i]] + 1;
		}

		for (int i = 0; i < a.length; i++) {
			if (count[a[i]] == 1) {
				return a[i];
			}
		}
		return '_';
	}

	static int[][] rotateImage(int[][] matrix) {
		if (matrix.length == 0 || matrix.length != matrix[0].length)
			return matrix;
		int n = matrix.length;
		for (int layer = 0; layer < n / 2; layer++) {
			int first = layer;
			int last = n - 1 - layer;
			for (int i = first; i < last; i++) {
				int offset = i - first;
				int top = matrix[first][i];

				matrix[first][i] = matrix[last - offset][first];

				matrix[last - offset][first] = matrix[last][last - offset];

				matrix[last][last - offset] = matrix[i][last];
				matrix[i][last] = top;
			}
		}
		return matrix;
	}
}
