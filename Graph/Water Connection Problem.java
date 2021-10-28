class Solution 
{ 
    int n, p;
    int rd[], wt[], cd[], ans;
    
    int dfs(int w){
    	if (cd[w] == 0)
    		return w;
    	if (wt[w] < ans)
    		ans = wt[w];
    	return dfs(cd[w]);
    }
    
    ArrayList<ArrayList<Integer>> solve(int n, int p, ArrayList<Integer> a ,
        ArrayList<Integer> b ,ArrayList<Integer> d) { 
         // code here
        this.n = n;
        this.p = p;
        rd = new int[n + 1];
        wt = new int[n + 1];
        cd = new int[n + 1];
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        
        int i = 0;
       
    	while (i < p) {
    		int q = a.get(i), h = b.get(i), t = d.get(i);
    		cd[q] = h;
    		wt[q] = t;
    		rd[h] = q;
    		i++;
    	}
    	
    	for (int j = 1; j <= n; ++j)
    
    		/*If a pipe has no ending vertex
    		but has starting vertex i.e is
    		an outgoing pipe then we need
    		to start DFS with this vertex.*/
    		if (rd[j] == 0 && cd[j] != 0) {
    			ans = 1000000000;
    			int w = dfs(j);
    
    			// We put the details of component
    			// in final output res array
    			ArrayList<Integer> li = new ArrayList<>();
    			li.add(j);
    			li.add(w);
    			li.add(ans);
    			res.add(li);
    	}
    
        return res;
    }
} 
