package leet_code.leet_code_0051_0100.leet_code_0081;

class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = new int[]{2, 5, 6, 0, 0, 1, 2};
        int target = 0;
        System.out.println(solution.search(nums, target));
    }

    public boolean search(int[] nums, int target) {
        if (nums.length == 0) {
            return false;
        }
        return find(nums, 0, nums.length - 1, target);
    }

    boolean find(int[] nums, int l, int r, int target) {
        if (l == r) {
            if (nums[l] == target) {
                return true;
            } else {
                return false;
            }
        }
        int ml = (l + r) / 2;
        int mr = ml + 1;
        while (ml > l && nums[ml] == nums[l]) {
            ml--;
        }
        while (mr < r && nums[mr] == nums[r]) {
            mr++;
        }
        if (nums[ml] == target) {
            return true;
        }
        if (nums[mr] == target) {
            return true;
        }
        if (target < nums[ml]) {
            if (nums[l] > nums[ml] || target >= nums[l]) {
                return find(nums, l, ml, target);
            } else {
                return find(nums, mr, r, target);
            }
        } else {
            if (nums[mr] > nums[r] || target <= nums[r]) {
                return find(nums, mr, r, target);
            } else {
                return find(nums, l, ml, target);
            }
        }
    }
}
