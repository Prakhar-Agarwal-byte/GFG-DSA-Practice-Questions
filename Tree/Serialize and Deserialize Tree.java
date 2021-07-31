import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */
public class Codec {
  public String serialize(TreeNode root) {
    return serial(new StringBuilder(), root).toString();
  }

  private StringBuilder serial(StringBuilder sb, TreeNode root) {
    if (root == null)
      return sb.append("#");
    sb.append(root.val).append(",");
    serial(sb, root.left).append(",");
    serial(sb, root.right);
    return sb;
  }

  public TreeNode deserialize(String data) {
    return deserial(new LinkedList<>(Arrays.asList(data.split(","))));
  }

  private TreeNode deserial(Queue<String> q) {
    String val = q.remove();
    if ("#".equals(val))
      return null;
    TreeNode root = new TreeNode(Integer.valueOf(val));
    root.left = deserial(q);
    root.right = deserial(q);
    return root;
  }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));
