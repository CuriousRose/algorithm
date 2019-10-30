package leet_code.leet_code_0101_0150.leet_code_0143;

import java.util.ArrayList;
import java.util.List;

/**
 * 链表 排序
 */
class Solution {
    public void reorderList(ListNode head) {
        if (head == null || head.next == null) {
            return;
        }
        List<ListNode> list = new ArrayList<>();
        ListNode node = head;
        while (node != null) {
            list.add(node);
            node = node.next;
        }
        int l = 0;
        int r = list.size();
        int mark = 0;
        node = head;
        while (l < r) {
            mark = 1 - mark;
            if (mark == 1) {
                r--;
                node.next = list.get(r);
            } else {
                l++;
                node.next = list.get(l);
            }
            node = node.next;
        }
        node.next = null;
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}