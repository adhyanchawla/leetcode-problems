class Solution {
    public int uniquePaths(int m, int n) {
        int[][] dir = {{0, 1}, {1, 0}};
        return mazePathsWithOneJump_tab(0, 0, m - 1, n - 1, new int[m][n], dir);
    }
    
    public static int mazePathsWithOneJump_tab(int SR, int SC, int ER, int EC, int[][] dp, int[][] dir) {
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
                    if(r >= 0 && c >= 0 && r < dp.length && c < dp[0].length) {
                        count += dp[r][c];
                    }
    
                }
    
                dp[sr][sc] = count;
            }

        }

        return dp[SR][SC];
    }
}