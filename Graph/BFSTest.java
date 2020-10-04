package Graph;

//Un-directed graph
public class BFSTest {

	public static void main(String[] args) {
		BFS bfs=new BFS(8);
		bfs.addEdge(0, 1);
		bfs.addEdge(1, 0);
		bfs.addEdge(1, 4);
		bfs.addEdge(4, 1);
		bfs.addEdge(4, 6);
		bfs.addEdge(6, 4);
		bfs.addEdge(6, 0);
		bfs.addEdge(0, 6);
		bfs.addEdge(1, 5);
		bfs.addEdge(5, 1);
		bfs.addEdge(5, 3);
		bfs.addEdge(3, 5);
		bfs.addEdge(3, 0);
		bfs.addEdge(0, 3);
		bfs.addEdge(5, 2);
		bfs.addEdge(2, 5);
		bfs.addEdge(2, 7);
		bfs.addEdge(7, 2);
		
		System.out.println("Breadth first traversal starting from vertex 0:  ");
		bfs.BFS(0);
		
		

	}

}
