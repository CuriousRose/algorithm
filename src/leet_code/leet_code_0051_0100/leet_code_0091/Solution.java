package leet_code.leet_code_0051_0100.leet_code_0091;

class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = "01";
        System.out.println(solution.numDecodings(s));
    }

    public int numDecodings(String s) {
        if (s.length() == 0) {
            return 0;
        }
        int[] ns = new int[s.length()];
        for (int i = 0; i < s.length(); i++) {
            ns[i] = s.charAt(i) - '0';
        }
        int[] dp = new int[s.length()];
        if (ns[0] != 0) {
            dp[0] = 1;
        }
        if (s.length() == 1) {
            return dp[0];
        }
        if (ns[1] != 0) {
            dp[1] = dp[0];
        }
        if (isMatch(ns[0], ns[1])) {
            dp[1]++;
        }
        for (int i = 2; i < s.length(); i++) {
            if (ns[i] != 0) {
                dp[i] += dp[i - 1];
            }
            if (isMatch(ns[i - 1], ns[i])) {
                dp[i] += dp[i - 2];
            }
        }
        return dp[s.length() - 1];
    }

    boolean isMatch(int a, int b) {
        if (a == 0) {
            return false;
        }
        int k = a * 10 + b;
        if (k >= 1 && k <= 26) {
            return true;
        }
        return false;
    }
}