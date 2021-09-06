class Solution {
  public static int maxSumPairWithDifferenceLessThanK(int arr[], int N, int K) {
    if (N == 1)
      return 0;
    int[] dp = new int[N];
    Arrays.sort(arr);
    if (arr[1] - arr[0] < K) {
      dp[1] = arr[0] + arr[1];
    }
    for (int i = 2; i < N; i++) {
      if (arr[i] - arr[i - 1] < K) {
        dp[i] = dp[i - 2] + arr[i] + arr[i - 1];
      } else {
        dp[i] = dp[i - 1];
      }
    }
    return dp[N - 1];
  }
}
