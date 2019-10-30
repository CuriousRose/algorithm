package leet_code.leet_code_0201_0250.leet_code_0214;

/**
 * 暴力 搜索 剪纸
 */
class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.shortestPalindrome("abb"));
    }

    int min = Integer.MAX_VALUE;
    String result;

    public String shortestPalindrome(String s) {
        if (s.length() < 2) {
            return s;
        }
        int len = s.length();
        findOdd(s, (len - 1) / 2);
        for (int index = len / 2 - 1; index >= 0; index--) {
            findEven(s, index);
            findOdd(s, index);
            if (min < len - 2 * index) {
                break;
            }
        }
        return result;
    }

    void findOdd(String s, int index) {
        int len = s.length();
        int l = index;
        int r = index;
        while (l >= 0) {
            if (s.charAt(l) != s.charAt(r)) {
                return;
            }
            l--;
            r++;
        }
        int diff = len - r;
        if (diff < min) {
            min = diff;
            StringBuffer buffer = new StringBuffer();
            for (int i = len - 1; i >= r; i--) {
                buffer.append(s.charAt(i));
            }
            buffer.append(s);
            result = buffer.toString();
        }
    }

    void findEven(String s, int index) {
        int len = s.length();
        int l = index;
        int r = index + 1;
        while (l >= 0) {
            if (s.charAt(l) != s.charAt(r)) {
                return;
            }
            l--;
            r++;
        }
        int diff = len - r;
        if (diff < min) {
            min = diff;
            StringBuffer buffer = new StringBuffer();
            for (int i = len - 1; i >= r; i--) {
                buffer.append(s.charAt(i));
            }
            buffer.append(s);
            result = buffer.toString();
        }
    }
}