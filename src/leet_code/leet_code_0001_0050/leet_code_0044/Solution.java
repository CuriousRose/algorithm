package leet_code.leet_code_0001_0050.leet_code_0044;

class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.isMatch("a", "*a*"));
    }

    public boolean isMatch(String s, String p) {
        boolean[][] dp = new boolean[p.length() + 1][s.length() + 1];
        dp[0][0] = true;
        for (int i = 1; i <= p.length(); i++) {
            char cp = p.charAt(i - 1);
            if (cp == '*') {
                dp[i][0] = dp[i - 1][0];
            }
            for (int j = 1; j <= s.length(); j++) {
                char cs = s.charAt(j - 1);
                if (dp[i - 1][j - 1]) {
                    if (cp == cs || cp == '?' || cp == '*') {
                        dp[i][j] = true;
                        continue;
                    }
                }
                if (dp[i][j - 1] || dp[i - 1][j]) {
                    if (cp == '*') {
                        dp[i][j] = true;
                        continue;
                    }
                }
            }
        }
        return dp[p.length()][s.length()];
    }
}