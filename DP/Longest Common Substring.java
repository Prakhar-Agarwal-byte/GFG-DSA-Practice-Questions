class Solution {
  public int findLength(int[] nums1, int[] nums2) {
    int[][] dp = new int[nums1.length + 1][nums2.length + 1];
    for (int i = 0; i <= nums1.length; i++) {
      dp[i][0] = 0;
    }
    for (int i = 0; i <= nums2.length; i++) {
      dp[0][i] = 0;
    }
    int max = Integer.MIN_VALUE;
    for (int i = 1; i <= nums1.length; i++) {
      for (int j = 1; j <= nums2.length; j++) {
        if (nums1[i - 1] == nums2[j - 1]) {
          dp[i][j] = 1 + dp[i - 1][j - 1];
        } else {
          dp[i][j] = 0;
        }
        max = Math.max(max, dp[i][j]);
      }
    }
    return max;
  }
}
