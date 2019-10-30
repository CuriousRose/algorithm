package leet_code.leet_code_0001_0050.leet_code_0035;

class Solution {
    public int searchInsert(int[] nums, int target) {
        return find(nums, 0, nums.length - 1, target);
    }

    int find(int[] nums, int l, int r, int target) {
        if (l > r || l == r) {
            if (nums[r] < target) {
                return r + 1;
            } else {
                return l;
            }
        }

        int m = (l + r) / 2;
        if (nums[m] == target) {
            return m;
        }

        if (nums[m] < target) {
            return find(nums, m + 1, r, target);
        } else {
            return find(nums, l, m, target);
        }
    }
}