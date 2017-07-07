/**
 * 
 */
package algorithms.mishra.dev.rahul.quora.linkedlist;

/**
 * @author Rahul Dev Mishra
 * @assignment  
 * @date 30-Jun-2017 2:12:26 PM
 *
 */
public class AddToLinkedList {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		LinkedList linkedList = new AddToLinkedList().new LinkedList();
		Node head = linkedList.add(null, 1);
		linkedList.add(head, 2);
		linkedList.add(head, 3);
		linkedList.add(head, 5);
		linkedList.add(head, 7);
		System.out.println();
	}
	
	class LinkedList {
		public Node add(Node head, int data) {
			Node end = new Node(data);
			if(head == null) {
				return end;
			}
			
			Node curr = head;
			while(curr.next != null) {
				curr = curr.next;
			}
			curr.next = end;
			return head;
		}
	}
	
	class Node {
		Node next;
		int data;
		
		Node(int data) {
			this.data = data;
		}
	}

}
