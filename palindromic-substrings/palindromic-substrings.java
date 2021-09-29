class Solution {
    public int countSubstrings(String s) {
        int n = s.length();
        int[][] dp = new int[n][n];
        return lps(s, 0, n - 1, dp);
    }
    
    public int lps(String s, int I, int J, int[][] dp) {
        int n = s.length();
        for(int gap = 0; gap < n; gap++) {
            for(int i = 0, j = gap; i < n && j < n; i++, j++) {
                if(i == j) {
                    dp[i][j] = 1;
                    continue;
                }
                
                if(gap == 1) {
                    if(s.charAt(i) == s.charAt(j)) {
                        dp[i][j] = 2;
                        continue;
                    }
                }
                
                if(s.charAt(i) == s.charAt(j)) {
                    if(dp[i + 1][j - 1] != 0)
                        dp[i][j] = dp[i + 1][j - 1] + 2;
                    else continue;
                }
            }
        }
        
        
        int max = 0;
        
        int mi = 0, mj = 0;
        
        for(int i = 0; i < dp.length; i++) {
            for(int j = 0; j < dp.length; j++) {
                if(dp[i][j] != 0) {
                    max++;
                }
            }
            
        }
        

        
        return max;
    }
}