package leet_code.leet_code_0201_0250.leet_code_0213;

/**
 * 动态规划
 */
class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = new int[]{1, 1, 3, 6, 7, 10, 7, 1, 8, 5, 9, 1, 4, 4, 3};
        System.out.println(solution.rob(nums));
    }

    public int rob(int[] nums) {
        int len = nums.length;
        if (nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        int dp[][] = new int[len][4];
        dp[0][1] = nums[0];
        dp[0][3] = 1;

        for (int i = 1; i < len - 1; i++) {
            dp[i][1] = dp[i - 1][0] + nums[i];
            dp[i][3] = dp[i - 1][2];

            if (dp[i - 1][0] > dp[i - 1][1]) {
                dp[i][0] = dp[i - 1][0];
                dp[i][2] = dp[i - 1][2];
            }
            if (dp[i - 1][0] < dp[i - 1][1]) {
                dp[i][0] = dp[i - 1][1];
                dp[i][2] = dp[i - 1][3];
            }
            if (dp[i - 1][0] == dp[i - 1][1]) {
                dp[i][0] = dp[i - 1][0];
                dp[i][2] = dp[i - 1][2] & dp[i - 1][3];
            }
        }

        int x = dp[len - 2][0];
        int y = dp[len - 2][1];
        if (dp[len - 2][2] == 0) {
            x += nums[len - 1];
        }
        int max = Math.max(x, y);

        dp = new int[len][2];
        for (int i = 1; i < len; i++) {
            dp[i][1] = dp[i - 1][0] + nums[i];
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1]);
        }

        return Math.max(max, Math.max(dp[len - 1][0], dp[len - 1][1]));
    }
}