package leet_code.leet_code_0101_0150.leet_code_0131;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class Solution {
    List<List<String>> result = new ArrayList<>();
    Stack<String> stack = new Stack<>();

    public List<List<String>> partition(String s) {
        dfs(s);
        return result;
    }

    void dfs(String s) {
        if (s.length() == 0) {
            List<String> item = new ArrayList<>();
            for (String str : stack) {
                item.add(str);
            }
            result.add(item);
            return;
        }
        for (int i = 1; i <= s.length(); i++) {
            String sub = s.substring(0, i);
            if (check(sub)) {
                stack.add(sub);
                dfs(s.substring(i));
                stack.pop();
            }
        }
    }

    boolean check(String s) {
        if (s.length() == 1) {
            return true;
        }
        int l = 0;
        int r = s.length() - 1;
        while (l < r) {
            if (s.charAt(l) == s.charAt(r)) {
                l++;
                r--;
            } else {
                return false;
            }
        }
        return true;
    }
}
