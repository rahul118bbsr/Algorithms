package algorithms.mishra.dev.rahul.leetcode;

/**
 * https://leetcode.com/problems/reverse-words-in-a-string-iii/
 * <p>
 * Created by aleesha on 13/07/17.
 */
public class ReverseWords {
    public static void main(String[] args) {
        System.out.println("[" + reverseWords("Let's take LeetCode contest") + "]");
    }

    public static String reverseWords(String s) {
        StringBuilder result = new StringBuilder();
        StringBuilder temp = new StringBuilder();
        for (String word : s.split(" ")) {
            temp.append(word.toCharArray()).reverse();
            result.append(temp).append(" ");
            temp.setLength(0);
        }
        return result.deleteCharAt(result.length() - 1).toString();

        /*
         * 1 line solution
         * return new ArrayList<>(Arrays.asList(s.split(" "))).stream()
         *  .map(str -> new StringBuilder(str).reverse().toString())
         *  .collect(Collectors.joining(" "));
         */
    }
}
