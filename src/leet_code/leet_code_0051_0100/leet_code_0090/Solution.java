package leet_code.leet_code_0051_0100.leet_code_0090;

import java.util.*;

class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = new int[]{4, 4, 4, 1, 4};
        for (List<Integer> list : solution.subsetsWithDup(nums)) {
            System.out.println(list);
        }
    }

    List<List<Integer>> result = new ArrayList<>();
    Set<String> record = new HashSet<>();
    int[] list;

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        list = new int[nums.length];
        Arrays.sort(nums);
        dfs(nums, 0, 0);
        return result;
    }

    void dfs(int[] nums, int index, int start) {
        StringBuffer buffer = new StringBuffer();
        List<Integer> item = new ArrayList<>();
        for (int i = 0; i < index; i++) {
            buffer.append(list[i]);
            item.add(list[i]);
        }
        if (!record.contains(buffer.toString())) {
            record.add(buffer.toString());
            result.add(item);
        }
        for (int i = start; i < nums.length; i++) {
            list[index] = nums[i];
            dfs(nums, index + 1, i + 1);
        }
    }
}