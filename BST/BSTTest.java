
public class BSTTest {

	public static void main(String[] args) {
		
		BST bst=new BST();
		
		bst.insert(5,"F");
		bst.insert(3,"A");
		bst.insert(2,"B");
		bst.insert(4,"C");
		bst.insert(7,"D");
		bst.insert(6,"E");
		bst.insert(8,"G");
	
		bst.find(2);
		
		System.out.println();
		System.out.println("Level Order Bottom: ");
		bst.levelOrderBotom();
		
		System.out.println("Inorder");
		bst.printInorderTraversal();
		
		System.out.println();
		
		System.out.println("PreOrder");
		bst.printPreOrderTraversal();
		
		System.out.println();
		
		System.out.println("PostOrder");
		bst.printPostOrderTraversal();
		
		System.out.println();
		System.out.println();
		System.out.println("2nd Largest: ");
		bst.seconLargest(bst.root);
		
		System.out.println();
		System.out.print("Second Smallest element: ");
		bst.secondSmallest(bst.root);
		
		System.out.println();
		System.out.println("Kth Largest element: ");
		bst.kthLargest(2);
		
		System.out.println();
		System.out.println("Kth smallest element: ");
		bst.kthSmallest(2);
		
		System.out.println();
		
		System.out.println("Max Height of the tree is: "+bst.maxDepth(bst.root));
		System.out.println("Min Height of the tree is: "+bst.minDepth(bst.root));
		
		System.out.println();
		System.out.println("Level Order");
		bst.printLevelOrder();
		
		System.out.println();
		System.out.println("Lowest common ancestor");
		bst.lca(2, 4);
		
		
		
		System.out.println();
		System.out.println("Is symmetric: "+bst.isSymmetric(bst.root));
		
	
		
	
		

	}

}
