class Solution {
  // Function to detect cycle in a directed graph.
  public boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) {
    boolean[] visited = new boolean[V];
    boolean[] curVisited = new boolean[V];
    for (int i = 0; i < V; i++) {
      if (!visited[i]) {
        if (dfs(i, visited, curVisited, adj))
          return true;
      }
    }
    return false;
  }

  private boolean dfs(int i, boolean[] visited, boolean[] curVisited, ArrayList<ArrayList<Integer>> adj) {
    visited[i] = true;
    curVisited[i] = true;
    for (int e : adj.get(i)) {
      if (!visited[e]) {
        if (dfs(e, visited, curVisited, adj))
          return true;
      } else if (curVisited[e] == true) {
        return true;
      }

    }
    curVisited[i] = false;
    return false;
  }
}
