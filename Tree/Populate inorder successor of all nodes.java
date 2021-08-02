class Solution {
  Node nextSuc;

  public void populateNext(Node root) {
    if (root == null)
      return;
    populateNext(root.right);
    root.next = nextSuc;
    nextSuc = root;
    populateNext(root.left);
  }
}
