package Stack;

public class StackTest {

	public static void main(String[] args) {
		Stack st=new Stack();
		System.out.println(st.isEmpty());
		st.push(3);
		System.out.println(st.peek());
		st.push(2);
		st.push(7);
		st.push(6);
		st.pop();
		st.show();

	}

}
