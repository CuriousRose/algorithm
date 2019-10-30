package leet_code.leet_code_0001_0050.leet_code_0033;

class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = new int[]{1, 3};
        System.out.println(solution.search(nums, 3));

    }

    public int search(int[] nums, int target) {
        return find(nums, 0, nums.length - 1, target);
    }

    int find(int[] nums, int l, int r, int target) {
        if (l > r) {
            return -1;
        }

        if (l == r && nums[l] == target) {
            return l;
        }

        int m = (l + r) / 2;
        if (nums[m] == target) {
            return m;
        }

        if (nums[m] < nums[r]) {
            if (target <= nums[r] && target > nums[m]) {
                return find(nums, m + 1, r, target);
            } else {
                return find(nums, l, m, target);
            }
        } else {
            if (target <= nums[m] && target >= nums[l]) {
                return find(nums, l, m, target);
            } else {
                return find(nums, m + 1, r, target);
            }
        }
    }
}