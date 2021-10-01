class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int n = text1.length(), m = text2.length();
        int[][] dp = new int[n + 1][m + 1];
        for(int[]d : dp) {
            Arrays.fill(d, -1);
        }
        return lcss(text1, text2, text1.length(), text2.length(), dp);
    }
    
    public int lcss(String s1, String s2, int n, int m, int[][] dp) {
        // if(n == 0 && m == 0) {
        //     return dp[n][m] = 1;
        // }
        if(n == 0 || m == 0) {
            return dp[n][m] = 0;
        }
        
        if(dp[n][m] != -1) {
            return dp[n][m];
        }
        
        if(s1.charAt(n - 1) == s2.charAt(m - 1)) {
            return dp[n][m] = 1 + lcss(s1, s2, n - 1, m - 1, dp);
        } else {
            return dp[n][m] = Math.max(lcss(s1, s2, n, m - 1, dp), lcss(s1, s2, n - 1, m, dp));
        }
    }
}