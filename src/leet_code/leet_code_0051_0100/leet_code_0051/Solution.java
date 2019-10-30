package leet_code.leet_code_0051_0100.leet_code_0051;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        for (List<String> list : solution.solveNQueens(4)) {
            for (String str : list) {
                System.out.println(str);
            }
            System.out.println();
        }
    }

    List<List<String>> result = new ArrayList<>();
    char[][] map;
    int[][] mark;
    int[] xs;
    int[] ys;

    public List<List<String>> solveNQueens(int n) {
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
            List<String> item = new ArrayList<>();
            for (char[] cs : map) {
                item.add(String.valueOf(cs));
            }
            result.add(item);
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