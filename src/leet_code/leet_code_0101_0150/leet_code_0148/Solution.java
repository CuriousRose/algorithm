package leet_code.leet_code_0101_0150.leet_code_0148;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * 链表 排序(快速排序)
 */
class Solution {
    public ListNode sortList(ListNode head) {
        List<ListNode> nodes = new ArrayList<>();
        while (head != null) {
            nodes.add(head);
            head = head.next;
        }
        nodes.sort(new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                return o1.val - o2.val;
            }
        });
        ListNode link = new ListNode(0);
        head = link;
        for (ListNode node : nodes) {
            link.next = node;
            link = node;
        }
        link.next = null;
        return head.next;
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}