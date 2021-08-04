class Solution {
  static long countBT(int h) {
    if (h == 0 || h == 1)
      return 1;
    return countBT(h - 1) * countBT(h - 1) * countBT(h - 1) * countBT(h - 2) * countBT(h - 2) * countBT(h - 1);
  }
}
