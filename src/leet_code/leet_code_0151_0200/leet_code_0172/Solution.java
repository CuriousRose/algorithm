package leet_code.leet_code_0151_0200.leet_code_0172;

/**
 * 模拟 数学
 */
class Solution {
    public int trailingZeroes(int n) {
        if (n < 5) {
            return 0;
        }
        return n / 5 + trailingZeroes(n / 5);
    }
}