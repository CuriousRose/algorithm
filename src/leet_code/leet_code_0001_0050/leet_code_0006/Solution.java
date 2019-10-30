package leet_code.leet_code_0001_0050.leet_code_0006;

class Solution {
    public static void main(String[] args) {
        String s = "A";
        int numRows = 1;
        Solution solution = new Solution();
        System.out.println(solution.convert(s, numRows));
    }

    public String convert(String s, int numRows) {
        char[] cs = s.toCharArray();
        char[] rs = new char[cs.length];

        if (numRows == 1) {
            return s;
        }

        int index = 0;
        int c = numRows * 2 - 2;
        int l = s.length();
        for (int i = 0; i < l; i += c) {
            rs[index++] = cs[i];
        }

        for (int k = 1; k < numRows - 1; k++) {
            for (int i = k, j = c - k; i < l; i += c, j += c) {
                rs[index++] = cs[i];
                if (j < l) {
                    rs[index++] = cs[j];
                }
            }
        }

        for (int i = numRows - 1; i < l; i += c) {
            rs[index++] = cs[i];
        }

        return String.valueOf(rs);
    }
}