package leet_code.leet_code_0101_0150.leet_code_0140;

import java.util.*;

/**
 * 搜索 深度优先
 * 超时
 */
class Solution {
    List<String> result = new ArrayList<>();
    Stack<String> stack = new Stack<>();
    Set<String> words = new HashSet<>();
    List<Integer> lens = new ArrayList<>();

    public List<String> wordBreak(String s, List<String> wordDict) {
        Set<Integer> lenMark = new HashSet<>();
        for (String str : wordDict) {
            words.add(str);
            if (lenMark.contains(str.length())) {
                continue;
            } else {
                lens.add(str.length());
                lenMark.add(str.length());
            }
        }
        dfs(s, 0);
        return result;
    }

    void dfs(String s, int index) {
        if (index == s.length()) {
            StringBuffer buffer = new StringBuffer();
            for (String str : stack) {
                buffer.append(str).append(" ");
            }
            result.add(buffer.toString().trim());
            return;
        }
        for (int len : lens) {
            if (index + len > s.length()) {
                continue;
            }
            String sub = s.substring(index, index + len);
            if (words.contains(sub)) {
                stack.push(sub);
                dfs(s, index + len);
                stack.pop();
            }
        }
    }
}
