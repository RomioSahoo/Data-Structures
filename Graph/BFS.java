package Graph;

import java.util.*;

public class BFS {

	private int V;// no of vertices
	private LinkedList<Integer> adj[];// adjacency list

	BFS(int v) {
		V = v;
		adj = new LinkedList[v];
		for (int i = 0; i < v; i++)
			adj[i] = new LinkedList();
	}
	
	void addEdge(int v,int w)
	{
		adj[v].add(w);
	}
	
	//BFS traversal from a given source s
	void BFS(int s) {
		//mark all the vertices as not visited(false)
		boolean visited[]=new boolean[V];
		
		//create a queue for BFS
		LinkedList<Integer> queue=new LinkedList<Integer>();
		
		//mark the current node as visited and enqueue it
		visited[s]=true;
		//System.out.println("Starting at "+s);
		queue.add(s);
		
		while(queue.size()!=0) {
			//Dequeue a vertex from queue and print it
			s=queue.poll();
		//	System.out.println("De-queuing "+ s);
			System.out.print(s+" ");
			
			//Get all adjacent vertices of the de-queued vertex s
			//If a adjacent has not been visited, then mark it
			//visited and enqueue it
			Iterator<Integer> i=adj[s].listIterator();
			while(i.hasNext())
			{
				int n=i.next();
				if(!visited[n]) {
					visited[n]=true;
				//	System.out.println("Queuing "+ n);
					queue.add(n);
				}
			}
			
		}
		
	}
}
