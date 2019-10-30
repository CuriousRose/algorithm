package leet_code.leet_code_0201_0250.leet_code_0240;


/**
 * @author chj
 * @date 2019/7/4 10:52
 * 搜索
 * 11:04
 */
class Solution {
    boolean[][] mark;
    int m, n;
    boolean find = false;

    public boolean searchMatrix(int[][] matrix, int target) {
        m = matrix.length;
        if (m == 0) {
            return false;
        }
        n = matrix[0].length;
        if (n == 0) {
            return false;
        }
        mark = new boolean[m][n];
        dfs(0, 0, target, matrix);
        return find;
    }

    int[] px = new int[]{1, 0};
    int[] py = new int[]{0, 1};

    void dfs(int x, int y, int aim, int[][] map) {
        if (find) {
            return;
        }
        if (map[x][y] == aim) {
            find = true;
            return;
        }
        if (map[x][y] > aim) {
            return;
        }
        for (int i = 0; i < 2; i++) {
            int xx = x + px[i];
            int yy = y + py[i];
            if (xx >= m || yy >= n) {
                continue;
            }
            if (map[xx][yy] > aim) {
                continue;
            }
            if (mark[xx][yy]) {
                continue;
            }
            mark[xx][yy] = true;
            dfs(xx, yy, aim, map);
        }
    }
}