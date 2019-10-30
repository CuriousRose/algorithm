package leet_code.leet_code_0001_0050.leet_code_0022;

import java.util.ArrayList;
import java.util.List;

class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        for (String str : solution.generateParenthesis(3)) {
            System.out.println(str);
        }
    }

    List<String> result = new ArrayList<>();

    public List<String> generateParenthesis(int n) {
        dfs(0, 0, n, "");
        return result;
    }

    void dfs(int l, int r, int n, String s) {
        if (l == n && r == 0) {
            result.add(s);
        }

        if (l < n) {
            dfs(l + 1, r + 1, n, s + "(");
        }

        if (r > 0) {
            dfs(l, r - 1, n, s + ")");
        }
    }
}