/**
 * 
 */
package algorithms.mishra.dev.rahul.quora.linkedlist;

/**
 * https://www.hackerrank.com/challenges/compare-two-linked-lists
 * 
 * @author Rahul Dev Mishra
 * @assignment  
 * @date 30-Jun-2017 7:37:15 PM
 *
 */
public class CompareTwoSingleLinkedLists {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		LinkedList list = new CompareTwoSingleLinkedLists().new LinkedList();
		Node head1 = list.add(null, 1);
		list.add(head1, 2);
		list.add(head1, 3);
		list.add(head1, 4);
		list.add(head1, 5);
		
		Node head2 = list.add(null, 1);
		list.add(head2, 2);
		list.add(head2, 3);
		list.add(head2, 4);
		list.add(head2, 5);
		System.out.println(list.compare(head1, head2));
		System.out.println(list.compare(head1, null));
		System.out.println(list.compare(null, null));
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
		
		public int compare(Node head1, Node head2) {
			if(head1 == null && head2 == null) {
				return 1;
			}
			
			if(head1 == null || head2 == null) {
				return 0;
			}
			
			Node curr1 = head1;
			Node curr2 = head2;
			
			while(curr1 != null && curr2 != null && curr1.data == curr2.data) {
				curr1 = curr1.next;
				curr2 = curr2.next;
			}
			return curr1 == null && curr2 == null ? 1 : 0;
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
