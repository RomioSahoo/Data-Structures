package Graph;
import java.util.*;
public class DFS {

	private int V;
	private LinkedList adj[];
	
	DFS(int v){
		V=v;
		adj=new LinkedList[v];
		for(int i=0;i<v;i++)
			adj[i]=new LinkedList();
	}
	
	void addEdge(int v,int w) {
		adj[v].add(w);
	}
	
	void DFS(int s)
	{
		boolean visited[]=new boolean[V];
		Stack<Integer> stack=new Stack<>();
		
		visited[s]=true;
		stack.add(s);
		while(!stack.isEmpty()) {
			s=stack.pop();
			System.out.print(s+" ");
			Iterator<Integer> it=adj[s].listIterator();
			while(it.hasNext()) {
				int n=it.next();
				if(!visited[n]) {
					visited[n]=true;
					stack.add(n);
				}
				
			}
		}
	}
}
