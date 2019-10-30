package leet_code.leet_code_0001_0050.leet_code_0045;

class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = new int[]{1, 2};
        System.out.println(solution.jump(nums));
    }

    public int jump(int[] nums) {
        if (nums.length == 1) {
            return 0;
        }

        int dp[] = new int[nums.length + 1];
        int[] len = new int[nums.length + 1];

        int step = 1;
        len[step] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            while (len[step] < i) {
                step++;
            }

            dp[i] = step;
            if (len[step + 1] < i + nums[i]) {
                len[step + 1] = i + nums[i];
            }
        }

        return dp[nums.length - 1];
    }
}
