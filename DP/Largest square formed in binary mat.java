class Solution {
  static int maxSquare(int n, int m, int mat[][]) {
    int[][] dp = new int[n][m];
    int max = 0;
    for (int i = 0; i < n; i++) {
      dp[i][0] = mat[i][0];
      max = Math.max(max, dp[i][0]);
    }
    for (int i = 0; i < m; i++) {
      dp[0][i] = mat[0][i];
      max = Math.max(max, dp[0][i]);
    }
    for (int i = 1; i < n; i++) {
      for (int j = 1; j < m; j++) {
        if (mat[i][j] == 1) {
          dp[i][j] = 1 + Math.min(dp[i - 1][j], Math.min(dp[i - 1][j - 1], dp[i][j - 1]));
        } else {
          dp[i][j] = 0;
        }
        max = Math.max(max, dp[i][j]);
      }
    }
    return max;
  }
}
