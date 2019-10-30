package leet_code.leet_code_0051_0100.leet_code_0078;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        for (List<Integer> list : solution.subsets(new int[]{1, 2, 3})) {
            System.out.println(list);
        }
    }

    List<List<Integer>> result = new ArrayList<>();
    int[] list;

    public List<List<Integer>> subsets(int[] nums) {
        list = new int[nums.length];
        dfs(nums, 0, 0);
        return result;
    }

    void dfs(int[] nums, int index, int start) {
        List<Integer> item = new ArrayList<>();
        for (int i = 0; i < index; i++) {
            item.add(list[i]);
        }
        result.add(item);

        for (int i = start; i < nums.length; i++) {
            list[index] = nums[i];
            dfs(nums, index + 1, i + 1);
        }
    }
}