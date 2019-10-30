package leet_code.leet_code_0051_0100.leet_code_0077;

import java.util.ArrayList;
import java.util.List;

class Solution {
    List<List<Integer>> result = new ArrayList<>();
    int[] list;

    public List<List<Integer>> combine(int n, int k) {
        list = new int[k];
        dfs(n, k, 0, 1);
        return result;
    }

    void dfs(int n, int k, int index, int start) {
        if (index == k) {
            List<Integer> item = new ArrayList<>();
            for (int i : list) {
                item.add(i);
            }
            result.add(item);
            return;
        }
        for (int i = start; i <= n; i++) {
            list[index] = i;
            dfs(n, k, index + 1, i + 1);
        }
    }
}