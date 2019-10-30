package leet_code.leet_code_0251_0300.leet_code_0266;

import java.util.HashSet;
import java.util.Set;

/**
 * @author chj
 * @date 2019/8/8 9:57
 * 模拟 哈希
 * 10:01
 */
class Solution {
    public boolean canPermutePalindrome(String s) {
        Set<Character> set = new HashSet<>();
        for (char c : s.toCharArray()) {
            if (set.contains(c)) {
                set.remove(c);
            } else {
                set.add(c);
            }
        }
        return set.size() <= 1;
    }
}