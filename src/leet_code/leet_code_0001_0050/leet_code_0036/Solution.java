package leet_code.leet_code_0001_0050.leet_code_0036;

class Solution {
    public boolean isValidSudoku(char[][] board) {
        for (int i = 0; i < 9; i++) {
            boolean m1[] = new boolean[9];
            boolean m2[] = new boolean[9];
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    int k = board[i][j] - '1';
                    if (m1[k]) {
                        return false;
                    } else {
                        m1[k] = true;
                    }
                }

                if (board[j][i] != '.') {
                    int k = board[j][i] - '1';
                    if (m2[k]) {
                        return false;
                    } else {
                        m2[k] = true;
                    }
                }
            }
        }

        for (int i = 0; i < 9; i += 3) {
            for (int j = 0; j < 9; j += 3) {
                boolean m[] = new boolean[9];
                for (int x = 0; x < 3; x++) {
                    for (int y = 0; y < 3; y++) {
                        if (board[i + x][j + y] != '.') {
                            int k = board[i + x][j + y] - '1';
                            if (m[k]) {
                                return false;
                            } else {
                                m[k] = true;
                            }
                        }
                    }
                }
            }
        }
        return true;
    }
}