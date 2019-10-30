package leet_code.leet_code_0251_0300.leet_code_0259;


import java.util.Arrays;

/**
 * @author chj
 * @date 2019/8/6 11:48
 * 模拟 排序 二分查找
 * 12:50av
 */
class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.threeSumSmaller(new int[]{3, 1, 0, -2}, 4));
    }

    public int threeSumSmaller(int[] nums, int target) {
        if (nums.length < 3) {
            return 0;
        }
        Arrays.sort(nums);
        int len = nums.length - 1;
        if (nums[0] < 0) {
            for (int i = 1; i <= len; i++) {
                nums[i] -= nums[0];
            }
        }
        target -= 3 * nums[0];
        nums[0] = 0;
        int count = 0;
        int sum;
        for (int i = 0; i <= len - 2; i++) {
            sum = nums[i];
            if (sum >= target) {
                return count;
            }
            int jr = find(target - sum, nums, i + 1, len - 1);
            for (int j = i + 1; j <= jr; j++) {
                int sum2 = sum + nums[j];
                int kr = find(target - sum2, nums, j + 1, len);
                if (kr > 0) {
                    count += kr - j;
                }
            }
        }
        return count;
    }

    int find(int target, int[] nums, int l, int r) {
        if (l == r) {
            if (nums[l] < target) {
                return l;
            } else {
                return -1;
            }
        }
        int m = (l + r) / 2;
        if (nums[m + 1] < target) {
            return find(target, nums, m + 1, r);
        } else {
            return find(target, nums, l, m);
        }
    }
}