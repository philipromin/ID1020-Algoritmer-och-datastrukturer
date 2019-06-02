import edu.princeton.cs.algs4.*;

public class Graph {
	private final int V; // Vertices
	private int E; // Edges
	private Bag<Integer>[] adj; // Adjacency list

	public Graph(int V) {
		this.V = V;
		this.E = 0;
		adj = (Bag<Integer>[]) new Bag[V]; // Create array of lists.
		for (int v = 0; v < V; v++) // Initialize all lists
			adj[v] = new Bag<Integer>(); // to empty.
		}

	public int V() {
		return V;
	}

	public int E() {
		return E;
 	}

	public void addEdge(int v, int w) {
		adj[v].add(w); // Add w to v’s list.
		adj[w].add(v); // Add v to w’s list.
		E++;
	}

	public Iterable<Integer> adj(int v) {
		return adj[v];
	}
}