package leet_code.leet_code_0001_0050.leet_code_0046;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = new int[]{1, 2, 3};
        for (List<Integer> list : solution.permute(nums)) {
            System.out.println(list);
        }
    }

    List<List<Integer>> result = new ArrayList<>();
    boolean[] mark;
    int[] list;

    public List<List<Integer>> permute(int[] nums) {
        mark = new boolean[nums.length];
        list = new int[nums.length];
        dfs(nums, 0);
        return result;
    }

    void dfs(int[] nums, int index) {
        if (index == nums.length) {
            List<Integer> item = new ArrayList<>();
            for (int i : list) {
                item.add(i);
            }
            result.add(item);
        }
        for (int i = 0; i < nums.length; i++) {
            if (mark[i]) {
                continue;
            }
            list[index] = nums[i];
            mark[i] = true;
            dfs(nums, index + 1);
            mark[i] = false;
        }
    }
}