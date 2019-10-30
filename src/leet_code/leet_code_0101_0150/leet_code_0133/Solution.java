package leet_code.leet_code_0101_0150.leet_code_0133;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Solution {
    public Node cloneGraph(Node node) {
        if (node == null) {
            return null;
        }

        Queue<Node> nodeQueue = new LinkedList<>();
        Queue<Node> cloneQueue = new LinkedList<>();
        Node[] record = new Node[101];

        Node clone = new Node();
        clone.val = node.val;
        clone.neighbors = new ArrayList<>();
        record[clone.val] = clone;
        Node head = clone;

        nodeQueue.add(node);
        cloneQueue.add(clone);

        while (!nodeQueue.isEmpty()) {
            node = nodeQueue.poll();
            clone = cloneQueue.poll();

            for (Node link : node.neighbors) {
                int val = link.val;
                if (record[val] == null) {
                    record[val] = new Node();
                    record[val].val = val;
                    record[val].neighbors = new ArrayList<>();
                    nodeQueue.add(link);
                    cloneQueue.add(record[val]);
                }
                clone.neighbors.add(record[val]);
            }
        }
        return head;
    }
}

class Node {
    public int val;
    public List<Node> neighbors;

    public Node() {
    }

    public Node(int _val, List<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}