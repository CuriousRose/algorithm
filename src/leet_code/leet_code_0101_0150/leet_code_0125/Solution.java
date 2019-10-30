package leet_code.leet_code_0101_0150.leet_code_0125;

class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.isPalindrome("0P"));
    }

    public boolean isPalindrome(String s) {
        if (s.length() == 0) {
            return true;
        }
        char[] cs = s.toCharArray();
        int l = 0;
        int r = cs.length - 1;
        while (l < r) {
            char lc = deal(cs[l]);
            while (lc == '.' && l < r) {
                l++;
                lc = deal(cs[l]);
            }
            char rc = deal(cs[r]);
            while (rc == '.' && l < r) {
                r--;
                rc = deal(cs[r]);
            }
            if (lc == rc) {
                l++;
                r--;
            } else {
                return false;
            }
        }
        return true;
    }

    char deal(char c) {
        if (c >= '0' && c <= '9') {
            return c;
        }
        if (c >= 'a' && c <= 'z') {
            return c;
        }
        if (c >= 'A' && c <= 'Z') {
            return (char) (c + 32);
        }
        return '.';
    }
}