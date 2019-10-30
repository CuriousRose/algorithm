package leet_code.leet_code_0051_0100.leet_code_0085;

class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        char[][] matrix = new char[][]{
                {'1', '0', '1', '0', '0'},
                {'1', '0', '1', '1', '1'},
                {'1', '1', '1', '1', '1'},
                {'1', '0', '0', '1', '0'},
        };
        System.out.println(solution.maximalRectangle(matrix));
    }

    char[][] map;
    int m;
    int n;
    int max = 0;
    int[][] dl;
    int[][] dr;

    public int maximalRectangle(char[][] matrix) {
        if (matrix.length == 0) {
            return 0;
        }
        m = matrix.length;
        n = matrix[0].length;
        map = matrix;
        dl = new int[m][n];
        dr = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (map[i][j] == '0') {
                    dl[i][j] = -1;
                } else {
                    if (j > 0) {
                        if (dl[i][j - 1] >= 0) {
                            dl[i][j] = dl[i][j];
                        } else {
                            dl[i][j] = j;
                        }
                    } else {
                        dl[i][j] = j;
                    }
                }
            }
            for (int j = n - 1; j >= 0; j--) {
                if (map[i][j] == '0') {
                    dr[i][j] = -1;
                } else {
                    if (j < n - 1) {
                        if (dr[i][j + 1] >= 0) {
                            dr[i][j] = dr[i][j + 1];
                        } else {
                            dr[i][j] = j;
                        }
                    } else {
                        dr[i][j] = j;
                    }
                }
            }
        }
        for (int head = 0; head < m; head++) {
            find(head, 0, n - 1, head);
        }
        return max;
    }

    void find(int head, int left, int right, int button) {
        if (button == m) {
            return;
        }
        int nl = left;
        int nr = left;
        while (nl <= right) {
            if (map[button][nl] == '0') {
                nl++;
                continue;
            } else {
                nl = Math.max(left, dl[button][nl]);
                nr = Math.min(right, dr[button][nl]);
                max = Math.max(max, (nr - nl + 1) * (button - head + 1));
                find(head, nl, nr, button + 1);
                nl = nr + 1;
            }
        }
    }
}