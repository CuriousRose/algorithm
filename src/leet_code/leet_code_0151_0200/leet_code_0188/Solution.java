package leet_code.leet_code_0151_0200.leet_code_0188;


/**
 * 动态规划 贪心
 */
class Solution {
    public static void main(String[] args) throws Exception {
        Solution solution = new Solution();
        int[] prices = new int[]{1, 2};
        System.out.println(solution.maxProfit(1000000000, prices));
    }

    public int maxProfit(int k, int[] prices) {
        if (prices.length == 0) {
            return 0;
        }
        int len = prices.length;

        if (k >= len / 2) {
            return greedy(prices);
        }

        int[][][] dp = new int[len][k + 1][2];
        for (int i = 0; i <= k; i++) {
            dp[0][i][1] = -prices[0];
        }
        for (int i = 1; i < len; i++) {
            for (int j = 0; j <= k; j++) {
                dp[i][j][1] = Math.max(dp[i - 1][j][1], dp[i - 1][j][0] - prices[i]);
                if (j > 0) {
                    dp[i][j][0] = Math.max(dp[i - 1][j][0], dp[i][j - 1][1] + prices[i]);
                }
            }
        }

        int max = Integer.MIN_VALUE;
        for (int i = 0; i <= k; i++) {
            max = Math.max(max, dp[len - 1][i][0]);
        }
        return max;
    }

    int greedy(int[] prices) {
        int max = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1]) {
                max += prices[i] - prices[i - 1];
            }
        }
        return max;
    }
}
