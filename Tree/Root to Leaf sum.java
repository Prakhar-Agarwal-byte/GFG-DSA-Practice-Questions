class Solution {
  public boolean hasPathSum(TreeNode root, int targetSum) {
    if (root == null)
      return false;
    return util(root, targetSum, 0);
  }

  private boolean util(TreeNode root, int targetSum, int curSum) {
    if (root == null)
      return false;
    if (root.left == null && root.right == null) {
      if (curSum + root.val == targetSum)
        return true;
    }
    return util(root.left, targetSum, curSum + root.val) || util(root.right, targetSum, curSum + root.val);
  }
}
