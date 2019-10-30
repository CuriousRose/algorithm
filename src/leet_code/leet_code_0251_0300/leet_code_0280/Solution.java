package leet_code.leet_code_0251_0300.leet_code_0280;

import java.util.Arrays;

/**
 * @author chj
 * @date 2019/8/14 9:58
 * 模拟 排序
 * 10:14
 */
class Solution {
    public void wiggleSort(int[] nums) {
        if (nums.length <= 1) {
            return;
        }
        Arrays.sort(nums);
        int[] copy = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            copy[i] = nums[i];
        }
        int j = 0;
        for (int i = 0; i < nums.length; i += 2) {
            nums[i] = copy[j++];
        }
        for (int i = 1; i < nums.length; i += 2) {
            nums[i] = copy[j++];
        }
    }
}