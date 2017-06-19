/**
 * 
 */
package algorithms.mishra.dev.rahul.hackerrank.problems.implementation;

import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/kangaroo
 * 
 * @author Rahul Dev Mishra
 * @assignment  
 * @date 12-Jun-2017 11:19:47 AM
 *
 */
public class Kangaroo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
        int x1 = in.nextInt();
        int v1 = in.nextInt();
        int x2 = in.nextInt();
        int v2 = in.nextInt();
        String result = kangaroo(x1, v1, x2, v2);
        System.out.println(result);
        in.close();
	}
	
	static String kangaroo(int x1, int v1, int x2, int v2) {
		if(x2 > x1 && v2 >= v1) {
			return "NO";
		}
		
		return (x1 - x2) % (v2 - v1) == 0 ? "YES" : "NO";    
    }

}
