package leet_code.leet_code_0201_0250.leet_code_0216;

import java.util.ArrayList;
import java.util.List;

/**
 * 深度优先搜索
 */
class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.combinationSum3(3, 9));
    }

    List<List<Integer>> result = new ArrayList<>();
    int[] list;
    boolean[] mark;

    public List<List<Integer>> combinationSum3(int k, int n) {
        list = new int[k];
        mark = new boolean[10];
        dfs(0, 0, 1, n, k);
        return result;
    }

    void dfs(int index, int sum, int start, int aim, int len) {
        if (sum == aim && index == len) {
            List<Integer> item = new ArrayList<>();
            for (int i : list) {
                item.add(i);
            }
            result.add(item);
            return;
        }
        if (sum >= aim) {
            return;
        }
        if (index >= len) {
            return;
        }
        for (int i = start; i <= 9; i++) {
            if (mark[i]) {
                continue;
            }
            mark[i] = true;
            list[index] = i;
            dfs(index + 1, sum + i, i + 1, aim, len);
            mark[i] = false;
        }
    }
}