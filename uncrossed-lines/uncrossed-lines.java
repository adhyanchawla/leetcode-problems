class Solution {
    public int maxUncrossedLines(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;
        
        int[][] dp = new int[n + 1][m + 1];
        
        for(int[] d : dp) {
            Arrays.fill(d, -1);
        }
        
        return maxLines(nums1, nums2, n, m, dp);
    }
    
    public int maxLines(int[] nums1, int[] nums2, int n, int m, int[][] dp) {
        if(n == 0 || m == 0) {
            return dp[n][m] = 0;
        }
        
        if(dp[n][m] != -1) {
            return dp[n][m];
        }
        
        if(nums1[n - 1] == nums2[m - 1]) {
            return dp[n][m] = 1 + maxLines(nums1, nums2, n - 1, m - 1, dp);
        } else {
            return dp[n][m] = Math.max(maxLines(nums1, nums2, n - 1, m, dp), maxLines(nums1, nums2, n, m - 1, dp));
        }
    }
}