package leet_code.leet_code_0151_0200.leet_code_0163;

import java.util.ArrayList;
import java.util.List;

/**
 * 区间
 */
class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = new int[]{2147483647};
        System.out.println(solution.findMissingRanges(nums, 2147483647, 2147483647));
    }

    List<String> result = new ArrayList<>();

    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        for (int i : nums) {
            if (i < lower) {
                continue;
            }
            if (i == upper) {
                upper--;
                break;
            }
            if (i == lower) {
                lower++;
                continue;
            } else {
                if (i - lower == 1) {
                    result.add(lower + "");
                } else {
                    result.add(String.format("%s->%s", lower, i - 1));
                }
                lower = i + 1;
            }
        }
        if (upper >= lower) {
            if (upper == lower) {
                result.add(String.valueOf(lower));
            } else {
                result.add(String.format("%s->%s", lower, upper));
            }
        }
        return result;
    }
}