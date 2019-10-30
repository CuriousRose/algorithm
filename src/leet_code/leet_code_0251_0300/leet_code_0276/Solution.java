package leet_code.leet_code_0251_0300.leet_code_0276;

/**
 * @author chj
 * @date 2019/8/13 10:38
 * 动态规划
 * 10:43
 */
class Solution {
    public int numWays(int n, int k) {
        if (n == 0) {
            return 0;
        }
        int[][] dp = new int[n][2];
        dp[0][1] = k;
        for (int i = 1; i < n; i++) {
            dp[i][0] = dp[i - 1][1];
            dp[i][1] = dp[i - 1][0] * (k - 1) + dp[i - 1][1] * (k - 1);
        }
        return dp[n - 1][0] + dp[n - 1][1];
    }
}