class Solution {
  // Function to find the minimum number of platforms required at the
  // railway station such that no train waits.
  static int findPlatform(int arr[], int dep[], int n) {
    int i = 0;
    int j = 0;
    int max = 0;
    int plats = 0;
    Arrays.sort(arr);
    Arrays.sort(dep);
    while (i < n && j < n) {
      if (arr[i] == dep[j]) {
        plats++;
        i++;
      } else if (arr[i] < dep[j]) {
        plats++;
        i++;
      } else {
        plats--;
        j++;
      }
      max = Math.max(max, plats);
    }
    return max;
  }
}
