package leet_code.leet_code_0101_0150.leet_code_0130;

import java.util.*;

class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        char[][] board = new char[][]{
                {'X', 'X', 'X', 'X'},
                {'X', 'O', 'O', 'X'},
                {'X', 'X', 'O', 'X'},
                {'X', 'O', 'X', 'X'}
        };
        solution.solve(board);
        for (char[] chars : board) {
            System.out.println(chars);
        }
    }

    public void solve(char[][] board) {
        if (board.length == 0) {
            return;
        }
        int m = board.length;
        if (board[0].length == 0) {
            return;
        }
        int n = board[0].length;
        boolean[][] alive = new boolean[m][n];

        int[] px = new int[]{1, -1, 0, 0};
        int[] py = new int[]{0, 0, 1, -1};

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'O' && !alive[i][j]) {
                    boolean[][] mark = new boolean[m][n];
                    Queue<Node> queue = new LinkedList<>();
                    List<Node> record = new ArrayList<>();
                    Node node = new Node(i, j);
                    queue.add(node);
                    record.add(node);

                    boolean success = false;
                    while (!queue.isEmpty()) {
                        node = queue.poll();
                        for (int k = 0; k < 4; k++) {
                            int x = node.x + px[k];
                            int y = node.y + py[k];
                            if (x < 0 || x >= m || y < 0 || y >= n) {
                                success = true;
                                break;
                            }
                            if (mark[x][y] || board[x][y] == 'X') {
                                continue;
                            }
                            if (alive[x][y]) {
                                success = true;
                                break;
                            }
                            Node next = new Node(x, y);
                            mark[x][y] = true;
                            queue.add(next);
                            record.add(next);
                        }
                        if (success) {
                            break;
                        }
                    }

                    if (success) {
                        for (Node item : record) {
                            alive[item.x][item.y] = true;
                        }
                    } else {
                        for (Node item : record) {
                            board[item.x][item.y] = 'X';
                        }
                    }
                }
            }
        }
    }

    class Node {
        int x;
        int y;

        Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}