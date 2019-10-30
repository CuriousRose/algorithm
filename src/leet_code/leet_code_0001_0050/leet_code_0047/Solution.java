package leet_code.leet_code_0001_0050.leet_code_0047;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = new int[]{1, 1, 2};
        for (List<Integer> list : solution.permuteUnique(nums)) {
            System.out.println(list);
        }
    }

    List<List<Integer>> result = new ArrayList<>();
    Set<String> set = new HashSet<>();
    boolean[] mark;
    int[] list;

    public List<List<Integer>> permuteUnique(int[] nums) {
        mark = new boolean[nums.length];
        list = new int[nums.length];
        dfs(nums, 0);
        return result;
    }

    void dfs(int[] nums, int index) {
        if (index == nums.length) {
            StringBuffer buffer = new StringBuffer();
            List<Integer> item = new ArrayList<>();
            for (int i : list) {
                buffer.append(i);
                item.add(i);
            }
            String key = buffer.toString();
            if (set.contains(key)) {
                return;
            } else {
                set.add(key);
                result.add(item);
                return;
            }
        }

        for (int i = 0; i < nums.length; i++) {
            if (mark[i]) {
                continue;
            }
            mark[i] = true;
            list[index] = nums[i];
            dfs(nums, index + 1);
            mark[i] = false;
        }
    }
}
