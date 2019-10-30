package leet_code.leet_code_0201_0250.leet_code_0229;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author chj
 * @date 2019/7/1 10:23
 * 哈希
 * 10:28
 */
class Solution {
    List<Integer> result = new ArrayList<>();

    public List<Integer> majorityElement(int[] nums) {
        int len = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : nums) {
            if (!map.containsKey(i)) {
                map.put(i, 1);
            } else {
                map.put(i, map.get(i) + 1);
            }
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() > len / 3) {
                result.add(entry.getKey());
            }
        }
        return result;
    }
}