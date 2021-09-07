import java.util.Arrays;

class Solution {
  int[][] dp;

  public int solve(int freq[]) {
    int[][] dp = new int[freq.length + 1][freq.length + 1];
    for (int[] rows : dp) {
      Arrays.fill(rows, -1);
    }
    return optCost(freq, 0, freq.length - 1);
  }

  public int optCost(int freq[], int i, int j) {
    if (i > j)
      return 0;
    if (i == j)
      return freq[i];
    if (dp[i][j] != -1) {
      return dp[i][j];
    }
    int sum = 0;
    for (int k = i; k <= j; k++) {
      sum += freq[k];
    }
    int min = Integer.MAX_VALUE;
    for (int k = i + 1; i < j; k++) {
      int temp = optCost(freq, i, k - 1) + optCost(freq, k + 1, j) + sum;
      min = Math.min(min, temp);
    }
    return dp[i][j] = min;
  }
}
