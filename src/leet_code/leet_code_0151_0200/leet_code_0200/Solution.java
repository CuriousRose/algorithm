package leet_code.leet_code_0151_0200.leet_code_0200;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 搜索
 */
class Solution {

    public int numIslands(char[][] grid) {
        int m = grid.length;
        if (m == 0) {
            return 0;
        }
        int n = grid[0].length;
        if (n == 0) {
            return 0;
        }
        boolean[][] mark = new boolean[m][n];
        int[] px = new int[]{1, -1, 0, 0};
        int[] py = new int[]{0, 0, 1, -1};
        Queue<Integer> qx = new LinkedList<>();
        Queue<Integer> qy = new LinkedList<>();
        int count = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '0' || mark[i][j]) {
                    continue;
                }
                count++;
                qx.add(i);
                qy.add(j);
                while (!qx.isEmpty()) {
                    int x = qx.poll();
                    int y = qy.poll();
                    for (int k = 0; k < 4; k++) {
                        int xx = x + px[k];
                        int yy = y + py[k];
                        if (xx < 0 || xx >= m || yy < 0 || yy >= n) {
                            continue;
                        }
                        if (mark[xx][yy]) {
                            continue;
                        }
                        if (grid[xx][yy] == '0') {
                            continue;
                        }
                        mark[xx][yy] = true;
                        qx.add(xx);
                        qy.add(yy);
                    }
                }
            }
        }
        return count;
    }
}
