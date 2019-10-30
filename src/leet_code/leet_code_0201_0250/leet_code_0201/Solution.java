package leet_code.leet_code_0201_0250.leet_code_0201;

/**
 * 进制
 */
class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.rangeBitwiseAnd(0, 2147483647));
    }

    public int rangeBitwiseAnd(int m, int n) {
        char[] cs = Integer.toBinaryString(m & n).toCharArray();
        int len = cs.length;
        int diff = n - m;
        int p = 1;
        int b = 1;
        while (p <= len && diff >= b) {
            cs[len - p] = '0';
            p++;
            b <<= 1;
        }
        int sum = 0;
        b = 1;
        for (int i = len - 1; i >= 0; i--) {
            if (cs[i] == '1') {
                sum += b;
            }
            b <<= 1;
        }
        return sum;
    }
}