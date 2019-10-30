package leet_code.leet_code_0251_0300.leet_code_0254;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author chj
 * @date 2019/8/6 10:17
 * 搜索(深度优先)
 * 10:38
 */
class Solution {
    List<List<Integer>> result = new ArrayList<>();
    Stack<Integer> stack = new Stack<>();

    public List<List<Integer>> getFactors(int n) {
        dfs(n, 2, n);
        return result;
    }

    void dfs(int n, int l, int r) {
        if (n == 1) {
            if (stack.size() == 0) {
                return;
            }
            List<Integer> item = new ArrayList<>();
            for (Integer i : stack) {
                item.add(i);
            }
            result.add(item);
            return;
        }
        for (int i = l; i <= n && i < r; i++) {
            if (n % i == 0) {
                stack.push(i);
                dfs(n / i, i, r);
                stack.pop();
            }
        }
    }
}