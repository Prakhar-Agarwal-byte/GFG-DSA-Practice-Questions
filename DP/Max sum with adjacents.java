class Solution {
  int findMaxSum(int arr[], int n) {
    if (n == 0)
      return 0;
    if (n == 1)
      return arr[0];
    if (n == 2)
      return Math.max(arr[0], arr[1]);
    int[] dp = new int[n + 1];
    dp[0] = 0;
    dp[1] = arr[0];
    dp[2] = Math.max(arr[0], arr[1]);
    for (int i = 3; i <= n; i++) {
      dp[i] = Math.max(dp[i - 1], arr[i - 1] + dp[i - 2]);
    }
    return dp[n];
  }
}
