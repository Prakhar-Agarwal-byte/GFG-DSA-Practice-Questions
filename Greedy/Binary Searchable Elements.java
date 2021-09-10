class Solution {
    static int binarySearchable(int[] Arr, int n) {
        int[] maxLeft = new int[n];
        int[] minRight = new int[n];
        
        maxLeft[0] = Arr[0];
        minRight[n-1] = Arr[n-1];
        
        for(int i=1; i<n; i++)
            maxLeft[i] = Math.max(maxLeft[i-1], Arr[i]);
            
        for(int i=n-2; i>=0; i--)
            minRight[i] = Math.min(minRight[i+1], Arr[i]); 
            
        int count = 0;
        for(int i=0; i<n; i++)
        {
            if (Arr[i] <= minRight[i] && Arr[i] >= maxLeft[i])
                count++;
        }
        
        return count;
    }
}
