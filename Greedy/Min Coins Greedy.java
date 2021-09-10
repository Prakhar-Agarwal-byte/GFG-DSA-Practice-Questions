// Greedy works because sum of any 2 previous denominations is less than the next

class Solution {
  public int MinCoin(int[] nums, int amount) {
    int i = nums.length - 1;
    int count = 0;
    while (i >= 0) {
      while (nums[i] <= amount) {
        amount -= nums[i];
        count++;
      }
      i--;
    }
    if (amount > 0) return -1;
    return count;
  }
}
