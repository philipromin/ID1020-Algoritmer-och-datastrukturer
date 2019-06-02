public class DepthFirstDirectedPaths {
  private boolean[] marked;
  private int[] edgeTo;
  private final int s;

  public DepthFirstDirectedPaths(Digraph G, int s) {
    marked = new boolean[G.V()];
    edgeTo = new int[G.V()];
    this.s = s;
    validateVertex(s);
    dfs(G, s);
  }

  private void dfs(Digraph G, int v) {
    marked[v] = true;
    for (int w : G.adj(v)) {
      if (!marked[w]) {
        edgeTo[w] = v;
        dfs(G, w);
      }
    }
  }

  public boolean hasPathTo(int v) {
    validateVertex(v);
    return marked[v];
  }

  public Iterable<Integer> pathTo(int v) {
    validateVertex(v);
    if (!hasPathTo(v))
      return null;
    Stack<Integer> path = new Stack<Integer>();
    for (int x = v; x != s; x = edgeTo[x]) path.push(x);
    path.push(s);
    return path;
  }

  private void validateVertex(int v) {
    int V = marked.length;
    if (v < 0 || v >= V)
      throw new IllegalArgumentException("vertex " + v + " is not between 0 and " + (V - 1));
  }

  public static void main(String[] args) {
	  String url = "C:\\Users\\phili\\Documents\\Skola\\Algoritmer\\Labb4\\data.dat";
	  SymbolDigraph sg = new SymbolDigraph(url, " ");
	  Digraph G = sg.digraph();      
      int start = sg.indexOf("AL");
      int end = sg.indexOf("SC");
      DepthFirstDirectedPaths dfs = new DepthFirstDirectedPaths(G, start);

      if (dfs.hasPathTo(end)) {
    	  System.out.print("Path from " + sg.nameOf(start) + " to " + sg.nameOf(end) + ":\n");
    	  for (int x : dfs.pathTo(end)) {
    		  if (x == start) {
    			  System.out.print(sg.nameOf(x));
    		  }
    		  else {
    			  StdOut.print("-" + sg.nameOf(x));
    		  }
        }
        StdOut.println();
      }

      else {
        System.out.println("Not connected");
      }      
  }
}