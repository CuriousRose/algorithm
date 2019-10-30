package leet_code.leet_code_0201_0250.leet_code_0224;


import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author chj
 * @date 2019/6/28 11:38
 * 逆波兰式 栈
 * 13:29
 */
class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.calculate("(1+(4+5+2)-3)+(6+8)"));
    }

    public int calculate(String s) {
        Stack<Node> symbles = new Stack<>();
        List<Node> expression = new ArrayList<>();
        int i = 0;
        while (i < s.length()) {
            char c = s.charAt(i);
            if (c == ' ') {
                i++;
                continue;
            }
            if (c >= '0' && c <= '9') {
                int j = i + 1;
                while (j < s.length() && s.charAt(j) >= '0' && s.charAt(j) <= '9') {
                    j++;
                }
                expression.add(new Node(Integer.parseInt(s.substring(i, j))));
                i = j;
                continue;
            } else if (c == ')') {
                Node node = symbles.pop();
                while (node.symbol != '(') {
                    expression.add(node);
                    node = symbles.pop();
                }
            } else {
                if (c != '(') {
                    while (!symbles.isEmpty() && symbles.peek().symbol != '(') {
                        expression.add(symbles.pop());
                    }
                }
                symbles.add(new Node(c));
            }
            i++;
        }
        while (!symbles.isEmpty()) {
            expression.add(symbles.pop());
        }
        Stack<Integer> calcs = new Stack<>();
        for (Node node : expression) {
            if (node.mark) {
                calcs.push(node.num);
            } else {
                int b = calcs.pop();
                int a = calcs.pop();
                if (node.symbol == '+') {
                    calcs.push(a + b);
                }
                if (node.symbol == '-') {
                    calcs.push(a - b);
                }
            }
        }
        return calcs.pop();
    }

    class Node {
        boolean mark;
        int num;
        char symbol;

        Node(int num) {
            this.mark = true;
            this.num = num;
        }

        Node(char symbol) {
            this.mark = false;
            this.symbol = symbol;
        }

        void out() {
            if (mark) {
                System.out.println(num);
            } else {
                System.out.println(symbol);
            }
        }
    }
}