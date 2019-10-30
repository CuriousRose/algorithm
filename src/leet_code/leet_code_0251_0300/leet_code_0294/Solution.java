package leet_code.leet_code_0251_0300.leet_code_0294;

/**
 * @author chj
 * @date 2019/8/19 11:38
 * 搜索(深度优先)
 * 11:44
 */
class Solution {
    public boolean canWin(String s) {
        for (int i = 0; i < s.length() - 1; i++) {
            char[] cs = s.toCharArray();
            if (cs[i] == '+' && cs[i + 1] == '+') {
                cs[i] = '-';
                cs[i + 1] = '-';
                if (canWin(String.valueOf(cs))) {
                    continue;
                } else {
                    return true;
                }
            }
        }
        return false;
    }
}