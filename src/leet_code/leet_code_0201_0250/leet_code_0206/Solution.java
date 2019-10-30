package leet_code.leet_code_0201_0250.leet_code_0206;

/**
 * 链表 翻转
 */
class Solution {
    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode node = head;
        ListNode record = null;
        ListNode next;
        while (node != null) {
            next = node.next;
            node.next = record;
            record = node;
            if (next == null) {
                break;
            } else {
                node = next;
            }
        }
        return node;
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}