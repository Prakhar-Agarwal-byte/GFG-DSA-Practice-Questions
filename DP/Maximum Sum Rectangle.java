class Solution {
  int maximumSumRectangle(int R, int C, int M[][]) {
    int[][] prefix = new int[R + 1][C];
    for (int j = 0; j < C; j++) {
      for (int i = 0; i < R; i++) {
        prefix[i + 1][j] = prefix[i][j] + M[i][j];
      }
    }
    int totMax = Integer.MIN_VALUE;
    for (int i = 0; i < R+1; i++) {
      for (int j = i + 1; j < R+1; j++) {
        int[] temp = new int[C];
        for (int k = 0; k < C; k++) {
          temp[k] = prefix[j][k] - prefix[i][k];
        }
        int max = Integer.MIN_VALUE;
        int curSum = 0;
        for (int k = 0; k < C; k++) {
          curSum += temp[k];
          max = Math.max(max, curSum);
          if (curSum < 0)
            curSum = 0;
        }
        totMax = Math.max(totMax, max);
      }
    }
    return totMax;
  }
}
