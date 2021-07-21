class Solution {
  public int evalTree(Node root) {
    if (root == null)
      return 0;
    if (root.left == null && root.right == null) return Integer.valueOf(root.data);
    int leftEval = evalTree(root.left);
    int rightEval = evalTree(root.right);
    return calc(leftEval, rightEval, root.data);
  }

  private int calc(int left, int right, String oper) {
    switch (oper) {
      case "+":
        return left + right;
      case "-":
        return left - right;
      case "*":
        return left * right;
      case "/":
        return left / right;
    }
    return 0;
  }
}
