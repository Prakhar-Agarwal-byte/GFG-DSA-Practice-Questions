class Solution {
  public TreeNode invertTree(TreeNode root) {
    if (root == null)
      return null;
    TreeNode leftTree = invertTree(root.left);
    TreeNode rightTree = invertTree(root.right);
    root.right = leftTree;
    root.left = rightTree;
    return root;
  }
}
