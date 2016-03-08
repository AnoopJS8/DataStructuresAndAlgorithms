package graphs;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Graph<T>{
	private int V;//No of Vertices
	private List<T> adj[];//Adjacency Lists; private LinkedList<T> adj[];
	public Graph(int _v){
		V=_v;
		adj=new LinkedList[V];
		for(int i=0;i<V;i++){
			//System.out.println(i);
			adj[i]=new LinkedList<T>();
		}
	}
	//FUnction to add an edge
	public void addEdge(T v,T w){
		adj[(int)v].add(w);//it adds to the end of the list, equivalent to addLast()
		//It is for directed graph.	
	}
	//Print BFS traversal from the source node
	public void BFS(T source){
		// Mark all the vertices as not visited(By default
        // set as false)
		boolean visited[]=new boolean[V];
		
		//creating a queue for bfs.
		Queue<T> queue=new LinkedList<T>();
		visited[(int)source]=true;
		queue.offer(source);
		while(queue.size()!=0){
			// Dequeue a vertex from queue and print it
			T s=queue.poll();
			System.out.print(s+" ");
			// Get all adjacent vertices of the dequeued vertex s
            // If a adjacent has not been visited, then mark it
            // visited and enqueue it
			Iterator<T> iter=adj[(int)s].listIterator();
			while(iter.hasNext()){
				T next=iter.next();
				if(!visited[(int) next]){
					visited[(int)next]=true;
					queue.offer(next);
				}
			}
			
		}
		
		
	}
	
}


public class GraphApplications {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Graph<Integer> g=new Graph<Integer>(4);
		g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);
 
        System.out.println("Following is Breadth First Traversal "+
                           "(starting from vertex 2)");
 
        g.BFS(2);
		
	}

}
/*
 * Note that the above code traverses only the vertices reachable from a given
 * source vertex. All the vertices may not be reachable from a given vertex
 * (example Disconnected graph). To print all the vertices, we can modify the
 * BFS function to do traversal starting from all nodes one by one
 */