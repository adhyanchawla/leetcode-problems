class Solution {
    public int numDistinct(String s, String t) {
        int n = s.length(), m = t.length();
        int[][] dp = new int[n + 1][m + 1];
        
        for(int[] d : dp) {
            Arrays.fill(d, -1);
        }
        
        return distinct(s, t, n, m, dp);
    }
    
    public int distinct(String s1, String s2, int n, int m, int[][] dp) {
        if(n == 0 || m == 0) {
            return dp[n][m] = (m == 0) ? 1 : 0;
        }
        
        
        if(dp[n][m] != -1) {
            return dp[n][m];
        }
        
        if(s1.charAt(n - 1) == s2.charAt(m - 1)) {
            return dp[n][m] = distinct(s1, s2, n - 1, m - 1, dp) + distinct(s1, s2, n - 1, m, dp);
        } else {
            return dp[n][m] = distinct(s1, s2, n - 1, m, dp);
        }
    }
}