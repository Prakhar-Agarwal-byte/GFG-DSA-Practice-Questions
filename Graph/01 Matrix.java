import java.util.*;

class Solution {
  public int[][] updateMatrix(int[][] mat) {
    int n = mat.length;
    int m = mat[0].length;
    int[][] dist = new int[n][m];
    for (int[] r : dist) {
      Arrays.fill(r, Integer.MAX_VALUE);
    }
    Queue<Coordinate> q = new LinkedList<>();
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        if (mat[i][j] == 0) {
          dist[i][j] = 0;
          q.add(new Coordinate(i, j));
        }
      }
    }
    int[] rM = { -1, 0, 1, 0 };
    int[] cM = { 0, 1, 0, -1 };
    while (!q.isEmpty()) {
      Coordinate cur = q.remove();
      for (int i = 0; i < 4; i++) {
        int ii = cur.i + rM[i];
        int jj = cur.j + cM[i];
        if (ii >= 0 && ii < n && jj >= 0 && jj < m) {
          if (dist[cur.i][cur.j] + 1 < dist[ii][jj]) {
            dist[ii][jj] = dist[cur.i][cur.j] + 1;
            q.add(new Coordinate(ii, jj));
          }
        }
      }
    }
    return dist;
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
