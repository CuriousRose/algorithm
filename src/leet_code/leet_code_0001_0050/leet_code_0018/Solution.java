package leet_code.leet_code_0001_0050.leet_code_0018;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        int len = nums.length;

        for (int i = 0; i < len - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            for (int j = len - 1; j > i; j--) {
                if (j < len - 1 && nums[j] == nums[j + 1]) {
                    continue;
                }
                int l = i + 1;
                int r = j - 1;
                while (l < r) {
                    int current = nums[i] + nums[j] + nums[l] + nums[r];
                    if (current == target) {
                        List<Integer> item = new ArrayList<>();
                        item.add(nums[i]);
                        item.add(nums[l]);
                        item.add(nums[r]);
                        item.add(nums[j]);
                        result.add(item);
                        while (l < r && nums[l] == nums[l + 1]) {
                            l++;
                        }
                        while (l < r && nums[r] == nums[r - 1]) {
                            r--;
                        }
                    }
                    if (current < target) {
                        l++;
                    } else {
                        r--;
                    }
                }
            }
        }

        return result;
    }
}
