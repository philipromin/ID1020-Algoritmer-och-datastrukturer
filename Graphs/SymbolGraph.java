import edu.princeton.cs.algs4.*;

public class SymbolGraph {
  private ST<String, Integer> st;
  private String[] keys;
  private Graph G;

  public SymbolGraph(String filename, String sp) {
    st = new ST<>();
    In in = new In(filename);
    while (in.hasNextLine()) {
      String[] a = in.readLine().split(sp);

      for (int i = 0; i < a.length; i++) {
        if (!st.contains(a[i])) {
        	//System.out.print(a[i] + "\n");
          st.put(a[i], st.size());
        }
      }
    }
    keys = new String[st.size()];
    for (String name : st.keys()) {
      keys[st.get(name)] = name;
    }
    G = new Graph(st.size());
    in = new In(filename);

    while (in.hasNextLine()) {
      String[] a = in.readLine().split(sp);
      int v = st.get(a[0]);
      for (int i = 1; i < a.length; i++) {
      	//System.out.println(a[i]);
        G.addEdge(v, st.get(a[i]));
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

  public Graph G() {
    return G;
  }
}