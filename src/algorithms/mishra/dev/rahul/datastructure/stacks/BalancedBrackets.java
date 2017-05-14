/**
 * 
 */
package algorithms.mishra.dev.rahul.datastructure.stacks;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Stack;

/**
 * @author Rahul Dev Mishra
 * @assignment  
 * @date 12-May-2017 11:22:19 PM
 *
 */
public class BalancedBrackets {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
        for(int a0 = 0; a0 < t; a0++){
            String s = in.next();
            check(s);
        }
        in.close();
	}
	
	private static void check(String str) {
		Map<Character, Character> map = new HashMap<Character, Character>();
		map.put('}', '{');
		map.put(']', '[');
		map.put(')', '(');
		
		Stack<Character> stack = new Stack<>();
		for(int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);
			Character bracket = null;
            if(stack.isEmpty()) {
            	stack.push(c);
            	continue;
            }
            
            bracket = stack.pop();
            if(bracket != null && bracket == map.get(c)) {
            	// match is found
            } else {
            	stack.push(bracket);
            	stack.push(c);
            }
		}
		
		String result = stack.isEmpty() ? "YES" : "NO";
        System.out.println(result);
	}

}
