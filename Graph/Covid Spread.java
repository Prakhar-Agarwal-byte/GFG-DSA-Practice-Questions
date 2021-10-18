class Solution {
  public int helpaterp(int[][] hospital) {
    int n = hospital.length;
    int m = hospital[0].length;
    Queue<Pair> q = new LinkedList<>();
    int count = 0;
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        if (hospital[i][j] == 2) {
          q.add(new Pair(i, j));
        }
      }
    }
    int[] rM = { -1, 0, 1, 0 };
    int[] cM = { 0, 1, 0, -1 };
    while (!q.isEmpty()) {
      int size = q.size();
      for (int i = 0; i < size; i++) {
        Pair cur = q.remove();
        for (int k = 0; k < rM.length; k++) {
          int ii = cur.i + rM[k];
          int jj = cur.j + cM[k];
          if (ii >= 0 && ii < n && jj >= 0 && jj < m && hospital[ii][jj] == 1) {
            q.add(new Pair(ii, jj));
            hospital[ii][jj] = 2;
          }
        }
      }
      count++;
    }
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        if (hospital[i][j] == 1)
          return -1;
      }
    }
    return count-1;
  }
}

class Pair {
  int i;
  int j;

  Pair(int i, int j) {
    this.i = i;
    this.j = j;
  }
}
