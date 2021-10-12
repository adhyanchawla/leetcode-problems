class Solution {
    public String removeStar(String str) {
        if(str.length() == 0) {
            return "";
        }
        
        StringBuilder sb = new StringBuilder();
        sb.append(str.charAt(0));
        
        int i = 1;
        while(i < str.length()) {
            while(i < str.length() && sb.charAt(sb.length() - 1) == '*' && str.charAt(i) == '*') {
                i++;
            }
            
            if(i < str.length()) {
                sb.append(str.charAt(i));
            }
            i++;
        }
        
        return sb.toString();
    }
    
    public boolean isMatch(String s, String p) {
        p = removeStar(p);
        int[][] dp = new int[s.length() + 1][p.length() + 1];
        
        for(int[] d : dp) {
            Arrays.fill(d, -1);
        }
        
        int n = s.length(), m = p.length();
        
        return check(s, p, n, m, dp) == 1;
    }
    
    public int check(String s, String p, int n, int m, int[][] dp) {
        if(m == 0 || n == 0) {
            if(m == 0 && n == 0)  return dp[n][m] = 1;
            else if(m == 1 && p.charAt(m - 1) == '*') return dp[n][m] = 1;
            else return dp[n][m] = 0;
        }
        
        if(dp[n][m] != -1) {
            return dp[n][m];
        }
        
        char ch1 = s.charAt(n -1);
        char ch2 = p.charAt(m - 1);
        
        if(ch1 == ch2 || ch2 == '?') {
            return dp[n][m] = check(s, p, n - 1, m - 1, dp);
        } else if(ch2 == '*') {
            boolean res = false;
            res = res || check(s, p, n - 1, m, dp) == 1; //star matched with current character
            res = res || check(s, p, n, m - 1, dp) == 1; //star matched with empty string
            return dp[n][m] = (res == true) ? 1 : 0;
        } else {
            return dp[n][m] = 0;
        }
    }
}