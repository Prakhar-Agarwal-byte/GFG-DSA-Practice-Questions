class Solution {
  public boolean isBipartite(int[][] graph) {
    int n = graph.length, m = graph[0].length;
    int[] color = new int[n];
    Arrays.fill(color, -1);
    for (int i = 0; i < n; i++) {
      if (color[i] == -1) {
        if (!dfs(i, 1, color, graph))
          return false;
      }
    }
    return true;
  }

  private boolean dfs(int i, int j, int[] color, int[][] graph) {
    color[i] = j;
    for (int e : graph[i]) {
      if (color[e] == -1) {
        if (!dfs(e, 1 - color[i], color, graph)) {
          return false;
        }
      } else {
        if (color[e] == color[i]) {
          return false;
        }
      }
    }
    return true;
  }
}
