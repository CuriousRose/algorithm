package leet_code.leet_code_0251_0300.leet_code_0300;

/**
 * @author chj
 * @date 2019/8/20 10:16
 * 动态规划
 * 10:24
 */
class Solution {
    int max = 0;

    public int lengthOfLIS(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int[] dp = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            dp[i] = 1;
            for (int j = i - 1; j >= 0; j--) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            max = Math.max(max, dp[i]);
        }
        return max;
    }
}