class Solution {
  public int findTargetSumWays(int[] nums, int target) {
    int sum = 0;
    int n = nums.length;
    for (int i = 0; i < n; i++) {
      sum += nums[i];
    }
    sum += target;
    if (sum % 2 == 0) {
      return subsetSumWays(nums, sum / 2, n);
    } else {
      return 0;
    }
  }

  private int subsetSumWays(int[] nums, int sum, int n) {
    int[][] dp = new int[n + 1][sum + 1];
    for (int i = 1; i <= sum; i++) {
      dp[0][i] = 0;
    }
    for (int i = 0; i <= n; i++) {
      dp[i][0] = 1;
    }
    for (int i = 1; i <= n; i++) {
      for (int j = 1; j <= sum; j++) {
        if (nums[i - 1] <= j) {
          dp[i][j] = dp[i - 1][j - nums[i - 1]] + dp[i - 1][j];
        } else {
          dp[i][j] = dp[i - 1][j];
        }
      }
    }
    return dp[n][sum];
  }
}
