class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int[]dp = new int[cost.length + 1];
        Arrays.fill(dp, -1);
        return minCost(cost, dp, cost.length);
    }
    
    public int minCost(int[] cost, int[] dp, int idx) {
        if(idx <= 1) {
            return dp[idx] = cost[idx];
        }
        
        if(dp[idx] != -1) {
            return dp[idx];
        }
        
        int min = 0;
        int jump1 = minCost(cost, dp, idx - 1);
        int jump2 = minCost(cost, dp, idx - 2);
        
        min = Math.min(jump1, jump2) + (idx != cost.length ? cost[idx] : 0);
        
        return dp[idx] = min;
    }
}