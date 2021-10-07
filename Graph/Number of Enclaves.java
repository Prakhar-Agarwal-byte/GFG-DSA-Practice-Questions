class Solution {
  public int numEnclaves(int[][] grid) {
    int n = grid.length, m = grid[0].length;
    for (int i = 0; i < m; i++) {
      if (grid[0][i] == 1) {
        dfs(0, i, grid);
      }
    }
    for (int i = 0; i < m; i++) {
      if (grid[n - 1][i] == 1) {
        dfs(n - 1, i, grid);
      }
    }
    for (int i = 0; i < n; i++) {
      if (grid[i][0] == 1) {
        dfs(i, 0, grid);
      }
    }
    for (int i = 0; i < n; i++) {
      if (grid[i][m - 1] == 1) {
        dfs(i, m - 1, grid);
      }
    }
    int count = 0;
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        if (grid[i][j] == 1) {
          count++;
        }
      }
    }
    return count;
  }

  private void dfs(int i, int j, int[][] grid) {
    grid[i][j] = 2;
    int[] rM = { -1, 0, 1, 0 };
    int[] cM = { 0, 1, 0, -1 };
    for (int k = 0; k < rM.length; k++) {
      int ii = i + rM[k];
      int jj = j + cM[k];
      if (isValid(ii, jj, grid)) {
        dfs(ii, jj, grid);
      }
    }
  }

  private boolean isValid(int i, int j, int[][] grid) {
    return i >= 0 && i < grid.length && j >= 0 && j < grid[0].length && grid[i][j] == 1;
  }
}
