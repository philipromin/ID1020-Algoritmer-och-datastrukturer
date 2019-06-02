public class DepthFirstOrder {
    private boolean[] marked;          
    private edu.princeton.cs.algs4.Stack<Integer> topoOrder;  

    /**
     * Determines a depth-first order for the digraph {@code G}.
     * @param G the digraph
     */
    public DepthFirstOrder(Digraph G) {
    	topoOrder = new edu.princeton.cs.algs4.Stack<Integer>();
        marked    = new boolean[G.V()];
        for (int v = 0; v < G.V(); v++)
            if (!marked[v]) dfs(G, v);
    }

    // run DFS in digraph G from vertex v and compute preorder/postorder
    private void dfs(Digraph G, int v) {
        marked[v] = true;
        for (int w : G.adj(v)) {
            if (!marked[w]) {
                dfs(G, w);
            }
        }
        topoOrder.push(v);
    }

    public Iterable<Integer> getTopoOrder() {
		return topoOrder;
	}
}