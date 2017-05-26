package algorithms.mishra.dev.rahul.hackerrank.arrays;

import java.util.Scanner;

//public class AlgorithmicCrush {
//
//	public static void main(String[] args) {
//		int maxValue = 0;
//		Scanner scanner = new Scanner(System.in);
//		int[] arr = new int[scanner.nextInt()];
//		int noOfOperations = scanner.nextInt();
//		
//		while(noOfOperations > 0) {
//			noOfOperations--;
//			int startIndex = scanner.nextInt() - 1;
//			int endIndex = scanner.nextInt() - 1;
//			int kValue = scanner.nextInt();
//			for(int i = startIndex; i <= endIndex; i++) {
//				arr[i] = arr[i] + kValue;
//				maxValue = arr[i] > maxValue ? arr[i] : maxValue;
//			}
//		}
//		scanner.close();
//		System.out.println(maxValue);
//	}
//}

public class AlgorithmicCrush {
    
    static class Operation {
        public int a;
        public int b;
        public int k;
    
        public Operation(int a, int b, int k) {
            this.a = a;
            this.b = b;
            this.k = k;
        }
    
        public String toString() {
            return "[" + a + ", " + b + ", " + k + "]";
        }
    }
    
    public static long crush(int n, int m, Operation[] ops) {
        long[] crushState = new long[n+1];
        for(int i=0; i < m; i++) {
            crushState[ops[i].a-1] += ops[i].k;
            crushState[ops[i].b] -= ops[i].k;
        }
        
        long max = crushState[0];
        long sum = max;
        for(int i=1; i < n; i++) {
            sum += crushState[i];
            if(sum > max) {
                max = sum;
            }
        }
        
        return max;
    }

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        /* https://www.hackerrank.com/contests/w4/challenges/crush */
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        Operation[] ops = new Operation[m];
        
        for(int i=0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int k = sc.nextInt();
            ops[i] = new Operation(a, b, k);
        }
        
        long max = crush(n, m, ops);
        System.out.println(max);
    }
    
}
