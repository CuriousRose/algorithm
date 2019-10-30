package leet_code.leet_code_0001_0050.leet_code_0034;

class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = new int[]{5, 7, 7, 8, 8, 10};
        for (int i : solution.searchRange(nums, 6)) {
            System.out.print(i + " ");
        }
    }

    public int[] searchRange(int[] nums, int target) {
        return find(nums, 0, nums.length - 1, target);
    }

    int[] find(int[] nums, int l, int r, int target) {
        if (l > r) {
            return new int[]{-1, -1};
        }

        if (l == r && nums[l] != target) {
            return new int[]{-1, -1};
        }

        if (nums[l] == target && nums[r] == target) {
            return new int[]{l, r};
        }

        int m = (l + r) / 2;
        if (nums[m] == target) {
            return com(find(nums, l, m, target), find(nums, m + 1, r, target));
        }

        if (nums[m] < target) {
            return find(nums, m + 1, r, target);
        } else {
            return find(nums, l, m, target);
        }
    }

    int[] com(int[] n1, int[] n2) {
        if (n1[1] == -1) {
            return n2;
        }

        if (n2[0] == -1) {
            return n1;
        }

        if (n2[0] - n1[1] == 1) {
            return new int[]{n1[0], n2[1]};
        }
        return new int[]{-1, -1};
    }
}