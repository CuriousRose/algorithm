package leet_code.leet_code_0251_0300.leet_code_0293;

import java.util.ArrayList;
import java.util.List;

/**
 * @author chj
 * @date 2019/8/19 11:29
 * 模拟
 * 11:32
 */
class Solution {
    List<String> result = new ArrayList<>();

    public List<String> generatePossibleNextMoves(String s) {
        for (int i = 0; i < s.length() - 1; i++) {
            if (s.charAt(i) == '+' && s.charAt(i + 1) == '+') {
                String item = s.substring(0, i) + "--" + s.substring(i + 2);
                result.add(item);
            }
        }
        return result;
    }
}