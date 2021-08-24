class Solution {
  public int minDifference(int arr[], int n) {
    int sum = 0;
    for (int i = 0; i < arr.length; i++) {
      sum += arr[i];
    }
    boolean[][] dp = new boolean[arr.length + 1][sum + 1];
    for (int i = 0; i <= arr.length; i++) {
      dp[i][0] = true;
    }

    for (int i = 1; i <= arr.length; i++) {
      for (int j = 1; j <= sum; j++) {
        if (arr[i - 1] <= j) {
          dp[i][j] = dp[i - 1][j] || dp[i - 1][j - arr[i - 1]];
        } else {
          dp[i][j] = dp[i - 1][j];
        }
      }
    }
    ArrayList<Integer> list = new ArrayList<>();
    for (int i = 0; i <= sum; i++) {
      if (dp[arr.length][i]) {
        list.add(i);
      }
    }
    int min = Integer.MAX_VALUE;
    for (int e : list) {
      min = Math.min(min, Math.abs(sum - 2 * e));
    }
    return min;
  }
}
