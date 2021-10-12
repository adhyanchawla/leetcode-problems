class Solution {
    public int distinctSubseqII(String s) {
        int n = s.length();
        int[] dp = new int[n + 1];
        
        int m = (int)(1e9 + 7);
        
        HashMap<Character, Integer> map = new HashMap<>();
        for(int i = 0; i <= n; i++) {
            if(i == 0) {
                dp[i] = 1;
                continue;
            }
            
            dp[i] = (2 * dp[i - 1]);
            char ch = s.charAt(i - 1);
            if(map.containsKey(ch)) {
                int j = map.get(ch);
                dp[i] = (2 * dp[i - 1] % m - dp[j - 1] % m + m) % m;
            }
            
            dp[i] %= m;
            map.put(ch, i);
        }
        
        return dp[n] - 1;
    }
}