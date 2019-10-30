package leet_code.leet_code_0251_0300.leet_code_0286;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author chj
 * @date 2019/8/15 11:23
 * 搜索(广度优先)
 */
class Solution {
    public void wallsAndGates(int[][] rooms) {
        int m = rooms.length;
        if (m == 0) {
            return;
        }
        int n = rooms[0].length;

        Queue<Integer> xq = new LinkedList<>();
        Queue<Integer> yq = new LinkedList<>();

        int[] px = {0, 0, -1, 1};
        int[] py = {-1, 1, 0, 0};

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (rooms[i][j] == 0) {
                    xq.add(i);
                    yq.add(j);
                }
            }
        }

        while (!xq.isEmpty()) {
            int x = xq.poll();
            int y = yq.poll();
            int dis = rooms[x][y] + 1;
            for (int k = 0; k < 4; k++) {
                int xx = x + px[k];
                int yy = y + py[k];
                if (xx < 0 || xx >= m) {
                    continue;
                }
                if (yy < 0 || yy >= n) {
                    continue;
                }
                if (rooms[xx][yy] == -1) {
                    continue;
                }
                if (dis < rooms[xx][yy]) {
                    rooms[xx][yy] = dis;
                    xq.add(xx);
                    yq.add(yy);
                }
            }
        }
    }
}