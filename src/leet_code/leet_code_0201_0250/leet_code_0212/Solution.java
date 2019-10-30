package leet_code.leet_code_0201_0250.leet_code_0212;

import java.util.ArrayList;
import java.util.List;

/**
 * 前缀树 深度优先搜索
 */
class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
//        char[][] board = new char[][]{
//                {'o', 'a', 'a', 'n'},
//                {'e', 't', 'a', 'e'},
//                {'i', 'h', 'k', 'r'},
//                {'i', 'f', 'l', 'v'},
//        };
//        String[] words = new String[]{"oath", "pea", "eat", "rain"};

        char[][] board = new char[][]{
                {'a', 'b'},
                {'a', 'a'}
        };
        String[] words = new String[]{"aba", "baa", "bab", "aaab", "aaa", "aaaa", "aaba"};


        for (String s : solution.findWords(board, words)) {
            System.out.println(s);
        }
    }

    int m, n;
    List<String> result = new ArrayList<>();
    Tire tire = new Tire();

    public List<String> findWords(char[][] board, String[] words) {
        m = board.length;
        if (m == 0) {
            return result;
        }
        n = board[0].length;
        if (n == 0) {
            return result;
        }
        if (words.length == 0) {
            return result;
        }
        for (String word : words) {
            tire.insert(word);
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                mark = new boolean[m][n];
                dfs(board, i, j, "");
            }
        }
        return result;
    }

    boolean[][] mark;
    int[] px = new int[]{-1, 1, 0, 0};
    int[] py = new int[]{0, 0, -1, 1};

    void dfs(char[][] board, int x, int y, String prefix) {
        String word = prefix + board[x][y];
        int match = tire.search(word);
        if (match == 0) {
            tire.remove(word);
            result.add(word);
        }
        if (match == -1) {
            return;
        }

        mark[x][y] = true;
        for (int i = 0; i < 4; i++) {
            int xx = x + px[i];
            int yy = y + py[i];
            if (xx < 0 || xx >= m || yy < 0 || yy >= n) {
                continue;
            }
            if (mark[xx][yy]) {
                continue;
            }
            dfs(board, xx, yy, word);
        }
        mark[x][y] = false;
    }
}

class Tire {
    Node root;

    Tire() {
        root = new Node(' ');
    }

    void insert(String word) {
        Node node = root;
        for (char c : word.toCharArray()) {
            int index = c - 'a';
            if (node.list[index] == null) {
                node.list[index] = new Node(c);
            }
            node = node.list[index];
            node.sub++;
        }
        node.end = true;
    }

    int search(String word) {
        Node node = root;
        for (char c : word.toCharArray()) {
            int index = c - 'a';
            if (node.list[index] == null) {
                return -1;
            }
            node = node.list[index];
        }
        if (node.end) {
            return 0;
        } else {
            return 1;
        }
    }

    void remove(String word) {
        Node node = root;
        for (char c : word.toCharArray()) {
            int index = c - 'a';
            node.list[index].sub--;
            if (node.list[index].sub == 0) {
                node.list[index] = null;
                return;
            }
            node = node.list[index];
        }
        node.end = false;
    }
}

class Node {
    char c;
    boolean end;
    int sub;
    Node[] list = new Node[26];

    Node(char c) {
        this.c = c;
    }
}