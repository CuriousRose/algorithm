package leet_code.leet_code_0101_0150.leet_code_0137;

class Solution {
    public int singleNumber(int[] nums) {
        int a = 0;
        int b = 0;
        for (int i : nums) {
            b = (b ^ i) & ~a;
            a = (a ^ i) & ~b;
        }
        return b;
    }
}
