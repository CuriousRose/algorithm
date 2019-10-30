package leet_code.leet_code_0251_0300.leet_code_0282;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author chj
 * @date 2019/8/14 11:04
 */
class Solution {
    static int count = 0;
    static int hit = 0;

    public static void main(String[] args) {
        Solution solution = new Solution();
        for (String item : solution.addOperators("1111111111", 111111111)) {
            System.out.println(item);
        }
        System.out.println(count);
        System.out.println(hit);
    }

    List<String> result = new ArrayList<>();

    Record[][] records;

    public List<String> addOperators(String num, int target) {
        int len = num.length();
        records = new Record[len][len];
        calc(num, 0, len - 1);
        Record record = records[0][len - 1];
        for (Expression ex : record.map.values()) {
            if (ex.value == target) {
                result.add(ex.getValue());
            }
        }
        return result;
    }

    /**
     * 记忆化搜索
     *
     * @param num
     * @param l
     * @param r
     * @return
     */
    Record calc(String num, int l, int r) {
//        System.out.println(num + " " + l + " " + r);
        if (records[l][r] != null) {
            return records[l][r];
        }

        Record record = new Record(l, r);
        String str = num.substring(l, r + 1);
        if (str.length() == 1) {
            Expression expression = new Expression(Long.parseLong(str));
            record.add(expression);
        } else {
            if (!str.startsWith("0")) {
                Expression expression = new Expression(Long.parseLong(str));
                record.add(expression);
            }
        }

        for (int m = l + 1; m <= r; m++) {
            Record r1 = calc(num, l, m - 1);
            Record r2 = calc(num, m, r);
            for (Expression ex1 : r1.map.values()) {
                for (Expression ex2 : r2.map.values()) {
                    {
                        Expression ex = new Expression(ex1, ex2, '+');
                        record.add(ex);
                        count++;
                    }
                    {
                        Expression ex = new Expression(ex1, ex2, '-');
                        record.add(ex);
                        count++;
                    }
                    if (!ex1.level0 && !ex2.level0) {
                        Expression ex = new Expression(ex1, ex2, '*');
                        record.add(ex);
                        count++;
                    }
                }
            }
        }
        records[l][r] = record;
//        record.output();
        return record;
    }

    /**
     * 记录
     */
    class Record {
        int l, r;
        Map<String, Expression> map;

        Record(int l, int r) {
            this.l = l;
            this.r = r;
            map = new HashMap<>();
        }

        void add(Expression expression) {
            String key = expression.getValue();
            if (map.containsKey(key)) {
                hit++;
            }
            map.put(key, expression);
        }

        void output() {
            System.out.println(l + " " + r);
            for (Expression ex : map.values()) {
                System.out.println(ex.getValue() + "=" + ex.value);
            }
        }
    }

    /**
     * 表达式
     */
    class Expression {
        List<Node> nodeList;
        long value;
        boolean level0;

        Expression(long number) {
            Node node = new Node(number);
            nodeList = new ArrayList<>();
            nodeList.add(node);
            this.value = number;
        }

        Expression(Expression ex1, Expression ex2, char operator) {
            this.level0 = ex1.level0 || ex2.level0;

            if (operator == '+') {
                nodeList = new ArrayList<>();
                nodeList.addAll(ex1.nodeList);
                nodeList.add(new Node(operator));
                nodeList.addAll(ex2.nodeList);
                this.value = ex1.value + ex2.value;
                this.level0 = true;
            }

            if (operator == '-') {
                nodeList = new ArrayList<>();
                nodeList.addAll(ex1.nodeList);
                nodeList.add(new Node(operator));
                for (Node node : ex2.nodeList) {
                    if (node.isOperator) {
                        nodeList.add(node.getReverse());
                    } else {
                        nodeList.add(node);
                    }
                }
                this.value = ex1.value - ex2.value;
                this.level0 = true;

            }

            if (operator == '*') {
                nodeList = new ArrayList<>();
                nodeList.addAll(ex1.nodeList);
                nodeList.add(new Node(operator));
                nodeList.addAll(ex2.nodeList);
                this.value = ex1.value * ex2.value;
            }
        }

        String getValue() {
            StringBuffer buffer = new StringBuffer();
            for (Node node : nodeList) {
                buffer.append(node.getValue());
            }
            return buffer.toString();
        }
    }

    /**
     * 运算节点
     */
    class Node {
        boolean isNumber;
        boolean isOperator;
        long number;
        char operator;

        Node(long number) {
            this.isNumber = true;
            this.number = number;
        }

        Node(char operator) {
            this.isOperator = true;
            this.operator = operator;
        }

        Node getReverse() {
            if (operator == '+') {
                return new Node('-');
            }
            if (operator == '-') {
                return new Node('+');
            }
            return new Node(operator);
        }

        String getValue() {
            if (isNumber) {
                return String.valueOf(number);
            } else {
                return String.valueOf(operator);
            }
        }
    }
}