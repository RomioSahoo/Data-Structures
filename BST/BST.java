import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//BST is made up of small BSTs so here recursion will be used
public class BST {

	class Node {
		int key;
		String value;
		Node left, right;

		public Node(int key, String value) {
			super();
			this.key = key;
			this.value = value;
		}

		public Node min() {
			if (left == null)
				return this;
			else
				return left.min();
		}

		public Node max() {
			if (right == null)
				return this;
			else
				return right.max();
		}

	}

	class count {
		int count = 0;
	}

	Node root;

	public BST() {
		root = null;
	}

	public String find(int key) {
		Node node = find(root, key);
		System.out.println("value: " + node.value);
		return node == null ? null : node.value;
	}

	private Node find(Node node, int key) {
		if (node == null || node.key == key)
			return node;
		else if (key < node.key)
			return find(node.left, key);
		else if (key > node.key)
			return find(node.right, key);
		return null;
	}

	public void insert(int key, String value) {
		root = insertItem(root, key, value);
	}

	public Node insertItem(Node node, int key, String value) {
		Node newNode = new Node(key, value);
//		if null, set it here
		if (node == null) {
			node = newNode;
			return node;
		}
//		else wait until you find a node that is null and set it there
		if (key < node.key)
			node.left = insertItem(node.left, key, value);
		else
			node.right = insertItem(node.right, key, value);

//		we have returned from the bottom
//		return our fully constructed tree
		return node;
	}

////	minimum node value
//	public void minimum() {
//		System.out.println("Minimum: " + root.min().key);
//	}
//
////	maximum node value
//	public void maximum() {
//		System.out.println("Maximum: " + root.max().key);
//	}

	public Node findMin(Node node) {
		return node.min();
	}

	// print
	// InOrder
	public void printInorderTraversal() {
		System.out.println();
		inOrderTraversal(root);
	}

	private void inOrderTraversal(Node node) {
		if (node != null) {
			inOrderTraversal(node.left);
			System.out.print(node.key + " ");
			inOrderTraversal(node.right);
		}
	}

	// PreOrder
	public void printPreOrderTraversal() {
		System.out.println();
		preOrderTraversal(root);
	}

	private void preOrderTraversal(Node node) {
		if (node != null) {
			System.out.print(node.key + " ");
			preOrderTraversal(node.left);
			preOrderTraversal(node.right);
		}
	}

	// PostOrder
	public void printPostOrderTraversal() {
		System.out.println();
		postOrderTraversal(root);
	}

	private void postOrderTraversal(Node node) {
		if (node != null) {
			postOrderTraversal(node.left);
			postOrderTraversal(node.right);
			System.out.print(node.key + " ");
		}
	}

	// Delete
	public void delete(int key) {
		root = delete(root, key);
	}

	public Node delete(Node node, int key) {
		if (node == null)
			return null;
		else if (key < node.key)
			return delete(node.left, key);
		else if (key > node.key)
			return delete(node.right, key);
		else// node found
		{
			// Case 1:No child
			if (node.left == null && node.right == null)
				node = null;

			// Case 2:One child
			else if (node.left == null)
				node = node.right;
			else if (node.right == null)
				node = node.left;
			// Case 3:Two Children
			else {
				Node minRight = findMin(node.right);

				node.key = minRight.key;
				node.value = minRight.value;

				node.right = delete(node.right, node.key);
			}
		}
		return node;
	}

	// Max depth of BST
	int maxDepth(Node node) { // O(n) TM
		if (node == null)
			return 0;
		else {
			int Ldepth = maxDepth(node.left);
			int Rdepth = maxDepth(node.right);

			if (Ldepth > Rdepth)
				return Ldepth + 1;
			else
				return Rdepth + 1;

			// OR
			// return Math.max(Ldepth, Rdepth)+1;
		}
	}

	// Min Depth of BSt
	int minDepth(Node node) {
		if (node == null)
			return 0;
		else {
			int lDepth = minDepth(node.left);
			int rDepth = minDepth(node.right);
			if (node.left == null)
				return rDepth + 1;
			if (node.right == null)
				return lDepth + 1;
			return Math.min(lDepth, rDepth) + 1;
		}
	}

