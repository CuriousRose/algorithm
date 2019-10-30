package leet_code.leet_code_0001_0050.leet_code_0048;

class Solution {
    public void rotate(int[][] matrix) {
        int n = matrix.length - 1;
        for (int i = 0; i <= (n - 1) / 2; i++) {
            for (int j = 0; j <= n / 2; j++) {
                int[] xs = new int[]{i, j, n - i, n - j};
                int[] ys = new int[]{j, n - i, n - j, i};
                int k = matrix[i][j];
                matrix[xs[0]][ys[0]] = matrix[xs[3]][ys[3]];
                matrix[xs[3]][ys[3]] = matrix[xs[2]][ys[2]];
                matrix[xs[2]][ys[2]] = matrix[xs[1]][ys[1]];
                matrix[xs[1]][ys[1]] = k;
            }
        }
    }
}
