package leet_code.leet_code_0151_0200.leet_code_0151;

/**
 * 字符串
 */
class Solution {
    public String reverseWords(String s) {
        StringBuffer buffer = new StringBuffer();
        String[] splits = s.split(" ");
        for (int i = splits.length - 1; i >= 0; i--) {
            String str = splits[i];
            if (str.length() == 0) {
                continue;
            }
            buffer.append(str).append(" ");
        }
        return buffer.toString().trim();
    }
}
