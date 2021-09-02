class Solution {
    public int numDecodings(String s) {
        
        int[] dp = new int[s.length() + 1];
        return countDecodings_opti(s);   
    }
    
    public int countDecodings_opti(String s) {
        int a = 1, b = 0;
        for(int i = s.length() - 1; i >= 0; i--) {
            int sum = 0;
            char ch = s.charAt(i);
            if(ch != '0') {
                sum += a;
                
                if(i < s.length() - 1) {
                int num1 = ((ch - '0') * 10) + s.charAt(i + 1) - '0';
                if(num1 <= 26) {
                    sum += b;
                }
            }
            
            }
            b = a;
            a = sum;

        }
        
        return a;
    }
    
    public int countDecodings_tab(String ques, int[] dp, int SI) {
        
        for(int i = ques.length(); i >= 0; i--) {
            if(i == ques.length()) {
                dp[i] = 1;
                continue;
            }
            
            int count = 0;
            
            char ch = ques.charAt(i);
            if(ch != '0') {
                count += dp[i + 1];
            
            if(i < ques.length() - 1) {
                int num1 = ((ch - '0') * 10) + ques.charAt(i + 1) - '0';
                if(num1 <= 26) {
                    count += dp[i + 2];
                }
            }           
            dp[i] = count;
        }
        }
        
        return dp[SI];
    }
    
        //character ko encode kr rha hu baaki ki string encode hoke aa jayegi
    public int countDecodings(String ques, int[] dp, int idx) {
        if(idx == ques.length()){
            return dp[idx] = 1;
        }
        
        if(dp[idx] != -1) return dp[idx];
        
        int count = 0;
        
        char ch = ques.charAt(idx);
        
        if(ch == '0') {
            return dp[idx] = 0;
        }
        
        int num = (int)(ch - '0');
        
        if(num != 0) {
            count += countDecodings(ques, dp, idx + 1);
        }   
        
        
        if(idx < ques.length() - 1) {
            int num1 = (ch - '0') * 10 + (ques.charAt(idx + 1) - '0');
            
            if(num1 >= 10 && num1 <= 26) {
                count += countDecodings(ques, dp, idx + 2);
            }
        }
        
        return dp[idx] = count;
    }
}