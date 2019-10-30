package leet_code.leet_code_0151_0200.leet_code_0153;

/**
 * 二分
 */
class Solution {
    public int findMin(int[] nums) {
        return min(nums, 0, nums.length - 1);
    }

    int min(int[] nums, int l, int r) {
        if (l == r) {
            return nums[l];
        }
        if (r - l == 1) {
            return Math.min(nums[l], nums[r]);
        }
        if (nums[l] <= nums[r]) {
            return nums[l];
        }
        int m = (l + r) >> 1;
        if (nums[l] < nums[m]) {
            return min(nums, m + 1, r);
        } else {
            return min(nums, l, m);
        }
    }
}
