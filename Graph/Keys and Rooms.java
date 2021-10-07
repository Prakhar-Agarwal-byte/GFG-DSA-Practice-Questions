import java.util.*;

class Solution {
  public boolean canVisitAllRooms(List<List<Integer>> rooms) {
    boolean[] visited = new boolean[rooms.size()];
    dfs(0, visited, rooms);
    for (boolean b : visited) {
      if (!b)
        return false;
    }
    return true;
  }

  private void dfs(int i, boolean[] visited, List<List<Integer>> rooms) {
    visited[i] = true;
    for (int e : rooms.get(i)) {
      if (!visited[e]) {
        dfs(e, visited, rooms);
      }
    }
  }
}
