import edu.princeton.cs.algs4.*;

public class SymbolGraphWeighted {
  private ST<String, Integer> st;
  private String[] keys;
  private EdgeWeightedGraph G;

  public SymbolGraphWeighted(String filename, String sp) {
    st = new ST<>();
    In in = new In(filename);
    while (in.hasNextLine()) {
      String[] a = in.readLine().split(sp);

      for (int i = 0; i < a.length - 1; i++) {
        if (!st.contains(a[i])) {
          st.put(a[i], st.size());
        }
      }
    }
    keys = new String[st.size()];
    for (String name : st.keys()) {
      keys[st.get(name)] = name;
    }
    G = new EdgeWeightedGraph(st.size());
    in = new In(filename);
    
    while (in.hasNextLine()) {
      String[] a = in.readLine().split(sp);
      int v = st.get(a[0]);
      for (int i = 1; i < a.length - 1; i++) {
    	  Edge e = new Edge(v, st.get(a[i]), Double.parseDouble(a[i+1]));
    	  G.addEdge(e);
      }
    }
  }

  public boolean contains(String s) {
    return st.contains(s);
  }

  public int index(String s) {
    return st.get(s);
  }

  public String name(int v) {
    return keys[v];
  }

  public EdgeWeightedGraph G() {
    return G;
  }
}