/**
 * 
 */
package algorithms.mishra.dev.rahul.datastructure.linkedlist;

/**
 * @author Rahul Dev Mishra
 * @assignment  
 * @date 16-May-2017 8:04:29 PM
 *
 */
public class LinkedList {
	private Node head;
	
	public void add(int value) {
		if(head == null) {
			head = new Node(value);
			return;
		}
		
		Node next = head.right;
		Node curr = head;
		while(next != null) {
			curr = next;
			next = curr.right;
		}
		
		next = new Node(value);
		curr.right = next;
	}
	
	@Override
	public String toString() {
		return head.toString();
	}
	
	public Node getHead() {
		return head;
	}

}

class Node {
	public int value;
	public Node left;
	public Node right;
	
	public Node(){}
	
	public Node(int value) {
		this.value = value;
	}
	
	public Node(int value, Node left, Node right) {
		this(value);
		this.left = left;
		this.right = right;
	}
	
	@Override
	public String toString() {
		String str = value + " --> " + right;
		return str;
	}
}
