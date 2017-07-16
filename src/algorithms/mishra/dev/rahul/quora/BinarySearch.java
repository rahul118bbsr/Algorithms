/**
 * 
 */
package algorithms.mishra.dev.rahul.quora;

/**
 * @author Rahul Dev Mishra
 * @assignment  
 * @date 11-Jul-2017 5:24:07 PM
 *
 */
public class BinarySearch {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] array = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15};
		System.out.println(binarySearch(array, 0));
	}
	
	private static int binarySearch(int[] array, int key) {
		int left = 0;
		int right = array.length;
		int mid = 0;
		while(left <= right) {
			mid = (left + right) / 2;
			if(array[mid] == key) {
				return mid;
			} else if (key < array[mid]) {
				right = mid - 1;
			} else {
				left = mid + 1;
			}
		}
		return -1;
	}
}
