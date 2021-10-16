import java.util.*;

public class Solution {
  public void prims(ArrayList<ArrayList<Edge>> adjList, int dest, int V) {
    PriorityQueue<Pair> minHeap = new PriorityQueue<>(new Comparator<Pair>() {
      public int compare(Pair p1, Pair p2) {
        return p1.w - p2.w;
      }
    });
    boolean[] vis = new boolean[V];
    minHeap.add(new Pair(0, -1, 0));
    vis[0] = true;
    while (!minHeap.isEmpty()) {
      Pair cur = minHeap.remove();
      System.out.println(cur.parent + "-" + cur.node + "@" + cur.w);
      for (Edge e : adjList.get(cur.node)) {
        if (!vis[e.node]) {
          minHeap.add(new Pair(e.node, cur.node, e.weight));
        }
      }
    }
  }
}

class Edge {
  int node;
  int weight;
}

class Pair {
  public Pair(int i, int j, int z) {
  }

  int node;
  int parent;
  int w;
}
