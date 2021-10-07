// Basic Topological sort on DAG
class Solution {
  public int[] findOrder(int n, int[][] prerequisites) {
    boolean[] visited = new boolean[n];
    LinkedList<Integer>[] adjList = new LinkedList[n];
    Arrays.fill(adjList, new LinkedList<Integer>());
    for (int i = 0; i < prerequisites.length; i++) {
      adjList[prerequisites[i][1]].add(prerequisites[i][0]);
    }
    Stack<Integer> st = new Stack<>();
    for (int i = 0; i < n; i++) {
      if (!visited[i]) {
        dfs(i, visited, st, adjList);
      }
    }
    int[] ordering = new int[n];
    for (int i = 0; i < n; i++) {
      ordering[i] = st.pop();
    }
    return ordering;
  }

  private void dfs(int i, boolean[] visited, Stack<Integer> st, LinkedList<Integer>[] adjList) {
    visited[i] = true;
    for (int e : adjList[i]) {
      if (!visited[e]) {
        dfs(e, visited, st, adjList);
      }
    }
    st.add(i);
  }
}
// Checking if the graph is a DAG then doing Top sort
// will update in future
// Top Sort using BFS (Kahn's Algorithm)
class Solution {
  public int[] findOrder(int n, int[][] prerequisites) {
    LinkedList<Integer>[] adjList = new LinkedList[n];
    for (int i = 0; i < n; i++) {
        adjList[i] = new LinkedList<Integer>();
    }
    int[] inDegree = new int[n];
    for (int i = 0; i < prerequisites.length; i++) {
      adjList[prerequisites[i][1]].add(prerequisites[i][0]);
      inDegree[prerequisites[i][0]]++;
    }
    List<Integer> list = new ArrayList<>();
    Queue<Integer> q = new LinkedList<>();
    for (int i = 0; i < n; i++) {
      if (inDegree[i] == 0) {
        q.add(i);
      }
    }
    int count = 0;
    while (!q.isEmpty()) {
      int cur = q.remove();
      for (int e : adjList[cur]) {
        inDegree[e]--;
        if (inDegree[e] == 0) {
          q.add(e);
        }
      }
      list.add(cur);
      count++;
    }
    if (count == n) {
      int[] ordering = new int[n];
      for (int i = 0; i < n; i++) {
        ordering[i] = list.get(i);
      }
      return ordering;
    } else {
      return new int[0];
    }
  }
}
