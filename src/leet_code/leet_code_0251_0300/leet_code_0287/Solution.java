package leet_code.leet_code_0251_0300.leet_code_0287;

import java.util.HashSet;
import java.util.Set;

/**
 * @author chj
 * @date 2019/8/15 11:36
 * 哈希
 * 11:38
 */
class Solution {
    public int findDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int i : nums) {
            if (set.contains(i)) {
                return i;
            } else {
                set.add(i);
            }
        }
        return -1;
    }
}