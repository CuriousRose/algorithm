package leet_code.leet_code_0251_0300.leet_code_0290;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author chj
 * @date 2019/8/19 10:26
 * 模拟 哈希
 * 10:35
 */
class Solution {
    public boolean wordPattern(String pattern, String str) {
        Map<String, Character> map = new HashMap<>();
        Set<Character> set = new HashSet<>();
        String[] words = str.split(" ");
        if (words.length != pattern.length()) {
            return false;
        }
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            char mark = pattern.charAt(i);
            if (map.containsKey(word)) {
                if (map.get(word) != mark) {
                    return false;
                }
            } else {
                if (set.contains(mark)) {
                    return false;
                }
                set.add(mark);
                map.put(word, mark);
            }
        }
        return true;
    }
}