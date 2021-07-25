class Solution {
  public void toSumTree(Node root) {
    util(root);
  }

  private int util(Node root) {
    if (root == null)
      return 0;
    int left = util(root.left);
    int right = util(root.right);
    int temp = root.data;
    root.data = left + right;
    return temp + left + right;
  }
}
