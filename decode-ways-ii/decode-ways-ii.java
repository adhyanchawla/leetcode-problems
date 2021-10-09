class Solution {
    public int numDecodings(String s) {
        long[] dp = new long[s.length() + 1];
        Arrays.fill(dp, -1);
        return (int)decodeWays(s, 0, dp);
    }
    
    static int mod = (int)(1e9 + 7);
    
    public long decodeWays(String s, int idx, long[] dp) {
        if(idx == s.length()) {
            return dp[idx] = 1;
        }
        
        if(dp[idx] != -1) {
            return dp[idx];
        }
        
        if(s.charAt(idx) == '0') {
            return dp[idx] = 0;
        }
        
        long count = 0;
        
        char ch = s.charAt(idx);
        if(ch == '*') {
            count = (count + 9 * decodeWays(s, idx + 1, dp)) % mod;
        } else {
            count = (count + decodeWays(s, idx + 1, dp)) % mod;
        }
        
        if(idx < s.length() - 1) {
            char ch1 = s.charAt(idx + 1);
            if(ch == '*' && ch1 == '*') {
                count = (count + 15 * decodeWays(s, idx + 2, dp)) % mod;
            } else if(ch != '*' && ch1 == '*') {
                if(ch == '1') {
                    count = (count + 9 * decodeWays(s, idx + 2, dp)) % mod;
                } else if(ch == '2') {
                    count = (count + 6 * decodeWays(s, idx + 2, dp)) % mod;
                }
            } else if(ch == '*' && ch1 != '*') {
                if(ch1 >= '0' && ch1 <= '6') {
                    count = (count + 2 * decodeWays(s, idx + 2, dp)) % mod;
                } else if(ch1 > '6') {
                    count = (count + decodeWays(s, idx + 2, dp)) % mod;
                }
            } else {
                int num = (ch -'0') * 10 + (ch1 - '0');
                if(num >= 10 && num <= 26)
                count = (count + decodeWays(s, idx + 2, dp)) % mod;
            }
        }
        
        return dp[idx] = count;
    }
    
    
}