class Solution {
  // Function to find the sum of contiguous subarray with maximum sum.
  long maxSubarraySum(int arr[], int n) {
    long max = Long.MIN_VALUE;
    long curSum = 0;
    for (int i = 0; i < n; i++) {
      curSum += arr[i];
      max = Math.max(max, curSum);
      if (curSum < 0)
        curSum = 0;
    }
    return max;
  }
}
