package leet_code.leet_code_0151_0200.leet_code_0166;

import java.util.HashMap;
import java.util.Map;

/**
 * 数学 除法
 */
class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.fractionToDecimal(-2147483648, -1));
    }

    public String fractionToDecimal(int numerator, int denominator) {
        long a = numerator;
        long b = denominator;
        if (a % b == 0) {
            return String.valueOf(a / b);
        }
        StringBuffer buffer = new StringBuffer();

        buffer.append(a * b > 0 ? "" : "-");
        a = Math.abs((long) numerator);
        b = Math.abs((long) denominator);
        buffer.append(a / b).append('.');
        a %= b;
        Map<Long, Integer> map = new HashMap<>();
        int index = -1;
        while (a != 0) {
            long m = a % b;
            if (map.containsKey(m)) {
                index = map.get(m);
                break;
            } else {
                map.put(m, buffer.length());
            }
            a *= 10;
            long c = a / b;
            buffer.append(c);
            a %= b;
        }
        String s = buffer.toString();
        if (index == -1) {
            return s;
        } else {
            return String.format("%s(%s)", s.substring(0, index), s.substring(index));
        }
    }
}