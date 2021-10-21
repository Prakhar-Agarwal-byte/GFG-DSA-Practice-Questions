class Solution {
  int count;

  public int countPaths(int V, ArrayList<ArrayList<Integer>> adj, int source, int destination) {
    dfs(source, destination, adj);
    return count;
  }

  private void dfs(int i, int dest, ArrayList<ArrayList<Integer>> adj) {
    if (i == dest) {
      count++;
      return;
    }
    for (int e : adj.get(i)) {
      dfs(e, dest, adj);
    }
  }
}
