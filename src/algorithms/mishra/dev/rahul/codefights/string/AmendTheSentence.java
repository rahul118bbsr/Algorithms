/**
 * 
 */
package algorithms.mishra.dev.rahul.codefights.string;

/**
 * @author Rahul Dev Mishra
 * @assignment
 * @date 22-Jun-2017 3:35:55 PM
 *
 */
public class AmendTheSentence {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
//		System.out.println(amendTheSentence("CodefightsIsAwesome"));
		System.out.println(findFirstSubstringOccurrence("CodefightsIsAwesome", "IsA"));
	}

	static String amendTheSentence(String s) {
		String result = "";
		for (int i = 0; i < s.length(); i++) {
			if (Character.isUpperCase(s.charAt(i))) {
				result = i == 0 ? result + Character.toLowerCase(s.charAt(i))
						: result + " " + Character.toLowerCase(s.charAt(i));
			} else {
				result = result + s.charAt(i);
			}
		}
		return result;
	}

	static int findFirstSubstringOccurrence(String s, String x) {
		int hash = x.hashCode();
		int count = 0;	
		while(s.length() >= x.length()) {
			if(hash == s.substring(0, x.length()).hashCode()) {
				return count;
			}
			
			count = count + x.length();
			s = s.substring(x.length() - 1);
		}
		return -1;

	}

}
