// Same as Binary tree to DLL just a variation


public class Solution {
  TreeNode head;
  TreeNode root;
  TreeNode prev;

  Node convert(Node root) {
    if (root == null)
      return null;
    if (root.left == null && root.right == null) {
      if (prev == null) {
        head = root;
      } else {
        root.left = prev;
        prev.right = root;
      }
      prev = root;
      return null;
    }
    node.left = convert(root.left);
    node.right = convert(root.right);
    return root;
  }
}
