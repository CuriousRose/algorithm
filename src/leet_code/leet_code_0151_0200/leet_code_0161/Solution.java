package leet_code.leet_code_0151_0200.leet_code_0161;

/**
 * 模拟 比较
 */
class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.isOneEditDistance("ab", "acb"));
    }

    public boolean isOneEditDistance(String s, String t) {
        if (s.length() == 0 && t.length() == 0) {
            return false;
        }
        if (Math.abs(s.length() - t.length()) > 1) {
            return false;
        }
        if (s.length() == t.length()) {
            int diff = 0;
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) != t.charAt(i)) {
                    diff++;
                }
            }
            if (diff != 1) {
                return false;
            } else {
                return true;
            }
        }
        if (s.length() > t.length()) {
            int diff = 0;
            for (int i = 0; i < t.length(); i++) {
                if (s.charAt(i + diff) != t.charAt(i)) {
                    if (diff == 0) {
                        diff++;
                    } else {
                        return false;
                    }
                    i--;
                }
            }
            return true;
        }
        if (s.length() < t.length()) {
            int diff = 0;
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) != t.charAt(i + diff)) {
                    if (diff == 0) {
                        diff++;
                    } else {
                        return false;
                    }
                    i--;
                }
            }
            return true;
        }
        return false;
    }
}
