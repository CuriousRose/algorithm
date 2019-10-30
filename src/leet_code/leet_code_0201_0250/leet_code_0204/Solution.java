package leet_code.leet_code_0201_0250.leet_code_0204;

/**
 * 数学 打表
 */
class Solution {
    public int countPrimes(int n) {
        if (n < 2) {
            return 0;
        }
        boolean[] mark = new boolean[n];
        int count = 0;
        for (int i = 2; i < n; i++) {
            if (mark[i]) {
                continue;
            }
            for (int j = 2; i * j < n; j++) {
                if (!mark[i * j]) {
                    mark[i * j] = true;
                    count++;
                }
            }
        }
        return n - count - 2;
    }
}