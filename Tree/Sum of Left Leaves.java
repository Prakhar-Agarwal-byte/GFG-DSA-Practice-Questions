class Solution {
  public int sumOfLeftLeaves(TreeNode root) {
    if (root == null)
      return 0;
    return util(root.left, true) + util(root.right, false);
  }

  private int util(TreeNode node, boolean isLeft) {
    if (node == null)
      return 0;
    int sum = 0;
    if (node.left == null && node.right == null && isLeft) {
      sum = node.val;
    }
    return sum + util(node.left, true) + util(node.right, false);
  }
}
