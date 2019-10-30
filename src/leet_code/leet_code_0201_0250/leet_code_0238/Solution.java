package leet_code.leet_code_0201_0250.leet_code_0238;

/**
 * @author chj
 * @date 2019/7/4 10:24
 * 模拟
 * 10:34
 */
class Solution {
    public int[] productExceptSelf(int[] nums) {
        if (nums.length <= 1) {
            return nums;
        }
        long sum = 1;
        int zero = 0;
        for (int i : nums) {
            if (i == 0) {
                zero++;
            } else {
                sum *= i;
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (zero > 1) {
                nums[i] = 0;
            } else {
                if (nums[i] == 0) {
                    nums[i] = (int) sum;
                } else {
                    if (zero > 0) {
                        nums[i] = 0;
                    } else {
                        nums[i] = (int) (sum / nums[i]);
                    }
                }
            }
        }
        return nums;
    }
}