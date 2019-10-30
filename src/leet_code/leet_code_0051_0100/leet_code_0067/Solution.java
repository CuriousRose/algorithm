package leet_code.leet_code_0051_0100.leet_code_0067;

class Solution {
    public String addBinary(String a, String b) {
        int[] cs = new int[Math.max(a.length(), b.length()) + 1];
        int index = 0;
        for (int i = a.length() - 1; i >= 0; i--) {
            cs[index++] += a.charAt(i) - '0';
        }
        index = 0;
        for (int i = b.length() - 1; i >= 0; i--) {
            cs[index++] += b.charAt(i) - '0';
        }
        index = 0;
        for (int i = 0; i < cs.length - 1; i++) {
            cs[index + 1] += cs[index] / 2;
            cs[index] %= 2;
            index++;
        }
        StringBuffer buffer = new StringBuffer();
        if (cs[index] != 0) {
            buffer.append(cs[index--]);
        } else {
            index--;
        }
        while (index >= 0) {
            buffer.append(cs[index--]);
        }
        return buffer.toString();
    }
}