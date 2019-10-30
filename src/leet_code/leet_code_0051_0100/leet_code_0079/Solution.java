package leet_code.leet_code_0051_0100.leet_code_0079;

class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
//        char[][] board = new char[][]{
//                {'A', 'B', 'C', 'E'},
//                {'S', 'F', 'C', 'S'},
//                {'A', 'D', 'E', 'E'},
//        };
        char[][] board = new char[][]{
                {'a', 'a'},
        };
        String word = "aaa";
        System.out.println(solution.exist(board, word));
    }

    boolean mark[][];
    int m;
    int n;
    char[] aim;
    int[] px = new int[]{-1, 1, 0, 0};
    int[] py = new int[]{0, 0, -1, 1};
    boolean success;
    char[][] map;

    public boolean exist(char[][] board, String word) {
        if (word.length() == 0) {
            return true;
        }
        if (board.length == 0) {
            return false;
        }
        m = board.length;
        n = board[0].length;
        map = board;

        aim = word.toCharArray();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (map[i][j] == aim[0]) {
                    mark = new boolean[m][n];
                    mark[i][j] = true;
                    dfs(i, j, 1);
                }
            }
        }

        return success;
    }

    void dfs(int i, int j, int index) {
        System.out.println(i + ":" + j + "," + index);
        if (index == aim.length) {
            success = true;
            return;
        }
        if (success) {
            return;
        }
        for (int k = 0; k < 4; k++) {
            int x = i + px[k];
            int y = j + py[k];
            if (x < 0 || x >= m || y < 0 || y >= n) {
                continue;
            }
            if (mark[x][y]) {
                continue;
            }
            if (map[x][y] != aim[index]) {
                continue;
            }
            mark[x][y] = true;
            dfs(x, y, index + 1);
            mark[x][y] = false;
        }
    }
}