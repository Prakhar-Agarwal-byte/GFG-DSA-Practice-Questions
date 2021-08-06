class Tree {
  static int turns = 0;

  static int NumberOfTurns(Node root, int first, int second) {
    Node lca = lca(root, first, second);
    if (lca == null)
      return 0;
    if (lca.data != first && lca.data != second) {
      count(lca.left, first, true);
      count(lca.right, first, false);
      count(lca.left, second, true);
      count(lca.right, second, false);
    }
    return turns;
  }

  static Node lca(Node root, int first, int second) {
    if (root == null)
      return null;
    if (root.data == first)
      return root;
    if (root.data == second)
      return root;
    Node left = lca(root.left, first, second);
    Node right = lca(root.right, first, second);
    if (left != null && right != null)
      return root;
    if (left != null)
      return left;
    return right;
  }

  static int count(Node root, int target, boolean wasLeft) {
    if (root == null)
      return 0;
    if (root.data == target)
      return root.data;
    int left = count(root.left, target, true);
    int right = count(root.right, target, false);
    if ((left != 0 && !wasLeft) || (right != 0 && wasLeft)) {
      turns++;
      return left != 0 ? left : right;
    }
    return 0;
  }
}
