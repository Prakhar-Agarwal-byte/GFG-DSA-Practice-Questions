import java.util.*;

class Solution {
  int timer = 0;

  public void findAP(ArrayList<ArrayList<Integer>> adjList, int V) {
    int[] disc = new int[V];
    int[] low = new int[V];
    boolean[] stArr = new boolean[V];
    Stack<Integer> st = new Stack<>();
    Arrays.fill(disc, -1);
    Arrays.fill(low, -1);
    for (int i = 0; i < V; i++) {
      if (disc[i] == -1) {
        dfs(i, disc, low, stArr, st, adjList);
      }
    }
  }

  private void dfs(int i, int[] disc, int[] low, boolean[] stArr, Stack<Integer> st,
      ArrayList<ArrayList<Integer>> adjList) {
    disc[i] = low[i] = timer++;
    stArr[i] = true;
    st.push(i);
    for (int e : adjList.get(i)) {
      if (disc[e] == -1) {
        dfs(e, disc, low, stArr, st, adjList);
        low[i] = Math.min(low[i], low[e]);
      } else if (stArr[e] == true) {
        low[i] = Math.min(low[i], disc[e]);
      }
    }
    if (disc[i] == low[i]) {
      while (st.peek() != i) {
        int t = st.pop();
        stArr[t] = false;
        System.out.print(t + " ");
      }
      stArr[i] = false;
      st.pop();
      System.out.println(i);
    }
  }
}
