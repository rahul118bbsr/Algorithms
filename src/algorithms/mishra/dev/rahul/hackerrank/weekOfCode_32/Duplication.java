package algorithms.mishra.dev.rahul.hackerrank.weekOfCode_32;

import java.util.Scanner;

/**
 * https://www.hackerrank.com/contests/w32/challenges/duplication
 * 
 * @author Rahul Dev Mishra
 * @assignment  
 * @date 15-May-2017 5:33:12 PM
 *
 */
public class Duplication {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
        int q = in.nextInt();
        for(int a0 = 0; a0 < q; a0++){
            int x = in.nextInt();
            String result = duplication(x);
            System.out.println(result);
        }
        in.close();
	}
	
	static String duplication(int x){
		String d = "0110100110010110100101100110100110010110011010010110100110010110100101100110100101101001100101100110100110010110100101100110100110010110011010010110100110010110011010011001011010010110011010010110100110010110100101100110100110010110011010010110100110010110100101100110100101101001100101100110100110010110100101100110100101101001100101101001011001101001100101100110100101101001100101100110100110010110100101100110100110010110011010010110100110010110100101100110100101101001100101100110100110010110100101100110100110010110011010010110100110010110011010011001011010010110011010010110100110010110100101100110100110010110011010010110100110010110011010011001011010010110011010011001011001101001011010011001011010010110011010010110100110010110011010011001011010010110011010010110100110010110100101100110100110010110011010010110100110010110100101100110100101101001100101100110100110010110100101100110100110010110011010010110100110010110011010011001011010010110011010010110100110010110100101100110100110010110011010010110100110010110";
		return String.valueOf(d.charAt(x));
    }

}
