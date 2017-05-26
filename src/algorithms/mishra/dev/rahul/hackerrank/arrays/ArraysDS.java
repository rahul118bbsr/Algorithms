package algorithms.mishra.dev.rahul.hackerrank.arrays;

import java.util.Scanner;

public class ArraysDS {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int arrLength = scanner.nextInt();
		int[] arr = new int[arrLength];
		for(int i = 0; i < arrLength; i++) {
			arr[i] = scanner.nextInt();
		}
		scanner.close();
		
		for(int i = arrLength - 1; i >= 0; i--) {
			System.out.print(arr[i] + " ");
		}
	}
}
