class Solution {
  public int closedIsland(int[][] grid) {
    for (int i = 0; i < grid.length; i++) {
      for (int j = 0; j < grid[0].length; j++) {
        if (grid[i][j] == 0) {
          if (i == 0 || j == 0 || i == grid.length - 1 || j == grid[0].length - 1) {
            dfs(i, j, grid);
          }
        }
      }
    }
    int count = 0;
    for (int i = 0; i < grid.length; i++) {
      for (int j = 0; j < grid[0].length; j++) {
        if (grid[i][j] == 0) {
          count++;
          dfs(i, j, grid);
        }
      }
    }
    return count;
  }

  private void dfs(int i, int j, int[][] grid) {
    grid[i][j] = 1;
    int[] rM = { -1, 0, 1, 0 };
    int[] cM = { 0, 1, 0, -1 };
    for (int k = 0; k < 4; k++) {
      int ii = i + rM[k];
      int jj = j + cM[k];
      if (isValid(ii, jj, grid)) {
        dfs(ii, jj, grid);
      }
    }
  }

  private boolean isValid(int i, int j, int[][] grid) {
    return i >= 0 && i < grid.length && j >= 0 && j < grid[0].length && grid[i][j] == 0;
  }
}
