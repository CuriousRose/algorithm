package leet_code.leet_code_0001_0050.leet_code_0027;

class Solution {
    public int removeElement(int[] nums, int val) {
        int n = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == val) {
                continue;
            }
            nums[n++] = nums[i];
        }
        return n;
    }
}