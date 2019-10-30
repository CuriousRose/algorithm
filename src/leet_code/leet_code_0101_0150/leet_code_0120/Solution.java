package leet_code.leet_code_0101_0150.leet_code_0120;

import java.util.List;

class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        if (triangle.size() == 0) {
            return 0;
        }
        List<Integer> next = triangle.get(triangle.size() - 1);
        for (int i = triangle.size() - 2; i >= 0; i--) {
            List<Integer> current = triangle.get(i);
            for (int j = 0; j < triangle.get(i).size(); j++) {
                current.set(j, Math.min(next.get(j), next.get(j + 1)) + current.get(j));
            }
            next = current;
        }
        return next.get(0);
    }
}