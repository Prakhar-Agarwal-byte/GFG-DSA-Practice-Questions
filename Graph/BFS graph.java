class Solution {
  // Function to return a list containing the DFS traversal of the graph.
  public ArrayList<Integer> bfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
    boolean[] visited = new boolean[V];
    ArrayList<Integer> list = new ArrayList<>();
    bfs(0, list, visited, adj);
    return list;
  }

  private void bfs(int i, ArrayList<Integer> list, boolean[] visited, ArrayList<ArrayList<Integer>> adj) {
    Queue<Integer> q = new LinkedList<>();
    q.add(i);
    visited[i] = true;
    while (!q.isEmpty()) {
      int cur = q.remove();
      list.add(cur);
      for (int e : adj.get(cur)) {
        if (!visited[e]) {
          visited[e] = true;
          q.add(e);
        }
      }
    }
  }
}
