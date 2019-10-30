package leet_code.leet_code_0101_0150.leet_code_0128;

import java.util.HashSet;
import java.util.Set;

class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int i : nums) {
            set.add(i);
        }
        int max = 0;
        for (int i : set) {
            if (set.contains(i - 1)) {
                continue;
            }

            int count = 1;
            int j = i + 1;
            while (set.contains(j)) {
                count++;
                j++;
            }
            max = Math.max(max, count);
        }
        return max;
    }
}