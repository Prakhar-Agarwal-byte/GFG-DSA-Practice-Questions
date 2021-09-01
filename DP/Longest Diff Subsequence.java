class Solution {
  static int longestSubsequence(int N, int A[]) {
    int[] dp = new int[N];
    int max = 1;
    Arrays.fill(dp, 1);
    for (int i = 1; i < N; i++) {
      for (int j = 0; j < i; j++) {
        if (Math.abs(A[j] - A[i]) == 1) {
          dp[i] = Math.max(dp[i], 1 + dp[j]);
        }
      }
      max = Math.max(max, dp[i]);
    }
    return max;
  }
}
