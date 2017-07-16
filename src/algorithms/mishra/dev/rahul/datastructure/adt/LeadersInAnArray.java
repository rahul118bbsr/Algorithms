/**
 * 
 */
package algorithms.mishra.dev.rahul.datastructure.adt;

import java.util.Arrays;
import java.util.Scanner;

/**
 * http://www.ideserve.co.in/learn/leaders-in-an-array
 * A leader is an element which is larger than all the elements in the array to its next.
 * 
 * @author Rahul Dev Mishra
 * @assignment  
 * @date 01-Jun-2017 7:38:02 PM
 *
 */
public class LeadersInAnArray {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the number of elements in the array: ");
		int[] array = new int[scanner.nextInt()];
		System.out.println("Enter the array elements: ");
		for(int i = 0; i < array.length; i++) {
			array[i] = scanner.nextInt();
		}
		scanner.close();
		Arrays.stream(array).forEach(i -> System.out.println(i));
		findLeaders(array);
	}
	
	private static void findLeaders(int[] array) {
		System.out.println("Current Leaders: ");
		int currentLeader = array[array.length - 1];
		System.out.println(currentLeader);
		for(int i = array.length - 1; i >= 0; i--) {
			if(array[i] > currentLeader) {
				System.out.println(array[i]);
				currentLeader = array[i];
			}
		}
	}

}
