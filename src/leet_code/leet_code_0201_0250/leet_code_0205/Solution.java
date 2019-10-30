package leet_code.leet_code_0201_0250.leet_code_0205;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 模拟
 */
class Solution {
    public boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        Map<Character, Character> map = new HashMap<>();
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            char cs = s.charAt(i);
            char ct = t.charAt(i);
            if (map.containsKey(cs)) {
                if (map.get(cs) != ct) {
                    return false;
                }
            } else {
                if (set.contains(ct)) {
                    return false;
                } else {
                    set.add(ct);
                    map.put(cs, ct);
                }
            }
        }
        return true;
    }
}
