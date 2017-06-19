/**
 * 
 */
package algorithms.mishra.dev.rahul.hackerrank.problems.implementation;

import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/migratory-birds
 * 
 * @author Rahul Dev Mishra
 * @assignment  
 * @date 17-Jun-2017 2:57:48 PM
 *
 */
public class MigratoryBirds {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] ar = new int[n];
        for(int ar_i = 0; ar_i < n; ar_i++){
            ar[ar_i] = in.nextInt();
        }
        int result = migratoryBirds(n, ar);
        System.out.println(result);
        in.close();
	}
	
	private static int migratoryBirds(int n, int[] ar) {
		int[] freqArray = {-1, 0, 0, 0, 0, 0};
		int maxCount = 0;
		int maxIndex = -1;
		for(int i = 0; i < n; i++) {
			++freqArray[ar[i]]; 
		}
		
		for(int i = 1; i < freqArray.length; i++) {
			if(maxCount < freqArray[i]) {
				maxCount = freqArray[i];
				maxIndex = i;
			} else if (maxCount == freqArray[i]) {
				maxIndex = maxIndex > i ? i : maxIndex;
			}
 		}
		return maxIndex;
    }
}
