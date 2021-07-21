class Solution {
  static HashMap<Tree, Tree> map = new HashMap<>();

  public static Tree cloneTree(Tree tree) {
    if (tree == null)
      return null;
    Tree t = copyLeftAndRightPointer(tree);
    copyRandomPointer(tree);
    return t;
  }

  private static Tree copyLeftAndRightPointer(Tree tree) {
    if (tree == null)
      return null;
    Tree t = new Tree(tree.data);
    map.put(tree, t);
    t.left = copyLeftAndRightPointer(tree.left);
    t.right = copyLeftAndRightPointer(tree.right);
    return t;
  }

  private static void copyRandomPointer(Tree tree) {
    if (tree == null)
      return;
    Tree t = map.get(tree);
    t.random = tree.random;
    copyRandomPointer(tree.left);
    copyRandomPointer(tree.right);
  }
}
