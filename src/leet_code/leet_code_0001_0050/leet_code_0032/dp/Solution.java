package leet_code.leet_code_0001_0050.leet_code_0032.dp;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.longestValidParentheses(")(((((()())()()))()(()))("));
    }

    public int longestValidParentheses(String s) {
        char[] cs = s.toCharArray();
        int max = 0;

        int[] dp = new int[cs.length];

        for (int i = 0; i < s.length(); i++) {
            if (cs[i] == '(') {
                dp[i] = 0;
            } else {
                if (i > 0) {
                    if (cs[i - 1] == '(') {
                        dp[i] = 2;
                        if (i > 1) {
                            dp[i] += dp[i - 2];
                        }
                    } else {
                        if (i - dp[i - 1] > 0) {
                            if (cs[i - dp[i - 1] - 1] == '(') {
                                dp[i] = dp[i - 1] + 2;
                                if (i - dp[i - 1] - 1 > 0) {
                                    dp[i] += dp[i - dp[i - 1] - 2];
                                }
                            }
                        }
                    }

                }
            }
            max = max > dp[i] ? max : dp[i];
        }

        return max;
    }

}
