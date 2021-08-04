class Tree {
  int k;

  public int kthAncestor(Node root, int k, int node) {
    this.k = k;
    int res = util(root, node);
    if (this.k > 0)
      return -1;
    return res;
  }

  private int util(Node root, int node) {
    if (root == null)
      return 0;
    int left = util(root.left, node);
    int right = util(root.right, node);
    if (root.data == node)
      return root.data;
    if (k == 0)
      return left != 0 ? left : right;
    if (left != 0 || right != 0) {
      k--;
      return root.data;
    }
    return 0;
  }
}
