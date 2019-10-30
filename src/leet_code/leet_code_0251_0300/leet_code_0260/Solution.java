package leet_code.leet_code_0251_0300.leet_code_0260;

import java.util.HashSet;
import java.util.Set;

/**
 * @author chj
 * @date 2019/8/7 10:01
 * 模拟 哈希
 * 10:04
 */
class Solution {
    public int[] singleNumber(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int i : nums) {
            if (set.contains(i)) {
                set.remove(i);
            } else {
                set.add(i);
            }
        }
        int[] result = new int[2];
        int index = 0;
        for (int i : set) {
            result[index++] = i;
        }
        return result;
    }
}