class Solution {
  public int sumOfLongRootToLeafPath(Node root) {
    if (root == null)
      return 0;
    Pair p = util(root);
    return p.sum;
  }

  private Pair util(Node root) {
    if (root == null)
      return new Pair(0, 0);
    Pair left = util(root.left);
    Pair right = util(root.right);
    if (left.height == right.height) {
      int max = Math.max(left.sum, right.sum);
      return new Pair(left.height + 1, max + root.data);
    }
    if (left.height > right.height) {
      return new Pair(left.height + 1, left.sum + root.data);
    }
    return new Pair(right.height + 1, right.sum + root.data);
  }
}

class Pair {
  int height;
  int sum;

  Pair(int height, int sum) {
    this.height = height;
    this.sum = sum;
  }
}
