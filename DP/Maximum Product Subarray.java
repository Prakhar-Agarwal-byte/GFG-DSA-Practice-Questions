class Solution {
  public int maxProduct(int[] arr) {
    int n = arr.length;
    int minVal = arr[0];
    int maxVal = arr[0];
    int maxProd = arr[0];
    for (int i = 1; i < n; i++) {
      if (arr[i] < 0) {
        int temp = minVal;
        minVal = maxVal;
        maxVal = temp;
      }
      minVal = Math.min(arr[i], minVal * arr[i]);
      maxVal = Math.max(arr[i], maxVal * arr[i]);
      maxProd = Math.max(maxProd, maxVal);
    }
    return maxProd;
  }
}
