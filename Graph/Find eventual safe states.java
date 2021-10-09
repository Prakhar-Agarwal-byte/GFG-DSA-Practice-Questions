import java.util.*;

class Solution {
  public List<Integer> eventualSafeNodes(int[][] graph) {
    int v = graph.length;
    boolean[] vis = new boolean[v];
    boolean[] curVis = new boolean[v];
    boolean[] safeNodes = new boolean[v];
    for (int i = 0; i < v; i++) {
      if (!vis[i]) {
        dfs(i, vis, curVis, safeNodes, graph);
      }
    }
    ArrayList<Integer> list = new ArrayList<>();
    for (int i = 0; i < safeNodes.length; i++) {
      if (safeNodes[i]) {
        list.add(i);
      }
    }
    return list;
  }

  private boolean dfs(int i, boolean[] vis, boolean[] curVis, boolean[] safeNodes, int[][] graph) {
    vis[i] = true;
    curVis[i] = true;
    for (int e : graph[i]) {
      if (!vis[e]) {
        if (dfs(e, vis, curVis, safeNodes, graph)) {
          return true;
        }
      } else if (curVis[e] == true) {
        return true;
      }
    }
    curVis[i] = false;
    safeNodes[i] = true;
    return false;
  }
}
