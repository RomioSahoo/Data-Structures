package BinaryHeap;

public class MaxIntHeapTest {

	public static void main(String[] args) {
		MaxIntHeap heap=new MaxIntHeap();
		heap.insert(42);
		heap.insert(29);
		heap.insert(18);
		heap.insert(35);
		
		heap.print();
		
		System.out.println("Max:"+heap.extractMax());
	//	System.out.println(heap.extractMax());
		heap.print();
		
		System.out.println("Max:"+heap.extractMax());
		heap.print();
		

	}

}
