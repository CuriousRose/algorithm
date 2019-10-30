package leet_code.leet_code_0051_0100.leet_code_0052;


class Solution {
    int result = 0;
    char[][] map;
    int[][] mark;
    int[] xs;
    int[] ys;

    public int totalNQueens(int n) {
        map = new char[n][n];
        mark = new int[n][n];
        xs = new int[n];
        ys = new int[n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                map[i][j] = '.';
            }
        }
        dfs(0, n);
        return result;
    }

    void dfs(int index, int n) {
        if (index == n) {
            result++;
            return;
        }
        for (int i = 0; i < n; i++) {
            if (mark[index][i] > 0) {
                continue;
            }
            map[index][i] = 'Q';
            mark(index, i, n, 1);
            dfs(index + 1, n);
            mark(index, i, n, -1);
            map[index][i] = '.';
        }
    }

    int[] px = new int[]{-1, -1, 1, 1};
    int[] py = new int[]{-1, 1, 1, -1};

    void mark(int x, int y, int n, int value) {
        for (int i = 0; i < n; i++) {
            mark[x][i] += value;
            mark[i][y] += value;
        }

        for (int k = 0; k < 4; k++) {
            int xx = x + px[k];
            int yy = y + py[k];
            while (xx >= 0 && yy >= 0 && xx < n && yy < n) {
                mark[xx][yy] += value;
                xx += px[k];
                yy += py[k];
            }
        }
    }
}