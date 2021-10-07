import java.util.*;

class Solution {
  public int shortestPathBinaryMatrix(int[][] grid) {
    int n = grid.length;
    int m = grid[0].length;
    if (grid[0][0] == 1 || grid[m - 1][n - 1] == 1) {
      return -1;
    }
    Queue<Coordinate> q = new LinkedList<>();
    boolean[][] visited = new boolean[n][m];
    q.add(new Coordinate(0, 0));
    visited[0][0] = true;
    int[] rM = { -1, -1, 0, 1, 1, 1, 0, -1 };
    int[] cM = { 0, 1, 1, 1, 0, -1, -1, -1 };
    int lvl = 0;
    while (!q.isEmpty()) {
      int size = q.size();
      for (int k = 0; k < size; k++) {
        Coordinate cur = q.remove();
        if (cur.i == n - 1 && cur.j == m - 1)
          return lvl + 1;
        for (int i = 0; i < 8; i++) {
          int ii = cur.i + rM[i];
          int jj = cur.j + cM[i];
          if (ii >= 0 && ii < n && jj >= 0 && jj < m && grid[ii][jj] == 0 && !visited[ii][jj]) {
            visited[ii][jj] = true;
            q.add(new Coordinate(ii, jj));
          }
        }
      }
      lvl++;
    }
    return -1;
  }
}

class Coordinate {
  int i;
  int j;

  Coordinate(int i, int j) {
    this.i = i;
    this.j = j;
  }
}
