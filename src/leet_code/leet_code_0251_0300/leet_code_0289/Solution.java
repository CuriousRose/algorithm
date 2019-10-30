package leet_code.leet_code_0251_0300.leet_code_0289;

/**
 * @author chj
 * @date 2019/8/19 10:05
 * 模拟 图
 * 10:15
 */
class Solution {
    public void gameOfLife(int[][] board) {
        int m = board.length;
        if (m == 0) {
            return;
        }
        int n = board[0].length;
        int[][] next = new int[m][n];
        int[] px = {-1, -1, -1, 0, 0, 1, 1, 1};
        int[] py = {-1, 0, 1, -1, 1, -1, 0, 1};
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int count = 0;
                for (int k = 0; k < 8; k++) {
                    int x = i + px[k];
                    int y = j + py[k];
                    if (x < 0 || x >= m || y < 0 || y >= n) {
                        continue;
                    }
                    count += board[x][y];
                }
                if (board[i][j] == 0) {
                    if (count == 3) {
                        next[i][j] = 1;
                    } else {
                        next[i][j] = 0;
                    }
                } else {
                    if (count < 2 || count > 3) {
                        next[i][j] = 0;
                    } else {
                        next[i][j] = 1;
                    }
                }
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = next[i][j];
            }
        }
    }
}