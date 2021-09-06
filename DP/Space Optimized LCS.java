class Solution {
  static int lcs(int x, int y, String s1, String s2) {
    int[][] dp = new int[2][y + 1];
    int bi = 0;
    for (int i = 0; i < x + 1; i++) {
      bi = i & 1;
      for (int j = 0; j < y + 1; j++) {
        if (i == 0 || j == 0) {
          dp[bi][j] = 0;
        } else if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
          dp[bi][j] = 1 + dp[1 - bi][j - 1];
        } else {
          dp[bi][j] = Math.max(dp[1 - bi][j], dp[bi][j - 1]);
        }
      }
    }
    return dp[bi][y];
  }
}
