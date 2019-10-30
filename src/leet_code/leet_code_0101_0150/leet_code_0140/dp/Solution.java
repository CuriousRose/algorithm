package leet_code.leet_code_0101_0150.leet_code_0140.dp;

import java.util.*;

/**
 * 动态规划 背包 路径
 */
class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = "pineapplepenapple";
        String[] wordDict = new String[]{"apple", "pen", "applepen", "pine", "pineapple"};
        for (String str : solution.wordBreak(s, Arrays.asList(wordDict))) {
            System.out.println(str);
        }

    }

    List<String> result = new ArrayList<>();
    List<List<Integer>> record = new ArrayList<>();

    public List<String> wordBreak(String s, List<String> wordDict) {
        int len = s.length();
        boolean[] dp = new boolean[len + 1];

        Set<String> words = new HashSet<>();
        Set<Integer> wordLens = new HashSet<>();
        for (String str : wordDict) {
            words.add(str);
            wordLens.add(str.length());
        }

        dp[0] = true;
        List<Integer> init = new ArrayList<>();
        init.add(0);
        record.add(init);

        for (int i = 1; i <= len; i++) {
            List<Integer> item = new ArrayList<>();
            for (int wordLen : wordLens) {
                int j = i - wordLen;
                if (j < 0) {
                    continue;
                }
                String sub = s.substring(j, i);
                if (!words.contains(sub)) {
                    continue;
                }
                if (dp[j]) {
                    dp[i] = true;
                    item.add(j);
                }
            }
            record.add(item);
        }

        dfs(s, len);
        return result;
    }

    LinkedList<String> list = new LinkedList<>();

    void dfs(String s, int index) {
        if (index == 0) {
            StringBuffer buffer = new StringBuffer();
            for (String str : list) {
                buffer.append(str).append(" ");
            }
            result.add(buffer.toString().trim());
            return;
        }

        List<Integer> before = record.get(index);
        for (int i : before) {
            String sub = s.substring(i, index);
            list.addFirst(sub);
            dfs(s, i);
            list.removeFirst();
        }
    }
}
