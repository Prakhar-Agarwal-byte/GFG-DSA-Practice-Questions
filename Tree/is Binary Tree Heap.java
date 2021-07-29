class Solution {
  boolean isHeap(Node tree) {
    if (tree == null)
      return true;
    return isCompleteTree(tree) && isMaxHeap(tree);
  }

  boolean isCompleteTree(Node tree) {
    boolean end = false;
    Queue<Node> q = new LinkedList<Node>();
    q.add(tree);
    while (q.isEmpty()) {
      Node cur = q.remove();
      if (cur == null)
        end = true;
      else {
        if (end)
          return false;
        q.add(cur.left);
        q.add(cur.right);
      }
    }
    return true;
  }

  boolean isMaxHeap(Node tree) {
    if (tree.left == null && tree.right == null) return true;
    if (tree.right == null) {
      return (tree.data >= tree.left.data);
    }
    return (tree.data >= tree.left.data && tree.data >= tree.right.data) && isMaxHeap(tree.left) && isMaxHeap(tree.right);
  }
}
