class Solution {
  // Function to find the maximum number of cuts.
  public int maximizeCuts(int n, int x, int y, int z) {
    int[] arr = new int[3];
    arr[0] = x;
    arr[1] = y;
    arr[2] = z;
    int[][] dp = new int[arr.length + 1][n + 1];
    for (int i = 0; i <= arr.length; i++) {
      for (int j = 0; j <= n; j++)
        dp[0][i] = Integer.MIN_VALUE;
    }
    for (int i = 0; i <= arr.length; i++) {
      dp[i][0] = 0;
    }
    for (int i = 1; i <= arr.length; i++) {
      for (int j = 1; j <= n; j++) {
        if (arr[i - 1] <= j) {
          dp[i][j] = Math.max(dp[i][j - arr[i - 1]] + 1, dp[i - 1][j]);
        } else {
          dp[i][j] = dp[i - 1][j];
        }
      }
    }
    if (dp[arr.length][n] < 0)
      return 0;
    return dp[arr.length][n];
  }
}
