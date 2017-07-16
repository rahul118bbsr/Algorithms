/**
 * 
 */
package algorithms.mishra.dev.rahul.quora.trees;

import java.util.Stack;

/**
 * @author Rahul Dev Mishra
 * @assignment
 * @date 23-Jun-2017 8:04:27 PM
 *
 */
public class ConvertTreeToDoubleLinkedList {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		BST bst = new ConvertTreeToDoubleLinkedList().new BST();
		Node root = bst.add(null, 5);
		root = bst.add(root, 3);
		root = bst.add(root, 9);
		root = bst.add(root, 1);
		root = bst.add(root, 4);
		root = bst.add(root, 6);
		root = bst.add(root, 10);
		root = bst.add(root, 0);
		root = bst.add(root, 2);
		
		LinkedList linkedList = new ConvertTreeToDoubleLinkedList().new LinkedList();
		Node head1 = bst.convertTreeToLinkedList(root, null, linkedList);
		System.out.println(head1);
		
		Node head2 = bst.convertTreeToLinkedListIteratively(root);
		System.out.println(head2);
	}

	class BST {
		public Node add(Node root, int data) {
			Node end = new Node(data);
			if (root == null) {
				return end;
			}

			if (data <= root.data) {
				root.left = add(root.left, data);
			} else if (data > root.data) {
				root.right = add(root.right, data);
			}
			return root;
		}

		public Node convertTreeToLinkedList(Node root, Node head, LinkedList linkedList) {
			if (root == null) {
				return root;
			}

			if (root.left != null) {
				head = convertTreeToLinkedList(root.left, head, linkedList);
			}
			System.out.print(root.data + " ");
			head = linkedList.add(head, root.data);
			if (root.right != null) {
				head = convertTreeToLinkedList(root.right, head, linkedList);
			}

			return head;
		}
		
		public Node convertTreeToLinkedListIteratively(Node root) {
			Node head = null;
			if(root == null) {
				return null;
			}
			
			LinkedList linkedList = new LinkedList();
			Stack<Node> stack = new Stack<>();
			Node current = root;
			while(!stack.isEmpty() || current != null) {
				if(current != null) {
					stack.push(current);
					current = current.left;
				} else {
					current = stack.pop();
					System.out.print(current.data + " ");
					head = linkedList.add(head, current.data);
					current = current.right;
				}
			}
			return head;
		}

	}

	class LinkedList {
		public Node add(Node head, int data) {
			Node end = new Node(data);
			if (head == null) {
				return end;
			}

			Node current = head;
			while (current.right != null) {
				current = current.right;
			}

			current.right = end;
			end.left = current;
			return head;
		}
	}

	class Node {
		Node left;
		Node right;
		int data;

		Node(int data) {
			this.data = data;
		}

		@Override
		public String toString() {
			return "" + data;
		}
	}

}
