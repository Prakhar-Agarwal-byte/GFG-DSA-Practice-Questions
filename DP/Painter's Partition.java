class Solution {
  static long minTime(int[] arr, int n, int k) {
    long low = Long.MIN_VALUE;
    long high = 0;
    for (int i = 0; i < n; i++) {
      low = Math.max(low, arr[i]);
      high += arr[i];
    }
    long ans = 0;
    while (low <= high) {
      long mid = low + (high - low) / 2;
      if (isValid(arr, k, mid)) {
        ans = mid;
        high = mid - 1;
      } else {
        low = mid + 1;
      }
    }
    return ans;
  }

  private static boolean isValid(int[] arr, int k, long mid) {
    int students = 1;
    long sum = 0;
    for (int i = 0; i < arr.length; i++) {
      sum += arr[i];
      if (sum > mid) {
        sum = arr[i];
        students++;
      }
    }
    if (students > k)
      return false;
    return true;
  }
}
