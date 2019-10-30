package leet_code.leet_code_0001_0050.leet_code_0039;

import java.util.*;

class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] candidates = new int[]{2, 3, 6, 7};
        for (List<Integer> list : solution.combinationSum(candidates, 7)) {
            System.out.println(list);
        }
    }

    List<List<Integer>> result = new ArrayList<>();
    Stack<Integer> stack = new Stack<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
//        Arrays.sort(candidates);
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

        int count = 0;
        while (sum < target) {
            dfs(candidates, index + 1, target, sum);

            stack.add(candidates[index]);
            sum += candidates[index];
            count++;
        }

        if (sum == target) {
            List<Integer> list = new ArrayList<>();
            for (int i : stack) {
                list.add(i);
            }
            result.add(list);
        }

        for (int i = 0; i < count; i++) {
            stack.pop();
        }
    }
}