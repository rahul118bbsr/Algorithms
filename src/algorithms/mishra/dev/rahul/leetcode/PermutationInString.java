package algorithms.mishra.dev.rahul.leetcode;

import java.util.*;

/**
 * https://leetcode.com/problems/permutation-in-string/#/description
 * 
 * Created by aleesha on 20/05/17.
 */
public class PermutationInString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter String s1 and s2: ");
        String s1 = scanner.nextLine();
        String s2 = scanner.nextLine();
        scanner.close();
        PermutationInString permutationInString = new PermutationInString();
        System.out.println(permutationInString.checkInclusion(s1, s2));
    }

    public boolean checkInclusion(String s1, String s2) {
        int len1 = s1.length(), len2 = s2.length();
        if (len1 > len2) return false;

        int[] count = new int[26];
        for (int i = 0; i < len1; i++) {
            count[s1.charAt(i) - 'a']++;
            count[s2.charAt(i) - 'a']--;
        }
        if (allZero(count)) return true;

        for (int i = len1; i < len2; i++) {
            count[s2.charAt(i) - 'a']--;
            count[s2.charAt(i - len1) - 'a']++;
            if (allZero(count)) return true;
        }

        return false;
    }

    private boolean allZero(int[] count) {
        for (int i = 0; i < 26; i++) {
            if (count[i] != 0) return false;
        }
        return true;
    }
}