	// level order traversal
	void printLevelOrder() { // O(n) TM
		Queue<Node> queue = new LinkedList<Node>();
		queue.add(root);
		while (!queue.isEmpty()) {
			Node node = queue.poll();
			System.out.print(node.key + " ");

			if (node.left != null)
				queue.add(node.left);
			if (node.right != null)
				queue.add(node.right);
		}

	}

	// bottom-up level order traversal
	void levelOrderBotom() {
		List<List<Integer>> li = GetLevelOrderBottom(root);
		System.out.println(li);
	}

	List<List<Integer>> GetLevelOrderBottom(Node root) {
		List<List<Integer>> list = new ArrayList<>();
		if (root == null)
			return list;
		Queue<Node> queue = new LinkedList<Node>();
		queue.add(root);
		while (!queue.isEmpty()) {
			List<Integer> li = new ArrayList<>();
			int size = queue.size();
			while (size > 0) {
				Node node = queue.poll();
				li.add(node.key);
				if (node.left != null)
					queue.add(node.left);
				if (node.right != null)
					queue.add(node.right);
				size--;
			}
			list.add(li);
		}

		Collections.reverse(list);
		return list;

	}

	// lowest common ancestor
	public void lca(int key1, int key2) {
		root = findLCA(root, key1, key2);
		System.out.println(root.key);

	}

	Node findLCA(Node node, int key1, int key2) {
		if (root.key == key1 || root.key == key2)
			return root;
		while (root != null) {
			if (node.key < key1 && node.key < key2)
				return findLCA(node.right, key1, key2);
			else if (node.key > key1 && node.key > key2)
				return findLCA(node.left, key1, key2);
			break;
		}
		return node;

	}

	// Is symmetric or not
	boolean isSymmetric(Node root) {
		return isMirror(root, root);
	}

	boolean isMirror(Node node1, Node node2) {
		if (node1 == null && node2 == null)
			return false;
		if (node1 != null && node2 != null && node1.key == node2.key) {
			return (isMirror(node1.left, node2.right) && isMirror(node1.right, node2.left));
		}
		return false;
	}

	// function to find 2nd largest element
	void seconLargest(Node node) {
		count C = new count();
		this.secondLargestUtil(node, C);
	}

	void secondLargestUtil(Node root, count C) {
		if (root == null || C.count >= 2)
			return;
		this.secondLargestUtil(root.right, C);
		C.count++;
		if (C.count == 2) {
			System.out.println("2nd largest element is " + root.key);
			return;
		}
		
		this.secondLargestUtil(root.left, C);
	}
	
	
	//2nd smallest element
	void secondSmallest(Node node)
	{
		count c=new count();
		this.secondSmallestUtil(node,c);
	}
	
	void secondSmallestUtil(Node root, count C) {
		if(root==null || C.count>=2)
			return;
		this.secondSmallestUtil(root.left,C);
		C.count++;
		if(C.count==2)
		{
			System.out.println(root.key);
			return;
		}
		this.secondLargestUtil(root.left, C);
	}
	
	//kth largest element
	void kthLargest(int k) {
		count c=new count();
		this.kthLargestUtil(this.root,k,c);
	}
	
	void kthLargestUtil(Node root,int k,count C)
	{
		if(root==null||C.count>=k)
		{
			return;
		}
		this.kthLargestUtil(root.right, k, C);
		C.count++;
		if(C.count==k)
		{
			System.out.println(root.key);
			return;
		}
		this.secondLargestUtil(root.left, C);
	}
	
	//kth smallest element
	void kthSmallest(int k)
	{
		count c=new count();
		this.kthSmallestUtil(this.root,k,c);
	}
	
	void kthSmallestUtil(Node root,int k,count C) {
		if(root==null||C.count>=k)
			return;
		this.kthLargestUtil(root.left, k, C);
		C.count++;
		if(C.count==k)
		{
			System.out.println(root.key);
			return;
		}
		this.kthSmallestUtil(root.right, k, C);
	}
	
	

}
