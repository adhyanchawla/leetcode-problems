class Solution {
    public int numDistinct(String s, String t) {
        int n = s.length(), m = t.length();
        int[][] dp = new int[n + 1][m + 1];
        
        // for(int[] d : dp) {
        //     Arrays.fill(d, -1);
        // }
        
        return dis_tab(s, t, n, m, dp);
    }
    
    public static int dis_tab(String s1, String s2, int N, int M, int[][] dp) {
        for(int n = 0; n <= N; n++) {
            for(int m = 0; m <= M; m++) {
                if(m == 0 || n == 0 || m > n) {
                    dp[n][m] = (m == 0) ? 1 : 0;
                    continue;
                }

                int a = dp[n - 1][m - 1];
                int b = dp[n - 1][m];

                if(s1.charAt(n - 1) == s2.charAt(m - 1)) {
                    dp[n][m] = a + b;
                } else {
                    dp[n][m] = b;
                }
            }
        }

        return dp[N][M];
    }
    
    public int distinct(String s1, String s2, int n, int m, int[][] dp) {
        if(n == 0 || m == 0) {
            return dp[n][m] = (m == 0) ? 1 : 0;
        }
        
        if(m > n) {
            return dp[n][m] = 0;
        }
        
        
        if(dp[n][m] != -1) {
            return dp[n][m];
        }
        
        if(s1.charAt(n - 1) == s2.charAt(m - 1)) {
            return dp[n][m] = distinct(s1, s2, n - 1, m - 1, dp) + distinct(s1, s2, n - 1, m, dp);
        } else {
            return dp[n][m] = distinct(s1, s2, n - 1, m, dp);
        }
    }
}