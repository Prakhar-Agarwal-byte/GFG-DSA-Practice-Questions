class Solution {
  // Function to detect cycle in an undirected graph.
  public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
    boolean[] visited = new boolean[V];
    for (int i = 0; i < V; i++) {
      if (!visited[i]) {
        if (dfs(i, -1, visited, adj))
          return true;
      }
    }
    return false;
  }

  private boolean dfs(int i, int p, boolean[] visited, ArrayList<ArrayList<Integer>> adj) {
    visited[i] = true;
    for (int e : adj.get(i)) {
      if (!visited[e]) {
        if (dfs(e, i, visited, adj))
          return true;
      } else {
        if (e != p)
          return true;
      }
    }
    return false;
  }
}
