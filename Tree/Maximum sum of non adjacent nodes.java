class GFG {
  static int getMaxSum(Node root) {
    Pair res = helper(root);
    return Math.max(res.first, res.second);
  }

  static Pair helper(Node node) {
    if (node == null)
      return new Pair(0, 0);
    Pair left = helper(node.left);
    Pair right = helper(node.right);
    Pair p = new Pair(0, 0);

    p.first = node.data + left.second + right.second;
    p.second = Math.max(left.first, left.second) + Math.max(right.first, right.second);

    return p;
  }
}

class Pair {
  int first;
  int second;

  Pair(int first, int second) {
    this.first = first;
    this.second = second;
  }
}
