/**
 * 
 */
package algorithms.mishra.dev.rahul.quora.linkedlist;

/**
 * @author Rahul Dev Mishra
 * @assignment
 * @date 30-Jun-2017 3:20:38 PM
 *
 */
public class DetectLoopInSingleLinkedList {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		LinkedList list = new DetectLoopInSingleLinkedList().new LinkedList();
		Node head = list.create();
		System.out.println(list.detectLoop(head).data);
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

		public Node create() {
			Node head = new Node(1);
			head.next = new Node(2);
			Node loopNode = new Node(3);
			head.next.next = loopNode;
			head.next.next.next = new Node(4);
			head.next.next.next.next = new Node(5);
			head.next.next.next.next.next = new Node(6);
			head.next.next.next.next.next.next = new Node(7);
			head.next.next.next.next.next.next.next = loopNode;
			return head;
		}

		public Node detectLoop(Node head) {
			if (head == null) {
				return head;
			}

			Node slow = head;
			Node fast = head;

			while (fast != null && fast.next != null) {
				slow = slow.next;
				fast = fast.next.next;
				if (slow == fast) {
					return findStartingNodeOfLoop(head, fast);
				}
			}
			System.out.println("No Loop detected...");
			return head;
		}

		private Node findStartingNodeOfLoop(Node head, Node fast) {
			Node slow = head;
			while (slow != fast) {
				slow = slow.next;
				fast = fast.next;
			}
			return slow;
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
