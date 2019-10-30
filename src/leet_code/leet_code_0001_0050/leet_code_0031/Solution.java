package leet_code.leet_code_0001_0050.leet_code_0031;

class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = new int[]{5, 1, 1};
        solution.nextPermutation(nums);
        for (int i : nums) {
            System.out.print(i + " ");
        }
    }

    public void nextPermutation(int[] nums) {
        if (nums.length == 0 || nums.length == 1) {
            return;
        }
        int left = nums.length - 2;
        while (left >= 0) {
            if (nums[left] >= nums[left + 1]) {
                left--;
            } else {
                break;
            }
        }

        if (left < 0) {
            filp(nums, 0, nums.length - 1);
            return;
        }

        int right = left + 1;
        while (right < nums.length) {
            if (nums[left] < nums[right]) {
                right++;
            } else {
                break;
            }
        }
        right--;

        int c = nums[left];
        nums[left] = nums[right];
        nums[right] = c;

        filp(nums, left + 1, nums.length - 1);
    }

    void filp(int[] nums, int l, int r) {
        for (int i = 0; i <= (r - l) / 2; i++) {
            int c = nums[l + i];
            nums[l + i] = nums[r - i];
            nums[r - i] = c;
        }
    }
}