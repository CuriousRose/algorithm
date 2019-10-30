package leet_code.leet_code_0101_0150.leet_code_0136;


class Solution {
    public int singleNumber(int[] nums) {
        int sum = 0;
        for (int i : nums) {
            sum ^= i;
        }
        return sum;
    }
}