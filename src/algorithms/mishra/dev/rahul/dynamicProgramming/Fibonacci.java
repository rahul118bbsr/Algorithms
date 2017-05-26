package algorithms.mishra.dev.rahul.dynamicProgramming;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Fibonacci {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the number of terms: ");
		int n = scanner.nextInt();
		scanner.close();
		Fibonacci fibonacci = new Fibonacci();
		fibonacci.naive(n);
		fibonacci.dp(n);
	}

	private void naive(int n) {
		long[] results = new long[n];
		results[0] = 0;
		results[1] = 1;
		System.out.print(0 + ", " + 1 + ", ");
		
		for (int i = 2; i < n; i++) {
			results[i] = fib(i);
			System.out.print(results[i] + ", ");
		}
		System.out.println("\n");
		System.out.println("Done via Naive Method!!!");
	}

	private long fib(int n) {
		if (n == 0)
			return 0;
		else if (n == 1)
			return 1;

		return fib(n - 1) + fib(n - 2);
	}
	
	private void dp(int n) {
		List<Long> memoList = new ArrayList<>();
		memoList.add(0l); memoList.add(1l);
		for (int i = 2; i < n; i++) {
			memoList.add(fibWithDPRecursively(i, memoList));
		}
		System.out.println(memoList);
		System.out.println("Done via DP Method!!!");
	}
	
	private long fibWithDPRecursively(int n, List<Long> memoList) {
		if(memoList.size() > n && memoList.get(n) != null) {
			return memoList.get(n);
		}
		
		return fibWithDPRecursively(n - 1, memoList) + fibWithDPRecursively(n - 2, memoList);
	}
	
	private void fibWithDPIteratively(int num, List<Long> fibList) {
        fibList.add(0l);
        fibList.add(1l);

        for(int i = 2; i <= num; i++) {
            fibList.add(i, fibList.get(i - 1) + fibList.get(i - 2));
        }
    }

}
