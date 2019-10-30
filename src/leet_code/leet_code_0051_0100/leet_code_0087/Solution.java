package leet_code.leet_code_0051_0100.leet_code_0087;

import java.util.HashSet;
import java.util.Set;

class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String s1 = "abcdefghijklmnopq";
        String s2 = "efghijklmnopqcadb";
        System.out.println(solution.isScramble(s1, s2));
    }

    Set<String> record = new HashSet<>();
    public boolean isScramble(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }
        return match(s1, s2);
    }

    boolean match(String s, String aim) {
        if (s.equals(aim)) {
            return true;
        }
        if (record.contains(s + "_" + aim)) {
            return false;
        }
        if (!mayEquals(s, aim)) {
            return false;
        }
        for (int i = 1; i < s.length(); i++) {
            String s1 = s.substring(0, i);
            String s2 = s.substring(i);
            String aim1 = aim.substring(0, i);
            String aim2 = aim.substring(i);
            String aim3 = aim.substring(0, s.length() - i);
            String aim4 = aim.substring(s.length() - i);
            if (match(s1, aim1) && match(s2, aim2)) {
                return true;
            }
            if (match(s1, aim4) && match(s2, aim3)) {
                return true;
            }
        }
        record.add(s + "_" + aim);
        return false;
    }

    boolean mayEquals(String s1, String s2) {
        int[] mark = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            mark[s1.charAt(i) - 'a']++;
            mark[s2.charAt(i) - 'a']--;
        }
        for (int m : mark) {
            if (m != 0) {
                return false;
            }
        }
        return true;
    }
}