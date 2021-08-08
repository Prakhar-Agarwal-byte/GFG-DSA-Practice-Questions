class Solution {
  public static long minSum(int arr[], int n) {
    PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    long num1 = 0, num2 = 0;
    boolean first = true;
    for (int i = 0; i < n; i++) {
      minHeap.add(arr[i]);
    }
    while (!minHeap.isEmpty()) {
      int dig = minHeap.poll();
      if (first) {
        num1 = 10 * num1 + dig;
      } else {
        num2 = 10 * num2 + dig;
      }
      first = !first;
    }
    return num1 + num2;
  }
}
