package leet_code.leet_code_0101_0150.leet_code_0139;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 动态规划 背包
 */
class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = "leetcode";
        String[] wordDict = new String[]{"leet", "code"};
        System.out.println(solution.wordBreak(s, Arrays.asList(wordDict)));
    }

    public boolean wordBreak(String s, List<String> wordDict) {
        int len = s.length();
        boolean[] dp = new boolean[len + 1];

        dp[0] = true;
        Set<String> words = new HashSet<>();

        int minLen = Integer.MAX_VALUE;
        int maxLen = Integer.MIN_VALUE;
        for (String str : wordDict) {
            words.add(str);
            minLen = Math.min(minLen, str.length());
            maxLen = Math.max(maxLen, str.length());
        }

        for (int i = 1; i <= len; i++) {
            for (int j = i - minLen; j >= j - maxLen; j--) {
                if (j < 0) {
                    break;
                }
                String word = s.substring(j, i);
                if (!words.contains(word)) {
                    continue;
                }
                if (dp[j]) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[len];
    }
}