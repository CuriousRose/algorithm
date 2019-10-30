package leet_code.leet_code_0201_0250.leet_code_0232;

import java.util.Stack;

/**
 * @author chj
 * @date 2019/7/1 10:44
 * 栈 队列
 * 10:47
 */
class MyQueue {

    Stack<Integer> stack;

    public MyQueue() {
        stack = new Stack<>();
    }

    public void push(int x) {
        stack.add(x);
    }

    public int pop() {
        return stack.remove(0);
    }


    public int peek() {
        return stack.get(0);
    }


    public boolean empty() {
        return stack.isEmpty();
    }
}
