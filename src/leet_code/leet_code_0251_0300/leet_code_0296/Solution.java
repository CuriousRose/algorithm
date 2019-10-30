package leet_code.leet_code_0251_0300.leet_code_0296;

/**
 * @author chj
 * @date 2019/8/19 20:44
 * 压缩 双指针
 * 21:34
 */
class Solution {
    public int minTotalDistance(int[][] grid) {
        int m = grid.length;
        if (m == 0) {
            return 0;
        }
        int n = grid[0].length;
        int[] ms = new int[m];
        int[] ns = new int[n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    ms[i]++;
                    ns[j]++;
                }
            }
        }

        int sum = find(ms) + find(ns);
        return sum;
    }

    int find(int[] s) {
        int t = 0;
        int l = s[0];
        int r = 0;
        for (int i = 1; i < s.length; i++) {
            r += s[i];
            t += s[i] * i;
        }
        int min = t;
        for (int i = 1; i < s.length; i++) {
            t += l;
            t -= r;
            min = t < min ? t : min;
            l += s[i];
            r -= s[i];
        }
        return min;
    }
}