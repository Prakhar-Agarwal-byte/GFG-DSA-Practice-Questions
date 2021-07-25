class Tree {
  public static ArrayList<Integer> diagonalSum(Node root) {
    Queue<Node> q = new LinkedList<>();
    ArrayList<Integer> res = new ArrayList<>();
    q.add(root);
    q.add(null);
    int sum = 0;
    while (!q.isEmpty()) {
      Node cur = q.remove();
      if (cur == null) {
        res.add(sum);
        q.add(null);
        cur = q.remove();
        if (cur == null)
          break;
      }
      sum = 0;
      while (cur != null) {
        sum += cur.data;
        if (cur.left != null) {
          q.add(cur.left);
        }
        cur = cur.right;
      }
    }
    return res;
  }
}
