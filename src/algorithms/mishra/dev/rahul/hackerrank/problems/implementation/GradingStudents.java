/**
 * 
 */
package algorithms.mishra.dev.rahul.hackerrank.problems.implementation;

import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/grading
 * 
 * @author Rahul Dev Mishra
 * @assignment
 * @date 12-Jun-2017 12:09:22 AM
 *
 */
public class GradingStudents {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int[] grades = new int[n];
		for (int grades_i = 0; grades_i < n; grades_i++) {
			grades[grades_i] = in.nextInt();
		}
		int[] result = solve(grades);
		for (int i = 0; i < result.length; i++) {
			System.out.print(result[i] + (i != result.length - 1 ? "\n" : ""));
		}
		System.out.println("");
		in.close();
	}

	private static int[] solve(int[] grades) {
		for(int i = 0; i < grades.length; i++) {
			if(grades[i] < 38) {
				grades[i] = grades[i];
				continue;
			}
			
			if(grades[i] % 5 > 2) {
				grades[i] = ((grades[i] / 5) + 1) * 5;
			}
		}
		return grades;
	}

}
