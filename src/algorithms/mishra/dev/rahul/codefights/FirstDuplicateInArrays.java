/**
 * 
 */
package algorithms.mishra.dev.rahul.codefights;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Rahul Dev Mishra
 * @assignment  
 * @date 22-Jun-2017 2:12:06 PM
 *
 */
public class FirstDuplicateInArrays {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] array = {9, 3, 2, 3, 5, 2};
		System.out.println(firstDuplicate(array));
	}
	
	static int firstDuplicate(int[] a) {
		int min = Integer.MAX_VALUE;
		Map<Integer, Integer> map = new HashMap<>();
		for(int i = 0; i < a.length; i++) {
			if(map.containsKey(a[i])) {
				min = min < i ? min : i;
			} else {
				map.put(a[i], i);
			}
		}
		return min == Integer.MAX_VALUE ? -1 : a[min];
	}

}
