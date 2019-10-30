package leet_code.leet_code_0051_0100.leet_code_0089;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        for (int i : solution.grayCode(1)) {
            System.out.print(i + " ");
        }
    }

    public List<Integer> grayCode(int n) {
        List<Integer> result = new ArrayList<>();
        int sum = 0;
        result.add(sum);
        if (n == 0) {
            return result;
        }
        int len = 1 << n;
        int[] step = new int[len];
        int p = 1;
        while (p < len) {
            step[p] = p;
            p <<= 1;
        }
        int m = 1;
        for (int i = 1; i < len; i++) {
            if (step[i] != 0) {
                m = i;
            } else {
                step[i] = -step[m * 2 - i];
            }
            sum += step[i];
            result.add(sum);
        }
        return result;
    }
}