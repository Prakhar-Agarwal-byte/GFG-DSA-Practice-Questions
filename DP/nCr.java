class Solution {
  static int nCr(int n, int r) {
    int ans = 1;
    if (r > n - r) {
      r = n - r;
    }
    for (int i = 1; i <= r; i++) {
      ans *= (n - r + 1);
      ans /= r;
    }
    return ans;
  }
}
