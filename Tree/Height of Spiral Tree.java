class Tree {
  public static int findTreeHeight(Node root) {
    if (root == null)
      return 0;
    if (isLeaf(root)) {
      return 1;
    }
    return Math.max(findTreeHeight(root.left), findTreeHeight(root.right)) + 1;
  }

  private static boolean isLeaf(Node node) {
    if (node == null)
      return false;
    return (node.left != null && node.left.right == node && node.right != null && node.right.left == node);
  }
}
