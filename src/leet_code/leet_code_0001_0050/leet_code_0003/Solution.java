package leet_code.leet_code_0001_0050.leet_code_0003;

import java.util.HashSet;
import java.util.Set;

class Solution {
    public int lengthOfLongestSubstring(String s) {
        int max = 0;
        Set<Character> set = new HashSet<>();
        int i = 0;
        for (int j = 0; j < s.length(); j++) {
            char jc = s.charAt(j);

            if (set.contains(jc)) {
                while (i < j) {
                    char ic = s.charAt(i);
                    i++;
                    if (ic == jc) {
                        break;
                    } else {
                        set.remove(ic);
                    }
                }
            } else {
                set.add(jc);
                max = max > set.size() ? max : set.size();
            }
        }

        return max;
    }
}