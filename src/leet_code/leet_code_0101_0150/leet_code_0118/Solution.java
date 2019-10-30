package leet_code.leet_code_0101_0150.leet_code_0118;

import java.util.ArrayList;
import java.util.List;

class Solution {
    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> generate(int numRows) {
        if (numRows == 0) {
            return result;
        }
        List<Integer> before = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            List<Integer> current = new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i) {
                    current.add(1);
                    continue;
                }
                current.add(before.get(j - 1) + before.get(j));
            }
            result.add(current);
            before = current;
        }
        return result;
    }
}