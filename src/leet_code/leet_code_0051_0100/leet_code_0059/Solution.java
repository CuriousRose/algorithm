package leet_code.leet_code_0051_0100.leet_code_0059;

class Solution {
    public int[][] generateMatrix(int n) {
        int[][] map = new int[n][n];
        int top = 0;
        int left = 0;
        int right = n - 1;
        int button = n - 1;
        int[] px = new int[]{0, 1, 0, -1};
        int[] py = new int[]{1, 0, -1, 0};

        int index = 0;
        int x = 0;
        int y = -1;
        int k = 0;

        while (top <= button && left <= right) {
            while (x + px[k] >= top && x + px[k] <= button
                    && y + py[k] >= left && y + py[k] <= right) {
                x += px[k];
                y += py[k];
                index++;
                map[x][y] = index;
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
        return map;
    }
}