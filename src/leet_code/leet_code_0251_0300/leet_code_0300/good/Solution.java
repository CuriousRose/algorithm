package leet_code.leet_code_0251_0300.leet_code_0300.good;

/**
 * @author chj
 * @date 2019/8/20 10:27
 * 动态规划 记忆化 二分查找
 * 10:45
 */
class Solution {
    public int lengthOfLIS(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int[] dp = new int[nums.length];
        int len = 0;
        dp[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > dp[len]) {
                dp[++len] = nums[i];
            } else {
                dp[find(dp, 0, len, nums[i])] = nums[i];
            }
        }
        return len + 1;
    }

    int find(int[] nums, int l, int r, int aim) {
        if (l == r) {
            return l;
        }
        int m = (l + r) / 2;
        if (nums[m] < aim) {
            return find(nums, m + 1, r, aim);
        } else {
            return find(nums, l, m, aim);
        }
    }
}