import java.util.*;

public class Solution {
  private void union(int[] parent, int x, int y) {
    parent[x] = y;
  }

  private int find(int[] parent, int x) {
    if (parent[x] == -1) {
      return x;
    }
    return find(parent, parent[x]);
  }

  public boolean detectCycle(ArrayList<Edge> edgeList, int V) {
    int[] parent = new int[V];
    Arrays.fill(parent, -1);
    for (Edge e : edgeList) {
      int x = find(parent, e.src);
      int y = find(parent, e.dest);
      if (x == y) {
        return true;
      }
      union(parent, x, y);
    }
    return false;
  }
}

class Edge {
  int src;
  int dest;
}
