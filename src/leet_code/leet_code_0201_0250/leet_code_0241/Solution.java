package leet_code.leet_code_0201_0250.leet_code_0241;

import java.util.ArrayList;
import java.util.List;

/**
 * @author chj
 * @date 2019/7/4 11:25
 * 模拟 分治
 * 11:55
 */
class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        for (int i : solution.diffWaysToCompute("2*3-4*5")) {
            System.out.print(i + " ");
        }

    }

    List<Integer> result = new ArrayList<>();

    public List<Integer> diffWaysToCompute(String input) {
        List<Integer> numbers = new ArrayList<>();
        List<Character> symbols = new ArrayList<>();
        int index = 0;
        while (index < input.length()) {
            char c = input.charAt(index);
            if (c >= '0' && c <= '9') {
                int j = 1;
                while (index + j < input.length() && input.charAt(index + j) >= '0' && input.charAt(index + j) <= '9') {
                    j++;
                }
                numbers.add(Integer.parseInt(input.substring(index, index + j)));
                index = index + j;
            } else {
                symbols.add(c);
                index++;
            }
        }
        return calc(numbers, symbols);
    }

    List<Integer> calc(List<Integer> numbers, List<Character> symbols) {
        if (numbers.size() == 1) {
            return numbers;
        }
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i < numbers.size(); i++) {
            List<Integer> left = calc(numbers.subList(0, i), symbols.subList(0, i - 1));
            List<Integer> right = calc(numbers.subList(i, numbers.size()), symbols.subList(i, symbols.size()));
            char c = symbols.get(i - 1);
            for (int l : left) {
                for (int r : right) {
                    if (c == '+') {
                        list.add(l + r);
                    }
                    if (c == '-') {
                        list.add(l - r);
                    }
                    if (c == '*') {
                        list.add(l * r);
                    }
                }
            }
        }
        return list;
    }
}