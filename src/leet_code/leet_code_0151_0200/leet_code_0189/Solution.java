package leet_code.leet_code_0151_0200.leet_code_0189;

/**
 * 数组
 */
class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = new int[]{1, 2, 3, 4, 5, 6, 7, 8};
        solution.rotate(nums, 2);
        for (int i : nums) {
            System.out.print(i + " ");
        }
    }

    public void rotate(int[] nums, int k) {
        int len = nums.length;
        int times = 0;
        for (int i = 0; i < k; i++) {
            int index = i;
            int record = nums[i];
            int aim;
            int current;
            do {
                aim = (index + k) % len;
                current = nums[aim];
                nums[aim] = record;
                index = aim;
                record = current;
                times++;
            } while (index != i);
            if (times == len) {
                break;
            }
        }
    }
}