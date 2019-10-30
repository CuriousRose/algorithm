package leet_code.leet_code_0251_0300.leet_code_0268;

/**
 * @author chj
 * @date 2019/8/8 10:51
 * 数学
 * 10:59
 */
class Solution {
    public int missingNumber(int[] nums) {
        int n = nums.length;
        long sum = n * (n + 1) / 2;
        for (int i : nums) {
            sum -= i;
        }
        return (int) sum;
    }
}