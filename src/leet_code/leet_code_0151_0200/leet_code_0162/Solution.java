package leet_code.leet_code_0151_0200.leet_code_0162;

/**
 * 序列 选择
 */
class Solution {
    public int findPeakElement(int[] nums) {
        return find(nums, 0, nums.length - 1);
    }

    int find(int[] nums, int l, int r) {
        if (l == r) {
            return l;
        }
        if (l + 1 == r) {
            return nums[l] > nums[r] ? l : r;
        }
        int m = (l + r) >> 1;
        if (nums[m] > nums[m + 1]) {
            return find(nums, l, m);
        } else {
            return find(nums, m + 1, r);
        }
    }
}