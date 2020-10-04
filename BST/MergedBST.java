import java.util.ArrayList;
import java.util.List;

class MergedBST {

	static class Node {
		int val;
		Node left, right;

		Node(int value) {

			val = value;
			left = right = null;

		}

	}

	Node root;

	MergedBST() {
		root = null;
	}

	
	/*--------------------------------------------------------------*/

	public List<Integer> getAllElements(Node root1, Node root2) {
		List<Integer> list1 = new ArrayList<>();
		inorder(root1, list1);
		List<Integer> list2 = new ArrayList<>();
		inorder(root2, list2);
		return mergeBST(list1, list2);
	}

	private void inorder(Node node, List<Integer> list) {
		if (node != null) {
			inorder(node.left, list);
			list.add(node.val);
			inorder(node.right, list);
		}

	}

	List<Integer> mergeBST(List<Integer> list1, List<Integer> list2) {
		List<Integer> list = new ArrayList<>();
		int i, j;
		i = j = 0;
		while (i < list1.size() && j < list2.size()) {
			if (list1.get(i) < list2.get(j)) {
				list.add(list1.get(i));
				i++;
			} else {
				list.add(list2.get(j));
				j++;
			}
		}
		while (i < list1.size()) {
			list.add(list1.get(i));
			i++;
		}
		while (j < list2.size()) {
			list.add(list2.get(j));
			j++;
		}
		return list;

	}
	/*--------------------------------------------------------------*/

	public static void main(String[] args) {
		MergedBST bst1 = new MergedBST();

		bst1.root = new Node(2);
		bst1.root.left = new Node(1);
		bst1.root.right = new Node(4);

		MergedBST bst2 = new MergedBST();

		bst2.root = new Node(1);
		bst2.root.left = new Node(0);
		bst2.root.right = new Node(3);

		MergedBST bst = new MergedBST();
		List<Integer> list=bst.getAllElements(bst1.root, bst2.root);
		System.out.println(list);
		

	}
}
