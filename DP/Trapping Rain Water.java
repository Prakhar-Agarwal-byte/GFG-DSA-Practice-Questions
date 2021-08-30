class Solution {
  public int trap(int[] height) {
    int l = 1;
    int r = height.length - 2;
    int leftMax = height[0];
    int rightMax = height[height.length - 1];
    int ans = 0;
    while (l <= r) {
      if (leftMax < rightMax) {
        if (height[l] > leftMax) {
          leftMax = height[l];
        } else {
          ans += leftMax - height[l];
          l++;
        }
      } else {
        if (height[r] > rightMax) {
          rightMax = height[r];
        } else {
          ans += rightMax - height[r];
          r--;
        }
      }
    }
    return ans;
  }
}
