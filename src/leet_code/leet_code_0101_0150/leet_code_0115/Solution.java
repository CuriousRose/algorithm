package leet_code.leet_code_0101_0150.leet_code_0115;

class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = "rabbbit";
        String t = "rabbit";
        System.out.println(solution.numDistinct(s, t));

    }

    public int numDistinct(String s, String t) {
        int[][] dp = new int[s.length() + 1][t.length() + 1];
        for (int i = 0; i <= s.length(); i++) {
            for (int j = 0; j <= t.length(); j++) {
                if (j == 0) {
                    dp[i][j] = 1;
                    continue;
                }
                if (i == 0) {
                    continue;
                }
                dp[i][j] = dp[i - 1][j];
                if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    dp[i][j] += dp[i - 1][j - 1];
                }
            }
        }
        return dp[s.length()][t.length()];
    }
}