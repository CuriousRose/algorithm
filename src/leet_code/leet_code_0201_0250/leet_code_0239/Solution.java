package leet_code.leet_code_0201_0250.leet_code_0239;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

/**
 * @author chj
 * @date 2019/7/4 10:34
 * 二叉搜索树 哈希
 * 10:52
 */
class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums.length == 0) {
            return new int[0];
        }
        Map<Integer, Integer> map = new HashMap<>();
        TreeSet<Integer> set = new TreeSet<>();
        for (int i = 0; i < k && i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                map.put(nums[i], map.get(nums[i]) + 1);
            } else {
                map.put(nums[i], 1);
                set.add(nums[i]);
            }
        }
        int[] result = new int[nums.length - k + 1];
        for (int i = 0; i < result.length; i++) {
            result[i] = set.last();
            if (i == result.length - 1) {
                break;
            }
            if (map.containsKey(nums[i + k])) {
                map.put(nums[i + k], map.get(nums[i + k]) + 1);
            } else {
                map.put(nums[i + k], 1);
                set.add(nums[i + k]);
            }
            if (map.get(nums[i]) == 1) {
                map.remove(nums[i]);
                set.remove(nums[i]);
            } else {
                map.put(nums[i], map.get(nums[i]) - 1);
            }
        }
        return result;
    }
}