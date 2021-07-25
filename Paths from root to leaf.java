class Solution {
    public List<String> binaryTreePaths(TreeNode root) {
         List<String> l = new ArrayList<String>();
    
    if(root == null)
        return l;
    find(root,l,"");
    return l;
    
}

public void find(TreeNode root,List<String> l, String path)
{
    if(root.left == null && root.right == null)
    {   l.add(path + root.val);
        return;
    } 
    if(root.left != null)
    {
        find(root.left,l,path + root.val + "->");
    }
    
    if(root.right != null)
    {
        find(root.right,l,path + root.val + "->");
    }
    }
}
