package leet_code.leet_code_0251_0300.leet_code_0282.dfs;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author chj
 * @date 2019/8/15 9:46
 * 搜索(深度优先) 表达式计算
 * 10:55
 */
class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        for (String str : solution.addOperators("2147483648", -2147483648)) {
            System.out.println(str);
        }
    }

    List<String> result = new ArrayList<>();
    Stack<Character> stack = new Stack<>();
    char[] cs = {'+', '-', '*'};
    int target;

    public List<String> addOperators(String num, int target) {
        if (num.length() == 0) {
            return result;
        }
        this.target = target;
        dfs(num, 0);
        return result;
    }

    void dfs(String num, int index) {
        if (index == num.length()) {
            calc();
            return;
        }

        stack.add(num.charAt(index));
        dfs(num, index + 1);

        if (index < num.length() - 1) {
            for (int i = 0; i < 3; i++) {
                stack.add(cs[i]);
                dfs(num, index + 1);
                stack.pop();
            }
        }
        stack.pop();
    }

    void calc() {
        Stack<Long> numberStack = new Stack<>();
        Stack<Character> operatorStack = new Stack<>();
        Long num = null;
        for (char c : stack) {
            if (c >= '0' && c <= '9') {
                if (num == null) {
                    num = Long.valueOf(c - '0');
                } else {
                    if (num == 0) {
                        return;
                    }
                    num = num * 10 + (c - '0');
                }
            } else {
                numberStack.add(num);
                num = null;
                if (c == '+' || c == '-') {
                    while (!operatorStack.isEmpty()) {
                        char r = operatorStack.pop();
                        if (r == '+') {
                            numberStack.add(numberStack.pop() + numberStack.pop());
                        }
                        if (r == '-') {
                            long a = numberStack.pop();
                            long b = numberStack.pop();
                            numberStack.add(b - a);
                        }
                        if (r == '*') {
                            numberStack.add(numberStack.pop() * numberStack.pop());
                        }
                    }
                }
                operatorStack.add(c);
            }
        }
        if (num != null) {
            numberStack.add(num);
        }
        while (!operatorStack.isEmpty()) {
            char c = operatorStack.pop();
            if (c == '+') {
                numberStack.add(numberStack.pop() + numberStack.pop());
            }
            if (c == '-') {
                long a = numberStack.pop();
                long b = numberStack.pop();
                numberStack.add(b - a);
            }
            if (c == '*') {
                numberStack.add(numberStack.pop() * numberStack.pop());
            }
        }
        if (numberStack.pop() == target) {
            StringBuffer buffer = new StringBuffer();
            for (char c : stack) {
                buffer.append(c);
            }
            result.add(buffer.toString());
        }
    }
}