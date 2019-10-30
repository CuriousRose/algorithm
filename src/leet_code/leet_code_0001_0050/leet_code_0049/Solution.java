package leet_code.leet_code_0001_0050.leet_code_0049;

import java.util.*;

class Solution {
    public static void main(String[] args) {
        char[] cs = new char[]{'a', 'c', 'b', 'a'};
        Arrays.sort(cs);
        System.out.println(String.valueOf(cs));
    }


    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String s : strs) {
            char[] cs = s.toCharArray();
            Arrays.sort(cs);
            String key = String.valueOf(cs);

            if (map.containsKey(key)) {
                map.get(key).add(s);
            } else {
                List<String> item = new ArrayList<>();
                item.add(s);
                map.put(key, item);
            }
        }
        List<List<String>> result = new ArrayList<>();
        for (List<String> list : map.values()) {
            result.add(list);
        }
        return result;
    }
}
