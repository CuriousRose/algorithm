package leet_code.leet_code_0001_0050.leet_code_0005.dp;

class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.longestPalindrome("ababa"));
    }

    public String longestPalindrome(String s) {
        char[] chars = s.toCharArray();
        int len = chars.length;
        boolean[][] mark = new boolean[len][len];

        if (len == 0) {
            return "";
        }

        int max = 0;
        int ml = 0, mr = 0;

        for (int j = 0; j < len; j++) {
            for (int i = 0; i + j < len; i++) {
                if (chars[i] != chars[i + j]) {
                    continue;
                }
                if (i + 1 <= i + j - 1) {
                    if (!mark[i + 1][i + j - 1]) {
                        continue;
                    }
                }

                mark[i][i + j] = true;
                if (j > max) {
                    ml = i;
                    mr = i + j;
                }
            }
        }

        return s.substring(ml, mr + 1);
    }
}