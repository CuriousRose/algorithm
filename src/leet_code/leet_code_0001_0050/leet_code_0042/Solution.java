package leet_code.leet_code_0001_0050.leet_code_0042;

import java.util.Stack;

class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        System.out.println(solution.trap(nums));
    }

    public int trap(int[] height) {
        if (height.length == 0 || height.length == 1) {
            return 0;
        }

        int sum = 0;

        Stack<Integer> stack = new Stack<>();
        Stack<Integer> record = new Stack<>();
        stack.push(height[0]);
        int button = height[0];
        record.push(0);


        for (int i = 1; i < height.length; i++) {
            int right = height[i];

            while (!stack.isEmpty()) {
                int left = stack.pop();
                int index = record.pop();

                if (button < left) {
                    sum += (i - index - 1) * (Math.min(left, right) - button);
                    button = left;
                }

                if (left > right) {
                    stack.push(left);
                    record.push(index);
                    break;
                }
            }

            stack.push(right);
            record.push(i);
            button = right;
        }

        return sum;
    }
}
