class Solution {
    public int numDecodings(String s) {
        int[]dp = new int[s.length() + 1];
        Arrays.fill(dp , -1);
        return decodeWays(s, 0, dp);
    }
    
    
    public int decodeWays(String s, int idx, int[] dp) {
        if(idx >= s.length()) {
            return dp[idx] = 1;
        }
        
        if(dp[idx] != -1) {
            return dp[idx];
        }
        
        int count = 0;
        
        char ch = s.charAt(idx);
        if(ch - '0' != 0) {
            count += decodeWays(s, idx + 1, dp);
        }
        
        if(idx < s.length() - 1) {
            int num = (ch - '0') * 10 + (s.charAt(idx + 1) - '0');
            if(num >= 10 && num <= 26) {
                count += decodeWays(s, idx + 2, dp);
            }
        }
        
        return dp[idx] = count;
    }
}