import java.util.ArrayList;
import java.util.List;

class Solution {
  List<Node> list = new ArrayList<>();

  public int pthAncestor(Node root, int x, int y, int p) {
    dfs(root, x, y, p);
    return list.get(list.size() - p).val;
  }

  private void dfs(Node node, int x, int y, int p) {
    if (node == null)
      return;
    if (node.val > x && node.val > y) {
      list.add(node);
      dfs(node.left, x, y, p);
    } else if (node.val < x && node.val < y) {
      list.add(node);
      dfs(node.right, x, y, p);
    } else {
      list.add(node);
      return;
    }
  }
}
