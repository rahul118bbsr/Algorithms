/**
 * 
 */
package algorithms.mishra.dev.rahul.codefights.linkedlist;

/**
 * @author Rahul Dev Mishra
 * @assignment
 * @date 22-Jun-2017 2:47:51 PM
 *
 */
public class RemoveKFromList {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		LinkedList list = new RemoveKFromList().new LinkedList();
		Node head = list.add(null, 1000);
		head = list.add(head, 1000);
//		head = list.add(head, 2);
//		head = list.add(head, 3);
//		head = list.add(head, 4);
//		head = list.add(head, 5);
		
		list.removeKFromList(head, 1000);
	}


	class LinkedList {
		public Node add(Node head, int data) {
			Node end = new Node(data);
			if (head == null) {
				return end;
			}

			Node curr = head;
			while (curr.next != null) {
				curr = curr.next;
			}
			curr.next = end;
			return head;
		}
		
		Node removeKFromList(Node l, int k) {
			Node c = l.next;
			Node prev = null;
			if (l.value == k) {
				l = l.next;
			}
			while (c != null) {
				if (c.value != k) {
					prev = c;
					c = c.next;
				} else {
					c = c.next;
					prev.next = c;
				}
			}
			return l;

		}
	}

	class Node {
		Node(int x) {
			value = x;
		}

		int value;
		Node next;
	}

}
