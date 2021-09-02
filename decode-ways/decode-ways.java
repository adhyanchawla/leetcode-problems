class Solution {
    public int numDecodings(String s) {
        int[] dp = new int[s.length() + 1];
        return countDecodings(s, dp, 0);   
    }
    
    public int countDecodings(String ques, int[] dp, int idx) {
        if(ques.length() == 0){
            return dp[idx] = 1;
        }
        
        if(dp[idx] != 0) return dp[idx];
        
        int count = 0;
        
        char ch = ques.charAt(0);
        int num = (int)(ch - '0');
        
        if(num != 0) {
            count += countDecodings(ques.substring(1), dp, idx + 1);
        }
        
        if(ques.length() > 1) {
            int num1 = (ch - '0') * 10 + (ques.charAt(1) - '0');
            
            if(num1 >= 10 && num1 <= 26) {
                count += countDecodings(ques.substring(2), dp, idx + 2);
            }
        }
        
        return dp[idx] = count;
    }
}