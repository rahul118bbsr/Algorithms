package algorithms.mishra.dev.rahul.quora.arrays;

import java.util.Scanner;

/**
 * Created by aleesha on 19/07/17.
 */
public class FirstNonRepeatingCharacterInString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the String: ");
        System.out.println(findFirstNonRepeatingCharacter(scanner.nextLine()));
    }

    private static char findFirstNonRepeatingCharacter(String string) {
        int[] array = new int[26];
        for(int i = 0; i < string.length(); i++) {
            array[string.charAt(i) - 'A']++;
        }
        for(int i = 0; i < string.length(); i++) {
            if(array[string.charAt(i) - 'A'] == 1) {
                return string.charAt(i);
            }
        }
        System.out.println("No repeating characters found in the string " + string);
        return ' ';
    }
}
