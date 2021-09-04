class Solution {
  long countWays(int n, int k) {
    long same = k;
    long diff = k * (k - 1);
    long total = same + diff;
    for (int i = 3; i <= n; i++) {
      same = diff;
      diff = total * (k - 1);
      total = same + diff;
    }
    return total;
  }
}
