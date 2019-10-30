package leet_code.leet_code_0101_0150.leet_code_0123;

class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] prices = new int[]{6, 1, 3, 2, 4, 7};
        System.out.println(solution.maxProfit(prices));
    }

    public int maxProfit(int[] prices) {
        int len = prices.length;
        if (len == 0) {
            return 0;
        }
        int[][][] dp = new int[len][3][2];
        for (int i = 0; i < 3; i++) {
            dp[0][i][0] = 0;
            dp[0][i][1] = -prices[0];
        }
        for (int i = 1; i < len; i++) {
            for (int j = 0; j < 3; j++) {
                if (j == 0) {
                    dp[i][j][0] = dp[i - 1][j][0];
                } else {
                    dp[i][j][0] = Math.max(dp[i - 1][j][0], dp[i - 1][j - 1][1] + prices[i]);
                }
                dp[i][j][1] = Math.max(dp[i - 1][j][1], dp[i - 1][j][0] - prices[i]);
            }
        }

        return Math.max(Math.max(dp[len - 1][0][0], dp[len - 1][1][0]), dp[len - 1][2][0]);
    }

}