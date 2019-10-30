package leet_code.leet_code_0051_0100.leet_code_0066;

class Solution {
    public int[] plusOne(int[] digits) {
        digits[digits.length - 1]++;
        for (int i = digits.length - 1; i > 0; i--) {
            if (digits[i] >= 10) {
                digits[i - 1] += digits[i] / 10;
                digits[i] %= 10;
            }
        }
        if (digits[0] >= 10) {
            int[] result = new int[digits.length + 1];
            result[0] = digits[0] / 10;
            digits[0] %= 10;
            for (int i = 1; i < result.length; i++) {
                result[i] = digits[i - 1];
            }
            return result;
        } else {
            return digits;
        }
    }
}