package leet_code.leet_code_0001_0050.leet_code_0011;

class Solution {
    public int maxArea(int[] height) {
        int max = 0;
        int l = 0;
        int r = height.length - 1;

        while (l < r) {
            int sum = (r - l) * (height[l] > height[r] ? height[r] : height[l]);
            max = max > sum ? max : sum;

            if (height[l] < height[r]) {
                l++;
            } else {
                r--;
            }
        }
        return max;
    }
}