class Solution {
    public String longestPalindrome(String s) {
        int n = s.length();
        int[][] dp = new int[s.length()][s.length()];
        
        String ans = "";
        int si = 0;
        int ei = 0;
        for(int gap = 0; gap < n; gap++) {
            for(int i = 0, j = gap; i < n && j < n; i++, j++) {
                if(gap == 0) {
                    dp[i][j] = 1;
                    continue;
                } 
                
                if(gap == 1) {
                    if(s.charAt(i) == s.charAt(j)) {
                        dp[i][j] = 2;
                    }
                } 
                
                if(s.charAt(i) == s.charAt(j) && dp[i + 1][j - 1] != 0) {
                    dp[i][j] = 2 + dp[i + 1][j - 1];
                }
                
                if(dp[i][j] > 0 && dp[i][j] > ans.length()) {
                    si = i;
                    ei = j;
                }
            }
        }
        
        return s.substring(si, ei + 1);
    }
}