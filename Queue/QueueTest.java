package Queue;

public class QueueTest {

	public static void main(String[] args) {
		Queue qe=new Queue();
		System.out.println("Is queue empty: "+qe.isEmpty());
		qe.add(6);
		qe.add(5);
		qe.add(2);
		System.out.println("Peak element: "+qe.peek());
		qe.remove();
		qe.show();

	}

}
