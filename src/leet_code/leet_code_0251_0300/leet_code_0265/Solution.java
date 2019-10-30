package leet_code.leet_code_0251_0300.leet_code_0265;

/**
 * @author chj
 * @date 2019/8/7 11:52
 * 动态规划
 */
class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] costs = new int[][]{
                {1, 5, 3}, {2, 9, 4}
        };
        System.out.println(solution.minCostII(costs));
    }

    public int minCostII(int[][] costs) {
        if (costs.length == 0) {
            return 0;
        }
        int n = costs.length;
        int k = costs[0].length;
        int[][] dp = new int[n][k];
        for (int i = 0; i < k; i++) {
            dp[0][i] = costs[0][i];
        }
        for (int i = 1; i < n; i++) {
            int k1 = 0, v1 = dp[i - 1][k1];
            for (int j = 0; j < k; j++) {
                if (v1 > dp[i - 1][j]) {
                    k1 = j;
                    v1 = dp[i - 1][j];
                }
            }
            int k2 = k1 == 0 ? 1 : 0, v2 = dp[i - 1][k2];
            for (int j = 0; j < k; j++) {
                if (j == k1) {
                    continue;
                }
                if (v2 > dp[i - 1][j]) {
                    k2 = j;
                    v2 = dp[i - 1][j];
                }
            }
            for (int j = 0; j < k; j++) {
                if (j != k1) {
                    dp[i][j] = v1 + costs[i][j];
                } else {
                    dp[i][j] = v2 + costs[i][j];
                }
            }
        }
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < k; i++) {
            min = Math.min(min, dp[n - 1][i]);
        }
        return min;
    }
}