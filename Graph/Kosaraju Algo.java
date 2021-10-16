import java.util.*;

class Solution {
  public void kosaraju(ArrayList<ArrayList<Integer>> adjList, int V) {
    ArrayList<ArrayList<Integer>> rev = new ArrayList<>();
    for (int i = 0; i < V; i++) {
      rev.add(new ArrayList<Integer>());
    }
    boolean[] visited = new boolean[V];
    Stack<Integer> st = new Stack<>();
    for (int u = 0; u < V; u++) {
      if (!visited[u]) {
        dfs1(u, visited, st, adjList);
      }
    }
    reverseEdges(adjList, rev, V);
    Arrays.fill(visited, false);
    while (!st.isEmpty()) {
      int cur = st.pop();
      if (!visited[cur]) {
        dfs2(cur, visited, adjList);
      }
      System.out.println();
    }
  }

  private void dfs2(int cur, boolean[] visited, ArrayList<ArrayList<Integer>> adjList) {
    visited[cur] = true;
    System.out.print(cur + " ");
    for (int e : adjList.get(cur)) {
      if (!visited[e]) {
        dfs2(e, visited, adjList);
      }
    }
  }

  private void reverseEdges(ArrayList<ArrayList<Integer>> adjList, ArrayList<ArrayList<Integer>> rev, int V) {
    for (int u = 0; u < V; u++) {
      for (int e : adjList.get(u)) {
        rev.get(e).add(u);
      }
    }
  }

  private void dfs1(int u, boolean[] visited, Stack<Integer> st, ArrayList<ArrayList<Integer>> adjList) {
    visited[u] = true;
    st.push(u);
    for (int v : adjList.get(u)) {
      if (!visited[v]) {
        dfs1(v, visited, st, adjList);
      }
    }
    st.push(u);
  }
}
