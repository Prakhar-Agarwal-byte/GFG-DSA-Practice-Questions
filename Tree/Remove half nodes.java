class Tree {
  public static Node RemoveHalfNodes(Node root) {
    if (root == null)
      return null;
    if (root.left == null && root.right == null)
      return root;
    if (root.left == null)
      return root.right;
    if (root.right == null)
      return root.left;
    root.left = RemoveHalfNodes(root.left);
    root.right = RemoveHalfNodes(root.right);
    return root;
  }
}
