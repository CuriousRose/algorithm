package leet_code.leet_code_0251_0300.leet_code_0258;

/**
 * @author chj
 * @date 2019/8/6 11:47
 * 模拟
 * 11:48
 */
class Solution {
    public int addDigits(int num) {
        while (num >= 10) {
            String str = String.valueOf(num);
            num = 0;
            for (char c : str.toCharArray()) {
                num += c - '0';
            }
        }
        return num;
    }
}