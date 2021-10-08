class Solution {
  // Function to detect cycle in an undirected graph.
  public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
    boolean[] visited = new boolean[V];
    for (int i = 0; i < V; i++) {
      if (!visited[i]) {
        if (bfs(new Pair(i, -1), visited, adj))
          return true;
      }
    }
    return false;
  }

  private boolean bfs(Pair p, boolean[] visited, ArrayList<ArrayList<Integer>> adj) {
    Queue<Pair> q = new LinkedList<>();
    q.add(p);
    visited[p.i] = true;
    while (!q.isEmpty()) {
      Pair cur = q.remove();
      for (int e : adj.get(cur.i)) {
        if (!visited[e]) {
          visited[e] = true;
          q.add(new Pair(e, cur.i));
        } else {
          if (e != cur.p)
            return true;
        }
      }
    }
    return false;
  }
}

class Pair {
  int i;
  int p;

  Pair(int i, int p) {
    this.i = i;
    this.p = p;
  }
}
