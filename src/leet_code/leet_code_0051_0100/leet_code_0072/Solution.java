package leet_code.leet_code_0051_0100.leet_code_0072;

class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
//        String s1 = "horse";
//        String s2 = "ros";
        String s1 = "intention";
        String s2 = "execution";
        System.out.println(solution.minDistance(s1, s2));
    }

    public int minDistance(String word1, String word2) {
        int l1 = word1.length();
        int l2 = word2.length();
        char[] cs1 = word1.toCharArray();
        char[] cs2 = word2.toCharArray();
        int[][] dp = new int[l1 + 1][l2 + 1];
        for (int i = 1; i <= l1; i++) {
            dp[i][0] = i;
        }
        for (int j = 1; j <= l2; j++) {
            dp[0][j] = j;
        }
        for (int i = 1; i <= l1; i++) {
            for (int j = 1; j <= l2; j++) {
                dp[i][j] = Math.min(dp[i - 1][j] + 1, dp[i][j - 1] + 1);
                if (cs1[i - 1] == cs2[j - 1]) {
                    dp[i][j] = Math.min(dp[i][j], dp[i - 1][j - 1]);
                } else {
                    dp[i][j] = Math.min(dp[i][j], dp[i - 1][j - 1] + 1);
                }
            }
        }
        return dp[l1][l2];
    }
}
