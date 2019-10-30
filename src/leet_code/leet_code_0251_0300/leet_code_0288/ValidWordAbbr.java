package leet_code.leet_code_0251_0300.leet_code_0288;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author chj
 * @date 2019/8/19 9:50
 * 模拟 哈希
 * 10:04
 */
class ValidWordAbbr {
    Map<String, Integer> map = new HashMap<>();
    Set<String> set = new HashSet();

    public ValidWordAbbr(String[] dictionary) {
        for (String word : dictionary) {
            if (set.contains(word)) {
                continue;
            }
            set.add(word);
            String key = abridge(word);
            if (!map.containsKey(key)) {
                map.put(key, 1);
            } else {
                map.put(key, map.get(key) + 1);
            }
        }
    }

    public boolean isUnique(String word) {
        String key = abridge(word);
        if (!map.containsKey(key)) {
            return true;
        }
        int count = map.get(key);
        if (count > 1) {
            return false;
        }
        if (count == 1 && !set.contains(word)) {
            return false;
        }
        return true;
    }

    String abridge(String word) {
        if (word.length() <= 2) {
            return word;
        }
        StringBuffer buffer = new StringBuffer();
        buffer.append(word.charAt(0)).append(word.length() - 2).append(word.charAt(word.length() - 1));
        return buffer.toString();
    }
}