package LinkedList;
public class LinkedList {
	private static class Node {
		int data;
		Node next;

		public Node(int data) {
			super();
			this.data = data;
		}

	}
	
	
	private Node head;
	
	/*add element at front of linked list*/
	public void addFront(int data)
	{
		Node newNode=new Node(data);
		
		if(head==null)
		{
			head=newNode;
			return;
		}
		//set it's next to the current head	
		newNode.next=head;
		
		//set current head to the new head
		head=newNode;	
	}
	
	
	
	
	/*get the first element of the linked list*/
	public int getFirst()
	{
		return head.data;  //O(1)- No random access
	}
	
	
	
	/*get the last element of the linked list*/
	public int getLast()
	{
		if(head==null)
			throw new IllegalStateException("Empty list");
		
		Node current=head;
		//while we are not at the tail
		while(current.next!=null)
		{
			current=current.next;	//O(n)-No fixed capacity
		}
		//we are at the tail
		return current.data;
	}
	
	
	
	/*add element at the back of linked list*/
	public void addBack(int data)
	{
		Node newNode=new Node(data);
		if(head==null)
		{
			head=newNode;
			return;
		}
		//start at the head
		Node current=head;
		//walk back until node =null
		while(current.next!=null)
		{
			current=current.next;
		}
		//at the tail
		current.next=newNode;
		
	}
	
	
	
	
	/*get the size of the linked list using brute force method*/
	public int size()
	{
		if(head==null)
		{
			return 0;
		}
		int count=1;
		Node current=head;
		while(current.next!=null)
		{
			current=current.next;
			count++;
		}
		return count;
	}
	
	
	
	/*clear the linked list*/
	public void clear() {
		head=null;
		/*all the previously pointed to nodes still exist but by dereferencing them they get targetted 
		 * for garbage collection and are effectively set to 0*/
	}
	
	
	
	/*delete given value from the linked list*/
	public void deleteValue(int data)
	{
		if(head==null)
		{
			return;
		}
		//if data present at head
		while(head!=null&&head.data==data)
		{
			head=head.next;
			return;
		}
		//if data present somewhere in middle of the list
	
		
			Node current=head;
			while(current!=null&&current.next!=null)
			{
				if(current.next.data==data) {
					current.next=current.next.next;		//O(n)
					return;
				}
				current=current.next;
			}
	
		
	}
	
	
	
	/*get element of the linked list corresponding to given index*/
	public int NthNode(int index) {
		Node current=head;
		int count=0;
		while(current.next!=null)
		{
			if(count==index)
			{
			return current.data;
			}
			count++;
			current=current.next;
			
		}
		if(count==index)
			return current.data;
		return 0;
	}
	
	
	
	/*Insert node at the specific position*/
	public void insertPosition(int data,int index)
	{
		Node newNode=new Node(data);
		Node current=head;
		int count=1;
		while(current!=null)
		{
			if(count==index)
			{
				newNode.next=current.next;
				current.next=newNode;
			}
			count++;
			current=current.next;
		}
	}
	
	
	
	/*get the middle element of the linked list*/
	public int middleElement()
	{
		if(head==null)
			return 0;
		int count=1;
		Node current=head;
		while(current.next!=null)
		{
			count++;
			current=current.next;
		}
		
		int mid=count/2;
		count=0;
		Node current1=head;
		while(current1.next!=null)
		{
			if(count==mid)
				return current1.data;
			count++;
			current1=current1.next;
		}
		return 0;
	}
	
	
	
	/*detect loop in the linked list if present or not*/
	public boolean detectLoop()
	{
		
		Node n1=head;
		Node n2=head;
		if(n1!=null && n2!=null && n2.next!=null)
		{
			n1=n1.next;
			n2=n2.next.next;
			if(n1==n2)
				return true;
		
		}
		if(n1==n2)
			return true;
		
		return false;
	}
	
	
	
	//removing duplicates from the likedList
	public void removeDuplicates()
	{
		Node current=head;
		while(current.next!=null)
		{
			if(current.data==current.next.data)
			{
				current.next=current.next.next;
			}
			else
			current=current.next;
		}
	}
	
	
	
	
	public void show()
	{
		Node current=head;
		System.out.print("LinkedList elements: ");
		 while(current.next!=null)
		 {
			 System.out.print(current.data+" ");
			 current=current.next;
		 }
		 System.out.println(current.data);
	}
	
	
	/*reversing the elements of the linked list*/
	public void reverse() {
		Node prev=null;
		Node current=head;
		Node next=null;
		while(current!=null)
		{
			next=current.next;
			current.next=prev;
			prev=current;
			current=next;
		}
		head=prev;
	}
}
