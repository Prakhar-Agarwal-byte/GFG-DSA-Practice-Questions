class Solution {
  ArrayList<Integer> list = new ArrayList<>();

  public ArrayList<Integer> btWithKleaves(Node root, int k) {
    if (root == null)
      return list;
    util(root, k);
    return list;
  }

  private int util(Node root, int k) {
    if (root == null)
      return 0;
    if (root.left == null && root.right == null)
      return 1;
    int left = util(root.left, k);
    int right = util(root.right, k);
    int num = left + right;
    if (num == k) {
      list.add(root.data);
    }
    return num;
  }
}
