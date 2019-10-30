package leet_code.leet_code_0001_0050.leet_code_0013;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public int romanToInt(String s) {
        Map<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);

        int result = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (i + 1 < s.length()) {
                char nc = s.charAt(i + 1);
                if (map.get(c) < map.get(nc)) {
                    result -= map.get(c);
                } else {
                    result += map.get(c);
                }
            } else {
                result += map.get(c);
            }
        }
        return result;
    }
}