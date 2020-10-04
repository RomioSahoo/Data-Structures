package Queue;

public class Queue {
	private class Node {
		private Node next;
		private int data;

		public Node(int data) {
			super();
			this.data = data;
		}

	}

	private Node head;
	private Node tail;

	public boolean isEmpty() {
		return head == null;
	}

	public int peek() {
		return head.data;
	}

	public void add(int data) {
		// create a new node
		// set the current tail.next to point to this new node
		// then set the new node to be the new tail
		Node node = new Node(data);
		if (tail != null) {
			tail.next = node;
		}
		tail = node;
		if (head == null)
			head = tail;
	}

	public int remove() {
		// save the data
		// point the head to the next element(effectively removing it)
		// then return the data
		int data = head.data;
		head = head.next;

		if (head == null)
			tail = null;
		return data;
	}

	public void show() {
		Node curr=head;
		while(curr!=null) {
			System.out.print(curr.data+" ");
			curr=curr.next;
		}
		
	}
}
