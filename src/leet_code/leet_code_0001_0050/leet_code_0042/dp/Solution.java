package leet_code.leet_code_0001_0050.leet_code_0042.dp;


class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = new int[]{4, 2, 3};
        System.out.println(solution.trap(nums));
    }

    public int trap(int[] height) {
        if (height.length == 0 || height.length == 1) {
            return 0;
        }

        int sum = 0;
        int[] dpl = new int[height.length];
        int[] dpr = new int[height.length];

        dpl[0] = height[0];
        dpr[height.length - 1] = height[height.length - 1];
        for (int i = 1; i < height.length; i++) {
            dpl[i] = Math.max(dpl[i - 1], height[i]);
        }

        for (int i = height.length - 2; i >= 0; i--) {
            dpr[i] = Math.max(dpr[i + 1], height[i]);
        }

        for (int i = 0; i < height.length; i++) {
            sum += Math.min(dpl[i], dpr[i]) - height[i];
        }

        return sum;
    }
}
