// DFS recursive
class Solution {
  // Function to return a list containing the DFS traversal of the graph.
  public ArrayList<Integer> dfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
    boolean[] visited = new boolean[V];
    ArrayList<Integer> list = new ArrayList<>();
    dfs(0, list, visited, adj);
    return list;
  }

  private void dfs(int i, ArrayList<Integer> list, boolean[] visited, ArrayList<ArrayList<Integer>> adj) {
    visited[i] = true;
    list.add(i);
    for (int e : adj.get(i)) {
      if (!visited[e]) {
        dfs(e, list, visited, adj);
      }
    }
  }
}
// DFS iterative
class Solution {
  // Function to return a list containing the DFS traversal of the graph.
  public ArrayList<Integer> dfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
    boolean[] visited = new boolean[V];
    ArrayList<Integer> list = new ArrayList<>();
    dfs(0, list, visited, new Stack<Integer>(), adj);
    return list;
  }

  private void dfs(int i, ArrayList<Integer> list, boolean[] visited, Stack<Integer> st,
      ArrayList<ArrayList<Integer>> adj) {
    st.push(i);
    visited[i] = true;
    while (!st.isEmpty()) {
      int cur = st.pop();
      list.add(cur);
      for (int e : adj.get(cur)) {
        if (!visited[e]) {
          visited[e] = true;
          st.push(e);
        }
      }
    }
  }
}
