class Solution {
  static int heapHeight(int N, int arr[]) {
    return (int) Math.ceil(Math.log(N + 1) / Math.log(2)) - 1;
  }
}
