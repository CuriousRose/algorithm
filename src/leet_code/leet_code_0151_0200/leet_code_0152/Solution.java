package leet_code.leet_code_0151_0200.leet_code_0152;

/**
 * 动态规划
 */
class Solution {
    public int maxProduct(int[] nums) {
        int[][] dp = new int[nums.length][2];
        dp[0][0] = nums[0];
        dp[0][1] = nums[0];
        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i][0] = Math.max(dp[i - 1][0] * nums[i], dp[i - 1][1] * nums[i]);
            dp[i][0] = Math.max(dp[i][0], nums[i]);
            dp[i][1] = Math.min(dp[i - 1][0] * nums[i], dp[i - 1][1] * nums[i]);
            dp[i][1] = Math.min(dp[i][1], nums[i]);
            max = Math.max(max, dp[i][0]);
        }
        return max;
    }
}