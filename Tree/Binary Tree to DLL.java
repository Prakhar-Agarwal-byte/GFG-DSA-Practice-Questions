public class Solution {
  TreeNode head;
  TreeNode root;
  TreeNode prev;

  void convert(Node root) {
    if (root == null)
      return;
    convert(root.left);
    if (prev == null) {
      head = root;
    } else {
      root.left = prev;
      prev.right = root;
    }
    prev = root;
    convert(root.right);
  }
}
