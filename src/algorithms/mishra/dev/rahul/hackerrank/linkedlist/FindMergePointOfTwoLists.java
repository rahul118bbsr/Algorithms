/**
 * 
 */
package algorithms.mishra.dev.rahul.hackerrank.linkedlist;

/**
 * https://www.hackerrank.com/challenges/find-the-merge-point-of-two-joined-linked-lists
 * StackOverflow solution: https://stackoverflow.com/questions/1594061/check-if-two-linked-lists-merge-if-so-where/14956113#14956113
 * 
 * @author Rahul Dev Mishra
 * @assignment  
 * @date 26-May-2017 12:40:06 PM
 *
 */
public class FindMergePointOfTwoLists {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

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
		
		public int findMergeNode(Node headA, Node headB) {
			Node nodeA = headA;
			Node nodeB = headB;
			while(true) {
				if(nodeA == nodeB) {
					return nodeA.data;
				}
				
				nodeA = nodeA.next;
				nodeB = nodeB.next;
				nodeA = nodeA == null ? headB : nodeA;
				nodeB = nodeB == null ? headA : nodeB;
			}
		}
	}
	
	class Node {
		int data;
		Node next;
		
		Node(int data) {
			this.data = data;
		}
		
		@Override
		public String toString() {
			return data + "-->" + next;
		}
	}

}
