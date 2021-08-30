class Geeks {
  public long count(int n) {
    int[] arr = { 3, 5, 10 };
    long[][] dp = new long[4][n + 1];
    for (int i = 0; i <= n; i++) {
      dp[0][i] = 0;
    }
    for (int i = 0; i <= 3; i++) {
      dp[i][0] = 1;
    }
    for (int i = 1; i <= 3; i++) {
      for (int j = 1; j <= n; j++) {
        if (arr[i - 1] <= j) {
          dp[i][j] = dp[i][j - arr[i - 1]] + dp[i - 1][j];
        } else {
          dp[i][j] = dp[i - 1][j];
        }
      }
    }
    return dp[3][n];
  }
}
