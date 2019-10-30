package leet_code.leet_code_0251_0300.leet_code_0261;

import java.util.ArrayList;
import java.util.List;

/**
 * @author chj
 * @date 2019/8/7 10:08
 * 图论 遍历
 * 10:40
 */
class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] edges = new int[][]{
                {0, 1}, {1, 2}, {2, 3}, {1, 3}, {1, 4}
        };
        System.out.println(solution.validTree(5, edges));
    }

    public boolean validTree(int n, int[][] edges) {
        Node[] nodes = new Node[n];
        for (int i = 0; i < n; i++) {
            nodes[i] = new Node(i);
        }
        for (int i = 0; i < edges.length; i++) {
            int a = edges[i][0];
            int b = edges[i][1];
            nodes[a].link.add(nodes[b]);
            nodes[b].link.add(nodes[a]);
        }
        mark = new boolean[n];
        return calc(nodes[0], -1) == n;
    }

    boolean[] mark;

    int calc(Node node, int p) {
        int count = 1;
        mark[node.val] = true;
        for (Node link : node.link) {
            if (link.val == p) {
                continue;
            }
            if (mark[link.val]) {
                return -1;
            }
            count += calc(link, node.val);
        }
        return count;
    }

    static class Node {
        int val;
        List<Node> link = new ArrayList<>();

        Node(int val) {
            this.val = val;
        }
    }
}
