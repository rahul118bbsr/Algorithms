package algorithms.mishra.dev.rahul.leetcode;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * https://leetcode.com/problems/keyboard-row/
 *
 * Created by aleesha on 13/07/17.
 */
public class KeyboardRow {

    public static void main(String[] args) {
        String[] array = {"Hello", "Alaska", "Dad", "Peace"};
        String[] output = findWords(array);
        Arrays.stream(output).forEach(word -> System.out.print(word + " "));
    }

    public static String[] findWords(String[] words) {
        Map<Character, Integer> map = new HashMap<>();
        addToMap("QWERTYUIOP", map, 0);
        addToMap("ASDFGHJKL", map, 1);
        addToMap("ZXCVBNM", map, 2);
        List<String> result = new ArrayList<>();
        for(String word : words) {
            int level = -1;
            boolean isTrue = true;
            for(char ch : word.toCharArray()) {
                if(level == -1) {
                    level = map.get(Character.toUpperCase(ch));
                } else {
                    if(level != map.get(Character.toUpperCase(ch))) {
                        isTrue = false;
                        break;
                    }
                }
            }
            if(isTrue) {
                result.add(word);
            }
        }
        return result.toArray(new String[0]);
    }

    private static void addToMap(String word, Map<Character, Integer> map, int level) {
        for(char c : word.toCharArray()) {
            map.put(c, level);
        }
    }
}
