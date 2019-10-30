package leet_code.leet_code_0051_0100.leet_code_0075;

class Solution {
    public void sortColors(int[] nums) {
        int[] count = new int[3];
        for (int i : nums) {
            count[i]++;
        }
        int index = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < count[i]; j++) {
                nums[index++] = i;
            }
        }
    }
}