class Solution {
  public boolean isBipartite(int[][] graph) {
    int n = graph.length, m = graph[0].length;
    int[] color = new int[n];
    Arrays.fill(color, -1);
    for (int i = 0; i < n; i++) {
      if (color[i] == -1) {
        if (!bfs(i, color, graph))
          return false;
      }

    }
    return true;
  }

  private boolean bfs(int i, int[] color, int[][] graph) {
    Queue<Integer> q = new LinkedList<>();
    q.add(i);
    color[i] = 1;
    while (!q.isEmpty()) {
      int cur = q.remove();
      for (int e : graph[cur]) {
        if (color[e] == -1) {
          color[e] = 1 - color[cur];
          q.add(e);
        } else {
          if (color[e] == color[cur]) {
            return false;
          }
        }
      }
    }
    return true;
  }
}
