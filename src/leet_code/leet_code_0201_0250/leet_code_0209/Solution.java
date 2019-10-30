package leet_code.leet_code_0201_0250.leet_code_0209;

/**
 * 滑动窗口
 */
class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = new int[]{2, 3, 1, 2, 4, 3};
        System.out.println(solution.minSubArrayLen(7, nums));
    }

    public int minSubArrayLen(int s, int[] nums) {
        int left = 0;
        int right = 0;
        int sum = 0;
        int len = nums.length;
        int min = len + 1;
        while (left < len) {
            if (sum >= s || right == len) {
                sum -= nums[left];
                left++;
            } else {
                sum += nums[right];
                right++;
            }
            if (sum >= s) {
                min = Math.min(min, right - left);
            }
        }
        if (min == len + 1) {
            min = 0;
        }
        return min;
    }
}