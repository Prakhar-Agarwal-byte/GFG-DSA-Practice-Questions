class Tree {
  int count = 0;

  int countSubtreesWithSumX(Node root, int X) {
    if (root == null)
      return 0;
    util(root, X);
    return count;
  }

  private int util(Node node, int X) {
    if (node == null)
      return 0;
    int sum = node.data + util(node.left, X) + util(node.right, X);
    if (sum == X)
      count++;
    return sum;
  }
}
