import java.util.Arrays;

class Solution {
  static int eggDrop(int n, int k) {
    int[][] dp = new int[k + 1][n + 1];
    for (int[] row : dp) {
      Arrays.fill(row, -1);
    }
    return util(k, n, dp);
  }

  private static int util(int k, int n, int[][] dp) {
    if (k == 1)
      return n;
    if (n == 0 || n == 1)
      return n;
    if (dp[k][n] != -1) {
      return dp[k][n];
    }
    int min = Integer.MAX_VALUE;
    for (int a = 1; a <= n; a++) {
      int temp = 1 + Math.max(util(k - 1, a - 1, dp), util(k, n - a, dp));
      min = Math.min(min, temp);
    }
    return dp[k][n] = min;
  }
}
