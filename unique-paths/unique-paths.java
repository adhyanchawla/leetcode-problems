class Solution {
    public int uniquePaths(int m, int n) {
        int[][] dir = {{0, 1}, {1, 0}};
        int[][]dp = new int[m][n];
        //System.out.println(mazePathOneJump_memo(dir, dp, 0, 0, 2, 2));
        return mazePathWithOneJump_tab(dir, dp, 0, 0, m - 1, n - 1);
        //display2D(dp);
    }
    
    public static int mazePathWithOneJump_tab(int[][] dir, int [][] dp, int sr, int sc, int er, int ec) {

        for(int i = er; i >= sr; i--) {
            for(int j = ec; j >= sc; j--) {
                if(i == er && j == ec) {
                    dp[i][j] = 1;
                    continue;
                }

                int count = 0;

                for(int d = 0; d < dir.length; d++) {
                    int r = i + dir[d][0];
                    int c = j + dir[d][1];

                    if(r >= 0 && c >= 0 && r <= er && c <= ec) {
                        count += dp[r][c];
                    }
                }
        
                dp[i][j] = count;
            }
            
        }

        return dp[0][0];
    }
}