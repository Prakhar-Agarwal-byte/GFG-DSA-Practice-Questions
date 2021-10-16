import java.util.*;

public class Solution {
  private void union(Node[] parent, int x, int y) {
    if (parent[x].rank < parent[y].rank) {
      parent[x].node = parent[y].node;
    } else if (parent[x].rank > parent[y].rank) {
      parent[y].node = parent[x].node;
    } else {
      parent[x].node = parent[y].node;
      parent[y].rank += 1;
    }
  }

  private int find(Node[] parent, int x) {
    if (parent[x].node == -1) {
      return x;
    }
    return parent[x].node = find(parent, parent[x].node);
  }

  public boolean detectCycle(ArrayList<Edge> edgeList, int V) {
    Node[] parent = new Node[V];
    for (int i = 0; i < V; i++)
      parent[i] = new Node(-1, 0);
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

class Node {
  int node;
  int rank;

  public Node(int i, int j) {
  }
}
