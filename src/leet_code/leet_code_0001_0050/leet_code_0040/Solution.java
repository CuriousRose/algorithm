package leet_code.leet_code_0001_0050.leet_code_0040;

import java.util.*;

class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] candidates = new int[]{10, 1, 2, 7, 6, 1, 5};
        for (List<Integer> list : solution.combinationSum2(candidates, 8)) {
            System.out.println(list);
        }
    }

    List<List<Integer>> result = new ArrayList<>();
    Stack<Integer> stack = new Stack<>();
    Set<String> check = new HashSet<>();

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        dfs(candidates, 0, target, 0);
        return result;
    }

    void dfs(int[] candidates, int index, int target, int sum) {
        if (index == candidates.length) {
            return;
        }

        if (sum + candidates[index] > target) {
            return;
        }

        dfs(candidates, index + 1, target, sum);

        stack.add(candidates[index]);
        sum += candidates[index];

        if (sum == target) {
            StringBuffer buffer = new StringBuffer();
            List<Integer> list = new ArrayList<>();
            for (int i : stack) {
                list.add(i);
                buffer.append(i);
            }
            String key = buffer.toString();
            if (!check.contains(key)) {
                check.add(key);
                result.add(list);
            }
        }

        dfs(candidates, index + 1, target, sum);
        stack.pop();
    }
}
