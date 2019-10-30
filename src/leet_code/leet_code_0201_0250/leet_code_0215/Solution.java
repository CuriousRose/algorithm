package leet_code.leet_code_0201_0250.leet_code_0215;

import java.util.Arrays;

/**
 * 排序
 */
class Solution {
    public int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length - k];
    }
}