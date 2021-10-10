import java.util.*;

class Solution {
  public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
    List<List<Integer>> list = new ArrayList<>();
    dfs(root, 0, new ArrayList<Integer>(), targetSum, list);
    return list;
  }

  private void dfs(TreeNode root, int curSum, ArrayList<Integer> curList, int targetSum, List<List<Integer>> list) {
    if (root == null)
      return;
    curSum += root.val;
    curList.add(root.val);
    if (root.left == null && root.right == null && curSum == targetSum) {
      list.add(new ArrayList<>(curList));
    }
    dfs(root.left, curSum, curList, targetSum, list);
    dfs(root.right, curSum, curList, targetSum, list);
    curList.remove(curList.size() - 1);
  }
}
