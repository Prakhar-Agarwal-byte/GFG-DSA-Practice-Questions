class Solution {
  List<Integer> list = new ArrayList<>();

  Node binaryTreeToBST(Node root) {
    if (root == null)
      return null;
    toList(root);
    return toBST(0, list.size() - 1);
  }

  void toList(Node root) {
    if (root == null)
      return ;
    list.add(root.data);
    toList(root.left);
    toList(root.right);
  }

  Node toBST(int start, int end) {
    if (start > end)
      return null;
    int mid = start + (end - start) / 2;
    Node node = new Node(list.get(mid));
    node.left = toBST(start, mid - 1);
    node.right = toBST(mid + 1, end);
    return node;
  }
}
