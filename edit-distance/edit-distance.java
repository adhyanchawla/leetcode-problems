class Solution {
    public int minDistance(String word1, String word2) {
        int n = word1.length(), m = word2.length();
        int[][] dp = new int[n + 1][m + 1];
        
        for(int[] d : dp) {
            Arrays.fill(d, -1);
        }
        
        return editDistance(word1, word2, n, m, dp);
    }
    
    public int editDistance(String s1, String s2, int n, int m, int[][] dp) {
        if(n == 0 || m == 0) {
            return dp[n][m] = (n == 0) ? m : n;
        }
        
        if(dp[n][m] != -1) {
            return dp[n][m];
        }
        
        if(s1.charAt(n - 1) == s2.charAt(m - 1)) return dp[n][m] = editDistance(s1, s2, n - 1, m - 1, dp); 
        else {
            return dp[n][m] = 1 + Math.min(editDistance(s1, s2, n, m - 1, dp), Math.min(editDistance(s1, s2, n - 1, m - 1, dp), editDistance(s1, s2, n - 1, m, dp)));
        }
    }
}