package leet_code.leet_code_0051_0100.leet_code_0080;

class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int len = 0;
        int record = nums[0];
        int times = 0;
        for (int i = 0; i < nums.length; i++) {
            if (record == nums[i]) {
                if (times < 2) {
                    times++;
                    nums[len++] = nums[i];
                } else {
                    continue;
                }
            } else {
                record = nums[i];
                times = 1;
                nums[len++] = nums[i];
            }
        }
        return len;
    }
}