class Solution {
  public boolean isCousins(TreeNode root, int x, int y) {
    if (root == null)
      return false;
    return (level(root, x, 1) == level(root, y, 1)) && !isSibling(root, x, y);
  }

  private boolean isSibling(TreeNode root, int x, int y) {
    if (root == null)
      return false;
    return (root.left != null && root.left.val == x && root.right != null && root.right.val == y) || (root.left != null && root.left.val == y && root.right != null && root.right.val == x)
        || isSibling(root.left, x, y) || isSibling(root.right, x, y);
  }

  private int level(TreeNode root, int x, int level) {
    if (root == null)
      return 0;
    if (root.val == x)
      return level;
    int left = level(root.left, x, level + 1);
    int right = level(root.right, x, level + 1);
    if (left != 0) {
      return left;
    }
    return right;
  }
}
