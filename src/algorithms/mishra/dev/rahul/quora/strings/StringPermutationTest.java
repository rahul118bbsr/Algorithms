/**
 * 
 */
package algorithms.mishra.dev.rahul.quora.strings;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.TreeMap;

/**
 * https://www.youtube.com/watch?v=nYFd7VHKyWQ
 * 
 * @author Rahul Dev Mishra
 * @assignment
 * @date 06-Jul-2017 4:20:16 PM
 *
 */
public class StringPermutationTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the string: ");
		String word = scanner.nextLine();
		scanner.close();
		StringPermutation stringPermutation = new StringPermutationTest().new StringPermutation();
		System.out.println("Result: ");
		System.out.println("Lexographical Order: " + stringPermutation.findAllPermutationOfString(word, true));
		System.out.println("Non-Lexographical Order: " + stringPermutation.findAllPermutationOfString(word, false));

	}

	class StringPermutation {
		private List<String> list = new ArrayList<>();

		public List<String> findAllPermutationOfString(String word, boolean lexographicalOrder) {
			Map<Character, Integer> map = lexographicalOrder ? countFrequencyOfDistinctCharacters(word, new TreeMap<>())
					: countFrequencyOfDistinctCharacters(word, new HashMap<>());
			list.clear();

			char[] array = new char[word.length()];
			char[] distinctChar = new char[map.size()];
			int[] distinctCharCount = new int[map.size()];
			int i = 0;

			for (Entry<Character, Integer> entry : map.entrySet()) {
				distinctChar[i] = entry.getKey();
				distinctCharCount[i] = entry.getValue();
				i++;
			}
			findAllPermutation(distinctChar, distinctCharCount, array, 0);
			return list;
		}

		public Map<Character, Integer> countFrequencyOfDistinctCharacters(String word, Map<Character, Integer> map) {
			for (Character c : word.toCharArray()) {
				if (map.get(c) == null) {
					map.put(c, 1);
				} else {
					map.put(c, map.get(c) + 1);
				}
			}
			return map;
		}

		private void findAllPermutation(char[] distinctChar, int[] distinctCharCount, char[] result, int level) {
			if (level == result.length) {
				list.add(new String(result));
				return;
			}

			for (int i = 0; i < distinctChar.length; i++) {
				if (distinctCharCount[i] > 0) {
					result[level] = distinctChar[i];
					distinctCharCount[i]--;
					findAllPermutation(distinctChar, distinctCharCount, result, level + 1);
					distinctCharCount[i]++;
				}
			}

		}
	}
}
