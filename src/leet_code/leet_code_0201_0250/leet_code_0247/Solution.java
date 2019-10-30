package leet_code.leet_code_0201_0250.leet_code_0247;

import java.util.ArrayList;
import java.util.List;

/**
 * @author chj
 * @date 2019/8/2 11:04
 * 模拟 搜索(深度优先)
 * 12:10 (work)
 */
class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        for (String s : solution.findStrobogrammatic(0)) {
            System.out.println(s);
        }
    }

    List<String> result = new ArrayList<>();

    char[] cs = {'0', '1', '6', '8', '9'};
    char[] ps = {'0', '1', '9', '8', '6'};
    char[] ms = {'0', '1', '8'};
    char[] list;

    public List<String> findStrobogrammatic(int n) {
        list = new char[n];
        dfs(0, n - 1);
        return result;
    }

    void dfs(int index, int len) {
        if (index > (len - 1) / 2 || len == 0) {
            if (len % 2 == 0) {
                int mid = len / 2;
                for (int i = 0; i < ms.length; i++) {
                    list[mid] = ms[i];
                    result.add(String.valueOf(list));
                }
            } else {
                result.add(String.valueOf(list));
            }
            return;
        }
        int i = index == 0 ? 1 : 0;
        for (; i < cs.length; i++) {
            list[index] = cs[i];
            list[len - index] = ps[i];
            dfs(index + 1, len);
        }
    }
}