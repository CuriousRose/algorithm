package leet_code.leet_code_0151_0200.leet_code_0169;

import java.util.HashMap;
import java.util.Map;

/**
 * 模拟
 */
class Solution {
    public int majorityElement(int[] nums) {
        int len = nums.length;
        int aim = len % 2 == 0 ? len >> 1 : (len - 1) >> 1;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : nums) {
            int c = 0;
            if (map.containsKey(i)) {
                c = map.get(i);
                map.put(i, c + 1);
            } else {
                map.put(i, 1);
            }
            if (c + 1 > aim) {
                return i;
            }
        }
        return 0;
    }
}