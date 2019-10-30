package leet_code.leet_code_0101_0150.leet_code_0117;

import java.util.ArrayList;
import java.util.List;

class Solution {

    List<Node> nodes = new ArrayList<>();

    public Node connect(Node root) {
        dfs(root, 0);
        return root;
    }

    void dfs(Node node, int floor) {
        if (node == null) {
            return;
        }
        if (nodes.size() <= floor) {
            nodes.add(node);
        } else {
            Node head = nodes.get(floor);
            head.next = node;
            nodes.set(floor, node);
        }
        dfs(node.left, floor + 1);
        dfs(node.right, floor + 1);
    }
}

class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
}