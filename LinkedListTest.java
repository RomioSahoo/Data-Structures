package LinkedList;

public class LinkedListTest {
	
	public static void main(String args[]) {
		LinkedList linkedList = new LinkedList();

		linkedList.addFront(1);
		linkedList.addFront(5);
		linkedList.addBack(7);
		linkedList.addBack(2);
		linkedList.addBack(2);
		linkedList.addBack(1);
		//linkedList.addFront(9);
		linkedList.addFront(9);
		linkedList.deleteValue(1);
		//linkedList.deleteValue(2);
		//linkedList.clear();
		System.out.println("first Element:"+linkedList.getFirst());
		System.out.println("Last element:"+linkedList.getLast());
		System.out.println("Linked list size:"+linkedList.size());
		//System.out.println("Linked List elements:"+linkedList.show(););
		linkedList.show();
		System.out.println("Nth node:"+linkedList.NthNode(3));
		System.out.println("Middle element:"+linkedList.middleElement());
		if(linkedList.detectLoop())
			System.out.println("loop is present");
		else
			System.out.println("loop is not present");
		linkedList.reverse();
		System.out.print("Reverse : ");
		linkedList.show();
		
		linkedList.insertPosition(5, 2);
		System.out.println("Linked list after inserting 5 at position 2:");
		linkedList.show();
		
		System.out.println("LinkedList after removing duplicates");
		linkedList.removeDuplicates();
		linkedList.show();
		
		
		
		
	}

}
