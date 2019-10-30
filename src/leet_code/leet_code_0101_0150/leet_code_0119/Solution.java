package leet_code.leet_code_0101_0150.leet_code_0119;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> before = new ArrayList<>();
        for (int i = 0; i <= rowIndex; i++) {
            List<Integer> current = new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i) {
                    current.add(1);
                    continue;
                }
                current.add(before.get(j - 1) + before.get(j));
            }
            before = current;
        }
        return before;
    }
}
