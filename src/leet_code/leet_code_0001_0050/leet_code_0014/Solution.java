package leet_code.leet_code_0001_0050.leet_code_0014;

class Solution {
    public String longestCommonPrefix(String[] strs) {
        StringBuffer buffer = new StringBuffer();
        int index = 0;

        if (strs.length == 0) {
            return "";
        }

        while (index < strs[0].length()) {
            char c = strs[0].charAt(index);
            for (String str : strs) {
                if (index >= str.length()) {
                    return buffer.toString();
                } else {
                    if (c != str.charAt(index)) {
                        return buffer.toString();
                    }
                }
            }
            buffer.append(c);
            index++;
        }

        return buffer.toString();
    }
}