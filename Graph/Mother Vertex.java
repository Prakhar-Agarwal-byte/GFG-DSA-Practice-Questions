class Solution {
  // Function to find a Mother Vertex in the Graph.
  public int findMotherVertex(int V, ArrayList<ArrayList<Integer>> adj) {
    int lastDfs = -1;
    boolean[] visited = new boolean[V];
    for (int i = 0; i < V; i++) {
      if (!visited[i]) {
        dfs(i, visited, adj);
        lastDfs = i;
      }
    }
    Arrays.fill(visited, false);
    dfs(lastDfs, visited, adj);
    for (int i = 0; i < visited.length; i++) {
      if (!visited[i])
        return -1;
    }
    return lastDfs;
  }

  private void dfs(int i, boolean[] visited, ArrayList<ArrayList<Integer>> adj) {
    visited[i] = true;
    for (int e : adj.get(i)) {
      if (!visited[e]) {
        dfs(e, visited, adj);
      }
    }
  }
}
