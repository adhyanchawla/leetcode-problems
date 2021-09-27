class Solution {
    public int minPathSum(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[][] dir = {{0, 1}, {1, 0}};
        int[][] dp = new int[m][n];
        
        return minPath(grid, 0, 0, m - 1, n - 1, dp, dir);
    }
    
    public int minPath(int[][] grid, int sr, int sc, int er, int ec, int[][] dp, int[][] dir) {
        int m = grid.length, n = grid[0].length;
        if(sr == er && sc == ec) {
            return dp[sr][sc] = grid[er][ec];
        }
        
        if(dp[sr][sc] != 0) {
            return dp[sr][sc];
        }
        
        int min = (int)1e9;
        
        for(int d = 0; d < dir.length; d++) {
            int r = sr + dir[d][0], c = sc + dir[d][1];
            if(r >= 0 && c >= 0 && r < m && c < n) {
                min = Math.min(min, minPath(grid, r, c, er, ec, dp, dir) + grid[sr][sc]);
            }
        }
        
        return dp[sr][sc] = min;
    }
}