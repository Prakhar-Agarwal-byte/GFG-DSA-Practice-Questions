class Solution {
  int offerings(int N, int arr[]) {
    int[] L = new int[N];
    Arrays.fill(L, 1);
    for (int i = 1; i < N; i++) {
      if (arr[i - 1] < arr[i]) {
        L[i] = L[i - 1] + 1;
      }
    }
    int[] R = new int[N];
    Arrays.fill(R, 1);
    for (int i = N - 2; i >= 0; i--) {
      if (arr[i + 1] < arr[i]) {
        R[i] = R[i + 1] + 1;
      }
    }
    int sum = 0;
    for (int i = 0; i < N; i++) {
      sum += Math.max(L[i], R[i]);
    }
    return sum;
  }
}
