class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] dir = {{0, 1}, {1, 0}};
        if(obstacleGrid[0][0] == 1 || obstacleGrid[m - 1][n - 1] == 1) return 0;
        
        return mazePathsWithOneJump_tab(obstacleGrid, 0, 0, m - 1, n - 1, new int[m][n], dir);
    }
    
    public static int mazePathsWithOneJump_tab(int[][] obstacleGrid, int SR, int SC, int ER, int EC, int[][] dp, int[][] dir) {
        for(int sr = ER; sr >= SR; sr--) {
            for(int sc = EC; sc >= SC; sc--) {
                if(sr == ER && sc == EC) {
                    dp[sr][sc] = 1;
                    continue;
                }

                int count = 0;
                for(int d = 0; d < dir.length; d++) {
                    int r = sr + dir[d][0];
                    int c = sc + dir[d][1];
                    if(r >= 0 && c >= 0 && r < dp.length && c < dp[0].length && obstacleGrid[r][c] == 0) {
                        count += dp[r][c];
                    }
    
                }
    
                dp[sr][sc] = count;
            }

        }

        return dp[SR][SC];
    }
}