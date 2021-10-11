class Solution {
  public int calculateMinimumHP(int[][] dungeon) {
    int n = dungeon.length;
    int m = dungeon[0].length;
    int[][] dp = new int[n][m];
    dp[n - 1][m - 1] = dungeon[n - 1][m - 1] < 0 ? dungeon[n - 1][m - 1] : 0;
    for (int i = m - 2; i >= 0; i--) {
      int need = dungeon[n - 1][i] + dp[n - 1][i + 1];
      if (need >= 0) {
        dp[n - 1][i] = 0;
      } else {
        dp[n - 1][i] = need;
      }
    }
    for (int i = n - 2; i >= 0; i--) {
      int need = dungeon[i][m - 1] + dp[i + 1][m - 1];
      if (need >= 0) {
        dp[i][m - 1] = 0;
      } else {
        dp[i][m - 1] = need;
      }
    }
    for (int i = n - 2; i >= 0; i--) {
      for (int j = m - 2; j >= 0; j--) {
        int need = Math.max(dp[i + 1][j], dp[i][j + 1]) + dungeon[i][j];
        if (need >= 0) {
          dp[i][j] = 0;
        } else {
          dp[i][j] = need;
        }
      }
    }
    return Math.abs(dp[0][0]) + 1;
  }
}
