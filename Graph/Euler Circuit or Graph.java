class Solution {
  public int isEularCircuitExist(int V, ArrayList<ArrayList<Integer>> adj) {
    int[] order = new int[V];
    for (int i = 0; i < V; i++) {
      for (int e : adj.get(i)) {
        order[e]++;
      }
    }
    int odd = 0;
    for (int i = 0; i < V; i++) {
      if (order[i] % 2 == 1) {
        odd++;
      }
    }
    if (odd == 2)
      return 1;
    if (odd == 0)
      return 2;
    return 0;
  }
}
