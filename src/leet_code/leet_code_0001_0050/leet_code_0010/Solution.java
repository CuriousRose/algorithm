package leet_code.leet_code_0001_0050.leet_code_0010;

class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
//        System.out.println(solution.isMatch("mississippi", "mis*is*p*."));
//        System.out.println(solution.isMatch("mississippi", "mis*is*.p*."));
//        System.out.println(solution.isMatch("aaa", "ab*a*c*a"));
        System.out.println(solution.isMatch("aaaaa", ".*"));
    }

    public boolean isMatch(String s, String p) {
        int sl = s.length();
        int pl = p.length();

        boolean dp[][] = new boolean[pl + 1][sl + 1];
        dp[0][0] = true;
        for (int i = 1; i <= pl; i++) {
            char pc = p.charAt(i - 1);
            if (pc == '.') {
                for (int j = 1; j <= sl; j++) {
                    if (dp[i - 1][j - 1]) {
                        dp[i][j] = true;
                        continue;
                    }
                }
            } else if (pc == '*') {
                char bpc = p.charAt(i - 2);
                for (int j = 0; j <= sl; j++) {
                    if (dp[i - 2][j] || dp[i - 1][j]) {
                        dp[i][j] = true;
                        continue;
                    }

                    if (j == 0) {
                        continue;
                    }
                    char sc = s.charAt(j - 1);
                    if (dp[i][j - 1]) {
                        if (bpc == sc || bpc == '.') {
                            dp[i][j] = true;
                            continue;
                        }
                    }
                }
            } else {
                for (int j = 1; j <= sl; j++) {
                    char sc = s.charAt(j - 1);
                    if (dp[i - 1][j - 1] && pc == sc) {
                        dp[i][j] = true;
                        continue;
                    }
                }
            }
        }
        return dp[pl][sl];
    }
}