package leet_code.leet_code_0201_0250.leet_code_0220;

import java.util.TreeSet;

/**
 * @author chj
 * @date 2019/6/28 10:12
 * 滑动区间 二叉搜索树
 * 10:45
 */
class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = new int[]{1, 0, 1, 1};
        System.out.println(solution.containsNearbyAlmostDuplicate(nums, 1, 2));
    }

    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        TreeSet<Long> set = new TreeSet<>();
        int l = 0;
        int r = 0;
        while (r < nums.length) {
            if (r - l <= k) {
                long v = nums[r];
                Long ceiling = set.ceiling(v);
                if (ceiling != null && ceiling - v <= t) {
                    return true;
                }
                Long floor = set.floor(v);
                if (floor != null && v - floor <= t) {
                    return true;
                }
                set.add(v);
                r++;
            } else {
                long v = nums[l];
                set.remove(v);
                l++;
            }
        }
        return false;
    }
}