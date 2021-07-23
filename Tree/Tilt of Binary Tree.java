class Solution {
    private int totalTilt = 0;

    protected int valueSum(TreeNode node) {
        if (node == null)
            return 0;

        int leftSum = valueSum(node.left);
        int rightSum = valueSum(node.right);
        int tilt = Math.abs(leftSum - rightSum);
        totalTilt += tilt;

        // return the sum of values starting from this node.
        return node.val + leftSum + rightSum;
    }

    public int findTilt(TreeNode root) {
        totalTilt = 0;
        valueSum(root);
        return totalTilt;
    }
}
