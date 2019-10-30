package leet_code.leet_code_0151_0200.leet_code_0159;

import java.util.HashMap;
import java.util.Map;

/**
 * 滑动窗口
 */
class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.lengthOfLongestSubstringTwoDistinct("eceba"));
    }

    public int lengthOfLongestSubstringTwoDistinct(String s) {
        if (s.length() == 0) {
            return 0;
        }
        Map<Character, Integer> map = new HashMap<>();
        int left = 0;
        int right = 0;
        int max = 0;
        int count = 0;
        while (right < s.length()) {
            if (count == 3) {
                char c = s.charAt(left);
                left++;
                int k = map.get(c) - 1;
                if (k == 0) {
                    map.remove(c);
                    count--;
                } else {
                    map.put(c, k);
                }
            } else {
                char c = s.charAt(right);
                right++;
                if (!map.containsKey(c)) {
                    map.put(c, 1);
                    count++;
                } else {
                    map.put(c, map.get(c) + 1);
                }
                if (count <= 2) {
                    max = Math.max(max, right - left);
                }
            }
        }
        return max;
    }
}