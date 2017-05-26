/**
 * 
 */
package algorithms.mishra.dev.rahul.hackerrank.arrays;

import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/array-left-rotation
 * 
 * @author Rahul Dev Mishra
 * @assignment  
 * @date 22-May-2017 12:49:47 PM
 *
 */
public class LeftRotation {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int noOfRotations = scanner.nextInt();
		int[] arr = new int[n];
		for(int i = 0; i < n; i++){
			arr[i] = scanner.nextInt();
		}
		scanner.close();
		
		arr = leftRotation(arr, noOfRotations);
		for(int i = 0; i < n; i++){
			System.out.print(arr[i] + " ");
		}
	}
	
	private static int[] leftRotation(int[] arr, int noOfRotations) {
		int[] temp = arr;
		arr = new int[temp.length];
		
		int index = 1;
		for(int i = arr.length - 1; i >= arr.length - noOfRotations; i--) {
			arr[i] = temp[noOfRotations - index];
			index++;
		}
		
		index = 0;
		for(int i = 0; i < arr.length - noOfRotations; i++) {
			arr[i] = temp[noOfRotations + index];
			index++;
		}
		
		return arr;
	}

}
