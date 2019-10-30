package leet_code.leet_code_0001_0050.leet_code_0037;

class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        char[][] board = new char[][]{
                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'},
        };
        solution.solveSudoku(board);

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    int[][] map = new int[9][9];
    int[][][] mark = new int[9][9][9];
    boolean find = false;

    public void solveSudoku(char[][] board) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') {
                    map[i][j] = -1;
                    continue;
                }
                int k = board[i][j] - '1';
                put(i, j, k);
            }
        }

        dfs(0, 0);

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                board[i][j] = (char) (map[i][j] + '1');
            }
        }
    }

    void dfs(int i, int j) {
        if (i == 9) {
            find = true;
        }

        if (find) {
            return;
        }

        if (map[i][j] >= 0) {
            int ni = i;
            int nj = j + 1;
            if (nj == 9) {
                ni++;
                nj = 0;
            }
            dfs(ni, nj);
            return;
        }


        for (int k = 0; k < 9; k++) {
            if (mark[i][j][k] == 0) {
                put(i, j, k);

                int ni = i;
                int nj = j + 1;
                if (nj == 9) {
                    ni++;
                    nj = 0;
                }
                dfs(ni, nj);

                if (find) {
                    return;
                }
                remove(i, j);
            }
        }
    }

    void put(int i, int j, int k) {
        map[i][j] = k;
        for (int x = 0; x < 9; x++) {
            mark[i][x][k]++;
            mark[x][j][k]++;
        }
        for (int x = i / 3 * 3; x < i / 3 * 3 + 3; x++) {
            for (int y = j / 3 * 3; y < j / 3 * 3 + 3; y++) {
                mark[x][y][k]++;
            }
        }
    }

    void remove(int i, int j) {
        int k = map[i][j];
        map[i][j] = -1;
        for (int x = 0; x < 9; x++) {
            mark[i][x][k]--;
            mark[x][j][k]--;
        }
        for (int x = i / 3 * 3; x < i / 3 * 3 + 3; x++) {
            for (int y = j / 3 * 3; y < j / 3 * 3 + 3; y++) {
                mark[x][y][k]--;
            }
        }
    }
}