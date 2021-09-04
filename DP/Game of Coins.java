class Solution {
  public int findWinner(int N, int X, int Y) {
    boolean[] dp = new boolean[N + 1];
    dp[0] = false;
    dp[1] = true;
    for (int i = 2; i <= N; i++) {
      if (i - 1 >= 0 && dp[i - 1] == false) {
        dp[i] = true;
      } else if (i - X >= 0 && dp[i - X] == false) {
        dp[i] = true;
      } else if (i - Y >= 0 && dp[i - Y] == false) {
        dp[i] = true;
      } else {
        dp[i] = false;
      }
    }
    if (dp[N] == true)
      return 1;
    return 0;
  }
}
