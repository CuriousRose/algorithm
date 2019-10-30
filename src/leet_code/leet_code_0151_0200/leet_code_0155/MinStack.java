package leet_code.leet_code_0151_0200.leet_code_0155;


import java.util.ArrayList;
import java.util.List;

/**
 * 栈
 */
class MinStack {

    List<Integer> list = new ArrayList<>();

    public MinStack() {
    }

    public void push(int x) {
        list.add(x);
    }

    public void pop() {
        list.remove(list.size() - 1);
    }

    public int top() {
        return list.get(list.size() - 1);
    }

    public int getMin() {
        int min = Integer.MAX_VALUE;
        for (int i : list) {
            min = Math.min(min, i);
        }
        return min;
    }
}