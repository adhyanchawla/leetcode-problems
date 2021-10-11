class Solution {
    public int longestPalindromeSubseq(String s) {
        int[][] dp = new int[s.length()][s.length()];
        
        for(int[]d : dp) {
            Arrays.fill(d, -1);
        }
        
        return lpss(s, dp, 0, s.length() - 1);
    }
    
    public int lpss(String s, int[][] dp, int i, int j) {
        if(i >= j) {
            return dp[i][j] = (i == j) ? 1 : 0;
        }
        
        if(dp[i][j] != -1) {
            return dp[i][j];
        }
        
        if(s.charAt(i) == s.charAt(j)) {
            return dp[i][j] = 2 + lpss(s, dp, i + 1, j - 1);
        } else {
            return dp[i][j] = Math.max(lpss(s, dp, i + 1, j), lpss(s, dp, i, j - 1));
        }
        
        
    }
}