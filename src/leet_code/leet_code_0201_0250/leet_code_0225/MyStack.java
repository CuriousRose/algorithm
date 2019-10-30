package leet_code.leet_code_0201_0250.leet_code_0225;

import java.util.ArrayList;
import java.util.List;

/**
 * @author chj
 * @date 2019/7/1 9:49
 * 栈 队列
 * 09:52
 */
class MyStack {

    List<Integer> list;
    int len;

    public MyStack() {
        list = new ArrayList<>();
        len = 0;
    }

    /**
     * Push element x onto stack.
     */
    public void push(int x) {
        list.add(x);
        len++;
    }

    /**
     * Removes the element on top of the stack and returns that element.
     */
    public int pop() {
        int value = list.get(len - 1);
        list.remove(len - 1);
        len--;
        return value;
    }

    /**
     * Get the top element.
     */
    public int top() {
        return list.get(len - 1);
    }

    /**
     * Returns whether the stack is empty.
     */
    public boolean empty() {
        return list.isEmpty();
    }
}
