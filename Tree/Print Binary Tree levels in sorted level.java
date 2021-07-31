class Solution
{
    public static ArrayList <ArrayList <Integer>> binTreeSortedLevels (int arr[], int n)
    {
        ArrayList <ArrayList <Integer>> res = new ArrayList <ArrayList <Integer>> (0);
    	int i = 0;
    
    	int t, ls = 1;
    	while (i < n)
    	{
    	    ArrayList <Integer> temp = new ArrayList <Integer> (0);
    		t = (1 << ls) - 1;
    		t = Math.min (t, n);
    		Arrays.sort(arr, i, t);
    		for (int j = i; j < t; ++j)
    		{
    			temp.add (arr[j]);
    		}
    		i = t;
    		ls++;
    		res.add (temp);
    	}
    	return res;
    }
}
