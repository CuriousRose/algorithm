package leet_code.leet_code_0001_0050.leet_code_0017;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.letterCombinations("23"));
    }

    List<String> result = new ArrayList<>();
    char[][] cs = new char[][]{
            {}, {}, {'a', 'b', 'c'}, {'d', 'e', 'f'},
            {'g', 'h', 'i'}, {'j', 'k', 'l'}, {'m', 'n', 'o'},
            {'p', 'q', 'r', 's'}, {'t', 'u', 'v'}, {'w', 'x', 'y', 'z'},
    };

    public List<String> letterCombinations(String digits) {
        if (digits.length() == 0) {
            return result;
        }
        dfs(0, digits, "");
        return result;
    }

    void dfs(int index, String digits, String s) {
        if (index > digits.length()) {
            return;
        }

        if (index == digits.length()) {
            result.add(s);
            return;
        }

        int i = digits.charAt(index) - '0';
        for (char c : cs[i]) {
            dfs(index + 1, digits, s + c);
        }
    }
}