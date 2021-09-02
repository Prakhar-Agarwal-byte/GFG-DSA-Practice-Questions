class Solution {
  public static int maxSumSubarray(int A[], int n) {
    int[] forw = new int[n];
    int[] back = new int[n];
    int max = Integer.MIN_VALUE;
    int curSum = 0;
    for (int i = 0; i < n; i++) {
      curSum += A[i];
      Math.max(max, curSum);
      forw[i] = max;
      if (curSum < 0)
        curSum = 0;
    }
    max = Integer.MIN_VALUE;
    curSum = 0;
    for (int i = n - 1; i >= 0; i--) {
      curSum += A[i];
      Math.max(max, curSum);
      back[i] = max;
      if (curSum < 0)
        curSum = 0;
    }
    max = Integer.MIN_VALUE;
    for (int i = 1; i < n - 1; i++) {
      max = Math.max(max, forw[i - 1] + back[i + 1]);
    }
    return max;
  }
}
