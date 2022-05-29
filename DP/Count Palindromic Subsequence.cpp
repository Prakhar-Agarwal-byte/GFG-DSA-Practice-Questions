class Solution {
public:
    /*You are required to complete below method */
    long long int countPS(string str) {
        int n = str.size();
        int mod = 1e9+7;
        vector<vector<int>> dp(n, vector<int>(n, 0));
        for (int gap = 0; gap < n; gap++) {
            for (int i = 0, j = gap; i < n && j < n; i++, j++) {
                if (gap == 0) {
                    dp[i][j] = 1;
                } else {
                    if (str[i] == str[j]) {
                        dp[i][j] = ((dp[i+1][j] + dp[i][j-1])%mod + 1)%mod;
                    } else {
                        dp[i][j] = (mod + ((dp[i+1][j] + dp[i][j-1])%mod) - dp[i+1][j-1])%mod;
                    }
                }
            }
        }
        return dp[0][n-1];
    }
     
};
