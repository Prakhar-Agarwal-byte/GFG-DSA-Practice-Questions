import java.util.*;

class Solution {
  int timer = 0;

  public void findAP(ArrayList<ArrayList<Integer>> adjList, int V) {
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
    int children = 0;
    visited[i] = true;
    disc[i] = low[i] = timer++;
    for (int e : adjList.get(i)) {
      if (!visited[e]) {
        children++;
        dfs(e, visited, disc, low, i, adjList);
        low[i] = Math.min(low[i], low[e]);
        if (low[e] >= disc[i] && parent != -1) {
          System.out.println(i);
        }
      } else if (e != parent) {
        low[i] = Math.min(low[i], disc[e]);
      }
    }
    if (children > 1 && parent == -1) {
      System.out.println(i);
    }
  }
}
