import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

class Solution {
  Map<TreeNode, TreeNode> map = new HashMap<TreeNode, TreeNode>();

  public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
    mapParent(root);
    return bfs(target, k);
  }

  private void mapParent(TreeNode root) {
    if (root == null)
      return;
    if (root.left != null) {
      map.put(root.left, root);
    }
    if (root.right != null) {
      map.put(root.right, root);
    }
    mapParent(root.left);
    mapParent(root.right);
  }

  private List<Integer> bfs(TreeNode target, int k) {
    List<Integer> res = new ArrayList<>();
    if (target == null)
      return res;
    Queue<TreeNode> q = new LinkedList<>();
    Set<TreeNode> visited = new HashSet<>();
    int level = 0;
    q.add(target);
    visited.add(target);
    while (!q.isEmpty()) {
      int size = q.size();
      if (k == level) {
        while (!q.isEmpty()) {
          res.add(q.remove().val);
        }
        return res;
      }
      for (int i = 0; i < size; i++) {
        TreeNode cur = q.remove();
        if (cur.left != null && !visited.contains(cur.left)) {
          q.add(cur.left);
          visited.add(cur.left);
        }
        if (cur.right != null && !visited.contains(cur.right)) {
          q.add(cur.right);
          visited.add(cur.right);
        }
        TreeNode parent = map.get(cur);
        if (parent != null && !visited.contains(parent)) {
          q.add(parent);
          visited.add(parent);
        }
      }
      level++;
    }
    return res;
  }
}
