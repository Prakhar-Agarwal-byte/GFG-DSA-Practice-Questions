class Solution {
  // Function to find length of shortest common supersequence of two strings.
  public static int shortestCommonSupersequence(String X, String Y, int m, int n) {
    int[][] dp = new int[X.length() + 1][Y.length() + 1];
    for (int i = 0; i <= X.length(); i++) {
      dp[i][0] = 0;
    }
    for (int i = 0; i <= Y.length(); i++) {
      dp[0][i] = 0;
    }
    for (int i = 1; i <= X.length(); i++) {
      for (int j = 1; j <= Y.length(); j++) {
        if (X.charAt(i - 1) == Y.charAt(j - 1)) {
          dp[i][j] = 1 + dp[i - 1][j - 1];
        } else {
          dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
        }
      }
    }
    return m + n - dp[X.length()][Y.length()];
  }
}
