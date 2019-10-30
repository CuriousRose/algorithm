package leet_code.leet_code_0201_0250.leet_code_0219;

import java.util.HashSet;
import java.util.Set;

/**
 * @author chj
 * @date 2019/6/28 9:49
 * 滑动区间
 * 10:11
 */
class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Set<Integer> set = new HashSet<>();
        int l = 0;
        int r = 0;
        while (r < nums.length) {
            if (r - l <= k) {
                if (set.contains(nums[r])) {
                    return true;
                } else {
                    set.add(nums[r]);
                }
                r++;
            } else {
                set.remove(nums[l]);
                l++;
            }
        }
        return false;
    }
}