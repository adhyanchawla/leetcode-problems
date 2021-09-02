class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int a = cost[0], b = cost[1];
        for(int i = 2; i <= cost.length; i++) {
            int min = Math.min(a, b) + (i != cost.length ? cost[i] : 0);
            a = b;
            b = min;
        }
        return b;
    }
    
    
    
    public int minCost_tab(int[] cost, int SR, int ER, int[] dp) {
    
        
        for(int er = SR; er <= ER; er++) {
            if(er <= 1) {
                dp[er] = cost[er];
                continue;
            }
            
            int minPath1 = dp[er - 1];
            int minPath2 = dp[er - 2];
            
            int minPath = Math.min(minPath1, minPath2) + (er != cost.length ? cost[er] : 0);
            
            dp[er] = minPath;
        }
        
        return dp[ER];
    }
    
//     public int minCost(int[] cost, int[] dp, int idx) {
//         if(idx <= 1) return dp[idx] = cost[idx];
        
//         if(dp[idx] != 0) return dp[idx];
        
        
//         int oneStep = minCost(cost, dp, idx - 1);
//         int twoStep = minCost(cost, dp, idx - 2);
        
//         int minPath = Math.min(oneStep, twoStep) + ((idx != cost.length) ? cost[idx] : 0);
        
//         return dp[idx] = minPath;
//     }
}