package leet_code.leet_code_0251_0300.leet_code_0269;

import java.util.ArrayList;
import java.util.List;

/**
 * @author chj
 * @date 2019/8/8 11:24
 * 图论 拓扑排序 搜索(深度优先)
 * 12:08
 */
class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String[] words = new String[]{"wrt", "wrf", "er", "ett", "rftt"};
        System.out.println(solution.alienOrder(words));
    }

    int[][] p = new int[26][26];
    List<Character> list = new ArrayList<>();

    public String alienOrder(String[] words) {
        for (int i = 0; i < words.length; i++) {
            for (char c : words[i].toCharArray()) {
                appear[c - 'a'] = true;
            }
        }
        for (int i = 1; i < words.length; i++) {
            compare(words[i - 1], words[i]);
        }
        for (int i = 0; i < 26; i++) {
            if (!appear[i]) {
                continue;
            }
            if (mark[i]) {
                continue;
            }
            if (build(i)) {
                continue;
            } else {
                return "";
            }
        }
        StringBuffer buffer = new StringBuffer();
        for (char c : list) {
            buffer.append(c);
        }
        return buffer.toString();
    }

    void compare(String s1, String s2) {
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) == s2.charAt(i)) {
                continue;
            } else {
                int x = s1.charAt(i) - 'a';
                int y = s2.charAt(i) - 'a';
                p[y][++p[y][0]] = x;
                break;
            }
        }
    }

    boolean[] appear = new boolean[26];
    boolean[] mark = new boolean[26];
    boolean[] record = new boolean[26];

    boolean build(int index) {
        record[index] = true;
        for (int i = 1; i <= p[index][0]; i++) {
            int item = p[index][i];
            if (mark[item]) {
                continue;
            } else {
                if (record[item]) {
                    return false;
                } else {
                    if (!build(item)) {
                        return false;
                    }
                }
            }
        }
        mark[index] = true;
        list.add((char) (index + 'a'));
        return true;
    }
}