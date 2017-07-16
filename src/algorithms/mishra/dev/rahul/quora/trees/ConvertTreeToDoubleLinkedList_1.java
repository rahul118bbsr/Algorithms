/**
 * 
 */
package algorithms.mishra.dev.rahul.quora.trees;

/**
 * @author Rahul Dev Mishra
 * @assignment  
 * @date 11-Jul-2017 10:20:02 PM
 *
 */
public class ConvertTreeToDoubleLinkedList_1 {

	public static void main(String[] args) {
		BST bst = new ConvertTreeToDoubleLinkedList_1().new BST();
		Node root = bst.add(null, 5);
		bst.add(root, 3);
		bst.add(root, 9);
		bst.add(root, 1);
		bst.add(root, 4);
		bst.add(root, 6);
		bst.add(root, 10);
		bst.add(root, 0);
		bst.add(root, 2);
		Node head = bst.convertToLinkedList(root);
		System.out.println(head);
	}
	
	class LinkedList {
		public Node add(Node head, int data) {
			Node end = new Node(data);
			if(head == null) {
				return end;
			}
			
			Node curr = head;
			while(curr.right != null) {
				curr = curr.right;
			}
			curr.right = end;
			return head;
		}
	}
	
	class BST {
		public Node add(Node root, int data) {
			Node end = new Node(data);
			if(root == null) {
				return end;
			}
			if(data <= root.data) {
				root.left = add(root.left, data);
			} else if(data > root.data) {
				root.right = add(root.right, data);
			}
			return root;
		}
		
		private Node convertToLinkedList(Node root) {
			LinkedList list = new LinkedList();
			Node head = convertToLinkedList(root, null, list);
			return head;
		}
		
		private Node convertToLinkedList(Node root, Node head, LinkedList linkedList) {
			if(root == null) {
				return head;
			}
			if(root.left != null) {
				head = convertToLinkedList(root.left, head, linkedList);
			}
			head = linkedList.add(head, root.data);
			if(root.right != null) {
				head = convertToLinkedList(root.right, head, linkedList);
			}
			return head;
		}
	}
	
	class Node {
		Node left;
		Node right;
		int data;
		
		Node(){}
		
		Node(int data) {
			this.data = data;
		}
		
		@Override
		public String toString() {
			return data +  "-->" + right;
		}
	}

}
