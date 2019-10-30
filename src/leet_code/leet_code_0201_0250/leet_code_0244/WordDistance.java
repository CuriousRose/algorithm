package leet_code.leet_code_0201_0250.leet_code_0244;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author chj
 * @date 2019/7/5 11:28
 * 模拟 哈希
 * 11:38
 */
class WordDistance {

    String[] words;

    public WordDistance(String[] words) {
        this.words = words;
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            if (!index.containsKey(word)) {
                index.put(word, new ArrayList<>());
            }
            index.get(word).add(i);
        }
    }

    Map<String, Integer> record = new HashMap<>();
    Map<String, List<Integer>> index = new HashMap<>();

    public int shortest(String word1, String word2) {
        if (word1.equals(word2)) {
            return 0;
        }
        String key = word1 + "_" + word2;
        if (record.containsKey(key)) {
            return record.get(key);
        }
        int i1 = 0;
        int i2 = 0;
        List<Integer> l1 = index.get(word1);
        List<Integer> l2 = index.get(word2);
        int min = Integer.MAX_VALUE;
        while (i1 < l1.size() && i2 < l2.size()) {
            min = Math.min(min, Math.abs(l1.get(i1) - l2.get(i2)));
            if (l1.get(i1) > l2.get(i2)) {
                i2++;
            } else {
                i1++;
            }
        }
        record.put(key, min);
        record.put(word2 + "_" + word1, min);
        return min;
    }
}
