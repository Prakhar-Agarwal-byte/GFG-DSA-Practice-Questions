class Solution {
  char[][] keypad = { { '1', '2', '3' }, { '4', '5', '6' }, { '7', '8', '9' }, { '*', '0', '#' } };
  long[][] dp;

  public long getCount(int N) {
    dp = new long[4][3];
    for (long[] rows : dp) {
      Arrays.fill(rows, -1);
    }
    long total = 0;
    for (int i = 0; i < 4; i++) {
      for (int j = 0; j < 3; j++) {
        if (keypad[i][j] != '*' && keypad[i][j] != '#') {
          total += util(N, i, j);
        }
      }
    }
    return total;
  }

  private long util(int n, int i, int j) {
    if (n <= 0)
      return 0;
    if (n == 1)
      return 1;
    if (dp[i][j] != -1) {
      return dp[i][j];
    }
    int[] mI = { 0, 1, 0, -1, 0 };
    int[] mj = { 0, 0, -1, 0, 1 };
    long ans = 0;
    for (int k = 0; k < 5; k++) {
      int r = i + mI[k];
      int c = j + mj[k];
      if (r >= 0 && r <= 3 && c >= 0 && c <= 2 && keypad[r][c] != '*' && keypad[r][c] != '#') {
        ans += util(n - 1, r, c);
      }
    }
    return dp[i][j] = ans;
  }
}
