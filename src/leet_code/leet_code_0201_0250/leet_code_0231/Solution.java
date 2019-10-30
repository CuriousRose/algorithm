package leet_code.leet_code_0201_0250.leet_code_0231;

/**
 * @author chj
 * @date 2019/7/1 10:40
 * 模拟
 * 10:43
 */
class Solution {
    public boolean isPowerOfTwo(int n) {
        if (n <= 0) {
            return false;
        }
        while (n > 1) {
            if (n % 2 != 0) {
                return false;
            }
            n /= 2;
        }
        return true;
    }
}