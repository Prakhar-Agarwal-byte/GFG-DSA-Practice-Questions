class Solution {
    int postIdx;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if(inorder==null || postorder == null)
            return null;
        postIdx = postorder.length-1;
        Map<Integer, Integer> indexes = new HashMap();
        for(int i =0; i<inorder.length; i++){
            indexes.put(inorder[i],i);     
        }
        return helper(inorder, postorder,0,inorder.length-1, indexes);
    }
    private TreeNode helper(int[] inorder, int[] postorder, int iStart, int iEnd, Map<Integer, Integer> indexes){
        if(postIdx<0 || iStart>iEnd)
            return null;
        int idx = indexes.get(postorder[postIdx]);
        TreeNode node = new TreeNode(postorder[postIdx]);
        postIdx--;
        node.right = helper(inorder, postorder,idx+1, iEnd,indexes);
        node.left = helper(inorder, postorder, iStart, idx-1, indexes);
        return node;
    }
}
