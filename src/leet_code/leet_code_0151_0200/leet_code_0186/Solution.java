package leet_code.leet_code_0151_0200.leet_code_0186;

/**
 * 字符串 翻转
 */
class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        char[] str = new char[]{'a', ' ', 'b'};
        solution.reverseWords(str);
        System.out.println(str);
    }

    public void reverseWords(char[] str) {
        int len = str.length - 1;
        reverse(str, 0, len);
        int l = 0, r = 0;
        while (r <= len) {
            if (str[r] == ' ') {
                reverse(str, l, r - 1);
                l = r + 1;
                r = l + 1;
            } else {
                r++;
            }
        }
        reverse(str, l, r - 1);
    }

    void reverse(char[] cs, int l, int r) {
        while (l < r) {
            char c = cs[l];
            cs[l] = cs[r];
            cs[r] = c;
            l++;
            r--;
        }
    }

}