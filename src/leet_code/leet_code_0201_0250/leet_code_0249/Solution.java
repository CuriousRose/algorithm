package leet_code.leet_code_0201_0250.leet_code_0249;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author chj
 * @date 2019/8/5 10:28
 * 模拟
 * 11:02
 */
class Solution {
    List<List<String>> result = new ArrayList<>();

    public List<List<String>> groupStrings(String[] strings) {
        Map<String, List<String>> map = new HashMap<>();
        for (String s : strings) {
            String k = move(s);
            if (!map.containsKey(k)) {
                map.put(k, new ArrayList<>());
            }
            map.get(k).add(s);
        }
        for (List<String> list : map.values()) {
            result.add(list);
        }
        return result;
    }

    String move(String s) {
        char[] cs = s.toCharArray();
        int px = cs[0] - 'a';
        for (int i = 0; i < cs.length; i++) {
            cs[i] -= px;
            if (cs[i] < 'a') {
                cs[i] += 26;
            }
        }
        return String.valueOf(cs);
    }
}