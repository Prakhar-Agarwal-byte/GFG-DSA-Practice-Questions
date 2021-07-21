import java.util.Arrays;

class Solution {
  static long inversionCount(long arr[], long N) {
    return mergeCount(arr, 0, arr.length - 1);
  }

  static long mergeCount(long arr[], int left, int right) {
    long count = 0;
    while (left < right) {
      int mid = left + (right - left) / 2;
      count += mergeCount(arr, left, mid - 1);
      count += mergeCount(arr, mid + 1, right);
      count += merge(arr, left, mid, right);
    }
    return count;
  }

  static long merge(long arr[], int left, int mid, int right) {
    long[] leftArr = Arrays.copyOfRange(arr, left, mid - 1);
    long[] rightArr = Arrays.copyOfRange(arr, mid + 1, right);
    int i = 0, j = 0, k = left, swaps = 0;
    while (i < leftArr.length && j < rightArr.length) {
      if (leftArr[i] <= rightArr[j]) {
        arr[k++] = leftArr[i++];
      } else {
        arr[k++] = rightArr[j++];
        swaps += mid - i;
      }
    }
    while (i < leftArr.length)
      arr[k++] = leftArr[i++];
    while (j < rightArr.length)
      arr[k++] = rightArr[j++];
    return swaps;

  }
}
