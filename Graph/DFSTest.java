package Graph;
//directed graph
public class DFSTest {

	public static void main(String[] args) {
		DFS dfs=new DFS(8);
		dfs.addEdge(0, 1);
//		dfs.addEdge(1, 0);
		dfs.addEdge(1, 4);
//		dfs.addEdge(4, 1);
		dfs.addEdge(4, 6);
//		dfs.addEdge(6, 4);
		dfs.addEdge(6, 0);
//		dfs.addEdge(0, 6);
		dfs.addEdge(1, 5);
//		dfs.addEdge(5, 1);
		dfs.addEdge(5, 3);
//		dfs.addEdge(3, 5);
		dfs.addEdge(3, 0);
//		dfs.addEdge(0, 3);
		dfs.addEdge(5, 2);
//		dfs.addEdge(2, 5);
		dfs.addEdge(2, 7);
//		dfs.addEdge(7, 2);
		
		System.out.println("Depth first Traversal starting from vertex 0: ");
		dfs.DFS(0);

	}

}
