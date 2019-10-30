package leet_code.leet_code_0001_0050.leet_code_0016;

import java.util.Arrays;

class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = new int[]{-1, 2, 1, -4};
        int target = 1;
        System.out.println(solution.threeSumClosest(nums, target));
    }

    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int len = nums.length;
        int result = nums[0] + nums[1] + nums[len - 1];
        for (int i = 0; i < len - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int l = i + 1;
            int r = len - 1;
            while (l < r) {
                int current = nums[i] + nums[l] + nums[r];
                if (current == target) {
                    return target;
                }
                if (Math.abs(current - target) < Math.abs(result - target)) {
                    result = current;
                }
                if (current < target) {
                    l++;
                } else {
                    r--;
                }
            }
        }
        return result;
    }
}
