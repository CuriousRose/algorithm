package leet_code.leet_code_0151_0200.leet_code_0164;

/**
 * 排序
 */
class Solution {
    public int maximumGap(int[] nums) {
        if (nums.length < 2) {
            return 0;
        }
        sort(nums, 0, nums.length - 1);
        int max = 0;
        for (int i = 1; i < nums.length; i++) {
            max = Math.max(max, nums[i] - nums[i - 1]);
        }
        return max;
    }

    void sort(int[] nums, int l, int r) {
        if (l >= r) {
            return;
        }
        int ll = l;
        int rr = r;
        while (ll < rr) {
            while (nums[ll] <= nums[rr] && ll < rr) {
                rr--;
            }
            int x = nums[ll];
            nums[ll] = nums[rr];
            nums[rr] = x;
            while (nums[ll] <= nums[rr] && ll < rr) {
                ll++;
            }
            int y = nums[ll];
            nums[ll] = nums[rr];
            nums[rr] = y;
        }
        sort(nums, l, ll - 1);
        sort(nums, rr + 1, r);

    }
}