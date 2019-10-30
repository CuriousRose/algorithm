package leet_code.leet_code_0051_0100.leet_code_0054;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int matrix[][] = new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        for (int i : solution.spiralOrder(matrix)) {
            System.out.print(i + " ");
        }
    }

    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> list = new ArrayList<>();
        if (matrix.length == 0) {
            return list;
        }
        int m = matrix.length;
        int n = matrix[0].length;
        int left = 0;
        int right = n - 1;
        int top = 0;
        int button = m - 1;

        int[] px = new int[]{0, 1, 0, -1};
        int[] py = new int[]{1, 0, -1, 0};

        int k = 0;
        int x = 0;
        int y = -1;

        while (left <= right && top <= button) {
            while (x + px[k] >= top && x + px[k] <= button
                    && y + py[k] >= left && y + py[k] <= right) {
                x += px[k];
                y += py[k];
                list.add(matrix[x][y]);
            }
            if (k == 0) {
                top++;
            }
            if (k == 1) {
                right--;
            }
            if (k == 2) {
                button--;
            }
            if (k == 3) {
                left++;
            }
            k++;
            k %= 4;
        }
        return list;
    }
}
