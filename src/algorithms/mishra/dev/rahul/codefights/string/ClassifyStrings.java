/**
 * 
 */
package algorithms.mishra.dev.rahul.codefights.string;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Rahul Dev Mishra
 * @assignment
 * @date 22-Jun-2017 7:03:28 PM
 *
 */
public class ClassifyStrings {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(classifyStrings("?"));
	}

	static String classifyStrings(String s) {
		Set<Character> vowels = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u'));
		int vCount = 0;
		int cCount = 0;
		String result = "good";
		boolean hasQuestion = false;
		for (char c : s.toCharArray()) {
			if (vowels.contains(c)) {
				cCount = 0;
				vCount++;
				if (vCount == 3) {
					return "bad";
				}
			} else {
				vCount = 0;
				if (c == '?') {
					hasQuestion = true;
				} else {
					cCount++;
					if (cCount == 5) {
						return "bad";
					}
				}
			}
		}
		result = hasQuestion && s.length() > 1 ? "mixed" : "good";
		return result;

	}

}
