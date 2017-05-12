/**
 * 
 */
package algorithms.mishra.dev.rahul.datastructure.trees;

import java.util.LinkedList;
import java.util.Queue;

/**
 * https://www.hackerrank.com/challenges/tree-level-order-traversal
 * 
 * @author Rahul Dev Mishra
 * @assignment
 * @date 12-May-2017 12:27:16 PM
 *
 */
public class LevelOrderTravsersal {
	public void LevelOrder(Node root) {
		if(root == null) {
			return;
		}
		
		Queue<Node> queue = new LinkedList<>();
		queue.add(root);
		while(!queue.isEmpty()) {
			Node tempNode = queue.poll();
			System.out.print(tempNode.value + " ");
			if(tempNode.leftChildNode != null) {
				queue.add(tempNode.leftChildNode);
			}
			
			if(tempNode.rightChildNode != null) {
				queue.add(tempNode.rightChildNode);
			}
		}
	}
}