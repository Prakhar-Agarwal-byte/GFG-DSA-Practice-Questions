class Tree {
  boolean IsFoldable(Node node) {
      if (node == null) return true;
    return util(node.left, node.right);
  }

  boolean util(Node node1, Node node2) {
    if (node1 == null && node2 == null)
      return true;
    if (node1 == null || node2 == null)
      return false;
    return util(node1.left, node2.right) && util(node1.right, node2.left);
  }
}
