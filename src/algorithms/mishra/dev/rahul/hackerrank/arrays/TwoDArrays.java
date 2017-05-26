package algorithms.mishra.dev.rahul.hackerrank.arrays;

import java.util.Scanner;

public class TwoDArrays {

	public static void main(String[] args) {
		int maxHourGlassSum = -100;
		Scanner scanner = new Scanner(System.in);
		int[][] array = new int[6][6];

		for (int i = 0; i < 6; i++) {
			for (int j = 0; j < 6; j++) {
				array[i][j] = scanner.nextInt();
			}
		}
		scanner.close();

		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				int sum = 0;
				int row = i;
				int column = j;
				sum = findRowSum(array, sum, row, column);
				if(++row > 5) {
					break;
				}
				
				sum = sum + array[row][++column];
				sum = findRowSum(array, sum, ++row, --column);
				maxHourGlassSum = sum > maxHourGlassSum ? sum : maxHourGlassSum;
			}
		}
		
		System.out.println(maxHourGlassSum);
	}

	private static int findRowSum(int[][] array, int sum, int row, int column) {
		int counter = 3;
		while (counter > 0) {
			counter--;
			if (column > 5 || row > 5) {
				return sum;
			}
			sum = sum + array[row][column];
			column++;
		}
		return sum;
	}
}