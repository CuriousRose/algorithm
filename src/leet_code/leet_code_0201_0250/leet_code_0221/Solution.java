package leet_code.leet_code_0201_0250.leet_code_0221;

/**
 * @author chj
 * @date 2019/6/28 10:47
 * 模拟 暴力 搜索
 */
class Solution {
    public int maximalSquare(char[][] matrix) {
        int max = 0;
        int m = matrix.length;
        if (m == 0) {
            return 0;
        }
        int n = matrix[0].length;
        if (n == 0) {
            return 0;
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == '1') {
                    int l = 1;
                    int x = i + 1;
                    int y = j + 1;
                    while (x < m && y < n) {
                        if (matrix[x][y] != '1') {
                            break;
                        }
                        int count = 0;
                        for (int k = j; k < y; k++) {
                            if (matrix[x][k] == '1') {
                                count++;
                            }
                        }
                        if (count != l) {
                            break;
                        }
                        count = 0;
                        for (int k = i; k < x; k++) {
                            if (matrix[k][y] == '1') {
                                count++;
                            }
                        }
                        if (count != l) {
                            break;
                        }
                        l++;
                        x++;
                        y++;
                    }
                    max = Math.max(max, l * l);
                }
            }
        }
        return max;
    }
}
