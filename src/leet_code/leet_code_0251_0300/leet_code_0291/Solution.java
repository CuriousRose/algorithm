package leet_code.leet_code_0251_0300.leet_code_0291;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author chj
 * @date 2019/8/19 10:36
 * 搜索(深度优先)
 * 11:25
 */
class Solution {
    Map<String, Character> map = new HashMap<>();
    Set<Character> set = new HashSet<>();

    boolean success;

    public boolean wordPatternMatch(String pattern, String str) {
        dfs(pattern, str, 0, 0);
        return success;
    }

    void dfs(String pattern, String str, int index, int start) {
        if (success) {
            return;
        }
        if (index == pattern.length() && start == str.length()) {
            success = true;
            return;
        }
        if (index == pattern.length() || start == str.length()) {
            return;
        }
        for (int i = start; i < str.length(); i++) {
            String work = str.substring(start, i + 1);
            char mark = pattern.charAt(index);
            if (map.containsKey(work)) {
                if (map.get(work) != mark) {
                    continue;
                } else {
                    dfs(pattern, str, index + 1, i + 1);
                }
            } else {
                if (set.contains(mark)) {
                    continue;
                } else {
                    map.put(work, mark);
                    set.add(mark);
                    dfs(pattern, str, index + 1, i + 1);
                    map.remove(work);
                    set.remove(mark);
                }
            }
        }
    }
}