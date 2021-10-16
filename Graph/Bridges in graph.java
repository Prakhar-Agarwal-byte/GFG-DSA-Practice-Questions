import java.util.*;

class Solution {
  int timer = 0;

  public void findBridges(ArrayList<ArrayList<Integer>> adjList, int V) {
    boolean[] visited = new boolean[V];
    int[] disc = new int[V];
    int[] low = new int[V];
    for (int i = 0; i < V; i++) {
      for (int e : adjList.get(i)) {
        if (!visited[e]) {
          dfs(e, visited, disc, low, -1, adjList);
        }
      }

    }
  }

  private void dfs(int i, boolean[] visited, int[] disc, int[] low, int parent, ArrayList<ArrayList<Integer>> adjList) {
    visited[i] = true;
    disc[i] = low[i] = timer++;
    for (int e : adjList.get(i)) {
      if (!visited[e]) {
        dfs(e, visited, disc, low, i, adjList);
        low[i] = Math.min(low[i], low[e]);
        if (low[e] > disc[i]) {
          System.out.println(i + "-" + e);
        }
      } else if (e != parent) {
        low[i] = Math.min(low[i], disc[e]);
      }
    }
  }
}
