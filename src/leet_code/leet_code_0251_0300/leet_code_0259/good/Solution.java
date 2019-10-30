package leet_code.leet_code_0251_0300.leet_code_0259.good;

import java.util.Arrays;

/**
 * @author chj
 * @date 2019/8/6 12:52
 * 双指针
 * 12:55
 */
public class Solution {
    public int threeSumSmaller(int[] nums, int target) {
        if (nums.length < 3) {
            return 0;
        }
        int count = 0;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            int l = i + 1;
            int r = nums.length - 1;
            while (l < r) {
                if (nums[i] + nums[l] + nums[r] < target) {
                    count += r - l;
                    l++;
                } else {
                    r--;
                }
            }
        }
        return count;
    }
}
