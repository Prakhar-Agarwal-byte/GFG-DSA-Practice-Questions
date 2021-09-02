class Solution {
  // Function to find the maximum profit and the number of jobs done.
  int[] JobScheduling(Job arr[], int n) {
    Arrays.sort(arr, (a, b) -> (b.profit - a.profit));
    int maxDeadline = 0;
    for (int i = 0; i < n; i++) {
      maxDeadline = Math.max(maxDeadline, arr[i].deadline);
    }
    int[] a = new int[maxDeadline + 1];
    Arrays.fill(a, -1);
    int count = 0;
    int maxProfit = 0;
    for (int i = 0; i < n; i++) {
      for (int j = arr[i].deadline; j > 0; j--) {
        if (a[j] == -1) {
          count++;
          maxProfit += arr[i].profit;
          a[j] = arr[i].id;
          break;
        }
      }
    }
    int[] res = { count, maxProfit };
    return res;
  }
}
