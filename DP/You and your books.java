// Simple Kadane's Algo
class Solution {
  int max_Books(int a[], int n, int k) {
    int max = 0;
    int curSum = 0;
    for (int i = 0; i < n; i++) {
      curSum += a[i];
      if (a[i] > k)
        curSum = 0;
      max = Math.max(max, curSum);
    }
    return max;
  }
}
