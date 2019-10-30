package leet_code.leet_code_0251_0300.leet_code_0283;

/**
 * @author chj
 * @date 2019/8/15 10:58
 * 模拟
 * 11:00
 */
class Solution {
    public void moveZeroes(int[] nums) {
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[index++] = nums[i];
            }
        }
        while (index < nums.length) {
            nums[index++] = 0;
        }
    }
}