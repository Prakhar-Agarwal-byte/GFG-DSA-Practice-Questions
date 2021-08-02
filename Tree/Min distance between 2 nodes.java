class GfG {
  int findDist(Node root, int a, int b) {
    Node lca = findLCA(root, a, b);
    return dist(lca, a, 0) + dist(lca, b, 0);
  }

  Node findLCA(Node root, int a, int b) {
    if (root == null)
      return null;
    if (root.data == a || root.data == b)
      return root;
    Node left = findLCA(root.left, a, b);
    Node right = findLCA(root.right, a, b);
    if (left != null && right != null)
      return root;
    if (left == null && right == null)
      return null;
    if (left == null)
      return right;
    return left;
  }

  int dist(Node root, int a, int level) {
    if (root == null)
      return -1;
    if (root.data == a)
      return level;
    int left = dist(root.left, a, level + 1);
    int right = dist(root.right, a, level + 1);
    if (left == -1)
      return right;
    return left;
  }
}
