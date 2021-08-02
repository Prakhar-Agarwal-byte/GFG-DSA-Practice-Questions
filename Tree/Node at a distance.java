class Solution
{
    int ctr;
    boolean visited[] = new boolean[100001];

    public void kDistantFromLeafUtil(Node root, int len, int k)
    {
        //base case
        if (root == null) return;

        visited[len] = false;
        len++;

        //if itâ€™s a leaf node, we increment the count but only if the 
	    //same ancestor at distance k is not already counted.
        if (root.left == null && root.right == null &&
            len-k-1 >= 0 && visited[len-k-1] == false)
        {
            ctr++;
            //setting the ancestor as visited so that we won't count it again.
            visited[len-k-1] = true;
            return;
        }

        //if the current node is not a leaf node then we call the function 
	    //recursively for left and right subtrees.
        kDistantFromLeafUtil(root.left, len, k);
        kDistantFromLeafUtil(root.right, len, k);
        
    }
    //Function to return count of nodes at a given distance from leaf nodes.
    public int printKDistantfromLeaf(Node root, int k)
    {
        ctr = 0;
        Arrays.fill(visited, false);

        kDistantFromLeafUtil(root, 0, k);
        //returning the count.
        return ctr;
    }

}
