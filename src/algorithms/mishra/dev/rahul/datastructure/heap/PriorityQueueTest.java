/**
 * 
 */
package algorithms.mishra.dev.rahul.datastructure.heap;

/**
 * @author Rahul Dev Mishra
 * @assignment  
 * @date 06-Jun-2017 8:24:50 PM
 *
 */
public class PriorityQueueTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] values = {30, 25, 29, 20, 18, 28, 21, 10, 15, 9};
		PriorityQueueImpl pq = new PriorityQueueImpl();
		pq.addAll(values);
		System.out.println(pq);
		pq.add(26);
		System.out.println(pq);
		System.out.println(pq.peek());
		System.out.println(pq.poll());
		System.out.println(pq);
		System.out.println(pq.poll());
		System.out.println(pq.poll());
		System.out.println(pq);
		System.out.println(pq.poll());
		System.out.println(pq);
	}
}
