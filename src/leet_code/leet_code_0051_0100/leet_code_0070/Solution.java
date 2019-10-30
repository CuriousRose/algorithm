package leet_code.leet_code_0051_0100.leet_code_0070;

class Solution {
    public int climbStairs(int n) {
        int[] record = new int[]{1, 1};
        if (n < 2) {
            return record[n];
        }
        int mark = 0;
        for (int i = 2; i <= n; i++) {
            record[mark] = record[mark] + record[1 - mark];
            mark = 1 - mark;
        }
        return record[1 - mark];
    }
}