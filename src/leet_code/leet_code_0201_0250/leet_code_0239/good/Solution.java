package leet_code.leet_code_0201_0250.leet_code_0239.good;

/**
 * @author chj
 * @date 2019/7/4 11:07
 * 模拟
 * 11:15
 */
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        if (m == 0) {
            return false;
        }
        int n = matrix[0].length;
        if (n == 0) {
            return false;
        }
        int x = m - 1;
        int y = 0;
        while (x >= 0 && y < n) {
            if (matrix[x][y] == target) {
                return true;
            }
            if (matrix[x][y] > target) {
                x--;
            } else {
                y++;
            }
        }
        return false;
    }
}
