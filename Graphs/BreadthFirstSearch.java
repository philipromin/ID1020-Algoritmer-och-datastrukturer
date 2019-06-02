public class BreadthFirstSearch{
	
	private boolean[] marked; // Is a shortest path to this vertex known?
	private int[] edgeTo; // last vertex on known path to this vertex
	private final int s; // source
	
	public BreadthFirstSearch(Graph G, int s){
		
		marked = new boolean[G.V()];
		edgeTo = new int[G.V()];
		this.s = s;
		bfs(G, s);
	 }
	
	 private void bfs(Graph G, int s){
	     edu.princeton.cs.algs4.Queue<Integer> queue = new edu.princeton.cs.algs4.Queue<Integer>(); 
		 marked[s] = true; // Mark the source
		 queue.enqueue(s); // and put it on the queue.
		 while (!queue.isEmpty()){			 
			 int v = queue.dequeue(); // Remove next vertex from the queue.
			 for (int w : G.adj(v)) {
				 if (!marked[w]) { // For every unmarked adjacent vertex,
				 
					 edgeTo[w] = v; // save last edge on a shortest path,
					 marked[w] = true; // mark it because path is known,
					 queue.enqueue(w); // and add it to the queue.
					 
				 }
			 }				
		 }
	 }
	 
	 public boolean hasPathTo(int v){ 
		 return marked[v]; 
	 }
	 
	 public Iterable<Integer> pathTo(int v){
		 Stack<Integer> path = new Stack<Integer>();
	        for (int x = v; x != s; x = edgeTo[x]) {
	            path.push(x);
	        }
	        path.push(s);
	        return path;		 
	 }
	 
	 public static void main(String[] args) {
	    	String url = "C:\\Users\\phili\\Documents\\Skola\\Algoritmer\\Labb4\\data.dat";
			SymbolGraph sg = new SymbolGraph(url, " ");
			Graph G = sg.G();      
	        int start = sg.index("AL");
	        int end = sg.index("SC");
	        BreadthFirstSearch dfs = new BreadthFirstSearch(G, start);
	                
	        if (dfs.hasPathTo(end)) {
	            System.out.print("Path from " + sg.name(start) + " to " + sg.name(end) + ":\n");
	            for (int x : dfs.pathTo(end)) {
	                if (x == start) {
	                	System.out.print("Path: " + sg.name(x));
	                }
	                else {
	                	System.out.print("-" + sg.name(x));
	                }
	            }
	            StdOut.println();
	        }
	        else {
	        	System.out.println("No Path");
	        }
	    }
}
