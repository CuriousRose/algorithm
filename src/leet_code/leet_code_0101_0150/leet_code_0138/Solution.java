package leet_code.leet_code_0101_0150.leet_code_0138;

import java.util.ArrayList;
import java.util.List;

/**
 * 链表
 * 深拷贝
 */
class Solution {
    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }
        List<Node> nodes = new ArrayList<>();
        List<Integer> values = new ArrayList<>();
        Node node = head;
        int index = 0;
        while (node != null) {
            Node clone = new Node();
            clone.val = node.val;
            nodes.add(clone);
            node.val = index++;
            node = node.next;
        }

        index = 0;
        node = head;
        while (node != null) {
            Node clone = nodes.get(index++);
            if (node.next != null) {
                clone.next = nodes.get(node.next.val);
            }
            if (node.random != null) {
                clone.random = nodes.get(node.random.val);
            }
            node = node.next;
        }
        return nodes.get(0);
    }
}

class Node {
    public int val;
    public Node next;
    public Node random;

    public Node() {
    }

    public Node(int _val, Node _next, Node _random) {
        val = _val;
        next = _next;
        random = _random;
    }
}