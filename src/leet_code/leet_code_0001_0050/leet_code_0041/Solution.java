package leet_code.leet_code_0001_0050.leet_code_0041;

class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = new int[]{1, 1};
        System.out.println(solution.firstMissingPositive(nums));
    }

    public int firstMissingPositive(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] <= 0 || nums[i] == i + 1) {
                continue;
            }
            while (nums[i] > 0 && nums[i] <= nums.length && nums[i] != i + 1) {
                int c = nums[i];
                nums[i] = nums[nums[i] - 1];
                nums[c - 1] = c;
                if (nums[i] == c) {
                    break;
                }
            }
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }

        return nums.length + 1;
    }
}