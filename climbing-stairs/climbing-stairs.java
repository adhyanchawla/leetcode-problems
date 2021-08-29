class Solution {
    public int climbStairs(int N) {
        int a = 1, b = 1;
        for(int n = 2; n <= N; n++) {
            int sum = a + b;
            a = b;
            b = sum;
        }

        return b;
    }
}