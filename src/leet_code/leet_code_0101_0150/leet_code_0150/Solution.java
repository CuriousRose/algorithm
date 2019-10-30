package leet_code.leet_code_0101_0150.leet_code_0150;

import java.util.Stack;

/**
 * 栈 逆波兰
 */
class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for (String str : tokens) {
            if (str.equals("+")) {
                int a = stack.pop();
                int b = stack.pop();
                stack.push(a + b);
                continue;
            }
            if (str.equals("-")) {
                int a = stack.pop();
                int b = stack.pop();
                stack.push(b - a);
                continue;
            }
            if (str.equals("*")) {
                int a = stack.pop();
                int b = stack.pop();
                stack.push(a * b);
                continue;
            }
            if (str.equals("/")) {
                int a = stack.pop();
                int b = stack.pop();
                stack.push(b / a);
                continue;
            }
            stack.push(Integer.parseInt(str));
        }
        return stack.pop();
    }
}
