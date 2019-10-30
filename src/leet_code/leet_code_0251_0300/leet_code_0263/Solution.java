package leet_code.leet_code_0251_0300.leet_code_0263;

/**
 * @author chj
 * @date 2019/8/7 11:16
 * 模拟
 * 11:19
 */
class Solution {
    public boolean isUgly(int num) {
        if (num == 0) {
            return false;
        }
        while (num % 2 == 0) {
            num /= 2;
        }
        while (num % 3 == 0) {
            num /= 3;
        }
        while (num % 5 == 0) {
            num /= 5;
        }
        return num == 1;
    }
}