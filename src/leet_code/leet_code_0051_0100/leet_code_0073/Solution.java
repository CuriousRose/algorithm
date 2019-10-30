package leet_code.leet_code_0051_0100.leet_code_0073;


class Solution {
    public void setZeroes(int[][] matrix) {
        if (matrix.length == 0) {
            return;
        }
        int m = matrix.length;
        int n = matrix[0].length;
        boolean[] line = new boolean[m];
        boolean[] row = new boolean[n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    line[i] = true;
                    row[j] = true;
                }
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (line[i] || row[j]) {
                    matrix[i][j] = 0;
                }
            }
        }
    }
}