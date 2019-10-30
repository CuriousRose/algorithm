package leet_code.leet_code_0051_0100.leet_code_0097;

class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
//        String s1 = "aabcc";
//        String s2 = "dbbca";
//        String s3 = "aadbbcbcac";
        String s1 = "a";
        String s2 = "b";
        String s3 = "a";
        System.out.println(solution.isInterleave(s1, s2, s3));
    }

    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1.length() + s2.length() != s3.length()) {
            return false;
        }
        boolean[][] dp = new boolean[s1.length() + 1][s2.length() + 1];
        dp[0][0] = true;
        for (int i = 0; i <= s1.length(); i++) {
            for (int j = 0; j <= s2.length(); j++) {
                if (i == 0 && j == 0) {
                    continue;
                }
                if (i > 0) {
                    if (dp[i - 1][j] && s1.charAt(i - 1) == s3.charAt(i + j - 1)) {
                        dp[i][j] = true;
                    }
                }
                if (j > 0) {
                    if (dp[i][j - 1] && s2.charAt(j - 1) == s3.charAt(i + j - 1)) {
                        dp[i][j] = true;
                    }
                }
            }
        }
        return dp[s1.length()][s2.length()];
    }
}