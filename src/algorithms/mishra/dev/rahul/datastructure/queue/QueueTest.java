/**
 * 
 */
package algorithms.mishra.dev.rahul.datastructure.queue;

/**
 * @author Rahul Dev Mishra
 * @assignment  
 * @date 07-Jun-2017 11:07:18 AM
 *
 */
public class QueueTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		QueueImpl queue = new QueueImpl();
		queue.add(5); queue.add(10); queue.add(1); queue.add(2); queue.add(4); queue.add(12);
		System.out.println(queue);
		System.out.println(queue.peek());
		System.out.println("Poll: " + queue.poll());
		System.out.println(queue);
		System.out.println("Poll: " + queue.poll());
		System.out.println(queue);
		System.out.println("Poll: " + queue.poll());
		System.out.println(queue);
		System.out.println("Poll: " + queue.poll());
		System.out.println(queue);
		System.out.println("Poll: " + queue.poll());
		System.out.println(queue);
		System.out.println("Poll: " + queue.poll());
		System.out.println(queue);
		System.out.println("Poll: " + queue.poll());
		System.out.println(queue);

	}

}
