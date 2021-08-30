class Solution {
  public int maxSum(int n) {
    if (n == 0 || n == 1)
      return n;
    int[] dp = new int[n + 1];
    dp[0] = 0;
    dp[1] = 0;
    for (int i = 2; i <= n; i++) {
      dp[i] = Math.max(dp[n / 2] + dp[n / 3] + dp[n / 4], n);
    }
    return dp[n];
  }
}
