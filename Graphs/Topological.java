public class Topological {
    private Iterable<Integer> order;  // topological order
    
    public Topological(Digraph G) {
        DirectedCycle finder = new DirectedCycle(G);
        if (!finder.hasCycle()) {
        	DepthFirstOrder dfs = new DepthFirstOrder(G);
            order = dfs.getTopoOrder();
        }
    }

    /**
     * Returns a topological order
     */
    public Iterable<Integer> order() {
        return order;
    }

    /**
     * Unit test
     */
    public static void main(String[] args) {
    	String url = "C:\\Users\\phili\\Documents\\Skola\\Algoritmer\\Labb4\\small_database.dat";
  	  	SymbolDigraph sg = new SymbolDigraph(url, " ");
  	  	Digraph G = sg.digraph();   
        Topological topological = new Topological(G);
        for (int v : topological.order()) {
            StdOut.println(sg.nameOf(v)); //OUTPUT: TJ TK TL TM TI TH TG TD TC TA TB TF TE
        } 
    }

}