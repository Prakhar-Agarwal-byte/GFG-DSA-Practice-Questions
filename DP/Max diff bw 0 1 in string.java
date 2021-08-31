class Solution {
  int maxSubstring(String S) {
    int max = -1;
    int curSum = 0;
    for (int i = 0; i < S.length(); i++) {
      if (S.charAt(i) == '1') {
        curSum--;
      } else {
        curSum++;
      }
      max = Math.max(max, curSum);
      if (curSum < 0)
        curSum = 0;
    }
    return max;
  }
}
