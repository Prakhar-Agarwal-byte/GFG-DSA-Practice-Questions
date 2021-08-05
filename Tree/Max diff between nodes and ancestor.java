class Tree {
  int maxDiff = Integer.MIN_VALUE;

  int maxDiff(Node root) {
    util(root);
    return maxDiff;
  }

  int util(Node root) {
    if (root == null)
      return Integer.MAX_VALUE;
    int left = util(root.left);
    int right = util(root.right);
    int min = Math.min(left, right);
    maxDiff = Math.max(maxDiff, root.data - min);
    return Math.min(min, root.data);
  }
}
