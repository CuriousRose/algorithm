package leet_code.leet_code_0151_0200.leet_code_0171;

/**
 * 模拟
 */
class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.titleToNumber("AAA"));
    }

    public int titleToNumber(String s) {
        int sum = 0;
        int k = 1;
        for (int i = 1; i < s.length(); i++) {
            k *= 26;
        }
        for (char c : s.toCharArray()) {
            int i = c - 'A' + 1;
            sum += i * k;
            k /= 26;
        }
        return sum;
    }
}