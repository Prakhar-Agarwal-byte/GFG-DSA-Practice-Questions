// Early exit on finding destination
import java.util.*;

public class Solution {
  public int dijkstra(ArrayList<ArrayList<Edge>> adjList, int dest, int V) {
    PriorityQueue<Pair> minHeap = new PriorityQueue<>(new Comparator<Pair>() {
      public int compare(Pair p1, Pair p2) {
        return p1.wsf - p2.wsf;
      }
    });
    boolean[] vis = new boolean[V];
    int[] dist = new int[V];
    minHeap.add(new Pair(0, 0));
    vis[0] = true;
    dist[0] = 0;
    boolean exists = false;
    while (!minHeap.isEmpty()) {
      Pair cur = minHeap.remove();
      for (Edge e : adjList.get(cur.node)) {
        if (!vis[e.node]) {
          dist[e.node] = cur.wsf + e.weight;
          minHeap.add(new Pair(e.node, dist[e.node]));
          if (e.node == dest) {
            exists = true;
            break;
          }
        }
      }
      if (exists)
        break;
    }
    return dist[dest];
  }
}

class Edge {
  int node;
  int weight;
}

class Pair {
  public Pair(int i, int j) {
  }

  int node;
  int wsf;
}
// Find distance of all nodes from source
import java.util.*;

public class Solution {
  public int[] dijkstra(ArrayList<ArrayList<Edge>> adjList, int dest, int V) {
    PriorityQueue<Pair> minHeap = new PriorityQueue<>(new Comparator<Pair>() {
      public int compare(Pair p1, Pair p2) {
        return p1.wsf - p2.wsf;
      }
    });
    int[] dist = new int[V];
    Arrays.fill(dist, Integer.MAX_VALUE);
    minHeap.add(new Pair(0, 0));
    dist[0] = 0;
    while (!minHeap.isEmpty()) {
      Pair cur = minHeap.remove();
      for (Edge e : adjList.get(cur.node)) {
        if (dist[e.node] < cur.wsf + e.weight) {
          dist[e.node] = cur.wsf + e.weight;
          minHeap.add(new Pair(e.node, dist[e.node]));
        }
      }
    }
    return dist;
  }
}

class Edge {
  int node;
  int weight;
}

class Pair {
  public Pair(int i, int j) {
  }

  int node;
  int wsf;
}
