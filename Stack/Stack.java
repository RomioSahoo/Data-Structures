package Stack;

import java.util.EmptyStackException;

public class Stack {
	private class Node {
		private Node next;
		private int data;

		public Node(int data) {
			super();
			this.data = data;
		}

	}

	private Node head;

	public boolean isEmpty() {
		return head == null;
	}

	public int peek() {
		return head.data;
	}

	public void push(int data) {
		Node n = new Node(data);
		n.next = head;
		head = n;
	}

	public int pop() {
		if (head == null) {
			throw new EmptyStackException();
		}

		int data = head.data;
		head = head.next;
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
