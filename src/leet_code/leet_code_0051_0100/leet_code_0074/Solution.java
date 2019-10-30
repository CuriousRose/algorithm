package leet_code.leet_code_0051_0100.leet_code_0074;

class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] matrix = new int[][]{
                {1, 3, 5, 7},
                {10, 11, 16, 20},
                {23, 30, 34, 50}
        };
        System.out.println(solution.searchMatrix(matrix, 3));
    }

    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0) {
            return false;
        }
        if (matrix[0].length == 0) {
            return false;
        }
        int m = matrix.length;
        int n = matrix[0].length;
        if (matrix[m - 1][n - 1] < target) {
            return false;
        }
        int i = 0;
        int j = 0;
        while (matrix[i][j] < target) {
            if (i < m - 1 && matrix[i + 1][j] <= target) {
                i++;
                continue;
            }
            if (j < n - 1 && matrix[i][j + 1] <= target) {
                j++;
                continue;
            }
            return false;
        }
        if (matrix[i][j] == target) {
            return true;
        } else {
            return false;
        }
    }
}