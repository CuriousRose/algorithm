package leet_code.leet_code_0001_0050.leet_code_0020;

import java.util.LinkedList;

class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.isValid("([)]"));
    }

    public boolean isValid(String s) {
        LinkedList<Character> cs = new LinkedList<>();
        for (char c : s.toCharArray()) {
            if (c == '(' || c == '{' || c == '[') {
                cs.addLast(c);
                continue;
            }

            if (cs.isEmpty()) {
                return false;
            }

            char b = cs.removeLast();
            if (c == ')' && b == '(') {
                continue;
            }

            if (c == '}' && b == '{') {
                continue;
            }

            if (c == ']' && b == '[') {
                continue;
            }

            return false;
        }

        if (cs.isEmpty()) {
            return true;
        } else {
            return false;
        }
    }
}
