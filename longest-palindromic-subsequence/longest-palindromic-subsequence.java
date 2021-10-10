class Solution {
    public int longestPalindromeSubseq(String s) {
        int n = s.length();
        int[][] dp = new int[n][n];
        
        return lpss_tab(s, 0, n - 1, dp);
    }
    
    public int lpss_tab(String str, int I, int J, int[][] dp) {
        int n = str.length();
        for(int gap = 0; gap < n; gap++) {
            for(int i = 0, j = gap; i < n && j < n; i++, j++) {
                if(i >= j) {
                    dp[i][j] = (i == j) ? 1 : 0; 
                    continue;
                }
        
                if(str.charAt(i) == str.charAt(j)) {
                    dp[i][j] = dp[i + 1][j - 1] + 2;
                } else {
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[I][J];
    }
}