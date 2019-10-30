package leet_code.leet_code_0151_0200.leet_code_0154;

/**
 * 二分
 */
class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = new int[]{3, 1, 3, 3, 3};
        System.out.println(solution.findMin(nums));
    }

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
        if (nums[l] < nums[r]) {
            return nums[l];
        }
        int m = (l + r) >> 1;
        int ml = m;
        int mr = m;
        while (ml > l && nums[ml] == nums[m]) {
            ml--;
        }
        while (mr < r && nums[mr] == nums[m]) {
            mr++;
        }
        if (nums[mr] < nums[m]) {
            return nums[mr];
        }
        if (nums[ml] > nums[m]) {
            return nums[m];
        }
        if (nums[l] <= nums[ml]) {
            return min(nums, mr, r);
        } else {
            return min(nums, l, ml);
        }
    }
}