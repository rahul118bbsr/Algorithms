/**
 * 
 */
package algorithms.mishra.dev.rahul.datastructure.stacks;

/**
 * @author Rahul Dev Mishra
 * @assignment  
 * @date 07-Jun-2017 8:59:28 AM
 *
 */
public class StackTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Stack stack = new Stack();
		stack.push(10); stack.push(20); stack.push(5); stack.push(15); stack.push(8); stack.push(2); stack.push(200);
		System.out.println(stack);
		System.out.println("Pop: " + stack.pop());
		System.out.println(stack);
		System.out.println("Pop: " + stack.pop());
		System.out.println(stack);
	}

}
