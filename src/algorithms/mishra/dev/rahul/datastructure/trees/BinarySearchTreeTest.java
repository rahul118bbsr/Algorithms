package algorithms.mishra.dev.rahul.datastructure.trees;

public class BinarySearchTreeTest {

	public static void main(String[] args) {
//		int[] data = {5, 3, 8, 4, 1, 7, 14, 6, 11, 12, 16, 15, 9};
		int[] data = {5,3,8,2,4,7, 9, 11};
		BinarySearchTree bst = new BinarySearchTree();
		bst.createBST(data);
		System.out.println(bst);
//		bst.delete(bst.getRootNode(), 3);
//		System.out.println(bst);
//		System.out.println(bst.findMax(bst.getRootNode()));
//		System.out.println(bst.findMin(bst.getRootNode()));
//		System.out.println(bst.findHeight(bst.getRootNode()));
//		System.out.println(bst.contains(bst.getRootNode(), 10));
		
//		bst.postOrderTraversal(bst.getRootNode());
//		TopView tv = new TopView();
//		tv.top_view(bst.getRootNode());
		
//		LevelOrderTravsersal lot = new LevelOrderTravsersal();
//		lot.LevelOrder(bst.getRootNode());
		
		BinarySearchTreeCheck bstc = new BinarySearchTreeCheck();
		System.out.println(bstc.checkBST(bst.getRootNode()));
		
		
//		BinarySearchTree_1 bst_1 = new BinarySearchTree_1();
//		bst_1.insertValues(data);;
//		bst_1.insert(bst_1.getRootNode(), 9);
//		System.out.println(bst_1);
//		System.out.println(bst_1.findMax(bst_1.getRootNode()));
//		System.out.println(bst_1.findMin(bst_1.getRootNode()));
//		System.out.println(bst_1.findHeight(bst_1.getRootNode()));
//		System.out.println(bst_1.contains(bst_1.getRootNode(), 10));
		
	}
}
