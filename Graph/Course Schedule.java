class Solution {
  public boolean canFinish(int N, int[][] prerequisites) {
    LinkedList<Integer>[] adjList = new LinkedList[N];
    for (int i = 0; i < N; i++) {
      adjList[i] = new LinkedList<Integer>();
    }
    for (int i = 0; i < prerequisites.length; i++) {
      adjList[prerequisites[i][0]].add(prerequisites[i][1]);
    }
    boolean[] visited = new boolean[N];
    boolean[] curVisited = new boolean[N];
    for (int i = 0; i < N; i++) {
      if (!visited[i]) {
        if (dfs(i, visited, curVisited, adjList))
          return false;
      }
    }
    return true;
  }

  private boolean dfs(int i, boolean[] visited, boolean[] curVisited, LinkedList<Integer>[] adjList) {
    visited[i] = true;
    curVisited[i] = true;
    for (int e : adjList[i]) {
      if (!visited[e]) {
        if (dfs(e, visited, curVisited, adjList))
          return true;
      } else if (curVisited[e]) {
        return true;
      }
    }
    curVisited[i] = false;
    return false;
  }
}
