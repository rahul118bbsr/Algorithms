/**
 * 
 */
package algorithms.mishra.dev.rahul.datastructure.adt;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * http://www.ideserve.co.in/learn/find-duplicates-in-an-array
 * 
 * @author Rahul Dev Mishra
 * @assignment  
 * @date 13-Jun-2017 7:51:20 PM
 *
 */
public class FindDuplicatesInIntegerArray {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the number of elements: ");
		int n = scanner.nextInt();
		System.out.println("Enter the elements in a sorted manner: ");
		int[] array = new int[n];
		for (int i = 0; i < n; i++) {
			array[i] = scanner.nextInt();
		}
		scanner.close();
		System.out.println(getDuplicates(array));
	}
	
	public static Set<Integer> getDuplicates(int[] array) {
        int n = array.length;
        Set<Integer> duplicates = new HashSet<Integer>();
        for(int i = 0; i < n; i++) {
            // Make the array element at index array[i] negative if it is positive
            if(array[Math.abs(array[i])] > 0) {
                array[Math.abs(array[i])] = -array[Math.abs(array[i])];
            } else {
                // If the element at index array[i] is negative, it means we have seen it before, so it is a duplicate
                duplicates.add(Math.abs(array[i]));
            }
        }
        return duplicates;
    }

}
