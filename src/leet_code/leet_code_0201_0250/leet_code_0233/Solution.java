package leet_code.leet_code_0201_0250.leet_code_0233;

/**
 * @author chj
 * @date 2019/7/1 10:49
 * 打表 数学
 * 11:34
 */
class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.countDigitOne(12312312));
    }

    public int countDigitOne(int n) {
        if (n < 0) {
            return 0;
        }
        int[][] table = new int[11][11];
        table[0][1] = 1;
        table[0][10] = 1;
        for (int i = 1; i < 10; i++) {
            for (int j = 0; j <= 9; j++) {
                table[i][j] += table[i - 1][10];
                if (j == 1) {
                    table[i][j] += Math.pow(10, i);
                }
                table[i][10] += table[i][j];
            }
        }
        int count = 0;
        String s = String.valueOf(n);
        int len = s.length();
        for (int i = 0; i < len; i++) {
            int m = Integer.parseInt(s.substring(i, i + 1));
            for (int j = 0; j < m; j++) {
                count += table[len - 1 - i][j];
            }
            if (m == 1) {
                if (i != len - 1) {
                    count += Integer.parseInt(s.substring(i + 1));
                }
                count += 1;
            }
        }
        return count;
    }
}
