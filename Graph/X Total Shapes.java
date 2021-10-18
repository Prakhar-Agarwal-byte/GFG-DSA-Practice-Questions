class Solution {
  public int xShape(char[][] grid) {
    int count = 0;
    for (int i = 0; i < grid.length; i++) {
      for (int j = 0; j < grid[0].length; j++) {
        if (grid[i][j] == 'X') {
          dfs(i, j, grid);
          count++;
        }
      }
    }
    return count;
  }

  private void dfs(int i, int j, char[][] grid) {
    grid[i][j] = 'O';
    int[] r = { -1, 0, 1, 0 };
    int[] c = { 0, 1, 0, -1 };
    for (int k = 0; k < r.length; k++) {
      int ii = i + r[k];
      int jj = j + c[k];
      if (ii >= 0 && ii < grid.length && jj >= 0 && jj < grid[0].length && grid[ii][jj] == 'X') {
        dfs(ii, jj, grid);
      }
    }
  }
}
