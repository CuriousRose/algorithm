package leet_code.leet_code_0001_0050.leet_code_0026;

class Solution {
    public int removeDuplicates(int[] nums) {
        int n = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            nums[n++] = nums[i];
        }
        return n;
    }
}
