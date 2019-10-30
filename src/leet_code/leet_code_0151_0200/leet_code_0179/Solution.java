package leet_code.leet_code_0151_0200.leet_code_0179;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 字符串 比较
 */
class Solution {
    public String largestNumber(int[] nums) {
        String[] strings = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            strings[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(strings, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                int index = 0;
                char c1 = s1.charAt(index);
                char c2 = s2.charAt(index);
                while (index < s1.length() || index < s2.length()) {
                    if (c1 > c2) {
                        return 1;
                    }
                    if (c1 < c2) {
                        return -1;
                    }
                    index++;
                    c1 = s1.charAt(index % s1.length());
                    c2 = s2.charAt(index % s2.length());
                }
                if (s1.length() == s2.length()) {
                    return 0;
                } else {
                    return compare(s1 + s2, s2 + s1);
                }
            }
        });
        StringBuffer buffer = new StringBuffer();
        for (int i = strings.length - 1; i >= 0; i--) {
            String s = strings[i];
            if (buffer.length() == 0 && s.equals("0")) {
                continue;
            } else {
                buffer.append(s);
            }
        }
        if (buffer.length() == 0) {
            buffer.append("0");
        }
        return buffer.toString();
    }
}