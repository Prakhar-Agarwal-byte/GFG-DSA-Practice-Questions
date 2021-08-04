class Solution {
  public int findMirror(Node root, int target) {
    return util(root, root, target);
  }

  private int util(Node left, Node right, int target) {
    if (left == null || right == null)
      return -1;
    if (left.data == target)
      return right.data;
    if (right.data == target)
      return left.data;
    int exterRecur = util(left.left, right.right, target);
    if (exterRecur != -1)
      return exterRecur;
    return util(left.right, right.left, target);
  }
}
