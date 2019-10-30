package leet_code.leet_code_0201_0250.leet_code_0227;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author chj
 * @date 2019/7/1 9:55
 * 逆波兰式 栈
 * 10:15
 */
class Solution {
    public int calculate(String s) {
        List<Node> expressions = new ArrayList<>();
        Stack<Node> symbols = new Stack<>();
        int index = 0;
        while (index < s.length()) {
            char c = s.charAt(index);
            if (c == ' ') {
                index++;
                continue;
            }
            if (c >= '0' && c <= '9') {
                int len = 1;
                while (index + len < s.length() && s.charAt(index + len) >= '0' && s.charAt(index + len) <= '9') {
                    len++;
                }
                expressions.add(new Node(Integer.parseInt(s.substring(index, index + len))));
                index += len;
            } else {
                if (c == '*' || c == '/') {
                    while (!symbols.isEmpty() && (symbols.peek().symbol == '*' || symbols.peek().symbol == '/')) {
                        expressions.add(symbols.pop());
                    }
                    symbols.add(new Node(c));
                } else {
                    while (!symbols.isEmpty()) {
                        expressions.add(symbols.pop());
                    }
                    symbols.add(new Node(c));
                }
                index++;
            }
        }
        while (!symbols.isEmpty()) {
            expressions.add(symbols.pop());
        }
        Stack<Integer> calcs = new Stack<>();
        for (Node node : expressions) {
            if (node.mark) {
                calcs.add(node.number);
            } else {
                int b = calcs.pop();
                int a = calcs.pop();
                if (node.symbol == '+') {
                    calcs.add(a + b);
                }
                if (node.symbol == '-') {
                    calcs.add(a - b);
                }
                if (node.symbol == '*') {
                    calcs.add(a * b);
                }
                if (node.symbol == '/') {
                    calcs.add(a / b);
                }
            }
        }
        return calcs.pop();
    }

    class Node {
        boolean mark;
        int number;
        char symbol;

        Node(int number) {
            mark = true;
            this.number = number;
        }

        Node(char symbol) {
            mark = false;
            this.symbol = symbol;
        }
    }
}