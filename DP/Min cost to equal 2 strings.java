class Solution {
  public int findMinCost(String X, String Y, int costX, int costY) {
    int[][] dp = new int[X.length() + 1][Y.length() + 1];
    for (int i = 1; i <= X.length(); i++) {
      for (int j = 1; j <= Y.length(); j++) {
        if (X.charAt(i - 1) == Y.charAt(j - 1)) {
          dp[i][j] = 1 + dp[i - 1][j - 1];
        } else {
          dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
        }
      }
    }
    int lcs = dp[X.length()][Y.length()];
    return costX * (X.length() - lcs) + costY * (Y.length() - lcs);
  }
}
