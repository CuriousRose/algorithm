package leet_code.leet_code_0201_0250.leet_code_0228;

import java.util.ArrayList;
import java.util.List;

/**
 * @author chj
 * @date 2019/7/1 10:16
 * 模拟
 * 10:22
 */
class Solution {
    List<String> result = new ArrayList<>();

    public List<String> summaryRanges(int[] nums) {
        if (nums.length == 0) {
            return result;
        }
        int l = 0;
        int r = 0;
        while (r < nums.length - 1) {
            if (nums[r] + 1 == nums[r + 1]) {
                r++;
            } else {
                if (l == r) {
                    result.add(String.valueOf(nums[l]));
                } else {
                    result.add(nums[l] + "->" + nums[r]);
                }
                l = r + 1;
                r = l;
            }
        }
        if (l == r) {
            result.add(String.valueOf(nums[l]));
        } else {
            result.add(nums[l] + "->" + nums[r]);
        }
        return result;
    }
}