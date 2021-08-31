import java.util.Arrays;

class Solution {
  int[] dp;

  public int maxAmt(int n, int hi[], int li[]) {
    dp = new int[n];
    Arrays.fill(dp, -1);
    return util(n, hi, li, 0, false);
  }

  private int util(int n, int hi[], int li[], int i, boolean choseHigh) {
    if (i >= n)
      return 0;
    if (dp[i] != -1) {
      return dp[i];
    }
    if (choseHigh) {
      return dp[i] = Math.max(util(n, hi, li, i + 1, false), li[i] + util(n, hi, li, i + 1, false));
    } else {
      return dp[i] = Math.max(util(n, hi, li, i + 1, false),
          Math.max(hi[i] + util(n, hi, li, i + 1, true), li[i] + util(n, hi, li, i + 1, false)));
    }
  }
}
