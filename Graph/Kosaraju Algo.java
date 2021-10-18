class Solution {
  public int kosaraju(int V, ArrayList<ArrayList<Integer>> adj) {
    boolean[] visited = new boolean[V];
    Stack<Integer> st = new Stack<>();
    ArrayList<ArrayList<Integer>> rev = new ArrayList<>();
    for (int i = 0; i < V; i++) {
      rev.add(new ArrayList<>());
    }
    for (int i = 0; i < V; i++) {
        if (!visited[i]) {
          dfs1(i, visited, st, adj);
        }
      }
    reverse(adj, rev);
    int count = 0;
    Arrays.fill(visited, false);
    while (!st.isEmpty()) {
      int cur = st.pop();
      if (!visited[cur]) {
        dfs2(cur, visited, rev);
        count++;
      }
    }
    return count;
  }

  private void dfs2(int i, boolean[] visited, ArrayList<ArrayList<Integer>> rev) {
    visited[i] = true;
    for (int e : rev.get(i)) {
      if (!visited[e]) {
        dfs2(e, visited, rev);
      }
    }
  }

  private void reverse(ArrayList<ArrayList<Integer>> adj, ArrayList<ArrayList<Integer>> rev) {
    for (int i = 0; i < adj.size(); i++) {
      for (int e : adj.get(i)) {
        rev.get(e).add(i);
      }
    }
  }

  private void dfs1(int i, boolean[] visited, Stack<Integer> st, ArrayList<ArrayList<Integer>> adj) {
    visited[i] = true;
    for (int e : adj.get(i)) {
      if (!visited[e]) {
        dfs1(e, visited, st, adj);
      }
    }
    st.push(i);
  }
}
