package leet_code.leet_code_0201_0250.leet_code_0217;

import java.util.HashSet;
import java.util.Set;

/**
 * 哈希
 */
class Solution {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int i : nums) {
            if (set.contains(i)) {
                return true;
            } else {
                set.add(i);
            }
        }
        return false;
    }
}