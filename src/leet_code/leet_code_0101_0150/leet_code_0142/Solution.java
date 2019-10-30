package leet_code.leet_code_0101_0150.leet_code_0142;

import java.util.HashSet;
import java.util.Set;

/**
 * 链表 哈希
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }
        ListNode node = head;
        Set<ListNode> set = new HashSet<>();
        while (node != null) {
            if (set.contains(node)) {
                return node;
            } else {
                set.add(node);
            }
            node = node.next;
        }
        return null;
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }
}