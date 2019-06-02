//recursive DFS
public class DepthFirstSearch {
    private boolean[] marked;    
    private int[] edgeTo;       
    private final int s;         

    public DepthFirstSearch(Graph G, int s) {
        this.s = s;
        edgeTo = new int[G.V()];
        marked = new boolean[G.V()];
        dfs(G, s);
    }

    private void dfs(Graph G, int v) {
        marked[v] = true;
        for (int w : G.adj(v)) {
            if (!marked[w]) {
                edgeTo[w] = v;
                dfs(G, w);
            }
        }
    }

    public boolean hasPathTo(int v) {
        return marked[v];
    }

    public Iterable<Integer> pathTo(int v) {
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
        DepthFirstSearch dfs = new DepthFirstSearch(G, start);
                       
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
